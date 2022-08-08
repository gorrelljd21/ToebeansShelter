<template>
  <nav class="navigation">
    <h1>Navigation</h1>
    <button id="animal" type="submit">About Us</button>
    <br />
    <button id="animal" type="submit">All Animal Listings</button>
    <br />
    <button id="animal" type="submit">Animals by Category</button>
    <br />
    <button id="animal" type="submit">Volunteers</button>
    <br />
    <button id="animal" type="submit">Success Stories</button>
    <br />
    <button id="animal" type="submit">Events</button>
  </nav>
</template>

<style scoped>
.home {
  display: flex;
}
.navigation {
  text-align: center;
  border-radius: 8px;
  border-style: solid;
  height: 100vh;
}

#animal {
  flex-direction: column-reverse;
  justify-content: space-between;
}
</style>