<template>
  <div>
    <ul>
      <animal-card v-for="animal in adoptedAnimals" :key="animal.animal_id">
      </animal-card>
    </ul>
  </div>
</template>

<script>
import AnimalCard from "@/components/AnimalCard";
import shelterService from "@/services/ShelterService.js";

export default {
  components: {
    AnimalCard,
  },
  name: "adopted-animals",
  data() {
    return {
      adoptedAnimals: [],
    };
  },
  methods: {
    getAdoptedAnimals() {
      shelterService.getAdoptedAnimals().then((response) => {
        if (response.status === 200) {
          this.adoptedAnimals = response.data;
        }
      });
    },
  },
  created() {
    this.getAdoptedAnimals();
  },
};
</script>

<style scoped>
</style>