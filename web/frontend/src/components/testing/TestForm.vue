<template>
    <div id="test-form">
        <b>Choose signs</b>
        <TestRow v-for="sign in signs" :id="sign.id" :sign="sign.sign"/>
        <button @click="go">Ready</button>
        <div :is="component" :id1="this.id1" :id2="this.id2" :sign1="this.sign1" :sign2="this.sign2">kek</div>
    </div>
</template>

<script>
    import TestRow from "./TestRow";
    import axios from 'axios';
    import ModalForm from './ModalForm.vue';

    export default {
        name: "TestForm",

        components: {TestRow, ModalForm},

        data: function() {
            return {
                component: null,
                id1: null,
                id2: null,
                sign1: null,
                sign2: null
            }
        },

        props: ['signs'],

        methods: {
            go: function () {
                let sign = '';
                let count = 0;

                let idOne;
                let idTwo;
                let signOne;
                let signTwo;

                this.signs.forEach(function (s) {
                    const el = document.getElementById(s.id);
                    if(el.checked) {
                        sign = sign + s.id + ' ';

                        if(count === 0) {
                            idOne = s.id;
                            signOne = s.sign;
                        } else {
                            idTwo = s.id;
                            signTwo = s.sign;
                        }
                        count++;
                    }

                });

                this.id1 = idOne;
                this.id2 = idTwo;
                this.sign1 = signOne;
                this.sign2 = signTwo;

                switch (count) {
                    case 0:
                        //Ввести 2 признака и название
                        this.component = 'ModalForm';
                        break;
                    case 1:
                        //Ввести 1 признак и название
                        this.component = 'ModalForm';
                        break;
                    case 2:
                        axios.post('/test/find', null, {
                            params: {
                                sign
                            }
                        }).then((res => {
                            const animal = res.data;
                            if(animal !== 'no') {
                                alert(animal)
                            } else {
                                this.component = 'ModalForm';
                            }
                        }));
                        break;
                }
            }
        }
    }
</script>

<style>
    #test-form {
        background-color: mistyrose;
    }
</style>