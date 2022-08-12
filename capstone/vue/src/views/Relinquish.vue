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
      <div class="nav">
        <nav-comp></nav-comp>
      </div>
      <div class="main">
        <relinquish-comp></relinquish-comp>
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
import NavComp from "@/components/NavComp.vue";
import StoriesComp from "@/components/StoriesComp.vue";
import FootView from "@/views/FootView.vue";
import LogoComp from "@/components/LogoComp.vue";
import TitleComp from "@/components/TitleComp.vue";
import LoginRegisterComp from "@/components/LoginRegisterComp.vue";
import RelinquishComp from "@/components/RelinquishComp.vue";

export default {
  name: "home",
  data() {
    return {
      mobileView: false,
    };
  },
  components: {
    RelinquishComp,
    NavComp,
    StoriesComp,
    FootView,
    LogoComp,
    TitleComp,
    LoginRegisterComp,
  },
  methods: {
    handleView() {
      this.mobileView = window.innerWidth <= 450;
    },
  },
  created() {
    this.handleView();
    window.addEventListener("resize", this.handleView);
  },
};
</script>

<style >
* {
  background-color: #e0dfd5;
}
.logo {
  grid-area: ga-logo;
}

.title {
  grid-area: ga-title;
}

.loginRegister {
  grid-area: ga-lr;
}

.nav {
  grid-area: ga-nav;
  border-top: black;
}

.main {
  grid-area: ga-main;
  border-top: black;
}

.story {
  grid-area: ga-story;
  border-top: black;
}

.feet {
  grid-area: ga-feet;
}

.home {
  display: grid;
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas:
    "ga-logo    ga-title  ga-lr"
    "ga-nav     ga-main   ga-story"
    "ga-feet    ga-feet   ga-feet";
  gap: 10px;
  height: 90vh;
  background-color: #e0dfd5;
}

.card * {
  background-color: aliceblue !important;
}

@media screen and (max-width: 450px) {
  .nav {
    border-style: none;
    height: 0hv;
  }

  .logo {
    padding: 0% 0% 0% 0%;
    width: 40vw;
    margin: 10px;
  }

  .home {
    width: 100vw;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
      "ga-logo ga-lr"
      "ga-nav ga-nav"
      "ga-main ga-main"
      "ga-story ga-story"
      "ga-feet ga-feet";
  }
}
</style> 
