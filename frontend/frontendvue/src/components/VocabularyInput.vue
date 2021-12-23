<template>
  <section class="py-5">
    <div>
      <div style="margin: 25px">
        <p>English</p>
        <input id="englishVoca" type="text" v-model="englishVoca" />
      </div>
      <div style="margin: 25px">
        <p>Deutsch</p>
        <input id="germanVoca" type="text" v-model="germanVoca" />
      </div>
      <button style="margin-left: 25px" id="createVoca" @click="buttonClicked">
        create
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

    function buttonClicked() {
      store.dispatch("addVocabularyAction", {
        id: 10,
        germanVoca: germanVoca.value,
        englishVoca: englishVoca.value,
      });
      console.log("Button was clicked");
      //saveVocabulary(germanVoca.value, englishVoca.value);
    }
    return {
      buttonClicked,
      germanVoca,
      englishVoca,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>