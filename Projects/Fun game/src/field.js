'use strict';

const CARROT_SIZE = 80;

export const ItemType = Object.freeze({
    carrot: 'carrot',
    bug: 'bug',
});

export class Field {
    constructor(carrotCount, bugCount) {
        this.INIT_CARROTCOUNT = carrotCount;
        this.INIT_BUGCOUNT = bugCount;

        this.field = document.querySelector('.game__field');
        this.fieldRect = this.field.getBoundingClientRect();
        this.field.addEventListener('click', this.onClick);
    };

    setClickListener(onItemClick) {
        this.onItemClick = onItemClick;
    };

    onClick = (event) => {
        const target = event.target;
        if (target.matches('.carrot')) {
            target.remove();
            this.onItemClick && this.onItemClick(ItemType.carrot);
        } else if (target.matches('.bug')) {
            this.onItemClick && this.onItemClick(ItemType.bug);
        };
    };

    _addItem(className, count, imgPath) {
        const x1 = 0;
        const y1 = 0;
        const x2 = this.fieldRect.width - CARROT_SIZE;
        const y2 = this.fieldRect.height - CARROT_SIZE;
        for (let i = 0; i < count; i++) {
            const item = document.createElement('img');
            item.setAttribute('class', className);
            item.setAttribute('src', imgPath);
            item.style.position = 'absolute';
            const x = randomNumber(x1, x2);
            const y = randomNumber(y1, y2);
            item.style.left = `${x}px`;
            item.style.top = `${y}px`;
            this.field.appendChild(item);
        };
    };
        
    init() {
        this.field.innerHTML = '';
        this._addItem('carrot', this.INIT_CARROTCOUNT, 'img/carrot.png');
        this._addItem('bug', this.INIT_BUGCOUNT, 'img/bug.png');
    };

    nextStage(carrotCount, bugCount) {
        this.field.innerHTML = '';
        this._addItem('carrot', carrotCount, 'img/carrot.png');
        this._addItem('bug', bugCount, 'img/bug.png');
    }
};

function randomNumber(min, max) {
  return Math.random() * (max - min) + min;
};