<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img src="..\assets\3035fb76965389.5c7945b0d0567.gif" />
    </div>
    <ul class="card-container">
      <animal-card
        v-for="animal in currentAnimals"
        :key="animal.animal_id"
        :animal="animal"
        :photo="animalPhotos.find((x) => x.animal_id == animal.animal_id)"
      >
      </animal-card>
    </ul>
    <div class="bottomComponent">
      <div class="pagination">
        <button
          v-for="num in numberOfPages"
          :key="num"
          @click="
            page = num;
            getAnimalsPaginated();
          "
          :class="{ currentPage: page == num }"
        >
          {{ num }}
        </button>
      </div>
    </div>
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
      animalPhotos: [],
      offset: 0,
      limit: 15,
      page: 1,
      currentAnimals: [],
    };
  },
  methods: {
    getPhotos() {
      shelterService.getAllPhotos().then((r) => {
        this.animalPhotos = r.data;
      });
    },
    getAnimalsPaginated() {
      this.isLoading = true;
      shelterService
        .getAnimalsPaginated(this.limit, (this.page - 1) * this.limit)
        .then((r) => {
          this.currentAnimals = r.data;
          this.isLoading = false;
        });
    },
  },
  computed: {
    numberOfPages() {
      return Math.ceil(this.animalPhotos.length / this.limit);
    },
  },
  created() {
    this.getAnimalsPaginated();
    this.getPhotos();
  },
};
</script>

<style>
.bottomComponent {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  font-family: Calibri, "Trebuchet MS", sans-serif;
}
.card-container {
  position: relative center;
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  padding: 0px 10px 10px 10px;
  margin-top: 0px;
}

.pagination {
  display: flex;
  align-items: center;
  margin: 10px;
}
.pagination > button {
  margin: 5px;
  background-color: #44a1a0;
  border: none;
  border-radius: 10px;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

.pagination > button:hover {
  opacity: 50%;
}

.currentPage {
  color: #4c5454 !important;
  opacity: 50%;
  font-weight: bolder;
}
</style>