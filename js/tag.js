export default class Tag {

    constructor() {
        this.input = document.querySelector('#tag-input');
        this.button = document.querySelector('.add-button');
        this.tagList = document.querySelector('.tag-in__list');
    }

    onAdd() {
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
        let tagCloseBtn = document.createElement('button');

        let text = this.input.value;

        if (text != '') {
            tagItem.setAttribute('class', 'tag-in__item');

            tagName.innerHTML = '#' + text;

            tagCloseBtn.setAttribute('type', 'button');
            tagCloseBtn.setAttribute('class', 'remove-btn');
            tagCloseBtn.innerHTML = 'X';
            tagCloseBtn.addEventListener('click', () => {
                tagItem.remove();
            })
            
            this.tagList.appendChild(tagItem);
            tagItem.appendChild(tagName);
            tagItem.appendChild(tagCloseBtn);

            this.input.value = '';
            this.input.focus();
        } else {
            this.input.focus();
            return;
        }
    }
}