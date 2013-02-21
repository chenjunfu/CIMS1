
var patternRequire = /.+/;
var patternEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
var patternPhone = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{7,8}(\-\d{1,4})?$/;
var patternMobile = /^((\(\d{2,3}\))|(\d{3}\-))?(13|14|15|18)\d{9}$/;
var patternUrl = /^http=\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\'=+!]*([^<>\"\"])*$/;
var patternCurrency = /^\d+(\.\d+)?$/;
var patternNumber = /^\d+$/;
var patternZip = /^[1-9]\d{5}$/;
var patternQQ = /^[1-9]\d{4,8}$/;
var patternInteger = /^[-\+]?\d+$/;
var patternDouble = /^[-\+]?\d+(\.\d+)?$/;
var patternEnglish = /^[A-Za-z]+$/;
var patternChinese =  /^[\u0391-\uFFE5]+$/;
var patternUserName = /^[a-zA-Z][a-zA-Z0-9_]{1,14}[a-zA-Z0-9]$/i;
var patternPassWord = /^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/;
var patternDate = /^((\d{2}(([02468][048])|([13579][26]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|([1-2][0-9])))))|(\d{2}(([02468][1235679])|([13579][01345789]))[\-\/\s]?((((0?[13578])|(1[02]))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\-\/\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\-\/\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\s(((0?[0-9])|([1-2][0-3]))\:([0-5]?[0-9])((\s)|(\:([0-5]?[0-9])))))?$/;
var patternIdCard = function(number){
	var date, Ai;
	var verify = "10x98765432";
	var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
	var area = ['','','','','','','','','','','','北京','天津','河北','山西','内蒙古','','','','','','辽宁','吉林','黑龙江','','','','','','','','上海','江苏','浙江','安微','福建','江西','山东','','','','河南','湖北','湖南','广东','广西','海南','','','','重庆','四川','贵州','云南','西藏','','','','','','','陕西','甘肃','青海','宁夏','新疆','','','','','','台湾','','','','','','','','','','香港','澳门','','','','','','','','','国外'];
	var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/i);
	if(re == null) return false;
	if(re[1] >= area.length || area[re[1]] == "") return false;
	if(re[2].length == 12){
		Ai = number.substr(0, 17);
		date = [re[9], re[10], re[11]].join("-");
	}
	else{
		Ai = number.substr(0, 6) + "19" + number.substr(6);
		date = ["19" + re[4], re[5], re[6]].join("-");
	}
	if(!this.IsDate(date, "ymd")) return false;
	var sum = 0;
	for(var i = 0;i<=16;i++){
		sum += Ai.charAt(i) * Wi[i];
	}
	Ai +=  verify.charAt(sum%11);
	return (number.length ==15 || number.length == 18 && number == Ai);
}

/**
 * 获得字符串的长度
 * 
 * @param str
 *            原始字符串
 */
function getLength(obj)
{
	if (obj)
		return obj.value.length;
	else
		return 0;
}

/**
 * 截断字符串
 * 
 * @param {}
 *            sSource 需要截断的字符串
 * @param {}
 *            iLen 需要截断字符串的长度
 * @param {}
 *            isend 截断后是否添加...符号
 */
function leftTrue(sSource, iLen, isend)
{
	if (sSource.replace(/[^\x00-\xff]/g, "xx").length <= iLen)
	{
		return sSource;
	}
	var ELIDED = "";

	var str = "";
	var l = 0;
	var schar;
	for (var i = 0; schar = sSource.charAt(i); i++)
	{
		str += schar;
		l += (schar.match(/[^\x00-\xff]/) != null ? 2 : 1);
		if (l >= iLen - ELIDED.length)
		{
			break;
		}
	}
	str += ELIDED;

	if (isend)
		str += "...";
	return str;
}
function OutleftTrue(sSource, iLen, isend)
{
	document.write(leftTrue(sSource, iLen, isend));
}

/**
 * 返回日期字符的日期 yyyy-MM-dd HH:mm:ss To yyyy-MM-dd
 * 
 * @param {}
 *            dtDate 时间字符
 */
function DateTimeToShortDateString(dtDate)
{
	if (dtDate.indexOf(" ") == -1)
	{
		return dtDate;
	}
	return dtDate.substring(0, dtDate.indexOf(" "));
}

function OutDateTimeToShortDateString(dtDate)
{
	document.write(DateTimeToShortDateString(dtDate));
}

/**
 * 返回数字的小数点前的整数位
 * 
 */
function NumberToInt(strNumber)
{
	if (strNumber.indexOf(".") == -1)
	{
		return strNumber;
	}
	return strNumber.substring(0, strNumber.indexOf("."));
}

function OutNumberToInt(strNumber)
{
	document.write(NumberToInt(strNumber));
}
// 依据指定长度来判断字符串长度（对应于页面中的textarea字段）
function CheckLength(str,len)
{
	var flag =false;
	var strLen = str.length;
	if(strLen <= len)
		flag = true;
	return flag;
}

// ---------------选择列表 开始----------------
// 移动单条
function moveOption(LeftSelect, RightSelect, TextBox, LeftOrRight)
{
	try
	{
		if (LeftOrRight == "Left")
		{

			for (var i = RightSelect.options.length - 1; i >= 0; i--)
			{
				if (RightSelect.options[i].selected)
				{
					var opt = new Option(RightSelect.options[i].text, RightSelect.options[i].value);
					opt.selected = true;
					LeftSelect.options.add(opt);
					RightSelect.remove(i);
				}
			}
			// var e = RightSelect.options[RightSelect.selectedIndex];
			// LeftSelect.options.add(new Option(e.text, e.value));
			// RightSelect.options.remove(RightSelect.selectedIndex);
		}
		else
		{

			for (var i = LeftSelect.options.length - 1; i >= 0; i--)
			{
				if (LeftSelect.options[i].selected)
				{
					var opt = new Option(LeftSelect.options[i].text, LeftSelect.options[i].value);
					opt.selected = true;
					RightSelect.options.add(opt);
					LeftSelect.remove(i);
				}
			}
			// var e = LeftSelect.options[LeftSelect.selectedIndex];
			// RightSelect.options.add(new Option(e.text, e.value));
			// LeftSelect.options.remove(LeftSelect.selectedIndex);
		}
		TextBoxValue(RightSelect, TextBox);
	}
	catch (e)
	{
	}
}

// 移动全部
function moveOptionAll(LeftSelect, RightSelect, TextBox, LeftOrRight)
{
	var i;
	var maxCount = 0;
	if (LeftOrRight == "Left")
	{
		maxCount = RightSelect.length;
		for (i = 0; i < maxCount; i++)
		{
			try
			{
				var e = RightSelect.options[0];
				LeftSelect.options.add(new Option(e.text, e.value));
				RightSelect.options.remove(0);
			}
			catch (e)
			{
			}
		}
	}
	else
	{
		maxCount = LeftSelect.length;
		for (i = 0; i < maxCount; i++)
		{
			try
			{
				var e = LeftSelect.options[0];
				RightSelect.options.add(new Option(e.text, e.value));
				LeftSelect.options.remove(0);
			}
			catch (e)
			{
			}
		}
	}
	TextBoxValue(RightSelect, TextBox);
}

// 初始化移出右边已经存在的栏目
function initListBox(LeftSelect, RightSelect, TextBox)
{
	try
	{
		var i;
		var LeftSelectCount = Array();
		for (i = 0; i < LeftSelect.length; i++)
		{
			if (IsListBox(LeftSelect.options[i].value, RightSelect))
			{
				// LeftSelect.options.remove(i);
				LeftSelectCount.push(LeftSelect.options[i].value);
			}
		}
		for (i = 0; i < LeftSelectCount.length; i++)
		{
			LeftSelect.options.remove(LeftSelectIndex(LeftSelect, LeftSelectCount[i]));
		}
		TextBoxValue(RightSelect, TextBox);
	}
	catch (e)
	{
	}
}
function LeftSelectIndex(LeftSelect, LeftValue)
{
	try
	{
		var i;
		for (i = 0; i < LeftSelect.length; i++)
		{
			if (LeftSelect.options[i].value == LeftValue)
			{
				return i;
			}
		}
		return -1;
	}
	catch (e)
	{
	}
}

function IsListBox(LeftSelect, RightSelect)
{
	try
	{
		var i;
		for (i = 0; i < RightSelect.length; i++)
		{
			if (RightSelect.options[i].value == LeftSelect)
			{
				return true;
			}
		}
		return false;
	}
	catch (e)
	{
	}
}

// 上移
function DynamicListBox_MoveUp(ListBox, TextBox)
{
	var index = ListBox.selectedIndex;
	if (index == -1 || index == 0)
	{
		return;
	}
	ListBox.options[index].swapNode(ListBox.options[(index != 0) ? (index - 1) : 0]);
	// var theItem = ListBox.options[index];
	// var oldText = theItem.text;
	// var oldValue = theItem.value;
	// ListBox.remove( index );
	// ListBox.add( oldValue, oldText, index - 1 );
	// ListBox.selectedIndex = index - 1;
	TextBoxValue(ListBox, TextBox);
}
// 下移
function DynamicListBox_MoveDown(ListBox, TextBox)
{
	var index = ListBox.selectedIndex;
	if (index == -1 || index == ListBox.length - 1)
	{
		return;
	}
	// dbox.options[i].swapNode(dbox.options[(i<dbox.length-1)?(i+1):i]);
	ListBox.options[index].swapNode(ListBox.options[(index < ListBox.length - 1) ? (index + 1) : index]);
	// var theItem = ListBox.options[index];
	// var oldText = theItem.text;
	// var oldValue = theItem.value;
	// ListBox.remove( index );
	// ListBox.add( oldValue, oldText, index + 1 );
	// ListBox.selectedIndex = index + 1;
	TextBoxValue(ListBox, TextBox);
}

// 得到项目
function TextBoxValue(ListBox, TextBox)
{
	var i;
	var str = "";
	for (i = 0; i < ListBox.length; i++)
	{
		str += ListBox.options[i].text + ":" + ListBox.options[i].value + "\n";
	}
	TextBox.value = str;
	// document.getElementById('TxtSelect1').value=str;
}

// 上移
function moveUp(obj, TextBox)
{
	for (var i = 1; i < obj.length; i++)
	{// 最上面的一个不需要移动，所以直接从i=1开始
		if (obj.options[i].selected)
		{
			if (!obj.options.item(i - 1).selected)
			{
				var selText = obj.options[i].text;
				var selValue = obj.options[i].value;
				obj.options[i].text = obj.options[i - 1].text;
				obj.options[i].value = obj.options[i - 1].value;
				obj.options[i].selected = false;
				obj.options[i - 1].text = selText;
				obj.options[i - 1].value = selValue;
				obj.options[i - 1].selected = true;
			}
		}
	}
	TextBoxValue(obj, TextBox);
}

// 下移
function moveDown(obj, TextBox)
{
	for (var i = obj.length - 2; i >= 0; i--)
	{// 向下移动，最后一个不需要处理，所以直接从倒数第二个开始
		if (obj.options[i].selected)
		{
			if (!obj.options[i + 1].selected)
			{
				var selText = obj.options[i].text;
				var selValue = obj.options[i].value;
				obj.options[i].text = obj.options[i + 1].text;
				obj.options[i].value = obj.options[i + 1].value;
				obj.options[i].selected = false;
				obj.options[i + 1].text = selText;
				obj.options[i + 1].value = selValue;
				obj.options[i + 1].selected = true;
			}
		}
	}
	TextBoxValue(obj, TextBox);
}
// 置顶
function moveTop(obj, TextBox)
{
	var opts = [];
	for (var i = obj.options.length - 1; i >= 0; i--)
	{
		if (obj.options[i].selected)
		{
			opts.push(obj.options[i]);
			obj.remove(i);
		}
	}
	var index = 0;
	for (var t = opts.length - 1; t >= 0; t--)
	{
		var opt = new Option(opts[t].text, opts[t].value);
		opt.selected = true;
		obj.options.add(opt, index++);
	}
	TextBoxValue(obj, TextBox);
}
// 置底
function moveBottom(obj, TextBox)
{
	var opts = [];
	for (var i = obj.options.length - 1; i >= 0; i--)
	{
		if (obj.options[i].selected)
		{
			opts.push(obj.options[i]);
			obj.remove(i);
		}
	}
	for (var t = opts.length - 1; t >= 0; t--)
	{
		var opt = new Option(opts[t].text, opts[t].value);
		opt.selected = true;
		obj.options.add(opt);
	}
	TextBoxValue(obj, TextBox);
}

// ---------------选择列表 结束----------------

// ---------------显示灰色JS遮罩层 开始----------------
// 显示灰色JS遮罩层
function showBg(ct, content)
{
	//控制遮罩的高度
	try{
	document.getElementById("main").style.height=document.documentElement.clientHeight+"px";
	}catch (ex){}//法人
	
	var bH = $("body").height();
	var bW = $("body").width() + 16;
	var objWH = getObjWh(ct);
	$("#fullbg").css(
			{
				width : bW,
				height : bH,
				display : "block"
			});
	var tbT = objWH.split("|")[0] + "px";
	var tbL = objWH.split("|")[1] + "px";
	$("#" + ct).css(
			{
				top : tbT,
				left : tbL,
				display : "block"
			});
	$("#" + content).html("<div style='text-align:center'>请稍等，正在执行操作...</div>");
	$(window).scroll(function()
			{
				resetBg()
			});
	$(window).resize(function()
			{
				resetBg()
			});
}
function getObjWh(obj)
{
	var st = document.documentElement.scrollTop;// 滚动条距顶部的距离
	var sl = document.documentElement.scrollLeft;// 滚动条距左边的距离
	var ch = document.documentElement.clientHeight;// 屏幕的高度
	var cw = document.documentElement.clientWidth;// 屏幕的宽度
	var objH = $("#" + obj).height();// 浮动对象的高度
	var objW = $("#" + obj).width();// 浮动对象的宽度
	var objT = Number(st) + (Number(ch) - Number(objH)) / 2;
	var objL = Number(sl) + (Number(cw) - Number(objW)) / 2;
	return objT + "|" + objL;
}
function resetBg()
{
	var fullbg = $("#fullbg").css("display");
	if (fullbg == "block")
	{
		var bH2 = $("body").height();
		var bW2 = $("body").width() + 16;
		$("#fullbg").css(
				{
					width : bW2,
					height : bH2
				});
		var objV = getObjWh("dialog");
		var tbT = objV.split("|")[0] + "px";
		var tbL = objV.split("|")[1] + "px";
		$("#dialog").css(
				{
					top : tbT,
					left : tbL
				});
	}
}

// 关闭灰色JS遮罩层和操作窗口
function closeBg()
{
	$("#fullbg").css("display", "none");
	$("#dialog").css("display", "none");
	try{
	document.getElementById("main").style.height="0px";
	}catch (ex){}//法人
}
// ---------------显示灰色JS遮罩层 结束----------------
function getQueryString(queryStringName,uRLString)
{
  var returnValue = "";
  var URLString = uRLString;
  if(uRLString=="")
	  URLString = new String(document.location);
  var serachLocation =  - 1;
  var queryStringLength = queryStringName.length;
  var URLStringLowerCase = URLString.toLowerCase();
  var queryStringNameLowerCase = queryStringName.toLowerCase();
  do
  {
    serachLocation = URLStringLowerCase.indexOf("&" + queryStringNameLowerCase + "\=");
    if (serachLocation ==  - 1)
    {
		serachLocation = URLStringLowerCase.indexOf("?" + queryStringNameLowerCase + "\=");
	}
    if (serachLocation !=  - 1)
    {
      if ((URLString.charAt(serachLocation) == '?') || (URLString.charAt(serachLocation ) == '&'))
      {
        URLString = URLString.substr(serachLocation + 1);
        break;
      }
      URLString = URLString.substr(serachLocation + queryStringLength + 2);
    }

  }
  while (serachLocation !=  - 1)
  
  if (serachLocation !=  - 1)
  {
    var seperatorLocation = URLString.indexOf("&");
    if (seperatorLocation ==  - 1)
    {
      returnValue = URLString.substr(queryStringLength + 1);
    }
    else
    {
      returnValue = URLString.substring(queryStringLength + 1, seperatorLocation);
    }
  }
  return decodeURI(returnValue);
}