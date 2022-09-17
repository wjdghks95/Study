const swiper = new Swiper('.fade-swiper', {
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