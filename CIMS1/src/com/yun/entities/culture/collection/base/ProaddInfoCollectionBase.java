package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.ProaddInfoBase.*;

/**
 * Proadd 的摘要说明
 */
public class ProaddInfoCollectionBase extends ArrayList<ProaddInfo> implements List<ProaddInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311525682865L;

	// [start] 根据主键或自增字段返回ProaddInfo

        // [start] GetProaddInfoByProadddatabaseid
        // [start] GetProaddInfoByProadddatabaseid
        /**
        * 根据ProadddatabaseID获取表 的对象ProaddInfo
        * @param Proadddatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProaddInfo对象实体
        */
        public ProaddInfo GetProaddInfoByProadddatabaseid(int Proadddatabaseid)
        {
              return GetProaddInfoByProadddatabaseid(Proadddatabaseid,  true);
        }
        // [end]

        // [start] GetProaddInfoByProadddatabaseid
        private int GetProaddInfoByProadddatabaseid_Proadddatabaseid = 0;//数据库ID
        private ProaddInfo GetProaddInfoByProadddatabaseid_ProaddInfo;
        /**
        * 根据ProadddatabaseID获取表 的对象ProaddInfo
        * @param Proadddatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProaddInfo对象实体
        */
        public ProaddInfo GetProaddInfoByProadddatabaseid(int Proadddatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetProaddInfoByProadddatabaseid_ProaddInfo = null;
                if (GetProaddInfoByProadddatabaseid_ProaddInfo == null || GetProaddInfoByProadddatabaseid_Proadddatabaseid != Proadddatabaseid)
            {
            for (ProaddInfo objProaddInfo : this)
            {
                if (objProaddInfo.getProadddatabaseid() == Proadddatabaseid)
                {
                    GetProaddInfoByProadddatabaseid_ProaddInfo = objProaddInfo;
                    GetProaddInfoByProadddatabaseid_Proadddatabaseid = Proadddatabaseid;//数据库ID
                    return objProaddInfo;
                }
            }
            return null;
            }
            else
            {
                return GetProaddInfoByProadddatabaseid_ProaddInfo;
            }
        }
        // [end]

        // [start] GetIndexByProadddatabaseid
        /**
        * 根据ProadddatabaseID获取表 的对象ProaddInfo 的位置
        * @param Proadddatabaseid 数据库ID 
        * @return ProaddInfo对象实体 的位置
        */
        public int GetIndexByProadddatabaseid(int Proadddatabaseid)
        {
             int index = 0;
            for (ProaddInfo objProaddInfo : this)
            {
                if (objProaddInfo.getProadddatabaseid() == Proadddatabaseid)
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

	// [start] 根据索引返回ProaddInfoCollection

        // [start] GetProaddInfoCollectionByProaddid
        // [start] GetProaddInfoCollectionByProaddid
        /**
        * 根据ProaddID获取表 的对象集合ProaddInfoCollection
        * @param Proaddid 地址ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProaddInfoCollection对象集合
        */
        public ProaddInfoCollection GetProaddInfoCollectionByProaddid(int Proaddid)
        {
              return GetProaddInfoCollectionByProaddid(Proaddid,  true);
        }
        // [end]

        // [start] GetProaddInfoCollectionByProaddid
        private int GetProaddInfoCollectionByProaddid_Proaddid = 0;//地址ID
        private ProaddInfoCollection GetProaddInfoCollectionByProaddid_ProaddInfoCollection;
        /**
        * 根据ProaddID获取表 的对象集合ProaddInfoCollection
        * @param Proaddid 地址ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProaddInfoCollection对象集合
        */
        public ProaddInfoCollection GetProaddInfoCollectionByProaddid(int Proaddid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetProaddInfoCollectionByProaddid_ProaddInfoCollection = null;
                if (GetProaddInfoCollectionByProaddid_ProaddInfoCollection == null || GetProaddInfoCollectionByProaddid_Proaddid != Proaddid)
            {
            ProaddInfoCollection list = new ProaddInfoCollection();
            for (ProaddInfo objProaddInfo : this)
            {
                if (objProaddInfo.getProaddid() == Proaddid)
                {
                    list.add(objProaddInfo);
                }
            }
            GetProaddInfoCollectionByProaddid_ProaddInfoCollection = list;
            GetProaddInfoCollectionByProaddid_Proaddid = Proaddid;//地址ID
            return list;
            }
            else
            {
                return GetProaddInfoCollectionByProaddid_ProaddInfoCollection;
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
	public ProaddInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new ProaddInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		ProaddInfoCollection list = new ProaddInfoCollection();
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
    public ProaddInfoCollection Copy()
    {
        ProaddInfoCollection list = new ProaddInfoCollection();
        for (ProaddInfo objProaddInfo : this)
        {
            list.add(objProaddInfo.Copy());
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
		sbStr.append("<ArrayOfProaddInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (ProaddInfo objProaddInfo : this)
		{
			sbStr.append("  <ProaddInfo>\n");
            //数据库ID
			sbStr.append("    <Proadddatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProaddInfo.getProadddatabaseid()));
			sbStr.append("</Proadddatabaseid>\n");
            //地址ID
			sbStr.append("    <Proaddid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProaddInfo.getProaddid()));
			sbStr.append("</Proaddid>\n");
            //地址名称
			sbStr.append("    <Proaddname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProaddInfo.getProaddname()));
			sbStr.append("</Proaddname>\n");
			sbStr.append("  </ProaddInfo>\n");
		}
		sbStr.append("</ArrayOfProaddInfo>\n");
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
	// GetProaddInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetProaddInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ProaddInfoCollection GetProaddInfoCollectionFormFileName(String filename)
	{
		return GetProaddInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProaddInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProaddInfoCollection GetProaddInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetProaddInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetProaddInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetProaddInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProaddInfoCollection GetProaddInfoCollectionFormXml(String xml)
	{
		return GetProaddInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProaddInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProaddInfoCollection GetProaddInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ProaddInfoCollection objProaddInfoCollection = new ProaddInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("ProaddInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				ProaddInfo objProaddInfo = new ProaddInfo();
				//数据库ID
				if (foo.elementText("Proadddatabaseid") != null)
					objProaddInfo.setProadddatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Proadddatabaseid")));
				//地址ID
				if (foo.elementText("Proaddid") != null)
					objProaddInfo.setProaddid(com.colorwinglib.Converts.StrToInt(foo.elementText("Proaddid")));
				//地址名称
				if (foo.elementText("Proaddname") != null)
					objProaddInfo.setProaddname(com.colorwinglib.Converts.objToStr(foo.elementText("Proaddname")));
				objProaddInfoCollection.add(objProaddInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objProaddInfoCollection;
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
		if ("Proadddatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(ProaddColumnNameEnum.Proadddatabaseid, isAsc);
		}

		//地址ID
		if ("Proaddid".equals(columnName) && isAsc == true)
		{
          return sort(ProaddColumnNameEnum.Proaddid, isAsc);
		}

		//地址名称
		if ("Proaddname".equals(columnName) && isAsc == true)
		{
          return sort(ProaddColumnNameEnum.Proaddname, isAsc);
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
	public boolean sort(ProaddColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//数据库ID
		if (ProaddColumnNameEnum.Proadddatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProaddProadddatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (ProaddColumnNameEnum.Proadddatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProaddProadddatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//地址ID
		if (ProaddColumnNameEnum.Proaddid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProaddProaddidComparatorAsc());// 顺序
			return true;
		}
		if (ProaddColumnNameEnum.Proaddid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProaddProaddidComparatorDesc());// 倒叙
			return true;
		}

		//地址名称
		if (ProaddColumnNameEnum.Proaddname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProaddProaddnameComparatorAsc());// 顺序
			return true;
		}
		if (ProaddColumnNameEnum.Proaddname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProaddProaddnameComparatorDesc());// 倒叙
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
		for (ProaddInfo objProaddInfo : this)
		{
			objJSONArray.put(objProaddInfo.toJson());
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
				ProaddInfo objProaddInfo = new ProaddInfo();
				objProaddInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objProaddInfo);
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
	// [start] 按 Proadddatabaseid 数据库ID 正序排序
/**
 * 按 Proadddatabaseid 数据库ID 正序排序
 *
 */
class ProaddProadddatabaseidComparatorAsc implements Comparator<ProaddInfo>
{
	public int compare(ProaddInfo arg0, ProaddInfo arg1)
	{
		if (arg0.getProadddatabaseid() > arg1.getProadddatabaseid())
			return 1;
		else if (arg0.getProadddatabaseid() < arg1.getProadddatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Proadddatabaseid 数据库ID 倒叙排序
/**
 * 按 Proadddatabaseid 数据库ID 倒叙排序
 *
 */
class ProaddProadddatabaseidComparatorDesc implements Comparator<ProaddInfo>
{

	public int compare(ProaddInfo arg0, ProaddInfo arg1)
	{
		if (arg0.getProadddatabaseid() > arg1.getProadddatabaseid())
			return -1;
		else if (arg0.getProadddatabaseid() < arg1.getProadddatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Proaddid 地址ID 正序排序
/**
 * 按 Proaddid 地址ID 正序排序
 *
 */
class ProaddProaddidComparatorAsc implements Comparator<ProaddInfo>
{
	public int compare(ProaddInfo arg0, ProaddInfo arg1)
	{
		if (arg0.getProaddid() > arg1.getProaddid())
			return 1;
		else if (arg0.getProaddid() < arg1.getProaddid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Proaddid 地址ID 倒叙排序
/**
 * 按 Proaddid 地址ID 倒叙排序
 *
 */
class ProaddProaddidComparatorDesc implements Comparator<ProaddInfo>
{

	public int compare(ProaddInfo arg0, ProaddInfo arg1)
	{
		if (arg0.getProaddid() > arg1.getProaddid())
			return -1;
		else if (arg0.getProaddid() < arg1.getProaddid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Proaddname 地址名称正序排序
/**
 * 按 Proaddname 地址名称 正序排序
 *
 */
class ProaddProaddnameComparatorAsc implements Comparator<ProaddInfo>
{
	public int compare(ProaddInfo arg0, ProaddInfo arg1)
	{
		return arg0.getProaddname().toLowerCase().compareTo(arg1.getProaddname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Proaddname 地址名称 倒叙排序
/**
 * 按 Proaddname 地址名称 倒叙排序
 *
 */
class ProaddProaddnameComparatorDesc implements Comparator<ProaddInfo>
{

	public int compare(ProaddInfo arg0, ProaddInfo arg1)
	{
		return arg1.getProaddname().toLowerCase().compareTo(arg0.getProaddname().toLowerCase());
	}
}
	// [end]


	// [end]

