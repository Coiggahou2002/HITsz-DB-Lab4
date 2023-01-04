// 项目入口文件 main.js


import { createApp } from 'vue'

import App from './App.vue'

import router from '@/router'
import store from '@/store'

import ElementPlus from 'element-plus'

import "./styles/main.scss"
import "element-plus/dist/index.css"


const app = createApp(App);

app.use(store);
app.use(router);
app.use(ElementPlus);



app.mount('#app');
