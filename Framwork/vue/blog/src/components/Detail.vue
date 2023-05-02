<template>
    <div>
        <h4>상세페이지</h4>
        <h5>{{ blog[$route.params.id].title }}</h5>
        <p>{{ blog[$route.params.id].content }}</p>
        <p>{{ blog[$route.params.id].date }}</p>
        <router-view></router-view>
    </div>
</template>

<script>
export default {
    name : 'Detail',

    props : {
        blog : Object,
    }
}
</script>

<style>

</style>