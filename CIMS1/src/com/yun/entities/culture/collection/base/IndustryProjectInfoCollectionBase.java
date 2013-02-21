package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.IndustryProjectInfoBase.*;

/**
 * IndustryProject 文化项目表的摘要说明
 */
public class IndustryProjectInfoCollectionBase extends ArrayList<IndustryProjectInfo> implements List<IndustryProjectInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120518324593729L;

	// [start] 根据主键或自增字段返回IndustryProjectInfo

        // [start] GetIndustryProjectInfoByDatabaseprojectid
        // [start] GetIndustryProjectInfoByDatabaseprojectid
        /**
        * 根据DatabaseProjectID获取表 文化项目表的对象IndustryProjectInfo
        * @param Databaseprojectid 项目ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryProjectInfo对象实体
        */
        public IndustryProjectInfo GetIndustryProjectInfoByDatabaseprojectid(int Databaseprojectid)
        {
              return GetIndustryProjectInfoByDatabaseprojectid(Databaseprojectid,  true);
        }
        // [end]

        // [start] GetIndustryProjectInfoByDatabaseprojectid
        private int GetIndustryProjectInfoByDatabaseprojectid_Databaseprojectid = 0;//项目ID
        private IndustryProjectInfo GetIndustryProjectInfoByDatabaseprojectid_IndustryProjectInfo;
        /**
        * 根据DatabaseProjectID获取表 文化项目表的对象IndustryProjectInfo
        * @param Databaseprojectid 项目ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryProjectInfo对象实体
        */
        public IndustryProjectInfo GetIndustryProjectInfoByDatabaseprojectid(int Databaseprojectid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetIndustryProjectInfoByDatabaseprojectid_IndustryProjectInfo = null;
                if (GetIndustryProjectInfoByDatabaseprojectid_IndustryProjectInfo == null || GetIndustryProjectInfoByDatabaseprojectid_Databaseprojectid != Databaseprojectid)
            {
            for (IndustryProjectInfo objIndustryProjectInfo : this)
            {
                if (objIndustryProjectInfo.getDatabaseprojectid() == Databaseprojectid)
                {
                    GetIndustryProjectInfoByDatabaseprojectid_IndustryProjectInfo = objIndustryProjectInfo;
                    GetIndustryProjectInfoByDatabaseprojectid_Databaseprojectid = Databaseprojectid;//项目ID
                    return objIndustryProjectInfo;
                }
            }
            return null;
            }
            else
            {
                return GetIndustryProjectInfoByDatabaseprojectid_IndustryProjectInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabaseprojectid
        /**
        * 根据DatabaseProjectID获取表 文化项目表的对象IndustryProjectInfo 的位置
        * @param Databaseprojectid 项目ID 
        * @return IndustryProjectInfo对象实体 的位置
        */
        public int GetIndexByDatabaseprojectid(int Databaseprojectid)
        {
             int index = 0;
            for (IndustryProjectInfo objIndustryProjectInfo : this)
            {
                if (objIndustryProjectInfo.getDatabaseprojectid() == Databaseprojectid)
                {
                    return index;
                }
                index ++;
            }
                return -1;
        }
        // [end]

        // [end]


	// [end]

	// [start] 根据索引返回IndustryProjectInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public IndustryProjectInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new IndustryProjectInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
		for (int i = startIndex; i <= endIndex; i++)
		{
			list.add(this.get(i));
		}
		return list;
	}
	// [end]

	// [start] 复制实体
    /**
     * 复制实体
     */
    public IndustryProjectInfoCollection Copy()
    {
        IndustryProjectInfoCollection list = new IndustryProjectInfoCollection();
        for (IndustryProjectInfo objIndustryProjectInfo : this)
        {
            list.add(objIndustryProjectInfo.Copy());
        }
        return list;
    }
	// [end]



	// [start] GetXml 返回存储在实体类中的Xml表现形式
	/**
	 * GetXml 返回存储在实体类中的Xml表现形式
	 */
	public String GetXml()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sbStr.append("<ArrayOfIndustryProjectInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (IndustryProjectInfo objIndustryProjectInfo : this)
		{
			sbStr.append("  <IndustryProjectInfo>\n");
            //项目ID
			sbStr.append("    <Databaseprojectid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getDatabaseprojectid()));
			sbStr.append("</Databaseprojectid>\n");
            //项目编号
			sbStr.append("    <Projectid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getProjectid()));
			sbStr.append("</Projectid>\n");
            //项目名称
			sbStr.append("    <Projectname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getProjectname()));
			sbStr.append("</Projectname>\n");
            //经营单位
			sbStr.append("    <Databaseenterpriseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getDatabaseenterpriseid()));
			sbStr.append("</Databaseenterpriseid>\n");
            //建设性质
			sbStr.append("    <Proquality>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getProquality()));
			sbStr.append("</Proquality>\n");
            //所在地址
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getAddress()));
			sbStr.append("</Address>\n");
            //创建时间
			sbStr.append("    <Createtime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getCreatetime()));
			sbStr.append("</Createtime>\n");
            //计划时间
			sbStr.append("    <Plantime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPlantime()));
			sbStr.append("</Plantime>\n");
            //完成时间
			sbStr.append("    <Completetime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getCompletetime()));
			sbStr.append("</Completetime>\n");
            //项目内容
			sbStr.append("    <Procontent>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getProcontent()));
			sbStr.append("</Procontent>\n");
            //计划投入资金
			sbStr.append("    <Planinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPlaninvest()));
			sbStr.append("</Planinvest>\n");
            //实际投入资金
			sbStr.append("    <Totalinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getTotalinvest()));
			sbStr.append("</Totalinvest>\n");
            //RealInvest
			sbStr.append("    <Realinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getRealinvest()));
			sbStr.append("</Realinvest>\n");
            //本年投入资金
			sbStr.append("    <Yearinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getYearinvest()));
			sbStr.append("</Yearinvest>\n");
            //政府投资
			sbStr.append("    <Publicinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPublicinvest()));
			sbStr.append("</Publicinvest>\n");
            //自筹
			sbStr.append("    <Selfinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getSelfinvest()));
			sbStr.append("</Selfinvest>\n");
            //银行
			sbStr.append("    <Bankloan>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getBankloan()));
			sbStr.append("</Bankloan>\n");
            //审批,核准,备案
			sbStr.append("    <Shb>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getShb()));
			sbStr.append("</Shb>\n");
            //环评批复
			sbStr.append("    <Hppf>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getHppf()));
			sbStr.append("</Hppf>\n");
            //土地批准
			sbStr.append("    <Tdpz>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getTdpz()));
			sbStr.append("</Tdpz>\n");
            //规划选址
			sbStr.append("    <Ghxz>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getGhxz()));
			sbStr.append("</Ghxz>\n");
            //所属区域
			sbStr.append("    <Regionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getRegionid()));
			sbStr.append("</Regionid>\n");
            //主管单位
			sbStr.append("    <Dutyunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getDutyunitid()));
			sbStr.append("</Dutyunitid>\n");
            //产业类别
			sbStr.append("    <Industryid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getIndustryid()));
			sbStr.append("</Industryid>\n");
            //计划进度
			sbStr.append("    <Planprogress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPlanprogress()));
			sbStr.append("</Planprogress>\n");
            //实际进度
			sbStr.append("    <Realprogress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getRealprogress()));
			sbStr.append("</Realprogress>\n");
            //项目特色
			sbStr.append("    <Feature>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getFeature()));
			sbStr.append("</Feature>\n");
            //经营状况
			sbStr.append("    <State>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getState()));
			sbStr.append("</State>\n");
            //linkman
			sbStr.append("    <Linkman>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getLinkman()));
			sbStr.append("</Linkman>\n");
            //phone
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPhone()));
			sbStr.append("</Phone>\n");
            //comment
			sbStr.append("    <Comment>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getComment()));
			sbStr.append("</Comment>\n");
            //项目图片
			sbStr.append("    <Pic>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getPic()));
			sbStr.append("</Pic>\n");
            //填表人员
			sbStr.append("    <Databasepeopleid1>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getDatabasepeopleid1()));
			sbStr.append("</Databasepeopleid1>\n");
            //统计人员
			sbStr.append("    <Databasepeopleid2>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getDatabasepeopleid2()));
			sbStr.append("</Databasepeopleid2>\n");
            //登录人员
			sbStr.append("    <Adminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getAdminid()));
			sbStr.append("</Adminid>\n");
            //部门
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //登录时间
			sbStr.append("    <Logintime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryProjectInfo.getLogintime()));
			sbStr.append("</Logintime>\n");
			sbStr.append("  </IndustryProjectInfo>\n");
		}
		sbStr.append("</ArrayOfIndustryProjectInfo>\n");
		return sbStr.toString();
	}
	// [end]

	// [start] Save 保存实体类到文件
	/**
	 * 保存实体类到文件
	 */
	public void Save(String filename)
	{
		com.colorwinglib.FileFormat.CreateFiles(filename, GetXml(), com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// 反序列化类
	// GetIndustryProjectInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryProjectInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryProjectInfoCollection GetIndustryProjectInfoCollectionFormFileName(String filename)
	{
		return GetIndustryProjectInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryProjectInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryProjectInfoCollection GetIndustryProjectInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryProjectInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryProjectInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryProjectInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryProjectInfoCollection GetIndustryProjectInfoCollectionFormXml(String xml)
	{
		return GetIndustryProjectInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryProjectInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryProjectInfoCollection GetIndustryProjectInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryProjectInfoCollection objIndustryProjectInfoCollection = new IndustryProjectInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("IndustryProjectInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				IndustryProjectInfo objIndustryProjectInfo = new IndustryProjectInfo();
				//项目ID
				if (foo.elementText("Databaseprojectid") != null)
					objIndustryProjectInfo.setDatabaseprojectid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseprojectid")));
				//项目编号
				if (foo.elementText("Projectid") != null)
					objIndustryProjectInfo.setProjectid(com.colorwinglib.Converts.StrToInt(foo.elementText("Projectid")));
				//项目名称
				if (foo.elementText("Projectname") != null)
					objIndustryProjectInfo.setProjectname(com.colorwinglib.Converts.objToStr(foo.elementText("Projectname")));
				//经营单位
				if (foo.elementText("Databaseenterpriseid") != null)
					objIndustryProjectInfo.setDatabaseenterpriseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseenterpriseid")));
				//建设性质
				if (foo.elementText("Proquality") != null)
					objIndustryProjectInfo.setProquality(com.colorwinglib.Converts.StrToInt(foo.elementText("Proquality")));
				//所在地址
				if (foo.elementText("Address") != null)
					objIndustryProjectInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				//创建时间
				if (foo.elementText("Createtime") != null)
					objIndustryProjectInfo.setCreatetime(com.colorwinglib.Converts.StrToDate(foo.elementText("Createtime")));
				//计划时间
				if (foo.elementText("Plantime") != null)
					objIndustryProjectInfo.setPlantime(com.colorwinglib.Converts.StrToDate(foo.elementText("Plantime")));
				//完成时间
				if (foo.elementText("Completetime") != null)
					objIndustryProjectInfo.setCompletetime(com.colorwinglib.Converts.StrToDate(foo.elementText("Completetime")));
				//项目内容
				if (foo.elementText("Procontent") != null)
					objIndustryProjectInfo.setProcontent(com.colorwinglib.Converts.objToStr(foo.elementText("Procontent")));
				//计划投入资金
				if (foo.elementText("Planinvest") != null)
					objIndustryProjectInfo.setPlaninvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Planinvest")));
				//实际投入资金
				if (foo.elementText("Totalinvest") != null)
					objIndustryProjectInfo.setTotalinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Totalinvest")));
				//RealInvest
				if (foo.elementText("Realinvest") != null)
					objIndustryProjectInfo.setRealinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Realinvest")));
				//本年投入资金
				if (foo.elementText("Yearinvest") != null)
					objIndustryProjectInfo.setYearinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Yearinvest")));
				//政府投资
				if (foo.elementText("Publicinvest") != null)
					objIndustryProjectInfo.setPublicinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Publicinvest")));
				//自筹
				if (foo.elementText("Selfinvest") != null)
					objIndustryProjectInfo.setSelfinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Selfinvest")));
				//银行
				if (foo.elementText("Bankloan") != null)
					objIndustryProjectInfo.setBankloan(com.colorwinglib.Converts.StrToFloat(foo.elementText("Bankloan")));
				//审批,核准,备案
				if (foo.elementText("Shb") != null)
					objIndustryProjectInfo.setShb(com.colorwinglib.Converts.StrToInt(foo.elementText("Shb")));
				//环评批复
				if (foo.elementText("Hppf") != null)
					objIndustryProjectInfo.setHppf(com.colorwinglib.Converts.StrToInt(foo.elementText("Hppf")));
				//土地批准
				if (foo.elementText("Tdpz") != null)
					objIndustryProjectInfo.setTdpz(com.colorwinglib.Converts.StrToInt(foo.elementText("Tdpz")));
				//规划选址
				if (foo.elementText("Ghxz") != null)
					objIndustryProjectInfo.setGhxz(com.colorwinglib.Converts.StrToInt(foo.elementText("Ghxz")));
				//所属区域
				if (foo.elementText("Regionid") != null)
					objIndustryProjectInfo.setRegionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Regionid")));
				//主管单位
				if (foo.elementText("Dutyunitid") != null)
					objIndustryProjectInfo.setDutyunitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Dutyunitid")));
				//产业类别
				if (foo.elementText("Industryid") != null)
					objIndustryProjectInfo.setIndustryid(com.colorwinglib.Converts.StrToInt(foo.elementText("Industryid")));
				//计划进度
				if (foo.elementText("Planprogress") != null)
					objIndustryProjectInfo.setPlanprogress(com.colorwinglib.Converts.objToStr(foo.elementText("Planprogress")));
				//实际进度
				if (foo.elementText("Realprogress") != null)
					objIndustryProjectInfo.setRealprogress(com.colorwinglib.Converts.objToStr(foo.elementText("Realprogress")));
				//项目特色
				if (foo.elementText("Feature") != null)
					objIndustryProjectInfo.setFeature(com.colorwinglib.Converts.objToStr(foo.elementText("Feature")));
				//经营状况
				if (foo.elementText("State") != null)
					objIndustryProjectInfo.setState(com.colorwinglib.Converts.objToStr(foo.elementText("State")));
				//linkman
				if (foo.elementText("Linkman") != null)
					objIndustryProjectInfo.setLinkman(com.colorwinglib.Converts.objToStr(foo.elementText("Linkman")));
				//phone
				if (foo.elementText("Phone") != null)
					objIndustryProjectInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//comment
				if (foo.elementText("Comment") != null)
					objIndustryProjectInfo.setComment(com.colorwinglib.Converts.objToStr(foo.elementText("Comment")));
				//项目图片
				if (foo.elementText("Pic") != null)
					objIndustryProjectInfo.setPic(com.colorwinglib.Converts.objToStr(foo.elementText("Pic")));
				//填表人员
				if (foo.elementText("Databasepeopleid1") != null)
					objIndustryProjectInfo.setDatabasepeopleid1(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid1")));
				//统计人员
				if (foo.elementText("Databasepeopleid2") != null)
					objIndustryProjectInfo.setDatabasepeopleid2(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid2")));
				//登录人员
				if (foo.elementText("Adminid") != null)
					objIndustryProjectInfo.setAdminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Adminid")));
				//部门
				if (foo.elementText("Sectorid") != null)
					objIndustryProjectInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//登录时间
				if (foo.elementText("Logintime") != null)
					objIndustryProjectInfo.setLogintime(com.colorwinglib.Converts.StrToDate(foo.elementText("Logintime")));
				objIndustryProjectInfoCollection.add(objIndustryProjectInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryProjectInfoCollection;
	}
	// [end]

	// [start] 排序
	/**
	 * 排序
	 *
	 * @param columnName
	 *            排序字段
	 * @param isAsc
	 *            排序的顺序
	 */
        public boolean sort(String columnName, boolean isAsc)
        {
		//项目ID
		if ("Databaseprojectid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Databaseprojectid, isAsc);
		}

		//项目编号
		if ("Projectid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Projectid, isAsc);
		}

		//项目名称
		if ("Projectname".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Projectname, isAsc);
		}

		//经营单位
		if ("Databaseenterpriseid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Databaseenterpriseid, isAsc);
		}

		//建设性质
		if ("Proquality".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Proquality, isAsc);
		}

		//所在地址
		if ("Address".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Address, isAsc);
		}

		//创建时间
		if ("Createtime".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Createtime, isAsc);
		}

		//计划时间
		if ("Plantime".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Plantime, isAsc);
		}

		//完成时间
		if ("Completetime".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Completetime, isAsc);
		}

		//项目内容
		if ("Procontent".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Procontent, isAsc);
		}

		//计划投入资金
		if ("Planinvest".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Planinvest, isAsc);
		}

		//实际投入资金
		if ("Totalinvest".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Totalinvest, isAsc);
		}

		//RealInvest
		if ("Realinvest".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Realinvest, isAsc);
		}

		//本年投入资金
		if ("Yearinvest".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Yearinvest, isAsc);
		}

		//政府投资
		if ("Publicinvest".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Publicinvest, isAsc);
		}

		//自筹
		if ("Selfinvest".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Selfinvest, isAsc);
		}

		//银行
		if ("Bankloan".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Bankloan, isAsc);
		}

		//审批,核准,备案
		if ("Shb".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Shb, isAsc);
		}

		//环评批复
		if ("Hppf".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Hppf, isAsc);
		}

		//土地批准
		if ("Tdpz".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Tdpz, isAsc);
		}

		//规划选址
		if ("Ghxz".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Ghxz, isAsc);
		}

		//所属区域
		if ("Regionid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Regionid, isAsc);
		}

		//主管单位
		if ("Dutyunitid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Dutyunitid, isAsc);
		}

		//产业类别
		if ("Industryid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Industryid, isAsc);
		}

		//计划进度
		if ("Planprogress".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Planprogress, isAsc);
		}

		//实际进度
		if ("Realprogress".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Realprogress, isAsc);
		}

		//项目特色
		if ("Feature".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Feature, isAsc);
		}

		//经营状况
		if ("State".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.State, isAsc);
		}

		//linkman
		if ("Linkman".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Linkman, isAsc);
		}

		//phone
		if ("Phone".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Phone, isAsc);
		}

		//comment
		if ("Comment".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Comment, isAsc);
		}

		//项目图片
		if ("Pic".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Pic, isAsc);
		}

		//填表人员
		if ("Databasepeopleid1".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Databasepeopleid1, isAsc);
		}

		//统计人员
		if ("Databasepeopleid2".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Databasepeopleid2, isAsc);
		}

		//登录人员
		if ("Adminid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Adminid, isAsc);
		}

		//部门
		if ("Sectorid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Sectorid, isAsc);
		}

		//登录时间
		if ("Logintime".equals(columnName) && isAsc == true)
		{
          return sort(IndustryProjectColumnNameEnum.Logintime, isAsc);
		}


            return false;
        }
	// [end]

	// [start] 排序
	/**
	 * 排序
	 *
	 * @param columnNameEnu
	 *            排序字段
	 * @param isAsc
	 *            排序的顺序
	 */
	public boolean sort(IndustryProjectColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//项目ID
		if (IndustryProjectColumnNameEnum.Databaseprojectid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectDatabaseprojectidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Databaseprojectid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectDatabaseprojectidComparatorDesc());// 倒叙
			return true;
		}

		//项目编号
		if (IndustryProjectColumnNameEnum.Projectid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectProjectidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Projectid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectProjectidComparatorDesc());// 倒叙
			return true;
		}

		//项目名称
		if (IndustryProjectColumnNameEnum.Projectname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectProjectnameComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Projectname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectProjectnameComparatorDesc());// 倒叙
			return true;
		}

		//经营单位
		if (IndustryProjectColumnNameEnum.Databaseenterpriseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectDatabaseenterpriseidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Databaseenterpriseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectDatabaseenterpriseidComparatorDesc());// 倒叙
			return true;
		}

		//建设性质
		if (IndustryProjectColumnNameEnum.Proquality.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectProqualityComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Proquality.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectProqualityComparatorDesc());// 倒叙
			return true;
		}

		//所在地址
		if (IndustryProjectColumnNameEnum.Address.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectAddressComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Address.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectAddressComparatorDesc());// 倒叙
			return true;
		}

		//创建时间
		if (IndustryProjectColumnNameEnum.Createtime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectCreatetimeComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Createtime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectCreatetimeComparatorDesc());// 倒叙
			return true;
		}

		//计划时间
		if (IndustryProjectColumnNameEnum.Plantime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectPlantimeComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Plantime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectPlantimeComparatorDesc());// 倒叙
			return true;
		}

		//完成时间
		if (IndustryProjectColumnNameEnum.Completetime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectCompletetimeComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Completetime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectCompletetimeComparatorDesc());// 倒叙
			return true;
		}

		//项目内容
		if (IndustryProjectColumnNameEnum.Procontent.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectProcontentComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Procontent.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectProcontentComparatorDesc());// 倒叙
			return true;
		}

		//计划投入资金
		if (IndustryProjectColumnNameEnum.Planinvest.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectPlaninvestComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Planinvest.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectPlaninvestComparatorDesc());// 倒叙
			return true;
		}

		//实际投入资金
		if (IndustryProjectColumnNameEnum.Totalinvest.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectTotalinvestComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Totalinvest.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectTotalinvestComparatorDesc());// 倒叙
			return true;
		}

		//RealInvest
		if (IndustryProjectColumnNameEnum.Realinvest.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectRealinvestComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Realinvest.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectRealinvestComparatorDesc());// 倒叙
			return true;
		}

		//本年投入资金
		if (IndustryProjectColumnNameEnum.Yearinvest.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectYearinvestComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Yearinvest.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectYearinvestComparatorDesc());// 倒叙
			return true;
		}

		//政府投资
		if (IndustryProjectColumnNameEnum.Publicinvest.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectPublicinvestComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Publicinvest.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectPublicinvestComparatorDesc());// 倒叙
			return true;
		}

		//自筹
		if (IndustryProjectColumnNameEnum.Selfinvest.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectSelfinvestComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Selfinvest.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectSelfinvestComparatorDesc());// 倒叙
			return true;
		}

		//银行
		if (IndustryProjectColumnNameEnum.Bankloan.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectBankloanComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Bankloan.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectBankloanComparatorDesc());// 倒叙
			return true;
		}

		//审批,核准,备案
		if (IndustryProjectColumnNameEnum.Shb.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectShbComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Shb.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectShbComparatorDesc());// 倒叙
			return true;
		}

		//环评批复
		if (IndustryProjectColumnNameEnum.Hppf.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectHppfComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Hppf.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectHppfComparatorDesc());// 倒叙
			return true;
		}

		//土地批准
		if (IndustryProjectColumnNameEnum.Tdpz.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectTdpzComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Tdpz.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectTdpzComparatorDesc());// 倒叙
			return true;
		}

		//规划选址
		if (IndustryProjectColumnNameEnum.Ghxz.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectGhxzComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Ghxz.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectGhxzComparatorDesc());// 倒叙
			return true;
		}

		//所属区域
		if (IndustryProjectColumnNameEnum.Regionid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectRegionidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Regionid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectRegionidComparatorDesc());// 倒叙
			return true;
		}

		//主管单位
		if (IndustryProjectColumnNameEnum.Dutyunitid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectDutyunitidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Dutyunitid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectDutyunitidComparatorDesc());// 倒叙
			return true;
		}

		//产业类别
		if (IndustryProjectColumnNameEnum.Industryid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectIndustryidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Industryid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectIndustryidComparatorDesc());// 倒叙
			return true;
		}

		//计划进度
		if (IndustryProjectColumnNameEnum.Planprogress.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectPlanprogressComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Planprogress.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectPlanprogressComparatorDesc());// 倒叙
			return true;
		}

		//实际进度
		if (IndustryProjectColumnNameEnum.Realprogress.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectRealprogressComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Realprogress.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectRealprogressComparatorDesc());// 倒叙
			return true;
		}

		//项目特色
		if (IndustryProjectColumnNameEnum.Feature.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectFeatureComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Feature.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectFeatureComparatorDesc());// 倒叙
			return true;
		}

		//经营状况
		if (IndustryProjectColumnNameEnum.State.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectStateComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.State.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectStateComparatorDesc());// 倒叙
			return true;
		}

		//linkman
		if (IndustryProjectColumnNameEnum.Linkman.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectLinkmanComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Linkman.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectLinkmanComparatorDesc());// 倒叙
			return true;
		}

		//phone
		if (IndustryProjectColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectPhoneComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectPhoneComparatorDesc());// 倒叙
			return true;
		}

		//comment
		if (IndustryProjectColumnNameEnum.Comment.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectCommentComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Comment.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectCommentComparatorDesc());// 倒叙
			return true;
		}

		//项目图片
		if (IndustryProjectColumnNameEnum.Pic.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectPicComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Pic.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectPicComparatorDesc());// 倒叙
			return true;
		}

		//填表人员
		if (IndustryProjectColumnNameEnum.Databasepeopleid1.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectDatabasepeopleid1ComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Databasepeopleid1.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectDatabasepeopleid1ComparatorDesc());// 倒叙
			return true;
		}

		//统计人员
		if (IndustryProjectColumnNameEnum.Databasepeopleid2.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectDatabasepeopleid2ComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Databasepeopleid2.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectDatabasepeopleid2ComparatorDesc());// 倒叙
			return true;
		}

		//登录人员
		if (IndustryProjectColumnNameEnum.Adminid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectAdminidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Adminid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectAdminidComparatorDesc());// 倒叙
			return true;
		}

		//部门
		if (IndustryProjectColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectSectoridComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectSectoridComparatorDesc());// 倒叙
			return true;
		}

		//登录时间
		if (IndustryProjectColumnNameEnum.Logintime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryProjectLogintimeComparatorAsc());// 顺序
			return true;
		}
		if (IndustryProjectColumnNameEnum.Logintime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryProjectLogintimeComparatorDesc());// 倒叙
			return true;
		}

		return false;
	}
	// [end]


	// [start] toJSONArray 返回JSONArray
	/**
	 * 返回JSONArray
	 */
	public org.json.JSONArray toJSONArray()
	{
		org.json.JSONArray objJSONArray = new org.json.JSONArray();
		for (IndustryProjectInfo objIndustryProjectInfo : this)
		{
			objJSONArray.put(objIndustryProjectInfo.toJson());
		}
		return objJSONArray;
	}

	// [end]

	// [start] FromJSONArray 通过Json填充数据
	/**
	 * 通过Json填充数据
	 */
	public void FromJSONArray(String strJson)
	{
		try
		{
			org.json.JSONArray objJSONArray = new org.json.JSONArray(strJson);
			for (int i = 0; i < objJSONArray.length(); i++)
			{
				IndustryProjectInfo objIndustryProjectInfo = new IndustryProjectInfo();
				objIndustryProjectInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objIndustryProjectInfo);
			}

		}
		catch (org.json.JSONException e)
		{
			e.printStackTrace();
		}
	}

	// [end]

}

	// [start] 排序
	// [start] 按 Databaseprojectid 项目ID 正序排序
