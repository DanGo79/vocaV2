<template lang="EN">
          <input
           :id="id"
            
            class="form-control"
            :placeholder="placeholder"
            :value="modelValue"
    @input="$emit('update:modelValue', $event.target.value)"
            @keyup.enter="clickedListener"
          >
</template>

<script>
export default {
  props: {
    id: String,
    type: Text,
    placeholder: {
      type: String,
      default: "",
    },

    modelValue: {
      type: String,
      default: "",
    },
    clickedListener: Function,
  },
};
</script>
<style lang="EN">
</style>