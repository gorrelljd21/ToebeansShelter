<template>
  <div id="whole">
    <div id="detail">
      <div id="imgcontainer">
        <img :src="photo" alt="Animal Photo Here" id="detail-photo" />
      </div>
      <h1 id="detailname">Name: {{ animal.name }}</h1>
      <br />
      <li class="detailli">Age: {{ animal.age }} Years Old</li>
      <li class="detailli">Type: {{ animalType }} - {{ animal.breed }}</li>
      <li class="detailli">Bio: {{ animal.bio }}</li>
      <li class="detailli">
        Adopted: {{ !animal.adopted ? "Needs a home" : "Has a home" }}
      </li>
      <br />

      <button
        @click="editing = !editing"
        v-if="isAdminUser() || isVolunteerUser()"
      >
        EDIT
      </button>
      <br />
      <form v-if="editing == true">
        <label>Name: </label>
        <input type="text" v-model="animal.name" /><br />
        <label>Age: </label
        ><input type="number" v-model.number="animal.age" /><br />
        <label>Breed: </label><input type="text" v-model="animal.breed" /><br />
        <label>Bio: </label><input type="text" v-model="animal.bio" /><br />
        <label>Found a home: </label>
        <input type="checkbox" v-model="animal.adopted" />
        <br />
        <button
          type="submit"
          id="submit"
          @click.prevent="updateAnimalCard(animal)"
        >
          Submit
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService";
export default {
  data() {
    return {
      animal: {},
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
      });
      this.isLoading = false;
    },
    getPhotoById(animalId) {
      shelterService.getPhotoById(animalId).then((response) => {
        this.photo = response.data.photo_link;
      });
    },
    updateAnimalCard(animal) {
      shelterService.updateAnimalCard(animal).then((response) => {
        if (response.status === 200) {
          this.animal = response.data;
        }
      });
    },
    isAdminUser() {
      if (!this.$store.state.user.authorities) {
        return false;
      }
      return this.$store.state.user.authorities[0].name === "ROLE_ADMIN";
    },
    isVolunteerUser() {
      if (!this.$store.state.user.authorities) {
        return false;
      }
      return this.$store.state.user.authorities[0].name === "ROLE_VOLUNTEER";
    },
  },
  created() {
    this.getAnimalById(this.$route.params.id);
    this.getPhotoById(this.$route.params.id);
  },
};
</script>

<style>
#imgcontainer {
  width: 400px;
  height: 400px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

#detailname,
.detailli {
  background-color: #e8e9eb;
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

.detailli {
  font-size: 20px;
}
#submit {
  margin-bottom: 10px;
}

#detail-photo {
  object-fit: cover;
  width: 100%;
  height: 100%;
  border: 1px solid black;
}

#detail {
  border: 1px solid black;
  margin-left: auto;
  margin-right: auto;
  margin-top: 2%;
  padding-top: 20px;
  width: 600px;
  /* height: 675px; */
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 10px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px,
    rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
  width: 600px;
  background-color: #e8e9eb;
}

#whole {
  border: 1px solid black;
  height: 100vh;
}

form,
input,
label,
button {
  background-color: #e8e9eb;
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

input,
button {
  margin-top: 5px;
  background-color: white;
}
</style>