package styling

import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.display
import kotlinx.html.*
import kotlinx.html.FlowContent

fun vspace(n: Int = 1): String {
    require(n > 0) { "vspace must be positive, was $n" }
    return """<span class="vspace" style="height: ${n}em"></span>"""
}

fun CssBuilder.vspaceStyles() {
    rule(".reveal span.vspace") {
        display = Display.block
    }
}

fun FlowContent.vspace(n: Int = 1) {
    require(n > 0) { "vspace must be positive, was $n" }

    span("vspace") {
        style = "height: ${n}em"
    }
}
