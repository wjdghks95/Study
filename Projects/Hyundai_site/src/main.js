'use strict'

import MainSlideBuilder from './slider.js';

const mainSlide = new MainSlideBuilder()
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
textUnderbarToggle('.menu');
textUnderbarToggle('.contentsMenu');
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

const slides = document.querySelector('.slides');
const slide = document.querySelectorAll('.slides li');
let currentIndex = 0;
let slideCount = slide.length;
const slideWidth = 430;
const slideMargin = 20;
const prevBtn = document.querySelector('.lineup .slider-previous');
const nextBtn = document.querySelector('.lineup .slider-next');

makeClone();

function makeClone() {
	for (let i = 0; i < slideCount; i++) {
		const cloneSlide = slide[i].cloneNode(true);
		cloneSlide.classList.add('clone');
		slides.appendChild(cloneSlide);
	}
	for (let i = slideCount - 1; i >=0; i--) {
		const cloneSlide = slide[i].cloneNode(true);
		cloneSlide.classList.add('clone');
		slides.prepend(cloneSlide);
	}
	updateWidth();
	setInitialPos();
	setTimeout(() => {
		slides.classList.add('animated');
	},100)
}
function updateWidth() {
	const currentSlides = document.querySelectorAll('.slides li');
	const newSlideCount = currentSlides.length;

	const newWidth = (slideWidth + slideMargin) * newSlideCount - slideMargin + 'px';
	slides.style.width = newWidth;
}
function setInitialPos() {
	const initialTranslateValue = -(slideWidth + slideMargin) * slideCount;
	slides.style.transform = `translateX(${initialTranslateValue}px)`;
}

nextBtn.addEventListener('click', () => {
	moveSlide(currentIndex + 1);
});
prevBtn.addEventListener('click', () => {
	moveSlide(currentIndex - 1);
});

function moveSlide(num) {
	slides.style.left = -num * (slideWidth + slideMargin) + 'px';
	currentIndex = num;
	
	if (currentIndex == slideCount || currentIndex == -slideCount) {
		
		setTimeout(() => {
			slides.classList.remove('animated');
			slides.style.left = '0px';
			currentIndex = 0;
		}, 500);
		setTimeout(() => {
			slides.classList.add('animated');
		}, 600);
	};
};