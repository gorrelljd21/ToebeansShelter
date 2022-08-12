<template>
  <div>
    <button v-on:click="goToLogin()" v-if="$store.state.token == ''">
      Login/Register
    </button>
    <div id="nav">
      <router-link
        tag="button"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
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
  border: 1px solid black;
  border-radius: 4px;
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
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px,
    rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
}

button:hover {
  background-color: #f78154;
  color: black;
}

@media screen and (max-width: 450px) {
  button {
    margin: 85px 20px 0px -15px;
    width: 35vw;
  }

  #nav {
    margin-bottom: -20px;
  }
}
</style>