<template>
  <div>

    <p style="float:left;font-size: 30px">Movie Titles</p>
    <br>
    <br>
    <br>
    <div style="display: flow-root;    float: left;">
      <div style="height:300px;display:grid;margin:30px;float:left;" v-for="item in items.titles">
        <span style="float:left;">Title: {{item.title}}</span><br>
        <span style="float:left;"> <img :src="item.image" style="width:150px;height:200px"> </span><br>
        <span style="float:left;">Id: {{item.id}}</span><br>
      </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <p style="float:left;font-size: 30px">Movie Actor Names</p>
    <br>
    <br>
    <br>
    <div style="display: flow-root;    float: left;">
      <div style="height:300px;display:grid;margin:30px;float:left;" v-for="item in items.names">
        <span style="float:left;">Title: {{item.title}}</span><br>
        <span style="float:left;"> <img :src="item.image" style="width:150px;height:200px"> </span><br>
        <span style="float:left;">Id: {{item.id}}</span><br>
      </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <p style="float:left;font-size: 30px">Movie Companies</p>
    <br>
    <br>
    <br>
    <div style="display: flow-root;    float: left;">
      <div style="height:300px;display:grid;margin:30px;float:left;" v-for="item in items.companies">
        <span style="float:left;">Title: {{item.title}}</span><br>
        <span style="float:left;"> <img :src="item.image" style="width:150px;height:200px"> </span><br>
        <span style="float:left;">Id: {{item.id}}</span><br>
      </div>
    </div>

  </div>
</template>

<script>
    export default {
        data() {
            return {
                items: []
            };
        },
        mounted() {
            this.axios.get('http://localhost:8100/search', {})
                .then((response) => {
                    this.items = response.data;
                }, (error) => {
                    console.log(error);
                });
        }
    };
</script>

<style>


</style>
