# reveal-mouse-pointer

A [Reveal.js](https://revealjs.com/) plugin to show a mouse pointer (red circle) when presenting.

Original source: https://github.com/caiofcm/plugin-revealjs-mouse-pointer

## Reveal.js 4.x

This version of the plugin is compatible with Reveal.js 4.x and is implemented as a proper plugin (object with `id` and `init`).

update: https://github.com/jbanaszczyk/kslides

## Installation for kslides

To include this plugin in your kslides presentation, add the following to your `Slides.kt`:

```kotlin
jsFiles += JsFile("plugin/mouse-pointer/mouse-pointer.js")
customPlugins += "MousePointer"
```

## Usage

Press **Z** to toggle the mouse pointer.

The pointer follows your mouse movement and automatically hides the system cursor when enabled.
