<template>
    <div id="test-row">
        <input type="checkbox" :id="id" :value="sign">
        <b>{{ sign }}</b>
    </div>
</template>

<script>
    export default {
        props: ['sign', 'id'],
        name: "TestRow"
    }
</script>

<style scoped>
    #test-row {

    }
</style>