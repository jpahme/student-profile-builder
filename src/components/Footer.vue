<template>
<div class="footer-script">
<div class="info">
    <small>&copy;2019 Capstone -</small>
    <router-link to="/contact"><small> Contact Us</small></router-link>
</div>


<!--
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">

<link href='https://fonts.googleapis.com/css?family=Inconsolata:400,700' rel='stylesheet' type='text/css'>
<div class="pad50"></div>
<div class="container">

<h5>Connect with us!</h5>
  <a href="https://facebook.com/colorlib" target="_blank" class="button facebook"><span><i class="fa fa-facebook" aria-hidden="true"></i></span>Facebook</a>
  <a href="https://www.linkedin.com/company/colorlib" target="_blank" class="button linkedin"><span><i class="fa fa-linkedin" aria-hidden="true"></i></span>Linkedin</a>
  <a href="#" class="button instagram"><span><i class="fa fa-instagram" aria-hidden="true"></i></span>Instagram</a>

</div>
-->



</div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
.footer-script {
    text-align: center;
 
}

.info{
    display: inline-block;
}



.container { width: 90%; text-align: center; margin: auto;
}

.pad50{
  padding-top: 50px;
}

.button {

  display: inline-block;
  height: 40px;
  line-height: 40px;
  padding-right: 30px;
  padding-left: 70px;
  position: relative;
  color:rgb(255,255,255);
  text-decoration: none;
  text-transform: none;
  letter-spacing: 1px;
  margin-bottom: 14px;
  text-shadow:1px 1px 0px rgba(0,0,0,0.5);
}

.button:hover{
  text-decoration: none;
  color: #fff;
  text-shadow: none;
}

.button p{font-size: 18px;}
.button span {
  position: absolute;
  left: 0;
  width: 50px;
  font-size:30px;
  -webkit-border-top-left-radius: 5px;
-webkit-border-bottom-left-radius: 5px;
-moz-border-radius-topleft: 5px;
-moz-border-radius-bottomleft: 5px;
border-top-left-radius: 5px;
border-bottom-left-radius: 5px;
border-right: 1px solid  rgba(0,0,0,0.15);
    text-decoration: none;
}

.button.facebook {
 background: #3b5998;
}

.button.linkedin {
  background: #0e76a8;
}


.button.instagram{
  background: #3f729b;
}

.text-center{
  text-align: center;
}

</style>