<template>
  <div>
    <div>Login</div>
    <button @click="login">Login</button>
  </div>
</template>

<script>
import { useStore } from "vuex";
export default {
  name: "Login",
  setup() {
    const store = useStore();
    function buttonClicked() {
      store.dispatch("login", {
        username: "",
        password: "",
      });
      console.log("Button was clicked");
      //saveVocabulary(germanVoca.value, englishVoca.value);
    }
    return {
      login: buttonClicked,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
