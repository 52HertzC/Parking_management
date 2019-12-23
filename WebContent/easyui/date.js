function parseToDate(value) {
    if (value == null || value == '') {
        return undefined;
    }
    var dt;
    if (value instanceof Date) {
        dt = value;
    } else {
        if (!isNaN(value)) {
            dt = new Date(value);
        } else if (value.indexOf('/Date') > -1) {
            value = value.replace(/\/Date\((-?\d+)\)\//, '$1');
            dt = new Date();
            dt.setTime(value);
        } else if (value.indexOf('/') > -1) {
            dt = new Date(Date.parse(value.replace(/-/g, '/')));
        } else {
            dt = new Date(value);
        }
    }
    return dt;
}
// 为Date类型拓展一个format方法，用于格式化日期
Date.prototype.format = function(format) // author: meizz
{
    var o = {
        "M+" : this.getMonth() + 1, // month
        "d+" : this.getDate(), // day
        "h+" : this.getHours(), // hour
        "m+" : this.getMinutes(), // minute
        "s+" : this.getSeconds(), // second
        "q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
        "S" : this.getMilliseconds()
    // millisecond
    };
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "")
                .substr(4 - RegExp.$1.length));
    for ( var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k]
                    : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
};
/* 带时间 */
function formatDateBoxFull(value) {
    if (value == null || value == '') {
        return '';
    }
    var dt = parseToDate(value);
    return dt.format("yyyy-MM-dd hh:mm:ss");
}
function formatDatebox(value) {
    if (value == null || value == '') {
        return '';
    }
    var dt = parseToDate(value);// 关键代码，将那个长字符串的日期值转换成正常的JS日期格式
    return dt.format("yyyy-MM-dd"); // 这里用到一个javascript的Date类型的拓展方法，这个是自己添加的拓展方法，在后面的步骤3定义
}
//重写datagrid方法，使datagrid行编辑时，日期控件内的时间格式正确显示：

$.extend($.fn.datagrid.defaults.editors, {
    datebox : {
        init : function(container, options) {
            var input = $('<input type="text">').appendTo(container);
            input.datebox(options);
            return input;
        },
        destroy : function(target) {
            $(target).datebox('destroy');
        },
        getValue : function(target) {
            return $(target).datebox('getValue');
        },
        setValue : function(target, value) {
            $(target).datebox('setValue', formatDatebox(value));
        },
        resize : function(target, width) {
            $(target).datebox('resize', width);
        }
    },
    datetimebox : {
        init : function(container, options) {
            var input = $('<input type="text">').appendTo(container);
            input.datetimebox(options);
            return input;
        },
        destroy : function(target) {
            $(target).datetimebox('destroy');
        },
        getValue : function(target) {
            return $(target).datetimebox('getValue');
        },
        setValue : function(target, value) {
            $(target).datetimebox('setValue', formatDateBoxFull(value));
        },
        resize : function(target, width) {
            $(target).datetimebox('resize', width);
        }
    }
});


function formatRecCarId(val,row,index) {
	return row.parkingRecord.recCarId;
	}

