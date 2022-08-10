<template>
  <div class="footer">
    <div class="footer-container">
      <h3>Contact Info and Other Fun Things:</h3>
      <ul>
        <li>Landline: 1800-TOE-BEAN</li>
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
.footer-container {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  background-color: rgb(207, 232, 220);
  border: 2px solid rgb(79, 185, 227);
  margin-left: 15px;
}

@media screen and (max-width: 450px) {
  .footer-container {
    margin-left: 15px;
    width: 400px;
    padding-left: 8px;
  }
}
</style>