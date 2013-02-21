package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.TalentInfoBase.*;

/**
 * Talent 文化人才表的摘要说明
 */
public class TalentInfoCollectionBase extends ArrayList<TalentInfo> implements List<TalentInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120317472660967L;

	// [start] 根据主键或自增字段返回TalentInfo

        // [start] GetTalentInfoByTalentid
        // [start] GetTalentInfoByTalentid
        /**
        * 根据TalentID获取表 文化人才表的对象TalentInfo
        * @param Talentid 人才编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return TalentInfo对象实体
        */
        public TalentInfo GetTalentInfoByTalentid(int Talentid)
        {
              return GetTalentInfoByTalentid(Talentid,  true);
        }
        // [end]

        // [start] GetTalentInfoByTalentid
        private int GetTalentInfoByTalentid_Talentid = 0;//人才编号
        private TalentInfo GetTalentInfoByTalentid_TalentInfo;
        /**
        * 根据TalentID获取表 文化人才表的对象TalentInfo
        * @param Talentid 人才编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return TalentInfo对象实体
        */
        public TalentInfo GetTalentInfoByTalentid(int Talentid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetTalentInfoByTalentid_TalentInfo = null;
                if (GetTalentInfoByTalentid_TalentInfo == null || GetTalentInfoByTalentid_Talentid != Talentid)
            {
            for (TalentInfo objTalentInfo : this)
            {
                if (objTalentInfo.getTalentid() == Talentid)
                {
                    GetTalentInfoByTalentid_TalentInfo = objTalentInfo;
                    GetTalentInfoByTalentid_Talentid = Talentid;//人才编号
                    return objTalentInfo;
                }
            }
            return null;
            }
            else
            {
                return GetTalentInfoByTalentid_TalentInfo;
            }
        }
        // [end]

        // [start] GetIndexByTalentid
        /**
        * 根据TalentID获取表 文化人才表的对象TalentInfo 的位置
        * @param Talentid 人才编号 
        * @return TalentInfo对象实体 的位置
        */
        public int GetIndexByTalentid(int Talentid)
        {
             int index = 0;
            for (TalentInfo objTalentInfo : this)
            {
                if (objTalentInfo.getTalentid() == Talentid)
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

	// [start] 根据索引返回TalentInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public TalentInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new TalentInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		TalentInfoCollection list = new TalentInfoCollection();
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
    public TalentInfoCollection Copy()
    {
        TalentInfoCollection list = new TalentInfoCollection();
        for (TalentInfo objTalentInfo : this)
        {
            list.add(objTalentInfo.Copy());
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
		sbStr.append("<ArrayOfTalentInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (TalentInfo objTalentInfo : this)
		{
			sbStr.append("  <TalentInfo>\n");
            //人才编号
			sbStr.append("    <Talentid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getTalentid()));
			sbStr.append("</Talentid>\n");
            //姓名
			sbStr.append("    <Talentname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getTalentname()));
			sbStr.append("</Talentname>\n");
            //性别：1-男、2-女
			sbStr.append("    <Sex>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getSex()));
			sbStr.append("</Sex>\n");
            //出生日期
			sbStr.append("    <Birthday>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getBirthday()));
			sbStr.append("</Birthday>\n");
            //民族
			sbStr.append("    <Nationid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getNationid()));
			sbStr.append("</Nationid>\n");
            //籍贯
			sbStr.append("    <Nativeplace>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getNativeplace()));
			sbStr.append("</Nativeplace>\n");
            //政治面貌
			sbStr.append("    <Politicsstatus>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getPoliticsstatus()));
			sbStr.append("</Politicsstatus>\n");
            //省份
			sbStr.append("    <Province>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getProvince()));
			sbStr.append("</Province>\n");
            //城市
			sbStr.append("    <Cityid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getCityid()));
			sbStr.append("</Cityid>\n");
            //学历
			sbStr.append("    <Educationid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getEducationid()));
			sbStr.append("</Educationid>\n");
            //学位
			sbStr.append("    <Degreeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getDegreeid()));
			sbStr.append("</Degreeid>\n");
            //专业
			sbStr.append("    <Majorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getMajorid()));
			sbStr.append("</Majorid>\n");
            //个人学习经历
			sbStr.append("    <Learnexperience>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getLearnexperience()));
			sbStr.append("</Learnexperience>\n");
            //工作经历
			sbStr.append("    <Workexperience>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getWorkexperience()));
			sbStr.append("</Workexperience>\n");
            //人才所属行业
			sbStr.append("    <Talentprofessionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getTalentprofessionid()));
			sbStr.append("</Talentprofessionid>\n");
            //业绩
			sbStr.append("    <Acheivement>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getAcheivement()));
			sbStr.append("</Acheivement>\n");
            //荣誉
			sbStr.append("    <Honor>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getHonor()));
			sbStr.append("</Honor>\n");
            //专长
			sbStr.append("    <Skills>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getSkills()));
			sbStr.append("</Skills>\n");
            //职称
			sbStr.append("    <Posttitleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getPosttitleid()));
			sbStr.append("</Posttitleid>\n");
            //工作单位
			sbStr.append("    <Workunit>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getWorkunit()));
			sbStr.append("</Workunit>\n");
            //现在住址
			sbStr.append("    <Adress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getAdress()));
			sbStr.append("</Adress>\n");
            //手机
			sbStr.append("    <Movephone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getMovephone()));
			sbStr.append("</Movephone>\n");
            //邮箱
			sbStr.append("    <Email>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getEmail()));
			sbStr.append("</Email>\n");
            //统计人员
			sbStr.append("    <Databasepeopleid1>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getDatabasepeopleid1()));
			sbStr.append("</Databasepeopleid1>\n");
            //填表人员
			sbStr.append("    <Databasepeopleid2>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getDatabasepeopleid2()));
			sbStr.append("</Databasepeopleid2>\n");
            //登录人员
			sbStr.append("    <Adminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getAdminid()));
			sbStr.append("</Adminid>\n");
            //SectorID
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //登录时间
			sbStr.append("    <Logintime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentInfo.getLogintime()));
			sbStr.append("</Logintime>\n");
			sbStr.append("  </TalentInfo>\n");
		}
		sbStr.append("</ArrayOfTalentInfo>\n");
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
	// GetTalentInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetTalentInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static TalentInfoCollection GetTalentInfoCollectionFormFileName(String filename)
	{
		return GetTalentInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTalentInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentInfoCollection GetTalentInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetTalentInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetTalentInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetTalentInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentInfoCollection GetTalentInfoCollectionFormXml(String xml)
	{
		return GetTalentInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTalentInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentInfoCollection GetTalentInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		TalentInfoCollection objTalentInfoCollection = new TalentInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("TalentInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				TalentInfo objTalentInfo = new TalentInfo();
				//人才编号
				if (foo.elementText("Talentid") != null)
					objTalentInfo.setTalentid(com.colorwinglib.Converts.StrToInt(foo.elementText("Talentid")));
				//姓名
				if (foo.elementText("Talentname") != null)
					objTalentInfo.setTalentname(com.colorwinglib.Converts.objToStr(foo.elementText("Talentname")));
				//性别：1-男、2-女
				if (foo.elementText("Sex") != null)
					objTalentInfo.setSex(com.colorwinglib.Converts.StrToInt(foo.elementText("Sex")));
				//出生日期
				if (foo.elementText("Birthday") != null)
					objTalentInfo.setBirthday(com.colorwinglib.Converts.StrToDate(foo.elementText("Birthday")));
				//民族
				if (foo.elementText("Nationid") != null)
					objTalentInfo.setNationid(com.colorwinglib.Converts.StrToInt(foo.elementText("Nationid")));
				//籍贯
				if (foo.elementText("Nativeplace") != null)
					objTalentInfo.setNativeplace(com.colorwinglib.Converts.objToStr(foo.elementText("Nativeplace")));
				//政治面貌
				if (foo.elementText("Politicsstatus") != null)
					objTalentInfo.setPoliticsstatus(com.colorwinglib.Converts.objToStr(foo.elementText("Politicsstatus")));
				//省份
				if (foo.elementText("Province") != null)
					objTalentInfo.setProvince(com.colorwinglib.Converts.StrToInt(foo.elementText("Province")));
				//城市
				if (foo.elementText("Cityid") != null)
					objTalentInfo.setCityid(com.colorwinglib.Converts.StrToInt(foo.elementText("Cityid")));
				//学历
				if (foo.elementText("Educationid") != null)
					objTalentInfo.setEducationid(com.colorwinglib.Converts.StrToInt(foo.elementText("Educationid")));
				//学位
				if (foo.elementText("Degreeid") != null)
					objTalentInfo.setDegreeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Degreeid")));
				//专业
				if (foo.elementText("Majorid") != null)
					objTalentInfo.setMajorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Majorid")));
				//个人学习经历
				if (foo.elementText("Learnexperience") != null)
					objTalentInfo.setLearnexperience(com.colorwinglib.Converts.objToStr(foo.elementText("Learnexperience")));
				//工作经历
				if (foo.elementText("Workexperience") != null)
					objTalentInfo.setWorkexperience(com.colorwinglib.Converts.objToStr(foo.elementText("Workexperience")));
				//人才所属行业
				if (foo.elementText("Talentprofessionid") != null)
					objTalentInfo.setTalentprofessionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Talentprofessionid")));
				//业绩
				if (foo.elementText("Acheivement") != null)
					objTalentInfo.setAcheivement(com.colorwinglib.Converts.objToStr(foo.elementText("Acheivement")));
				//荣誉
				if (foo.elementText("Honor") != null)
					objTalentInfo.setHonor(com.colorwinglib.Converts.objToStr(foo.elementText("Honor")));
				//专长
				if (foo.elementText("Skills") != null)
					objTalentInfo.setSkills(com.colorwinglib.Converts.objToStr(foo.elementText("Skills")));
				//职称
				if (foo.elementText("Posttitleid") != null)
					objTalentInfo.setPosttitleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Posttitleid")));
				//工作单位
				if (foo.elementText("Workunit") != null)
					objTalentInfo.setWorkunit(com.colorwinglib.Converts.objToStr(foo.elementText("Workunit")));
				//现在住址
				if (foo.elementText("Adress") != null)
					objTalentInfo.setAdress(com.colorwinglib.Converts.objToStr(foo.elementText("Adress")));
				//手机
				if (foo.elementText("Movephone") != null)
					objTalentInfo.setMovephone(com.colorwinglib.Converts.objToStr(foo.elementText("Movephone")));
				//邮箱
				if (foo.elementText("Email") != null)
					objTalentInfo.setEmail(com.colorwinglib.Converts.objToStr(foo.elementText("Email")));
				//统计人员
				if (foo.elementText("Databasepeopleid1") != null)
					objTalentInfo.setDatabasepeopleid1(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid1")));
				//填表人员
				if (foo.elementText("Databasepeopleid2") != null)
					objTalentInfo.setDatabasepeopleid2(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid2")));
				//登录人员
				if (foo.elementText("Adminid") != null)
					objTalentInfo.setAdminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Adminid")));
				//SectorID
				if (foo.elementText("Sectorid") != null)
					objTalentInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//登录时间
				if (foo.elementText("Logintime") != null)
					objTalentInfo.setLogintime(com.colorwinglib.Converts.StrToDate(foo.elementText("Logintime")));
				objTalentInfoCollection.add(objTalentInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objTalentInfoCollection;
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
		//人才编号
		if ("Talentid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Talentid, isAsc);
		}

		//姓名
		if ("Talentname".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Talentname, isAsc);
		}

		//性别：1-男、2-女
		if ("Sex".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Sex, isAsc);
		}

		//出生日期
		if ("Birthday".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Birthday, isAsc);
		}

		//民族
		if ("Nationid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Nationid, isAsc);
		}

		//籍贯
		if ("Nativeplace".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Nativeplace, isAsc);
		}

		//政治面貌
		if ("Politicsstatus".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Politicsstatus, isAsc);
		}

		//省份
		if ("Province".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Province, isAsc);
		}

		//城市
		if ("Cityid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Cityid, isAsc);
		}

		//学历
		if ("Educationid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Educationid, isAsc);
		}

		//学位
		if ("Degreeid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Degreeid, isAsc);
		}

		//专业
		if ("Majorid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Majorid, isAsc);
		}

		//个人学习经历
		if ("Learnexperience".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Learnexperience, isAsc);
		}

		//工作经历
		if ("Workexperience".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Workexperience, isAsc);
		}

		//人才所属行业
		if ("Talentprofessionid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Talentprofessionid, isAsc);
		}

		//业绩
		if ("Acheivement".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Acheivement, isAsc);
		}

		//荣誉
		if ("Honor".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Honor, isAsc);
		}

		//专长
		if ("Skills".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Skills, isAsc);
		}

		//职称
		if ("Posttitleid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Posttitleid, isAsc);
		}

		//工作单位
		if ("Workunit".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Workunit, isAsc);
		}

		//现在住址
		if ("Adress".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Adress, isAsc);
		}

		//手机
		if ("Movephone".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Movephone, isAsc);
		}

		//邮箱
		if ("Email".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Email, isAsc);
		}

		//统计人员
		if ("Databasepeopleid1".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Databasepeopleid1, isAsc);
		}

		//填表人员
		if ("Databasepeopleid2".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Databasepeopleid2, isAsc);
		}

		//登录人员
		if ("Adminid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Adminid, isAsc);
		}

		//SectorID
		if ("Sectorid".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Sectorid, isAsc);
		}

		//登录时间
		if ("Logintime".equals(columnName) && isAsc == true)
		{
          return sort(TalentColumnNameEnum.Logintime, isAsc);
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
	public boolean sort(TalentColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//人才编号
		if (TalentColumnNameEnum.Talentid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentTalentidComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Talentid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentTalentidComparatorDesc());// 倒叙
			return true;
		}

		//姓名
		if (TalentColumnNameEnum.Talentname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentTalentnameComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Talentname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentTalentnameComparatorDesc());// 倒叙
			return true;
		}

		//性别：1-男、2-女
		if (TalentColumnNameEnum.Sex.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentSexComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Sex.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentSexComparatorDesc());// 倒叙
			return true;
		}

		//出生日期
		if (TalentColumnNameEnum.Birthday.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentBirthdayComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Birthday.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentBirthdayComparatorDesc());// 倒叙
			return true;
		}

		//民族
		if (TalentColumnNameEnum.Nationid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentNationidComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Nationid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentNationidComparatorDesc());// 倒叙
			return true;
		}

		//籍贯
		if (TalentColumnNameEnum.Nativeplace.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentNativeplaceComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Nativeplace.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentNativeplaceComparatorDesc());// 倒叙
			return true;
		}

		//政治面貌
		if (TalentColumnNameEnum.Politicsstatus.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentPoliticsstatusComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Politicsstatus.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentPoliticsstatusComparatorDesc());// 倒叙
			return true;
		}

		//省份
		if (TalentColumnNameEnum.Province.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentProvinceComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Province.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentProvinceComparatorDesc());// 倒叙
			return true;
		}

		//城市
		if (TalentColumnNameEnum.Cityid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentCityidComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Cityid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentCityidComparatorDesc());// 倒叙
			return true;
		}

		//学历
		if (TalentColumnNameEnum.Educationid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentEducationidComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Educationid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentEducationidComparatorDesc());// 倒叙
			return true;
		}

		//学位
		if (TalentColumnNameEnum.Degreeid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentDegreeidComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Degreeid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentDegreeidComparatorDesc());// 倒叙
			return true;
		}

		//专业
		if (TalentColumnNameEnum.Majorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentMajoridComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Majorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentMajoridComparatorDesc());// 倒叙
			return true;
		}

		//个人学习经历
		if (TalentColumnNameEnum.Learnexperience.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentLearnexperienceComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Learnexperience.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentLearnexperienceComparatorDesc());// 倒叙
			return true;
		}

		//工作经历
		if (TalentColumnNameEnum.Workexperience.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentWorkexperienceComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Workexperience.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentWorkexperienceComparatorDesc());// 倒叙
			return true;
		}

		//人才所属行业
		if (TalentColumnNameEnum.Talentprofessionid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentTalentprofessionidComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Talentprofessionid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentTalentprofessionidComparatorDesc());// 倒叙
			return true;
		}

		//业绩
		if (TalentColumnNameEnum.Acheivement.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentAcheivementComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Acheivement.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentAcheivementComparatorDesc());// 倒叙
			return true;
		}

		//荣誉
		if (TalentColumnNameEnum.Honor.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentHonorComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Honor.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentHonorComparatorDesc());// 倒叙
			return true;
		}

		//专长
		if (TalentColumnNameEnum.Skills.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentSkillsComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Skills.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentSkillsComparatorDesc());// 倒叙
			return true;
		}

		//职称
		if (TalentColumnNameEnum.Posttitleid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentPosttitleidComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Posttitleid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentPosttitleidComparatorDesc());// 倒叙
			return true;
		}

		//工作单位
		if (TalentColumnNameEnum.Workunit.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentWorkunitComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Workunit.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentWorkunitComparatorDesc());// 倒叙
			return true;
		}

		//现在住址
		if (TalentColumnNameEnum.Adress.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentAdressComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Adress.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentAdressComparatorDesc());// 倒叙
			return true;
		}

		//手机
		if (TalentColumnNameEnum.Movephone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentMovephoneComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Movephone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentMovephoneComparatorDesc());// 倒叙
			return true;
		}

		//邮箱
		if (TalentColumnNameEnum.Email.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentEmailComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Email.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentEmailComparatorDesc());// 倒叙
			return true;
		}

		//统计人员
		if (TalentColumnNameEnum.Databasepeopleid1.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentDatabasepeopleid1ComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Databasepeopleid1.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentDatabasepeopleid1ComparatorDesc());// 倒叙
			return true;
		}

		//填表人员
		if (TalentColumnNameEnum.Databasepeopleid2.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentDatabasepeopleid2ComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Databasepeopleid2.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentDatabasepeopleid2ComparatorDesc());// 倒叙
			return true;
		}

		//登录人员
		if (TalentColumnNameEnum.Adminid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentAdminidComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Adminid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentAdminidComparatorDesc());// 倒叙
			return true;
		}

		//SectorID
		if (TalentColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentSectoridComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentSectoridComparatorDesc());// 倒叙
			return true;
		}

		//登录时间
		if (TalentColumnNameEnum.Logintime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentLogintimeComparatorAsc());// 顺序
			return true;
		}
		if (TalentColumnNameEnum.Logintime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentLogintimeComparatorDesc());// 倒叙
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
		for (TalentInfo objTalentInfo : this)
		{
			objJSONArray.put(objTalentInfo.toJson());
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
				TalentInfo objTalentInfo = new TalentInfo();
				objTalentInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objTalentInfo);
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
	// [start] 按 Talentid 人才编号 正序排序
