<template>
  <div>
    <div>
      <h2>{{ volunteer.full_name }}</h2>
      <table>
        <tr>
          <th>Phone Number:</th>
          <td>{{ volunteer.phone_number }}</td>
        </tr>
        <tr>
          <th>E-mail:</th>
          <td>{{ volunteer.email }}</td>
        </tr>
        <tr>
          <th>Bio:</th>
          <td>{{ volunteer.bio }}</td>
        </tr>
        <tr>
          <th>Reference Name:</th>
          <td>{{ volunteer.ref_full_name }}</td>
        </tr>
        <tr>
          <th>Reference Phone Number:</th>
          <td>{{ volunteer.ref_phone_number }}</td>
        </tr>
        <tr>
          <th>Reference E-mail:</th>
          <td>{{ volunteer.ref_email }}</td>
        </tr>
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
</style>