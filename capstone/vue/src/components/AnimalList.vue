<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="..\assets\3035fb76965389.5c7945b0d0567.gif" />
    </div>
    <ul class="card-container">
      <animal-card
        v-for="animal in animals"
        :key="animal.animal_id"
        :animal="animal"
        :photo="animalPhotos.find((x) => x.animal_id == animal.animal_id)"
      >
      </animal-card>
    </ul>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService";
import AnimalCard from "@/components/AnimalCard";

export default {
  components: {
    AnimalCard,
  },
  name: "animal-list",
  data() {
    return {
      isLoading: true,
      errorMsg: "",
      animals: [],
      animalPhotos: [],
      offset: 0,
      limit: 15,
    };
  },
  methods: {
    seeAnimals() {
      shelterService.getAnimals().then((response) => {
        this.animals = response.data;
        this.isLoading = false;
      });
    },
    getPhotos() {
      shelterService.getAllPhotos().then((r) => {
        this.animalPhotos = r.data;
      });
    },
    getAnimalsPaginated() {
      shelterService.getAnimalsPaginated(this.limit, this.offset).then((r) => {
        this.animals = r.data;
        this.isLoading = false;
      });
    },
  },
  created() {
    this.getAnimalsPaginated();
    this.getPhotos();
  },
};
</script>

<style>
.card-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  padding: 0px 10px 10px 10px;
  margin-top: 0px;
}
</style>