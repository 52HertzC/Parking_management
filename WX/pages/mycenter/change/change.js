// pages/mycenter/change/change.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user: [],
    passwordOld: "",
    passwordNew: "",
    passwordNewTwo: ""
  },
  passwordInputOld: function(e) {
    this.setData({
      passwordOld: e.detail.value
    })
  },
  passwordInputNew: function(e) {
    this.setData({
      passwordNew: e.detail.value
    })
  },
  passwordInputNewTwo: function(e) {
    this.setData({
      passwordNewTwo: e.detail.value
    })
  },
  showTopTipss: function() {
    var sessionId = getApp().globalData.sessionId;
    var that = this;
    wx.request({
      url: getApp().globalData.url +'/Parking_management/admin/wxlist.action?sessionId=' + sessionId,
      success: function(res) {
        that.setData({
          user: res.data
        })
        if (res.data.password == that.data.passwordOld) {

          if (that.data.passwordNew != '' || that.data.passwordNewTwo != '') {
            if (that.data.passwordNew == that.data.passwordNewTwo) {
              wx.request({
                url: getApp().globalData.url +'/Parking_management/admin/edit.action',
                data: {
                  'username': that.data.user.username,
                  'password': that.data.passwordNewTwo,
                  'userRoleId': that.data.user.userRoleId,
                  'userCarId': that.data.user.userCarId,
                  'userId': sessionId
                },
                success: function(res) {
                  console.log(res)
                  if (res.data.status == 200) {
                    wx.showToast({
                      title: '修改成功',
                      icon: 'success',
                      duration: 1500,
                      success: function() {
                        setTimeout(function() {
                          //要延时执行的代码
                          wx.switchTab({
                            url: '../../mycenter/mycenter'
                          })
                        }, 1500) //延迟时间
                      }
                    })
                  } else {
                    wx.showToast({
                      icon: 'loading',
                      title: '修改失败',
                      duration: 2000,
                      mask: true,
                      image: '../../../icons/error.png'
                    })
                  }

                }
              })
            } else {
              wx.showToast({
                icon: 'loading',
                title: '两次新密码不同',
                duration: 2000,
                mask: true,
                image: '../../../icons/error.png'
              })
            }
          } else {
            wx.showToast({
              icon: 'loading',
              title: '新密码不能为空',
              duration: 2000,
              mask: true,
              image: '../../../icons/error.png'
            })
          }

        } else {
          wx.showToast({
            icon: 'loading',
            title: '密码错误',
            duration: 2000,
            mask: true,
            image: '../../../icons/error.png'
          })
        }
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

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