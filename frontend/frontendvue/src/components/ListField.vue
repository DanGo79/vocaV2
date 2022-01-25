<template>
  <section class="sectionInput">
    <b-card class="inputCard">
      <div>
        <b-list-group horizontal>
          <b-list-group-item
            style="width: 150px"
            class="tableHead"
            variant="secondary"
            >Englisch</b-list-group-item
          >
          <b-list-group-item
            style="width: 150px"
            class="tableHead"
            variant="secondary"
            >Deutsch</b-list-group-item
          >
          <b-list-group-item
            button
            style="width: 115px"
            class="tableHead"
            variant="primary"
            >Alle Lernen</b-list-group-item
          >
        </b-list-group>
      </div>
      <div>
        <ListRow
          v-for="myVocabulary in $store.state.myVocabularys"
          :key="myVocabulary.id"
          :title1="myVocabulary.nameEnglish"
          :title2="myVocabulary.nameGerman"
          title3="Lernen"
          :clickedListener="lernen"
        />
      </div>
      <div class="divBox">
        <div class="divButtons">
          <b-input-group-append>
            <div style="margin-right: 10px">
              <Button title="Liste" :clickedListener="getAssignmentList" />
            </div>
            <div style="margin-left: 10px">
              <Button to="/register" title="Register" />
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
import ListRow from "./ListRow.vue";
import { ref, watchEffect } from "vue";
import { useStore } from "vuex";
import Button from "./Button.vue";
import MessageText from "./MessageText.vue";

export default {
  name: "ListField",
  props: {},
  components: { ListRow, Button, MessageText },
  setup() {
    const store = useStore();
    let myVocabulary = ref("");
    let password1 = ref("");

    //store.commit("setMessage", "");

    watchEffect(() => {
      myVocabulary.value = store.state.myVocabulary;
    });

    function getAssignmentList() {
      store.dispatch("getAssignmentList", {
        userId: store.state.currentUser.id,
        lernenGelernt: 1,
      });
      console.log("Button was clicked");
    }

    return {
      getAssignmentList,

      password1,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.tableHead {
  height: 42px;
}

.tableRow {
  font-size: 0.9em;
}

.inputGroup {
  width: max(25vw, 300px);
  display: flex;
  flex-direction: column;
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