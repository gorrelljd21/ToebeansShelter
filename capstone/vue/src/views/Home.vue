<template>
  <div class="home">
    <h1>Home</h1>
    <!-- <p>You must be authenticated to see this</p> -->
    <animal-list />
  </div>
</template>

<script>
import AnimalList from "@/components/AnimalList.vue";

export default {
  name: "home",
  components: { AnimalList },
};
</script>
