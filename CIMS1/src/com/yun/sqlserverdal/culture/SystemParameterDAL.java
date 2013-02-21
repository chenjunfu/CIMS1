
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:26:48
   功能说明: 表t_system_parameter 的实体类SystemParameterInfo的数据层基类
   表说明:
======================================================================*/
package com.yun.sqlserverdal.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.base.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * 表 t_system_parameter  的实体SystemParameterInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemParameterDAL extends SystemParameterDALBase
{
  // [start] SystemParameterDAL
	public SystemParameterDAL()
	{
		super();
	}

	public SystemParameterDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
	public int GetMaxID()
	{	
		int result=0;
		getDP().ClearParameter();
		result=(Integer)getDP().RunSqlScalar("select top 1 databaseid from t_system_parameter order by databaseid desc");
		getDP().Dispose();
		return result;
		
	}
  // [end]

}