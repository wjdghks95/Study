// viewerButton
const viewerBtns = document.querySelectorAll('.viewer-btn');
const contents = document.querySelectorAll('.category__content');

viewerBtns.forEach(viewerBtn => {
    viewerBtn.addEventListener('click', () => {
        viewerBtns.forEach(viewerBtn => {
            viewerBtn.classList.remove('active');
        })
        viewerBtn.classList.add('active');
        
        if(viewerBtns[0].classList.contains('active')) {
            contents[0].style.display = 'flex';
        } else {
            contents[0].style.display = 'none';
        }
        
        if(viewerBtns[1].classList.contains('active')) {
            contents[1].style.display = 'table';
        } else {
            contents[1].style.display = 'none';
        }

        if(viewerBtns[2].classList.contains('active')) {
            contents[2].style.display = 'flex';
        } else {
            contents[2].style.display = 'none';
        }
    })
})

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
