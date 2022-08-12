<template>
  <div class="logo">
    <router-link v-bind:to="{ name: 'home' }">
      <img src="..\assets\logoblueNameFINALBG.png" alt="logo" />
    </router-link>
  </div>
</template>

<style scoped>
img {
  padding: 8% 0% 0% 25%;
  width: 50%;
  height: 50%;
}

@media screen and (max-width: 450px) {
  img {
    width: 70%;
    height: 70%;
    padding: 0%;
  }
}
</style>