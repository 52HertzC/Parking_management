// pages/mycenter/mycenter.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:{},
    user:[],
    grids:[],
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  showTopTips: function () {
    wx.navigateTo({
      url: '../login/login',
    })
  },
  bindViewTap: function () {
    wx.navigateTo({
      url: '../mycenter/wxmycenter/wxmycenter'
    })
  },
  openDialog: function () {
    this.setData({
      istrue: true
    })
  },
  closeDialog: function () {
    this.setData({
      istrue: false
    })
  },
  getUserInfo: function (e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
    wx.reLaunch({
      url: '../park/park',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            lang: 'zh_CN',
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              app.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        lang: 'zh_CN',
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })

    }
    
    var sessionId = getApp().globalData.sessionId;
    var sessionCarId = getApp().globalData.sessionCarId;
    var that = this;
    wx.request({
      url: getApp().globalData.url +"/Parking_management/admin/wxlist.action?sessionId="+sessionId,
      success: function (res) {
        console.log(res)
        that.setData({
          user: res.data
        })
      　　}
    })
    if (sessionCarId != null || sessionCarId !=""){
      wx.request({
        url: getApp().globalData.url +'/Parking_management/manage/wxcarlist.action?',
        data: { 'manageCarId': getApp().globalData.sessionCarId},
        success: function (res) {
          //res.data就是后端返回的数据，转成了对象，可以直接遍历
          //把res.data放入data中 
          console.log(res.data.rows[0])
          if (res.data.rows[0]!=undefined){
            that.setData({
              grids: res.data.rows[0],
              userInfo: getApp().globalData.userInfo
            })
          }else{
            that.setData({
              grids: [],
              userInfo: getApp().globalData.userInfo
            })
          }
         
        
        }
      })
    }
    
  
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.onLoad();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    this.onLoad();
    wx.stopPullDownRefresh() 
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})