const fadeSwiper = new Swiper('.fade-swiper', {
    // Optional parameters
    spaceBetween: 30,
    effect: "fade",
	fadeEffect: {
		crossFade: true,
	},
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

const slideSwiper2 = new Swiper(".slide-swiper2", {
    slidesPerView: 5,    
    touchRatio: 1,
    freeMode: true,
    speed: 5000,

    loop: true,
    loopAdditionalSlides : 1,

    autoplay: {
        delay: 0,
        disableOnInteraction: true,
    },
    observer: true,
    observeParents: true,
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