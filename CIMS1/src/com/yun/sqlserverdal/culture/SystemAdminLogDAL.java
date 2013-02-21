
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:26:21
   功能说明: 表t_system_admin_log 管理人员日志表的实体类SystemAdminLogInfo的数据层基类
   表说明:管理人员日志表
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
 * 表 t_system_admin_log 管理人员日志表 的实体SystemAdminLogInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemAdminLogDAL extends SystemAdminLogDALBase
{
  // [start] SystemAdminLogDAL
	public SystemAdminLogDAL()
	{
		super();
	}

	public SystemAdminLogDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}