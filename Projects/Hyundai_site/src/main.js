(function () {
	function Slideshow(main, menu) {
		this.el = document.querySelector(main);
		this.ul = document.querySelector(menu);
		this.init();
	}

	Slideshow.prototype = {
		init: function () {
			this.wrapper = this.el.querySelector(".slider-wrapper");
			this.slides = this.el.querySelectorAll(".slide");
			this.previous = this.el.querySelector(".slider-previous");
			this.next = this.el.querySelector(".slider-next");
			this.slideItems = this.ul.querySelectorAll(".slideMenu__item");
			this.index = 0;
			this.total = this.slides.length;
			
			this.actions();
		},
		_slideTo: function (slide) {
			const currentSlide = this.slides[slide];
			const video = currentSlide.querySelector('video');
			currentSlide.style.opacity = 1;
			currentSlide.style.zIndex = 1;
			video.load();
			
			for (let i = 0; i < this.slides.length; i++) {
				const slide = this.slides[i];
				if (slide !== currentSlide) {
					slide.style.opacity = 0;
					slide.style.zIndex = 0;
				};
			};
		},
		_active: function (index) {
			const currentSlideItem = this.slideItems[index];
			const currentSlideName = currentSlideItem.querySelector('span');
			currentSlideItem.classList.add('active');
			currentSlideName.classList.add('active');
				
			for (let i = 0; i < this.slideItems.length; i++) {
				const slideItem = this.slideItems[i];
				const slideName = slideItem.querySelector('span');
				
				if (slideItem !== currentSlideItem) {
					slideItem.classList.remove('active');
					slideName.classList.remove('active');
				};
			};
		},
		actions: function () {
			let self = this;

			self.next.addEventListener("click", function () {
				self.index++;
				self.previous.style.display = "block";
				
				if (self.index == self.total - 1) {
					self.index = self.total - 1;
					self.next.style.display = "none";
				};

				self._slideTo(self.index);
				self._active(self.index);

				if (window.innerWidth <= 767) {
					self._active(self.index);
				};
				
			}, false);
			
			self.previous.addEventListener("click", function () {
				self.index--;
				self.next.style.display = "block";
				
				if (self.index == 0) {
					self.index = 0;
					self.previous.style.display = "none";
				}
				
				self._slideTo(self.index);
				self._active(self.index);

				if (window.innerWidth <= 767) {
					self._active(self.index);
				};

			}, false);

			self.ul.addEventListener("click", (event) => {
				event.preventDefault();
				const target = event.target.tagName === 'SPAN' ? event.target.parentNode : event.target;
				const itemIndex = target.parentNode.dataset.index;
				
				if (itemIndex == null) {
					return;
				};
				
				if (self.index != itemIndex) {
					self.index = itemIndex;

					if (self.index == 0) {
						self.previous.style.display = "none";
					} else {
						self.previous.style.display = "block";
					};

					if (self.index == self.total - 1) {
						self.next.style.display = "none";
					} else {
						self.next.style.display = "block";
					};
					
					self._slideTo(itemIndex);
					self._active(self.index);
				};

			}, false);
		},
	};
	
	const slider = new Slideshow("#home-slider", '#home-slideMenu');
	// 버튼 또는 메뉴 클릭 시 영상, 언더바 슬라이드
	
	function ShowUnderbar(ul) {
		this.ul = document.querySelector(ul);

		this.active();
	};

	ShowUnderbar.prototype = {
		active: function () {
			this.ul.addEventListener('click', (event) => {
				const items = this.ul.querySelectorAll('li');
				items.forEach(item => {
					const itemName = item.querySelector('span');
					itemName.classList.remove('active');
				});
				
				if (event.target.tagName === 'UL') {
					return;
				};

				const target = event.target.tagName === 'A' ? event.target.children[0] : event.target;
				target.classList.add('active');
			});
		},
	};

	const headMenu = new ShowUnderbar('.menu__items');
	const slideMenu = new ShowUnderbar('.slideMenu__items');
	// 메뉴 클릭 시 텍스트 언더바 활성화
	function Scroll(element) {
		this.el = document.querySelector(element);

		this.init();
	};

	Scroll.prototype = {
		init: function () {
			this.elHeight = this.el.getBoundingClientRect().height;
				
			this.action();
		},
		action: function () {
			document.addEventListener('scroll', () => {
				
				if (window.scrollY > this.elHeight) {
					this.el.classList.add('fixed');
				} else {
					this.el.classList.remove('fixed');
				};
			});
		},
	};
	const scrollHeader = new Scroll('#header');
	// 스크롤 시 헤더배경 고정 변환
})();

