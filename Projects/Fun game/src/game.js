'use strict';

import { Field, ItemType } from './field.js';
import * as sound from './sound.js';

export const Reason = Object.freeze({
    cancel: 'cancel',
    win: 'win',
    lose: 'lose',
});

export class gameBuilder {
    withGameDuratiom(duration) {
        this.gameDuration = duration;
        return this;
    };

    withCarrotCount(num) {
        this.carrotCount = num;
        return this;
    };

    withBugCount(num) {
        this.bugCount = num;
        return this;
    };

    withLevel(num) {
        this.level = num;
        return this;
    };

    build() {
        return new Game(
            this.gameDuration,
            this.carrotCount,
            this.bugCount,
            this.level
        );
    };
};

class Game {
    constructor(gameDuration, carrotCount, bugCount, level) {
        this.INIT_DURATION = gameDuration;
        this.INIT_CARROTCOUNT = carrotCount;
        this.INIT_BUGCOUNT = bugCount;
        
        this.gameDuration = gameDuration;
        this.carrotCount = carrotCount;
        this.bugCount = bugCount;
        this.level = level;

        this.started = false;
        this.point = 0;
        this.score = 0;
        this.timer = undefined;

        this.timerIndicator = document.querySelector('.game__timer');
        this.gamePoint = document.querySelector('.game__point');
        this.gameScore = document.querySelector('.game__score');
        this.gameBtn = document.querySelector('.game__button');
        this.gameBtn.addEventListener('click', () => {
            if (this.started) {
                this.stop(Reason.cancel);
            } else {
                this.start();
            };
        });
        
        this.gameField = new Field(this.INIT_CARROTCOUNT, this.INIT_BUGCOUNT);
        this.gameField.setClickListener(this.onItemClick);
    };
        
    onItemClick = (item) => {
        if (!this.started) {
            return;
        };
        if (item === ItemType.carrot) {
            this.score++;
            this.updateScoreBoard();
            this.point++
            this.updatePointBoard();
            sound.playCarrot();
            if (this.score === this.carrotCount) {
                this.stop(Reason.win, this.point);
            };
        } else if (item === ItemType.bug) {
            this.stop(Reason.lose, this.point);
        };
    };

    setGameStopListener(onGameStop) {
        this.onGameStop = onGameStop;
    };

    start() {
        this.started = true;
        this.startGameTimer();
        this.showStopButton();
        this.showTimerAndScore();
        this.initGame();
        sound.playBackground();
    };

    nextGame() {
        this.started = true;
        this.score = 0;
        this.gameDuration++;
        this.carrotCount = this.carrotCount + this.level;
        this.bugCount = this.bugCount + this.level;
        this.gameScore.innerText = this.carrotCount;
        this.startGameTimer();
        this.showStopButton();
        this.gameField.nextStage(this.carrotCount, this.bugCount);
        sound.playBackground();
    };

    stop(reason, point) {
        this.started = false;
        this.stopGameTimer();
        this.hideGameButton();
        this.onGameStop && this.onGameStop(reason, point);
        if (reason === Reason.cancel || reason === Reason.lose) {
            this.resetValue();
        };
        sound.stopBackground();
    };

    resetValue() {
        this.point = 0;
        this.gameDuration = this.INIT_DURATION;
        this.carrotCount = this.INIT_CARROTCOUNT;
        this.bugCount = this.INIT_BUGCOUNT;
        this.gamePoint.innerText = this.point;
    };

    showStopButton() {
        const icon = this.gameBtn.querySelector('.fas');
        icon.classList.add('fa-stop');
        icon.classList.remove('fa-play');
        this.gameBtn.style.visibility = 'visible';
    };

    hideGameButton() {
        this.gameBtn.style.visibility = 'hidden';
    };

    showTimerAndScore() {
        this.timerIndicator.style.visibility = 'visible';
        this.gameScore.style.visibility = 'visible';
    };

    startGameTimer() {
        let remainingTimeSec = this.gameDuration;
        this.updateTimerText(remainingTimeSec);
        this.timer = setInterval(() => {
            this.updateTimerText(--remainingTimeSec);
            if (remainingTimeSec <= 0) {
                clearInterval(this.timer);
                this.stop(this.score === this.carrotCount ? Reason.win : Reason.lose, this.point);
                return;
            };
        }, 1000);
    };

    stopGameTimer() {
        clearInterval(this.timer);
    };

    updateTimerText(time) {
        const minutes = Math.floor(time / 60);
        const seconds = time % 60;
        this.timerIndicator.innerHTML = `${minutes}:${seconds}`;
    };

    initGame() {
        this.score = 0;
        this.gameScore.innerText = this.carrotCount;
        this.gameField.init();
    };

    updateScoreBoard() {
        this.gameScore.innerText = this.carrotCount - this.score;
    };

    updatePointBoard() {
        this.gamePoint.innerText = this.point;
    };
};