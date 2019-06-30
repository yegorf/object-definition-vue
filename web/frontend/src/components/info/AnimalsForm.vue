<template>
    <div>
        <div id="right">
            <b>Animals</b>
            <br>
            <input type="text" v-model="remove">
            <button @click="del">Delete</button>
            <br>
            <AnimalRow v-for="animal in animals" :id="animal.id" :animal="animal.animal"/>
        </div>

        <div id="left">
            <b>Adding</b>
            <br>
            <input type="text" v-model="add">
            <button @click="enter">Enter</button>
            <TestRow v-for="sign in signs" :id="'s' + sign.id" :sign="sign.sign"/>
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
                signs: [],
                add: null,
                remove: null
            }
        },

        async created() {
            let animalsData = await axios.get('/info/animals');
            let signData = await axios.get('/info/signs');
            this.animals = animalsData.data;
            this.signs = signData.data;
        },

        methods: {
            del: function () {
                axios.post('/info/deleteAnimal', null, {
                    params: {
                        animal: this.remove
                    }
                });
            },

            enter: function () {
                let count = 0;
                let id1;
                let id2;

                this.signs.forEach(function (s) {
                    const el = document.getElementById('s' + s.id);
                    if (el.checked) {
                        if (count === 0) {
                            id1 = s.id;
                        } else {
                            id2 = s.id;
                        }
                        count++;
                    }
                });
                if (count === 2) {
                    axios.post('/info/addAnimal', null, {
                        params: {
                            animal: this.add,
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