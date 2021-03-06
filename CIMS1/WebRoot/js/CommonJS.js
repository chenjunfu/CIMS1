var m_objPopupWindow = null; //当前弹出窗体

//关闭弹出窗口
function closePopup() 
{
    if (m_objPopupWindow != null) {

        if (!m_objPopupWindow.closed) {
            m_objPopupWindow.close();
        }
        m_objPopupWindow = null;
    }
}

function focusPopup() 
{
    try
    {
         if (m_objPopupWindow != null)
         {
            m_objPopupWindow.focus();
         }
     }
     catch(e){}
}

//第一类：弹出窗口。（请记着在父窗体的body加onfocus="closePopup();" ）
function popWin(url) 
{
    closePopup();
    
    var iWidth = 900;
	var iHeight = 630;
	var iLeft = ( screen.availWidth - iWidth ) / 2;
	var iTop = ( screen.availHeight - iHeight ) / 2;
	var name = GetRandName(); //用时间做随机名称
//	window.open(url, name, "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=" + iLeft + ",top=" + iTop + ",width="+ iWidth +",height="+ iHeight +"",false);
	
    m_objPopupWindow = window.open(url, name, "toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,left=" + iLeft + ",top=" + iTop + ",width="+ iWidth +",height="+ iHeight +"",false);
    m_objPopupWindow.focus();
}
function popWinNew(url, name) 
{
    closePopup();
    
    var iWidth = 900;
	var iHeight = 700;
	var iLeft = ( screen.availWidth - iWidth ) / 2;
	var iTop = ( screen.availHeight - iHeight ) / 2 - 10;
	
    m_objPopupWindow = window.open(url, name, "toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,left=" + iLeft + ",top=" + iTop + ",width="+ iWidth +",height="+ iHeight +"",false);
    m_objPopupWindow.focus();
}
function popWinWithName(url, name) 
{
    closePopup();
    
    var iWidth = 900;
	var iHeight = 700;
	var iLeft = ( screen.availWidth - iWidth ) / 2;
	var iTop = ( screen.availHeight - iHeight ) / 2;
	
    m_objPopupWindow = window.open(url, name,"toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,left=" + iLeft + ",top=" + iTop + ",width="+ iWidth +",height="+ iHeight +"",false);
    m_objPopupWindow.focus();
}


//第二类：弹出窗口。（请记着在父窗体的body加onfocus="closePopup();" ）
function popWin2WithName(url, name,width, height) 
{
    closePopup();

	var iLeft = ( screen.availWidth - width ) / 2;
	var iTop = ( screen.availHeight - height ) / 2 - 10;
	
    m_objPopupWindow = window.open(url,name,"toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,left=" + iLeft + ",top=" + iTop + ",width="+ width +",height="+ height +"",false);
    m_objPopupWindow.focus();
}
function popWin2(url, width) 
{
    var iWidth = 900;
	if(width)
		iWidth = width;
	var iHeight = 630;
	var iLeft = ( screen.availWidth - iWidth ) / 2;
	var iTop = ( screen.availHeight - iHeight ) / 2;
	var name = GetRandName(); //用时间做随机名称
	
//	window.open(url, name, "toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=1,left=" + iLeft + ",top=" + iTop + ",width="+ iWidth +",height="+ iHeight +"",false);
	var win = window.open(url, name,"toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,left=" + iLeft + ",top=" + iTop + ",width="+ iWidth +",height="+ iHeight +"",false);
    win.focus();
}
function popWin2AllowMulti(url, width, height) 
{
	var iLeft = ( screen.availWidth - width ) / 2;
	var iTop = ( screen.availHeight - height ) / 2 - 10;
	var name = GetRandName(); //用时间做随机名称
	
    var win = window.open(url, name,"toolbar=0,location=0,directories=0,status=1,menubar=0,scrollbars=1,resizable=1,left=" + iLeft + ",top=" + iTop + ",width="+ width +",height="+ height +"",false);
    win.focus();
}

//弹出模式窗体
function popModalWin(url, winObj, width, height)
{
    var val = showModalDialog(url, winObj, "dialogWidth:" + width + "px; dialogHeight: "+ height + "px; resizable:yes;");
    return val;
}

