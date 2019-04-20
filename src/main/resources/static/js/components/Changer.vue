<template>
    <div>' +
        <button @click="add">Добавить животное</button>
        <button @click="remove">Скрыть</button>
        <div :is="componentName"></div>
    </div>
</template>

<script>
    export default {
        name: "Changer",
        data: function () {
            return {
                componentName: null
            }
        },
        methods: {
            add() {
                this.componentName = 'add-form'
            },
            remove() {
                this.componentName = null
            }
        }
    }
</script>

<style scoped>

</style>