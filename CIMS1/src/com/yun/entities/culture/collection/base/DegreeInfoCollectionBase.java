package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.DegreeInfoBase.*;

/**
 * Degree 的摘要说明
 */
public class DegreeInfoCollectionBase extends ArrayList<DegreeInfo> implements List<DegreeInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311462175088L;

	// [start] 根据主键或自增字段返回DegreeInfo

        // [start] GetDegreeInfoByDegreedatabaseid
        // [start] GetDegreeInfoByDegreedatabaseid
        /**
        * 根据DegreedatabaseID获取表 的对象DegreeInfo
        * @param Degreedatabaseid DegreedatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return DegreeInfo对象实体
        */
        public DegreeInfo GetDegreeInfoByDegreedatabaseid(int Degreedatabaseid)
        {
              return GetDegreeInfoByDegreedatabaseid(Degreedatabaseid,  true);
        }
        // [end]

        // [start] GetDegreeInfoByDegreedatabaseid
        private int GetDegreeInfoByDegreedatabaseid_Degreedatabaseid = 0;//DegreedatabaseID
        private DegreeInfo GetDegreeInfoByDegreedatabaseid_DegreeInfo;
        /**
        * 根据DegreedatabaseID获取表 的对象DegreeInfo
        * @param Degreedatabaseid DegreedatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return DegreeInfo对象实体
        */
        public DegreeInfo GetDegreeInfoByDegreedatabaseid(int Degreedatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetDegreeInfoByDegreedatabaseid_DegreeInfo = null;
                if (GetDegreeInfoByDegreedatabaseid_DegreeInfo == null || GetDegreeInfoByDegreedatabaseid_Degreedatabaseid != Degreedatabaseid)
            {
            for (DegreeInfo objDegreeInfo : this)
            {
                if (objDegreeInfo.getDegreedatabaseid() == Degreedatabaseid)
                {
                    GetDegreeInfoByDegreedatabaseid_DegreeInfo = objDegreeInfo;
                    GetDegreeInfoByDegreedatabaseid_Degreedatabaseid = Degreedatabaseid;//DegreedatabaseID
                    return objDegreeInfo;
                }
            }
            return null;
            }
            else
            {
                return GetDegreeInfoByDegreedatabaseid_DegreeInfo;
            }
        }
        // [end]

        // [start] GetIndexByDegreedatabaseid
        /**
        * 根据DegreedatabaseID获取表 的对象DegreeInfo 的位置
        * @param Degreedatabaseid DegreedatabaseID 
        * @return DegreeInfo对象实体 的位置
        */
        public int GetIndexByDegreedatabaseid(int Degreedatabaseid)
        {
             int index = 0;
            for (DegreeInfo objDegreeInfo : this)
            {
                if (objDegreeInfo.getDegreedatabaseid() == Degreedatabaseid)
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

	// [start] 根据索引返回DegreeInfoCollection

        // [start] GetDegreeInfoCollectionByDegreeid
        // [start] GetDegreeInfoCollectionByDegreeid
        /**
        * 根据DegreeID获取表 的对象集合DegreeInfoCollection
        * @param Degreeid DegreeID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return DegreeInfoCollection对象集合
        */
        public DegreeInfoCollection GetDegreeInfoCollectionByDegreeid(int Degreeid)
        {
              return GetDegreeInfoCollectionByDegreeid(Degreeid,  true);
        }
        // [end]

        // [start] GetDegreeInfoCollectionByDegreeid
        private int GetDegreeInfoCollectionByDegreeid_Degreeid = 0;//DegreeID
        private DegreeInfoCollection GetDegreeInfoCollectionByDegreeid_DegreeInfoCollection;
        /**
        * 根据DegreeID获取表 的对象集合DegreeInfoCollection
        * @param Degreeid DegreeID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return DegreeInfoCollection对象集合
        */
        public DegreeInfoCollection GetDegreeInfoCollectionByDegreeid(int Degreeid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetDegreeInfoCollectionByDegreeid_DegreeInfoCollection = null;
                if (GetDegreeInfoCollectionByDegreeid_DegreeInfoCollection == null || GetDegreeInfoCollectionByDegreeid_Degreeid != Degreeid)
            {
            DegreeInfoCollection list = new DegreeInfoCollection();
            for (DegreeInfo objDegreeInfo : this)
            {
                if (objDegreeInfo.getDegreeid() == Degreeid)
                {
                    list.add(objDegreeInfo);
                }
            }
            GetDegreeInfoCollectionByDegreeid_DegreeInfoCollection = list;
            GetDegreeInfoCollectionByDegreeid_Degreeid = Degreeid;//DegreeID
            return list;
            }
            else
            {
                return GetDegreeInfoCollectionByDegreeid_DegreeInfoCollection;
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
	public DegreeInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new DegreeInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		DegreeInfoCollection list = new DegreeInfoCollection();
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
    public DegreeInfoCollection Copy()
    {
        DegreeInfoCollection list = new DegreeInfoCollection();
        for (DegreeInfo objDegreeInfo : this)
        {
            list.add(objDegreeInfo.Copy());
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
		sbStr.append("<ArrayOfDegreeInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (DegreeInfo objDegreeInfo : this)
		{
			sbStr.append("  <DegreeInfo>\n");
            //DegreedatabaseID
			sbStr.append("    <Degreedatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objDegreeInfo.getDegreedatabaseid()));
			sbStr.append("</Degreedatabaseid>\n");
            //DegreeID
			sbStr.append("    <Degreeid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objDegreeInfo.getDegreeid()));
			sbStr.append("</Degreeid>\n");
            //DegreeName
			sbStr.append("    <Degreename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objDegreeInfo.getDegreename()));
			sbStr.append("</Degreename>\n");
			sbStr.append("  </DegreeInfo>\n");
		}
		sbStr.append("</ArrayOfDegreeInfo>\n");
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
	// GetDegreeInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetDegreeInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static DegreeInfoCollection GetDegreeInfoCollectionFormFileName(String filename)
	{
		return GetDegreeInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetDegreeInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DegreeInfoCollection GetDegreeInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetDegreeInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetDegreeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetDegreeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DegreeInfoCollection GetDegreeInfoCollectionFormXml(String xml)
	{
		return GetDegreeInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetDegreeInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static DegreeInfoCollection GetDegreeInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		DegreeInfoCollection objDegreeInfoCollection = new DegreeInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("DegreeInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				DegreeInfo objDegreeInfo = new DegreeInfo();
				//DegreedatabaseID
				if (foo.elementText("Degreedatabaseid") != null)
					objDegreeInfo.setDegreedatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Degreedatabaseid")));
				//DegreeID
				if (foo.elementText("Degreeid") != null)
					objDegreeInfo.setDegreeid(com.colorwinglib.Converts.StrToInt(foo.elementText("Degreeid")));
				//DegreeName
				if (foo.elementText("Degreename") != null)
					objDegreeInfo.setDegreename(com.colorwinglib.Converts.objToStr(foo.elementText("Degreename")));
				objDegreeInfoCollection.add(objDegreeInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objDegreeInfoCollection;
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
		//DegreedatabaseID
		if ("Degreedatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(DegreeColumnNameEnum.Degreedatabaseid, isAsc);
		}

		//DegreeID
		if ("Degreeid".equals(columnName) && isAsc == true)
		{
          return sort(DegreeColumnNameEnum.Degreeid, isAsc);
		}

		//DegreeName
		if ("Degreename".equals(columnName) && isAsc == true)
		{
          return sort(DegreeColumnNameEnum.Degreename, isAsc);
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
	public boolean sort(DegreeColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//DegreedatabaseID
		if (DegreeColumnNameEnum.Degreedatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new DegreeDegreedatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (DegreeColumnNameEnum.Degreedatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new DegreeDegreedatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//DegreeID
		if (DegreeColumnNameEnum.Degreeid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new DegreeDegreeidComparatorAsc());// 顺序
			return true;
		}
		if (DegreeColumnNameEnum.Degreeid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new DegreeDegreeidComparatorDesc());// 倒叙
			return true;
		}

		//DegreeName
		if (DegreeColumnNameEnum.Degreename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new DegreeDegreenameComparatorAsc());// 顺序
			return true;
		}
		if (DegreeColumnNameEnum.Degreename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new DegreeDegreenameComparatorDesc());// 倒叙
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
		for (DegreeInfo objDegreeInfo : this)
		{
			objJSONArray.put(objDegreeInfo.toJson());
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
				DegreeInfo objDegreeInfo = new DegreeInfo();
				objDegreeInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objDegreeInfo);
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
	// [start] 按 Degreedatabaseid DegreedatabaseID 正序排序
/**
 * 按 Degreedatabaseid DegreedatabaseID 正序排序
 *
 */
class DegreeDegreedatabaseidComparatorAsc implements Comparator<DegreeInfo>
{
	public int compare(DegreeInfo arg0, DegreeInfo arg1)
	{
		if (arg0.getDegreedatabaseid() > arg1.getDegreedatabaseid())
			return 1;
		else if (arg0.getDegreedatabaseid() < arg1.getDegreedatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Degreedatabaseid DegreedatabaseID 倒叙排序
/**
 * 按 Degreedatabaseid DegreedatabaseID 倒叙排序
 *
 */
class DegreeDegreedatabaseidComparatorDesc implements Comparator<DegreeInfo>
{

	public int compare(DegreeInfo arg0, DegreeInfo arg1)
	{
		if (arg0.getDegreedatabaseid() > arg1.getDegreedatabaseid())
			return -1;
		else if (arg0.getDegreedatabaseid() < arg1.getDegreedatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Degreeid DegreeID 正序排序
/**
 * 按 Degreeid DegreeID 正序排序
 *
 */
class DegreeDegreeidComparatorAsc implements Comparator<DegreeInfo>
{
	public int compare(DegreeInfo arg0, DegreeInfo arg1)
	{
		if (arg0.getDegreeid() > arg1.getDegreeid())
			return 1;
		else if (arg0.getDegreeid() < arg1.getDegreeid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Degreeid DegreeID 倒叙排序
/**
 * 按 Degreeid DegreeID 倒叙排序
 *
 */
class DegreeDegreeidComparatorDesc implements Comparator<DegreeInfo>
{

	public int compare(DegreeInfo arg0, DegreeInfo arg1)
	{
		if (arg0.getDegreeid() > arg1.getDegreeid())
			return -1;
		else if (arg0.getDegreeid() < arg1.getDegreeid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Degreename DegreeName正序排序
/**
 * 按 Degreename DegreeName 正序排序
 *
 */
class DegreeDegreenameComparatorAsc implements Comparator<DegreeInfo>
{
	public int compare(DegreeInfo arg0, DegreeInfo arg1)
	{
		return arg0.getDegreename().toLowerCase().compareTo(arg1.getDegreename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Degreename DegreeName 倒叙排序
/**
 * 按 Degreename DegreeName 倒叙排序
 *
 */
class DegreeDegreenameComparatorDesc implements Comparator<DegreeInfo>
{

	public int compare(DegreeInfo arg0, DegreeInfo arg1)
	{
		return arg1.getDegreename().toLowerCase().compareTo(arg0.getDegreename().toLowerCase());
	}
}
	// [end]


	// [end]

