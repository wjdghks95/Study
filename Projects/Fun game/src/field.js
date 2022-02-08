'use strict'

const CARROT_SIZE = 80;

export default class Field {
    constructor(carrotCount, bugCount) {
        this.init_carrotCount = carrotCount;
        this.init_bugCount = bugCount;

        this.gameField = document.querySelector('.game__field');
        this.gameField.addEventListener('click', this.onClick);
    }

    setClickListener(onItemClick) {
        this.onItemClick = onItemClick;
    };

    onClick = (event) => {
        const target = event.target;
        if (target.matches('.carrot')) {
            target.remove();
            this.onItemClick && this.onItemClick('carrot');
        } else if (target.matches('.bug')) {
            this.onItemClick && this.onItemClick('bug');
        };
    };

    init() {
        this.carrotCount = this.init_CarrotCount;
        this.bugCount = this.init_BugCount;
        this.gameField.innerText = '';
        this._addItem(this.init_carrotCount, 'carrot', 'img/carrot.png');
        this._addItem(this.init_bugCount, 'bug', 'img/bug.png');
    };
    
    nextStage(carrotCount, bugCount) {
        this.gameField.innerText = '';
        this._addItem(carrotCount, 'carrot', 'img/carrot.png');
        this._addItem(bugCount, 'bug', 'img/bug.png');
    };

    _addItem(count, className, imgPath) {
        const gameFieldRect = this.gameField.getBoundingClientRect();
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
            this.gameField.appendChild(item);
        };
    };
}

function getRandomNumber(min, max) {
    return Math.random() * (max - min) + min;
};