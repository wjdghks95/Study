INIT_CARROT_COUNT = 3;
INIT_BUG_COUNT = 1;
INIT_GAME_DURATION = 3;

CARROT_COUNT = INIT_CARROT_COUNT;
BUG_COUNT = INIT_BUG_COUNT;
GAME_DURATION = INIT_GAME_DURATION;

CARROT_SIZE = 80;

const gameBtn = document.querySelector('.game__button');
const gameField = document.querySelector('.game__field');
const gameTimer = document.querySelector('.game__timer');
const gameScore = document.querySelector('.game__score');
const gamePoint = document.querySelector('.game__point');

const popUp = document.querySelector('.pop-up');
const popUpText = document.querySelector('.pop-up__message');
const popUpRefresh = document.querySelector('.pop-up__refreshBtn');
const popUpIcon = popUpRefresh.querySelector('.fas');

const bgSound = new Audio('sound/bg.mp3');
const alertSound = new Audio('sound/alert.wav');
const bugSound = new Audio('sound/bug_pull.mp3');
const carrotSound = new Audio('sound/carrot_pull.mp3');
const winSound = new Audio('sound/game_win.mp3');


let started = false;
let timer;
let score = 0;
let point = 0;

popUpRefresh.addEventListener('click', () => {
    if (popUpIcon.classList.contains('fa-redo')) {
        startGame();
    } else if (popUpIcon.classList.contains('fa-forward')) {
        nextGame();
    };
});

gameField.addEventListener('click', onItemClick);

function onItemClick(event) {
    if (started === false) {
        return;
    };
    const target = event.target;
    if (target.matches('.carrot')) {
        target.remove();
        score++;
        updateScore();
        point++;
        updatePoint();
        carrotSound.play();
        carrotSound.currentTime = 0;
        if (score === CARROT_COUNT) {
            clearGame();
        };
    } else if (target.matches('.bug')) {
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
    CARROT_COUNT++;
    BUG_COUNT++;
    gameField.innerText = '';
    gameScore.innerText = CARROT_COUNT;
    startTimer();
    showStopBtn();
    score = 0;
    addItem(CARROT_COUNT, 'carrot', 'img/carrot.png');
    addItem(BUG_COUNT, 'bug', 'img/bug.png');
    hidePopUp();
    bgSound.play();
    bgSound.currentTime = 0;
};

function clearGame() {
    started = false;
    stopTimer();
    hideStopBtn();
    showPopUpWithText(`Next Game`);
    showPopUpForwardBtn();
    winSound.play();
    bgSound.pause();
};

function stopGame() {
    started = true;
    stopTimer();
    hideStopBtn();
    showPopUpWithText(`REPLAY ?`);
    showPopUpRefreshBtn();
    alertSound.play();
    bgSound.pause();
};

function finishGame() {
    started = false;
    stopTimer();
    hideStopBtn();
    showPopUpWithText(`${point}점`);
    showPopUpRefreshBtn();
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

function initGame() {
    CARROT_COUNT = INIT_CARROT_COUNT;
    BUG_COUNT = INIT_BUG_COUNT;
    GAME_DURATION = INIT_GAME_DURATION;
    gameField.innerText = '';
    gameScore.innerText = CARROT_COUNT;
    score = 0;
    point = 0;
    addItem(CARROT_COUNT, 'carrot', 'img/carrot.png');
    addItem(BUG_COUNT, 'bug', 'img/bug.png');
    hidePopUp();
    gameTimer.style.fontSize = 'calc(var(--font-large) * 1.2)';
};

function addItem(count, className, imgPath) {
    const gameFieldRect = gameField.getBoundingClientRect();
    const x1 = 0;
    const x2 = gameFieldRect.width -CARROT_SIZE;
    const y1 = 0;
    const y2 = gameFieldRect.height -CARROT_SIZE;

    for (let i = 1; i <= count; i++) {
        const item = document.createElement('img');
        item.setAttribute('class', className);
        item.setAttribute('src', imgPath);
        
        const x = getRandomNumber(x1, x2);
        const y = getRandomNumber(y1, y2);

        item.style.left = `${x}px`;
        item.style.top = `${y}px`;
        gameField.appendChild(item);
    };
};

function getRandomNumber(min, max) {
    return Math.random() * (max - min) + min;
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

function showPopUpWithText(text) {
    popUp.classList.remove('pop-up--hide');
    popUpText.innerText = text;
};

function hidePopUp() {
    popUp.classList.add('pop-up--hide');
};

function showPopUpForwardBtn() {
    const icon = popUpRefresh.querySelector('.fas');
    icon.classList.remove('fa-redo');
    icon.classList.add('fa-forward');
};

function showPopUpRefreshBtn() {
    const icon = popUpRefresh.querySelector('.fas');
    icon.classList.add('fa-redo');
    icon.classList.remove('fa-forward');
};