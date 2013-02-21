package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.SystemAdminInfoBase.*;

/**
 * SystemAdmin 系统人员表的摘要说明
 */
public class SystemAdminInfoCollectionBase extends ArrayList<SystemAdminInfo> implements List<SystemAdminInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012121309492304665L;

	// [start] 根据主键或自增字段返回SystemAdminInfo

        // [start] GetSystemAdminInfoByDatabaseadminid
        // [start] GetSystemAdminInfoByDatabaseadminid
        /**
        * 根据DatabaseAdminID获取表 系统人员表的对象SystemAdminInfo
        * @param Databaseadminid 人员ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemAdminInfo对象实体
        */
        public SystemAdminInfo GetSystemAdminInfoByDatabaseadminid(int Databaseadminid)
        {
              return GetSystemAdminInfoByDatabaseadminid(Databaseadminid,  true);
        }
        // [end]

        // [start] GetSystemAdminInfoByDatabaseadminid
        private int GetSystemAdminInfoByDatabaseadminid_Databaseadminid = 0;//人员ID
        private SystemAdminInfo GetSystemAdminInfoByDatabaseadminid_SystemAdminInfo;
        /**
        * 根据DatabaseAdminID获取表 系统人员表的对象SystemAdminInfo
        * @param Databaseadminid 人员ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemAdminInfo对象实体
        */
        public SystemAdminInfo GetSystemAdminInfoByDatabaseadminid(int Databaseadminid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetSystemAdminInfoByDatabaseadminid_SystemAdminInfo = null;
                if (GetSystemAdminInfoByDatabaseadminid_SystemAdminInfo == null || GetSystemAdminInfoByDatabaseadminid_Databaseadminid != Databaseadminid)
            {
            for (SystemAdminInfo objSystemAdminInfo : this)
            {
                if (objSystemAdminInfo.getDatabaseadminid() == Databaseadminid)
                {
                    GetSystemAdminInfoByDatabaseadminid_SystemAdminInfo = objSystemAdminInfo;
                    GetSystemAdminInfoByDatabaseadminid_Databaseadminid = Databaseadminid;//人员ID
                    return objSystemAdminInfo;
                }
            }
            return null;
            }
            else
            {
                return GetSystemAdminInfoByDatabaseadminid_SystemAdminInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabaseadminid
        /**
        * 根据DatabaseAdminID获取表 系统人员表的对象SystemAdminInfo 的位置
        * @param Databaseadminid 人员ID 
        * @return SystemAdminInfo对象实体 的位置
        */
        public int GetIndexByDatabaseadminid(int Databaseadminid)
        {
             int index = 0;
            for (SystemAdminInfo objSystemAdminInfo : this)
            {
                if (objSystemAdminInfo.getDatabaseadminid() == Databaseadminid)
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

	// [start] 根据索引返回SystemAdminInfoCollection

        // [start] GetSystemAdminInfoCollectionByAdminid
        // [start] GetSystemAdminInfoCollectionByAdminid
        /**
        * 根据AdminID获取表 系统人员表的对象集合SystemAdminInfoCollection
        * @param Adminid 人员编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemAdminInfoCollection对象集合
        */
        public SystemAdminInfoCollection GetSystemAdminInfoCollectionByAdminid(int Adminid)
        {
              return GetSystemAdminInfoCollectionByAdminid(Adminid,  true);
        }
        // [end]

        // [start] GetSystemAdminInfoCollectionByAdminid
        private int GetSystemAdminInfoCollectionByAdminid_Adminid = 0;//人员编号
        private SystemAdminInfoCollection GetSystemAdminInfoCollectionByAdminid_SystemAdminInfoCollection;
        /**
        * 根据AdminID获取表 系统人员表的对象集合SystemAdminInfoCollection
        * @param Adminid 人员编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemAdminInfoCollection对象集合
        */
        public SystemAdminInfoCollection GetSystemAdminInfoCollectionByAdminid(int Adminid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetSystemAdminInfoCollectionByAdminid_SystemAdminInfoCollection = null;
                if (GetSystemAdminInfoCollectionByAdminid_SystemAdminInfoCollection == null || GetSystemAdminInfoCollectionByAdminid_Adminid != Adminid)
            {
            SystemAdminInfoCollection list = new SystemAdminInfoCollection();
            for (SystemAdminInfo objSystemAdminInfo : this)
            {
                if (objSystemAdminInfo.getAdminid() == Adminid)
                {
                    list.add(objSystemAdminInfo);
                }
            }
            GetSystemAdminInfoCollectionByAdminid_SystemAdminInfoCollection = list;
            GetSystemAdminInfoCollectionByAdminid_Adminid = Adminid;//人员编号
            return list;
            }
            else
            {
                return GetSystemAdminInfoCollectionByAdminid_SystemAdminInfoCollection;
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
	public SystemAdminInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new SystemAdminInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		SystemAdminInfoCollection list = new SystemAdminInfoCollection();
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
    public SystemAdminInfoCollection Copy()
    {
        SystemAdminInfoCollection list = new SystemAdminInfoCollection();
        for (SystemAdminInfo objSystemAdminInfo : this)
        {
            list.add(objSystemAdminInfo.Copy());
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
		sbStr.append("<ArrayOfSystemAdminInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (SystemAdminInfo objSystemAdminInfo : this)
		{
			sbStr.append("  <SystemAdminInfo>\n");
            //人员ID
			sbStr.append("    <Databaseadminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getDatabaseadminid()));
			sbStr.append("</Databaseadminid>\n");
            //人员编号
			sbStr.append("    <Adminid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getAdminid()));
			sbStr.append("</Adminid>\n");
            //帐号
			sbStr.append("    <Adminname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getAdminname()));
			sbStr.append("</Adminname>\n");
            //密码
			sbStr.append("    <Adminpassword>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getAdminpassword()));
			sbStr.append("</Adminpassword>\n");
            //性别：1-男、2-女
			sbStr.append("    <Sex>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getSex()));
			sbStr.append("</Sex>\n");
            //姓名
			sbStr.append("    <Truename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getTruename()));
			sbStr.append("</Truename>\n");
            //工号
			sbStr.append("    <Workno>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getWorkno()));
			sbStr.append("</Workno>\n");
            //联系EMAIL
			sbStr.append("    <Email>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getEmail()));
			sbStr.append("</Email>\n");
            //移动电话
			sbStr.append("    <Movephone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getMovephone()));
			sbStr.append("</Movephone>\n");
            //电话
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getPhone()));
			sbStr.append("</Phone>\n");
            //MSN
			sbStr.append("    <Msn>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getMsn()));
			sbStr.append("</Msn>\n");
            //角色编号
			sbStr.append("    <Rolesid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getRolesid()));
			sbStr.append("</Rolesid>\n");
            //部门编号
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //人员描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getDescription()));
			sbStr.append("</Description>\n");
            //通讯地址
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getAddress()));
			sbStr.append("</Address>\n");
            //限定IP
			sbStr.append("    <LimitIp>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getLimitIp()));
			sbStr.append("</LimitIp>\n");
            //最后登录时间
			sbStr.append("    <LastLogintime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getLastLogintime()));
			sbStr.append("</LastLogintime>\n");
            //最后登录IP
			sbStr.append("    <LastLoginip>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getLastLoginip()));
			sbStr.append("</LastLoginip>\n");
            //创建时间
			sbStr.append("    <CreateTime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getCreateTime()));
			sbStr.append("</CreateTime>\n");
            //最后修改时间
			sbStr.append("    <LastModifytime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getLastModifytime()));
			sbStr.append("</LastModifytime>\n");
            //启用标志：1-启用、2-未启用
			sbStr.append("    <IsUse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getIsUse()));
			sbStr.append("</IsUse>\n");
            //是否删除：1-未删除、2-已删除
			sbStr.append("    <IsDel>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getIsDel()));
			sbStr.append("</IsDel>\n");
            //拥有权限
			sbStr.append("    <Competence>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminInfo.getCompetence()));
			sbStr.append("</Competence>\n");
			sbStr.append("  </SystemAdminInfo>\n");
		}
		sbStr.append("</ArrayOfSystemAdminInfo>\n");
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
	// GetSystemAdminInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemAdminInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemAdminInfoCollection GetSystemAdminInfoCollectionFormFileName(String filename)
	{
		return GetSystemAdminInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemAdminInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminInfoCollection GetSystemAdminInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemAdminInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetSystemAdminInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemAdminInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminInfoCollection GetSystemAdminInfoCollectionFormXml(String xml)
	{
		return GetSystemAdminInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemAdminInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminInfoCollection GetSystemAdminInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemAdminInfoCollection objSystemAdminInfoCollection = new SystemAdminInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("SystemAdminInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				SystemAdminInfo objSystemAdminInfo = new SystemAdminInfo();
				//人员ID
				if (foo.elementText("Databaseadminid") != null)
					objSystemAdminInfo.setDatabaseadminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseadminid")));
				//人员编号
				if (foo.elementText("Adminid") != null)
					objSystemAdminInfo.setAdminid(com.colorwinglib.Converts.StrToInt(foo.elementText("Adminid")));
				//帐号
				if (foo.elementText("Adminname") != null)
					objSystemAdminInfo.setAdminname(com.colorwinglib.Converts.objToStr(foo.elementText("Adminname")));
				//密码
				if (foo.elementText("Adminpassword") != null)
					objSystemAdminInfo.setAdminpassword(com.colorwinglib.Converts.objToStr(foo.elementText("Adminpassword")));
				//性别：1-男、2-女
				if (foo.elementText("Sex") != null)
					objSystemAdminInfo.setSex(com.colorwinglib.Converts.StrToInt(foo.elementText("Sex")));
				//姓名
				if (foo.elementText("Truename") != null)
					objSystemAdminInfo.setTruename(com.colorwinglib.Converts.objToStr(foo.elementText("Truename")));
				//工号
				if (foo.elementText("Workno") != null)
					objSystemAdminInfo.setWorkno(com.colorwinglib.Converts.objToStr(foo.elementText("Workno")));
				//联系EMAIL
				if (foo.elementText("Email") != null)
					objSystemAdminInfo.setEmail(com.colorwinglib.Converts.objToStr(foo.elementText("Email")));
				//移动电话
				if (foo.elementText("Movephone") != null)
					objSystemAdminInfo.setMovephone(com.colorwinglib.Converts.objToStr(foo.elementText("Movephone")));
				//电话
				if (foo.elementText("Phone") != null)
					objSystemAdminInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//MSN
				if (foo.elementText("Msn") != null)
					objSystemAdminInfo.setMsn(com.colorwinglib.Converts.objToStr(foo.elementText("Msn")));
				//角色编号
				if (foo.elementText("Rolesid") != null)
					objSystemAdminInfo.setRolesid(com.colorwinglib.Converts.StrToInt(foo.elementText("Rolesid")));
				//部门编号
				if (foo.elementText("Sectorid") != null)
					objSystemAdminInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//人员描述
				if (foo.elementText("Description") != null)
					objSystemAdminInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//通讯地址
				if (foo.elementText("Address") != null)
					objSystemAdminInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				//限定IP
				if (foo.elementText("LimitIp") != null)
					objSystemAdminInfo.setLimitIp(com.colorwinglib.Converts.objToStr(foo.elementText("LimitIp")));
				//最后登录时间
				if (foo.elementText("LastLogintime") != null)
					objSystemAdminInfo.setLastLogintime(com.colorwinglib.Converts.StrToDate(foo.elementText("LastLogintime")));
				//最后登录IP
				if (foo.elementText("LastLoginip") != null)
					objSystemAdminInfo.setLastLoginip(com.colorwinglib.Converts.objToStr(foo.elementText("LastLoginip")));
				//创建时间
				if (foo.elementText("CreateTime") != null)
					objSystemAdminInfo.setCreateTime(com.colorwinglib.Converts.StrToDate(foo.elementText("CreateTime")));
				//最后修改时间
				if (foo.elementText("LastModifytime") != null)
					objSystemAdminInfo.setLastModifytime(com.colorwinglib.Converts.StrToDate(foo.elementText("LastModifytime")));
				//启用标志：1-启用、2-未启用
				if (foo.elementText("IsUse") != null)
					objSystemAdminInfo.setIsUse(com.colorwinglib.Converts.StrToInt(foo.elementText("IsUse")));
				//是否删除：1-未删除、2-已删除
				if (foo.elementText("IsDel") != null)
					objSystemAdminInfo.setIsDel(com.colorwinglib.Converts.StrToInt(foo.elementText("IsDel")));
				//拥有权限
				if (foo.elementText("Competence") != null)
					objSystemAdminInfo.setCompetence(com.colorwinglib.Converts.objToStr(foo.elementText("Competence")));
				objSystemAdminInfoCollection.add(objSystemAdminInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemAdminInfoCollection;
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
		//人员ID
		if ("Databaseadminid".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Databaseadminid, isAsc);
		}

		//人员编号
		if ("Adminid".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Adminid, isAsc);
		}

		//帐号
		if ("Adminname".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Adminname, isAsc);
		}

		//密码
		if ("Adminpassword".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Adminpassword, isAsc);
		}

		//性别：1-男、2-女
		if ("Sex".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Sex, isAsc);
		}

		//姓名
		if ("Truename".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Truename, isAsc);
		}

		//工号
		if ("Workno".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Workno, isAsc);
		}

		//联系EMAIL
		if ("Email".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Email, isAsc);
		}

		//移动电话
		if ("Movephone".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Movephone, isAsc);
		}

		//电话
		if ("Phone".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Phone, isAsc);
		}

		//MSN
		if ("Msn".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Msn, isAsc);
		}

		//角色编号
		if ("Rolesid".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Rolesid, isAsc);
		}

		//部门编号
		if ("Sectorid".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Sectorid, isAsc);
		}

		//人员描述
		if ("Description".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Description, isAsc);
		}

		//通讯地址
		if ("Address".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Address, isAsc);
		}

		//限定IP
		if ("LimitIp".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.LimitIp, isAsc);
		}

		//最后登录时间
		if ("LastLogintime".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.LastLogintime, isAsc);
		}

		//最后登录IP
		if ("LastLoginip".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.LastLoginip, isAsc);
		}

		//创建时间
		if ("CreateTime".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.CreateTime, isAsc);
		}

		//最后修改时间
		if ("LastModifytime".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.LastModifytime, isAsc);
		}

		//启用标志：1-启用、2-未启用
		if ("IsUse".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.IsUse, isAsc);
		}

		//是否删除：1-未删除、2-已删除
		if ("IsDel".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.IsDel, isAsc);
		}

		//拥有权限
		if ("Competence".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminColumnNameEnum.Competence, isAsc);
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
	public boolean sort(SystemAdminColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//人员ID
		if (SystemAdminColumnNameEnum.Databaseadminid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminDatabaseadminidComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Databaseadminid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminDatabaseadminidComparatorDesc());// 倒叙
			return true;
		}

		//人员编号
		if (SystemAdminColumnNameEnum.Adminid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminAdminidComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Adminid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminAdminidComparatorDesc());// 倒叙
			return true;
		}

		//帐号
		if (SystemAdminColumnNameEnum.Adminname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminAdminnameComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Adminname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminAdminnameComparatorDesc());// 倒叙
			return true;
		}

		//密码
		if (SystemAdminColumnNameEnum.Adminpassword.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminAdminpasswordComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Adminpassword.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminAdminpasswordComparatorDesc());// 倒叙
			return true;
		}

		//性别：1-男、2-女
		if (SystemAdminColumnNameEnum.Sex.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminSexComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Sex.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminSexComparatorDesc());// 倒叙
			return true;
		}

		//姓名
		if (SystemAdminColumnNameEnum.Truename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminTruenameComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Truename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminTruenameComparatorDesc());// 倒叙
			return true;
		}

		//工号
		if (SystemAdminColumnNameEnum.Workno.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminWorknoComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Workno.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminWorknoComparatorDesc());// 倒叙
			return true;
		}

		//联系EMAIL
		if (SystemAdminColumnNameEnum.Email.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminEmailComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Email.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminEmailComparatorDesc());// 倒叙
			return true;
		}

		//移动电话
		if (SystemAdminColumnNameEnum.Movephone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminMovephoneComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Movephone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminMovephoneComparatorDesc());// 倒叙
			return true;
		}

		//电话
		if (SystemAdminColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminPhoneComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminPhoneComparatorDesc());// 倒叙
			return true;
		}

		//MSN
		if (SystemAdminColumnNameEnum.Msn.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminMsnComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Msn.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminMsnComparatorDesc());// 倒叙
			return true;
		}

		//角色编号
		if (SystemAdminColumnNameEnum.Rolesid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminRolesidComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Rolesid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminRolesidComparatorDesc());// 倒叙
			return true;
		}

		//部门编号
		if (SystemAdminColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminSectoridComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminSectoridComparatorDesc());// 倒叙
			return true;
		}

		//人员描述
		if (SystemAdminColumnNameEnum.Description.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminDescriptionComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Description.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminDescriptionComparatorDesc());// 倒叙
			return true;
		}

		//通讯地址
		if (SystemAdminColumnNameEnum.Address.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminAddressComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Address.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminAddressComparatorDesc());// 倒叙
			return true;
		}

		//限定IP
		if (SystemAdminColumnNameEnum.LimitIp.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLimitIpComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.LimitIp.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLimitIpComparatorDesc());// 倒叙
			return true;
		}

		//最后登录时间
		if (SystemAdminColumnNameEnum.LastLogintime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLastLogintimeComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.LastLogintime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLastLogintimeComparatorDesc());// 倒叙
			return true;
		}

		//最后登录IP
		if (SystemAdminColumnNameEnum.LastLoginip.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLastLoginipComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.LastLoginip.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLastLoginipComparatorDesc());// 倒叙
			return true;
		}

		//创建时间
		if (SystemAdminColumnNameEnum.CreateTime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminCreateTimeComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.CreateTime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminCreateTimeComparatorDesc());// 倒叙
			return true;
		}

		//最后修改时间
		if (SystemAdminColumnNameEnum.LastModifytime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLastModifytimeComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.LastModifytime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLastModifytimeComparatorDesc());// 倒叙
			return true;
		}

		//启用标志：1-启用、2-未启用
		if (SystemAdminColumnNameEnum.IsUse.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminIsUseComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.IsUse.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminIsUseComparatorDesc());// 倒叙
			return true;
		}

		//是否删除：1-未删除、2-已删除
		if (SystemAdminColumnNameEnum.IsDel.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminIsDelComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.IsDel.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminIsDelComparatorDesc());// 倒叙
			return true;
		}

		//拥有权限
		if (SystemAdminColumnNameEnum.Competence.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminCompetenceComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminColumnNameEnum.Competence.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminCompetenceComparatorDesc());// 倒叙
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
		for (SystemAdminInfo objSystemAdminInfo : this)
		{
			objJSONArray.put(objSystemAdminInfo.toJson());
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
				SystemAdminInfo objSystemAdminInfo = new SystemAdminInfo();
				objSystemAdminInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objSystemAdminInfo);
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
	// [start] 按 Databaseadminid 人员ID 正序排序
