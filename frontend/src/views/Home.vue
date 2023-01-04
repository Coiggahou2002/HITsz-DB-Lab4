<template>
  <el-header class="bg-white border-b flex items-center">
    <div class="text-2xl font-light">🐱 校园猫管理平台</div>
    <div class="flex-grow"></div>
    <div v-if="!!username" class="font-light">
      欢迎，{{ username }}
    </div>
    <div v-else>游客状态</div>
  </el-header>
  <el-container class="divide-x flex h-screen">
    <el-aside style="max-width: 150px" class="select-none">
      <el-scrollbar>
        <el-menu router active-text-color="#E6A23C">
            <el-menu-item index="1" route="/query">查询信息</el-menu-item>
            <el-menu-item index="2" route="/add">新增信息</el-menu-item>
            <el-menu-item index="3" route="/pos_checkin">猫猫打卡</el-menu-item>
            <el-menu-item index="4" route="/feed_log">投喂登记</el-menu-item>
            <el-menu-item index="5" route="/login">登录/注册</el-menu-item>
            <el-menu-item index="6" route="/about">关于</el-menu-item>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container class="p-0 bg-gray-50">
      <el-main class="p-0">
        <router-view name="main"/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'elhome',
  computed: {
    username() {
      return this.$store.state.username;
    }
  },
  data() {
    return {
      tableData: [

      ]
    }
  }
}
const item = {
  date: '2016-05-02',
  name: 'Tom',
  address: 'No. 189, Grove St, Los Angeles',
}
</script>

<style scoped>

</style>
