package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.SystemSectorInfoBase.*;

/**
 * SystemSector 部门表的摘要说明
 */
public class SystemSectorInfoCollectionBase extends ArrayList<SystemSectorInfo> implements List<SystemSectorInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311572790666L;

	// [start] 根据主键或自增字段返回SystemSectorInfo

        // [start] GetSystemSectorInfoBySectordatabaseid
        // [start] GetSystemSectorInfoBySectordatabaseid
        /**
        * 根据SectordatabaseID获取表 部门表的对象SystemSectorInfo
        * @param Sectordatabaseid 部门编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemSectorInfo对象实体
        */
        public SystemSectorInfo GetSystemSectorInfoBySectordatabaseid(int Sectordatabaseid)
        {
              return GetSystemSectorInfoBySectordatabaseid(Sectordatabaseid,  true);
        }
        // [end]

        // [start] GetSystemSectorInfoBySectordatabaseid
        private int GetSystemSectorInfoBySectordatabaseid_Sectordatabaseid = 0;//部门编号
        private SystemSectorInfo GetSystemSectorInfoBySectordatabaseid_SystemSectorInfo;
        /**
        * 根据SectordatabaseID获取表 部门表的对象SystemSectorInfo
        * @param Sectordatabaseid 部门编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemSectorInfo对象实体
        */
        public SystemSectorInfo GetSystemSectorInfoBySectordatabaseid(int Sectordatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetSystemSectorInfoBySectordatabaseid_SystemSectorInfo = null;
                if (GetSystemSectorInfoBySectordatabaseid_SystemSectorInfo == null || GetSystemSectorInfoBySectordatabaseid_Sectordatabaseid != Sectordatabaseid)
            {
            for (SystemSectorInfo objSystemSectorInfo : this)
            {
                if (objSystemSectorInfo.getSectordatabaseid() == Sectordatabaseid)
                {
                    GetSystemSectorInfoBySectordatabaseid_SystemSectorInfo = objSystemSectorInfo;
                    GetSystemSectorInfoBySectordatabaseid_Sectordatabaseid = Sectordatabaseid;//部门编号
                    return objSystemSectorInfo;
                }
            }
            return null;
            }
            else
            {
                return GetSystemSectorInfoBySectordatabaseid_SystemSectorInfo;
            }
        }
        // [end]

        // [start] GetIndexBySectordatabaseid
        /**
        * 根据SectordatabaseID获取表 部门表的对象SystemSectorInfo 的位置
        * @param Sectordatabaseid 部门编号 
        * @return SystemSectorInfo对象实体 的位置
        */
        public int GetIndexBySectordatabaseid(int Sectordatabaseid)
        {
             int index = 0;
            for (SystemSectorInfo objSystemSectorInfo : this)
            {
                if (objSystemSectorInfo.getSectordatabaseid() == Sectordatabaseid)
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

	// [start] 根据索引返回SystemSectorInfoCollection

        // [start] GetSystemSectorInfoCollectionBySectorid
        // [start] GetSystemSectorInfoCollectionBySectorid
        /**
        * 根据SectorID获取表 部门表的对象集合SystemSectorInfoCollection
        * @param Sectorid 部门编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemSectorInfoCollection对象集合
        */
        public SystemSectorInfoCollection GetSystemSectorInfoCollectionBySectorid(int Sectorid)
        {
              return GetSystemSectorInfoCollectionBySectorid(Sectorid,  true);
        }
        // [end]

        // [start] GetSystemSectorInfoCollectionBySectorid
        private int GetSystemSectorInfoCollectionBySectorid_Sectorid = 0;//部门编号
        private SystemSectorInfoCollection GetSystemSectorInfoCollectionBySectorid_SystemSectorInfoCollection;
        /**
        * 根据SectorID获取表 部门表的对象集合SystemSectorInfoCollection
        * @param Sectorid 部门编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemSectorInfoCollection对象集合
        */
        public SystemSectorInfoCollection GetSystemSectorInfoCollectionBySectorid(int Sectorid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetSystemSectorInfoCollectionBySectorid_SystemSectorInfoCollection = null;
                if (GetSystemSectorInfoCollectionBySectorid_SystemSectorInfoCollection == null || GetSystemSectorInfoCollectionBySectorid_Sectorid != Sectorid)
            {
            SystemSectorInfoCollection list = new SystemSectorInfoCollection();
            for (SystemSectorInfo objSystemSectorInfo : this)
            {
                if (objSystemSectorInfo.getSectorid() == Sectorid)
                {
                    list.add(objSystemSectorInfo);
                }
            }
            GetSystemSectorInfoCollectionBySectorid_SystemSectorInfoCollection = list;
            GetSystemSectorInfoCollectionBySectorid_Sectorid = Sectorid;//部门编号
            return list;
            }
            else
            {
                return GetSystemSectorInfoCollectionBySectorid_SystemSectorInfoCollection;
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
	public SystemSectorInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new SystemSectorInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		SystemSectorInfoCollection list = new SystemSectorInfoCollection();
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
    public SystemSectorInfoCollection Copy()
    {
        SystemSectorInfoCollection list = new SystemSectorInfoCollection();
        for (SystemSectorInfo objSystemSectorInfo : this)
        {
            list.add(objSystemSectorInfo.Copy());
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
		sbStr.append("<ArrayOfSystemSectorInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (SystemSectorInfo objSystemSectorInfo : this)
		{
			sbStr.append("  <SystemSectorInfo>\n");
            //部门编号
			sbStr.append("    <Sectordatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getSectordatabaseid()));
			sbStr.append("</Sectordatabaseid>\n");
            //部门编号
			sbStr.append("    <Sectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getSectorid()));
			sbStr.append("</Sectorid>\n");
            //部门名称
			sbStr.append("    <Sectorname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getSectorname()));
			sbStr.append("</Sectorname>\n");
            //部门描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getDescription()));
			sbStr.append("</Description>\n");
            //Address
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getAddress()));
			sbStr.append("</Address>\n");
            //Phone
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getPhone()));
			sbStr.append("</Phone>\n");
            //启用标志：1-启用、2-未启用
			sbStr.append("    <IsUse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getIsUse()));
			sbStr.append("</IsUse>\n");
            //是否删除：1-未删除、2-已删除
			sbStr.append("    <IsDel>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getIsDel()));
			sbStr.append("</IsDel>\n");
            //DatabaseUnitID
			sbStr.append("    <Databaseunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getDatabaseunitid()));
			sbStr.append("</Databaseunitid>\n");
            //排序
			sbStr.append("    <Sorts>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemSectorInfo.getSorts()));
			sbStr.append("</Sorts>\n");
			sbStr.append("  </SystemSectorInfo>\n");
		}
		sbStr.append("</ArrayOfSystemSectorInfo>\n");
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
	// GetSystemSectorInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemSectorInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemSectorInfoCollection GetSystemSectorInfoCollectionFormFileName(String filename)
	{
		return GetSystemSectorInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemSectorInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemSectorInfoCollection GetSystemSectorInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemSectorInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetSystemSectorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemSectorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemSectorInfoCollection GetSystemSectorInfoCollectionFormXml(String xml)
	{
		return GetSystemSectorInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemSectorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemSectorInfoCollection GetSystemSectorInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemSectorInfoCollection objSystemSectorInfoCollection = new SystemSectorInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("SystemSectorInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				SystemSectorInfo objSystemSectorInfo = new SystemSectorInfo();
				//部门编号
				if (foo.elementText("Sectordatabaseid") != null)
					objSystemSectorInfo.setSectordatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectordatabaseid")));
				//部门编号
				if (foo.elementText("Sectorid") != null)
					objSystemSectorInfo.setSectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Sectorid")));
				//部门名称
				if (foo.elementText("Sectorname") != null)
					objSystemSectorInfo.setSectorname(com.colorwinglib.Converts.objToStr(foo.elementText("Sectorname")));
				//部门描述
				if (foo.elementText("Description") != null)
					objSystemSectorInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//Address
				if (foo.elementText("Address") != null)
					objSystemSectorInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				//Phone
				if (foo.elementText("Phone") != null)
					objSystemSectorInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//启用标志：1-启用、2-未启用
				if (foo.elementText("IsUse") != null)
					objSystemSectorInfo.setIsUse(com.colorwinglib.Converts.StrToInt(foo.elementText("IsUse")));
				//是否删除：1-未删除、2-已删除
				if (foo.elementText("IsDel") != null)
					objSystemSectorInfo.setIsDel(com.colorwinglib.Converts.StrToInt(foo.elementText("IsDel")));
				//DatabaseUnitID
				if (foo.elementText("Databaseunitid") != null)
					objSystemSectorInfo.setDatabaseunitid(com.colorwinglib.Converts.objToStr(foo.elementText("Databaseunitid")));
				//排序
				if (foo.elementText("Sorts") != null)
					objSystemSectorInfo.setSorts(com.colorwinglib.Converts.StrToFloat(foo.elementText("Sorts")));
				objSystemSectorInfoCollection.add(objSystemSectorInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemSectorInfoCollection;
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
		//部门编号
		if ("Sectordatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.Sectordatabaseid, isAsc);
		}

		//部门编号
		if ("Sectorid".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.Sectorid, isAsc);
		}

		//部门名称
		if ("Sectorname".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.Sectorname, isAsc);
		}

		//部门描述
		if ("Description".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.Description, isAsc);
		}

		//Address
		if ("Address".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.Address, isAsc);
		}

		//Phone
		if ("Phone".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.Phone, isAsc);
		}

		//启用标志：1-启用、2-未启用
		if ("IsUse".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.IsUse, isAsc);
		}

		//是否删除：1-未删除、2-已删除
		if ("IsDel".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.IsDel, isAsc);
		}

		//DatabaseUnitID
		if ("Databaseunitid".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.Databaseunitid, isAsc);
		}

		//排序
		if ("Sorts".equals(columnName) && isAsc == true)
		{
          return sort(SystemSectorColumnNameEnum.Sorts, isAsc);
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
	public boolean sort(SystemSectorColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//部门编号
		if (SystemSectorColumnNameEnum.Sectordatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorSectordatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.Sectordatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorSectordatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//部门编号
		if (SystemSectorColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorSectoridComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.Sectorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorSectoridComparatorDesc());// 倒叙
			return true;
		}

		//部门名称
		if (SystemSectorColumnNameEnum.Sectorname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorSectornameComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.Sectorname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorSectornameComparatorDesc());// 倒叙
			return true;
		}

		//部门描述
		if (SystemSectorColumnNameEnum.Description.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorDescriptionComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.Description.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorDescriptionComparatorDesc());// 倒叙
			return true;
		}

		//Address
		if (SystemSectorColumnNameEnum.Address.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorAddressComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.Address.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorAddressComparatorDesc());// 倒叙
			return true;
		}

		//Phone
		if (SystemSectorColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorPhoneComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorPhoneComparatorDesc());// 倒叙
			return true;
		}

		//启用标志：1-启用、2-未启用
		if (SystemSectorColumnNameEnum.IsUse.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorIsUseComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.IsUse.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorIsUseComparatorDesc());// 倒叙
			return true;
		}

		//是否删除：1-未删除、2-已删除
		if (SystemSectorColumnNameEnum.IsDel.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorIsDelComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.IsDel.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorIsDelComparatorDesc());// 倒叙
			return true;
		}

		//DatabaseUnitID
		if (SystemSectorColumnNameEnum.Databaseunitid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorDatabaseunitidComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.Databaseunitid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorDatabaseunitidComparatorDesc());// 倒叙
			return true;
		}

		//排序
		if (SystemSectorColumnNameEnum.Sorts.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemSectorSortsComparatorAsc());// 顺序
			return true;
		}
		if (SystemSectorColumnNameEnum.Sorts.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemSectorSortsComparatorDesc());// 倒叙
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
		for (SystemSectorInfo objSystemSectorInfo : this)
		{
			objJSONArray.put(objSystemSectorInfo.toJson());
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
				SystemSectorInfo objSystemSectorInfo = new SystemSectorInfo();
				objSystemSectorInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objSystemSectorInfo);
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
	// [start] 按 Sectordatabaseid 部门编号 正序排序
