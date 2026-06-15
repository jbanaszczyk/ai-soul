package styling

import com.kslides.config.PresentationConfig
import kotlinx.css.CssBuilder

// always use together with styling.allowAlignSlidesToTop()
//
//  presentationConfig {
//     styling.allowAlignSlidesToTop()
// }
// css {
//     styling.alignSlidesToTop()
// }

fun PresentationConfig.allowAlignSlidesToTop() {
    minScale = 0.01F
    maxScale = 5.0F
}

fun CssBuilder.alignSlidesToTop() {

    rule(".reveal-viewport") {
        put("--r-overlay-header-height", "0px !important")
        put("--r-overlay-margin", "0px !important")
        put("--r-overlay-padding", "0px !important")
        put("--r-overlay-gap", "0px !important")
    }

    rule(".reveal .slides") {
        put("top", "0 !important")
        put("left", "calc((var(--viewport-width) - (var(--slide-width) * var(--slide-scale))) / 2) !important")
        put("width", "var(--slide-width) !important")
        put("height", "var(--slide-height) !important")
        put("transform-origin", "top left !important")
        put("transform", "scale(var(--slide-scale)) !important")
    }
}
