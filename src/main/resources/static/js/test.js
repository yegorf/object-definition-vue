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
                        alert(animal)
                    } else {
                        //Выводим результат
                        alert("Такого зверя нет. Добавить?");
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
    '<input type="text" id="s1">' +
    '<br>' +
    '<b>Второй признак</b>' +
    '<input type="text" id="s2">' +
    '<br>' +
    '<b>Животное</b>' +
    '<input type="text" id="en">' +
    '<br>' +
    '<button @click="addInfo">Добавить</button>' +
    '</form>',

    methods: {
        addInfo: function () {
            const s1 = document.getElementById("s1");
            const s2 = document.getElementById("s2");
            const en = document.getElementById("en");

            const sign1 = s1.value;
            const sign2 = s2.value;
            const entity = en.value;

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
