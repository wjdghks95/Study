'use strict'

const movBtn = $(".movie_title > ul > li");
const movCont = $(".movie_chart > div");

movCont.hide().eq(0).show();

movBtn.click((e) => {
    e.preventDefault();
    const target = $(e.target.parentNode);
    const index = target.index();
    movBtn.removeClass('active');
    target.addClass('active');
    movCont.css('display', 'none');
    movCont.eq(index).css('display', 'block');
});