/**
 * 按 Talentid 人才编号 正序排序
 *
 */
class TalentTalentidComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getTalentid() > arg1.getTalentid())
			return 1;
		else if (arg0.getTalentid() < arg1.getTalentid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Talentid 人才编号 倒叙排序
/**
 * 按 Talentid 人才编号 倒叙排序
 *
 */
class TalentTalentidComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getTalentid() > arg1.getTalentid())
			return -1;
		else if (arg0.getTalentid() < arg1.getTalentid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Talentname 姓名正序排序
/**
 * 按 Talentname 姓名 正序排序
 *
 */
class TalentTalentnameComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getTalentname().toLowerCase().compareTo(arg1.getTalentname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Talentname 姓名 倒叙排序
/**
 * 按 Talentname 姓名 倒叙排序
 *
 */
class TalentTalentnameComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getTalentname().toLowerCase().compareTo(arg0.getTalentname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Sex 性别：1-男、2-女 正序排序
/**
 * 按 Sex 性别：1-男、2-女 正序排序
 *
 */
class TalentSexComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getSex() > arg1.getSex())
			return 1;
		else if (arg0.getSex() < arg1.getSex())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Sex 性别：1-男、2-女 倒叙排序
/**
 * 按 Sex 性别：1-男、2-女 倒叙排序
 *
 */
class TalentSexComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getSex() > arg1.getSex())
			return -1;
		else if (arg0.getSex() < arg1.getSex())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Birthday 出生日期正序排序
/**
 * 按 Birthday 出生日期 正序排序
 *
 */
class TalentBirthdayComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getBirthday().compareTo(arg1.getBirthday());
	}
}
	// [end]

	// [start] 按 Birthday 出生日期 倒叙排序
