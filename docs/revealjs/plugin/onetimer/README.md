# reveal-onetimer

A [Reveal.js](https://revealjs.com/) plugin to animate fragments only once, so that
going to a previous slide shows final fragment state(s),
rather than tediously stepping through fragments backwards and forwards again.

No one wants to see the same trick twice.

Original source: https://github.com/tpoindex/reveal-onetimer

## Reveal.js 4.x

This version of the plugin is compatible with Reveal.js 4.x and is implemented as a proper plugin (object with `id` and `init`).

update: https://github.com/jbanaszczyk/kslides

## Installation for kslides

To include this plugin in your kslides presentation, add the following to your `Slides.kt`:

```kotlin
jsFiles += JsFile("plugin/onetimer/onetimer.js")
customPlugins += "OneTimer"
customConfig += "oneTimer: { immediateMode: false }"
```

## Usage

OneTimer operates in two modes:

- **Slide mode** (default): Removes the `fragment` class from all fragments on a slide when you move to a new slide. Navigating back to a previously visited slide shows all fragments in their final state.
- **Immediate mode**: Removes the `fragment` class immediately when a fragment is shown. Navigating backwards within a slide skips fragment steps and goes straight to the previous slide.

## Quirks

Reveal.js 4.x allows many added effects for fragments (i.e., 'grow', 'shrink', 
'strike', 'highlight-red', etc.), which are bound to the
"fragment" class.  Once OneTimer removes the "fragment" class, the added 
effects are re-enabled by OneTimer.  Additional handling is needed for 'two-step'
fragment classes.  Fragments with these extras must defer fragment cleanup until
the next fragment cycle or slide.
