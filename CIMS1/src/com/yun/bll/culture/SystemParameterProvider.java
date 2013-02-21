/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:32:32
   功能说明: 表t_system_parameter 的业务类SystemParameterInfo的业务层
   表说明:
======================================================================*/
package com.yun.bll.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;
import com.yun.bll.culture.base.*;


/**
 * 表SystemParameter 的实体SystemParameterInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemParameterProvider extends SystemParameterProviderBase
{

	public static int GetMaxDatabaseID() {
		// TODO Auto-generated method stub
		SystemParameterDAL dal=new  SystemParameterDAL();
		return dal.GetMaxID();
	}
	
}