/**
 * 按 Birthday 出生日期 倒叙排序
 *
 */
class TalentBirthdayComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getBirthday().compareTo(arg0.getBirthday());
	}
}
	// [end]


	// [start] 按 Nationid 民族 正序排序
/**
 * 按 Nationid 民族 正序排序
 *
 */
class TalentNationidComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getNationid() > arg1.getNationid())
			return 1;
		else if (arg0.getNationid() < arg1.getNationid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Nationid 民族 倒叙排序
/**
 * 按 Nationid 民族 倒叙排序
 *
 */
class TalentNationidComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getNationid() > arg1.getNationid())
			return -1;
		else if (arg0.getNationid() < arg1.getNationid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Nativeplace 籍贯正序排序
/**
 * 按 Nativeplace 籍贯 正序排序
 *
 */
class TalentNativeplaceComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getNativeplace().toLowerCase().compareTo(arg1.getNativeplace().toLowerCase());
	}
}
	// [end]

	// [start] 按 Nativeplace 籍贯 倒叙排序
/**
 * 按 Nativeplace 籍贯 倒叙排序
 *
 */
class TalentNativeplaceComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getNativeplace().toLowerCase().compareTo(arg0.getNativeplace().toLowerCase());
	}
}
	// [end]


	// [start] 按 Politicsstatus 政治面貌正序排序
