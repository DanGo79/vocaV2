<template >
  <div class="input-group-text" type="text">{{ title }}</div>
</template>
<script>
export default {
  inheritAttrs: false,

  props: {
    title: String,
  },
};
</script>
<style >
</style>