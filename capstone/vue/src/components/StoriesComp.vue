<template>
  <div class="story-comp">
    <div class="story-container">
      <div class="story-card">
        <h3 class="story-title">Story Headline Here</h3>
        <p class="story-content">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
          assumenda possimus obcaecati at odio ad eligendi cumque placeat
          adipisci aspernatur iure aut qui dolorum, a dolor maiores rerum atque
          sequi!
        </p>
      </div>
      <div class="story-card">
        <h3 class="story-title">Story Headline Here</h3>
        <p class="story-content">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Minima totam
          debitis dignissimos asperiores magnam quis! Unde, repellendus
          doloremque dicta quibusdam reiciendis quasi provident ea perferendis
          excepturi ex commodi ad sunt?
        </p>
      </div>
      <div class="story-card">
        <h3 class="story-title">Story Headline Here</h3>
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
.story-comp {
  font-family: "Calibri", "Trebuchet MS", sans-serif;
}

.story-container {
  column-width: 250px;
  column-gap: 20px;
  border-radius: 4px;
  border-style: solid;
  border-width: 1px;
}
.story-card {
  /* background-color: rgb(207, 232, 220); */
  border-radius: 2px;
  border-style: solid;
  border-color: rgb(79, 185, 227);
}

.story-title {
  text-align: center;
}

.story-content {
  font-size: 14px;
  text-align: center;
}
</style>