/**
 * 按 Databaseprojectid 项目ID 正序排序
 *
 */
class IndustryProjectDatabaseprojectidComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDatabaseprojectid() > arg1.getDatabaseprojectid())
			return 1;
		else if (arg0.getDatabaseprojectid() < arg1.getDatabaseprojectid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databaseprojectid 项目ID 倒叙排序
/**
 * 按 Databaseprojectid 项目ID 倒叙排序
 *
 */
class IndustryProjectDatabaseprojectidComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDatabaseprojectid() > arg1.getDatabaseprojectid())
			return -1;
		else if (arg0.getDatabaseprojectid() < arg1.getDatabaseprojectid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Projectid 项目编号 正序排序
/**
 * 按 Projectid 项目编号 正序排序
 *
 */
class IndustryProjectProjectidComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getProjectid() > arg1.getProjectid())
			return 1;
		else if (arg0.getProjectid() < arg1.getProjectid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Projectid 项目编号 倒叙排序
/**
 * 按 Projectid 项目编号 倒叙排序
 *
 */
class IndustryProjectProjectidComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getProjectid() > arg1.getProjectid())
			return -1;
		else if (arg0.getProjectid() < arg1.getProjectid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Projectname 项目名称正序排序
/**
 * 按 Projectname 项目名称 正序排序
 *
 */
class IndustryProjectProjectnameComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getProjectname().toLowerCase().compareTo(arg1.getProjectname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Projectname 项目名称 倒叙排序
/**
 * 按 Projectname 项目名称 倒叙排序
 *
 */
class IndustryProjectProjectnameComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getProjectname().toLowerCase().compareTo(arg0.getProjectname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Databaseenterpriseid 经营单位 正序排序
/**
 * 按 Databaseenterpriseid 经营单位 正序排序
 *
 */
class IndustryProjectDatabaseenterpriseidComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDatabaseenterpriseid() > arg1.getDatabaseenterpriseid())
			return 1;
		else if (arg0.getDatabaseenterpriseid() < arg1.getDatabaseenterpriseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databaseenterpriseid 经营单位 倒叙排序
/**
 * 按 Databaseenterpriseid 经营单位 倒叙排序
 *
 */
class IndustryProjectDatabaseenterpriseidComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDatabaseenterpriseid() > arg1.getDatabaseenterpriseid())
			return -1;
		else if (arg0.getDatabaseenterpriseid() < arg1.getDatabaseenterpriseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Proquality 建设性质 正序排序
/**
 * 按 Proquality 建设性质 正序排序
 *
 */
class IndustryProjectProqualityComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getProquality() > arg1.getProquality())
			return 1;
		else if (arg0.getProquality() < arg1.getProquality())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Proquality 建设性质 倒叙排序
/**
 * 按 Proquality 建设性质 倒叙排序
 *
 */
class IndustryProjectProqualityComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getProquality() > arg1.getProquality())
			return -1;
		else if (arg0.getProquality() < arg1.getProquality())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Address 所在地址正序排序
/**
 * 按 Address 所在地址 正序排序
 *
 */
class IndustryProjectAddressComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getAddress().toLowerCase().compareTo(arg1.getAddress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Address 所在地址 倒叙排序
/**
 * 按 Address 所在地址 倒叙排序
 *
 */
class IndustryProjectAddressComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getAddress().toLowerCase().compareTo(arg0.getAddress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Createtime 创建时间正序排序
/**
 * 按 Createtime 创建时间 正序排序
 *
 */
class IndustryProjectCreatetimeComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getCreatetime().compareTo(arg1.getCreatetime());
	}
}
	// [end]

	// [start] 按 Createtime 创建时间 倒叙排序
/**
 * 按 Createtime 创建时间 倒叙排序
 *
 */
class IndustryProjectCreatetimeComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getCreatetime().compareTo(arg0.getCreatetime());
	}
}
	// [end]


	// [start] 按 Plantime 计划时间正序排序
