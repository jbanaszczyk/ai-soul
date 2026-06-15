package styling

import com.kslides.Effect
import kotlinx.css.*

private const val CODE_FONT = "var(--r-code-font)"
private const val CODE_FONT_FEATURE_SETTINGS = "\"ss01\" 1, \"ss02\" 1, \"ss03\" 1, \"ss04\" 1, \"ss05\" 1"

enum class ColorStatus(val colorStatusName: String) {
    DEFAULT("Default"),
    RED_GREEN_BLUE("Red Green Blue"),
    PRIMARY("Primary"),
    SECONDARY("Secondary"),
    BW("Black White Gray"),
}

enum class OurColor(val code: Color, val status: ColorStatus) {
    Default(Color("#1428A0"), ColorStatus.DEFAULT), // 0

    Red(Color("#FE5D4D"), ColorStatus.RED_GREEN_BLUE), // 7
    Green(Color("#00C3B2"), ColorStatus.RED_GREEN_BLUE), // 3
    Blue(Color("#0077C8"), ColorStatus.RED_GREEN_BLUE), // 1

    SamsungBlue(Color("#1428A0"), ColorStatus.PRIMARY), // 0
    SamsungWhite(Color("#FFFFFF"), ColorStatus.PRIMARY),
    SamsungBlack(Color("#000000"), ColorStatus.PRIMARY),

    SkyBlue(Color("#0077C8"), ColorStatus.SECONDARY), // 1
    SeaBlue(Color("#00B3E3"), ColorStatus.SECONDARY), // 2
    Teal(Color("#00C3B2"), ColorStatus.SECONDARY), // 3
    Lavender(Color("#8093DC"), ColorStatus.SECONDARY), // 4
    Clover(Color("#97D653"), ColorStatus.SECONDARY), // 5
    Saffron(Color("#FFB546"), ColorStatus.SECONDARY), // 6
    Coral(Color("#FE5D4D"), ColorStatus.SECONDARY), // 7
    Yellow(Color("#FFD400"), ColorStatus.SECONDARY),
    Black(Color("#000000"), ColorStatus.BW),
    White(Color("#FFFFFF"), ColorStatus.BW),
    Gray(Color("#75787B"), ColorStatus.BW);

    fun getColorTag(): String = "color_" + name.lowercase()
}

enum class Mark(val code: String) {
    RED(OurColor.Red.getColorTag()),
    GREEN(OurColor.Green.getColorTag()),
    BLUE(OurColor.Blue.getColorTag()),
    BLACK(OurColor.Black.getColorTag()),

    SAMSUNG_BLUE(OurColor.SamsungBlue.getColorTag()),
    SKY_BLUE(OurColor.SkyBlue.getColorTag()),
    SEABLUE(OurColor.SeaBlue.getColorTag()),
    TEAL(OurColor.Teal.getColorTag()),
    LAVENDER(OurColor.Lavender.getColorTag()),
    CLOVER(OurColor.Clover.getColorTag()),
    SAFFRON(OurColor.Saffron.getColorTag()),
    CORAL(OurColor.Coral.getColorTag()),

    PROMPT("prompt"),
    ANSWER("answer"),
    TIP("tip"),
    DIY("diy"),
    COMMENT("comment");

    override fun toString(): String = code
}

