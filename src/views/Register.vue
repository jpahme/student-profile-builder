<template>
  <div class="register-page"
   style="background-image: url('https://www.intechnic.com/hs-fs/hubfs/intechnic_2017/assets/images/landing/footer/map-xl.jpg?width=1680&height=824&name=map-xl.jpg');"
  >
    <br />

    <div id="register" class="text-center">
      <form class="form-register" @submit.prevent="register">
        <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
        <div class="login-container">
          <div
            class="alert alert-danger"
            role="alert"
            v-if="registrationErrors"
          >There were problems registering this user.</div>

          <p><u>Select account type:</u></p>
          <div class="testcenter">
          <input type="radio" id="student" name="account-type" v-model="user.role" value="5" />
          <label for="student">Student</label>
          <br />
          <input type="radio" id="employer" name="account-type" v-model="user.role" value="2" />
          <label for="employer">Employer</label>
          </div>

          <br />
          <br />
          <div class="t2">
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
          <br />
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
          
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
          </div>
          <br />
          <button class="btn btn-lg btn-primary btn-block hvr-back-pulse" type="submit">Create Account</button>
          <br />
          <router-link :to="{ name: 'login' }">
            <small>If you already have an account, click here.</small>
          </router-link>
        </div>
        <br />
        <br />
        <br />
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "register",
  components: {},

  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: ""
      },
      registrationErrors: false,
      homeUrl: "http://localhost:8083"
    };
  },
  methods: {
    register() {
      //fetch(`${process.env.VUE_APP_REMOTE_API}/register`, {
      fetch(`${this.homeUrl}/register`, {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.user)
      })
        .then(response => {
          console.log(response.json());
          if (response.ok) {
            this.$router.push({
              path: "/login",
              query: { registration: "success" }
            });
          } else {
            this.registrationErrors = true;
          }
        })
        .then(err => console.error(err));
    }
  }
};
</script>

<style>
.login-page {
  text-align: center;
}

.text-center {
  display: inline-block;
  width: 100%;
}

.form-register {
  display: inline-block;
  width: 30%;
}

.login-container {
  background: #ebebeb;
  padding: 12px;
  border-radius: 15px;
  text-align: center;
  width: 100%;
}

input {
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

button[type="submit"] {
  background: #28d;
  border-color: transparent;
  color: #fff;
  cursor: pointer;
  border-radius: 15px;
}

input[type="text"] {
  border-radius: 15px;
}

input[type="password"] {
  border-radius: 15px;
}

button[type="submit"]:hover {   
  background: #17c;
}

/* Buttons' focus effect */
button[type="submit"]:focus {
  border-color: #05a;
}

.form-register label {
  display: inline-block;
  width: 200px;
  padding: 10px;
  border: solid 2px #ccc;
  transition: all 0.3;
  width: 100%;
  text-align: center;
  border-radius: 15px;
  margin: 8px;
}

.form-register input[type="radio"] {
  display: none;
  width: 100%;
}

.form-register input[type="radio"]:checked + label {
  border: solid 2px #17c;
  width: 100%;
}

/* #register {
  display: inline-block;
  width: 100%;

} */

/* .register-parent {
  text-align: center;
} */

/* Back Pulse */
@-webkit-keyframes hvr-back-pulse {
  50% {
    background-color: rgba(32, 152, 209, 0.75);
  }
}
@keyframes hvr-back-pulse {
  50% {
    background-color: rgba(32, 152, 209, 0.75);
  }
}
.hvr-back-pulse {
  display: inline-block;
  vertical-align: middle;
  -webkit-transform: perspective(1px) translateZ(0);
  transform: perspective(1px) translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
  overflow: hidden;
  -webkit-transition-duration: 0.5s;
  transition-duration: 0.5s;
  -webkit-transition-property: color, background-color;
  transition-property: color, background-color;
}
.hvr-back-pulse:hover, .hvr-back-pulse:focus, .hvr-back-pulse:active {
  -webkit-animation-name: hvr-back-pulse;
  animation-name: hvr-back-pulse;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-delay: 0.5s;
  animation-delay: 0.5s;
  -webkit-animation-timing-function: linear;
  animation-timing-function: linear;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
  background-color: #2098D1;
  background-color: #2098d1;
  color: white;
}
h1 {
  color: white;
}

.testcenter {
  padding-right: 20px; 
}

.t2 {
  padding-right: 20px; 
}

</style> 