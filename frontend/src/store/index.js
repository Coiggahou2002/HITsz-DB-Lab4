import {createStore} from 'vuex';

export default createStore({
  state: {
    userId: '',
    username: '',
    foods: [],
    catTypes: [],
    characters: [],
    colors: [],
    locations: [],
  },
  mutations: {
    setUserId(state, id) {
      state.userId = id;
    },
    setUsername(state, username) {
      state.username = username;
    },
    setFoods(state, foods) {
      state.foods = foods;
    },
    setCatTypes(state, catTypes) {
      state.catTypes = catTypes;
    },
    setCharacters(state, characters) {
      state.characters = characters;
    },
    setColors(state, colors) {
      state.colors = colors;
    },
    setLocations(state, locations) {
      state.locations = locations;
    }
  }
});