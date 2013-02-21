package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.NationInfoBase.*;

/**
 * Nation 民族表的摘要说明
 */
public class NationInfoCollectionBase extends ArrayList<NationInfo> implements List<NationInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311511273435L;

	// [start] 根据主键或自增字段返回NationInfo

        // [start] GetNationInfoByNationdatabaseid
        // [start] GetNationInfoByNationdatabaseid
        /**
        * 根据NationdatabaseID获取表 民族表的对象NationInfo
        * @param Nationdatabaseid NationdatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return NationInfo对象实体
        */
        public NationInfo GetNationInfoByNationdatabaseid(int Nationdatabaseid)
        {
              return GetNationInfoByNationdatabaseid(Nationdatabaseid,  true);
        }
        // [end]

        // [start] GetNationInfoByNationdatabaseid
        private int GetNationInfoByNationdatabaseid_Nationdatabaseid = 0;//NationdatabaseID
        private NationInfo GetNationInfoByNationdatabaseid_NationInfo;
        /**
        * 根据NationdatabaseID获取表 民族表的对象NationInfo
        * @param Nationdatabaseid NationdatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return NationInfo对象实体
        */
        public NationInfo GetNationInfoByNationdatabaseid(int Nationdatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetNationInfoByNationdatabaseid_NationInfo = null;
                if (GetNationInfoByNationdatabaseid_NationInfo == null || GetNationInfoByNationdatabaseid_Nationdatabaseid != Nationdatabaseid)
            {
            for (NationInfo objNationInfo : this)
            {
                if (objNationInfo.getNationdatabaseid() == Nationdatabaseid)
                {
                    GetNationInfoByNationdatabaseid_NationInfo = objNationInfo;
                    GetNationInfoByNationdatabaseid_Nationdatabaseid = Nationdatabaseid;//NationdatabaseID
                    return objNationInfo;
                }
            }
            return null;
            }
            else
            {
                return GetNationInfoByNationdatabaseid_NationInfo;
            }
        }
        // [end]

        // [start] GetIndexByNationdatabaseid
        /**
        * 根据NationdatabaseID获取表 民族表的对象NationInfo 的位置
        * @param Nationdatabaseid NationdatabaseID 
        * @return NationInfo对象实体 的位置
        */
        public int GetIndexByNationdatabaseid(int Nationdatabaseid)
        {
             int index = 0;
            for (NationInfo objNationInfo : this)
            {
                if (objNationInfo.getNationdatabaseid() == Nationdatabaseid)
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

	// [start] 根据索引返回NationInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public NationInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new NationInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		NationInfoCollection list = new NationInfoCollection();
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
    public NationInfoCollection Copy()
    {
        NationInfoCollection list = new NationInfoCollection();
        for (NationInfo objNationInfo : this)
        {
            list.add(objNationInfo.Copy());
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
		sbStr.append("<ArrayOfNationInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (NationInfo objNationInfo : this)
		{
			sbStr.append("  <NationInfo>\n");
            //NationdatabaseID
			sbStr.append("    <Nationdatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objNationInfo.getNationdatabaseid()));
			sbStr.append("</Nationdatabaseid>\n");
            //民族编号
			sbStr.append("    <Nationid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objNationInfo.getNationid()));
			sbStr.append("</Nationid>\n");
            //民族名称
			sbStr.append("    <Nationname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objNationInfo.getNationname()));
			sbStr.append("</Nationname>\n");
			sbStr.append("  </NationInfo>\n");
		}
		sbStr.append("</ArrayOfNationInfo>\n");
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
	// GetNationInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetNationInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static NationInfoCollection GetNationInfoCollectionFormFileName(String filename)
	{
		return GetNationInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetNationInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static NationInfoCollection GetNationInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetNationInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetNationInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetNationInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static NationInfoCollection GetNationInfoCollectionFormXml(String xml)
	{
		return GetNationInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetNationInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static NationInfoCollection GetNationInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		NationInfoCollection objNationInfoCollection = new NationInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("NationInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				NationInfo objNationInfo = new NationInfo();
				//NationdatabaseID
				if (foo.elementText("Nationdatabaseid") != null)
					objNationInfo.setNationdatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Nationdatabaseid")));
				//民族编号
				if (foo.elementText("Nationid") != null)
					objNationInfo.setNationid(com.colorwinglib.Converts.StrToInt(foo.elementText("Nationid")));
				//民族名称
				if (foo.elementText("Nationname") != null)
					objNationInfo.setNationname(com.colorwinglib.Converts.objToStr(foo.elementText("Nationname")));
				objNationInfoCollection.add(objNationInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objNationInfoCollection;
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
		//NationdatabaseID
		if ("Nationdatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(NationColumnNameEnum.Nationdatabaseid, isAsc);
		}

		//民族编号
		if ("Nationid".equals(columnName) && isAsc == true)
		{
          return sort(NationColumnNameEnum.Nationid, isAsc);
		}

		//民族名称
		if ("Nationname".equals(columnName) && isAsc == true)
		{
          return sort(NationColumnNameEnum.Nationname, isAsc);
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
	public boolean sort(NationColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//NationdatabaseID
		if (NationColumnNameEnum.Nationdatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new NationNationdatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (NationColumnNameEnum.Nationdatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new NationNationdatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//民族编号
		if (NationColumnNameEnum.Nationid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new NationNationidComparatorAsc());// 顺序
			return true;
		}
		if (NationColumnNameEnum.Nationid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new NationNationidComparatorDesc());// 倒叙
			return true;
		}

		//民族名称
		if (NationColumnNameEnum.Nationname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new NationNationnameComparatorAsc());// 顺序
			return true;
		}
		if (NationColumnNameEnum.Nationname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new NationNationnameComparatorDesc());// 倒叙
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
		for (NationInfo objNationInfo : this)
		{
			objJSONArray.put(objNationInfo.toJson());
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
				NationInfo objNationInfo = new NationInfo();
				objNationInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objNationInfo);
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
	// [start] 按 Nationdatabaseid NationdatabaseID 正序排序
/**
 * 按 Nationdatabaseid NationdatabaseID 正序排序
 *
 */
class NationNationdatabaseidComparatorAsc implements Comparator<NationInfo>
{
	public int compare(NationInfo arg0, NationInfo arg1)
	{
		if (arg0.getNationdatabaseid() > arg1.getNationdatabaseid())
			return 1;
		else if (arg0.getNationdatabaseid() < arg1.getNationdatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Nationdatabaseid NationdatabaseID 倒叙排序
/**
 * 按 Nationdatabaseid NationdatabaseID 倒叙排序
 *
 */
class NationNationdatabaseidComparatorDesc implements Comparator<NationInfo>
{

	public int compare(NationInfo arg0, NationInfo arg1)
	{
		if (arg0.getNationdatabaseid() > arg1.getNationdatabaseid())
			return -1;
		else if (arg0.getNationdatabaseid() < arg1.getNationdatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Nationid 民族编号 正序排序
/**
 * 按 Nationid 民族编号 正序排序
 *
 */
class NationNationidComparatorAsc implements Comparator<NationInfo>
{
	public int compare(NationInfo arg0, NationInfo arg1)
	{
		if (arg0.getNationid() > arg1.getNationid())
			return 1;
		else if (arg0.getNationid() < arg1.getNationid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Nationid 民族编号 倒叙排序
/**
 * 按 Nationid 民族编号 倒叙排序
 *
 */
class NationNationidComparatorDesc implements Comparator<NationInfo>
{

	public int compare(NationInfo arg0, NationInfo arg1)
	{
		if (arg0.getNationid() > arg1.getNationid())
			return -1;
		else if (arg0.getNationid() < arg1.getNationid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Nationname 民族名称正序排序
/**
 * 按 Nationname 民族名称 正序排序
 *
 */
class NationNationnameComparatorAsc implements Comparator<NationInfo>
{
	public int compare(NationInfo arg0, NationInfo arg1)
	{
		return arg0.getNationname().toLowerCase().compareTo(arg1.getNationname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Nationname 民族名称 倒叙排序
/**
 * 按 Nationname 民族名称 倒叙排序
 *
 */
class NationNationnameComparatorDesc implements Comparator<NationInfo>
{

	public int compare(NationInfo arg0, NationInfo arg1)
	{
		return arg1.getNationname().toLowerCase().compareTo(arg0.getNationname().toLowerCase());
	}
}
	// [end]


	// [end]

