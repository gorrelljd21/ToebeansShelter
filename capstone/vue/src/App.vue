<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div> -->
    <!-- <header-comp></header-comp> -->
    <div class="center"></div>

    <router-view />
  </div>
</template>

<script>
</script>

<style >
/* .center {
  display: flex;
  flex-direction: row;
} */
