
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:26:32
   功能说明: 表t_system_competence 权限表的实体类SystemCompetenceInfo的数据层基类
   表说明:权限表
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
 * 表 t_system_competence 权限表 的实体SystemCompetenceInfo的数据操作类
 * @author 贾军磊
 *
 */
public class SystemCompetenceDAL extends SystemCompetenceDALBase
{
  // [start] SystemCompetenceDAL
	public SystemCompetenceDAL()
	{
		super();
	}

	public SystemCompetenceDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
    // [start] GetListByCompetenceidReturnSQL
    /**
    * 根据 <br />
* CompetenceID Competenceid 权限编号<br />
返回表t_system_competence 权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月12日 10:23:04
    * @param Competenceid 权限编号 
    * @return SQL语句 
    */
    public String GetListByCompetenceidReturnSQL(int Competenceid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.SystemCompetenceInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_system_competence]\n");
        boolean isWhere = true;

        //权限编号
        if (Competenceid != 0)
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
        sbStr.append("	 [CompetenceID] Like ? + '%'\n");//-- 权限编号
        getDP().AddNewParameter("Competenceid",String.valueOf(Competenceid) ); // 权限编号
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
        sbStr.append("		[DatabaseCompetenceID] DESC \n");//权限ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByCompetenceid
    /**
    * 根据 <br />
* CompetenceID Competenceid 权限编号<br />
返回表t_system_competence 权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月12日 10:23:04
    * @param Competenceid 权限编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemCompetenceInfoCollection GetListByCompetenceid(int Competenceid, String OrderBy)
    {
        SystemCompetenceInfoCollection list = new SystemCompetenceInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.SystemCompetenceInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByCompetenceidReturnSQL(Competenceid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new SystemCompetenceInfo(rs));
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
    // [start] GetListByCompetenceid
    /**
    * 根据 <br />
* CompetenceID Competenceid 权限编号<br />
返回表t_system_competence 权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月12日 10:23:04
    * @param Competenceid 权限编号 
    * @return 数据列表的强类型实体类 
    */
    public SystemCompetenceInfoCollection GetListByCompetenceid(int Competenceid)
    {
        return GetListByCompetenceid(Competenceid, "");
    }
    // [end]

  // [end]

}