
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:20:21
   功能说明: 表t_dictionary 的实体类DictionaryInfo的数据层基类
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
 * 表 t_dictionary  的实体DictionaryInfo的数据操作类
 * @author 贾军磊
 *
 */
public class DictionaryDAL extends DictionaryDALBase
{
  // [start] DictionaryDAL
	public DictionaryDAL()
	{
		super();
	}

	public DictionaryDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}