<template>
  <div id="app">
    <div id="nav">
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <header-comp />
    <nav-comp />
    <router-view />
  </div>

  <!-- below may be needed when organizing layout of page -->
  <!-- <div class="container">
    <header>
        ...
    </header>
    <main class="container__main">
         Left sidebar -->
  <!-- <aside class="container__left">...</aside> -->

  <!-- Main content -->
  <!-- <article class="container__middle">...</article> -->

  <!-- Right sidebar -->
  <!-- <nav class="container__right">...</nav> -->
  <!-- </main>
    <footer>
        ...
    </footer>
</div> -->
</template>





<script>
import NavComp from "@/components/NavComp.vue";
import HeaderComp from "@/components/HeaderComp.vue";

export default {
  name: "app",
  components: {
    NavComp,
    HeaderComp,
  },
};
</script>

<style scoped>
</style>


