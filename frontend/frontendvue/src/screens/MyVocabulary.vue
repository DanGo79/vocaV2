<template>
  <div>
    <ListField />
    <a href="assets/user.xml" download="user.xml">Liste herunterladen ...</a>

    <!--
    
    -->
  </div>
</template>

<script>
import ListField from "../components/ListField.vue";
//import PuzzleField from "../components/PuzzleField.vue";

export default {
  name: "My Vocabulary",
  components: { ListField },
};
</script>


<style scoped>
</style>
