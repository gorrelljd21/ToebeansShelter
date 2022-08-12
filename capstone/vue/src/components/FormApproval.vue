<template>
  <div id="approval-container">
    <div>
      <h3>Select Volunteer</h3>

      <ul v-for="volunteer in volunteers" v-bind:key="volunteer.volunteer_id">
        <li>{{ volunteer.full_name }}, {{ volunteer.volunteer_id }}</li>
      </ul>
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
      volunteers: [
        {
          volunteer_id: "",
          full_name: "",
        },
      ],
    };
  },
  created() {
    this.getVolunteers();
  },

  methods: {
    getVolunteers() {
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
      ShelterService.changeAppStatus(this.volunteer_id, this.volunteer).then(
        (response) => {
          if (response.status === 200) {
            alert("Volunteer Application Approved!");
          }
        }
      );
    },
  },
  // computed: {
  //   isAdminUser() {
  //     return this.$store.state.user.authorities[0].name === "ROLE_ADMIN";
  //   },
  // },
};
</script>

<style scoped>
</style>