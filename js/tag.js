export default class Tag {

    constructor() {
        this.input = document.querySelector('.tag-in > input');
        this.button = document.querySelector('.tag-in__add-button');
        this.tagList = document.querySelector('.tag-in__list');
    }

    add() {
        this.button.addEventListener('click', this._createTag);
        this.input.addEventListener('keydown', (e) => { 
            if(e.key === 'Enter') {
                this.button.click();
            }
        });
    }

    _createTag = () => {
        let tagItem = document.createElement('li');
        let tagName = document.createElement('span');
        let tagRemoveBtn = document.createElement('button');

        let text = this.input.value;
        if (this.tagList.childElementCount >= 10) {
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
                this.tagList.appendChild(tagItem);
                
                this.input.value = '';
                this.input.focus();
            } else {
                this.input.focus();
                return;
            }
        }
    }
}