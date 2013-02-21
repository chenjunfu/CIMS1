package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.MajorInfoBase.*;

/**
 * Major 专业表的摘要说明
 */
public class MajorInfoCollectionBase extends ArrayList<MajorInfo> implements List<MajorInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311503996811L;

	// [start] 根据主键或自增字段返回MajorInfo

        // [start] GetMajorInfoByMajordatabaseid
        // [start] GetMajorInfoByMajordatabaseid
        /**
        * 根据MajordatabaseID获取表 专业表的对象MajorInfo
        * @param Majordatabaseid 专业数据库编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return MajorInfo对象实体
        */
        public MajorInfo GetMajorInfoByMajordatabaseid(int Majordatabaseid)
        {
              return GetMajorInfoByMajordatabaseid(Majordatabaseid,  true);
        }
        // [end]

        // [start] GetMajorInfoByMajordatabaseid
        private int GetMajorInfoByMajordatabaseid_Majordatabaseid = 0;//专业数据库编号
        private MajorInfo GetMajorInfoByMajordatabaseid_MajorInfo;
        /**
        * 根据MajordatabaseID获取表 专业表的对象MajorInfo
        * @param Majordatabaseid 专业数据库编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return MajorInfo对象实体
        */
        public MajorInfo GetMajorInfoByMajordatabaseid(int Majordatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetMajorInfoByMajordatabaseid_MajorInfo = null;
                if (GetMajorInfoByMajordatabaseid_MajorInfo == null || GetMajorInfoByMajordatabaseid_Majordatabaseid != Majordatabaseid)
            {
            for (MajorInfo objMajorInfo : this)
            {
                if (objMajorInfo.getMajordatabaseid() == Majordatabaseid)
                {
                    GetMajorInfoByMajordatabaseid_MajorInfo = objMajorInfo;
                    GetMajorInfoByMajordatabaseid_Majordatabaseid = Majordatabaseid;//专业数据库编号
                    return objMajorInfo;
                }
            }
            return null;
            }
            else
            {
                return GetMajorInfoByMajordatabaseid_MajorInfo;
            }
        }
        // [end]

        // [start] GetIndexByMajordatabaseid
        /**
        * 根据MajordatabaseID获取表 专业表的对象MajorInfo 的位置
        * @param Majordatabaseid 专业数据库编号 
        * @return MajorInfo对象实体 的位置
        */
        public int GetIndexByMajordatabaseid(int Majordatabaseid)
        {
             int index = 0;
            for (MajorInfo objMajorInfo : this)
            {
                if (objMajorInfo.getMajordatabaseid() == Majordatabaseid)
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

	// [start] 根据索引返回MajorInfoCollection

        // [start] GetMajorInfoCollectionByMajorid
        // [start] GetMajorInfoCollectionByMajorid
        /**
        * 根据MajorID获取表 专业表的对象集合MajorInfoCollection
        * @param Majorid 专业编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return MajorInfoCollection对象集合
        */
        public MajorInfoCollection GetMajorInfoCollectionByMajorid(int Majorid)
        {
              return GetMajorInfoCollectionByMajorid(Majorid,  true);
        }
        // [end]

        // [start] GetMajorInfoCollectionByMajorid
        private int GetMajorInfoCollectionByMajorid_Majorid = 0;//专业编号
        private MajorInfoCollection GetMajorInfoCollectionByMajorid_MajorInfoCollection;
        /**
        * 根据MajorID获取表 专业表的对象集合MajorInfoCollection
        * @param Majorid 专业编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return MajorInfoCollection对象集合
        */
        public MajorInfoCollection GetMajorInfoCollectionByMajorid(int Majorid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetMajorInfoCollectionByMajorid_MajorInfoCollection = null;
                if (GetMajorInfoCollectionByMajorid_MajorInfoCollection == null || GetMajorInfoCollectionByMajorid_Majorid != Majorid)
            {
            MajorInfoCollection list = new MajorInfoCollection();
            for (MajorInfo objMajorInfo : this)
            {
                if (objMajorInfo.getMajorid() == Majorid)
                {
                    list.add(objMajorInfo);
                }
            }
            GetMajorInfoCollectionByMajorid_MajorInfoCollection = list;
            GetMajorInfoCollectionByMajorid_Majorid = Majorid;//专业编号
            return list;
            }
            else
            {
                return GetMajorInfoCollectionByMajorid_MajorInfoCollection;
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
	public MajorInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new MajorInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		MajorInfoCollection list = new MajorInfoCollection();
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
    public MajorInfoCollection Copy()
    {
        MajorInfoCollection list = new MajorInfoCollection();
        for (MajorInfo objMajorInfo : this)
        {
            list.add(objMajorInfo.Copy());
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
		sbStr.append("<ArrayOfMajorInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (MajorInfo objMajorInfo : this)
		{
			sbStr.append("  <MajorInfo>\n");
            //专业数据库编号
			sbStr.append("    <Majordatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objMajorInfo.getMajordatabaseid()));
			sbStr.append("</Majordatabaseid>\n");
            //专业编号
			sbStr.append("    <Majorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objMajorInfo.getMajorid()));
			sbStr.append("</Majorid>\n");
            //专业名称
			sbStr.append("    <Majorname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objMajorInfo.getMajorname()));
			sbStr.append("</Majorname>\n");
			sbStr.append("  </MajorInfo>\n");
		}
		sbStr.append("</ArrayOfMajorInfo>\n");
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
	// GetMajorInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetMajorInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static MajorInfoCollection GetMajorInfoCollectionFormFileName(String filename)
	{
		return GetMajorInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetMajorInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static MajorInfoCollection GetMajorInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetMajorInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetMajorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetMajorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static MajorInfoCollection GetMajorInfoCollectionFormXml(String xml)
	{
		return GetMajorInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetMajorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static MajorInfoCollection GetMajorInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		MajorInfoCollection objMajorInfoCollection = new MajorInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("MajorInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				MajorInfo objMajorInfo = new MajorInfo();
				//专业数据库编号
				if (foo.elementText("Majordatabaseid") != null)
					objMajorInfo.setMajordatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Majordatabaseid")));
				//专业编号
				if (foo.elementText("Majorid") != null)
					objMajorInfo.setMajorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Majorid")));
				//专业名称
				if (foo.elementText("Majorname") != null)
					objMajorInfo.setMajorname(com.colorwinglib.Converts.objToStr(foo.elementText("Majorname")));
				objMajorInfoCollection.add(objMajorInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objMajorInfoCollection;
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
		//专业数据库编号
		if ("Majordatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(MajorColumnNameEnum.Majordatabaseid, isAsc);
		}

		//专业编号
		if ("Majorid".equals(columnName) && isAsc == true)
		{
          return sort(MajorColumnNameEnum.Majorid, isAsc);
		}

		//专业名称
		if ("Majorname".equals(columnName) && isAsc == true)
		{
          return sort(MajorColumnNameEnum.Majorname, isAsc);
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
	public boolean sort(MajorColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//专业数据库编号
		if (MajorColumnNameEnum.Majordatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new MajorMajordatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (MajorColumnNameEnum.Majordatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new MajorMajordatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//专业编号
		if (MajorColumnNameEnum.Majorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new MajorMajoridComparatorAsc());// 顺序
			return true;
		}
		if (MajorColumnNameEnum.Majorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new MajorMajoridComparatorDesc());// 倒叙
			return true;
		}

		//专业名称
		if (MajorColumnNameEnum.Majorname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new MajorMajornameComparatorAsc());// 顺序
			return true;
		}
		if (MajorColumnNameEnum.Majorname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new MajorMajornameComparatorDesc());// 倒叙
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
		for (MajorInfo objMajorInfo : this)
		{
			objJSONArray.put(objMajorInfo.toJson());
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
				MajorInfo objMajorInfo = new MajorInfo();
				objMajorInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objMajorInfo);
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
	// [start] 按 Majordatabaseid 专业数据库编号 正序排序
/**
 * 按 Majordatabaseid 专业数据库编号 正序排序
 *
 */
class MajorMajordatabaseidComparatorAsc implements Comparator<MajorInfo>
{
	public int compare(MajorInfo arg0, MajorInfo arg1)
	{
		if (arg0.getMajordatabaseid() > arg1.getMajordatabaseid())
			return 1;
		else if (arg0.getMajordatabaseid() < arg1.getMajordatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Majordatabaseid 专业数据库编号 倒叙排序
/**
 * 按 Majordatabaseid 专业数据库编号 倒叙排序
 *
 */
class MajorMajordatabaseidComparatorDesc implements Comparator<MajorInfo>
{

	public int compare(MajorInfo arg0, MajorInfo arg1)
	{
		if (arg0.getMajordatabaseid() > arg1.getMajordatabaseid())
			return -1;
		else if (arg0.getMajordatabaseid() < arg1.getMajordatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Majorid 专业编号 正序排序
/**
 * 按 Majorid 专业编号 正序排序
 *
 */
class MajorMajoridComparatorAsc implements Comparator<MajorInfo>
{
	public int compare(MajorInfo arg0, MajorInfo arg1)
	{
		if (arg0.getMajorid() > arg1.getMajorid())
			return 1;
		else if (arg0.getMajorid() < arg1.getMajorid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Majorid 专业编号 倒叙排序
/**
 * 按 Majorid 专业编号 倒叙排序
 *
 */
class MajorMajoridComparatorDesc implements Comparator<MajorInfo>
{

	public int compare(MajorInfo arg0, MajorInfo arg1)
	{
		if (arg0.getMajorid() > arg1.getMajorid())
			return -1;
		else if (arg0.getMajorid() < arg1.getMajorid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Majorname 专业名称正序排序
/**
 * 按 Majorname 专业名称 正序排序
 *
 */
class MajorMajornameComparatorAsc implements Comparator<MajorInfo>
{
	public int compare(MajorInfo arg0, MajorInfo arg1)
	{
		return arg0.getMajorname().toLowerCase().compareTo(arg1.getMajorname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Majorname 专业名称 倒叙排序
/**
 * 按 Majorname 专业名称 倒叙排序
 *
 */
class MajorMajornameComparatorDesc implements Comparator<MajorInfo>
{

	public int compare(MajorInfo arg0, MajorInfo arg1)
	{
		return arg1.getMajorname().toLowerCase().compareTo(arg0.getMajorname().toLowerCase());
	}
}
	// [end]


	// [end]

