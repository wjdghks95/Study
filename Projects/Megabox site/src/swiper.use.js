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

const swiper1 = new Swiper('.swiper-container2', {
    slidesPerView: 4,
    spaceBetween: 24,
    observer: true,
    observeParents: true,
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
     breakpoints: {
    600: {
      slidesPerView: 1.7,
      spaceBetween: 24
    },
    768: {
      slidesPerView: 2,
      spaceBetween: 24
    },
    960: {
      slidesPerView: 3,
      spaceBetween: 24
      },
  }
});
// 영화차트 이미지 슬라이드