package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.EnterpriseInfoBase.*;

/**
 * Enterprise 企业信息表的摘要说明
 */
public class EnterpriseInfoCollectionBase extends ArrayList<EnterpriseInfo> implements List<EnterpriseInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2013010511280595381L;

	// [start] 根据主键或自增字段返回EnterpriseInfo

        // [start] GetEnterpriseInfoByDatabaseenterpriseid
        // [start] GetEnterpriseInfoByDatabaseenterpriseid
        /**
        * 根据DatabaseEnterpriseID获取表 企业信息表的对象EnterpriseInfo
        * @param Databaseenterpriseid 企业ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EnterpriseInfo对象实体
        */
        public EnterpriseInfo GetEnterpriseInfoByDatabaseenterpriseid(int Databaseenterpriseid)
        {
              return GetEnterpriseInfoByDatabaseenterpriseid(Databaseenterpriseid,  true);
        }
        // [end]

        // [start] GetEnterpriseInfoByDatabaseenterpriseid
        private int GetEnterpriseInfoByDatabaseenterpriseid_Databaseenterpriseid = 0;//企业ID
        private EnterpriseInfo GetEnterpriseInfoByDatabaseenterpriseid_EnterpriseInfo;
        /**
        * 根据DatabaseEnterpriseID获取表 企业信息表的对象EnterpriseInfo
        * @param Databaseenterpriseid 企业ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EnterpriseInfo对象实体
        */
        public EnterpriseInfo GetEnterpriseInfoByDatabaseenterpriseid(int Databaseenterpriseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetEnterpriseInfoByDatabaseenterpriseid_EnterpriseInfo = null;
                if (GetEnterpriseInfoByDatabaseenterpriseid_EnterpriseInfo == null || GetEnterpriseInfoByDatabaseenterpriseid_Databaseenterpriseid != Databaseenterpriseid)
            {
            for (EnterpriseInfo objEnterpriseInfo : this)
            {
                if (objEnterpriseInfo.getDatabaseenterpriseid() == Databaseenterpriseid)
                {
                    GetEnterpriseInfoByDatabaseenterpriseid_EnterpriseInfo = objEnterpriseInfo;
                    GetEnterpriseInfoByDatabaseenterpriseid_Databaseenterpriseid = Databaseenterpriseid;//企业ID
                    return objEnterpriseInfo;
                }
            }
            return null;
            }
            else
            {
                return GetEnterpriseInfoByDatabaseenterpriseid_EnterpriseInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabaseenterpriseid
        /**
        * 根据DatabaseEnterpriseID获取表 企业信息表的对象EnterpriseInfo 的位置
        * @param Databaseenterpriseid 企业ID 
        * @return EnterpriseInfo对象实体 的位置
        */
        public int GetIndexByDatabaseenterpriseid(int Databaseenterpriseid)
        {
             int index = 0;
            for (EnterpriseInfo objEnterpriseInfo : this)
            {
                if (objEnterpriseInfo.getDatabaseenterpriseid() == Databaseenterpriseid)
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

	// [start] 根据索引返回EnterpriseInfoCollection

        // [start] GetEnterpriseInfoCollectionByEnterpriseid
        // [start] GetEnterpriseInfoCollectionByEnterpriseid
        /**
        * 根据EnterpriseID获取表 企业信息表的对象集合EnterpriseInfoCollection
        * @param Enterpriseid 企业编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EnterpriseInfoCollection对象集合
        */
        public EnterpriseInfoCollection GetEnterpriseInfoCollectionByEnterpriseid(int Enterpriseid)
        {
              return GetEnterpriseInfoCollectionByEnterpriseid(Enterpriseid,  true);
        }
        // [end]

        // [start] GetEnterpriseInfoCollectionByEnterpriseid
        private int GetEnterpriseInfoCollectionByEnterpriseid_Enterpriseid = 0;//企业编号
        private EnterpriseInfoCollection GetEnterpriseInfoCollectionByEnterpriseid_EnterpriseInfoCollection;
        /**
        * 根据EnterpriseID获取表 企业信息表的对象集合EnterpriseInfoCollection
        * @param Enterpriseid 企业编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EnterpriseInfoCollection对象集合
        */
        public EnterpriseInfoCollection GetEnterpriseInfoCollectionByEnterpriseid(int Enterpriseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetEnterpriseInfoCollectionByEnterpriseid_EnterpriseInfoCollection = null;
                if (GetEnterpriseInfoCollectionByEnterpriseid_EnterpriseInfoCollection == null || GetEnterpriseInfoCollectionByEnterpriseid_Enterpriseid != Enterpriseid)
            {
            EnterpriseInfoCollection list = new EnterpriseInfoCollection();
            for (EnterpriseInfo objEnterpriseInfo : this)
            {
                if (objEnterpriseInfo.getEnterpriseid() == Enterpriseid)
                {
                    list.add(objEnterpriseInfo);
                }
            }
            GetEnterpriseInfoCollectionByEnterpriseid_EnterpriseInfoCollection = list;
            GetEnterpriseInfoCollectionByEnterpriseid_Enterpriseid = Enterpriseid;//企业编号
            return list;
            }
            else
            {
                return GetEnterpriseInfoCollectionByEnterpriseid_EnterpriseInfoCollection;
            }
        }
        // [end]

        // [end]


	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public EnterpriseInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new EnterpriseInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		EnterpriseInfoCollection list = new EnterpriseInfoCollection();
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
    public EnterpriseInfoCollection Copy()
    {
        EnterpriseInfoCollection list = new EnterpriseInfoCollection();
        for (EnterpriseInfo objEnterpriseInfo : this)
        {
            list.add(objEnterpriseInfo.Copy());
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
		sbStr.append("<ArrayOfEnterpriseInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (EnterpriseInfo objEnterpriseInfo : this)
		{
			sbStr.append("  <EnterpriseInfo>\n");
            //企业ID
			sbStr.append("    <Databaseenterpriseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getDatabaseenterpriseid()));
			sbStr.append("</Databaseenterpriseid>\n");
            //企业编号
			sbStr.append("    <Enterpriseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getEnterpriseid()));
			sbStr.append("</Enterpriseid>\n");
            //企业名称
			sbStr.append("    <Enterprisename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getEnterprisename()));
			sbStr.append("</Enterprisename>\n");
            //行业类型
			sbStr.append("    <Businesstypeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getBusinesstypeid()));
			sbStr.append("</Businesstypeid>\n");
            //法人
			sbStr.append("    <Legalperson>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getLegalperson()));
			sbStr.append("</Legalperson>\n");
            //创立时间
			sbStr.append("    <Createtime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getCreatetime()));
			sbStr.append("</Createtime>\n");
            //所属区域
			sbStr.append("    <Regionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getRegionid()));
			sbStr.append("</Regionid>\n");
            //企业地址
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getAddress()));
			sbStr.append("</Address>\n");
            //工商登记号
			sbStr.append("    <Enterprisecode>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getEnterprisecode()));
			sbStr.append("</Enterprisecode>\n");
            //产品专利号
			sbStr.append("    <Partentcode>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getPartentcode()));
			sbStr.append("</Partentcode>\n");
            //经营范围
			sbStr.append("    <Scope>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getScope()));
			sbStr.append("</Scope>\n");
            //企业注册地址
			sbStr.append("    <Registaddress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getRegistaddress()));
			sbStr.append("</Registaddress>\n");
            //注册资金
			sbStr.append("    <Registfund>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getRegistfund()));
			sbStr.append("</Registfund>\n");
            //占地面积
			sbStr.append("    <Area>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getArea()));
			sbStr.append("</Area>\n");
            //总投资
			sbStr.append("    <Toalinvest>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getToalinvest()));
			sbStr.append("</Toalinvest>\n");
            //企业性质
			sbStr.append("    <Qualityid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getQualityid()));
			sbStr.append("</Qualityid>\n");
            //就业人数
			sbStr.append("    <Employnumber>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getEmploynumber()));
			sbStr.append("</Employnumber>\n");
            //年产值
			sbStr.append("    <Producevalue>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getProducevalue()));
			sbStr.append("</Producevalue>\n");
            //利润
			sbStr.append("    <Profit>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getProfit()));
			sbStr.append("</Profit>\n");
            //产品特色
			sbStr.append("    <Feature>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getFeature()));
			sbStr.append("</Feature>\n");
            //获得荣誉
			sbStr.append("    <Obtainhonor>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getObtainhonor()));
			sbStr.append("</Obtainhonor>\n");
            //社会效益
			sbStr.append("    <Socialbenefit>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getSocialbenefit()));
			sbStr.append("</Socialbenefit>\n");
            //统计人员
			sbStr.append("    <Peopleid1>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getPeopleid1()));
			sbStr.append("</Peopleid1>\n");
            //填表人员
			sbStr.append("    <Peopleid2>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getPeopleid2()));
			sbStr.append("</Peopleid2>\n");
            //登录人员
			sbStr.append("    <Adminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getAdminid()));
			sbStr.append("</Adminid>\n");
            //部门编号
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //登录时间
			sbStr.append("    <Logintime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getLogintime()));
			sbStr.append("</Logintime>\n");
            //联系电话
			sbStr.append("    <Linkphone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpriseInfo.getLinkphone()));
			sbStr.append("</Linkphone>\n");
			sbStr.append("  </EnterpriseInfo>\n");
		}
		sbStr.append("</ArrayOfEnterpriseInfo>\n");
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
	// GetEnterpriseInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetEnterpriseInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static EnterpriseInfoCollection GetEnterpriseInfoCollectionFormFileName(String filename)
	{
		return GetEnterpriseInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEnterpriseInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpriseInfoCollection GetEnterpriseInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetEnterpriseInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetEnterpriseInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetEnterpriseInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpriseInfoCollection GetEnterpriseInfoCollectionFormXml(String xml)
	{
		return GetEnterpriseInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEnterpriseInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpriseInfoCollection GetEnterpriseInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		EnterpriseInfoCollection objEnterpriseInfoCollection = new EnterpriseInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("EnterpriseInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				EnterpriseInfo objEnterpriseInfo = new EnterpriseInfo();
				//企业ID
				if (foo.elementText("Databaseenterpriseid") != null)
					objEnterpriseInfo.setDatabaseenterpriseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseenterpriseid")));
				//企业编号
				if (foo.elementText("Enterpriseid") != null)
					objEnterpriseInfo.setEnterpriseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Enterpriseid")));
				//企业名称
				if (foo.elementText("Enterprisename") != null)
					objEnterpriseInfo.setEnterprisename(com.colorwinglib.Converts.objToStr(foo.elementText("Enterprisename")));
				//行业类型
				if (foo.elementText("Businesstypeid") != null)
					objEnterpriseInfo.setBusinesstypeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Businesstypeid")));
				//法人
				if (foo.elementText("Legalperson") != null)
					objEnterpriseInfo.setLegalperson(com.colorwinglib.Converts.objToStr(foo.elementText("Legalperson")));
				//创立时间
				if (foo.elementText("Createtime") != null)
					objEnterpriseInfo.setCreatetime(com.colorwinglib.Converts.StrToDate(foo.elementText("Createtime")));
				//所属区域
				if (foo.elementText("Regionid") != null)
					objEnterpriseInfo.setRegionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Regionid")));
				//企业地址
				if (foo.elementText("Address") != null)
					objEnterpriseInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				//工商登记号
				if (foo.elementText("Enterprisecode") != null)
					objEnterpriseInfo.setEnterprisecode(com.colorwinglib.Converts.objToStr(foo.elementText("Enterprisecode")));
				//产品专利号
				if (foo.elementText("Partentcode") != null)
					objEnterpriseInfo.setPartentcode(com.colorwinglib.Converts.objToStr(foo.elementText("Partentcode")));
				//经营范围
				if (foo.elementText("Scope") != null)
					objEnterpriseInfo.setScope(com.colorwinglib.Converts.objToStr(foo.elementText("Scope")));
				//企业注册地址
				if (foo.elementText("Registaddress") != null)
					objEnterpriseInfo.setRegistaddress(com.colorwinglib.Converts.objToStr(foo.elementText("Registaddress")));
				//注册资金
				if (foo.elementText("Registfund") != null)
					objEnterpriseInfo.setRegistfund(com.colorwinglib.Converts.StrToFloat(foo.elementText("Registfund")));
				//占地面积
				if (foo.elementText("Area") != null)
					objEnterpriseInfo.setArea(com.colorwinglib.Converts.StrToInt(foo.elementText("Area")));
				//总投资
				if (foo.elementText("Toalinvest") != null)
					objEnterpriseInfo.setToalinvest(com.colorwinglib.Converts.StrToFloat(foo.elementText("Toalinvest")));
				//企业性质
				if (foo.elementText("Qualityid") != null)
					objEnterpriseInfo.setQualityid(com.colorwinglib.Converts.StrToInt(foo.elementText("Qualityid")));
				//就业人数
				if (foo.elementText("Employnumber") != null)
					objEnterpriseInfo.setEmploynumber(com.colorwinglib.Converts.StrToInt(foo.elementText("Employnumber")));
				//年产值
				if (foo.elementText("Producevalue") != null)
					objEnterpriseInfo.setProducevalue(com.colorwinglib.Converts.StrToFloat(foo.elementText("Producevalue")));
				//利润
				if (foo.elementText("Profit") != null)
					objEnterpriseInfo.setProfit(com.colorwinglib.Converts.StrToFloat(foo.elementText("Profit")));
				//产品特色
				if (foo.elementText("Feature") != null)
					objEnterpriseInfo.setFeature(com.colorwinglib.Converts.objToStr(foo.elementText("Feature")));
				//获得荣誉
				if (foo.elementText("Obtainhonor") != null)
					objEnterpriseInfo.setObtainhonor(com.colorwinglib.Converts.objToStr(foo.elementText("Obtainhonor")));
				//社会效益
				if (foo.elementText("Socialbenefit") != null)
					objEnterpriseInfo.setSocialbenefit(com.colorwinglib.Converts.objToStr(foo.elementText("Socialbenefit")));
				//统计人员
				if (foo.elementText("Peopleid1") != null)
					objEnterpriseInfo.setPeopleid1(com.colorwinglib.Converts.StrToInt(foo.elementText("Peopleid1")));
				//填表人员
				if (foo.elementText("Peopleid2") != null)
					objEnterpriseInfo.setPeopleid2(com.colorwinglib.Converts.StrToInt(foo.elementText("Peopleid2")));
				//登录人员
				if (foo.elementText("Adminid") != null)
					objEnterpriseInfo.setAdminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Adminid")));
				//部门编号
				if (foo.elementText("Sectorid") != null)
					objEnterpriseInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//登录时间
				if (foo.elementText("Logintime") != null)
					objEnterpriseInfo.setLogintime(com.colorwinglib.Converts.StrToDate(foo.elementText("Logintime")));
				//联系电话
				if (foo.elementText("Linkphone") != null)
					objEnterpriseInfo.setLinkphone(com.colorwinglib.Converts.objToStr(foo.elementText("Linkphone")));
				objEnterpriseInfoCollection.add(objEnterpriseInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objEnterpriseInfoCollection;
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
		//企业ID
		if ("Databaseenterpriseid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Databaseenterpriseid, isAsc);
		}

		//企业编号
		if ("Enterpriseid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Enterpriseid, isAsc);
		}

		//企业名称
		if ("Enterprisename".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Enterprisename, isAsc);
		}

		//行业类型
		if ("Businesstypeid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Businesstypeid, isAsc);
		}

		//法人
		if ("Legalperson".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Legalperson, isAsc);
		}

		//创立时间
		if ("Createtime".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Createtime, isAsc);
		}

		//所属区域
		if ("Regionid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Regionid, isAsc);
		}

		//企业地址
		if ("Address".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Address, isAsc);
		}

		//工商登记号
		if ("Enterprisecode".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Enterprisecode, isAsc);
		}

		//产品专利号
		if ("Partentcode".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Partentcode, isAsc);
		}

		//经营范围
		if ("Scope".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Scope, isAsc);
		}

		//企业注册地址
		if ("Registaddress".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Registaddress, isAsc);
		}

		//注册资金
		if ("Registfund".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Registfund, isAsc);
		}

		//占地面积
		if ("Area".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Area, isAsc);
		}

		//总投资
		if ("Toalinvest".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Toalinvest, isAsc);
		}

		//企业性质
		if ("Qualityid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Qualityid, isAsc);
		}

		//就业人数
		if ("Employnumber".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Employnumber, isAsc);
		}

		//年产值
		if ("Producevalue".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Producevalue, isAsc);
		}

		//利润
		if ("Profit".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Profit, isAsc);
		}

		//产品特色
		if ("Feature".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Feature, isAsc);
		}

		//获得荣誉
		if ("Obtainhonor".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Obtainhonor, isAsc);
		}

		//社会效益
		if ("Socialbenefit".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Socialbenefit, isAsc);
		}

		//统计人员
		if ("Peopleid1".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Peopleid1, isAsc);
		}

		//填表人员
		if ("Peopleid2".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Peopleid2, isAsc);
		}

		//登录人员
		if ("Adminid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Adminid, isAsc);
		}

		//部门编号
		if ("Sectorid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Sectorid, isAsc);
		}

		//登录时间
		if ("Logintime".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Logintime, isAsc);
		}

		//联系电话
		if ("Linkphone".equals(columnName) && isAsc == true)
		{
          return sort(EnterpriseColumnNameEnum.Linkphone, isAsc);
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
	public boolean sort(EnterpriseColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//企业ID
		if (EnterpriseColumnNameEnum.Databaseenterpriseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseDatabaseenterpriseidComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Databaseenterpriseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseDatabaseenterpriseidComparatorDesc());// 倒叙
			return true;
		}

		//企业编号
		if (EnterpriseColumnNameEnum.Enterpriseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseEnterpriseidComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Enterpriseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseEnterpriseidComparatorDesc());// 倒叙
			return true;
		}

		//企业名称
		if (EnterpriseColumnNameEnum.Enterprisename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseEnterprisenameComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Enterprisename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseEnterprisenameComparatorDesc());// 倒叙
			return true;
		}

		//行业类型
		if (EnterpriseColumnNameEnum.Businesstypeid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseBusinesstypeidComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Businesstypeid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseBusinesstypeidComparatorDesc());// 倒叙
			return true;
		}

		//法人
		if (EnterpriseColumnNameEnum.Legalperson.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseLegalpersonComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Legalperson.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseLegalpersonComparatorDesc());// 倒叙
			return true;
		}

		//创立时间
		if (EnterpriseColumnNameEnum.Createtime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseCreatetimeComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Createtime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseCreatetimeComparatorDesc());// 倒叙
			return true;
		}

		//所属区域
		if (EnterpriseColumnNameEnum.Regionid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseRegionidComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Regionid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseRegionidComparatorDesc());// 倒叙
			return true;
		}

		//企业地址
		if (EnterpriseColumnNameEnum.Address.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseAddressComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Address.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseAddressComparatorDesc());// 倒叙
			return true;
		}

		//工商登记号
		if (EnterpriseColumnNameEnum.Enterprisecode.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseEnterprisecodeComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Enterprisecode.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseEnterprisecodeComparatorDesc());// 倒叙
			return true;
		}

		//产品专利号
		if (EnterpriseColumnNameEnum.Partentcode.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterprisePartentcodeComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Partentcode.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterprisePartentcodeComparatorDesc());// 倒叙
			return true;
		}

		//经营范围
		if (EnterpriseColumnNameEnum.Scope.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseScopeComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Scope.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseScopeComparatorDesc());// 倒叙
			return true;
		}

		//企业注册地址
		if (EnterpriseColumnNameEnum.Registaddress.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseRegistaddressComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Registaddress.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseRegistaddressComparatorDesc());// 倒叙
			return true;
		}

		//注册资金
		if (EnterpriseColumnNameEnum.Registfund.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseRegistfundComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Registfund.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseRegistfundComparatorDesc());// 倒叙
			return true;
		}

		//占地面积
		if (EnterpriseColumnNameEnum.Area.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseAreaComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Area.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseAreaComparatorDesc());// 倒叙
			return true;
		}

		//总投资
		if (EnterpriseColumnNameEnum.Toalinvest.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseToalinvestComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Toalinvest.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseToalinvestComparatorDesc());// 倒叙
			return true;
		}

		//企业性质
		if (EnterpriseColumnNameEnum.Qualityid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseQualityidComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Qualityid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseQualityidComparatorDesc());// 倒叙
			return true;
		}

		//就业人数
		if (EnterpriseColumnNameEnum.Employnumber.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseEmploynumberComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Employnumber.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseEmploynumberComparatorDesc());// 倒叙
			return true;
		}

		//年产值
		if (EnterpriseColumnNameEnum.Producevalue.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseProducevalueComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Producevalue.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseProducevalueComparatorDesc());// 倒叙
			return true;
		}

		//利润
		if (EnterpriseColumnNameEnum.Profit.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseProfitComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Profit.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseProfitComparatorDesc());// 倒叙
			return true;
		}

		//产品特色
		if (EnterpriseColumnNameEnum.Feature.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseFeatureComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Feature.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseFeatureComparatorDesc());// 倒叙
			return true;
		}

		//获得荣誉
		if (EnterpriseColumnNameEnum.Obtainhonor.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseObtainhonorComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Obtainhonor.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseObtainhonorComparatorDesc());// 倒叙
			return true;
		}

		//社会效益
		if (EnterpriseColumnNameEnum.Socialbenefit.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseSocialbenefitComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Socialbenefit.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseSocialbenefitComparatorDesc());// 倒叙
			return true;
		}

		//统计人员
		if (EnterpriseColumnNameEnum.Peopleid1.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterprisePeopleid1ComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Peopleid1.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterprisePeopleid1ComparatorDesc());// 倒叙
			return true;
		}

		//填表人员
		if (EnterpriseColumnNameEnum.Peopleid2.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterprisePeopleid2ComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Peopleid2.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterprisePeopleid2ComparatorDesc());// 倒叙
			return true;
		}

		//登录人员
		if (EnterpriseColumnNameEnum.Adminid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseAdminidComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Adminid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseAdminidComparatorDesc());// 倒叙
			return true;
		}

		//部门编号
		if (EnterpriseColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseSectoridComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseSectoridComparatorDesc());// 倒叙
			return true;
		}

		//登录时间
		if (EnterpriseColumnNameEnum.Logintime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseLogintimeComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Logintime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseLogintimeComparatorDesc());// 倒叙
			return true;
		}

		//联系电话
		if (EnterpriseColumnNameEnum.Linkphone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpriseLinkphoneComparatorAsc());// 顺序
			return true;
		}
		if (EnterpriseColumnNameEnum.Linkphone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpriseLinkphoneComparatorDesc());// 倒叙
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
		for (EnterpriseInfo objEnterpriseInfo : this)
		{
			objJSONArray.put(objEnterpriseInfo.toJson());
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
				EnterpriseInfo objEnterpriseInfo = new EnterpriseInfo();
				objEnterpriseInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objEnterpriseInfo);
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
	// [start] 按 Databaseenterpriseid 企业ID 正序排序
