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

plusBtn.addEventListener('click', () => {
    onAdd();
});

