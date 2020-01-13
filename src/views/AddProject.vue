<template>
    <div
        class="grid-container"
        style="background-image: url('https://www.intechnic.com/hs-fs/hubfs/intechnic_2017/assets/images/landing/footer/map-xl.jpg?width=1680&height=824&name=map-xl.jpg');">
    
        <h4>Portfoio:</h4>

        <h5>Add to Portfolio</h5>

        <div class="projects grid-area">
            <label>
                <form class="porfolio">
                    <div class="input-port">
                        <input type="text" id="firstname" class="form-control" placeholder="Project name" v-model="project.name"/>

                        <textarea rows="2" cols="50" class="form-control" placeholder="Description" v-model="project.description"/>

                        <div class="number-entry grid-area">
                            <label>
                                Start Date
                                <input type="date" id="sd grid-area" class="form-control" v-model="project.startDate"/>
                            </label>
                            <label>
                                End Date
                                <input type="date" id="ed grid area" class="form-control" v-model="project.endDate"/>
                            </label>
                        </div>
                        <div class="button">
                            <router-link to="/">
                                <button v-on:click="addProject();" type="submit" class="btn btn-primary">Add to Portfolio</button>
                            </router-link>
                        </div>
                    </div>
                </form>
            </label>
        </div>
  
    </div>


</template>

<script>
import auth from "../auth";
export default {
    data() {
        return {
            project: {
                username: "",
                name: "",
                description: "",
                startDate: "",
                endDate: ""
            },

            projectSaveErrors: false,
            homeUrl: "http://localhost:8083"
        }

    },

    methods: {
        addProject() {
            console.log(JSON.stringify(auth.getUser()));
            this.project["username"] = auth.getUser()["sub"]
            console.log(JSON.stringify(this.project));
            fetch(`${this.homeUrl}/addproject/${auth.getUser()["sub"]}`, {
                method: "POST",
                headers: {
                    Accept: "application/json",
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(this.project)

            })
                .then(response => {
                    console.log(response.json());
                    if(response.ok) {
                        console.log("response ok");
                        this.$router.push({
                            path: "/",
                            query: { projectSaved: "success" }
                        });
                    } else {
                        this.projectSaveErrors = true;
                    }
                })
                .then(err => console.error(err));
        }

    }
}

</script>

<style scoped>
    .grid-container {
        display: grid;
        grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
        grid-template-areas:
            ". . . . . . "
            ". project project project project ."
            ;

        grid-gap: 20px;
    }

    .project {
        grid-area: project;
        border: 10px solid;
        border-radius: 15px;
        border-color: #eeeded;
        padding: 10px;
        background-color: #ffffff;
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

input {
  margin-right: 10px;
}

    

</style>>