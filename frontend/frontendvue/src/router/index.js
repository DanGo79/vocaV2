import { createWebHistory, createRouter } from "vue-router";
import Home from "@/screens/Home";
import Register from "@/screens/Register";
import Login from "@/screens/Login";
import Translate from "@/screens/Translate";
import AboutVue from "../screens/About.vue";
import MyVocabularyVue from "../screens/MyVocabulary.vue";
import PuzzleVue from "../screens/Puzzle.vue";
import Translations from "../screens/Translations.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/register",
    name: "Register",
    component: Register,
  },
  {
    path: "/translate",
    name: "Translate",
    component: Translate,
  },
  {
    path: "/translations",
    name: "Translations",
    component: Translations,
  },

  {
    path: "/about",
    name: "About",
    component: AboutVue,
  },
  {
    path: "/myVocabulary",
    name: "MyVocabulary",
    component: MyVocabularyVue,
  },
  {
    path: "/puzzle",
    name: "Puzzle",
    component: PuzzleVue,
    props: true,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
