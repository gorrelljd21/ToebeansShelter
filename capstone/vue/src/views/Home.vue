<template>
  <div class="home">
    <div class="header">
      <header-comp></header-comp>
    </div>
    <div class="nav">
      <nav-comp></nav-comp>
    </div>
    <div class="main">
      <animal-list></animal-list>
    </div>
    <div class="story">
      <stories-comp></stories-comp>
    </div>
    <div class="feet">
      <foot-view />
    </div>
  </div>
</template>

<script>
import AnimalList from "@/components/AnimalList.vue";
import HeaderComp from "@/components/HeaderComp.vue";
import NavComp from "@/components/NavComp.vue";
import StoriesComp from "@/components/StoriesComp.vue";
import FootView from "@/components/FootView.vue";

export default {
  name: "home",
  components: {
    AnimalList,
    HeaderComp,
    NavComp,
    StoriesComp,
    FootView,
  },
};
</script>

<style scoped>
.header {
  grid-area: ga-header;
}

.nav {
  grid-area: ga-nav;
}

.main {
  grid-area: ga-main;
}

.story {
  grid-area: ga-story;
}

.feet {
  grid-area: ga-feet;
}

.home {
  display: grid;
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas:
    "ga-header  ga-header ga-header"
    "ga-nav     ga-main   ga-story"
    "ga-nav     ga-feet   ga-feet";
  gap: 10px;
}
</style> 