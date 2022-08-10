<template>
  <div>
    <foot-comp />
  </div>
</template>

<script>
import FootComp from "@/components/FootComp.vue";

export default {
  name: "foot-view",
  components: {
    FootComp,
  },
};
</script>

<style scoped>
* {
  background-color: #e0dfd5;
}
</style>