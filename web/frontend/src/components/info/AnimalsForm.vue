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
            <input type="text" id="box">
            <button @click="enter">Enter</button>
            <TestRow v-for="sign in signs" :id="'s' + sign.id" :sign="sign.sign" />
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
        },

        methods: {
            enter: function() {
                const box = document.getElementById('box');
                const animal = box.value;
                //alert(animal);

                let count = 0;
                let id1;
                let id2;

                this.signs.forEach(function (s) {
                    const el = document.getElementById('s' + s.id);
                    if(el.checked) {
                        if(count === 0) {
                            id1 = s.id;
                        } else {
                            id2 = s.id;
                        }
                        count ++;
                    }
                });
                if(count === 2) {
                    console.log("Good. id1= " + id1 + " id2= " + id2);
                    //передать все на серв
                    axios.post('/info/addAnimal', null, {
                        params: {
                            animal,
                            id1,
                            id2
                        }
                    }).then((res => {
                        const result = res.data;
                        alert(result);
                    }));
                } else {
                    alert("Choose 2 signs!");
                }
            }
        }
    }
</script>

<style scoped>

</style>