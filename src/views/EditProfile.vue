<template>
  <div class="grid-container"
   style="background-image: url('https://www.intechnic.com/hs-fs/hubfs/intechnic_2017/assets/images/landing/footer/map-xl.jpg?width=1680&height=824&name=map-xl.jpg');"
  >
    <!-- <form class="form grid-area">
      <div class="experience grid-area">
        <h3>Add Job Experience</h3>

        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Institution"
          v-model="experience.institution"
        />
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Job Title"
          v-model="experience.jobtitle"
        />
        <textarea
            rows="2"
            cols="50"
            placeholder="Responsibilities"
            v-model="experience.res"
          />
        <div class="date-entry">
          <label class="start">
            Start Date
            <input
              type="date"
              id="start-date"
              class="form-control"
              v-model="experience.startdate"
            />
          </label>
          <label class="end">
            End Date
            <input
              type="date"
              id="end-date"
              class="form-control"
              v-model="experience.enddate"
            />
          </label>
        </div>
        <div class="button">
          <br />
          <button type="submit">Add Experience</button>
        </div>
      </div>

      <div class="education grid-area">
        <h3>Add Education</h3>

        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="School"
          v-model="education.school"
        />
        <div class="date-entry">
          <label class="start">
            Start Date
            <input type="date" id="start-date" class="form-control" />
          </label>
          <label class="end">
            End Date
            <input type="date" id="end-date" class="form-control" />
          </label>
        </div>
        <div class="button">
          <br />
          <button type="submit">Add Education</button>
        </div> -->
      <!-- </div> -->
      <div class="account">
        <div class="bio grid-area">
          <h3>Edit Bio</h3>
          <textarea
            rows="3"
            cols="50"
            placeholder="Tell us a little about yourself."
            v-model="userprofile.bio"
          />
        </div>
        <div class="username grid-area">
          <h3>Edit Username</h3>
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="userprofile.username"
          />
        </div>

        <div class="username grid-area">
          <h3>Edit Password</h3>
          <input type="password" id="username" class="form-control" placeholder="Password" />
        </div>

        <div class="button">
          <button type="submit">Save Changes</button>
        </div>
      </div>
    </form>
    <!-- <div class="profiledisplay grid-area">
      <p>View Profile</p>
      <p>Username: {{ userprofile.username }}</p>
      <p>Bio: {{ userprofile.bio }}</p>
      <p>Education: {{ education.school}} {{ education.school}} {{ education.school}}</p>
      <p>Experience {{ experience.jobtitle}} {{ experience.jobtitle}} {{ experience.jobtitle}}</p>

      <div class="experience" v-for="jobs in experience" v-bind:key="jobs.id">
        <h4>{{ jobs.jobtitle }}</h4>

        <h3>{{ jobs.startdate }}</h3>

        <p>{{ jobs.enddate }}</p>
      </div>
    </div> -->
  </div>
</template>

<script>
export default {
  name: "home",
  showXP1: false,
  data() {
    return {
      userprofile: {
        username: "",
        bio: ""
      },
      experience: [
        {
          jobtitle: "",
          startdate: "",
          enddate: ""
        }
      ],
      education: [
        {
          school: "",
          startdate: "",
          enddate: ""
        }
      ]
    };
  },
  methods: {}
};
</script>

<style scoped>
.grid-container {
  display: grid;
  grid-template-columns: 1fr 4fr 1fr;
  grid-template-areas:
    ". . . "
    ". form  . "
    ". profiledisplay .";
  grid-gap: 20px;
}

.date-entry {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    ". start end ."
    ". start-date end-date .";
  grid-gap: 10px;
}

.start {
  grid-area: start;
}
.end {
  grid-area: end;
}
#start-date {
  grid-area: start-date;
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
#end-date {
  grid-area: end-date;
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

.form {
  grid-area: form;
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
}

.username {
  grid-area: username;
}

.education {
  grid-area: education;
  background: #ebebeb;
  padding: 12px;
  border-radius: 15px;
  width: 100%;
  margin: 10px;
}

.account {
  background: #ebebeb;
  padding: 12px;
  border-radius: 15px;
  width: 100%;
  margin: 10px;
}

.experience {
  grid-area: experience;
  background: #ebebeb;
  padding: 12px;
  border-radius: 15px;
  width: 100%;
  margin: 10px;
}

.button {
  text-align: center;
}
.profiledisplay {
  grid-area: profiledisplay;
  padding: 16px;
}
</style>
