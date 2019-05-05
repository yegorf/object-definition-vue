<template>
    <div id="test-form">
        <b>Choose signs</b>
        <TestRow v-for="sign in signs" :id="sign.id" :sign="sign.sign"/>
        <button @click="go">Ready</button>
        <div :is="component" :id1="this.id1" :id2="this.id2">kek</div>
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
                id2: null
            }
        },

        props: ['signs'],

        methods: {
            go: function () {
                let sign = '';
                let count = 0;

                let idOne;
                let idTwo;


                this.signs.forEach(function (s) {
                    const el = document.getElementById(s.id);
                    if(el.checked) {
                        sign = sign + s.id + ' ';

                        if(count === 0) {
                            //this.id1 = s.id;
                            // this.id1 = 5;
                            // alert(this.id1);
                            //alert(this.id1);
                            idOne = s.id;
                        } else {
                            //this.id2 = s.id;
                            //alert(this.id2);
                            idTwo = s.id;
                        }

                        count++;
                    }

                });

                this.id1 = idOne;
                this.id2 = idTwo;


                switch (count) {
                    case 0:
                        alert("0");
                        //Ввести 2 признака и название
                        //this.component = 'ModalForm';
                        break;
                    case 1:
                        alert("1");
                        //Ввести 1 признак и название
                        //this.component = 'ModalForm';
                        break;
                    case 2:
                        alert("2");
                        //Шлем на серв
                        axios.post('/test/find', null, {
                            params: {
                                sign
                            }
                        }).then((res => {
                            const animal = res.data;
                            if(animal !== 'no') {
                                alert(animal)
                                //Конец ветки
                            } else {
                                //s1 = отмеченное
                                //s2 = отмеченное
                                //en = null
                                //this.component = 'add-form';
                                //Ввести только название
                                this.component = 'ModalForm';
                                alert("no")
                            }
                        }));
                        break;
                }

                // if(count === 0) {
                //     this.component = 'add-form';
                // } else if(count === 1) {
                //     //Вводим 1 признак и зверя
                //     let first;
                //     this.signs.forEach(function (s) {
                //         const el = document.getElementById(s.id);
                //         if(el.checked) {
                //             first = el.value; //Это передаем на форму как уже s1 (value)
                //         }
                //     });
                //     this.ss1 = first.toString();
                //     this.component = 'add-form';
                //
                //
                // } else if(count === 2) {
                //     axios.post('/test/find', null, {
                //         params: {
                //             sign
                //         }
                //     }).then((res => {
                //         const animal = res.data;
                //         if(animal !== 'no') {
                //             //Вводим только название животного
                //             alert(animal)
                //         } else {
                //             //Вводим только название
                //             //s1 = отмеченное
                //             //s2 = отмеченное
                //             //en = null
                //
                //             this.component = 'add-form';
                //         }
                //     }));
                // }
            }
        }
    }
</script>

<style>
    #test-form {
        background-color: mistyrose;
    }
</style>