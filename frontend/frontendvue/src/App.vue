<template>
  <div>
    <TheHeader />
    <router-view />
  </div>
</template>

<script>
import TheHeader from "./components/TheHeader.vue";
import store from "./store/store";

export default {
  name: "App",
  components: { TheHeader },

  setup() {
    store.commit("setLoggedOut");
  },
};
</script>

<style >
html,
body {
  padding: 0;
  margin: 0;
}
</style>
