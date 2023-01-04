import axios from "axios";
import {ElMessage} from 'element-plus';

const instance = axios.create({
  baseURL: 'http://localhost:9000',
  timeout: 30000,
})

/**
 * 网络请求拦截器配置
 * 所有请求发出前, 都会经过这个拦截器方法处理
 */
instance.interceptors.request.use(function (config) {
  return config;
}, function (error) {
  return Promise.reject(error);
});

/**
 * 网络响应拦截器配置
 * 所有响应到达前, 都会经过这个拦截器方法处理
 */
instance.interceptors.response.use(function (response) {
  // 2xx 范围内的状态码都会触发该函数。
  const { code, msg } = response.data;
  if (code != 10000) {
    ElMessage({
      message: msg,
      type: 'error',
      duration: 1000,
    });
  }
  else {
    ElMessage({
      message: '操作成功',
      type: 'success',
      duration: 1000,
    });
  }
  return response;
}, function (error) {
  // 超出 2xx 范围的状态码都会触发该函数。
  ElMessage({
    message: '网络请求错误',
    type: 'error',
    duration: 1000,
  });
  return Promise.reject(error);
});
export default instance