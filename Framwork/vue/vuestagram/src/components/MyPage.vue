<template>
    <div style="padding : 10px">
        <h4>팔로워</h4>
        <input placeholder="⭕" @input="search($event.target.value)" />
        <div class="post-header" v-for="(item, i) in follower" :key="i">
            <div class="profile" :style="`background-image: url(${item.image})`"></div>
            <span class="profile-name">{{item.name}}</span>
        </div>
    </div>
</template>

<script>
import { computed, onMounted, reactive, ref, toRef, watch } from 'vue'
import axios from 'axios';

export default {
    name: 'mypage',
    setup(porps, context) {
        let follower = ref([]);
        let followerOriginal = ref([]);

        onMounted(()=>{
        axios.get('/follower.json').then((a)=>{
            follower.value = a.data;
            followerOriginal.value = [...a.data];
        })
        });

        function search(검색어){
        let newFollower = followerOriginal.value.filter((a)=>{
            return a.name.indexOf(검색어) != -1
        });
        follower.value = [...newFollower]
        }
        return {follower, search}

        // let test = reactive({name : 'kim'});

        // let { one } = toRef(porps);
        // console.log(one.value);

        // watch(one, () => {
            // 실행할 코드
        // })

        // let result = computed(() => {return follower.value.length})
        // console.log(result.value)

        // let store = userStore();
        // console.log(store.state.name)
    }
}
</script>

<style>

</style>