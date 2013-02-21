package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.EnterpristQualityInfoBase.*;

/**
 * EnterpristQuality 企业性质表的摘要说明
 */
public class EnterpristQualityInfoCollectionBase extends ArrayList<EnterpristQualityInfo> implements List<EnterpristQualityInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311474873456L;

	// [start] 根据主键或自增字段返回EnterpristQualityInfo

        // [start] GetEnterpristQualityInfoByQualitydatabaseid
        // [start] GetEnterpristQualityInfoByQualitydatabaseid
        /**
        * 根据QualitydatabaseID获取表 企业性质表的对象EnterpristQualityInfo
        * @param Qualitydatabaseid 企业性质编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EnterpristQualityInfo对象实体
        */
        public EnterpristQualityInfo GetEnterpristQualityInfoByQualitydatabaseid(int Qualitydatabaseid)
        {
              return GetEnterpristQualityInfoByQualitydatabaseid(Qualitydatabaseid,  true);
        }
        // [end]

        // [start] GetEnterpristQualityInfoByQualitydatabaseid
        private int GetEnterpristQualityInfoByQualitydatabaseid_Qualitydatabaseid = 0;//企业性质编号
        private EnterpristQualityInfo GetEnterpristQualityInfoByQualitydatabaseid_EnterpristQualityInfo;
        /**
        * 根据QualitydatabaseID获取表 企业性质表的对象EnterpristQualityInfo
        * @param Qualitydatabaseid 企业性质编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EnterpristQualityInfo对象实体
        */
        public EnterpristQualityInfo GetEnterpristQualityInfoByQualitydatabaseid(int Qualitydatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetEnterpristQualityInfoByQualitydatabaseid_EnterpristQualityInfo = null;
                if (GetEnterpristQualityInfoByQualitydatabaseid_EnterpristQualityInfo == null || GetEnterpristQualityInfoByQualitydatabaseid_Qualitydatabaseid != Qualitydatabaseid)
            {
            for (EnterpristQualityInfo objEnterpristQualityInfo : this)
            {
                if (objEnterpristQualityInfo.getQualitydatabaseid() == Qualitydatabaseid)
                {
                    GetEnterpristQualityInfoByQualitydatabaseid_EnterpristQualityInfo = objEnterpristQualityInfo;
                    GetEnterpristQualityInfoByQualitydatabaseid_Qualitydatabaseid = Qualitydatabaseid;//企业性质编号
                    return objEnterpristQualityInfo;
                }
            }
            return null;
            }
            else
            {
                return GetEnterpristQualityInfoByQualitydatabaseid_EnterpristQualityInfo;
            }
        }
        // [end]

        // [start] GetIndexByQualitydatabaseid
        /**
        * 根据QualitydatabaseID获取表 企业性质表的对象EnterpristQualityInfo 的位置
        * @param Qualitydatabaseid 企业性质编号 
        * @return EnterpristQualityInfo对象实体 的位置
        */
        public int GetIndexByQualitydatabaseid(int Qualitydatabaseid)
        {
             int index = 0;
            for (EnterpristQualityInfo objEnterpristQualityInfo : this)
            {
                if (objEnterpristQualityInfo.getQualitydatabaseid() == Qualitydatabaseid)
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

	// [start] 根据索引返回EnterpristQualityInfoCollection

        // [start] GetEnterpristQualityInfoCollectionByQualityid
        // [start] GetEnterpristQualityInfoCollectionByQualityid
        /**
        * 根据QualityID获取表 企业性质表的对象集合EnterpristQualityInfoCollection
        * @param Qualityid QualityID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EnterpristQualityInfoCollection对象集合
        */
        public EnterpristQualityInfoCollection GetEnterpristQualityInfoCollectionByQualityid(String Qualityid)
        {
              return GetEnterpristQualityInfoCollectionByQualityid(Qualityid,  true);
        }
        // [end]

        // [start] GetEnterpristQualityInfoCollectionByQualityid
        private String GetEnterpristQualityInfoCollectionByQualityid_Qualityid = "";//QualityID
        private EnterpristQualityInfoCollection GetEnterpristQualityInfoCollectionByQualityid_EnterpristQualityInfoCollection;
        /**
        * 根据QualityID获取表 企业性质表的对象集合EnterpristQualityInfoCollection
        * @param Qualityid QualityID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return EnterpristQualityInfoCollection对象集合
        */
        public EnterpristQualityInfoCollection GetEnterpristQualityInfoCollectionByQualityid(String Qualityid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetEnterpristQualityInfoCollectionByQualityid_EnterpristQualityInfoCollection = null;
                if (GetEnterpristQualityInfoCollectionByQualityid_EnterpristQualityInfoCollection == null ||  !Qualityid.equals(GetEnterpristQualityInfoCollectionByQualityid_Qualityid))
            {
            EnterpristQualityInfoCollection list = new EnterpristQualityInfoCollection();
            for (EnterpristQualityInfo objEnterpristQualityInfo : this)
            {
                if (Qualityid.equals(objEnterpristQualityInfo.getQualityid()))
                {
                    list.add(objEnterpristQualityInfo);
                }
            }
            GetEnterpristQualityInfoCollectionByQualityid_EnterpristQualityInfoCollection = list;
            GetEnterpristQualityInfoCollectionByQualityid_Qualityid = Qualityid;//QualityID
            return list;
            }
            else
            {
                return GetEnterpristQualityInfoCollectionByQualityid_EnterpristQualityInfoCollection;
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
	public EnterpristQualityInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new EnterpristQualityInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		EnterpristQualityInfoCollection list = new EnterpristQualityInfoCollection();
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
    public EnterpristQualityInfoCollection Copy()
    {
        EnterpristQualityInfoCollection list = new EnterpristQualityInfoCollection();
        for (EnterpristQualityInfo objEnterpristQualityInfo : this)
        {
            list.add(objEnterpristQualityInfo.Copy());
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
		sbStr.append("<ArrayOfEnterpristQualityInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (EnterpristQualityInfo objEnterpristQualityInfo : this)
		{
			sbStr.append("  <EnterpristQualityInfo>\n");
            //企业性质编号
			sbStr.append("    <Qualitydatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpristQualityInfo.getQualitydatabaseid()));
			sbStr.append("</Qualitydatabaseid>\n");
            //QualityID
			sbStr.append("    <Qualityid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpristQualityInfo.getQualityid()));
			sbStr.append("</Qualityid>\n");
            //企业性质名称
			sbStr.append("    <Qualityname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objEnterpristQualityInfo.getQualityname()));
			sbStr.append("</Qualityname>\n");
			sbStr.append("  </EnterpristQualityInfo>\n");
		}
		sbStr.append("</ArrayOfEnterpristQualityInfo>\n");
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
	// GetEnterpristQualityInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetEnterpristQualityInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static EnterpristQualityInfoCollection GetEnterpristQualityInfoCollectionFormFileName(String filename)
	{
		return GetEnterpristQualityInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEnterpristQualityInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpristQualityInfoCollection GetEnterpristQualityInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetEnterpristQualityInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetEnterpristQualityInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetEnterpristQualityInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpristQualityInfoCollection GetEnterpristQualityInfoCollectionFormXml(String xml)
	{
		return GetEnterpristQualityInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetEnterpristQualityInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static EnterpristQualityInfoCollection GetEnterpristQualityInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		EnterpristQualityInfoCollection objEnterpristQualityInfoCollection = new EnterpristQualityInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("EnterpristQualityInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				EnterpristQualityInfo objEnterpristQualityInfo = new EnterpristQualityInfo();
				//企业性质编号
				if (foo.elementText("Qualitydatabaseid") != null)
					objEnterpristQualityInfo.setQualitydatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Qualitydatabaseid")));
				//QualityID
				if (foo.elementText("Qualityid") != null)
					objEnterpristQualityInfo.setQualityid(com.colorwinglib.Converts.objToStr(foo.elementText("Qualityid")));
				//企业性质名称
				if (foo.elementText("Qualityname") != null)
					objEnterpristQualityInfo.setQualityname(com.colorwinglib.Converts.objToStr(foo.elementText("Qualityname")));
				objEnterpristQualityInfoCollection.add(objEnterpristQualityInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objEnterpristQualityInfoCollection;
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
		//企业性质编号
		if ("Qualitydatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpristQualityColumnNameEnum.Qualitydatabaseid, isAsc);
		}

		//QualityID
		if ("Qualityid".equals(columnName) && isAsc == true)
		{
          return sort(EnterpristQualityColumnNameEnum.Qualityid, isAsc);
		}

		//企业性质名称
		if ("Qualityname".equals(columnName) && isAsc == true)
		{
          return sort(EnterpristQualityColumnNameEnum.Qualityname, isAsc);
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
	public boolean sort(EnterpristQualityColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//企业性质编号
		if (EnterpristQualityColumnNameEnum.Qualitydatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpristQualityQualitydatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (EnterpristQualityColumnNameEnum.Qualitydatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpristQualityQualitydatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//QualityID
		if (EnterpristQualityColumnNameEnum.Qualityid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpristQualityQualityidComparatorAsc());// 顺序
			return true;
		}
		if (EnterpristQualityColumnNameEnum.Qualityid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpristQualityQualityidComparatorDesc());// 倒叙
			return true;
		}

		//企业性质名称
		if (EnterpristQualityColumnNameEnum.Qualityname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new EnterpristQualityQualitynameComparatorAsc());// 顺序
			return true;
		}
		if (EnterpristQualityColumnNameEnum.Qualityname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new EnterpristQualityQualitynameComparatorDesc());// 倒叙
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
		for (EnterpristQualityInfo objEnterpristQualityInfo : this)
		{
			objJSONArray.put(objEnterpristQualityInfo.toJson());
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
				EnterpristQualityInfo objEnterpristQualityInfo = new EnterpristQualityInfo();
				objEnterpristQualityInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objEnterpristQualityInfo);
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
	// [start] 按 Qualitydatabaseid 企业性质编号 正序排序
/**
 * 按 Qualitydatabaseid 企业性质编号 正序排序
 *
 */
class EnterpristQualityQualitydatabaseidComparatorAsc implements Comparator<EnterpristQualityInfo>
{
	public int compare(EnterpristQualityInfo arg0, EnterpristQualityInfo arg1)
	{
		if (arg0.getQualitydatabaseid() > arg1.getQualitydatabaseid())
			return 1;
		else if (arg0.getQualitydatabaseid() < arg1.getQualitydatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Qualitydatabaseid 企业性质编号 倒叙排序
/**
 * 按 Qualitydatabaseid 企业性质编号 倒叙排序
 *
 */
class EnterpristQualityQualitydatabaseidComparatorDesc implements Comparator<EnterpristQualityInfo>
{

	public int compare(EnterpristQualityInfo arg0, EnterpristQualityInfo arg1)
	{
		if (arg0.getQualitydatabaseid() > arg1.getQualitydatabaseid())
			return -1;
		else if (arg0.getQualitydatabaseid() < arg1.getQualitydatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Qualityid QualityID正序排序
/**
 * 按 Qualityid QualityID 正序排序
 *
 */
class EnterpristQualityQualityidComparatorAsc implements Comparator<EnterpristQualityInfo>
{
	public int compare(EnterpristQualityInfo arg0, EnterpristQualityInfo arg1)
	{
		return arg0.getQualityid().toLowerCase().compareTo(arg1.getQualityid().toLowerCase());
	}
}
	// [end]

	// [start] 按 Qualityid QualityID 倒叙排序
/**
 * 按 Qualityid QualityID 倒叙排序
 *
 */
class EnterpristQualityQualityidComparatorDesc implements Comparator<EnterpristQualityInfo>
{

	public int compare(EnterpristQualityInfo arg0, EnterpristQualityInfo arg1)
	{
		return arg1.getQualityid().toLowerCase().compareTo(arg0.getQualityid().toLowerCase());
	}
}
	// [end]


	// [start] 按 Qualityname 企业性质名称正序排序
/**
 * 按 Qualityname 企业性质名称 正序排序
 *
 */
class EnterpristQualityQualitynameComparatorAsc implements Comparator<EnterpristQualityInfo>
{
	public int compare(EnterpristQualityInfo arg0, EnterpristQualityInfo arg1)
	{
		return arg0.getQualityname().toLowerCase().compareTo(arg1.getQualityname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Qualityname 企业性质名称 倒叙排序
/**
 * 按 Qualityname 企业性质名称 倒叙排序
 *
 */
class EnterpristQualityQualitynameComparatorDesc implements Comparator<EnterpristQualityInfo>
{

	public int compare(EnterpristQualityInfo arg0, EnterpristQualityInfo arg1)
	{
		return arg1.getQualityname().toLowerCase().compareTo(arg0.getQualityname().toLowerCase());
	}
}
	// [end]


	// [end]

