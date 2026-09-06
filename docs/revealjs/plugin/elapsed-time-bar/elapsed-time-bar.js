var ElapsedTimeBar = (function () {
    "use strict"

    let deck;
    let barColor = 'rgb( 254,93,77)';
    let pausedBarColor = 'rgba(0,255,0,.6)';
    let progressBarHeight = 3;

    let isPaused = false;
    let isFinished = false;

    let allowedTime = null; // in milliseconds
    let timeProgressBar = null;
    let startTime = null;
    let pauseTime = null;
    let pauseTimeDuration = 0;
    let timeProgressContainer = null;

    function handleReady() {
        const config = deck.getConfig().elapsedTimeBar || {};

        // allowedTime can be in elapsedTimeBar object or directly in config (backward compatibility)
        // expected in minutes
        let allowedTimeInMinutes = config.allowedTime || deck.getConfig().allowedTime;

        if (!allowedTimeInMinutes) {
            console.warn('Failed to start ElapsedTimeBar plugin. "allowedTime" property is required.');
            return;
        }

        allowedTime = allowedTimeInMinutes * 60 * 1000;
        barColor = config.barColor || deck.getConfig().barColor || barColor;
        pausedBarColor = config.pausedBarColor || deck.getConfig().pausedBarColor || pausedBarColor;
        progressBarHeight = config.progressBarHeight || deck.getConfig().progressBarHeight || progressBarHeight;

        let timeBarHeight = progressBarHeight + 'px';
        let pageProgressHeight = '0px';

        let pageProgressContainer = document.querySelector('.progress');

        if (pageProgressContainer && deck.getConfig().progress) {
            pageProgressHeight = pageProgressContainer.getBoundingClientRect().height + 'px';
        }

        timeProgressContainer = document.createElement('div');
        timeProgressContainer.classList.add('progress', 'elapsed-time-progress');

        Object.assign(timeProgressContainer.style, {
            display: 'block',
            position: 'fixed',
            width: '100%',
            height: progressBarHeight + 'px'
        });
        document.querySelector('.reveal').appendChild(timeProgressContainer);

        updatePosition();

        // create content of time-progress
        timeProgressBar = document.createElement('div');
        Object.assign(timeProgressBar.style, {
            height: '100%',
            willChange: 'width'
        });
        timeProgressContainer.appendChild(timeProgressBar);

        // start timer
        start(allowedTime);
    }

    function updatePosition() {
        const pageProgressContainer =
            document.querySelector('.progress:not(.elapsed-time-progress)');

        timeProgressContainer.style.bottom =
            pageProgressContainer
                ? pageProgressContainer.getBoundingClientRect().height + 'px'
                : '0px';
    }

    function loop() {
        if (isPaused) return;
        const now = +new Date();
        const elapsedTime = now - startTime - pauseTimeDuration;
        if (elapsedTime > allowedTime) {
            timeProgressBar.style.width = '100%';
            isFinished = true;
        } else {
            timeProgressBar.style.width = (elapsedTime / allowedTime * 100) + '%';
            requestAnimationFrame(loop);
        }
    }

    function setBarColor() {
        if (timeProgressBar) {
            timeProgressBar.style.backgroundColor = isPaused ? pausedBarColor : barColor;
        }
    }

    function start(newallowedTime, elapsedTime = 0) {
        isFinished = false;
        isPaused = false;
        allowedTime = newallowedTime;
        startTime = +new Date() - elapsedTime;
        pauseTimeDuration = 0;
        setBarColor();
        loop();
    }

    function pause() {
        if (isPaused) return;
        isPaused = true;
        pauseTime = +new Date();
        setBarColor();
    }

    function resume() {
        if (!isPaused) return;
        isPaused = false;
        pauseTimeDuration += new Date() - pauseTime;
        pauseTime = null;
        setBarColor();
        loop();
    }

    function reset() {
        const progress = deck.getProgress();
        const elapsedTime = allowedTime * progress;
        start(allowedTime, elapsedTime);
    }

    return {
        id: 'elapsed-time-bar',
        init: function (reveal) {
            deck = reveal;
            deck.on('slidechanged', updatePosition);

            if (deck.isReady()) {
                handleReady();
            } else {
                deck.on('ready', () => handleReady());
            }

            deck.addKeyBinding({
                keyCode: 84,
                key: 'T',
                description: 'Pause/Resume Elapsed Time Bar'
            }, () => {
                isPaused ? resume() : pause();
            });

            deck.addKeyBinding({
                keyCode: 82,
                key: 'R',
                description: 'Reset Elapsed Time Bar'
            }, () => {
                reset();
            });
        },
        pause: pause,
        resume: resume,
        reset: reset,
        start: start,
        get isPaused() {
            return isPaused;
        },
        get isFinished() {
            return isFinished;
        }
    };
})();
