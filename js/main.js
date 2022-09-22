import Rating from '../js/rating.js';
import Tag from '../js/tag.js';
import SubmitBtn from './button.js';

const rating = new Rating();
rating.action();

const tag = new Tag();
tag.onAdd();

const submitBtn = new SubmitBtn();
submitBtn.onSubmit();