/**
 * 按 Databaseenterpriseid 企业ID 正序排序
 *
 */
class EnterpriseDatabaseenterpriseidComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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

	// [start] 按 Databaseenterpriseid 企业ID 倒叙排序
/**
 * 按 Databaseenterpriseid 企业ID 倒叙排序
 *
 */
class EnterpriseDatabaseenterpriseidComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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


	// [start] 按 Enterpriseid 企业编号 正序排序
/**
 * 按 Enterpriseid 企业编号 正序排序
 *
 */
class EnterpriseEnterpriseidComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getEnterpriseid() > arg1.getEnterpriseid())
			return 1;
		else if (arg0.getEnterpriseid() < arg1.getEnterpriseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Enterpriseid 企业编号 倒叙排序
/**
 * 按 Enterpriseid 企业编号 倒叙排序
 *
 */
class EnterpriseEnterpriseidComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getEnterpriseid() > arg1.getEnterpriseid())
			return -1;
		else if (arg0.getEnterpriseid() < arg1.getEnterpriseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Enterprisename 企业名称正序排序
/**
 * 按 Enterprisename 企业名称 正序排序
 *
 */
class EnterpriseEnterprisenameComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getEnterprisename().toLowerCase().compareTo(arg1.getEnterprisename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Enterprisename 企业名称 倒叙排序
/**
 * 按 Enterprisename 企业名称 倒叙排序
 *
 */
class EnterpriseEnterprisenameComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getEnterprisename().toLowerCase().compareTo(arg0.getEnterprisename().toLowerCase());
	}
}
	// [end]


	// [start] 按 Businesstypeid 行业类型 正序排序
