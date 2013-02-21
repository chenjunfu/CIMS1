
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:27:13
   功能说明: 表t_talent 文化人才表的实体类TalentInfo的数据层基类
   表说明:文化人才表
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
 * 表 t_talent 文化人才表 的实体TalentInfo的数据操作类
 * @author 贾军磊
 *
 */
public class TalentDAL extends TalentDALBase
{
  // [start] TalentDAL
	public TalentDAL()
	{
		super();
	}
	
	public TalentDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
    // [start] GetTalentInfoByTalentnameNationidEducationidMajoridPosttitleidReturnSQL
    /**
    * 根据 <br />
姓名 民族 学历 专业 职称,TalentName NationID EducationID MajorID PostTitleID 获取表t_talent 文化人才表的SQL语句
    * 开发者 贾军磊 2012年12月04日 10:59:08
    * @param Talentname 姓名 
    * @param Nationid 民族 
    * @param Educationid 学历 
    * @param Majorid 专业 
    * @param Posttitleid 职称 
    * @return SQL语句 
    */
    public String GetListPagerByTalentnameNationidEducationidMajoridPosttitleidReturnSQL(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_talent]\n");
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
            sbStr.append("		[TalentID] DESC \n");//人才编号
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_talent]\n");
        }

        boolean isWhere = true;

        //姓名
        if (Talentname != null && Talentname.length() > 0)
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
        sbStr.append("	 [TalentName] = ?\n");//-- 姓名
        getDP().AddNewParameter("Talentname",Talentname ); // 姓名
        }
        //民族
        if (Nationid != 0)
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
        sbStr.append("	 [NationID] = ?\n");//-- 民族
        getDP().AddNewParameter("Nationid",Nationid ); // 民族
        }
        //学历
        if (Educationid != 0)
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
        sbStr.append("	 [EducationID] = ?\n");//-- 学历
        getDP().AddNewParameter("Educationid",Educationid ); // 学历
        }
        //专业
        if (Majorid != 0)
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
        sbStr.append("	 [MajorID] = ?\n");//-- 专业
        getDP().AddNewParameter("Majorid",Majorid ); // 专业
        }
        //职称
        if (Posttitleid != 0)
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
        sbStr.append("	 [PostTitleID] = ?\n");//-- 职称
        getDP().AddNewParameter("Posttitleid",Posttitleid ); // 职称
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
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:59:08
    * @param Talentname 姓名 
    * @param Nationid 民族 
    * @param Educationid 学历 
    * @param Majorid 专业 
    * @param Posttitleid 职称 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid, String OrderBy,int pageIndex, int pageSize)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByTalentnameNationidEducationidMajoridPosttitleidReturnSQL(Talentname, Nationid, Educationid, Majorid, Posttitleid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月04日 10:59:08
    * @param Talentname 姓名 
    * @param Nationid 民族 
    * @param Educationid 学历 
    * @param Majorid 专业 
    * @param Posttitleid 职称 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid, int pageIndex, int pageSize)
    {
       return GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:59:08
    * @param Talentname 姓名 
    * @param Nationid 民族 
    * @param Educationid 学历 
    * @param Majorid 专业 
    * @param Posttitleid 职称 
    * @return 数据总量 
    */
    public int GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByTalentnameNationidEducationidMajoridPosttitleidReturnSQL(Talentname, Nationid, Educationid, Majorid, Posttitleid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByTalentnameNationidEducationidMajoridPosttitleid
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
* NationID Nationid 民族<br />
* EducationID Educationid 学历<br />
* MajorID Majorid 专业<br />
* PostTitleID Posttitleid 职称<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月04日 10:59:08
    * @param Talentname 姓名 
    * @param Nationid 民族 
    * @param Educationid 学历 
    * @param Majorid 专业 
    * @param Posttitleid 职称 
    * @return 数据总量 
    */
    public int GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(String Talentname, int Nationid, int Educationid, int Majorid, int Posttitleid)
    {
        return GetListPagerByTalentnameNationidEducationidMajoridPosttitleid(Talentname, Nationid, Educationid, Majorid, Posttitleid,  "");
    }
    // [end]
    // [start] GetTalentInfoByLogintimeReturnSQL
    /**
    * 根据 <br />
登录时间,LoginTime 获取表t_talent 文化人才表的SQL语句
    * 开发者 贾军磊 2012年12月10日 11:44:12
    * @param Logintime 登录时间 
    * @return SQL语句 
    */
    public String GetListPagerByLogintimeReturnSQL(Date Logintime, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_talent]\n");
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
            sbStr.append("		[TalentID] DESC \n");//人才编号
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_talent]\n");
        }

        boolean isWhere = true;

        //登录时间
        if (Logintime != null)
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
        sbStr.append("	 [LoginTime] < ?\n");//-- 登录时间
        getDP().AddNewParameter("Logintime",Logintime ); // 登录时间
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
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 11:44:12
    * @param Logintime 登录时间 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListPagerByLogintime(Date Logintime, String OrderBy,int pageIndex, int pageSize)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByLogintimeReturnSQL(Logintime,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 11:44:12
    * @param Logintime 登录时间 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListPagerByLogintime(Date Logintime, int pageIndex, int pageSize)
    {
       return GetListPagerByLogintime(Logintime, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 11:44:12
    * @param Logintime 登录时间 
    * @return 数据总量 
    */
    public int GetListPagerByLogintime(Date Logintime, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByLogintimeReturnSQL(Logintime,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByLogintime
    /**
    * 根据 <br />
* LoginTime Logintime 登录时间<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 11:44:12
    * @param Logintime 登录时间 
    * @return 数据总量 
    */
    public int GetListPagerByLogintime(Date Logintime)
    {
        return GetListPagerByLogintime(Logintime,  "");
    }
    // [end]
    // [start] GetTalentInfoByTalentprofessionidReturnSQL
    /**
    * 根据 <br />
人才所属行业,TalentProfessionID 获取表t_talent 文化人才表的SQL语句
    * 开发者 贾军磊 2012年12月10日 14:10:35
    * @param Talentprofessionid 人才所属行业 
    * @return SQL语句 
    */
    public String GetListPagerByTalentprofessionidReturnSQL(int Talentprofessionid, String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SET NOCOUNT ON\n");
        if (isCount)
        {
            sbStr.append("		SELECT COUNT(*) FROM [t_talent]\n");
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
            sbStr.append("		[TalentID] DESC \n");//人才编号
        }
            sbStr.append("		) AS RowIndex,\n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
            sbStr.append("		FROM [t_talent]\n");
        }

        boolean isWhere = true;

        //人才所属行业
        if (Talentprofessionid != 0)
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
        sbStr.append("	 [TalentProfessionID] = ?\n");//-- 人才所属行业
        getDP().AddNewParameter("Talentprofessionid",Talentprofessionid ); // 人才所属行业
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
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 14:10:35
    * @param Talentprofessionid 人才所属行业 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListPagerByTalentprofessionid(int Talentprofessionid, String OrderBy,int pageIndex, int pageSize)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListPagerByTalentprofessionidReturnSQL(Talentprofessionid,  OrderBy, columnNames, pageIndex, pageSize,false));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月10日 14:10:35
    * @param Talentprofessionid 人才所属行业 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListPagerByTalentprofessionid(int Talentprofessionid, int pageIndex, int pageSize)
    {
       return GetListPagerByTalentprofessionid(Talentprofessionid, "",pageIndex,pageSize);
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 14:10:35
    * @param Talentprofessionid 人才所属行业 
    * @return 数据总量 
    */
    public int GetListPagerByTalentprofessionid(int Talentprofessionid, String OrderBy)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByTalentprofessionidReturnSQL(Talentprofessionid,  OrderBy, null, 0, 0,true)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListPagerByTalentprofessionid
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2012年12月10日 14:10:35
    * @param Talentprofessionid 人才所属行业 
    * @return 数据总量 
    */
    public int GetListPagerByTalentprofessionid(int Talentprofessionid)
    {
        return GetListPagerByTalentprofessionid(Talentprofessionid,  "");
    }
    // [end]
    public int CountAgeByRange(int MinAge,int MaxAge,Date end)
    {
    	getDP().ClearParameter();
    	getDP().AddNewParameter("MinAge", MinAge);
    	getDP().AddNewParameter("MaxAge", MaxAge);
    	getDP().AddNewParameter("end", end);
    	return (Integer)getDP().RunSqlScalar("select count(*) as total from (select talentID, datediff(year,Birthday,getdate()) 'age' ,[LoginTime] from t_talent) as a where a.age>=? and a.age<=? and  [LoginTime] <= ? ");
    	
    }
    
  // [end]
    
    // [start] GetListByEducationidReturnSQL
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:47:56
    * @param Educationid 学历 
    * @return SQL语句 
    */
    public String GetListByEducationidReturnSQL(int Educationid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_talent]\n");
        boolean isWhere = true;

        //学历
        if (Educationid != 0)
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
        sbStr.append("	 [EducationID] = ?\n");//-- 学历
        getDP().AddNewParameter("Educationid",Educationid ); // 学历
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
        sbStr.append("		[TalentID] DESC \n");//人才编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByEducationid
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:47:56
    * @param Educationid 学历 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByEducationid(int Educationid, String OrderBy)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByEducationidReturnSQL(Educationid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListByEducationid
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:47:56
    * @param Educationid 学历 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByEducationid(int Educationid)
    {
        return GetListByEducationid(Educationid, "");
    }
    // [end]
    // [start] GetListByPosttitleidReturnSQL
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:59:00
    * @param Posttitleid 职称 
    * @return SQL语句 
    */
    public String GetListByPosttitleidReturnSQL(int Posttitleid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_talent]\n");
        boolean isWhere = true;

        //职称
        if (Posttitleid != 0)
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
        sbStr.append("	 [PostTitleID] = ?\n");//-- 职称
        getDP().AddNewParameter("Posttitleid",Posttitleid ); // 职称
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
        sbStr.append("		[TalentID] DESC \n");//人才编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByPosttitleid
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:59:00
    * @param Posttitleid 职称 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByPosttitleid(int Posttitleid, String OrderBy)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByPosttitleidReturnSQL(Posttitleid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListByPosttitleid
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 09:59:00
    * @param Posttitleid 职称 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByPosttitleid(int Posttitleid)
    {
        return GetListByPosttitleid(Posttitleid, "");
    }
    // [end]
    
    // [start] GetListByTalentprofessionidLogintimeReturnSQL
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:42:23
    * @param Talentprofessionid 人才所属行业 
    * @param Logintime 登录时间 
    * @return SQL语句 
    */
    public String GetListByTalentprofessionidLogintimeReturnSQL(int Talentprofessionid, Date Logintime, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_talent]\n");
        boolean isWhere = true;

        //人才所属行业
        if (Talentprofessionid != 0)
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
        sbStr.append("	 [TalentProfessionID] = ?\n");//-- 人才所属行业
        getDP().AddNewParameter("Talentprofessionid",Talentprofessionid ); // 人才所属行业
        }
        //登录时间
        if (Logintime != null)
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
        sbStr.append("	 [LoginTime] < ?\n");//-- 登录时间
        getDP().AddNewParameter("Logintime",Logintime ); // 登录时间
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
        sbStr.append("		[TalentID] DESC \n");//人才编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByTalentprofessionidLogintime
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:42:23
    * @param Talentprofessionid 人才所属行业 
    * @param Logintime 登录时间 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByTalentprofessionidLogintime(int Talentprofessionid, Date Logintime, String OrderBy)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByTalentprofessionidLogintimeReturnSQL(Talentprofessionid, Logintime, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListByTalentprofessionidLogintime
    /**
    * 根据 <br />
* TalentProfessionID Talentprofessionid 人才所属行业<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:42:23
    * @param Talentprofessionid 人才所属行业 
    * @param Logintime 登录时间 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByTalentprofessionidLogintime(int Talentprofessionid, Date Logintime)
    {
        return GetListByTalentprofessionidLogintime(Talentprofessionid, Logintime, "");
    }
    // [end]

    // [start] GetListByEducationidLogintimeReturnSQL
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:48:45
    * @param Educationid 学历 
    * @param Logintime 登录时间 
    * @return SQL语句 
    */
    public String GetListByEducationidLogintimeReturnSQL(int Educationid, Date Logintime, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_talent]\n");
        boolean isWhere = true;

        //学历
        if (Educationid != 0)
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
        sbStr.append("	 [EducationID] = ?\n");//-- 学历
        getDP().AddNewParameter("Educationid",Educationid ); // 学历
        }
        //登录时间
        if (Logintime != null)
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
        sbStr.append("	 [LoginTime] < ?\n");//-- 登录时间
        getDP().AddNewParameter("Logintime",Logintime ); // 登录时间
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
        sbStr.append("		[TalentID] DESC \n");//人才编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByEducationidLogintime
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:48:45
    * @param Educationid 学历 
    * @param Logintime 登录时间 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByEducationidLogintime(int Educationid, Date Logintime, String OrderBy)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByEducationidLogintimeReturnSQL(Educationid, Logintime, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListByEducationidLogintime
    /**
    * 根据 <br />
* EducationID Educationid 学历<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:48:45
    * @param Educationid 学历 
    * @param Logintime 登录时间 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByEducationidLogintime(int Educationid, Date Logintime)
    {
        return GetListByEducationidLogintime(Educationid, Logintime, "");
    }
    // [end]
    // [start] GetListByPosttitleidLogintimeReturnSQL
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:42
    * @param Posttitleid 职称 
    * @param Logintime 登录时间 
    * @return SQL语句 
    */
    public String GetListByPosttitleidLogintimeReturnSQL(int Posttitleid, Date Logintime, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_talent]\n");
        boolean isWhere = true;

        //职称
        if (Posttitleid != 0)
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
        sbStr.append("	 [PostTitleID] = ?\n");//-- 职称
        getDP().AddNewParameter("Posttitleid",Posttitleid ); // 职称
        }
        //登录时间
        if (Logintime != null)
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
        sbStr.append("	 [LoginTime] < ?\n");//-- 登录时间
        getDP().AddNewParameter("Logintime",Logintime ); // 登录时间
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
        sbStr.append("		[TalentID] DESC \n");//人才编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByPosttitleidLogintime
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:42
    * @param Posttitleid 职称 
    * @param Logintime 登录时间 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByPosttitleidLogintime(int Posttitleid, Date Logintime, String OrderBy)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByPosttitleidLogintimeReturnSQL(Posttitleid, Logintime, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListByPosttitleidLogintime
    /**
    * 根据 <br />
* PostTitleID Posttitleid 职称<br />
* LoginTime Logintime 登录时间<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 11:49:42
    * @param Posttitleid 职称 
    * @param Logintime 登录时间 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByPosttitleidLogintime(int Posttitleid, Date Logintime)
    {
        return GetListByPosttitleidLogintime(Posttitleid, Logintime, "");
    }
    // [end]
    // [start] CountByReturnSQL
    /**
    * 根据 <br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 17:34:47
    * @return SQL语句 
    */
    public String CountByReturnSQL()
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT count(*) \n");
        sbStr.append("FROM [t_talent]\n");
        return sbStr.toString();
    }
    // [end]
    // [start] CountBy
    /**
    * 根据 <br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2013年01月14日 17:34:47
    * @return 数据量 
    */
    public int CountBy()
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByReturnSQL()).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] CountByTalentidReturnSQL
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2013年01月15日 09:26:14
    * @param Talentid 人才编号 
    * @return SQL语句 
    */
    public String CountByTalentidReturnSQL(int Talentid)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT count(*) \n");
        sbStr.append("FROM [t_talent]\n");
        boolean isWhere = true;

        //人才编号
        if (Talentid != 0)
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
        sbStr.append("	 [TalentID] = ?\n");//-- 人才编号
        getDP().AddNewParameter("Talentid",Talentid ); // 人才编号
        }
        return sbStr.toString();
    }
    // [end]
    // [start] CountByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
统计表t_talent 文化人才表的数据量<br />
    * 开发者 贾军磊 2013年01月15日 09:26:14
    * @param Talentid 人才编号 
    * @return 数据量 
    */
    public int CountByTalentid(int Talentid)
    {
        getDP().ClearParameter();
        int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByTalentidReturnSQL(Talentid)).toString());
        getDP().Dispose();
        return recordCount;
    }
    // [end]
    // [start] GetListByTalentidReturnSQL
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 10:30:56
    * @param Talentid 人才编号 
    * @return SQL语句 
    */
    public String GetListByTalentidReturnSQL(int Talentid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_talent]\n");
        boolean isWhere = true;

        //人才编号
        if (Talentid != 0)
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
        sbStr.append("	 [TalentID] = ?\n");//-- 人才编号
        getDP().AddNewParameter("Talentid",Talentid ); // 人才编号
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
        sbStr.append("		[databasetalentid] DESC \n");//databasetalentid
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 10:30:56
    * @param Talentid 人才编号 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByTalentid(int Talentid, String OrderBy)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByTalentidReturnSQL(Talentid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListByTalentid
    /**
    * 根据 <br />
* TalentID Talentid 人才编号<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月15日 10:30:56
    * @param Talentid 人才编号 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByTalentid(int Talentid)
    {
        return GetListByTalentid(Talentid, "");
    }
    // [end]
    // [start] GetListByTalentnameReturnSQL
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:53:19
    * @param Talentname 姓名 
    * @return SQL语句 
    */
    public String GetListByTalentnameReturnSQL(String Talentname, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_talent]\n");
        boolean isWhere = true;

        //姓名
        if (Talentname != null && Talentname.length() > 0)
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
        sbStr.append("	 [TalentName] = ?\n");//-- 姓名
        getDP().AddNewParameter("Talentname",Talentname ); // 姓名
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
        sbStr.append("		[databasetalentid] DESC \n");//databasetalentid
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByTalentname
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:53:19
    * @param Talentname 姓名 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByTalentname(String Talentname, String OrderBy)
    {
        TalentInfoCollection list = new TalentInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByTalentnameReturnSQL(Talentname, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new TalentInfo(rs));
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
    // [start] GetListByTalentname
    /**
    * 根据 <br />
* TalentName Talentname 姓名<br />
返回表t_talent 文化人才表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 17:53:19
    * @param Talentname 姓名 
    * @return 数据列表的强类型实体类 
    */
    public TalentInfoCollection GetListByTalentname(String Talentname)
    {
        return GetListByTalentname(Talentname, "");
    }
    // [end]


    
}