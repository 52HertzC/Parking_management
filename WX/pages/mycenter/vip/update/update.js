// pages/mycenter/vip/update/update.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
   
    sessionCarId: "",
    parkingOwners: {}
  },
  idCard: function (e) { //身份证号
    console.log(e.detail.value)
    var that = this;
    that.setData({
      parkingOwners:{
        'ownId': that.data.parkingOwners.ownId,
        'carId': that.data.parkingOwners.carId,
        'carStaId': e.detail.value,
        'carName': that.data.parkingOwners.carName,
        'carSite': that.data.parkingOwners.carSite,
        'carPhone': that.data.parkingOwners.carPhone,
        'carMoney': that.data.parkingOwners.carMoney
      }
      
    })
  },
  carName: function (e) { //姓名
    console.log(e.detail.value)
    var that = this;
    that.setData({
      parkingOwners: {
        'ownId': that.data.parkingOwners.ownId,
        'carId': that.data.parkingOwners.carId,
        'carStaId': that.data.parkingOwners.carStaId,
        'carName': e.detail.value,
        'carSite': that.data.parkingOwners.carSite,
        'carPhone': that.data.parkingOwners.carPhone,
        'carMoney': that.data.parkingOwners.carMoney
      }
      
    })
  },
  carSite: function (e) { //地址
    console.log(e.detail.value)
    var that = this;
    that.setData({
      parkingOwners: {
        'ownId': that.data.parkingOwners.ownId,
         'carId': that.data.parkingOwners.carId,
        'carStaId': that.data.parkingOwners.carStaId,
        'carName': that.data.parkingOwners.carName,
        'carSite': e.detail.value,
        'carPhone': that.data.parkingOwners.carPhone,
        'carMoney': that.data.parkingOwners.carMoney
      }
     
    })
  },
  carPhone: function (e) { //联系电话
    console.log(e.detail.value)
    var that = this;
   
    that.setData({
      parkingOwners: {
        'ownId': that.data.parkingOwners.ownId,
        'carId': that.data.parkingOwners.carId,
        'carStaId': that.data.parkingOwners.carStaId,
        'carName': that.data.parkingOwners.carName,
        'carSite': that.data.parkingOwners.carSite,
        'carPhone': e.detail.value,
        'carMoney': that.data.parkingOwners.carMoney
      }
      
    })
  
  },
  showTopTips: function(){
    var that=this;
    
    wx.request({
      url: getApp().globalData.url + '/Parking_management/owner/edit.action',
      data: that.data.parkingOwners,
      success: function (res) {
        console.log(res)
        if (res.data.status == 200) {
          wx.showToast({
            title: '修改成功',
            icon: 'success',
            duration: 1500,
            success: function () {
              setTimeout(function () {
                //要延时执行的代码
                wx.reLaunch({
                  url: '../vip'  
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
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
var that = this;
that.setData({
  sessionCarId: getApp().globalData.sessionCarId
})
    wx.request({
      url: getApp().globalData.url + '/Parking_management/owner/wxlist.action',
      data: {
        'carId': that.data.sessionCarId
      },
      success: function (res) {
        console.log(res.data.rows[0])
          that.setData({
            parkingOwners: res.data.rows[0]
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