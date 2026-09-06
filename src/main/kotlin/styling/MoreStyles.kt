package styling

import kotlinx.css.*

fun CssBuilder.rightSideTipStyle() {
    rule(".has_tip > blockquote:nth-child(1)") {
        fontSize = 0.6.em
        color = Color("#666")

        borderLeftWidth = 4.px
        borderLeftStyle = BorderStyle.solid
        borderLeftColor = Color("#1b91dd")

        paddingLeft = 10.px

        marginTop = 0.px
        marginRight = 0.px
        marginBottom = 0.px
        marginLeft = 0.px

        width = 20.pct
        textAlign = TextAlign.left

        position = Position.absolute
        right = 0.px
        bottom = LinearDimension.auto
        zIndex = 10

        top = 3.em
    }
}

fun CssBuilder.progressBarWithEot() {
    rule(".reveal:has(.slides section.present.end_of_thread) .progress:not(.elapsed-time-progress)") {
        height = 12.px
        color = Color("#FE5D4D")
    }
}
