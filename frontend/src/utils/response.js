/**
 * 封装从响应包中取出数据的基本方法
 */
const ResponseExtractor = {
  data: (resp) => resp && resp.data && resp.data.data,
  code: (resp) => resp && resp.data && resp.data.code,
}

export default ResponseExtractor;