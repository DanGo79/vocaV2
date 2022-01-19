<template>
  <section class="py-5">
    <div>
      <p>Fehler: {{ $store.state.error }}</p>

      <div style="margin: 25px">
        <p>English</p>
        <input
          id="englishVoca"
          type="text"
          placeholder="Wort in Englisch eingeben"
          v-model="englishVoca"
          style="width: 200px"
        />
      </div>
      <div style="margin: 25px">
        <p>Deutsch</p>
        <input
          id="germanVoca"
          type="text"
          placeholder="Deutsche Übersetzung"
          v-model="$store.state.currentVocabulary.nameGerman"
          style="width: 200px"
        />
      </div>
      <button style="margin-left: 25px" id="createVoca" @click="buttonClicked">
        Übersetzen
      </button>
      <button style="margin-left: 25px" @click="seleteClicked">
        Felder löschen
      </button>
    </div>
  </section>
</template>

<script>
import { ref } from "vue";
import { useStore } from "vuex";

export default {
  name: "VocabularyInput",
  props: {},
  setup() {
    const store = useStore();
    let germanVoca = ref("");
    let englishVoca = ref("");

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
      buttonClicked: searchVocabulary,
      germanVoca,
      englishVoca,
      seleteClicked,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>