function GetRandName()
{
   var d, s = "", tmp;
   var c = "_";
		d = new Date();
		tmp = d.getHours();
		tmp = tmp < 10 ? ('0'+tmp) : tmp;
		s += tmp + c;

		tmp = d.getMinutes();
		tmp = tmp < 10 ? ('0'+tmp) : tmp;
		s += tmp + c;

		tmp = d.getSeconds();
		tmp = tmp < 10 ? ('0'+tmp) : tmp;
		s += tmp; 
		s += d.getMilliseconds();
		return(s);
}

//关闭窗口

function closeWin()
{
    if(window.parent != null)
    {
        if(window.parent.parent != null)
        {
            window.parent.parent.opener = null;
            window.parent.parent.close();
        }
        else
        {
            window.parent.opener = null;
            window.parent.close();
        }
    }
    else
    {
        window.opener = null;
        window.close();
    }
}

//按钮状态设置
function  setOperateButtonStyle(obj,objEvent)
{
    if(objEvent=="over")        
        {if(obj.className!='buttonSelect') obj.className='buttonSelect';}
    else
        {if(obj.className!='button') obj.className='button';}
}

function  setimageelectStyle(obj,objEvent)
{
    if(objEvent=="over")        
        {if(obj.className!='imageSelectOver') obj.className='imageSelectOver';}
    else
        {if(obj.className!='imageSelect') obj.className='imageSelect';}
}

function  setImageClearStyle(obj,objEvent)
{
    if(objEvent=="over")        
        {if(obj.className!='imageClearOver') obj.className='imageClearOver';}
    else
        {if(obj.className!='imageClear') obj.className='imageClear';}
}

//
function doSelectUser(nameCtlId, valueCtlId, unitNameCtlId, unitIdCtlId)
{
    popWin2WithName("../../SysSetting/Group/UserManagement/UserMainForm.aspx?PageState=Select&SelectType=GetUnit&UidControl=" + valueCtlId + "&UserNameControl=" + nameCtlId + "&UnitNameControl=" + unitNameCtlId + "&UnitIdControl=" + unitIdCtlId ,"CusSelUser", 900, 700);
}

function doSelectUnit(nameCtlId, valueCtlId)
{
    popWin2WithName("../../SysSetting/Group/Unit/UnitMainForm.aspx?PageState=Select&SelectType=Single&CodeControlId=" + valueCtlId + "&NameControlId=" + nameCtlId,"CusSelUnit", 900, 700);
}

function doSelectContact(nameCtlId, valueCtlId)
{
    popWin2WithName("ContactListForm.aspx?PageState=Select&SelectType=Single&ValueControlId=" + valueCtlId + "&NameControlId=" + nameCtlId,"CusSelContact", 900, 700);
}

function doSelectCustomer(nameCtlId, valueCtlId)
{
    popWin2WithName("../../Base/Customer/CustomerListForm.aspx?PageType=SingleSelect&ValueControlId=" + valueCtlId + "&NameControlId=" + nameCtlId,"CusSelContact", 880, 680);
}

function doSelectContactSingle(nameCtlId, valueCtlId)
{
    var val = popModalWin("../../Base/Contact/ContactListForm.aspx?PageType=SingleSelect&ValueCtlId=" + valueCtlId + "&NameCtlId=" + nameCtlId,window, 880, 680);
}

function doSelectContactMulti(nameCtlId, valueCtlId)
{
    var val = popModalWin("../../Base/Contact/ContactListForm.aspx?PageType=MultiSelect&ValueCtlId=" + valueCtlId + "&NameCtlId=" + nameCtlId,window, 880, 680);
}

function doSelectCustomerSingle(nameCtlId, valueCtlId)
{
    var val = popModalWin("../../Base/Customer/CustomerListForm.aspx?PageType=SingleSelect&ValueCtlId=" + valueCtlId + "&NameCtlId=" + nameCtlId,window, 880, 680);
}

function doSelectCustomerMulti(nameCtlId, valueCtlId)
{
    var val = popModalWin("../../Base/Customer/CustomerListForm.aspx?PageType=MultiSelect&ValueCtlId=" + valueCtlId + "&NameCtlId=" + nameCtlId,window, 880, 680);
}