/**
 * 按 Businesstypeid 行业类型 正序排序
 *
 */
class EnterpriseBusinesstypeidComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getBusinesstypeid() > arg1.getBusinesstypeid())
			return 1;
		else if (arg0.getBusinesstypeid() < arg1.getBusinesstypeid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Businesstypeid 行业类型 倒叙排序
/**
 * 按 Businesstypeid 行业类型 倒叙排序
 *
 */
class EnterpriseBusinesstypeidComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getBusinesstypeid() > arg1.getBusinesstypeid())
			return -1;
		else if (arg0.getBusinesstypeid() < arg1.getBusinesstypeid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Legalperson 法人正序排序
/**
 * 按 Legalperson 法人 正序排序
 *
 */
class EnterpriseLegalpersonComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getLegalperson().toLowerCase().compareTo(arg1.getLegalperson().toLowerCase());
	}
}
	// [end]

	// [start] 按 Legalperson 法人 倒叙排序
/**
 * 按 Legalperson 法人 倒叙排序
 *
 */
class EnterpriseLegalpersonComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getLegalperson().toLowerCase().compareTo(arg0.getLegalperson().toLowerCase());
	}
}
	// [end]


	// [start] 按 Createtime 创立时间正序排序
/**
 * 按 Createtime 创立时间 正序排序
 *
 */
class EnterpriseCreatetimeComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getCreatetime().compareTo(arg1.getCreatetime());
	}
}
	// [end]

	// [start] 按 Createtime 创立时间 倒叙排序
/**
 * 按 Createtime 创立时间 倒叙排序
 *
 */
class EnterpriseCreatetimeComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getCreatetime().compareTo(arg0.getCreatetime());
	}
}
	// [end]


	// [start] 按 Regionid 所属区域 正序排序
/**
 * 按 Regionid 所属区域 正序排序
 *
 */
class EnterpriseRegionidComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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
class EnterpriseRegionidComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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


	// [start] 按 Address 企业地址正序排序
/**
 * 按 Address 企业地址 正序排序
 *
 */
class EnterpriseAddressComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getAddress().toLowerCase().compareTo(arg1.getAddress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Address 企业地址 倒叙排序
/**
 * 按 Address 企业地址 倒叙排序
 *
 */
class EnterpriseAddressComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getAddress().toLowerCase().compareTo(arg0.getAddress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Enterprisecode 工商登记号正序排序
/**
 * 按 Enterprisecode 工商登记号 正序排序
 *
 */
class EnterpriseEnterprisecodeComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getEnterprisecode().toLowerCase().compareTo(arg1.getEnterprisecode().toLowerCase());
	}
}
	// [end]

	// [start] 按 Enterprisecode 工商登记号 倒叙排序
