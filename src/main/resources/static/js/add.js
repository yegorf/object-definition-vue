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

            alert("add");
        }
    }
});

var add = new Vue({
    el: '#addInfo',
    template:
        '<add-form />',
    data: {
        signs: []
    },

    async created() {
        alert('hi');
    }
});