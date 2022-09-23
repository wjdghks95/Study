const fadeSwiper = new Swiper('.fade-swiper', {
    // Optional parameters
    spaceBetween: 30,
    effect: "fade",
    loop: true,

    autoplay: {
        delay: 2500,
        disableOnInteraction: false,
    },

    // If we need pagination
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    }
});

const slideSwiper = new Swiper(".slide-swiper", {
    slidesPerView: 10,    
    touchRatio: 0,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

const singleSlideSwiper = new Swiper(".single-slide-swiper", {
    touchRatio: 0,
    observer: true,
    observeParents: true,

    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});