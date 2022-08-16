<template>
  <div>
    <img src="photo.photo_link" alt="Animal Photo Here" />
    <h1>{{ animal.name }}</h1>
    <br />
    <li>{{ animal.age }} Years Old</li>
    <li>{{ animalType }} - {{ animal.breed }}</li>
    <li>{{ animal.bio }}</li>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService";
export default {
  data() {
    return {
      animal: {
        name: "",
        age: "",
        animalType: "",
        bio: "",
      },
    };
  },
  computed: {
    animalType() {
      if (this.animal.animal_type_id == 1) {
        return "Dog";
      } else if (this.animal.animal_type_id == 2) {
        return "Cat";
      } else if (this.animal.animal_type_id == 3) {
        return "Farm Animal";
      } else {
        return "Small Animal";
      }
    },
  },

  methods: {
    getAnimalById(animalId) {
      shelterService.getAnimalById(animalId).then((response) => {
        this.animal = response.data;
      });
    },
  },
};
</script>

<style>
</style>