// 脚手架配置文件

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      // 目录别名配置，'@'代表'src'目录
      '@': path.resolve(__dirname, './src')
    }
  }
})
