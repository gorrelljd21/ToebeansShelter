<template>
  <div id="whole">
    <h2>Volunteer With Us!</h2>
    <form action="" id="volunteerform">
      <label for="name">Your Name: </label>
      <input
        type="text"
        placeholder="First Last"
        name="name"
        id="name"
        required
      /><br />
      <br />
      <label for="phone">Your Phone Number: </label>
      <input type="text" name="phone" placeholder="##########" required />
      <br /><br />
      <label for="email">Your E-mail: </label>
      <input
        type="text"
        name="email"
        placeholder="xxxxxxxxxxx@xxx.com"
        required
      /><br /><br />
      <label for="bio">Tell Us About Yourself: </label>
      <br /><br />
      <textarea rows="5" cols="60" name="bio" style="resize: none">
            Why are you looking to volunteer?
         </textarea
      >

      <br />
      <h3>Reference Info:</h3>
      <label for="refname">Reference Name: </label>
      <input type="text" name="refname" placeholder="First Last" required />
      <br /><br />
      <label for="refphone">Reference Phone Number: </label>
      <input type="text" name="refphone" placeholder="##########" required />
      <br /><br />
      <label for="refemail">Reference E-mail: </label>
      <input
        type="text"
        name="refemail"
        placeholder="xxxxxxxxxxx@xxx.com"
        required
      />
      <br />
      <button type="submit">Submit</button>
      <router-link to="/" tag="button" id="cancel">Cancel</router-link>
    </form>
  </div>
</template>

<script>
import shelterService from "@/services.ShelterService.js";
export default {
  name: "volunteer-comp",
  data() {
    return {
      volunteer: {},
    };
  },
  methods: {
    submitVoluntter(volunteer) {
      shelterService.submitVoluntter(volunteer).then((response) => {
        if (response.status === 201) {
          this.$router.push("/");
        }
      });
    },
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

h2,
form {
  margin-left: 20px;
}

h2,
h3 {
  color: #313638;
}

#bio {
  width: 300px;
  height: 100px;
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

textarea {
  margin-right: 15px;
}
</style>