<template>
  <div
    class="grid-container"
    style="background-image: url('https://www.intechnic.com/hs-fs/hubfs/intechnic_2017/assets/images/landing/footer/map-xl.jpg?width=1680&height=824&name=map-xl.jpg');"
  >
    <h3 class="title grid-area">Tell us a bit about yourself</h3>
    <div class="add grid-area">
      <form class="form-add-profile" @submit.prevent="addUserProfile">
        <div class="pad-left">
          <input
            type="text"
            id="firstname"
            class="form-control"
            placeholder="First Name"
            v-model="profile.firstName"
          />

          <input
            type="text"
            id="lastname"
            class="form-control"
            placeholder="Last Name"
            v-model="profile.lastName"
          />

  

          <input
            type="text"
            id="email"
            class="form-control"
            placeholder="Email Address"
            v-model="profile.email"
          />

          <textarea
            rows="2"
            cols="50"
            class="form-control"
            placeholder="Summary"
            v-model="profile.summary"
          />
          <label id="cohort grid-area">
            Select Cohort
            <select class="form-control" v-model="profile.cohort">
              <option value="Cohort 0">Cohort 0</option>
              <option value="Cohort 01">Cohort 1</option>
              <option value="Cohort 02">Cohort 2</option>
              <option value="Cohort 03">Cohort 3</option>
            </select>
          </label>

          <label class="sk grid-area">
            Skills
            <select class="form-control" v-model="skills.skill">
              <option value="1">Java</option>
              <option value="2">Python</option>
              <option value="3">Decorative Spoon Making</option>
              <option value="4">Waxing Floors</option>
              <option value="5">Ghost Busting</option>
              <option value="6">Camel Assasinating</option>
              <option value="7">Database Entry</option>
              <option value="8">Chess</option>
              <option value="9">Doing nothing</option>
            </select>
          </label>

          <div class="number-entry">
            <label>
              Phone Number
              <input
                type="number"
                id="phonenumber"
                class="form-control"
                placeholder="xxxxxxxxxx"
                v-model="profile.phoneNumber"
              />
            </label>
            <label>
              Date of Birth
              <input
                type="date"
                id="birthdate"
                class="form-control"
                v-model="profile.birthday"
              />
            </label>
          </div>

          <div class="button">
            <router-link to="/addprofile">
              <button v-on:click="addUserProfile(); addSkill();" type="submit">Submit Profile</button>
            </router-link>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import auth from "../auth";
export default {
  data() {
    return {
      profile: {
        username: "",
        firstName: "",
        lastName: "",
        email: "",
        summary: "",
        phoneNumber: "",
        birthday: "",
        cohort: ""
      },
      skills: {
        skill: ""
      },

      profileSaveErrors: false,
      homeUrl: "http://localhost:8083"
    };
  },

  methods: {
    addUserProfile() {
      //fetch(`${process.env.VUE_APP_REMOTE_API}/register`, {
      console.log(JSON.stringify(auth.getUser()));
      this.profile["username"] = auth.getUser()["sub"];
      // this.profile.username = auth.getUser().sub
      console.log(JSON.stringify(this.profile));
      fetch(`${this.homeUrl}/addprofile`, {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.profile)
      })
        .then(response => {
          console.log(response.json());
          if (response.ok) {
            console.log("response ok");
            this.$router.push({
              path: "/",
              query: { profileSaved: "success" }
            });
          } else {
            this.profileSaveErrors = true;
          }
        })
        .then(err => console.error(err));
    },
    addSkill() {
      console.log(JSON.stringify(this.skills));
      fetch(`${this.homeUrl}/addprofile`, {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.skills)
      });
    }
  }
};
</script>

<style scoped>
.grid-container {
  display: grid;
  grid-template-columns: 2fr 3fr 2fr;
  grid-template-areas:
    ". t . "
    ". add . ";
  grid-gap: 20px;
  text-align: center;
}

@media only screen and (max-width: 768px) {
  .grid-container {
    display: grid;
    grid-template-columns: 1fr 4fr 1fr;
    grid-template-areas:
      ". t . "
      ". add . ";
    grid-gap: 20px;
    text-align: center;
  }
}
.add {
  grid-area: add;
  background: #ebebeb;
  padding: 12px;
  border-radius: 15px;
  width: 100%;
  margin: 25px;
  text-align: center;
}
.title {
  grid-area: t;
  padding-top: 35px;
  color: #ebebeb;
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
label {
  margin: 10px;
}
.form-control {
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
  margin: 10px;
}
.sk {
  grid-area: sk;
}

.number-entry {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "co sk"
    "pn bd ";
  grid-gap: 10px;
}
#birthdate {
  grid-area: bd;
}
#phonenumber {
  grid-area: pn;
}
#cohort {
  grid-area: co;
}
.pad-left {
  padding-right: 20px;
}
</style>