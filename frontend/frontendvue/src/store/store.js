import { createStore } from "vuex";

export default createStore({
  state() {
    return {
      myVocabulary: [],
      isLogged: false,
      error: "",
      currentVocabulary: { nameGerman: "" },
    };
  },
  mutations: {
    setError(state, err) {
      state.error = err;
    },
    setLoggedIn(state) {
      state.isLoggedIn = true;
    },
    setLoggedOut(state) {
      state.isLoggedIn = true;
    },
    addVocabulary(state, vocabulary) {
      state.currentVocabulary = vocabulary;
    },

    // removeVocabulary(state, id) {
    //  let newMyVocabulary = state.myVocabulary.filter(
    //     (vocabulary) => vocabulary.id != id
    //   );
    //   state.myVocabulary = newMyVocabulary;
    //},
  },
  actions: {
    async login({ commit }, data) {
      console.log(data);
      commit("setLoggedIn");
    },
    async logout({ commit }) {
      commit("setLoggedOut");
    },
    async addVocabularyAction({ commit }, data) {
      commit("setError", null);
      const requestOptions = {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: JSON.stringify(data),
      };
      try {
        const response = await fetch(
          "http://localhost:8080/Vocabulary/searchEnglish/",
          requestOptions
        );
        if (response.ok) {
          const dataResponse = await response.json();
          console.log(dataResponse);
          commit("addVocabulary", dataResponse);
        } else {
          commit("setError", "Ein Fehler ist aufgetreten!");
        }
      } catch (err) {
        commit("setError", err.toString());
        console.log(err);
      }
    },
    async deleteVocabularyAction({ commit }, id) {
      //so tun als ob wir speichern
      console.log(id);
      commit("removeVocabulary", id);
    },
  },
});
