// pages/mycenter/reservation/reservation.js
var util = require('../../../utils/util.js')
var reserve;
var resId="";
var resStaId="";
Page({

  /**
   * 页面的初始数据
   */
  data: {
    multiArrayA: [],
    multiArrayB: [],
    multiArrayC: [],
    multiArray: [
      ['A区', 'B区', 'C区'],
      ['A001', 'A002', 'A003', 'A004', 'A005']
    ],
    multiIndex: [0, 0],
    date: "2016-09-01",
    time: "12:01",
    endTime: "",
    endTimes: "",
    startdatetime: "",
    enddatetime: "",
    carId: "",
    staId: "",
    id:"",
    parkingmanage: {},
    parkingRes: {},
    parkingResCarId: {},
    isParkingRes: false,
    manage: {},
    userInfo: {},
    isParkingOwner: true,
    systemInfo: {}
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
  bindMultiPickerChange: function(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      multiIndex: e.detail.value
    })
  },
  bindMultiPickerColumnChange: function(e) {
    console.log('修改的列为', e.detail.column, '，值为', e.detail.value);
    var that = this;
    var data = {
      multiArray: this.data.multiArray,
      multiIndex: this.data.multiIndex
    };
    data.multiIndex[e.detail.column] = e.detail.value;
    switch (e.detail.column) {
      case 0:
        if (data.multiArray[0].length==3){
          switch (data.multiIndex[0]) {
            case 0:
              data.multiArray[1] = that.data.multiArrayA;
              break;
            case 1:
              data.multiArray[1] = that.data.multiArrayB;
              break;
            case 2:
              data.multiArray[1] = that.data.multiArrayC;
              break;
          }
        } else if (data.multiArray[0].length == 2){
          switch (data.multiIndex[0]) {
            case 0:
              data.multiArray[1] = that.data.multiArrayB;
              break;
            case 1:
              data.multiArray[1] = that.data.multiArrayC;
              break;
          }
        } else if (data.multiArray[0].length == 1){
          switch (data.multiIndex[0]) {
            case 0:
              data.multiArray[1] = that.data.multiArrayC;
              break;
          }
      }
       
        data.multiIndex[1] = 0;
        break;
    }
    console.log(data.multiIndex);
    console.log(data.multiIndex[0]);
    this.setData(data);
    var staId = "";
    var ss = that.data.multiArray[0]; //multiArra的第一个数组
    var aa = data.multiIndex[0];
    var bb = that.data.multiArray[1]; //multiArra的第二个数组
    var cc = data.multiIndex[1];
    console.log(ss[aa])
    console.log(bb[cc])
    getApp().globalData.resStaId = bb[cc];
    that.setData({
      staId: bb[cc]
    })

  },
  bindEndTimeChange: function(e) {
    console.log(e)
    this.setData({
      endTimes: e.detail.value
    })
  },
  showTopTips: function() {
    var that = this;
    that.setData({
      parkingRes: {
        'resCarId': that.data.carId,
        'resStaId': that.data.staId,
        'resStartTime': that.data.date + " " + that.data.time,
        'resEndTime': that.data.date + " " + that.data.endTimes + ":00"
      }
    })
    wx.request({
      url: getApp().globalData.url + "/Parking_management/res/save.action",
      data: that.data.parkingRes,
      success: function(res) {
        if (res.data.status == 200) {
          that.setData({
            manage: {
              'manageStaId': that.data.staId,
              'manageCarId': '已预订'
            }
          })

          wx.request({
            url: getApp().globalData.url + "/Parking_management/manage/editstaid.action",
            data: that.data.manage,
            success: function(res) {
              console.log(res)
              if (res.data.status == 200) {
                wx.showToast({
                  title: '预订车位成功',
                  icon: 'success',
                  duration: 1500,
                  success: function() {
                    setTimeout(function() {
                      //要延时执行的代码
                      wx.switchTab({
                        url: '../../park/park',
                        success: function() {
                          var page = getCurrentPages().pop();
                          if (page == undefined || page == null) return;
                          page.onLoad(); //重新刷新页面
                        }
                      })
                    }, 1500) //延迟时间
                  }
                })
               
                //定时器，预订时间到后取消预订 
                var indatetime = that.data.parkingRes.resStartTime;
                var outdatetime = that.data.parkingRes.resEndTime;
                var recTime = util.formatTimeDate_ms(outdatetime, indatetime);
                reserve = setTimeout(function() {
                  //要延时执行的代码
                  wx.request({
                    url: getApp().globalData.url + "/Parking_management/res/wxcarlist.action",
                    data: {
                      resCarId: that.data.carId
                    },
                    success: function (res) {
                      console.log('根据车牌号查询的车辆')
                      console.log(res)
                      resId = res.data.rows[0].id;
                      resStaId = res.data.rows[0].resStaId;
                    }
                  })
                  wx.request({
                    url: getApp().globalData.url + "/Parking_management/res/cariddelete.action",
                    data: {
                      'resCarId': getApp().globalData.sessionCarId
                    },
                    success: function(res) {
                      if (res.data.status == 200) {
                        that.setData({
                          manage: {
                            'manageStaId': resStaId,
                            'manageCarId': ''
                          }
                        })
                        wx.request({
                          url: getApp().globalData.url + "/Parking_management/manage/editstaid.action",
                          data: that.data.manage,
                          success: function(res) {
                            console.log('定时器执行了') 
                            var page = getCurrentPages().pop();
                            if (page == undefined || page == null) return;
                            page.onLoad(); //重新刷新页面                       
                          }
                        })

                      }
                    }
                  })
                }, recTime)
              } else {
                wx.showToast({
                  icon: 'loading',
                  title: '预订车位失败',
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
  showTopTipss: function() {
    var that = this;
    wx.request({
      url: getApp().globalData.url + "/Parking_management/res/delete.action",
      data: {
        'id': that.data.parkingResCarId.id
      },
      success: function(res) {
        if (res.data.status == 200) {
          that.setData({
            manage: {
              'manageStaId': that.data.parkingResCarId.resStaId,
              'manageCarId': ''
            }
          })
          wx.request({
            url: getApp().globalData.url + "/Parking_management/manage/editstaid.action",
            data: that.data.manage,
            success: function(res) {
              console.log(res)
              if (res.data.status == 200) {
                wx.showToast({
                  title: '取消预订成功',
                  icon: 'success',
                  duration: 1500,
                  success: function() {
                    setTimeout(function() {
                      //要延时执行的代码
                      wx.switchTab({
                        url: '../../park/park',
                        success: function() {
                          that.setData({
                            isParkingRes: false
                          })
                          clearTimeout(reserve);
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
                  title: '取消预订失败',
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
    var that = this;
    if (this.data.systemInfo.platform == "ios") {
      var time = util.formatTimeNow(new Date());
      var date = util.formatDate(new Date());
      var endTime = util.formatTimeNow_1(new Date());
      date = Date.parse(date.replace(/-/g, "/"));
    } else {
      var time = util.formatTimeNow(new Date());
      var date = util.formatDate(new Date());
      var endTime = util.formatTimeNow_1(new Date());
    }
    
    that.setData({
      date: date,
      time: time,
      endTime: endTime,
      carId: getApp().globalData.sessionCarId,
      userInfo: getApp().globalData.userInfo
    })
    wx.request({
      url: getApp().globalData.url + "/Parking_management/manage/wxlists.action",
      success: function(res) {
        console.log(res)
        that.setData({
          parkingmanage: res.data.rows
        })
        var manageArea = ''; //区域
        var manageStaIdA = ''; //A区域停车位
        var manageStaIdB = ''; //B区域停车位
        var manageStaIdC = ''; //C区域停车位
        for (var i = 0; i < res.data.rows.length; i++) { //循环拼接
          manageArea += res.data.rows[i].manageArea + ',';
          if (res.data.rows[i].manageStaId.substring(0, 1) == 'A') {
            manageStaIdA += res.data.rows[i].manageStaId + ','
          } else if (res.data.rows[i].manageStaId.substring(0, 1) == 'B') {
            manageStaIdB += res.data.rows[i].manageStaId + ','
          } else if (res.data.rows[i].manageStaId.substring(0, 1) == 'C') {
            manageStaIdC += res.data.rows[i].manageStaId + ','
          }
        }
        //去除最后一个逗号
        manageArea = manageArea.substring(0, manageArea.length - 1)
        manageStaIdA = manageStaIdA.substring(0, manageStaIdA.length - 1)
        manageStaIdB = manageStaIdB.substring(0, manageStaIdB.length - 1)
        manageStaIdC = manageStaIdC.substring(0, manageStaIdC.length - 1)
        //字符串转数组
        manageArea = manageArea.split(",")
        manageArea = util.unique(manageArea) //数组去重
        manageStaIdA = manageStaIdA.split(",")
        manageStaIdB = manageStaIdB.split(",")
        manageStaIdC = manageStaIdC.split(",")
        console.log(manageStaIdB)
        if (manageStaIdA == "" && manageStaIdB != "" && manageStaIdC!=""){
          console.log("进入A")
          that.setData({
            multiArray: [manageArea, manageStaIdB],
            multiArrayA: manageStaIdA,
            multiArrayB: manageStaIdB,
            multiArrayC: manageStaIdC,
            staId: manageStaIdB[0]
          })
        } else if( manageStaIdA == "" && manageStaIdB == "" && manageStaIdC != ""){
          console.log("进入B")
          that.setData({
            multiArray: [manageArea, manageStaIdC],
            multiArrayA: manageStaIdA,
            multiArrayB: manageStaIdB,
            multiArrayC: manageStaIdC,
            staId: manageStaIdC[0]
          })
        } else if (manageStaIdA == "" && manageStaIdB != "" && manageStaIdC == ""){
          that.setData({
            multiArray: [manageArea, manageStaIdB],
            multiArrayA: manageStaIdA,
            multiArrayB: manageStaIdB,
            multiArrayC: manageStaIdC,
            staId: manageStaIdB[0]
          })
        }else{
          that.setData({
            multiArray: [manageArea, manageStaIdA],
            multiArrayA: manageStaIdA,
            multiArrayB: manageStaIdB,
            multiArrayC: manageStaIdC,
            staId: manageStaIdA[0]
          })
        }
       
      }
    })
    //通过车牌号查询所有预订
    wx.request({
      url: getApp().globalData.url + "/Parking_management/res/wxcarlist.action",
      data: {
        resCarId: that.data.carId
      },
      success: function(res) {
        console.log(res)
        if (res.data.rows.length != 0) {
          var startdatetime = util.formatTimeTwo(res.data.rows[0].resStartTime, 'Y-M-D h:m:s');
          var enddatetime = util.formatTimeTwo(res.data.rows[0].resEndTime, 'Y-M-D h:m:s');
          that.setData({
            parkingResCarId: res.data.rows[0],
            isParkingRes: true,
            startdatetime: startdatetime,
            enddatetime: enddatetime
          })
        }

      }
    })
    wx.request({
      url: getApp().globalData.url + '/Parking_management/owner/wxlist.action',
      data: {
        'carId': getApp().globalData.sessionCarId
      },
      success: function (res) {
        console.log(res.data.rows[0])
        if (res.data.rows[0] == undefined) {
          that.setData({
            parkingOwner: {},
            isParkingOwner: true
          })
        } else {
          that.setData({
            parkingOwner: res.data.rows[0],
            isParkingOwner: false
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