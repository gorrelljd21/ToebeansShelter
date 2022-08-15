<template>
  <div>
    <table>
      <h2>Volunteer Approval Status</h2>
      <thead>
        <tr>
          <!-- <th>Volunteer ID</th> -->
          <th>Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Volunteer Status</th>
          <th>Application Form</th>
          <th>Select</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <!-- <td>
            <input
              type="text"
              id="volunteerId"
              v-model="volunteers.volunteer_id"
            />
          </td> -->
          <td>
            <input type="text" id="nameFilter" v-model="filter.full_name" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.email" />
          </td>
          <td>
            <input type="text" id="phoneFilter" v-model="filter.phone_number" />
          </td>

          <td>
            <select id="statusFilter" v-model="filter.app_status">
              <option value="APPROVED">APPROVED</option>
              <option value="PENDING">PENDING</option>
              <option value="">SHOW ALL</option>
            </select>
          </td>
          <td>
            <input type="text" id="appForm" v-model="filter.app_form" />
          </td>
          <td>
            <input
              type="checkbox"
              id="selectAll"
              @change="selectAllVolunteers"
            />
          </td>
        </tr>

        <tr
          v-for="volunteer in filteredList"
          v-bind:key="volunteer.volunteer_id"
        >
          <!-- <td>{{ volunteer.volunteer_id }}</td> -->
          <td>{{ volunteer.full_name }}</td>
          <td>{{ volunteer.email }}</td>
          <td>{{ volunteer.phone_number }}</td>
          <td>{{ volunteer.app_status }}</td>
          <td>{{ volunteer.bio }}</td>
          <td>
            <input
              type="checkbox"
              id="selectVolunteerApp"
              @click="addSelectedVolunteers"
              v-bind:key="volunteer.volunteer_id"
              v-bind:value="volunteer.volunteer_id"
              v-model.number="selectedVolunteers"
            />
          </td>
        </tr>
      </tbody>
      <!-- <h3>For Pending Volunteers</h3> -->
      <button
        disableButtons
        type="submit"
        id="approve"
        @click.prevent="updateSelected(approved)"
      >
        APPROVE
      </button>

      <button
        disableButtons
        type="submit"
        id="deny"
        @click.prevent="updateSelected(denied)"
      >
        DENY
      </button>

      <button
        disableButtons
        type="submit"
        id="delete-app"
        @click.prevent="deleteSelectedVolunteers"
      >
        DELETE
      </button>
      <button type="submit" id="clear" @click.prevent="clearSelected">
        CLEAR
      </button>
    </table>
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
          phone_number: "",
          email: "",
          bio: "",
          ref_full_name: "",
          ref_phone_number: "",
          ref_email: "",
          app_status: "",
        },
      ],
      filter: {
        volunteer_id: "",
        full_name: "",
        email: "",
        phone_number: "",
        app_form: "",
        app_status: "",
      },
      selectedVolunteers: [],
      approved: "APPROVED",
      denied: "DENIED",
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
    clearSelected() {
      this.selectedVolunteers = [];
      this.getVolunteers();
    },
    addSelectedVolunteers() {
      this.selectedVolunteers.push(this.volunteer.volunteer_id);
    },
    selectAllVolunteers() {
      this.volunteers.forEach((volunteer) => {
        if (this.selectedVolunteers.indexOf(volunteer.volunteer_id) === -1) {
          this.selectedVolunteers.push(volunteer.volunteer_id);
        } else {
          this.selectedVolunteers.splice(
            this.selectedVolunteers.indexOf(volunteer.volunteer_id),
            1
          );
        }
      });
    },
    deleteSelectedVolunteers() {
      this.selectedVolunteers.forEach((volunteer) => {
        let selected = this.volunteers.find(
          (f) => f.volunteer_id === volunteer
        );
        return this.removeApplication(selected.volunteer_id);
      });
    },
    removeApplication(volunteer_id) {
      ShelterService.deleteVolunteer(volunteer_id)
        .then((response) => {
          if (response.status === 200) {
            alert("Application Removed!");
          }
        })
        .catch((error) => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
      this.clearSelected();
    },
    updateSelected(newStatus) {
      this.selectedVolunteers.forEach((volunteer) => {
        let selected = this.volunteers.find(
          (f) => f.volunteer_id === volunteer
        );
        selected.app_status = newStatus;
        return this.updateApplications(selected.volunteer_id, selected);
      });
    },
    updateApplications(volunteer_id, volunteer) {
      ShelterService.changeAppStatus(volunteer_id, volunteer)
        .then((response) => {
          if (response.status === 200) {
            alert("Application changed");
          }
        })
        .catch((error) => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
      this.clearSelected();
    },
  },
  // computed: {
  //   isAdminUser() {
  //     return this.$store.state.user.authorities[0].name === "ROLE_ADMIN";
  //   },
  // },

  computed: {
    filteredList() {
      return this.volunteers.filter((volunteer) => {
        return (
          volunteer.full_name
            .toLowerCase()
            .includes(this.filter.full_name.toLowerCase()) &&
          volunteer.email
            .toLowerCase()
            .includes(this.filter.email.toLowerCase()) &&
          volunteer.phone_number.includes(this.filter.phone_number) &&
          volunteer.app_status.includes(this.filter.app_status)
        );
      });
    },
    disableButtons() {
      return this.selectedVolunteers.length === 0;
    },
  },
};
</script>

<style scoped>
div {
  border: 1px solid black;
  display: block;
  height: 100vh;
  margin: 0px 25px 0px 25px;
}

* {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

input,
select,
textarea {
  background-color: white;
}

input {
  background-color: white;
  border-width: 1px;
}

label {
  background-color: #e8e9eb;
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

h2,
h3 {
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

/* #delete-app {
  margin-left: 5%;
} */
</style>