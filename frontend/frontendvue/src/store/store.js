import { createStore } from "vuex";

export default createStore({
    state() {
        return {
            myVocabulary: [],
            isLogged: false
        }
    },
    mutations: {
        setLoggedIn(state) {
            state.isLoggedIn = true;
        },
        setLoggedOut(state) {
            state.isLoggedIn = true;
        },
        addVocabulary(state, vocabulary) {
            state.myVocabulary.push(vocabulary);
        },
        removeVocabulary(state, id) {
            let newMyVocabulary = state.myVocabulary.filter(vocabulary => vocabulary.id != id)
            state.myVocabulary = newMyVocabulary;
        }
    },
    actions: {
        async login({ commit }, data) {
            console.log(data);
            commit('setLoggedIn');
        },
        async logout({ commit }) {
            commit('setLoggedOut');
        },
        async addVocabularyAction({ commit }, data) {
            //so tun als ob wir speichern
            console.log(data);
            commit('addVocabulary', data);
        },
        async deleteVocabularyAction({ commit }, id) {
            //so tun als ob wir speichern
            console.log(id);
            commit('removeVocabulary', id);
        }
    }
})