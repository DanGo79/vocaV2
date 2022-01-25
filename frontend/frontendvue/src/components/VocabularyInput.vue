<template>
  <section class="sectionInput">
    <b-card class="inputCard">
      <div>
        <div class="divBox">
          <b-input-group class="inputGroup">
            <text-field title="Englisch" />

            <input-field
              placeholder="Wort in Englisch eingeben"
              v-model="englishVoca"
              :clickedListener="searchVocabulary"
            />
          </b-input-group>
          <!--
        <b-input-group class="inputGroup">-->
        </div>

        <div class="divBox">
          <b-input-group-append>
            <Button title="Übersetzen" :clickedListener="searchVocabulary" />
          </b-input-group-append>
        </div>

        <div class="divBox">
          <b-input-group class="inputGroup">
            <text-field title="Deutsch" />
            <input-field
              placeholder="Deutsche Übersetzung"
              v-model="germanVoca"
              :clickedListener="searchVocabulary"
            />
          </b-input-group>
        </div>
      </div>

      <div class="divButtons">
        <div style="margin: 10px">
          <Button title="Felder löschen" :clickedListener="deleteClicked" />
        </div>
        <div>
          <div style="margin: 10px">
            <Button
              v-if="$store.state.isLogged"
              title="Vokabel speichern"
              :clickedListener="createAssignment"
            />
          </div>
          <div style="margin: 10px">
            <Button
              v-if="!$store.state.isLogged"
              title="Vokabel speichern"
              :clickedListener="linkToLogin"
            />
          </div>
        </div>
      </div>

      <div style="margin-top: 25px">
        <MessageText />
      </div>
    </b-card>
  </section>
</template>

<script>
import { ref, watchEffect } from "vue";
import { useStore } from "vuex";
import Button from "./Button.vue";
import InputField from "./InputField";
import TextField from "./TextField";
import MessageText from "./MessageText.vue";
import router from "@/router";

export default {
  components: { InputField, TextField, Button, MessageText },

  name: "VocabularyInput",
  props: {},
  setup() {
    const store = useStore();
    let germanVoca = ref("");
    let englishVoca = ref("");
    store.commit("setMessage", "");
    console.log(store.state.currentUser);
    console.log(store.state.isLogged);

    watchEffect(() => {
      germanVoca.value = store.state.currentVocabulary.nameGerman;
      englishVoca.value = store.state.currentVocabulary.nameEnglish;
    });

    function searchVocabulary() {
      store.dispatch("addVocabularyAction", {
        nameEnglish: englishVoca.value,
      });

      console.log("Button was clicked");
      //saveVocabulary(germanVoca.value, englishVoca.value);
    }

    function deleteClicked() {
      germanVoca.value = "";
      englishVoca.value = "";
      console.log("Delete was Clicked");
    }

    function linkToLogin() {
      store.commit(
        "setMessage",
        "Um Vokabeln speichern zu können bitte eingeloggen!"
      );
      router.push("/login");
    }

    function createAssignment() {
      store.dispatch("createAssignment", {
        userId: store.state.currentUser.id,
        vocaId: store.state.currentVocabulary.id,
      });

      store.commit("setMessage", "Vokabel gespeichert!");
    }

    return {
      searchVocabulary,
      germanVoca,
      englishVoca,
      deleteClicked,
      linkToLogin,
      createAssignment,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.inputGroup {
  width: max(25vw, 330px);
}
.inputCard {
  background-color: rgb(195, 195, 202);
  align-items: center;
  height: auto;
  width: max(50vw, 600px);
}
.sectionInput {
  background-color: rgb(212, 212, 218);
  display: flex;
  justify-content: center;
}
.divBox {
  display: flex;
  justify-content: center;
  margin: 35px;
}
.divButtons {
  display: flex;
  justify-content: center;
}
</style>