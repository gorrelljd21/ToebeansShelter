<template>
  <div>
    <div class="loading" v-if="isLoading">
      <img id="bunny" src="..\assets\hopping.gif" />
    </div>
    <ul class="card-container">
      <animal-card
        @click.native="goToDetailPage(animal.animal_id)"
        v-for="animal in currentAnimals"
        :key="animal.animal_id"
        :animal="animal"
        :photo="animalPhotos.find((x) => x.animal_id == animal.animal_id)"
        v-show="!isLoading"
      >
      </animal-card>
    </ul>
    <div class="bottomComponent">
      <div class="pagination">
        <button
          id="back-btn"
          @click="
            page--;
            getAnimalsPaginated();
          "
          v-show="page > 1"
        >
          Back
        </button>
        <button
          id="next-btn"
          @click="
            page++;
            getAnimalsPaginated();
          "
          v-show="page < 4"
          v-if="!isLoading"
        >
          Next
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
      limit: 15,
      page: 1,
      currentAnimals: [],
      isDisabled: false,
    };
  },
  methods: {
    getAnimalsPaginated() {
      this.isLoading = true;
      shelterService
        .getFullAnimalByTypePaginated(
          this.limit,
          (this.page - 1) * this.limit,
          this.$route.params.id
        )
        .then((r) => {
          this.currentAnimals = r.data;
          this.animalPhotos = r.data;
          this.isLoading = false;
        });
    },
    goToDetailPage(id) {
      this.$router.push({ name: "animal-detail", params: { id: id } });
    },
  },
  computed: {
    numberOfPages() {
      return Math.ceil(this.animalPhotos.length / this.limit);
    },
  },

  created() {
    this.getAnimalsPaginated();
  },
};
</script>

<style>
.loading {
  margin: 20% 10% 0% 45%;
}
#bunny {
  width: 100px;
}
.bottomComponent {
  display: flex;
  justify-content: flex-end;
  align-content: center;
  font-family: "Calibri", "Trebuchet MS", sans-serif;
  margin-right: 1.5%;
}
.card-container {
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
  border: 1px solid black;
  border-radius: 4px;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px,
    rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
}
.pagination > button:hover {
  background-color: #f78154;
  color: black;
}
.currentPage {
  color: #4c5454 !important;
  opacity: 50%;
  font-weight: bolder;
}
@media screen and (max-width: 450px) {
  .card-container {
    padding: 0px 20px 10px 30px;
    gap: 5px;
  }

  .pagination {
    margin-right: -30px;
  }

  .pagination #back-btn #next-btn {
    margin-right: 70px;
  }

  .pagination > button {
    margin-right: 100px;
  }
}
</style>