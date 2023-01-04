
<template>
 <div>
    <div class=" mb-8 text-xl">🌍 猫猫打卡</div>
     <el-form :model="form" label-width="60px" style="max-width: 600px">
        <el-form-item label="猫">
          <el-select v-model="form.catId" placeholder="选择要打卡的猫">
            <el-option v-for="cat in cats" :key="cat.id" :label="cat.name"
            :value="cat.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="位置">
          <el-select v-model="form.locationId" placeholder="输入要打卡的位置">
            <el-option v-for="location in locations" :key="location.id" :label="location.name"
                       :value="location.id"/>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="warning" @click="onSubmit">打卡</el-button>
        </el-form-item>
      </el-form>
  </div> 
</template>

<script>
import ResponseExtractor from "@/utils/response.js";
import {check, listAllCats} from "@/api/myapi.js";

export default {
  name: 'PosCheck',
  created() {
    listAllCats().then(res => {
      const data = ResponseExtractor.data(res)
      this.cats = data;
    })
  },
  computed: {
    locations() {
      return this.$store.state.locations;
    }
  },
  methods: {
    async onSubmit() {
      await check({
        ...this.form,
        time: Date.now().toString()});
    }
  },
  data() {
    return {
      cats: [],
      form: {
        catId: "",
        locationId: '',
      },
    }
  }
}
</script>