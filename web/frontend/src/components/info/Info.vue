<template>
    <div id="info-menu">
        <div id="menu">
            <button @click="showSigns">Signs</button>
            <button @click="showAnimals">Animals</button>
        </div>

        <div id="content">
            <div :is="componentName"></div>
        </div>
    </div>
</template>

<script>
    import AnimalsForm from './AnimalsForm.vue';
    import SignForm from './SignForm.vue';

    export default {
        name: "Info",
        components: {AnimalsForm, SignForm},
        data: function () {
            return {
                componentName: null
            }
        },
        methods: {
            showSigns() {
                this.componentName = 'SignForm';
            },

            showAnimals() {
                this.componentName = 'AnimalsForm';
            }
        }
    }
</script>

<style scoped>
    #info-menu {
        background-color: cadetblue;
    }
</style>