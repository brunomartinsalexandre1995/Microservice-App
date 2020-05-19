<template>
  <div>
    {{ test }}
  </div>
</template>

<script>



    export default {
        data() {
            return {
                test: []
            };
        },
        mounted() {
            let config = {
                    headers: {
                        'Access-Control-Allow-Origin':'*'
                    },
                    options: {}
                }
            ;


            this.$http.get('http://localhost:8080/search', config)
                .then(response => {
                    this.test = response.data
                })
                .catch(err => {
                    // Manage the state of the application if the request
                    // has failed
                })
        }
    };
</script>

<style>

  .welcome-message {
    margin-top: 20px;
    font-size: 22px;
    font-weight: bold;
  }


  #arcade {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }


</style>
