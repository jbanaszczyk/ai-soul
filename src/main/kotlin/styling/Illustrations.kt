package styling

import com.kslides.Effect
import kotlinx.css.*
import kotlinx.html.SECTION
import kotlinx.html.classes
import kotlinx.html.iframe
import kotlinx.html.title
import kotlinx.css.Float as CssFloat

private const val IMAGES_DIR = "images/"

enum class IllustrationSide(val cssClass: String) {
    Right(""),
    Left("left")
}

enum class IllustrationSize(val cssClass: String) {
    Normal(""),
    Small("small"),
    Large("large")
}

fun illustration(
    name: String,
    alt: String = "",
    side: IllustrationSide = IllustrationSide.Right,
    size: IllustrationSize = IllustrationSize.Normal,
    fragmentIndex: Int? = null,
    effect: Effect = Effect.NONE,
): String {
    val cssClasses = listOf(
        "illustration",
        side.cssClass,
        size.cssClass,
    )
        .filter { it.isNotBlank() }
        .joinToString(" ")

    return """<img class="$cssClasses${
        fragmentClass(
            fragmentIndex,
            effect
        )
    }" src="$IMAGES_DIR$name" alt="$alt"${fragmentAttribute(fragmentIndex)}/>"""
}

fun CssBuilder.illustrationStyles() {
    rule(".reveal img.illustration") {
        float = CssFloat.right
        width = 400.px
        marginTop = 0.px
        marginRight = 0.px
        marginBottom = 1.em
        marginLeft = 1.em
    }

    rule(".reveal img.illustration.left") {
        float = CssFloat.left
        marginTop = 0.px
        marginRight = 1.em
        marginBottom = 1.em
        marginLeft = 0.px
    }

    rule(".reveal img.illustration.small") {
        width = 250.px
    }

    rule(".reveal img.illustration.large") {
        width = 525.px
    }

    rule(""".reveal img[alt^="Samsung_"]""") {
        width = 400.px
        marginTop = 0.px
        marginRight = 0.px
        marginBottom = 0.px
        marginLeft = 0.px
    }

    rule(".reveal iframe.illustration") {
//        width = 640.px
//        height = 360.px

        width = 480.px
        height = 270.px

//        width = 400.px
//        height = 225.px
        float = CssFloat.right
        marginTop = 0.px
        marginRight = 0.px
        marginBottom = 1.em
        marginLeft = 1.em
        border = Border.none
    }

    rule(".reveal iframe.illustration.left") {
        float = CssFloat.left
        marginTop = 0.px
        marginRight = 1.em
        marginBottom = 1.em
        marginLeft = 0.px
    }
}

private val youtubeVideoIdPattern = Regex("^[A-Za-z0-9_-]{11}$")

enum class YtCaptions(val code: String) {
    PL("pl"),
    EN("en")
}

fun SECTION.yt(
    videoId: String,
    title: String,
    start: Int? = null,
    stop: Int? = null,
    autoplay: Boolean = false,
    captions: YtCaptions? = null
) {
    require(videoId.matches(youtubeVideoIdPattern))
    require(start == null || start >= 0)
    require(stop == null || stop > 0)
    require(start == null || stop == null || stop > start)

    val parameters = buildList {
        start?.let { add("start=$it") }
        stop?.let { add("end=$it") }
        add("mute=1")
        add("controls=0")
        add("fs=0")
        if (autoplay) {
            add("autoplay=1")
        }
        if (captions == null) {
            add("cc_load_policy=0")
        } else {
            add("cc_load_policy=1")
            add("cc_lang_pref=${captions.code}")
        }
    }.joinToString("&")

    iframe {
        classes = setOf("illustration")
        src = "https://www.youtube.com/embed/$videoId?$parameters"
        this.title = title
        attributes["allow"] = "autoplay; encrypted-media; fullscreen 'none'; picture-in-picture 'none'"
    }
}
