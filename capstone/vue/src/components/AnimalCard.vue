<template>
  <div class="card">
    <!-- Cover -->
    <div class="card__cover">
      <img :src="photo.photo_link" alt="" />
    </div>

    <!-- Content -->
    <div class="card__content">
      <div class="petname">
        {{ animal.name }}
      </div>
      <br />
      <div class="petinfo">
        {{ animal.age }} Years Old<br />
        {{ animalType }} - {{ animal.breed }}<br />
      </div>
    </div>
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
  border-radius: 8px;
  margin-bottom: 20px;
}

.card__content {
  /* Take available height */
  flex: 1;
  margin: 5px;
  font-family: Arial, Helvetica, sans-serif;
  color: black;
  padding-left: 2px;
}

.card:hover {
  opacity: 0.5;
}

img {
  width: 180px;
  border-radius: 10px;
  height: 150px;
  object-fit: cover;
  padding: 7px;
}

.petinfo {
  font-size: 0.9em;
}

.petname {
  font-weight: bold;
}

@media screen and (max-width: 450px) {
  .card {
    max-width: 150px;
    margin: 10px 10px 0px 10px;
  }

  img {
    width: 135px;
  }
}
</style>