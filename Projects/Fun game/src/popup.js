'use strict';

export default class Popup {
    constructor() {
        this.popUp = document.querySelector('.pop-up');
        this.popUpText = document.querySelector('.pop-up__message');
        this.popUpRefresh = document.querySelector('.pop-up__refresh');
        this.popUpIcon = document.querySelector('.pop-up__refresh i');
        this.popUpRefresh.addEventListener('click', () => {
            if (this.popUpIcon.classList.contains('fa-redo')) {
                this.onStart && this.onStart();
            } else if (this.popUpIcon.classList.contains('fa-forward')) {
                this.onNextGame && this.onNextGame();
            };
            this.hide();
        });
    };

    onClickStartListener(onStart) {
        this.onStart = onStart;
    };

    onClickNextGameListener(onNextGame) {
        this.onNextGame = onNextGame;
    };

    createForward() {
        this.popUpIcon.classList.remove('fa-redo');
        this.popUpIcon.classList.add('fa-forward');
    };

    createRedo() {
        this.popUpIcon.classList.add('fa-redo');
        this.popUpIcon.classList.remove('fa-forward');
    };

    showWithText(text) {
        this.popUpText.innerText = text;
        this.popUp.classList.remove('pop-up--hide');
    };

    hide() {
        this.popUp.classList.add('pop-up--hide');
    };
};