
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:18:56
   功能说明: 表t_age 年龄段表的实体类AgeInfo的数据层基类
   表说明:年龄段表
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
 * 表 t_age 年龄段表 的实体AgeInfo的数据操作类
 * @author 贾军磊
 *
 */
public class AgeDAL extends AgeDALBase
{
  // [start] AgeDAL
	public AgeDAL()
	{
		super();
	}

	public AgeDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]
    // [start] GetListByAgedatabaseidReturnSQL
    /**
    * 根据 <br />
* AgedatabaseID Agedatabaseid AgedatabaseID<br />
返回表t_age 年龄段表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:42:31
    * @param Agedatabaseid AgedatabaseID 
    * @return SQL语句 
    */
    public String GetListByAgedatabaseidReturnSQL(int Agedatabaseid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_age]\n");
        boolean isWhere = true;

        //AgedatabaseID
        if (Agedatabaseid != 0)
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
        sbStr.append("	 [AgedatabaseID] = ?\n");//-- AgedatabaseID
        getDP().AddNewParameter("Agedatabaseid",Agedatabaseid ); // AgedatabaseID
        }
        if (OrderBy.trim().length() > 0)
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append(OrderBy);
        sbStr.append("\n");
        }
        else
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append("		[AgedatabaseID] DESC \n");//AgedatabaseID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByAgedatabaseid
    /**
    * 根据 <br />
* AgedatabaseID Agedatabaseid AgedatabaseID<br />
返回表t_age 年龄段表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:42:31
    * @param Agedatabaseid AgedatabaseID 
    * @return 数据列表的强类型实体类 
    */
    public AgeInfoCollection GetListByAgedatabaseid(int Agedatabaseid, String OrderBy)
    {
        AgeInfoCollection list = new AgeInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.AgeInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByAgedatabaseidReturnSQL(Agedatabaseid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new AgeInfo(rs));
        }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
        }
        getDP().Dispose();
        return list;
    }
    // [end]
    // [start] GetListByAgedatabaseid
    /**
    * 根据 <br />
* AgedatabaseID Agedatabaseid AgedatabaseID<br />
返回表t_age 年龄段表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:42:31
    * @param Agedatabaseid AgedatabaseID 
    * @return 数据列表的强类型实体类 
    */
    public AgeInfoCollection GetListByAgedatabaseid(int Agedatabaseid)
    {
        return GetListByAgedatabaseid(Agedatabaseid, "");
    }
    // [end]


}