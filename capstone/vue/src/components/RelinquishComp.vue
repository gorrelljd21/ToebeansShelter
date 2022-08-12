<template>
  <div class="main">
    <h1>Does your pet need a new home?</h1>
    <h2>We are here to help.</h2>

    <div>
      <form id="relinquishform">
        <label for="pets-name">What is the name of your pet? </label>
        <input
          type="text"
          placeholder="Pet's name"
          name="pets-name"
          id="pets-name"
          required
        />
        <br />
        <label for="type">Type of animal: </label>
        <select name="type" id="animal-type">
          <option value="Dog">Dog</option>
          <option value="Cat">Cat</option>
          <option value="Small Animal">Small Animal</option>
          <option value="Farm Animal">Farm Animal</option>
        </select>
        <br />
        <label for="breed">What is your pets breed? </label>
        <input type="text" name="breed" id="breed" />
        <br />
        <label for="why">Why do you need to relinquish your pet? </label>
        <textarea
          name="why"
          id="why"
          cols="55"
          rows="5"
          style="resize: none"
        ></textarea>
        <br />
        <label for="why"
          >Is there anything else we should know about to help place your pet in
          a good home?
        </label>
        <textarea
          name="why"
          id="why"
          cols="55"
          rows="5"
          style="resize: none"
        ></textarea>
        <br />
        <button type="submit">List your Pet</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.main {
  border: 1px solid black;
  display: block;
  height: 100vh;
  margin: 0px 25px 0px 25px;
}
* {
  font-family: Calibri, Candara, Segoe, "Segoe UI", Optima, Arial, sans-serif;
}
h1,
h2 {
  color: #313638;
}
input,
select,
textarea {
  background-color: white;
}
</style>