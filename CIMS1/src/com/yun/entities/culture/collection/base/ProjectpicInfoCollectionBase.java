package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.ProjectpicInfoBase.*;

/**
 * Projectpic 项目图片表的摘要说明
 */
public class ProjectpicInfoCollectionBase extends ArrayList<ProjectpicInfo> implements List<ProjectpicInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311541221880L;

	// [start] 根据主键或自增字段返回ProjectpicInfo

        // [start] GetProjectpicInfoByProjectpicid
        // [start] GetProjectpicInfoByProjectpicid
        /**
        * 根据ProjectPicID获取表 项目图片表的对象ProjectpicInfo
        * @param Projectpicid 项目图片编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProjectpicInfo对象实体
        */
        public ProjectpicInfo GetProjectpicInfoByProjectpicid(int Projectpicid)
        {
              return GetProjectpicInfoByProjectpicid(Projectpicid,  true);
        }
        // [end]

        // [start] GetProjectpicInfoByProjectpicid
        private int GetProjectpicInfoByProjectpicid_Projectpicid = 0;//项目图片编号
        private ProjectpicInfo GetProjectpicInfoByProjectpicid_ProjectpicInfo;
        /**
        * 根据ProjectPicID获取表 项目图片表的对象ProjectpicInfo
        * @param Projectpicid 项目图片编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return ProjectpicInfo对象实体
        */
        public ProjectpicInfo GetProjectpicInfoByProjectpicid(int Projectpicid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetProjectpicInfoByProjectpicid_ProjectpicInfo = null;
                if (GetProjectpicInfoByProjectpicid_ProjectpicInfo == null || GetProjectpicInfoByProjectpicid_Projectpicid != Projectpicid)
            {
            for (ProjectpicInfo objProjectpicInfo : this)
            {
                if (objProjectpicInfo.getProjectpicid() == Projectpicid)
                {
                    GetProjectpicInfoByProjectpicid_ProjectpicInfo = objProjectpicInfo;
                    GetProjectpicInfoByProjectpicid_Projectpicid = Projectpicid;//项目图片编号
                    return objProjectpicInfo;
                }
            }
            return null;
            }
            else
            {
                return GetProjectpicInfoByProjectpicid_ProjectpicInfo;
            }
        }
        // [end]

        // [start] GetIndexByProjectpicid
        /**
        * 根据ProjectPicID获取表 项目图片表的对象ProjectpicInfo 的位置
        * @param Projectpicid 项目图片编号 
        * @return ProjectpicInfo对象实体 的位置
        */
        public int GetIndexByProjectpicid(int Projectpicid)
        {
             int index = 0;
            for (ProjectpicInfo objProjectpicInfo : this)
            {
                if (objProjectpicInfo.getProjectpicid() == Projectpicid)
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

	// [start] 根据索引返回ProjectpicInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public ProjectpicInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new ProjectpicInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		ProjectpicInfoCollection list = new ProjectpicInfoCollection();
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
    public ProjectpicInfoCollection Copy()
    {
        ProjectpicInfoCollection list = new ProjectpicInfoCollection();
        for (ProjectpicInfo objProjectpicInfo : this)
        {
            list.add(objProjectpicInfo.Copy());
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
		sbStr.append("<ArrayOfProjectpicInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (ProjectpicInfo objProjectpicInfo : this)
		{
			sbStr.append("  <ProjectpicInfo>\n");
            //项目图片编号
			sbStr.append("    <Projectpicid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProjectpicInfo.getProjectpicid()));
			sbStr.append("</Projectpicid>\n");
            //项目编号
			sbStr.append("    <Databaseprojectid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProjectpicInfo.getDatabaseprojectid()));
			sbStr.append("</Databaseprojectid>\n");
            //项目图片
			sbStr.append("    <Pic>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objProjectpicInfo.getPic()));
			sbStr.append("</Pic>\n");
			sbStr.append("  </ProjectpicInfo>\n");
		}
		sbStr.append("</ArrayOfProjectpicInfo>\n");
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
	// GetProjectpicInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetProjectpicInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static ProjectpicInfoCollection GetProjectpicInfoCollectionFormFileName(String filename)
	{
		return GetProjectpicInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProjectpicInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectpicInfoCollection GetProjectpicInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetProjectpicInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetProjectpicInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetProjectpicInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectpicInfoCollection GetProjectpicInfoCollectionFormXml(String xml)
	{
		return GetProjectpicInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetProjectpicInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static ProjectpicInfoCollection GetProjectpicInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		ProjectpicInfoCollection objProjectpicInfoCollection = new ProjectpicInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("ProjectpicInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				ProjectpicInfo objProjectpicInfo = new ProjectpicInfo();
				//项目图片编号
				if (foo.elementText("Projectpicid") != null)
					objProjectpicInfo.setProjectpicid(com.colorwinglib.Converts.StrToInt(foo.elementText("Projectpicid")));
				//项目编号
				if (foo.elementText("Databaseprojectid") != null)
					objProjectpicInfo.setDatabaseprojectid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseprojectid")));
				//项目图片
				if (foo.elementText("Pic") != null)
					objProjectpicInfo.setPic(com.colorwinglib.Converts.objToStr(foo.elementText("Pic")));
				objProjectpicInfoCollection.add(objProjectpicInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objProjectpicInfoCollection;
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
		//项目图片编号
		if ("Projectpicid".equals(columnName) && isAsc == true)
		{
          return sort(ProjectpicColumnNameEnum.Projectpicid, isAsc);
		}

		//项目编号
		if ("Databaseprojectid".equals(columnName) && isAsc == true)
		{
          return sort(ProjectpicColumnNameEnum.Databaseprojectid, isAsc);
		}

		//项目图片
		if ("Pic".equals(columnName) && isAsc == true)
		{
          return sort(ProjectpicColumnNameEnum.Pic, isAsc);
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
	public boolean sort(ProjectpicColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//项目图片编号
		if (ProjectpicColumnNameEnum.Projectpicid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProjectpicProjectpicidComparatorAsc());// 顺序
			return true;
		}
		if (ProjectpicColumnNameEnum.Projectpicid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProjectpicProjectpicidComparatorDesc());// 倒叙
			return true;
		}

		//项目编号
		if (ProjectpicColumnNameEnum.Databaseprojectid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProjectpicDatabaseprojectidComparatorAsc());// 顺序
			return true;
		}
		if (ProjectpicColumnNameEnum.Databaseprojectid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProjectpicDatabaseprojectidComparatorDesc());// 倒叙
			return true;
		}

		//项目图片
		if (ProjectpicColumnNameEnum.Pic.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new ProjectpicPicComparatorAsc());// 顺序
			return true;
		}
		if (ProjectpicColumnNameEnum.Pic.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new ProjectpicPicComparatorDesc());// 倒叙
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
		for (ProjectpicInfo objProjectpicInfo : this)
		{
			objJSONArray.put(objProjectpicInfo.toJson());
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
				ProjectpicInfo objProjectpicInfo = new ProjectpicInfo();
				objProjectpicInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objProjectpicInfo);
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
	// [start] 按 Projectpicid 项目图片编号 正序排序
/**
 * 按 Projectpicid 项目图片编号 正序排序
 *
 */
class ProjectpicProjectpicidComparatorAsc implements Comparator<ProjectpicInfo>
{
	public int compare(ProjectpicInfo arg0, ProjectpicInfo arg1)
	{
		if (arg0.getProjectpicid() > arg1.getProjectpicid())
			return 1;
		else if (arg0.getProjectpicid() < arg1.getProjectpicid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Projectpicid 项目图片编号 倒叙排序
/**
 * 按 Projectpicid 项目图片编号 倒叙排序
 *
 */
class ProjectpicProjectpicidComparatorDesc implements Comparator<ProjectpicInfo>
{

	public int compare(ProjectpicInfo arg0, ProjectpicInfo arg1)
	{
		if (arg0.getProjectpicid() > arg1.getProjectpicid())
			return -1;
		else if (arg0.getProjectpicid() < arg1.getProjectpicid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Databaseprojectid 项目编号 正序排序
/**
 * 按 Databaseprojectid 项目编号 正序排序
 *
 */
class ProjectpicDatabaseprojectidComparatorAsc implements Comparator<ProjectpicInfo>
{
	public int compare(ProjectpicInfo arg0, ProjectpicInfo arg1)
	{
		if (arg0.getDatabaseprojectid() > arg1.getDatabaseprojectid())
			return 1;
		else if (arg0.getDatabaseprojectid() < arg1.getDatabaseprojectid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databaseprojectid 项目编号 倒叙排序
/**
 * 按 Databaseprojectid 项目编号 倒叙排序
 *
 */
class ProjectpicDatabaseprojectidComparatorDesc implements Comparator<ProjectpicInfo>
{

	public int compare(ProjectpicInfo arg0, ProjectpicInfo arg1)
	{
		if (arg0.getDatabaseprojectid() > arg1.getDatabaseprojectid())
			return -1;
		else if (arg0.getDatabaseprojectid() < arg1.getDatabaseprojectid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Pic 项目图片正序排序
/**
 * 按 Pic 项目图片 正序排序
 *
 */
class ProjectpicPicComparatorAsc implements Comparator<ProjectpicInfo>
{
	public int compare(ProjectpicInfo arg0, ProjectpicInfo arg1)
	{
		return arg0.getPic().toLowerCase().compareTo(arg1.getPic().toLowerCase());
	}
}
	// [end]

	// [start] 按 Pic 项目图片 倒叙排序
/**
 * 按 Pic 项目图片 倒叙排序
 *
 */
class ProjectpicPicComparatorDesc implements Comparator<ProjectpicInfo>
{

	public int compare(ProjectpicInfo arg0, ProjectpicInfo arg1)
	{
		return arg1.getPic().toLowerCase().compareTo(arg0.getPic().toLowerCase());
	}
}
	// [end]


	// [end]

