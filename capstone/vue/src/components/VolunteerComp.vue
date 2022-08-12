<template>
  <div id="whole">
    <div class="status-message error" v-show="errorMsg !== ''">
      {{ errorMsg }}
    </div>

    <form id="volunteerform">
      <h2>Volunteer With Us!</h2>
      <label for="name">Your Full Name: </label>
      <input
        v-model="volunteer.full_name"
        type="text"
        placeholder="First Last"
        name="name"
        id="name"
        required
      /><br />
      <br />
      <label for="phone">Your Phone Number: </label>
      <input
        type="text"
        name="phone"
        placeholder="##########"
        required
        v-model="volunteer.phone_number"
      />
      <br /><br />
      <label for="email">Your E-mail: </label>
      <input
        v-model="volunteer.email"
        type="text"
        name="email"
        id="email"
        placeholder="xxxxxxxxxxx@xxx.com"
        required
      /><br /><br />
      <label for="bio">Tell Us About Yourself: </label>
      <br /><br />
      <textarea
        rows="5"
        cols="56"
        name="bio"
        style="resize: none"
        v-model="volunteer.bio"
      >
            Why are you looking to volunteer?
         </textarea
      >

      <br />
      <h2>Reference Info:</h2>
      <label for="refname">Reference Full Name: </label>
      <input
        type="text"
        name="refname"
        id="refname"
        placeholder="First Last"
        required
        v-model="volunteer.ref_full_name"
      />
      <br /><br />
      <label for="refphone">Reference Phone Number: </label>
      <input
        type="text"
        name="refphone"
        placeholder="##########"
        required
        v-model="volunteer.ref_phone_number"
      />
      <br /><br />
      <label for="refemail">Reference E-mail: </label>
      <input
        v-model="volunteer.ref_email"
        type="text"
        name="refemail"
        id="refemail"
        placeholder="xxxxxxxxxxx@xxx.com"
        required
      />
      <br />
      <button type="submit" @click.prevent="submitApplication()">Submit</button>
      <router-link to="/" tag="button" id="cancel">Cancel</router-link>
    </form>
  </div>
</template>

<script>
import shelterService from "@/services/ShelterService.js";

export default {
  name: "volunteer-comp",

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
      errorMsg: "",
      isLoading: true,
    };
  },
  methods: {
    submitApplication() {
      shelterService
        .addNewVolunteer(this.volunteer)
        .then((response) => {
          if (response.status === 201) {
            alert("Application submitted!");
            this.$router.push("/");
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error, "submitting");
        });
    },
  },
  created() {
    this.getVolunteers();
  },
  handleErrorResponse(error, verb) {
    if (error.response) {
      this.errorMsg =
        "Error " +
        verb +
        " application. Response received was " +
        error.response.statusText +
        " .";
    } else if (error.request) {
      this.errorMsg =
        "Error " + verb + " application. Server could not be reached.";
    } else {
      this.errorMsg =
        "Error " + verb + " application. Request could not be created";
    }
  },
};
</script>

<style scoped>
input {
  background-color: white;
  border-width: 1px;
}

* {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

#whole {
  border: 1px solid black;
  display: block;
  height: 100vh;
  margin: 0px 25px 0px 25px;
}

form {
  margin-left: 20px;
}

form {
  border: 1px solid black;
  margin: auto;
  margin-top: 10%;
  padding: 0px 0px 20px 20px;
  width: 600px;
  display: block;
  border-radius: 10px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px,
    rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
  width: 600px;
  background-color: #e8e9eb;
}

h2,
h3 {
  color: #313638;
}

label {
  background-color: #e8e9eb;
}

#name {
  margin-left: 34px;
}

#email {
  margin-left: 59px;
}

#bio {
  width: 300px;
  height: 100px;
}

#refname {
  margin-left: 33px;
}

#refemail {
  margin-left: 59px;
}

textarea {
  background-color: white;
}

button {
  margin-top: 20px;
  background-color: #e8e9eb;
  border-width: 1px;
  border-radius: 4px;
}

#cancel {
  margin-left: 5px;
}

h2 {
  background-color: #6eb8b6;
  padding: 5px 5px 5px 12px;
  border-radius: 3px;
  margin-right: 40%;
  color: aliceblue;
  border: 1px solid black;
}

h3 {
  background-color: #f89670;

  padding: 5px 5px 5px 12px;
  border-radius: 3px;
  margin-right: 40%;
  color: white;
  border: 1px solid black;
}

textarea {
  margin-right: 15px;
}
</style>