
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月26日 10:58:19
   功能说明: 表t_industry_project 文化项目表的实体类IndustryProjectInfo的数据层基类
   表说明:文化项目表
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
 * 表 t_industry_project 文化项目表 的实体IndustryProjectInfo的数据操作类
 * @author 贾军磊
 *
 */
public class IndustryProjectDALBase
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
	public IndustryProjectDALBase()
	{

	}

	public IndustryProjectDALBase(String connectionString, String DbUserName, String DbPassWord,String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
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
        // [start] CountByDatabaseprojectidReturnSQL
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param Databaseprojectid 项目ID 
        * @return SQL语句 
        */
        public String CountByDatabaseprojectidReturnSQL(int Databaseprojectid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_project]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseProjectID] = ?\n");//-- 项目ID
            getDP().AddNewParameter("Databaseprojectid",Databaseprojectid ); // 项目ID
            return sbStr.toString();
        }
        // [end]
        // [start] CountByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param Databaseprojectid 项目ID 
        * @return 数据量 
        */
        public int CountByDatabaseprojectid(int Databaseprojectid)
        {
            getDP().ClearParameter();
            int recordCount = Integer.parseInt(getDP().RunSqlScalar(CountByDatabaseprojectidReturnSQL(Databaseprojectid)).toString());
            getDP().Dispose();
            return recordCount;
        }
        // [end]
        // [start] CountByReturnSQL
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @return SQL语句 
        */
        public String CountByReturnSQL()
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT count(*) \n");
            sbStr.append("FROM [t_industry_project]\n");
            return sbStr.toString();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
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
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @return SQL语句 
        */
        public String GetListByReturnSQL(String OrderBy, String[] ColumnNames)
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
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @return 数据列表的强类型实体类 
        */
        public IndustryProjectInfoCollection GetListBy(String OrderBy)
        {
            IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListByReturnSQL(OrderBy, columnNames));
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
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @return 数据列表的强类型实体类 
        */
        public IndustryProjectInfoCollection GetListBy()
        {
            return GetListBy("");
        }
        // [end]

        // [end]

        // [start] GetListPager
        // [start] GetIndustryProjectInfoByReturnSQL
        /**
        * 根据 <br />
, 获取表t_industry_project 文化项目表的SQL语句
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @return SQL语句 
        */
        public String GetListPagerByReturnSQL(String OrderBy, String[] ColumnNames, int pageIndex, int pageSize, boolean isCount)
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
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @return 数据列表的强类型实体类 
        */
        public IndustryProjectInfoCollection GetListPagerBy(String OrderBy,int pageIndex, int pageSize)
        {
            IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
            getDP().ClearParameter();
            String[] columnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
            ResultSet rs = getDP().RunSqlResultSet(GetListPagerByReturnSQL( OrderBy, columnNames, pageIndex, pageSize,false));
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
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_industry_project 文化项目表的数据列表<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @return 数据列表的强类型实体类 
        */
        public IndustryProjectInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
           return GetListPagerBy("",pageIndex,pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
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
 统计表t_industry_project 文化项目表的数据量<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @return 数据总量 
        */
        public int GetListPagerBy()
        {
            return GetListPagerBy( "");
        }
        // [end]

        // [end]

        // [start] GetObject
        // [start] GetIndustryProjectInfoByDatabaseprojectidReturnSQL
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 获取表t_industry_project 文化项目表的对象<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param Databaseprojectid 项目ID 
        * @return SQL语句 
        */
        public String GetListByDatabaseprojectidReturnSQL(int Databaseprojectid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("SELECT \n");
                String[] ColumnNames = com.yun.entities.culture.IndustryProjectInfo.ColumnNames;
                String LastColumnName = ColumnNames[ColumnNames.length - 1];
                for (String s : ColumnNames)
                {
                    if (s.equals(LastColumnName))
                        sbStr.append("		[").append(s).append("] \n");
                    else
                        sbStr.append("		[").append(s).append("], \n");
                }
            sbStr.append("FROM [t_industry_project]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseProjectID] = ?\n");//-- 项目ID
            getDP().AddNewParameter("Databaseprojectid",Databaseprojectid ); // 项目ID
            return sbStr.toString();
        }
        // [end]
        // [start] GetIndustryProjectInfoByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 获取表t_industry_project 文化项目表的对象<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param Databaseprojectid 项目ID 
        * @return IndustryProjectInfo对象实体 
        */
        public IndustryProjectInfo GetIndustryProjectInfoByDatabaseprojectid(int Databaseprojectid)
        {
            getDP().ClearParameter();
            ResultSet rs = getDP().RunSqlResultSet(GetListByDatabaseprojectidReturnSQL(Databaseprojectid));
            if (rs != null)
            {
			try
			{
            while (rs.next())
            {
                IndustryProjectInfo objIndustryProjectInfo = new IndustryProjectInfo(rs);
                getDP().Dispose();
                return objIndustryProjectInfo;
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
        * 向表t_industry_project 文化项目表中插入数据,的SQL语句
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param objIndustryProjectInfo IndustryProjectInfo对象 文化项目表 
        * @return SQL语句 
        */
        public String InsertReturnSQL(IndustryProjectInfo objIndustryProjectInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("INSERT INTO [t_industry_project]\n");
            sbStr.append("(\n");
            sbStr.append("	[ProjectID],\n");//-- 项目编号
            sbStr.append("	[ProjectName],\n");//-- 项目名称
            sbStr.append("	[DatabaseEnterpriseID],\n");//-- 经营单位
            sbStr.append("	[ProQuality],\n");//-- 建设性质
            sbStr.append("	[Address],\n");//-- 所在地址
            sbStr.append("	[CreateTime],\n");//-- 创建时间
            sbStr.append("	[plantime],\n");//-- 计划时间
            sbStr.append("	[CompleteTime],\n");//-- 完成时间
            sbStr.append("	[ProContent],\n");//-- 项目内容
            sbStr.append("	[planInvest],\n");//-- 计划投入资金
            sbStr.append("	[TotalInvest],\n");//-- 实际投入资金
            sbStr.append("	[RealInvest],\n");//-- RealInvest
            sbStr.append("	[yearinvest],\n");//-- 本年投入资金
            sbStr.append("	[publicinvest],\n");//-- 政府投资
            sbStr.append("	[selfinvest],\n");//-- 自筹
            sbStr.append("	[bankloan],\n");//-- 银行
            sbStr.append("	[shb],\n");//-- 审批,核准,备案
            sbStr.append("	[hppf],\n");//-- 环评批复
            sbStr.append("	[tdpz],\n");//-- 土地批准
            sbStr.append("	[ghxz],\n");//-- 规划选址
            sbStr.append("	[shbno],\n");//-- shbno
            sbStr.append("	[hppfno],\n");//-- hppfno
            sbStr.append("	[tdpzno],\n");//-- tdpzno
            sbStr.append("	[ghxzno],\n");//-- ghxzno
            sbStr.append("	[RegionID],\n");//-- 所属区域
            sbStr.append("	[DutyUnitID],\n");//-- 主管单位
            sbStr.append("	[IndustryID],\n");//-- 产业类别
            sbStr.append("	[PlanProgress],\n");//-- 计划进度
            sbStr.append("	[RealProgress],\n");//-- 实际进度
            sbStr.append("	[Feature],\n");//-- 项目特色
            sbStr.append("	[State],\n");//-- 经营状况
            sbStr.append("	[linkman],\n");//-- linkman
            sbStr.append("	[phone],\n");//-- phone
            sbStr.append("	[comment],\n");//-- comment
            sbStr.append("	[Pic],\n");//-- 项目图片
            sbStr.append("	[DatabasePeopleID1],\n");//-- 填表人员
            sbStr.append("	[DatabasePeopleID2],\n");//-- 统计人员
            sbStr.append("	[AdminID],\n");//-- 登录人员
            sbStr.append("	[SectorID],\n");//-- 部门
            sbStr.append("	[LoginTime]\n");//-- 登录时间
            sbStr.append(")\n");
            sbStr.append("VALUES\n");
            sbStr.append("(\n");
            sbStr.append("	?,\n");//-- 项目编号
            getDPUpdate().AddNewParameter("Projectid",objIndustryProjectInfo.getProjectid()); // 
            sbStr.append("	?,\n");//-- 项目名称
            getDPUpdate().AddNewParameter("Projectname",objIndustryProjectInfo.getProjectname()); // 
            sbStr.append("	?,\n");//-- 经营单位
            getDPUpdate().AddNewParameter("Databaseenterpriseid",objIndustryProjectInfo.getDatabaseenterpriseid()); // 
            sbStr.append("	?,\n");//-- 建设性质
            getDPUpdate().AddNewParameter("Proquality",objIndustryProjectInfo.getProquality()); // 
            sbStr.append("	?,\n");//-- 所在地址
            getDPUpdate().AddNewParameter("Address",objIndustryProjectInfo.getAddress()); // 
            sbStr.append("	?,\n");//-- 创建时间
            getDPUpdate().AddNewParameter("Createtime",objIndustryProjectInfo.getCreatetime()); // 
            sbStr.append("	?,\n");//-- 计划时间
            getDPUpdate().AddNewParameter("Plantime",objIndustryProjectInfo.getPlantime()); // 
            sbStr.append("	?,\n");//-- 完成时间
            if(objIndustryProjectInfo.getCompletetime()==null)
            {
            	getDPUpdate().AddNullParameter("Completetime", null);// 完成时间
            }
            else
            {
            	getDPUpdate().AddNewParameter("Completetime",objIndustryProjectInfo.getCompletetime()); // 完成时间
            }
            sbStr.append("	?,\n");//-- 项目内容
            getDPUpdate().AddNewParameter("Procontent",objIndustryProjectInfo.getProcontent()); // 
            sbStr.append("	?,\n");//-- 计划投入资金
            getDPUpdate().AddNewParameter("Planinvest",objIndustryProjectInfo.getPlaninvest()); // 
            sbStr.append("	?,\n");//-- 实际投入资金
            getDPUpdate().AddNewParameter("Totalinvest",objIndustryProjectInfo.getTotalinvest()); // 
            sbStr.append("	?,\n");//-- RealInvest
            getDPUpdate().AddNewParameter("Realinvest",objIndustryProjectInfo.getRealinvest()); // 
            sbStr.append("	?,\n");//-- 本年投入资金
            getDPUpdate().AddNewParameter("Yearinvest",objIndustryProjectInfo.getYearinvest()); // 
            sbStr.append("	?,\n");//-- 政府投资
            getDPUpdate().AddNewParameter("Publicinvest",objIndustryProjectInfo.getPublicinvest()); // 
            sbStr.append("	?,\n");//-- 自筹
            getDPUpdate().AddNewParameter("Selfinvest",objIndustryProjectInfo.getSelfinvest()); // 
            sbStr.append("	?,\n");//-- 银行
            getDPUpdate().AddNewParameter("Bankloan",objIndustryProjectInfo.getBankloan()); // 
            sbStr.append("	?,\n");//-- 审批,核准,备案
            getDPUpdate().AddNewParameter("Shb",objIndustryProjectInfo.getShb()); // 
            sbStr.append("	?,\n");//-- 环评批复
            getDPUpdate().AddNewParameter("Hppf",objIndustryProjectInfo.getHppf()); // 
            sbStr.append("	?,\n");//-- 土地批准
            getDPUpdate().AddNewParameter("Tdpz",objIndustryProjectInfo.getTdpz()); // 
            sbStr.append("	?,\n");//-- 规划选址
            getDPUpdate().AddNewParameter("Ghxz",objIndustryProjectInfo.getGhxz()); // 
            sbStr.append("	?,\n");//-- shbno
            getDPUpdate().AddNewParameter("Shbno",objIndustryProjectInfo.getShbno()); // 
            sbStr.append("	?,\n");//-- hppfno
            getDPUpdate().AddNewParameter("Hppfno",objIndustryProjectInfo.getHppfno()); // 
            sbStr.append("	?,\n");//-- tdpzno
            getDPUpdate().AddNewParameter("Tdpzno",objIndustryProjectInfo.getTdpzno()); // 
            sbStr.append("	?,\n");//-- ghxzno
            getDPUpdate().AddNewParameter("Ghxzno",objIndustryProjectInfo.getGhxzno()); // 
            sbStr.append("	?,\n");//-- 所属区域
            getDPUpdate().AddNewParameter("Regionid",objIndustryProjectInfo.getRegionid()); // 
            sbStr.append("	?,\n");//-- 主管单位
            getDPUpdate().AddNewParameter("Dutyunitid",objIndustryProjectInfo.getDutyunitid()); // 
            sbStr.append("	?,\n");//-- 产业类别
            getDPUpdate().AddNewParameter("Industryid",objIndustryProjectInfo.getIndustryid()); // 
            sbStr.append("	?,\n");//-- 计划进度
            getDPUpdate().AddNewParameter("Planprogress",objIndustryProjectInfo.getPlanprogress()); // 
            sbStr.append("	?,\n");//-- 实际进度
            getDPUpdate().AddNewParameter("Realprogress",objIndustryProjectInfo.getRealprogress()); // 
            sbStr.append("	?,\n");//-- 项目特色
            getDPUpdate().AddNewParameter("Feature",objIndustryProjectInfo.getFeature()); // 
            sbStr.append("	?,\n");//-- 经营状况
            getDPUpdate().AddNewParameter("State",objIndustryProjectInfo.getState()); // 
            sbStr.append("	?,\n");//-- linkman
            getDPUpdate().AddNewParameter("Linkman",objIndustryProjectInfo.getLinkman()); // 
            sbStr.append("	?,\n");//-- phone
            getDPUpdate().AddNewParameter("Phone",objIndustryProjectInfo.getPhone()); // 
            sbStr.append("	?,\n");//-- comment
            getDPUpdate().AddNewParameter("Comment",objIndustryProjectInfo.getComment()); // 
            sbStr.append("	?,\n");//-- 项目图片
            getDPUpdate().AddNewParameter("Pic",objIndustryProjectInfo.getPic()); // 
            sbStr.append("	?,\n");//-- 填表人员
            getDPUpdate().AddNewParameter("Databasepeopleid1",objIndustryProjectInfo.getDatabasepeopleid1()); // 
            sbStr.append("	?,\n");//-- 统计人员
            getDPUpdate().AddNewParameter("Databasepeopleid2",objIndustryProjectInfo.getDatabasepeopleid2()); // 
            sbStr.append("	?,\n");//-- 登录人员
            getDPUpdate().AddNewParameter("Adminid",objIndustryProjectInfo.getAdminid()); // 
            sbStr.append("	?,\n");//-- 部门
            getDPUpdate().AddNewParameter("Sectorid",objIndustryProjectInfo.getSectorid()); // 
            sbStr.append("	?\n");//-- 登录时间
            getDPUpdate().AddNewParameter("Logintime",objIndustryProjectInfo.getLogintime()); // 
            sbStr.append(")\n");
            sbStr.append(";SELECT SCOPE_IDENTITY();\n");
            return sbStr.toString();
        }
        // [end]
        // [start] Insert
        /**
        * 向表t_industry_project 文化项目表中插入数据,返回DatabaseProjectID字段内容<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param objIndustryProjectInfo IndustryProjectInfo对象 文化项目表 
        * @return 字段IndustryProjectID 
        */
        public int Insert(IndustryProjectInfo objIndustryProjectInfo)
        {
            getDPUpdate().ClearParameter();
            int Databaseprojectid = (int)(getDPUpdate().RunSqlScalarByInsert(InsertReturnSQL(objIndustryProjectInfo)));
            objIndustryProjectInfo.setDatabaseprojectid(Databaseprojectid);//项目ID  数据类型:int
            getDPUpdate().Dispose();
            return Databaseprojectid;
        }
        // [end]

        // [end]

        // [start] Update
        // [start] UpdateByDatabaseprojectidReturnSQL
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 更新表t_industry_project 文化项目表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param objIndustryProjectInfo IndustryProjectInfo对象 文化项目表 
        * @return SQL语句 
        */
        public String UpdateByDatabaseprojectidReturnSQL(IndustryProjectInfo objIndustryProjectInfo)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("UPDATE [t_industry_project]\n");
            sbStr.append("SET\n");
            sbStr.append("	[ProjectID] = ?,\n");//-- 项目编号
            getDPUpdate().AddNewParameter("Projectid",objIndustryProjectInfo.getProjectid()); // 项目编号
            sbStr.append("	[ProjectName] = ?,\n");//-- 项目名称
            getDPUpdate().AddNewParameter("Projectname",objIndustryProjectInfo.getProjectname()); // 项目名称
            sbStr.append("	[DatabaseEnterpriseID] = ?,\n");//-- 经营单位
            getDPUpdate().AddNewParameter("Databaseenterpriseid",objIndustryProjectInfo.getDatabaseenterpriseid()); // 经营单位
            sbStr.append("	[ProQuality] = ?,\n");//-- 建设性质
            getDPUpdate().AddNewParameter("Proquality",objIndustryProjectInfo.getProquality()); // 建设性质
            sbStr.append("	[Address] = ?,\n");//-- 所在地址
            getDPUpdate().AddNewParameter("Address",objIndustryProjectInfo.getAddress()); // 所在地址
            sbStr.append("	[CreateTime] = ?,\n");//-- 创建时间
            getDPUpdate().AddNewParameter("Createtime",objIndustryProjectInfo.getCreatetime()); // 创建时间
            sbStr.append("	[plantime] = ?,\n");//-- 计划时间
            getDPUpdate().AddNewParameter("Plantime",objIndustryProjectInfo.getPlantime()); // 计划时间
            sbStr.append("	[CompleteTime] = ?,\n");//-- 完成时间
            if(objIndustryProjectInfo.getCompletetime()==null)
            {
            	getDPUpdate().AddNullParameter("Completetime", null);// 完成时间
            }
            else
            {
            	getDPUpdate().AddNewParameter("Completetime",objIndustryProjectInfo.getCompletetime()); // 完成时间
            }

            	
            sbStr.append("	[ProContent] = ?,\n");//-- 项目内容
            getDPUpdate().AddNewParameter("Procontent",objIndustryProjectInfo.getProcontent()); // 项目内容
            sbStr.append("	[planInvest] = ?,\n");//-- 计划投入资金
            getDPUpdate().AddNewParameter("Planinvest",objIndustryProjectInfo.getPlaninvest()); // 计划投入资金
            sbStr.append("	[TotalInvest] = ?,\n");//-- 实际投入资金
            getDPUpdate().AddNewParameter("Totalinvest",objIndustryProjectInfo.getTotalinvest()); // 实际投入资金
            sbStr.append("	[RealInvest] = ?,\n");//-- RealInvest
            getDPUpdate().AddNewParameter("Realinvest",objIndustryProjectInfo.getRealinvest()); // RealInvest
            sbStr.append("	[yearinvest] = ?,\n");//-- 本年投入资金
            getDPUpdate().AddNewParameter("Yearinvest",objIndustryProjectInfo.getYearinvest()); // 本年投入资金
            sbStr.append("	[publicinvest] = ?,\n");//-- 政府投资
            getDPUpdate().AddNewParameter("Publicinvest",objIndustryProjectInfo.getPublicinvest()); // 政府投资
            sbStr.append("	[selfinvest] = ?,\n");//-- 自筹
            getDPUpdate().AddNewParameter("Selfinvest",objIndustryProjectInfo.getSelfinvest()); // 自筹
            sbStr.append("	[bankloan] = ?,\n");//-- 银行
            getDPUpdate().AddNewParameter("Bankloan",objIndustryProjectInfo.getBankloan()); // 银行
            sbStr.append("	[shb] = ?,\n");//-- 审批,核准,备案
            getDPUpdate().AddNewParameter("Shb",objIndustryProjectInfo.getShb()); // 审批,核准,备案
            sbStr.append("	[hppf] = ?,\n");//-- 环评批复
            getDPUpdate().AddNewParameter("Hppf",objIndustryProjectInfo.getHppf()); // 环评批复
            sbStr.append("	[tdpz] = ?,\n");//-- 土地批准
            getDPUpdate().AddNewParameter("Tdpz",objIndustryProjectInfo.getTdpz()); // 土地批准
            sbStr.append("	[ghxz] = ?,\n");//-- 规划选址
            getDPUpdate().AddNewParameter("Ghxz",objIndustryProjectInfo.getGhxz()); // 规划选址
            sbStr.append("	[shbno] = ?,\n");//-- shbno
            getDPUpdate().AddNewParameter("Shbno",objIndustryProjectInfo.getShbno()); // shbno
            sbStr.append("	[hppfno] = ?,\n");//-- hppfno
            getDPUpdate().AddNewParameter("Hppfno",objIndustryProjectInfo.getHppfno()); // hppfno
            sbStr.append("	[tdpzno] = ?,\n");//-- tdpzno
            getDPUpdate().AddNewParameter("Tdpzno",objIndustryProjectInfo.getTdpzno()); // tdpzno
            sbStr.append("	[ghxzno] = ?,\n");//-- ghxzno
            getDPUpdate().AddNewParameter("Ghxzno",objIndustryProjectInfo.getGhxzno()); // ghxzno
            sbStr.append("	[RegionID] = ?,\n");//-- 所属区域
            getDPUpdate().AddNewParameter("Regionid",objIndustryProjectInfo.getRegionid()); // 所属区域
            sbStr.append("	[DutyUnitID] = ?,\n");//-- 主管单位
            getDPUpdate().AddNewParameter("Dutyunitid",objIndustryProjectInfo.getDutyunitid()); // 主管单位
            sbStr.append("	[IndustryID] = ?,\n");//-- 产业类别
            getDPUpdate().AddNewParameter("Industryid",objIndustryProjectInfo.getIndustryid()); // 产业类别
            sbStr.append("	[PlanProgress] = ?,\n");//-- 计划进度
            getDPUpdate().AddNewParameter("Planprogress",objIndustryProjectInfo.getPlanprogress()); // 计划进度
            sbStr.append("	[RealProgress] = ?,\n");//-- 实际进度
            getDPUpdate().AddNewParameter("Realprogress",objIndustryProjectInfo.getRealprogress()); // 实际进度
            sbStr.append("	[Feature] = ?,\n");//-- 项目特色
            getDPUpdate().AddNewParameter("Feature",objIndustryProjectInfo.getFeature()); // 项目特色
            sbStr.append("	[State] = ?,\n");//-- 经营状况
            getDPUpdate().AddNewParameter("State",objIndustryProjectInfo.getState()); // 经营状况
            sbStr.append("	[linkman] = ?,\n");//-- linkman
            getDPUpdate().AddNewParameter("Linkman",objIndustryProjectInfo.getLinkman()); // linkman
            sbStr.append("	[phone] = ?,\n");//-- phone
            getDPUpdate().AddNewParameter("Phone",objIndustryProjectInfo.getPhone()); // phone
            sbStr.append("	[comment] = ?,\n");//-- comment
            getDPUpdate().AddNewParameter("Comment",objIndustryProjectInfo.getComment()); // comment
            sbStr.append("	[Pic] = ?,\n");//-- 项目图片
            getDPUpdate().AddNewParameter("Pic",objIndustryProjectInfo.getPic()); // 项目图片
            sbStr.append("	[DatabasePeopleID1] = ?,\n");//-- 填表人员
            getDPUpdate().AddNewParameter("Databasepeopleid1",objIndustryProjectInfo.getDatabasepeopleid1()); // 填表人员
            sbStr.append("	[DatabasePeopleID2] = ?,\n");//-- 统计人员
            getDPUpdate().AddNewParameter("Databasepeopleid2",objIndustryProjectInfo.getDatabasepeopleid2()); // 统计人员
            sbStr.append("	[AdminID] = ?,\n");//-- 登录人员
            getDPUpdate().AddNewParameter("Adminid",objIndustryProjectInfo.getAdminid()); // 登录人员
            sbStr.append("	[SectorID] = ?,\n");//-- 部门
            getDPUpdate().AddNewParameter("Sectorid",objIndustryProjectInfo.getSectorid()); // 部门
            sbStr.append("	[LoginTime] = ?\n");//-- 登录时间
            getDPUpdate().AddNewParameter("Logintime",objIndustryProjectInfo.getLogintime()); // 登录时间
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseProjectID] = ?\n");//-- 项目ID
            getDPUpdate().AddNewParameter("Databaseprojectid",objIndustryProjectInfo.getDatabaseprojectid() ); // 项目ID
            return sbStr.toString();
        }
        // [end]
        // [start] UpdateByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 更新表t_industry_project 文化项目表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param objIndustryProjectInfo IndustryProjectInfo对象 文化项目表 
        */
        public void UpdateByDatabaseprojectid(IndustryProjectInfo objIndustryProjectInfo)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(UpdateByDatabaseprojectidReturnSQL(objIndustryProjectInfo));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

        // [start] Delete
        // [start] DeleteByDatabaseprojectidReturnSQL
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 删除数据表t_industry_project 文化项目表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param Databaseprojectid 项目ID 
        * @return SQL语句 
        */
        public String DeleteByDatabaseprojectidReturnSQL(int Databaseprojectid)
        {
            StringBuilder sbStr = new StringBuilder(1024);
            sbStr.append("DELETE\n");
            sbStr.append("FROM [t_industry_project]\n");
            sbStr.append("WHERE\n");
            sbStr.append("	 [DatabaseProjectID] = ?\n");//-- 项目ID
            getDPUpdate().AddNewParameter("Databaseprojectid",Databaseprojectid ); // 项目ID
            return sbStr.toString();
        }
        // [end]
        // [start] DeleteByDatabaseprojectid
        /**
        * 根据 <br />
    * DatabaseProjectID Databaseprojectid 项目ID<br />
 删除数据表t_industry_project 文化项目表中的内容<br />
        * 开发者 贾军磊 2012年12月26日 10:58:19
        * @param Databaseprojectid 项目ID 
        */
        public void DeleteByDatabaseprojectid(int Databaseprojectid)
        {
            getDPUpdate().ClearParameter();
            getDPUpdate().RunSql(DeleteByDatabaseprojectidReturnSQL(Databaseprojectid));
            getDPUpdate().Dispose();
        }
        // [end]

        // [end]

}
