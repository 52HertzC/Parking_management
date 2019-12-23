// pages/mycenter/vip/vip.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    carStaId:"",
    carName:"",
    carSite:"",
    carPhone:"",
    sessionCarId: "",
    grids: [],
    userInfo: {},
    parkingOwner: {},
    parkingOwners: {},
    isParkingOwner: false
  },
  successTwo: function(e) { //身份证正面识别
    console.log(e.detail)
    console.log(e.detail.name)
    console.log(e.detail.name.text)
    this.setData({
      carName: e.detail.name.text,
      carSite: e.detail.address.text,
      carStaId: e.detail.id.text,
      parkingOwners: {
        'carName': e.detail.name.text,
        'carSite': e.detail.address.text,
        'carStaId': e.detail.id.text
      }
    })
  },
  idCard: function(e) { //身份证号
    console.log(e.detail.value)
    var that=this;
    this.setData({
        'carId': that.data.sessionCarId,
        'carStaId': e.detail.value
    })
  },
  carName: function(e) { //姓名
    console.log(e.detail.value)
    this.setData({
        'carName': e.detail.value
    })
  },
  carSite: function(e) { //地址
    console.log(e.detail.value)
    this.setData({
        'carSite': e.detail.value
    })
  },
  carPhone: function(e) { //联系电话
    console.log(e.detail.value)
    this.setData({
        'carPhone': e.detail.value
    })
  },
  showTopTips: function() { //确定
    var that = this;
    that.setData({
      parkingOwners:{
        'carId': that.data.sessionCarId,
        'carStaId': that.data.carStaId,
        'carName': that.data.carName,
        'carSite': that.data.carSite,
        'carPhone': that.data.carPhone
      }
    })
    wx.request({
      url: getApp().globalData.url + '/Parking_management/owner/save.action',
      data: that.data.parkingOwners,
      success: function(res) {
        console.log(res)
        if (res.data.status == 200) {
          wx.showToast({
            title: '绑定成功',
            icon: 'success',
            duration: 1500,
            success: function() {
              setTimeout(function() {
                //要延时执行的代码
                wx.switchTab({
                  url: '../mycenter',
                  success: function() {
                    var page = getCurrentPages().pop();
                    if (page == undefined || page == null) return;
                    page.onLoad(); //重新刷新页面
                  }
                })
              }, 1500) //延迟时间
            }
          })
        }else{
          wx.showToast({
            icon: 'loading',
            title: '绑定失败',
            duration: 2000,
            mask: true,
            image: '../../../icons/error.png'
          })
        }
      }
    })

  },
  showTopTipss: function () { //跳转修改信息页面
    wx.navigateTo({
      url: '../vip/update/update',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    that.setData({
      sessionCarId: getApp().globalData.sessionCarId,
      userInfo: getApp().globalData.userInfo
    })
    var sessionCarId = getApp().globalData.sessionCarId;
    if (sessionCarId != '' || sessionCarId != null | sessionCarId != undefined) {
      wx.request({
        url: getApp().globalData.url + '/Parking_management/owner/wxlist.action',
        data: {
          'carId': getApp().globalData.sessionCarId
        },
        success: function(res) {
          console.log(res.data.rows[0])
          if (res.data.rows[0] == undefined) {
            that.setData({
              parkingOwner: {},
              isParkingOwner: true
            })
          } else {
            that.setData({
              parkingOwner: res.data.rows[0]
            })
          }
        }
      })
    }

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