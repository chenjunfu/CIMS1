
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:55
   功能说明: 表t_shb 的实体类ShbInfo的数据层基类
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
 * 表 t_shb  的实体ShbInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ShbDAL extends ShbDALBase
{
  // [start] ShbDAL
	public ShbDAL()
	{
		super();
	}

	public ShbDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}