/**
 * 按 Enterprisecode 工商登记号 倒叙排序
 *
 */
class EnterpriseEnterprisecodeComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getEnterprisecode().toLowerCase().compareTo(arg0.getEnterprisecode().toLowerCase());
	}
}
	// [end]


	// [start] 按 Partentcode 产品专利号正序排序
/**
 * 按 Partentcode 产品专利号 正序排序
 *
 */
class EnterprisePartentcodeComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getPartentcode().toLowerCase().compareTo(arg1.getPartentcode().toLowerCase());
	}
}
	// [end]

	// [start] 按 Partentcode 产品专利号 倒叙排序
/**
 * 按 Partentcode 产品专利号 倒叙排序
 *
 */
class EnterprisePartentcodeComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getPartentcode().toLowerCase().compareTo(arg0.getPartentcode().toLowerCase());
	}
}
	// [end]


	// [start] 按 Scope 经营范围正序排序
/**
 * 按 Scope 经营范围 正序排序
 *
 */
class EnterpriseScopeComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getScope().toLowerCase().compareTo(arg1.getScope().toLowerCase());
	}
}
	// [end]

	// [start] 按 Scope 经营范围 倒叙排序
/**
 * 按 Scope 经营范围 倒叙排序
 *
 */
class EnterpriseScopeComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getScope().toLowerCase().compareTo(arg0.getScope().toLowerCase());
	}
}
	// [end]


	// [start] 按 Registaddress 企业注册地址正序排序
