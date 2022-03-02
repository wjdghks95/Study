'use strict'

export default class SlideBuilder {
    section(element) {
        this.el = document.querySelector(element);
        return this;
    };

    build() {
        return new Slideshow(
            this.el
        );
    };
};

export class Slideshow {
    constructor(el) {
        this.wrapper = el.querySelector(".slider-wrapper");
        this.slides = el.querySelectorAll(".slider-slide");
        this.previous = el.querySelector(".slider-previous");
        this.next = el.querySelector(".slider-next");
        this.contentsMenu = el.querySelector('.items');
        this.contentMenuItems = this.contentsMenu.querySelectorAll('.item');
        this.index = 0;
        this.total = this.slides.length;

        this.actions();
    };

    _slideTo(slide) {
        const currentSlide = this.slides[slide];
        const currentVideo = currentSlide.querySelector('video');
        currentSlide.style.opacity = 1;
        currentSlide.style.zIndex = 1;
        currentVideo.currentTime = 0;
        currentVideo.load();
        
        for (let i = 0; i < this.slides.length; i++) {
            const slide = this.slides[i];
            if (slide !== currentSlide) {
                slide.style.opacity = 0;
                slide.style.zIndex = 0;
            };
        };
    };
    // 슬라이드

    _toggleNav(index) {
        switch (index) {
            case this.total - 1:
                this.previous.style.display = "block";
                this.next.style.display = "none";
            break;
            case 0:
                this.next.style.display = "block";
                this.previous.style.display = "none";
            break;
            default:
                this.next.style.display = "block";
                this.previous.style.display = "block";
            break;
        };
    };
    // 처음 슬라이드에는 prev버튼을 숨기고 마지막 슬라이드에는 next버튼을 숨김

    _toggleActive(index) {
        const currentItem = this.contentMenuItems[index];
        currentItem.classList.add('active');

        for (let i = 0; i < this.contentMenuItems.length; i++) {
            const item = this.contentMenuItems[i];
            
            if (currentItem != item) {
                item.classList.remove('active');
            };
        };
    };
    // 현재 슬라이드 아이템에 active 클래스를 생성하고 나머지는 제거

    _toggleTextUnderbar(index) {
        const currentItem = this.contentMenuItems[index];
        const currentItemName = currentItem.querySelector('span');
        
        currentItemName.classList.add('active');

        for (let i = 0; i < this.contentMenuItems.length; i++) {
            const item = this.contentMenuItems[i];
            const itemName = item.querySelector('span');
            
            if (currentItemName != itemName) {
                itemName.classList.remove('active');
            };
        };
    };
    // 현재 슬라이드 아이템에 해당하는 텍스트에 언더바 생성

    actions() {
        let self = this;

        self.next.addEventListener("click", function () {
            self.index++;

            self._toggleNav(self.index);
            self._toggleActive(self.index);
            self._toggleTextUnderbar(self.index);
            self._slideTo(self.index);

        }, false);
        
        self.previous.addEventListener("click", function () {
            self.index--;

            self._toggleNav(self.index);
            self._toggleActive(self.index);
            self._toggleTextUnderbar(self.index);
            self._slideTo(self.index);

        }, false);

        self.contentsMenu.addEventListener('click', (event) => {
            event.preventDefault();
                    
            if (event.target === this.contentsMenu) {
                return;
            };
                    
            const target = event.target.tagName === 'SPAN' ? event.target.parentNode.parentNode : event.target.parentNode;
            const index = parseInt(target.dataset.index);

            if (self.index != index) {
                self.index = index;

                self._toggleNav(self.index)
                self._toggleActive(self.index);
                self._slideTo(self.index);
            };
        }, false);
    };
    // Nav버튼이나 메뉴 클릭 시 슬라이드
};