/**
 * 按 Databaseadminid 人员ID 正序排序
 *
 */
class SystemAdminDatabaseadminidComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		if (arg0.getDatabaseadminid() > arg1.getDatabaseadminid())
			return 1;
		else if (arg0.getDatabaseadminid() < arg1.getDatabaseadminid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databaseadminid 人员ID 倒叙排序
/**
 * 按 Databaseadminid 人员ID 倒叙排序
 *
 */
class SystemAdminDatabaseadminidComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		if (arg0.getDatabaseadminid() > arg1.getDatabaseadminid())
			return -1;
		else if (arg0.getDatabaseadminid() < arg1.getDatabaseadminid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Adminid 人员编号 正序排序
/**
 * 按 Adminid 人员编号 正序排序
 *
 */
class SystemAdminAdminidComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
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

	// [start] 按 Adminid 人员编号 倒叙排序
/**
 * 按 Adminid 人员编号 倒叙排序
 *
 */
class SystemAdminAdminidComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
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


	// [start] 按 Adminname 帐号正序排序
/**
 * 按 Adminname 帐号 正序排序
 *
 */
class SystemAdminAdminnameComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getAdminname().toLowerCase().compareTo(arg1.getAdminname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Adminname 帐号 倒叙排序
/**
 * 按 Adminname 帐号 倒叙排序
 *
 */
class SystemAdminAdminnameComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getAdminname().toLowerCase().compareTo(arg0.getAdminname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Adminpassword 密码正序排序
/**
 * 按 Adminpassword 密码 正序排序
 *
 */
class SystemAdminAdminpasswordComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getAdminpassword().toLowerCase().compareTo(arg1.getAdminpassword().toLowerCase());
	}
}
	// [end]

	// [start] 按 Adminpassword 密码 倒叙排序
/**
 * 按 Adminpassword 密码 倒叙排序
 *
 */
class SystemAdminAdminpasswordComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getAdminpassword().toLowerCase().compareTo(arg0.getAdminpassword().toLowerCase());
	}
}
	// [end]


	// [start] 按 Sex 性别：1-男、2-女 正序排序
