
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:22:08
   功能说明: 表t_industry_dutyunit 主管单位表的实体类IndustryDutyunitInfo的数据层基类
   表说明:主管单位表
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
 * 表 t_industry_dutyunit 主管单位表 的实体IndustryDutyunitInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryDutyunitDAL extends IndustryDutyunitDALBase
{
  // [start] IndustryDutyunitDAL
	public IndustryDutyunitDAL()
	{
		super();
	}

	public IndustryDutyunitDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]

}