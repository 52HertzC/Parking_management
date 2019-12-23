// pages/parklogs/parklogs.js
var util = require('../../utils/util.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    indatetime:[],
    parkingRecord: [{ recEntryDate:""}],
    inputShowed: false,
    inputVal: ""
  },
  showInput: function () {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },
  inputTyping: function (e) {
    console.log(e.detail.value)
    this.setData({
      inputVal: e.detail.value
    });
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that=this;
    wx.request({

      url: getApp().globalData.url+'/Parking_management/record/carlist.action',
      data: {
        'recCarId': getApp().globalData.sessionCarId
      },
      success: function(res) {
        console.log(res)
         
        that.setData({
          parkingRecord: res.data.rows,
        })
        for (var i = 0; i < res.data.rows.length; i++) {
          var parkingRecord = that.data.parkingRecord;
          var timestamp = res.data.rows[i].recEntryDate;
          var indatetime = util.formatTimeTwo(timestamp, 'Y-M-D h:m:s');
          parkingRecord[i].recEntryDate = indatetime;
          that.setData({
            parkingRecord: parkingRecord
          })
        }
        
      }
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