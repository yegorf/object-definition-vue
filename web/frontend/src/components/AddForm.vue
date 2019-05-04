<template>
    <form>
        <b>Первый признак</b>
        <input type="text" id="s1" :value="ss1">
        <b>Второй признак</b>
        <input type="text" id="s2" :value="ss2">
        <br>
        <b>Животное</b>
        <input type="text" id="en" :value="ent">
        <br>
        <button @click="addInfo">Добавить</button>
    </form>
</template>

<script>
    export default {
        name: "add-form",
        props: ['ss1','ss2','ent'],
        methods: {
            addInfo: function () {

                const s1 = document.getElementById("s1");
                const s2 = document.getElementById("s2");
                const en = document.getElementById("en");

                const sign1 = s1.value;
                const sign2 = s2.value;
                const entity = en.value;
            }
        }
    }
</script>

<style scoped>

</style>