/**
 * 按 Sex 性别：1-男、2-女 正序排序
 *
 */
class SystemAdminSexComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
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
class SystemAdminSexComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
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


	// [start] 按 Truename 姓名正序排序
/**
 * 按 Truename 姓名 正序排序
 *
 */
class SystemAdminTruenameComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getTruename().toLowerCase().compareTo(arg1.getTruename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Truename 姓名 倒叙排序
/**
 * 按 Truename 姓名 倒叙排序
 *
 */
class SystemAdminTruenameComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getTruename().toLowerCase().compareTo(arg0.getTruename().toLowerCase());
	}
}
	// [end]


	// [start] 按 Workno 工号正序排序
/**
 * 按 Workno 工号 正序排序
 *
 */
class SystemAdminWorknoComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getWorkno().toLowerCase().compareTo(arg1.getWorkno().toLowerCase());
	}
}
	// [end]

	// [start] 按 Workno 工号 倒叙排序
/**
 * 按 Workno 工号 倒叙排序
 *
 */
class SystemAdminWorknoComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getWorkno().toLowerCase().compareTo(arg0.getWorkno().toLowerCase());
	}
}
	// [end]


	// [start] 按 Email 联系EMAIL正序排序
/**
 * 按 Email 联系EMAIL 正序排序
 *
 */
class SystemAdminEmailComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getEmail().toLowerCase().compareTo(arg1.getEmail().toLowerCase());
	}
}
	// [end]

	// [start] 按 Email 联系EMAIL 倒叙排序
/**
 * 按 Email 联系EMAIL 倒叙排序
 *
 */
class SystemAdminEmailComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getEmail().toLowerCase().compareTo(arg0.getEmail().toLowerCase());
	}
}
	// [end]


	// [start] 按 Movephone 移动电话正序排序
/**
 * 按 Movephone 移动电话 正序排序
 *
 */
class SystemAdminMovephoneComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getMovephone().toLowerCase().compareTo(arg1.getMovephone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Movephone 移动电话 倒叙排序
/**
 * 按 Movephone 移动电话 倒叙排序
 *
 */
class SystemAdminMovephoneComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getMovephone().toLowerCase().compareTo(arg0.getMovephone().toLowerCase());
	}
}
	// [end]


	// [start] 按 Phone 电话正序排序
/**
 * 按 Phone 电话 正序排序
 *
 */
class SystemAdminPhoneComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getPhone().toLowerCase().compareTo(arg1.getPhone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Phone 电话 倒叙排序
/**
 * 按 Phone 电话 倒叙排序
 *
 */
class SystemAdminPhoneComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getPhone().toLowerCase().compareTo(arg0.getPhone().toLowerCase());
	}
}
	// [end]


	// [start] 按 Msn MSN正序排序
