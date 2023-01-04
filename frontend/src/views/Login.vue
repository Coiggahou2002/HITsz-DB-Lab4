<template>
  <section class="h-full flex justify-center items-center">
    <div class="bg-white shadow-lg rounded-lg">
      <!-- <section class="flex border-b">
        <div class="basis-1/2 p-3 text-center  hover:bg-indigo-50 hover:text-slate-600 hover:cursor-pointer" @click="toLoginTab" :class="">Login</div>
        <div class="basis-1/2 p-3 text-center hover:bg-indigo-50 hover:text-slate-600 hover:cursor-pointer" @click="toRegisterTab">Register</div>
      </section>
      <section class="p-4">
        <input placeholder="hhh"/>
      </section> -->
      <el-tabs type="border-card">
        <el-tab-pane label="登录">
          <div class="flex flex-col gap-y-4">
            <el-input v-model="username" placeholder="用户名"/>
            <el-input v-model="password" type="password" placeholder="密码"/>
            <el-button type="primary" @click="doLogin">登录</el-button>
          </div>
        </el-tab-pane>
        <el-tab-pane label="注册">
          <div class="flex flex-col gap-y-4">
            <el-input v-model="username" placeholder="用户名"/>
            <el-input v-model="password" type="password" placeholder="密码"/>
            <el-button type="warning" @click="doRegister">注册</el-button>
          </div>
        </el-tab-pane>
      </el-tabs>
    </div>
  </section>
</template>
<script>
import {login, register} from "@/api/myapi.js"
import ResponseExtractor from "@/utils/response.js";

export default {
  name: "Crud",
  methods: {
    async doLogin() {
      const username = this.username;
      const resp = await login({
        username: this.username,
        password: this.password
      });
      const code = ResponseExtractor.code(resp)
      this.userId = ResponseExtractor.data(resp);
      if (code == 10000) {
        this.$store.commit('setUsername', this.username);
        this.$store.commit('setUserId', this.userId);
      }
    },
    async doRegister() {
      const resp = await register({
        username: this.username,
        password: this.password
      });
    }
  },
  data() {
    return {
      userId: '',
      username: "",
      password: "",
    };
  },
};
</script>

<style scoped lang="scss">
.tab-item {
  user-select: none;
  cursor: pointer;

  &:hover {
    background-color: var(--indigo400);
    color: #fff;
  }

  &.active {
    background-color: var(--primary);
  }
}
</style>