/**
 * 按 Sectordatabaseid 部门编号 正序排序
 *
 */
class SystemSectorSectordatabaseidComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getSectordatabaseid() > arg1.getSectordatabaseid())
			return 1;
		else if (arg0.getSectordatabaseid() < arg1.getSectordatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Sectordatabaseid 部门编号 倒叙排序
/**
 * 按 Sectordatabaseid 部门编号 倒叙排序
 *
 */
class SystemSectorSectordatabaseidComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getSectordatabaseid() > arg1.getSectordatabaseid())
			return -1;
		else if (arg0.getSectordatabaseid() < arg1.getSectordatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Sectorid 部门编号 正序排序
/**
 * 按 Sectorid 部门编号 正序排序
 *
 */
class SystemSectorSectoridComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getSectorid() > arg1.getSectorid())
			return 1;
		else if (arg0.getSectorid() < arg1.getSectorid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Sectorid 部门编号 倒叙排序
/**
 * 按 Sectorid 部门编号 倒叙排序
 *
 */
class SystemSectorSectoridComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getSectorid() > arg1.getSectorid())
			return -1;
		else if (arg0.getSectorid() < arg1.getSectorid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Sectorname 部门名称正序排序
/**
 * 按 Sectorname 部门名称 正序排序
 *
 */
class SystemSectorSectornameComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg0.getSectorname().toLowerCase().compareTo(arg1.getSectorname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Sectorname 部门名称 倒叙排序
/**
 * 按 Sectorname 部门名称 倒叙排序
 *
 */
class SystemSectorSectornameComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg1.getSectorname().toLowerCase().compareTo(arg0.getSectorname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Description 部门描述正序排序
/**
 * 按 Description 部门描述 正序排序
 *
 */
class SystemSectorDescriptionComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg0.getDescription().toLowerCase().compareTo(arg1.getDescription().toLowerCase());
	}
}
	// [end]

	// [start] 按 Description 部门描述 倒叙排序
/**
 * 按 Description 部门描述 倒叙排序
 *
 */
class SystemSectorDescriptionComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg1.getDescription().toLowerCase().compareTo(arg0.getDescription().toLowerCase());
	}
}
	// [end]


	// [start] 按 Address Address正序排序