/**
 * 按 Plantime 计划时间 正序排序
 *
 */
class IndustryProjectPlantimeComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getPlantime().compareTo(arg1.getPlantime());
	}
}
	// [end]

	// [start] 按 Plantime 计划时间 倒叙排序
/**
 * 按 Plantime 计划时间 倒叙排序
 *
 */
class IndustryProjectPlantimeComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getPlantime().compareTo(arg0.getPlantime());
	}
}
	// [end]


	// [start] 按 Completetime 完成时间正序排序
/**
 * 按 Completetime 完成时间 正序排序
 *
 */
class IndustryProjectCompletetimeComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getCompletetime().compareTo(arg1.getCompletetime());
	}
}
	// [end]

	// [start] 按 Completetime 完成时间 倒叙排序
/**
 * 按 Completetime 完成时间 倒叙排序
 *
 */
class IndustryProjectCompletetimeComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getCompletetime().compareTo(arg0.getCompletetime());
	}
}
	// [end]


	// [start] 按 Procontent 项目内容正序排序
/**
 * 按 Procontent 项目内容 正序排序
 *
 */
class IndustryProjectProcontentComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getProcontent().toLowerCase().compareTo(arg1.getProcontent().toLowerCase());
	}
}
	// [end]

	// [start] 按 Procontent 项目内容 倒叙排序
