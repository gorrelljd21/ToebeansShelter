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
    <!-- <body>
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
        <animal-list></animal-list>
      </div>
      <div class="story">
        <stories-comp></stories-comp>
      </div>
      <div class="feet">
        <foot-view />
      </div>
    </div>
  </body> -->
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
