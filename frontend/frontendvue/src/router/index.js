import { createWebHistory, createRouter } from "vue-router";
import Home from "@/screens/Home";
import Register from "@/screens/Register";
import Login from "@/screens/Login";
import Translate from "@/screens/Translate";
import AboutVue from "../screens/About.vue";

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
    path: "/about",
    name: "About",
    component: AboutVue,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
