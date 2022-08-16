<template>
  <div>
    <table>
      <h2 v-if="isAdminUser">Volunteer Information / Approval Status</h2>
      <h2 v-if="isVolunteerUser">Volunteer Information</h2>
      <thead>
        <tr>
          <!-- <th>Volunteer ID</th> -->
          <th>Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Volunteer Status</th>
          <th v-if="isAdminUser">Application Form</th>
          <th v-if="isAdminUser">Select</th>
        </tr>
      </thead>

      <tbody>
        <tr>
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
            <input type="text" id="appfilter" v-model="filter.app_status" />
          </td>
          <td>
            <input
              v-if="isAdminUser"
              type="text"
              id="appForm"
              v-model="filter.app_form"
            />
          </td>
          <td>
            <input
              v-if="isAdminUser"
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
          <!-- <td v-if="isAdminUser">{{ volunteer.volunteer_id }}</td> -->
          <td>{{ volunteer.full_name }}</td>
          <td>{{ volunteer.email }}</td>
          <td>{{ volunteer.phone_number }}</td>
          <td>{{ volunteer.app_status }}</td>
          <td>
            <router-link
              v-if="isAdminUser"
              id="see-application"
              :to="{
                name: 'volunteer-application-form',
                params: { volunteer_id: volunteer.volunteer_id },
              }"
              >See Application
            </router-link>
          </td>
          <td>
            <input
              v-if="isAdminUser"
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
        v-if="isAdminUser"
        disableButtons
        type="submit"
        id="approve"
        @click.prevent="updateSelected(approved)"
      >
        APPROVE
      </button>

      <button
        v-if="isAdminUser"
        disableButtons
        type="submit"
        id="deny"
        @click.prevent="updateSelected(denied)"
      >
        DENY
      </button>

      <button
        v-if="isAdminUser"
        disableButtons
        type="submit"
        id="delete-app"
        @click.prevent="deleteSelectedVolunteers"
      >
        DELETE
      </button>
      <button
        v-if="isAdminUser"
        type="submit"
        id="clear"
        @click.prevent="clearSelected"
      >
        CLEAR
      </button>
    </table>
  </div>
</template>

<script>
import ShelterService from "@/services/ShelterService.js";
import AuthService from "../services/AuthService";

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
          form: "See Application Form",
          ref_full_name: "",
          ref_phone_number: "",
          ref_email: "",
          app_status: "",
        },
      ],

      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
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
      default: "password",
    };
  },
  created() {
    this.getVolunteers();
  },

  methods: {
    getVolunteersById(volunteer_id) {
      this.$router.push(`/volunteers/${volunteer_id}`);
    },
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
      if (confirm("Are you sure you want to delete this application?")) {
        this.selectedVolunteers.forEach((volunteer) => {
          let selected = this.volunteers.find(
            (f) => f.volunteer_id === volunteer
          );
          return this.removeApplication(selected.volunteer_id);
        });
      } else {
        ("Cancelled delete");
      }
    },
    removeApplication(volunteer_id) {
      ShelterService.deleteVolunteer(volunteer_id)
        .then((response) => {
          if (response.status === 200) {
            this.clearSelected();
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
            this.clearSelected();
            if (volunteer.app_status == this.approved) {
              this.registerVolunteer(volunteer);
            }
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
    registerVolunteer(volunteer) {
      const user = {
        username: volunteer.email,
        password: this.default,
        confirmPassword: this.default,
        role: "VOLUNTEER",
      };
      AuthService.register(user)
        .then((response) => {
          if (response.status === 201) {
            alert("Volunteer account registered!");
          }
        })
        .catch((error) => {
          const response = error.response;
          this.registrationErrors = true;
          if (response.status === 400) {
            this.registrationErrorMsg = "Bad Request: Validation Errors";
          }
        });
    },
  },
  computed: {
    isAdminUser() {
      if (!this.$store.state.user.authorities) {
        return false;
      }
      return this.$store.state.user.authorities[0].name === "ROLE_ADMIN";
    },
    isVolunteerUser() {
      if (!this.$store.state.user.authorities) {
        return false;
      }
      return this.$store.state.user.authorities[0].name === "ROLE_VOLUNTEER";
    },
    filteredList() {
      if (this.isVolunteerUser) {
        return this.volunteers.filter((volunteer) => {
          return (
            volunteer.full_name.includes(this.filter.full_name) &&
            volunteer.email.includes(this.filter.email) &&
            volunteer.phone_number.includes(this.filter.phone_number) &&
            volunteer.app_status === "APPROVED"
          );
        });
      } else {
        return this.volunteers.filter((volunteer) => {
          return (
            volunteer.full_name.includes(this.filter.full_name) &&
            volunteer.email.includes(this.filter.email) &&
            volunteer.phone_number.includes(this.filter.phone_number) &&
            volunteer.app_status.includes(this.filter.app_status)
          );
        });
      }
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

#see-application {
  text-decoration: none;
  background-color: #e8e9eb;
  color: black;
}

#see-application:focus {
  color: #44a1a0;
}

#see-application:hover {
  color: #f78154;
}

button {
  margin-top: 20px;
  margin-right: 10px;
  background-color: #e8e9eb;
  border-width: 1px;
  border-radius: 4px;
}
</style>