CARROUT_COUNT = 5;
BUG_COUNT = 3;
GAME_DURATION = 3;

CARROT_SIZE = 80;

const gameBtn = document.querySelector('.game__button');
const gameField = document.querySelector('.game__field');
const gameTimer = document.querySelector('.game__timer');
const gameScore = document.querySelector('.game__score');
const gamePoint = document.querySelector('.game__point');

let started = false;
let timer;
let score = 0;
let point = 0;

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
    showStopBtn();
    showTimerAndScore();
};

function startTimer() {
    let time = GAME_DURATION;
    updateTimer(time);
    timer = setInterval(() => {
        time--;
        updateTimer(time);
        if (time <= 0) {
            clearInterval(timer);
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

function initGame() {
    gameScore.innerText = CARROUT_COUNT;
    addItem(CARROUT_COUNT, 'carrot', 'img/carrot.png');
    addItem(BUG_COUNT, 'bug', 'img/bug.png');
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
    const icon = gameBtn.querySelector('.fas');
    icon.classList.remove('fa-play');
    icon.classList.add('fa-stop');
};

function showTimerAndScore() {
    gameTimer.style.visibility = 'visible';
    gameScore.style.visibility = 'visible';
};