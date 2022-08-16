<template>
  <div id="fullList">
    <div id="dogs" @click="$router.push('animals/type/1')">
      <h3>Browse Dogs</h3>
      <animal-card :animal="animals[0]" :photo="animals[0]" />
    </div>
    <div id="cats" @click="$router.push('animals/type/2')">
      <h3>Browse Cats</h3>
      <animal-card :animal="animals[1]" :photo="animals[1]" />
    </div>
    <div id="farm" @click="$router.push('animals/type/3')">
      <h3>Browse Farm Animals</h3>
      <animal-card :animal="animals[2]" :photo="animals[2]" />
    </div>
    <div id="small" @click="$router.push('animals/type/4')">
      <h3>Browse Small Animals</h3>
      <animal-card :animal="animals[3]" :photo="animals[3]" />
    </div>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService";
import AnimalCard from "./AnimalCard.vue";

export default {
  data() {
    return {
      animals: [],
    };
  },
  components: { AnimalCard },
  methods: {
    getCards() {
      shelterService.oneOfEach().then((x) => {
        this.animals = x.data;
      });
    },
  },
  created() {
    this.getCards();
  },
};
</script>

<style>
h3 {
  font-family: "Calibri", "Trebuchet MS", sans-serif;
}

#dogs {
  grid-area: ga-dogs;
  margin: auto;
  scale: 125%;
}

#cats {
  grid-area: ga-cats;
  margin: auto;
  scale: 125%;
}

#farm {
  grid-area: ga-farm;
  margin: auto;
  margin-top: 5%;
  scale: 125%;
}

#small {
  grid-area: ga-small;
  margin: auto;
  margin-top: 5%;
  scale: 125%;
}

#fullList {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "ga-dogs ga-cats"
    "ga-farm ga-small";

  border: 1px solid black;
  height: 100vh;

  /* justify-content: center;
  align-content: center; */
}
</style>