/**
 * 按 Politicsstatus 政治面貌 正序排序
 *
 */
class TalentPoliticsstatusComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getPoliticsstatus().toLowerCase().compareTo(arg1.getPoliticsstatus().toLowerCase());
	}
}
	// [end]

	// [start] 按 Politicsstatus 政治面貌 倒叙排序
/**
 * 按 Politicsstatus 政治面貌 倒叙排序
 *
 */
class TalentPoliticsstatusComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getPoliticsstatus().toLowerCase().compareTo(arg0.getPoliticsstatus().toLowerCase());
	}
}
	// [end]


	// [start] 按 Province 省份 正序排序
/**
 * 按 Province 省份 正序排序
 *
 */
class TalentProvinceComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getProvince() > arg1.getProvince())
			return 1;
		else if (arg0.getProvince() < arg1.getProvince())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Province 省份 倒叙排序
/**
 * 按 Province 省份 倒叙排序
 *
 */
class TalentProvinceComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getProvince() > arg1.getProvince())
			return -1;
		else if (arg0.getProvince() < arg1.getProvince())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Cityid 城市 正序排序
/**
 * 按 Cityid 城市 正序排序
 *
 */
class TalentCityidComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getCityid() > arg1.getCityid())
			return 1;
		else if (arg0.getCityid() < arg1.getCityid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Cityid 城市 倒叙排序
/**
 * 按 Cityid 城市 倒叙排序
 *
 */
class TalentCityidComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getCityid() > arg1.getCityid())
			return -1;
		else if (arg0.getCityid() < arg1.getCityid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Educationid 学历 正序排序
/**
 * 按 Educationid 学历 正序排序
 *
 */
class TalentEducationidComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getEducationid() > arg1.getEducationid())
			return 1;
		else if (arg0.getEducationid() < arg1.getEducationid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Educationid 学历 倒叙排序
/**
 * 按 Educationid 学历 倒叙排序
 *
 */
class TalentEducationidComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getEducationid() > arg1.getEducationid())
			return -1;
		else if (arg0.getEducationid() < arg1.getEducationid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Degreeid 学位 正序排序
/**
 * 按 Degreeid 学位 正序排序
 *
 */
class TalentDegreeidComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getDegreeid() > arg1.getDegreeid())
			return 1;
		else if (arg0.getDegreeid() < arg1.getDegreeid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Degreeid 学位 倒叙排序
/**
 * 按 Degreeid 学位 倒叙排序
 *
 */
class TalentDegreeidComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getDegreeid() > arg1.getDegreeid())
			return -1;
		else if (arg0.getDegreeid() < arg1.getDegreeid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Majorid 专业 正序排序
/**
 * 按 Majorid 专业 正序排序
 *
 */
class TalentMajoridComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getMajorid() > arg1.getMajorid())
			return 1;
		else if (arg0.getMajorid() < arg1.getMajorid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Majorid 专业 倒叙排序
/**
 * 按 Majorid 专业 倒叙排序
 *
 */
class TalentMajoridComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getMajorid() > arg1.getMajorid())
			return -1;
		else if (arg0.getMajorid() < arg1.getMajorid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Learnexperience 个人学习经历正序排序
/**
 * 按 Learnexperience 个人学习经历 正序排序
 *
 */
class TalentLearnexperienceComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getLearnexperience().toLowerCase().compareTo(arg1.getLearnexperience().toLowerCase());
	}
}
	// [end]

	// [start] 按 Learnexperience 个人学习经历 倒叙排序
