<template>
  <div id="approval-container">
    <div>
      <h3>For Pending Volunteers</h3>
      <button></button>
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
    listVolunteers() {
      ShelterService.getVolunteers().then((response) => {
        this.volunteers = response.data;
      });
    },
  },
};
</script>

<style lang="scss" scoped>
</style>