/**
 * 按 Procontent 项目内容 倒叙排序
 *
 */
class IndustryProjectProcontentComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getProcontent().toLowerCase().compareTo(arg0.getProcontent().toLowerCase());
	}
}
	// [end]


	// [start] 按 Planinvest 计划投入资金 正序排序
/**
 * 按 Planinvest 计划投入资金 正序排序
 *
 */
class IndustryProjectPlaninvestComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getPlaninvest() > arg1.getPlaninvest())
			return 1;
		else if (arg0.getPlaninvest() < arg1.getPlaninvest())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Planinvest 计划投入资金 倒叙排序
/**
 * 按 Planinvest 计划投入资金 倒叙排序
 *
 */
class IndustryProjectPlaninvestComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getPlaninvest() > arg1.getPlaninvest())
			return -1;
		else if (arg0.getPlaninvest() < arg1.getPlaninvest())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Totalinvest 实际投入资金 正序排序
/**
 * 按 Totalinvest 实际投入资金 正序排序
 *
 */
class IndustryProjectTotalinvestComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getTotalinvest() > arg1.getTotalinvest())
			return 1;
		else if (arg0.getTotalinvest() < arg1.getTotalinvest())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Totalinvest 实际投入资金 倒叙排序
/**
 * 按 Totalinvest 实际投入资金 倒叙排序
 *
 */
class IndustryProjectTotalinvestComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getTotalinvest() > arg1.getTotalinvest())
			return -1;
		else if (arg0.getTotalinvest() < arg1.getTotalinvest())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Realinvest RealInvest 正序排序
/**
 * 按 Realinvest RealInvest 正序排序
 *
 */
class IndustryProjectRealinvestComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getRealinvest() > arg1.getRealinvest())
			return 1;
		else if (arg0.getRealinvest() < arg1.getRealinvest())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Realinvest RealInvest 倒叙排序
/**
 * 按 Realinvest RealInvest 倒叙排序
 *
 */
class IndustryProjectRealinvestComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getRealinvest() > arg1.getRealinvest())
			return -1;
		else if (arg0.getRealinvest() < arg1.getRealinvest())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Yearinvest 本年投入资金 正序排序
/**
 * 按 Yearinvest 本年投入资金 正序排序
 *
 */
class IndustryProjectYearinvestComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getYearinvest() > arg1.getYearinvest())
			return 1;
		else if (arg0.getYearinvest() < arg1.getYearinvest())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Yearinvest 本年投入资金 倒叙排序
/**
 * 按 Yearinvest 本年投入资金 倒叙排序
 *
 */
class IndustryProjectYearinvestComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getYearinvest() > arg1.getYearinvest())
			return -1;
		else if (arg0.getYearinvest() < arg1.getYearinvest())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Publicinvest 政府投资 正序排序
