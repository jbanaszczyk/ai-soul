package styling

import kotlinx.css.Border
import kotlinx.css.BorderCollapse
import kotlinx.css.Clear
import kotlinx.css.CssBuilder
import kotlinx.css.Display
import kotlinx.css.Float
import kotlinx.css.LinearDimension
import kotlinx.css.QuotedString
import kotlinx.css.VerticalAlign
import kotlinx.css.border
import kotlinx.css.borderCollapse
import kotlinx.css.clear
import kotlinx.css.content
import kotlinx.css.display
import kotlinx.css.float
import kotlinx.css.marginBottom
import kotlinx.css.verticalAlign
import kotlinx.css.width

fun CssBuilder.tableStyles() {
    rule(".reveal .table_no_hlines td, .reveal .table_no_hlines th") {
        borderCollapse = BorderCollapse.collapse
        border = Border.none
    }

    rule(".reveal table td, .reveal table th") {
        verticalAlign = VerticalAlign.middle
    }

    rule(".multiColumn2::after") {
        content = QuotedString("")
        display = Display.table
        clear = Clear.both
    }

    rule(".column2") {
        float = Float.left
        width = LinearDimension("50%")
    }

    rule(".column2 li") {
        marginBottom = LinearDimension("10px")
    }
}
