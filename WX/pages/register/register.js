// pages/register/register.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: "",
    password: "",
    userRoleId: "1",
    userCarId: ""
  },
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
  carIdInput: function(e){
    this.setData({
      userCarId: e.detail.value
    })
  },
  saveTopTips: function () {
 
    var that = this;
    var username = that.data.username;
    var password = that.data.password;
    var userCarId = that.data.userCarId;
    if (username=='') {
      wx.showToast({
        title: '用户名不能为空',
        icon: 'none',
      })
      return;
    }else if(password==''){
      wx.showToast({
        title: '密码不能为空',
        icon: 'none',
      })
      return;
    } else if (userCarId==''){
      wx.showToast({
        title: '车牌号不能为空',
        icon: 'none',
      })
      return;
    }
    wx.request({
      url: getApp().globalData.url +'/Parking_management/admin/save.action',
      data: {
        'username': that.data.username,
        'password': that.data.password,
        'userRoleId':'1',
        'userCarId':that.data.userCarId
      },
      success: function (res) {
        if (res.data.msg == 'OK') {
          console.log('注册成功')
          wx.showToast({
            title: '注册成功',
            icon: 'loading',
            image: '../../icons/resuccess.png',
            duration: 1000
          });
          setTimeout(function () {
            wx.navigateTo({
              url: '../login/login'
            })
          }, 1000)
         
        } else {
          wx.showToast({
            icon: 'loading',
            title: '注册失败',
            duration: 2000,
            mask: true,
            image: '../../icons/error.png'
          })
        }
      }
    })
  },
  tologinTopTips: function(){
    wx.navigateTo({
      url: '../login/login'
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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