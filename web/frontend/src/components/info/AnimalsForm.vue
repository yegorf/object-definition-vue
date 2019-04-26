<template>
    <div>
        <!--<AnimalRow v-for="animal in animals" :id="animal.id" :animal="animal.animal"/>-->
    </div>
</template>

<script>
    import axios from 'axios';
    import AnimalRow from 'AnimalRow.vue';

    export default {
        name: "AnimalsForm",

        components: {AnimalRow},

        data() {
            return {
                animals: []
            }
        },

        async created() {
            let kek = await axios.get('/info/animals');
            this.animals = kek.data;
            console.log(this.animals);
        }
    }
</script>

<style scoped>

</style>