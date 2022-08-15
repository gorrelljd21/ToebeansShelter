<template>
  <body>
    <div>
      <volunteer-application-comp></volunteer-application-comp>
    </div>
  </body>
</template>

<script>
import VolunteerApplicationComp from "@/components/VolunteerApplicationComp.vue";

export default {
  name: "volunteer-application-view",
  components: {
    VolunteerApplicationComp,
  },
};
</script>