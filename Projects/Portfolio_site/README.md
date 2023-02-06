# 포트폴리오 웹사이트

### 🔗URL
https://wjdghks95.github.io/Study/Projects/Portfolio_site/index.html

### 🚩목표
포트폴리오 웹사이트 제작

### ✏️요구사항
- 싱글 페이지로
- 클릭을 작게 할 수 있게
- 깔끔하지만 나의 개성을 살려서
- 전문가, 전문 지식, 개발 관련
- 개발에 대한 나의 열정
- 나의 기술 스택
- 내가 가지고 있는 기술, 언어, 툴
- 프로젝트들 (우선순위)
- 추천사
- 연락처
- 링크:  깃허브, 노션, 인스타그램

### 💡주요 기능
- ✅ 간단한 자기소개
- ✅ 인적 사항
- ✅ 기술 스택
- ✅ 프로젝트 경험
- ✅ GitHub 및 노션 링크


### 🔨사용기술
<div>
<img src="https://img.shields.io/badge/HTML-E34F26?style=for-the-badge&logo=HTML5&logoColor=white" style="display: inline-block; margin-right: 6px;">
<img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=CSS3&logoColor=white" style="display: inline-block; margin-right: 6px;">
<img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white" style="display: inline-block; margin-right: 6px;">
</div>

### ⚡Advanced Feature
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

### 🔥개선사항
CAREER 섹션 추가