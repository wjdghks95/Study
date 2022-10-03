import Rating from './rating.js';
import Tag from './tag.js';
import { SubmitBtn, ImgUploadBtn } from './button.js';

const rating = new Rating();
rating.onEventListener();

const tag = new Tag();
tag.add();

const submitBtn = new SubmitBtn('.review-model__submit-button');
submitBtn.onClick();

const imgUploadBtn = new ImgUploadBtn('.review-model__photo');
imgUploadBtn.upload();