/**
 * 按 Publicinvest 政府投资 正序排序
 *
 */
class IndustryProjectPublicinvestComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getPublicinvest() > arg1.getPublicinvest())
			return 1;
		else if (arg0.getPublicinvest() < arg1.getPublicinvest())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Publicinvest 政府投资 倒叙排序
/**
 * 按 Publicinvest 政府投资 倒叙排序
 *
 */
class IndustryProjectPublicinvestComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getPublicinvest() > arg1.getPublicinvest())
			return -1;
		else if (arg0.getPublicinvest() < arg1.getPublicinvest())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Selfinvest 自筹 正序排序
/**
 * 按 Selfinvest 自筹 正序排序
 *
 */
class IndustryProjectSelfinvestComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getSelfinvest() > arg1.getSelfinvest())
			return 1;
		else if (arg0.getSelfinvest() < arg1.getSelfinvest())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Selfinvest 自筹 倒叙排序
/**
 * 按 Selfinvest 自筹 倒叙排序
 *
 */
class IndustryProjectSelfinvestComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getSelfinvest() > arg1.getSelfinvest())
			return -1;
		else if (arg0.getSelfinvest() < arg1.getSelfinvest())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Bankloan 银行 正序排序
/**
 * 按 Bankloan 银行 正序排序
 *
 */
class IndustryProjectBankloanComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getBankloan() > arg1.getBankloan())
			return 1;
		else if (arg0.getBankloan() < arg1.getBankloan())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Bankloan 银行 倒叙排序
/**
 * 按 Bankloan 银行 倒叙排序
 *
 */
class IndustryProjectBankloanComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getBankloan() > arg1.getBankloan())
			return -1;
		else if (arg0.getBankloan() < arg1.getBankloan())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Shb 审批,核准,备案 正序排序
/**
 * 按 Shb 审批,核准,备案 正序排序
 *
 */
class IndustryProjectShbComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getShb() > arg1.getShb())
			return 1;
		else if (arg0.getShb() < arg1.getShb())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Shb 审批,核准,备案 倒叙排序
/**
 * 按 Shb 审批,核准,备案 倒叙排序
 *
 */
class IndustryProjectShbComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getShb() > arg1.getShb())
			return -1;
		else if (arg0.getShb() < arg1.getShb())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Hppf 环评批复 正序排序
/**
 * 按 Hppf 环评批复 正序排序
 *
 */
class IndustryProjectHppfComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getHppf() > arg1.getHppf())
			return 1;
		else if (arg0.getHppf() < arg1.getHppf())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Hppf 环评批复 倒叙排序
/**
 * 按 Hppf 环评批复 倒叙排序
 *
 */
class IndustryProjectHppfComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getHppf() > arg1.getHppf())
			return -1;
		else if (arg0.getHppf() < arg1.getHppf())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Tdpz 土地批准 正序排序
/**
 * 按 Tdpz 土地批准 正序排序
 *
 */
class IndustryProjectTdpzComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getTdpz() > arg1.getTdpz())
			return 1;
		else if (arg0.getTdpz() < arg1.getTdpz())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Tdpz 土地批准 倒叙排序
/**
 * 按 Tdpz 土地批准 倒叙排序
 *
 */
class IndustryProjectTdpzComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getTdpz() > arg1.getTdpz())
			return -1;
		else if (arg0.getTdpz() < arg1.getTdpz())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Ghxz 规划选址 正序排序
/**
 * 按 Ghxz 规划选址 正序排序
 *
 */
class IndustryProjectGhxzComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getGhxz() > arg1.getGhxz())
			return 1;
		else if (arg0.getGhxz() < arg1.getGhxz())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Ghxz 规划选址 倒叙排序
/**
 * 按 Ghxz 规划选址 倒叙排序
 *
 */
class IndustryProjectGhxzComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getGhxz() > arg1.getGhxz())
			return -1;
		else if (arg0.getGhxz() < arg1.getGhxz())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Regionid 所属区域 正序排序
/**
 * 按 Regionid 所属区域 正序排序
 *
 */
class IndustryProjectRegionidComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getRegionid() > arg1.getRegionid())
			return 1;
		else if (arg0.getRegionid() < arg1.getRegionid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Regionid 所属区域 倒叙排序
/**
 * 按 Regionid 所属区域 倒叙排序
 *
 */
class IndustryProjectRegionidComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getRegionid() > arg1.getRegionid())
			return -1;
		else if (arg0.getRegionid() < arg1.getRegionid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Dutyunitid 主管单位 正序排序
/**
 * 按 Dutyunitid 主管单位 正序排序
 *
 */
class IndustryProjectDutyunitidComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDutyunitid() > arg1.getDutyunitid())
			return 1;
		else if (arg0.getDutyunitid() < arg1.getDutyunitid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Dutyunitid 主管单位 倒叙排序
/**
 * 按 Dutyunitid 主管单位 倒叙排序
 *
 */
class IndustryProjectDutyunitidComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDutyunitid() > arg1.getDutyunitid())
			return -1;
		else if (arg0.getDutyunitid() < arg1.getDutyunitid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Industryid 产业类别 正序排序
/**
 * 按 Industryid 产业类别 正序排序
 *
 */
class IndustryProjectIndustryidComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getIndustryid() > arg1.getIndustryid())
			return 1;
		else if (arg0.getIndustryid() < arg1.getIndustryid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Industryid 产业类别 倒叙排序
/**
 * 按 Industryid 产业类别 倒叙排序
 *
 */
class IndustryProjectIndustryidComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getIndustryid() > arg1.getIndustryid())
			return -1;
		else if (arg0.getIndustryid() < arg1.getIndustryid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Planprogress 计划进度正序排序
/**
 * 按 Planprogress 计划进度 正序排序
 *
 */
class IndustryProjectPlanprogressComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getPlanprogress().toLowerCase().compareTo(arg1.getPlanprogress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Planprogress 计划进度 倒叙排序
/**
 * 按 Planprogress 计划进度 倒叙排序
 *
 */
class IndustryProjectPlanprogressComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getPlanprogress().toLowerCase().compareTo(arg0.getPlanprogress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Realprogress 实际进度正序排序
/**
 * 按 Realprogress 实际进度 正序排序
 *
 */
class IndustryProjectRealprogressComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getRealprogress().toLowerCase().compareTo(arg1.getRealprogress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Realprogress 实际进度 倒叙排序
/**
 * 按 Realprogress 实际进度 倒叙排序
 *
 */
class IndustryProjectRealprogressComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getRealprogress().toLowerCase().compareTo(arg0.getRealprogress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Feature 项目特色正序排序
/**
 * 按 Feature 项目特色 正序排序
 *
 */
class IndustryProjectFeatureComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getFeature().toLowerCase().compareTo(arg1.getFeature().toLowerCase());
	}
}
	// [end]

	// [start] 按 Feature 项目特色 倒叙排序
/**
 * 按 Feature 项目特色 倒叙排序
 *
 */
class IndustryProjectFeatureComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getFeature().toLowerCase().compareTo(arg0.getFeature().toLowerCase());
	}
}
	// [end]


	// [start] 按 State 经营状况正序排序
/**
 * 按 State 经营状况 正序排序
 *
 */
class IndustryProjectStateComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getState().toLowerCase().compareTo(arg1.getState().toLowerCase());
	}
}
	// [end]

	// [start] 按 State 经营状况 倒叙排序
