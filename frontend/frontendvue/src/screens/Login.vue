<template>
  <div>
    <LoginField />
  </div>
</template>

<script>
import LoginField from "../components/LoginField.vue";
export default {
  name: "Login",
  setup() {
    return {};
  },
  components: { LoginField },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
