import { createStore } from "vuex";

export default createStore({
    state() {
        return {
            myVocabulary: []
        }
    },
    mutations: {
        addVocabulary(state, vocabulary) {
            state.myVocabulary.push(vocabulary);
        },
        removeVocabulary(state, id) {
            let newMyVocabulary = state.myVocabulary.filter(vocabulary => vocabulary.id != id)
            state.myVocabulary = newMyVocabulary;
        }
    },
    actions: {
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