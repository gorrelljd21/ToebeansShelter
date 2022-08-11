<template>
  <div>
    <ul>
      <li v-for="volunteer in volunteers" v-bind:key="volunteer.id">
        {{ volunteer.full_name }}
      </li>
    </ul>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService.js";
export default {
  data() {
    return {
      volunteers: [],
    };
  },
  methods: {
    getVolunteers() {
      shelterService.getVolunteers().then((response) => {
        this.volunteers = response.data;
      });
    },
  },
};
</script>

<style scoped>
</style>