/**
 * 按 Msn MSN 正序排序
 *
 */
class SystemAdminMsnComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getMsn().toLowerCase().compareTo(arg1.getMsn().toLowerCase());
	}
}
	// [end]

	// [start] 按 Msn MSN 倒叙排序
/**
 * 按 Msn MSN 倒叙排序
 *
 */
class SystemAdminMsnComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getMsn().toLowerCase().compareTo(arg0.getMsn().toLowerCase());
	}
}
	// [end]


	// [start] 按 Rolesid 角色编号 正序排序
/**
 * 按 Rolesid 角色编号 正序排序
 *
 */
class SystemAdminRolesidComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		if (arg0.getRolesid() > arg1.getRolesid())
			return 1;
		else if (arg0.getRolesid() < arg1.getRolesid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Rolesid 角色编号 倒叙排序
/**
 * 按 Rolesid 角色编号 倒叙排序
 *
 */
class SystemAdminRolesidComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		if (arg0.getRolesid() > arg1.getRolesid())
			return -1;
		else if (arg0.getRolesid() < arg1.getRolesid())
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
class SystemAdminSectoridComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
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
class SystemAdminSectoridComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
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


	// [start] 按 Description 人员描述正序排序
/**
 * 按 Description 人员描述 正序排序
 *
 */
class SystemAdminDescriptionComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getDescription().toLowerCase().compareTo(arg1.getDescription().toLowerCase());
	}
}
	// [end]

	// [start] 按 Description 人员描述 倒叙排序
