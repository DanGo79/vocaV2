<template>
  <div>
    <vocabulary-input />
    <vocabulary-list />
  </div>
</template>

<script>
import VocabularyList from "./components/VocabularyList.vue";
import VocabularyInput from "./components/VocabularyInput.vue";

export default {
  name: "App",
  components: {
    VocabularyInput,
    VocabularyList,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
