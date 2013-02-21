
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:21:04
   功能说明: 表t_enterprise 企业信息表的实体类EnterpriseInfo的数据层基类
   表说明:企业信息表
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
 * 表 t_enterprise 企业信息表 的实体EnterpriseInfo的数据操作类
 * @author 贾军磊
 *
 */
public class EnterpriseDAL extends EnterpriseDALBase
{
  // [start] EnterpriseDAL
	public EnterpriseDAL()
	{
		super();
	}

	public EnterpriseDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]
    // [start] GetEnterpriseInfoByEnterprisenameBusinesstypeidLegalpersonRegionidReturnSQL
    /**
    * 根据 <br />
企业名称 行业类型 法人 所属区域,EnterpriseName BusinessTypeID LegalPerson RegionID 获取表t_enterprise 企业信息表的SQL语句
    * 开发者 贾军磊 2012年12月04日 10:30:27
    * @param Enterprisename 企业名称 
    * @param Businesstypeid 行业类型 
    * @param Legalperson 法人 
    * @param Regionid 所属区域 
    * @return SQL语句 
    */
    public String GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionidReturnSQL(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {	

        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_enterprise]\n");
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
            sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_enterprise]\n");
        }

        boolean isWhere = true;

        //企业名称
        if (Enterprisename != null && Enterprisename.length() > 0)
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
        sbStr.append("	 [EnterpriseName] = ?\n");//-- 企业名称
        getDP().AddNewParameter("Enterprisename",Enterprisename ); // 企业名称
        }
        //行业类型
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
        sbStr.append("	 [BusinessTypeID] = ?\n");//-- 行业类型
        getDP().AddNewParameter("Businesstypeid",Businesstypeid ); // 行业类型
        }
        //法人
        if (Legalperson != null && Legalperson.length() > 0)
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
        sbStr.append("	 [LegalPerson] = ?\n");//-- 法人
        getDP().AddNewParameter("Legalperson",Legalperson ); // 法人
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
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:30:27
    * @param Enterprisename 企业名称 
    * @param Businesstypeid 行业类型 
    * @param Legalperson 法人 
    * @param Regionid 所属区域 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid, String OrderBy,int pageIndex, int pageSize)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionidReturnSQL(Enterprisename, Businesstypeid, Legalperson, Regionid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:30:27
    * @param Enterprisename 企业名称 
    * @param Businesstypeid 行业类型 
    * @param Legalperson 法人 
    * @param Regionid 所属区域 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid, int pageIndex, int pageSize)
    {
       return GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:30:27
    * @param Enterprisename 企业名称 
    * @param Businesstypeid 行业类型 
    * @param Legalperson 法人 
    * @param Regionid 所属区域 
    * @return 数据总量 
    */
    public int GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid, String OrderBy)
    {
    	
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionidReturnSQL(Enterprisename, Businesstypeid, Legalperson, Regionid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
* BusinessTypeID Businesstypeid 行业类型<br />
* LegalPerson Legalperson 法人<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:30:27
    * @param Enterprisename 企业名称 
    * @param Businesstypeid 行业类型 
    * @param Legalperson 法人 
    * @param Regionid 所属区域 
    * @return 数据总量 
    */
    public int GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(String Enterprisename, int Businesstypeid, String Legalperson, int Regionid)
    {		
    		
        return GetListPagerByEnterprisenameBusinesstypeidLegalpersonRegionid(Enterprisename, Businesstypeid, Legalperson, Regionid,  "");
    }
    // [end]
    // [start] GetEnterpriseInfoByCreatetimeReturnSQL
    /**
    * 根据 <br />
创立时间,CreateTime 获取表t_enterprise 企业信息表的SQL语句
    * 开发者 贾军磊 2012年12月04日 10:36:21
    * @param Createtime 创立时间 
    * @return SQL语句 
    */
    public String GetListPagerByCreatetimeReturnSQL(Date Createtime1, Date Createtime2, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_enterprise]\n");
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
            sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_enterprise]\n");
        }

        boolean isWhere = true;

        //创立时间
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
        sbStr.append("	 [CreateTime] between ? and ?\n");//-- 创立时间
        getDP().AddNewParameter("Createtime",Createtime1 ); // 创立时间
        getDP().AddNewParameter("Createtime",Createtime2 ); // 创立时间
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
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:36:21
    * @param Createtime 创立时间 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListPagerByCreatetime(Date Createtime1, Date Createtime2, String OrderBy,int pageIndex, int pageSize)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByCreatetimeReturnSQL(Createtime1, Createtime2,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:36:21
    * @param Createtime 创立时间 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListPagerByCreatetime(Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
       return GetListPagerByCreatetime(Createtime1, Createtime2, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetime
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:36:21
    * @param Createtime 创立时间 
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
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:36:21
    * @param Createtime 创立时间 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetime(Date Createtime1, Date Createtime2)
    {
        return GetListPagerByCreatetime(Createtime1, Createtime2,  "");
    }
    // [end]
    // [start] GetEnterpriseInfoByBusinesstypeidCreatetimeReturnSQL
    /**
    * 根据 <br />
行业类型 创立时间,BusinessTypeID CreateTime 获取表t_enterprise 企业信息表的SQL语句
    * 开发者 贾军磊 2012年12月04日 10:41:17
    * @param Businesstypeid 行业类型 
    * @param Createtime 创立时间 
    * @return SQL语句 
    */
    public String GetListPagerByBusinesstypeidCreatetimeReturnSQL(int Businesstypeid, Date Createtime1, Date Createtime2, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_enterprise]\n");
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
            sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_enterprise]\n");
        }

        boolean isWhere = true;

        //行业类型
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
        sbStr.append("	 [BusinessTypeID] = ?\n");//-- 行业类型
        getDP().AddNewParameter("Businesstypeid",Businesstypeid ); // 行业类型
        }
        //创立时间
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
        sbStr.append("	 [CreateTime] between ? and ?\n");//-- 创立时间
        getDP().AddNewParameter("Createtime",Createtime1 ); // 创立时间
        getDP().AddNewParameter("Createtime",Createtime2 ); // 创立时间
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
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:41:17
    * @param Businesstypeid 行业类型 
    * @param Createtime 创立时间 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListPagerByBusinesstypeidCreatetime(int Businesstypeid, Date Createtime1, Date Createtime2, String OrderBy,int pageIndex, int pageSize)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByBusinesstypeidCreatetimeReturnSQL(Businesstypeid, Createtime1, Createtime2,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:41:17
    * @param Businesstypeid 行业类型 
    * @param Createtime 创立时间 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListPagerByBusinesstypeidCreatetime(int Businesstypeid, Date Createtime1, Date Createtime2, int pageIndex, int pageSize)
    {
       return GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:41:17
    * @param Businesstypeid 行业类型 
    * @param Createtime 创立时间 
    * @return 数据总量 
    */
    public int GetListPagerByBusinesstypeidCreatetime(int Businesstypeid, Date Createtime1, Date Createtime2, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByBusinesstypeidCreatetimeReturnSQL(Businesstypeid, Createtime1, Createtime2,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByBusinesstypeidCreatetime
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
* CreateTime Createtime 创立时间<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:41:17
    * @param Businesstypeid 行业类型 
    * @param Createtime 创立时间 
    * @return 数据总量 
    */
    public int GetListPagerByBusinesstypeidCreatetime(int Businesstypeid, Date Createtime1, Date Createtime2)
    {
        return GetListPagerByBusinesstypeidCreatetime(Businesstypeid, Createtime1, Createtime2,  "");
    }
    // [end]
    // [start] GetEnterpriseInfoByCreatetimeRegionidReturnSQL
    /**
    * 根据 <br />
创立时间 所属区域,CreateTime RegionID 获取表t_enterprise 企业信息表的SQL语句
    * 开发者 贾军磊 2012年12月04日 10:45:50
    * @param Createtime 创立时间 
    * @param Regionid 所属区域 
    * @return SQL语句 
    */
    public String GetListPagerByCreatetimeRegionidReturnSQL(Date Createtime1, Date Createtime2, int Regionid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_enterprise]\n");
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
            sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_enterprise]\n");
        }

        boolean isWhere = true;

        //创立时间
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
        sbStr.append("	 [CreateTime] between ? and ?\n");//-- 创立时间
        getDP().AddNewParameter("Createtime",Createtime1 ); // 创立时间
        getDP().AddNewParameter("Createtime",Createtime2 ); // 创立时间
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
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:45:50
    * @param Createtime 创立时间 
    * @param Regionid 所属区域 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListPagerByCreatetimeRegionid(Date Createtime1, Date Createtime2, int Regionid, String OrderBy,int pageIndex, int pageSize)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByCreatetimeRegionidReturnSQL(Createtime1, Createtime2, Regionid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:45:50
    * @param Createtime 创立时间 
    * @param Regionid 所属区域 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListPagerByCreatetimeRegionid(Date Createtime1, Date Createtime2, int Regionid, int pageIndex, int pageSize)
    {
       return GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:45:50
    * @param Createtime 创立时间 
    * @param Regionid 所属区域 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeRegionid(Date Createtime1, Date Createtime2, int Regionid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByCreatetimeRegionidReturnSQL(Createtime1, Createtime2, Regionid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByCreatetimeRegionid
    /**
    * 根据 <br />
* CreateTime Createtime 创立时间<br />
* RegionID Regionid 所属区域<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:45:50
    * @param Createtime 创立时间 
    * @param Regionid 所属区域 
    * @return 数据总量 
    */
    public int GetListPagerByCreatetimeRegionid(Date Createtime1, Date Createtime2, int Regionid)
    {
        return GetListPagerByCreatetimeRegionid(Createtime1, Createtime2, Regionid,  "");
    }
    // [end]
    // [start] GetListByRegionidReturnSQL
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:18:28
    * @param Regionid 所属区域 
    * @return SQL语句 
    */
    public String GetListByRegionidReturnSQL(int Regionid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_enterprise]\n");
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
        if (OrderBy.trim().length() > 0)
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append(OrderBy);
        sbStr.append("\n");
        }
        else
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:18:28
    * @param Regionid 所属区域 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByRegionid(int Regionid, String OrderBy)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByRegionidReturnSQL(Regionid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
    // [start] GetListByRegionid
    /**
    * 根据 <br />
* RegionID Regionid 所属区域<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:18:28
    * @param Regionid 所属区域 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByRegionid(int Regionid)
    {
        return GetListByRegionid(Regionid, "");
    }
    // [end]
    // [start] GetListByBusinesstypeidReturnSQL
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:44:09
    * @param Businesstypeid 行业类型 
    * @return SQL语句 
    */
    public String GetListByBusinesstypeidReturnSQL(int Businesstypeid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_enterprise]\n");
        boolean isWhere = true;

        //行业类型
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
        sbStr.append("	 [BusinessTypeID] = ?\n");//-- 行业类型
        getDP().AddNewParameter("Businesstypeid",Businesstypeid ); // 行业类型
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
        sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByBusinesstypeid
    /**
    * 根据 <br />
* BusinessTypeID Businesstypeid 行业类型<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:44:09
    * @param Businesstypeid 行业类型 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByBusinesstypeid(int Businesstypeid, String OrderBy)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByBusinesstypeidReturnSQL(Businesstypeid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
* BusinessTypeID Businesstypeid 行业类型<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2012年12月15日 16:44:09
    * @param Businesstypeid 行业类型 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByBusinesstypeid(int Businesstypeid)
    {
        return GetListByBusinesstypeid(Businesstypeid, "");
    }
    // [end]
    
    
    // [start] CountByEnterpriseidReturnSQL
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 16:06:08
    * @param Enterpriseid 企业编号 
    * @return SQL语句 
    */
    public String CountByEnterpriseidReturnSQL(int Enterpriseid)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT count(*) \n");
        sbStr.append("FROM [t_enterprise]\n");
        boolean isWhere = true;

        //企业编号
        if (Enterpriseid != 0)
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
        sbStr.append("	 [EnterpriseID] = ?\n");//-- 企业编号
        getDP().AddNewParameter("Enterpriseid",Enterpriseid ); // 企业编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] CountByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
统计表t_enterprise 企业信息表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 16:06:08
    * @param Enterpriseid 企业编号 
    * @return 数据量 
    */
    public int CountByEnterpriseid(int Enterpriseid)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByEnterpriseidReturnSQL(Enterpriseid)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]

    // [start] GetListByEnterpriseidReturnSQL
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:23:13
    * @param Enterpriseid 企业编号 
    * @return SQL语句 
    */
    public String GetListByEnterpriseidReturnSQL(int Enterpriseid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_enterprise]\n");
        boolean isWhere = true;

        //企业编号
        if (Enterpriseid != 0)
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
        sbStr.append("	 [EnterpriseID] = ?\n");//-- 企业编号
        getDP().AddNewParameter("Enterpriseid",Enterpriseid ); // 企业编号
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
        sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:23:13
    * @param Enterpriseid 企业编号 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByEnterpriseid(int Enterpriseid, String OrderBy)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByEnterpriseidReturnSQL(Enterpriseid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
    // [start] GetListByEnterpriseid
    /**
    * 根据 <br />
* EnterpriseID Enterpriseid 企业编号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:23:13
    * @param Enterpriseid 企业编号 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByEnterpriseid(int Enterpriseid)
    {
        return GetListByEnterpriseid(Enterpriseid, "");
    }
    // [end]

    // [start] GetListByEnterprisenameReturnSQL
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:30:52
    * @param Enterprisename 企业名称 
    * @return SQL语句 
    */
    public String GetListByEnterprisenameReturnSQL(String Enterprisename, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_enterprise]\n");
        boolean isWhere = true;

        //企业名称
        if (Enterprisename != null && Enterprisename.length() > 0)
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
        sbStr.append("	 [EnterpriseName] = ?\n");//-- 企业名称
        getDP().AddNewParameter("Enterprisename",Enterprisename ); // 企业名称
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
        sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByEnterprisename
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:30:52
    * @param Enterprisename 企业名称 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByEnterprisename(String Enterprisename, String OrderBy)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByEnterprisenameReturnSQL(Enterprisename, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
    // [start] GetListByEnterprisename
    /**
    * 根据 <br />
* EnterpriseName Enterprisename 企业名称<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 16:30:52
    * @param Enterprisename 企业名称 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByEnterprisename(String Enterprisename)
    {
        return GetListByEnterprisename(Enterprisename, "");
    }
    // [end]
    // [start] GetListByEnterprisecodeReturnSQL
    /**
    * 根据 <br />
* EnterpriseCode Enterprisecode 工商登记号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:24:40
    * @param Enterprisecode 工商登记号 
    * @return SQL语句 
    */
    public String GetListByEnterprisecodeReturnSQL(String Enterprisecode, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_enterprise]\n");
        boolean isWhere = true;

        //工商登记号
        if (Enterprisecode != null && Enterprisecode.length() > 0)
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
        sbStr.append("	 [EnterpriseCode] = ?\n");//-- 工商登记号
        getDP().AddNewParameter("Enterprisecode",Enterprisecode ); // 工商登记号
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
        sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByEnterprisecode
    /**
    * 根据 <br />
* EnterpriseCode Enterprisecode 工商登记号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:24:40
    * @param Enterprisecode 工商登记号 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByEnterprisecode(String Enterprisecode, String OrderBy)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByEnterprisecodeReturnSQL(Enterprisecode, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
    // [start] GetListByEnterprisecode
    /**
    * 根据 <br />
* EnterpriseCode Enterprisecode 工商登记号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:24:40
    * @param Enterprisecode 工商登记号 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByEnterprisecode(String Enterprisecode)
    {
        return GetListByEnterprisecode(Enterprisecode, "");
    }
    // [end]
    // [start] GetListByPartentcodeReturnSQL
    /**
    * 根据 <br />
* PartentCode Partentcode 产品专利号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:26:36
    * @param Partentcode 产品专利号 
    * @return SQL语句 
    */
    public String GetListByPartentcodeReturnSQL(String Partentcode, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_enterprise]\n");
        boolean isWhere = true;

        //产品专利号
        if (Partentcode != null && Partentcode.length() > 0)
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
        sbStr.append("	 [PartentCode] = ?\n");//-- 产品专利号
        getDP().AddNewParameter("Partentcode",Partentcode ); // 产品专利号
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
        sbStr.append("		[DatabaseEnterpriseID] DESC \n");//企业ID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByPartentcode
    /**
    * 根据 <br />
* PartentCode Partentcode 产品专利号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:26:36
    * @param Partentcode 产品专利号 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByPartentcode(String Partentcode, String OrderBy)
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EnterpriseInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByPartentcodeReturnSQL(Partentcode, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EnterpriseInfo(rs));
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
    // [start] GetListByPartentcode
    /**
    * 根据 <br />
* PartentCode Partentcode 产品专利号<br />
返回表t_enterprise 企业信息表的数据列表<br />
    * 开发者 贾军磊 2013年01月24日 10:26:36
    * @param Partentcode 产品专利号 
    * @return 数据列表的强类型实体类 
    */
    public EnterpriseInfoCollection GetListByPartentcode(String Partentcode)
    {
        return GetListByPartentcode(Partentcode, "");
    }
    // [end]



}