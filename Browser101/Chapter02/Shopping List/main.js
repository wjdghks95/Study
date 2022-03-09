const items = document.querySelector('.items');
const input = document.querySelector('.footer__input');
const addBtn = document.querySelector('.footer__button');

function onAdd() {
    const text = input.value;
    if (text === '') {
        input.focus();
        return;
    };
    const item = createItem(text);
    items.appendChild(item);
    item.scrollIntoView({block: 'center'})
    input.value = '';
    input.focus();
};

let id = 0;
let link = 0;
function createItem(text) {
    /* const itemRow = document.createElement('li');
    itemRow.setAttribute('class', 'item__row');

    const item = document.createElement('div');
    item.setAttribute('class', 'item');

    const span = document.createElement('span');
    span.setAttribute('class', 'item__name');
    span.innerText = text;

    const deleteBtn = document.createElement('button');
    deleteBtn.setAttribute('class', 'item__delete');
    deleteBtn.innerHTML = '<i class="fas fa-trash"></i>';
    deleteBtn.addEventListener('click', () => {
        items.removeChild(itemRow);
    });

    const itemDivider = document.createElement('div');
    itemDivider.setAttribute('class', 'item__divider')

    item.appendChild(span);
    item.appendChild(deleteBtn);

    itemRow.appendChild(item);
    itemRow.appendChild(itemDivider);

    return itemRow; */
    
    // 개선
    const itemRow = document.createElement('li');
    itemRow.setAttribute('class', 'item__row');
    itemRow.setAttribute('data-id', id);
    itemRow.innerHTML = `
                <div class="item">
                    <span class="item__name" data-link="${link}">${text}</span>
                    <div class="item__button">
                        <button class="item__delete">
                            <i class="fas fa-trash" data-id="${id}"></i>
                        </button>
                        <button class="item__check" data-link=${link}>
                            <i class="fas fa-check" data-link="${link}"></i>
                        </button>
                    </div>
                </div>
                <div class="item__divider"></div>
    `;
    id++;
    link++;
    return itemRow;
};

/* addBtn.addEventListener('click', () => {
    onAdd();
});

input.addEventListener('keydown', (event) => {
    if (event.keyCode === 13) {
        onAdd();
    };
}); */

// 개선
items.addEventListener('click', (event) => {
    const id = event.target.dataset.id;
    const link = event.target.dataset.link;
    if (id) {
        const toBeDeleted = document.querySelector(`.item__row[data-id="${id}"]`);
        toBeDeleted.remove();
    };
    if (link) {
        const toBeChecked = document.querySelector(`.item__name[data-link="${link}"]`);
        const checkBtn = document.querySelector(`.item__check[data-link="${link}"]`);
        toBeChecked.classList.toggle('checked');
        checkBtn.classList.toggle('checked');
    };
});

const form = document.querySelector('.new-form');
form.addEventListener('submit', (event) => {
    onAdd();
    event.preventDefault();
});