/**
 * 按 State 经营状况 倒叙排序
 *
 */
class IndustryProjectStateComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getState().toLowerCase().compareTo(arg0.getState().toLowerCase());
	}
}
	// [end]


	// [start] 按 Linkman linkman正序排序
/**
 * 按 Linkman linkman 正序排序
 *
 */
class IndustryProjectLinkmanComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getLinkman().toLowerCase().compareTo(arg1.getLinkman().toLowerCase());
	}
}
	// [end]

	// [start] 按 Linkman linkman 倒叙排序
/**
 * 按 Linkman linkman 倒叙排序
 *
 */
class IndustryProjectLinkmanComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getLinkman().toLowerCase().compareTo(arg0.getLinkman().toLowerCase());
	}
}
	// [end]


	// [start] 按 Phone phone正序排序
/**
 * 按 Phone phone 正序排序
 *
 */
class IndustryProjectPhoneComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getPhone().toLowerCase().compareTo(arg1.getPhone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Phone phone 倒叙排序
/**
 * 按 Phone phone 倒叙排序
 *
 */
class IndustryProjectPhoneComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getPhone().toLowerCase().compareTo(arg0.getPhone().toLowerCase());
	}
}
	// [end]


	// [start] 按 Comment comment正序排序
/**
 * 按 Comment comment 正序排序
 *
 */
class IndustryProjectCommentComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getComment().toLowerCase().compareTo(arg1.getComment().toLowerCase());
	}
}
	// [end]

	// [start] 按 Comment comment 倒叙排序
/**
 * 按 Comment comment 倒叙排序
 *
 */
class IndustryProjectCommentComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getComment().toLowerCase().compareTo(arg0.getComment().toLowerCase());
	}
}
	// [end]


	// [start] 按 Pic 项目图片正序排序
/**
 * 按 Pic 项目图片 正序排序
 *
 */
class IndustryProjectPicComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getPic().toLowerCase().compareTo(arg1.getPic().toLowerCase());
	}
}
	// [end]

	// [start] 按 Pic 项目图片 倒叙排序
/**
 * 按 Pic 项目图片 倒叙排序
 *
 */
class IndustryProjectPicComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getPic().toLowerCase().compareTo(arg0.getPic().toLowerCase());
	}
}
	// [end]


	// [start] 按 Databasepeopleid1 填表人员 正序排序
/**
 * 按 Databasepeopleid1 填表人员 正序排序
 *
 */
class IndustryProjectDatabasepeopleid1ComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDatabasepeopleid1() > arg1.getDatabasepeopleid1())
			return 1;
		else if (arg0.getDatabasepeopleid1() < arg1.getDatabasepeopleid1())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databasepeopleid1 填表人员 倒叙排序
/**
 * 按 Databasepeopleid1 填表人员 倒叙排序
 *
 */
class IndustryProjectDatabasepeopleid1ComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDatabasepeopleid1() > arg1.getDatabasepeopleid1())
			return -1;
		else if (arg0.getDatabasepeopleid1() < arg1.getDatabasepeopleid1())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Databasepeopleid2 统计人员 正序排序
/**
 * 按 Databasepeopleid2 统计人员 正序排序
 *
 */
class IndustryProjectDatabasepeopleid2ComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDatabasepeopleid2() > arg1.getDatabasepeopleid2())
			return 1;
		else if (arg0.getDatabasepeopleid2() < arg1.getDatabasepeopleid2())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databasepeopleid2 统计人员 倒叙排序
/**
 * 按 Databasepeopleid2 统计人员 倒叙排序
 *
 */
class IndustryProjectDatabasepeopleid2ComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getDatabasepeopleid2() > arg1.getDatabasepeopleid2())
			return -1;
		else if (arg0.getDatabasepeopleid2() < arg1.getDatabasepeopleid2())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Adminid 登录人员 正序排序
/**
 * 按 Adminid 登录人员 正序排序
 *
 */
class IndustryProjectAdminidComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getAdminid() > arg1.getAdminid())
			return 1;
		else if (arg0.getAdminid() < arg1.getAdminid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Adminid 登录人员 倒叙排序
/**
 * 按 Adminid 登录人员 倒叙排序
 *
 */
class IndustryProjectAdminidComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getAdminid() > arg1.getAdminid())
			return -1;
		else if (arg0.getAdminid() < arg1.getAdminid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Sectorid 部门 正序排序
/**
 * 按 Sectorid 部门 正序排序
 *
 */
class IndustryProjectSectoridComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getSectorid() > arg1.getSectorid())
			return 1;
		else if (arg0.getSectorid() < arg1.getSectorid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Sectorid 部门 倒叙排序
/**
 * 按 Sectorid 部门 倒叙排序
 *
 */
class IndustryProjectSectoridComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		if (arg0.getSectorid() > arg1.getSectorid())
			return -1;
		else if (arg0.getSectorid() < arg1.getSectorid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Logintime 登录时间正序排序
/**
 * 按 Logintime 登录时间 正序排序
 *
 */
class IndustryProjectLogintimeComparatorAsc implements Comparator<IndustryProjectInfo>
{
	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg0.getLogintime().compareTo(arg1.getLogintime());
	}
}
	// [end]

	// [start] 按 Logintime 登录时间 倒叙排序
/**
 * 按 Logintime 登录时间 倒叙排序
 *
 */
class IndustryProjectLogintimeComparatorDesc implements Comparator<IndustryProjectInfo>
{

	public int compare(IndustryProjectInfo arg0, IndustryProjectInfo arg1)
	{
		return arg1.getLogintime().compareTo(arg0.getLogintime());
	}
}
	// [end]


	// [end]

