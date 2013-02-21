package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.SystemCompetenceInfoBase.*;

/**
 * SystemCompetence 权限表的摘要说明
 */
public class SystemCompetenceInfoCollectionBase extends ArrayList<SystemCompetenceInfo> implements List<SystemCompetenceInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311561146811L;

	// [start] 根据主键或自增字段返回SystemCompetenceInfo

        // [start] GetSystemCompetenceInfoByDatabasecompetenceid
        // [start] GetSystemCompetenceInfoByDatabasecompetenceid
        /**
        * 根据DatabaseCompetenceID获取表 权限表的对象SystemCompetenceInfo
        * @param Databasecompetenceid 权限ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemCompetenceInfo对象实体
        */
        public SystemCompetenceInfo GetSystemCompetenceInfoByDatabasecompetenceid(int Databasecompetenceid)
        {
              return GetSystemCompetenceInfoByDatabasecompetenceid(Databasecompetenceid,  true);
        }
        // [end]

        // [start] GetSystemCompetenceInfoByDatabasecompetenceid
        private int GetSystemCompetenceInfoByDatabasecompetenceid_Databasecompetenceid = 0;//权限ID
        private SystemCompetenceInfo GetSystemCompetenceInfoByDatabasecompetenceid_SystemCompetenceInfo;
        /**
        * 根据DatabaseCompetenceID获取表 权限表的对象SystemCompetenceInfo
        * @param Databasecompetenceid 权限ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemCompetenceInfo对象实体
        */
        public SystemCompetenceInfo GetSystemCompetenceInfoByDatabasecompetenceid(int Databasecompetenceid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetSystemCompetenceInfoByDatabasecompetenceid_SystemCompetenceInfo = null;
                if (GetSystemCompetenceInfoByDatabasecompetenceid_SystemCompetenceInfo == null || GetSystemCompetenceInfoByDatabasecompetenceid_Databasecompetenceid != Databasecompetenceid)
            {
            for (SystemCompetenceInfo objSystemCompetenceInfo : this)
            {
                if (objSystemCompetenceInfo.getDatabasecompetenceid() == Databasecompetenceid)
                {
                    GetSystemCompetenceInfoByDatabasecompetenceid_SystemCompetenceInfo = objSystemCompetenceInfo;
                    GetSystemCompetenceInfoByDatabasecompetenceid_Databasecompetenceid = Databasecompetenceid;//权限ID
                    return objSystemCompetenceInfo;
                }
            }
            return null;
            }
            else
            {
                return GetSystemCompetenceInfoByDatabasecompetenceid_SystemCompetenceInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabasecompetenceid
        /**
        * 根据DatabaseCompetenceID获取表 权限表的对象SystemCompetenceInfo 的位置
        * @param Databasecompetenceid 权限ID 
        * @return SystemCompetenceInfo对象实体 的位置
        */
        public int GetIndexByDatabasecompetenceid(int Databasecompetenceid)
        {
             int index = 0;
            for (SystemCompetenceInfo objSystemCompetenceInfo : this)
            {
                if (objSystemCompetenceInfo.getDatabasecompetenceid() == Databasecompetenceid)
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

	// [start] 根据索引返回SystemCompetenceInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public SystemCompetenceInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new SystemCompetenceInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		SystemCompetenceInfoCollection list = new SystemCompetenceInfoCollection();
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
    public SystemCompetenceInfoCollection Copy()
    {
        SystemCompetenceInfoCollection list = new SystemCompetenceInfoCollection();
        for (SystemCompetenceInfo objSystemCompetenceInfo : this)
        {
            list.add(objSystemCompetenceInfo.Copy());
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
		sbStr.append("<ArrayOfSystemCompetenceInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (SystemCompetenceInfo objSystemCompetenceInfo : this)
		{
			sbStr.append("  <SystemCompetenceInfo>\n");
            //权限ID
			sbStr.append("    <Databasecompetenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemCompetenceInfo.getDatabasecompetenceid()));
			sbStr.append("</Databasecompetenceid>\n");
            //权限编号
			sbStr.append("    <Competenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemCompetenceInfo.getCompetenceid()));
			sbStr.append("</Competenceid>\n");
            //权限名称
			sbStr.append("    <Competencename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemCompetenceInfo.getCompetencename()));
			sbStr.append("</Competencename>\n");
            //权限描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemCompetenceInfo.getDescription()));
			sbStr.append("</Description>\n");
            //启用标志：1-启用、2-未启用
			sbStr.append("    <IsUse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemCompetenceInfo.getIsUse()));
			sbStr.append("</IsUse>\n");
			sbStr.append("  </SystemCompetenceInfo>\n");
		}
		sbStr.append("</ArrayOfSystemCompetenceInfo>\n");
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
	// GetSystemCompetenceInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemCompetenceInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemCompetenceInfoCollection GetSystemCompetenceInfoCollectionFormFileName(String filename)
	{
		return GetSystemCompetenceInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemCompetenceInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemCompetenceInfoCollection GetSystemCompetenceInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemCompetenceInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetSystemCompetenceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemCompetenceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemCompetenceInfoCollection GetSystemCompetenceInfoCollectionFormXml(String xml)
	{
		return GetSystemCompetenceInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemCompetenceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemCompetenceInfoCollection GetSystemCompetenceInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemCompetenceInfoCollection objSystemCompetenceInfoCollection = new SystemCompetenceInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("SystemCompetenceInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				SystemCompetenceInfo objSystemCompetenceInfo = new SystemCompetenceInfo();
				//权限ID
				if (foo.elementText("Databasecompetenceid") != null)
					objSystemCompetenceInfo.setDatabasecompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasecompetenceid")));
				//权限编号
				if (foo.elementText("Competenceid") != null)
					objSystemCompetenceInfo.setCompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Competenceid")));
				//权限名称
				if (foo.elementText("Competencename") != null)
					objSystemCompetenceInfo.setCompetencename(com.colorwinglib.Converts.objToStr(foo.elementText("Competencename")));
				//权限描述
				if (foo.elementText("Description") != null)
					objSystemCompetenceInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//启用标志：1-启用、2-未启用
				if (foo.elementText("IsUse") != null)
					objSystemCompetenceInfo.setIsUse(com.colorwinglib.Converts.StrToInt(foo.elementText("IsUse")));
				objSystemCompetenceInfoCollection.add(objSystemCompetenceInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemCompetenceInfoCollection;
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
		//权限ID
		if ("Databasecompetenceid".equals(columnName) && isAsc == true)
		{
          return sort(SystemCompetenceColumnNameEnum.Databasecompetenceid, isAsc);
		}

		//权限编号
		if ("Competenceid".equals(columnName) && isAsc == true)
		{
          return sort(SystemCompetenceColumnNameEnum.Competenceid, isAsc);
		}

		//权限名称
		if ("Competencename".equals(columnName) && isAsc == true)
		{
          return sort(SystemCompetenceColumnNameEnum.Competencename, isAsc);
		}

		//权限描述
		if ("Description".equals(columnName) && isAsc == true)
		{
          return sort(SystemCompetenceColumnNameEnum.Description, isAsc);
		}

		//启用标志：1-启用、2-未启用
		if ("IsUse".equals(columnName) && isAsc == true)
		{
          return sort(SystemCompetenceColumnNameEnum.IsUse, isAsc);
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
	public boolean sort(SystemCompetenceColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//权限ID
		if (SystemCompetenceColumnNameEnum.Databasecompetenceid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemCompetenceDatabasecompetenceidComparatorAsc());// 顺序
			return true;
		}
		if (SystemCompetenceColumnNameEnum.Databasecompetenceid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemCompetenceDatabasecompetenceidComparatorDesc());// 倒叙
			return true;
		}

		//权限编号
		if (SystemCompetenceColumnNameEnum.Competenceid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemCompetenceCompetenceidComparatorAsc());// 顺序
			return true;
		}
		if (SystemCompetenceColumnNameEnum.Competenceid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemCompetenceCompetenceidComparatorDesc());// 倒叙
			return true;
		}

		//权限名称
		if (SystemCompetenceColumnNameEnum.Competencename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemCompetenceCompetencenameComparatorAsc());// 顺序
			return true;
		}
		if (SystemCompetenceColumnNameEnum.Competencename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemCompetenceCompetencenameComparatorDesc());// 倒叙
			return true;
		}

		//权限描述
		if (SystemCompetenceColumnNameEnum.Description.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemCompetenceDescriptionComparatorAsc());// 顺序
			return true;
		}
		if (SystemCompetenceColumnNameEnum.Description.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemCompetenceDescriptionComparatorDesc());// 倒叙
			return true;
		}

		//启用标志：1-启用、2-未启用
		if (SystemCompetenceColumnNameEnum.IsUse.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemCompetenceIsUseComparatorAsc());// 顺序
			return true;
		}
		if (SystemCompetenceColumnNameEnum.IsUse.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemCompetenceIsUseComparatorDesc());// 倒叙
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
		for (SystemCompetenceInfo objSystemCompetenceInfo : this)
		{
			objJSONArray.put(objSystemCompetenceInfo.toJson());
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
				SystemCompetenceInfo objSystemCompetenceInfo = new SystemCompetenceInfo();
				objSystemCompetenceInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objSystemCompetenceInfo);
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
	// [start] 按 Databasecompetenceid 权限ID 正序排序
/**
 * 按 Databasecompetenceid 权限ID 正序排序
 *
 */
class SystemCompetenceDatabasecompetenceidComparatorAsc implements Comparator<SystemCompetenceInfo>
{
	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
	{
		if (arg0.getDatabasecompetenceid() > arg1.getDatabasecompetenceid())
			return 1;
		else if (arg0.getDatabasecompetenceid() < arg1.getDatabasecompetenceid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databasecompetenceid 权限ID 倒叙排序
/**
 * 按 Databasecompetenceid 权限ID 倒叙排序
 *
 */
class SystemCompetenceDatabasecompetenceidComparatorDesc implements Comparator<SystemCompetenceInfo>
{

	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
	{
		if (arg0.getDatabasecompetenceid() > arg1.getDatabasecompetenceid())
			return -1;
		else if (arg0.getDatabasecompetenceid() < arg1.getDatabasecompetenceid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Competenceid 权限编号 正序排序
/**
 * 按 Competenceid 权限编号 正序排序
 *
 */
class SystemCompetenceCompetenceidComparatorAsc implements Comparator<SystemCompetenceInfo>
{
	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
	{
		if (arg0.getCompetenceid() > arg1.getCompetenceid())
			return 1;
		else if (arg0.getCompetenceid() < arg1.getCompetenceid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Competenceid 权限编号 倒叙排序
/**
 * 按 Competenceid 权限编号 倒叙排序
 *
 */
class SystemCompetenceCompetenceidComparatorDesc implements Comparator<SystemCompetenceInfo>
{

	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
	{
		if (arg0.getCompetenceid() > arg1.getCompetenceid())
			return -1;
		else if (arg0.getCompetenceid() < arg1.getCompetenceid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Competencename 权限名称正序排序
/**
 * 按 Competencename 权限名称 正序排序
 *
 */
class SystemCompetenceCompetencenameComparatorAsc implements Comparator<SystemCompetenceInfo>
{
	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
	{
		return arg0.getCompetencename().toLowerCase().compareTo(arg1.getCompetencename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Competencename 权限名称 倒叙排序
/**
 * 按 Competencename 权限名称 倒叙排序
 *
 */
class SystemCompetenceCompetencenameComparatorDesc implements Comparator<SystemCompetenceInfo>
{

	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
	{
		return arg1.getCompetencename().toLowerCase().compareTo(arg0.getCompetencename().toLowerCase());
	}
}
	// [end]


	// [start] 按 Description 权限描述正序排序
/**
 * 按 Description 权限描述 正序排序
 *
 */
class SystemCompetenceDescriptionComparatorAsc implements Comparator<SystemCompetenceInfo>
{
	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
	{
		return arg0.getDescription().toLowerCase().compareTo(arg1.getDescription().toLowerCase());
	}
}
	// [end]

	// [start] 按 Description 权限描述 倒叙排序
/**
 * 按 Description 权限描述 倒叙排序
 *
 */
class SystemCompetenceDescriptionComparatorDesc implements Comparator<SystemCompetenceInfo>
{

	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
	{
		return arg1.getDescription().toLowerCase().compareTo(arg0.getDescription().toLowerCase());
	}
}
	// [end]


	// [start] 按 IsUse 启用标志：1-启用、2-未启用 正序排序
/**
 * 按 IsUse 启用标志：1-启用、2-未启用 正序排序
 *
 */
class SystemCompetenceIsUseComparatorAsc implements Comparator<SystemCompetenceInfo>
{
	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
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
class SystemCompetenceIsUseComparatorDesc implements Comparator<SystemCompetenceInfo>
{

	public int compare(SystemCompetenceInfo arg0, SystemCompetenceInfo arg1)
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


	// [end]

