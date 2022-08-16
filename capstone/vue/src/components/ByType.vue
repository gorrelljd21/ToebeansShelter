<template>
  <div>
    <div @click="$router.push('animals/type/1')">
      <h3>Dogs</h3>
      <animal-card :animal="animals[0]" :photo="animals[0]" />
    </div>
    <div @click="$router.push('animals/type/2')">
      <h3>Cats</h3>
      <animal-card :animal="animals[1]" :photo="animals[1]" />
    </div>
    <div @click="$router.push('animals/type/3')">
      <h3>Farm Animals</h3>
      <animal-card :animal="animals[2]" :photo="animals[2]" />
    </div>
    <div @click="$router.push('animals/type/4')">
      <h3>Small Animals</h3>
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
</style>