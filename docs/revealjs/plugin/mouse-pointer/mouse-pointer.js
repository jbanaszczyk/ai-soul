var MousePointer = (function () {
    "use strict"

    const radius = 50

    const initial_css = {
        position: 'absolute',
        float: 'left',
        borderRadius: '50%',
        width: (radius * 2) + 'px',
        height: (radius * 2) + 'px',
        backgroundColor: 'rgba(255, 0, 0, 0.4)',
        zIndex: 20,
        display: 'none',
        pointerEvents: 'none'
    }

    let toggleBind = false
    let tail = null
    let mouseX = window.innerWidth / 2
    let mouseY = window.innerHeight / 2

    function mouse_pointing(e) {
        mouseX = e.pageX
        mouseY = e.pageY
        if (toggleBind) {
            update_position()
        }
    }

    function update_position() {
        if (tail) {
            tail.style.left = mouseX - radius + 'px'
            tail.style.top = mouseY - radius + 'px'
        }
    }

    function toggleMousePointer() {
        if (!tail) return
        if (!toggleBind) {
            tail.style.display = 'none'
            document.body.style.cursor = 'auto'
        } else {
            tail.style.display = 'block'
            update_position()
            document.body.style.cursor = 'none'
        }
    }

    return {
        id: 'mouse-pointer',
        init: function (deck) {
            tail = document.createElement('div')
            Object.assign(tail.style, initial_css)
            document.body.appendChild(tail)

            document.addEventListener('mousemove', mouse_pointing)

            deck.addKeyBinding({
                keyCode: 90,
                key: 'Z',
                description: 'Toggle Mouse Pointer'
            }, function () {
                toggleBind = !toggleBind
                toggleMousePointer()
            })
        }
    }
})();
