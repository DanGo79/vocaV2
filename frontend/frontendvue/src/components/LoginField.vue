<template>
  <section class="sectionInput">
    <b-card class="inputCard">
      <div class="divBox">
        <div class="inputGroup">
          <div class="inputField">
            <input-field
              placeholder="Benutzername oder email"
              v-model="usernameEmail"
            />
          </div>
          <div class="inputField">
            <input-field placeholder="Passwort" v-model="password1" />
          </div>
        </div>
      </div>

      <div class="divButtons">
        <b-input-group-append>
          <div style="margin-right: 10px">
            <Button title="Login" :clickedListener="login" />
          </div>
          <div style="margin-left: 10px">
            <Button to="/register" title="Register" />
          </div>
        </b-input-group-append>
      </div>
      <div style="margin-top: 25px">
        <MessageText />
      </div>
    </b-card>
  </section>
</template>

<script>
import { ref, watchEffect } from "vue";
import { useStore } from "vuex";
import Button from "./Button.vue";
import InputField from "./InputField";
import MessageText from "./MessageText.vue";

export default {
  components: { InputField, Button, MessageText },

  name: "Register",
  props: {},
  setup() {
    const store = useStore();
    let usernameEmail = ref("");
    let password1 = ref("");
    store.commit("setMessage", "");

    watchEffect(() => {
      // messages.value = store.state.currentUser;
    });

    function login() {
      store.dispatch("login", {
        username: usernameEmail.value,
        password: password1.value,
      });
      console.log("Button was clicked");
    }

    return {
      login,
      usernameEmail,
      password1,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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