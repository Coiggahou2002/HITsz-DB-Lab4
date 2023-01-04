<template>
  <el-table :data="tableData">
    <el-table-column label="身份证" width="200">
      <template #default="scope">
        {{ scope.row.id }}
      </template>
    </el-table-column>
    <el-table-column label="昵称" width="120">
      <template #default="scope">
        {{ scope.row.name }}
      </template>
    </el-table-column>
    <el-table-column label="品种" width="120">
      <template #default="scope">
        {{ scope.row.type.name }}
      </template>
    </el-table-column>
    <el-table-column label="颜色" width="120">
      <template #default="scope">
        {{ scope.row.color.name }}
      </template>
    </el-table-column>
    <el-table-column label="性格" width="120">
      <template #default="scope">
        {{ scope.row.character.name }}
      </template>
    </el-table-column>
    <el-table-column label="经常出没在" width="120">
      <template #default="scope">
        {{ scope.row.aroundLocation.name }}
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button size="small" @click="openEditDialog(scope.$index, scope.row)"
        >编辑
        </el-button
        >
        <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
        >删除
        </el-button
        >
      </template>
    </el-table-column>
  </el-table>


  <el-dialog
      v-model="showEditDialog"
      title="编辑猫信息"
      width="40%"
      align-center
  >
    <el-form :model="editForm" label-width="120px" style="max-width: 600px">
      <el-form-item label="昵称">
        <el-input v-model="editForm.name" placeholder="比如猫爷..."/>
      </el-form-item>
      <el-form-item label="品种">
        <el-select v-model="editForm.typeId" placeholder="选择猫的品种">
          <el-option v-for="type in catTypes" :key="type.name" :label="type.name"
                     :value="type.id"/>
        </el-select>
      </el-form-item>
      <el-form-item label="颜色">
        <el-select v-model="editForm.colorId" placeholder="黑猫白猫都是好猫~">
          <el-option v-for="color in catColors" :key="color.name" :label="color.name"
                     :value="color.id"/>
        </el-select>
      </el-form-item>
      <el-form-item label="性格">
        <el-select v-model="editForm.characterId" placeholder="你的猫喜欢发脾气不?">
          <el-option v-for="character in catCharacters" :key="character.name" :label="character.name"
                     :value="character.id"/>
        </el-select>
      </el-form-item>
      <el-form-item label="常出没的位置">
        <el-select v-model="editForm.aroundLocationId" placeholder="选择打卡地点">
          <el-option v-for="location in aroundLocations" :key="location.name" :label="location.name"
                     :value="location.id"/>
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="showEditDialog = false">取消</el-button>
        <el-button type="primary" @click="confirmEdit">
          确认
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>
<script>
import {listAllCats, removeCatById, updateCat} from '../api/myapi'
import ResponseExtractor from '../utils/response'

export default {
  name: "Query",
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
  mounted() {
    listAllCats().then(resp => {
      this.tableData = ResponseExtractor.data(resp)
    })
  },
  methods: {
    async confirmEdit() {
      await updateCat({
        ...this.editForm,
      });
      const resp = await listAllCats();
      this.tableData = ResponseExtractor.data(resp)
      this.showEditDialog = false;
    },
    openEditDialog(index, row) {
      let {name, type, id, color, character, aroundLocation} = row;
      this.editForm.id = id;
      this.editForm.name = name;
      this.editForm.typeId = type.id;
      this.editForm.colorId = color.id;
      this.editForm.characterId = character.id;
      this.editForm.aroundLocationId = aroundLocation.id;
      this.showEditDialog = true;
    },
    async handleDelete(index, row) {
      await removeCatById(row.id);
      const resp = await listAllCats()
      this.tableData = ResponseExtractor.data(resp)
    }
  },
  data() {
    return {
      showEditDialog: false,
      editForm: {
        id: "",
        name: "",
        typeId: "",
        colorId: "",
        characterId: "",
        aroundLocationId: ""
      },
      tableData: [],
    };
  },
};
</script>

<style scoped></style>
