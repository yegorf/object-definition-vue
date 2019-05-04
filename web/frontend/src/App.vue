<template>
  <div id="app">
    <h2>Object definition</h2>
    <div id="left" align="left">
      <h2>Definition</h2>
      <TestForm :signs="signs" />
    </div>
    <div id="right" align="right">
      <h2>Data</h2>
      <Info/>
    </div>
  </div>
</template>

<script>
import TestForm from './components/testing/TestForm.vue';
import axios from 'axios';
import Info from './components/info/Info.vue';

export default {
  name: 'app',
  data() {
      return {
          signs: []
      }
  },
  components: {
        TestForm, Info
  },
    async created() {
        let kek = await axios.get('/test');
        this.signs = kek.data;
        console.log(this.signs);
    }
}

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: honeydew;
}
</style>
