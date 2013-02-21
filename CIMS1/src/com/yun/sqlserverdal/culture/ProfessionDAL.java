
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:19
   功能说明: 表t_profession 行业类别表的实体类ProfessionInfo的数据层基类
   表说明:行业类别表
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
 * 表 t_profession 行业类别表 的实体ProfessionInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProfessionDAL extends ProfessionDALBase
{
  // [start] ProfessionDAL
	public ProfessionDAL()
	{
		super();
	}

	public ProfessionDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]
    // [start] GetListByBusinessdatabaseidReturnSQL
    /**
    * 根据 <br />
* BusinessdatabaseID Businessdatabaseid 数据库ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:38:09
    * @param Businessdatabaseid 数据库ID 
    * @return SQL语句 
    */
    public String GetListByBusinessdatabaseidReturnSQL(int Businessdatabaseid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_profession]\n");
        boolean isWhere = true;

        //数据库ID
        if (Businessdatabaseid != 0)
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
        sbStr.append("	 [BusinessdatabaseID] = ?\n");//-- 数据库ID
        getDP().AddNewParameter("Businessdatabaseid",Businessdatabaseid ); // 数据库ID
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
        sbStr.append("		[BusinessdatabaseID] DESC \n");//数据库ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByBusinessdatabaseid
    /**
    * 根据 <br />
* BusinessdatabaseID Businessdatabaseid 数据库ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:38:09
    * @param Businessdatabaseid 数据库ID 
    * @return 数据列表的强类型实体类 
    */
    public ProfessionInfoCollection GetListByBusinessdatabaseid(int Businessdatabaseid, String OrderBy)
    {
        ProfessionInfoCollection list = new ProfessionInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByBusinessdatabaseidReturnSQL(Businessdatabaseid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new ProfessionInfo(rs));
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
    // [start] GetListByBusinessdatabaseid
    /**
    * 根据 <br />
* BusinessdatabaseID Businessdatabaseid 数据库ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:38:09
    * @param Businessdatabaseid 数据库ID 
    * @return 数据列表的强类型实体类 
    */
    public ProfessionInfoCollection GetListByBusinessdatabaseid(int Businessdatabaseid)
    {
        return GetListByBusinessdatabaseid(Businessdatabaseid, "");
    }
    // [end]
    // [start] GetListByBusinesstypeidReturnSQL
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 企业所属行业ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 09:44:33
    * @param Businesstypeid 企业所属行业ID 
    * @return SQL语句 
    */
    public String GetListByBusinesstypeidReturnSQL(int Businesstypeid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_profession]\n");
        boolean isWhere = true;

        //企业所属行业ID
        if (Businesstypeid != 0)
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
        sbStr.append("	 [BusinessTypeID] = ?\n");//-- 企业所属行业ID
        getDP().AddNewParameter("Businesstypeid",Businesstypeid ); // 企业所属行业ID
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
        sbStr.append("		[BusinessdatabaseID] DESC \n");//数据库ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 企业所属行业ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 09:44:33
    * @param Businesstypeid 企业所属行业ID 
    * @return 数据列表的强类型实体类 
    */
    public ProfessionInfoCollection GetListByBusinesstypeid(int Businesstypeid, String OrderBy)
    {
        ProfessionInfoCollection list = new ProfessionInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.ProfessionInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByBusinesstypeidReturnSQL(Businesstypeid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new ProfessionInfo(rs));
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
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 企业所属行业ID<br />
返回表t_profession 行业类别表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 09:44:33
    * @param Businesstypeid 企业所属行业ID 
    * @return 数据列表的强类型实体类 
    */
    public ProfessionInfoCollection GetListByBusinesstypeid(int Businesstypeid)
    {
        return GetListByBusinesstypeid(Businesstypeid, "");
    }
    // [end]


}