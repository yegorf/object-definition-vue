<template>
    <div align="left">
        <b>Adding</b>
        <br>
        <input type="text" id="box">
        <button @click="enter">Enter</button>
        <br>

        <b>Signs</b>
        <br>
        <SignRow v-for="sign in signs" :id="sign.id" :sign="sign.sign" />
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
            enter: function() {
                const box = document.getElementById('box');
                const sign = box.value;
                //передать на серв
                axios.post('/info/addSign', null, {
                    params: {
                        sign
                    }
                });
            }
        }
    }
</script>

<style scoped>

</style>