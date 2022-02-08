'use strict'

import PopUp from './popup.js';
import Game from './game.js';

const CARROT_COUNT = 3;
const BUG_COUNT = 1;
const GAME_DURATION = 3;

const bgSound = new Audio('sound/bg.mp3');
const alertSound = new Audio('sound/alert.wav');
const bugSound = new Audio('sound/bug_pull.mp3');
const carrotSound = new Audio('sound/carrot_pull.mp3');
const winSound = new Audio('sound/game_win.mp3');

const game = new Game(CARROT_COUNT, BUG_COUNT, GAME_DURATION);
game.setGameStopListener((reason, point) => {
    let message;
    switch (reason) {
        case 'win':
            message = 'NEXT GAME';
            gameFinishBanner.showForwardBtn();
            break;
        case 'lose':
            message = `${point}점`;
            gameFinishBanner.showRefreshBtn();
            break;
        case 'cancel':
            message = 'REPLAY ?';
            gameFinishBanner.showRefreshBtn();
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
