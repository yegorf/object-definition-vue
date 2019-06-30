<template>
    <div id="signs">
        <b>Adding</b>

        <br>
        <input type="text" id="box">
        <button @click="enter">Enter</button>
        <br>
        <input type="text" id="dSign">
        <button @click="del">Delete</button>
        <br>

        <b>Signs</b>
        <br>
        <SignRow v-for="sign in signs" :id="sign.id" :sign="sign.sign"/>
    </div>
</template>

<script>
    import SignRow from './SignRow.vue';
    import axios from 'axios';

    export default {
        name: "SignForm",

        components: {SignRow},

        data() {
            return {
                signs: []
            }
        },

        async created() {
            let kek = await axios.get('/info/signs');
            this.signs = kek.data;
        },

        methods: {
            enter: function () {
                const box = document.getElementById('box');
                const sign = box.value;


                axios.post('/info/addSign', null, {
                    params: {
                        sign
                    }
                }).then((res => {
                    const result = res.data;
                    alert(result);
                }));
            },

            del: function () {
                const box = document.getElementById('dSign');
                const sign = box.value;

                axios.post('/info/deleteSign', null, {
                    params: {
                        sign
                    }
                });
            }
        }
    }
</script>

<style scoped>
    #signs {
        background: beige;
    }
</style>