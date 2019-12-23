// pages/park/input/input.js
var util = require('../../../utils/util.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    manageStaId: "",
    id: "",
    date: "2016-09-01",
    time: "12:01",
    recCarId: "",
    record: {},
    manage: {}
  },
  bindDateChange: function(e) {
    this.setData({
      date: e.detail.value
    })
  },
  bindTimeChange: function(e) {
    console.log(e.detail.value)
    this.setData({
      time: e.detail.value
    })
  },
  bindrecCarIdInput: function(e) {
    this.setData({
      recCarId: e.detail.value
    })
  },
  showTopTips: function() {
    var that = this;
    that.setData({
      record: {
        'recCarId': that.data.recCarId,
        'recEntryDate': that.data.date + ' ' + that.data.time
      },
      manage: {
        'manageStaId': that.data.manageStaId,
        'id': that.data.id,
        'manageCarId': that.data.recCarId
      }
    })
    wx.request({
      url: getApp().globalData.url + '/Parking_management/record/save.action?',
      data: that.data.record,
      success: function(res) {
        if (res.data.status == 200) {
          wx.request({
            url: getApp().globalData.url + '/Parking_management/manage/edit.action?',
            data: that.data.manage,
            success: function(res) {
              //res.data就是后端返回的数据，转成了对象，可以直接遍历
              //把res.data放入data中
              if (res.data.status == 200) {
                getApp().globalData.isInput = true;
                wx.request({
                  url: getApp().globalData.url + "/Parking_management/res/wxcarlist.action",
                  data: {
                    resCarId: getApp().globalData.sessionCarId
                  },
                  success: function(res) {
                    console.log(res)
                    if (res.data.rows.length != 0) {
                      wx.request({
                      url: getApp().globalData.url + '/Parking_management/res/cariddelete.action',
                      data: {
                          'resCarId': getApp().globalData.sessionCarId
                      },
                      success: function(res) {
                          console.log(res)
                          if (res.data.status == 200) {
                            
                            wx.showToast({
                              title: '停车成功',
                              icon: 'success',
                              duration: 1500,
                              success: function() {
                                setTimeout(function() {
                                  //要延时执行的代码
                                  wx.switchTab({
                                    url: '/pages/parklogs/parklogs',
                                    success: function() {
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
                              title: '停车失败',
                              duration: 2000,
                              mask: true,
                              image: '../../../icons/error.png'
                            })
                          }
                        }
                      })
                    }else{
                      wx.showToast({
                        title: '停车成功',
                        icon: 'success',
                        duration: 1500,
                        success: function () {
                          setTimeout(function () {
                            //要延时执行的代码
                            wx.switchTab({
                              url: '/pages/parklogs/parklogs',
                              success: function () {
                                var page = getCurrentPages().pop();
                                if (page == undefined || page == null) return;
                                page.onLoad(); //重新刷新页面
                              }
                            })
                          }, 1500) //延迟时间
                        }
                      })
                    }

                  }
                })
              } else {
                wx.showToast({
                  icon: 'loading',
                  title: '停车失败',
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
  onLoad: function(options) {
    var time = util.formatTimeNow(new Date());
    var date = util.formatDate(new Date());
    this.setData({
      recCarId: getApp().globalData.sessionCarId,
      manageStaId: options.manageStaId,
      id: options.id,
      time: time,
      date: date
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