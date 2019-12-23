// pages/parklogs/parkrecord/parkrecord.js
var util = require('../../../utils/util.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    indatetime: "",
    datetime: "",
    parkingRecord:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({

      url: getApp().globalData.url +'/Parking_management/record/recId.action',
      data: {
        'recId': options.recId
      },
      success: function (res) {
        console.log(res)
        var timestamp = res.data.recEntryDate;
        var timestamps = res.data.recLeaveDate;
        var indatetime = util.formatTimeTwo(timestamp, 'Y-M-D h:m:s');
        var datetime = util.formatTimeTwo(timestamps, 'Y-M-D h:m:s');
        that.setData({
          datetime: datetime,
          indatetime: indatetime,
          parkingRecord: res.data
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