'use strict'

import PopUp from './popup.js';
import Field from './field.js';

const CARROT_COUNT = 3;
const BUG_COUNT = 1;
const INIT_GAME_DURATION = 3;

let GAME_DURATION = INIT_GAME_DURATION;


const gameBtn = document.querySelector('.game__button');
const gameTimer = document.querySelector('.game__timer');
const gameScore = document.querySelector('.game__score');
const gamePoint = document.querySelector('.game__point');

const bgSound = new Audio('sound/bg.mp3');
const alertSound = new Audio('sound/alert.wav');
const bugSound = new Audio('sound/bug_pull.mp3');
const carrotSound = new Audio('sound/carrot_pull.mp3');
const winSound = new Audio('sound/game_win.mp3');
let started = false;
let timer;
let score = 0;
let point = 0;

const gameFinishBanner = new PopUp();
gameFinishBanner.onClickListener(() => {
    startGame()
}, () => {
    nextGame();
});

const gameField = new Field(CARROT_COUNT, BUG_COUNT);
gameField.setClickListener(onItemClick)

function onItemClick(item) {
    if (started === false) {
        return;
    };
    if (item === 'carrot') {
        score++;
        updateScore();
        point++;
        updatePoint();
        carrotSound.play();
        carrotSound.currentTime = 0;
        if (score === CARROT_COUNT) {
            clearGame();
        };
    } else if (item ==='bug') {
        bugSound.play();
        finishGame();
    };
};

function updateScore() {
    gameScore.innerText = CARROT_COUNT - score;
};

function updatePoint() {
    gamePoint.innerText = point;
};

gameBtn.addEventListener('click', () => {
    if (started === true) {
        stopGame();
    };
    if (started === false) {
        startGame();
    };
});

function startGame() {
    started = true;
    initGame();
    startTimer();
    updatePoint();
    showStopBtn();
    showTimerAndScore();
    bgSound.play();
    bgSound.currentTime = 0;
};

function nextGame() {
    started = true;
    GAME_DURATION++;
    gameField.innerText = '';
    gameScore.innerText = CARROT_COUNT;
    startTimer();
    showStopBtn();
    score = 0;
    gameField.nextStage();
    gameFinishBanner.hide();
    bgSound.play();
    bgSound.currentTime = 0;
};

function clearGame() {
    started = false;
    stopTimer();
    hideStopBtn();
    gameFinishBanner.showWithText('Next Game');
    gameFinishBanner.showForwardBtn();
    winSound.play();
    bgSound.pause();
};

function stopGame() {
    started = true;
    stopTimer();
    hideStopBtn();
    gameFinishBanner.showWithText('REPLAY ?');
    gameFinishBanner.showRefreshBtn();
    alertSound.play();
    bgSound.pause();
};

function finishGame() {
    started = false;
    stopTimer();
    hideStopBtn();
    gameFinishBanner.showWithText(`${point}점`);
    gameFinishBanner.showRefreshBtn();
    bugSound.play();
    bgSound.pause();
};

function startTimer() {
    let time = GAME_DURATION;
    updateTimer(time);
    timer = setInterval(() => {
        time--;
        updateTimer(time);
        if (time <= 0) {
            finishGame();
            gameTimer.innerText = 'Game over';
            gameTimer.style.fontSize = 'var(--font-medium)';
        };
    }, 1000);
};

function updateTimer(time) {
    let min = Math.floor(time / 60);
    let sec = time % 60;
    gameTimer.innerText = `${min}:${sec}`;
};

function stopTimer() {
    clearInterval(timer);
};

function showStopBtn() {
    gameBtn.style.visibility = 'visible';
    const icon = gameBtn.querySelector('.fas');
    icon.classList.remove('fa-play');
    icon.classList.add('fa-stop');
};

function hideStopBtn() {
    gameBtn.style.visibility = 'hidden';
};

function showTimerAndScore() {
    gameTimer.style.visibility = 'visible';
    gameScore.style.visibility = 'visible';
};

function initGame() {
    GAME_DURATION = INIT_GAME_DURATION;
    gameScore.innerText = CARROT_COUNT;
    score = 0;
    point = 0;
    gameField.init();
    gameFinishBanner.hide();
    gameTimer.style.fontSize = 'calc(var(--font-large) * 1.2)';
};
