<template>
  <div></div>
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
.main {
  border-bottom: black solid;
}
</style>  