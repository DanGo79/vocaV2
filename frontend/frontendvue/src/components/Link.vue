<template lang="">

  <b-button
  class="text-decoration-none"
  variant="link"
   :to="link"
@click="clickedListener"
>{{ title }}</b-button>
</template>
<script>
export default {
  props: {
    title: String,
    clickedListener: Function,
    link: String,
  },
};
</script>
<style lang="">
</style>