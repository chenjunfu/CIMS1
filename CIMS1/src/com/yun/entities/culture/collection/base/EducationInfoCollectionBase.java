package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.EducationInfoBase.*;

/**
 * Education 学历表的摘要说明
 */
public class EducationInfoCollectionBase extends ArrayList<EducationInfo> implements List<EducationInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311470601559L;

	// [start] 根据主键或自增字段返回EducationInfo

        // [start] GetEducationInfoByEducationdatabaseid
        // [start] GetEducationInfoByEducationdatabaseid
        /**
        * 根据EducationdatabaseID获取表 学历表的对象EducationInfo
        * @param Educationdatabaseid EducationdatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EducationInfo对象实体
        */
        public EducationInfo GetEducationInfoByEducationdatabaseid(int Educationdatabaseid)
        {
              return GetEducationInfoByEducationdatabaseid(Educationdatabaseid,  true);
        }
        // [end]

        // [start] GetEducationInfoByEducationdatabaseid
        private int GetEducationInfoByEducationdatabaseid_Educationdatabaseid = 0;//EducationdatabaseID
        private EducationInfo GetEducationInfoByEducationdatabaseid_EducationInfo;
        /**
        * 根据EducationdatabaseID获取表 学历表的对象EducationInfo
        * @param Educationdatabaseid EducationdatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EducationInfo对象实体
        */
        public EducationInfo GetEducationInfoByEducationdatabaseid(int Educationdatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetEducationInfoByEducationdatabaseid_EducationInfo = null;
                if (GetEducationInfoByEducationdatabaseid_EducationInfo == null || GetEducationInfoByEducationdatabaseid_Educationdatabaseid != Educationdatabaseid)
            {
            for (EducationInfo objEducationInfo : this)
            {
                if (objEducationInfo.getEducationdatabaseid() == Educationdatabaseid)
                {
                    GetEducationInfoByEducationdatabaseid_EducationInfo = objEducationInfo;
                    GetEducationInfoByEducationdatabaseid_Educationdatabaseid = Educationdatabaseid;//EducationdatabaseID
                    return objEducationInfo;
                }
            }
            return null;
            }
            else
            {
                return GetEducationInfoByEducationdatabaseid_EducationInfo;
            }
        }
        // [end]

        // [start] GetIndexByEducationdatabaseid
        /**
        * 根据EducationdatabaseID获取表 学历表的对象EducationInfo 的位置
        * @param Educationdatabaseid EducationdatabaseID 
        * @return EducationInfo对象实体 的位置
        */
        public int GetIndexByEducationdatabaseid(int Educationdatabaseid)
        {
             int index = 0;
            for (EducationInfo objEducationInfo : this)
            {
                if (objEducationInfo.getEducationdatabaseid() == Educationdatabaseid)
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

	// [start] 根据索引返回EducationInfoCollection

        // [start] GetEducationInfoCollectionByEducationid
        // [start] GetEducationInfoCollectionByEducationid
        /**
        * 根据EducationID获取表 学历表的对象集合EducationInfoCollection
        * @param Educationid 学历编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EducationInfoCollection对象集合
        */
        public EducationInfoCollection GetEducationInfoCollectionByEducationid(int Educationid)
        {
              return GetEducationInfoCollectionByEducationid(Educationid,  true);
        }
        // [end]

        // [start] GetEducationInfoCollectionByEducationid
        private int GetEducationInfoCollectionByEducationid_Educationid = 0;//学历编号
        private EducationInfoCollection GetEducationInfoCollectionByEducationid_EducationInfoCollection;
        /**
        * 根据EducationID获取表 学历表的对象集合EducationInfoCollection
        * @param Educationid 学历编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EducationInfoCollection对象集合
        */
        public EducationInfoCollection GetEducationInfoCollectionByEducationid(int Educationid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetEducationInfoCollectionByEducationid_EducationInfoCollection = null;
                if (GetEducationInfoCollectionByEducationid_EducationInfoCollection == null || GetEducationInfoCollectionByEducationid_Educationid != Educationid)
            {
            EducationInfoCollection list = new EducationInfoCollection();
            for (EducationInfo objEducationInfo : this)
            {
                if (objEducationInfo.getEducationid() == Educationid)
                {
                    list.add(objEducationInfo);
                }
            }
            GetEducationInfoCollectionByEducationid_EducationInfoCollection = list;
            GetEducationInfoCollectionByEducationid_Educationid = Educationid;//学历编号
            return list;
            }
            else
            {
                return GetEducationInfoCollectionByEducationid_EducationInfoCollection;
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
	public EducationInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new EducationInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		EducationInfoCollection list = new EducationInfoCollection();
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
    public EducationInfoCollection Copy()
    {
        EducationInfoCollection list = new EducationInfoCollection();
        for (EducationInfo objEducationInfo : this)
        {
            list.add(objEducationInfo.Copy());
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
		sbStr.append("<ArrayOfEducationInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (EducationInfo objEducationInfo : this)
		{
			sbStr.append("  <EducationInfo>\n");
            //EducationdatabaseID
			sbStr.append("    <Educationdatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEducationInfo.getEducationdatabaseid()));
			sbStr.append("</Educationdatabaseid>\n");
            //学历编号
			sbStr.append("    <Educationid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEducationInfo.getEducationid()));
			sbStr.append("</Educationid>\n");
            //学历名称
			sbStr.append("    <Educationname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEducationInfo.getEducationname()));
			sbStr.append("</Educationname>\n");
			sbStr.append("  </EducationInfo>\n");
		}
		sbStr.append("</ArrayOfEducationInfo>\n");
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
	// GetEducationInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetEducationInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static EducationInfoCollection GetEducationInfoCollectionFormFileName(String filename)
	{
		return GetEducationInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEducationInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EducationInfoCollection GetEducationInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetEducationInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetEducationInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetEducationInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EducationInfoCollection GetEducationInfoCollectionFormXml(String xml)
	{
		return GetEducationInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEducationInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EducationInfoCollection GetEducationInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		EducationInfoCollection objEducationInfoCollection = new EducationInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("EducationInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				EducationInfo objEducationInfo = new EducationInfo();
				//EducationdatabaseID
				if (foo.elementText("Educationdatabaseid") != null)
					objEducationInfo.setEducationdatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Educationdatabaseid")));
				//学历编号
				if (foo.elementText("Educationid") != null)
					objEducationInfo.setEducationid(com.colorwinglib.Converts.StrToInt(foo.elementText("Educationid")));
				//学历名称
				if (foo.elementText("Educationname") != null)
					objEducationInfo.setEducationname(com.colorwinglib.Converts.objToStr(foo.elementText("Educationname")));
				objEducationInfoCollection.add(objEducationInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objEducationInfoCollection;
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
		//EducationdatabaseID
		if ("Educationdatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(EducationColumnNameEnum.Educationdatabaseid, isAsc);
		}

		//学历编号
		if ("Educationid".equals(columnName) && isAsc == true)
		{
          return sort(EducationColumnNameEnum.Educationid, isAsc);
		}

		//学历名称
		if ("Educationname".equals(columnName) && isAsc == true)
		{
          return sort(EducationColumnNameEnum.Educationname, isAsc);
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
	public boolean sort(EducationColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//EducationdatabaseID
		if (EducationColumnNameEnum.Educationdatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EducationEducationdatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (EducationColumnNameEnum.Educationdatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EducationEducationdatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//学历编号
		if (EducationColumnNameEnum.Educationid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EducationEducationidComparatorAsc());// 顺序
			return true;
		}
		if (EducationColumnNameEnum.Educationid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EducationEducationidComparatorDesc());// 倒叙
			return true;
		}

		//学历名称
		if (EducationColumnNameEnum.Educationname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EducationEducationnameComparatorAsc());// 顺序
			return true;
		}
		if (EducationColumnNameEnum.Educationname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EducationEducationnameComparatorDesc());// 倒叙
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
		for (EducationInfo objEducationInfo : this)
		{
			objJSONArray.put(objEducationInfo.toJson());
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
				EducationInfo objEducationInfo = new EducationInfo();
				objEducationInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objEducationInfo);
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
	// [start] 按 Educationdatabaseid EducationdatabaseID 正序排序
/**
 * 按 Educationdatabaseid EducationdatabaseID 正序排序
 *
 */
class EducationEducationdatabaseidComparatorAsc implements Comparator<EducationInfo>
{
	public int compare(EducationInfo arg0, EducationInfo arg1)
	{
		if (arg0.getEducationdatabaseid() > arg1.getEducationdatabaseid())
			return 1;
		else if (arg0.getEducationdatabaseid() < arg1.getEducationdatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Educationdatabaseid EducationdatabaseID 倒叙排序
/**
 * 按 Educationdatabaseid EducationdatabaseID 倒叙排序
 *
 */
class EducationEducationdatabaseidComparatorDesc implements Comparator<EducationInfo>
{

	public int compare(EducationInfo arg0, EducationInfo arg1)
	{
		if (arg0.getEducationdatabaseid() > arg1.getEducationdatabaseid())
			return -1;
		else if (arg0.getEducationdatabaseid() < arg1.getEducationdatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Educationid 学历编号 正序排序
/**
 * 按 Educationid 学历编号 正序排序
 *
 */
class EducationEducationidComparatorAsc implements Comparator<EducationInfo>
{
	public int compare(EducationInfo arg0, EducationInfo arg1)
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

	// [start] 按 Educationid 学历编号 倒叙排序
/**
 * 按 Educationid 学历编号 倒叙排序
 *
 */
class EducationEducationidComparatorDesc implements Comparator<EducationInfo>
{

	public int compare(EducationInfo arg0, EducationInfo arg1)
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


	// [start] 按 Educationname 学历名称正序排序
/**
 * 按 Educationname 学历名称 正序排序
 *
 */
class EducationEducationnameComparatorAsc implements Comparator<EducationInfo>
{
	public int compare(EducationInfo arg0, EducationInfo arg1)
	{
		return arg0.getEducationname().toLowerCase().compareTo(arg1.getEducationname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Educationname 学历名称 倒叙排序
/**
 * 按 Educationname 学历名称 倒叙排序
 *
 */
class EducationEducationnameComparatorDesc implements Comparator<EducationInfo>
{

	public int compare(EducationInfo arg0, EducationInfo arg1)
	{
		return arg1.getEducationname().toLowerCase().compareTo(arg0.getEducationname().toLowerCase());
	}
}
	// [end]


	// [end]

