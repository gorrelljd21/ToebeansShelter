<template>
  <div>
    <ul>
      <animal-card :animal="adoptedAnimals[0]" :photo="adoptedAnimals[0]">
      </animal-card>
    </ul>
  </div>
</template>

<script>
import AnimalCard from "@/components/AnimalCard";
import shelterService from "@/services/ShelterService";

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
      shelterService.getFourAdopted().then((x) => {
        this.adoptedAnimals = x.data; 
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