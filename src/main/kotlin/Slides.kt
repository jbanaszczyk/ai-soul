import com.kslides.Presentation
import com.kslides.kslides
import kotlinx.html.*
import styling.*

fun getGithubRootUrl(): String = "https://github.sec.samsung.net/j-banaszczyk/ai-soul/"

fun getPagesUrl(path: String): String = "https://pages.github.sec.samsung.net/j-banaszczyk/ai-soul/" + path.trimStart('/')

fun main() {
    kslides {
        output {
            defaultOutputConfig()
        }
        css {
            alignSlidesToTop()
            illustrationStyles()
            codeBlockCssHeights()
            vspaceStyles()
            textTagStyles()
            tableStyles()
            rightSideTipStyle()
            progressBarWithEot()
            defaultThemeSettings()
        }

        presentationConfig {
            allowAlignSlidesToTop()
            defaultPresentationConfig()
        }

        presentationMain()
        presentationMain_EN()

        presentationExample()

//        presentationLogics()
    }
}

fun Presentation.thanks() {
    verticalSlides {
        dslSlide {
            classes = "has_tip"
            content {
                h1("r-fit-text") { +"👏 Thank you 🤗" }
                h2("r-fit-text") { +"❤️❤️❤️ 💖💖💖 🌹🌹🌹 💖💖💖 ❤️❤️❤️" }

                hr {}

                unsafe { +illustration("qr-ai-soul.png", alt = "QR: ${getGithubRootUrl()}", size = IllustrationSize.Large) }

                p { span("color_blue block") { +"${charCopyright}'26 Jacek Banaszczyk" } }
                p { span("color_blue block") { +"j.banaszczyk@samsung.com" } }
            }
        }
    }
}
