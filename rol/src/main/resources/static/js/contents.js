// viewerButton
let viewerBtns = document.querySelectorAll('.viewer-btn');
let contents = document.querySelectorAll('.category__content');

viewerBtns.forEach(viewerBtn => {
    viewerBtn.addEventListener('click', () => {
        viewerBtns.forEach(viewerBtn => {
            viewerBtn.classList.remove('active');
        })
        viewerBtn.classList.add('active');

        view(viewerBtns, contents);
    })
})

function view(viewerBtns, contents) {
    for(let i=0; i<viewerBtns.length; i++) {

        if(viewerBtns[i].classList.contains('active')) {
            switch(i) {
                case 0: contents[i].style.display = 'flex';
                break;
                case 1: contents[i].style.display = 'table';
                break;
                case 2: contents[i].style.display = 'flex';
                break;
                default: break;
            }
        } else {
            contents[i].style.display = 'none';
        }
    }
}

// category
const category = document.querySelector(".category__list");
const categoryBtns = document.querySelectorAll(".category-btn");

category.addEventListener("click", (e) => {
    const target = e.target.tagName === "BUTTON" ? e.target : null;

    if(target !== null) {
        categoryBtns.forEach(categoryBtn => {
            categoryBtn.classList.remove("active");
        });

        target.classList.add("active");

        const categoryVal = target.value;
        const xhr = new XMLHttpRequest();
        xhr.open("GET", `/contents?category=${categoryVal}`, true);
        xhr.send();
        xhr.onload = (data) => {
            const content = document.querySelector("#category-article");
            content.innerHTML = data.target.response;

            viewerBtns = document.querySelectorAll('.viewer-btn');
            contents = document.querySelectorAll('.category__content');

            view(viewerBtns, contents);
        }
    }
})