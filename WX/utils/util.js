const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatDate = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  

  return [year, month, day].map(formatNumber).join('-') 
}

const formatTimeNow = date => {
  
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return  [hour, minute, second].map(formatNumber).join(':')
}
//当前时间加一小时
const formatTimeNow_1 = date => {

  const hour = date.getHours()+1
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [hour, minute, second].map(formatNumber).join(':')
}
//传值转换
function formatTimeTwo(timestamp, format) {
  const formateArr = ['Y', 'M', 'D', 'h', 'm', 's'];
  let returnArr = [];

  let date = new Date(timestamp);
  let year = date.getFullYear()
  let month = date.getMonth() + 1
  let day = date.getDate()
  let hour = date.getHours()
  let minute = date.getMinutes()
  let second = date.getSeconds()
  returnArr.push(year, month, day, hour, minute, second);

  returnArr = returnArr.map(formatNumber);

  for (var i in returnArr) {
    format = format.replace(formateArr[i], returnArr[i]);
  }
  return format;
}

function formatTimeDate(faultDate, completeTime) {
  var stime = Date.parse(new Date(faultDate));
  var etime = Date.parse(new Date(completeTime));
  var usedTime = stime - etime; //两个时间戳相差的毫秒数
  //计算出小时数
  var hour = Math.ceil((usedTime / 86400000) * 24);  
  return hour;
}
//计算相差毫秒数
function formatTimeDate_ms(faultDate, completeTime) {
  var stime = Date.parse(new Date(faultDate));
  var etime = Date.parse(new Date(completeTime));
  var usedTime = stime - etime; //两个时间戳相差的毫秒数
  return usedTime;
}
const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

function unique(arr) {
  if (!Array.isArray(arr)) {
    console.log('type error!')
    return
  }
  let res = [arr[0]]
  for (let i = 1; i < arr.length; i++) {
    let flag = true
    for (let j = 0; j < res.length; j++) {
      if (arr[i] === res[j]) {
        flag = false;
        break
      }
    }
    if (flag) {
      res.push(arr[i])
    }
  }
  return res
}

module.exports = {
  formatTime: formatTime,
  formatDate: formatDate,
  formatTimeNow: formatTimeNow,
  formatTimeTwo: formatTimeTwo,
  formatTimeDate: formatTimeDate,
  formatTimeNow_1: formatTimeNow_1,
  formatTimeDate_ms: formatTimeDate_ms,
  unique: unique
}
