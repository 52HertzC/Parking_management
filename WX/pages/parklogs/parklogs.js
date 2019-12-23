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
    inputVal: "",
    isInput:false,
    record:{},
    datetime:"",
    nowdatetime:"",
    recCost:"",
    timer:""
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
  startReportHeart:function() {
    var that = this;
    var timerTem = setTimeout(function () {  //要延时执行的代码
      that.startReportHeart()
      var newdate = new Date();
      var nowdatetime = util.formatTimeTwo(newdate, 'Y-M-D h:m:s');
      var datetime = that.data.datetime;
      var recTime = util.formatTimeDate(nowdatetime, datetime);
      var recCost = recTime * 2;
      that.setData({
        nowdatetime: nowdatetime,
        recCost: recCost
      })
    }, 1000)
    // 保存定时器name
    getApp().globalData.timer= timerTem  
  },
 
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    
    var that=this;
    that.setData({
      isInput: getApp().globalData.isInput
    })
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

    wx.request({
      url: getApp().globalData.url + '/Parking_management/record/dateisnull.action?',
      data: { 'recCarId': getApp().globalData.sessionCarId },
      success: function (res) {
        console.log(res)
        if (res.data.rows[0] != undefined) {
          var timestamp = res.data.rows[0].recEntryDate;
          var indate = util.formatTimeTwo(timestamp, 'Y-M-D');
          var intime = util.formatTimeTwo(timestamp, 'h:m:s');
          var datetime = indate + " " + intime;
          that.setData({
            record: res.data.rows[0],
            datetime: datetime,
            isInput:true
          })
          
        }
      }
    })
    that.startReportHeart();
   
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