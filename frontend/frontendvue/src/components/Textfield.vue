<template >
  <div class="input-group-text notselectable" type="text">{{ title }}</div>
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