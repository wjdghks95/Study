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