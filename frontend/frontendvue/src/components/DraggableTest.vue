<template lang="">
    <div>
       <draggable class="dragArea list-group w-full" :list="list" @change="log">
  <div
    class="list-styles"
    v-for="element in list"
    :key="element.name"
  >
    {{ element.name }}
  </div>
</draggable> 
    </div>
</template>
<script>
import { VueDraggableNext } from "vue-draggable-next";
import { ref } from "@vue/reactivity";

export default {
  components: {
    draggable: VueDraggableNext,
  },

  setup() {
    const list = ref([]);

    list.value.push({ name: "vue", id: 1 });
    list.value.push({ name: "script", id: 2 });
    list.value.push({ name: "com", id: 3 });

    return {
      enabled: true,
      list,
      dragging: false,
      log: (event) => {
        const oldIndex = event.oldIndex;
        const newIndex = event.newIndex;
        var swap = list.value[oldIndex];
        list.value[oldIndex] = list.value[newIndex];
        list.value[newIndex] = swap;
      },
    };
  },
};
</script>
<style lang="">
</style>