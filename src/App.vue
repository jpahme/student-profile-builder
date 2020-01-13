<template>
  <div id="app">
    <Header/>
    <router-view/>
    <Footer/>
  </div>
</template>


<script>
import Header from './components/Header.vue';
import Footer from '@/components/Footer.vue';


export default {
  name: 'app',
  components: {
    Header,
    Footer
  }
}
</script>

<style>
* {
   font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
   
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
</style>