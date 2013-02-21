
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:25:46
   功能说明: 表t_roles_competence 角色权限表的实体类RolesCompetenceInfo的数据层基类
   表说明:角色权限表
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
 * 表 t_roles_competence 角色权限表 的实体RolesCompetenceInfo的数据操作类
 * @author 贾军磊
 *
 */
public class RolesCompetenceDAL extends RolesCompetenceDALBase
{
  // [start] RolesCompetenceDAL
	public RolesCompetenceDAL()
	{
		super();
	}

	public RolesCompetenceDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
	
    // [start] GetRolesCompetenceInfoByRolesidReturnSQL
    /**
    * 根据 <br />
角色ID,RolesID 获取表t_roles_competence 角色权限表的SQL语句
    * 开发者 贾军磊 2012年12月04日 09:29:10
    * @param Rolesid 角色ID 
    * @return SQL语句 
    */
    public String GetListPagerByRolesidReturnSQL(int Rolesid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_roles_competence]\n");
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
            sbStr.append("		[DatabaseRoseCompetenceID] DESC \n");//角色权限ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.RolesCompetenceInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_roles_competence]\n");
        }

        boolean isWhere = true;

        //角色ID
        if (Rolesid != 0)
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
        sbStr.append("	 [RolesID] = ?\n");//-- 角色ID
        getDP().AddNewParameter("Rolesid",Rolesid ); // 角色ID
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
    // [start] GetListPagerByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色ID<br />
返回表t_roles_competence 角色权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 09:29:10
    * @param Rolesid 角色ID 
    * @return 数据列表的强类型实体类 
    */
    public RolesCompetenceInfoCollection GetListPagerByRolesid(int Rolesid, String OrderBy,int pageIndex, int pageSize)
    {
        RolesCompetenceInfoCollection list = new RolesCompetenceInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.RolesCompetenceInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByRolesidReturnSQL(Rolesid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new RolesCompetenceInfo(rs));
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
    // [start] GetListPagerByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色ID<br />
返回表t_roles_competence 角色权限表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 09:29:10
    * @param Rolesid 角色ID 
    * @return 数据列表的强类型实体类 
    */
    public RolesCompetenceInfoCollection GetListPagerByRolesid(int Rolesid, int pageIndex, int pageSize)
    {
       return GetListPagerByRolesid(Rolesid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色ID<br />
统计表t_roles_competence 角色权限表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 09:29:10
    * @param Rolesid 角色ID 
    * @return 数据总量 
    */
    public int GetListPagerByRolesid(int Rolesid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByRolesidReturnSQL(Rolesid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByRolesid
    /**
    * 根据 <br />
* RolesID Rolesid 角色ID<br />
统计表t_roles_competence 角色权限表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 09:29:10
    * @param Rolesid 角色ID 
    * @return 数据总量 
    */
    public int GetListPagerByRolesid(int Rolesid)
    {
        return GetListPagerByRolesid(Rolesid,  "");
    }
    // [end]

  // [end]

}