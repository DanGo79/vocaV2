let vOne = new Vue({
    el: '#vue-one-app',
    data: {
        firstname: '',
        lastname: '',
        names: ['Danny', 'Gustav', 'Peter'],
        persons: [
            { name: 'Danny', age: 42 },
            { name: 'Gustav', age: 51},
        ]
    },

    computed: {
        fullname() {
            return `${this.firstname} ${this.lastname}`;
        },
    },
});

let vTwo = new Vue({
    el: '#vue-two-app',
    data: {
        helloStr: 'Hello World',
    },

    computed: {
        print() {
            return this.helloStr;
        },
    },
})