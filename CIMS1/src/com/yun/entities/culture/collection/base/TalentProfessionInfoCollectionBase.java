package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.TalentProfessionInfoBase.*;

/**
 * TalentProfession 人才所属行业的摘要说明
 */
public class TalentProfessionInfoCollectionBase extends ArrayList<TalentProfessionInfo> implements List<TalentProfessionInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311575667174L;

	// [start] 根据主键或自增字段返回TalentProfessionInfo

        // [start] GetTalentProfessionInfoByTalentprofessiondatabaseid
        // [start] GetTalentProfessionInfoByTalentprofessiondatabaseid
        /**
        * 根据TalentProfessiondatabaseID获取表 人才所属行业的对象TalentProfessionInfo
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return TalentProfessionInfo对象实体
        */
        public TalentProfessionInfo GetTalentProfessionInfoByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
        {
              return GetTalentProfessionInfoByTalentprofessiondatabaseid(Talentprofessiondatabaseid,  true);
        }
        // [end]

        // [start] GetTalentProfessionInfoByTalentprofessiondatabaseid
        private int GetTalentProfessionInfoByTalentprofessiondatabaseid_Talentprofessiondatabaseid = 0;//TalentProfessiondatabaseID
        private TalentProfessionInfo GetTalentProfessionInfoByTalentprofessiondatabaseid_TalentProfessionInfo;
        /**
        * 根据TalentProfessiondatabaseID获取表 人才所属行业的对象TalentProfessionInfo
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return TalentProfessionInfo对象实体
        */
        public TalentProfessionInfo GetTalentProfessionInfoByTalentprofessiondatabaseid(int Talentprofessiondatabaseid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetTalentProfessionInfoByTalentprofessiondatabaseid_TalentProfessionInfo = null;
                if (GetTalentProfessionInfoByTalentprofessiondatabaseid_TalentProfessionInfo == null || GetTalentProfessionInfoByTalentprofessiondatabaseid_Talentprofessiondatabaseid != Talentprofessiondatabaseid)
            {
            for (TalentProfessionInfo objTalentProfessionInfo : this)
            {
                if (objTalentProfessionInfo.getTalentprofessiondatabaseid() == Talentprofessiondatabaseid)
                {
                    GetTalentProfessionInfoByTalentprofessiondatabaseid_TalentProfessionInfo = objTalentProfessionInfo;
                    GetTalentProfessionInfoByTalentprofessiondatabaseid_Talentprofessiondatabaseid = Talentprofessiondatabaseid;//TalentProfessiondatabaseID
                    return objTalentProfessionInfo;
                }
            }
            return null;
            }
            else
            {
                return GetTalentProfessionInfoByTalentprofessiondatabaseid_TalentProfessionInfo;
            }
        }
        // [end]

        // [start] GetIndexByTalentprofessiondatabaseid
        /**
        * 根据TalentProfessiondatabaseID获取表 人才所属行业的对象TalentProfessionInfo 的位置
        * @param Talentprofessiondatabaseid TalentProfessiondatabaseID 
        * @return TalentProfessionInfo对象实体 的位置
        */
        public int GetIndexByTalentprofessiondatabaseid(int Talentprofessiondatabaseid)
        {
             int index = 0;
            for (TalentProfessionInfo objTalentProfessionInfo : this)
            {
                if (objTalentProfessionInfo.getTalentprofessiondatabaseid() == Talentprofessiondatabaseid)
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

	// [start] 根据索引返回TalentProfessionInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public TalentProfessionInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new TalentProfessionInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		TalentProfessionInfoCollection list = new TalentProfessionInfoCollection();
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
    public TalentProfessionInfoCollection Copy()
    {
        TalentProfessionInfoCollection list = new TalentProfessionInfoCollection();
        for (TalentProfessionInfo objTalentProfessionInfo : this)
        {
            list.add(objTalentProfessionInfo.Copy());
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
		sbStr.append("<ArrayOfTalentProfessionInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (TalentProfessionInfo objTalentProfessionInfo : this)
		{
			sbStr.append("  <TalentProfessionInfo>\n");
            //TalentProfessiondatabaseID
			sbStr.append("    <Talentprofessiondatabaseid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentProfessionInfo.getTalentprofessiondatabaseid()));
			sbStr.append("</Talentprofessiondatabaseid>\n");
            //人才所属行业
			sbStr.append("    <Talentprofessionid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentProfessionInfo.getTalentprofessionid()));
			sbStr.append("</Talentprofessionid>\n");
            //行业类型名称
			sbStr.append("    <Talentprofessionname>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objTalentProfessionInfo.getTalentprofessionname()));
			sbStr.append("</Talentprofessionname>\n");
			sbStr.append("  </TalentProfessionInfo>\n");
		}
		sbStr.append("</ArrayOfTalentProfessionInfo>\n");
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
	// GetTalentProfessionInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetTalentProfessionInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static TalentProfessionInfoCollection GetTalentProfessionInfoCollectionFormFileName(String filename)
	{
		return GetTalentProfessionInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTalentProfessionInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentProfessionInfoCollection GetTalentProfessionInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetTalentProfessionInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetTalentProfessionInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetTalentProfessionInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentProfessionInfoCollection GetTalentProfessionInfoCollectionFormXml(String xml)
	{
		return GetTalentProfessionInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetTalentProfessionInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static TalentProfessionInfoCollection GetTalentProfessionInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		TalentProfessionInfoCollection objTalentProfessionInfoCollection = new TalentProfessionInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("TalentProfessionInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				TalentProfessionInfo objTalentProfessionInfo = new TalentProfessionInfo();
				//TalentProfessiondatabaseID
				if (foo.elementText("Talentprofessiondatabaseid") != null)
					objTalentProfessionInfo.setTalentprofessiondatabaseid(com.colorwinglib.Converts.StrToInt(foo.elementText("Talentprofessiondatabaseid")));
				//人才所属行业
				if (foo.elementText("Talentprofessionid") != null)
					objTalentProfessionInfo.setTalentprofessionid(com.colorwinglib.Converts.StrToInt(foo.elementText("Talentprofessionid")));
				//行业类型名称
				if (foo.elementText("Talentprofessionname") != null)
					objTalentProfessionInfo.setTalentprofessionname(com.colorwinglib.Converts.objToStr(foo.elementText("Talentprofessionname")));
				objTalentProfessionInfoCollection.add(objTalentProfessionInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objTalentProfessionInfoCollection;
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
		//TalentProfessiondatabaseID
		if ("Talentprofessiondatabaseid".equals(columnName) && isAsc == true)
		{
          return sort(TalentProfessionColumnNameEnum.Talentprofessiondatabaseid, isAsc);
		}

		//人才所属行业
		if ("Talentprofessionid".equals(columnName) && isAsc == true)
		{
          return sort(TalentProfessionColumnNameEnum.Talentprofessionid, isAsc);
		}

		//行业类型名称
		if ("Talentprofessionname".equals(columnName) && isAsc == true)
		{
          return sort(TalentProfessionColumnNameEnum.Talentprofessionname, isAsc);
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
	public boolean sort(TalentProfessionColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//TalentProfessiondatabaseID
		if (TalentProfessionColumnNameEnum.Talentprofessiondatabaseid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentProfessionTalentprofessiondatabaseidComparatorAsc());// 顺序
			return true;
		}
		if (TalentProfessionColumnNameEnum.Talentprofessiondatabaseid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentProfessionTalentprofessiondatabaseidComparatorDesc());// 倒叙
			return true;
		}

		//人才所属行业
		if (TalentProfessionColumnNameEnum.Talentprofessionid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentProfessionTalentprofessionidComparatorAsc());// 顺序
			return true;
		}
		if (TalentProfessionColumnNameEnum.Talentprofessionid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentProfessionTalentprofessionidComparatorDesc());// 倒叙
			return true;
		}

		//行业类型名称
		if (TalentProfessionColumnNameEnum.Talentprofessionname.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new TalentProfessionTalentprofessionnameComparatorAsc());// 顺序
			return true;
		}
		if (TalentProfessionColumnNameEnum.Talentprofessionname.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new TalentProfessionTalentprofessionnameComparatorDesc());// 倒叙
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
		for (TalentProfessionInfo objTalentProfessionInfo : this)
		{
			objJSONArray.put(objTalentProfessionInfo.toJson());
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
				TalentProfessionInfo objTalentProfessionInfo = new TalentProfessionInfo();
				objTalentProfessionInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objTalentProfessionInfo);
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
	// [start] 按 Talentprofessiondatabaseid TalentProfessiondatabaseID 正序排序
/**
 * 按 Talentprofessiondatabaseid TalentProfessiondatabaseID 正序排序
 *
 */
class TalentProfessionTalentprofessiondatabaseidComparatorAsc implements Comparator<TalentProfessionInfo>
{
	public int compare(TalentProfessionInfo arg0, TalentProfessionInfo arg1)
	{
		if (arg0.getTalentprofessiondatabaseid() > arg1.getTalentprofessiondatabaseid())
			return 1;
		else if (arg0.getTalentprofessiondatabaseid() < arg1.getTalentprofessiondatabaseid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Talentprofessiondatabaseid TalentProfessiondatabaseID 倒叙排序
/**
 * 按 Talentprofessiondatabaseid TalentProfessiondatabaseID 倒叙排序
 *
 */
class TalentProfessionTalentprofessiondatabaseidComparatorDesc implements Comparator<TalentProfessionInfo>
{

	public int compare(TalentProfessionInfo arg0, TalentProfessionInfo arg1)
	{
		if (arg0.getTalentprofessiondatabaseid() > arg1.getTalentprofessiondatabaseid())
			return -1;
		else if (arg0.getTalentprofessiondatabaseid() < arg1.getTalentprofessiondatabaseid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Talentprofessionid 人才所属行业 正序排序
/**
 * 按 Talentprofessionid 人才所属行业 正序排序
 *
 */
class TalentProfessionTalentprofessionidComparatorAsc implements Comparator<TalentProfessionInfo>
{
	public int compare(TalentProfessionInfo arg0, TalentProfessionInfo arg1)
	{
		if (arg0.getTalentprofessionid() > arg1.getTalentprofessionid())
			return 1;
		else if (arg0.getTalentprofessionid() < arg1.getTalentprofessionid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Talentprofessionid 人才所属行业 倒叙排序
/**
 * 按 Talentprofessionid 人才所属行业 倒叙排序
 *
 */
class TalentProfessionTalentprofessionidComparatorDesc implements Comparator<TalentProfessionInfo>
{

	public int compare(TalentProfessionInfo arg0, TalentProfessionInfo arg1)
	{
		if (arg0.getTalentprofessionid() > arg1.getTalentprofessionid())
			return -1;
		else if (arg0.getTalentprofessionid() < arg1.getTalentprofessionid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Talentprofessionname 行业类型名称正序排序
/**
 * 按 Talentprofessionname 行业类型名称 正序排序
 *
 */
class TalentProfessionTalentprofessionnameComparatorAsc implements Comparator<TalentProfessionInfo>
{
	public int compare(TalentProfessionInfo arg0, TalentProfessionInfo arg1)
	{
		return arg0.getTalentprofessionname().toLowerCase().compareTo(arg1.getTalentprofessionname().toLowerCase());
	}
}
	// [end]

	// [start] 按 Talentprofessionname 行业类型名称 倒叙排序
/**
 * 按 Talentprofessionname 行业类型名称 倒叙排序
 *
 */
class TalentProfessionTalentprofessionnameComparatorDesc implements Comparator<TalentProfessionInfo>
{

	public int compare(TalentProfessionInfo arg0, TalentProfessionInfo arg1)
	{
		return arg1.getTalentprofessionname().toLowerCase().compareTo(arg0.getTalentprofessionname().toLowerCase());
	}
}
	// [end]


	// [end]

