package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.IndustryDutyunitInfoBase.*;

/**
 * IndustryDutyunit 主管单位表的摘要说明
 */
public class IndustryDutyunitInfoCollectionBase extends ArrayList<IndustryDutyunitInfo> implements List<IndustryDutyunitInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311484109373L;

	// [start] 根据主键或自增字段返回IndustryDutyunitInfo

        // [start] GetIndustryDutyunitInfoByDutyunitid
        // [start] GetIndustryDutyunitInfoByDutyunitid
        /**
        * 根据DutyUnitID获取表 主管单位表的对象IndustryDutyunitInfo
        * @param Dutyunitid 责主管位编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryDutyunitInfo对象实体
        */
        public IndustryDutyunitInfo GetIndustryDutyunitInfoByDutyunitid(int Dutyunitid)
        {
              return GetIndustryDutyunitInfoByDutyunitid(Dutyunitid,  true);
        }
        // [end]

        // [start] GetIndustryDutyunitInfoByDutyunitid
        private int GetIndustryDutyunitInfoByDutyunitid_Dutyunitid = 0;//责主管位编号
        private IndustryDutyunitInfo GetIndustryDutyunitInfoByDutyunitid_IndustryDutyunitInfo;
        /**
        * 根据DutyUnitID获取表 主管单位表的对象IndustryDutyunitInfo
        * @param Dutyunitid 责主管位编号 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return IndustryDutyunitInfo对象实体
        */
        public IndustryDutyunitInfo GetIndustryDutyunitInfoByDutyunitid(int Dutyunitid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetIndustryDutyunitInfoByDutyunitid_IndustryDutyunitInfo = null;
                if (GetIndustryDutyunitInfoByDutyunitid_IndustryDutyunitInfo == null || GetIndustryDutyunitInfoByDutyunitid_Dutyunitid != Dutyunitid)
            {
            for (IndustryDutyunitInfo objIndustryDutyunitInfo : this)
            {
                if (objIndustryDutyunitInfo.getDutyunitid() == Dutyunitid)
                {
                    GetIndustryDutyunitInfoByDutyunitid_IndustryDutyunitInfo = objIndustryDutyunitInfo;
                    GetIndustryDutyunitInfoByDutyunitid_Dutyunitid = Dutyunitid;//责主管位编号
                    return objIndustryDutyunitInfo;
                }
            }
            return null;
            }
            else
            {
                return GetIndustryDutyunitInfoByDutyunitid_IndustryDutyunitInfo;
            }
        }
        // [end]

        // [start] GetIndexByDutyunitid
        /**
        * 根据DutyUnitID获取表 主管单位表的对象IndustryDutyunitInfo 的位置
        * @param Dutyunitid 责主管位编号 
        * @return IndustryDutyunitInfo对象实体 的位置
        */
        public int GetIndexByDutyunitid(int Dutyunitid)
        {
             int index = 0;
            for (IndustryDutyunitInfo objIndustryDutyunitInfo : this)
            {
                if (objIndustryDutyunitInfo.getDutyunitid() == Dutyunitid)
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

	// [start] 根据索引返回IndustryDutyunitInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public IndustryDutyunitInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new IndustryDutyunitInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		IndustryDutyunitInfoCollection list = new IndustryDutyunitInfoCollection();
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
    public IndustryDutyunitInfoCollection Copy()
    {
        IndustryDutyunitInfoCollection list = new IndustryDutyunitInfoCollection();
        for (IndustryDutyunitInfo objIndustryDutyunitInfo : this)
        {
            list.add(objIndustryDutyunitInfo.Copy());
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
		sbStr.append("<ArrayOfIndustryDutyunitInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (IndustryDutyunitInfo objIndustryDutyunitInfo : this)
		{
			sbStr.append("  <IndustryDutyunitInfo>\n");
            //责主管位编号
			sbStr.append("    <Dutyunitid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryDutyunitInfo.getDutyunitid()));
			sbStr.append("</Dutyunitid>\n");
            //主管单位名
			sbStr.append("    <Dutyunitname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryDutyunitInfo.getDutyunitname()));
			sbStr.append("</Dutyunitname>\n");
            //联系人
			sbStr.append("    <Linkman>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryDutyunitInfo.getLinkman()));
			sbStr.append("</Linkman>\n");
            //联系电话
			sbStr.append("    <Telphone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objIndustryDutyunitInfo.getTelphone()));
			sbStr.append("</Telphone>\n");
			sbStr.append("  </IndustryDutyunitInfo>\n");
		}
		sbStr.append("</ArrayOfIndustryDutyunitInfo>\n");
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
	// GetIndustryDutyunitInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetIndustryDutyunitInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static IndustryDutyunitInfoCollection GetIndustryDutyunitInfoCollectionFormFileName(String filename)
	{
		return GetIndustryDutyunitInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryDutyunitInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryDutyunitInfoCollection GetIndustryDutyunitInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetIndustryDutyunitInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetIndustryDutyunitInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetIndustryDutyunitInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryDutyunitInfoCollection GetIndustryDutyunitInfoCollectionFormXml(String xml)
	{
		return GetIndustryDutyunitInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetIndustryDutyunitInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static IndustryDutyunitInfoCollection GetIndustryDutyunitInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		IndustryDutyunitInfoCollection objIndustryDutyunitInfoCollection = new IndustryDutyunitInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("IndustryDutyunitInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				IndustryDutyunitInfo objIndustryDutyunitInfo = new IndustryDutyunitInfo();
				//责主管位编号
				if (foo.elementText("Dutyunitid") != null)
					objIndustryDutyunitInfo.setDutyunitid(com.colorwinglib.Converts.StrToInt(foo.elementText("Dutyunitid")));
				//主管单位名
				if (foo.elementText("Dutyunitname") != null)
					objIndustryDutyunitInfo.setDutyunitname(com.colorwinglib.Converts.objToStr(foo.elementText("Dutyunitname")));
				//联系人
				if (foo.elementText("Linkman") != null)
					objIndustryDutyunitInfo.setLinkman(com.colorwinglib.Converts.objToStr(foo.elementText("Linkman")));
				//联系电话
				if (foo.elementText("Telphone") != null)
					objIndustryDutyunitInfo.setTelphone(com.colorwinglib.Converts.objToStr(foo.elementText("Telphone")));
				objIndustryDutyunitInfoCollection.add(objIndustryDutyunitInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objIndustryDutyunitInfoCollection;
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
		//责主管位编号
		if ("Dutyunitid".equals(columnName) && isAsc == true)
		{
          return sort(IndustryDutyunitColumnNameEnum.Dutyunitid, isAsc);
		}

		//主管单位名
		if ("Dutyunitname".equals(columnName) && isAsc == true)
		{
          return sort(IndustryDutyunitColumnNameEnum.Dutyunitname, isAsc);
		}

		//联系人
		if ("Linkman".equals(columnName) && isAsc == true)
		{
          return sort(IndustryDutyunitColumnNameEnum.Linkman, isAsc);
		}

		//联系电话
		if ("Telphone".equals(columnName) && isAsc == true)
		{
          return sort(IndustryDutyunitColumnNameEnum.Telphone, isAsc);
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
	public boolean sort(IndustryDutyunitColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//责主管位编号
		if (IndustryDutyunitColumnNameEnum.Dutyunitid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryDutyunitDutyunitidComparatorAsc());// 顺序
			return true;
		}
		if (IndustryDutyunitColumnNameEnum.Dutyunitid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryDutyunitDutyunitidComparatorDesc());// 倒叙
			return true;
		}

		//主管单位名
		if (IndustryDutyunitColumnNameEnum.Dutyunitname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryDutyunitDutyunitnameComparatorAsc());// 顺序
			return true;
		}
		if (IndustryDutyunitColumnNameEnum.Dutyunitname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryDutyunitDutyunitnameComparatorDesc());// 倒叙
			return true;
		}

		//联系人
		if (IndustryDutyunitColumnNameEnum.Linkman.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryDutyunitLinkmanComparatorAsc());// 顺序
			return true;
		}
		if (IndustryDutyunitColumnNameEnum.Linkman.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryDutyunitLinkmanComparatorDesc());// 倒叙
			return true;
		}

		//联系电话
		if (IndustryDutyunitColumnNameEnum.Telphone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new IndustryDutyunitTelphoneComparatorAsc());// 顺序
			return true;
		}
		if (IndustryDutyunitColumnNameEnum.Telphone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new IndustryDutyunitTelphoneComparatorDesc());// 倒叙
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
		for (IndustryDutyunitInfo objIndustryDutyunitInfo : this)
		{
			objJSONArray.put(objIndustryDutyunitInfo.toJson());
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
				IndustryDutyunitInfo objIndustryDutyunitInfo = new IndustryDutyunitInfo();
				objIndustryDutyunitInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objIndustryDutyunitInfo);
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
	// [start] 按 Dutyunitid 责主管位编号 正序排序
/**
 * 按 Dutyunitid 责主管位编号 正序排序
 *
 */
class IndustryDutyunitDutyunitidComparatorAsc implements Comparator<IndustryDutyunitInfo>
{
	public int compare(IndustryDutyunitInfo arg0, IndustryDutyunitInfo arg1)
	{
		if (arg0.getDutyunitid() > arg1.getDutyunitid())
			return 1;
		else if (arg0.getDutyunitid() < arg1.getDutyunitid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Dutyunitid 责主管位编号 倒叙排序
/**
 * 按 Dutyunitid 责主管位编号 倒叙排序
 *
 */
class IndustryDutyunitDutyunitidComparatorDesc implements Comparator<IndustryDutyunitInfo>
{

	public int compare(IndustryDutyunitInfo arg0, IndustryDutyunitInfo arg1)
	{
		if (arg0.getDutyunitid() > arg1.getDutyunitid())
			return -1;
		else if (arg0.getDutyunitid() < arg1.getDutyunitid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Dutyunitname 主管单位名正序排序
/**
 * 按 Dutyunitname 主管单位名 正序排序
 *
 */
class IndustryDutyunitDutyunitnameComparatorAsc implements Comparator<IndustryDutyunitInfo>
{
	public int compare(IndustryDutyunitInfo arg0, IndustryDutyunitInfo arg1)
	{
		return arg0.getDutyunitname().toLowerCase().compareTo(arg1.getDutyunitname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Dutyunitname 主管单位名 倒叙排序
/**
 * 按 Dutyunitname 主管单位名 倒叙排序
 *
 */
class IndustryDutyunitDutyunitnameComparatorDesc implements Comparator<IndustryDutyunitInfo>
{

	public int compare(IndustryDutyunitInfo arg0, IndustryDutyunitInfo arg1)
	{
		return arg1.getDutyunitname().toLowerCase().compareTo(arg0.getDutyunitname().toLowerCase());
	}
}
	// [end]


	// [start] 按 Linkman 联系人正序排序
/**
 * 按 Linkman 联系人 正序排序
 *
 */
class IndustryDutyunitLinkmanComparatorAsc implements Comparator<IndustryDutyunitInfo>
{
	public int compare(IndustryDutyunitInfo arg0, IndustryDutyunitInfo arg1)
	{
		return arg0.getLinkman().toLowerCase().compareTo(arg1.getLinkman().toLowerCase());
	}
}
	// [end]

	// [start] 按 Linkman 联系人 倒叙排序
/**
 * 按 Linkman 联系人 倒叙排序
 *
 */
class IndustryDutyunitLinkmanComparatorDesc implements Comparator<IndustryDutyunitInfo>
{

	public int compare(IndustryDutyunitInfo arg0, IndustryDutyunitInfo arg1)
	{
		return arg1.getLinkman().toLowerCase().compareTo(arg0.getLinkman().toLowerCase());
	}
}
	// [end]


	// [start] 按 Telphone 联系电话正序排序
/**
 * 按 Telphone 联系电话 正序排序
 *
 */
class IndustryDutyunitTelphoneComparatorAsc implements Comparator<IndustryDutyunitInfo>
{
	public int compare(IndustryDutyunitInfo arg0, IndustryDutyunitInfo arg1)
	{
		return arg0.getTelphone().toLowerCase().compareTo(arg1.getTelphone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Telphone 联系电话 倒叙排序
/**
 * 按 Telphone 联系电话 倒叙排序
 *
 */
class IndustryDutyunitTelphoneComparatorDesc implements Comparator<IndustryDutyunitInfo>
{

	public int compare(IndustryDutyunitInfo arg0, IndustryDutyunitInfo arg1)
	{
		return arg1.getTelphone().toLowerCase().compareTo(arg0.getTelphone().toLowerCase());
	}
}
	// [end]


	// [end]

