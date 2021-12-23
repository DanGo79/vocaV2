<template>
  <div>
    <div>Id: {{ props }}</div>
    <button @click="deleteVocabulary">delete</button>
  </div>
</template>

<script>
import { useStore } from "vuex";
export default {
  name: "Vocabulary",
  props: {
    voca: Object,
  },
  setup(props) {
    const store = useStore();
    function deleteVocabulary() {
      store.dispatch("deleteVocabularyAction", props.voca.id);
    }
    return {
      props,
      deleteVocabulary,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>