//ʹ�÷���
////���ڳ���
//var jjlCity=new c02_class_ld(arrCity,"Drp_ProvinceID_Edit","Drp_CityID_Edit"); //��������Դ
//jjlCity.init("0","","");//��ʼ������Դ

//����Դ
//var arrCity=new Array();
////���ݸ�ʽ ID������ID������
//arrCity[0]=new Array("972","831","������");


function c02_class_ld(array,obj1,obj2)
{
	//���飬����������Դ
	this.array=array; 
	this.obj1=document.getElementById(obj1);
	this.obj2=document.getElementById(obj2);
	
	this.init=function(indexName,selectName1,selectName2)
	{
        /// <summary>
        /// ��ʼ��������
        /// </summary>
        /// <param name="indexName">ָѡ����</param>
        /// <param name="selectName1">������1ѡ����Ŀ</param>
        /// <param name="selectName2">������2ѡ����Ŀ</param>
        
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

	// indexNameָѡ����,selectNameָselect��ID
	this.optionChange=function (indexName,obj)
	{
        /// <summary>
        /// ������ı�ʱ������
        /// </summary>
        /// <param name="indexName">ָѡ����</param>
        /// <param name="obj">������</param>
		obj.length=0;
		//obj.options[0]=new Option("��ѡ��",'');
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
        /// ͨ������IDѡ����
        /// </summary>
        /// <param name="ParentID">����ID</param>
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
        /// ͨ��Ŀ¼IDѡ����
        /// </summary>
        /// <param name="ThisID">Ŀ¼ID</param>
		for(var i=0;i<this.array.length;i++)
		{
			if(this.array[i][0]==ThisID)
			{
			    return this.array[i];
			}
		}
	}
	
}