Vue.component('sign-form', {
    template:
    '<form>' +
    '<input type="text" id="is">' +
    '<button @click="addSign">Ввести</button>' +
    '</form>',
    methods: {
        addSign: function () {
            const sign = document.getElementById('is').value;
            alert('lol');

            axios.post('/info/add', null, {
                params: {
                    sign
                }
            });
        }
    }
});

Vue.component('sign-row', {
    props: ['sign'],
    template:
    '<div>' +
    '<i>{{sign.id}}</i> <b>{{sign.sign}}</b>' +
    '</div>'
});

Vue.component('sign-table', {
    props: ['signs'],
    template:
    '<div>' +
    '<sign-row v-for="sign in signs" :sign="sign" :key="sign.id" />' +
    '<sign-form />' +
    '</div>'
});

var app = new Vue({
    el: '#app',
    template:
        '<sign-table :signs="signs"/>',
    data: {
        signs: []
    },

    async created() {
        let kek = await axios.get('/info');
        this.signs = kek.data;
        console.log('kek');

        console.log(this.signs);
    }
});