<template>
  <div class="home">
    <!-- <p>You must be authenticated to see this</p> -->
    <animal-list />
    <nav />
  </div>
</template>

<script>
// import Nav from "@/components/Nav";
import AnimalList from "@/components/AnimalList.vue";

export default {
  name: "home",
  components: {
    AnimalList,
  },
};
</script>

<style scoped>
</style>