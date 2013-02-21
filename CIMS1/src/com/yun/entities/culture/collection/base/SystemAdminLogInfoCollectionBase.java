package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.SystemAdminLogInfoBase.*;

/**
 * SystemAdminLog 管理人员日志表的摘要说明
 */
public class SystemAdminLogInfoCollectionBase extends ArrayList<SystemAdminLogInfo> implements List<SystemAdminLogInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311555125018L;

	// [start] 根据主键或自增字段返回SystemAdminLogInfo

        // [start] GetSystemAdminLogInfoByLogid
        // [start] GetSystemAdminLogInfoByLogid
        /**
        * 根据LogID获取表 管理人员日志表的对象SystemAdminLogInfo
        * @param Logid 人员日志编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemAdminLogInfo对象实体
        */
        public SystemAdminLogInfo GetSystemAdminLogInfoByLogid(int Logid)
        {
              return GetSystemAdminLogInfoByLogid(Logid,  true);
        }
        // [end]

        // [start] GetSystemAdminLogInfoByLogid
        private int GetSystemAdminLogInfoByLogid_Logid = 0;//人员日志编号
        private SystemAdminLogInfo GetSystemAdminLogInfoByLogid_SystemAdminLogInfo;
        /**
        * 根据LogID获取表 管理人员日志表的对象SystemAdminLogInfo
        * @param Logid 人员日志编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemAdminLogInfo对象实体
        */
        public SystemAdminLogInfo GetSystemAdminLogInfoByLogid(int Logid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetSystemAdminLogInfoByLogid_SystemAdminLogInfo = null;
                if (GetSystemAdminLogInfoByLogid_SystemAdminLogInfo == null || GetSystemAdminLogInfoByLogid_Logid != Logid)
            {
            for (SystemAdminLogInfo objSystemAdminLogInfo : this)
            {
                if (objSystemAdminLogInfo.getLogid() == Logid)
                {
                    GetSystemAdminLogInfoByLogid_SystemAdminLogInfo = objSystemAdminLogInfo;
                    GetSystemAdminLogInfoByLogid_Logid = Logid;//人员日志编号
                    return objSystemAdminLogInfo;
                }
            }
            return null;
            }
            else
            {
                return GetSystemAdminLogInfoByLogid_SystemAdminLogInfo;
            }
        }
        // [end]

        // [start] GetIndexByLogid
        /**
        * 根据LogID获取表 管理人员日志表的对象SystemAdminLogInfo 的位置
        * @param Logid 人员日志编号 
        * @return SystemAdminLogInfo对象实体 的位置
        */
        public int GetIndexByLogid(int Logid)
        {
             int index = 0;
            for (SystemAdminLogInfo objSystemAdminLogInfo : this)
            {
                if (objSystemAdminLogInfo.getLogid() == Logid)
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

	// [start] 根据索引返回SystemAdminLogInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public SystemAdminLogInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new SystemAdminLogInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		SystemAdminLogInfoCollection list = new SystemAdminLogInfoCollection();
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
    public SystemAdminLogInfoCollection Copy()
    {
        SystemAdminLogInfoCollection list = new SystemAdminLogInfoCollection();
        for (SystemAdminLogInfo objSystemAdminLogInfo : this)
        {
            list.add(objSystemAdminLogInfo.Copy());
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
		sbStr.append("<ArrayOfSystemAdminLogInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (SystemAdminLogInfo objSystemAdminLogInfo : this)
		{
			sbStr.append("  <SystemAdminLogInfo>\n");
            //人员日志编号
			sbStr.append("    <Logid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminLogInfo.getLogid()));
			sbStr.append("</Logid>\n");
            //帐号
			sbStr.append("    <Adminname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminLogInfo.getAdminname()));
			sbStr.append("</Adminname>\n");
            //日志类型：1-操作日志、2-登录日志
			sbStr.append("    <Type>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminLogInfo.getType()));
			sbStr.append("</Type>\n");
            //日志内容
			sbStr.append("    <Content>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminLogInfo.getContent()));
			sbStr.append("</Content>\n");
            //日志时间
			sbStr.append("    <Addtime>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminLogInfo.getAddtime()));
			sbStr.append("</Addtime>\n");
            //日志IP
			sbStr.append("    <Ip>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemAdminLogInfo.getIp()));
			sbStr.append("</Ip>\n");
			sbStr.append("  </SystemAdminLogInfo>\n");
		}
		sbStr.append("</ArrayOfSystemAdminLogInfo>\n");
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
	// GetSystemAdminLogInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemAdminLogInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemAdminLogInfoCollection GetSystemAdminLogInfoCollectionFormFileName(String filename)
	{
		return GetSystemAdminLogInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemAdminLogInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminLogInfoCollection GetSystemAdminLogInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemAdminLogInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetSystemAdminLogInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemAdminLogInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminLogInfoCollection GetSystemAdminLogInfoCollectionFormXml(String xml)
	{
		return GetSystemAdminLogInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemAdminLogInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemAdminLogInfoCollection GetSystemAdminLogInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemAdminLogInfoCollection objSystemAdminLogInfoCollection = new SystemAdminLogInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("SystemAdminLogInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				SystemAdminLogInfo objSystemAdminLogInfo = new SystemAdminLogInfo();
				//人员日志编号
				if (foo.elementText("Logid") != null)
					objSystemAdminLogInfo.setLogid(com.colorwinglib.Converts.StrToInt(foo.elementText("Logid")));
				//帐号
				if (foo.elementText("Adminname") != null)
					objSystemAdminLogInfo.setAdminname(com.colorwinglib.Converts.objToStr(foo.elementText("Adminname")));
				//日志类型：1-操作日志、2-登录日志
				if (foo.elementText("Type") != null)
					objSystemAdminLogInfo.setType(com.colorwinglib.Converts.StrToInt(foo.elementText("Type")));
				//日志内容
				if (foo.elementText("Content") != null)
					objSystemAdminLogInfo.setContent(com.colorwinglib.Converts.objToStr(foo.elementText("Content")));
				//日志时间
				if (foo.elementText("Addtime") != null)
					objSystemAdminLogInfo.setAddtime(com.colorwinglib.Converts.StrToDate(foo.elementText("Addtime")));
				//日志IP
				if (foo.elementText("Ip") != null)
					objSystemAdminLogInfo.setIp(com.colorwinglib.Converts.objToStr(foo.elementText("Ip")));
				objSystemAdminLogInfoCollection.add(objSystemAdminLogInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemAdminLogInfoCollection;
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
		//人员日志编号
		if ("Logid".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminLogColumnNameEnum.Logid, isAsc);
		}

		//帐号
		if ("Adminname".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminLogColumnNameEnum.Adminname, isAsc);
		}

		//日志类型：1-操作日志、2-登录日志
		if ("Type".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminLogColumnNameEnum.Type, isAsc);
		}

		//日志内容
		if ("Content".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminLogColumnNameEnum.Content, isAsc);
		}

		//日志时间
		if ("Addtime".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminLogColumnNameEnum.Addtime, isAsc);
		}

		//日志IP
		if ("Ip".equals(columnName) && isAsc == true)
		{
          return sort(SystemAdminLogColumnNameEnum.Ip, isAsc);
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
	public boolean sort(SystemAdminLogColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//人员日志编号
		if (SystemAdminLogColumnNameEnum.Logid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLogLogidComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminLogColumnNameEnum.Logid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLogLogidComparatorDesc());// 倒叙
			return true;
		}

		//帐号
		if (SystemAdminLogColumnNameEnum.Adminname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLogAdminnameComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminLogColumnNameEnum.Adminname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLogAdminnameComparatorDesc());// 倒叙
			return true;
		}

		//日志类型：1-操作日志、2-登录日志
		if (SystemAdminLogColumnNameEnum.Type.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLogTypeComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminLogColumnNameEnum.Type.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLogTypeComparatorDesc());// 倒叙
			return true;
		}

		//日志内容
		if (SystemAdminLogColumnNameEnum.Content.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLogContentComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminLogColumnNameEnum.Content.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLogContentComparatorDesc());// 倒叙
			return true;
		}

		//日志时间
		if (SystemAdminLogColumnNameEnum.Addtime.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLogAddtimeComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminLogColumnNameEnum.Addtime.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLogAddtimeComparatorDesc());// 倒叙
			return true;
		}

		//日志IP
		if (SystemAdminLogColumnNameEnum.Ip.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemAdminLogIpComparatorAsc());// 顺序
			return true;
		}
		if (SystemAdminLogColumnNameEnum.Ip.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemAdminLogIpComparatorDesc());// 倒叙
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
		for (SystemAdminLogInfo objSystemAdminLogInfo : this)
		{
			objJSONArray.put(objSystemAdminLogInfo.toJson());
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
				SystemAdminLogInfo objSystemAdminLogInfo = new SystemAdminLogInfo();
				objSystemAdminLogInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objSystemAdminLogInfo);
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
	// [start] 按 Logid 人员日志编号 正序排序
/**
 * 按 Logid 人员日志编号 正序排序
 *
 */
class SystemAdminLogLogidComparatorAsc implements Comparator<SystemAdminLogInfo>
{
	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		if (arg0.getLogid() > arg1.getLogid())
			return 1;
		else if (arg0.getLogid() < arg1.getLogid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Logid 人员日志编号 倒叙排序
/**
 * 按 Logid 人员日志编号 倒叙排序
 *
 */
class SystemAdminLogLogidComparatorDesc implements Comparator<SystemAdminLogInfo>
{

	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		if (arg0.getLogid() > arg1.getLogid())
			return -1;
		else if (arg0.getLogid() < arg1.getLogid())
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
class SystemAdminLogAdminnameComparatorAsc implements Comparator<SystemAdminLogInfo>
{
	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
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
class SystemAdminLogAdminnameComparatorDesc implements Comparator<SystemAdminLogInfo>
{

	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		return arg1.getAdminname().toLowerCase().compareTo(arg0.getAdminname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Type 日志类型：1-操作日志、2-登录日志 正序排序
/**
 * 按 Type 日志类型：1-操作日志、2-登录日志 正序排序
 *
 */
class SystemAdminLogTypeComparatorAsc implements Comparator<SystemAdminLogInfo>
{
	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		if (arg0.getType() > arg1.getType())
			return 1;
		else if (arg0.getType() < arg1.getType())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Type 日志类型：1-操作日志、2-登录日志 倒叙排序
/**
 * 按 Type 日志类型：1-操作日志、2-登录日志 倒叙排序
 *
 */
class SystemAdminLogTypeComparatorDesc implements Comparator<SystemAdminLogInfo>
{

	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		if (arg0.getType() > arg1.getType())
			return -1;
		else if (arg0.getType() < arg1.getType())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Content 日志内容正序排序
/**
 * 按 Content 日志内容 正序排序
 *
 */
class SystemAdminLogContentComparatorAsc implements Comparator<SystemAdminLogInfo>
{
	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		return arg0.getContent().toLowerCase().compareTo(arg1.getContent().toLowerCase());
	}
}
	// [end]

	// [start] 按 Content 日志内容 倒叙排序
/**
 * 按 Content 日志内容 倒叙排序
 *
 */
class SystemAdminLogContentComparatorDesc implements Comparator<SystemAdminLogInfo>
{

	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		return arg1.getContent().toLowerCase().compareTo(arg0.getContent().toLowerCase());
	}
}
	// [end]


	// [start] 按 Addtime 日志时间正序排序
/**
 * 按 Addtime 日志时间 正序排序
 *
 */
class SystemAdminLogAddtimeComparatorAsc implements Comparator<SystemAdminLogInfo>
{
	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		return arg0.getAddtime().compareTo(arg1.getAddtime());
	}
}
	// [end]

	// [start] 按 Addtime 日志时间 倒叙排序
/**
 * 按 Addtime 日志时间 倒叙排序
 *
 */
class SystemAdminLogAddtimeComparatorDesc implements Comparator<SystemAdminLogInfo>
{

	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		return arg1.getAddtime().compareTo(arg0.getAddtime());
	}
}
	// [end]


	// [start] 按 Ip 日志IP正序排序
/**
 * 按 Ip 日志IP 正序排序
 *
 */
class SystemAdminLogIpComparatorAsc implements Comparator<SystemAdminLogInfo>
{
	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		return arg0.getIp().toLowerCase().compareTo(arg1.getIp().toLowerCase());
	}
}
	// [end]

	// [start] 按 Ip 日志IP 倒叙排序
/**
 * 按 Ip 日志IP 倒叙排序
 *
 */
class SystemAdminLogIpComparatorDesc implements Comparator<SystemAdminLogInfo>
{

	public int compare(SystemAdminLogInfo arg0, SystemAdminLogInfo arg1)
	{
		return arg1.getIp().toLowerCase().compareTo(arg0.getIp().toLowerCase());
	}
}
	// [end]


	// [end]

