
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:23
   功能说明: 表t_project_quality 项目性质的实体类ProjectQualityInfo的数据层基类
   表说明:项目性质
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
 * 表 t_project_quality 项目性质 的实体ProjectQualityInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProjectQualityDAL extends ProjectQualityDALBase
{
  // [start] ProjectQualityDAL
	public ProjectQualityDAL()
	{
		super();
	}

	public ProjectQualityDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}