// tagButton
const tagBtn = document.querySelector('.tag-btn');
const searchTag = document.querySelector('.search-tag');
tagBtn.addEventListener('click', () => {
    searchTag.style.display = 'block';
    tagBtn.style.display = 'none';

    const xBtn = document.querySelector('.x-btn');
    xBtn.addEventListener('click', () => {
        searchTag.style.display = 'none';
        tagBtn.style.display = 'block';
    })
})