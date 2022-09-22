export default class SubmitBtn {
    constructor() {
        this.form = document.querySelector('form');
        this.submitBtn = document.querySelector('.form__submit-button');
    }

    onSubmit() {
        this.submitBtn.addEventListener('click', (e) => {
            this.form.submit();
        })
    }
}