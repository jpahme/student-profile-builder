<template>
  <div class="login-page">
    <div
      style="background-image: url('https://www.intechnic.com/hs-fs/hubfs/intechnic_2017/assets/images/landing/footer/map-xl.jpg?width=1680&height=824&name=map-xl.jpg');"
    >
      <br />

      <div id="login" class="text-center">
        <h2 class="login-header">Welcome.</h2>
        <br />
        <form class="form-signin" @submit.prevent="login">
          <div id="login-container" class="text-center">
            <div
              class="alert alert-danger"
              role="alert"
              v-if="invalidCredentials"
            >Invalid username and password!</div>
            <div
              class="alert alert-success"
              role="alert"
              v-if="this.$route.query.registration"
            >Thank you for registering, please sign in.</div>

            <p>Log in to your Profolio</p>
            <div class="testcenter">
              <input
                type="text"
                id="username"
                class="form-control"
                placeholder="Username"
                v-model="user.username"
                required
                autofocus
              />

              <label for="password" class="sr-only">
                <br />
              </label>
              <input
                type="password"
                id="password"
                class="form-control"
                placeholder="Password"
                v-model="user.password"
                required
              />
            </div>

            <br />
            <button class="hvr-back-pulse" type="submit">Sign in</button>
            <br />
            <router-link to="/register">Need an account?</router-link>
          </div>
        </form>
        <br />
        <br />
        <br />
      </div>
    </div>
  </div>
</template>

<script>
import auth from "../auth";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false,
      homeUrl: "http://localhost:8083"
    };
  },
  methods: {
    login() {
      console.log(JSON.stringify(this.user));
      //fetch(`${process.env.VUE_APP_REMOTE_API}/login`, {
      fetch(this.homeUrl + `/login`, {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.user)
      })
        .then(response => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then(token => {
          console.log(token);
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, "");
            }
            auth.saveToken(token);
            console.log(auth.getUser());
            window.location.href = "/addprofile";
          }
        })
        .catch(err => console.error(err));
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

#login input {
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

#login-container {
  background: #ebebeb;
  padding: 12px;
  border-radius: 15px;
  width: 25%;
  margin-bottom: 350px;
}

#login button[type="submit"] {
  background: #28d;
  border-color: transparent;
  color: #fff;
  cursor: pointer;
  width: 75%;
  border-radius: 15px;
}

#login button[type="submit"]:hover {
  background: #17c;
}

#login button[type="submit"]:focus {
  border-color: #05a;
}

h2 {
  margin: auto;
  color: white;
}

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
.hvr-back-pulse:hover,
.hvr-back-pulse:focus,
.hvr-back-pulse:active {
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
  background-color: #2098d1;
  background-color: #2098d1;
  color: white;
}

.testcenter {
  padding-right: 20px;
}
</style>
