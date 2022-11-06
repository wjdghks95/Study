// viewerButton
let viewerBtns = document.querySelectorAll('.viewer-btn');
let contents = document.querySelectorAll('.category__content');

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

// category
const category = document.querySelector(".category__list");
const categoryBtns = document.querySelectorAll(".category-btn");

category.addEventListener("click", (e) => {
    const target = e.target.tagName === "BUTTON" ? e.target : null;

    categoryBtns.forEach(categoryBtn => {
        categoryBtn.classList.remove("active");
    });

    target.classList.add("active");

    if(target !== null) {
        const categoryVal = target.value = target.value;
        const xhr = new XMLHttpRequest();
        xhr.open("GET", `/contents?category=${categoryVal}`, true);
        xhr.send();
        xhr.onload = (data) => {
            const content = document.querySelector("#category-article");
            content.innerHTML = data.target.response;

            viewerBtns = document.querySelectorAll('.viewer-btn');
            contents = document.querySelectorAll('.category__content');
        }
    }
})