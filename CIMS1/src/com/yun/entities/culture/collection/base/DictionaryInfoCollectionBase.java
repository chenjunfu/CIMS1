package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.DictionaryInfoBase.*;

/**
 * Dictionary 的摘要说明
 */
public class DictionaryInfoCollectionBase extends ArrayList<DictionaryInfo> implements List<DictionaryInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311464493788L;

	// [start] 根据主键或自增字段返回DictionaryInfo

        // [start] GetDictionaryInfoByDictionaryid
        // [start] GetDictionaryInfoByDictionaryid
        /**
        * 根据DictionaryId获取表 的对象DictionaryInfo
        * @param Dictionaryid DictionaryId 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return DictionaryInfo对象实体
        */
        public DictionaryInfo GetDictionaryInfoByDictionaryid(int Dictionaryid)
        {
              return GetDictionaryInfoByDictionaryid(Dictionaryid,  true);
        }
        // [end]

        // [start] GetDictionaryInfoByDictionaryid
        private int GetDictionaryInfoByDictionaryid_Dictionaryid = 0;//DictionaryId
        private DictionaryInfo GetDictionaryInfoByDictionaryid_DictionaryInfo;
        /**
        * 根据DictionaryId获取表 的对象DictionaryInfo
        * @param Dictionaryid DictionaryId 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return DictionaryInfo对象实体
        */
        public DictionaryInfo GetDictionaryInfoByDictionaryid(int Dictionaryid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetDictionaryInfoByDictionaryid_DictionaryInfo = null;
                if (GetDictionaryInfoByDictionaryid_DictionaryInfo == null || GetDictionaryInfoByDictionaryid_Dictionaryid != Dictionaryid)
            {
            for (DictionaryInfo objDictionaryInfo : this)
            {
                if (objDictionaryInfo.getDictionaryid() == Dictionaryid)
                {
                    GetDictionaryInfoByDictionaryid_DictionaryInfo = objDictionaryInfo;
                    GetDictionaryInfoByDictionaryid_Dictionaryid = Dictionaryid;//DictionaryId
                    return objDictionaryInfo;
                }
            }
            return null;
            }
            else
            {
                return GetDictionaryInfoByDictionaryid_DictionaryInfo;
            }
        }
        // [end]

        // [start] GetIndexByDictionaryid
        /**
        * 根据DictionaryId获取表 的对象DictionaryInfo 的位置
        * @param Dictionaryid DictionaryId 
        * @return DictionaryInfo对象实体 的位置
        */
        public int GetIndexByDictionaryid(int Dictionaryid)
        {
             int index = 0;
            for (DictionaryInfo objDictionaryInfo : this)
            {
                if (objDictionaryInfo.getDictionaryid() == Dictionaryid)
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

	// [start] 根据索引返回DictionaryInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public DictionaryInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new DictionaryInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		DictionaryInfoCollection list = new DictionaryInfoCollection();
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
    public DictionaryInfoCollection Copy()
    {
        DictionaryInfoCollection list = new DictionaryInfoCollection();
        for (DictionaryInfo objDictionaryInfo : this)
        {
            list.add(objDictionaryInfo.Copy());
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
		sbStr.append("<ArrayOfDictionaryInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (DictionaryInfo objDictionaryInfo : this)
		{
			sbStr.append("  <DictionaryInfo>\n");
            //DictionaryId
			sbStr.append("    <Dictionaryid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objDictionaryInfo.getDictionaryid()));
			sbStr.append("</Dictionaryid>\n");
            //显示名称
			sbStr.append("    <Name>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objDictionaryInfo.getName()));
			sbStr.append("</Name>\n");
            //对应表名
			sbStr.append("    <Tablename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objDictionaryInfo.getTablename()));
			sbStr.append("</Tablename>\n");
            //是否启用
			sbStr.append("    <Isuse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objDictionaryInfo.getIsuse()));
			sbStr.append("</Isuse>\n");
			sbStr.append("  </DictionaryInfo>\n");
		}
		sbStr.append("</ArrayOfDictionaryInfo>\n");
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
	// GetDictionaryInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetDictionaryInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static DictionaryInfoCollection GetDictionaryInfoCollectionFormFileName(String filename)
	{
		return GetDictionaryInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetDictionaryInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DictionaryInfoCollection GetDictionaryInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetDictionaryInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetDictionaryInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetDictionaryInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DictionaryInfoCollection GetDictionaryInfoCollectionFormXml(String xml)
	{
		return GetDictionaryInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetDictionaryInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DictionaryInfoCollection GetDictionaryInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		DictionaryInfoCollection objDictionaryInfoCollection = new DictionaryInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("DictionaryInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				DictionaryInfo objDictionaryInfo = new DictionaryInfo();
				//DictionaryId
				if (foo.elementText("Dictionaryid") != null)
					objDictionaryInfo.setDictionaryid(com.colorwinglib.Converts.StrToInt(foo.elementText("Dictionaryid")));
				//显示名称
				if (foo.elementText("Name") != null)
					objDictionaryInfo.setName(com.colorwinglib.Converts.objToStr(foo.elementText("Name")));
				//对应表名
				if (foo.elementText("Tablename") != null)
					objDictionaryInfo.setTablename(com.colorwinglib.Converts.objToStr(foo.elementText("Tablename")));
				//是否启用
				if (foo.elementText("Isuse") != null)
					objDictionaryInfo.setIsuse(com.colorwinglib.Converts.StrToInt(foo.elementText("Isuse")));
				objDictionaryInfoCollection.add(objDictionaryInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objDictionaryInfoCollection;
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
		//DictionaryId
		if ("Dictionaryid".equals(columnName) && isAsc == true)
		{
          return sort(DictionaryColumnNameEnum.Dictionaryid, isAsc);
		}

		//显示名称
		if ("Name".equals(columnName) && isAsc == true)
		{
          return sort(DictionaryColumnNameEnum.Name, isAsc);
		}

		//对应表名
		if ("Tablename".equals(columnName) && isAsc == true)
		{
          return sort(DictionaryColumnNameEnum.Tablename, isAsc);
		}

		//是否启用
		if ("Isuse".equals(columnName) && isAsc == true)
		{
          return sort(DictionaryColumnNameEnum.Isuse, isAsc);
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
	public boolean sort(DictionaryColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//DictionaryId
		if (DictionaryColumnNameEnum.Dictionaryid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new DictionaryDictionaryidComparatorAsc());// 顺序
			return true;
		}
		if (DictionaryColumnNameEnum.Dictionaryid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new DictionaryDictionaryidComparatorDesc());// 倒叙
			return true;
		}

		//显示名称
		if (DictionaryColumnNameEnum.Name.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new DictionaryNameComparatorAsc());// 顺序
			return true;
		}
		if (DictionaryColumnNameEnum.Name.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new DictionaryNameComparatorDesc());// 倒叙
			return true;
		}

		//对应表名
		if (DictionaryColumnNameEnum.Tablename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new DictionaryTablenameComparatorAsc());// 顺序
			return true;
		}
		if (DictionaryColumnNameEnum.Tablename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new DictionaryTablenameComparatorDesc());// 倒叙
			return true;
		}

		//是否启用
		if (DictionaryColumnNameEnum.Isuse.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new DictionaryIsuseComparatorAsc());// 顺序
			return true;
		}
		if (DictionaryColumnNameEnum.Isuse.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new DictionaryIsuseComparatorDesc());// 倒叙
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
		for (DictionaryInfo objDictionaryInfo : this)
		{
			objJSONArray.put(objDictionaryInfo.toJson());
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
				DictionaryInfo objDictionaryInfo = new DictionaryInfo();
				objDictionaryInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objDictionaryInfo);
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
	// [start] 按 Dictionaryid DictionaryId 正序排序
/**
 * 按 Dictionaryid DictionaryId 正序排序
 *
 */
class DictionaryDictionaryidComparatorAsc implements Comparator<DictionaryInfo>
{
	public int compare(DictionaryInfo arg0, DictionaryInfo arg1)
	{
		if (arg0.getDictionaryid() > arg1.getDictionaryid())
			return 1;
		else if (arg0.getDictionaryid() < arg1.getDictionaryid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Dictionaryid DictionaryId 倒叙排序
/**
 * 按 Dictionaryid DictionaryId 倒叙排序
 *
 */
class DictionaryDictionaryidComparatorDesc implements Comparator<DictionaryInfo>
{

	public int compare(DictionaryInfo arg0, DictionaryInfo arg1)
	{
		if (arg0.getDictionaryid() > arg1.getDictionaryid())
			return -1;
		else if (arg0.getDictionaryid() < arg1.getDictionaryid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Name 显示名称正序排序
/**
 * 按 Name 显示名称 正序排序
 *
 */
class DictionaryNameComparatorAsc implements Comparator<DictionaryInfo>
{
	public int compare(DictionaryInfo arg0, DictionaryInfo arg1)
	{
		return arg0.getName().toLowerCase().compareTo(arg1.getName().toLowerCase());
	}
}
	// [end]

	// [start] 按 Name 显示名称 倒叙排序
/**
 * 按 Name 显示名称 倒叙排序
 *
 */
class DictionaryNameComparatorDesc implements Comparator<DictionaryInfo>
{

	public int compare(DictionaryInfo arg0, DictionaryInfo arg1)
	{
		return arg1.getName().toLowerCase().compareTo(arg0.getName().toLowerCase());
	}
}
	// [end]


	// [start] 按 Tablename 对应表名正序排序
/**
 * 按 Tablename 对应表名 正序排序
 *
 */
class DictionaryTablenameComparatorAsc implements Comparator<DictionaryInfo>
{
	public int compare(DictionaryInfo arg0, DictionaryInfo arg1)
	{
		return arg0.getTablename().toLowerCase().compareTo(arg1.getTablename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Tablename 对应表名 倒叙排序
/**
 * 按 Tablename 对应表名 倒叙排序
 *
 */
class DictionaryTablenameComparatorDesc implements Comparator<DictionaryInfo>
{

	public int compare(DictionaryInfo arg0, DictionaryInfo arg1)
	{
		return arg1.getTablename().toLowerCase().compareTo(arg0.getTablename().toLowerCase());
	}
}
	// [end]


	// [start] 按 Isuse 是否启用 正序排序
/**
 * 按 Isuse 是否启用 正序排序
 *
 */
class DictionaryIsuseComparatorAsc implements Comparator<DictionaryInfo>
{
	public int compare(DictionaryInfo arg0, DictionaryInfo arg1)
	{
		if (arg0.getIsuse() > arg1.getIsuse())
			return 1;
		else if (arg0.getIsuse() < arg1.getIsuse())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Isuse 是否启用 倒叙排序
/**
 * 按 Isuse 是否启用 倒叙排序
 *
 */
class DictionaryIsuseComparatorDesc implements Comparator<DictionaryInfo>
{

	public int compare(DictionaryInfo arg0, DictionaryInfo arg1)
	{
		if (arg0.getIsuse() > arg1.getIsuse())
			return -1;
		else if (arg0.getIsuse() < arg1.getIsuse())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [end]

