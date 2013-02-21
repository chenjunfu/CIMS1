package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.HuanpiInfoBase.*;

/**
 * Huanpi 的摘要说明
 */
public class HuanpiInfoCollectionBase extends ArrayList<HuanpiInfo> implements List<HuanpiInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311481617183L;

	// [start] 根据主键或自增字段返回HuanpiInfo

        // [start] GetHuanpiInfoByHuanpidatabaseid
        // [start] GetHuanpiInfoByHuanpidatabaseid
        /**
        * 根据HuanpidatabaseID获取表 的对象HuanpiInfo
        * @param Huanpidatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return HuanpiInfo对象实体
        */
        public HuanpiInfo GetHuanpiInfoByHuanpidatabaseid(int Huanpidatabaseid)
        {
              return GetHuanpiInfoByHuanpidatabaseid(Huanpidatabaseid,  true);
        }
        // [end]

        // [start] GetHuanpiInfoByHuanpidatabaseid
        private int GetHuanpiInfoByHuanpidatabaseid_Huanpidatabaseid = 0;//数据库ID
        private HuanpiInfo GetHuanpiInfoByHuanpidatabaseid_HuanpiInfo;
        /**
        * 根据HuanpidatabaseID获取表 的对象HuanpiInfo
        * @param Huanpidatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return HuanpiInfo对象实体
        */
        public HuanpiInfo GetHuanpiInfoByHuanpidatabaseid(int Huanpidatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetHuanpiInfoByHuanpidatabaseid_HuanpiInfo = null;
                if (GetHuanpiInfoByHuanpidatabaseid_HuanpiInfo == null || GetHuanpiInfoByHuanpidatabaseid_Huanpidatabaseid != Huanpidatabaseid)
            {
            for (HuanpiInfo objHuanpiInfo : this)
            {
                if (objHuanpiInfo.getHuanpidatabaseid() == Huanpidatabaseid)
                {
                    GetHuanpiInfoByHuanpidatabaseid_HuanpiInfo = objHuanpiInfo;
                    GetHuanpiInfoByHuanpidatabaseid_Huanpidatabaseid = Huanpidatabaseid;//数据库ID
                    return objHuanpiInfo;
                }
            }
            return null;
            }
            else
            {
                return GetHuanpiInfoByHuanpidatabaseid_HuanpiInfo;
            }
        }
        // [end]

        // [start] GetIndexByHuanpidatabaseid
        /**
        * 根据HuanpidatabaseID获取表 的对象HuanpiInfo 的位置
        * @param Huanpidatabaseid 数据库ID 
        * @return HuanpiInfo对象实体 的位置
        */
        public int GetIndexByHuanpidatabaseid(int Huanpidatabaseid)
        {
             int index = 0;
            for (HuanpiInfo objHuanpiInfo : this)
            {
                if (objHuanpiInfo.getHuanpidatabaseid() == Huanpidatabaseid)
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

	// [start] 根据索引返回HuanpiInfoCollection

        // [start] GetHuanpiInfoCollectionByHuanpiid
        // [start] GetHuanpiInfoCollectionByHuanpiid
        /**
        * 根据HuanpiID获取表 的对象集合HuanpiInfoCollection
        * @param Huanpiid 环境批复ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return HuanpiInfoCollection对象集合
        */
        public HuanpiInfoCollection GetHuanpiInfoCollectionByHuanpiid(int Huanpiid)
        {
              return GetHuanpiInfoCollectionByHuanpiid(Huanpiid,  true);
        }
        // [end]

        // [start] GetHuanpiInfoCollectionByHuanpiid
        private int GetHuanpiInfoCollectionByHuanpiid_Huanpiid = 0;//环境批复ID
        private HuanpiInfoCollection GetHuanpiInfoCollectionByHuanpiid_HuanpiInfoCollection;
        /**
        * 根据HuanpiID获取表 的对象集合HuanpiInfoCollection
        * @param Huanpiid 环境批复ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return HuanpiInfoCollection对象集合
        */
        public HuanpiInfoCollection GetHuanpiInfoCollectionByHuanpiid(int Huanpiid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetHuanpiInfoCollectionByHuanpiid_HuanpiInfoCollection = null;
                if (GetHuanpiInfoCollectionByHuanpiid_HuanpiInfoCollection == null || GetHuanpiInfoCollectionByHuanpiid_Huanpiid != Huanpiid)
            {
            HuanpiInfoCollection list = new HuanpiInfoCollection();
            for (HuanpiInfo objHuanpiInfo : this)
            {
                if (objHuanpiInfo.getHuanpiid() == Huanpiid)
                {
                    list.add(objHuanpiInfo);
                }
            }
            GetHuanpiInfoCollectionByHuanpiid_HuanpiInfoCollection = list;
            GetHuanpiInfoCollectionByHuanpiid_Huanpiid = Huanpiid;//环境批复ID
            return list;
            }
            else
            {
                return GetHuanpiInfoCollectionByHuanpiid_HuanpiInfoCollection;
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
	public HuanpiInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new HuanpiInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		HuanpiInfoCollection list = new HuanpiInfoCollection();
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
    public HuanpiInfoCollection Copy()
    {
        HuanpiInfoCollection list = new HuanpiInfoCollection();
        for (HuanpiInfo objHuanpiInfo : this)
        {
            list.add(objHuanpiInfo.Copy());
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
		sbStr.append("<ArrayOfHuanpiInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (HuanpiInfo objHuanpiInfo : this)
		{
			sbStr.append("  <HuanpiInfo>\n");
            //数据库ID
			sbStr.append("    <Huanpidatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objHuanpiInfo.getHuanpidatabaseid()));
			sbStr.append("</Huanpidatabaseid>\n");
            //环境批复ID
			sbStr.append("    <Huanpiid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objHuanpiInfo.getHuanpiid()));
			sbStr.append("</Huanpiid>\n");
            //HuanpiName
			sbStr.append("    <Huanpiname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objHuanpiInfo.getHuanpiname()));
			sbStr.append("</Huanpiname>\n");
			sbStr.append("  </HuanpiInfo>\n");
		}
		sbStr.append("</ArrayOfHuanpiInfo>\n");
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
	// GetHuanpiInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetHuanpiInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static HuanpiInfoCollection GetHuanpiInfoCollectionFormFileName(String filename)
	{
		return GetHuanpiInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetHuanpiInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static HuanpiInfoCollection GetHuanpiInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetHuanpiInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetHuanpiInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetHuanpiInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static HuanpiInfoCollection GetHuanpiInfoCollectionFormXml(String xml)
	{
		return GetHuanpiInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetHuanpiInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static HuanpiInfoCollection GetHuanpiInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		HuanpiInfoCollection objHuanpiInfoCollection = new HuanpiInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("HuanpiInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				HuanpiInfo objHuanpiInfo = new HuanpiInfo();
				//数据库ID
				if (foo.elementText("Huanpidatabaseid") != null)
					objHuanpiInfo.setHuanpidatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Huanpidatabaseid")));
				//环境批复ID
				if (foo.elementText("Huanpiid") != null)
					objHuanpiInfo.setHuanpiid(com.colorwinglib.Converts.StrToInt(foo.elementText("Huanpiid")));
				//HuanpiName
				if (foo.elementText("Huanpiname") != null)
					objHuanpiInfo.setHuanpiname(com.colorwinglib.Converts.objToStr(foo.elementText("Huanpiname")));
				objHuanpiInfoCollection.add(objHuanpiInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objHuanpiInfoCollection;
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
		//数据库ID
		if ("Huanpidatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(HuanpiColumnNameEnum.Huanpidatabaseid, isAsc);
		}

		//环境批复ID
		if ("Huanpiid".equals(columnName) && isAsc == true)
		{
          return sort(HuanpiColumnNameEnum.Huanpiid, isAsc);
		}

		//HuanpiName
		if ("Huanpiname".equals(columnName) && isAsc == true)
		{
          return sort(HuanpiColumnNameEnum.Huanpiname, isAsc);
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
	public boolean sort(HuanpiColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//数据库ID
		if (HuanpiColumnNameEnum.Huanpidatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new HuanpiHuanpidatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (HuanpiColumnNameEnum.Huanpidatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new HuanpiHuanpidatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//环境批复ID
		if (HuanpiColumnNameEnum.Huanpiid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new HuanpiHuanpiidComparatorAsc());// 顺序
			return true;
		}
		if (HuanpiColumnNameEnum.Huanpiid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new HuanpiHuanpiidComparatorDesc());// 倒叙
			return true;
		}

		//HuanpiName
		if (HuanpiColumnNameEnum.Huanpiname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new HuanpiHuanpinameComparatorAsc());// 顺序
			return true;
		}
		if (HuanpiColumnNameEnum.Huanpiname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new HuanpiHuanpinameComparatorDesc());// 倒叙
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
		for (HuanpiInfo objHuanpiInfo : this)
		{
			objJSONArray.put(objHuanpiInfo.toJson());
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
				HuanpiInfo objHuanpiInfo = new HuanpiInfo();
				objHuanpiInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objHuanpiInfo);
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
	// [start] 按 Huanpidatabaseid 数据库ID 正序排序
/**
 * 按 Huanpidatabaseid 数据库ID 正序排序
 *
 */
class HuanpiHuanpidatabaseidComparatorAsc implements Comparator<HuanpiInfo>
{
	public int compare(HuanpiInfo arg0, HuanpiInfo arg1)
	{
		if (arg0.getHuanpidatabaseid() > arg1.getHuanpidatabaseid())
			return 1;
		else if (arg0.getHuanpidatabaseid() < arg1.getHuanpidatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Huanpidatabaseid 数据库ID 倒叙排序
/**
 * 按 Huanpidatabaseid 数据库ID 倒叙排序
 *
 */
class HuanpiHuanpidatabaseidComparatorDesc implements Comparator<HuanpiInfo>
{

	public int compare(HuanpiInfo arg0, HuanpiInfo arg1)
	{
		if (arg0.getHuanpidatabaseid() > arg1.getHuanpidatabaseid())
			return -1;
		else if (arg0.getHuanpidatabaseid() < arg1.getHuanpidatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Huanpiid 环境批复ID 正序排序
/**
 * 按 Huanpiid 环境批复ID 正序排序
 *
 */
class HuanpiHuanpiidComparatorAsc implements Comparator<HuanpiInfo>
{
	public int compare(HuanpiInfo arg0, HuanpiInfo arg1)
	{
		if (arg0.getHuanpiid() > arg1.getHuanpiid())
			return 1;
		else if (arg0.getHuanpiid() < arg1.getHuanpiid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Huanpiid 环境批复ID 倒叙排序
/**
 * 按 Huanpiid 环境批复ID 倒叙排序
 *
 */
class HuanpiHuanpiidComparatorDesc implements Comparator<HuanpiInfo>
{

	public int compare(HuanpiInfo arg0, HuanpiInfo arg1)
	{
		if (arg0.getHuanpiid() > arg1.getHuanpiid())
			return -1;
		else if (arg0.getHuanpiid() < arg1.getHuanpiid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Huanpiname HuanpiName正序排序
/**
 * 按 Huanpiname HuanpiName 正序排序
 *
 */
class HuanpiHuanpinameComparatorAsc implements Comparator<HuanpiInfo>
{
	public int compare(HuanpiInfo arg0, HuanpiInfo arg1)
	{
		return arg0.getHuanpiname().toLowerCase().compareTo(arg1.getHuanpiname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Huanpiname HuanpiName 倒叙排序
/**
 * 按 Huanpiname HuanpiName 倒叙排序
 *
 */
class HuanpiHuanpinameComparatorDesc implements Comparator<HuanpiInfo>
{

	public int compare(HuanpiInfo arg0, HuanpiInfo arg1)
	{
		return arg1.getHuanpiname().toLowerCase().compareTo(arg0.getHuanpiname().toLowerCase());
	}
}
	// [end]


	// [end]

