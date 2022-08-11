<template>
  <div></div>
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