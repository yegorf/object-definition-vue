<template>
    <div>
        <modal v-if="showModal" @close="showModal = false">
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
        </modal>

    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: "ModalForm",
        props: ["id1", "id2"],
        data() {
            return {
                showModal : true
            }
        },
        methods: {
            show: function () {
                this.showModal = false;
                const box = document.getElementById('iAnimal');
                const animal = box.value;

                axios.post('/info/addAnimal', null, {
                    params: {
                        animal,
                        id1 : this.id1,
                        id2 : this.id2
                    }
                }).then((res => {
                    const result = res.data;
                    alert(result);
                }));
            },
            exit: function () {
                this.showModal = false;
            }
        },
        async created() {
            const sign1Box = document.getElementById('iSign1');
            const sign2Box = document.getElementById('iSign2');

            // if(this.id1 != null) {
            //     sign1Box.value = this.id1;
            // }
            // if(this.id2 != null) {
            //     sign2Box.value = this.id2;
            // }
            // sign1Box.value = 5;
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