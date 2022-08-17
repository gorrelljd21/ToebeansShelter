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
      // shelterService.then((x) => {
      //   this.adoptedAnimals = x.data;
      // });
    },
  },
  created() {
    this.getAdoptedAnimals();
  },
};
</script>

<style scoped>
</style>