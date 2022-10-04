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

