<template>
  <div>
    <VocabularyInput />
    <div>Hallo</div>
    <draggable-test />
  </div>
</template>

<script>
import DraggableTest from "../components/DraggableTest.vue";
import VocabularyInput from "../components/VocabularyInput.vue";
export default {
  name: "Home",
  components: { VocabularyInput, DraggableTest },
};
</script>


<style scoped>
</style>
