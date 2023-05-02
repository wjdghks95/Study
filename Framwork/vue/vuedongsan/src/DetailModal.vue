<template>
    <div class="black-bg" v-if="isModal">
        <div class="white-bg">
        <h4>{{ onerooms[num].title }}</h4>
        <img :src="onerooms[num].image">
        <p>{{ month }}개월 선택함 : {{ onerooms[num].price * month }}원</p>
        <!-- <input @input="month = $event.target.value"> -->
        <input v-model="month">
        <p>{{ onerooms[num].content }}</p>
        <button @click="$emit('closeModal')">닫기</button>
        </div>
    </div>
</template>

<script>

export default {
    name : "DetailModal",

    data() {
        return {
            month : 1,
        }
    },

    props : {
        onerooms : Array,
        num : Number,
        isModal : Boolean,
    },

    watch : {
        month(val) {
            if(val >= 13) {
                alert('13이상은 입력할 수 없습니다.');
                this.month = 1;
            }

            if (isNaN(val) == true){
                alert("문자는 입력할 수 없습니다.")
                this.month = 1;
            }
        }
    },

    beforeUpdate() {
        if (this.month == 2){
            alert('2개월은 너무 적어 판매하지 않습니다.');
            this.month = 1;
        }
    }
}
</script>

<style>

</style>