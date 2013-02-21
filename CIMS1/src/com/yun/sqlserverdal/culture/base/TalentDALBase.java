
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月26日 17:59:21
   功能说明: 表t_talent 文化人才表的实体类TalentInfo的数据层基类
   表说明:文化人才表
======================================================================*/
package com.yun.sqlserverdal.culture.base;

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
public class TalentDALBase
{
	// [start] 属性
	private String connectionString = null;
	private String dbUserName = null;
	private String dbPassWord = null;

	private String connectionStringUpdate = null;
	private String dbUserNameUpdate = null;
	private String dbPassWordUpdate = null;

	private DataProvider _dp;

	/**
	 *  数据库操作类
	 */
	public DataProvider getDP()
	{
		if (connectionString == null)
			connectionString = com.yun.configuration.WebConfig.getCultureBysqlserverdal();
		if (dbUserName == null)
			dbUserName = com.yun.configuration.WebConfig.getDbUserNameBysqlserverdal();
		if (dbPassWord == null)
			dbPassWord = com.yun.configuration.WebConfig.getDbPassWordBysqlserverdal();
		if (_dp == null || _dp.getIsDisposed())
			_dp = new DataProvider(connectionString, dbUserName, dbPassWord);
		return _dp;
	}

	public void setDP(DataProvider value)
	{
		_dp = value;
	}

	private DataProvider _dpUpdate;

	/**
	 *  数据库操作类
	 */
	public DataProvider getDPUpdate()
	{
		if (connectionStringUpdate == null)
			connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		if (dbUserNameUpdate == null)
			dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		if (dbPassWordUpdate == null)
			dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();
		if (_dpUpdate == null || _dpUpdate.getIsDisposed())
			_dpUpdate = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return _dpUpdate;
	}

	public void setDPUpdate(DataProvider value)
	{
		_dpUpdate = value;
	}

	// [end]

	// [start] 构造函数
	public TalentDALBase()
	{

	}

	public TalentDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		this.connectionString = connectionString;
		this.dbUserName = DbUserName;
		this.dbPassWord = DbPassWord;

