import com.kslides.Effect
import com.kslides.KSlides
import com.kslides.fragment
import com.kslides.playground
import kotlinx.html.*
import styling.*

fun KSlides.presentationLogics() {
    presentation {
        presentationConfig {
            title = "Logiki wielowartościowe"
        }

        path = "logics.html"
        val pagesUrl = getPagesUrl(path)

        addNewPlugins()

        val playgroundFiles = "src/main/kotlin/playground"
        css += """
            .reveal section.truth-table-16 table th,
            .reveal section.truth-table-16 table td {
              text-align: center;
            }

            .reveal section.truth-table-16 table th:nth-child(1),
            .reveal section.truth-table-16 table td:nth-child(1),
            .reveal section.truth-table-16 table th:nth-child(2),
            .reveal section.truth-table-16 table td:nth-child(2) {
              background: #FE5D4D;
            }

            .reveal section.truth-table-16 table th:nth-child(2n + 3),
            .reveal section.truth-table-16 table td:nth-child(2n + 3) {
              background: #D0DAFE;
            }

            .reveal section.truth-table-16 table th:nth-child(2n + 4),
            .reveal section.truth-table-16 table td:nth-child(2n + 4) {
              background: #97D653;
            }

            .reveal section.truth-table-16 table th:nth-child(2),
            .reveal section.truth-table-16 table td:nth-child(2) {
              border-right: 3px double currentColor;
            }

            .reveal section.truth-table-16 table th:nth-last-child(-n + 6),
            .reveal section.truth-table-16 table td:nth-last-child(-n + 6) {
              background: transparent;
            }
            .reveal section.truth-table-16 table tbody td {
                 border-bottom: none;
            }
        """.trimIndent()

        markdownSlide {
            content {
                """
                    # Na rozgrzewkę
                    
                    ## Logika

                    ${vspace()}

                    ### W logikę umiemy: `boolean`

                    - `boolean`
                    - `false`, `true`
                    - `${charAnd}${charAnd}`, `||`, `!`
                    - 𝔹 := ( B, ||, ${charAnd}${charAnd}, !, false, true )
                    - semantyka operatorów ${fragment(Effect.GROW, 1)}

                    ${Mark.BLUE("Semantyka? Yyyy?", 1, Effect.FADE_LEFT)}

                    notes:
                    - to nie jest formalna definicja
                    - formalnie:
                          - rachunek zdań, ...
                """.trimIndent()
            }
        }
        markdownSlide {
            content {
                """
                    # W logikę umiemy: `boolean`

                    - `boolean`
                    - `false`, `true`
                    - `${charAnd}${charAnd}`, `||`, `!`

                    ${Mark.BLUE("Semantyka operatorów? Yyyy?")}

                    ____

                    > Weź to jabłko, **albo** to drugie, ale nie oba

                    > Weź to jabłko **lub** to drugie. A mogę oba?

                    ${Mark.BLUE.block("W języku potocznym to nie razi")}

                    ${Mark.BLUE.block("Potocznie: \"lub\" i \"albo\" to są synonimy (mniej więcej)")}

                    ${Mark.BLUE.block("Użycie lub/albo w innym znaczeniu to nie jest błąd 😕")}

                    ${Mark.BLUE.block("Te same stałe, te same operatory, inna semantyka", 1)}

                    ${Mark.GREEN.block("To jest po prostu inna logika", 1)}
                """.trimIndent()
            }
        }
        markdownSlide {
            classes += "truth-table-16"
            content {
                """
                    # W logikę umiemy: `boolean`

                    - `boolean`
                    - `false`, `true`
                    - `${charAnd}${charAnd}`, `||`, `!`

                    ${Mark.BLUE("Semantyka operatorów? Yyyy?")}

                    ____

                    | `x` | `y` | `${charAnd}` | `\|` | `xor` | `==` | `nand` | `nor` | `->` |     |     |     | `x` | `y` | `!x` | `!y` | `0` | `1` |
                    |-----|-----|--------------|------|-------|------|--------|-------|------|-----|-----|-----|-----|-----|------|------|-----|-----|
                    | `0` | `0` | `0`          | `0`  | `0`   | `1`  | `1`    | `1`   | `1`  | `1` | `0` | `0` | `0` | `0` | `1`  | `1`  | `0` | `1` |
                    | `0` | `1` | `0`          | `1`  | `1`   | `0`  | `1`    | `0`   | `1`  | `0` | `0` | `1` | `0` | `1` | `1`  | `0`  | `0` | `1` |
                    | `1` | `0` | `0`          | `1`  | `1`   | `0`  | `1`    | `0`   | `0`  | `1` | `1` | `0` | `1` | `0` | `0`  | `1`  | `0` | `1` |
                    | `1` | `1` | `1`          | `1`  | `0`   | `1`  | `0`    | `0`   | `1`  | `1` | `0` | `0` | `1` | `1` | `0`  | `0`  | `0` | `1` |

                    - dokładnie 16 operatorów, niezależnie od logiki
                      - inna logika ${charRArrow} inne nagłówki w tabelce
                    - 4 używane: `${charAnd}`, `|`, `xor`, `==`
                    - `nand` (not and), `nor` (not or) - powszechne w elektronice
                    - `->` implikacja (znana ze szkoły, brak operatora)

                    Notes:
                    - dokładnie 16 operatorów.
                      - niezależnie od logiki
                      - operatory:
                        - totalne (zawsze jakiś wynik)
                        - wyniki w tej samej domenie, co argumenty (`0` i `1`)
                        - deterministyczne (dla danego wejścia zawsze ten sam wynik)
                    - Ta tabelka (same nagłówki) są dla boolean
                      - dla innej logiki będą inne nagłówki
                    - Dygresja: `${charAnd}` vs. `${charAnd}${charAnd}`
                        - bool algebraiczny vs. runtime
                        - podejście deklaratywne vs. imperatywne
                        - operatory `${charAnd}${charAnd}` i `||` nie są pure
                          - short circuit: `x and y`
                          - pure version: `x.evaluate; y.evaluate; x and y`
                        - tabela prawdy jest taka sama, **ale${charHellip}**
                        - czepiam się 🙃
                """.trimIndent()
            }
        }

        dslSlide {
            classes += "truth-table-16"
            content {
                h1 { +"Wymyślmy nowy operator" }

                h2("fragment fade-in") { +"Na przykład: dzielenie" }

                table("fragment fade-in") {
                    thead {
                        tr { th { code { +"x" } }; th { code { +"y" } }; th { code { +"x/y" } } }
                    }
                    tbody {
                        tr("fragment fade-in") { td { code { +"0" } }; td { code { +"0" } }; td {} }
                        tr { td { code { +"0" } }; td { code { +"1" } }; td { code { +"0" } } }
                        tr("fragment fade-in") { td { code { +"1" } }; td { code { +"0" } }; td {} }
                        tr { td { code { +"1" } }; td { code { +"1" } }; td { code { +"1" } } }
                    }
                }
            }
        }

        dslSlide {
            classes += "has_tip"
            content {
                blockQuote { +"Spoiler: `NaN`, `Infinity`" }
                h1 { +"Wymyślmy nowy operator" }
                h2 { +"Na przykład: dzielenie" }
                ul {
                    li { +"Jak się nie da podzielić, jak się da?" }
                    li { +"Nie lubimy pustych miejsc" }
                    li { +"Lubimy systemy bez dziur" }
                    li {
                        +"Lubimy operatory "; strong { +"totalne" }; +":"
                        ul { li { +"dla każdego inputu ma być jakiś output" } }
                    }
                }
                playground("$playgroundFiles/Floats.kt") { }
            }
        }

        markdownSlide {
            classes += "truth-table-16"
            content {
                """
                    # Wymyślmy nowy operator

                    ## Na przykład: dzielenie

                    | `x` | `y` | `x/y` |
                    |-----|-----|-------|
                    | 0   | 0   | ?     |
                    | 0   | 1   | 0     |
                    | 1   | 0   | ?     |
                    | 1   | 1   | 1     |

                    ____

                    - W naszej logice pojawiła się trzecia wartość
                    - Można by to nazwać `NotAValue`, `NaV` albo `yyyy`

                    ${Mark.RED("To już nie jest boolean", 0)}
                """.trimIndent()
            }
        }
        markdownSlide {
            classes += "truth-table-16"
            content {
                """
                    # Nowa wartość?

                    ${Mark.BLUE("Różne semantyki -> różne logiki")}

                    ## To może `${charAnd}${charAnd}` koniunkcja  z `yyyy`

                    | x | y | unknown | refusal | infer |
                    |---|---|---------|---------|-------|
                    | 0 | ? | 0       | ?       | 0     |
                    | 1 | ? | ?       | ?       | 1     |
                    | ? | 0 | 0       | ?       | 0     |
                    | ? | 1 | ?       | ?       | 1     |
                    | ? | ? | ?       | ?       | ?     |

                    - unknown
                      -  C++ `boost.tribool`, Kleene (ten od `*` w regexach), SQL (`UNKNOWN`)
                    - refusal
                      - Bochvar, logika z silną negacją: tak, nie, ${charHellip}
                    - infer (domyśl się)
                      - memiczne: "O co chodzi? Domyśl się."
                    Notes:
                    - logika Łukasiewicza L3 ma słabą koniunkcję `∧` i mocną koniunkcję `⊗` 
                      - `? ⊗ ? = 0`
                """.trimIndent()
            }
        }
        markdownSlide {
            classes += "truth-table-16"
            content {
                """
                    # Ostatni slajd nie na temat
                    
                    ## Fizyka

                    ```plaintext
                        Czy Kot Schrödingera żyje? Tak, Nie, Yyyy
                    ```

                    ## C++ `boost.tribool`

                    ```cpp
                        if (x) ${charHellip}
                        else if (!x) ${charHellip}
                        else ${charHellip}
                    ```

                    ## SQL

                    Co się dzieje dla `id = 3` i dlaczemu?

                    ```sql
                        where id not in (1, 2, null)
                    ```

                    ## Java i inne

                    Używamy logiki trójwartościowej nadspodziewanie często.

                    ```java
                        if (x == null) ${charHellip}
                        else if (x) ${charHellip}
                        else ${charHellip}
                    ```

                    Notes:
                    - `id NOT IN (1, 2, NULL)`
                    - `id ${charLt}${charGt} 1 AND id ${charLt}${charGt} 2 AND id ${charLt}${charGt} NULL`
                    - `3 ${charLt}${charGt} 1 AND 3 ${charLt}${charGt} 2 AND 3 ${charLt}${charGt} NULL`
                    - `FALSE AND TRUE AND UNKNOWN`
                    - -> `UNKNOWN`
                    - dla `id = 3` warunek nie przechodzi
                """.trimIndent()
            }
        }
    }
}
