import { createStore } from "vuex";
import router from "@/router";

export default createStore({
  state() {
    return {
      myVocabulary: [],
      isLogged: localStorage.getItem("isLogged"),
      message: "",
      currentVocabulary: { nameGerman: "" },
      currentUser: localStorage.getItem("addUser"),
    };
  },
  mutations: {
    setMessage(state, message) {
      state.message = message;
    },
    setLoggedIn(state) {
      localStorage.setItem("isLogged", true);
      state.isLogged = true;
      console.log(state);
    },
    setLoggedOut(state) {
      state.isLogged = false;
      localStorage.setItem("isLogged", false);
      localStorage.removeItem("addUser");
    },
    addVocabulary(state, vocabulary) {
      state.currentVocabulary = vocabulary;
    },
    addUser(state, user) {
      state.currentUser = user;
      localStorage.setItem("addUser", JSON.stringify(user));
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
      commit("setMessage", null);
      const requestOptions = {
        method: "Post",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: JSON.stringify(data),
      };
      console.log("request OK");
      try {
        const response = await fetch(
          "http://localhost:8080/User/getUser/",
          requestOptions
        );
        if (response.ok) {
          const dataResponse = await response.json();
          commit("addUser", dataResponse);
          commit("setMessage", "Benutzer ist eingeloggt.");
          commit("setLoggedIn");

          //window.location.href = "/";
          router.push("/");
        } else {
          const dataResponse = await response.json();
          console.log(dataResponse);
          commit("setMessage", dataResponse.message);
        }
      } catch (err) {
        commit("setMessage", err.toString());
        console.log(err);
      }
    },

    async logout({ commit }) {
      commit("setLoggedOut");
    },

    async addVocabularyAction({ commit }, data) {
      commit("setMessage", null);
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
          const dataResponse = await response.json();
          console.log(dataResponse);
          commit("setMessage", dataResponse.message);
        }
      } catch (err) {
        commit("setMessage", err.toString());
        console.log(err);
      }
    },
    async deleteVocabularyAction({ commit }, id) {
      //so tun als ob wir speichern
      console.log(id);
      commit("removeVocabulary", id);
    },

    async registerUser({ commit }, data) {
      commit("setMessage", null);
      const requestOptions = {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
        body: JSON.stringify(data),
      };
      console.log("request OK");
      try {
        const response = await fetch(
          "http://localhost:8080/User/",
          requestOptions
        );
        if (response.ok) {
          const dataResponse = await response.json();
          console.log(dataResponse);
          commit("addUser", dataResponse);
          commit("setMessage", "Benutzer wurde erfolgreich angelegt.");
          commit("setLoggedIn");
        } else {
          const dataResponse = await response.json();
          console.log(dataResponse);
          commit("setMessage", dataResponse.message);
        }
      } catch (err) {
        commit("setMessage", err.toString());

        console.log(err);
      }
    },
  },
});
