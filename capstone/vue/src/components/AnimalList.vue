<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="..\assets\3035fb76965389.5c7945b0d0567.gif" />
    </div>
    <ul v-for="animal in animals" :key="animal.animal_id">
      <li>{{ animal.name }}</li>
      <li>{{ animal.breed }}</li>
      <li>{{ animal.age }}</li>
      <li>{{ animal.animal_id }}</li>
    </ul>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService";

export default {
  name: "animal-list",
  data() {
    return {
      isLoading: true,
      errorMsg: "",
      animals: [],
    };
  },
  methods: {
    seeAnimals() {
      shelterService.getAnimals().then((response) => {
        this.animals = response.data;
        this.isLoading = false;
      });
    },
  },
  created() {
    this.seeAnimals();
  },
};
</script>

<style>
</style>