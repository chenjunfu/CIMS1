
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:21:09
   功能说明: 表t_enterprist_quality 企业性质表的实体类EnterpristQualityInfo的数据层基类
   表说明:企业性质表
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
 * 表 t_enterprist_quality 企业性质表 的实体EnterpristQualityInfo的数据操作类
 * @author 贾军磊
 *
 */
public class EnterpristQualityDAL extends EnterpristQualityDALBase
{
  // [start] EnterpristQualityDAL
	public EnterpristQualityDAL()
	{
		super();
	}

	public EnterpristQualityDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}