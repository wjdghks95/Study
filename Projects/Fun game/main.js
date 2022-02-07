CARROUT_COUNT = 5;
BUG_COUNT = 3;
GAME_DURATION = 3;

CARROT_SIZE = 80;

const gameBtn = document.querySelector('.game__button');
const gameField = document.querySelector('.game__field');
const gameTimer = document.querySelector('.game__timer');
const gameScore = document.querySelector('.game__score');
const gamePoint = document.querySelector('.game__point');

const popUp = document.querySelector('.pop-up');
const popUpText = document.querySelector('.pop-up__message');
const popUpRefresh = document.querySelector('.pop-up__refreshBtn');

let started = false;
let timer;
let score = 0;
let point = 0;

popUpRefresh.addEventListener('click', () => {
    startGame();
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
    } else if (target.matches('.bug')) {
        finishGame();
    };
};

function updateScore() {
    gameScore.innerText = CARROUT_COUNT - score;
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
    startTimer();
    initGame();
    updatePoint();
    showStopBtn();
    showTimerAndScore();
};

function finishGame() {
    started = false;
    stopTimer();
    hideStopBtn();
    showPopUpWithText(`${point}점`);
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
    gameField.innerText = '';
    gameScore.innerText = CARROUT_COUNT;
    score = 0;
    point = 0;
    addItem(CARROUT_COUNT, 'carrot', 'img/carrot.png');
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