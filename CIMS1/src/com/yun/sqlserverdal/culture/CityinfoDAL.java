
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:19:53
   功能说明: 表t_cityinfo 城市的实体类CityinfoInfo的数据层基类
   表说明:城市
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
 * 表 t_cityinfo 城市 的实体CityinfoInfo的数据操作类
 * @author 贾军磊
 *
 */
public class CityinfoDAL extends CityinfoDALBase
{
  // [start] CityinfoDAL
	public CityinfoDAL()
	{
		super();
	}

	public CityinfoDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}