<template>
  <div class="grid-container"
    style="background-image: url('https://www.intechnic.com/hs-fs/hubfs/intechnic_2017/assets/images/landing/footer/map-xl.jpg?width=1680&height=824&name=map-xl.jpg');">
    <div class="title grid-area">
  <h3>Your Search Results</h3>
  </div>
    <div class="resume grid-area">
      <label>
        <h4>Profiles:</h4>
        <div class="experience" v-for="user in profile" v-bind:key="profile.id">
          <h5
            class="jt grid-area"
          >{{ user.firstName}} + " " + {{ user.lastName }} + " bio: " {{ user.summary }}</h5>

        </div>
      </label>

      
      <label>
        <h4>Portfolio:</h4>
        <div class="experience" v-for="project in portfolio" v-bind:key="portfolio.id">
          <h5
            class="jt grid-area"
          >{{ project.name }} from {{ project.startdate }} to {{ project.enddate }}</h5>

          <p class="r grid-area">{{ project.description}}</p>
        </div>
      </label>
      <br />
    </div>

    </div>
 
</template>
<script>
export default {
  name: "home",

  data() {
    return {
      profile: [
        {
          firstName: "Plumber",
          lastName: "01/23/2018",
          summary: "Had to clean a LOT"
        },
        
      ],

      portfolio: [
        {
          name: "Frankton VA",
          startdate: "January of 02",
          enddate: "February of 03",
          description: "I've made some mistakes"
        },
        {
          name: "Swartz Creek High",
          startdate: "January of 01",
          enddate: "February of 02",
          description: "I've made some mistakes"
        }
      ]
    };
  }
};
</script>
<style scoped>
.grid-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas:
  ". . . . . . "
    " . title title title title ."
    ". resume resume resume resume ."
      ". . . . . . "
;

  grid-gap: 20px;
}
.title {
  grid-area: title;
  color: white;
}
.number-entry {
    display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "sd ed ";
  grid-gap: 20px;
}
.resume {
  grid-area: resume;
}
h4 {
  color: white;
}
.experience {
  display: grid;
  grid-template-columns: 1fr 1fr ;
  grid-template-areas:
    "jt jt "
    "r r ";

  grid-gap: 5px;
  padding: 10px;
  border-radius: 15px;
  margin: 5px;
  background-color: #dfdede;
  width: 100%;
  border: 10px solid;
  border-color: #eeeded;
}

.jt {
  grid-area: jt;
}
.sd {
  grid-area: sd;
}
.r {
  grid-area: r;
}
.bio {
  padding: 10px;
  border-radius: 15px;
  margin: 5px;
  background-color: #dfdede;
  border: 10px solid;
  border-color: #eeeded;
}
#bio-title {
  color:black;
}
textarea {
  box-sizing: border-box;
  display: block;
  width: 100%;
  border-width: 1px;
  border-style: solid;
  padding: 16px;
  outline: 0;
  font-family: inherit;
  font-size: 0.95em;
  border-radius: 15px;
}
.bio {
  grid-area: bio;
  padding: 10px;
}

.username {
  grid-area: username;
}
.userbox {
  box-sizing: content-box;
  text-align: center;
  border-radius: 15px;
  border: 10px solid;
  border-color: #eeeded;
  margin: 5px;
  padding: 10px;

  background-color: #ffffff;
}

.newsfeed {
  grid-area: newsfeed;
}

.tools {
  grid-area: tools;
  border: 10px solid;
  border-radius: 15px;
  border-color: #eeeded;
  padding: 10px;
  background-color: #ffffff;
}

.default-image {
  text-align: center;
  border-radius: 15px;
  margin: 10px;
}
.portfolio {
  width: 100%;
}

label {
  width: 100%;
}
button {
  margin: 10px;
}
</style>