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
    export default {
        name: "Info",
        data: function () {
            return {
                componentName: null
            }
        },
        methods: {
            // add() {
            //     this.componentName = 'add-form'
            // },
            // remove() {
            //     this.componentName = null
            // }

            showSigns() {
                this.componentName = '';
            },

            showAnimals() {
                this.componentName = '';
            }
        }
    }
</script>

<style scoped>
    #info-menu {
        background-color: antiquewhite;
    }
</style>