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
            let sign = '';
            let count = 0;

            this.signs.forEach(function (s) {
                const el = document.getElementById(s.id);
                if(el.checked) {
                    sign = sign + s.id + ' ';
                    count++;
                }
            });

            if(count === 0) {
                alert('0');
                window.open('add.html', '_self');

            } else if(count === 1) {
                alert('1');
            } else if(count === 2) {
                axios.post('/test/find', null, {
                    params: {
                        sign
                    }
                });
            }
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
