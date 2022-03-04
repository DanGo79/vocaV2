<template>
  <b-list-group horizontal>
    <b-list-group-item
      style="width: 150px; height: 28px; padding-top: 0px; padding-bottom: 0px"
      >{{ title1 }}</b-list-group-item
    >
    <b-list-group-item
      style="width: 150px; height: 28px; padding-top: 0px; padding-bottom: 0px"
      >{{ title2 }}</b-list-group-item
    >
    <b-list-group-item
      button
      style="width: 115px; height: 28px; padding-top: 0px; padding-bottom: 0px"
      variant="primary"
      @click="clickedListener"
      >{{ title3 }}</b-list-group-item
    >
    <b-badge variant="primary" pill>{{ gelernt }}</b-badge>
  </b-list-group>
</template>

<script>
export default {
  name: "ListField",
  props: {
    title1: String,
    title2: String,
    title3: String,
    gelernt: Number,
    clickedListener: Function,
  },
  components: {},
};
</script>
<style>
.rowField {
  width: 150px;
  height: 28px;
  padding-top: 0px;
  padding-bottom: 0px;
}
</style>