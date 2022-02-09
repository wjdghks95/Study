'use strict'

import PopUp from './popup.js';
import { gameBuilder, Reason } from './game.js';
import * as sound from './sound.js'

const game = new gameBuilder()
    .withCarrotCount(3)
    .withBugCount(1)
    .withGameDuration(3)
    .build();

game.setGameStopListener((reason, point) => {
    let message;
    switch (reason) {
        case Reason.win:
            message = 'NEXT GAME';
            gameFinishBanner.showForwardBtn();
            sound.playWin();
            break;
        case Reason.lose:
            message = `${point}점`;
            gameFinishBanner.showRefreshBtn();
            sound.playBug();
            break;
        case Reason.cancel:
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
