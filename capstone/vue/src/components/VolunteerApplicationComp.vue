<template>
  <div>
    <div class="main">
      <table>
        <h2>{{ volunteer.full_name }}</h2>
        <tr>
          <th>Phone Number:</th>
          <td>{{ volunteer.phone_number }}</td>
        </tr>
        <br />
        <tr>
          <th>E-mail:</th>
          <td>{{ volunteer.email }}</td>
        </tr>
        <br />
        <tr>
          <th>Bio:</th>
          <td>{{ volunteer.bio }}</td>
        </tr>
        <br />
        <tr>
          <th>Reference Name:</th>
          <td>{{ volunteer.ref_full_name }}</td>
        </tr>
        <br />
        <tr>
          <th>Reference Phone Number:</th>
          <td>{{ volunteer.ref_phone_number }}</td>
        </tr>
        <br />
        <tr>
          <th>Reference E-mail:</th>
          <td>{{ volunteer.ref_email }}</td>
        </tr>
        <button>
          <router-link id="link" to="/volunteer-requests">Back</router-link>
        </button>
      </table>
    </div>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService";

export default {
  name: "view-volunteer-application",

  data() {
    return {
      volunteer: {
        full_name: "",
        phone_number: "",
        email: "",
        bio: "",
        ref_full_name: "",
        ref_phone_number: "",
        ref_email: "",
      },
    };
  },
  methods: {
    getVolunteerById(volunteer_id) {
      this.$router.push(`/volunteers/${volunteer_id}`);
    },
  },
  created() {
    shelterService
      .getVolunteerById(this.$route.params.volunteer_id)
      .then((response) => {
        this.volunteer = response.data;
      });
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

table {
  margin-left: 20px;
  border: 1px solid black;
  margin: auto;
  margin-top: 10%;
  padding: 0px 0px 20px 20px;
  display: block;
  border-radius: 10px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px,
    rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
  width: 90%;
  background-color: #e8e9eb;
}

th,
td {
  background-color: #e8e9eb;
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
  margin-right: 10px;
  background-color: #e8e9eb;
  border-width: 1px;
  border-radius: 4px;
}

#link {
  text-decoration: none;
  background-color: #e8e9eb;
  color: black;
}
</style>