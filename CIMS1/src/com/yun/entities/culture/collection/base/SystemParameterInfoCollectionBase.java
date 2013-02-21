package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.SystemParameterInfoBase.*;

/**
 * SystemParameter 的摘要说明
 */
public class SystemParameterInfoCollectionBase extends ArrayList<SystemParameterInfo> implements List<SystemParameterInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311562410951L;

	// [start] 根据主键或自增字段返回SystemParameterInfo

        // [start] GetSystemParameterInfoByDatabaseid
        // [start] GetSystemParameterInfoByDatabaseid
        /**
        * 根据DatabaseID获取表 的对象SystemParameterInfo
        * @param Databaseid DatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemParameterInfo对象实体
        */
        public SystemParameterInfo GetSystemParameterInfoByDatabaseid(int Databaseid)
        {
              return GetSystemParameterInfoByDatabaseid(Databaseid,  true);
        }
        // [end]

        // [start] GetSystemParameterInfoByDatabaseid
        private int GetSystemParameterInfoByDatabaseid_Databaseid = 0;//DatabaseID
        private SystemParameterInfo GetSystemParameterInfoByDatabaseid_SystemParameterInfo;
        /**
        * 根据DatabaseID获取表 的对象SystemParameterInfo
        * @param Databaseid DatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemParameterInfo对象实体
        */
        public SystemParameterInfo GetSystemParameterInfoByDatabaseid(int Databaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetSystemParameterInfoByDatabaseid_SystemParameterInfo = null;
                if (GetSystemParameterInfoByDatabaseid_SystemParameterInfo == null || GetSystemParameterInfoByDatabaseid_Databaseid != Databaseid)
            {
            for (SystemParameterInfo objSystemParameterInfo : this)
            {
                if (objSystemParameterInfo.getDatabaseid() == Databaseid)
                {
                    GetSystemParameterInfoByDatabaseid_SystemParameterInfo = objSystemParameterInfo;
                    GetSystemParameterInfoByDatabaseid_Databaseid = Databaseid;//DatabaseID
                    return objSystemParameterInfo;
                }
            }
            return null;
            }
            else
            {
                return GetSystemParameterInfoByDatabaseid_SystemParameterInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabaseid
        /**
        * 根据DatabaseID获取表 的对象SystemParameterInfo 的位置
        * @param Databaseid DatabaseID 
        * @return SystemParameterInfo对象实体 的位置
        */
        public int GetIndexByDatabaseid(int Databaseid)
        {
             int index = 0;
            for (SystemParameterInfo objSystemParameterInfo : this)
            {
                if (objSystemParameterInfo.getDatabaseid() == Databaseid)
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

	// [start] 根据索引返回SystemParameterInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public SystemParameterInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new SystemParameterInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		SystemParameterInfoCollection list = new SystemParameterInfoCollection();
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
    public SystemParameterInfoCollection Copy()
    {
        SystemParameterInfoCollection list = new SystemParameterInfoCollection();
        for (SystemParameterInfo objSystemParameterInfo : this)
        {
            list.add(objSystemParameterInfo.Copy());
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
		sbStr.append("<ArrayOfSystemParameterInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (SystemParameterInfo objSystemParameterInfo : this)
		{
			sbStr.append("  <SystemParameterInfo>\n");
            //DatabaseID
			sbStr.append("    <Databaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemParameterInfo.getDatabaseid()));
			sbStr.append("</Databaseid>\n");
            //UnitName
			sbStr.append("    <Unitname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemParameterInfo.getUnitname()));
			sbStr.append("</Unitname>\n");
            //Dept
			sbStr.append("    <Dept>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemParameterInfo.getDept()));
			sbStr.append("</Dept>\n");
            //Address
			sbStr.append("    <Address>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemParameterInfo.getAddress()));
			sbStr.append("</Address>\n");
			sbStr.append("  </SystemParameterInfo>\n");
		}
		sbStr.append("</ArrayOfSystemParameterInfo>\n");
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
	// GetSystemParameterInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemParameterInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemParameterInfoCollection GetSystemParameterInfoCollectionFormFileName(String filename)
	{
		return GetSystemParameterInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemParameterInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemParameterInfoCollection GetSystemParameterInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemParameterInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetSystemParameterInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemParameterInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemParameterInfoCollection GetSystemParameterInfoCollectionFormXml(String xml)
	{
		return GetSystemParameterInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemParameterInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemParameterInfoCollection GetSystemParameterInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemParameterInfoCollection objSystemParameterInfoCollection = new SystemParameterInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("SystemParameterInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				SystemParameterInfo objSystemParameterInfo = new SystemParameterInfo();
				//DatabaseID
				if (foo.elementText("Databaseid") != null)
					objSystemParameterInfo.setDatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseid")));
				//UnitName
				if (foo.elementText("Unitname") != null)
					objSystemParameterInfo.setUnitname(com.colorwinglib.Converts.objToStr(foo.elementText("Unitname")));
				//Dept
				if (foo.elementText("Dept") != null)
					objSystemParameterInfo.setDept(com.colorwinglib.Converts.objToStr(foo.elementText("Dept")));
				//Address
				if (foo.elementText("Address") != null)
					objSystemParameterInfo.setAddress(com.colorwinglib.Converts.objToStr(foo.elementText("Address")));
				objSystemParameterInfoCollection.add(objSystemParameterInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemParameterInfoCollection;
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
		//DatabaseID
		if ("Databaseid".equals(columnName) && isAsc == true)
		{
          return sort(SystemParameterColumnNameEnum.Databaseid, isAsc);
		}

		//UnitName
		if ("Unitname".equals(columnName) && isAsc == true)
		{
          return sort(SystemParameterColumnNameEnum.Unitname, isAsc);
		}

		//Dept
		if ("Dept".equals(columnName) && isAsc == true)
		{
          return sort(SystemParameterColumnNameEnum.Dept, isAsc);
		}

		//Address
		if ("Address".equals(columnName) && isAsc == true)
		{
          return sort(SystemParameterColumnNameEnum.Address, isAsc);
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
	public boolean sort(SystemParameterColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//DatabaseID
		if (SystemParameterColumnNameEnum.Databaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemParameterDatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (SystemParameterColumnNameEnum.Databaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemParameterDatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//UnitName
		if (SystemParameterColumnNameEnum.Unitname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemParameterUnitnameComparatorAsc());// 顺序
			return true;
		}
		if (SystemParameterColumnNameEnum.Unitname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemParameterUnitnameComparatorDesc());// 倒叙
			return true;
		}

		//Dept
		if (SystemParameterColumnNameEnum.Dept.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemParameterDeptComparatorAsc());// 顺序
			return true;
		}
		if (SystemParameterColumnNameEnum.Dept.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemParameterDeptComparatorDesc());// 倒叙
			return true;
		}

		//Address
		if (SystemParameterColumnNameEnum.Address.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemParameterAddressComparatorAsc());// 顺序
			return true;
		}
		if (SystemParameterColumnNameEnum.Address.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemParameterAddressComparatorDesc());// 倒叙
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
		for (SystemParameterInfo objSystemParameterInfo : this)
		{
			objJSONArray.put(objSystemParameterInfo.toJson());
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
				SystemParameterInfo objSystemParameterInfo = new SystemParameterInfo();
				objSystemParameterInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objSystemParameterInfo);
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
	// [start] 按 Databaseid DatabaseID 正序排序
/**
 * 按 Databaseid DatabaseID 正序排序
 *
 */
class SystemParameterDatabaseidComparatorAsc implements Comparator<SystemParameterInfo>
{
	public int compare(SystemParameterInfo arg0, SystemParameterInfo arg1)
	{
		if (arg0.getDatabaseid() > arg1.getDatabaseid())
			return 1;
		else if (arg0.getDatabaseid() < arg1.getDatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databaseid DatabaseID 倒叙排序
/**
 * 按 Databaseid DatabaseID 倒叙排序
 *
 */
class SystemParameterDatabaseidComparatorDesc implements Comparator<SystemParameterInfo>
{

	public int compare(SystemParameterInfo arg0, SystemParameterInfo arg1)
	{
		if (arg0.getDatabaseid() > arg1.getDatabaseid())
			return -1;
		else if (arg0.getDatabaseid() < arg1.getDatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Unitname UnitName正序排序
/**
 * 按 Unitname UnitName 正序排序
 *
 */
class SystemParameterUnitnameComparatorAsc implements Comparator<SystemParameterInfo>
{
	public int compare(SystemParameterInfo arg0, SystemParameterInfo arg1)
	{
		return arg0.getUnitname().toLowerCase().compareTo(arg1.getUnitname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Unitname UnitName 倒叙排序
/**
 * 按 Unitname UnitName 倒叙排序
 *
 */
class SystemParameterUnitnameComparatorDesc implements Comparator<SystemParameterInfo>
{

	public int compare(SystemParameterInfo arg0, SystemParameterInfo arg1)
	{
		return arg1.getUnitname().toLowerCase().compareTo(arg0.getUnitname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Dept Dept正序排序
/**
 * 按 Dept Dept 正序排序
 *
 */
class SystemParameterDeptComparatorAsc implements Comparator<SystemParameterInfo>
{
	public int compare(SystemParameterInfo arg0, SystemParameterInfo arg1)
	{
		return arg0.getDept().toLowerCase().compareTo(arg1.getDept().toLowerCase());
	}
}
	// [end]

	// [start] 按 Dept Dept 倒叙排序
/**
 * 按 Dept Dept 倒叙排序
 *
 */
class SystemParameterDeptComparatorDesc implements Comparator<SystemParameterInfo>
{

	public int compare(SystemParameterInfo arg0, SystemParameterInfo arg1)
	{
		return arg1.getDept().toLowerCase().compareTo(arg0.getDept().toLowerCase());
	}
}
	// [end]


	// [start] 按 Address Address正序排序
/**
 * 按 Address Address 正序排序
 *
 */
class SystemParameterAddressComparatorAsc implements Comparator<SystemParameterInfo>
{
	public int compare(SystemParameterInfo arg0, SystemParameterInfo arg1)
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
class SystemParameterAddressComparatorDesc implements Comparator<SystemParameterInfo>
{

	public int compare(SystemParameterInfo arg0, SystemParameterInfo arg1)
	{
		return arg1.getAddress().toLowerCase().compareTo(arg0.getAddress().toLowerCase());
	}
}
	// [end]


	// [end]

