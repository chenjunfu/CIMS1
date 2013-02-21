
//document.getElementById("tbListSelect").style.display="none";
function tbListSelectShowHidden(obj)
{
 if(obj.value=='显示条件'){obj.value='隐藏条件';document.getElementById('tbListSelect').style.display='';}
 else{obj.value='显示条件';document.getElementById('tbListSelect').style.display='none';}
}
function dgItemItemStyleonmouseover(obj)
{
	if (obj.className == 'dgItemItemStyle')
		obj.className = 'dgSelectedStyle0';
	if (obj.className == 'dgAlternatingItemStyle')
		obj.className = 'dgSelectedStyle1';
}
function dgItemItemStyleonmouseout(obj)
{
	if (obj.className == 'dgSelectedStyle0')
		obj.className = 'dgItemItemStyle';
	if (obj.className == 'dgSelectedStyle1')
		obj.className = 'dgAlternatingItemStyle';
}


function TbRowInterlacedColor(TbRow)
{
	if (TbRow != null)
	{
		// document.write("Hello <br />");
		for (var i = 1; i < TbRow.rows.length; i++)
		{
			TbRow.rows[i].onmouseover = function(){dgItemItemStyleonmouseover(this);}
			TbRow.rows[i].onmouseout = function(){dgItemItemStyleonmouseout(this);}
			if (TbRow.rows[i].rowIndex % 2 == 1)
			{
				// TbRow.rows[i].style.backgroundColor="#ffffff";
				TbRow.rows[i].className = "dgItemItemStyle";
			}
			else
			{
				// TbRow.rows[i].style.backgroundColor="#CCCCCC";
				TbRow.rows[i].className = "dgAlternatingItemStyle";
			}
			TbRow.rows[i].style.textAlign="left";
		}
	}
}
TbRowInterlacedColor(document.getElementById("tbList"));