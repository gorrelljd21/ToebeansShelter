<template>
  <div>
    <form id="addPet">
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
      <label for="type">Type of animal: </label>
      <select name="type" id="animal-type" v-model="animal.animal_type_id">
        <option value="1">Dog</option>
        <option value="2">Cat</option>
        <option value="3">Farm Animal</option>
        <option value="4">Small Animal</option>
      </select>
      <br />
      <label for="breed">Breed: </label>
      <input type="text" name="breed" id="breed" v-model="animal.breed" />
      <br />
      <label for="why">Add a short bio for this pet's future owners: </label>
      <br />
      <textarea
        name="why"
        id="why"
        cols="55"
        rows="5"
        style="resize: none"
        v-model="animal.bio"
      ></textarea>
      <br />
      <label for="age">Pet approximate age:</label>
      <input type="number" name="age" v-model="animal.age" required />
      <br />
      <label for="photo">Add a photo link: </label>
      <input type="text" name="photo" v-model="animal.link" required />
      <br />
      <button type="submit" @click.prevent="addAnimal">Submit</button>
    </form>
    <h1 v-if="accepted">successfully added</h1>
    <!-- PROBABLY CHANGE ME -->
    <h1 v-if="rejected">
      Something went horribly wrong, it probably wasn't your fault :)
    </h1>
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
          }
          if (r.status == 400) {
            this.rejected = true;
          }
          //todo
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style scoped>
.main {
  border: 1px solid black;
  display: block;
  height: 100vh;
  margin: 0px 25px 0px 25px;
}
* {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}
h1,
h2 {
  color: #313638;
}
input,
select,
textarea {
  background-color: white;
}
</style>