<template>
  <div class="home">
    <div class="logo">
      <logo-comp></logo-comp>
    </div>
    <div class="title">
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
      <animal-list></animal-list>
    </div>
    <div class="story">
      <stories-comp></stories-comp>
    </div>
    <div class="feet">
      <foot-view />
    </div>
  </div>
</template>

<script>
import AnimalList from "@/components/AnimalList.vue";
import HeaderComp from "@/components/HeaderComp.vue";
import NavComp from "@/components/NavComp.vue";
import StoriesComp from "@/components/StoriesComp.vue";
import FootView from "@/views/FootView.vue";
import LogoComp from "@/components/LogoComp.vue";
import TitleComp from "@/components/TitleComp.vue";
import LoginRegisterComp from "@/components/LoginRegisterComp.vue";

export default {
  name: "home",
  components: {
    AnimalList,
    HeaderComp,
    NavComp,
    StoriesComp,
    FootView,
    LogoComp,
    TitleComp,
    LoginRegisterComp,
  },
};
</script>

<style scoped>
.logo {
  grid-area: ga-logo;
}

.title {
  grid-area: ga-title;
}

.loginRegister {
  grid-area: ga-lr;
}

.header {
  grid-area: ga-header;
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
}

/* @media screen and (max-width: 450px) {
  .nav {
    height: 25vh;
    border-style: none;
  }

  .home {
    grid-template-columns: 1fr;
    grid-template-areas:
      "ga-header"
      "ga-nav"
      "ga-main";
  }
} */
</style> 