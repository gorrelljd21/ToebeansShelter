<template>
  <div id="approval-container">
    <div>
      <h3>For Pending Volunteers</h3>
      <button type=""></button>
      <button></button>
    </div>
  </div>
</template>

<script>
import ShelterService from "@/services/ShelterService.js";

export default {
  name: "form-approval",
  data() {
    return {
      volunteers: [],
    };
  },
  methods: {
    created() {
      this.getVolunteers();
    },
    listVolunteerApps() {
      ShelterService.getVolunteers().then((response) => {
        this.volunteers = response.data;
      });
    },
  },
};
</script>

<style scoped>
</style>