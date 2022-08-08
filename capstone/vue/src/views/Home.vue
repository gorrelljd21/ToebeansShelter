<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <animal />
  </div>
</template>

<script>
import Animal from "@/views/Animal.vue";

export default {
  name: "home",
  components: { Animal },
};
</script>
