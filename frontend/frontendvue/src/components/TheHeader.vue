<template>
  <header class="header">
    <div class="navbarHeader">
      <div>
        <Link to="/" title="Home" />
        <Link to="/about" title="About" />
      </div>
      <div>
        <div v-if="!$store.state.isLoggedIn">
          <Link to="/login" title="Login" />
          <Link to="/register" title="Register" />
        </div>
        <div v-else>
          <Link to="/translate" title="Translate" />
          <Link to="/translations" title="Translations" />
          <Link to="/myVocabulary" title="My Vocabulary" />
          <Link to="/logout" title="Logout" />
        </div>
      </div>
    </div>
  </header>
</template>
<script>
import Link from "./Link.vue";

export default {
  name: "TheHeader",
  components: { Link },
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