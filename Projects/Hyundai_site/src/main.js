'use strict'

import Slideshow from './slider.js';

const home = document.querySelector('#home');
const slide = new Slideshow(home);
// 홈 슬라이드

const searchToggle = document.querySelector('.utils__search-toggle');
const search = document.querySelector('.utils__search');
const searchInput = document.querySelector('#search-input');

searchToggle.addEventListener('click', (event) => {
	event.preventDefault();

	searchToggle.style.display = 'none';
	search.style.display = 'inline-block';
	searchInput.focus();
});
document.addEventListener('click', (event) => {
	const target = event.target;
	
	if (target == searchToggle || target == searchInput) {
		return;
	} else {
		search.style.display = 'none';
		searchToggle.style.display = 'inline-block';
		searchInput.value = '';
	};
});
// 검색 활성화

function showMenuUnderbar(ul) {
	const menu = document.querySelector(ul);
	menu.addEventListener('click', (event) => {

		if (event.target == menu) {
			return;
		};

		const target = event.target.tagName !== 'SPAN' ? event.target.children[0] : event.target;
		target.classList.add('active');

		const items = menu.querySelectorAll('li');
		
		items.forEach(item => {
			const itemName = item.querySelector('span');

			if (target !== itemName) {
				itemName.classList.remove('active');
			};
		});
	});
};
showMenuUnderbar('.nav__items');
showMenuUnderbar('.contents-menu__items');
// 메뉴 클릭 시 해당 메뉴 언더바 생성

const header = document.querySelector('#header');
const headerHeight = header.getBoundingClientRect().height;

(function fixHeader() {
	window.addEventListener('scroll', () => {
			
			if (window.scrollY > headerHeight) {
				header.classList.add('fixed');
			} else {
				header.classList.remove('fixed');
			};
	});
})();
// 스크롤 시 헤더 배경 고정

const swiper = new Swiper('.swiper-container', {
	slidesPerView: 1,
	spaceBetween: 10,
	speed: 800,
	loop: true,
	effect: 'fade',
	fadeEffect: {
		crossFade: true,
	},
    pagination: {
    el: '.swiper-pagination',
	type: 'bullets',
	clickable: true,
	},
});
// 라인업 swiper
const swiper2 = new Swiper('.swiper-container2', {
	slidesPerView: 5,
	spaceBetween: 10,
	navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
	},
	pagination: {
    el: '.swiper-pagination',
	type: 'bullets',
	clickable: true,
	},
	speed: 800,
	loop: true,
	breakpoints: {
	0: {
		slidesPerView: 1,
		spaceBetween: 0,
    },
    480: {
		slidesPerView: 1.7,
		spaceBetween: 80,
		centeredSlides: true,
    },
    768: {
		slidesPerView: 3,
		spaceBetween: 15,
    },
    1024: {
		slidesPerView: 5,
		spaceBetween: 10,
    },
  }
});
// 이벤트 swiper

const topBtn = document.querySelector('.footer__go-to-topBtn');
topBtn.addEventListener('click', (event) => {
	event.preventDefault();
	window.scrollTo({
		top: 0,
		behavior: 'smooth',
	});
});
// top버튼 클릭 시 최상단으로 이동

const wrap = document.querySelector('#wrap');
const sideNavBtn = document.querySelector('.utils__toggle-sideNav');
const sideNav = document.querySelector('#side-pad');
const closeNav = document.querySelector('.side-pad__close');

sideNavBtn.addEventListener('click', (event) => {
	event.preventDefault();
	showSideNav();
});
closeNav.addEventListener('click', () => {
	removeSideNav()
});
document.addEventListener('click', (event) => {
	const target = event.target;
	
	if (target !== wrap) {
		return;
	} else {
		removeSideNav();
	};
});
function showSideNav() {
	sideNav.style.display = 'block';
	setTimeout(() => {
		sideNav.classList.add('active');
		wrap.classList.add('active');
	}, 0);
};
function removeSideNav() {
	sideNav.classList.remove('active');
	wrap.classList.remove('active');
	setTimeout(() => {
		sideNav.style.display = 'none';
	}, 300);
};
// 모바일메뉴 버튼 클릭 시 활성화