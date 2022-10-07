const select = document.querySelector("select");
const email = document.querySelector('.email-hidden');

select.addEventListener('change', () => {
    if (select.options[select.selectedIndex].value == "input") {
        email.style.display = 'block';
    } else {
        email.style.display = 'none';
    }
    
})