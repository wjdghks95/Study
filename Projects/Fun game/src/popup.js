export default class Popup {
    constructor () {
        this.popUp = document.querySelector('.pop-up');
        this.popUpText = document.querySelector('.pop-up__message');
        this.popUpRefresh = document.querySelector('.pop-up__refreshBtn');
        this.popUpIcon = this.popUpRefresh.querySelector('.fas');
        this.popUpRefresh.addEventListener('click', () => {
            if (this.popUpIcon.classList.contains('fa-redo')) {
                this.onStart && this.onStart();
            } else if (this.popUpIcon.classList.contains('fa-forward')) {
                this.onNext && this.onNext();
            };
        });
    }

    onClickListener(onStart, onNext) {
        this.onStart = onStart;
        this.onNext = onNext;
    };
    

    showWithText(text) {
        this.popUp.classList.remove('pop-up--hide');
        this.popUpText.innerText = text;
    };

    hide() {
        this.popUp.classList.add('pop-up--hide');
    };

    showForwardBtn() {
        const icon = this.popUpRefresh.querySelector('.fas');
        icon.classList.remove('fa-redo');
        icon.classList.add('fa-forward');
    };

    showRefreshBtn() {
        const icon = this.popUpRefresh.querySelector('.fas');
        icon.classList.add('fa-redo');
        icon.classList.remove('fa-forward');
    };
}