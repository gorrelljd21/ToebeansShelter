<template>
  <div>
    <h2>Volunteer Approval Status</h2>
    <table>
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
              <option value="APPROVED">ACTIVE</option>
              <option value="PENDING">PENDING</option>
            </select>
          </td>
          <td>
            <input type="text" id="appForm" v-model="filter.app_form" />
          </td>
          <td>
            <input type="checkbox" id="selectAll" />
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
    </table>
    <h3>For Pending Volunteers</h3>
    <button type="submit" id="approve" @click.prevent="approveSelected">
      APPROVE
    </button>
    <button type="submit" id="deny" @click.prevent="deleteSelectedVolunteers">
      DENY
    </button>
    <button type="submit" id="clear" @click.prevent="clearSelected">
      CLEAR
    </button>
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
    },
    addSelectedVolunteers() {
      this.selectedVolunteers.push(this.volunteer.volunteer_id);
    },
    deleteSelectedVolunteers() {
      this.selectedVolunteers.forEach((volunteer) => {
        let selected = this.volunteers.find(
          (f) => f.volunteer_id === volunteer
        );
        return this.denyApplication(selected.volunteer_id);
      });
    },
    denyApplication(volunteer_id) {
      ShelterService.deleteVolunteer(volunteer_id)
        .then((response) => {
          if (response.status === 200) {
            alert("Volunteer Application Removed!");
            this.$router.push("/volunteer-requests");
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
    approveSelected() {
      this.selectedVolunteers.forEach((volunteer) => {
        let selected = this.volunteers.find(
          (f) => f.volunteer_id === volunteer
        );
        selected.app_status = "APPROVED";
        return this.approveApplications(selected.volunteer_id, selected);
      });
    },
    approveApplications(volunteer_id, volunteer) {
      ShelterService.changeAppStatus(volunteer_id, volunteer)
        .then((response) => {
          if (response.status === 200) {
            alert("Application approved!");
            this.$router.push("/volunteer-requests");
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
  },
};
</script>

<style scoped>
</style>