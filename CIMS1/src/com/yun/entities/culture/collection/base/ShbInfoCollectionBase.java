package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.ShbInfoBase.*;

/**
 * Shb 的摘要说明
 */
public class ShbInfoCollectionBase extends ArrayList<ShbInfo> implements List<ShbInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311551400077L;

	// [start] 根据主键或自增字段返回ShbInfo

        // [start] GetShbInfoByShbdatabaseid
        // [start] GetShbInfoByShbdatabaseid
        /**
        * 根据shbdatabaseID获取表 的对象ShbInfo
        * @param Shbdatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ShbInfo对象实体
        */
        public ShbInfo GetShbInfoByShbdatabaseid(int Shbdatabaseid)
        {
              return GetShbInfoByShbdatabaseid(Shbdatabaseid,  true);
        }
        // [end]

        // [start] GetShbInfoByShbdatabaseid
        private int GetShbInfoByShbdatabaseid_Shbdatabaseid = 0;//数据库ID
        private ShbInfo GetShbInfoByShbdatabaseid_ShbInfo;
        /**
        * 根据shbdatabaseID获取表 的对象ShbInfo
        * @param Shbdatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ShbInfo对象实体
        */
        public ShbInfo GetShbInfoByShbdatabaseid(int Shbdatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetShbInfoByShbdatabaseid_ShbInfo = null;
                if (GetShbInfoByShbdatabaseid_ShbInfo == null || GetShbInfoByShbdatabaseid_Shbdatabaseid != Shbdatabaseid)
            {
            for (ShbInfo objShbInfo : this)
            {
                if (objShbInfo.getShbdatabaseid() == Shbdatabaseid)
                {
                    GetShbInfoByShbdatabaseid_ShbInfo = objShbInfo;
                    GetShbInfoByShbdatabaseid_Shbdatabaseid = Shbdatabaseid;//数据库ID
                    return objShbInfo;
                }
            }
            return null;
            }
            else
            {
                return GetShbInfoByShbdatabaseid_ShbInfo;
            }
        }
        // [end]

        // [start] GetIndexByShbdatabaseid
        /**
        * 根据shbdatabaseID获取表 的对象ShbInfo 的位置
        * @param Shbdatabaseid 数据库ID 
        * @return ShbInfo对象实体 的位置
        */
        public int GetIndexByShbdatabaseid(int Shbdatabaseid)
        {
             int index = 0;
            for (ShbInfo objShbInfo : this)
            {
                if (objShbInfo.getShbdatabaseid() == Shbdatabaseid)
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

	// [start] 根据索引返回ShbInfoCollection

        // [start] GetShbInfoCollectionByShbid
        // [start] GetShbInfoCollectionByShbid
        /**
        * 根据shbID获取表 的对象集合ShbInfoCollection
        * @param Shbid 审核备ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ShbInfoCollection对象集合
        */
        public ShbInfoCollection GetShbInfoCollectionByShbid(int Shbid)
        {
              return GetShbInfoCollectionByShbid(Shbid,  true);
        }
        // [end]

        // [start] GetShbInfoCollectionByShbid
        private int GetShbInfoCollectionByShbid_Shbid = 0;//审核备ID
        private ShbInfoCollection GetShbInfoCollectionByShbid_ShbInfoCollection;
        /**
        * 根据shbID获取表 的对象集合ShbInfoCollection
        * @param Shbid 审核备ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ShbInfoCollection对象集合
        */
        public ShbInfoCollection GetShbInfoCollectionByShbid(int Shbid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetShbInfoCollectionByShbid_ShbInfoCollection = null;
                if (GetShbInfoCollectionByShbid_ShbInfoCollection == null || GetShbInfoCollectionByShbid_Shbid != Shbid)
            {
            ShbInfoCollection list = new ShbInfoCollection();
            for (ShbInfo objShbInfo : this)
            {
                if (objShbInfo.getShbid() == Shbid)
                {
                    list.add(objShbInfo);
                }
            }
            GetShbInfoCollectionByShbid_ShbInfoCollection = list;
            GetShbInfoCollectionByShbid_Shbid = Shbid;//审核备ID
            return list;
            }
            else
            {
                return GetShbInfoCollectionByShbid_ShbInfoCollection;
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
	public ShbInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new ShbInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		ShbInfoCollection list = new ShbInfoCollection();
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
    public ShbInfoCollection Copy()
    {
        ShbInfoCollection list = new ShbInfoCollection();
        for (ShbInfo objShbInfo : this)
        {
            list.add(objShbInfo.Copy());
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
		sbStr.append("<ArrayOfShbInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (ShbInfo objShbInfo : this)
		{
			sbStr.append("  <ShbInfo>\n");
            //数据库ID
			sbStr.append("    <Shbdatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objShbInfo.getShbdatabaseid()));
			sbStr.append("</Shbdatabaseid>\n");
            //审核备ID
			sbStr.append("    <Shbid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objShbInfo.getShbid()));
			sbStr.append("</Shbid>\n");
            //shbName
			sbStr.append("    <Shbname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objShbInfo.getShbname()));
			sbStr.append("</Shbname>\n");
			sbStr.append("  </ShbInfo>\n");
		}
		sbStr.append("</ArrayOfShbInfo>\n");
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
	// GetShbInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetShbInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ShbInfoCollection GetShbInfoCollectionFormFileName(String filename)
	{
		return GetShbInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetShbInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ShbInfoCollection GetShbInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetShbInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetShbInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetShbInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ShbInfoCollection GetShbInfoCollectionFormXml(String xml)
	{
		return GetShbInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetShbInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ShbInfoCollection GetShbInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ShbInfoCollection objShbInfoCollection = new ShbInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("ShbInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				ShbInfo objShbInfo = new ShbInfo();
				//数据库ID
				if (foo.elementText("Shbdatabaseid") != null)
					objShbInfo.setShbdatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Shbdatabaseid")));
				//审核备ID
				if (foo.elementText("Shbid") != null)
					objShbInfo.setShbid(com.colorwinglib.Converts.StrToInt(foo.elementText("Shbid")));
				//shbName
				if (foo.elementText("Shbname") != null)
					objShbInfo.setShbname(com.colorwinglib.Converts.objToStr(foo.elementText("Shbname")));
				objShbInfoCollection.add(objShbInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objShbInfoCollection;
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
		if ("Shbdatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(ShbColumnNameEnum.Shbdatabaseid, isAsc);
		}

		//审核备ID
		if ("Shbid".equals(columnName) && isAsc == true)
		{
          return sort(ShbColumnNameEnum.Shbid, isAsc);
		}

		//shbName
		if ("Shbname".equals(columnName) && isAsc == true)
		{
          return sort(ShbColumnNameEnum.Shbname, isAsc);
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
	public boolean sort(ShbColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//数据库ID
		if (ShbColumnNameEnum.Shbdatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ShbShbdatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (ShbColumnNameEnum.Shbdatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ShbShbdatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//审核备ID
		if (ShbColumnNameEnum.Shbid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ShbShbidComparatorAsc());// 顺序
			return true;
		}
		if (ShbColumnNameEnum.Shbid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ShbShbidComparatorDesc());// 倒叙
			return true;
		}

		//shbName
		if (ShbColumnNameEnum.Shbname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ShbShbnameComparatorAsc());// 顺序
			return true;
		}
		if (ShbColumnNameEnum.Shbname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ShbShbnameComparatorDesc());// 倒叙
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
		for (ShbInfo objShbInfo : this)
		{
			objJSONArray.put(objShbInfo.toJson());
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
				ShbInfo objShbInfo = new ShbInfo();
				objShbInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objShbInfo);
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
	// [start] 按 Shbdatabaseid 数据库ID 正序排序
/**
 * 按 Shbdatabaseid 数据库ID 正序排序
 *
 */
class ShbShbdatabaseidComparatorAsc implements Comparator<ShbInfo>
{
	public int compare(ShbInfo arg0, ShbInfo arg1)
	{
		if (arg0.getShbdatabaseid() > arg1.getShbdatabaseid())
			return 1;
		else if (arg0.getShbdatabaseid() < arg1.getShbdatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Shbdatabaseid 数据库ID 倒叙排序
/**
 * 按 Shbdatabaseid 数据库ID 倒叙排序
 *
 */
class ShbShbdatabaseidComparatorDesc implements Comparator<ShbInfo>
{

	public int compare(ShbInfo arg0, ShbInfo arg1)
	{
		if (arg0.getShbdatabaseid() > arg1.getShbdatabaseid())
			return -1;
		else if (arg0.getShbdatabaseid() < arg1.getShbdatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Shbid 审核备ID 正序排序
/**
 * 按 Shbid 审核备ID 正序排序
 *
 */
class ShbShbidComparatorAsc implements Comparator<ShbInfo>
{
	public int compare(ShbInfo arg0, ShbInfo arg1)
	{
		if (arg0.getShbid() > arg1.getShbid())
			return 1;
		else if (arg0.getShbid() < arg1.getShbid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Shbid 审核备ID 倒叙排序
/**
 * 按 Shbid 审核备ID 倒叙排序
 *
 */
class ShbShbidComparatorDesc implements Comparator<ShbInfo>
{

	public int compare(ShbInfo arg0, ShbInfo arg1)
	{
		if (arg0.getShbid() > arg1.getShbid())
			return -1;
		else if (arg0.getShbid() < arg1.getShbid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Shbname shbName正序排序
/**
 * 按 Shbname shbName 正序排序
 *
 */
class ShbShbnameComparatorAsc implements Comparator<ShbInfo>
{
	public int compare(ShbInfo arg0, ShbInfo arg1)
	{
		return arg0.getShbname().toLowerCase().compareTo(arg1.getShbname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Shbname shbName 倒叙排序
/**
 * 按 Shbname shbName 倒叙排序
 *
 */
class ShbShbnameComparatorDesc implements Comparator<ShbInfo>
{

	public int compare(ShbInfo arg0, ShbInfo arg1)
	{
		return arg1.getShbname().toLowerCase().compareTo(arg0.getShbname().toLowerCase());
	}
}
	// [end]


	// [end]

