Vue.component('test-row', {
    props: ['sign', 'id'],
    template:
    '<div>' +
        '<input type="checkbox" :id="id">' +
        ' - {{ sign }}' +
    '</div>'
});

Vue.component('test-form', {
    props: ['signs'],
    template:
    '<div>' +
        '<test-row v-for="sign in signs" :id="sign.id" :sign="sign.sign"/>' +
        '<button @click="go">Ready</button>' +
    '</div>',
    methods: {
        go: function () {
           // var sign = [];
            var sign = '';

            this.signs.forEach(function (s) {
                var el = document.getElementById(s.id);
                if(el.checked) {
              //      sign.push(s.id);
                    sign = sign + s.id + ' ';
                }
            });
            axios.post('/test/find', null, {
                params: {
                    sign
                }
            });
        }
    }
});

var test = new Vue({
    el: '#test',
    template:
        '<test-form :signs="signs"/>',
    data: {
        signs: []
    },

    async created() {
        let kek = await axios.get('/test');
        this.signs = kek.data;
        console.log(this.signs);
    }
});
