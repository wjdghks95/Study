new Swiper('.best-review-swiper', {
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

new Swiper(".category-swiper", {
    slidesPerView: 10,    
    touchRatio: 0,
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

new Swiper(".tag-swiper", {
    slidesPerView: 5, 
    loop: true,
    loopAdditionalSlides : 1,

    touchRatio: 1,
    speed: 3000,

    observer: true,
    observeParents: true,
    autoplayDisableOnInteraction: false,

    autoplay: {
        delay: 0,
        disableOnInteraction: false
    },
});

new Swiper(".photo-swiper", {
    touchRatio: 0,
    observer: true,
    observeParents: true,

    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});