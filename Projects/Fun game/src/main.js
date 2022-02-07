'use strict';

import { gameBuilder, Reason } from './game.js';
import Popup from './popup.js';
import * as sound from './sound.js';

const gameFinishBanner = new Popup();
gameFinishBanner.onClickStartListener(() => {
    game.start();
});
gameFinishBanner.onClickNextGameListener(() => {
    game.nextGame();
});

const game = new gameBuilder()
    .withGameDuratiom(5)
    .withCarrotCount(3)
    .withBugCount(1)
    .withLevel(2)
    .build();

game.setGameStopListener((reason, point) => {
    let message;
    switch (reason) {
        case Reason.cancel:
            message = 'REPLAY❓';
            gameFinishBanner.createRedo();
            sound.playAlert();
        break;
        case Reason.win:
            message = 'NEXT STAGE 🎉';
            gameFinishBanner.createForward();
            sound.playWin();
        break;
        case Reason.lose:
            message = `💩${point}점💩`;
            gameFinishBanner.createRedo();
            sound.playBug();
        break;
        default:
            throw new Error('Error');
    };
    gameFinishBanner.showWithText(message);
});