<template>
  <div>
    <h2>Volunteer Approval Status</h2>
    <table>
      <thead>
        <tr>
          <th>Volunteer ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Volunteer Status</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <td>
            <input
              type="text"
              id="volunteerId"
              v-model="volunteers.volunteer_id"
            />
          </td>
          <td>
            <input type="text" id="nameFilter" v-model="volunteers.full_name" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="volunteers.email" />
          </td>
          <td>
            <input
              type="text"
              id="phoneFilter"
              v-model="volunteers.phone_number"
            />
          </td>
          <td>
            <select id="statusFilter" v-model="volunteers.app_status">
              <option value="">Show All</option>
              <option value="Active">Active</option>
              <option value="Pending">Pending</option>
            </select>
          </td>
        </tr>

        <tr v-for="volunteer in volunteers" v-bind:key="volunteer.volunteer_id">
          <td>{{ volunteer.volunteer_id }}</td>
          <td>{{ volunteer.full_name }}</td>
          <td>{{ volunteer.email }}</td>
          <td>{{ volunteer.phone_number }}</td>
          <td>{{ volunteer.app_status }}</td>
        </tr>
      </tbody>
    </table>
    <h3>For Pending Volunteers</h3>
    <button type="submit" id="approve" @click="approveApplication()">
      APPROVE
    </button>
    <button type="submit" id="deny" @click="denyApplication()">DENY</button>
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
          email: "",
          phone_number: "",
          app_status: "",
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