/**
 * 按 Address Address 正序排序
 *
 */
class SystemSectorAddressComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg0.getAddress().toLowerCase().compareTo(arg1.getAddress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Address Address 倒叙排序
/**
 * 按 Address Address 倒叙排序
 *
 */
class SystemSectorAddressComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg1.getAddress().toLowerCase().compareTo(arg0.getAddress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Phone Phone正序排序
/**
 * 按 Phone Phone 正序排序
 *
 */
class SystemSectorPhoneComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg0.getPhone().toLowerCase().compareTo(arg1.getPhone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Phone Phone 倒叙排序
/**
 * 按 Phone Phone 倒叙排序
 *
 */
class SystemSectorPhoneComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg1.getPhone().toLowerCase().compareTo(arg0.getPhone().toLowerCase());
	}
}
	// [end]


	// [start] 按 IsUse 启用标志：1-启用、2-未启用 正序排序
/**
 * 按 IsUse 启用标志：1-启用、2-未启用 正序排序
 *
 */
class SystemSectorIsUseComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getIsUse() > arg1.getIsUse())
			return 1;
		else if (arg0.getIsUse() < arg1.getIsUse())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 IsUse 启用标志：1-启用、2-未启用 倒叙排序
/**
 * 按 IsUse 启用标志：1-启用、2-未启用 倒叙排序
 *
 */
class SystemSectorIsUseComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getIsUse() > arg1.getIsUse())
			return -1;
		else if (arg0.getIsUse() < arg1.getIsUse())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 IsDel 是否删除：1-未删除、2-已删除 正序排序
/**
 * 按 IsDel 是否删除：1-未删除、2-已删除 正序排序
 *
 */
class SystemSectorIsDelComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getIsDel() > arg1.getIsDel())
			return 1;
		else if (arg0.getIsDel() < arg1.getIsDel())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 IsDel 是否删除：1-未删除、2-已删除 倒叙排序
/**
 * 按 IsDel 是否删除：1-未删除、2-已删除 倒叙排序
 *
 */
class SystemSectorIsDelComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getIsDel() > arg1.getIsDel())
			return -1;
		else if (arg0.getIsDel() < arg1.getIsDel())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Databaseunitid DatabaseUnitID正序排序
/**
 * 按 Databaseunitid DatabaseUnitID 正序排序
 *
 */
class SystemSectorDatabaseunitidComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg0.getDatabaseunitid().toLowerCase().compareTo(arg1.getDatabaseunitid().toLowerCase());
	}
}
	// [end]

	// [start] 按 Databaseunitid DatabaseUnitID 倒叙排序
/**
 * 按 Databaseunitid DatabaseUnitID 倒叙排序
 *
 */
class SystemSectorDatabaseunitidComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		return arg1.getDatabaseunitid().toLowerCase().compareTo(arg0.getDatabaseunitid().toLowerCase());
	}
}
	// [end]


	// [start] 按 Sorts 排序 正序排序
/**
 * 按 Sorts 排序 正序排序
 *
 */
class SystemSectorSortsComparatorAsc implements Comparator<SystemSectorInfo>
{
	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getSorts() > arg1.getSorts())
			return 1;
		else if (arg0.getSorts() < arg1.getSorts())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Sorts 排序 倒叙排序
/**
 * 按 Sorts 排序 倒叙排序
 *
 */
class SystemSectorSortsComparatorDesc implements Comparator<SystemSectorInfo>
{

	public int compare(SystemSectorInfo arg0, SystemSectorInfo arg1)
	{
		if (arg0.getSorts() > arg1.getSorts())
			return -1;
		else if (arg0.getSorts() < arg1.getSorts())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [end]

