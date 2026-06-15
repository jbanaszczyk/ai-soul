import com.kslides.Effect
import com.kslides.KSlides
import kotlinx.html.*
import styling.*

fun KSlides.presentationMain() {
    presentation {
        presentationConfig {
            title = "Czy cline ma duszę?"
        }

        val pagesUrl = getPagesUrl(path)
        val githubRootUrl = getGithubRootUrl()

        addNewPlugins()

        css += (1..40).joinToString("\n") { line ->
            """
                .has_tip.tip_at_line_$line > blockquote:nth-child(1) {
                  bottom: auto;
                  top: ${line}em;
                }
            """.trimIndent()
        }

        verticalSlides {
            markdownSlide {
                content {
                    """
                        # Czy cline ma duszę?

                        ## O antropomorfizacji mechanicznych programistów

                        ${vspace()}

                        ${illustration("ai_target.png", alt = "nie można trafić w AI, tam nie ma osobowości", fragmentIndex = 0, effect = Effect.FADE_LEFT)}

                        ${Mark.PROMPT.block("\".clinerules\" To są reguły dla Ciebie")}
                        ${Mark.ANSWER.block("To są reguły dla Ciebie${charHellip}")}
                        ${Mark.PROMPT.block("Jak się nazywasz?")}
                        ${Mark.ANSWER.block("Cline SR")}
                        ${Mark.PROMPT.block("To są reguły dla Cline SR")}
                        ${Mark.ANSWER.block("To są reguły dla Cline SR")}
                        ${Mark.PROMPT.block("Czyli dla Ciebie")}
                        ${Mark.ANSWER.block("Czyli dla Ciebie", 0)}

                        ${vspace()}

                        ____

                        ### ${pagesUrl}

                        Notes:
                        - W sumie to taki trochę spoiler
                        - To był któryś poprzedni model, miał problemy ze skuteczną aplikacją `.clinerules`
                        - Trochę filozoficznie:
                            - nie ma żadnego "bytu", który można zaadresować: "Ty", który można w jakiś sposób "wskazać"
                            - nie da się do niego trafić

                        ---
                        ${illustration("qr-ai-soul.png", alt = "QR: ${githubRootUrl}", size = IllustrationSize.Large)}

                        # Disclaimer

                        - ❤️ Zapraszam na szkolenie "**Clean Code w dobie AI**" ❤️ _(BiT)_
                        - Może się tak zdarzyć, że cały talk zdezaktualizuje się ${Mark.BLUE("pojutrze")}
                        - Wszystkie dialogi z życia wzięte
                        - Z cline rozmawiam po polsku (mix polsko-angielski)
                        - Nawigacja: spacja, `S` ${charRArrow} speaker notes, `?` ${charRArrow} help
                        - Repo: ${githubRootUrl}

                        ${vspace(3)}

                        > ${charCopyright}2026 Jacek Banaszczyk${charBR}
                        > j.banaszczyk@samsung.com

                        ${vspace()}

                        ____

                        ### ${pagesUrl}

                        ____

                        ${vspace()}

                        > Jeśli przeglądasz to samodzielnie - wciśnij `S` (speaker notes)

                        Notes:
                        - grafika: AI
                        - Nie spodziewam się dyskusji po.
                            - Pragmatycznie: to będzie dyskusja o wartościach
                            - To nigdy nie jest dobry pomysł :(

                        ---
                        ${illustration("medal.png", "Logo: Vibes Based Solutions", size = IllustrationSize.Large)}

                        # Disclaimer #2

                        - ❤️ Zapraszam na szkolenie "**Clean Code w dobie AI**" ❤️ _(BiT)_
                        - Tezy, konspekt i treść - 100% handmade
                          - nie chciałem, żeby AI dowiedziało się, co wiem
                          - oczywiście: wyszukiwanie i analiza źródeł: AI + google
                        - Będzie dużo tez na chłopski rozum
                          - 🫣 ${charLArrow} ta ikonka
                          - 🫣 popartych dowodami przez zamachanie rękami
                          - 🫣 i dowodami przez litość
                            - *nie będę Was zamęczać dowodami*
                        - ${Mark.RED("Żeby nie było, że nie ostrzegałem")}

                        Notes:
                        - Justificationes anecdoticae: dowody anegdotyczne
                        - 🫣 - tak sygnalizuję uproszczenia
                        - źródła zweryfikowane
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip"
                content {
                    """
                        > Są logiki, w których${charBR}
                        > odpowiedź \"yyyy?\"${charBR}
                        > jest w pełni legalna

                        # Czy cline ma duszę?

                        ${vspace()}

                        ${Mark.BLUE.block("- Tak: Lorem ipsum dolor sit amet, consectetur adipiscing elit")}
                        ${Mark.BLUE.block("- Nie: Proin fermentum nisl lectus, maximus finibus nisi")}
                        ${Mark.BLACK.block("Wypada odpowiedzieć tak lub nie?")}
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip"
                content {
                    """
                    > Są logiki, w których${charBR}
                    > odpowiedź \"yyyy?\"${charBR}
                    > jest w pełni legalna

                    # Czy cline ma duszę?

                    ${vspace()}

                    ${Mark.BLUE.block("- Tak: Lorem ipsum dolor sit amet, consectetur adipiscing elit")}
                    ${Mark.BLUE.block("- Nie: Proin fermentum nisl lectus, maximus finibus nisi")}
                    ${Mark.BLUE.block("- Yyyy?")}

                    ${vspace()}

                    ${Mark.RED.block("Nikt nam nie będzie mówić: \"co mamy myśleć\"!")}
                    ${Mark.GREEN.block("Będę opowiadać bez naruszania Waszego komfortu")}
                    ${Mark.GREEN.block("Nie zamierzam \"wiedzieć lepiej\"", indent = 1)}

                     ${vspace(4)}

                    > Jeśli na opakowaniu parówek jest napisane \"tu otwierać\":${charBR}
                    > Nikt mi nie będzie mówić \"gdzie mam otwierać\"
                    Notes:
                    - Oczywiście wrzuciłem do AI: "Napisz mi konspekt". Wygenerował:
                      - "Macie kłopot",
                      - "Róbcie tak, a tak nie",
                      - "Podejmujecie złe decyzje"
                """.trimIndent()
                }
            }
        }
        verticalSlides {
            markdownSlide {
                content {
                    """
                        # Część I

                        ## Wrażenie inteligencji

                        ${Mark.BLUE("${charHellip} teraz nie będzie nic o duszy ${charHellip}")}${charBR}
                        ${Mark.BLUE("Nie rozchodźcie się 🙂")}${charBR}
                        ${Mark.BLUE("O duszy jeszcze będzie i będzie grubo 😮")}

                   """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip tip_at_line_15"
                content {
                    """
                        > Veronika Megler${charBR}
                        > Principal data scientist, Amazon
                        > age: 22 years 🔥

                        # Kacze typowanie

                        > Duck typing:${charBR}
                        > If it walks like a duck${charBR}
                        > and quacks like a duck,${charBR}
                        > then it’s a duck.${charBR}

                        ____

                        # Gra \"Hobbit\" [1982]

                        - Platformy: Commodore 64, Spectrum, inne 8-bitowe z ~64 KB RAM
                        - Parser:
                          - 400 słów
                          - rozumiał takie zwroty:
                            - \"ask Gandalf about the curious map then take sword and kill troll with **it**\"
                            - \"**viciously** attack the goblin\"

                        ${Mark.BLUE.block("Napisanie takiego parsera jest w zasięgu wielu z nas", 0)}
                        ${Mark.BLUE.block("Nie, że trywialne, ale nie wymaga ogromnych zasobów", 0)}
                        ${Mark.RED.block("Przez 40 lat nie przyjął się jako podstawowy interfejs gier", 0)}
                    """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Kacze typowanie

                        > Duck typing:${charBR}
                        > If it walks like a duck${charBR}
                        > and quacks like a duck,${charBR}
                        > then it’s a duck.${charBR}

                        ____

                        # Mechaniczny programista ${charHellip}

                        ${Mark.BLUE.block("${charHellip} przyjmuje polecenia w języku naturalnym,")}
                        ${Mark.BLUE.block("${charHellip} pisze jak człowiek,")}
                        ${Mark.BLUE.block("${charHellip} pisze: \"sprawdzę\", \"zrozumiałem\", \"poprawiłem\"")}
                        ${Mark.RED.block("Mózg automatycznie buduje model \"kogoś\"")}

                        ---

                        # Kacze typowanie

                        > Duck typing:${charBR}
                        > If it walks like a duck${charBR}
                        > and quacks like a duck,${charBR}
                        > then it’s a duck.${charBR}

                        ____

                        # ${charHellip} vs. developer

                        ${Mark.BLUE.block("My z grubsza wiemy, co jest pod maską:")}
                        ${Mark.BLUE.block("macierze, tensory, trochę kodu, ${charHellip},")}
                        ${Mark.BLUE.block("Ta wiedza działa zaledwie jak korekta intuicji")}
                        ${Mark.RED.block("Ta wiedza nie wyłącza modelowania \"kogoś\"")}

                        ---

                        # Ambiwalencja poznawcza

                        ${vspace()}

                        ${Mark.BLUE.block("Mózg społeczny ewoluował setki tysięcy lat")}
                        ${Mark.BLUE.block("Publicznie dostępny ChatGPT - 2022")}
                        ${Mark.BLUE.block("Nie mamy stabilnych intuicji dla interakcji z AI")}

                        ${vspace()}

                        ${Mark.BLUE.block("Rozumiemy: prompt, kontekst, tensory, statystykę")}
                        ${Mark.BLUE.block("Jednocześnie mózg dopowiada model \"kogoś\"")}

                        ${vspace()}

                        ${Mark.RED.block("Wiedza techniczna tylko tonuje antropomorfizację")}
                    """.trimIndent()
                }
            }
            dslSlide {
                content {
                    h1 { +"Szybkie ścieżki kognitywne" }
                    yt("JMJXvsCLu6s", "Wildebeest ${charCopyright} Birdbox Studio", start = 17, stop = 50, autoplay = true)
                    p { span("color_blue block") { +"Jest w mózgu szybka ścieżka wykrywania zagrożenia" } }
                    p { span("color_blue block") { +"Ten mechanizm jest nadczuły:" } }
                    p { span("color_green block") { +"Mniejszy wstyd jest przestraszyć się krzaka," } }
                    p { span("color_green block") { +"niż nie zauważyć tygrysa." } }
                    notes {
                        p { +"https://www.youtube.com/@Birdboxstudio" }
                    }
                }
            }
            markdownSlide {
                content {
                    """
                    # Szybkie ścieżki kognitywne

                    ${illustration("face.webp", alt = "Stylizowany nieoczywisty obraz twarzy")}

                    ${Mark.BLUE.block("Jest w mózgu szybka ścieżka wykrywania twarzy")}
                    ${Mark.BLUE.block("Ten mechanizm jest nadczuły:")}
                    ${Mark.GREEN.block("Mniejszy wstyd jest przywitać się z drzewem,")}
                    ${Mark.GREEN.block("niż nie ukłonić się przed wodzem.")}

                    Notes:
                    source: https://biennaleai.org
                """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Szybkie ścieżki kognitywne

                        ${illustration("dragon.jpg", alt = "Smok", fragmentIndex = 0)}

                        ${Mark.BLUE.block("🫣 Jednym z atrybutów istot rozumnych")}
                        ${Mark.BLUE.block("jest posługiwanie się **naszym** (lub przetłumaczalnym) językiem.")}
                        ${Mark.BLUE.block("Nie mam żadnych dobrych przykładów 😕")}
                        ${Mark.BLUE.block("Ten mechanizm też jest nadczuły:")}
                        ${Mark.RED.block("_tu nie ma mowy o tym \"co z czego wynika\"_", indent = 1, fragmentIndex = 0)}
                        ${Mark.RED.block("_ani język ${charRArrow} wrażenie inteligencji, ani odwrotnie_", indent = 1, fragmentIndex = 0)}
                        ${Mark.GREEN.block("Delfiny? Chyba mają język, być może są inteligentne", 0)}
                        ${Mark.GREEN.block("Zombie? Nie są rozumne, mimo że kiedyś były. Nie mówią", 0)}
                        ${Mark.GREEN.block("Smoki? Rozmawiają, nie są w tej samej kategorii co krowa", 0)}
                        ${Mark.GREEN.block("No i jeszcze koty, tylko że kotom się nie chce 😉", 0)}

                        Notes:
                        - smoki, koty, zombie: naprawdę nie mam lepszych przykładów
                        - pomińmy czy smoki są realne
                        - gorylica Koko:
                          - potrafiła dogadać się z kotem
                          - "kotka nie przyjdzie na obiad, bo ją brzuch boli"
                    """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Szybkie ścieżki kognitywne

                        ${illustration("furby.jpg", alt = "Zabawka: Furby")}

                        ${Mark.BLUE.block("🫣 Jednym z atrybutów istot rozumnych")}
                        ${Mark.BLUE.block("jest posługiwanie się **naszym** (lub przetłumaczalnym) językiem.")}
                        ${Mark.BLUE.block("Ten mechanizm też jest nadczuły:")}
                        ${Mark.GREEN.block("Furby [1998]: furbish, ewoluujący do angielskiego")}
                        ${Mark.GREEN.block("R2D2 \"Star Wars\": droidspeak, ma sporo atrybutów inteligencji")}
                        ${Mark.GREEN.block("Winda: \"Drzwi otwarte.\" _(cześć Ela)_")}
                        ${Mark.GREEN.block("- tam nie ma grama inteligencji, ale gadająca winda +10 do popytu")}

                        Notes:
                        - https://pixabay.com/pl/photos/furby-uroczy-niebieskie-oczy-974514/
                        - Znam twórcę mówiącej windy
                    """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Szybkie ścieżki kognitywne

                        ${illustration("cline.png", alt = "Logo: cline")}

                        ${Mark.BLUE.block("🫣 Jednym z atrybutów istot rozumnych")}
                        ${Mark.BLUE.block("jest posługiwanie się **naszym** (lub przetłumaczalnym) językiem.")}
                        ${Mark.BLUE.block("Nie mam żadnych dobrych przykładów 😕")}
                        ${Mark.BLUE.block("Ten mechanizm też jest nadczuły:")}
                        ${Mark.GREEN.block("cline: język naturalny jako interfejs")}
                        ${Mark.GREEN.block("cline: \"_Thinking:_\", \"poprawiłem\", \"przeczytałem\", ${charHellip}")}
                        ${Mark.RED.block("cline: \"Myślę, że${charHellip}\", \"Wydaje mi się, że${charHellip}\"", 0)}
                        ${Mark.RED.block("Te zwroty są koszmarne: tylko człowiek mówił, co myśli.", 0)}
                        ${Mark.RED.block("cline całkiem sprawnie operuje językiem, tylko człowiek tak umie.", 0)}
                    """.trimIndent()
                }
            }
            dslSlide {
                classes = "has_tip tip_at_line_17"
                content {
                    blockQuote {
                        p { +"Yann LeCun:" }
                        p { +"Chief AI Scientist at Meta" }
                    }
                    h1 { +"Szybkie ścieżki kognitywne" }
                    yt("w-TtKPRuXL8", "AI nadal jest głupia")
                    p { span("color_blue block") { +"AI potrafi bardzo dobrze manipulować językiem" } }
                    p { span("color_blue block") { +"dajemy się oszukać, że jest inteligentne" } }
                    blockQuote("color_green block") { +"Operowanie językiem nie jest takie trudne" }
                    span("color_red block fragment") {
                        p { span("block") { +"Yyyy?" } }
                        p { +"Brzmi jak herezja, tylko człowiek tak umie" }
                        p { +"Veronice Megler 40 lat temu wystarczył parser na 400 słów" }
                    }
                    notes {
                        p { +"Yann LeCun mówi wprost: AI jest głupia. Operuje językiem, ale nie rozumie." }
                    }
                }
            }
            markdownSlide {
                content {
                    """
                        # Spiseq

                        ${illustration("reptilians.jpg", alt = "grafika: reptilianin")}

                        ${Mark.GREEN.block("🫣 Oczywiście: trochę upraszczam")}
                        ${Mark.GREEN.block("Różnica między parserem na 400 słów a LLM jest ${charHellip} spora")}
                        ${Mark.GREEN.block("Możliwości też się różnią")}
                        ${Mark.BLUE.block("Hobbit dawał namiastkę języka naturalnego")}
                        ${Mark.GREEN.block("LLM: \"Wow, to gada, nawet z sensem\"")}
                        ${Mark.GREEN.block("LLM: \"Wow, to programuje, czasem z sensem\"")}
                        ${Mark.BLUE.block("Nazwaliśmy tę namiastkę: AI - Artificial Intelligence")}
                        ${Mark.RED.block("To tak, jakby nazywać Ubera taksówką")}
                        ${Mark.BLACK.block("A może AI jest over-hyped?", extraClass = "yellow_subtitles")}
                        ${Mark.BLACK.block("Połączcie kropki", extraClass = "yellow_subtitles")}

                        Notes:
                        - License:
                          - CC BY 4.0
                          - https://pl.wikipedia.org/wiki/Plik:6858607_2202998_szymszyl_untitled-6858607.c599a8d6e86d38ecbbd56b28bdb4f472.jpg
                        """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Czy androidy śnią o elektrycznych owcach?

                        ${Mark.BLUE.block("W jakim języku myśli cline?")}

                        ${Mark.GREEN.block("- po polsku")}
                        ${Mark.GREEN.block("- po angielsku")}
                        ${Mark.GREEN.block("- po matematycznemu")}
                        ${Mark.GREEN.block("- po statystycznemu")}

                        ${Mark.RED.block("Chwila do namysłu dla publiczności", 0, Effect.FADE_OUT)}

                        ${Mark.RED.block("${charHellip} a podobno nie ma głupich pytań 🙃", 0)}
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip tip_at_line_17"
                content {
                    """
                        > Perplexity

                        # Czy androidy śnią o elektrycznych owcach?

                        ${vspace()}

                        ${Mark.PROMPT.block("W jakim języku myśli cline?")}
                        ${Mark.ANSWER.block("AI nie myśli po polsku ani po angielsku; wykonuje obliczenia na reprezentacjach liczb, a język pojawia się głównie na wejściu i wyjściu.")}

                        Notes:
                        - pamiętajcie o tendencji do antropomorfizacji czytając newsy w mediach
                    """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Czy androidy śnią o elektrycznych owcach?

                        ${illustration("cline.png", alt = "Logo: cline")}

                        ${Mark.COMMENT.block("W trakcie pracy nad skryptem w bashu:")}
                        ${Mark.PROMPT.block("Funkcja `yyyy` - to już bardziej skomplikować się nie dało?")}
                        ${Mark.ANSWER.block("Rozumiem instrukcję - uprościć funkcję `yyyy`")}
                        ${Mark.COMMENT.block("Dekodowanie sarkazmu to potężny wysiłek intelektualny")}
                        ${Mark.RED.block("No przecież${charHellip} antropomorfizuję", 0)}
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip tip_at_line_25"
                content {
                    """
                        > Claude 4.8 Opus

                        # Czy androidy śnią o elektrycznych owcach?

                        ${illustration("ai_target.png", alt = "nie można trafić w AI, tam nie ma osobowości")}

                        ${Mark.PROMPT.block("Skoro cline nie ma tożsamości")}
                        ${Mark.PROMPT.block("- Nie ma tego \"Ja\",")}
                        ${Mark.PROMPT.block("- do którego możemy trafić przez \"Ty\"")}
                        ${Mark.PROMPT.block("To może źle promptujemy?")}
                        ${Mark.ANSWER.block("Prompt to zlecenie, .clinerules to constraints.")}
                        ${Mark.ANSWER.block("Nie promptuj Cline’a jako osoby.")}
                        ${Mark.RED.block("😌😏🥹 aż się wzruszyłem własną błyskotliwością")}
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip tip_at_line_25"
                content {
                    """
                        > Claude 4.8 Opus

                        # Czy androidy śnią o elektrycznych owcach?

                        ${illustration("ai_target.png", alt = "nie można trafić w AI, tam nie ma osobowości")}

                        ${Mark.RED.block("😐🙄🤦 A nie, jednak nie")}
                        ${Mark.PROMPT.block("Czekaj, czekaj, teraz to ty antropomorfizujesz.")}
                        ${Mark.PROMPT.block("To, że AI nie ma osobowości, nie znaczy, że nie rozumie adresowania.")}
                        ${Mark.PROMPT.block("Tak został wyszkolony.")}
                        ${Mark.PROMPT.block("Tak samo skuteczne jest \"napisz funkcję\" jak \"potrzebna jest funkcja\"")}
                        ${Mark.ANSWER.block("Masz absolutną rację. Złapałeś mnie na gorącym uczynku.")}
                        ${Mark.ANSWER.block("Antropomorfizacja przemycona w argumencie przeciw antropomorfizacji. Ironia pełna.")}

                        Notes:
                        - Model nie ma osobowości, ale "rozumie" adresowanie:
                          - na tekstach adresowanych do kogoś był trenowany.
                          - "Ty", "napisz", "potrzebna jest funkcja" - to są wzorce tekstu z korpusu,
                          - i wszystkie są równie skuteczne (albo nieskuteczne).
                        - modelowi jest wszystko jedno, czy coś brzmi jak rozmowa z bytem.
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip tip_at_line_25"
                content {
                    """
                        > Claude 4.8 Opus

                        # Czy androidy śnią o elektrycznych owcach?

                        ${illustration("ai_target.png", alt = "nie można trafić w AI, tam nie ma osobowości")}

                        ${Mark.RED.block("🤔😕❔Co tu się stanęło?")}
                        ${Mark.BLUE.block("Tak wyszło. Ze statystyki i z kontekstu")}

                        ${vspace()}
                        ${Mark.ANSWER.block("Excellent finding. You are absolutely right!")}

                        ${vspace()}
                        ${Mark.PROMPT.block("Sam żeś to byle co napisał${charHellip}")}
                        ${Mark.ANSWER.block("Czekaj, czytam plik, żeby zobaczyć, co napisałem.")}

                        ${vspace()}
                        ${Mark.BLUE.block("cline nie żałuje, cline nie budzi się w nocy:")}
                        ${Mark.ANSWER.block("Czy `AbstractDuckFactoryProviderFactoryProvider` to była dobra nazwa?")}
                        ${Mark.BLUE.block("cline dopisuje Adapter")}

                        Notes:
                        - abstrakcyjny dostawca fabryki dostawców fabryk kaczek
                        - `DuckFactory` = fabryka kaczek
                        - `DuckFactoryProvider` = dostawca fabryki kaczek
                        - `DuckFactoryProviderFactory` = fabryka dostawców fabryk kaczek
                        - `DuckFactoryProviderFactoryProvider` = dostawca tej fabryki
                    """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Zanim zrobi się poważnie (takie mi zostało)

                        ## Co robi cline jak się nudzi?

                        ${Mark.ANSWER.block("Cline wants to execute this command:")}
                        ${Mark.ANSWER.block("`ping 127.0.0.1 -n 30`")}
                        ${Mark.PROMPT.block("Yyyy? Po co ci ping do localhost???")}
                        ${Mark.ANSWER.block("Użytkownik ma rację - ping do localhost był bez sensu.")}
                        ${Mark.ANSWER.block("To było odczekanie na zakończenie builda w tle.")}

                        Notes:
                        - pogubił się co ma w kontekście
                        - nie umiał znaleźć `sleep` ani `delay`, to uruchomił `ping` przez 30 sekund

                        ---

                        ## Nie trafiam do niego

                        ${Mark.COMMENT.block("Jakiś manual piszemy. Z trudem. ")}
                        ${Mark.COMMENT.block("cline ignoruje .clinerules")}
                        ${Mark.PROMPT.block("To są reguły, które ja(operator), CI ${Mark.GREEN(" 👈👈👈", 1)} zdefiniowałem...")}
                        ${Mark.ANSWER.block("Jako CI operator...")}
                        ${Mark.PROMPT.block("Yyyy??? Co to jest CI???", 0)}
                        ${Mark.ANSWER.block("Continuous Integration", 0)}
                        ${Mark.PROMPT.block("Skąd *****???", 1)}
                        ${Mark.ANSWER.block("Projekt jest o github actions, poza tym pisałeś \"operator CI\"...", 1)}
                        ${Mark.PROMPT.block("Nie CI !!! TOBIE !!!", 3)}
                        ${Mark.ANSWER.block("Jako TOBIE operator...", 4)}

                        Notes:
                        - Przypuszczam, że winny był tokenizer
                          - Wszystko wielkimi literami (TCP/IP, CI, TOBIE) traktował jako nazwę własną, bez wnikania w semantykę
                    """.trimIndent()
                }
            }

        }

        verticalSlides {
            markdownSlide {
                content {
                    """
                        # Część II

                        ## O akceptacji języka naturalnego
                    """.trimIndent()
                }
            }
            dslSlide {
                classes = "has_tip tip_at_line_8"
                content {
                    blockQuote {
                        p {
                            strong { +"Mastah" }; +":"; br {}
                            +"Master hacker"; br {}
                            +charLongRArrow; +" Masta hacka"; br {}
                            +charLongRArrow; +" Mastah"
                        }
                    }

                    h1 { +"Structural JSON" }
                    h2 { +"Garbage-in-Garbage-out" }

                    blockQuote {
                        p {
                            +"Byłem na rekrutacji, zapytali czy umiem w prompty"; br {}
                            +"A ja im od razu strukturalnego JSONa"; +charHellip; br {}
                            +"Łoo, Ty to ale jesteś! Mastah 😮"
                        }
                    }

                    span("block color_green") {
                        +"Na strukturalnego JSON w promptach był hype "
                        span("fragment fade-out") {
                            attributes["data-fragment-index"] = "0"
                            +"dawno"
                        }
                        span("fragment") {
                            attributes["data-fragment-index"] = "0"
                            +"jakiś rok"
                        }
                        +" temu"
                    }

                    p("fragment") {
                        attributes["data-fragment-index"] = "0"
                        span("block color_green") {
                            +"Mowa jest o czymś takim:"
                        }
                    }

                    div("fragment") {
                        attributes["data-fragment-index"] = "0"
                        pre {
                            code("language-json") {
                                +"""
                                {
                                  "task": "...",
                                  "jira_context": "...",
                                  "memory_bank": ["..."],
                                  "files": ["..."],
                                  "problem": "...",
                                  "proposed_approach": "..."
                                }
                            """.trimIndent()
                            }
                        }
                    }
                }
            }
            dslSlide {
                classes = "has_tip tip_at_line_3"
                content {
                    blockQuote {
                        p {
                            strong { +"Interakcja:" }; br {}
                            +"- chat bot"; br {}
                            +"- mechaniczny programista"; br {}
                            strong { +"Produkcja:" }; br {}
                            +"- prompt w ramach toolchainu"; br {}
                            +"- fragment procesu"
                        }
                    }

                    h1 { +"Structural JSON" }
                    h2 { +"Garbage-in-Garbage-out" }

                    p("color_green") {
                        span("block") {
                            +"Mowa jest o czymś takim "; strong { +"(jako prompt otwierający interakcję)" }
                        }
                    }

                    div {
                        pre {
                            code("language-json") {
                                +"""
                                    {
                                      "task": "...",
                                      "jira_context": "...",
                                      "memory_bank": ["..."],
                                      "files": ["..."],
                                      "problem": "...",
                                      "proposed_approach": "..."
                                    }
                                """.trimIndent()
                            }
                        }
                    }

                    p("color_green") {
                        span("block") {
                            +"Mieszanie benchmarków z produkcji w interakcję"
                        }
                        span("block") {
                            +"${charRArrow} overhyped JSON"
                        }
                    }

                    p("fragment") {
                        attributes["data-fragment-index"] = "0"
                        span("color_red block") {
                            +"Pytanie z Reddita: "; strong { +"\"Co się z tym robi?\"" }
                        }
                    }

                    p("fragment") {
                        attributes["data-fragment-index"] = "0"
                        span("color_green block") {
                            +"To się: projektuje, wypełnia danymi i wkleja jak zwykły prompt"
                        }
                    }

                    notes {
                        p { +"https://www.reddit.com/r/ChatGPTPromptGenius/comments/1mteqd5/i_built_a_json_prompt_that_makes_ai_write_like_a/?tl=pl" }
                        p { +"Sama składnia JSONa nie powinna być dla nas trudna" }
                    }
                }
            }
            dslSlide {
                classes = "has_tip tip_at_line_3"
                content {
                    blockQuote {
                        p {
                            strong { +"Interakcja:" }; br {}
                            +"- chat bot"; br {}
                            +"- mechaniczny programista"; br {}
                            strong { +"Produkcja:" }; br {}
                            +"- prompt w ramach toolchainu"; br {}
                            +"- fragment procesu"
                        }
                    }

                    h1 { +"Structural JSON" }
                    h2 { +"Garbage-in-Garbage-out" }

                    p("color_green") {
                        span("block") {
                            +"Mowa jest o czymś takim "; strong { +"(prompt otwierający interakcję)" }; +":"
                        }
                    }

                    div {
                        pre {
                            code("language-json") {
                                +"""
                                    {
                                      "task": "...",
                                      "jira_context": "...",
                                      "memory_bank": ["..."],
                                      "files": ["..."],
                                      "problem": "...",
                                      "proposed_approach": "..."
                                    }
                                """.trimIndent()
                            }
                        }
                    }

                    span("block ") {
                        span("color_green") {
                            +"Bo AI JSONa świetnie rozumie "
                        }
                        span("color_blue fragment") {
                            attributes["data-fragment-index"] = "0"
                            +"${charNonBreakingHyphen}${charNonBreakingSpace}a język naturalny jest dla LLMa jakiś obcy?"
                        }
                    }

                    span("block ") {
                        span("color_green") {
                            +"JSON to standard nowoczesnej wymiany danych "
                        }
                        span("color_blue fragment") {
                            attributes["data-fragment-index"] = "0"
                            +"${charNonBreakingHyphen}${charNonBreakingSpace}JSON jest czytelny dla człowieka, ale "; strong { +"jego zapis bywa trudny" }
                        }
                    }

                    span("block ") {
                        span("color_green") {
                            +"JSON jest testowalny, można go wersjonować, łatwiej się debuguje "
                        }
                        span("color_blue fragment") {
                            attributes["data-fragment-index"] = "0"
                            +"${charNonBreakingHyphen}${charNonBreakingSpace}"
                            strong { +"Yyyy?" }
                            +" Ale ja to używam jednorazowo"
                        }
                    }

                    span("block ") {
                        span("color_green") {
                            +"Prompt w języku naturalnym można szybko wpisać i uzyskać jakiś${charNonBreakingHyphen}tam wynik, JSON ma lepsze metryki jakości "
                        }
                        span("color_blue fragment") {
                            attributes["data-fragment-index"] = "0"
                            +"${charNonBreakingHyphen}${charNonBreakingSpace}"
                            strong { +"nie ma zakazu używania \"tłustych\" promptów" }
                        }
                    }

                    notes {
                        p { +"https://www.unite.ai/pl/what-is-json-prompting-and-why-is-everyone-talking-about-it" }
                    }
                }
            }
            dslSlide {
                classes = "has_tip tip_at_line_3"
                content {
                    blockQuote {
                        p {
                            strong { +"Interakcja:" }; br {}
                            +"- chat bot"; br {}
                            +"- mechaniczny programista"; br {}
                            strong { +"Produkcja:" }; br {}
                            +"- prompt w ramach toolchainu"; br {}
                            +"- fragment procesu"
                        }
                    }

                    h1 { +"Structural JSON" }
                    h2 { +"Garbage-in-Garbage-out" }

                    p("color_green") {
                        span("block") {
                            +"Mowa jest o czymś takim "; strong { +"(prompt otwierający interakcję)" }; +":"
                        }
                    }

                    div {
                        pre {
                            code("language-json") {
                                +"""
                                    {
                                      "task": "...",
                                      "jira_context": "...",
                                      "memory_bank": ["..."],
                                      "files": ["..."],
                                      "problem": "...",
                                      "proposed_approach": "..."
                                    }
                                """.trimIndent()
                            }
                        }
                    }

                    p {
                        span("block color_green") {
                            +"Mój rutynowy prompt na początek implementacji zadania z Jiry"
                        }
                        span("block color_green") {
                            +"${charHellip} przygotowanie czasem trwa nawet pół godziny"
                        }
                    }

                    div {
                        pre {
                            code("language-plaintext") {
                                +"""
                                    /deep-planning Jesteśmy w tasku `...`
                                    Kontekst z Jiry: "...".
                                    Przeczytaj memory bank:
                                    - `...`
                                    - `...`
                                    Przeczytaj pliki:
                                    - `...`
                                    - `...`
                                    Problem jest taki, że ...
                                    Mój pomysł jest taki, że ...
                                """.trimIndent()
                            }
                        }
                    }

                    p {
                        span("block color_green") {
                            +"Wartość jest w kontekście, nie w klamrach"
                        }
                    }
                }
            }
            markdownSlide {
                content {
                    """
                        # Akceptacja interfejsów

                        Kolejność **nie**przypadkowa:
                        - IDE / GUI
                        - CLI
                        - AI Chat
                        - Voice
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip tip_at_line_5"
                content {
                    """
                        > IDE / CLI / chat / voice

                        # Dlaczego "AI chat" jest tak nisko?

                        ${Mark.RED.block("Chwila do namysłu dla publiczności", 0, Effect.FADE_OUT)}

                        ${Mark.RED.block("🫣 Moje typy", 0, Effect.FADE_IN_THEN_OUT)}

                        ${Mark.GREEN.block("Niska innowacyjność ${Mark.BLUE("- współpraca z mechanicznym programistą nie wnosi nic nowego, używamy tych samych technik i czynności", 1)}", 0)}
                        ${Mark.GREEN.block("Dyskomfort 😣 ${Mark.BLUE("- dolina niesamowitości (uncanny valley)", 1)}", 0)}
                        ${vspace()}
                        ${Mark.GREEN.block("Brak powtarzalności ${Mark.BLUE("- nigdy nie wiem, jak \"dziś\" będzie mi się współpracować z AI", 1)}", 0)}
                        ${Mark.GREEN.block("Koszt weryfikacji ${Mark.BLUE("- może i kod wygląda nieźle, ale na produkcję? Bez review?", 1)}", 0)}
                        ${Mark.GREEN.block("Obserwowalność ${Mark.BLUE("- black box nie ma flagi `--verbose`", 1)}", 0)}

                        Notes:
                        - Pozwolę sobie nie omawiać ostatnich trzech
                          - wydają mi się w miarę uniwersalne
                        - Można jeszcze dodać:
                          - Brak determinizmu
                          - Mniejsza kontrola nad szczegółem
                          - Brak utrwalonych konwencji i kompetencji
                    """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Dlaczego "AI chat" jest tak nisko?
                        ## Niska innowacyjność

                        ${Mark.RED.block("Yyyy? Wykorzystanie AI jest mało innowacyjne?")}
                        ${Mark.BLUE.block("Komputeryzacja (wczesne lata '80) nie doprowadziła od razu do wzrostu wydajności")}

                        > komputery widać wszędzie poza statystyką

                        ${Mark.GREEN.block("Znaliśmy CP/M, bazy danych, edytory tekstów")}
                        ${Mark.BLUE.block("Efekt dały sieci, kooperacja między programami, integracja systemów, zmiany procesów${charHellip}")}
                        ${Mark.RED.block("Nauczyliśmy się ich używać")}

                        Notes:
                        - Przykład: pierwsze pojazdy z napędem silnikowym to były bryczki bez konia, nawet woźnica nie siedział pod dachem
                        - Paradoks Produktywności (Solow, 1987): komputery widać wszędzie poza statystyką
                        - Wzrost przyszedł z opóźnieniem (lata '90), po nauczeniu się narzędzia i integracji
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip tip_at_line_25"
                content {
                    """
                        > ${charCopyright}Masahiro Mori

                        # Dlaczego "AI chat" jest tak nisko?
                        ## Dolina niesamowitości (Uncanny Valley)

                        ${illustration("Mori_Uncanny_Valley.svg", alt = "wykres: dolina niesamowitości", size = IllustrationSize.Large)}

                        ${Mark.BLUE.block("Teoria Moriego dotyczyła **wyłącznie wyglądu i ruchu**")}
                        ${Mark.BLUE.block("Dolina niesamowitości: ${Mark.GREEN("obszar negatywnych reakcji wobec robotów \"prawie\" ludzkich")}")}
                        ${Mark.RED.block("Jeśli udajesz człowieka, to rób to bardzo dobrze")}
                        ${Mark.GREEN.block("To jest oczywiście statystyka, każdy jest jakiś")}
                        ${vspace()}
                        ${Mark.RED.block("🫣 Będzie naciąganie teorii")}
                        ${Mark.RED.block("Jeśli udajesz inteligencję: albo rób to bardzo dobrze, albo nie zaprzyjaźnimy się")}

                        Notes:
                        - License: By Smurrayinchester - self-made, based on image by Masahiro Mori and Karl MacDorman at http://www.androidscience.com/theuncannyvalley/proceedings2005/uncannyvalley.html (archive), CC BY-SA 3.0, https://commons.wikimedia.org/w/index.php?curid=2041097
                        - Dwa wykresy - nieruchome i poruszające się
                        - Wykres: Reakcja emocjonalna w zależności od stopnia antropomorfizmu robota
                        - "bunraku puppet" tak wysoko??? To chyba jakiś lokalny koloryt kulturowy
                    """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Trójkąt akceptacji

                        ${illustration("ai_triangle_PL.png", alt = "trójkąt akceptacji", size = IllustrationSize.Large)}

                        ${Mark.BLUE.block("Wybierzcie proszę")}
                        ${Mark.BLUE.block("Gdzie lokujecie swój sposób współpracy z czat-botami")}
                        ${Mark.GREEN.block("Wierzchołki:")}
                        ${Mark.GREEN.block("- naturalny dialog w języku naturalnym jest ok")}
                        ${Mark.GREEN.block("- wolę JSON strukturalny i inne formy syntetyczne")}
                        ${Mark.GREEN.block("- ale że z maszyną rozmawiać?")}

                        ${vspace()}

                        ${Mark.RED.block("Wspieranie się AI to jest nowa wymagana umiejętność")}
                        ${Mark.RED.block("Znam inżynierów wysokiej klasy, którzy z niej nie korzystają")}

                        Notes:
                        - ten trójkąt to jest mój wynalazek, w internetach go nie znajdziecie
                    """.trimIndent()
                }
            }
            dslSlide {
                classes = "has_tip tip_at_line_17"
                content {
                    blockQuote {
                        span { +"Andrew Ng" }; br {}
                        span { +"100 Most Influential People in AI" }
                    }

                    h1 { +"Trójkąt akceptacji" }
                    yt("Yfhd7XpBZIU", "Andrew Ng ogłasza przełomowy test ludzkiej inteligencji.", start = 2715)

                    blockQuote {
                        span { +"Specjaliści, którzy wykorzystają AI, będą w stanie zrobić dużo więcej" }; br {}
                        span { +"Osoby, które nie wykorzystają tych możliwości zostaną w tyle" }
                    }

                    p { span("color_red block") { +"Wspieranie się AI to jest nowa wymagana umiejętność" } }
                    p { span("color_red block") { +"Znam inżynierów wysokiej klasy, którzy z niej nie korzystają" } }
                    p { span("color_red block") { +"Może ten trzeci wierzchołek jest ważniejszy niż wygląda? 😞" } }

                    vspace()

                    unsafe { +illustration("ai_triangle_red_PL.png", alt = "trójkąt akceptacji - trudne przejście z nieśmiałości do języka naturalnego", size = IllustrationSize.Large) }

                    p { span("color_red block") { +"🫣 Może z \"nieśmiałości\" łatwiej wyjść przez strukturę niż dialog?" } }

                    notes {
                        p { +"2023 Time 100 Most Influential People in AI" }
                        p { +"Ja na przykład nie zaakceptowałem \"rozmowy\" z maszyną. Te wszystkie \"Ok Bixby\", \"Ok google\", głosowe wybieranie numerów mimo wielu prób - nie potrafię się przełamać" }
                    }

                }
            }
            dslSlide {
                content {
                    h1 { +"Trójkąt akceptacji" }
                    yt("Yfhd7XpBZIU", "Andrew Ng ogłasza przełomowy test ludzkiej inteligencji.", start = 2715)

                    blockQuote {
                        span { +"Specjaliści, którzy wykorzystają AI, będą w stanie zrobić dużo więcej" }; br {}
                        span { +"Osoby, które nie wykorzystają tych możliwości zostaną w tyle" }
                    }

                    p { span("color_red block") { +"Wspieranie się AI to jest nowa wymagana umiejętność" } }
                    p { span("color_red block") { +"Znam inżynierów wysokiej klasy, którzy z niej nie korzystają" } }
                    p { span("color_red block") { +"Może ten trzeci wierzchołek jest ważniejszy niż wygląda? 😞" } }

                    vspace()

                    unsafe { +illustration("ai_triangle_green_PL.png", alt = "trójkąt akceptacji - łatwiejsze przejście z nieśmiałości do JSON", size = IllustrationSize.Large) }

                    p { span("color_red block") { +"🫣 Może z \"nieśmiałości\" łatwiej wyjść przez strukturę niż dialog?" } }
                    p { span("color_green block") { +"Może podpowiedź jest na obrazku?" } }
                    p { span("color_green block") { +"Model nie zauważy, a przestajesz modelować \"kogoś\"" } }
                }
            }
            markdownSlide {
                content {
                    """
                        # Drugie wykluczenie cyfrowe

                        ${illustration("raport_gov.jpg", alt = "Czy-sztuczna-inteligencja-poglebia-wykluczenia-cyfrowe-1")}

                        ## AI adoption divide

                        > [${charHellip}] brak kompetencji umożliwiających korzystanie z narzędzi w pracy i życiu codziennym.

                        > Istnieje pilna potrzeba interwencji edukacyjnych, które przełamią "spiralę wykluczenia"

                        > Bez proaktywnych [${charHellip}] działań [${charHellip}] sztuczna inteligencja, zamiast stać się
                        narzędziem wyrównywania szans, utrwali i pogłębi istniejące nierówności społeczne.

                        Notes:
                        - Tu nie chodzi o dostęp, tylko o kompetencję korzystania z AI
                        - AI adoption divide: nie ma dobrego tłumaczenia PL
                        - `https://ai.gov.pl/media/2026/04/Czy-sztuczna-inteligencja-poglebia-wykluczenia-cyfrowe-1.pdf`
                    """.trimIndent()
                }
            }

        }

        verticalSlides {
            markdownSlide {
                content {
                    """
                        # Część III

                        ## Czy cline ma duszę?
                    """.trimIndent()
                }
            }
            markdownSlide {
                classes = "has_tip tip_at_line_15"
                content {
                    """
                        > Jacek Dukaj${charBR}
                        > W kraju niewiernych${charBR}
                        > In partibus infidelium

                        # Czy cline ma duszę?

                        Kogo to interesuje?

                        - filozofowie
                        - ~religia~
                        - **teolodzy**
                        - Jacek Dukaj
                        - _producenci żelazek_
                        - _lutnicy_

                        Notes:
                        - religia: pomijam (zasady korporacyjne)
                    """.trimIndent()
                }
            }
            dslSlide {
                classes = "has_tip tip_at_line_17"
                content {
                    blockQuote {
                        span { +"Wojciech Grygiel" }; br {}
                        span { +"teolog-naukowiec" }
                    }

                    h1 { +"Czy cline ma duszę?" }
                    yt("kcNiibTCdow", "Jeden świat, dwa języki", start = 3811)

                    p { span("color_blue block") { +"w filmie mowa o:" } }
                    p { span("color_blue block") { strong { +"Kongregacja Nauki Wiary, list o eschatologii" }; +", 1979." } }

                    blockQuote {
                        span { +"Dokument nie robi roszczeń w stylu \"dusza istnieje\"." }; br {}
                        span { +"Jest to coś, co warunkuje naszą podmiotowość, przetrwa śmierć fizyczną." }; br {}
                        span { +"${charHellip} "; strong { +"nie jest wykluczone, że nie można podjąć jakiegoś innego aparatu" }; +" ${charHellip}" }; br {}
                        span { +"Jak to nazwiemy - to kwestia zmienna." }
                    }

                    p { span("color_blue block") { +"Bez precyzowania z czego ludzka dusza jest, ale jak może być z czegoś innego, to wszystko jedno 😇" } }

                    notes {
                        ul {
                            li { p { +"Grygiel mówi 1978; dokument o eschatologii to 1979 (Kongregacja Nauki Wiary)" } }
                            li {
                                p { +"Inne filmy warte uwagi" }
                                ul {
                                    li {
                                        p {
                                            a(href = "https://www.youtube.com/watch?v=atfxadPv7Zw") {
                                                +"Tego nie usłyszysz w Kościele! Biblia, Wielki Wybuch, Brak Cudów"
                                            }
                                        }
                                    }
                                    li {
                                        p {
                                            a(href = "https://www.youtube.com/watch?v=QI8O6mpzejc") {
                                                +"Nie powiedziałbym tego z ambony. Dusza jako emergentna właściwość mózgu"
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            markdownSlide {
                content {
                    """
                        # Czy cline ma duszę?

                        ## Watykan nie lubi być zaskakiwany

                        ### Szczególnie przez obcych

                        Gdyby byli rozumni obcy - wypada mieć wypracowane stanowisko

                        - **dusza**:
                          - po śmierci zachowuje świadomość i wolę
                          - raczej coś innego niż stan zapisany w "hiberfil.sys"
                        - **anioły**
                          - niematerialne, niecielesne, osobowe, mają rozum (eng: intelligence) i wolę
                            - Katechizm, §330 LAT: "intelligentiam habent et voluntatem" 😏
                          - są nazwanym bytem
                        - **obcy**
                          - mogą istnieć, także inteligentni
                          - nie są rozstrzygnięte ich relacje z Bogiem ani kwestia odkupienia

                        Teologiczna przestrzeń bytów osobowych nie kończy się na biologicznym Homo sapiens

                        Notes:
                        - Katechizm Kościoła Katolickiego, §328-330
                          - niuans jest w tłumaczeniu "intelligence" / "rozum"
                          - §330 LAT: "intelligentiam habent et voluntatem" - nie podejmuję się tłumaczenia
                          - §330 ENG: "angels have intelligence and will"
                          - §330 PL: aniołowie są osobowi, rozumni, wolni; nie są ludźmi ani ludzkimi duszami
                        - Kongregacja Nauki Wiary, list o eschatologii, 1979, pkt 3: po śmierci trwa "element duchowy" ze świadomością i wolą; ten element Kościół nazywa "duszą"
                          - Jan Paweł II zatwierdził i zarządził publikację
                        - (to wywiad, **nie doktryna**) José Gabriel Funes SJ, dyrektor Obserwatorium Watykańskiego, L'Osservatore Romano, 2008: inteligentni obcy są teologicznie dopuszczalni
                        - z aniołów i obcych nie wynika, że każdy inteligentny system jest osobą

                        ---

                        # Czy cline ma duszę?

                        ## Dzisiaj: nie ma do tego podstaw

                        > Watykańska nota "Antiqua et nova" opisuje AI jako:${charBR}
                        > - system wykonujący zadania${charBR}
                        > - **imitację** rezultatów ludzkiej inteligencji${charBR}
                        > - narzędzie, nie osobę${charBR}
                        > BTW: osoba != dusza

                        ${vspace()}

                        - To nie jest definicja "braku duszy"
                        - To ocena: dzisiejsza AI nie jest osobą ani moralnym podmiotem

                        Notes:
                        - Dicastery for the Doctrine of the Faith + Dicastery for Culture and Education, "Antiqua et nova", 2025
                        - §10-12: "inteligencja" AI jest funkcjonalna; wykonuje zadania, ale to nie to samo, co ludzkie myślenie
                        - §59: AI to "narzędzie, nie osoba"; dokument wprost ostrzega przed antropomorfizacją
                        - dokument nie mówi wprost "AI nie ma duszy" - mówi, że nie jest osobą
                        - Franciszek zatwierdził i zarządził publikację
                    """.trimIndent()
                }
            }
            markdownSlide {
                content {
                    """
                        # Czy cline mogłoby mieć duszę?

                        ## Tego dokumenty Kościoła nie rozstrzygają

                        🫣 Przyszłe AI od reptilianina mogłoby się nie różnić znacząco
                        - 🫣 reptilianina też nie spotkałem
                        - 🫣 nie mam pojęcia jak będzie działać AI
                        - obcy - w zasadzie mógłby mieć duszę
                        - AI+ - Yyyy?

                        ${vspace(2)}

                        ### Ciekawie będzie, gdy przejdziemy
                        ### z pytań "co to potrafi?" do "kto to jest?"${charHellip}

                        Notes:
                        - "Antiqua et nova", przypis 10: nawet hipotetyczna AGI, która wydawałaby się naprawdę inteligentna, w tej perspektywie pozostaje funkcjonalna
                        - dzisiejsza AI nie jest osobą
                        - niebiologiczna osoba w przyszłości nie jest logicznie wykluczona, ale wymagałaby osobnej teologii
                    """.trimIndent()
                }
            }
        }

        verticalSlides {
            markdownSlide {
                classes = "has_tip tip_at_line_39"
                content {
                    """
                        > Douglas Hofstadter, Gödel, Escher, Bach - "trip-let"

                        ${illustration("geb.jpg", alt = "GEB", size = IllustrationSize.Small)}

                        # Grande finale

                        ## niewspółprzywiedlność

                        ${Mark.BLUE.block("Poznawczo: ${Mark.GREEN("Rozmawiamy z AI jak z \"kimś\", bez wyrobionych instynktów")}")}
                        ${Mark.BLUE.block("Metafizycznie: ${Mark.GREEN("🫣 Sztuczne pochodzenie nie zamyka ścieżki do bycia osobą")}")}
                        ${Mark.BLUE.block("Społecznie: ${Mark.GREEN("Umiejętność korzystania z AI staje się osią \"drugiego wykluczenia cyfrowego\"")}")}
                    """.trimIndent()
                }
            }
        }

        thanks()
    }
}
