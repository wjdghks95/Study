'use strict'

import { Field, ItemType } from './field.js';
import * as sound from './sound.js'

export const Reason = Object.freeze({
    win: 'win',
    lose: 'lose',
    cancel: 'cancel',
});

export class gameBuilder {
    withCarrotCount(num) {
        this.carrotCount = num;
        return this;
    };

    withBugCount(num) {
        this.bugCount = num;
        return this;
    };

    withGameDuration(duration) {
        this.gameDuration = duration;
        return this;
    };

    build() {
        return new Game(
            this.carrotCount,
            this.bugCount,
            this.gameDuration
        )
    };
}

export class Game {
    constructor(carrotCount, bugCount, gameDuration) {
        this.init_carrotCount = carrotCount;
        this.init_bugCount = bugCount;
        this.init_gameDuration = gameDuration;

        this.carrotCount = this.init_carrotCount;
        this.bugCount = this.init_bugCount;
        this.gameDuration = this.init_gameDuration;        
        
        this.started = false;
        this.timer;
        this.score = 0;
        this.point = 0;

        this.gameBtn = document.querySelector('.game__button');
        this.gameTimer = document.querySelector('.game__timer');
        this.gameScore = document.querySelector('.game__score');
        this.gamePoint = document.querySelector('.game__point');
        
        this.gameBtn.addEventListener('click', () => {
            if (this.started === true) {
                this.stop(Reason.cancel);
            } else if (this.started === false) {
                this.start();
            };
        });

        this.gameField = new Field(this.init_carrotCount, this.init_bugCount);
        this.gameField.setClickListener(this.onItemClick)
    }

    start() {
        this.started = true;
        this.initGame();
        this.startTimer();
        this.updatePoint();
        this.showStopBtn();
        this.showTimerAndScore();
        sound.playBackground();
    };

    next() {
        this.started = true;
        this.levelUpGame();
        this.startTimer();
        this.showStopBtn();
        sound.playBackground();
    };

    stop(reason, point) {
        this.started = false;
        this.stopTimer();
        this.hideStopBtn();
        this.onGameStop && this.onGameStop(reason, point);
        sound.stopBackground();
    };

    setGameStopListener(onGameStop) {
        this.onGameStop = onGameStop;
    };

    onItemClick = (item) => {
        if (this.started === false) {
            return;
        };
        if (item === ItemType.carrot) {
            this.score++;
            this.updateScore();
            this.point++;
            this.updatePoint();
            sound.playCarrot();
            if (this.score === this.carrotCount) {
                this.stop(Reason.win);
            };
        } else if (item === ItemType.bug) {
            this.stop(Reason.lose, this.point);
        };
    };

    updateScore() {
        this.gameScore.innerText = this.carrotCount - this.score;
    };

    updatePoint() {
        this.gamePoint.innerText = this.point;
    };

    startTimer() {
        let time = this.gameDuration;
        this.updateTimer(time);
        this.timer = setInterval(() => {
            time--;
            this.updateTimer(time);
            if (time <= 0) {
                this.stop(Reason.lose, this.point);
                this.gameTimer.innerText = 'Game over';
                this.gameTimer.style.fontSize = 'var(--font-medium)';
            };
        }, 1000);
    };

    updateTimer(time) {
        let min = Math.floor(time / 60);
        let sec = time % 60;
        this.gameTimer.innerText = `${min}:${sec}`;
    };

    stopTimer() {
        clearInterval(this.timer);
    };

    showStopBtn() {
        this.gameBtn.style.visibility = 'visible';
        const icon = this.gameBtn.querySelector('.fas');
        icon.classList.remove('fa-play');
        icon.classList.add('fa-stop');
    };

    hideStopBtn() {
        this.gameBtn.style.visibility = 'hidden';
    };

    showTimerAndScore() {
        this.gameTimer.style.visibility = 'visible';
        this.gameScore.style.visibility = 'visible';
    };

    levelUpGame() {
        this.carrotCount++;
        this.bugCount++;
        this.gameDuration++;
        this.gameScore.innerText = this.carrotCount;
        this.score = 0;
        this.gameField.nextStage(this.carrotCount, this.bugCount);
    };

    initGame() {
        this.carrotCount = this.init_carrotCount;
        this.bugCount = this.init_bugCount;
        this.gameDuration = this.init_gameDuration;
        this.gameScore.innerText = this.carrotCount;
        this.score = 0;
        this.point = 0;
        this.gameField.init();
        this.gameTimer.style.fontSize = 'calc(var(--font-large) * 1.2)';
    };
}