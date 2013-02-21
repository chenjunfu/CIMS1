package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.AgeInfoBase.*;

/**
 * Age 年龄段表的摘要说明
 */
public class AgeInfoCollectionBase extends ArrayList<AgeInfo> implements List<AgeInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311454539011L;

	// [start] 根据主键或自增字段返回AgeInfo

        // [start] GetAgeInfoByAgedatabaseid
        // [start] GetAgeInfoByAgedatabaseid
        /**
        * 根据AgedatabaseID获取表 年龄段表的对象AgeInfo
        * @param Agedatabaseid AgedatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return AgeInfo对象实体
        */
        public AgeInfo GetAgeInfoByAgedatabaseid(int Agedatabaseid)
        {
              return GetAgeInfoByAgedatabaseid(Agedatabaseid,  true);
        }
        // [end]

        // [start] GetAgeInfoByAgedatabaseid
        private int GetAgeInfoByAgedatabaseid_Agedatabaseid = 0;//AgedatabaseID
        private AgeInfo GetAgeInfoByAgedatabaseid_AgeInfo;
        /**
        * 根据AgedatabaseID获取表 年龄段表的对象AgeInfo
        * @param Agedatabaseid AgedatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return AgeInfo对象实体
        */
        public AgeInfo GetAgeInfoByAgedatabaseid(int Agedatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetAgeInfoByAgedatabaseid_AgeInfo = null;
                if (GetAgeInfoByAgedatabaseid_AgeInfo == null || GetAgeInfoByAgedatabaseid_Agedatabaseid != Agedatabaseid)
            {
            for (AgeInfo objAgeInfo : this)
            {
                if (objAgeInfo.getAgedatabaseid() == Agedatabaseid)
                {
                    GetAgeInfoByAgedatabaseid_AgeInfo = objAgeInfo;
                    GetAgeInfoByAgedatabaseid_Agedatabaseid = Agedatabaseid;//AgedatabaseID
                    return objAgeInfo;
                }
            }
            return null;
            }
            else
            {
                return GetAgeInfoByAgedatabaseid_AgeInfo;
            }
        }
        // [end]

        // [start] GetIndexByAgedatabaseid
        /**
        * 根据AgedatabaseID获取表 年龄段表的对象AgeInfo 的位置
        * @param Agedatabaseid AgedatabaseID 
        * @return AgeInfo对象实体 的位置
        */
        public int GetIndexByAgedatabaseid(int Agedatabaseid)
        {
             int index = 0;
            for (AgeInfo objAgeInfo : this)
            {
                if (objAgeInfo.getAgedatabaseid() == Agedatabaseid)
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

	// [start] 根据索引返回AgeInfoCollection

        // [start] GetAgeInfoCollectionByAgeid
        // [start] GetAgeInfoCollectionByAgeid
        /**
        * 根据AgeID获取表 年龄段表的对象集合AgeInfoCollection
        * @param Ageid 年龄段编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return AgeInfoCollection对象集合
        */
        public AgeInfoCollection GetAgeInfoCollectionByAgeid(int Ageid)
        {
              return GetAgeInfoCollectionByAgeid(Ageid,  true);
        }
        // [end]

        // [start] GetAgeInfoCollectionByAgeid
        private int GetAgeInfoCollectionByAgeid_Ageid = 0;//年龄段编号
        private AgeInfoCollection GetAgeInfoCollectionByAgeid_AgeInfoCollection;
        /**
        * 根据AgeID获取表 年龄段表的对象集合AgeInfoCollection
        * @param Ageid 年龄段编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return AgeInfoCollection对象集合
        */
        public AgeInfoCollection GetAgeInfoCollectionByAgeid(int Ageid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetAgeInfoCollectionByAgeid_AgeInfoCollection = null;
                if (GetAgeInfoCollectionByAgeid_AgeInfoCollection == null || GetAgeInfoCollectionByAgeid_Ageid != Ageid)
            {
            AgeInfoCollection list = new AgeInfoCollection();
            for (AgeInfo objAgeInfo : this)
            {
                if (objAgeInfo.getAgeid() == Ageid)
                {
                    list.add(objAgeInfo);
                }
            }
            GetAgeInfoCollectionByAgeid_AgeInfoCollection = list;
            GetAgeInfoCollectionByAgeid_Ageid = Ageid;//年龄段编号
            return list;
            }
            else
            {
                return GetAgeInfoCollectionByAgeid_AgeInfoCollection;
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
	public AgeInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new AgeInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		AgeInfoCollection list = new AgeInfoCollection();
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
    public AgeInfoCollection Copy()
    {
        AgeInfoCollection list = new AgeInfoCollection();
        for (AgeInfo objAgeInfo : this)
        {
            list.add(objAgeInfo.Copy());
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
		sbStr.append("<ArrayOfAgeInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (AgeInfo objAgeInfo : this)
		{
			sbStr.append("  <AgeInfo>\n");
            //AgedatabaseID
			sbStr.append("    <Agedatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objAgeInfo.getAgedatabaseid()));
			sbStr.append("</Agedatabaseid>\n");
            //年龄段编号
			sbStr.append("    <Ageid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objAgeInfo.getAgeid()));
			sbStr.append("</Ageid>\n");
            //年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
			sbStr.append("    <Agename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objAgeInfo.getAgename()));
			sbStr.append("</Agename>\n");
			sbStr.append("  </AgeInfo>\n");
		}
		sbStr.append("</ArrayOfAgeInfo>\n");
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
	// GetAgeInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetAgeInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static AgeInfoCollection GetAgeInfoCollectionFormFileName(String filename)
	{
		return GetAgeInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetAgeInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AgeInfoCollection GetAgeInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetAgeInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetAgeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetAgeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AgeInfoCollection GetAgeInfoCollectionFormXml(String xml)
	{
		return GetAgeInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetAgeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static AgeInfoCollection GetAgeInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		AgeInfoCollection objAgeInfoCollection = new AgeInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("AgeInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				AgeInfo objAgeInfo = new AgeInfo();
				//AgedatabaseID
				if (foo.elementText("Agedatabaseid") != null)
					objAgeInfo.setAgedatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Agedatabaseid")));
				//年龄段编号
				if (foo.elementText("Ageid") != null)
					objAgeInfo.setAgeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Ageid")));
				//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
				if (foo.elementText("Agename") != null)
					objAgeInfo.setAgename(com.colorwinglib.Converts.objToStr(foo.elementText("Agename")));
				objAgeInfoCollection.add(objAgeInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objAgeInfoCollection;
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
		//AgedatabaseID
		if ("Agedatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(AgeColumnNameEnum.Agedatabaseid, isAsc);
		}

		//年龄段编号
		if ("Ageid".equals(columnName) && isAsc == true)
		{
          return sort(AgeColumnNameEnum.Ageid, isAsc);
		}

		//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
		if ("Agename".equals(columnName) && isAsc == true)
		{
          return sort(AgeColumnNameEnum.Agename, isAsc);
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
	public boolean sort(AgeColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//AgedatabaseID
		if (AgeColumnNameEnum.Agedatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new AgeAgedatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (AgeColumnNameEnum.Agedatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new AgeAgedatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//年龄段编号
		if (AgeColumnNameEnum.Ageid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new AgeAgeidComparatorAsc());// 顺序
			return true;
		}
		if (AgeColumnNameEnum.Ageid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new AgeAgeidComparatorDesc());// 倒叙
			return true;
		}

		//年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60
		if (AgeColumnNameEnum.Agename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new AgeAgenameComparatorAsc());// 顺序
			return true;
		}
		if (AgeColumnNameEnum.Agename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new AgeAgenameComparatorDesc());// 倒叙
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
		for (AgeInfo objAgeInfo : this)
		{
			objJSONArray.put(objAgeInfo.toJson());
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
				AgeInfo objAgeInfo = new AgeInfo();
				objAgeInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objAgeInfo);
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
	// [start] 按 Agedatabaseid AgedatabaseID 正序排序
/**
 * 按 Agedatabaseid AgedatabaseID 正序排序
 *
 */
class AgeAgedatabaseidComparatorAsc implements Comparator<AgeInfo>
{
	public int compare(AgeInfo arg0, AgeInfo arg1)
	{
		if (arg0.getAgedatabaseid() > arg1.getAgedatabaseid())
			return 1;
		else if (arg0.getAgedatabaseid() < arg1.getAgedatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Agedatabaseid AgedatabaseID 倒叙排序
/**
 * 按 Agedatabaseid AgedatabaseID 倒叙排序
 *
 */
class AgeAgedatabaseidComparatorDesc implements Comparator<AgeInfo>
{

	public int compare(AgeInfo arg0, AgeInfo arg1)
	{
		if (arg0.getAgedatabaseid() > arg1.getAgedatabaseid())
			return -1;
		else if (arg0.getAgedatabaseid() < arg1.getAgedatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Ageid 年龄段编号 正序排序
/**
 * 按 Ageid 年龄段编号 正序排序
 *
 */
class AgeAgeidComparatorAsc implements Comparator<AgeInfo>
{
	public int compare(AgeInfo arg0, AgeInfo arg1)
	{
		if (arg0.getAgeid() > arg1.getAgeid())
			return 1;
		else if (arg0.getAgeid() < arg1.getAgeid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Ageid 年龄段编号 倒叙排序
/**
 * 按 Ageid 年龄段编号 倒叙排序
 *
 */
class AgeAgeidComparatorDesc implements Comparator<AgeInfo>
{

	public int compare(AgeInfo arg0, AgeInfo arg1)
	{
		if (arg0.getAgeid() > arg1.getAgeid())
			return -1;
		else if (arg0.getAgeid() < arg1.getAgeid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Agename 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60正序排序
/**
 * 按 Agename 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60 正序排序
 *
 */
class AgeAgenameComparatorAsc implements Comparator<AgeInfo>
{
	public int compare(AgeInfo arg0, AgeInfo arg1)
	{
		return arg0.getAgename().toLowerCase().compareTo(arg1.getAgename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Agename 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60 倒叙排序
/**
 * 按 Agename 年龄段：A-1-20、B-21-30、C-31-40、D-41-50、E-51-60 倒叙排序
 *
 */
class AgeAgenameComparatorDesc implements Comparator<AgeInfo>
{

	public int compare(AgeInfo arg0, AgeInfo arg1)
	{
		return arg1.getAgename().toLowerCase().compareTo(arg0.getAgename().toLowerCase());
	}
}
	// [end]


	// [end]

