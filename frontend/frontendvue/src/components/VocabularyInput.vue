<template>
  <section class="sectionInput">
    <b-card class="inputCard">
      <p>Fehler: {{ $store.state.error }}</p>

      <div class="divBox">
        <b-input-group class="inputGroup">
          <b-input-group-prepend>
            <Textfield text="Englisch" />
          </b-input-group-prepend>
          <Inputfield
            id="englishVoca"
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
          <b-button
            class="inputButton"
            variant="outline-primary"
            id="createVoca"
            @click="searchVocabulary"
            >Übersetzen</b-button
          >
        </b-input-group-append>
      </div>

      <div class="divBox">
        <b-input-group class="inputGroup">
          <b-input-group-text>Deutsch</b-input-group-text>
          <Inputfield
            id="germanVoca"
            placeholder="Deutsche Übersetzung"
            v-model="germanVoca"
            :clickedListener="searchVocabulary"
          />
        </b-input-group>
      </div>

      <div class="divBox">
        <b-input-group-append>
          <b-button
            class="inputButton"
            variant="outline-primary"
            @click="seleteClicked"
          >
            Felder löschen
          </b-button>
          <b-button
            class="inputButton"
            variant="outline-primary"
            id="createVoca"
            @click="searchVocabulary"
            >Vokabel speichern</b-button
          >
        </b-input-group-append>
      </div>
    </b-card>
  </section>
</template>

<script>
import { ref, watchEffect } from "vue";
import { useStore } from "vuex";
import Inputfield from "./Inputfield.vue";
import Textfield from "./Textfield.vue";

export default {
  components: { Inputfield, Textfield },

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

    function seleteClicked() {
      germanVoca.value = "";
      englishVoca.value = "";
      console.log("Delete was Clicked");
    }

    return {
      searchVocabulary,
      germanVoca,
      englishVoca,
      seleteClicked,
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