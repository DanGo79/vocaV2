<template>
  <div>
    <div v-for="vocabulary in $store.state.myVocabulary" :key="vocabulary">
      <vocabulary :voca="vocabulary" />
    </div>
  </div>
</template>

<script>
import Vocabulary from "./Vocabulary.vue";
export default {
  components: { Vocabulary },
  name: "VocabularyList",
  props: {},
  setup() {
    return {};
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>