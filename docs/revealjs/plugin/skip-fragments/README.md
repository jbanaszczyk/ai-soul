# reveal-skip-fragments

A [Reveal.js](https://revealjs.com/) plugin to skip fragment animations on a slide by pressing a shortcut key.

When presenting, you may need to go faster than anticipated and skip to the end of all fragments on the current slide.
This plugin provides shortcuts to show or hide all slide fragments at once.

Original source: https://github.com/PiDayDev/reveal-skip-fragments

## Reveal.js 4.x

This version of the plugin is compatible with Reveal.js 4.x and is implemented as a proper plugin (object with `id` and `init`).

update: https://github.com/jbanaszczyk/kslides

## Installation for kslides

To include this plugin in your kslides presentation, add the following to your `Slides.kt`:

```kotlin
jsFiles += JsFile("plugin/skip-fragments/skip-fragments.js")
customPlugins += "SkipFragments"
```

## Usage

While you are presenting, just press:

Shortcut keys are hardcoded:

- **V** to show (**v**iew) all fragments;
- **C** to hide (**c**onceal) all fragments.

Terms like "show" are used here as synonyms for "activate", meaning the fragment performs its animation 
(which may include disappearing, e.g., for `fade-out` fragments).


## API

### Javascript

The plugin API is accessible from the global `SkipFragments` object.

```javascript
// Programmatically show all fragments on current slide
SkipFragments.showAll();

// Programmatically hide all fragments on current slide
SkipFragments.hideAll();
```