/**
 * 按 Learnexperience 个人学习经历 倒叙排序
 *
 */
class TalentLearnexperienceComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getLearnexperience().toLowerCase().compareTo(arg0.getLearnexperience().toLowerCase());
	}
}
	// [end]


	// [start] 按 Workexperience 工作经历正序排序
/**
 * 按 Workexperience 工作经历 正序排序
 *
 */
class TalentWorkexperienceComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getWorkexperience().toLowerCase().compareTo(arg1.getWorkexperience().toLowerCase());
	}
}
	// [end]

	// [start] 按 Workexperience 工作经历 倒叙排序
/**
 * 按 Workexperience 工作经历 倒叙排序
 *
 */
class TalentWorkexperienceComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getWorkexperience().toLowerCase().compareTo(arg0.getWorkexperience().toLowerCase());
	}
}
	// [end]


	// [start] 按 Talentprofessionid 人才所属行业 正序排序
/**
 * 按 Talentprofessionid 人才所属行业 正序排序
 *
 */
class TalentTalentprofessionidComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getTalentprofessionid() > arg1.getTalentprofessionid())
			return 1;
		else if (arg0.getTalentprofessionid() < arg1.getTalentprofessionid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Talentprofessionid 人才所属行业 倒叙排序
/**
 * 按 Talentprofessionid 人才所属行业 倒叙排序
 *
 */
class TalentTalentprofessionidComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getTalentprofessionid() > arg1.getTalentprofessionid())
			return -1;
		else if (arg0.getTalentprofessionid() < arg1.getTalentprofessionid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Acheivement 业绩正序排序
/**
 * 按 Acheivement 业绩 正序排序
 *
 */
class TalentAcheivementComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getAcheivement().toLowerCase().compareTo(arg1.getAcheivement().toLowerCase());
	}
}
	// [end]

	// [start] 按 Acheivement 业绩 倒叙排序
