<template>
  <input
    type="text"
    class="form-control"
    :placeholder="placeholder"
    :value="modelValue"
    @input="$emit('update:modelValue', $event.target.value)"
    @keyup.enter="clickedListener"
  />
</template>


<script>
export default {
  name: "InputField",
  props: {
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
<style>
</style>