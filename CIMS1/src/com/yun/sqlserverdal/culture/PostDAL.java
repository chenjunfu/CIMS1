
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:05
   功能说明: 表t_post 职称表的实体类PostInfo的数据层基类
   表说明:职称表
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
 * 表 t_post 职称表 的实体PostInfo的数据操作类
 * @author 贾军磊
 *
 */
public class PostDAL extends PostDALBase
{
  // [start] PostDAL
	public PostDAL()
	{
		super();
	}

	public PostDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]
    // [start] GetListByTitledatabaseidReturnSQL
    /**
    * 根据 <br />
* TitledatabaseID Titledatabaseid TitledatabaseID<br />
返回表t_post 职称表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:47:32
    * @param Titledatabaseid TitledatabaseID 
    * @return SQL语句 
    */
    public String GetListByTitledatabaseidReturnSQL(int Titledatabaseid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.PostInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_post]\n");
        boolean isWhere = true;

        //TitledatabaseID
        if (Titledatabaseid != 0)
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
        sbStr.append("	 [TitledatabaseID] = ?\n");//-- TitledatabaseID
        getDP().AddNewParameter("Titledatabaseid",Titledatabaseid ); // TitledatabaseID
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
        sbStr.append("		[TitledatabaseID] DESC \n");//TitledatabaseID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByTitledatabaseid
    /**
    * 根据 <br />
* TitledatabaseID Titledatabaseid TitledatabaseID<br />
返回表t_post 职称表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:47:32
    * @param Titledatabaseid TitledatabaseID 
    * @return 数据列表的强类型实体类 
    */
    public PostInfoCollection GetListByTitledatabaseid(int Titledatabaseid, String OrderBy)
    {
        PostInfoCollection list = new PostInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.PostInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByTitledatabaseidReturnSQL(Titledatabaseid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new PostInfo(rs));
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
    // [start] GetListByTitledatabaseid
    /**
    * 根据 <br />
* TitledatabaseID Titledatabaseid TitledatabaseID<br />
返回表t_post 职称表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:47:32
    * @param Titledatabaseid TitledatabaseID 
    * @return 数据列表的强类型实体类 
    */
    public PostInfoCollection GetListByTitledatabaseid(int Titledatabaseid)
    {
        return GetListByTitledatabaseid(Titledatabaseid, "");
    }
    // [end]


}