/**
 * 按 Acheivement 业绩 倒叙排序
 *
 */
class TalentAcheivementComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getAcheivement().toLowerCase().compareTo(arg0.getAcheivement().toLowerCase());
	}
}
	// [end]


	// [start] 按 Honor 荣誉正序排序
/**
 * 按 Honor 荣誉 正序排序
 *
 */
class TalentHonorComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getHonor().toLowerCase().compareTo(arg1.getHonor().toLowerCase());
	}
}
	// [end]

	// [start] 按 Honor 荣誉 倒叙排序
/**
 * 按 Honor 荣誉 倒叙排序
 *
 */
class TalentHonorComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getHonor().toLowerCase().compareTo(arg0.getHonor().toLowerCase());
	}
}
	// [end]


	// [start] 按 Skills 专长正序排序
/**
 * 按 Skills 专长 正序排序
 *
 */
class TalentSkillsComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getSkills().toLowerCase().compareTo(arg1.getSkills().toLowerCase());
	}
}
	// [end]

	// [start] 按 Skills 专长 倒叙排序
/**
 * 按 Skills 专长 倒叙排序
 *
 */
class TalentSkillsComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getSkills().toLowerCase().compareTo(arg0.getSkills().toLowerCase());
	}
}
	// [end]


	// [start] 按 Posttitleid 职称 正序排序
