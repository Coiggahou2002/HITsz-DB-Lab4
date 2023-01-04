import axios from "./axios"

/**
 * 以下 API 与后端仓库 AppController 的 API 一一对应 
 */

export const login = ({username, password}) => {
    return axios({
        method: 'post',
        url: '/user_login',
        data: {
            username,
            password
        }
    })
}
export const register = ({username, password}) => {
    return axios({
        method: 'post',
        url: '/user_register',
        data: {
            username,
            password,
        }
    })
}
export const listAllCats = () => {
    return axios({
        method: 'get',
        url: '/list_all_cats',
    })
}

export const updateCat = (cat) => {
    return axios({
        method: 'post',
        url: '/update_cat',
        data: {
            ...cat
        }
    })
}

export const addCat = (cat) => {
    return axios({
        method: 'post',
        url: '/add_cat',
        data: {
            ...cat
        }
    })
}

export const removeCatById = (id) => {
    return axios({
        method: 'post',
        url: '/remove_cat_by_id',
        params: {
            id
        }
    })
}
export const getCatById = (id) => {
    return axios({
        method: 'get',
        url: '/get_cat_by_id',
        params: {
            id
        }
    })
}

export const listAllColors = () => {
    return axios({
        method: 'get',
        url: '/list_all_colors',
    })
}

export const listAllCharacters = () => {
    return axios({
        method: 'get',
        url: '/list_all_characters',
    })
}

export const listAllCatTypes = () => {
    return axios({
        method: 'get',
        url: '/list_all_cat_types',
    })
}

export const listAllLocations = () => {
    return axios({
        method: 'get',
        url: '/list_all_locations',
    })
}

export const listAllFoods = () => {
    return axios({
        method: 'get',
        url: '/list_all_foods',
    })
}

export const check = ({catId, time, locationId}) => {
    return axios({
        method: 'post',
        url: '/check',
        data: {
            catId,
            time,
            locationId
        }
    })
}

export const listAllCheckRecords = () => {
    return axios({
        method: 'get',
        url: '/list_all_check_records',
    })
}

export const feed = ({userId, time, locationId, catId, foodId}) => {
    return axios({
        method: 'post',
        url: '/feed',
        data: {
            userId, time, locationId, catId, foodId
        }
    })
}

export const listAllFeedRecords = () => {
    return axios({
        method: 'get',
        url: '/list_all_feed_records',
    })
}
