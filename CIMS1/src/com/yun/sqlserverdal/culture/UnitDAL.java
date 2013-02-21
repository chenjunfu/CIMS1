
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:27:29
   功能说明: 表t_unit 单位信息的实体类UnitInfo的数据层基类
   表说明:单位信息
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
 * 表 t_unit 单位信息 的实体UnitInfo的数据操作类
 * @author 贾军磊
 *
 */
public class UnitDAL extends UnitDALBase
{
  // [start] UnitDAL
	public UnitDAL()
	{
		super();
	}

	public UnitDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}