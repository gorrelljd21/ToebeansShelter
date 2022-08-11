<template>
  <body>
    <div class="home">
      <div class="logo">
        <logo-comp></logo-comp>
      </div>
      <div class="title" v-if="!mobileView">
        <title-comp></title-comp>
      </div>
<<<<<<< HEAD
      <label for="username" class="sr-only">Username </label>
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
      <label for="password" class="sr-only">Password </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br />
      <router-link class="newAccount" :to="{ name: 'register' }"
        >Need an account?</router-link
      >
      <p></p>
      <button id="sign-in" type="submit">Sign in</button>
      <button @click="goToHome()">Cancel</button>
      <br />
      <button @click="resetForm()">Reset</button>
    </form>
  </div>
=======
      <div class="loginRegister">
        <login-register-comp></login-register-comp>
      </div>
      <div class="header">
        <header-comp></header-comp>
      </div>
      <div class="nav">
        <nav-comp></nav-comp>
      </div>
      <div class="main">
        <login-comp></login-comp>
      </div>
      <div class="story">
        <stories-comp></stories-comp>
      </div>
      <div class="feet">
        <foot-view />
      </div>
    </div>
  </body>
>>>>>>> 4c6dda17924a12c9976d1736dcd3662a1d285c53
</template>

<script>
import authService from "../services/AuthService";
import HeaderComp from "@/components/HeaderComp.vue";
import NavComp from "@/components/NavComp.vue";
import StoriesComp from "@/components/StoriesComp.vue";
import FootView from "@/views/FootView.vue";
import LogoComp from "@/components/LogoComp.vue";
import TitleComp from "@/components/TitleComp.vue";
import LoginRegisterComp from "@/components/LoginRegisterComp.vue";
import LoginComp from "@/components/LoginComp.vue";

export default {
  name: "login",
  components: {
    HeaderComp,
    NavComp,
    StoriesComp,
    FootView,
    LogoComp,
    TitleComp,
    LoginRegisterComp,
    LoginComp,
  },
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
    resetForm() {
      this.$refs["user"].value = "";
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
h1,
.newAccount {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}
</style>