<template>
  <div class="story">
    <stories-comp />
  </div>
</template>

<script>
import StoriesComp from "@/components/StoriesComp.vue";

export default {
  name: "stories",
  components: {
    StoriesComp,
  },
};
</script>
  

<style  scoped>
.story {
  display: flex;
  flex-direction: column;
}
</style>