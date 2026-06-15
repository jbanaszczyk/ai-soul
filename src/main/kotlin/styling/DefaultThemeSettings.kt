package styling

import kotlinx.css.*
import kotlinx.css.properties.BoxShadows

fun CssBuilder.defaultThemeSettings() {
    // CSS values assigned here are applied to all the presentations
    // :root - white.css is not available for modification, so we need to use custom css instead
    rule(":root") {
        put("--r-main-font", "SamsungSSBody, Helvetica, sans-serif")
        put("--r-heading-font", "SamsungSSHead, Helvetica, sans-serif")
        put("--r-code-font", "CommitMono, monospace")

        put("--r-background-color", "#fff")

        put("--r-main-font-size", "42px")
        put("--r-main-color", "#000")
        put("--r-heading-color", "#000")

        put("--r-block-margin", "15px")
        put("--r-heading-margin", "0 0 20px 0")

        put("--r-heading-line-height", "1.2")
        put("--r-heading-letter-spacing", "normal")
        put("--r-heading-text-transform", "uppercase")
        put("--r-heading-text-shadow", "none")
        put("--r-heading-font-weight", "700")
        put("--r-heading1-text-shadow", "none")

        put("--r-heading1-size", "2.0em")
        put("--r-heading2-size", "1.6em")
        put("--r-heading3-size", "1.3em")
        put("--r-heading4-size", "1.1em")

        put("--r-link-color-dark", "#0083E3")
        put("--r-link-color-hover", "#0077C8")
        put("--r-link-color", "#1428A0")

        put("--r-selection-background-color", "#8093DC")
        put("--r-selection-color", "#000")
        put("--r-overlay-element-bg-color", "0, 0, 0")
        put("--r-overlay-element-fg-color", "240, 240, 240")
    }

    rule(".reveal h1") {
        color = OurColor.Default.code
    }
    rule(".reveal h2") {
        color = OurColor.Blue.code
        paddingTop = 0.1.em
    }

    rule(".reveal blockquote") {
        textAlign = TextAlign.left
        borderLeft = Border(4.px, BorderStyle.solid, OurColor.Blue.code)
        boxShadow = BoxShadows.none
        paddingLeft = 1.em
        fontSize = 1.em
        put("width", "auto")
        put("display", "flow-root")
        put("margin", "var(--r-block-margin) 0 var(--r-block-margin) 15%")
    }
    rule(".reveal blockquote p") {
        marginTop = 0.px
        marginBottom = 0.px
    }
}
