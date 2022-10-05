// tagButton
const tagBtn = document.querySelector('.tag-btn');
const tag = document.querySelector('.tag-swiper');
tagBtn.addEventListener('click', () => {
    tagBtn.classList.toggle('active');
    
    if (tagBtn.classList.contains('active')) {
        tag.style.display = "block";
        tagBtn.style.position = "absolute";
    } else {
        tag.style.display = "none";
        tagBtn.style.position = "static";
    }
})