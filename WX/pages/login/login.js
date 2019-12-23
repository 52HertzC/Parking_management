// pages/login/login.js
const APP_ID = 'wx03bd9d7af96cd522';//输入小程序appid  
const APP_SECRET = 'd474b1ddde5cfdfc923f319086f091ed';//输入小程序app_secret  
var OPEN_ID = ''//储存获取到openid  
var SESSION_KEY = ''//储存获取到session_key
Page({

  /**
   * 页面的初始数据
   */
  data: {
    openid:"",
    session_key:"",
    username: "",
    password: "",
    user:{},
    sessionId:"",
    sessionCarId:""
  },
   /**
   * e就是事件=》e.detail.value就是输入框的值
   * 调用this.setData方法 把 e.detail.value 放入data中
   * username中
   */
  nameInput: function (e) {
    this.setData({
      username: e.detail.value
    })
  },

  passInput: function (e) {
    this.setData({
      password: e.detail.value
    })
  },
  tomycenterTopTips: function (e) {
    wx.switchTab({
      url: '../mycenter/mycenter'
    })
  },
  /**从data中获取 */
  showTopTips: function () {
    // console.log("用户名"+this.data.username)
    // console.log("密码" + this.data.password)
    var that = this;
    console.log("code:"+getApp().globalData.code)
    wx.request({
      url: getApp().globalData.url +'/Parking_management/user/wxLogin.action',
      data: {
        'username': that.data.username,
        'password': that.data.password
      },
      success: function (res) {
        var datas=res.data;
        var ok=datas.substring(0,2);
        if (ok == "ok") {
          console.log(res)
          var sessionCarId = datas.substring(2, 9);
          var sessionId = datas.substring(9, datas.length);
          console.log(sessionId)
          that.setData({
            'sessionId': sessionId,
            'sessionCarId': sessionCarId
          })
          console.log('登录成功')
          wx.request({
            url: getApp().globalData.url + "/Parking_management/admin/wxlist.action",
            data: {
              'sessionId': that.data.sessionId
            },
            success: function (res) {
              that.setData({
                user: res.data
              })
            }
          })
         
          wx.request({
            url: getApp().globalData.url + '/Parking_management/wxuser/list.action',
            data: {
              'openid': OPEN_ID
            },
            success: function (res) {
              if (res.data.rows[0]!=null){
                that.setData({
                  "user": {
                    'id': res.data.rows[0].id,
                    'username': that.data.user.username,
                    'password': that.data.user.password,
                    'userRoleId': that.data.user.userRoleId,
                    'userCarId': that.data.user.userCarId,
                    'openid': getApp().globalData.openid
                  }
                })
                wx.request({
                  url: getApp().globalData.url + '/Parking_management/wxuser/edit.action',
                  data:  that.data.user ,
                  success: function (res) {
                    if(res.data.status==200){
                      getApp().globalData.sessionId=that.data.sessionId;
                      getApp().globalData.sessionCarId = that.data.sessionCarId;
                      wx.showToast({
                        title: '更改绑定成功',
                        icon: 'success',
                        duration: 1500,
                        success: function () {
                          setTimeout(function () {
                            //要延时执行的代码
                            wx.switchTab({
                              url: '../park/park',
                              success:function(e){
                                var page = getCurrentPages().pop();
                                if (page == undefined || page == null) return;
                                page.onLoad();
                              
                              }
                            })
                          }, 1500) //延迟时间
                        }
                      })
                    }else{
                      wx.showToast({
                        icon: 'loading',
                        title: '更改绑定失败',
                        duration: 2000,
                        mask: true,
                        image: '../../icons/error.png'
                      })
                    }
                  } 
                  })
                
              }else{
                that.setData({
                  "user": {
                    'username': that.data.user.username,
                    'password': that.data.user.password,
                    'userRoleId': that.data.user.userRoleId,
                    'userCarId': that.data.user.userCarId,
                    'openid': getApp().globalData.openid
                  }
                })
                wx.request({
                  url: getApp().globalData.url + '/Parking_management/wxuser/save.action',
                  data: that.data.user,
                  success: function (res) {
                    if (res.data.status == 200) {
                      wx.showToast({
                        title: '绑定成功',
                        icon: 'success',
                        duration: 1500,
                        success: function () {
                          setTimeout(function () {
                            //要延时执行的代码
                            wx.switchTab({
                              url: '../park/park',
                              success: function (e) {
                                var page = getCurrentPages().pop();
                                if (page == undefined || page == null) return;
                                page.onLoad();
                              }
                            })
                          }, 1500) //延迟时间
                        }
                      })
                    } else {
                      wx.showToast({
                        icon: 'loading',
                        title: '绑定失败',
                        duration: 2000,
                        mask: true,
                        image: '../../icons/error.png'
                      })
                    }
                  }
                })
              }
            }
          })
          wx.switchTab({
            url: '../park/park'
          })
        } else {
          wx.showToast({
            icon: 'loading',
            title: '用户名密码错误',
            duration: 2000,
            mask: true,
            image: '../../icons/error.png'
          })
        }
      }
    })
  },
  tosaveTopTips: function () {
    
    wx.navigateTo({
      url: '../register/register'
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 登录
    var that = this;
    wx.login({
      success: function (res) {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if (res.code) {
          console.log('获取用户登录态success！' + res.code)
          getApp().globalData.code = res.code
        } else {
          console.log('获取用户登录态失败！' + res.errMsg)
        }
       
        wx.request({
          //获取openid接口  
          url: 'https://api.weixin.qq.com/sns/jscode2session',
          data: {
            appid: APP_ID,
            secret: APP_SECRET,
            js_code: res.code,
            grant_type: 'authorization_code'
          },
          success: function (res) {
            console.log(res.data)
            OPEN_ID = res.data.openid;//获取到的openid  
            SESSION_KEY = res.data.session_key;//获取到session_key  
            console.log(OPEN_ID.length)
            console.log(SESSION_KEY.length)
            that.setData({
              'openid': res.data.openid.substr(0, 10) + '********' + res.data.openid.substr(res.data.openid.length - 8, res.data.openid.length),
              'session_key': res.data.session_key.substr(0, 8) + '********' + res.data.session_key.substr(res.data.session_key.length - 6, res.data.session_key.length)
            })
          }
        })
       
      }
    })
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