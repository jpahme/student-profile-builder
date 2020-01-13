<template>
    <div class="about">
        <br>
    <br>
    <body>
    <h2>About</h2>
    <hr>
    <p>Profolio is a social media site designed for both students and employers. 
        Students have the ability create an online profile that will display their professional summary, resume, as well as projects they've completed. 
        Employers can can browse and search through the student profiles. 
        Once a profile is created it can be updated easily on our platform. 
        The main purpose of this site is for students to build an online profile that can showcase their work and make it availble for employers to see.
<br><br>
This site was create as a final capstone for Tech Elevator school of software devlopment by Chris Day, Austin Grant, Nathan Newcomb and John Paul Ahme.
<br><br>
Thank you for visiting.  
    </p>

    <br><br>
    <center><a href="/"><div class="return1 hvr-bounce-in"><img src="../assets/return1.png" width="160px"></div></a></center>

<hr>
    </body>
    </div>
</template>

<script>
export default {
    name: 'About'
}
</script>

<style scoped>
.about {
  margin-right: 80px;
  margin-left: 80px; 
  
}
h2 {
    text-align: center;
    color: black;
}

p {
    text-align: center;
}



/* Bounce In */
.hvr-bounce-in {
   
  display: inline-block;
  vertical-align: middle;
  -webkit-transform: perspective(4px) translateZ(0);
  transform: perspective(4px) translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
  -webkit-transition-duration: 0.5s;
  transition-duration: 0.5s;
}
.hvr-bounce-in:hover, .hvr-bounce-in:focus, .hvr-bounce-in:active {
  -webkit-transform: scale(1.2);
  transform: scale(1.2);
  -webkit-transition-timing-function: cubic-bezier(0.47, 2.02, 0.31, -0.36);
  transition-timing-function: cubic-bezier(0.47, 2.02, 0.31, -0.36);
}
</style>