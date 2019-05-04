<template>
    <div id="test-form">
        <b>Choose signs</b>
        <TestRow v-for="sign in signs" :id="sign.id" :sign="sign.sign"/>
        <button @click="go">Ready</button>
        <div :is="component" :ss1="ss1" :ss2="ss2" :ent="ent">kek</div>
    </div>
</template>

<script>
    import TestRow from "./TestRow";
    import axios from 'axios';

    export default {
        name: "TestForm",
        components: {TestRow},
        data: function() {
            return {
                component: null,
                ss1: '',
                ss2: '',
                ent: ''
            }
        },
        props: ['signs'],
        methods: {
            go: function () {
                let sign = '';
                let count = 0;

                this.signs.forEach(function (s) {
                    const el = document.getElementById(s.id);
                    if(el.checked) {
                        sign = sign + s.id + ' ';
                        count++;
                    }
                });

                if(count === 0) {
                    this.component = 'add-form';
                } else if(count === 1) {
                    //Вводим 1 признак и зверя
                    let first;
                    this.signs.forEach(function (s) {
                        const el = document.getElementById(s.id);
                        if(el.checked) {
                            first = el.value; //Это передаем на форму как уже s1 (value)
                        }
                    });
                    this.ss1 = first.toString();
                    this.component = 'add-form';


                } else if(count === 2) {
                    axios.post('/test/find', null, {
                        params: {
                            sign
                        }
                    }).then((res => {
                        const animal = res.data;
                        if(animal !== 'no') {
                            //Вводим только название животного
                            alert(animal)
                        } else {
                            //Вводим только название
                            //s1 = отмеченное
                            //s2 = отмеченное
                            //en = null

                            this.component = 'add-form';
                        }
                    }));
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