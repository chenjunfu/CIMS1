package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.UnitInfoBase.*;

/**
 * Unit 单位信息的摘要说明
 */
public class UnitInfoCollectionBase extends ArrayList<UnitInfo> implements List<UnitInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311582850052L;

	// [start] 根据主键或自增字段返回UnitInfo

        // [start] GetUnitInfoByDatabaseunitid
        // [start] GetUnitInfoByDatabaseunitid
        /**
        * 根据DatabaseUnitID获取表 单位信息的对象UnitInfo
        * @param Databaseunitid 单位ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return UnitInfo对象实体
        */
        public UnitInfo GetUnitInfoByDatabaseunitid(int Databaseunitid)
        {
              return GetUnitInfoByDatabaseunitid(Databaseunitid,  true);
        }
        // [end]

        // [start] GetUnitInfoByDatabaseunitid
        private int GetUnitInfoByDatabaseunitid_Databaseunitid = 0;//单位ID
        private UnitInfo GetUnitInfoByDatabaseunitid_UnitInfo;
        /**
        * 根据DatabaseUnitID获取表 单位信息的对象UnitInfo
        * @param Databaseunitid 单位ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return UnitInfo对象实体
        */
        public UnitInfo GetUnitInfoByDatabaseunitid(int Databaseunitid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetUnitInfoByDatabaseunitid_UnitInfo = null;
                if (GetUnitInfoByDatabaseunitid_UnitInfo == null || GetUnitInfoByDatabaseunitid_Databaseunitid != Databaseunitid)
            {
            for (UnitInfo objUnitInfo : this)
            {
                if (objUnitInfo.getDatabaseunitid() == Databaseunitid)
                {
                    GetUnitInfoByDatabaseunitid_UnitInfo = objUnitInfo;
                    GetUnitInfoByDatabaseunitid_Databaseunitid = Databaseunitid;//单位ID
                    return objUnitInfo;
                }
            }
            return null;
            }
            else
            {
                return GetUnitInfoByDatabaseunitid_UnitInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabaseunitid
        /**
        * 根据DatabaseUnitID获取表 单位信息的对象UnitInfo 的位置
        * @param Databaseunitid 单位ID 
        * @return UnitInfo对象实体 的位置
        */
        public int GetIndexByDatabaseunitid(int Databaseunitid)
        {
             int index = 0;
            for (UnitInfo objUnitInfo : this)
            {
                if (objUnitInfo.getDatabaseunitid() == Databaseunitid)
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

	// [start] 根据索引返回UnitInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public UnitInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new UnitInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		UnitInfoCollection list = new UnitInfoCollection();
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
    public UnitInfoCollection Copy()
    {
        UnitInfoCollection list = new UnitInfoCollection();
        for (UnitInfo objUnitInfo : this)
        {
            list.add(objUnitInfo.Copy());
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
		sbStr.append("<ArrayOfUnitInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (UnitInfo objUnitInfo : this)
		{
			sbStr.append("  <UnitInfo>\n");
            //单位ID
			sbStr.append("    <Databaseunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objUnitInfo.getDatabaseunitid()));
			sbStr.append("</Databaseunitid>\n");
            //单位编号
			sbStr.append("    <Unitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objUnitInfo.getUnitid()));
			sbStr.append("</Unitid>\n");
            //单位名称
			sbStr.append("    <Unitname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objUnitInfo.getUnitname()));
			sbStr.append("</Unitname>\n");
            //单位地址
			sbStr.append("    <Adress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objUnitInfo.getAdress()));
			sbStr.append("</Adress>\n");
            //联系电话
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objUnitInfo.getPhone()));
			sbStr.append("</Phone>\n");
			sbStr.append("  </UnitInfo>\n");
		}
		sbStr.append("</ArrayOfUnitInfo>\n");
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
	// GetUnitInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetUnitInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static UnitInfoCollection GetUnitInfoCollectionFormFileName(String filename)
	{
		return GetUnitInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetUnitInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static UnitInfoCollection GetUnitInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetUnitInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetUnitInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetUnitInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static UnitInfoCollection GetUnitInfoCollectionFormXml(String xml)
	{
		return GetUnitInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetUnitInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static UnitInfoCollection GetUnitInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		UnitInfoCollection objUnitInfoCollection = new UnitInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("UnitInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				UnitInfo objUnitInfo = new UnitInfo();
				//单位ID
				if (foo.elementText("Databaseunitid") != null)
					objUnitInfo.setDatabaseunitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseunitid")));
				//单位编号
				if (foo.elementText("Unitid") != null)
					objUnitInfo.setUnitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Unitid")));
				//单位名称
				if (foo.elementText("Unitname") != null)
					objUnitInfo.setUnitname(com.colorwinglib.Converts.objToStr(foo.elementText("Unitname")));
				//单位地址
				if (foo.elementText("Adress") != null)
					objUnitInfo.setAdress(com.colorwinglib.Converts.objToStr(foo.elementText("Adress")));
				//联系电话
				if (foo.elementText("Phone") != null)
					objUnitInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				objUnitInfoCollection.add(objUnitInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objUnitInfoCollection;
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
		//单位ID
		if ("Databaseunitid".equals(columnName) && isAsc == true)
		{
          return sort(UnitColumnNameEnum.Databaseunitid, isAsc);
		}

		//单位编号
		if ("Unitid".equals(columnName) && isAsc == true)
		{
          return sort(UnitColumnNameEnum.Unitid, isAsc);
		}

		//单位名称
		if ("Unitname".equals(columnName) && isAsc == true)
		{
          return sort(UnitColumnNameEnum.Unitname, isAsc);
		}

		//单位地址
		if ("Adress".equals(columnName) && isAsc == true)
		{
          return sort(UnitColumnNameEnum.Adress, isAsc);
		}

		//联系电话
		if ("Phone".equals(columnName) && isAsc == true)
		{
          return sort(UnitColumnNameEnum.Phone, isAsc);
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
	public boolean sort(UnitColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//单位ID
		if (UnitColumnNameEnum.Databaseunitid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new UnitDatabaseunitidComparatorAsc());// 顺序
			return true;
		}
		if (UnitColumnNameEnum.Databaseunitid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new UnitDatabaseunitidComparatorDesc());// 倒叙
			return true;
		}

		//单位编号
		if (UnitColumnNameEnum.Unitid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new UnitUnitidComparatorAsc());// 顺序
			return true;
		}
		if (UnitColumnNameEnum.Unitid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new UnitUnitidComparatorDesc());// 倒叙
			return true;
		}

		//单位名称
		if (UnitColumnNameEnum.Unitname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new UnitUnitnameComparatorAsc());// 顺序
			return true;
		}
		if (UnitColumnNameEnum.Unitname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new UnitUnitnameComparatorDesc());// 倒叙
			return true;
		}

		//单位地址
		if (UnitColumnNameEnum.Adress.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new UnitAdressComparatorAsc());// 顺序
			return true;
		}
		if (UnitColumnNameEnum.Adress.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new UnitAdressComparatorDesc());// 倒叙
			return true;
		}

		//联系电话
		if (UnitColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new UnitPhoneComparatorAsc());// 顺序
			return true;
		}
		if (UnitColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new UnitPhoneComparatorDesc());// 倒叙
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
		for (UnitInfo objUnitInfo : this)
		{
			objJSONArray.put(objUnitInfo.toJson());
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
				UnitInfo objUnitInfo = new UnitInfo();
				objUnitInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objUnitInfo);
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
	// [start] 按 Databaseunitid 单位ID 正序排序
/**
 * 按 Databaseunitid 单位ID 正序排序
 *
 */
class UnitDatabaseunitidComparatorAsc implements Comparator<UnitInfo>
{
	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		if (arg0.getDatabaseunitid() > arg1.getDatabaseunitid())
			return 1;
		else if (arg0.getDatabaseunitid() < arg1.getDatabaseunitid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databaseunitid 单位ID 倒叙排序
/**
 * 按 Databaseunitid 单位ID 倒叙排序
 *
 */
class UnitDatabaseunitidComparatorDesc implements Comparator<UnitInfo>
{

	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		if (arg0.getDatabaseunitid() > arg1.getDatabaseunitid())
			return -1;
		else if (arg0.getDatabaseunitid() < arg1.getDatabaseunitid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Unitid 单位编号 正序排序
/**
 * 按 Unitid 单位编号 正序排序
 *
 */
class UnitUnitidComparatorAsc implements Comparator<UnitInfo>
{
	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		if (arg0.getUnitid() > arg1.getUnitid())
			return 1;
		else if (arg0.getUnitid() < arg1.getUnitid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Unitid 单位编号 倒叙排序
/**
 * 按 Unitid 单位编号 倒叙排序
 *
 */
class UnitUnitidComparatorDesc implements Comparator<UnitInfo>
{

	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		if (arg0.getUnitid() > arg1.getUnitid())
			return -1;
		else if (arg0.getUnitid() < arg1.getUnitid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Unitname 单位名称正序排序
/**
 * 按 Unitname 单位名称 正序排序
 *
 */
class UnitUnitnameComparatorAsc implements Comparator<UnitInfo>
{
	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		return arg0.getUnitname().toLowerCase().compareTo(arg1.getUnitname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Unitname 单位名称 倒叙排序
/**
 * 按 Unitname 单位名称 倒叙排序
 *
 */
class UnitUnitnameComparatorDesc implements Comparator<UnitInfo>
{

	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		return arg1.getUnitname().toLowerCase().compareTo(arg0.getUnitname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Adress 单位地址正序排序
/**
 * 按 Adress 单位地址 正序排序
 *
 */
class UnitAdressComparatorAsc implements Comparator<UnitInfo>
{
	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		return arg0.getAdress().toLowerCase().compareTo(arg1.getAdress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Adress 单位地址 倒叙排序
/**
 * 按 Adress 单位地址 倒叙排序
 *
 */
class UnitAdressComparatorDesc implements Comparator<UnitInfo>
{

	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		return arg1.getAdress().toLowerCase().compareTo(arg0.getAdress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Phone 联系电话正序排序
/**
 * 按 Phone 联系电话 正序排序
 *
 */
class UnitPhoneComparatorAsc implements Comparator<UnitInfo>
{
	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		return arg0.getPhone().toLowerCase().compareTo(arg1.getPhone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Phone 联系电话 倒叙排序
/**
 * 按 Phone 联系电话 倒叙排序
 *
 */
class UnitPhoneComparatorDesc implements Comparator<UnitInfo>
{

	public int compare(UnitInfo arg0, UnitInfo arg1)
	{
		return arg1.getPhone().toLowerCase().compareTo(arg0.getPhone().toLowerCase());
	}
}
	// [end]


	// [end]

