<template>
  <div class="footer">
    <div class="footer-container">
      <h3>Contact Info and Other Fun Things:</h3>
      <ul>
        <li>Landline: PLEASE CALL 1800-TOE-BEAN TO SCHEDULE AN ADOPTION</li>
        <li>Email: contact@toebeanshelter.org</li>
        <li>Address: Not <em>that</em> Farm, Cincinnati, Oh</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  setup() {
    return {};
  },
};
</script>

<style scoped>
* {
  background-color: #e0dfd5;
}
.footer {
  font-family: "Calibri", "Trebuchet MS", sans-serif;
  margin-bottom: 1%;
  margin-right: 15px;
}

.footer-container {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  /* background-color: rgb(207, 232, 220); */
  border-radius: 4px;
  border-style: solid;
  border-color: #44a1a0;
  margin-left: 15px;
  background-color: #e0dfd5;
  border-width: 2px;
}

.footer-container h3 {
  margin-left: 1%;
}

ul {
  padding-left: 1%;
}

.footer-container > ul > li {
  list-style: none;
}

@media screen and (max-width: 450px) {
  .footer-container {
    margin-left: 15px;
    width: 400px;
    padding-left: 8px;
  }
}
</style>