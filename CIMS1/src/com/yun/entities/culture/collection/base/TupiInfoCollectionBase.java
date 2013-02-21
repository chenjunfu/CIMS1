package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.TupiInfoBase.*;

/**
 * Tupi 的摘要说明
 */
public class TupiInfoCollectionBase extends ArrayList<TupiInfo> implements List<TupiInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311581323421L;

	// [start] 根据主键或自增字段返回TupiInfo

        // [start] GetTupiInfoByTupidatabaseid
        // [start] GetTupiInfoByTupidatabaseid
        /**
        * 根据TupidatabaseID获取表 的对象TupiInfo
        * @param Tupidatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return TupiInfo对象实体
        */
        public TupiInfo GetTupiInfoByTupidatabaseid(int Tupidatabaseid)
        {
              return GetTupiInfoByTupidatabaseid(Tupidatabaseid,  true);
        }
        // [end]

        // [start] GetTupiInfoByTupidatabaseid
        private int GetTupiInfoByTupidatabaseid_Tupidatabaseid = 0;//数据库ID
        private TupiInfo GetTupiInfoByTupidatabaseid_TupiInfo;
        /**
        * 根据TupidatabaseID获取表 的对象TupiInfo
        * @param Tupidatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return TupiInfo对象实体
        */
        public TupiInfo GetTupiInfoByTupidatabaseid(int Tupidatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetTupiInfoByTupidatabaseid_TupiInfo = null;
                if (GetTupiInfoByTupidatabaseid_TupiInfo == null || GetTupiInfoByTupidatabaseid_Tupidatabaseid != Tupidatabaseid)
            {
            for (TupiInfo objTupiInfo : this)
            {
                if (objTupiInfo.getTupidatabaseid() == Tupidatabaseid)
                {
                    GetTupiInfoByTupidatabaseid_TupiInfo = objTupiInfo;
                    GetTupiInfoByTupidatabaseid_Tupidatabaseid = Tupidatabaseid;//数据库ID
                    return objTupiInfo;
                }
            }
            return null;
            }
            else
            {
                return GetTupiInfoByTupidatabaseid_TupiInfo;
            }
        }
        // [end]

        // [start] GetIndexByTupidatabaseid
        /**
        * 根据TupidatabaseID获取表 的对象TupiInfo 的位置
        * @param Tupidatabaseid 数据库ID 
        * @return TupiInfo对象实体 的位置
        */
        public int GetIndexByTupidatabaseid(int Tupidatabaseid)
        {
             int index = 0;
            for (TupiInfo objTupiInfo : this)
            {
                if (objTupiInfo.getTupidatabaseid() == Tupidatabaseid)
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

	// [start] 根据索引返回TupiInfoCollection

        // [start] GetTupiInfoCollectionByTupiid
        // [start] GetTupiInfoCollectionByTupiid
        /**
        * 根据TupiID获取表 的对象集合TupiInfoCollection
        * @param Tupiid 土地批准ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return TupiInfoCollection对象集合
        */
        public TupiInfoCollection GetTupiInfoCollectionByTupiid(int Tupiid)
        {
              return GetTupiInfoCollectionByTupiid(Tupiid,  true);
        }
        // [end]

        // [start] GetTupiInfoCollectionByTupiid
        private int GetTupiInfoCollectionByTupiid_Tupiid = 0;//土地批准ID
        private TupiInfoCollection GetTupiInfoCollectionByTupiid_TupiInfoCollection;
        /**
        * 根据TupiID获取表 的对象集合TupiInfoCollection
        * @param Tupiid 土地批准ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return TupiInfoCollection对象集合
        */
        public TupiInfoCollection GetTupiInfoCollectionByTupiid(int Tupiid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetTupiInfoCollectionByTupiid_TupiInfoCollection = null;
                if (GetTupiInfoCollectionByTupiid_TupiInfoCollection == null || GetTupiInfoCollectionByTupiid_Tupiid != Tupiid)
            {
            TupiInfoCollection list = new TupiInfoCollection();
            for (TupiInfo objTupiInfo : this)
            {
                if (objTupiInfo.getTupiid() == Tupiid)
                {
                    list.add(objTupiInfo);
                }
            }
            GetTupiInfoCollectionByTupiid_TupiInfoCollection = list;
            GetTupiInfoCollectionByTupiid_Tupiid = Tupiid;//土地批准ID
            return list;
            }
            else
            {
                return GetTupiInfoCollectionByTupiid_TupiInfoCollection;
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
	public TupiInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new TupiInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		TupiInfoCollection list = new TupiInfoCollection();
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
    public TupiInfoCollection Copy()
    {
        TupiInfoCollection list = new TupiInfoCollection();
        for (TupiInfo objTupiInfo : this)
        {
            list.add(objTupiInfo.Copy());
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
		sbStr.append("<ArrayOfTupiInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (TupiInfo objTupiInfo : this)
		{
			sbStr.append("  <TupiInfo>\n");
            //数据库ID
			sbStr.append("    <Tupidatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTupiInfo.getTupidatabaseid()));
			sbStr.append("</Tupidatabaseid>\n");
            //土地批准ID
			sbStr.append("    <Tupiid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTupiInfo.getTupiid()));
			sbStr.append("</Tupiid>\n");
            //TupiName
			sbStr.append("    <Tupiname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTupiInfo.getTupiname()));
			sbStr.append("</Tupiname>\n");
			sbStr.append("  </TupiInfo>\n");
		}
		sbStr.append("</ArrayOfTupiInfo>\n");
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
	// GetTupiInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetTupiInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static TupiInfoCollection GetTupiInfoCollectionFormFileName(String filename)
	{
		return GetTupiInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTupiInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TupiInfoCollection GetTupiInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetTupiInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetTupiInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetTupiInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TupiInfoCollection GetTupiInfoCollectionFormXml(String xml)
	{
		return GetTupiInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTupiInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TupiInfoCollection GetTupiInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		TupiInfoCollection objTupiInfoCollection = new TupiInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("TupiInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				TupiInfo objTupiInfo = new TupiInfo();
				//数据库ID
				if (foo.elementText("Tupidatabaseid") != null)
					objTupiInfo.setTupidatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Tupidatabaseid")));
				//土地批准ID
				if (foo.elementText("Tupiid") != null)
					objTupiInfo.setTupiid(com.colorwinglib.Converts.StrToInt(foo.elementText("Tupiid")));
				//TupiName
				if (foo.elementText("Tupiname") != null)
					objTupiInfo.setTupiname(com.colorwinglib.Converts.objToStr(foo.elementText("Tupiname")));
				objTupiInfoCollection.add(objTupiInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objTupiInfoCollection;
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
		if ("Tupidatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(TupiColumnNameEnum.Tupidatabaseid, isAsc);
		}

		//土地批准ID
		if ("Tupiid".equals(columnName) && isAsc == true)
		{
          return sort(TupiColumnNameEnum.Tupiid, isAsc);
		}

		//TupiName
		if ("Tupiname".equals(columnName) && isAsc == true)
		{
          return sort(TupiColumnNameEnum.Tupiname, isAsc);
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
	public boolean sort(TupiColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//数据库ID
		if (TupiColumnNameEnum.Tupidatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TupiTupidatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (TupiColumnNameEnum.Tupidatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TupiTupidatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//土地批准ID
		if (TupiColumnNameEnum.Tupiid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TupiTupiidComparatorAsc());// 顺序
			return true;
		}
		if (TupiColumnNameEnum.Tupiid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TupiTupiidComparatorDesc());// 倒叙
			return true;
		}

		//TupiName
		if (TupiColumnNameEnum.Tupiname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TupiTupinameComparatorAsc());// 顺序
			return true;
		}
		if (TupiColumnNameEnum.Tupiname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TupiTupinameComparatorDesc());// 倒叙
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
		for (TupiInfo objTupiInfo : this)
		{
			objJSONArray.put(objTupiInfo.toJson());
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
				TupiInfo objTupiInfo = new TupiInfo();
				objTupiInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objTupiInfo);
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
	// [start] 按 Tupidatabaseid 数据库ID 正序排序
/**
 * 按 Tupidatabaseid 数据库ID 正序排序
 *
 */
class TupiTupidatabaseidComparatorAsc implements Comparator<TupiInfo>
{
	public int compare(TupiInfo arg0, TupiInfo arg1)
	{
		if (arg0.getTupidatabaseid() > arg1.getTupidatabaseid())
			return 1;
		else if (arg0.getTupidatabaseid() < arg1.getTupidatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Tupidatabaseid 数据库ID 倒叙排序
/**
 * 按 Tupidatabaseid 数据库ID 倒叙排序
 *
 */
class TupiTupidatabaseidComparatorDesc implements Comparator<TupiInfo>
{

	public int compare(TupiInfo arg0, TupiInfo arg1)
	{
		if (arg0.getTupidatabaseid() > arg1.getTupidatabaseid())
			return -1;
		else if (arg0.getTupidatabaseid() < arg1.getTupidatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Tupiid 土地批准ID 正序排序
/**
 * 按 Tupiid 土地批准ID 正序排序
 *
 */
class TupiTupiidComparatorAsc implements Comparator<TupiInfo>
{
	public int compare(TupiInfo arg0, TupiInfo arg1)
	{
		if (arg0.getTupiid() > arg1.getTupiid())
			return 1;
		else if (arg0.getTupiid() < arg1.getTupiid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Tupiid 土地批准ID 倒叙排序
/**
 * 按 Tupiid 土地批准ID 倒叙排序
 *
 */
class TupiTupiidComparatorDesc implements Comparator<TupiInfo>
{

	public int compare(TupiInfo arg0, TupiInfo arg1)
	{
		if (arg0.getTupiid() > arg1.getTupiid())
			return -1;
		else if (arg0.getTupiid() < arg1.getTupiid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Tupiname TupiName正序排序
/**
 * 按 Tupiname TupiName 正序排序
 *
 */
class TupiTupinameComparatorAsc implements Comparator<TupiInfo>
{
	public int compare(TupiInfo arg0, TupiInfo arg1)
	{
		return arg0.getTupiname().toLowerCase().compareTo(arg1.getTupiname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Tupiname TupiName 倒叙排序
/**
 * 按 Tupiname TupiName 倒叙排序
 *
 */
class TupiTupinameComparatorDesc implements Comparator<TupiInfo>
{

	public int compare(TupiInfo arg0, TupiInfo arg1)
	{
		return arg1.getTupiname().toLowerCase().compareTo(arg0.getTupiname().toLowerCase());
	}
}
	// [end]


	// [end]

