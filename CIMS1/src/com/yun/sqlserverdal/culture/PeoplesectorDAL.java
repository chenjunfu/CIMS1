
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:24:55
   功能说明: 表t_peoplesector 部门信息表的实体类PeoplesectorInfo的数据层基类
   表说明:部门信息表
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
 * 表 t_peoplesector 部门信息表 的实体PeoplesectorInfo的数据操作类
 * @author 贾军磊
 *
 */
public class PeoplesectorDAL extends PeoplesectorDALBase
{
  // [start] PeoplesectorDAL
	public PeoplesectorDAL()
	{
		super();
	}

	public PeoplesectorDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}