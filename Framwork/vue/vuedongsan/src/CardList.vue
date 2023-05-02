<template>
    <div>
        <img :src="oneroom.image" class="room-img">
        <h4 @click="$emit('openModal', oneroom.id)">{{ oneroom.title }}</h4>
        <p>{{ oneroom.price }}원</p>
        <!-- <button @click="increase(i)">허위매물신고</button> <span>신고수 : {{ 신고수[i] }}</span> -->
    </div>
</template>

<script>
export default {
    name : "CardList",
    props : {
        oneroom : Object,
    }
}
</script>

<style>

</style>