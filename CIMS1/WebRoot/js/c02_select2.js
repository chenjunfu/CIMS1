//使用方法
////所在城市
//var jjlCity=new c02_class_ld(arrCity,"Drp_ProvinceID_Edit","Drp_CityID_Edit"); //设置数据源
//jjlCity.init("0","","");//初始化数据源

//数据源
//var arrCity=new Array();
////数据格式 ID，父级ID，名称
//arrCity[0]=new Array("972","831","拱墅区");


function c02_class_ld(array,obj1,obj2)
{
	//数组，联动的数据源
	this.array=array; 
	this.obj1=document.getElementById(obj1);
	this.obj2=document.getElementById(obj2);
	
	this.init=function(indexName,selectName1,selectName2)
	{
        /// <summary>
        /// 初始化下拉框
        /// </summary>
        /// <param name="indexName">指选中项</param>
        /// <param name="selectName1">下拉框1选择项目</param>
        /// <param name="selectName2">下拉框2选择项目</param>
        
        if(selectName1 == "" && selectName2 != "")
        {
            selectName1=this.selectItemByThisID(selectName2)[1];
        }
        
		this.optionChange(indexName,this.obj1)
	    this.obj1.value = selectName1;
		
	    this.optionChange(selectName1,this.obj2)
	    this.obj2.value = selectName2;
	    
	    
		var me=this;
	    this.obj1.onchange=function()
	    {
		    me.optionChange(me.obj1.value,me.obj2)
	    }
		
		
	    this.obj2.onchange=function()
	    {
		    me.optionChange(me.obj2.value)
	    }
	}

	// indexName指选中项,selectName指select的ID
	this.optionChange=function (indexName,obj)
	{
        /// <summary>
        /// 下拉框改变时的条件
        /// </summary>
        /// <param name="indexName">指选中项</param>
        /// <param name="obj">下拉框</param>
		obj.length=0;
		//obj.options[0]=new Option("请选择",'');
		for(var i=0;i<this.array.length;i++)
		{
			if(this.array[i][1]==indexName)
			{
				//alert(this.array[i][1]+" "+indexName);
				obj.options[obj.length]=new Option(this.array[i][2],this.array[i][0]);
			}
		}
	}

	this.selectItemByParentID=function (ParentID)
	{
        /// <summary>
        /// 通过父级ID选择行
        /// </summary>
        /// <param name="ParentID">父级ID</param>
		for(var i=0;i<this.array.length;i++)
		{
			if(this.array[i][1]==ParentID)
			{
			    return this.array[i];
			}
		}
	}

	this.selectItemByThisID=function (ThisID)
	{
        /// <summary>
        /// 通过目录ID选择行
        /// </summary>
        /// <param name="ThisID">目录ID</param>
		for(var i=0;i<this.array.length;i++)
		{
			if(this.array[i][0]==ThisID)
			{
			    return this.array[i];
			}
		}
	}
	
}