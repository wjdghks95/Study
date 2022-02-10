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