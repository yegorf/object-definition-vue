Vue.component('sign-form', {
    template:
    '<form>' +
    '<b>Добавление</b>' +
    '<input type="text" id="is">' +
    '<button @click="addSign">Ввести</button>' +
    '<br>' +
    '<b>Удаление</b>' +
    '<input type="text" id="de">' +
    '<button @click="deleteSign">Удалить</button>' +
    '</form>',
    methods: {
        addSign: function () {
            const sign = document.getElementById('is').value;
            axios.post('/info/add', null, {
                params: {
                    sign
                }
            });
        },

        deleteSign: function () {
            const id = document.getElementById('de').value;
            axios.post('/info/delete', null, {
                params: {
                    id
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