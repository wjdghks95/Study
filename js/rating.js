let stars = document.querySelectorAll('.rating__star');
let totalStar = 0;

stars.forEach((star, index) => {
    star.dataset.rating = index + 1;
    star.addEventListener('mouseover', onMouseOver);
    star.addEventListener('click', onClick);
    star.addEventListener('mouseleave', onMouseLeave);
});

function onMouseOver(e) {
    const ratingVal = e.currentTarget.dataset.rating;
    if (!ratingVal) {
        return;
    } else {
        fill(ratingVal);
    }
}

function fill(ratingVal) {
    for (let i = 0; i < 5; i++) {
        if (i < ratingVal) {
            stars[i].querySelector('img').setAttribute('src', '../icon/star-solid.svg');
        } else {
            stars[i].querySelector('img').setAttribute('src', '../icon/star-regular.svg');
        }
    }
}

function onMouseLeave(e) {
    fill(totalStar);
}

function onClick(e) {
    const ratingVal = e.currentTarget.dataset.rating;
    totalStar = ratingVal;
    fill(totalStar);
}