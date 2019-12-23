// pages/mycenter/ocr/idCard/idCard.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    idCardOne: {},
    idCardTwo: {},
    isIdCardOne: true,
    isIdCardTwo:true
  },
  successOne: function(e) { //身份证识别
    console.log(e.detail)
    console.log(e.detail.valid_date.text)
    this.setData({
      idCardOne: e.detail,
      isIdCardOne:false
    })
  },
  successTwo: function (e) { //身份证识别
    console.log(e.detail)
    console.log(e.detail.name)
    console.log(e.detail.name.text)
    this.setData({
      idCardTwo: e.detail,
      isIdCardTwo: false
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