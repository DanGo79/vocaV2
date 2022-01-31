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
          :clickedListener="
            () => {
              //lernen(myVocabulary);

              $router.push({
                name: 'Puzzle',
                params: myVocabulary,
              });
            }
          "
        />
      </div>
      <div class="divBox">
        <div class="divButtons">
          <b-input-group-append>
            <div style="margin-left: 10px">
              <Button
                title="Liste downloaden"
                :clickedListener="saveTextFile"
              />
            </div>

            <div style="margin-left: 10px">
              <Button title="Liste upload" :clickedListener="importTextFile" />
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
import { watchEffect } from "vue";
import { useStore } from "vuex";
import Button from "./Button.vue";
import MessageText from "./MessageText.vue";
import { saveAs } from "file-saver";

export default {
  name: "ListField",
  props: {},
  components: { ListRow, Button, MessageText },
  setup() {
    const store = useStore();
    store.dispatch("getAssignmentList", {
      userId: store.state.currentUser.id,
      lernenGelernt: 1,
    });
    store.commit("setMessage", "");

    //store.commit("setMessage", "");

    watchEffect(() => {});

    function getAssignmentList() {
      store.dispatch("getAssignmentList", {
        userId: store.state.currentUser.id,
        lernenGelernt: 1,
      });
      console.log("Button was clicked");
    }

    function saveTextFile() {
      let result = "";
      store.state.myVocabularys.forEach((element) => {
        result += JSON.stringify(element);
        result += "\n";
      });

      var blob = new Blob([result], {
        type: "application/xhtml+xml;charset=utf-8 ",
      });
      saveAs(blob, "VocaList.txt");
    }

    function importTextFile() {
      let url = "assets/VocaList.txt";
      let array = [];
      fetch(url)
        .then((response) => response.text())
        .then((data) => {
          array = data.split("\n");
          array.forEach((element) => {
            let obj = JSON.parse(element);
            console.log(obj);
            store.state.myVocabularys.push(obj);
          });

          console.log(store.state.myVocabularys);
        });

      store.commit("addVocabularyList", array);
    }

    function saveXMLFile() {
      let result = '<?xml version="1.0" encoding="UTF-8"?>\n';
      result += "<Vocabularies>\n";
      store.state.myVocabularys.forEach((element) => {
        result += "    <Vocaular>\n";
        for (let key of Object.keys(element)) {
          result += `        <${key}>${element[key]}</${key}>\n`;
        }
        result += "    </Vocular>\n";
      });
      result += "</Vocabularies>";
      var blob = new Blob([result], {
        type: "application/xhtml+xml;charset=utf-8 ",
      });
      saveAs(blob, "result.xml");
    }

    function saveExcelFile() {
      axios
        .post(
          config.backendHost + "/excel",
          {
            file_name: fileName,
          },
          {
            responseType: "blob",
          }
        )
        .then((response) => {
          const url = URL.createObjectURL(
            new Blob([response.data], {
              type: "application/vnd.ms-excel",
            })
          );
          const link = document.createElement("a");
          link.href = url;
          link.setAttribute("download", fileName);
          document.body.appendChild(link);
          link.click();
        });
    }
    return {
      getAssignmentList,
      saveXMLFile,
      saveTextFile,
      importTextFile,
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