# kslides template

(C) j.banaszczyk@samsung.com

Live examples

- https://pages.github.sec.samsung.net/j-banaszczyk/ai-soul/
- https://pages.github.sec.samsung.net/j-banaszczyk/ai-soul/kslides.html
- https://pages.github.sec.samsung.net/j-banaszczyk/rex/
- https://pages.github.sec.samsung.net/j-banaszczyk/rex2/
- https://pages.github.sec.samsung.net/j-banaszczyk/code_i_prompts/

> feel free to reuse

## Getting Started

## Required:

- Java 17
    - no more, no less
- IntelliJ
- github pages: https://pages.github.sec.samsung.net/

## Required:

- clone https://github.com/jbanaszczyk/kslides
- review: https://github.com/jbanaszczyk/kslides/blob/master/RELEASE_NOTES.md
- compile: `./gradlew publishToMavenLocal`

## Setup

- duplicate this repo
    - clone / clone from template / fork / any_other_way
- github settings:
    - pages
        - branch: main
        - folder: /docs
- Look for examples in: `src/main/kotlin/_UseCase.kt`
- work with `src/main/kotlin/Slides.kt`
    - remove my content
- fix:
    - in `settings.gradle.kts`
        - `rootProject.name`
    - `gradle.properties`
        - `group`
        - `version`
    - `build.gradle.kts`
- run (IntelliJ) `src/main/kotlin/Slides.kt`
    - open http://127.0.0.1:8080
- publish
    - build
    - commit
    - push
- Your site is live at https://pages.github.sec.samsung.net/your_repo/

## tools

- Presentation framework: [reveal.js](https://revealjs.com/)
- Edit framework: [kslides](https://github.com/kslides/kslides)
    - kslides API is well documented
- typography:
    - Samsung Brand Playbook
        - Samsung colors
        - SamsungSS font (2026)
    - CommitMono (with coding ligatures) font for code
- look at `src/main/kotlin/Slides.kt` for examples
    - > Use the Source, Luke

## why?

- works fine with samsung github (CODE) and pages
    - https://github.sec.samsung.net/your_repo/
    - https://pages.github.sec.samsung.net/your_repo/
- simple
    - write in markdown
        - using keyboard, not mice
        - no more PowerPoint nor MS_Paint
    - compile
    - commit/push
    - live site at github pages
- simple code source references
    - just create (sub)projects in `src/main/resources/projects`
    - use `#{include()}` to insert code snippet
        - example: `#{include(pyExamples + "chat_02/main_00.py")}`
    - life cycle:
        - edit (sub)project (s)
        - rebuild slides
        - publish on github
- typography:
    - Samsung Brand Playbook
        - Samsung colors
        - SamsungOneSans font
    - CommitMono (with coding ligatures) font for code

## Project Structure

- `src/main/kotlin/Slides.kt` — your deck (the only file most users touch).
- `src/main/resources/public/` — static assets when serving over HTTP.
- `docs/` — generated HTML and static assets when publishing to GitHub Pages or Netlify.
- `gradle.properties` — `group` and `version`.
- `build.gradle.kts` — `mainName` (only change if you rename `Slides.kt`; required for HTTP-served decks).

## Output Modes

Configured per-presentation in `Slides.kt` via the `output {}` block:

- `enableFileSystem = true` — write static HTML into `/docs` for GitHub Pages or Netlify.
- `enableHttp = true` — run an embedded HTTP server (used for local preview).

Both can be enabled at the same time.

### Static Content

Presentations served by HTTP load static content from `/src/main/resources/public`, whereas filesystem presentations load static content from `/docs`.

Make sure to run `./gradlew clean build` after making changes to `/src/main/resources/public`.

### reveal.js Assets (`docs/revealjs`)

The reveal.js distribution lives inside the `kslides-core` JAR and that JAR is the single source of truth. The `syncRevealJs` Gradle task unpacks those assets onto disk at
`docs/revealjs/` so the static HTML in `/docs` has working JS/CSS references when published.

Run it whenever you bump `kslides-core` in `gradle/libs.versions.toml`:

```
make sync-revealjs        # or: ./gradlew syncRevealJs
```

## Deploy to GitHub Pages

1) Go to your kslides content repo on GitHub
2) Click on _Settings_ -> _Pages_
3) Under **Source**, choose the _main_ branch and the _/docs_ folder and click on _Save_
4) Open the _src/main/kotlin/Slides.kt_ file
5) Ensure the _output{}_ block contains: `enableFileSystem = true`
6) Click on the green arrow next to the `fun main()` declaration to run the program and generate the html content in the _/docs_ folder
7) Add the newly generated html files in the `/docs` folder to git
8) Commit and push the changes to GitHub
9) Wait a minute or so and your slides will be available at _https://pages.github.sec.samsung.net/your_repo/_
