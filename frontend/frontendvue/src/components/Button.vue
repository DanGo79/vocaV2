<template >
  <b-button
    type="button"
    class="mx-1"
    variant="outline-primary"
    @click="clickedListener"
  >
    {{ title }}
  </b-button>
</template>

<script>
export default {
  props: {
    title: String,
    clickedListener: Function,
  },
};
</script>
<style >
</style>