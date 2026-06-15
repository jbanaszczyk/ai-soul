# reveal-elapsed-time-bar

A [Reveal.js](https://revealjs.com/) plugin adding a progress bar of elapsed time to keep track of time during presentations.

Original source: https://github.com/tkrkt/reveal.js-elapsed-time-bar

## Reveal.js 4.x

This version of the plugin is compatible with Reveal.js 4.x and is implemented as a proper plugin (object with `id` and `init`).

update: https://github.com/jbanaszczyk/kslides

## Installation for kslides

To include this plugin in your kslides presentation, add the following to your `Slides.kt`:

```kotlin
jsFiles += JsFile("plugin/elapsed-time-bar/elapsed-time-bar.js")
customPlugins += "ElapsedTimeBar"
customConfig += "elapsedTimeBar: { allowedTime: 25 }"
```

## Configurations

The plugin can be configured via the `elapsedTimeBar` object in `Reveal.initialize`.

```js
Reveal.initialize({
    // ...

    elapsedTimeBar: {
        // - (required) your allowed time for presentation in minutes
        allowedTime: 25,

        // - (optional) height of page/time progress bar in pixels
        progressBarHeight: 3,

        // - (optional) bar color
        barColor: 'rgb(255,0,0)',

        // - (optional) bar color when timer is paused
        pausedBarColor: 'rgba(0,255,0,.6)',
    }
});
```

## API

You can use APIs from global `ElapsedTimeBar` object.

| Property                              | Description                                       |
|---------------------------------------|---------------------------------------------------|
| `isPaused`                            | `true` if timer is paused                         |
| `isFinished`                          | `true` when you run out of your allowed time      |
| `start(allowedTime [,elapsedTime=0])` | Start timer with new allowed time (in ms)         |
| `reset()`                             | Reset timer proportional to presentation progress |
| `pause()`                             | Pause timer                                       |
| `resume()`                            | Resume timer                                      |

## Keyboard binding

The plugin automatically registers the following keyboard shortcuts:

- **T**: Toggle pause/resume timer.
- **R**: Reset timer (sets elapsed time proportional to current presentation progress).
