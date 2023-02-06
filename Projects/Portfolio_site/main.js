'use strict'

// 스크롤시 Navbar 변화
const navbar = document.querySelector('#navbar');
const navbarHeight = navbar.getBoundingClientRect().height;
document.addEventListener('scroll', () => {
    if (window.scrollY > navbarHeight) {
        navbar.classList.add('navbar-dark');
    } else {
        navbar.classList.remove('navbar-dark');
    };
});

// Navbar 메뉴 클릭시 해당 섹션으로 이동
const navbarMenu = document.querySelector('.navbar__menu');
navbarMenu.addEventListener('click', (event) => {
    const target = event.target;
    const link = target.dataset.link;
    if (link == null) {
        return;
    };
    navbarMenu.classList.remove('open');
    scrollIntoView(link);
    selectNavItem(target);
});

//  스크롤 시 섹션에 해당하는 Navbar 메뉴 활성화
const sectionIds = [
    '#home',
    '#about',
    '#skills',
    '#work',
    '#archiving',
    '#contact',
];
const sections = sectionIds.map(id => document.querySelector(id));
const navItems = sectionIds.map(id => document.querySelector(`[data-link="${id}"]`));

let selectedNavIndex = 0;
let selectedNavItem = navItems[0];
function selectNavItem(selected) {
    selectedNavItem.classList.remove('active');
    selectedNavItem = selected;
    selectedNavItem.classList.add('active');    
};

const observerCallback = (entries, observer) => {
    entries.forEach(entry => {
        if (!entry.isIntersecting && entry.intersectionRatio > 0) {
            let index = sectionIds.indexOf(`#${entry.target.id}`);
            if (entry.boundingClientRect.y < 0) {
                selectedNavIndex = index + 1;
            } else {
                selectedNavIndex = index - 1;
            };
        };
    });
};

const observerOptions = {
    root: null,
    rootMargin: '0px',
    threshold: 0.3,
};

const observer = new IntersectionObserver(observerCallback, observerOptions);
sections.forEach(section => {
    observer.observe(section);
});

window.addEventListener('wheel', () => {
    if (window.scrollY === 0) {
        selectedNavIndex = 0;
    } else if (Math.round(window.scrollY + window.innerHeight) >= document.body.clientHeight) {
        selectedNavIndex = navItems.length - 1;
    };
    selectNavItem(navItems[selectedNavIndex]);
});

// Navbar 메뉴 토글
const toggleBtn = document.querySelector('.navbar__toggle-btn');
toggleBtn.addEventListener('click', () => {
    navbarMenu.classList.toggle('open');
});


// Contact Me 버튼 클릭시 Contact 섹션으로 이동
const contactBtn = document.querySelector('.home__contact');
contactBtn.addEventListener('click', () => {
    scrollIntoView('#contact');
});

// 스크롤 시 Home의 텍스트, 이미지를 투명하게
const home = document.querySelector('.home__container');
const homeHeight = home.getBoundingClientRect().height;
document.addEventListener('scroll', () => {
    home.style.opacity = 1 - window.scrollY / homeHeight;
});

// 스크롤시 Arrow up 버튼 생성
const arrowUp = document.querySelector('.arrow-up');
document.addEventListener('scroll', () => {
    if (window.scrollY > homeHeight / 2) {
        arrowUp.classList.add('visible');
    } else {
        arrowUp.classList.remove('visible');
    };
});

// Arrow up 버튼 클릭 시 home으로 이동
arrowUp.addEventListener('click', () => {
    scrollIntoView('#home');
});

// Projects 이미지 슬라이드
class Slide {
    constructor(slideBox) {
        this.slideList = document.querySelector(slideBox + ' .project__slide-list');
        this.slideContents = document.querySelectorAll(slideBox + ' .project__slide-content');
        this.slideBtnPrev = document.querySelector(slideBox + ' .project__slide-btn--prev');
        this.slideBtnNext = document.querySelector(slideBox + ' .project__slide-btn--next');
        this.pagination = document.querySelector(slideBox + ' .project__slide-pagination');
        this.slideTotalNum = document.querySelector(slideBox + ' .project__slide-totalNum');
        this.slideNum = document.querySelector(slideBox + ' .project__slide-num');

        this.slideLen = this.slideContents.length;  // slide length
        this.slideWidth = this.slideContents[0].clientWidth; // slide width
        this.slideSpeed = 300; // slide speed
        this.startNum = 0; // initial slide index (0 ~ 4)
        this.slideTotalNum.innerHTML = this.slideLen; // slide total number

        // Copy first and last slide
        this.firstChild = this.slideList.firstElementChild;
        this.lastChild = this.slideList.lastElementChild;
        this.clonedFirst = this.firstChild.cloneNode(true);
        this.clonedLast = this.lastChild.cloneNode(true);

        // Add copied Slides
        this.slideList.appendChild(this.clonedFirst);
        this.slideList.insertBefore(this.clonedLast, this.slideList.firstElementChild);

        this.slideList.style.transform = "translate3d(-" + (this.slideWidth * (this.startNum + 1)) + "px, 0px, 0px)";

        this.curIndex = this.startNum; // current slide index

        // Next Button Event
        this.slideBtnNext.addEventListener('click', () => {
            this.next();
        });

        // Prev Button Event
        this.slideBtnPrev.addEventListener('click', () => {
            this.prev();
        });
    }

    next() {
        this.curIndex++;
        this.slideList.style.transition = this.slideSpeed + "ms";
        this.slideList.style.transform = "translate3d(-" + this.slideWidth * (this.curIndex + 1) + "px, 0px, 0px)";

        if (this.curIndex === this.slideLen) {
            const slideList = this.slideList;
            const slideWidth = this.slideWidth;
            this.curIndex = this.startNum;

            setTimeout(function() {
                slideList.style.transition = "0ms";
                slideList.style.transform = "translate3d(-" + slideWidth + "px, 0px, 0px)";
            }, this.slideSpeed);
        }
        this.slideNum.innerHTML = this.curIndex + 1;
    }

    prev() {
        this.curIndex--;
        this.slideList.style.transition = this.slideSpeed + "ms";
        this.slideList.style.transform = "translate3d(-" + this.slideWidth * (this.curIndex + 1) + "px, 0px, 0px)";

        if (this.curIndex === this.startNum - 1) {
            const slideList = this.slideList;
            const slideWidth = this.slideWidth;
            const slideLen = this.slideLen;
            this.curIndex = this.slideLen - 1;

            setTimeout(function() {
                slideList.style.transition = "0ms";
                slideList.style.transform = "translate3d(-" + slideWidth * slideLen + "px, 0px, 0px)";
            }, this.slideSpeed);
        }
        this.slideNum.innerHTML = this.curIndex + 1;
    }
}

new Slide(".project1-slide");
new Slide(".project2-slide");
new Slide(".project3-slide");
new Slide(".project4-slide");

function scrollIntoView(selector) {
    const scrollTo = document.querySelector(selector);
    scrollTo.scrollIntoView({behavior: 'smooth'});
    selectNavItem(navItems[sectionIds.indexOf(selector)]);
};