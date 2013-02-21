package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.ProjectQualityInfoBase.*;

/**
 * ProjectQuality 项目性质的摘要说明
 */
public class ProjectQualityInfoCollectionBase extends ArrayList<ProjectQualityInfo> implements List<ProjectQualityInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311534900063L;

	// [start] 根据主键或自增字段返回ProjectQualityInfo

        // [start] GetProjectQualityInfoByProqulidatabaseid
        // [start] GetProjectQualityInfoByProqulidatabaseid
        /**
        * 根据proqulidatabaseID获取表 项目性质的对象ProjectQualityInfo
        * @param Proqulidatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProjectQualityInfo对象实体
        */
        public ProjectQualityInfo GetProjectQualityInfoByProqulidatabaseid(int Proqulidatabaseid)
        {
              return GetProjectQualityInfoByProqulidatabaseid(Proqulidatabaseid,  true);
        }
        // [end]

        // [start] GetProjectQualityInfoByProqulidatabaseid
        private int GetProjectQualityInfoByProqulidatabaseid_Proqulidatabaseid = 0;//数据库ID
        private ProjectQualityInfo GetProjectQualityInfoByProqulidatabaseid_ProjectQualityInfo;
        /**
        * 根据proqulidatabaseID获取表 项目性质的对象ProjectQualityInfo
        * @param Proqulidatabaseid 数据库ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProjectQualityInfo对象实体
        */
        public ProjectQualityInfo GetProjectQualityInfoByProqulidatabaseid(int Proqulidatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetProjectQualityInfoByProqulidatabaseid_ProjectQualityInfo = null;
                if (GetProjectQualityInfoByProqulidatabaseid_ProjectQualityInfo == null || GetProjectQualityInfoByProqulidatabaseid_Proqulidatabaseid != Proqulidatabaseid)
            {
            for (ProjectQualityInfo objProjectQualityInfo : this)
            {
                if (objProjectQualityInfo.getProqulidatabaseid() == Proqulidatabaseid)
                {
                    GetProjectQualityInfoByProqulidatabaseid_ProjectQualityInfo = objProjectQualityInfo;
                    GetProjectQualityInfoByProqulidatabaseid_Proqulidatabaseid = Proqulidatabaseid;//数据库ID
                    return objProjectQualityInfo;
                }
            }
            return null;
            }
            else
            {
                return GetProjectQualityInfoByProqulidatabaseid_ProjectQualityInfo;
            }
        }
        // [end]

        // [start] GetIndexByProqulidatabaseid
        /**
        * 根据proqulidatabaseID获取表 项目性质的对象ProjectQualityInfo 的位置
        * @param Proqulidatabaseid 数据库ID 
        * @return ProjectQualityInfo对象实体 的位置
        */
        public int GetIndexByProqulidatabaseid(int Proqulidatabaseid)
        {
             int index = 0;
            for (ProjectQualityInfo objProjectQualityInfo : this)
            {
                if (objProjectQualityInfo.getProqulidatabaseid() == Proqulidatabaseid)
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

	// [start] 根据索引返回ProjectQualityInfoCollection

        // [start] GetProjectQualityInfoCollectionByProquliid
        // [start] GetProjectQualityInfoCollectionByProquliid
        /**
        * 根据proquliID获取表 项目性质的对象集合ProjectQualityInfoCollection
        * @param Proquliid 项目性质ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProjectQualityInfoCollection对象集合
        */
        public ProjectQualityInfoCollection GetProjectQualityInfoCollectionByProquliid(int Proquliid)
        {
              return GetProjectQualityInfoCollectionByProquliid(Proquliid,  true);
        }
        // [end]

        // [start] GetProjectQualityInfoCollectionByProquliid
        private int GetProjectQualityInfoCollectionByProquliid_Proquliid = 0;//项目性质ID
        private ProjectQualityInfoCollection GetProjectQualityInfoCollectionByProquliid_ProjectQualityInfoCollection;
        /**
        * 根据proquliID获取表 项目性质的对象集合ProjectQualityInfoCollection
        * @param Proquliid 项目性质ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProjectQualityInfoCollection对象集合
        */
        public ProjectQualityInfoCollection GetProjectQualityInfoCollectionByProquliid(int Proquliid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetProjectQualityInfoCollectionByProquliid_ProjectQualityInfoCollection = null;
                if (GetProjectQualityInfoCollectionByProquliid_ProjectQualityInfoCollection == null || GetProjectQualityInfoCollectionByProquliid_Proquliid != Proquliid)
            {
            ProjectQualityInfoCollection list = new ProjectQualityInfoCollection();
            for (ProjectQualityInfo objProjectQualityInfo : this)
            {
                if (objProjectQualityInfo.getProquliid() == Proquliid)
                {
                    list.add(objProjectQualityInfo);
                }
            }
            GetProjectQualityInfoCollectionByProquliid_ProjectQualityInfoCollection = list;
            GetProjectQualityInfoCollectionByProquliid_Proquliid = Proquliid;//项目性质ID
            return list;
            }
            else
            {
                return GetProjectQualityInfoCollectionByProquliid_ProjectQualityInfoCollection;
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
	public ProjectQualityInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new ProjectQualityInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		ProjectQualityInfoCollection list = new ProjectQualityInfoCollection();
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
    public ProjectQualityInfoCollection Copy()
    {
        ProjectQualityInfoCollection list = new ProjectQualityInfoCollection();
        for (ProjectQualityInfo objProjectQualityInfo : this)
        {
            list.add(objProjectQualityInfo.Copy());
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
		sbStr.append("<ArrayOfProjectQualityInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (ProjectQualityInfo objProjectQualityInfo : this)
		{
			sbStr.append("  <ProjectQualityInfo>\n");
            //数据库ID
			sbStr.append("    <Proqulidatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProjectQualityInfo.getProqulidatabaseid()));
			sbStr.append("</Proqulidatabaseid>\n");
            //项目性质ID
			sbStr.append("    <Proquliid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProjectQualityInfo.getProquliid()));
			sbStr.append("</Proquliid>\n");
            //项目性质Name
			sbStr.append("    <Proquliname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProjectQualityInfo.getProquliname()));
			sbStr.append("</Proquliname>\n");
			sbStr.append("  </ProjectQualityInfo>\n");
		}
		sbStr.append("</ArrayOfProjectQualityInfo>\n");
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
	// GetProjectQualityInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetProjectQualityInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ProjectQualityInfoCollection GetProjectQualityInfoCollectionFormFileName(String filename)
	{
		return GetProjectQualityInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProjectQualityInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectQualityInfoCollection GetProjectQualityInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetProjectQualityInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetProjectQualityInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetProjectQualityInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectQualityInfoCollection GetProjectQualityInfoCollectionFormXml(String xml)
	{
		return GetProjectQualityInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProjectQualityInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectQualityInfoCollection GetProjectQualityInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ProjectQualityInfoCollection objProjectQualityInfoCollection = new ProjectQualityInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("ProjectQualityInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				ProjectQualityInfo objProjectQualityInfo = new ProjectQualityInfo();
				//数据库ID
				if (foo.elementText("Proqulidatabaseid") != null)
					objProjectQualityInfo.setProqulidatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Proqulidatabaseid")));
				//项目性质ID
				if (foo.elementText("Proquliid") != null)
					objProjectQualityInfo.setProquliid(com.colorwinglib.Converts.StrToInt(foo.elementText("Proquliid")));
				//项目性质Name
				if (foo.elementText("Proquliname") != null)
					objProjectQualityInfo.setProquliname(com.colorwinglib.Converts.objToStr(foo.elementText("Proquliname")));
				objProjectQualityInfoCollection.add(objProjectQualityInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objProjectQualityInfoCollection;
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
		if ("Proqulidatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(ProjectQualityColumnNameEnum.Proqulidatabaseid, isAsc);
		}

		//项目性质ID
		if ("Proquliid".equals(columnName) && isAsc == true)
		{
          return sort(ProjectQualityColumnNameEnum.Proquliid, isAsc);
		}

		//项目性质Name
		if ("Proquliname".equals(columnName) && isAsc == true)
		{
          return sort(ProjectQualityColumnNameEnum.Proquliname, isAsc);
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
	public boolean sort(ProjectQualityColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//数据库ID
		if (ProjectQualityColumnNameEnum.Proqulidatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProjectQualityProqulidatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (ProjectQualityColumnNameEnum.Proqulidatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProjectQualityProqulidatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//项目性质ID
		if (ProjectQualityColumnNameEnum.Proquliid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProjectQualityProquliidComparatorAsc());// 顺序
			return true;
		}
		if (ProjectQualityColumnNameEnum.Proquliid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProjectQualityProquliidComparatorDesc());// 倒叙
			return true;
		}

		//项目性质Name
		if (ProjectQualityColumnNameEnum.Proquliname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProjectQualityProqulinameComparatorAsc());// 顺序
			return true;
		}
		if (ProjectQualityColumnNameEnum.Proquliname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProjectQualityProqulinameComparatorDesc());// 倒叙
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
		for (ProjectQualityInfo objProjectQualityInfo : this)
		{
			objJSONArray.put(objProjectQualityInfo.toJson());
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
				ProjectQualityInfo objProjectQualityInfo = new ProjectQualityInfo();
				objProjectQualityInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objProjectQualityInfo);
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
	// [start] 按 Proqulidatabaseid 数据库ID 正序排序
/**
 * 按 Proqulidatabaseid 数据库ID 正序排序
 *
 */
class ProjectQualityProqulidatabaseidComparatorAsc implements Comparator<ProjectQualityInfo>
{
	public int compare(ProjectQualityInfo arg0, ProjectQualityInfo arg1)
	{
		if (arg0.getProqulidatabaseid() > arg1.getProqulidatabaseid())
			return 1;
		else if (arg0.getProqulidatabaseid() < arg1.getProqulidatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Proqulidatabaseid 数据库ID 倒叙排序
/**
 * 按 Proqulidatabaseid 数据库ID 倒叙排序
 *
 */
class ProjectQualityProqulidatabaseidComparatorDesc implements Comparator<ProjectQualityInfo>
{

	public int compare(ProjectQualityInfo arg0, ProjectQualityInfo arg1)
	{
		if (arg0.getProqulidatabaseid() > arg1.getProqulidatabaseid())
			return -1;
		else if (arg0.getProqulidatabaseid() < arg1.getProqulidatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Proquliid 项目性质ID 正序排序
/**
 * 按 Proquliid 项目性质ID 正序排序
 *
 */
class ProjectQualityProquliidComparatorAsc implements Comparator<ProjectQualityInfo>
{
	public int compare(ProjectQualityInfo arg0, ProjectQualityInfo arg1)
	{
		if (arg0.getProquliid() > arg1.getProquliid())
			return 1;
		else if (arg0.getProquliid() < arg1.getProquliid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Proquliid 项目性质ID 倒叙排序
/**
 * 按 Proquliid 项目性质ID 倒叙排序
 *
 */
class ProjectQualityProquliidComparatorDesc implements Comparator<ProjectQualityInfo>
{

	public int compare(ProjectQualityInfo arg0, ProjectQualityInfo arg1)
	{
		if (arg0.getProquliid() > arg1.getProquliid())
			return -1;
		else if (arg0.getProquliid() < arg1.getProquliid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Proquliname 项目性质Name正序排序
/**
 * 按 Proquliname 项目性质Name 正序排序
 *
 */
class ProjectQualityProqulinameComparatorAsc implements Comparator<ProjectQualityInfo>
{
	public int compare(ProjectQualityInfo arg0, ProjectQualityInfo arg1)
	{
		return arg0.getProquliname().toLowerCase().compareTo(arg1.getProquliname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Proquliname 项目性质Name 倒叙排序
/**
 * 按 Proquliname 项目性质Name 倒叙排序
 *
 */
class ProjectQualityProqulinameComparatorDesc implements Comparator<ProjectQualityInfo>
{

	public int compare(ProjectQualityInfo arg0, ProjectQualityInfo arg1)
	{
		return arg1.getProquliname().toLowerCase().compareTo(arg0.getProquliname().toLowerCase());
	}
}
	// [end]


	// [end]

