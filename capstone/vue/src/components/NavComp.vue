<template>
  <div>
    <nav class="navigation">
      <h1>Navigation</h1>
      <router-link v-bind:to="{ name: 'home' }">
        <button id="btn" type="submit">Home</button>
      </router-link>
      <br />
      <button id="btn" type="submit">About Us</button>
      <br />
      <button id="btn" type="submit">All Animal Listings</button>
      <br />
      <button id="btn" type="submit">Animals by Category</button>
      <br />
      <button id="btn" type="submit">Volunteers</button>
      <br />
      <button id="btn" type="submit">Success Stories</button>
      <br />
      <button id="btn" type="submit">Events</button>
    </nav>
  </div>
</template>

<style scoped>
.navigation {
  position: relative left;
  display: flex;
  flex-direction: column;
  text-align: center;
  border-radius: 8px;
  border-style: solid;
  height: 100vh;
}

#animal {
  flex-direction: column-reverse;
  flex-grow: 0;
  justify-content: flex-start;
}
</style>