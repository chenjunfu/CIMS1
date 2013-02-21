package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.RegionsInfoBase.*;

/**
 * Regions 郑州市地区表的摘要说明
 */
public class RegionsInfoCollectionBase extends ArrayList<RegionsInfo> implements List<RegionsInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311545264034L;

	// [start] 根据主键或自增字段返回RegionsInfo

        // [start] GetRegionsInfoByRegiondatabaseid
        // [start] GetRegionsInfoByRegiondatabaseid
        /**
        * 根据RegiondatabaseID获取表 郑州市地区表的对象RegionsInfo
        * @param Regiondatabaseid RegiondatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return RegionsInfo对象实体
        */
        public RegionsInfo GetRegionsInfoByRegiondatabaseid(int Regiondatabaseid)
        {
              return GetRegionsInfoByRegiondatabaseid(Regiondatabaseid,  true);
        }
        // [end]

        // [start] GetRegionsInfoByRegiondatabaseid
        private int GetRegionsInfoByRegiondatabaseid_Regiondatabaseid = 0;//RegiondatabaseID
        private RegionsInfo GetRegionsInfoByRegiondatabaseid_RegionsInfo;
        /**
        * 根据RegiondatabaseID获取表 郑州市地区表的对象RegionsInfo
        * @param Regiondatabaseid RegiondatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return RegionsInfo对象实体
        */
        public RegionsInfo GetRegionsInfoByRegiondatabaseid(int Regiondatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetRegionsInfoByRegiondatabaseid_RegionsInfo = null;
                if (GetRegionsInfoByRegiondatabaseid_RegionsInfo == null || GetRegionsInfoByRegiondatabaseid_Regiondatabaseid != Regiondatabaseid)
            {
            for (RegionsInfo objRegionsInfo : this)
            {
                if (objRegionsInfo.getRegiondatabaseid() == Regiondatabaseid)
                {
                    GetRegionsInfoByRegiondatabaseid_RegionsInfo = objRegionsInfo;
                    GetRegionsInfoByRegiondatabaseid_Regiondatabaseid = Regiondatabaseid;//RegiondatabaseID
                    return objRegionsInfo;
                }
            }
            return null;
            }
            else
            {
                return GetRegionsInfoByRegiondatabaseid_RegionsInfo;
            }
        }
        // [end]

        // [start] GetIndexByRegiondatabaseid
        /**
        * 根据RegiondatabaseID获取表 郑州市地区表的对象RegionsInfo 的位置
        * @param Regiondatabaseid RegiondatabaseID 
        * @return RegionsInfo对象实体 的位置
        */
        public int GetIndexByRegiondatabaseid(int Regiondatabaseid)
        {
             int index = 0;
            for (RegionsInfo objRegionsInfo : this)
            {
                if (objRegionsInfo.getRegiondatabaseid() == Regiondatabaseid)
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

	// [start] 根据索引返回RegionsInfoCollection

        // [start] GetRegionsInfoCollectionByRegionid
        // [start] GetRegionsInfoCollectionByRegionid
        /**
        * 根据RegionID获取表 郑州市地区表的对象集合RegionsInfoCollection
        * @param Regionid 城市编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return RegionsInfoCollection对象集合
        */
        public RegionsInfoCollection GetRegionsInfoCollectionByRegionid(int Regionid)
        {
              return GetRegionsInfoCollectionByRegionid(Regionid,  true);
        }
        // [end]

        // [start] GetRegionsInfoCollectionByRegionid
        private int GetRegionsInfoCollectionByRegionid_Regionid = 0;//城市编号
        private RegionsInfoCollection GetRegionsInfoCollectionByRegionid_RegionsInfoCollection;
        /**
        * 根据RegionID获取表 郑州市地区表的对象集合RegionsInfoCollection
        * @param Regionid 城市编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return RegionsInfoCollection对象集合
        */
        public RegionsInfoCollection GetRegionsInfoCollectionByRegionid(int Regionid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetRegionsInfoCollectionByRegionid_RegionsInfoCollection = null;
                if (GetRegionsInfoCollectionByRegionid_RegionsInfoCollection == null || GetRegionsInfoCollectionByRegionid_Regionid != Regionid)
            {
            RegionsInfoCollection list = new RegionsInfoCollection();
            for (RegionsInfo objRegionsInfo : this)
            {
                if (objRegionsInfo.getRegionid() == Regionid)
                {
                    list.add(objRegionsInfo);
                }
            }
            GetRegionsInfoCollectionByRegionid_RegionsInfoCollection = list;
            GetRegionsInfoCollectionByRegionid_Regionid = Regionid;//城市编号
            return list;
            }
            else
            {
                return GetRegionsInfoCollectionByRegionid_RegionsInfoCollection;
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
	public RegionsInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new RegionsInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		RegionsInfoCollection list = new RegionsInfoCollection();
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
    public RegionsInfoCollection Copy()
    {
        RegionsInfoCollection list = new RegionsInfoCollection();
        for (RegionsInfo objRegionsInfo : this)
        {
            list.add(objRegionsInfo.Copy());
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
		sbStr.append("<ArrayOfRegionsInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (RegionsInfo objRegionsInfo : this)
		{
			sbStr.append("  <RegionsInfo>\n");
            //RegiondatabaseID
			sbStr.append("    <Regiondatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objRegionsInfo.getRegiondatabaseid()));
			sbStr.append("</Regiondatabaseid>\n");
            //城市编号
			sbStr.append("    <Regionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objRegionsInfo.getRegionid()));
			sbStr.append("</Regionid>\n");
            //城市名称
			sbStr.append("    <Regionname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objRegionsInfo.getRegionname()));
			sbStr.append("</Regionname>\n");
            //上级城市编号
			sbStr.append("    <Partherregionsid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objRegionsInfo.getPartherregionsid()));
			sbStr.append("</Partherregionsid>\n");
            //深度
			sbStr.append("    <Depth>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objRegionsInfo.getDepth()));
			sbStr.append("</Depth>\n");
			sbStr.append("  </RegionsInfo>\n");
		}
		sbStr.append("</ArrayOfRegionsInfo>\n");
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
	// GetRegionsInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetRegionsInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static RegionsInfoCollection GetRegionsInfoCollectionFormFileName(String filename)
	{
		return GetRegionsInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetRegionsInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RegionsInfoCollection GetRegionsInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetRegionsInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetRegionsInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetRegionsInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RegionsInfoCollection GetRegionsInfoCollectionFormXml(String xml)
	{
		return GetRegionsInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetRegionsInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RegionsInfoCollection GetRegionsInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		RegionsInfoCollection objRegionsInfoCollection = new RegionsInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("RegionsInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				RegionsInfo objRegionsInfo = new RegionsInfo();
				//RegiondatabaseID
				if (foo.elementText("Regiondatabaseid") != null)
					objRegionsInfo.setRegiondatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Regiondatabaseid")));
				//城市编号
				if (foo.elementText("Regionid") != null)
					objRegionsInfo.setRegionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Regionid")));
				//城市名称
				if (foo.elementText("Regionname") != null)
					objRegionsInfo.setRegionname(com.colorwinglib.Converts.objToStr(foo.elementText("Regionname")));
				//上级城市编号
				if (foo.elementText("Partherregionsid") != null)
					objRegionsInfo.setPartherregionsid(com.colorwinglib.Converts.StrToInt(foo.elementText("Partherregionsid")));
				//深度
				if (foo.elementText("Depth") != null)
					objRegionsInfo.setDepth(com.colorwinglib.Converts.StrToInt(foo.elementText("Depth")));
				objRegionsInfoCollection.add(objRegionsInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objRegionsInfoCollection;
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
		//RegiondatabaseID
		if ("Regiondatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(RegionsColumnNameEnum.Regiondatabaseid, isAsc);
		}

		//城市编号
		if ("Regionid".equals(columnName) && isAsc == true)
		{
          return sort(RegionsColumnNameEnum.Regionid, isAsc);
		}

		//城市名称
		if ("Regionname".equals(columnName) && isAsc == true)
		{
          return sort(RegionsColumnNameEnum.Regionname, isAsc);
		}

		//上级城市编号
		if ("Partherregionsid".equals(columnName) && isAsc == true)
		{
          return sort(RegionsColumnNameEnum.Partherregionsid, isAsc);
		}

		//深度
		if ("Depth".equals(columnName) && isAsc == true)
		{
          return sort(RegionsColumnNameEnum.Depth, isAsc);
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
	public boolean sort(RegionsColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//RegiondatabaseID
		if (RegionsColumnNameEnum.Regiondatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new RegionsRegiondatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (RegionsColumnNameEnum.Regiondatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new RegionsRegiondatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//城市编号
		if (RegionsColumnNameEnum.Regionid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new RegionsRegionidComparatorAsc());// 顺序
			return true;
		}
		if (RegionsColumnNameEnum.Regionid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new RegionsRegionidComparatorDesc());// 倒叙
			return true;
		}

		//城市名称
		if (RegionsColumnNameEnum.Regionname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new RegionsRegionnameComparatorAsc());// 顺序
			return true;
		}
		if (RegionsColumnNameEnum.Regionname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new RegionsRegionnameComparatorDesc());// 倒叙
			return true;
		}

		//上级城市编号
		if (RegionsColumnNameEnum.Partherregionsid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new RegionsPartherregionsidComparatorAsc());// 顺序
			return true;
		}
		if (RegionsColumnNameEnum.Partherregionsid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new RegionsPartherregionsidComparatorDesc());// 倒叙
			return true;
		}

		//深度
		if (RegionsColumnNameEnum.Depth.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new RegionsDepthComparatorAsc());// 顺序
			return true;
		}
		if (RegionsColumnNameEnum.Depth.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new RegionsDepthComparatorDesc());// 倒叙
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
		for (RegionsInfo objRegionsInfo : this)
		{
			objJSONArray.put(objRegionsInfo.toJson());
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
				RegionsInfo objRegionsInfo = new RegionsInfo();
				objRegionsInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objRegionsInfo);
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
	// [start] 按 Regiondatabaseid RegiondatabaseID 正序排序
/**
 * 按 Regiondatabaseid RegiondatabaseID 正序排序
 *
 */
class RegionsRegiondatabaseidComparatorAsc implements Comparator<RegionsInfo>
{
	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		if (arg0.getRegiondatabaseid() > arg1.getRegiondatabaseid())
			return 1;
		else if (arg0.getRegiondatabaseid() < arg1.getRegiondatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Regiondatabaseid RegiondatabaseID 倒叙排序
/**
 * 按 Regiondatabaseid RegiondatabaseID 倒叙排序
 *
 */
class RegionsRegiondatabaseidComparatorDesc implements Comparator<RegionsInfo>
{

	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		if (arg0.getRegiondatabaseid() > arg1.getRegiondatabaseid())
			return -1;
		else if (arg0.getRegiondatabaseid() < arg1.getRegiondatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Regionid 城市编号 正序排序
/**
 * 按 Regionid 城市编号 正序排序
 *
 */
class RegionsRegionidComparatorAsc implements Comparator<RegionsInfo>
{
	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		if (arg0.getRegionid() > arg1.getRegionid())
			return 1;
		else if (arg0.getRegionid() < arg1.getRegionid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Regionid 城市编号 倒叙排序
/**
 * 按 Regionid 城市编号 倒叙排序
 *
 */
class RegionsRegionidComparatorDesc implements Comparator<RegionsInfo>
{

	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		if (arg0.getRegionid() > arg1.getRegionid())
			return -1;
		else if (arg0.getRegionid() < arg1.getRegionid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Regionname 城市名称正序排序
/**
 * 按 Regionname 城市名称 正序排序
 *
 */
class RegionsRegionnameComparatorAsc implements Comparator<RegionsInfo>
{
	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		return arg0.getRegionname().toLowerCase().compareTo(arg1.getRegionname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Regionname 城市名称 倒叙排序
/**
 * 按 Regionname 城市名称 倒叙排序
 *
 */
class RegionsRegionnameComparatorDesc implements Comparator<RegionsInfo>
{

	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		return arg1.getRegionname().toLowerCase().compareTo(arg0.getRegionname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Partherregionsid 上级城市编号 正序排序
/**
 * 按 Partherregionsid 上级城市编号 正序排序
 *
 */
class RegionsPartherregionsidComparatorAsc implements Comparator<RegionsInfo>
{
	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		if (arg0.getPartherregionsid() > arg1.getPartherregionsid())
			return 1;
		else if (arg0.getPartherregionsid() < arg1.getPartherregionsid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Partherregionsid 上级城市编号 倒叙排序
/**
 * 按 Partherregionsid 上级城市编号 倒叙排序
 *
 */
class RegionsPartherregionsidComparatorDesc implements Comparator<RegionsInfo>
{

	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		if (arg0.getPartherregionsid() > arg1.getPartherregionsid())
			return -1;
		else if (arg0.getPartherregionsid() < arg1.getPartherregionsid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Depth 深度 正序排序
/**
 * 按 Depth 深度 正序排序
 *
 */
class RegionsDepthComparatorAsc implements Comparator<RegionsInfo>
{
	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		if (arg0.getDepth() > arg1.getDepth())
			return 1;
		else if (arg0.getDepth() < arg1.getDepth())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Depth 深度 倒叙排序
/**
 * 按 Depth 深度 倒叙排序
 *
 */
class RegionsDepthComparatorDesc implements Comparator<RegionsInfo>
{

	public int compare(RegionsInfo arg0, RegionsInfo arg1)
	{
		if (arg0.getDepth() > arg1.getDepth())
			return -1;
		else if (arg0.getDepth() < arg1.getDepth())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [end]