/**
 * 按 Registaddress 企业注册地址 正序排序
 *
 */
class EnterpriseRegistaddressComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getRegistaddress().toLowerCase().compareTo(arg1.getRegistaddress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Registaddress 企业注册地址 倒叙排序
/**
 * 按 Registaddress 企业注册地址 倒叙排序
 *
 */
class EnterpriseRegistaddressComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getRegistaddress().toLowerCase().compareTo(arg0.getRegistaddress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Registfund 注册资金 正序排序
/**
 * 按 Registfund 注册资金 正序排序
 *
 */
class EnterpriseRegistfundComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getRegistfund() > arg1.getRegistfund())
			return 1;
		else if (arg0.getRegistfund() < arg1.getRegistfund())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Registfund 注册资金 倒叙排序
/**
 * 按 Registfund 注册资金 倒叙排序
 *
 */
class EnterpriseRegistfundComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getRegistfund() > arg1.getRegistfund())
			return -1;
		else if (arg0.getRegistfund() < arg1.getRegistfund())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Area 占地面积 正序排序
/**
 * 按 Area 占地面积 正序排序
 *
 */
class EnterpriseAreaComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getArea() > arg1.getArea())
			return 1;
		else if (arg0.getArea() < arg1.getArea())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Area 占地面积 倒叙排序
