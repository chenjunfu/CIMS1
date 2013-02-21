
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:20:12
   功能说明: 表t_degree 的实体类DegreeInfo的数据层基类
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
 * 表 t_degree  的实体DegreeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class DegreeDAL extends DegreeDALBase
{
  // [start] DegreeDAL
	public DegreeDAL()
	{
		super();
	}

	public DegreeDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
    // [start] CountByDegreeidReturnSQL
    /**
    * 根据 <br />
* DegreeID Degreeid DegreeID<br />
统计表t_degree 的数据量<br />
    * 开发者 贾军磊 2013年01月15日 14:31:02
    * @param Degreeid DegreeID 
    * @return SQL语句 
    */
    public String CountByDegreeidReturnSQL(int Degreeid)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT count(*) \n");
        sbStr.append("FROM [t_degree]\n");
        boolean isWhere = true;

        //DegreeID
        if (Degreeid != 0)
        {
            if (isWhere)
            {
                sbStr.append("		WHERE\n");
                isWhere = false;
            }
            else
            {
                sbStr.append("		 AND ");
            }
        sbStr.append("	 [DegreeID] = ?\n");//-- DegreeID
        getDP().AddNewParameter("Degreeid",Degreeid ); // DegreeID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] CountByDegreeid
    /**
    * 根据 <br />
* DegreeID Degreeid DegreeID<br />
统计表t_degree 的数据量<br />
    * 开发者 贾军磊 2013年01月15日 14:31:02
    * @param Degreeid DegreeID 
    * @return 数据量 
    */
    public int CountByDegreeid(int Degreeid)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDegreeidReturnSQL(Degreeid)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]

  // [end]

}