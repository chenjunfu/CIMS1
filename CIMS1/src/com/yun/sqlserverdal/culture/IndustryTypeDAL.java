
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:23:54
   功能说明: 表t_industry_type 产业项目类别类别表的实体类IndustryTypeInfo的数据层基类
   表说明:产业项目类别类别表
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
 * 表 t_industry_type 产业项目类别类别表 的实体IndustryTypeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryTypeDAL extends IndustryTypeDALBase
{
  // [start] IndustryTypeDAL
	public IndustryTypeDAL()
	{
		super();
	}

	public IndustryTypeDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}