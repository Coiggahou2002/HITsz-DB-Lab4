<template>
  <section class="select-none">
    <div class=" mb-8 text-xl">🐱 新猫建档</div>
    <section>
     <el-form :model="form" label-width="120px" style="max-width: 600px">
        <el-form-item label="昵称">
          <el-input v-model="form.name" placeholder="比如猫爷..." />
        </el-form-item>
        <el-form-item label="品种">
          <el-select v-model="form.typeId" placeholder="选择猫的品种">
            <el-option v-for="type in catTypes" :key="type.name" :label="type.name"
            :value="type.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="颜色">
          <el-select v-model="form.colorId" placeholder="黑猫白猫都是好猫~">
            <el-option v-for="color in catColors" :key="color.name" :label="color.name"
            :value="color.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="性格">
          <el-select v-model="form.characterId" placeholder="你的猫喜欢发脾气不?">
            <el-option v-for="character in catCharacters" :key="character.name" :label="character.name"
            :value="character.id"/>
          </el-select>
        </el-form-item>
        <el-form-item label="常出没的位置">
          <el-select v-model="form.aroundLocationId" placeholder="选择打卡地点">
            <el-option v-for="location in aroundLocations" :key="location.name" :label="location.name"
                       :value="location.id"/>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="warning" @click="onSubmit">完成建档</el-button>
        </el-form-item>
      </el-form>
    </section>
  </section>
</template>

<script>
import {addCat} from "@/api/myapi.js";

export default {
  name: "AddInfo",
  computed: {
    catTypes() {
      return this.$store.state.catTypes;
    },
    catColors() {
      return this.$store.state.colors;
    },
    catCharacters() {
      return this.$store.state.characters;
    },
    aroundLocations() {
      return this.$store.state.locations;
    },
  },
  methods: {
    async onSubmit() {
      await addCat({...this.form})
    }
  },
  data() {
    return {
      name: "Coiggahou2002",
      form: {
        name: "",
        colorId: "",
        characterId: '',
        aroundLocationId: '',
        typeId: '',
      },
    };
  },
};
</script>
