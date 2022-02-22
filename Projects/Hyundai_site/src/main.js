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
			video.load();
			
			for (let i = 0; i < this.slides.length; i++) {
				const slide = this.slides[i];
				if (slide !== currentSlide) {
					slide.style.opacity = 0;
				};
			};
		},
		_active: function (index) {
			const currentSlideItem = this.slideItems[index];
			currentSlideItem.classList.add('active');
				
			for (let i = 0; i < this.slideItems.length; i++) {
				const slideItem = this.slideItems[i];
				
				if (slideItem !== currentSlideItem) {
					slideItem.classList.remove('active');
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
	
})();

