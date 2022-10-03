export default class Rating {

    constructor() {
        this.stars = document.querySelectorAll('.rating__star');
        this.totalStar = 0;
    }

    onEventListener() {
        this.stars.forEach((star, index) => {
            star.dataset.rating = index + 1;
            star.addEventListener('mouseover', this._onMouseOver);
            star.addEventListener('click', this._onClick);
            star.addEventListener('mouseleave', this._onMouseLeave);
        });
    }

    _fill(ratingVal) {
        for (let i = 0; i < 5; i++) {
            if (i < ratingVal) {
                this.stars[i].querySelector('img').setAttribute('src', '../icon/star-solid.svg');
            } else {
                this.stars[i].querySelector('img').setAttribute('src', '../icon/star-regular.svg');
            }
        }
    }

    _onMouseOver = (e) => {
        const ratingVal = e.currentTarget.dataset.rating;
        if (!ratingVal) {
            return;
        } else {
            this._fill(ratingVal);
        }
    }
    
    _onMouseLeave = (e) => {
        this._fill(this.totalStar);
    }
    
    _onClick = (e) => {
        const ratingVal = e.currentTarget.dataset.rating;
        this.totalStar = ratingVal;
    }
}