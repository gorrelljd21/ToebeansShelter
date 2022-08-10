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
export default {
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
  /* border-radius: 8px; */
  margin-bottom: 20px;
}

.card__content {
  /* Take available height */
  flex: 1;
  margin: 0px;
  padding-bottom: 5px;
  margin-top: 0px;
  font-family: Arial, Helvetica, sans-serif;
  color: black;
  padding-left: 10px;
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
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
</style>