/**
 * 按 Posttitleid 职称 正序排序
 *
 */
class TalentPosttitleidComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getPosttitleid() > arg1.getPosttitleid())
			return 1;
		else if (arg0.getPosttitleid() < arg1.getPosttitleid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Posttitleid 职称 倒叙排序
/**
 * 按 Posttitleid 职称 倒叙排序
 *
 */
class TalentPosttitleidComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		if (arg0.getPosttitleid() > arg1.getPosttitleid())
			return -1;
		else if (arg0.getPosttitleid() < arg1.getPosttitleid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Workunit 工作单位正序排序
/**
 * 按 Workunit 工作单位 正序排序
 *
 */
class TalentWorkunitComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getWorkunit().toLowerCase().compareTo(arg1.getWorkunit().toLowerCase());
	}
}
	// [end]

	// [start] 按 Workunit 工作单位 倒叙排序
/**
 * 按 Workunit 工作单位 倒叙排序
 *
 */
class TalentWorkunitComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getWorkunit().toLowerCase().compareTo(arg0.getWorkunit().toLowerCase());
	}
}
	// [end]


	// [start] 按 Adress 现在住址正序排序
/**
 * 按 Adress 现在住址 正序排序
 *
 */
class TalentAdressComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getAdress().toLowerCase().compareTo(arg1.getAdress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Adress 现在住址 倒叙排序
/**
 * 按 Adress 现在住址 倒叙排序
 *
 */
class TalentAdressComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getAdress().toLowerCase().compareTo(arg0.getAdress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Movephone 手机正序排序
/**
 * 按 Movephone 手机 正序排序
 *
 */
class TalentMovephoneComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getMovephone().toLowerCase().compareTo(arg1.getMovephone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Movephone 手机 倒叙排序
/**
 * 按 Movephone 手机 倒叙排序
 *
 */
class TalentMovephoneComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getMovephone().toLowerCase().compareTo(arg0.getMovephone().toLowerCase());
	}
}
	// [end]


	// [start] 按 Email 邮箱正序排序
/**
 * 按 Email 邮箱 正序排序
 *
 */
class TalentEmailComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg0.getEmail().toLowerCase().compareTo(arg1.getEmail().toLowerCase());
	}
}
	// [end]

	// [start] 按 Email 邮箱 倒叙排序
