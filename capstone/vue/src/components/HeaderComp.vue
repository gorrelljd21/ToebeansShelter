<template>
  <div class="main">
    <div id="LR">
      <button v-on:click="goToLogin()">Login/Register</button>
    </div>
    <div class="header">
      <h1 id="title">TOEBEANS ANIMAL SHELTER</h1>
    </div>
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
  /* position: relative top; */
  /* display: flex; */
  /* flex-direction: row;
  justify-content: space-between;
  align-items: center; */
  border-bottom: solid;
}
.logo {
  width: 12%;
  height: 12%;
}
#title {
  align-content: center;
  justify-content: center;
}

#LR {
  /* display: flex; */
  flex-direction: row-reverse;
  align-items: start;
  justify-content: flex-start;
  padding: 15px 15px 0px 0px;
}
</style>