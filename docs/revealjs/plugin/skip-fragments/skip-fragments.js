// Press V to View all fragments in current slide
// Press C to hide (Conceal) all fragments in current slide
const SkipFragments = (function () {
    let deck;

    function showAll() {
        let {h, v} = deck.getIndices();
        deck.slide(h, v, +Infinity);
    }
    function hideAll() {
        let {h, v} = deck.getIndices();
        deck.slide(h, v, -1);
    }

    return {
        id: 'SkipFragments',
        init: function (reveal) {
            deck = reveal;
            // Press V to View all fragments in current slide
            deck.addKeyBinding({keyCode: 86, key: 'V', description: 'Slide fragments: show all'}, showAll);
            // Press C to hide (Conceal) all fragments in current slide
            deck.addKeyBinding({keyCode: 67, key: 'C', description: 'Slide fragments: hide all'}, hideAll);
        },
        showAll: showAll,
        hideAll: hideAll
    };

})();
