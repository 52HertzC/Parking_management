// pages/park/park.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    carid:"",
    grids: [],
    userInfo:{},
    parkingRes:{},
    isInput:""
  },
  open: function() {
    var itemLists = ['A', 'B', 'C'];
    var that = this;
    wx.showActionSheet({
      itemList: itemLists,
      success: function(res) {
        if (!res.cancel) {
          wx.request({
            url: getApp().globalData.url +'/Parking_management/manage/wxlike.action?manageArea=' + itemLists[res.tapIndex],
            success: function(res) {
              //res.data就是后端返回的数据，转成了对象，可以直接遍历
              //把res.data放入data中
              console.log(res.data.rows)
              that.setData({
                grids: res.data.rows
              })
            }
          })
        }
      }

    });
  },
  openDialog: function() {
    this.setData({
      istrue: true
    })
  },
  closeDialog: function() {
    this.setData({
      istrue: false
    })
  }, 
  openDialogs: function () {
    this.setData({
      istrues: true
    })
  },
  closeDialogs: function () {
    this.setData({
      istrues: false
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    that.setData({
      'userInfo': getApp().globalData.userInfo
    })
    if (getApp().globalData.userInfo!=null){
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
        appid: getApp().globalData.APP_ID,
        secret: getApp().globalData.APP_SECRET,
        js_code: res.code,
        grant_type: 'authorization_code'
      },
      success: function (res) {
        getApp().globalData.openid = res.data.openid;//获取到的openid  
        wx.request({
          url: getApp().globalData.url + '/Parking_management/wxuser/list.action',
          data: {
            'openid': getApp().globalData.openid
          },
          success: function (res) {
            var datas = res.data.rows[0];
            if (res.data.rows[0] != null) {
              getApp().globalData.sessionCarId = datas.userCarId;
              getApp().globalData.sessionId = datas.id;
              wx.showLoading({
                title: '数据拼命加载中',
              })
          
              wx.request({
                url: getApp().globalData.url + '/Parking_management/manage/wxlike.action?manageArea=A',
                success: function (res) {
                  that.setData({
                    carid: getApp().globalData.sessionCarId,
                    grids: res.data.rows
                  })
                  wx.hideLoading()
                }
              })

              wx.request({
                url: getApp().globalData.url + '/Parking_management/user/wxLogin.action',
                data: {
                  'username': datas.username,
                  'password': datas.password
                },
                success: function (res) {
                  var datas = res.data;
                  var ok = datas.substring(0, 2);
                  if (ok == "ok") {
                    console.log(res)
                    getApp().globalData.sessionCarId = datas.substring(2, 9);
                    getApp().globalData.sessionId = datas.substring(9, datas.length);
                  } 
                }
              })
              wx.request({
                url: getApp().globalData.url + '/Parking_management/res/wxcarlist.action',
                data: {
                  'resCarId': getApp().globalData.sessionCarId
                },
                success: function (res) {
                  console.log(res)
                  that.setData({
                    parkingRes:res.data.rows[0]
                  })
                }
              })

              wx.request({
                url: getApp().globalData.url + '/Parking_management/record/dateisnull.action?',
                data: { 'recCarId': getApp().globalData.sessionCarId },
                success: function (res) {
                  console.log(res)
                  if (res.data.rows[0] != undefined) {
                    that.setData({
                      isInput: true
                    })

                  }
                }
              })
            } 
          }
        })
      }
    })
      }
    })
    }
    that.setData({
      isInput: ""
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    this.onLoad();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {
    this.onLoad();
    wx.stopPullDownRefresh() 
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})