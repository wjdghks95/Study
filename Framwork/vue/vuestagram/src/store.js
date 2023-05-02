import { createStore } from 'vuex'
import postdata from './assets/postdata.js'
import axios from 'axios'

const store = createStore({
    state(){
        return {
            name: 'kim',
            age: 20,
            likes: postdata.map(post => post.likes),
            liked: postdata.map(post => post.liked),
            more: {},
        }
    },

    mutations: {
        changeName(state) {
            state.name = 'park';
        }, 

        changeAge(state, payload) {
            state.age += payload;
        },

        thumbsUp(state, idx) {
            if(!state.liked[idx]) {
                state.likes[idx]++;
                state.liked[idx] = true;
            } else {
                state.likes[idx]--;
                state.liked[idx] = false;
            }
            
        },

        setMore(state, data) {
            state.more = data;
        }
    },

    actions: {
        getData(context) {
            axios.get('https://codingapple1.github.io/vue/more0.json')
            .then((result) => {
                context.commit('setMore', result.data);
            })
        }
    }
})

export default store