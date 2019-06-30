<template>
    <div id="app">
        <h1>Animal definition</h1>

        <div id="left">
            <h2>Definition</h2>
            <TestForm :signs="signs"/>
        </div>
        <div id="right">
            <h2>Data</h2>
            <Info/>
        </div>
    </div>
</template>

<script>
    import TestForm from './components/testing/TestForm.vue';
    import axios from 'axios';
    import Info from './components/info/Info.vue';
    import ModalForm from './components/testing/ModalForm.vue'

    export default {
        name: 'app',
        data() {
            return {
                signs: []
            }
        },
        components: {
            TestForm, Info, ModalForm
        },
        async created() {
            let kek = await axios.get('/test');
            this.signs = kek.data;
            console.log(this.signs);
        }
    }

</script>

<style>
    body {
        background-color: honeydew;
    }

    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;

    }

    #left {
        width: 50%;
        float: left;
        background-color: lightgreen;
        min-height: 300px;
    }

    #right {
        width: 50%;
        float: left;
        background-color: lightskyblue;
        min-height: 300px;
    }
</style>
