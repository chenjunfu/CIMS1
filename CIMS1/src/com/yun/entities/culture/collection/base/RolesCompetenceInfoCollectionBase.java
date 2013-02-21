package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.RolesCompetenceInfoBase.*;

/**
 * RolesCompetence 角色权限表的摘要说明
 */
public class RolesCompetenceInfoCollectionBase extends ArrayList<RolesCompetenceInfo> implements List<RolesCompetenceInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311550296888L;

	// [start] 根据主键或自增字段返回RolesCompetenceInfo

        // [start] GetRolesCompetenceInfoByDatabaserosecompetenceid
        // [start] GetRolesCompetenceInfoByDatabaserosecompetenceid
        /**
        * 根据DatabaseRoseCompetenceID获取表 角色权限表的对象RolesCompetenceInfo
        * @param Databaserosecompetenceid 角色权限ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return RolesCompetenceInfo对象实体
        */
        public RolesCompetenceInfo GetRolesCompetenceInfoByDatabaserosecompetenceid(int Databaserosecompetenceid)
        {
              return GetRolesCompetenceInfoByDatabaserosecompetenceid(Databaserosecompetenceid,  true);
        }
        // [end]

        // [start] GetRolesCompetenceInfoByDatabaserosecompetenceid
        private int GetRolesCompetenceInfoByDatabaserosecompetenceid_Databaserosecompetenceid = 0;//角色权限ID
        private RolesCompetenceInfo GetRolesCompetenceInfoByDatabaserosecompetenceid_RolesCompetenceInfo;
        /**
        * 根据DatabaseRoseCompetenceID获取表 角色权限表的对象RolesCompetenceInfo
        * @param Databaserosecompetenceid 角色权限ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return RolesCompetenceInfo对象实体
        */
        public RolesCompetenceInfo GetRolesCompetenceInfoByDatabaserosecompetenceid(int Databaserosecompetenceid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetRolesCompetenceInfoByDatabaserosecompetenceid_RolesCompetenceInfo = null;
                if (GetRolesCompetenceInfoByDatabaserosecompetenceid_RolesCompetenceInfo == null || GetRolesCompetenceInfoByDatabaserosecompetenceid_Databaserosecompetenceid != Databaserosecompetenceid)
            {
            for (RolesCompetenceInfo objRolesCompetenceInfo : this)
            {
                if (objRolesCompetenceInfo.getDatabaserosecompetenceid() == Databaserosecompetenceid)
                {
                    GetRolesCompetenceInfoByDatabaserosecompetenceid_RolesCompetenceInfo = objRolesCompetenceInfo;
                    GetRolesCompetenceInfoByDatabaserosecompetenceid_Databaserosecompetenceid = Databaserosecompetenceid;//角色权限ID
                    return objRolesCompetenceInfo;
                }
            }
            return null;
            }
            else
            {
                return GetRolesCompetenceInfoByDatabaserosecompetenceid_RolesCompetenceInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabaserosecompetenceid
        /**
        * 根据DatabaseRoseCompetenceID获取表 角色权限表的对象RolesCompetenceInfo 的位置
        * @param Databaserosecompetenceid 角色权限ID 
        * @return RolesCompetenceInfo对象实体 的位置
        */
        public int GetIndexByDatabaserosecompetenceid(int Databaserosecompetenceid)
        {
             int index = 0;
            for (RolesCompetenceInfo objRolesCompetenceInfo : this)
            {
                if (objRolesCompetenceInfo.getDatabaserosecompetenceid() == Databaserosecompetenceid)
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

	// [start] 根据索引返回RolesCompetenceInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public RolesCompetenceInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new RolesCompetenceInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		RolesCompetenceInfoCollection list = new RolesCompetenceInfoCollection();
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
    public RolesCompetenceInfoCollection Copy()
    {
        RolesCompetenceInfoCollection list = new RolesCompetenceInfoCollection();
        for (RolesCompetenceInfo objRolesCompetenceInfo : this)
        {
            list.add(objRolesCompetenceInfo.Copy());
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
		sbStr.append("<ArrayOfRolesCompetenceInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (RolesCompetenceInfo objRolesCompetenceInfo : this)
		{
			sbStr.append("  <RolesCompetenceInfo>\n");
            //角色权限ID
			sbStr.append("    <Databaserosecompetenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objRolesCompetenceInfo.getDatabaserosecompetenceid()));
			sbStr.append("</Databaserosecompetenceid>\n");
            //角色ID
			sbStr.append("    <Rolesid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objRolesCompetenceInfo.getRolesid()));
			sbStr.append("</Rolesid>\n");
            //权限编号
			sbStr.append("    <Competenceid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objRolesCompetenceInfo.getCompetenceid()));
			sbStr.append("</Competenceid>\n");
			sbStr.append("  </RolesCompetenceInfo>\n");
		}
		sbStr.append("</ArrayOfRolesCompetenceInfo>\n");
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
	// GetRolesCompetenceInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetRolesCompetenceInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static RolesCompetenceInfoCollection GetRolesCompetenceInfoCollectionFormFileName(String filename)
	{
		return GetRolesCompetenceInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetRolesCompetenceInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RolesCompetenceInfoCollection GetRolesCompetenceInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetRolesCompetenceInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetRolesCompetenceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetRolesCompetenceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RolesCompetenceInfoCollection GetRolesCompetenceInfoCollectionFormXml(String xml)
	{
		return GetRolesCompetenceInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetRolesCompetenceInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static RolesCompetenceInfoCollection GetRolesCompetenceInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		RolesCompetenceInfoCollection objRolesCompetenceInfoCollection = new RolesCompetenceInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("RolesCompetenceInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				RolesCompetenceInfo objRolesCompetenceInfo = new RolesCompetenceInfo();
				//角色权限ID
				if (foo.elementText("Databaserosecompetenceid") != null)
					objRolesCompetenceInfo.setDatabaserosecompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaserosecompetenceid")));
				//角色ID
				if (foo.elementText("Rolesid") != null)
					objRolesCompetenceInfo.setRolesid(com.colorwinglib.Converts.StrToInt(foo.elementText("Rolesid")));
				//权限编号
				if (foo.elementText("Competenceid") != null)
					objRolesCompetenceInfo.setCompetenceid(com.colorwinglib.Converts.StrToInt(foo.elementText("Competenceid")));
				objRolesCompetenceInfoCollection.add(objRolesCompetenceInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objRolesCompetenceInfoCollection;
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
		//角色权限ID
		if ("Databaserosecompetenceid".equals(columnName) && isAsc == true)
		{
          return sort(RolesCompetenceColumnNameEnum.Databaserosecompetenceid, isAsc);
		}

		//角色ID
		if ("Rolesid".equals(columnName) && isAsc == true)
		{
          return sort(RolesCompetenceColumnNameEnum.Rolesid, isAsc);
		}

		//权限编号
		if ("Competenceid".equals(columnName) && isAsc == true)
		{
          return sort(RolesCompetenceColumnNameEnum.Competenceid, isAsc);
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
	public boolean sort(RolesCompetenceColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//角色权限ID
		if (RolesCompetenceColumnNameEnum.Databaserosecompetenceid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new RolesCompetenceDatabaserosecompetenceidComparatorAsc());// 顺序
			return true;
		}
		if (RolesCompetenceColumnNameEnum.Databaserosecompetenceid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new RolesCompetenceDatabaserosecompetenceidComparatorDesc());// 倒叙
			return true;
		}

		//角色ID
		if (RolesCompetenceColumnNameEnum.Rolesid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new RolesCompetenceRolesidComparatorAsc());// 顺序
			return true;
		}
		if (RolesCompetenceColumnNameEnum.Rolesid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new RolesCompetenceRolesidComparatorDesc());// 倒叙
			return true;
		}

		//权限编号
		if (RolesCompetenceColumnNameEnum.Competenceid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new RolesCompetenceCompetenceidComparatorAsc());// 顺序
			return true;
		}
		if (RolesCompetenceColumnNameEnum.Competenceid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new RolesCompetenceCompetenceidComparatorDesc());// 倒叙
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
		for (RolesCompetenceInfo objRolesCompetenceInfo : this)
		{
			objJSONArray.put(objRolesCompetenceInfo.toJson());
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
				RolesCompetenceInfo objRolesCompetenceInfo = new RolesCompetenceInfo();
				objRolesCompetenceInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objRolesCompetenceInfo);
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
	// [start] 按 Databaserosecompetenceid 角色权限ID 正序排序
/**
 * 按 Databaserosecompetenceid 角色权限ID 正序排序
 *
 */
class RolesCompetenceDatabaserosecompetenceidComparatorAsc implements Comparator<RolesCompetenceInfo>
{
	public int compare(RolesCompetenceInfo arg0, RolesCompetenceInfo arg1)
	{
		if (arg0.getDatabaserosecompetenceid() > arg1.getDatabaserosecompetenceid())
			return 1;
		else if (arg0.getDatabaserosecompetenceid() < arg1.getDatabaserosecompetenceid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databaserosecompetenceid 角色权限ID 倒叙排序
/**
 * 按 Databaserosecompetenceid 角色权限ID 倒叙排序
 *
 */
class RolesCompetenceDatabaserosecompetenceidComparatorDesc implements Comparator<RolesCompetenceInfo>
{

	public int compare(RolesCompetenceInfo arg0, RolesCompetenceInfo arg1)
	{
		if (arg0.getDatabaserosecompetenceid() > arg1.getDatabaserosecompetenceid())
			return -1;
		else if (arg0.getDatabaserosecompetenceid() < arg1.getDatabaserosecompetenceid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Rolesid 角色ID 正序排序
/**
 * 按 Rolesid 角色ID 正序排序
 *
 */
class RolesCompetenceRolesidComparatorAsc implements Comparator<RolesCompetenceInfo>
{
	public int compare(RolesCompetenceInfo arg0, RolesCompetenceInfo arg1)
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

	// [start] 按 Rolesid 角色ID 倒叙排序
/**
 * 按 Rolesid 角色ID 倒叙排序
 *
 */
class RolesCompetenceRolesidComparatorDesc implements Comparator<RolesCompetenceInfo>
{

	public int compare(RolesCompetenceInfo arg0, RolesCompetenceInfo arg1)
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


	// [start] 按 Competenceid 权限编号 正序排序
/**
 * 按 Competenceid 权限编号 正序排序
 *
 */
class RolesCompetenceCompetenceidComparatorAsc implements Comparator<RolesCompetenceInfo>
{
	public int compare(RolesCompetenceInfo arg0, RolesCompetenceInfo arg1)
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
class RolesCompetenceCompetenceidComparatorDesc implements Comparator<RolesCompetenceInfo>
{

	public int compare(RolesCompetenceInfo arg0, RolesCompetenceInfo arg1)
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


	// [end]

