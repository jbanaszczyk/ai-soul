package styling

import com.kslides.*
import com.kslides.config.OutputConfig
import com.kslides.config.PresentationConfig
import kotlinx.css.fontSize
import kotlinx.css.properties.LineHeight
import kotlinx.css.px

fun OutputConfig.defaultOutputConfig() {
    enableFileSystem = true
    enableHttp = true
    httpServeFromOutputDir = true
}

fun Presentation.addNewPlugins() {
    jsFiles += JsFile("plugin/onetimer/onetimer.js")
    customPlugins += "OneTimer"
    customConfig += "oneTimer: { immediateMode: false }"

    jsFiles += JsFile("plugin/mouse-pointer/mouse-pointer.js")
    customPlugins += "MousePointer"

    jsFiles += JsFile("plugin/elapsed-time-bar/elapsed-time-bar.js")
    customPlugins += "ElapsedTimeBar"
    customConfig += "elapsedTimeBar: { allowedTime: 20 }"

    jsFiles += JsFile("plugin/skip-fragments/skip-fragments.js")
    customPlugins += "SkipFragments"
}

fun PresentationConfig.defaultPresentationConfig() {
    // TODO Adjust this
    // title - your own
    // width - it is a width of FullHD screen
    // height - in my case: FullHD screen, __Firefox__ in normal view (not full screen), bookmarks tab visibility - off -> height of Firefox view window

    width = 1920
    height = 1080

    theme = PresentationTheme.WHITE
    slideNumber = "c/t"

    enableSpeakerNotes = true
    enableMenu = true
    progress = true
    mouseWheel = false

    center = false
    margin = 0.01F

    history = true

    transition = Transition.FADE
    transitionSpeed = Speed.FAST

    highlight = Highlight.GITHUB

    menuConfig {
        numbers = true
    }

    copyCodeConfig {
        timeout = 3000
        copy = "Copy"
        copied = "Copied!"
        copybg = "#FFB546"
        copiedbg = "#FFB546"
    }

    slideConfig {
    }

    enableMathKatex = true

    playgroundConfig {
        theme = PlaygroundTheme.IDEA
        lines = true
        style = "border:none;"
        width = "100%"
        height = "350px"

        css {
            rule(".CodeMirror pre") {
                LineHeight("30px")
            }

            rule(".CodeMirror") {
                fontSize = 25.px
            }

            rule(".code-output") {
                fontSize = 25.px
                LineHeight("30px")
            }
        }
    }
}
