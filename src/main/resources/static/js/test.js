//Test
// Vue.component('test-row', {
//     props: ['sign', 'id'],
//     template:
//     '<div>' +
//     '<input type="checkbox" :id="id" :value="sign">' +
//      ' - {{ sign }}' +
//     '</div>'
// });

// Vue.component('test-form', {
//     data: function() {
//       return {
//           component: null,
//           ss1: '',
//           ss2: '',
//           ent: ''
//       }
//     },
//     props: ['signs'],
//
//     template:
//     '<div>' +
//     '<changer />' +
//     '<test-row v-for="sign in signs" :id="sign.id" :sign="sign.sign"/>' +
//     '<button @click="go">Ready</button>' +
//     '<div :is="component" :ss1="ss1" :ss2="ss2" :ent="ent">kek</div>' +
//     '</div>',

    // methods: {
    //     go: function () {
    //         let sign = '';
    //         let count = 0;
    //
    //         this.signs.forEach(function (s) {
    //             const el = document.getElementById(s.id);
    //             if(el.checked) {
    //                 sign = sign + s.id + ' ';
    //                 count++;
    //             }
    //         });
    //
    //         if(count === 0) {
    //             this.component = 'add-form';
    //         } else if(count === 1) {
    //             //Вводим 1 признак и зверя
    //             let first;
    //             this.signs.forEach(function (s) {
    //                 const el = document.getElementById(s.id);
    //                 if(el.checked) {
    //                     first = el.value; //Это передаем на форму как уже s1 (value)
    //                 }
    //             });
    //             this.ss1 = first.toString();
    //             this.component = 'add-form';
    //
    //
    //         } else if(count === 2) {
    //             axios.post('/test/find', null, {
    //                 params: {
    //                     sign
    //                 }
    //             }).then((res => {
    //                 const animal = res.data;
    //                 if(animal !== 'no') {
    //                     //Вводим только название животного
    //                     alert(animal)
    //                 } else {
    //                     //Вводим только название
    //                     //s1 = отмеченное
    //                     //s2 = отмеченное
    //                     //en = null
    //
    //                     this.component = 'add-form';
    //                 }
    //             }));
    //         }
    //     }
    // }
//});

//AddAll
// Vue.component("add-form", {
//     props: ['ss1','ss2','ent'],
//     template:
//     '<form>' +
//         '<b>Первый признак</b>' +
//     '<input type="text" id="s1" :value="ss1">' +
//     '<br>' +
//     '<b>Второй признак</b>' +
//     '<input type="text" id="s2" :value="ss2">' +
//     '<br>' +
//     '<b>Животное</b>' +
//     '<input type="text" id="en" :value="ent">' +
//     '<br>' +
//     '<button @click="addInfo">Добавить</button>' +
//     '</form>',
//
//     methods: {
//         addInfo: function () {
//
//             const s1 = document.getElementById("s1");
//             const s2 = document.getElementById("s2");
//             const en = document.getElementById("en");
//
//             const sign1 = s1.value;
//             const sign2 = s2.value;
//             const entity = en.value;
//
//             // const path = '/result/addTwo';
//             //
//             // axios.post(path, null, {
//             //     params: {
//             //         sign1,
//             //         sign2,
//             //         entity
//             //     }
//             // });
//         }
//     }
// });
//addAll

//changer
// Vue.component('changer', {
//     data: function () {
//         return {
//             componentName: null
//         }
//     },
//     template:
//     '<div>' +
//         '<button @click="add">Добавить животное</button>\n' +
//         '<button @click="remove">Скрыть</button>\n' +
//         '\n' +
//         ' <div :is="componentName"></div>' +
//     '</div>',
//     methods: {
//         add() {
//             this.componentName = 'add-form'
//         },
//         remove() {
//             this.componentName = null
//         }
//     }
// });

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
