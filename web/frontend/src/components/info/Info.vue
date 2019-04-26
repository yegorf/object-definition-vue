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

    export default {
        name: "Info",
        components: {AnimalsForm},
        data: function () {
            return {
                componentName: null
            }
        },
        methods: {
            showSigns() {
                this.componentName = null;
            },

            showAnimals() {
                this.componentName = 'AnimalsForm';
            }
        }
    }
</script>

<style scoped>
    #info-menu {
        background-color: antiquewhite;
    }
</style>