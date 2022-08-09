<template>
  <div id="app">
    <div id="nav">
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <div class="center">
<<<<<<< HEAD
      <router-view />
=======
      <nav-comp />
      <animal />
      <story-view />
>>>>>>> d77c9aca8b156fc7acb36363e002ad10d1b8b198
    </div>

    <router-view />
  </div>
</template>

<script>
<<<<<<< HEAD
export default {
  name: "app",
=======
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
>>>>>>> d77c9aca8b156fc7acb36363e002ad10d1b8b198
};
</script>

<style scoped>
.center {
  display: flex;
  flex-direction: row;
}
</style>


