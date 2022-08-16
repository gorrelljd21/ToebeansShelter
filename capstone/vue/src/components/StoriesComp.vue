<template>
  <div class="story-comp">
    <div class="story-container">
      <div class="story-card">
        <h3 class="story-title">Possum Finds New Home At ToeBeans</h3>
        <p class="story-content">
          By: ToeBeans Staff <br /><br />
          Last Sunday, on 8/14/22, local man Jeff Dinsky was driving home from
          his daughter's ballet recital when he noticed a big fuzzball waddling
          in the road up ahead. He pulled his car to the side, making sure it
          was safe to do so of course, and approached the animal, which turned
          out to be a chubby possum making its way downtown. Jeff was so struck
          by the cuteness of the animal that he felt compelled to pick it up off
          the road to ensure no harm came to it. It should be noted that Jeff is
          well-versed in wildlife and knew that possums do not usually carry
          rabies, and he was equipped with large gloves. He brought the fuzzy
          friend to Toebeans shelter where we have taken great care of it and
          are looking to find it a forever home. Please let us know if you are
          in the market to adopt a marvelous marsupial!
        </p>
      </div>
      <div class="story-card">
        <h3 class="story-title">ToeBeans to Host Adoptathon This Saturday</h3>
        <p class="story-content">
          By: ToeBeans Staff <br /><br />This Saturday, 8/20/22, ToeBeans
          Shelter will be hosting an all-you-can-adopt Adoptathon! All adoptions
          will be FREE! There will be food, drinks, prizes, and games! Come on
          down to the shelter and bring your friends and family! We have plenty
          of wonderful animals that would love to become a member of your
          family. We will be set up at the old Glue Factory on Mill St. from 11
          am to 4 pm.
        </p>
      </div>
      <div class="story-card">
        <h3 class="story-title">ToeBeans Wins "Comfiest Shelter 2022"</h3>
        <p class="story-content">
          By: ToeBeans Staff <br /><br />The 4th annual Animal Wellness Awards
          were held last weekend at Mitchell Convention Center. ToeBeans is
          proud to have received the "Comfiest Shelter" award for the third year
          in a row! We pride ourselves on providing the utmost comfort to our
          fuzzy residents and believe that a happy home makes for happy animals.
          Our amentities include a spa, an enormous pasture with ample space for
          running and playing, and as of this year, a theater where the animals
          can chill and watch their favorite netflix shows!
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      story: {
        id: null,
        title: "",
        content: "",
      },
    };
  },
};
</script>

<style scoped>
.story-comp {
  font-family: "Calibri", "Trebuchet MS", sans-serif;
  margin-right: 15px;
}

.story-container {
  column-width: 250px;
  column-gap: 20px;
  border-radius: 4px;
  border-style: solid;
  border-width: 1px;
}
.story-card {
  margin: 2px;
  /* background-color: rgb(207, 232, 220); */

  border-style: solid;
  border-color: #44a1a0;
  background-color: aliceblue;
}

.story-title {
  text-align: left;
  padding-left: 15px;
  padding-right: 15px;
  font-size: 16px;
  background-color: aliceblue;
}

.story-content {
  font-size: 14px;
  text-align: left;
  padding: 0px 15px 15px 15px;
  padding-bottom: 0px;
}

@media screen and (max-width: 450px) {
  .story-container {
    column-width: 210px;
    margin-right: 10px;
    margin-left: 20px;
  }
}

p {
  background-color: aliceblue;
}
</style>