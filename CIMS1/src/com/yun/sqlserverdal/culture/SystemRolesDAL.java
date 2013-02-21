
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:26:59
   功能说明: 表t_system_roles 角色表的实体类SystemRolesInfo的数据层基类
   表说明:角色表
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
 * 表 t_system_roles 角色表 的实体SystemRolesInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemRolesDAL extends SystemRolesDALBase
{
  // [start] SystemRolesDAL
	public SystemRolesDAL()
	{
		super();
	}

	public SystemRolesDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}