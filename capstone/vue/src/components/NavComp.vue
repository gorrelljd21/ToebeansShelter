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
        <b><a id="link" href="default.asp" target="_blank">Volunteers</a></b>
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
  border-radius: 8px;
  border-style: solid;
  height: 100vh;
  margin-left: 15px;
}

#link {
  border-width: 1px;
  border-style: solid;
  border-color: #313638;
  padding: 8px 30px 8px 30px;
  background-color: white;
  display: block;
  margin: -10px 20px 0px 20px;
  border-radius: 4px;
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
  text-decoration: none;
  color: #313638;
  font-size: 20px;
}

#link:hover {
  color: #f78154;
}

h1 {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
  color: #313638;
}
</style>