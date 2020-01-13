<template>
<div class="contact">
   <div section id="logo">
    <br>
    
    <body>
   <center><h3><u>Contact Us</u></h3></center>
   <br><br>
<center><img src="https://images.squarespace-cdn.com/content/55ef2da9e4b03f6e1ef0cd28/1573837430685-80KGNIB9IVQO3GMY344H/Stacked+logo_white+behind+the+mark.png?content-type=image%2Fpng"></center>
<br>
   <center> <p>Thank you for visiting our site.<br>
    You may contact us with the following information:
    </p></center>
    <br>
   


    <div class="contactus">
    <center><p><strong>Tech Elevator</strong><br>
    Email: <i>Hello@techelevator.com</i><br>
    Phone: <i>877.606.3203</i>
    </p></center>
    </div>
    
    <div section id="link1">
       <center> <p>To learn more about Tech Elevator, <a href="http://techelevator.com/">click here.</a></p></center>
    </div>
   <section id="info2">
<center><button class="b2" id="alert" v-on:click="myFunction()"><img src="http://cdn.onlinewebfonts.com/svg/img_519962.png" height="22" width="22"/></button></center>

   </section>
  
    <hr>

    </body>
    </div>
</div>
</template>

<script>
export default {
  name: 'contact',
    methods: {
        myFunction() {
    alert("Tech Elevator is an immersive 14-week coding bootcamp with tracks in Java and . NET. Their mission is to elevate people, companies, and communities. ... For the final capstone project, students will work together on a business project, building a fully-functional app using either Java or . NET.");
    }
}
}
</script>

<style scoped>

img {
    width: 25%;
   
}
 h3 {
     color: gray;
 }

.b2 {
    
    border-radius: 100%;
    border: none;
    background-color: rgba(0, 0, 0, 0);
    width: 6%;
}

</style>