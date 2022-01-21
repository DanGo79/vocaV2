<template>
  <section class="sectionInput">
    <b-card class="inputCard">
      <p>Fehler: {{ $store.state.error }}</p>

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

      <div class="divBox">
        <b-input-group-append>
          <Button title="Felder löschen" :clickedListener="deleteClicked" />
          <Button title="Vokabel speichern" :clickedListener="deleteClicked" />
        </b-input-group-append>
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

export default {
  components: { InputField, TextField, Button },

  name: "VocabularyInput",
  props: {},
  setup() {
    const store = useStore();
    let germanVoca = ref("");
    let englishVoca = ref("");

    watchEffect(() => {
      console.log("Hallo");
      germanVoca.value = store.state.currentVocabulary.nameGerman;
    });

    function searchVocabulary() {
      store.dispatch("addVocabularyAction", {
        nameEnglish: englishVoca.value,
      });

      //germanVoca.value = store.state.currentVocabulary.nameGerman;
      console.log("Button was clicked");
      //saveVocabulary(germanVoca.value, englishVoca.value);
    }

    function deleteClicked() {
      germanVoca.value = "";
      englishVoca.value = "";
      console.log("Delete was Clicked");
    }

    return {
      searchVocabulary,
      germanVoca,
      englishVoca,
      deleteClicked,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.inputGroup {
  width: max(25vw, 330px);
}

.inputButton {
  width: 160px;
  margin-right: 10px;
  margin-left: 10px;
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
</style>