<template>
  <div id="app">
    <div id="nav">
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <!-- <header-comp></header-comp> -->
    <div class="center">
      <!-- <nav-comp />
      <animal />
      <story-view /> -->
    </div>

    <router-view />
  </div>
</template>

<script>
// import NavComp from "@/components/NavComp.vue";
// import HeaderComp from "@/components/HeaderComp.vue";
// import Animal from "@/views/Animal.vue";
// import StoryView from "@/views/StoryView.vue";

export default {
  name: "app",
  // components: {
  //   NavComp,
  //   HeaderComp,
  //   Animal,
  //   StoryView,
  // },
};
</script>

<style >
/* .center {
  display: flex;
  flex-direction: row;
} */
