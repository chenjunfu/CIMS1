package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.SystemRolesInfoBase.*;

/**
 * SystemRoles 角色表的摘要说明
 */
public class SystemRolesInfoCollectionBase extends ArrayList<SystemRolesInfo> implements List<SystemRolesInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311564501582L;

	// [start] 根据主键或自增字段返回SystemRolesInfo

        // [start] GetSystemRolesInfoByRolesid
        // [start] GetSystemRolesInfoByRolesid
        /**
        * 根据RolesID获取表 角色表的对象SystemRolesInfo
        * @param Rolesid 角色编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemRolesInfo对象实体
        */
        public SystemRolesInfo GetSystemRolesInfoByRolesid(int Rolesid)
        {
              return GetSystemRolesInfoByRolesid(Rolesid,  true);
        }
        // [end]

        // [start] GetSystemRolesInfoByRolesid
        private int GetSystemRolesInfoByRolesid_Rolesid = 0;//角色编号
        private SystemRolesInfo GetSystemRolesInfoByRolesid_SystemRolesInfo;
        /**
        * 根据RolesID获取表 角色表的对象SystemRolesInfo
        * @param Rolesid 角色编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return SystemRolesInfo对象实体
        */
        public SystemRolesInfo GetSystemRolesInfoByRolesid(int Rolesid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetSystemRolesInfoByRolesid_SystemRolesInfo = null;
                if (GetSystemRolesInfoByRolesid_SystemRolesInfo == null || GetSystemRolesInfoByRolesid_Rolesid != Rolesid)
            {
            for (SystemRolesInfo objSystemRolesInfo : this)
            {
                if (objSystemRolesInfo.getRolesid() == Rolesid)
                {
                    GetSystemRolesInfoByRolesid_SystemRolesInfo = objSystemRolesInfo;
                    GetSystemRolesInfoByRolesid_Rolesid = Rolesid;//角色编号
                    return objSystemRolesInfo;
                }
            }
            return null;
            }
            else
            {
                return GetSystemRolesInfoByRolesid_SystemRolesInfo;
            }
        }
        // [end]

        // [start] GetIndexByRolesid
        /**
        * 根据RolesID获取表 角色表的对象SystemRolesInfo 的位置
        * @param Rolesid 角色编号 
        * @return SystemRolesInfo对象实体 的位置
        */
        public int GetIndexByRolesid(int Rolesid)
        {
             int index = 0;
            for (SystemRolesInfo objSystemRolesInfo : this)
            {
                if (objSystemRolesInfo.getRolesid() == Rolesid)
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

	// [start] 根据索引返回SystemRolesInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public SystemRolesInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new SystemRolesInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		SystemRolesInfoCollection list = new SystemRolesInfoCollection();
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
    public SystemRolesInfoCollection Copy()
    {
        SystemRolesInfoCollection list = new SystemRolesInfoCollection();
        for (SystemRolesInfo objSystemRolesInfo : this)
        {
            list.add(objSystemRolesInfo.Copy());
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
		sbStr.append("<ArrayOfSystemRolesInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (SystemRolesInfo objSystemRolesInfo : this)
		{
			sbStr.append("  <SystemRolesInfo>\n");
            //角色编号
			sbStr.append("    <Rolesid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemRolesInfo.getRolesid()));
			sbStr.append("</Rolesid>\n");
            //角色名称
			sbStr.append("    <Rolesname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemRolesInfo.getRolesname()));
			sbStr.append("</Rolesname>\n");
            //描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemRolesInfo.getDescription()));
			sbStr.append("</Description>\n");
            //启用标志：1-启用、2-未启用
			sbStr.append("    <IsUse>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemRolesInfo.getIsUse()));
			sbStr.append("</IsUse>\n");
            //权限编号
			sbStr.append("    <Competenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objSystemRolesInfo.getCompetenceid()));
			sbStr.append("</Competenceid>\n");
			sbStr.append("  </SystemRolesInfo>\n");
		}
		sbStr.append("</ArrayOfSystemRolesInfo>\n");
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
	// GetSystemRolesInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetSystemRolesInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static SystemRolesInfoCollection GetSystemRolesInfoCollectionFormFileName(String filename)
	{
		return GetSystemRolesInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemRolesInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemRolesInfoCollection GetSystemRolesInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetSystemRolesInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetSystemRolesInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetSystemRolesInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemRolesInfoCollection GetSystemRolesInfoCollectionFormXml(String xml)
	{
		return GetSystemRolesInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetSystemRolesInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static SystemRolesInfoCollection GetSystemRolesInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		SystemRolesInfoCollection objSystemRolesInfoCollection = new SystemRolesInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("SystemRolesInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				SystemRolesInfo objSystemRolesInfo = new SystemRolesInfo();
				//角色编号
				if (foo.elementText("Rolesid") != null)
					objSystemRolesInfo.setRolesid(com.colorwinglib.Converts.StrToInt(foo.elementText("Rolesid")));
				//角色名称
				if (foo.elementText("Rolesname") != null)
					objSystemRolesInfo.setRolesname(com.colorwinglib.Converts.objToStr(foo.elementText("Rolesname")));
				//描述
				if (foo.elementText("Description") != null)
					objSystemRolesInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//启用标志：1-启用、2-未启用
				if (foo.elementText("IsUse") != null)
					objSystemRolesInfo.setIsUse(com.colorwinglib.Converts.StrToInt(foo.elementText("IsUse")));
				//权限编号
				if (foo.elementText("Competenceid") != null)
					objSystemRolesInfo.setCompetenceid(com.colorwinglib.Converts.objToStr(foo.elementText("Competenceid")));
				objSystemRolesInfoCollection.add(objSystemRolesInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objSystemRolesInfoCollection;
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
		//角色编号
		if ("Rolesid".equals(columnName) && isAsc == true)
		{
          return sort(SystemRolesColumnNameEnum.Rolesid, isAsc);
		}

		//角色名称
		if ("Rolesname".equals(columnName) && isAsc == true)
		{
          return sort(SystemRolesColumnNameEnum.Rolesname, isAsc);
		}

		//描述
		if ("Description".equals(columnName) && isAsc == true)
		{
          return sort(SystemRolesColumnNameEnum.Description, isAsc);
		}

		//启用标志：1-启用、2-未启用
		if ("IsUse".equals(columnName) && isAsc == true)
		{
          return sort(SystemRolesColumnNameEnum.IsUse, isAsc);
		}

		//权限编号
		if ("Competenceid".equals(columnName) && isAsc == true)
		{
          return sort(SystemRolesColumnNameEnum.Competenceid, isAsc);
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
	public boolean sort(SystemRolesColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//角色编号
		if (SystemRolesColumnNameEnum.Rolesid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemRolesRolesidComparatorAsc());// 顺序
			return true;
		}
		if (SystemRolesColumnNameEnum.Rolesid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemRolesRolesidComparatorDesc());// 倒叙
			return true;
		}

		//角色名称
		if (SystemRolesColumnNameEnum.Rolesname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemRolesRolesnameComparatorAsc());// 顺序
			return true;
		}
		if (SystemRolesColumnNameEnum.Rolesname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemRolesRolesnameComparatorDesc());// 倒叙
			return true;
		}

		//描述
		if (SystemRolesColumnNameEnum.Description.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemRolesDescriptionComparatorAsc());// 顺序
			return true;
		}
		if (SystemRolesColumnNameEnum.Description.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemRolesDescriptionComparatorDesc());// 倒叙
			return true;
		}

		//启用标志：1-启用、2-未启用
		if (SystemRolesColumnNameEnum.IsUse.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemRolesIsUseComparatorAsc());// 顺序
			return true;
		}
		if (SystemRolesColumnNameEnum.IsUse.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemRolesIsUseComparatorDesc());// 倒叙
			return true;
		}

		//权限编号
		if (SystemRolesColumnNameEnum.Competenceid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new SystemRolesCompetenceidComparatorAsc());// 顺序
			return true;
		}
		if (SystemRolesColumnNameEnum.Competenceid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new SystemRolesCompetenceidComparatorDesc());// 倒叙
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
		for (SystemRolesInfo objSystemRolesInfo : this)
		{
			objJSONArray.put(objSystemRolesInfo.toJson());
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
				SystemRolesInfo objSystemRolesInfo = new SystemRolesInfo();
				objSystemRolesInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objSystemRolesInfo);
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
	// [start] 按 Rolesid 角色编号 正序排序
/**
 * 按 Rolesid 角色编号 正序排序
 *
 */
class SystemRolesRolesidComparatorAsc implements Comparator<SystemRolesInfo>
{
	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
	{
		if (arg0.getRolesid() > arg1.getRolesid())
			return 1;
		else if (arg0.getRolesid() < arg1.getRolesid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Rolesid 角色编号 倒叙排序
/**
 * 按 Rolesid 角色编号 倒叙排序
 *
 */
class SystemRolesRolesidComparatorDesc implements Comparator<SystemRolesInfo>
{

	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
	{
		if (arg0.getRolesid() > arg1.getRolesid())
			return -1;
		else if (arg0.getRolesid() < arg1.getRolesid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Rolesname 角色名称正序排序
/**
 * 按 Rolesname 角色名称 正序排序
 *
 */
class SystemRolesRolesnameComparatorAsc implements Comparator<SystemRolesInfo>
{
	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
	{
		return arg0.getRolesname().toLowerCase().compareTo(arg1.getRolesname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Rolesname 角色名称 倒叙排序
/**
 * 按 Rolesname 角色名称 倒叙排序
 *
 */
class SystemRolesRolesnameComparatorDesc implements Comparator<SystemRolesInfo>
{

	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
	{
		return arg1.getRolesname().toLowerCase().compareTo(arg0.getRolesname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Description 描述正序排序
/**
 * 按 Description 描述 正序排序
 *
 */
class SystemRolesDescriptionComparatorAsc implements Comparator<SystemRolesInfo>
{
	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
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
class SystemRolesDescriptionComparatorDesc implements Comparator<SystemRolesInfo>
{

	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
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
class SystemRolesIsUseComparatorAsc implements Comparator<SystemRolesInfo>
{
	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
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
class SystemRolesIsUseComparatorDesc implements Comparator<SystemRolesInfo>
{

	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
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


	// [start] 按 Competenceid 权限编号正序排序
/**
 * 按 Competenceid 权限编号 正序排序
 *
 */
class SystemRolesCompetenceidComparatorAsc implements Comparator<SystemRolesInfo>
{
	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
	{
		return arg0.getCompetenceid().toLowerCase().compareTo(arg1.getCompetenceid().toLowerCase());
	}
}
	// [end]

	// [start] 按 Competenceid 权限编号 倒叙排序
/**
 * 按 Competenceid 权限编号 倒叙排序
 *
 */
class SystemRolesCompetenceidComparatorDesc implements Comparator<SystemRolesInfo>
{

	public int compare(SystemRolesInfo arg0, SystemRolesInfo arg1)
	{
		return arg1.getCompetenceid().toLowerCase().compareTo(arg0.getCompetenceid().toLowerCase());
	}
}
	// [end]


	// [end]

