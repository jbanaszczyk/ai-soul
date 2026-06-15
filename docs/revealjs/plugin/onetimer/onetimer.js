// onetimer - reveal.js plugin, Only animates fragments once, so that
//            going to a previous slide shows final fragment state(s),
//            rather than tediously stepping through fragments backwards.
//            No one wants to see the same trick twice.

var OneTimer = window.OneTimer || (function () {

    // slide mode (default), or immediate mode if set in Reveal.initialize()
    var immediateMode = false;

    // fragment list: in slide mode, accumulate frags until next page.
    //                in immediate mode, keep track of frags w/ special states
    var fragmentList = [];

    // list of effect style fix-ups, since removing "fragment" hinders other fragment effects
    // 'two step' fragment effects currently not handled, see readme
    const effects = [
        {effect: 'fade-out', style: {prop: 'opacity', value: '0'}},
        {effect: 'semi-fade-out', style: {prop: 'opacity', value: '0.5'}},
        {effect: 'fade-in-then-out', style: {prop: 'opacity', value: '0'}},
        {effect: 'fade-in-then-semi-out', style: {prop: 'opacity', value: '0.5'}},
        {effect: 'grow', style: {prop: 'transform', value: 'scale(1.3)'}},
        {effect: 'shrink', style: {prop: 'transform', value: 'scale(0.7)'}},
        {effect: 'strike', style: {prop: 'text-decoration', value: 'line-through'}},
        {effect: 'highlight-red', style: {prop: 'color', value: '#ff2c2d'}},
        {effect: 'highlight-blue', style: {prop: 'color', value: '#1b91ff'}},
        {effect: 'highlight-green', style: {prop: 'color', value: '#17ff2e'}},
    ]

    // special handling for these fragment extras, when in immediate mode
    // these are 'two-step' extras.
    const special = ['fade-in-then-out', 'fade-in-then-semi-out', 'highlight-current-red', 'highlight-current-blue', 'highlight-current-green'];


    // reveal.js fires 'fragmentshown'/'fragmenthidden' once per group, with only the primary
    // element in event.fragment — sibling fragments sharing the same data-fragment-index are not
    // reported. Re-derive the full group from the DOM so we process every co-revealed element.
    function siblingFragments(frag) {
        var index = frag.getAttribute('data-fragment-index');
        if (index === null) {
            // no explicit index: this element stands on its own
            return [frag];
        }
        var slide = frag.closest('section');
        if (!slide) {
            return [frag];
        }
        var matches = slide.querySelectorAll('[data-fragment-index="' + index + '"]');
        return matches.length ? Array.prototype.slice.call(matches) : [frag];
    }

    function killFragment(frag, force) {

        if (immediateMode && !force) {
            // immediate mode special cases, kludgy state handling..
            // check for special state handling class, if found and not already on fragmentList, add it, and stop
            var isSpecial = special.some(sp => frag.classList.contains(sp));
            if (isSpecial) {
                if (!fragmentList.includes(frag)) {
                    fragmentList.push(frag);
                }
                return;
            } else {
                // apply precessing to all frags on the fragmentList
                if (fragmentList.length > 0) {
                    fragmentList.forEach(f => killFragment(f, true));
                    fragmentList = [];
                }
            }
        }

        // continue with regular handling and fix-ups
        // Use setTimeout to avoid Reveal.js fragment index skipping bug in immediateMode
        setTimeout(() => {
            frag.classList.remove("fragment");

            // apply extra effects to restore the fragment text appearence
            effects.forEach(ef => {
                if (frag.classList.contains(ef.effect)) {
                    frag.style[ef.style.prop] = ef.style.value;
                }
            });
        }, 0);
    }

    return {
        id: 'OneTimer',
        init: (deck) => {

            // check if reveal config object has oneTimer.immediateMode
            var config = Reveal.getConfig();
            if (config && config.oneTimer && config.oneTimer.immediateMode) {
                immediateMode = config.oneTimer.immediateMode;
            }

            // each time we progress to the next slide, remove the "fragment" class from accumlated fragments.
            // and reset the fragmentList to empty
            Reveal.on('slidechanged', event => {
                // event.previousSlide, event.currentSlide, event.indexh, event.indexv
                fragmentList.forEach(frag => killFragment(frag, true));
                fragmentList = [];
            });

            // on each fragment accumulate to apply on slide change, or
            // if immediateMode is true, remove the "fragment" class now.
            Reveal.on('fragmentshown', event => {
                // event.fragment is only the primary element of the group; expand to all siblings
                var frags = siblingFragments(event.fragment);

                if (immediateMode) {
                    frags.forEach(frag => killFragment(frag, false));
                } else {
                    frags.forEach(frag => {
                        if (!fragmentList.includes(frag)) {
                            fragmentList.push(frag);
                        }
                    });
                }
            });

            // if immediateMode is true, remove all "fragment" on fragmenthidden now.
            Reveal.on('fragmenthidden', event => {
                // event.fragment is only the primary element of the group; expand to all siblings
                if (immediateMode) {
                    siblingFragments(event.fragment).forEach(frag => killFragment(frag, true));
                }
            });

        }
    }

})();
