<script>
import {
  listAllCats,
  listAllCatTypes,
  listAllCharacters,
  listAllFoods,
  listAllLocations,
  listAllCheckRecords,
  listAllColors,
  listAllFeedRecords
} from "@/api/myapi"
import ResponseExtractor from "@/utils/response.js";

export default {
  name: "App",
  created() {
    Promise.all([
      listAllCatTypes(),
      listAllCharacters(),
      listAllColors(),
      listAllFoods(),
      listAllLocations(),
    ]).then(values => {
      const datas = values.map(i => ResponseExtractor.data(i));
      console.log('datas', datas)
      const [
          catTypes,
          characters,
          colors,
          foods,
          locations,
      ] = datas;
      this.$store.commit("setCatTypes", catTypes)
      this.$store.commit("setFoods", foods)
      this.$store.commit("setCharacters", characters)
      this.$store.commit("setColors", colors)
      this.$store.commit("setLocations", locations)
    })
  }
}
</script>

<template>
  <div>
    <router-view/>
  </div>
</template>

<style scoped>
</style>