/**
 * 按 Email 邮箱 倒叙排序
 *
 */
class TalentEmailComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getEmail().toLowerCase().compareTo(arg0.getEmail().toLowerCase());
	}
}
	// [end]


	// [start] 按 Databasepeopleid1 统计人员 正序排序
/**
 * 按 Databasepeopleid1 统计人员 正序排序
 *
 */
class TalentDatabasepeopleid1ComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
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

	// [start] 按 Databasepeopleid1 统计人员 倒叙排序
/**
 * 按 Databasepeopleid1 统计人员 倒叙排序
 *
 */
class TalentDatabasepeopleid1ComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
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


	// [start] 按 Databasepeopleid2 填表人员 正序排序
/**
 * 按 Databasepeopleid2 填表人员 正序排序
 *
 */
class TalentDatabasepeopleid2ComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
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

	// [start] 按 Databasepeopleid2 填表人员 倒叙排序
/**
 * 按 Databasepeopleid2 填表人员 倒叙排序
 *
 */
class TalentDatabasepeopleid2ComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
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
class TalentAdminidComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
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
class TalentAdminidComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
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


	// [start] 按 Sectorid SectorID 正序排序
/**
 * 按 Sectorid SectorID 正序排序
 *
 */
class TalentSectoridComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
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

	// [start] 按 Sectorid SectorID 倒叙排序
/**
 * 按 Sectorid SectorID 倒叙排序
 *
 */
class TalentSectoridComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
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
class TalentLogintimeComparatorAsc implements Comparator<TalentInfo>
{
	public int compare(TalentInfo arg0, TalentInfo arg1)
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
class TalentLogintimeComparatorDesc implements Comparator<TalentInfo>
{

	public int compare(TalentInfo arg0, TalentInfo arg1)
	{
		return arg1.getLogintime().compareTo(arg0.getLogintime());
	}
}
	// [end]


	// [end]

