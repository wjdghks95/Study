<template>
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">
            <router-link to="/">HOME</router-link>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">
            <router-link to="/list">LIST</router-link>
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="mt-4">
  <router-view :blog="blog"></router-view>
</div>

<!-- <List :blog="blog"/> -->

</template>

<script>

import List from './components/List.vue';
import blog from './assets/blog.js';

export default {
  name: 'App',
  components: {
    List,

  },

  data() {
    return {
      blog : blog,
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
