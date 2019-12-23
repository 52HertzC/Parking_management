//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
    // 获取用户信息
    // wx.getSetting({
    //   success: res => {
    //     if (res.authSetting['scope.userInfo']) {
    //       // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
    //       wx.getUserInfo({
    //         lang: 'zh_CN',
    //         success: res => {
    //           // 可以将 res 发送给后台解码出 unionId
    //           this.globalData.userInfo = res.userInfo

    //           // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
    //           // 所以此处加入 callback 以防止这种情况
    //           if (this.userInfoReadyCallback) {
    //             this.userInfoReadyCallback(res)
    //           }
    //         }
    //       })
    //     }
    //   }
    // })
  },
  globalData: {
    APP_ID : 'wx03bd9d7af96cd522',//输入小程序appid  
    APP_SECRET : 'd474b1ddde5cfdfc923f319086f091ed',//输入小程序app_secret  
    userInfo: null,
    openid:"",
    code:"",
    urlsss: 'http://192.168.43.186:8888',//手机热点IP
    urlss: 'http://192.168.3.8:8888',//寝室IP
    url: 'http://49.234.7.23:8080',//云服务器
    urls:'http://localhost:8888',
    sessionId:'',
    sessionCarId:'',
    isInput: false,  //判断是否停车
    timer:''
  }
})