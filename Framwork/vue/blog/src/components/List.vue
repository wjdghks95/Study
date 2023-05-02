<template>
    <div v-for="(item, i) in blog" :key="i">
        <h5 @click="$router.push('/detail/' + i)">{{ item.title }}</h5>
        <p>{{ item.date }}</p>
    </div>
</template>

<script>

export default {
    name : 'List',

    props : {
        blog : Object,
    }
}
</script>

<style>

</style>