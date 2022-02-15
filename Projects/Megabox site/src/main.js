'use strict'

// 영화 탭 메뉴

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

// 공지사항 탭 메뉴

const tabMenu = $('.notice');
tabMenu.find('ul > li > ul').hide();
tabMenu.find('li.active > ul').show();

function tabList(e) {
    e.preventDefault();
    const target = $(this);
    target.next().show().parent('li').addClass('active').siblings('li').removeClass('active').find('ul').hide();
}

tabMenu.find('ul > li > a').click(tabList).focus(tabList);