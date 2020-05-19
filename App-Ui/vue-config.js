module.exports = {
  devServer: {
    proxy: 'http://localhost:8081',
    changeOrigin: true
  }
}
