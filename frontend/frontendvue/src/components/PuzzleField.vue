<template>
  <section class="sectionInput">
    <b-card class="inputCard">
      <div class="divBox">
        <TextField :title="$route.params.nameGerman" />
      </div>

      <div class="divBox" v-if="!won">
        <draggable
          class="list-group list-group-horizontal"
          :list="charArray"
          @change="itemSwapped"
        >
          <b-list-group-item
            v-for="char in charArray"
            :key="char"
            class="notselectable"
            :style="{
              backgroundColor: `rgb(${char.background}, ${0}, ${0})`,
              color: 'rgb(212, 212, 218)',
              fontWeight: bolder,
            }"
            >{{ char.char }}
          </b-list-group-item>
        </draggable>
      </div>

      <div class="divBox list-group list-group-horizontal" v-if="won">
        <b-list-group-item
          v-for="char in charArray"
          :key="char"
          class="notselectable"
          :style="{
            backgroundColor: `rgb(${0}, ${256}, ${0})`,
            fontWeight: bolder,
          }"
          >{{ char.char }}
        </b-list-group-item>
      </div>

      <div class="divBox" style="margin-top: 25px">
        <MessageText />
      </div>

      <div class="divBox">
        <div class="divButtons">
          <b-input-group-append>
            <div>
              <Button to="/myVocabulary" title="Zurück" />
            </div>
          </b-input-group-append>
        </div>
      </div>
    </b-card>
  </section>
</template>

<script>
import { computed, ref } from "vue";
import { VueDraggableNext } from "vue-draggable-next";
import { useStore } from "vuex";
import { useRoute } from "vue-router";
import Button from "../components/Button.vue";
import MessageText from "../components/MessageText.vue";
import TextField from "../components/TextField.vue";

export default {
  name: "PuzzleField",
  props: {},
  components: {
    TextField,
    Button,
    MessageText,
    draggable: VueDraggableNext,
  },
  setup() {
    const store = useStore();
    store.commit(
      "setMessage",
      "Bilde das englische Wort durch verschieben der Buchstaben!  Tip: von Hell zu Dunkel"
    );
    const route = useRoute();

    const vocabulary = route.params.nameEnglish;
    console.log("Param: " + vocabulary);
    const string = vocabulary;
    const usingSplit = string.split("");
    const usingArrayFrom = Array.from(usingSplit);
    console.log(usingArrayFrom);

    let x = usingArrayFrom.length;
    console.log("let x: " + usingArrayFrom.length);
    let z = 256;
    let y = Math.floor(z / (x + 2));
    z += y;
    let tmpArray = [];
    usingArrayFrom.forEach((element) => {
      let c = z - y;
      let charColor = {
        char: element,
        background: c,
      };
      z = c;
      tmpArray.push(charColor);
    });

    let charArray = ref(tmpArray);

    let shuffle = (a) => {
      let j, x, i;
      for (i = a.length - 1; i > 0; i--) {
        j = Math.floor(Math.random() * (i + 1));
        x = a[i];
        a[i] = a[j];
        a[j] = x;
      }
    };

    console.log(tmpArray);
    shuffle(tmpArray);

    return {
      won: computed(() => {
        for (var i = 0; i < usingArrayFrom.length; i++) {
          if (usingArrayFrom[i] != charArray.value[i].char) {
            return false;
          }
        }
        store.commit("setMessage", "Das ist richtig:)");
        return true;
      }),
      itemSwapped: (event) => {
        console.log(JSON.stringify(event));
        const oldItem = charArray.value[event.oldIndex];
        charArray.value[event.oldIndex] = charArray.value[event.newIndex];
        charArray.value[event.newIndex] = oldItem;
      },

      charArray,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.inputCard {
  background-color: rgb(195, 195, 202);
  align-items: center;
  height: auto;
  width: max(50vw, 600px);
}

.sectionInput {
  background-color: rgb(212, 212, 218);
  display: flex;
  justify-content: center;
}

.divBox {
  display: flex;
  justify-content: center;
  margin: 35px;
  width: max(450px);
}

.divButtons {
  display: flex;
  justify-content: center;
}
</style>