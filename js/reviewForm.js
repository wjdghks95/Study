// rating
const stars = document.querySelectorAll('.rating__star');
let totalStar = 0;

stars.forEach((star, index) => {
    star.dataset.rating = index + 1;
    star.addEventListener('mouseover', e => {
        onMouseOver(e);
    });
    star.addEventListener('click', e => {
        onClick(e);
    });
    star.addEventListener('mouseleave', e => {
        onMouseLeave(e);
    });
});

function fill(ratingVal) {
    for (let i = 0; i < 5; i++) {
        if (i < ratingVal) {
            stars[i].querySelector('img').setAttribute('src', '../icon/star-solid.svg');
        } else {
            stars[i].querySelector('img').setAttribute('src', '../icon/star-regular.svg');
        }
    }
}

function onMouseOver(e) {
    const ratingVal = e.currentTarget.dataset.rating;
    if (!ratingVal) {
        return;
    } else {
        fill(ratingVal);
    }
}

function onMouseLeave(e) {
    fill(totalStar);
}

function onClick(e) {
    const ratingVal = e.currentTarget.dataset.rating;
    totalStar = ratingVal;
}

// tag
const tagInput = document.querySelector('.tag-in > input');
const tagAddBtn = document.querySelector('.tag-in__add-button');
const tagList = document.querySelector('.tag-in__list');

tagAddBtn.addEventListener('click', () => createTag());
tagInput.addEventListener('keydown', (e) => { 
    if(e.key === 'Enter') {
        tagAddBtn.click();
    }
});

function createTag() {
    const tagItem = document.createElement('li');
    const tagName = document.createElement('span');
    const tagRemoveBtn = document.createElement('button');

    let text = tagInput.value;
    if (tagList.childElementCount >= 10) {
        alert('태그는 10개까지만 추가할 수 있습니다.');
    } else {
        if (text != '') {
            tagItem.setAttribute('class', 'tag-in__item');

            tagName.innerHTML = '#' + text;

            tagRemoveBtn.setAttribute('type', 'button');
            tagRemoveBtn.setAttribute('class', 'remove-btn');
            tagRemoveBtn.innerHTML = 'x';
            tagRemoveBtn.addEventListener('click', () => {
                tagItem.remove();
            })
            
            tagItem.appendChild(tagName);
            tagItem.appendChild(tagRemoveBtn);
            tagList.appendChild(tagItem);
            
            tagInput.value = '';
            tagInput.focus();
        } else {
            tagInput.focus();
            return;
        }
    }
}

// submitBtn
const submitBtn = document.querySelector('.review-model__submit-button');
const form = document.querySelector('form');

submitBtn.addEventListener('click', () => form.submit());

// imgUpload
const uploadBtn = document.querySelector('.review-model__photo');
const fileInput = document.querySelector('.review-model__photo input');
const wrapper = document.querySelector(".review-model__photo .swiper-wrapper");
const nextBtn = document.querySelector(".review-model__photo .swiper-button-next");
const prevBtn = document.querySelector(".review-model__photo .swiper-button-prev");

uploadBtn.addEventListener('click', (e) => {
    if (e.target == nextBtn || e.target == prevBtn) {
        return;
    }
    fileInput.click();
    fileInput.addEventListener('change', (e) => getImageFile(e));
})

function getImageFile(e) {
    const uploadFiles = [];
    const files = e.currentTarget.files;
    const count = [...files].length;

    if (count == 0) {
        return;
    }

    if (count > 10) {
        alert('이미지는 최대 10개까지 업로드가 가능합니다.');
        return;
    }

    [...files].forEach(file => {
        if (!file.type.match("image/.*")) {
            alert('이미지 파일만 업로드가 가능합니다.');
            return;
        }
    });

    init();

    [...files].forEach(file => {
        uploadFiles.push(file);
        const reader = new FileReader();
        reader.onload = (e) => {
            const photo = createPhoto(e, file);
            wrapper.appendChild(photo);
        }
        reader.readAsDataURL(file);
    })

    const uploadInfo = document.createElement('p');
    let fileName;
    if (count == 1) {
        [...files].forEach(file => {
            fileName = `해당 사진을 썸네일로 등록합니다. (${file.name})`;
        })
    } else {
            fileName = `해당 사진을 썸네일로 등록합니다. (업로드할 사진 수 ${count}개)`;
    }
    uploadInfo.innerHTML = fileName;
    uploadBtn.appendChild(uploadInfo);
}


function init() {
    const photoBtn = document.querySelector('.photo-btn');
    if (photoBtn != null) {
        photoBtn.remove();
    }

    nextBtn.style.display = 'block';
    prevBtn.style.display = 'block';

    if (wrapper.hasChildNodes) {
        wrapper.querySelectorAll('.swiper-slide').forEach(slide => {
            slide.remove();
        })
    }

    uploadBtn.childNodes.forEach(child  => {
        if (child.tagName == 'P') {
            child.remove();
        }
    })
}

function createPhoto(e, file) {
    const photo = createElement('div', 'class', 'swiper-slide');
    const img = createElement('img', 'src', e.target.result);
    img.setAttribute('data-file', file.name);

    photo.appendChild(img);

    return photo;
}

function createElement(e, attr, attrName) {
    const element = document.createElement(e);
    element.setAttribute(attr, attrName);
    return element;
}b