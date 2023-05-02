import { createWebHistory, createRouter } from "vue-router";
import List from "./components/List.vue";
import Home from "./components/Home.vue";
import Detail from "./components/Detail.vue";
import Comment from "./components/Comment.vue";
import Author from "./components/Author.vue";

const routes = [
    {
        path: "/",
        component: Home,  // import해온 컴포넌트
    },
    {
        path: "/list",
        component: List,
    },
    {
        path: "/detail/:id",
        component: Detail,
        children: [
            {
                path: "author",
                component: Author,
            },
            {
                path: "comment",
                component: Comment,
            }
        ]
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router; 