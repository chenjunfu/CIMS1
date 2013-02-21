package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.ProfessionInfoBase.*;

/**
 * Profession 行业类别表的摘要说明
 */
public class ProfessionInfoCollectionBase extends ArrayList<ProfessionInfo> implements List<ProfessionInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311531651522L;

	// [start] 根据主键或自增字段返回ProfessionInfo

        // [start] GetProfessionInfoByBusinessdatabaseid
        // [start] GetProfessionInfoByBusinessdatabaseid
        /**
        * 根据BusinessdatabaseID获取表 行业类别表的对象ProfessionInfo
        * @param Businessdatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProfessionInfo对象实体
        */
        public ProfessionInfo GetProfessionInfoByBusinessdatabaseid(int Businessdatabaseid)
        {
              return GetProfessionInfoByBusinessdatabaseid(Businessdatabaseid,  true);
        }
        // [end]

        // [start] GetProfessionInfoByBusinessdatabaseid
        private int GetProfessionInfoByBusinessdatabaseid_Businessdatabaseid = 0;//数据库ID
        private ProfessionInfo GetProfessionInfoByBusinessdatabaseid_ProfessionInfo;
        /**
        * 根据BusinessdatabaseID获取表 行业类别表的对象ProfessionInfo
        * @param Businessdatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProfessionInfo对象实体
        */
        public ProfessionInfo GetProfessionInfoByBusinessdatabaseid(int Businessdatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetProfessionInfoByBusinessdatabaseid_ProfessionInfo = null;
                if (GetProfessionInfoByBusinessdatabaseid_ProfessionInfo == null || GetProfessionInfoByBusinessdatabaseid_Businessdatabaseid != Businessdatabaseid)
            {
            for (ProfessionInfo objProfessionInfo : this)
            {
                if (objProfessionInfo.getBusinessdatabaseid() == Businessdatabaseid)
                {
                    GetProfessionInfoByBusinessdatabaseid_ProfessionInfo = objProfessionInfo;
                    GetProfessionInfoByBusinessdatabaseid_Businessdatabaseid = Businessdatabaseid;//数据库ID
                    return objProfessionInfo;
                }
            }
            return null;
            }
            else
            {
                return GetProfessionInfoByBusinessdatabaseid_ProfessionInfo;
            }
        }
        // [end]

        // [start] GetIndexByBusinessdatabaseid
        /**
        * 根据BusinessdatabaseID获取表 行业类别表的对象ProfessionInfo 的位置
        * @param Businessdatabaseid 数据库ID 
        * @return ProfessionInfo对象实体 的位置
        */
        public int GetIndexByBusinessdatabaseid(int Businessdatabaseid)
        {
             int index = 0;
            for (ProfessionInfo objProfessionInfo : this)
            {
                if (objProfessionInfo.getBusinessdatabaseid() == Businessdatabaseid)
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

	// [start] 根据索引返回ProfessionInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public ProfessionInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new ProfessionInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		ProfessionInfoCollection list = new ProfessionInfoCollection();
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
    public ProfessionInfoCollection Copy()
    {
        ProfessionInfoCollection list = new ProfessionInfoCollection();
        for (ProfessionInfo objProfessionInfo : this)
        {
            list.add(objProfessionInfo.Copy());
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
		sbStr.append("<ArrayOfProfessionInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (ProfessionInfo objProfessionInfo : this)
		{
			sbStr.append("  <ProfessionInfo>\n");
            //数据库ID
			sbStr.append("    <Businessdatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProfessionInfo.getBusinessdatabaseid()));
			sbStr.append("</Businessdatabaseid>\n");
            //企业所属行业ID
			sbStr.append("    <Businesstypeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProfessionInfo.getBusinesstypeid()));
			sbStr.append("</Businesstypeid>\n");
            //企业行业类型名称
			sbStr.append("    <Businesstypename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProfessionInfo.getBusinesstypename()));
			sbStr.append("</Businesstypename>\n");
			sbStr.append("  </ProfessionInfo>\n");
		}
		sbStr.append("</ArrayOfProfessionInfo>\n");
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
	// GetProfessionInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetProfessionInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ProfessionInfoCollection GetProfessionInfoCollectionFormFileName(String filename)
	{
		return GetProfessionInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProfessionInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProfessionInfoCollection GetProfessionInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetProfessionInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetProfessionInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetProfessionInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProfessionInfoCollection GetProfessionInfoCollectionFormXml(String xml)
	{
		return GetProfessionInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProfessionInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProfessionInfoCollection GetProfessionInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ProfessionInfoCollection objProfessionInfoCollection = new ProfessionInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("ProfessionInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				ProfessionInfo objProfessionInfo = new ProfessionInfo();
				//数据库ID
				if (foo.elementText("Businessdatabaseid") != null)
					objProfessionInfo.setBusinessdatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Businessdatabaseid")));
				//企业所属行业ID
				if (foo.elementText("Businesstypeid") != null)
					objProfessionInfo.setBusinesstypeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Businesstypeid")));
				//企业行业类型名称
				if (foo.elementText("Businesstypename") != null)
					objProfessionInfo.setBusinesstypename(com.colorwinglib.Converts.objToStr(foo.elementText("Businesstypename")));
				objProfessionInfoCollection.add(objProfessionInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objProfessionInfoCollection;
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
		if ("Businessdatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(ProfessionColumnNameEnum.Businessdatabaseid, isAsc);
		}

		//企业所属行业ID
		if ("Businesstypeid".equals(columnName) && isAsc == true)
		{
          return sort(ProfessionColumnNameEnum.Businesstypeid, isAsc);
		}

		//企业行业类型名称
		if ("Businesstypename".equals(columnName) && isAsc == true)
		{
          return sort(ProfessionColumnNameEnum.Businesstypename, isAsc);
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
	public boolean sort(ProfessionColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//数据库ID
		if (ProfessionColumnNameEnum.Businessdatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProfessionBusinessdatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (ProfessionColumnNameEnum.Businessdatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProfessionBusinessdatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//企业所属行业ID
		if (ProfessionColumnNameEnum.Businesstypeid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProfessionBusinesstypeidComparatorAsc());// 顺序
			return true;
		}
		if (ProfessionColumnNameEnum.Businesstypeid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProfessionBusinesstypeidComparatorDesc());// 倒叙
			return true;
		}

		//企业行业类型名称
		if (ProfessionColumnNameEnum.Businesstypename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProfessionBusinesstypenameComparatorAsc());// 顺序
			return true;
		}
		if (ProfessionColumnNameEnum.Businesstypename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProfessionBusinesstypenameComparatorDesc());// 倒叙
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
		for (ProfessionInfo objProfessionInfo : this)
		{
			objJSONArray.put(objProfessionInfo.toJson());
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
				ProfessionInfo objProfessionInfo = new ProfessionInfo();
				objProfessionInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objProfessionInfo);
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
	// [start] 按 Businessdatabaseid 数据库ID 正序排序
/**
 * 按 Businessdatabaseid 数据库ID 正序排序
 *
 */
class ProfessionBusinessdatabaseidComparatorAsc implements Comparator<ProfessionInfo>
{
	public int compare(ProfessionInfo arg0, ProfessionInfo arg1)
	{
		if (arg0.getBusinessdatabaseid() > arg1.getBusinessdatabaseid())
			return 1;
		else if (arg0.getBusinessdatabaseid() < arg1.getBusinessdatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Businessdatabaseid 数据库ID 倒叙排序
/**
 * 按 Businessdatabaseid 数据库ID 倒叙排序
 *
 */
class ProfessionBusinessdatabaseidComparatorDesc implements Comparator<ProfessionInfo>
{

	public int compare(ProfessionInfo arg0, ProfessionInfo arg1)
	{
		if (arg0.getBusinessdatabaseid() > arg1.getBusinessdatabaseid())
			return -1;
		else if (arg0.getBusinessdatabaseid() < arg1.getBusinessdatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Businesstypeid 企业所属行业ID 正序排序
/**
 * 按 Businesstypeid 企业所属行业ID 正序排序
 *
 */
class ProfessionBusinesstypeidComparatorAsc implements Comparator<ProfessionInfo>
{
	public int compare(ProfessionInfo arg0, ProfessionInfo arg1)
	{
		if (arg0.getBusinesstypeid() > arg1.getBusinesstypeid())
			return 1;
		else if (arg0.getBusinesstypeid() < arg1.getBusinesstypeid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Businesstypeid 企业所属行业ID 倒叙排序
/**
 * 按 Businesstypeid 企业所属行业ID 倒叙排序
 *
 */
class ProfessionBusinesstypeidComparatorDesc implements Comparator<ProfessionInfo>
{

	public int compare(ProfessionInfo arg0, ProfessionInfo arg1)
	{
		if (arg0.getBusinesstypeid() > arg1.getBusinesstypeid())
			return -1;
		else if (arg0.getBusinesstypeid() < arg1.getBusinesstypeid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Businesstypename 企业行业类型名称正序排序
/**
 * 按 Businesstypename 企业行业类型名称 正序排序
 *
 */
class ProfessionBusinesstypenameComparatorAsc implements Comparator<ProfessionInfo>
{
	public int compare(ProfessionInfo arg0, ProfessionInfo arg1)
	{
		return arg0.getBusinesstypename().toLowerCase().compareTo(arg1.getBusinesstypename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Businesstypename 企业行业类型名称 倒叙排序
/**
 * 按 Businesstypename 企业行业类型名称 倒叙排序
 *
 */
class ProfessionBusinesstypenameComparatorDesc implements Comparator<ProfessionInfo>
{

	public int compare(ProfessionInfo arg0, ProfessionInfo arg1)
	{
		return arg1.getBusinesstypename().toLowerCase().compareTo(arg0.getBusinesstypename().toLowerCase());
	}
}
	// [end]


	// [end]

