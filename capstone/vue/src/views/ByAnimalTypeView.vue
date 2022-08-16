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
        <by-type />
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
import ByType from "../components/ByType.vue";
export default {
  components: {
    NavComp,
    StoriesComp,
    FootView,
    LogoComp,
    TitleComp,
    LoginRegisterComp,
    ByType,
  },
};
</script>

<style scoped>




</style>