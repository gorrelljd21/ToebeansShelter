<template>
  <div id="whole">
    <h2 v-if="adoptedAnimals.length === 0">No pets recently adopted :(</h2>
    <div id="one">
      <h3 v-if="adoptedAnimals.length >= 1">
        {{ adoptedAnimals[0].bio }}
      </h3>
      <animal-card :animal="adoptedAnimals[0]" :photo="adoptedAnimals[0]">
      </animal-card>
    </div>
    <div id="two">
      <h3 v-if="adoptedAnimals.length >= 2">
        {{ adoptedAnimals[1].bio }}
      </h3>
      <animal-card :animal="adoptedAnimals[1]" :photo="adoptedAnimals[1]">
      </animal-card>
    </div>
    <div id="three">
      <h3 v-if="adoptedAnimals.length >= 3">
        {{ adoptedAnimals[2].bio }}
      </h3>
      <animal-card :animal="adoptedAnimals[2]" :photo="adoptedAnimals[2]">
      </animal-card>
    </div>
    <div id="four">
      <h3 v-if="adoptedAnimals.length === 4">
        {{ adoptedAnimals[3].bio }}
      </h3>
      <animal-card :animal="adoptedAnimals[3]" :photo="adoptedAnimals[3]">
      </animal-card>
    </div>
  </div>
</template>

<script>
import AnimalCard from "@/components/AnimalCard";
import shelterService from "@/services/ShelterService";

export default {
  components: {
    AnimalCard,
  },
  name: "adopted-animals",
  data() {
    return {
      adoptedAnimals: [],
    };
  },
  methods: {
    getAdoptedAnimals() {
      shelterService.getFourAdopted().then((x) => {
        this.adoptedAnimals = x.data;
      });
    },
  },
  created() {
    this.getAdoptedAnimals();
  },
};
</script>

<style scoped>
#whole {
  border: 1px solid black;
  height: 100vh;
  margin: 0px 25px 0px 25px;
}

h2 {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
  text-align: center;
}

#one {
  grid-area: ga-one;
  margin: auto;
  scale: 125%;
}

#two {
  grid-area: ga-two;
  margin: auto;
  scale: 125%;
}

#three {
  grid-area: ga-three;
  margin: auto;
  margin-top: 5%;
  scale: 125%;
}

#four {
  grid-area: ga-four;
  margin: auto;
  margin-top: 5%;
  scale: 125%;
}

#whole {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "ga-one ga-two"
    "ga-three ga-four";
  border: 1px solid black;
  height: 100vh;

  /* justify-content: center;
  align-content: center; */
}
</style>