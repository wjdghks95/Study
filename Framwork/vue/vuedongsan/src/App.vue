<template>

  <!-- 모달창 -->
  <!--
  <div class="black-bg" v-if="isModal">
    <div class="white-bg">
      <h4>{{ onerooms[num].title }}</h4>
      <img :src="onerooms[num].image">
      <p>{{ onerooms[num].price }}원</p>
      <p>{{ onerooms[num].content }}</p>
      <button @click="isModal = false">닫기</button>
    </div>
  </div>
  -->

  <!-- <div class="start" :class="{ end : isModal }"> -->
  <transition name="fade">
    <DetailModal :onerooms="onerooms" :num="num" :isModal="isModal" @closeModal="isModal = false;"/>
  </transition>
  <!-- </div> -->

  <!-- v-for 반복문 -->
  <div class="menu">
    <!-- <a v-for="i in 3" :key="i">Home</a> -->
    <a v-for="i in menu" :key="i">{{ i }}</a>
  </div>
  
  <!-- <DiscountBanner v-bind="object" v-if="showDiscount == true"/> -->
  <DiscountBanner :discount="discount"/>

  <button @click="priceSort">가격순정렬</button>
  <button @click="sortBack">되돌리기</button>

  <!-- 콧수염 데이터 바인딩 -->
  <!-- 
  <div>
    원룸샵
    <h4 class="red" :style="스타일">XX 원룸</h4>
    <p>{{ price1 }} 만원</p>
  </div>
  <div>
    <h4>XX 원룸</h4>
    <p>{{ price2 }} 만원</p>
  </div> 
  -->

  <!-- 함수 -->
  <!--
  <div>
    <img src="./assets/room0.jpg" class="room-img">
    <h4 @click="isModal = true">{{ products[0] }}</h4>
    <p>50만원</p>
    <button @click="increase(0)">허위매물신고</button> <span>신고수 : {{ 신고수[0] }}</span>
  </div>
  <div>
    <img src="./assets/room1.jpg" class="room-img">
    <h4>{{ products[1] }}</h4>
    <p>60만원</p>
    <button @click="increase(1)">허위매물신고</button> <span>신고수 : {{ 신고수[1] }}</span>
  </div>
  <div>
    <img src="./assets/room2.jpg" class="room-img">
    <h4>{{ products[2] }}</h4>
    <p>70만원</p>
    <button @click="increase(2)">허위매물신고</button> <span>신고수 : {{ 신고수[2] }}</span>
  </div>
  -->
  
  <!-- import, export -->
  <!-- 
  <div v-for="(item, i) in onerooms" :key="i">
    <img :src="item.image" class="room-img">
    <h4 @click="isModal = true; num = i">{{ item.title }}</h4>
    <p>{{ item.price }}</p>
    <button @click="increase(i)">허위매물신고</button> <span>신고수 : {{ 신고수[i] }}</span>
  </div>
  -->

  <!-- props -->
  <CardList @openModal="isModal = true; num = $event" v-for="(item, i) in onerooms" :key="i" :oneroom="onerooms[i]"/>

  <!-- 
  <div v-for="(product, i) in products" :key="i">
    <h4>{{ product }}</h4>
    <p>50만원</p>
  </div>
  -->
  
</template>

<script>
import data from './assets/oneroom.js';
import DiscountBanner from './DiscountBanner.vue';
import DetailModal from './DetailModal.vue';
import CardList from './CardList.vue';

export default {
  name: 'App',

  data() {
    return {
      // price1 : 60,
      // price2 : 70,
      // 스타일 : 'color:blue',
      showDiscount : true,
      object : {name : 'kim', age: 20},
      num : 0,
      oneroomsOrignal : [...data],
      onerooms : data,
      products : ['역삼동원룸', '천호동원룸', '마포구원룸'],
      menu : ['Home', 'Shop', 'About'],
      신고수: [0, 0, 0, 0, 0],
      isModal : false,
      discount : 30,
    }
  },

  methods : {
    increase(idx) {
      this.신고수[idx] += 1;
    },

    priceSort() {
      this.onerooms.sort(function(a, b) {
        return a.price - b.price;
      })
    },

    sortBack() {
      this.onerooms = [...this.oneroomsOrignal];
    }
  },

  components : {
    DiscountBanner : DiscountBanner,
    DetailModal : DetailModal,
    CardList : CardList,
  },

  mounted() {
    setInterval(() => {
      this.discount--;
    }, 1000);
  },

  /*
  mounted() {
    setTimeout(() => {
      this.showDiscount = false;
    }, 2000);
  },
  */
}
</script>

<style>
body {
  margin: 0;
}

div {
  box-sizing: border-box;
}

img { 
  width: 100%;
}

.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, .5);
  position: fixed;
  padding: 20px;
}

.white-bg {
  width: 100%;
  background: white;
  border-radius: 8px;
  padding: 20px;
}

.room-img {
  width: 100%;
  margin-top: 40px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.menu {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

.menu a {
  color: white;
  padding: 10px;
}

.discount {
  background: #eee;
  padding: 10px;
  margin: 10px;
  border-radius: 5px;
}

.start {
  opacity: 0;
  transition: all 1s;
}
.end {
  opacity: 1;
}

.fade-enter-from {
  opacity: 0;
}
.fade-enter-active {
  transition: all 1s;
}
.fade-enter-to {
  opacity: 1;
}

.fade-leave-from {
  opacity: 1;
}
.fade-leave-active {
  transition: all 1s;
}
.fade-leave-to {
  opacity: 0;
}
</style>