/**
 * 按 Area 占地面积 倒叙排序
 *
 */
class EnterpriseAreaComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getArea() > arg1.getArea())
			return -1;
		else if (arg0.getArea() < arg1.getArea())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Toalinvest 总投资 正序排序
/**
 * 按 Toalinvest 总投资 正序排序
 *
 */
class EnterpriseToalinvestComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getToalinvest() > arg1.getToalinvest())
			return 1;
		else if (arg0.getToalinvest() < arg1.getToalinvest())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Toalinvest 总投资 倒叙排序
/**
 * 按 Toalinvest 总投资 倒叙排序
 *
 */
class EnterpriseToalinvestComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getToalinvest() > arg1.getToalinvest())
			return -1;
		else if (arg0.getToalinvest() < arg1.getToalinvest())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Qualityid 企业性质 正序排序
/**
 * 按 Qualityid 企业性质 正序排序
 *
 */
class EnterpriseQualityidComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getQualityid() > arg1.getQualityid())
			return 1;
		else if (arg0.getQualityid() < arg1.getQualityid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Qualityid 企业性质 倒叙排序
/**
 * 按 Qualityid 企业性质 倒叙排序
 *
 */
class EnterpriseQualityidComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getQualityid() > arg1.getQualityid())
			return -1;
		else if (arg0.getQualityid() < arg1.getQualityid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Employnumber 就业人数 正序排序
/**
 * 按 Employnumber 就业人数 正序排序
 *
 */
class EnterpriseEmploynumberComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getEmploynumber() > arg1.getEmploynumber())
			return 1;
		else if (arg0.getEmploynumber() < arg1.getEmploynumber())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Employnumber 就业人数 倒叙排序
/**
 * 按 Employnumber 就业人数 倒叙排序
 *
 */
class EnterpriseEmploynumberComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getEmploynumber() > arg1.getEmploynumber())
			return -1;
		else if (arg0.getEmploynumber() < arg1.getEmploynumber())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Producevalue 年产值 正序排序
/**
 * 按 Producevalue 年产值 正序排序
 *
 */
class EnterpriseProducevalueComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getProducevalue() > arg1.getProducevalue())
			return 1;
		else if (arg0.getProducevalue() < arg1.getProducevalue())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Producevalue 年产值 倒叙排序
/**
 * 按 Producevalue 年产值 倒叙排序
 *
 */
class EnterpriseProducevalueComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getProducevalue() > arg1.getProducevalue())
			return -1;
		else if (arg0.getProducevalue() < arg1.getProducevalue())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Profit 利润 正序排序
/**
 * 按 Profit 利润 正序排序
 *
 */
class EnterpriseProfitComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getProfit() > arg1.getProfit())
			return 1;
		else if (arg0.getProfit() < arg1.getProfit())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Profit 利润 倒叙排序
