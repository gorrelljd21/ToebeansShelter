<template>
  <div>
    <button v-on:click="goToLogin()">Login/Register</button>
  </div>
</template>

<script>
export default {
  methods: {
    goToLogin() {
      this.$router.push("/login");
    },
  },
};
</script>

<style scoped>
button {
  background-color: #44a1a0;
  border: none;
  border-radius: 10px;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
  margin: 100px 0px 0px 95px;
}

button:hover {
  background-color: white;
  color: black;
}

@media screen and (max-width: 450px) {
  button {
    margin: 85px 20px 0px -15px;
    width: 35vw;
  }
}
</style>