<template>
  <section class="sectionInput">
    <b-card class="inputCard">
      <div class="divBox">
        <div class="inputGroup">
          <!-- <text-field title="Username" />
-->
          <div class="inputField">
            <input-field placeholder="Benutzername" v-model="username" />
          </div>
          <div class="inputField">
            <input-field placeholder="email" v-model="email" />
          </div>
          <div class="inputField">
            <input-field placeholder="Passwort" v-model="password1" />
          </div>
          <div class="inputField">
            <input-field
              placeholder="Passwort bestätigen"
              v-model="password2"
            />
          </div>
        </div>
        <!--
        <b-input-group class="inputGroup">-->
      </div>

      <div class="divBox">
        <b-input-group-append>
          <Button title="Registrieren" :clickedListener="registerUser" />
        </b-input-group-append>
      </div>
      <div>
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
    let username = ref("");
    let email = ref("");
    let password1 = ref("");
    let password2 = ref("");
    store.commit("setMessage", "");

    watchEffect(() => {
      // messages.value = store.state.currentUser;
    });

    function registerUser() {
      if (password1.value == password2.value) {
        store.dispatch("registerUser", {
          username: username.value,
          email: email.value,
          password: password1.value,
        });
        console.log("Button was clicked");
      } else {
        store.commit("setMessage", "Das Passwort stimmt nicht überein!");
      }
    }

    return {
      registerUser,
      username,
      email,
      password1,
      password2,
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
</style>