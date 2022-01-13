<template>
  <div>
    <vocabulary-input />
    <vocabulary-list />
  </div>
</template>

<script>
import VocabularyInput from "../components/VocabularyInput.vue";
import VocabularyList from "../components/VocabularyList.vue";
export default {
  components: { VocabularyInput, VocabularyList },
  name: "Translation",
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
