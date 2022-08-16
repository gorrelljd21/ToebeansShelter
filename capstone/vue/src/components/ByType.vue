<template>
  <div>
    <h3>Dogs</h3>
    <animal-card :animal="animals[0]" :photo="animals[0]" />
    <h3>Cats</h3>
    <animal-card :animal="animals[1]" :photo="animals[1]" />
    <h3>Farm Animals</h3>
    <animal-card :animal="animals[2]" :photo="animals[2]" />
    <h3>Small Animals</h3>
    <animal-card :animal="animals[3]" :photo="animals[3]" />
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