<template>
  <div>
    <div class=" mb-8 text-xl">📌 投喂登记</div>
    <el-form :model="form" label-width="120px" style="max-width: 600px">
      <el-form-item label="猫">
        <el-select v-model="form.catId" placeholder="选择要打卡的猫">
          <el-option
              v-for="cat in cats"
              :key="cat.id"
              :label="cat.name"
              :value="cat.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="投喂食物">
        <el-select v-model="form.locationId" placeholder="选择位置">
          <el-option
              v-for="location in locations"
              :key="location.id"
              :label="location.name"
              :value="location.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="投喂食物">
        <el-select v-model="form.foodId" placeholder="选择要打卡的猫">
          <el-option
              v-for="food in foods"
              :key="food.id"
              :label="food.name"
              :value="food.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="warning" @click="onSubmit">登记</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {feed, listAllCats} from "@/api/myapi.js";
import ResponseExtractor from "@/utils/response.js";
import {ElMessage} from "element-plus";

export default {
  name: "FeedLog",
  created() {
    listAllCats().then(res => {
      this.cats = ResponseExtractor.data(res);
    })
  },
  computed: {
    locations() {
      return this.$store.state.locations;
    },
    foods() {
      return this.$store.state.foods;
    },
  },
  methods: {
    async onSubmit() {
      const userId = this.$store.state.userId;
      console.log('userId', userId)
      if (!userId) {
        ElMessage({
          message: '需要登录才能进行此操作',
          type: 'error',
          duration: 1000,
        })
        return;
      }
      await feed({
        ...this.form,
        time: Date.now().toString(),
        userId,
      });
    }
  },
  data() {
    return {
      cats: [],
      form: {
        catId: '',
        foodId: '',
        locationId: '',
      },
    }
  },
};
</script>
