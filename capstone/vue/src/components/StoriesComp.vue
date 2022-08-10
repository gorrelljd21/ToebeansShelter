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
      <div class="story-card">
        <h2 class="story-title">Story Headline Here</h2>
        <p class="story-content">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Minima totam
          debitis dignissimos asperiores magnam quis! Unde, repellendus
          doloremque dicta quibusdam reiciendis quasi provident ea perferendis
          excepturi ex commodi ad sunt?
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
  border: solid;
  border-radius: 2px;
}
.story-card {
  background-color: rgb(207, 232, 220);
  border: 2px solid rgb(79, 185, 227);
}

@media screen and (max-width: 450px) {
  .story-container {
    column-width: 210px;
    margin-right: 10px;
    margin-left: 20px;
  }
}
</style>