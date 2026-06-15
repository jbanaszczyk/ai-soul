import com.kslides.Effect
import com.kslides.KSlides
import kotlinx.html.*
import styling.*

fun KSlides.presentationExample() {
    presentation {
        presentationConfig {
            title = "Custom Kslides"
        }
        path = "kslides.html"
        val pagesUrl = getPagesUrl(path)
        val githubRootUrl = getGithubRootUrl()

        addNewPlugins()

        css += """
            .reveal .no_stylistic_set code {
            font-feature-settings: "ss01" 0, "ss02" 0, "ss03" 0, "ss04" 0, "ss05" 0;
        }
            .has_tip.tip_at_line_17 > blockquote:nth-child(1) {
                bottom: auto;
                top: 17em;
        }
        """.trimIndent()

        verticalSlides {
            markdownSlide {
                classes = "has_tip"
                content {
                    """
                    > Navigation
                    > * space key
                    > * explicit movement: cursors, ...
                    > * speaker notes: `S`
                    > * presentation map: `Esc`
                    > * more: `?`
    
                    # kslides template
    
                    > ${charCopyright} j.banaszczyk@samsung.com${charBR}
                    > feel free to reuse
    
                    ## This presentation
    
                    - live: ${pagesUrl}
                    - repository to clone: ${githubRootUrl}
    
                    ## kslides
    
                    - kslides framework: https://github.com/kslides/kslides
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Other examples
    
                    - (this one) https://pages.github.sec.samsung.net/j-banaszczyk/ai-soul/kslides.html
                    - https://pages.github.sec.samsung.net/j-banaszczyk/ai-soul/
                    - https://pages.github.sec.samsung.net/j-banaszczyk/rex/
                    - https://pages.github.sec.samsung.net/j-banaszczyk/rex2/
                    - (obsolete) https://pages.github.sec.samsung.net/j-banaszczyk/code_i_workshop/
                    - https://pages.github.sec.samsung.net/j-banaszczyk/code_i_prompts/
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Reuse
    
                    - Update `kslides-core`
                        - clone https://github.com/jbanaszczyk/kslides
                        - review https://github.com/jbanaszczyk/kslides/blob/master/RELEASE_NOTES.md
                        - `gradlew publishToMavenLocal`
                    - build and publish content 
                        - copy / clone / fork this repo
                        - open in IntelliJ
                        - edit `src/main/kotlin/Slides.kt`
                        - run as IntelliJ/kotlin configuration
                        - commit / push
                        - publish from `/docs` using GitHub Pages
                        - read main `README.md` file
                    - Local preview
                        - http://127.0.0.1:8080
                    """.trimIndent()
                }
            }
        }
        verticalSlides {
            markdownSlide {
                content {
                    """
                    # Template features
    
                    - reveal.js / kslides framework
                    - Samsung typography and color palette
                    - CommitMono font for code blocks
                    - top-aligned slide layout
                    - text helpers / block text helpers
                    - minor configuration tuning
                    - code block height presets
                    - illustrations (images styling)
                    - vertical spacing helper
                    - special character constants
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Project files
    
                    - Most content goes to:
                      - `src/main/kotlin/Slides.kt`
                    - Generated/published content:
                      - `docs/`
                    - Static assets:
                        - `src/main/resources/public/`
                        - ${Mark.RED("Important: store images in both:")}
                          - `docs/images`
                          - `src/main/resources/public/images`
                    """.trimIndent()
                }
            }
        }
        verticalSlides {
            markdownSlide {
                content {
                    """
                    # Typography
    
                    ## Fonts
    
                    - main font: SamsungSS
                    - code font: `CommitMono`
                    - ligatures and kerning are disabled globally
                      - required by Samsung Brand Playbook
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Typography
                    ## Headers
                    ___
                    # Heading h1
                    ## Heading h2
                    ### Heading h3
                    #### Heading h4
                    """.trimIndent()
                }
            }

            markdownSlide {
                fun colorTags(colorStatus: ColorStatus): String =
                    OurColor.entries
                        .filter { it.status == colorStatus }
                        .joinToString(" ") { color ->
                            val colorName = color.getColorTag()
                            """<span class="$colorName">$colorName</span>"""
                        }

                fun allColorTags(): String =
                    buildString {
                        append("| Group | Color classes |\n")
                        append("|---|---|\n")
                        ColorStatus.entries.forEach { status ->
                            append("| ")
                            append(status.colorStatusName)
                            append(" | ")
                            append(colorTags(status))
                            append(" |\n")
                        }
                    }

                content {
                    """
                    # Typography
    
                    ## Samsung brand colors
    
                    ${vspace()}
    
                    ${allColorTags()}
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Typography
    
                    ## Text marks
                    
                    Produces `<span></span>` tag
                    
                    ${vspace()}
    
                    | Function                       |                                    Result |
                    |--------------------------------|-------------------------------------------|
                    | `Mark.PROMPT("Some content")`  | ${Mark.PROMPT("Some content")}  |
                    | `Mark.ANSWER("Some content")`  | ${Mark.ANSWER("Some content")}  |
                    | `Mark.TIP("Some content")`     | ${Mark.TIP("Some content")}     |
                    | `Mark.DIY("Some content")`     | ${Mark.DIY("Some content")}     |
                    | `Mark.COMMENT("Some content")` | ${Mark.COMMENT("Some content")} |
                    | `Mark.RED("Red")`              | ${Mark.RED("Red")}              |
                    | `Mark.GREEN("Green")`          | ${Mark.GREEN("Green")}          |
                    | `Mark.BLUE("Blue")`            | ${Mark.BLUE("Blue")}            |
                    | `Mark.BLACK("Black")`          | ${Mark.BLACK("Black")}          |
    
                    🙃 ${Mark.RED("Blue")} ${Mark.GREEN("Red")} ${Mark.BLUE("Green")} 🙃

                    ---
                    
                    # Typography
    
                    ## Text marks

                    Marks support fragments and effects:

                    | Usage                                          | Result |
                    |------------------------------------------------|--------|
                    | `Mark.BLUE("text", 0)`                         | ${Mark.BLUE("text", 0)} |
                    | `Mark.RED("text", 0, Effect.STRIKE)`           | ${Mark.RED("text", 0, Effect.STRIKE)} |
                    | `Mark.GREEN("text", 0, Effect.FADE_UP)`        | ${Mark.GREEN("text", 0, Effect.FADE_UP)} |
    
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Typography
    
                    ## Block Text marks
    
                    `Mark.YYYYY.block` - produces `<div></div>` tag
    
                    ${vspace()}
    
                    ${Mark.PROMPT.block("This is a prompt block.")}
    
                    ${Mark.ANSWER.block("This is an answer block.")}
    
                    ${Mark.TIP.block("This is a tip block.")}
    
                    ${Mark.DIY.block("This is a DIY block.")}
    
                    ${Mark.COMMENT.block("This is a comment block.")}
                    
                    ___
                    
                    ${Mark.BLACK.block("Mark.BLACK.block works too")}

                    ${Mark.BLUE.block("Mark.YYYY and Mark.YYYY.block supports fragments", fragmentIndex = 1)}
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Typography

                    ## Block marks: indent

                    `Mark.YYYY.block("text", indent = N)` - indent level 0..2

                    ${vspace()}

                    ${Mark.BLUE.block("indent = null (default)")}

                    ${Mark.BLUE.block("indent = 1", indent = 1)}

                    ${Mark.BLUE.block("indent = 2", indent = 2)}

                    ${vspace()}

                    ## Nested marks inside block

                    ${Mark.BLACK.block("Outer block with ${Mark.BLUE("inner inline mark", 0)} inside")}
                    """.trimIndent()
                }
            }
        }
        verticalSlides {
            val codeBlockCssHeightsConfig = CodeBlockCssHeightsConfig()
            dslSlide {
                classes = "table_no_hlines"
                val codeSample1 = "<= === !="
                val codeSample2 = ">-> =>"
                val codeSample3 = "2+3-4"
                val codeSample4 = "... <<"
                val codeSample5 = "Commit Mono kerning: moi"

                content {
                    h1 { +"Code blocks" }
                    ul {
                        li { +"Using CommitMono font" }
                        li { +"Stylistic sets ss01..ss05 (ligatures, arrows and so) turned on" }
                    }
                    hr { }
                    table {
                        tr {
                            th { +"Ligatures" }
                            th { +"Arrows" }
                            th { +"Smart case" }
                            th { +"Symbol spacing" }
                            th { +"Smart kerning" }
                        }
                        tr {
                            th { +"ss01" }
                            th { +"ss02" }
                            th { +"ss03" }
                            th { +"ss04" }
                            th { +"ss05" }
                        }
                        tr {
                            td { code { +codeSample1 } }
                            td { code { +codeSample2 } }
                            td { code { +codeSample3 } }
                            td { code { +codeSample4 } }
                            td { code { +codeSample5 } }
                        }
                        tr {
                            td("no_stylistic_set") { code { +codeSample1 } }
                            td("no_stylistic_set") { code { +codeSample2 } }
                            td("no_stylistic_set") { code { +codeSample3 } }
                            td("no_stylistic_set") { code { +codeSample4 } }
                            td("no_stylistic_set") { code { +codeSample5 } }
                        }
                    }
                }
            }

            markdownSlide {
                content {
                    """
                    # Code blocks
    
                    Two code blocks on page, ${codeBlockCssHeightsConfig.defaultSpecificLineCount} lines each.
    
                    ```plaintext
                    Default code block height: ${codeBlockCssHeightsConfig.defaultSpecificLineCount} lines
    
                    &gt;= === !=
                    &gt;-&gt; =&gt;
                    2+3-4
                    ... &gt;&gt; &lt;&lt;
                    Commit Mono kerning: moi
    
                    ${sampleCodeLines(10, 30, "code block")}
                    ```
    
                    ```plaintext
                    ${sampleCodeLines(1, codeBlockCssHeightsConfig.defaultSpecificLineCount, "code block")}
                    ```
                    """.trimIndent()
                }
            }

            markdownSlide {
                classes = "code20lines"
                content {
                    """
                    # Code blocks
    
                    This slide uses class:
    
                    ```kotlin
                    classes = "${classes} "
                    ```
    
                    Predefined heights:
    
                    `${codeBlockCssHeightsConfig.codeBlockPredefinedHeights.joinToString(", ")}`
    
                    ```plaintext
                    ${sampleCodeLines(1, 20, "another code block")}
                    ```
                    """.trimIndent()
                }
            }
        }
        verticalSlides {
            dslSlide {
                content {
                    h1 { +"YouTube embed: yt()" }
                    yt("JMJXvsCLu6s", "Wildebeest ${charCopyright} Birdbox Studio", start = 17, stop = 50, autoplay = true)
                    p { +"Basic usage: yt(videoId, title)" }
                    p { +"With options: yt(videoId, title, start = 10, stop = 60, autoplay = true, captions = YtCaptions.EN)" }
                }
            }

            markdownSlide {
                classes = "has_tip"
                content {
                    """
                    > * first blockquote
                    > * before the heading
                    > * slide class: `has_tip`

                    # Side note
    
                    A slide can use the first blockquote as a right-side note.
                    * first blockquote
                    * before the heading
                    * slide class: `has_tip`
                    * uses `absolute` positioning
                      * no html override protection :(
                    * The rendered note is visible on the right side of this slide.
                    """.trimIndent()
                }
            }

            dslSlide {
                classes = "has_tip tip_at_line_17"
                content {
                    blockQuote {
                        p { +"Tip positioned lower" }
                        p { +"using CSS override" }
                    }
                    h1 { +"Side note: custom position" }
                    p { +"Override tip vertical position with extra CSS class and custom rule:" }
                    pre {
                        code {
                            +"""
                            css += ""\"
                                .has_tip.tip_at_line_17 > blockquote:nth-child(1) {
                                  bottom: auto;
                                  top: 17em;
                                }
                            ""\"
                            """.trimIndent()
                        }
                    }
                    p { +"Then use: classes = \"has_tip tip_at_line_17\"" }
                }
            }

            markdownSlide {
                content {
                    """
                    # Vertical spacing
    
                    `vspace()` helper adds vertical spacing.
    
                    ___
                    `vspace()`
    
                    ${vspace()}
                    ___
    
                    `vspace(3)`
    
                    ${vspace(3)}
                    ___
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Special characters
    
                    | Constant                           | Result                                            |
                    |------------------------------------|---------------------------------------------------|
                    | `charHellip`                       | ${charHellip}                                     |
                    | `charLt`, `charGt`                 | ${charLt} ${charGt}                               |
                    | `charEnDash`                       | ${charEnDash}                                     |
                    | `charEmDash`                       | ${charEmDash}                                     |
                    | `charLQuotation`, `charRQuotation` | ${charLQuotation} ${charRQuotation}               |
                    | `charCopyright`                    | ${charCopyright}                                  |
                    | `charLArrow`, `charRArrow`         | ${charLArrow} ${charRArrow}                       |
                    | `charLongLArrow`, `charLongRArrow` | ${charLongLArrow} ${charLongRArrow}               |
                    | `charBR`                           | two trailing spaces used for Markdown line breaks |
                    | emoticons: 👏 🤗 ❤️               | just use                                          |
                    """.trimIndent()
                }
            }
        }
        verticalSlides {
            markdownSlide {
                content {
                    """
                    # Illustrations helper
    
                    ```kotlin
                    illustration("diagram.png")
    
                    illustration(
                        name = "diagram.png",
                        alt = "diagram",
                        side = IllustrationSide.Left,
                        size = IllustrationSize.Large,
                        fragmentIndex = 1
                        effect = Effect.FADE_LEFT
                    )
                    ```
    
                    - Supperts fragments
                    - Sizes
                      - normal: 400px
                      - small: 250px
                      - large: 500px
                    - Sides
                      - right
                      - left
    
                    ---
                    
                    # QR images
    
                    Images with `alt` starting with `qr` are styled as right-floating QR images.
    
                    ```markdown
                    ![qr-example](images/qr/example.png)
                    ```
                    """.trimIndent()
                }
            }

            markdownSlide {
                content {
                    """
                    # Samsung lettermark
    
                    ## Remember the rules for using lettermark
    
                    - Samsung lettermarks are available in three colors
                    - image files are located in `images/lettermark/`
                    - filenames: `Samsung_(BLUE|BLACK|WHITE).png`
    
                    | Variant | Image                                                                                                          |
                    |:-------:|:--------------------------------------------------------------------------------------------------------------:|
                    | blue    | ![Samsung_BLUE_png](images/lettermark/Samsung_BLUE.png)                                                        |
                    | black   | ![Samsung_BLACK_png](images/lettermark/Samsung_BLACK.png)                                                      |
                    | white   | <img alt="Samsung_WHITE_png" src="images/lettermark/Samsung_WHITE.png" style="background:#ccc; padding:0px" /> |
                    """.trimIndent()
                }
            }
        }
        verticalSlides {
            markdownSlide {
                classes = "table_no_hlines"
                content {
                    """
                    # Tables
                    
                    ___
                    
                    ## Formatting
                    
                    Table cells are vertically centered.
    
                    ___
    
                    ## Hide horizontal lines
                    
                    Use slide class `classes = "table_no_hlines"` to hide horizontal lines.
    
                    | Name   | Value |
                    |--------|-------|
                    | first  | 1     |
                    | second | 2     |
                    | third  | 3     |
                    """.trimIndent()
                }
            }

            dslSlide {
                content {
                    h1 { +"Two-column layout" }
                    p { +"Use classes `multiColumn2` on container and `column2` on each column:" }
                    div("multiColumn2") {
                        div("column2") {
                            ul {
                                li { +"Left column" }
                                li { +"item A" }
                                li { +"item B" }
                                li { +"item C" }
                            }
                        }
                        div("column2") {
                            ul {
                                li { +"Right column" }
                                li { +"item X" }
                                li { +"item Y" }
                                li { +"item Z" }
                            }
                        }
                    }
                }
            }
        }
        thanks()
    }
}

private fun sampleCodeLines(
    first: Int,
    last: Int,
    text: String,
): String =
    (first..last).joinToString("\n") { index -> "$index: $text" }
