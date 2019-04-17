//Test
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
    '<changer />' +
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
                //window.open('add.html', '_self');
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

//Add
Vue.component("add-form", {
    template:
    '<form>' +
    '<b>Первый признак</b>' +
    '<input type="text" id="sign1">' +
    '<br>' +
    '<b>Второй признак</b>' +
    '<input type="text" id="sign2">' +
    '<br>' +
    '<b>Животное</b>' +
    '<input type="text" id="entity">' +
    '<br>' +
    '<button @click="addInfo">Добавить</button>' +
    '</form>',

    methods: {
        addInfo: function () {
            const sign1 = document.getElementById("sign1");
            const sign2 = document.getElementById("sign2");
            const entity = document.getElementById("entity");

            axios.post('/result/addTwo', null, {
                params: {
                    sign1,
                    sign2,
                    entity
                }
            });
        }
    }
});

//changer
Vue.component('changer', {
    data: function () {
        return {
            componentName: null
        }
    },
    template:
    '<div>' +
        '<button @click="add">Добавить животное</button>\n' +
        '<button @click="remove">Скрыть</button>\n' +
        '\n' +
        ' <div :is="componentName"></div>' +
    '</div>',
    methods: {
        add() {
            this.componentName = 'add-form'
        },
        remove() {
            this.componentName = null
        }
    }
});

var test = new Vue({
    el: '#test',
    template:
        '<test-form :signs="signs"/>',
    data: {
        signs: [],
        componentName: null
    },

    async created() {
        let kek = await axios.get('/test');
        this.signs = kek.data;
        console.log(this.signs);
    }

});
