<template>
  <div class="card">
    <!-- Cover -->
    <div class="card__cover">
      <img :src="photo.photo_link" alt="" />
    </div>

    <!-- Content -->
    <div class="card__content">
      {{ animal.name }}<br />
      {{ animal.age }} Years Old<br />
      {{ animalType }} - {{ animal.breed }}
      {{ photo.photo_link }}
    </div>
    ...
  </div>
</template>



<script>
import shelterService from "@/services/ShelterService";
export default {
  photoLink: "",
  props: ["animal", "photo"],
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
    animalPic() {
      this.getPhoto();
      return this.photoLink;
    },
  },
  methods: {
    getPhoto() {
      shelterService
        .getPhotoById(this.animal.animal_id)
        .then((r) => (this.photoLink = r.data.photo_link));
    },
  },
  created() {
    this.getPhoto;
  },
};
</script>

<style scoped>
.card {
  display: flex;
  flex-direction: column;
  border: solid 1px black;
  max-width: 200px;
  color: aliceblue;
}

.card__cover {
  height: 150px;
  width: 100%;
}

.card__content {
  /* Take available height */
  flex: 1;
}

img {
  max-width: 100%;
}
</style>