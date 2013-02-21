
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:23:50
   功能说明: 表t_industry_project 文化项目表的实体类IndustryProjectInfo的数据层基类
   表说明:文化项目表
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
 * 表 t_industry_project 文化项目表 的实体IndustryProjectInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryProjectDAL extends IndustryProjectDALBase
{
  // [start] IndustryProjectDAL
	public IndustryProjectDAL()
	{
		super();
	}

	public IndustryProjectDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]
    // [start] GetIndustryProjectInfoByProjectnameCreatetimeRegionidDutyunitidIndustryidReturnSQL
    /**
    * 根据 <br />
项目名称 创建时间 所属区域 主管单位 产业类别,ProjectName CreateTime RegionID DutyUnitID IndustryID 获取表t_industry_project 文化项目表的SQL语句
    * 开发者 贾军磊 2012年12月03日 15:13:59
    * @param Projectname 项目名称 
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @param Dutyunitid 主管单位 
    * @param Industryid 产业类别 
    * @return SQL语句 
    */
    public String GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryidReturnSQL(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_industry_project]\n");
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
            sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_industry_project]\n");
        }

        boolean isWhere = true;

        //项目名称
        if (Projectname != null && Projectname.length() > 0)
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
        sbStr.append("	 [ProjectName] = ?\n");//-- 项目名称
        getDP().AddNewParameter("Projectname",Projectname ); // 项目名称
        }
        //创建时间
        if (Createtime1 != null && Createtime2 != null && ! com.colorwinglib.Converts.DateTimeStar.equals(Createtime1) && ! com.colorwinglib.Converts.DateTimeEnd.equals(Createtime2) )
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
        sbStr.append("	 [CreateTime] between ? and ?\n");//-- 创建时间
        getDP().AddNewParameter("Createtime",Createtime1 ); // 创建时间
        getDP().AddNewParameter("Createtime",Createtime2 ); // 创建时间
        }
        //所属区域
        if (Regionid != 0)
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
        sbStr.append("	 [RegionID] = ?\n");//-- 所属区域
        getDP().AddNewParameter("Regionid",Regionid ); // 所属区域
        }
        //主管单位
        if (Dutyunitid != 0)
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
        sbStr.append("	 [DutyUnitID] = ?\n");//-- 主管单位
        getDP().AddNewParameter("Dutyunitid",Dutyunitid ); // 主管单位
        }
        //产业类别
        if (Industryid != 0)
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
        sbStr.append("	 [IndustryID] = ?\n");//-- 产业类别
        getDP().AddNewParameter("Industryid",Industryid ); // 产业类别
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
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 15:13:59
    * @param Projectname 项目名称 
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @param Dutyunitid 主管单位 
    * @param Industryid 产业类别 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid, String OrderBy,int pageIndex, int pageSize)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryidReturnSQL(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月03日 15:13:59
    * @param Projectname 项目名称 
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @param Dutyunitid 主管单位 
    * @param Industryid 产业类别 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid, int pageIndex, int pageSize)
    {
       return GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 15:13:59
    * @param Projectname 项目名称 
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @param Dutyunitid 主管单位 
    * @param Industryid 产业类别 
    * @return 数据总量 
    */
    public int GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryidReturnSQL(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
* DutyUnitID Dutyunitid 主管单位<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月03日 15:13:59
    * @param Projectname 项目名称 
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @param Dutyunitid 主管单位 
    * @param Industryid 产业类别 
    * @return 数据总量 
    */
    public int GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(String Projectname, Date Createtime1, Date Createtime2, int Regionid, int Dutyunitid, int Industryid)
    {
        return GetListPagerByProjectnameCreatetimeRegionidDutyunitidIndustryid(Projectname, Createtime1, Createtime2, Regionid, Dutyunitid, Industryid,  "");
    }
    // [end]
    // [start] GetIndustryProjectInfoByCreatetimeReturnSQL
    /**
    * 根据 <br />
创建时间,CreateTime 获取表t_industry_project 文化项目表的SQL语句
    * 开发者 贾军磊 2012年12月07日 09:31:21
    * @param Createtime 创建时间 
    * @return SQL语句 
    */
    public String GetListPagerByCreatetimeReturnSQL(Date Createtime, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_industry_project]\n");
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
            sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_industry_project]\n");
        }

        boolean isWhere = true;

        //创建时间
        if (Createtime != null)
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
        sbStr.append("	 [CreateTime] < ?\n");//-- 创建时间
        getDP().AddNewParameter("Createtime",Createtime ); // 创建时间
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
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 09:31:21
    * @param Createtime 创建时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetime(Date Createtime, String OrderBy,int pageIndex, int pageSize)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByCreatetimeReturnSQL(Createtime,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 09:31:21
    * @param Createtime 创建时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetime(Date Createtime, int pageIndex, int pageSize)
    {
       return GetListPagerByCreatetime(Createtime, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 09:31:21
    * @param Createtime 创建时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetime(Date Createtime, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByCreatetimeReturnSQL(Createtime,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 09:31:21
    * @param Createtime 创建时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetime(Date Createtime)
    {
        return GetListPagerByCreatetime(Createtime,  "");
    }
    // [end]

    // [start] GetIndustryProjectInfoByCreatetimeReturnSQL
    /**
    * 根据 <br />
创建时间,CreateTime 获取表t_industry_project 文化项目表的SQL语句
    * 开发者 贾军磊 2012年12月07日 12:45:46
    * @param Createtime 创建时间 
    * @return SQL语句 
    */
    public String GetListPagerByCreatetimeReturnSQL(Date Createtime1, Date Createtime2, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_industry_project]\n");
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
            sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_industry_project]\n");
        }

        boolean isWhere = true;

        //创建时间
        if (Createtime1 != null && Createtime2 != null && ! com.colorwinglib.Converts.DateTimeStar.equals(Createtime1) && ! com.colorwinglib.Converts.DateTimeEnd.equals(Createtime2) )
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
        sbStr.append("	 [CreateTime] between ? and ?\n");//-- 创建时间
        getDP().AddNewParameter("Createtime",Createtime1 ); // 创建时间
        getDP().AddNewParameter("Createtime",Createtime2 ); // 创建时间
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
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 12:45:46
    * @param Createtime 创建时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetime(Date Createtime1, Date Createtime2, String OrderBy,int pageIndex, int pageSize)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByCreatetimeReturnSQL(Createtime1, Createtime2,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 12:45:46
    * @param Createtime 创建时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetime(Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
       return GetListPagerByCreatetime(Createtime1, Createtime2, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 12:45:46
    * @param Createtime 创建时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetime(Date Createtime1, Date Createtime2, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByCreatetimeReturnSQL(Createtime1, Createtime2,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 12:45:46
    * @param Createtime 创建时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetime(Date Createtime1, Date Createtime2)
    {
        return GetListPagerByCreatetime(Createtime1, Createtime2,  "");
    }
    // [end]
    // [start] GetIndustryProjectInfoByCreatetimeCompletetimeReturnSQL
    /**
    * 根据 <br />
创建时间 完成时间,CreateTime CompleteTime 获取表t_industry_project 文化项目表的SQL语句
    * 开发者 贾军磊 2012年12月07日 14:21:31
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return SQL语句 
    */
    public String GetListPagerByCreatetimeCompletetimeReturnSQL(Date Createtime1, Date Createtime2, Date Completetime, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_industry_project]\n");
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
            sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_industry_project]\n");
        }

        boolean isWhere = true;

        //创建时间
        if (Createtime1 != null && Createtime2 != null && ! com.colorwinglib.Converts.DateTimeStar.equals(Createtime1) && ! com.colorwinglib.Converts.DateTimeEnd.equals(Createtime2) )
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
        sbStr.append("	 [CreateTime] between ? and ?\n");//-- 创建时间
        getDP().AddNewParameter("Createtime",Createtime1 ); // 创建时间
        getDP().AddNewParameter("Createtime",Createtime2 ); // 创建时间
        }
        //完成时间
        if (Completetime != null)
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
        sbStr.append("	 [CompleteTime] <> ?\n");//-- 完成时间
        getDP().AddNewParameter("Completetime",""); // 完成时间
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
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 14:21:31
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetimeCompletetime(Date Createtime1, Date Createtime2, Date Completetime, String OrderBy,int pageIndex, int pageSize)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByCreatetimeCompletetimeReturnSQL(Createtime1, Createtime2, Completetime,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月07日 14:21:31
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetimeCompletetime(Date Createtime1, Date Createtime2, Date Completetime, int pageIndex, int pageSize)
    {
       return GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 14:21:31
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeCompletetime(Date Createtime1, Date Createtime2, Date Completetime, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByCreatetimeCompletetimeReturnSQL(Createtime1, Createtime2, Completetime,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月07日 14:21:31
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeCompletetime(Date Createtime1, Date Createtime2, Date Completetime)
    {
        return GetListPagerByCreatetimeCompletetime(Createtime1, Createtime2, Completetime,  "");
    }
    // [start] GetIndustryProjectInfoByCreatetimeRegionidReturnSQL
    /**
    * 根据 <br />
创建时间 所属区域,CreateTime RegionID 获取表t_industry_project 文化项目表的SQL语句
    * 开发者 贾军磊 2012年12月08日 10:29:22
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @return SQL语句 
    */
    public String GetListPagerByCreatetimeRegionidReturnSQL(Date Createtime, int Regionid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_industry_project]\n");
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
            sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_industry_project]\n");
        }

        boolean isWhere = true;

        //创建时间
        if (Createtime != null)
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
        sbStr.append("	 [CreateTime] <= ?\n");//-- 创建时间
        getDP().AddNewParameter("Createtime",Createtime ); // 创建时间
        }
        //所属区域
        if (Regionid != 0)
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
        sbStr.append("	 [RegionID] = ?\n");//-- 所属区域
        getDP().AddNewParameter("Regionid",Regionid ); // 所属区域
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
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:29:22
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetimeRegionid(Date Createtime, int Regionid, String OrderBy,int pageIndex, int pageSize)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByCreatetimeRegionidReturnSQL(Createtime, Regionid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:29:22
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetimeRegionid(Date Createtime, int Regionid, int pageIndex, int pageSize)
    {
       return GetListPagerByCreatetimeRegionid(Createtime, Regionid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:29:22
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeRegionid(Date Createtime, int Regionid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByCreatetimeRegionidReturnSQL(Createtime, Regionid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:29:22
    * @param Createtime 创建时间 
    * @param Regionid 所属区域 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeRegionid(Date Createtime, int Regionid)
    {
        return GetListPagerByCreatetimeRegionid(Createtime, Regionid,  "");
    }
    // [end]
    // [start] GetIndustryProjectInfoByCreatetimeIndustryidReturnSQL
    /**
    * 根据 <br />
创建时间 产业类别,CreateTime IndustryID 获取表t_industry_project 文化项目表的SQL语句
    * 开发者 贾军磊 2012年12月08日 10:40:54
    * @param Createtime 创建时间 
    * @param Industryid 产业类别 
    * @return SQL语句 
    */
    public String GetListPagerByCreatetimeIndustryidReturnSQL(Date Createtime, int Industryid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_industry_project]\n");
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
            sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_industry_project]\n");
        }

        boolean isWhere = true;

        //创建时间
        if (Createtime != null)
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
        sbStr.append("	 [CreateTime] < ?\n");//-- 创建时间
        getDP().AddNewParameter("Createtime",Createtime ); // 创建时间
        }
        //产业类别
        if (Industryid != 0)
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
        sbStr.append("	 [IndustryID] = ?\n");//-- 产业类别
        getDP().AddNewParameter("Industryid",Industryid ); // 产业类别
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
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:40:54
    * @param Createtime 创建时间 
    * @param Industryid 产业类别 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetimeIndustryid(Date Createtime, int Industryid, String OrderBy,int pageIndex, int pageSize)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByCreatetimeIndustryidReturnSQL(Createtime, Industryid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:40:54
    * @param Createtime 创建时间 
    * @param Industryid 产业类别 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetimeIndustryid(Date Createtime, int Industryid, int pageIndex, int pageSize)
    {
       return GetListPagerByCreatetimeIndustryid(Createtime, Industryid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:40:54
    * @param Createtime 创建时间 
    * @param Industryid 产业类别 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeIndustryid(Date Createtime, int Industryid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByCreatetimeIndustryidReturnSQL(Createtime, Industryid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByCreatetimeIndustryid
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* IndustryID Industryid 产业类别<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:40:54
    * @param Createtime 创建时间 
    * @param Industryid 产业类别 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeIndustryid(Date Createtime, int Industryid)
    {
        return GetListPagerByCreatetimeIndustryid(Createtime, Industryid,  "");
    }
    // [end]

    // [start] GetIndustryProjectInfo_lessthan_ByCreatetimeReturnSQL
    /**
    * 根据 <br />
创建时间,CreateTime 获取表t_industry_project 文化项目表的SQL语句
    * 开发者 贾军磊 2012年12月08日 10:48:22
    * @param Createtime 创建时间 
    * @return SQL语句 
    */
    public String GetListPager_lessthan_ByCreatetimeReturnSQL(Date Createtime, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_industry_project]\n");
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
            sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_industry_project]\n");
        }

        boolean isWhere = true;

        //创建时间
        if (Createtime != null)
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
        sbStr.append("	 [CreateTime] < ?\n");//-- 创建时间
        getDP().AddNewParameter("Createtime",Createtime ); // 创建时间
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
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:48:22
    * @param Createtime 创建时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPager_lessthan_ByCreatetime(Date Createtime, String OrderBy,int pageIndex, int pageSize)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPager_lessthan_ByCreatetimeReturnSQL(Createtime,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 10:48:22
    * @param Createtime 创建时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPager_lessthan_ByCreatetime(Date Createtime, int pageIndex, int pageSize)
    {
       return GetListPager_lessthan_ByCreatetime(Createtime, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:48:22
    * @param Createtime 创建时间 
    * @return 数据总量 
    */
    public int GetListPager_lessthan_ByCreatetime(Date Createtime, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPager_lessthan_ByCreatetimeReturnSQL(Createtime,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPager_lessthan_ByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 10:48:22
    * @param Createtime 创建时间 
    * @return 数据总量 
    */
    public int GetListPager_lessthan_ByCreatetime(Date Createtime)
    {
        return GetListPager_lessthan_ByCreatetime(Createtime,  "");
    }
    // [end]

    // [start] GetIndustryProjectInfoByCreatetimeCompletetimeReturnSQL
    /**
    * 根据 <br />
创建时间 完成时间,CreateTime CompleteTime 获取表t_industry_project 文化项目表的SQL语句
    * 开发者 贾军磊 2012年12月08日 13:23:06
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return SQL语句 
    */
    public String GetListPagerByCreatetimeCompletetimeReturnSQL(Date Createtime, Date Completetime, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_industry_project]\n");
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
            sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_industry_project]\n");
        }

        boolean isWhere = true;

        //创建时间
        if (Createtime != null)
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
        sbStr.append("	 [CreateTime] < ?\n");//-- 创建时间
        getDP().AddNewParameter("Createtime",Createtime ); // 创建时间
        }
        //完成时间
        if (Completetime != null)
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
        sbStr.append("	 [CompleteTime] <> ?\n");//-- 完成时间
        getDP().AddNewParameter("Completetime","" ); // 完成时间
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
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 13:23:06
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetimeCompletetime(Date Createtime, Date Completetime, String OrderBy,int pageIndex, int pageSize)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByCreatetimeCompletetimeReturnSQL(Createtime, Completetime,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月08日 13:23:06
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListPagerByCreatetimeCompletetime(Date Createtime, Date Completetime, int pageIndex, int pageSize)
    {
       return GetListPagerByCreatetimeCompletetime(Createtime, Completetime, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 13:23:06
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeCompletetime(Date Createtime, Date Completetime, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByCreatetimeCompletetimeReturnSQL(Createtime, Completetime,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByCreatetimeCompletetime
    /**
    * 根据 <br />
* CreateTime Createtime 创建时间<br />
* CompleteTime Completetime 完成时间<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月08日 13:23:06
    * @param Createtime 创建时间 
    * @param Completetime 完成时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeCompletetime(Date Createtime, Date Completetime)
    {
        return GetListPagerByCreatetimeCompletetime(Createtime, Completetime,  "");
    }
    // [end]
    // [start] GetListByCompletetimeReturnSQL
    /**
    * 根据 <br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月26日 11:21:29
    * @param Completetime 完成时间 
    * @return SQL语句 
    */
    public String GetListByCompletetimeReturnSQL(Date Completetime, String OrderBy, String[] ColumnNames)
    {
        	StringBuilder sbStr = new StringBuilder(1024);
        	sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_industry_project]\n");
        boolean isWhere = true;

        //完成时间
        if (Completetime != null)
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
        sbStr.append("	 [CompleteTime] < ?\n");//-- 完成时间
        getDP().AddNewParameter("Completetime",Completetime ); // 完成时间
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
        sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByCompletetime
    /**
    * 根据 <br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月26日 11:21:29
    * @param Completetime 完成时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListByCompletetime(Date Completetime, String OrderBy)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByCompletetimeReturnSQL(Completetime, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListByCompletetime
    /**
    * 根据 <br />
* CompleteTime Completetime 完成时间<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2012年12月26日 11:21:29
    * @param Completetime 完成时间 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListByCompletetime(Date Completetime)
    {
        return GetListByCompletetime(Completetime, "");
    }
    // [end]
    // [start] CountByRegionidReturnSQL
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月27日 17:45:51
    * @param Regionid 所属区域 
    * @return SQL语句 
    */
    public String CountByRegionidReturnSQL(int Regionid)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT count(*) \n");
        sbStr.append("FROM [t_industry_project]\n");
        boolean isWhere = true;

        //所属区域
        if (Regionid != 0)
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
        sbStr.append("	 [RegionID] = ?\n");//-- 所属区域
        getDP().AddNewParameter("Regionid",Regionid ); // 所属区域
        }
        return sbStr.toString();
    }
    // [end]
    // [start] CountByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2012年12月27日 17:45:51
    * @param Regionid 所属区域 
    * @return 数据量 
    */
    public int CountByRegionid(int Regionid)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByRegionidReturnSQL(Regionid)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] CountByProjectidReturnSQL
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 16:20:16
    * @param Projectid 项目编号 
    * @return SQL语句 
    */
    public String CountByProjectidReturnSQL(int Projectid)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT count(*) \n");
        sbStr.append("FROM [t_industry_project]\n");
        boolean isWhere = true;

        //项目编号
        if (Projectid != 0)
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
        sbStr.append("	 [ProjectID] = ?\n");//-- 项目编号
        getDP().AddNewParameter("Projectid",Projectid ); // 项目编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] CountByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 16:20:16
    * @param Projectid 项目编号 
    * @return 数据量 
    */
    public int CountByProjectid(int Projectid)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByProjectidReturnSQL(Projectid)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] CountByDatabaseenterpriseidReturnSQL
    /**
    * 根据 <br />
* DatabaseEnterpriseID Databaseenterpriseid 经营单位<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2013年01月15日 11:41:13
    * @param Databaseenterpriseid 经营单位 
    * @return SQL语句 
    */
    public String CountByDatabaseenterpriseidReturnSQL(int Databaseenterpriseid)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT count(*) \n");
        sbStr.append("FROM [t_industry_project]\n");
        boolean isWhere = true;

        //经营单位
        if (Databaseenterpriseid != 0)
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
        sbStr.append("	 [DatabaseEnterpriseID] = ?\n");//-- 经营单位
        getDP().AddNewParameter("Databaseenterpriseid",Databaseenterpriseid ); // 经营单位
        }
        return sbStr.toString();
    }
    // [end]
    // [start] CountByDatabaseenterpriseid
    /**
    * 根据 <br />
* DatabaseEnterpriseID Databaseenterpriseid 经营单位<br />
统计表t_industry_project 文化项目表的数据量<br />
    * 开发者 贾军磊 2013年01月15日 11:41:13
    * @param Databaseenterpriseid 经营单位 
    * @return 数据量 
    */
    public int CountByDatabaseenterpriseid(int Databaseenterpriseid)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabaseenterpriseidReturnSQL(Databaseenterpriseid)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListByProjectidReturnSQL
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 15:39:32
    * @param Projectid 项目编号 
    * @return SQL语句 
    */
    public String GetListByProjectidReturnSQL(int Projectid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_industry_project]\n");
        boolean isWhere = true;

        //项目编号
        if (Projectid != 0)
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
        sbStr.append("	 [ProjectID] = ?\n");//-- 项目编号
        getDP().AddNewParameter("Projectid",Projectid ); // 项目编号
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
        sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 15:39:32
    * @param Projectid 项目编号 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListByProjectid(int Projectid, String OrderBy)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByProjectidReturnSQL(Projectid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListByProjectid
    /**
    * 根据 <br />
* ProjectID Projectid 项目编号<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 15:39:32
    * @param Projectid 项目编号 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListByProjectid(int Projectid)
    {
        return GetListByProjectid(Projectid, "");
    }
    // [end]
    // [start] GetListByProjectnameReturnSQL
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:47:52
    * @param Projectname 项目名称 
    * @return SQL语句 
    */
    public String GetListByProjectnameReturnSQL(String Projectname, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_industry_project]\n");
        boolean isWhere = true;

        //项目名称
        if (Projectname != null && Projectname.length() > 0)
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
        sbStr.append("	 [ProjectName] = ?\n");//-- 项目名称
        getDP().AddNewParameter("Projectname",Projectname ); // 项目名称
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
        sbStr.append("		[DatabaseProjectID] DESC \n");//项目ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByProjectname
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:47:52
    * @param Projectname 项目名称 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListByProjectname(String Projectname, String OrderBy)
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByProjectnameReturnSQL(Projectname, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new IndustryProjectInfo(rs));
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
    // [start] GetListByProjectname
    /**
    * 根据 <br />
* ProjectName Projectname 项目名称<br />
返回表t_industry_project 文化项目表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:47:52
    * @param Projectname 项目名称 
    * @return 数据列表的强类型实体类 
    */
    public IndustryProjectInfoCollection GetListByProjectname(String Projectname)
    {
        return GetListByProjectname(Projectname, "");
    }
    // [end]

    // [end]
    

}