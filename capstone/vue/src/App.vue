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
    <div class="center">
      <nav-comp />
      <animal />
      <story-view />
    </div>

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
import Animal from "@/views/Animal.vue";
import StoryView from "@/views/StoryView.vue";

export default {
  name: "app",
  components: {
    NavComp,
    HeaderComp,
    Animal,
    StoryView,
  },
};
</script>

<style scoped>
.center {
  display: flex;
  flex-direction: row;
}
</style>


