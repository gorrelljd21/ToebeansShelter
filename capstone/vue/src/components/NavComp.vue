<template>
  <div>
    <nav class="navigation">
      <h1>Navigation</h1>

      <p>
        <router-link v-bind:to="{ name: 'home' }">
          <b><a id="link" href="default.asp" target="_blank">Home</a></b>
        </router-link>
      </p>
      <!-- <br /> -->
      <p>
        <b><a id="link" href="default.asp" target="_blank">About Us</a></b>
      </p>
      <!-- <br /> -->
      <p>
        <b
          ><a id="link" href="default.asp" target="_blank"
            >All Animal Listings</a
          ></b
        >
      </p>
      <!-- <br /> -->
      <p>
        <b
          ><a id="link" href="default.asp" target="_blank"
            >Animals by Category</a
          ></b
        >
      </p>
      <!-- <br /> -->
      <p>
        <b><router-link id="link" to="/volunteer">Volunteer</router-link></b>
      </p>
      <!-- <br /> -->
      <p>
        <b
          ><a id="link" href="default.asp" target="_blank"
            >Success Stories</a
          ></b
        >
      </p>
      <!-- <br /> -->
      <p>
        <b><a id="link" href="default.asp" target="_blank">Events</a></b>
      </p>
    </nav>
  </div>
</template>

<style scoped>
.navigation {
  position: relative left;
  display: flex;
  flex-direction: column;
  text-align: center;
  border-radius: 4px;
  border-style: solid;
  border-width: 1px;
  margin-left: 15px;
  padding: 0 0 30px 0;
}

#link {
  border-width: 1px;
  border-style: solid;
  border-color: #313638;
  padding: 5% 20% 5% 20%;
  background-color: white;
  display: block;
  margin: -5% 10% 0% 10%;
  border-radius: 4px;
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
  text-decoration: none;
  color: #313638;
  font-size: 1em;
}

#link:hover {
  color: #f78154;
}

h1 {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
  color: #313638;
}

#animal {
  flex-direction: column-reverse;
  flex-grow: 0;
  justify-content: flex-start;
}

@media screen and (max-width: 450px) {
  .navigation {
    width: 70vw;
    margin-left: 60px;
  }
}
</style>