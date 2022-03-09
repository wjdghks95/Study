'use strict';
import Popup from './popup.js';
import * as sound from './sound.js';
import { GameBuilder, Reason } from './game.js';

const gameFinishBanner = new Popup();

const game = new GameBuilder()
    .withGameDuration(5)
    .withCarrotCount(3)
    .withBugCount(3)
    .build();

game.setGameStopListener((reason) => {
    let message;
    switch (reason) {
        case Reason.cancel:
            message = 'Replay ?';
            sound.playAlert();
            break;
        case Reason.win:
            message = 'YOU WON';
            sound.playwin();
            break;
        case Reason.lose:
            message = 'YOU LOST';
            sound.playBug();
            break;
        default:
            throw new Error('not valid reason');
    };
    gameFinishBanner.showWithText(message);
});

gameFinishBanner.setClickListener(() => {
    game.start();
});