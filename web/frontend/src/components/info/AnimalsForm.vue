<template>
    <div>
        <div id="right">
            <b>Animals</b>
            <br>
            <AnimalRow v-for="animal in animals" :id="animal.id" :animal="animal.animal"/>
        </div>

        <div id="left">
            <b>Adding</b>
            <br>
            <input type="text">
            <button>Enter</button>
            <TestRow v-for="sign in signs" :id="sign.id" :sign="sign.sign" />
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import AnimalRow from './AnimalRow.vue';
    import TestRow from "../testing/TestRow";


    export default {
        name: "AnimalsForm",

        components: {AnimalRow, TestRow},

        data() {
            return {
                animals: [],
                signs: []
            }
        },

        async created() {
            let kek = await axios.get('/info/animals');
            let s = await axios.get('/info/signs');
            this.animals = kek.data;
            this.signs = s.data;
        }
    }
</script>

<style scoped>

</style>