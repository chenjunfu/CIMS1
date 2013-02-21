package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.IndustryTypeInfoBase.*;

/**
 * IndustryType 产业项目类别类别表的摘要说明
 */
public class IndustryTypeInfoCollectionBase extends ArrayList<IndustryTypeInfo> implements List<IndustryTypeInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311501623432L;

	// [start] 根据主键或自增字段返回IndustryTypeInfo

        // [start] GetIndustryTypeInfoByIndustrydatabaseid
        // [start] GetIndustryTypeInfoByIndustrydatabaseid
        /**
        * 根据IndustrydatabaseID获取表 产业项目类别类别表的对象IndustryTypeInfo
        * @param Industrydatabaseid IndustrydatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryTypeInfo对象实体
        */
        public IndustryTypeInfo GetIndustryTypeInfoByIndustrydatabaseid(int Industrydatabaseid)
        {
              return GetIndustryTypeInfoByIndustrydatabaseid(Industrydatabaseid,  true);
        }
        // [end]

        // [start] GetIndustryTypeInfoByIndustrydatabaseid
        private int GetIndustryTypeInfoByIndustrydatabaseid_Industrydatabaseid = 0;//IndustrydatabaseID
        private IndustryTypeInfo GetIndustryTypeInfoByIndustrydatabaseid_IndustryTypeInfo;
        /**
        * 根据IndustrydatabaseID获取表 产业项目类别类别表的对象IndustryTypeInfo
        * @param Industrydatabaseid IndustrydatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryTypeInfo对象实体
        */
        public IndustryTypeInfo GetIndustryTypeInfoByIndustrydatabaseid(int Industrydatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetIndustryTypeInfoByIndustrydatabaseid_IndustryTypeInfo = null;
                if (GetIndustryTypeInfoByIndustrydatabaseid_IndustryTypeInfo == null || GetIndustryTypeInfoByIndustrydatabaseid_Industrydatabaseid != Industrydatabaseid)
            {
            for (IndustryTypeInfo objIndustryTypeInfo : this)
            {
                if (objIndustryTypeInfo.getIndustrydatabaseid() == Industrydatabaseid)
                {
                    GetIndustryTypeInfoByIndustrydatabaseid_IndustryTypeInfo = objIndustryTypeInfo;
                    GetIndustryTypeInfoByIndustrydatabaseid_Industrydatabaseid = Industrydatabaseid;//IndustrydatabaseID
                    return objIndustryTypeInfo;
                }
            }
            return null;
            }
            else
            {
                return GetIndustryTypeInfoByIndustrydatabaseid_IndustryTypeInfo;
            }
        }
        // [end]

        // [start] GetIndexByIndustrydatabaseid
        /**
        * 根据IndustrydatabaseID获取表 产业项目类别类别表的对象IndustryTypeInfo 的位置
        * @param Industrydatabaseid IndustrydatabaseID 
        * @return IndustryTypeInfo对象实体 的位置
        */
        public int GetIndexByIndustrydatabaseid(int Industrydatabaseid)
        {
             int index = 0;
            for (IndustryTypeInfo objIndustryTypeInfo : this)
            {
                if (objIndustryTypeInfo.getIndustrydatabaseid() == Industrydatabaseid)
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

	// [start] 根据索引返回IndustryTypeInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public IndustryTypeInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new IndustryTypeInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		IndustryTypeInfoCollection list = new IndustryTypeInfoCollection();
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
    public IndustryTypeInfoCollection Copy()
    {
        IndustryTypeInfoCollection list = new IndustryTypeInfoCollection();
        for (IndustryTypeInfo objIndustryTypeInfo : this)
        {
            list.add(objIndustryTypeInfo.Copy());
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
		sbStr.append("<ArrayOfIndustryTypeInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (IndustryTypeInfo objIndustryTypeInfo : this)
		{
			sbStr.append("  <IndustryTypeInfo>\n");
            //IndustrydatabaseID
			sbStr.append("    <Industrydatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryTypeInfo.getIndustrydatabaseid()));
			sbStr.append("</Industrydatabaseid>\n");
            //产业项目类别编号
			sbStr.append("    <Industryid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryTypeInfo.getIndustryid()));
			sbStr.append("</Industryid>\n");
            //产业项目类别名称
			sbStr.append("    <Industryname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryTypeInfo.getIndustryname()));
			sbStr.append("</Industryname>\n");
			sbStr.append("  </IndustryTypeInfo>\n");
		}
		sbStr.append("</ArrayOfIndustryTypeInfo>\n");
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
	// GetIndustryTypeInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryTypeInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryTypeInfoCollection GetIndustryTypeInfoCollectionFormFileName(String filename)
	{
		return GetIndustryTypeInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryTypeInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryTypeInfoCollection GetIndustryTypeInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryTypeInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryTypeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryTypeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryTypeInfoCollection GetIndustryTypeInfoCollectionFormXml(String xml)
	{
		return GetIndustryTypeInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryTypeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryTypeInfoCollection GetIndustryTypeInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryTypeInfoCollection objIndustryTypeInfoCollection = new IndustryTypeInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("IndustryTypeInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				IndustryTypeInfo objIndustryTypeInfo = new IndustryTypeInfo();
				//IndustrydatabaseID
				if (foo.elementText("Industrydatabaseid") != null)
					objIndustryTypeInfo.setIndustrydatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Industrydatabaseid")));
				//产业项目类别编号
				if (foo.elementText("Industryid") != null)
					objIndustryTypeInfo.setIndustryid(com.colorwinglib.Converts.StrToInt(foo.elementText("Industryid")));
				//产业项目类别名称
				if (foo.elementText("Industryname") != null)
					objIndustryTypeInfo.setIndustryname(com.colorwinglib.Converts.objToStr(foo.elementText("Industryname")));
				objIndustryTypeInfoCollection.add(objIndustryTypeInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryTypeInfoCollection;
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
		//IndustrydatabaseID
		if ("Industrydatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryTypeColumnNameEnum.Industrydatabaseid, isAsc);
		}

		//产业项目类别编号
		if ("Industryid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryTypeColumnNameEnum.Industryid, isAsc);
		}

		//产业项目类别名称
		if ("Industryname".equals(columnName) && isAsc == true)
		{
          return sort(IndustryTypeColumnNameEnum.Industryname, isAsc);
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
	public boolean sort(IndustryTypeColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//IndustrydatabaseID
		if (IndustryTypeColumnNameEnum.Industrydatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryTypeIndustrydatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryTypeColumnNameEnum.Industrydatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryTypeIndustrydatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//产业项目类别编号
		if (IndustryTypeColumnNameEnum.Industryid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryTypeIndustryidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryTypeColumnNameEnum.Industryid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryTypeIndustryidComparatorDesc());// 倒叙
			return true;
		}

		//产业项目类别名称
		if (IndustryTypeColumnNameEnum.Industryname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryTypeIndustrynameComparatorAsc());// 顺序
			return true;
		}
		if (IndustryTypeColumnNameEnum.Industryname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryTypeIndustrynameComparatorDesc());// 倒叙
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
		for (IndustryTypeInfo objIndustryTypeInfo : this)
		{
			objJSONArray.put(objIndustryTypeInfo.toJson());
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
				IndustryTypeInfo objIndustryTypeInfo = new IndustryTypeInfo();
				objIndustryTypeInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objIndustryTypeInfo);
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
	// [start] 按 Industrydatabaseid IndustrydatabaseID 正序排序
/**
 * 按 Industrydatabaseid IndustrydatabaseID 正序排序
 *
 */
class IndustryTypeIndustrydatabaseidComparatorAsc implements Comparator<IndustryTypeInfo>
{
	public int compare(IndustryTypeInfo arg0, IndustryTypeInfo arg1)
	{
		if (arg0.getIndustrydatabaseid() > arg1.getIndustrydatabaseid())
			return 1;
		else if (arg0.getIndustrydatabaseid() < arg1.getIndustrydatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Industrydatabaseid IndustrydatabaseID 倒叙排序
/**
 * 按 Industrydatabaseid IndustrydatabaseID 倒叙排序
 *
 */
class IndustryTypeIndustrydatabaseidComparatorDesc implements Comparator<IndustryTypeInfo>
{

	public int compare(IndustryTypeInfo arg0, IndustryTypeInfo arg1)
	{
		if (arg0.getIndustrydatabaseid() > arg1.getIndustrydatabaseid())
			return -1;
		else if (arg0.getIndustrydatabaseid() < arg1.getIndustrydatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Industryid 产业项目类别编号 正序排序
/**
 * 按 Industryid 产业项目类别编号 正序排序
 *
 */
class IndustryTypeIndustryidComparatorAsc implements Comparator<IndustryTypeInfo>
{
	public int compare(IndustryTypeInfo arg0, IndustryTypeInfo arg1)
	{
		if (arg0.getIndustryid() > arg1.getIndustryid())
			return 1;
		else if (arg0.getIndustryid() < arg1.getIndustryid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Industryid 产业项目类别编号 倒叙排序
/**
 * 按 Industryid 产业项目类别编号 倒叙排序
 *
 */
class IndustryTypeIndustryidComparatorDesc implements Comparator<IndustryTypeInfo>
{

	public int compare(IndustryTypeInfo arg0, IndustryTypeInfo arg1)
	{
		if (arg0.getIndustryid() > arg1.getIndustryid())
			return -1;
		else if (arg0.getIndustryid() < arg1.getIndustryid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Industryname 产业项目类别名称正序排序
/**
 * 按 Industryname 产业项目类别名称 正序排序
 *
 */
class IndustryTypeIndustrynameComparatorAsc implements Comparator<IndustryTypeInfo>
{
	public int compare(IndustryTypeInfo arg0, IndustryTypeInfo arg1)
	{
		return arg0.getIndustryname().toLowerCase().compareTo(arg1.getIndustryname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Industryname 产业项目类别名称 倒叙排序
/**
 * 按 Industryname 产业项目类别名称 倒叙排序
 *
 */
class IndustryTypeIndustrynameComparatorDesc implements Comparator<IndustryTypeInfo>
{

	public int compare(IndustryTypeInfo arg0, IndustryTypeInfo arg1)
	{
		return arg1.getIndustryname().toLowerCase().compareTo(arg0.getIndustryname().toLowerCase());
	}
}
	// [end]


	// [end]

