<template>
  <div>
    <div>
      <router-link to="/">Home</router-link>
      <div v-if="!$store.state.isLoggedIn">
        <router-link to="/login">Login</router-link>
        <router-link to="/register">Register</router-link>
      </div>
      <div v-else>
        <router-link to="/translate">Translate</router-link>
        <router-link to="/translations">Translations</router-link>
        <router-link to="/myVocabulary">My Vocabulary</router-link>
        <router-link to="/logout">Logout</router-link>
      </div>
      <router-link to="/about">About</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "App",
  components: {},
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
