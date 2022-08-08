<template>
  <div class="loading" v-if="isLoading">
    <img src="..\assets\3035fb76965389.5c7945b0d0567.gif" />
  </div>
</template>

<script>
// import shelterService from "../services/ShelterService";

export default {
  name: "pet-detail",
  data() {
    return {
      isLoading: true,
      errorMsg: "",
    };
  },
};
</script>

<style>
</style>