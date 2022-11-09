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

// category
const category = document.querySelector(".category__list");

category.addEventListener("click", (e) => {
    const target = e.target.tagName === "BUTTON" ? e.target : null;

    if(target !== null) {
        category.querySelectorAll('.category-btn').forEach(categoryBtn => {
            categoryBtn.classList.remove("active");
        })
        target.classList.add("active");

        const categoryVal = target.value;
        const url = new URL(window.location.href);
        const page = url.searchParams.get('page') == null ? 0 : url.searchParams.get('page');
        fn_go_page(page, categoryVal);
    }
})

// pagination
function paging(pageNo) {
    const url = new URL(window.location.href);
    const categoryName = url.searchParams.get('category') == null ? "all" : url.searchParams.get('category');
    fn_go_page(pageNo, categoryName);
}

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

function fn_go_page(pageNo, categoryVal) {
    const pageIndex = pageNo;
    const categoryName = categoryVal;

    const xhr = new XMLHttpRequest();
    xhr.open("GET", `/contents?category=${categoryName}&page=${pageIndex}`, true);
    xhr.send();
    xhr.onload = (data) => {
        const content = document.querySelector("#content");
        content.innerHTML = data.target.response;

        viewerBtns = document.querySelectorAll('.viewer-btn');
        contents = document.querySelectorAll('.category__content');
        view(viewerBtns, contents);
    }
}