package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.IndustryFounsourceInfoBase.*;

/**
 * IndustryFounsource 资金来源表的摘要说明
 */
public class IndustryFounsourceInfoCollectionBase extends ArrayList<IndustryFounsourceInfo> implements List<IndustryFounsourceInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311492490628L;

	// [start] 根据主键或自增字段返回IndustryFounsourceInfo

        // [start] GetIndustryFounsourceInfoByFoundsourceid
        // [start] GetIndustryFounsourceInfoByFoundsourceid
        /**
        * 根据FoundSourceID获取表 资金来源表的对象IndustryFounsourceInfo
        * @param Foundsourceid 资金来源编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryFounsourceInfo对象实体
        */
        public IndustryFounsourceInfo GetIndustryFounsourceInfoByFoundsourceid(int Foundsourceid)
        {
              return GetIndustryFounsourceInfoByFoundsourceid(Foundsourceid,  true);
        }
        // [end]

        // [start] GetIndustryFounsourceInfoByFoundsourceid
        private int GetIndustryFounsourceInfoByFoundsourceid_Foundsourceid = 0;//资金来源编号
        private IndustryFounsourceInfo GetIndustryFounsourceInfoByFoundsourceid_IndustryFounsourceInfo;
        /**
        * 根据FoundSourceID获取表 资金来源表的对象IndustryFounsourceInfo
        * @param Foundsourceid 资金来源编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryFounsourceInfo对象实体
        */
        public IndustryFounsourceInfo GetIndustryFounsourceInfoByFoundsourceid(int Foundsourceid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetIndustryFounsourceInfoByFoundsourceid_IndustryFounsourceInfo = null;
                if (GetIndustryFounsourceInfoByFoundsourceid_IndustryFounsourceInfo == null || GetIndustryFounsourceInfoByFoundsourceid_Foundsourceid != Foundsourceid)
            {
            for (IndustryFounsourceInfo objIndustryFounsourceInfo : this)
            {
                if (objIndustryFounsourceInfo.getFoundsourceid() == Foundsourceid)
                {
                    GetIndustryFounsourceInfoByFoundsourceid_IndustryFounsourceInfo = objIndustryFounsourceInfo;
                    GetIndustryFounsourceInfoByFoundsourceid_Foundsourceid = Foundsourceid;//资金来源编号
                    return objIndustryFounsourceInfo;
                }
            }
            return null;
            }
            else
            {
                return GetIndustryFounsourceInfoByFoundsourceid_IndustryFounsourceInfo;
            }
        }
        // [end]

        // [start] GetIndexByFoundsourceid
        /**
        * 根据FoundSourceID获取表 资金来源表的对象IndustryFounsourceInfo 的位置
        * @param Foundsourceid 资金来源编号 
        * @return IndustryFounsourceInfo对象实体 的位置
        */
        public int GetIndexByFoundsourceid(int Foundsourceid)
        {
             int index = 0;
            for (IndustryFounsourceInfo objIndustryFounsourceInfo : this)
            {
                if (objIndustryFounsourceInfo.getFoundsourceid() == Foundsourceid)
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

	// [start] 根据索引返回IndustryFounsourceInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public IndustryFounsourceInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new IndustryFounsourceInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		IndustryFounsourceInfoCollection list = new IndustryFounsourceInfoCollection();
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
    public IndustryFounsourceInfoCollection Copy()
    {
        IndustryFounsourceInfoCollection list = new IndustryFounsourceInfoCollection();
        for (IndustryFounsourceInfo objIndustryFounsourceInfo : this)
        {
            list.add(objIndustryFounsourceInfo.Copy());
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
		sbStr.append("<ArrayOfIndustryFounsourceInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (IndustryFounsourceInfo objIndustryFounsourceInfo : this)
		{
			sbStr.append("  <IndustryFounsourceInfo>\n");
            //资金来源编号
			sbStr.append("    <Foundsourceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryFounsourceInfo.getFoundsourceid()));
			sbStr.append("</Foundsourceid>\n");
            //资金来源名
			sbStr.append("    <Foundsourcename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryFounsourceInfo.getFoundsourcename()));
			sbStr.append("</Foundsourcename>\n");
            //描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryFounsourceInfo.getDescription()));
			sbStr.append("</Description>\n");
			sbStr.append("  </IndustryFounsourceInfo>\n");
		}
		sbStr.append("</ArrayOfIndustryFounsourceInfo>\n");
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
	// GetIndustryFounsourceInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryFounsourceInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryFounsourceInfoCollection GetIndustryFounsourceInfoCollectionFormFileName(String filename)
	{
		return GetIndustryFounsourceInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryFounsourceInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFounsourceInfoCollection GetIndustryFounsourceInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryFounsourceInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryFounsourceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryFounsourceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFounsourceInfoCollection GetIndustryFounsourceInfoCollectionFormXml(String xml)
	{
		return GetIndustryFounsourceInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryFounsourceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFounsourceInfoCollection GetIndustryFounsourceInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryFounsourceInfoCollection objIndustryFounsourceInfoCollection = new IndustryFounsourceInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("IndustryFounsourceInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				IndustryFounsourceInfo objIndustryFounsourceInfo = new IndustryFounsourceInfo();
				//资金来源编号
				if (foo.elementText("Foundsourceid") != null)
					objIndustryFounsourceInfo.setFoundsourceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Foundsourceid")));
				//资金来源名
				if (foo.elementText("Foundsourcename") != null)
					objIndustryFounsourceInfo.setFoundsourcename(com.colorwinglib.Converts.objToStr(foo.elementText("Foundsourcename")));
				//描述
				if (foo.elementText("Description") != null)
					objIndustryFounsourceInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				objIndustryFounsourceInfoCollection.add(objIndustryFounsourceInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryFounsourceInfoCollection;
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
		//资金来源编号
		if ("Foundsourceid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryFounsourceColumnNameEnum.Foundsourceid, isAsc);
		}

		//资金来源名
		if ("Foundsourcename".equals(columnName) && isAsc == true)
		{
          return sort(IndustryFounsourceColumnNameEnum.Foundsourcename, isAsc);
		}

		//描述
		if ("Description".equals(columnName) && isAsc == true)
		{
          return sort(IndustryFounsourceColumnNameEnum.Description, isAsc);
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
	public boolean sort(IndustryFounsourceColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//资金来源编号
		if (IndustryFounsourceColumnNameEnum.Foundsourceid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryFounsourceFoundsourceidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryFounsourceColumnNameEnum.Foundsourceid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryFounsourceFoundsourceidComparatorDesc());// 倒叙
			return true;
		}

		//资金来源名
		if (IndustryFounsourceColumnNameEnum.Foundsourcename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryFounsourceFoundsourcenameComparatorAsc());// 顺序
			return true;
		}
		if (IndustryFounsourceColumnNameEnum.Foundsourcename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryFounsourceFoundsourcenameComparatorDesc());// 倒叙
			return true;
		}

		//描述
		if (IndustryFounsourceColumnNameEnum.Description.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryFounsourceDescriptionComparatorAsc());// 顺序
			return true;
		}
		if (IndustryFounsourceColumnNameEnum.Description.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryFounsourceDescriptionComparatorDesc());// 倒叙
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
		for (IndustryFounsourceInfo objIndustryFounsourceInfo : this)
		{
			objJSONArray.put(objIndustryFounsourceInfo.toJson());
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
				IndustryFounsourceInfo objIndustryFounsourceInfo = new IndustryFounsourceInfo();
				objIndustryFounsourceInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objIndustryFounsourceInfo);
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
	// [start] 按 Foundsourceid 资金来源编号 正序排序
/**
 * 按 Foundsourceid 资金来源编号 正序排序
 *
 */
class IndustryFounsourceFoundsourceidComparatorAsc implements Comparator<IndustryFounsourceInfo>
{
	public int compare(IndustryFounsourceInfo arg0, IndustryFounsourceInfo arg1)
	{
		if (arg0.getFoundsourceid() > arg1.getFoundsourceid())
			return 1;
		else if (arg0.getFoundsourceid() < arg1.getFoundsourceid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Foundsourceid 资金来源编号 倒叙排序
/**
 * 按 Foundsourceid 资金来源编号 倒叙排序
 *
 */
class IndustryFounsourceFoundsourceidComparatorDesc implements Comparator<IndustryFounsourceInfo>
{

	public int compare(IndustryFounsourceInfo arg0, IndustryFounsourceInfo arg1)
	{
		if (arg0.getFoundsourceid() > arg1.getFoundsourceid())
			return -1;
		else if (arg0.getFoundsourceid() < arg1.getFoundsourceid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Foundsourcename 资金来源名正序排序
/**
 * 按 Foundsourcename 资金来源名 正序排序
 *
 */
class IndustryFounsourceFoundsourcenameComparatorAsc implements Comparator<IndustryFounsourceInfo>
{
	public int compare(IndustryFounsourceInfo arg0, IndustryFounsourceInfo arg1)
	{
		return arg0.getFoundsourcename().toLowerCase().compareTo(arg1.getFoundsourcename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Foundsourcename 资金来源名 倒叙排序
/**
 * 按 Foundsourcename 资金来源名 倒叙排序
 *
 */
class IndustryFounsourceFoundsourcenameComparatorDesc implements Comparator<IndustryFounsourceInfo>
{

	public int compare(IndustryFounsourceInfo arg0, IndustryFounsourceInfo arg1)
	{
		return arg1.getFoundsourcename().toLowerCase().compareTo(arg0.getFoundsourcename().toLowerCase());
	}
}
	// [end]


	// [start] 按 Description 描述正序排序
/**
 * 按 Description 描述 正序排序
 *
 */
class IndustryFounsourceDescriptionComparatorAsc implements Comparator<IndustryFounsourceInfo>
{
	public int compare(IndustryFounsourceInfo arg0, IndustryFounsourceInfo arg1)
	{
		return arg0.getDescription().toLowerCase().compareTo(arg1.getDescription().toLowerCase());
	}
}
	// [end]

	// [start] 按 Description 描述 倒叙排序
/**
 * 按 Description 描述 倒叙排序
 *
 */
class IndustryFounsourceDescriptionComparatorDesc implements Comparator<IndustryFounsourceInfo>
{

	public int compare(IndustryFounsourceInfo arg0, IndustryFounsourceInfo arg1)
	{
		return arg1.getDescription().toLowerCase().compareTo(arg0.getDescription().toLowerCase());
	}
}
	// [end]


	// [end]

