<template>
  <div id="main-container">
    <nav class="navbar navbar-expand-md navbar-light bg-light">
      <router-link class="navbar-brand" to="/">
        <img class="logo hvr-pulse" src="../assets/logo2.png" alt="Profolio logo" />
      </router-link>
      <button
        type="button"
        class="navbar-toggler"
        data-toggle="collapse"
        data-target="#navbarCollapse"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
        <div class="navbar-nav">
          <a href="/login" class="nav-item hvr-pulse nav-link active">
            <font color="white">
              <strong>Login</strong>
            </font>
          </a>
          <a href="/register" class="nav-item hvr-pulse nav-link">
            <font color="white">
              <strong>Register</strong>
            </font>
          </a>
          <span @click="handleLogOut" v-if="isLoggedIn" class="nav-item hvr-pulse nav-link active">
            <font color="white">
              <strong>Log Out</strong>
            </font>
          </span>
          <a href="/about" class="nav-item hvr-pulse nav-link">
            <img class="info" src="../assets/infoi.png" alt="information" />
          </a>
        </div>
        <form class="form-inline">
          <input
            type="text"
            id="search"
            class="s1 form-control"
            placeholder="What are you looking for?"
          />
          <div class="input-group-append">
            <router-link to="/searchlanding">
              <button type="button" class="btn btn-secondary hvr-pulse">
                <img class="search" src="../assets/search.jpg" />
                <i class="fa fa-search"></i>
              </button>
            </router-link>
          </div>
        </form>
      </div>
    </nav>
  </div>
</template>

<script>
import auth from "../auth";

export default {
  name: "Header",
  data() {
    return {};
  },
  methods: {
    handleLogOut() {
      auth.destroyToken();
      window.location.href = "/login";
    }
  },
  computed: {
    isLoggedIn() {
      return auth.getUser() !== null;
    }
  }
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css?family=Acme&display=swap");

.nav-link {
  text-align: left;
}

.logo.grow {
  transition: all 0.2s ease-in-out;
}

.grow:hover {
  transform: scale(1.1);
}

img {
  width: 200px;
}

.bg-light {
  background: #3281a8 !important;
}

.info {
  width: 15px;
}

.btn {
  border-radius: 15px;
  background-color: #3281a8;
  border: 0px;
}
.search {
  width: 40px;
  border: 0px;
}

/* Pulse */
@-webkit-keyframes hvr-pulse {
  25% {
    -webkit-transform: scale(1.1);
    transform: scale(1.1);
  }
  75% {
    -webkit-transform: scale(0.9);
    transform: scale(0.9);
  }
}
@keyframes hvr-pulse {
  25% {
    -webkit-transform: scale(1.1);
    transform: scale(1.1);
  }
  75% {
    -webkit-transform: scale(0.9);
    transform: scale(0.9);
  }
}
.hvr-pulse {
  display: inline-block;
  vertical-align: middle;
  -webkit-transform: perspective(1px) translateZ(0);
  transform: perspective(1px) translateZ(0);
}
.hvr-pulse:hover,
.hvr-pulse:focus,
.hvr-pulse:active {
  -webkit-animation-name: hvr-pulse;
  animation-name: hvr-pulse;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-timing-function: linear;
  animation-timing-function: linear;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
  background-color: rgba(0, 0, 0, 0);
}

.s1 {
  background-color: #dbdbdb;
  border: none;
}

.s1:hover {
  background-color: white;
}
</style>