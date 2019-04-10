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
                //Вводим 2 признака и зверя
                alert('0');
                window.open('add.html', '_self');
            } else if(count === 1) {
                //Вводим 1 признак и зверя
                alert('1');
                window.open('add.html', '_self');
            } else if(count === 2) {
                axios.post('/test/find', null, {
                    params: {
                        sign
                    }
                }).then((res => {
                    const animal = res.data;
                    if(animal !== 'no') {
                        //Вводим только название животного
                        alert("Животного с такими признаками нет. Добавить?")
                    } else {
                        //Выводим результат
                        alert(animal);
                    }
                }));
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
