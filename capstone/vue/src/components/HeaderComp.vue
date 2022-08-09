<template>
  <div class="header">
    <img class="logo" src="..\assets\logoblueNameFINALBG.png" alt="logo" />
    <h1 id="title">TOEBEANS SHELTER</h1>
    <button v-on:click="goToLogin()">Login/Register</button>
  </div>
</template>

<script>
// import  Login  from "@/views/Login.vue";

export default {
  // components: {
  //   Login,
  // },
  methods: {
    goToLogin() {
      this.$router.push("/login");
    },
  },
};
</script>




<style scoped>
.header {
  position: relative top;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  border: solid;
  border-radius: 3px;
}
.logo {
  width: 10%;
  height: 10%;
}
#title {
  align-content: center;
  justify-content: center;
}
</style>