CARROUT_COUNT = 5;
BUG_COUNT = 3;

CARROT_SIZE = 80;

const gameBtn = document.querySelector('.game__button');
const gameField = document.querySelector('.game__field');

let started = false;

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
    showStopBtn();
};

function initGame() {
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