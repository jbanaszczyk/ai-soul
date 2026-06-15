package styling

import kotlinx.css.CssBuilder
import kotlinx.css.maxHeight
import kotlinx.css.px
import kotlin.math.ceil

private const val CODE_BLOCK_LINE_HEIGHT = 28.1f

fun CssBuilder.codeBlockCssHeights(
    config: CodeBlockCssHeightsConfig = CodeBlockCssHeightsConfig()
) {
    config.codeBlockPredefinedHeights.forEach { lines ->
        rule(".reveal .code${lines}lines pre code") {
            maxHeight = codeBlockHeight(lines)
        }
    }

    rule(".reveal pre code") {
        maxHeight = codeBlockHeight(config.defaultSpecificLineCount)
    }
}

private fun codeBlockHeight(lines: Int) =
    ceil(lines * CODE_BLOCK_LINE_HEIGHT).px

data class CodeBlockCssHeightsConfig(
    val defaultSpecificLineCount: Int = 13,
    val codeBlockPredefinedHeights: List<Int> = listOf(5, 10, 13, 15, 20, 25, 30, 35)
)