fun CssBuilder.textTagStyles() {
    OurColor.entries.forEach { color ->
        rule("." + color.getColorTag()) {
            this.color = color.code
        }
    }

    rule(".comment") {
        color = OurColor.Blue.code
        fontStyle = FontStyle.italic
    }

    rule(".comment::before") {
        color = OurColor.Blue.code
        fontStyle = FontStyle.italic
        content = QuotedString("// ")
    }

    codeTextStyle(".prompt", OurColor.Blue)
    codeTextPrefix(".prompt::before", OurColor.Blue, "JB: ")

    codeTextStyle(".answer", OurColor.Green)
    codeTextPrefix(".answer::before", OurColor.Green, "AI: ")

    codeTextStyle(".tip", OurColor.Green)
    textPrefix(".tip::before", OurColor.Blue, "Tip: ")

    codeTextStyle(".diy", OurColor.Blue)
    textPrefix(".diy::before", OurColor.Green, "DIY: ")

    rule(".reveal span.block") {
        display = Display.block
        width = 70.pct
        put("margin", "var(--r-block-margin) 0 var(--r-block-margin) 15%")
        textAlign = TextAlign.left
    }

    rule(".reveal span.block.yellow_subtitles") {
        color = OurColor.Yellow.code
        backgroundColor = OurColor.Black.code
        padding = Padding(0.px, 8.px)
        width = 70.pct
        textAlign = TextAlign.center
    }

    rule(".reveal span.block.indent-1") {
        width = 65.pct
        marginLeft = 20.pct
    }

    rule(".reveal span.block.indent-2") {
        width = 60.pct
        marginLeft = 25.pct
    }
}

private fun CssBuilder.codeTextStyle(selector: String, textColor: OurColor) {
    rule(selector) {
        color = textColor.code
        fontFamily = CODE_FONT
        fontFeatureSettings = CODE_FONT_FEATURE_SETTINGS
    }
}

private fun CssBuilder.codeTextPrefix(selector: String, textColor: OurColor, prefix: String) {
    rule(selector) {
        color = textColor.code
        fontFamily = CODE_FONT
        fontFeatureSettings = CODE_FONT_FEATURE_SETTINGS
        fontWeight = FontWeight.bold
        content = QuotedString(prefix)
    }
}

private fun CssBuilder.textPrefix(selector: String, textColor: OurColor, prefix: String) {
    rule(selector) {
        color = textColor.code
        fontWeight = FontWeight.bold
        content = QuotedString(prefix)
    }
}

operator fun Mark.invoke(
    content: String,
    fragmentIndex: Int? = null,
    extraClass: String? = null,
): String =
    spanTag(this, content, fragmentIndex, extraClass = extraClass)


operator fun Mark.invoke(
    content: String,
    fragmentIndex: Int? = null,
    effect: Effect = Effect.NONE,
    extraClass: String? = null,
): String =
    spanTag(this, content, fragmentIndex, effect, extraClass = extraClass)

fun Mark.block(
    content: String,
    fragmentIndex: Int? = null,
    effect: Effect = Effect.NONE,
    indent: Int? = null,
    extraClass: String? = null,
): String =
    blockTag(this, content, fragmentIndex, effect, indent, extraClass)

fun fragmentClass(
    fragmentIndex: Int?,
    effect: Effect = Effect.NONE,
): String =
    if (fragmentIndex == null) {
        ""
    } else {
        " fragment fragment${effectToString(effect)}"
    }

private fun indentClass(indent: Int?): String {
    val value = indent ?: 0
    require(value in 0..2) {
        "Indent must be in range 0..2, but was $value"
    }
    return if (value == 0) "" else " indent-$value"
}

fun effectToString(effect: Effect): String =
    if (effect == Effect.NONE) {
        ""
    } else {
        " " + effect.name.lowercase().replace('_', '-')
    }

fun fragmentAttribute(fragmentIndex: Int?): String =
    fragmentIndex?.let { """ data-fragment-index="$it"""" } ?: ""

private fun spanTag(
    style: Mark,
    content: String,
    fragmentIndex: Int? = null,
    effect: Effect = Effect.NONE,
    extraClass: String? = null,
): String =
    """<span class="$style${fragmentClass(fragmentIndex, effect)}${extraClass?.let { " $it" } ?: ""}"${fragmentAttribute(fragmentIndex)}>$content</span>"""

private fun blockTag(
    style: Mark,
    content: String,
    fragmentIndex: Int? = null,
    effect: Effect = Effect.NONE,
    indent: Int? = null,
    extraClass: String? = null,
): String =
    """<span class="$style block${fragmentClass(fragmentIndex, effect)}${indentClass(indent)}${extraClass?.let { " $it" } ?: ""}"${fragmentAttribute(fragmentIndex)}>$content</span>""" + "\n"
