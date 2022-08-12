<template>
  <div id="approval-container">
    <div>
      <h3>For Pending Volunteers</h3>
      <button type="submit" id="approve" @click="approveApplication()">
        APPROVE
      </button>
      <button type="submit" id="deny" @click="denyApplication()">DENY</button>
    </div>
  </div>
</template>

<script>
import ShelterService from "@/services/ShelterService.js";

export default {
  name: "form-approval",
  data() {
    return {
      props: ["volunteer", "volunteer_id"],
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
    denyApplication() {
      ShelterService.deleteVolunteer(this.volunteer_id)
        .then((response) => {
          if (response.status === 200) {
            alert("Volunteer Application Removed!");
          }
        })
        .catch((error) => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
    },
    approveApplication() {
      ShelterService.approveNewVolunteer(
        this.volunteer_id,
        this.volunteer
      ).then((response) => {
        if (response.status === 200) {
          alert("Volunteer Application Approved!");
        }
      });
    },
  },
};
</script>

<style scoped>
</style>