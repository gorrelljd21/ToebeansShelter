<template>
  <div class="home">
    <!-- <p>You must be authenticated to see this</p> -->
    <header-comp></header-comp>
    <nav-comp></nav-comp>
    <animal-list />
    <stories-comp></stories-comp>
  </div>
</template>

<script>
// import Nav from "@/components/Nav";
import AnimalList from "@/components/AnimalList.vue";
import HeaderComp from "@/components/HeaderComp.vue";
import NavComp from "@/components/NavComp.vue";
import StoriesComp from "@/components/StoriesComp.vue";

export default {
  name: "home",
  components: {
    AnimalList,
    HeaderComp,
    NavComp,
    StoriesComp,
  },
};
</script>

<style scoped>
</style>