<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h2 class="h3 mb-3 font-weight-normal">Please Sign In</h2>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <label for="username" class="sr-only">Username: </label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <br />
      <br />
      <label for="password" class="sr-only">Password: </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br />
      <br />
      <router-link class="newAccount" :to="{ name: 'register' }"
        >Need an account?</router-link
      >
      <p></p>
      <button id="sign-in" type="submit">Sign in</button>
      <button v-on:click="goToHome()" id="cancel">Cancel</button>
      <br />
      <button type="reset">Reset Form</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
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

#password {
  margin-left: 0.3%;
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
}

h2,
h3 {
  color: #313638;
}

#cancel {
  margin-left: 5px;
}
</style>