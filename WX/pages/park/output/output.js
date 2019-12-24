// pages/park/output/output.js
var util = require('../../../utils/util.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    indate:"2016-09-01",
    intime:"12:01",
    date: "2016-09-01",
    time: "12:01",
    manageStaId:"",
    id:"",
    recTime:"",
    recCharge:"2",
    recCost:"",
    manage:{},
    record:{},
    systemInfo:{}
  },
  sys: function () {//判断系统
    var that = this;
    wx.getSystemInfo({
      success: function (res) {
        console.log(res)
        that.setData({
          systemInfo: res,
        })
       
      }
    })
  },
  showTopTips: function(){
    var that = this;
    that.setData({
      record: {
        'recId': that.data.record.recId,
        'recCarId': that.data.record.recCarId,
        'recEntryDate': that.data.indate + ' ' + that.data.intime,
        'recLeaveDate': that.data.date + ' ' + that.data.time,
        'recTime': that.data.recTime,
        'recCharge': that.data.recCharge,
        'recCost': that.data.recCost
      },
      manage: {
        'manageStaId': that.data.manageStaId,
        'id': that.data.id,
        'manageCarId':''
      }
    })
    wx.request({
      url: getApp().globalData.url + '/Parking_management/record/edit.action?',
      data: that.data.record,
      success: function (res) {
        console.log(res)
        if (res.data.status == 200) {
          wx.request({
            url: getApp().globalData.url + '/Parking_management/manage/edit.action?',
            data: that.data.manage,
            success: function (res) {
              //res.data就是后端返回的数据，转成了对象，可以直接遍历
              //把res.data放入data中
              if (res.data.status == 200) {
                getApp().globalData.isInput=false;
                wx.showToast({
                  title: '缴费成功',
                  icon: 'success',
                  duration: 1500,
                  success: function () {
                    setTimeout(function () {
                      //要延时执行的代码
                      wx.switchTab({
                        url: '../park',
                        success: function () {
                          var page = getCurrentPages().pop();
                          if (page == undefined || page == null) return;
                          page.onLoad(); //重新刷新页面
                        }
                      })
                    }, 1500) //延迟时间
                  }
                })
              } else {
                wx.showToast({
                  icon: 'loading',
                  title: '缴费失败',
                  duration: 2000,
                  mask: true,
                  image: '../../../icons/error.png'
                })
              }
            }
          })

        }

      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (this.data.systemInfo.platform == "ios") {
      var time = util.formatTimeNow(new Date());
      var date = util.formatDate(new Date());
      date = Date.parse(date.replace(/-/g, "/"));
    } else{
      var time = util.formatTimeNow(new Date());
      var date = util.formatDate(new Date());
    }
    
    var that=this;
    wx.request({
      url: getApp().globalData.url + '/Parking_management/record/dateisnull.action?',
      data: { 'recCarId': getApp().globalData.sessionCarId},
      success: function (res) {
        console.log(res)
        if (res.data.rows[0]!=undefined){
          var timestamp = res.data.rows[0].recEntryDate;
          console.log(timestamp)
          var indate = util.formatTimeTwo(timestamp, 'Y-M-D');
          var intime = util.formatTimeTwo(timestamp, 'h:m:s');
          var outdatetime = date + " " + time;
          var indatetime = indate + " " + intime;
          var recTime = util.formatTimeDate(outdatetime, indatetime);
          var recCost = recTime * 2;
          console.log(recTime)
          that.setData({
            record: res.data.rows[0],
            manageStaId: options.manageStaId,
            id: options.id,
            time: time,
            date: date,
            intime: intime,
            indate: indate,
            recTime: recTime,
            recCost: recCost
          })
        }
       
       
      }
    })
    this.sys();
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