
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:27:17
   功能说明: 表t_talent_profession 人才所属行业的实体类TalentProfessionInfo的数据层基类
   表说明:人才所属行业
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
 * 表 t_talent_profession 人才所属行业 的实体TalentProfessionInfo的数据操作类
 * @author 贾军磊
 *
 */
public class TalentProfessionDAL extends TalentProfessionDALBase
{
  // [start] TalentProfessionDAL
	public TalentProfessionDAL()
	{
		super();
	}

	public TalentProfessionDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}