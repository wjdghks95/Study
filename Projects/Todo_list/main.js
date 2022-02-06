const items = document.querySelector('.items');
const input = document.querySelector('.footer__input');
const plusBtn = document.querySelector('.footer__plusBtn');

function onAdd() {
    const text = input.value;
    if (text === '') {
        input.focus();
        return;
    };
    const item = createItem(text);
    items.appendChild(item);
    input.value = '';
    input.focus();
};

function setItem(element, className, parentNode) {
    element.setAttribute('class', className);
    parentNode.appendChild(element);
};

function createItem(text) {
    const itemRow = document.createElement('li');
    setItem(itemRow, 'item__row', items);
    
    const item = document.createElement('div');
    setItem(item, 'item', itemRow);

    const itemCheckBtnAndName = document.createElement('div');
    setItem(itemCheckBtnAndName, 'item__checkBtnAndName', item);

    const itemCheckBtn = document.createElement('button');
    setItem(itemCheckBtn, 'checkBtnAndName__checkBtn', itemCheckBtnAndName);
    itemCheckBtn.innerHTML = '<i class="far fa-square"></i>'

    const itemName = document.createElement('span');
    setItem(itemName, 'checkBtnAndName__name', itemCheckBtnAndName);
    itemName.innerHTML = text;

    const itemDeleteBtn = document.createElement('button');
    setItem(itemDeleteBtn, 'item__deleteBtn', item);
    itemDeleteBtn.innerHTML = '<i class="fas fa-trash"></i>';
    itemDeleteBtn.addEventListener('click', () => {
        itemRow.remove();
    });

    const itemDivider = document.createElement('div');
    setItem(itemDivider, 'item__divider', itemRow);

    return itemRow;
};

plusBtn.addEventListener('click', () => {
    onAdd();
});

