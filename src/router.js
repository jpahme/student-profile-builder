import Vue from 'vue'
import Router from 'vue-router'
import auth from './auth'
import Home from './views/Home.vue'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import Contact from './views/Contact.vue'
import EditProfile from './views/EditProfile.vue'
import AddProfile from './views/AddProfile.vue'
import About from './views/About.vue'
import SearchLanding from './views/SearchLanding.vue'
import AddProject from './views/AddProject.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/contact",
      name: "Contact",
      component: Contact,
      meta: {
        requiresAuth: false
      }
    }, 
    {
    path: "/About",
    name: "About",
    component: About,
    meta: {
      requiresAuth: false
    }
  

    },
    {
      path: "/editprofile",
      name: "edit-profile",
      component: EditProfile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addprofile",
      name: "add-profile",
      component: AddProfile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/searchlanding",
      name: "search-landing",
      component: SearchLanding,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addproject",
      name: "add-profolio",
      component: AddProject,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const user = auth.getUser();

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && !user) {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }

});

export default router;
