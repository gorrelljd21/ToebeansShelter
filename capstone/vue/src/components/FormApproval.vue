<template>
  <div id="approval-container">
    <div>
      <h3>For Pending Volunteers</h3>
      <button type="submit">APPROVE</button>
      <button type="submit">DENY</button>
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
    denyApplication(id) {
      ShelterService.deleteVolunteer(id).then((response) => {
        if (response.status === 200) {
          this.getVolunteers();
        }
      });
    },
  },
};
</script>

<style scoped>
</style>