function doSelectUserSingle(nameCtlId, valueCtlId)
{
    var val = popModalWin("../../SysSetting/Group/User/UserListForm.aspx?PageType=SingleSelect&ValueCtlId=" + valueCtlId + "&NameCtlId=" + nameCtlId,window, 880, 680);
}

function doSelectUserMulti(nameCtlId, valueCtlId)
{
    var val = popModalWin("../../SysSetting/Group/User/UserListForm.aspx?PageType=MultiSelect&ValueCtlId=" + valueCtlId + "&NameCtlId=" + nameCtlId,window, 880, 680);
}

function doSelectUnitSingle(nameCtlId, valueCtlId)
{
    var val = popModalWin("../../SysSetting/Group/Unit/UnitListForm.aspx?PageType=SingleSelect&ValueCtlId=" + valueCtlId + "&NameCtlId=" + nameCtlId,window, 880, 680);
}

function doSelectUnitMulti(nameCtlId, valueCtlId)
{
    var val = popModalWin("../../SysSetting/Group/Unit/UnitListForm.aspx?PageType=MultiSelect&ValueCtlId=" + valueCtlId + "&NameCtlId=" + nameCtlId,window, 880, 680);
}

//设置指定控件值
function setControlValue(ctlID,ctlValue)
{
    var ctl = document.getElementById(ctlID);
    if(ctl != null)
    {
        ctl.value = ctlValue;
    }
}
//清除指定控件值
function doClearCtlContent(ctlId)
{
    var ctl = document.getElementById(ctlId);
    if(ctl != null)
    {
        ctl.value = "";
    }
}

//刷新父窗体
function refreshParentData()
{
    if(window.parent.opener != null) 
        window.parent.opener.location.href =window.parent.opener.location.href;
}

// 判断是否有选择项选中(单行记录)
function CheckSelectSingle()
{
    var objArray = document.getElementsByTagName('input');
    if(objArray != null)
    {
        var n = 0;
        for(var i = 0;i< objArray.length;i++)
        {
            if(objArray[i].type == "checkbox")
            {
                if(objArray[i].checked == true)
                n += 1;
            }
        }
        if(n == 1)
            return true;
        else
        {
            window.alert('请选择单行记录，再进行复制操作');
            return false;
        }
    }
    return false;
}  

//向父窗口提交选择的值
function SubmitSelectResult()
{
//   debugger;		  
    var valueStr = window.frames["frameList"].document.getElementById("hidSelectedValue").value;
    if(valueStr != "")
    {
        var nameStr = window.frames["frameList"].document.getElementById("hidSelectedName").value;  
        var ctlID = document.getElementById("hidCtlID").value;  
        if(window.parent.dialogArguments != null) //use showModalDialog() and ModalDialogFrame.aspx
        {
            var rootParentWin = window.parent.dialogArguments;
            if(rootParentWin == null) return;

            var nameCtl = rootParentWin.document.getElementById(ctlID.split(",")[1]);
            if(nameCtl != null) nameCtl.value = nameStr;

            var valueCtl = rootParentWin.document.getElementById(ctlID.split(",")[0]);
            if(valueCtl != null) valueCtl.value = valueStr;		    


            window.parent.returnValue = true;			    
            window.parent.close();
        }
        else //use window.open()
        {
            if(window.opener == null) return;

            var nameCtl = window.opener.document.getElementById(ctlID.split(",")[1]);
            if(nameCtl != null) nameCtl.value = nameStr;

            var valueCtl = window.opener.document.getElementById(ctlID.split(",")[0]);
            if(valueCtl != null) valueCtl.value = valueStr;		   

            window.close();			        
        }
    }
    else
    { alert("请选择记录后，再进行该操作。"); }			
}

function alertMsg(ctlName)
{
    var objMsg = document.getElementById(ctlName);
    if(objMsg != null)
    {
        if(objMsg.value != "")
        {
            alert(objMsg.value);
            objMsg.value = "";
        }
    }
}

/*选项卡更换显示样式*/
function setTab(name, cursel, n) {
    for (i = 1; i <= n; i++) {
        var menu = document.getElementById(name + i);
        var con = document.getElementById("con_" + name + "_" + i);
        menu.className = i == cursel ? "hover" : "";
        con.style.display = i == cursel ? "block" : "none";
    }
}