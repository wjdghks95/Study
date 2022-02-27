# Portfolio_site

### [[Demo]](https://wjdghks95.github.io/Study/Projects/Portfolio_site/index.html)

## 개발목표
포트폴리오 웹사이트 제작

## 사용기술
HTML, CSS, JavaScript

## Advanced Feature
IntersectionObserver API를 이용하여 스크롤시 메뉴 활성화
```
//  스크롤 시 섹션에 해당하는 Navbar 메뉴 활성화
const sectionIds = [
    '#home',
    '#about',
    '#skills',
    '#work',
    '#testimonials',
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
```

## 개선사항
