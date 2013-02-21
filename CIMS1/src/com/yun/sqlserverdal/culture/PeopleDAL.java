
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:24:29
   功能说明: 表t_people 人员表的实体类PeopleInfo的数据层基类
   表说明:人员表
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
 * 表 t_people 人员表 的实体PeopleInfo的数据操作类
 * @author 贾军磊
 *
 */
public class PeopleDAL extends PeopleDALBase
{
  // [start] PeopleDAL
	public PeopleDAL()
	{
		super();
	}

	public PeopleDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}