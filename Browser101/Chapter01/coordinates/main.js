const target = document.querySelector('.target');
const horizontal = document.querySelector('.horizontal');
const vertical = document.querySelector('.vertical');
const tag = document.querySelector('.tag');

/* document.addEventListener('mousemove', (event) => {
    const x = event.clientX;
    const y = event.clientY;
    horizontal.style.top = `${y}px`;
    vertical.style.left = `${x}px`;
    target.style.top = `${y}px`;
    target.style.left = `${x}px`;
    tag.innerHTML = `${x}px, ${y}px`
    tag.style.top = `${y}px`;
    tag.style.left = `${x}px`;
}); */

// 성능개선
addEventListener('load', () => {
    const targetRect = target.getBoundingClientRect();
    const targetHalfWidth = targetRect.width / 2;
    const targetHalfHeight = targetRect.height / 2;

    document.addEventListener('mousemove', (event) => {
        const x = event.clientX;
        const y = event.clientY;
        horizontal.style.transform = `translateY(${y}px)`;
        vertical.style.transform = `translateX(${x}px)`;
        target.style.transform = `translate(${x - targetHalfWidth}px, ${y - targetHalfHeight}px)`
        tag.style.transform = `translate(${x}px, ${y}px)`
        tag.innerHTML = `${x}px, ${y}px`
    });
});