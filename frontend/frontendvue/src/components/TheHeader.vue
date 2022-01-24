<template>
  <header class="header">
    <div class="navbarHeader">
      <div>
        <Link to="/translate" title="Home" />
      </div>
      <div>
        <div v-if="!$store.state.isLogged">
          <Link to="/login" title="Login" />
          <Link to="/register" title="Register" />
        </div>
        <div v-else>
          <Link to="/translate" title="Translate" />
          <Link to="/translations" title="Translations" />
          <Link to="/myVocabulary" title="My Vocabulary" />
          <Link title="Logout" :clickedListener="logout" />
        </div>
      </div>
      <Link to="/about" title="About" />
    </div>
  </header>
</template>
<script>
import store from "../store/store";
import Link from "./Link.vue";

export default {
  name: "TheHeader",
  components: { Link },

  setup() {
    function logout() {
      console.log("CALLED_");
      store.commit("setLoggedOut");
    }
    return {
      logout,
    };
  },
};
</script>
<style>
.header {
  background-color: rgb(71, 71, 65);
}

.navbarHeader {
  display: flex;
  justify-content: center;
  padding-top: 0.5rem;
  padding-bottom: 0.5rem;
}
</style>