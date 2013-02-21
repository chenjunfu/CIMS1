package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.CityinfoInfoBase.*;

/**
 * Cityinfo 城市的摘要说明
 */
public class CityinfoInfoCollectionBase extends ArrayList<CityinfoInfo> implements List<CityinfoInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311460093724L;

	// [start] 根据主键或自增字段返回CityinfoInfo

        // [start] GetCityinfoInfoByCityid
        // [start] GetCityinfoInfoByCityid
        /**
        * 根据N_CityID获取表 城市的对象CityinfoInfo
        * @param Cityid 城市id 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return CityinfoInfo对象实体
        */
        public CityinfoInfo GetCityinfoInfoByCityid(int Cityid)
        {
              return GetCityinfoInfoByCityid(Cityid,  true);
        }
        // [end]

        // [start] GetCityinfoInfoByCityid
        private int GetCityinfoInfoByCityid_Cityid = 0;//城市id
        private CityinfoInfo GetCityinfoInfoByCityid_CityinfoInfo;
        /**
        * 根据N_CityID获取表 城市的对象CityinfoInfo
        * @param Cityid 城市id 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return CityinfoInfo对象实体
        */
        public CityinfoInfo GetCityinfoInfoByCityid(int Cityid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetCityinfoInfoByCityid_CityinfoInfo = null;
                if (GetCityinfoInfoByCityid_CityinfoInfo == null || GetCityinfoInfoByCityid_Cityid != Cityid)
            {
            for (CityinfoInfo objCityinfoInfo : this)
            {
                if (objCityinfoInfo.getCityid() == Cityid)
                {
                    GetCityinfoInfoByCityid_CityinfoInfo = objCityinfoInfo;
                    GetCityinfoInfoByCityid_Cityid = Cityid;//城市id
                    return objCityinfoInfo;
                }
            }
            return null;
            }
            else
            {
                return GetCityinfoInfoByCityid_CityinfoInfo;
            }
        }
        // [end]

        // [start] GetIndexByCityid
        /**
        * 根据N_CityID获取表 城市的对象CityinfoInfo 的位置
        * @param Cityid 城市id 
        * @return CityinfoInfo对象实体 的位置
        */
        public int GetIndexByCityid(int Cityid)
        {
             int index = 0;
            for (CityinfoInfo objCityinfoInfo : this)
            {
                if (objCityinfoInfo.getCityid() == Cityid)
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

	// [start] 根据索引返回CityinfoInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public CityinfoInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new CityinfoInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		CityinfoInfoCollection list = new CityinfoInfoCollection();
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
    public CityinfoInfoCollection Copy()
    {
        CityinfoInfoCollection list = new CityinfoInfoCollection();
        for (CityinfoInfo objCityinfoInfo : this)
        {
            list.add(objCityinfoInfo.Copy());
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
		sbStr.append("<ArrayOfCityinfoInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (CityinfoInfo objCityinfoInfo : this)
		{
			sbStr.append("  <CityinfoInfo>\n");
            //城市id
			sbStr.append("    <Cityid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objCityinfoInfo.getCityid()));
			sbStr.append("</Cityid>\n");
            //父id
			sbStr.append("    <Parentid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objCityinfoInfo.getParentid()));
			sbStr.append("</Parentid>\n");
            //城市名称
			sbStr.append("    <Cityname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objCityinfoInfo.getCityname()));
			sbStr.append("</Cityname>\n");
            //排序id
			sbStr.append("    <Orderid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objCityinfoInfo.getOrderid()));
			sbStr.append("</Orderid>\n");
			sbStr.append("  </CityinfoInfo>\n");
		}
		sbStr.append("</ArrayOfCityinfoInfo>\n");
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
	// GetCityinfoInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetCityinfoInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static CityinfoInfoCollection GetCityinfoInfoCollectionFormFileName(String filename)
	{
		return GetCityinfoInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetCityinfoInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static CityinfoInfoCollection GetCityinfoInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetCityinfoInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetCityinfoInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetCityinfoInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static CityinfoInfoCollection GetCityinfoInfoCollectionFormXml(String xml)
	{
		return GetCityinfoInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetCityinfoInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static CityinfoInfoCollection GetCityinfoInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		CityinfoInfoCollection objCityinfoInfoCollection = new CityinfoInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("CityinfoInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				CityinfoInfo objCityinfoInfo = new CityinfoInfo();
				//城市id
				if (foo.elementText("Cityid") != null)
					objCityinfoInfo.setCityid(com.colorwinglib.Converts.StrToInt(foo.elementText("Cityid")));
				//父id
				if (foo.elementText("Parentid") != null)
					objCityinfoInfo.setParentid(com.colorwinglib.Converts.StrToInt(foo.elementText("Parentid")));
				//城市名称
				if (foo.elementText("Cityname") != null)
					objCityinfoInfo.setCityname(com.colorwinglib.Converts.objToStr(foo.elementText("Cityname")));
				//排序id
				if (foo.elementText("Orderid") != null)
					objCityinfoInfo.setOrderid(com.colorwinglib.Converts.StrToInt(foo.elementText("Orderid")));
				objCityinfoInfoCollection.add(objCityinfoInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objCityinfoInfoCollection;
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
		//城市id
		if ("Cityid".equals(columnName) && isAsc == true)
		{
          return sort(CityinfoColumnNameEnum.Cityid, isAsc);
		}

		//父id
		if ("Parentid".equals(columnName) && isAsc == true)
		{
          return sort(CityinfoColumnNameEnum.Parentid, isAsc);
		}

		//城市名称
		if ("Cityname".equals(columnName) && isAsc == true)
		{
          return sort(CityinfoColumnNameEnum.Cityname, isAsc);
		}

		//排序id
		if ("Orderid".equals(columnName) && isAsc == true)
		{
          return sort(CityinfoColumnNameEnum.Orderid, isAsc);
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
	public boolean sort(CityinfoColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//城市id
		if (CityinfoColumnNameEnum.Cityid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new CityinfoCityidComparatorAsc());// 顺序
			return true;
		}
		if (CityinfoColumnNameEnum.Cityid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new CityinfoCityidComparatorDesc());// 倒叙
			return true;
		}

		//父id
		if (CityinfoColumnNameEnum.Parentid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new CityinfoParentidComparatorAsc());// 顺序
			return true;
		}
		if (CityinfoColumnNameEnum.Parentid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new CityinfoParentidComparatorDesc());// 倒叙
			return true;
		}

		//城市名称
		if (CityinfoColumnNameEnum.Cityname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new CityinfoCitynameComparatorAsc());// 顺序
			return true;
		}
		if (CityinfoColumnNameEnum.Cityname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new CityinfoCitynameComparatorDesc());// 倒叙
			return true;
		}

		//排序id
		if (CityinfoColumnNameEnum.Orderid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new CityinfoOrderidComparatorAsc());// 顺序
			return true;
		}
		if (CityinfoColumnNameEnum.Orderid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new CityinfoOrderidComparatorDesc());// 倒叙
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
		for (CityinfoInfo objCityinfoInfo : this)
		{
			objJSONArray.put(objCityinfoInfo.toJson());
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
				CityinfoInfo objCityinfoInfo = new CityinfoInfo();
				objCityinfoInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objCityinfoInfo);
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
	// [start] 按 Cityid 城市id 正序排序
/**
 * 按 Cityid 城市id 正序排序
 *
 */
class CityinfoCityidComparatorAsc implements Comparator<CityinfoInfo>
{
	public int compare(CityinfoInfo arg0, CityinfoInfo arg1)
	{
		if (arg0.getCityid() > arg1.getCityid())
			return 1;
		else if (arg0.getCityid() < arg1.getCityid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Cityid 城市id 倒叙排序
/**
 * 按 Cityid 城市id 倒叙排序
 *
 */
class CityinfoCityidComparatorDesc implements Comparator<CityinfoInfo>
{

	public int compare(CityinfoInfo arg0, CityinfoInfo arg1)
	{
		if (arg0.getCityid() > arg1.getCityid())
			return -1;
		else if (arg0.getCityid() < arg1.getCityid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Parentid 父id 正序排序
/**
 * 按 Parentid 父id 正序排序
 *
 */
class CityinfoParentidComparatorAsc implements Comparator<CityinfoInfo>
{
	public int compare(CityinfoInfo arg0, CityinfoInfo arg1)
	{
		if (arg0.getParentid() > arg1.getParentid())
			return 1;
		else if (arg0.getParentid() < arg1.getParentid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Parentid 父id 倒叙排序
/**
 * 按 Parentid 父id 倒叙排序
 *
 */
class CityinfoParentidComparatorDesc implements Comparator<CityinfoInfo>
{

	public int compare(CityinfoInfo arg0, CityinfoInfo arg1)
	{
		if (arg0.getParentid() > arg1.getParentid())
			return -1;
		else if (arg0.getParentid() < arg1.getParentid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Cityname 城市名称正序排序
/**
 * 按 Cityname 城市名称 正序排序
 *
 */
class CityinfoCitynameComparatorAsc implements Comparator<CityinfoInfo>
{
	public int compare(CityinfoInfo arg0, CityinfoInfo arg1)
	{
		return arg0.getCityname().toLowerCase().compareTo(arg1.getCityname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Cityname 城市名称 倒叙排序
/**
 * 按 Cityname 城市名称 倒叙排序
 *
 */
class CityinfoCitynameComparatorDesc implements Comparator<CityinfoInfo>
{

	public int compare(CityinfoInfo arg0, CityinfoInfo arg1)
	{
		return arg1.getCityname().toLowerCase().compareTo(arg0.getCityname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Orderid 排序id 正序排序
/**
 * 按 Orderid 排序id 正序排序
 *
 */
class CityinfoOrderidComparatorAsc implements Comparator<CityinfoInfo>
{
	public int compare(CityinfoInfo arg0, CityinfoInfo arg1)
	{
		if (arg0.getOrderid() > arg1.getOrderid())
			return 1;
		else if (arg0.getOrderid() < arg1.getOrderid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Orderid 排序id 倒叙排序
/**
 * 按 Orderid 排序id 倒叙排序
 *
 */
class CityinfoOrderidComparatorDesc implements Comparator<CityinfoInfo>
{

	public int compare(CityinfoInfo arg0, CityinfoInfo arg1)
	{
		if (arg0.getOrderid() > arg1.getOrderid())
			return -1;
		else if (arg0.getOrderid() < arg1.getOrderid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [end]

