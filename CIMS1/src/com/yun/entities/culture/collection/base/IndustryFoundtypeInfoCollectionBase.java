package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.IndustryFoundtypeInfoBase.*;

/**
 * IndustryFoundtype 资金类别表的摘要说明
 */
public class IndustryFoundtypeInfoCollectionBase extends ArrayList<IndustryFoundtypeInfo> implements List<IndustryFoundtypeInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311490012598L;

	// [start] 根据主键或自增字段返回IndustryFoundtypeInfo

        // [start] GetIndustryFoundtypeInfoByFundtypeid
        // [start] GetIndustryFoundtypeInfoByFundtypeid
        /**
        * 根据FundTypeID获取表 资金类别表的对象IndustryFoundtypeInfo
        * @param Fundtypeid 资金类别编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryFoundtypeInfo对象实体
        */
        public IndustryFoundtypeInfo GetIndustryFoundtypeInfoByFundtypeid(int Fundtypeid)
        {
              return GetIndustryFoundtypeInfoByFundtypeid(Fundtypeid,  true);
        }
        // [end]

        // [start] GetIndustryFoundtypeInfoByFundtypeid
        private int GetIndustryFoundtypeInfoByFundtypeid_Fundtypeid = 0;//资金类别编号
        private IndustryFoundtypeInfo GetIndustryFoundtypeInfoByFundtypeid_IndustryFoundtypeInfo;
        /**
        * 根据FundTypeID获取表 资金类别表的对象IndustryFoundtypeInfo
        * @param Fundtypeid 资金类别编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryFoundtypeInfo对象实体
        */
        public IndustryFoundtypeInfo GetIndustryFoundtypeInfoByFundtypeid(int Fundtypeid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetIndustryFoundtypeInfoByFundtypeid_IndustryFoundtypeInfo = null;
                if (GetIndustryFoundtypeInfoByFundtypeid_IndustryFoundtypeInfo == null || GetIndustryFoundtypeInfoByFundtypeid_Fundtypeid != Fundtypeid)
            {
            for (IndustryFoundtypeInfo objIndustryFoundtypeInfo : this)
            {
                if (objIndustryFoundtypeInfo.getFundtypeid() == Fundtypeid)
                {
                    GetIndustryFoundtypeInfoByFundtypeid_IndustryFoundtypeInfo = objIndustryFoundtypeInfo;
                    GetIndustryFoundtypeInfoByFundtypeid_Fundtypeid = Fundtypeid;//资金类别编号
                    return objIndustryFoundtypeInfo;
                }
            }
            return null;
            }
            else
            {
                return GetIndustryFoundtypeInfoByFundtypeid_IndustryFoundtypeInfo;
            }
        }
        // [end]

        // [start] GetIndexByFundtypeid
        /**
        * 根据FundTypeID获取表 资金类别表的对象IndustryFoundtypeInfo 的位置
        * @param Fundtypeid 资金类别编号 
        * @return IndustryFoundtypeInfo对象实体 的位置
        */
        public int GetIndexByFundtypeid(int Fundtypeid)
        {
             int index = 0;
            for (IndustryFoundtypeInfo objIndustryFoundtypeInfo : this)
            {
                if (objIndustryFoundtypeInfo.getFundtypeid() == Fundtypeid)
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

	// [start] 根据索引返回IndustryFoundtypeInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public IndustryFoundtypeInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new IndustryFoundtypeInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		IndustryFoundtypeInfoCollection list = new IndustryFoundtypeInfoCollection();
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
    public IndustryFoundtypeInfoCollection Copy()
    {
        IndustryFoundtypeInfoCollection list = new IndustryFoundtypeInfoCollection();
        for (IndustryFoundtypeInfo objIndustryFoundtypeInfo : this)
        {
            list.add(objIndustryFoundtypeInfo.Copy());
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
		sbStr.append("<ArrayOfIndustryFoundtypeInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (IndustryFoundtypeInfo objIndustryFoundtypeInfo : this)
		{
			sbStr.append("  <IndustryFoundtypeInfo>\n");
            //资金类别编号
			sbStr.append("    <Fundtypeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryFoundtypeInfo.getFundtypeid()));
			sbStr.append("</Fundtypeid>\n");
            //资金类别名
			sbStr.append("    <Fundtypename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryFoundtypeInfo.getFundtypename()));
			sbStr.append("</Fundtypename>\n");
            //描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryFoundtypeInfo.getDescription()));
			sbStr.append("</Description>\n");
			sbStr.append("  </IndustryFoundtypeInfo>\n");
		}
		sbStr.append("</ArrayOfIndustryFoundtypeInfo>\n");
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
	// GetIndustryFoundtypeInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryFoundtypeInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryFoundtypeInfoCollection GetIndustryFoundtypeInfoCollectionFormFileName(String filename)
	{
		return GetIndustryFoundtypeInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryFoundtypeInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFoundtypeInfoCollection GetIndustryFoundtypeInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryFoundtypeInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryFoundtypeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryFoundtypeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFoundtypeInfoCollection GetIndustryFoundtypeInfoCollectionFormXml(String xml)
	{
		return GetIndustryFoundtypeInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryFoundtypeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryFoundtypeInfoCollection GetIndustryFoundtypeInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryFoundtypeInfoCollection objIndustryFoundtypeInfoCollection = new IndustryFoundtypeInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("IndustryFoundtypeInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				IndustryFoundtypeInfo objIndustryFoundtypeInfo = new IndustryFoundtypeInfo();
				//资金类别编号
				if (foo.elementText("Fundtypeid") != null)
					objIndustryFoundtypeInfo.setFundtypeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Fundtypeid")));
				//资金类别名
				if (foo.elementText("Fundtypename") != null)
					objIndustryFoundtypeInfo.setFundtypename(com.colorwinglib.Converts.objToStr(foo.elementText("Fundtypename")));
				//描述
				if (foo.elementText("Description") != null)
					objIndustryFoundtypeInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				objIndustryFoundtypeInfoCollection.add(objIndustryFoundtypeInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryFoundtypeInfoCollection;
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
		//资金类别编号
		if ("Fundtypeid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryFoundtypeColumnNameEnum.Fundtypeid, isAsc);
		}

		//资金类别名
		if ("Fundtypename".equals(columnName) && isAsc == true)
		{
          return sort(IndustryFoundtypeColumnNameEnum.Fundtypename, isAsc);
		}

		//描述
		if ("Description".equals(columnName) && isAsc == true)
		{
          return sort(IndustryFoundtypeColumnNameEnum.Description, isAsc);
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
	public boolean sort(IndustryFoundtypeColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//资金类别编号
		if (IndustryFoundtypeColumnNameEnum.Fundtypeid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryFoundtypeFundtypeidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryFoundtypeColumnNameEnum.Fundtypeid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryFoundtypeFundtypeidComparatorDesc());// 倒叙
			return true;
		}

		//资金类别名
		if (IndustryFoundtypeColumnNameEnum.Fundtypename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryFoundtypeFundtypenameComparatorAsc());// 顺序
			return true;
		}
		if (IndustryFoundtypeColumnNameEnum.Fundtypename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryFoundtypeFundtypenameComparatorDesc());// 倒叙
			return true;
		}

		//描述
		if (IndustryFoundtypeColumnNameEnum.Description.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryFoundtypeDescriptionComparatorAsc());// 顺序
			return true;
		}
		if (IndustryFoundtypeColumnNameEnum.Description.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryFoundtypeDescriptionComparatorDesc());// 倒叙
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
		for (IndustryFoundtypeInfo objIndustryFoundtypeInfo : this)
		{
			objJSONArray.put(objIndustryFoundtypeInfo.toJson());
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
				IndustryFoundtypeInfo objIndustryFoundtypeInfo = new IndustryFoundtypeInfo();
				objIndustryFoundtypeInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objIndustryFoundtypeInfo);
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
	// [start] 按 Fundtypeid 资金类别编号 正序排序
/**
 * 按 Fundtypeid 资金类别编号 正序排序
 *
 */
class IndustryFoundtypeFundtypeidComparatorAsc implements Comparator<IndustryFoundtypeInfo>
{
	public int compare(IndustryFoundtypeInfo arg0, IndustryFoundtypeInfo arg1)
	{
		if (arg0.getFundtypeid() > arg1.getFundtypeid())
			return 1;
		else if (arg0.getFundtypeid() < arg1.getFundtypeid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Fundtypeid 资金类别编号 倒叙排序
/**
 * 按 Fundtypeid 资金类别编号 倒叙排序
 *
 */
class IndustryFoundtypeFundtypeidComparatorDesc implements Comparator<IndustryFoundtypeInfo>
{

	public int compare(IndustryFoundtypeInfo arg0, IndustryFoundtypeInfo arg1)
	{
		if (arg0.getFundtypeid() > arg1.getFundtypeid())
			return -1;
		else if (arg0.getFundtypeid() < arg1.getFundtypeid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Fundtypename 资金类别名正序排序
/**
 * 按 Fundtypename 资金类别名 正序排序
 *
 */
class IndustryFoundtypeFundtypenameComparatorAsc implements Comparator<IndustryFoundtypeInfo>
{
	public int compare(IndustryFoundtypeInfo arg0, IndustryFoundtypeInfo arg1)
	{
		return arg0.getFundtypename().toLowerCase().compareTo(arg1.getFundtypename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Fundtypename 资金类别名 倒叙排序
/**
 * 按 Fundtypename 资金类别名 倒叙排序
 *
 */
class IndustryFoundtypeFundtypenameComparatorDesc implements Comparator<IndustryFoundtypeInfo>
{

	public int compare(IndustryFoundtypeInfo arg0, IndustryFoundtypeInfo arg1)
	{
		return arg1.getFundtypename().toLowerCase().compareTo(arg0.getFundtypename().toLowerCase());
	}
}
	// [end]


	// [start] 按 Description 描述正序排序
/**
 * 按 Description 描述 正序排序
 *
 */
class IndustryFoundtypeDescriptionComparatorAsc implements Comparator<IndustryFoundtypeInfo>
{
	public int compare(IndustryFoundtypeInfo arg0, IndustryFoundtypeInfo arg1)
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
class IndustryFoundtypeDescriptionComparatorDesc implements Comparator<IndustryFoundtypeInfo>
{

	public int compare(IndustryFoundtypeInfo arg0, IndustryFoundtypeInfo arg1)
	{
		return arg1.getDescription().toLowerCase().compareTo(arg0.getDescription().toLowerCase());
	}
}
	// [end]


	// [end]

