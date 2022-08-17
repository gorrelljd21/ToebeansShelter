<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="changePassword(user)">
      <h2 class="h3 mb-3 font-weight-normal">Please Change Your Password</h2>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username or password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>

      <br />
      <br />
      <label for="password" class="sr-only">New Password: </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="New Password"
        v-model="user.password"
        required
      />
      <br />
      <br />
      <label for="confirmPassword" class="sr-only">Confirm Password: </label>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="New Password"
        v-model="user.confirmPassword"
        required
      />
      <br /><br />
      <button id="sign-in" type="submit">Change password</button>
      <br />
      <button type="reset">Reset Form</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import swal from "sweetalert";

export default {
  name: "loginUpdate",
  components: {},
  data() {
    return {
      user: {
        username: "",
        confirmPassword: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    changePassword() {
      if (this.user.password !== this.user.confirmPassword) {
        alert("Password mismatch, please ensure they're the same!");
      } else {
        authService
          .updatePassword(this.user)
          .then((response) => {
            if (response.status == 201) {
              alert("Password changed!");
              swal({
                title: "Welcome to our Team!",
                text: "We are excited for you to join!",
                button: "LETS GOOO",
              });
              this.user = response.data;
              this.$router.push("/");
            }
          })
          .catch((error) => {
            const response = error.response;

            if (response.status === 403) {
              this.invalidCredentials = true;
            }
          });
      }
    },
    goToHome() {
      this.$router.push("/");
    },
  },
};
</script>

<style scoped>
button {
  margin-top: 20px;
  background-color: #e8e9eb;
  border-width: 1px;
  border-radius: 4px;
}

label,
.newAccount,
h2,
.alert {
  background-color: #f89670;
  color: white;
}

#password {
  margin-left: 5px;
}

.sr-only,
h2,
.newAccount {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

input {
  background-color: white;
  border-width: 1px;
}

* {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

#login {
  border: 1px solid black;
  display: block;
  height: 100vh;
  margin: 0px 25px 0px 25px;
}

form {
  margin-left: 20px;
  border: 1px solid black;
  margin: auto;
  margin-top: 15%;
  padding-left: 20px;
  display: block;
  padding-bottom: 20px;
  border-radius: 10px;
  background-color: #f89670;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px,
    rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
  width: 350px;
}

h2,
h3 {
  color: white;
}

#cancel {
  margin-left: 5px;
}
</style>

<style>
.swal-modal {
  background-color: #44a1a0;
  border: 3px solid white;
}

.swal-title {
  font-size: 30px;
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
  box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.21);
  margin-bottom: 28px;
  background-color: #44a1a0;
}

.swal-text {
  background-color: white;
  padding: 17px;
  border: 1px solid #313638;
  display: block;
  margin: 22px;
  text-align: center;
  color: #313638;
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

.swal-footer {
  background-color: #44a1a0;
  margin-top: 32px;
  border-top: 1px solid #e9eef1;
  overflow: hidden;
}

.swal-button {
  padding: 7px 19px;
  border-radius: 2px;
  background-color: #e8e9eb;
  color: black;
  font-size: 12px;
  border: 1px solid #3e549a;
  text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.3);
}
</style>