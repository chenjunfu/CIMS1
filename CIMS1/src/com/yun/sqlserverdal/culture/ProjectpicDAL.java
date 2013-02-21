
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:27
   功能说明: 表t_projectpic 项目图片表的实体类ProjectpicInfo的数据层基类
   表说明:项目图片表
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
 * 表 t_projectpic 项目图片表 的实体ProjectpicInfo的数据操作类
 * @author 贾军磊
 *
 */
public class ProjectpicDAL extends ProjectpicDALBase
{
  // [start] ProjectpicDAL
	public ProjectpicDAL()
	{
		super();
	}

	public ProjectpicDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]
	
    // [start] GetProjectpicInfoByDatabaseprojectidReturnSQL
    /**
    * 根据 <br />
项目编号,DatabaseProjectID 获取表t_projectpic 项目图片表的SQL语句
    * 开发者 贾军磊 2012年12月22日 17:43:22
    * @param Databaseprojectid 项目编号 
    * @return SQL语句 
    */
    public String GetListPagerByDatabaseprojectidReturnSQL(int Databaseprojectid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_projectpic]\n");
        }
        else
        {
            sbStr.append("	DECLARE @PageLowerBound int \n");//获得需要分页的低段数量
            sbStr.append("	DECLARE @PageUpperBound int \n");//获得需要分页的高端数量
            sbStr.append("	SET @PageLowerBound = ? * (?-1)\n");
        getDP().AddNewParameter("@PageSize", pageSize);
        getDP().AddNewParameter("@PageIndex", pageIndex);
            sbStr.append("	SET @PageUpperBound = @PageLowerBound + ?\n");
        getDP().AddNewParameter("@PageSize", pageSize);
            sbStr.append("	SELECT * FROM (\n");
            sbStr.append("		SELECT TOP (@PageUpperBound)\n");
            sbStr.append("		ROW_NUMBER() OVER (\n");
        if (OrderBy.trim().length() > 0)
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append(OrderBy);
        sbStr.append("\n");
        }
        else
        {
            sbStr.append("		ORDER BY\n");
            sbStr.append("		[ProjectPicID] DESC \n");//项目图片编号
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.ProjectpicInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_projectpic]\n");
        }

        boolean isWhere = true;

        //项目编号
        if (Databaseprojectid != 0)
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
        sbStr.append("	 [DatabaseProjectID] = ?\n");//-- 项目编号
        getDP().AddNewParameter("Databaseprojectid",Databaseprojectid ); // 项目编号
        }

        if (!isCount)
        {

            sbStr.append("		) AS Pager\n");
            sbStr.append("	WHERE\n");
            sbStr.append("	Pager.RowIndex > @PageLowerBound\n");
            sbStr.append("	and Pager.RowIndex <= @PageUpperBound\n");
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
返回表t_projectpic 项目图片表的数据列表<br />
    * 开发者 贾军磊 2012年12月22日 17:43:22
    * @param Databaseprojectid 项目编号 
    * @return 数据列表的强类型实体类 
    */
    public ProjectpicInfoCollection GetListPagerByDatabaseprojectid(int Databaseprojectid, String OrderBy,int pageIndex, int pageSize)
    {
        ProjectpicInfoCollection list = new ProjectpicInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.ProjectpicInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByDatabaseprojectidReturnSQL(Databaseprojectid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new ProjectpicInfo(rs));
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
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
返回表t_projectpic 项目图片表的数据列表<br />
    * 开发者 贾军磊 2012年12月22日 17:43:22
    * @param Databaseprojectid 项目编号 
    * @return 数据列表的强类型实体类 
    */
    public ProjectpicInfoCollection GetListPagerByDatabaseprojectid(int Databaseprojectid, int pageIndex, int pageSize)
    {
       return GetListPagerByDatabaseprojectid(Databaseprojectid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
统计表t_projectpic 项目图片表的数据量<br />
    * 开发者 贾军磊 2012年12月22日 17:43:22
    * @param Databaseprojectid 项目编号 
    * @return 数据总量 
    */
    public int GetListPagerByDatabaseprojectid(int Databaseprojectid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByDatabaseprojectidReturnSQL(Databaseprojectid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByDatabaseprojectid
    /**
    * 根据 <br />
* DatabaseProjectID Databaseprojectid 项目编号<br />
统计表t_projectpic 项目图片表的数据量<br />
    * 开发者 贾军磊 2012年12月22日 17:43:22
    * @param Databaseprojectid 项目编号 
    * @return 数据总量 
    */
    public int GetListPagerByDatabaseprojectid(int Databaseprojectid)
    {
        return GetListPagerByDatabaseprojectid(Databaseprojectid,  "");
    }
    // [end]


}