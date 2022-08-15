<template>
  <div id="whole">
    <form id="addPet">
      <h2>Help us find your pet a new home</h2>
      <label for="pets-name">Animal name: </label>
      <input
        type="text"
        placeholder="Pet's name"
        name="pets-name"
        id="pets-name"
        required
        v-model="animal.name"
      />
      <br />
      <br />
      <label for="type">Type of animal: </label>
      <select name="type" id="animal-type" v-model="animal.animal_type_id">
        <option value="1">Dog</option>
        <option value="2">Cat</option>
        <option value="3">Farm Animal</option>
        <option value="4">Small Animal</option>
      </select>
      <br />
      <br />
      <label for="breed">Breed: </label>
      <input
        type="text"
        name="breed"
        id="breed"
        placeholder="Pet's breed"
        v-model="animal.breed"
      />
      <br />
      <br />
      <label for="why">Add a short bio for this pet's future owners: </label>
      <br />
      <br />
      <textarea
        name="why"
        id="why"
        cols="55"
        rows="5"
        style="resize: none"
        placeholder="Are they good with other pets, any medical issues, etc."
        v-model="animal.bio"
      ></textarea>
      <br />
      <br />
      <label for="age">Pet approximate age: </label>
      <input
        type="number"
        name="age"
        placeholder="add birthday if known"
        v-model="animal.age"
        required
      />
      <br />
      <br />
      <label for="photo">Add a photo link: </label>
      <input
        type="text"
        name="photo"
        v-model="animal.link"
        placeholder=".png only"
        required
      />
      <br />
      <br />
      <button type="submit" @click.prevent="addAnimal">
        Place for Adoption
      </button>
    </form>
  </div>
</template>

<script>
import ss from "@/services/ShelterService";
export default {
  data() {
    return {
      animal: {
        age: "",
        name: "",
        breed: "",
        link: "",
        bio: "",
        animal_type_id: "",
      },
      accepted: false,
      rejected: false,
    };
  },
  methods: {
    //NEEDS TESTING
    addAnimal() {
      ss.addAnimal(this.animal)
        .then((r) => {
          if (r.status == 201) {
            this.accepted = true;
            this.$emit("submitted-animal", this.animal);
            alert("Successfully Added!");
          }
        })
        .catch((err) => {
          if (err.response.status == 401) {
            alert("Something went wrong! (User not authorized)");
          }
          console.log(err);
        });
    },
  },
};
</script>

<style scoped>
* {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

h1 {
  margin-left: 40px;
}

input,
select,
textarea {
  background-color: white;
}
input {
  background-color: white;
  border-width: 1px;
}

label {
  background-color: #e8e9eb;
}

form {
  margin-left: 20px;
  border: 1px solid black;
  margin: auto;
  margin-top: 10%;
  padding: 0px 0px 20px 20px;
  width: 600px;
  display: block;
  border-radius: 10px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px,
    rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
  width: 600px;
  background-color: #e8e9eb;
}
h1 {
  display: flex;
  justify-content: center;
  padding: 10px;
  margin: 0;
}

h2 {
  background-color: #6eb8b6;
  padding: 5px 5px 5px 12px;
  border-radius: 3px;
  margin-right: 40%;
  color: aliceblue;
  border: 1px solid black;
}

button {
  margin-top: 20px;
  background-color: #e8e9eb;
  border-width: 1px;
  border-radius: 4px;
}
</style>