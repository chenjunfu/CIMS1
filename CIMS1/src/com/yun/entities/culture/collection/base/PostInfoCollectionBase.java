package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.PostInfoBase.*;

/**
 * Post 职称表的摘要说明
 */
public class PostInfoCollectionBase extends ArrayList<PostInfo> implements List<PostInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311523062556L;

	// [start] 根据主键或自增字段返回PostInfo

        // [start] GetPostInfoByTitledatabaseid
        // [start] GetPostInfoByTitledatabaseid
        /**
        * 根据TitledatabaseID获取表 职称表的对象PostInfo
        * @param Titledatabaseid TitledatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return PostInfo对象实体
        */
        public PostInfo GetPostInfoByTitledatabaseid(int Titledatabaseid)
        {
              return GetPostInfoByTitledatabaseid(Titledatabaseid,  true);
        }
        // [end]

        // [start] GetPostInfoByTitledatabaseid
        private int GetPostInfoByTitledatabaseid_Titledatabaseid = 0;//TitledatabaseID
        private PostInfo GetPostInfoByTitledatabaseid_PostInfo;
        /**
        * 根据TitledatabaseID获取表 职称表的对象PostInfo
        * @param Titledatabaseid TitledatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return PostInfo对象实体
        */
        public PostInfo GetPostInfoByTitledatabaseid(int Titledatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetPostInfoByTitledatabaseid_PostInfo = null;
                if (GetPostInfoByTitledatabaseid_PostInfo == null || GetPostInfoByTitledatabaseid_Titledatabaseid != Titledatabaseid)
            {
            for (PostInfo objPostInfo : this)
            {
                if (objPostInfo.getTitledatabaseid() == Titledatabaseid)
                {
                    GetPostInfoByTitledatabaseid_PostInfo = objPostInfo;
                    GetPostInfoByTitledatabaseid_Titledatabaseid = Titledatabaseid;//TitledatabaseID
                    return objPostInfo;
                }
            }
            return null;
            }
            else
            {
                return GetPostInfoByTitledatabaseid_PostInfo;
            }
        }
        // [end]

        // [start] GetIndexByTitledatabaseid
        /**
        * 根据TitledatabaseID获取表 职称表的对象PostInfo 的位置
        * @param Titledatabaseid TitledatabaseID 
        * @return PostInfo对象实体 的位置
        */
        public int GetIndexByTitledatabaseid(int Titledatabaseid)
        {
             int index = 0;
            for (PostInfo objPostInfo : this)
            {
                if (objPostInfo.getTitledatabaseid() == Titledatabaseid)
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

	// [start] 根据索引返回PostInfoCollection

        // [start] GetPostInfoCollectionByTitleid
        // [start] GetPostInfoCollectionByTitleid
        /**
        * 根据TitleID获取表 职称表的对象集合PostInfoCollection
        * @param Titleid 职称编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return PostInfoCollection对象集合
        */
        public PostInfoCollection GetPostInfoCollectionByTitleid(int Titleid)
        {
              return GetPostInfoCollectionByTitleid(Titleid,  true);
        }
        // [end]

        // [start] GetPostInfoCollectionByTitleid
        private int GetPostInfoCollectionByTitleid_Titleid = 0;//职称编号
        private PostInfoCollection GetPostInfoCollectionByTitleid_PostInfoCollection;
        /**
        * 根据TitleID获取表 职称表的对象集合PostInfoCollection
        * @param Titleid 职称编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return PostInfoCollection对象集合
        */
        public PostInfoCollection GetPostInfoCollectionByTitleid(int Titleid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetPostInfoCollectionByTitleid_PostInfoCollection = null;
                if (GetPostInfoCollectionByTitleid_PostInfoCollection == null || GetPostInfoCollectionByTitleid_Titleid != Titleid)
            {
            PostInfoCollection list = new PostInfoCollection();
            for (PostInfo objPostInfo : this)
            {
                if (objPostInfo.getTitleid() == Titleid)
                {
                    list.add(objPostInfo);
                }
            }
            GetPostInfoCollectionByTitleid_PostInfoCollection = list;
            GetPostInfoCollectionByTitleid_Titleid = Titleid;//职称编号
            return list;
            }
            else
            {
                return GetPostInfoCollectionByTitleid_PostInfoCollection;
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
	public PostInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new PostInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		PostInfoCollection list = new PostInfoCollection();
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
    public PostInfoCollection Copy()
    {
        PostInfoCollection list = new PostInfoCollection();
        for (PostInfo objPostInfo : this)
        {
            list.add(objPostInfo.Copy());
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
		sbStr.append("<ArrayOfPostInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (PostInfo objPostInfo : this)
		{
			sbStr.append("  <PostInfo>\n");
            //TitledatabaseID
			sbStr.append("    <Titledatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPostInfo.getTitledatabaseid()));
			sbStr.append("</Titledatabaseid>\n");
            //职称编号
			sbStr.append("    <Titleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPostInfo.getTitleid()));
			sbStr.append("</Titleid>\n");
            //职称名称
			sbStr.append("    <Titlename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPostInfo.getTitlename()));
			sbStr.append("</Titlename>\n");
            //职称描述
			sbStr.append("    <Description>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPostInfo.getDescription()));
			sbStr.append("</Description>\n");
            //上级职称编号
			sbStr.append("    <Farthertitleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPostInfo.getFarthertitleid()));
			sbStr.append("</Farthertitleid>\n");
            //深度
			sbStr.append("    <Depth>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPostInfo.getDepth()));
			sbStr.append("</Depth>\n");
            //是否删除：1-未删除、2-已删除
			sbStr.append("    <IsDel>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPostInfo.getIsDel()));
			sbStr.append("</IsDel>\n");
			sbStr.append("  </PostInfo>\n");
		}
		sbStr.append("</ArrayOfPostInfo>\n");
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
	// GetPostInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetPostInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static PostInfoCollection GetPostInfoCollectionFormFileName(String filename)
	{
		return GetPostInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPostInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PostInfoCollection GetPostInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetPostInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetPostInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetPostInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PostInfoCollection GetPostInfoCollectionFormXml(String xml)
	{
		return GetPostInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPostInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PostInfoCollection GetPostInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		PostInfoCollection objPostInfoCollection = new PostInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("PostInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				PostInfo objPostInfo = new PostInfo();
				//TitledatabaseID
				if (foo.elementText("Titledatabaseid") != null)
					objPostInfo.setTitledatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Titledatabaseid")));
				//职称编号
				if (foo.elementText("Titleid") != null)
					objPostInfo.setTitleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Titleid")));
				//职称名称
				if (foo.elementText("Titlename") != null)
					objPostInfo.setTitlename(com.colorwinglib.Converts.objToStr(foo.elementText("Titlename")));
				//职称描述
				if (foo.elementText("Description") != null)
					objPostInfo.setDescription(com.colorwinglib.Converts.objToStr(foo.elementText("Description")));
				//上级职称编号
				if (foo.elementText("Farthertitleid") != null)
					objPostInfo.setFarthertitleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Farthertitleid")));
				//深度
				if (foo.elementText("Depth") != null)
					objPostInfo.setDepth(com.colorwinglib.Converts.StrToInt(foo.elementText("Depth")));
				//是否删除：1-未删除、2-已删除
				if (foo.elementText("IsDel") != null)
					objPostInfo.setIsDel(com.colorwinglib.Converts.StrToInt(foo.elementText("IsDel")));
				objPostInfoCollection.add(objPostInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objPostInfoCollection;
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
		//TitledatabaseID
		if ("Titledatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(PostColumnNameEnum.Titledatabaseid, isAsc);
		}

		//职称编号
		if ("Titleid".equals(columnName) && isAsc == true)
		{
          return sort(PostColumnNameEnum.Titleid, isAsc);
		}

		//职称名称
		if ("Titlename".equals(columnName) && isAsc == true)
		{
          return sort(PostColumnNameEnum.Titlename, isAsc);
		}

		//职称描述
		if ("Description".equals(columnName) && isAsc == true)
		{
          return sort(PostColumnNameEnum.Description, isAsc);
		}

		//上级职称编号
		if ("Farthertitleid".equals(columnName) && isAsc == true)
		{
          return sort(PostColumnNameEnum.Farthertitleid, isAsc);
		}

		//深度
		if ("Depth".equals(columnName) && isAsc == true)
		{
          return sort(PostColumnNameEnum.Depth, isAsc);
		}

		//是否删除：1-未删除、2-已删除
		if ("IsDel".equals(columnName) && isAsc == true)
		{
          return sort(PostColumnNameEnum.IsDel, isAsc);
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
	public boolean sort(PostColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//TitledatabaseID
		if (PostColumnNameEnum.Titledatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PostTitledatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (PostColumnNameEnum.Titledatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PostTitledatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//职称编号
		if (PostColumnNameEnum.Titleid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PostTitleidComparatorAsc());// 顺序
			return true;
		}
		if (PostColumnNameEnum.Titleid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PostTitleidComparatorDesc());// 倒叙
			return true;
		}

		//职称名称
		if (PostColumnNameEnum.Titlename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PostTitlenameComparatorAsc());// 顺序
			return true;
		}
		if (PostColumnNameEnum.Titlename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PostTitlenameComparatorDesc());// 倒叙
			return true;
		}

		//职称描述
		if (PostColumnNameEnum.Description.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PostDescriptionComparatorAsc());// 顺序
			return true;
		}
		if (PostColumnNameEnum.Description.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PostDescriptionComparatorDesc());// 倒叙
			return true;
		}

		//上级职称编号
		if (PostColumnNameEnum.Farthertitleid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PostFarthertitleidComparatorAsc());// 顺序
			return true;
		}
		if (PostColumnNameEnum.Farthertitleid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PostFarthertitleidComparatorDesc());// 倒叙
			return true;
		}

		//深度
		if (PostColumnNameEnum.Depth.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PostDepthComparatorAsc());// 顺序
			return true;
		}
		if (PostColumnNameEnum.Depth.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PostDepthComparatorDesc());// 倒叙
			return true;
		}

		//是否删除：1-未删除、2-已删除
		if (PostColumnNameEnum.IsDel.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PostIsDelComparatorAsc());// 顺序
			return true;
		}
		if (PostColumnNameEnum.IsDel.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PostIsDelComparatorDesc());// 倒叙
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
		for (PostInfo objPostInfo : this)
		{
			objJSONArray.put(objPostInfo.toJson());
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
				PostInfo objPostInfo = new PostInfo();
				objPostInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objPostInfo);
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
	// [start] 按 Titledatabaseid TitledatabaseID 正序排序
/**
 * 按 Titledatabaseid TitledatabaseID 正序排序
 *
 */
class PostTitledatabaseidComparatorAsc implements Comparator<PostInfo>
{
	public int compare(PostInfo arg0, PostInfo arg1)
	{
		if (arg0.getTitledatabaseid() > arg1.getTitledatabaseid())
			return 1;
		else if (arg0.getTitledatabaseid() < arg1.getTitledatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Titledatabaseid TitledatabaseID 倒叙排序
/**
 * 按 Titledatabaseid TitledatabaseID 倒叙排序
 *
 */
class PostTitledatabaseidComparatorDesc implements Comparator<PostInfo>
{

	public int compare(PostInfo arg0, PostInfo arg1)
	{
		if (arg0.getTitledatabaseid() > arg1.getTitledatabaseid())
			return -1;
		else if (arg0.getTitledatabaseid() < arg1.getTitledatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Titleid 职称编号 正序排序
/**
 * 按 Titleid 职称编号 正序排序
 *
 */
class PostTitleidComparatorAsc implements Comparator<PostInfo>
{
	public int compare(PostInfo arg0, PostInfo arg1)
	{
		if (arg0.getTitleid() > arg1.getTitleid())
			return 1;
		else if (arg0.getTitleid() < arg1.getTitleid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Titleid 职称编号 倒叙排序
/**
 * 按 Titleid 职称编号 倒叙排序
 *
 */
class PostTitleidComparatorDesc implements Comparator<PostInfo>
{

	public int compare(PostInfo arg0, PostInfo arg1)
	{
		if (arg0.getTitleid() > arg1.getTitleid())
			return -1;
		else if (arg0.getTitleid() < arg1.getTitleid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Titlename 职称名称正序排序
/**
 * 按 Titlename 职称名称 正序排序
 *
 */
class PostTitlenameComparatorAsc implements Comparator<PostInfo>
{
	public int compare(PostInfo arg0, PostInfo arg1)
	{
		return arg0.getTitlename().toLowerCase().compareTo(arg1.getTitlename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Titlename 职称名称 倒叙排序
/**
 * 按 Titlename 职称名称 倒叙排序
 *
 */
class PostTitlenameComparatorDesc implements Comparator<PostInfo>
{

	public int compare(PostInfo arg0, PostInfo arg1)
	{
		return arg1.getTitlename().toLowerCase().compareTo(arg0.getTitlename().toLowerCase());
	}
}
	// [end]


	// [start] 按 Description 职称描述正序排序
/**
 * 按 Description 职称描述 正序排序
 *
 */
class PostDescriptionComparatorAsc implements Comparator<PostInfo>
{
	public int compare(PostInfo arg0, PostInfo arg1)
	{
		return arg0.getDescription().toLowerCase().compareTo(arg1.getDescription().toLowerCase());
	}
}
	// [end]

	// [start] 按 Description 职称描述 倒叙排序
/**
 * 按 Description 职称描述 倒叙排序
 *
 */
class PostDescriptionComparatorDesc implements Comparator<PostInfo>
{

	public int compare(PostInfo arg0, PostInfo arg1)
	{
		return arg1.getDescription().toLowerCase().compareTo(arg0.getDescription().toLowerCase());
	}
}
	// [end]


	// [start] 按 Farthertitleid 上级职称编号 正序排序
/**
 * 按 Farthertitleid 上级职称编号 正序排序
 *
 */
class PostFarthertitleidComparatorAsc implements Comparator<PostInfo>
{
	public int compare(PostInfo arg0, PostInfo arg1)
	{
		if (arg0.getFarthertitleid() > arg1.getFarthertitleid())
			return 1;
		else if (arg0.getFarthertitleid() < arg1.getFarthertitleid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Farthertitleid 上级职称编号 倒叙排序
/**
 * 按 Farthertitleid 上级职称编号 倒叙排序
 *
 */
class PostFarthertitleidComparatorDesc implements Comparator<PostInfo>
{

	public int compare(PostInfo arg0, PostInfo arg1)
	{
		if (arg0.getFarthertitleid() > arg1.getFarthertitleid())
			return -1;
		else if (arg0.getFarthertitleid() < arg1.getFarthertitleid())
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
class PostDepthComparatorAsc implements Comparator<PostInfo>
{
	public int compare(PostInfo arg0, PostInfo arg1)
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
class PostDepthComparatorDesc implements Comparator<PostInfo>
{

	public int compare(PostInfo arg0, PostInfo arg1)
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


	// [start] 按 IsDel 是否删除：1-未删除、2-已删除 正序排序
/**
 * 按 IsDel 是否删除：1-未删除、2-已删除 正序排序
 *
 */
class PostIsDelComparatorAsc implements Comparator<PostInfo>
{
	public int compare(PostInfo arg0, PostInfo arg1)
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
class PostIsDelComparatorDesc implements Comparator<PostInfo>
{

	public int compare(PostInfo arg0, PostInfo arg1)
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


	// [end]