		this.connectionStringUpdate = connectionStringUpdate;
		this.dbUserNameUpdate = DbUserNameUpdate;
		this.dbPassWordUpdate = DbPassWordUpdate;

	}

	// [end]

        // [start] Count
        // [start] CountByDatabasetalentidReturnSQL
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param Databasetalentid databasetalentid 
        * @return SQL语句 
        */
        public String CountByDatabasetalentidReturnSQL(int Databasetalentid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_talent]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [databasetalentid] = ?\n");//-- databasetalentid
            getDP().AddNewParameter("Databasetalentid",Databasetalentid ); // databasetalentid
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param Databasetalentid databasetalentid 
        * @return 数据量 
        */
        public int CountByDatabasetalentid(int Databasetalentid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabasetalentidReturnSQL(Databasetalentid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
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
        * 开发者 贾军磊 2012年12月26日 17:59:22
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

        // [end]

        // [start] GetList
        // [start] GetListByReturnSQL
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
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
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @return 数据列表的强类型实体类 
        */
        public TalentInfoCollection GetListBy(String OrderBy)
        {
            TalentInfoCollection list = new TalentInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
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
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @return 数据列表的强类型实体类 
        */
        public TalentInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetTalentInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_talent 文化人才表的SQL语句
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
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
                sbStr.append("		[databasetalentid] DESC \n");//databasetalentid
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
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @return 数据列表的强类型实体类 
        */
        public TalentInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            TalentInfoCollection list = new TalentInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
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
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_talent 文化人才表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @return 数据列表的强类型实体类 
        */
        public TalentInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @return 数据总量 
        */
        public int GetListPagerBy(String OrderBy)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(GetListPagerByReturnSQL( OrderBy, null, 0, 0,true)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_talent 文化人才表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetTalentInfoByDatabasetalentidReturnSQL
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 获取表t_talent 文化人才表的对象<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param Databasetalentid databasetalentid 
        * @return SQL语句 
        */
        public String GetListByDatabasetalentidReturnSQL(int Databasetalentid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.TalentInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_talent]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [databasetalentid] = ?\n");//-- databasetalentid
            getDP().AddNewParameter("Databasetalentid",Databasetalentid ); // databasetalentid
            return sbStr.toString();
        }
        // [end]
        // [start] GetTalentInfoByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 获取表t_talent 文化人才表的对象<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param Databasetalentid databasetalentid 
        * @return TalentInfo对象实体 
        */
        public TalentInfo GetTalentInfoByDatabasetalentid(int Databasetalentid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabasetalentidReturnSQL(Databasetalentid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                TalentInfo objTalentInfo = new TalentInfo(rs);
                getDP().Dispose();
                return objTalentInfo;
            }
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
            }
            getDP().Dispose();
            return null;
        }
        // [end]

        // [end]

        // [start] Insert
        // [start] InsertReturnSQL
        /**
        * 向表t_talent 文化人才表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param objTalentInfo TalentInfo对象 文化人才表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(TalentInfo objTalentInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_talent]\n");
            sbStr.append("(\n");
            sbStr.append("	[TalentID],\n");//-- 人才编号
            sbStr.append("	[TalentName],\n");//-- 姓名
            sbStr.append("	[Sex],\n");//-- 性别：1-男、2-女
            sbStr.append("	[Birthday],\n");//-- 出生日期
            sbStr.append("	[NationID],\n");//-- 民族
            sbStr.append("	[NativePlace],\n");//-- 籍贯
            sbStr.append("	[PoliticsStatus],\n");//-- 政治面貌
            sbStr.append("	[Province],\n");//-- 省份
            sbStr.append("	[CityID],\n");//-- 城市
            sbStr.append("	[EducationID],\n");//-- 学历
            sbStr.append("	[DegreeID],\n");//-- 学位
            sbStr.append("	[MajorID],\n");//-- 专业
            sbStr.append("	[LearnExperience],\n");//-- 个人学习经历
            sbStr.append("	[WorkExperience],\n");//-- 工作经历
            sbStr.append("	[TalentProfessionID],\n");//-- 人才所属行业
            sbStr.append("	[Acheivement],\n");//-- 业绩
            sbStr.append("	[Honor],\n");//-- 荣誉
            sbStr.append("	[Skills],\n");//-- 专长
            sbStr.append("	[PostTitleID],\n");//-- 职称
            sbStr.append("	[WorkUnit],\n");//-- 工作单位
            sbStr.append("	[Adress],\n");//-- 现在住址
            sbStr.append("	[MovePhone],\n");//-- 手机
            sbStr.append("	[Email],\n");//-- 邮箱
            sbStr.append("	[DatabasePeopleID1],\n");//-- 统计人员
            sbStr.append("	[DatabasePeopleID2],\n");//-- 填表人员
            sbStr.append("	[AdminID],\n");//-- 登录人员
            sbStr.append("	[SectorID],\n");//-- SectorID
            sbStr.append("	[LoginTime]\n");//-- 登录时间
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 人才编号
            getDPUpdate().AddNewParameter("Talentid",objTalentInfo.getTalentid()); // 
            sbStr.append("	?,\n");//-- 姓名
            getDPUpdate().AddNewParameter("Talentname",objTalentInfo.getTalentname()); // 
            sbStr.append("	?,\n");//-- 性别：1-男、2-女
            getDPUpdate().AddNewParameter("Sex",objTalentInfo.getSex()); // 
            sbStr.append("	?,\n");//-- 出生日期
            getDPUpdate().AddNewParameter("Birthday",objTalentInfo.getBirthday()); // 
            sbStr.append("	?,\n");//-- 民族
            getDPUpdate().AddNewParameter("Nationid",objTalentInfo.getNationid()); // 
            sbStr.append("	?,\n");//-- 籍贯
            getDPUpdate().AddNewParameter("Nativeplace",objTalentInfo.getNativeplace()); // 
            sbStr.append("	?,\n");//-- 政治面貌
            getDPUpdate().AddNewParameter("Politicsstatus",objTalentInfo.getPoliticsstatus()); // 
            sbStr.append("	?,\n");//-- 省份
            getDPUpdate().AddNewParameter("Province",objTalentInfo.getProvince()); // 
            sbStr.append("	?,\n");//-- 城市
            getDPUpdate().AddNewParameter("Cityid",objTalentInfo.getCityid()); // 
            sbStr.append("	?,\n");//-- 学历
            getDPUpdate().AddNewParameter("Educationid",objTalentInfo.getEducationid()); // 
            sbStr.append("	?,\n");//-- 学位
            getDPUpdate().AddNewParameter("Degreeid",objTalentInfo.getDegreeid()); // 
            sbStr.append("	?,\n");//-- 专业
            getDPUpdate().AddNewParameter("Majorid",objTalentInfo.getMajorid()); // 
            sbStr.append("	?,\n");//-- 个人学习经历
            getDPUpdate().AddNewParameter("Learnexperience",objTalentInfo.getLearnexperience()); // 
            sbStr.append("	?,\n");//-- 工作经历
            getDPUpdate().AddNewParameter("Workexperience",objTalentInfo.getWorkexperience()); // 
            sbStr.append("	?,\n");//-- 人才所属行业
            getDPUpdate().AddNewParameter("Talentprofessionid",objTalentInfo.getTalentprofessionid()); // 
            sbStr.append("	?,\n");//-- 业绩
            getDPUpdate().AddNewParameter("Acheivement",objTalentInfo.getAcheivement()); // 
            sbStr.append("	?,\n");//-- 荣誉
            getDPUpdate().AddNewParameter("Honor",objTalentInfo.getHonor()); // 
            sbStr.append("	?,\n");//-- 专长
            getDPUpdate().AddNewParameter("Skills",objTalentInfo.getSkills()); // 
            sbStr.append("	?,\n");//-- 职称
            getDPUpdate().AddNewParameter("Posttitleid",objTalentInfo.getPosttitleid()); // 
            sbStr.append("	?,\n");//-- 工作单位
            getDPUpdate().AddNewParameter("Workunit",objTalentInfo.getWorkunit()); // 
            sbStr.append("	?,\n");//-- 现在住址
            getDPUpdate().AddNewParameter("Adress",objTalentInfo.getAdress()); // 
            sbStr.append("	?,\n");//-- 手机
            getDPUpdate().AddNewParameter("Movephone",objTalentInfo.getMovephone()); // 
            sbStr.append("	?,\n");//-- 邮箱
            getDPUpdate().AddNewParameter("Email",objTalentInfo.getEmail()); // 
            sbStr.append("	?,\n");//-- 统计人员
            getDPUpdate().AddNewParameter("Databasepeopleid1",objTalentInfo.getDatabasepeopleid1()); // 
            sbStr.append("	?,\n");//-- 填表人员
            getDPUpdate().AddNewParameter("Databasepeopleid2",objTalentInfo.getDatabasepeopleid2()); // 
            sbStr.append("	?,\n");//-- 登录人员
            getDPUpdate().AddNewParameter("Adminid",objTalentInfo.getAdminid()); // 
            sbStr.append("	?,\n");//-- SectorID
            getDPUpdate().AddNewParameter("Sectorid",objTalentInfo.getSectorid()); // 
            sbStr.append("	?\n");//-- 登录时间
            getDPUpdate().AddNewParameter("Logintime",objTalentInfo.getLogintime()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_talent 文化人才表中插入数据,返回databasetalentid字段内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param objTalentInfo TalentInfo对象 文化人才表 
        * @return 字段TalentID 
        */
        public int Insert(TalentInfo objTalentInfo)
        {
            getDPUpdate().ClearParameter();
            int Databasetalentid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objTalentInfo)));
            objTalentInfo.setDatabasetalentid(Databasetalentid);//databasetalentid  数据类型:int
            getDPUpdate().Dispose();
            return Databasetalentid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabasetalentidReturnSQL
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 更新表t_talent 文化人才表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param objTalentInfo TalentInfo对象 文化人才表 
        * @return SQL语句 
        */
        public String UpdateByDatabasetalentidReturnSQL(TalentInfo objTalentInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_talent]\n");
            sbStr.append("SET\n");
            sbStr.append("	[TalentID] = ?,\n");//-- 人才编号
            getDPUpdate().AddNewParameter("Talentid",objTalentInfo.getTalentid()); // 人才编号
            sbStr.append("	[TalentName] = ?,\n");//-- 姓名
            getDPUpdate().AddNewParameter("Talentname",objTalentInfo.getTalentname()); // 姓名
            sbStr.append("	[Sex] = ?,\n");//-- 性别：1-男、2-女
            getDPUpdate().AddNewParameter("Sex",objTalentInfo.getSex()); // 性别：1-男、2-女
            sbStr.append("	[Birthday] = ?,\n");//-- 出生日期
            getDPUpdate().AddNewParameter("Birthday",objTalentInfo.getBirthday()); // 出生日期
            sbStr.append("	[NationID] = ?,\n");//-- 民族
            getDPUpdate().AddNewParameter("Nationid",objTalentInfo.getNationid()); // 民族
            sbStr.append("	[NativePlace] = ?,\n");//-- 籍贯
            getDPUpdate().AddNewParameter("Nativeplace",objTalentInfo.getNativeplace()); // 籍贯
            sbStr.append("	[PoliticsStatus] = ?,\n");//-- 政治面貌
            getDPUpdate().AddNewParameter("Politicsstatus",objTalentInfo.getPoliticsstatus()); // 政治面貌
            sbStr.append("	[Province] = ?,\n");//-- 省份
            getDPUpdate().AddNewParameter("Province",objTalentInfo.getProvince()); // 省份
            sbStr.append("	[CityID] = ?,\n");//-- 城市
            getDPUpdate().AddNewParameter("Cityid",objTalentInfo.getCityid()); // 城市
            sbStr.append("	[EducationID] = ?,\n");//-- 学历
            getDPUpdate().AddNewParameter("Educationid",objTalentInfo.getEducationid()); // 学历
            sbStr.append("	[DegreeID] = ?,\n");//-- 学位
            getDPUpdate().AddNewParameter("Degreeid",objTalentInfo.getDegreeid()); // 学位
            sbStr.append("	[MajorID] = ?,\n");//-- 专业
            getDPUpdate().AddNewParameter("Majorid",objTalentInfo.getMajorid()); // 专业
            sbStr.append("	[LearnExperience] = ?,\n");//-- 个人学习经历
            getDPUpdate().AddNewParameter("Learnexperience",objTalentInfo.getLearnexperience()); // 个人学习经历
            sbStr.append("	[WorkExperience] = ?,\n");//-- 工作经历
            getDPUpdate().AddNewParameter("Workexperience",objTalentInfo.getWorkexperience()); // 工作经历
            sbStr.append("	[TalentProfessionID] = ?,\n");//-- 人才所属行业
            getDPUpdate().AddNewParameter("Talentprofessionid",objTalentInfo.getTalentprofessionid()); // 人才所属行业
            sbStr.append("	[Acheivement] = ?,\n");//-- 业绩
            getDPUpdate().AddNewParameter("Acheivement",objTalentInfo.getAcheivement()); // 业绩
            sbStr.append("	[Honor] = ?,\n");//-- 荣誉
            getDPUpdate().AddNewParameter("Honor",objTalentInfo.getHonor()); // 荣誉
            sbStr.append("	[Skills] = ?,\n");//-- 专长
            getDPUpdate().AddNewParameter("Skills",objTalentInfo.getSkills()); // 专长
            sbStr.append("	[PostTitleID] = ?,\n");//-- 职称
            getDPUpdate().AddNewParameter("Posttitleid",objTalentInfo.getPosttitleid()); // 职称
            sbStr.append("	[WorkUnit] = ?,\n");//-- 工作单位
            getDPUpdate().AddNewParameter("Workunit",objTalentInfo.getWorkunit()); // 工作单位
            sbStr.append("	[Adress] = ?,\n");//-- 现在住址
            getDPUpdate().AddNewParameter("Adress",objTalentInfo.getAdress()); // 现在住址
            sbStr.append("	[MovePhone] = ?,\n");//-- 手机
            getDPUpdate().AddNewParameter("Movephone",objTalentInfo.getMovephone()); // 手机
            sbStr.append("	[Email] = ?,\n");//-- 邮箱
            getDPUpdate().AddNewParameter("Email",objTalentInfo.getEmail()); // 邮箱
            sbStr.append("	[DatabasePeopleID1] = ?,\n");//-- 统计人员
            getDPUpdate().AddNewParameter("Databasepeopleid1",objTalentInfo.getDatabasepeopleid1()); // 统计人员
            sbStr.append("	[DatabasePeopleID2] = ?,\n");//-- 填表人员
            getDPUpdate().AddNewParameter("Databasepeopleid2",objTalentInfo.getDatabasepeopleid2()); // 填表人员
            sbStr.append("	[AdminID] = ?,\n");//-- 登录人员
            getDPUpdate().AddNewParameter("Adminid",objTalentInfo.getAdminid()); // 登录人员
            sbStr.append("	[SectorID] = ?,\n");//-- SectorID
            getDPUpdate().AddNewParameter("Sectorid",objTalentInfo.getSectorid()); // SectorID
            sbStr.append("	[LoginTime] = ?\n");//-- 登录时间
            getDPUpdate().AddNewParameter("Logintime",objTalentInfo.getLogintime()); // 登录时间
            sbStr.append("WHERE\n");
            sbStr.append("	 [databasetalentid] = ?\n");//-- databasetalentid
            getDPUpdate().AddNewParameter("Databasetalentid",objTalentInfo.getDatabasetalentid() ); // databasetalentid
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 更新表t_talent 文化人才表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param objTalentInfo TalentInfo对象 文化人才表 
        */
        public void UpdateByDatabasetalentid(TalentInfo objTalentInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabasetalentidReturnSQL(objTalentInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabasetalentidReturnSQL
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 删除数据表t_talent 文化人才表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param Databasetalentid databasetalentid 
        * @return SQL语句 
        */
        public String DeleteByDatabasetalentidReturnSQL(int Databasetalentid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_talent]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [databasetalentid] = ?\n");//-- databasetalentid
            getDPUpdate().AddNewParameter("Databasetalentid",Databasetalentid ); // databasetalentid
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabasetalentid
        /**
        * 根据 <br />
    * databasetalentid Databasetalentid databasetalentid<br />
 删除数据表t_talent 文化人才表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 17:59:22
        * @param Databasetalentid databasetalentid 
        */
        public void DeleteByDatabasetalentid(int Databasetalentid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabasetalentidReturnSQL(Databasetalentid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
