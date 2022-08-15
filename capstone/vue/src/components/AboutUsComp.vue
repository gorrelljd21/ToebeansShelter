<template>
  <div class="whole">
    <h2>Welcome to Toebeans Animal Shelter!</h2>
    <h3>We want to help animals find the perfect home.</h3>
    <p id="blurb">
      Founded in 2022 by Jessica Gorrell, Kit Morgan, Evan Amezcua, Mary
      Schmidt, and Nate Schlie, Toebeans Animal Shelter is a no-kill shelter
      located in Cincinnati, Ohio that seeks to provide the finest care and
      comfort to our animals while we seek out a loving fur-ever home for them.
      We are driven by an intense desire to see all animals in need aligned with
      the perfect owners so that no furry friend goes unhoused. You certainly
      will not find a shelter run by more passionate individuals anywhere in the
      area. We also do not shame anyone for putting their pets up for adoption -
      it takes a lot of humility to admit that your pet could have a better life
      somewhere else. If you feel that you're unable to provide the care your
      pet deserves, please do not hesitate to reach out to us and we will do our
      best to find your friend the perfect home.
    </p>
    <img id="gif" src="../assets/hug.gif" alt="hug" />
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
/* #gif {
  margin-left: 700px;
  margin-top: -300px; 
} */
img {
  display: block;
}

.whole {
  display: flex;
  align-items: center;

  flex-direction: column;
}

.whole {
  border: 1px solid black;
  height: 100vh;
  margin: 0px 25px 0px 25px;
}

h2 {
  background-color: #6eb8b6;
  padding: 5px 120px 5px 120px;
  border-radius: 3px;
  /* margin-right: 40%; */
  color: aliceblue;
  border: 1px solid black;
  margin-top: 4%;
}

h3 {
  background-color: #f89670;
  padding: 5px 120px 5px 120px;
  border-radius: 3px;
  /* margin-right: 40%; */
  color: white;
  border: 1px solid black;
}

h2,
h3,
p {
  margin-left: 20%;
  margin-right: 20%;
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 6px 12px -2px,
    rgba(0, 0, 0, 0.3) 0px 3px 7px -3px;
}

p {
  /* margin-right: 40%; */
}

#blurb {
  border: 1px solid black;
  padding: 8px 8px 8px 12px;
  border-radius: 4px;
  background-color: white;
}
</style>