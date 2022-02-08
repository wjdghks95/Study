'use strict'

import PopUp from './popup.js';
import Game from './game.js';
import * as sound from './sound.js'

const CARROT_COUNT = 3;
const BUG_COUNT = 1;
const GAME_DURATION = 3;

const game = new Game(CARROT_COUNT, BUG_COUNT, GAME_DURATION);
game.setGameStopListener((reason, point) => {
    let message;
    switch (reason) {
        case 'win':
            message = 'NEXT GAME';
            gameFinishBanner.showForwardBtn();
            sound.playWin();
            break;
        case 'lose':
            message = `${point}점`;
            gameFinishBanner.showRefreshBtn();
            sound.playBug();
            break;
        case 'cancel':
            message = 'REPLAY ?';
            gameFinishBanner.showRefreshBtn();
            sound.playAlert();
            break;
        default:
            break;
    }
    gameFinishBanner.showWithText(message);
});

const gameFinishBanner = new PopUp();
gameFinishBanner.onClickListener(() => {
    game.start();
}, () => {
    game.next();
});