/**
 * 按 Description 人员描述 倒叙排序
 *
 */
class SystemAdminDescriptionComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getDescription().toLowerCase().compareTo(arg0.getDescription().toLowerCase());
	}
}
	// [end]


	// [start] 按 Address 通讯地址正序排序
/**
 * 按 Address 通讯地址 正序排序
 *
 */
class SystemAdminAddressComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getAddress().toLowerCase().compareTo(arg1.getAddress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Address 通讯地址 倒叙排序
/**
 * 按 Address 通讯地址 倒叙排序
 *
 */
class SystemAdminAddressComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getAddress().toLowerCase().compareTo(arg0.getAddress().toLowerCase());
	}
}
	// [end]


	// [start] 按 LimitIp 限定IP正序排序
/**
 * 按 LimitIp 限定IP 正序排序
 *
 */
class SystemAdminLimitIpComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getLimitIp().toLowerCase().compareTo(arg1.getLimitIp().toLowerCase());
	}
}
	// [end]

	// [start] 按 LimitIp 限定IP 倒叙排序
/**
 * 按 LimitIp 限定IP 倒叙排序
 *
 */
class SystemAdminLimitIpComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getLimitIp().toLowerCase().compareTo(arg0.getLimitIp().toLowerCase());
	}
}
	// [end]


	// [start] 按 LastLogintime 最后登录时间正序排序
