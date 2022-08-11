<template>
  <div class="story-comp">
    <div class="story-container">
      <div class="story-card">
        <h3 class="story-title">Opossum Finds New Home At ToeBeans</h3>
        <p class="story-content">
          By: ToeBeans Staff Lorem ipsum dolor sit amet consectetur adipisicing
          elit. Accusantium assumenda possimus obcaecati at odio ad eligendi
          cumque placeat adipisci aspernatur iure aut qui dolorum, a dolor
          maiores rerum atque sequi! Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Accusantium assumenda possimus obcaecati at odio ad
          eligendi cumque placeat adipisci aspernatur iure aut qui dolorum, a
          dolor maiores rerum atque sequi! Lorem ipsum dolor sit amet
          consectetur adipisicing elit. Accusantium assumenda possimus obcaecati
          at odio ad eligendi cumque placeat adipisci aspernatur iure aut qui
          dolorum, a dolor maiores rerum atque sequi!
        </p>
      </div>
      <div class="story-card">
        <h3 class="story-title">ToeBeans to Host Adopt-athon This Saturday</h3>
        <p class="story-content">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Minima totam
          debitis dignissimos asperiores magnam quis! Unde, repellendus
          doloremque dicta quibusdam reiciendis quasi provident ea perferendis
          excepturi ex commodi ad sunt? Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Minima totam debitis dignissimos asperiores magnam
          quis! Unde, repellendus doloremque dicta quibusdam reiciendis quasi
          provident ea perferendis excepturi ex commodi ad sunt?
        </p>
      </div>
      <div class="story-card">
        <h3 class="story-title">
          Elderly Rat Adopts Four Baby Turtles as Sons
        </h3>
        <p class="story-content">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium
          assumenda possimus obcaecati at odio ad eligendi cumque placeat
          adipisci aspernatur iure aut qui dolorum, a dolor maiores rerum atque
          sequi! Lorem ipsum dolor sit amet consectetur adipisicing elit.
          Accusantium assumenda possimus obcaecati at odio ad eligendi cumque
          placeat adipisci aspernatur iure aut qui dolorum, a dolor maiores
          rerum atque sequi! Lorem ipsum dolor sit amet consectetur adipisicing
          elit. Accusantium assumenda possimus obcaecati at odio ad eligendi
          cumque placeat adipisci aspernatur iure aut qui dolorum, a dolor
          maiores rerum atque sequi! Lorem ipsum dolor sit amet consectetur
          adipisicing elit. Accusantium assumenda possimus obcaecati at odio ad
          eligendi cumque placeat adipisci aspernatur iure aut qui dolorum, a
          dolor maiores rerum atque sequi!
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
  margin-right: 15px;
}

.story-container {
  column-width: 250px;
  column-gap: 20px;
  border-radius: 4px;
  border-style: solid;
  border-width: 1px;
}
.story-card {
  margin: 2px;
  /* background-color: rgb(207, 232, 220); */

  border-style: solid;
  border-color: #44a1a0;
}

.story-title {
  text-align: left;
  padding-left: 15px;
  padding-right: 15px;
  font-size: 16px;
}

.story-content {
  font-size: 14px;
  text-align: left;
  padding: 0px 15px 15px 15px;
  padding-bottom: 0px;
}

@media screen and (max-width: 450px) {
  .story-container {
    column-width: 210px;
    margin-right: 10px;
    margin-left: 20px;
  }
}
</style>