<template>
  <div>
    <div>
      <img :src="photo" alt="Animal Photo Here" id="detail-photo" />
      <h1>{{ animal.name }}</h1>
      <br />
      <li>{{ animal.age }} Years Old</li>
      <li>{{ animalType }} - {{ animal.breed }}</li>
      <li>{{ animal.bio }}</li>
    </div>
    <button @click="editing = !editing">EDIT</button> <br />
    <form v-if="editing == true">
      <label>Name: </label>
      <input type="text" v-model="animal.name" /><br />
      <label>Age: </label><input type="number" v-model="animal.age" /><br />
      <label>Breed: </label><input type="text" v-model="animal.breed" /><br />
      <label>Bio: </label><input type="text" v-model="animal.bio" />
      <button type="submit" @click.prevent="updateAnimalCard(animalId, animal)">
        Submit
      </button>
    </form>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService";
export default {
  data() {
    return {
      animal: { name: "", age: "", breed: "", bio: "" },
      isLoading: true,
      photo: "",
      editing: false,
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
      this.isLoading = true;
      shelterService.getAnimalById(animalId).then((response) => {
        this.animal = response.data;
        this.isLoading = false;
      });
    },
    getPhotoById(animalId) {
      shelterService.getPhotoById(animalId).then((response) => {
        this.photo = response.data.photo_link;
      });
    },
    updateAnimalCard(animalId, animal) {
      shelterService.updateAnimalCard(animalId, animal).then((response) => {
        if (response.status === 200) {
          this.animal = response.data;
        }
      });
    },
  },
  created() {
    this.getAnimalById(this.$route.params.id);
    this.getPhotoById(this.$route.params.id);
  },
};
</script>

<style>
#detail-photo {
  width: 500px;
}
</style>