/**
 * 按 Profit 利润 倒叙排序
 *
 */
class EnterpriseProfitComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getProfit() > arg1.getProfit())
			return -1;
		else if (arg0.getProfit() < arg1.getProfit())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Feature 产品特色正序排序
/**
 * 按 Feature 产品特色 正序排序
 *
 */
class EnterpriseFeatureComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getFeature().toLowerCase().compareTo(arg1.getFeature().toLowerCase());
	}
}
	// [end]

	// [start] 按 Feature 产品特色 倒叙排序
/**
 * 按 Feature 产品特色 倒叙排序
 *
 */
class EnterpriseFeatureComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getFeature().toLowerCase().compareTo(arg0.getFeature().toLowerCase());
	}
}
	// [end]


	// [start] 按 Obtainhonor 获得荣誉正序排序
/**
 * 按 Obtainhonor 获得荣誉 正序排序
 *
 */
class EnterpriseObtainhonorComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getObtainhonor().toLowerCase().compareTo(arg1.getObtainhonor().toLowerCase());
	}
}
	// [end]

	// [start] 按 Obtainhonor 获得荣誉 倒叙排序
/**
 * 按 Obtainhonor 获得荣誉 倒叙排序
 *
 */
class EnterpriseObtainhonorComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getObtainhonor().toLowerCase().compareTo(arg0.getObtainhonor().toLowerCase());
	}
}
	// [end]


	// [start] 按 Socialbenefit 社会效益正序排序
/**
 * 按 Socialbenefit 社会效益 正序排序
 *
 */
class EnterpriseSocialbenefitComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getSocialbenefit().toLowerCase().compareTo(arg1.getSocialbenefit().toLowerCase());
	}
}
	// [end]

	// [start] 按 Socialbenefit 社会效益 倒叙排序
/**
 * 按 Socialbenefit 社会效益 倒叙排序
 *
 */
class EnterpriseSocialbenefitComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getSocialbenefit().toLowerCase().compareTo(arg0.getSocialbenefit().toLowerCase());
	}
}
	// [end]


	// [start] 按 Peopleid1 统计人员 正序排序
/**
 * 按 Peopleid1 统计人员 正序排序
 *
 */
class EnterprisePeopleid1ComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getPeopleid1() > arg1.getPeopleid1())
			return 1;
		else if (arg0.getPeopleid1() < arg1.getPeopleid1())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Peopleid1 统计人员 倒叙排序
/**
 * 按 Peopleid1 统计人员 倒叙排序
 *
 */
class EnterprisePeopleid1ComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getPeopleid1() > arg1.getPeopleid1())
			return -1;
		else if (arg0.getPeopleid1() < arg1.getPeopleid1())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Peopleid2 填表人员 正序排序
/**
 * 按 Peopleid2 填表人员 正序排序
 *
 */
class EnterprisePeopleid2ComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getPeopleid2() > arg1.getPeopleid2())
			return 1;
		else if (arg0.getPeopleid2() < arg1.getPeopleid2())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Peopleid2 填表人员 倒叙排序
/**
 * 按 Peopleid2 填表人员 倒叙排序
 *
 */
class EnterprisePeopleid2ComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		if (arg0.getPeopleid2() > arg1.getPeopleid2())
			return -1;
		else if (arg0.getPeopleid2() < arg1.getPeopleid2())
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
class EnterpriseAdminidComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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
class EnterpriseAdminidComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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


	// [start] 按 Sectorid 部门编号 正序排序
/**
 * 按 Sectorid 部门编号 正序排序
 *
 */
class EnterpriseSectoridComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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

	// [start] 按 Sectorid 部门编号 倒叙排序
/**
 * 按 Sectorid 部门编号 倒叙排序
 *
 */
class EnterpriseSectoridComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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
class EnterpriseLogintimeComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
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
class EnterpriseLogintimeComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getLogintime().compareTo(arg0.getLogintime());
	}
}
	// [end]


	// [start] 按 Linkphone 联系电话正序排序
/**
 * 按 Linkphone 联系电话 正序排序
 *
 */
class EnterpriseLinkphoneComparatorAsc implements Comparator<EnterpriseInfo>
{
	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg0.getLinkphone().toLowerCase().compareTo(arg1.getLinkphone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Linkphone 联系电话 倒叙排序
/**
 * 按 Linkphone 联系电话 倒叙排序
 *
 */
class EnterpriseLinkphoneComparatorDesc implements Comparator<EnterpriseInfo>
{

	public int compare(EnterpriseInfo arg0, EnterpriseInfo arg1)
	{
		return arg1.getLinkphone().toLowerCase().compareTo(arg0.getLinkphone().toLowerCase());
	}
}
	// [end]


	// [end]