/**
 * 按 LastLogintime 最后登录时间 正序排序
 *
 */
class SystemAdminLastLogintimeComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getLastLogintime().compareTo(arg1.getLastLogintime());
	}
}
	// [end]

	// [start] 按 LastLogintime 最后登录时间 倒叙排序
/**
 * 按 LastLogintime 最后登录时间 倒叙排序
 *
 */
class SystemAdminLastLogintimeComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getLastLogintime().compareTo(arg0.getLastLogintime());
	}
}
	// [end]


	// [start] 按 LastLoginip 最后登录IP正序排序
/**
 * 按 LastLoginip 最后登录IP 正序排序
 *
 */
class SystemAdminLastLoginipComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getLastLoginip().toLowerCase().compareTo(arg1.getLastLoginip().toLowerCase());
	}
}
	// [end]

	// [start] 按 LastLoginip 最后登录IP 倒叙排序
/**
 * 按 LastLoginip 最后登录IP 倒叙排序
 *
 */
class SystemAdminLastLoginipComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getLastLoginip().toLowerCase().compareTo(arg0.getLastLoginip().toLowerCase());
	}
}
	// [end]


	// [start] 按 CreateTime 创建时间正序排序
/**
 * 按 CreateTime 创建时间 正序排序
 *
 */
class SystemAdminCreateTimeComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getCreateTime().compareTo(arg1.getCreateTime());
	}
}
	// [end]

	// [start] 按 CreateTime 创建时间 倒叙排序
/**
 * 按 CreateTime 创建时间 倒叙排序
 *
 */
class SystemAdminCreateTimeComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getCreateTime().compareTo(arg0.getCreateTime());
	}
}
	// [end]


	// [start] 按 LastModifytime 最后修改时间正序排序
/**
 * 按 LastModifytime 最后修改时间 正序排序
 *
 */
class SystemAdminLastModifytimeComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getLastModifytime().compareTo(arg1.getLastModifytime());
	}
}
	// [end]

	// [start] 按 LastModifytime 最后修改时间 倒叙排序
/**
 * 按 LastModifytime 最后修改时间 倒叙排序
 *
 */
class SystemAdminLastModifytimeComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getLastModifytime().compareTo(arg0.getLastModifytime());
	}
}
	// [end]


	// [start] 按 IsUse 启用标志：1-启用、2-未启用 正序排序
/**
 * 按 IsUse 启用标志：1-启用、2-未启用 正序排序
 *
 */
class SystemAdminIsUseComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		if (arg0.getIsUse() > arg1.getIsUse())
			return 1;
		else if (arg0.getIsUse() < arg1.getIsUse())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 IsUse 启用标志：1-启用、2-未启用 倒叙排序
/**
 * 按 IsUse 启用标志：1-启用、2-未启用 倒叙排序
 *
 */
class SystemAdminIsUseComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		if (arg0.getIsUse() > arg1.getIsUse())
			return -1;
		else if (arg0.getIsUse() < arg1.getIsUse())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 IsDel 是否删除：1-未删除、2-已删除 正序排序
/**
 * 按 IsDel 是否删除：1-未删除、2-已删除 正序排序
 *
 */
class SystemAdminIsDelComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		if (arg0.getIsDel() > arg1.getIsDel())
			return 1;
		else if (arg0.getIsDel() < arg1.getIsDel())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 IsDel 是否删除：1-未删除、2-已删除 倒叙排序
/**
 * 按 IsDel 是否删除：1-未删除、2-已删除 倒叙排序
 *
 */
class SystemAdminIsDelComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		if (arg0.getIsDel() > arg1.getIsDel())
			return -1;
		else if (arg0.getIsDel() < arg1.getIsDel())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Competence 拥有权限正序排序
/**
 * 按 Competence 拥有权限 正序排序
 *
 */
class SystemAdminCompetenceComparatorAsc implements Comparator<SystemAdminInfo>
{
	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg0.getCompetence().toLowerCase().compareTo(arg1.getCompetence().toLowerCase());
	}
}
	// [end]

	// [start] 按 Competence 拥有权限 倒叙排序
/**
 * 按 Competence 拥有权限 倒叙排序
 *
 */
class SystemAdminCompetenceComparatorDesc implements Comparator<SystemAdminInfo>
{

	public int compare(SystemAdminInfo arg0, SystemAdminInfo arg1)
	{
		return arg1.getCompetence().toLowerCase().compareTo(arg0.getCompetence().toLowerCase());
	}
}
	// [end]


	// [end]

