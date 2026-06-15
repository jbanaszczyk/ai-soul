from html import escape
from pathlib import Path
import re
import sys

block_pattern = re.compile(r"(?<![\w-])\.hljs\s*\{([^}]*)}", re.DOTALL)
property_pattern = re.compile(
    r"\b(background-color|background|color)\s*:\s*([^;]+)",
    re.IGNORECASE,
)

def read_colors(path: Path) -> tuple[str, str] | None:
    css = path.read_text(encoding="utf-8-sig", errors="replace")

    for block_match in block_pattern.finditer(css):
        properties = {
            name.lower(): value.strip()
            for name, value in property_pattern.findall(block_match.group(1))
        }

        background = properties.get("background-color") or properties.get("background")
        color = properties.get("color")

        if background and color:
            return background, color

    return None

print("""<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>CSS themes</title>
<style>
body {
  margin: 2rem;
  background: white;
  font: 20px/1.4 sans-serif;
}
.theme {
  box-sizing: border-box;
  margin-bottom: 1rem;
  padding: 1.5rem 2rem;
  border: 1px solid #888;
  border-radius: 0.4rem;
}
</style>
</head>
<body>""")

for path in sorted(Path.cwd().glob("*.css")):
    colors = read_colors(path)

    if colors is None:
        print(path.name, file=sys.stderr)
        continue

    background, color = colors

    print(
        f'<div class="theme" '
        f'style="background: {escape(background, quote=True)}; '
        f'color: {escape(color, quote=True)}">'
        f'{escape(path.name.upper().replace("-", "_"))}</div>'
    )

print("</body>\n</html>")
