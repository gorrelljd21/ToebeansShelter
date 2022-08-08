<template>
  <div class="loading" v-if="isLoading">
    <img src="..\assets\3035fb76965389.5c7945b0d0567.gif" />
    <input type="text" />
    <label for="">See animals</label>
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
};
</script>

<style>
</style>