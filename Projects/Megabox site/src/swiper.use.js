const swiper = new Swiper('.swiper-container', {
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
    pagination: {
    el: '.swiper-pagination',
    type: 'bullets',
    },
    autoplay: {
   delay: 3000,
 },
});
// 배너 이미지 슬라이드

const swipe2 = new Swiper('.swiper-container2', {
    slidesPerView: 4,
    spaceBetween: 24,
    mousewheel: {
        invert: true,
    },
    keyboard: {
        enabled: true,
        onlyInViewport: false,
    },
    autoplay: {
        delay: 5000,
    },
});
// 영화차트 이미지 슬라이드