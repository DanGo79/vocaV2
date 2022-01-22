<template>
  <div>
    <TheHeader />
    <router-view />
  </div>
</template>

<script>
import TheHeader from "./components/TheHeader.vue";
export default {
  name: "App",
  components: { TheHeader },
};
</script>

<style >
html,
body {
  padding: 0;
  margin: 0;
}
</style>
