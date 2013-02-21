package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.PeoplesectorInfoBase.*;

/**
 * Peoplesector 部门信息表的摘要说明
 */
public class PeoplesectorInfoCollectionBase extends ArrayList<PeoplesectorInfo> implements List<PeoplesectorInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311520387567L;

	// [start] 根据主键或自增字段返回PeoplesectorInfo

        // [start] GetPeoplesectorInfoByDatabasepeoplesectorid
        // [start] GetPeoplesectorInfoByDatabasepeoplesectorid
        /**
        * 根据DatabasePeoplesectorID获取表 部门信息表的对象PeoplesectorInfo
        * @param Databasepeoplesectorid 部门ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return PeoplesectorInfo对象实体
        */
        public PeoplesectorInfo GetPeoplesectorInfoByDatabasepeoplesectorid(int Databasepeoplesectorid)
        {
              return GetPeoplesectorInfoByDatabasepeoplesectorid(Databasepeoplesectorid,  true);
        }
        // [end]

        // [start] GetPeoplesectorInfoByDatabasepeoplesectorid
        private int GetPeoplesectorInfoByDatabasepeoplesectorid_Databasepeoplesectorid = 0;//部门ID
        private PeoplesectorInfo GetPeoplesectorInfoByDatabasepeoplesectorid_PeoplesectorInfo;
        /**
        * 根据DatabasePeoplesectorID获取表 部门信息表的对象PeoplesectorInfo
        * @param Databasepeoplesectorid 部门ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return PeoplesectorInfo对象实体
        */
        public PeoplesectorInfo GetPeoplesectorInfoByDatabasepeoplesectorid(int Databasepeoplesectorid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetPeoplesectorInfoByDatabasepeoplesectorid_PeoplesectorInfo = null;
                if (GetPeoplesectorInfoByDatabasepeoplesectorid_PeoplesectorInfo == null || GetPeoplesectorInfoByDatabasepeoplesectorid_Databasepeoplesectorid != Databasepeoplesectorid)
            {
            for (PeoplesectorInfo objPeoplesectorInfo : this)
            {
                if (objPeoplesectorInfo.getDatabasepeoplesectorid() == Databasepeoplesectorid)
                {
                    GetPeoplesectorInfoByDatabasepeoplesectorid_PeoplesectorInfo = objPeoplesectorInfo;
                    GetPeoplesectorInfoByDatabasepeoplesectorid_Databasepeoplesectorid = Databasepeoplesectorid;//部门ID
                    return objPeoplesectorInfo;
                }
            }
            return null;
            }
            else
            {
                return GetPeoplesectorInfoByDatabasepeoplesectorid_PeoplesectorInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabasepeoplesectorid
        /**
        * 根据DatabasePeoplesectorID获取表 部门信息表的对象PeoplesectorInfo 的位置
        * @param Databasepeoplesectorid 部门ID 
        * @return PeoplesectorInfo对象实体 的位置
        */
        public int GetIndexByDatabasepeoplesectorid(int Databasepeoplesectorid)
        {
             int index = 0;
            for (PeoplesectorInfo objPeoplesectorInfo : this)
            {
                if (objPeoplesectorInfo.getDatabasepeoplesectorid() == Databasepeoplesectorid)
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

	// [start] 根据索引返回PeoplesectorInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public PeoplesectorInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new PeoplesectorInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		PeoplesectorInfoCollection list = new PeoplesectorInfoCollection();
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
    public PeoplesectorInfoCollection Copy()
    {
        PeoplesectorInfoCollection list = new PeoplesectorInfoCollection();
        for (PeoplesectorInfo objPeoplesectorInfo : this)
        {
            list.add(objPeoplesectorInfo.Copy());
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
		sbStr.append("<ArrayOfPeoplesectorInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (PeoplesectorInfo objPeoplesectorInfo : this)
		{
			sbStr.append("  <PeoplesectorInfo>\n");
            //部门ID
			sbStr.append("    <Databasepeoplesectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeoplesectorInfo.getDatabasepeoplesectorid()));
			sbStr.append("</Databasepeoplesectorid>\n");
            //部门编号
			sbStr.append("    <Peoplesectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeoplesectorInfo.getPeoplesectorid()));
			sbStr.append("</Peoplesectorid>\n");
            //部门名称
			sbStr.append("    <Peoplesectorname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeoplesectorInfo.getPeoplesectorname()));
			sbStr.append("</Peoplesectorname>\n");
            //办公住址
			sbStr.append("    <Adress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeoplesectorInfo.getAdress()));
			sbStr.append("</Adress>\n");
            //电话
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeoplesectorInfo.getPhone()));
			sbStr.append("</Phone>\n");
            //单位编号
			sbStr.append("    <Databaseunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeoplesectorInfo.getDatabaseunitid()));
			sbStr.append("</Databaseunitid>\n");
			sbStr.append("  </PeoplesectorInfo>\n");
		}
		sbStr.append("</ArrayOfPeoplesectorInfo>\n");
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
	// GetPeoplesectorInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetPeoplesectorInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static PeoplesectorInfoCollection GetPeoplesectorInfoCollectionFormFileName(String filename)
	{
		return GetPeoplesectorInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPeoplesectorInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeoplesectorInfoCollection GetPeoplesectorInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetPeoplesectorInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetPeoplesectorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetPeoplesectorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeoplesectorInfoCollection GetPeoplesectorInfoCollectionFormXml(String xml)
	{
		return GetPeoplesectorInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPeoplesectorInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeoplesectorInfoCollection GetPeoplesectorInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		PeoplesectorInfoCollection objPeoplesectorInfoCollection = new PeoplesectorInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("PeoplesectorInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				PeoplesectorInfo objPeoplesectorInfo = new PeoplesectorInfo();
				//部门ID
				if (foo.elementText("Databasepeoplesectorid") != null)
					objPeoplesectorInfo.setDatabasepeoplesectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeoplesectorid")));
				//部门编号
				if (foo.elementText("Peoplesectorid") != null)
					objPeoplesectorInfo.setPeoplesectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Peoplesectorid")));
				//部门名称
				if (foo.elementText("Peoplesectorname") != null)
					objPeoplesectorInfo.setPeoplesectorname(com.colorwinglib.Converts.objToStr(foo.elementText("Peoplesectorname")));
				//办公住址
				if (foo.elementText("Adress") != null)
					objPeoplesectorInfo.setAdress(com.colorwinglib.Converts.objToStr(foo.elementText("Adress")));
				//电话
				if (foo.elementText("Phone") != null)
					objPeoplesectorInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//单位编号
				if (foo.elementText("Databaseunitid") != null)
					objPeoplesectorInfo.setDatabaseunitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databaseunitid")));
				objPeoplesectorInfoCollection.add(objPeoplesectorInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objPeoplesectorInfoCollection;
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
		//部门ID
		if ("Databasepeoplesectorid".equals(columnName) && isAsc == true)
		{
          return sort(PeoplesectorColumnNameEnum.Databasepeoplesectorid, isAsc);
		}

		//部门编号
		if ("Peoplesectorid".equals(columnName) && isAsc == true)
		{
          return sort(PeoplesectorColumnNameEnum.Peoplesectorid, isAsc);
		}

		//部门名称
		if ("Peoplesectorname".equals(columnName) && isAsc == true)
		{
          return sort(PeoplesectorColumnNameEnum.Peoplesectorname, isAsc);
		}

		//办公住址
		if ("Adress".equals(columnName) && isAsc == true)
		{
          return sort(PeoplesectorColumnNameEnum.Adress, isAsc);
		}

		//电话
		if ("Phone".equals(columnName) && isAsc == true)
		{
          return sort(PeoplesectorColumnNameEnum.Phone, isAsc);
		}

		//单位编号
		if ("Databaseunitid".equals(columnName) && isAsc == true)
		{
          return sort(PeoplesectorColumnNameEnum.Databaseunitid, isAsc);
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
	public boolean sort(PeoplesectorColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//部门ID
		if (PeoplesectorColumnNameEnum.Databasepeoplesectorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplesectorDatabasepeoplesectoridComparatorAsc());// 顺序
			return true;
		}
		if (PeoplesectorColumnNameEnum.Databasepeoplesectorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplesectorDatabasepeoplesectoridComparatorDesc());// 倒叙
			return true;
		}

		//部门编号
		if (PeoplesectorColumnNameEnum.Peoplesectorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplesectorPeoplesectoridComparatorAsc());// 顺序
			return true;
		}
		if (PeoplesectorColumnNameEnum.Peoplesectorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplesectorPeoplesectoridComparatorDesc());// 倒叙
			return true;
		}

		//部门名称
		if (PeoplesectorColumnNameEnum.Peoplesectorname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplesectorPeoplesectornameComparatorAsc());// 顺序
			return true;
		}
		if (PeoplesectorColumnNameEnum.Peoplesectorname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplesectorPeoplesectornameComparatorDesc());// 倒叙
			return true;
		}

		//办公住址
		if (PeoplesectorColumnNameEnum.Adress.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplesectorAdressComparatorAsc());// 顺序
			return true;
		}
		if (PeoplesectorColumnNameEnum.Adress.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplesectorAdressComparatorDesc());// 倒叙
			return true;
		}

		//电话
		if (PeoplesectorColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplesectorPhoneComparatorAsc());// 顺序
			return true;
		}
		if (PeoplesectorColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplesectorPhoneComparatorDesc());// 倒叙
			return true;
		}

		//单位编号
		if (PeoplesectorColumnNameEnum.Databaseunitid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplesectorDatabaseunitidComparatorAsc());// 顺序
			return true;
		}
		if (PeoplesectorColumnNameEnum.Databaseunitid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplesectorDatabaseunitidComparatorDesc());// 倒叙
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
		for (PeoplesectorInfo objPeoplesectorInfo : this)
		{
			objJSONArray.put(objPeoplesectorInfo.toJson());
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
				PeoplesectorInfo objPeoplesectorInfo = new PeoplesectorInfo();
				objPeoplesectorInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objPeoplesectorInfo);
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
	// [start] 按 Databasepeoplesectorid 部门ID 正序排序
/**
 * 按 Databasepeoplesectorid 部门ID 正序排序
 *
 */
class PeoplesectorDatabasepeoplesectoridComparatorAsc implements Comparator<PeoplesectorInfo>
{
	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		if (arg0.getDatabasepeoplesectorid() > arg1.getDatabasepeoplesectorid())
			return 1;
		else if (arg0.getDatabasepeoplesectorid() < arg1.getDatabasepeoplesectorid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databasepeoplesectorid 部门ID 倒叙排序
/**
 * 按 Databasepeoplesectorid 部门ID 倒叙排序
 *
 */
class PeoplesectorDatabasepeoplesectoridComparatorDesc implements Comparator<PeoplesectorInfo>
{

	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		if (arg0.getDatabasepeoplesectorid() > arg1.getDatabasepeoplesectorid())
			return -1;
		else if (arg0.getDatabasepeoplesectorid() < arg1.getDatabasepeoplesectorid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Peoplesectorid 部门编号 正序排序
/**
 * 按 Peoplesectorid 部门编号 正序排序
 *
 */
class PeoplesectorPeoplesectoridComparatorAsc implements Comparator<PeoplesectorInfo>
{
	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		if (arg0.getPeoplesectorid() > arg1.getPeoplesectorid())
			return 1;
		else if (arg0.getPeoplesectorid() < arg1.getPeoplesectorid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Peoplesectorid 部门编号 倒叙排序
/**
 * 按 Peoplesectorid 部门编号 倒叙排序
 *
 */
class PeoplesectorPeoplesectoridComparatorDesc implements Comparator<PeoplesectorInfo>
{

	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		if (arg0.getPeoplesectorid() > arg1.getPeoplesectorid())
			return -1;
		else if (arg0.getPeoplesectorid() < arg1.getPeoplesectorid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Peoplesectorname 部门名称正序排序
/**
 * 按 Peoplesectorname 部门名称 正序排序
 *
 */
class PeoplesectorPeoplesectornameComparatorAsc implements Comparator<PeoplesectorInfo>
{
	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		return arg0.getPeoplesectorname().toLowerCase().compareTo(arg1.getPeoplesectorname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Peoplesectorname 部门名称 倒叙排序
/**
 * 按 Peoplesectorname 部门名称 倒叙排序
 *
 */
class PeoplesectorPeoplesectornameComparatorDesc implements Comparator<PeoplesectorInfo>
{

	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		return arg1.getPeoplesectorname().toLowerCase().compareTo(arg0.getPeoplesectorname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Adress 办公住址正序排序
/**
 * 按 Adress 办公住址 正序排序
 *
 */
class PeoplesectorAdressComparatorAsc implements Comparator<PeoplesectorInfo>
{
	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		return arg0.getAdress().toLowerCase().compareTo(arg1.getAdress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Adress 办公住址 倒叙排序
/**
 * 按 Adress 办公住址 倒叙排序
 *
 */
class PeoplesectorAdressComparatorDesc implements Comparator<PeoplesectorInfo>
{

	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		return arg1.getAdress().toLowerCase().compareTo(arg0.getAdress().toLowerCase());
	}
}
	// [end]


	// [start] 按 Phone 电话正序排序
/**
 * 按 Phone 电话 正序排序
 *
 */
class PeoplesectorPhoneComparatorAsc implements Comparator<PeoplesectorInfo>
{
	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		return arg0.getPhone().toLowerCase().compareTo(arg1.getPhone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Phone 电话 倒叙排序
/**
 * 按 Phone 电话 倒叙排序
 *
 */
class PeoplesectorPhoneComparatorDesc implements Comparator<PeoplesectorInfo>
{

	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
	{
		return arg1.getPhone().toLowerCase().compareTo(arg0.getPhone().toLowerCase());
	}
}
	// [end]


	// [start] 按 Databaseunitid 单位编号 正序排序
/**
 * 按 Databaseunitid 单位编号 正序排序
 *
 */
class PeoplesectorDatabaseunitidComparatorAsc implements Comparator<PeoplesectorInfo>
{
	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
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

	// [start] 按 Databaseunitid 单位编号 倒叙排序
/**
 * 按 Databaseunitid 单位编号 倒叙排序
 *
 */
class PeoplesectorDatabaseunitidComparatorDesc implements Comparator<PeoplesectorInfo>
{

	public int compare(PeoplesectorInfo arg0, PeoplesectorInfo arg1)
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


	// [end]

