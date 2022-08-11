<template>
  <body>
    <div class="home">
      <div class="logo">
        <logo-comp></logo-comp>
      </div>
      <div class="title" v-if="!mobileView">
        <title-comp></title-comp>
      </div>
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
        <register-comp></register-comp>
      </div>
      <div class="story">
        <stories-comp></stories-comp>
      </div>
      <div class="feet">
        <foot-view />
      </div>
    </div>
  </body>
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
import RegisterComp from "@/components/RegisterComp.vue";

export default {
  components: {
    HeaderComp,
    NavComp,
    StoriesComp,
    FootView,
    LogoComp,
    TitleComp,
    LoginRegisterComp,
    RegisterComp,
  },
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
#confirmPassword {
  margin-left: 3.6%;
}

#password {
  margin-left: 0.2%;
}

.sr-only,
.makeAccount,
h1 {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}

button {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
  margin-top: 20px;
  background-color: #e8e9eb;
  border-width: 1px;
  border-radius: 4px;
}
</style>
