'use strict'

import SlideBuilder from './slider.js';

const mainSlide = new SlideBuilder()
	.section('#home')
	.build();
// 메인 홈 슬라이드

function textUnderbarToggle(list) {
	const menu = document.querySelector(list);
	menu.addEventListener('click', (event) => {

		if (event.target === menu) {
			return;
		};

		const target = event.target.tagName !== 'SPAN' ? event.target.children[0] : event.target;
		target.classList.add('active');

		const items = menu.querySelectorAll('.item');
		
		items.forEach(item => {
			const itemName = item.querySelector('span');

			if (target !== itemName) {
				itemName.classList.remove('active');
			};
		});
	});
};
textUnderbarToggle('.header__nav');
textUnderbarToggle('.home__contents-menu');
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
// swiper

const topBtn = document.querySelector('.footer__go-to-top');
topBtn.addEventListener('click', (event) => {
	event.preventDefault();
	window.scrollTo({
		top: 0,
		behavior: 'smooth',
	});
});
// top버튼 클릭 시 최상단으로 이동

const searchBtn = document.querySelector('.searchBtn');
const searchInput = document.querySelector('.search-input');
searchBtn.addEventListener('click', (event) => {
	event.preventDefault();

	searchInput.style.display = 'block';
	searchInput.focus();
});
searchInput.addEventListener('focusout', (event) => {
	searchInput.value = '';
	searchInput.style.display = 'none';
});
// 검색버튼 활성화

const wrapBg = document.querySelector('#wrap-bg');
const mobileMenuBtn = document.querySelector('.util__mobileMenu');
const sideNav = document.querySelector('#side-nav');
const closeNav = document.querySelector('.side-nav__close');

mobileMenuBtn.addEventListener('click', (event) => {
	event.preventDefault();
	showSlideNav();
});
closeNav.addEventListener('click', () => {
	removeSideNav()
});
wrapBg.addEventListener('click', () => {
	removeSideNav()
});

function showSlideNav() {
	sideNav.style.display = 'block';
	setTimeout(() => {
		sideNav.classList.add('active');
		wrapBg.style.display = 'block';
	}, 0);
};
function removeSideNav() {
	sideNav.classList.remove('active');
	wrapBg.style.display = 'none';
	setTimeout(() => {
		sideNav.style.display = 'none';
	}, 300);
};
// 모바일메뉴 버튼 클릭 시 활성화