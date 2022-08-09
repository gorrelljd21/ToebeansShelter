<template>
  <div class="story-comp">
    <div class="story-container">
      <div class="story-card">
        <h2 class="story-title">Story Headline Here</h2>
        <p class="story-content">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
          assumenda possimus obcaecati at odio ad eligendi cumque placeat
          adipisci aspernatur iure aut qui dolorum, a dolor maiores rerum atque
          sequi!
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      story: {
        id: null,
        title: "",
        content: "",
      },
    };
  },
};
</script>

<style scoped>
.story-container {
  column-width: 250px;
  column-gap: 20px;
}
.story-card {
  background-color: rgb(207, 232, 220);
  border: 2px solid rgb(79, 185, 227);
  padding: 10px;
  margin: 0 0 1em 0;
}
</style>