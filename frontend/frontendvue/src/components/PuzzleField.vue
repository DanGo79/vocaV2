<template>
  <section class="sectionInput">
    <b-card class="inputCard">
      <div class="divBox">
        <TextField :title="$route.params.nameGerman" />
      </div>

      <div class="divBox">
        <b-list-group horizontal id="charList">
          <b-list-group-item
            v-for="char in word"
            :key="char"
            :style="{ backgroundColor: charColor() }"
            >{{ char }}
          </b-list-group-item>
        </b-list-group>
      </div>

      <div class="divBox">
        <div class="divButtons">
          <b-input-group-append>
            <div style="margin-right: 10px">
              <Button title="Liste" :clickedListener="getAssignmentList" />
            </div>
            <div style="margin-left: 10px">
              <Button to="/myVocabulary" title="Zurück" />
            </div>
          </b-input-group-append>
        </div>
      </div>
      <div style="margin-top: 25px">
        <MessageText />
      </div>
    </b-card>
  </section>
</template>

<script>
import { ref, watchEffect } from "vue";
import { useRoute } from "vue-router";
import Button from "../components/Button.vue";
import MessageText from "../components/MessageText.vue";
import TextField from "../components/TextField.vue";

export default {
  name: "PuzzleField",
  props: {},
  components: { TextField, Button, MessageText },
  setup() {
    const route = useRoute();
    let word = ref("");
    const vocabulary = route.params.nameEnglish;
    console.log("Param: " + vocabulary);
    const string = vocabulary;
    const usingSplit = string.split("");
    const usingArrayFrom = Array.from(usingSplit);

    let a = usingArrayFrom;
    shuffle(a);
    const usingObjectAssign = Object.assign([], a);
    word = usingObjectAssign;
    console.log(usingObjectAssign);

    //store.commit("setMessage", "");

    watchEffect(() => {});

    let z = 256;

    function charColor() {
      const f = z;
      const x = f - 20;
      z = x;
      console.log(z);
      return `rgb(${0}, ${z}, ${0})`;
    }

    function shuffle(a) {
      let j, x, i;
      for (i = a.length - 1; i > 0; i--) {
        j = Math.floor(Math.random() * (i + 1));
        x = a[i];
        a[i] = a[j];
        a[j] = x;
      }
      return a;
    }

    return {
      charColor,
      word,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.odd {
  background-color: #c02020;
}
.even {
  background-color: #413fad;
}

.tableHead {
  height: 42px;
}

.tableRow {
  font-size: 0.9em;
}

.inputGroup {
  width: max(25vw, 300px);
}

.inputButton {
  width: 160px;

  margin-right: 10px;
  margin-left: 10px;
}

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
}

.inputField {
  margin: 10px;
}
.divButtons {
  display: flex;
  justify-content: center;
}
</style>