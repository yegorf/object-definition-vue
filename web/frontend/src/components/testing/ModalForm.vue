<template>
    <div>
        <div v-if="showModal" @close="showModal = false">
            <transition name="modal">
                <div class="modal-mask">
                    <div class="modal-wrapper">
                        <div class="modal-container">

                            <div class="modal-header">
                                <slot name="header">
                                    Enter the information
                                </slot>
                            </div>

                            <div class="modal-body">
                                <slot name="body">
                                    <b>Animal name</b><br>
                                    <input type="text" id="iAnimal"><br>
                                    <b>First sign</b><br>
                                    <input type="text" id="iSign1"><br>
                                    <b>Second sign</b><br>
                                    <input type="text" id="iSign2"><br>
                                </slot>
                            </div>

                            <div class="modal-footer">
                                <slot name="footer">
                                    <button class="modal-default-button" @click="show">
                                        Enter
                                    </button>
                                    <button class="modal-default-button" @click="exit">
                                        Not add
                                    </button>
                                </slot>
                            </div>
                        </div>
                    </div>
                </div>
            </transition>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: "ModalForm",
        props: ["id1", "id2", "sign1", "sign2"],
        data() {
            return {
                showModal: true,
                s1: null,
                s2: null
            }
        },
        methods: {
            show: function () {
                this.showModal = false;
                const box = document.getElementById('iAnimal');
                const animal = box.value;

                const sign1Box = document.getElementById("iSign1");
                const sign2Box = document.getElementById("iSign2");

                if (sign1Box.disabled && sign2Box.disabled) {
                    axios.post('/info/addAnimal', null, {
                        params: {
                            animal,
                            id1: this.id1,
                            id2: this.id2
                        }
                    }).then((res => {
                        const result = res.data;
                        alert(result);
                    }));
                } else if (!sign1Box.disabled && !sign2Box.disabled) {
                    this.s1 = sign1Box.value;
                    this.s2 = sign2Box.value;

                    axios.post('/result/addTwo', null, {
                        params: {
                            animal,
                            sign1: this.s1,
                            sign2: this.s2
                        }
                    }).then((res => {
                        const result = res.data;
                        alert(result);
                    }));
                } else {
                    this.s1 = sign2Box.value;

                    axios.post('/result/addOne', null, {
                        params: {
                            animal,
                            sign: this.s1,
                            id: this.id1
                        }
                    }).then((res => {
                        const result = res.data;
                        alert(result);
                    }));
                }
            },
            exit: function () {
                this.showModal = false;
            }
        },
        async mounted() {
            const sign1Box = document.getElementById("iSign1");
            const sign2Box = document.getElementById("iSign2");

            if (this.id1 != null) {
                sign1Box.value = this.sign1;
                sign1Box.disabled = true;
            }
            if (this.id2 != null) {
                sign2Box.value = this.sign2;
                sign2Box.disabled = true;
            }
        }
    }
</script>

<style>
    .modal-mask {
        position: fixed;
        z-index: 9998;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, .5);
        display: table;
        transition: opacity .3s ease;
    }

    .modal-wrapper {
        display: table-cell;
        vertical-align: middle;
    }

    .modal-container {
        width: 300px;
        margin: 0px auto;
        padding: 20px 30px;
        background-color: #fff;
        border-radius: 2px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
        transition: all .3s ease;
        font-family: Helvetica, Arial, sans-serif;
    }

    .modal-header h3 {
        margin-top: 0;
        color: #42b983;
    }

    .modal-body {
        margin: 20px 0;
    }

    .modal-default-button {
        float: right;
    }

    .modal-enter .modal-container,
    .modal-leave-active .modal-container {
        -webkit-transform: scale(1.1);
        transform: scale(1.1);
    }
</style>