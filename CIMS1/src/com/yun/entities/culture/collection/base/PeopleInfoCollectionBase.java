package com.yun.entities.culture.collection.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.entities.culture.base.PeopleInfoBase.*;

/**
 * People 人员表的摘要说明
 */
public class PeopleInfoCollectionBase extends ArrayList<PeopleInfo> implements List<PeopleInfo>
{
	/**
	 * Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	private static final long serialVersionUID = 2012120311513903155L;

	// [start] 根据主键或自增字段返回PeopleInfo

        // [start] GetPeopleInfoByDatabasepeopleid
        // [start] GetPeopleInfoByDatabasepeopleid
        /**
        * 根据DatabasePeopleID获取表 人员表的对象PeopleInfo
        * @param Databasepeopleid 人员ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return PeopleInfo对象实体
        */
        public PeopleInfo GetPeopleInfoByDatabasepeopleid(int Databasepeopleid)
        {
              return GetPeopleInfoByDatabasepeopleid(Databasepeopleid,  true);
        }
        // [end]

        // [start] GetPeopleInfoByDatabasepeopleid
        private int GetPeopleInfoByDatabasepeopleid_Databasepeopleid = 0;//人员ID
        private PeopleInfo GetPeopleInfoByDatabasepeopleid_PeopleInfo;
        /**
        * 根据DatabasePeopleID获取表 人员表的对象PeopleInfo
        * @param Databasepeopleid 人员ID 
        * @param isUserCase 是否使用缓存，默认使用 
        * @return PeopleInfo对象实体
        */
        public PeopleInfo GetPeopleInfoByDatabasepeopleid(int Databasepeopleid,  boolean isUserCase)
        {
            if(isUserCase == false)
                    GetPeopleInfoByDatabasepeopleid_PeopleInfo = null;
                if (GetPeopleInfoByDatabasepeopleid_PeopleInfo == null || GetPeopleInfoByDatabasepeopleid_Databasepeopleid != Databasepeopleid)
            {
            for (PeopleInfo objPeopleInfo : this)
            {
                if (objPeopleInfo.getDatabasepeopleid() == Databasepeopleid)
                {
                    GetPeopleInfoByDatabasepeopleid_PeopleInfo = objPeopleInfo;
                    GetPeopleInfoByDatabasepeopleid_Databasepeopleid = Databasepeopleid;//人员ID
                    return objPeopleInfo;
                }
            }
            return null;
            }
            else
            {
                return GetPeopleInfoByDatabasepeopleid_PeopleInfo;
            }
        }
        // [end]

        // [start] GetIndexByDatabasepeopleid
        /**
        * 根据DatabasePeopleID获取表 人员表的对象PeopleInfo 的位置
        * @param Databasepeopleid 人员ID 
        * @return PeopleInfo对象实体 的位置
        */
        public int GetIndexByDatabasepeopleid(int Databasepeopleid)
        {
             int index = 0;
            for (PeopleInfo objPeopleInfo : this)
            {
                if (objPeopleInfo.getDatabasepeopleid() == Databasepeopleid)
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

	// [start] 根据索引返回PeopleInfoCollection



	// [end]

	// [start] 分页列表
	/**
	 * 分页列表
	 *
	 * @param pageIndex 起始页数
	 * @param pageSize 每页大小
	 *
	 */
	public PeopleInfoCollection Pager(int pageIndex, int pageSize)
	{
		int startIndex = (pageIndex - 1) * pageSize;
		int endIndex = pageIndex * pageSize - 1;
		if (startIndex > this.size())
			return new PeopleInfoCollection();

		if (this.size() - 1 < endIndex)
			endIndex = this.size() - 1;

		PeopleInfoCollection list = new PeopleInfoCollection();
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
    public PeopleInfoCollection Copy()
    {
        PeopleInfoCollection list = new PeopleInfoCollection();
        for (PeopleInfo objPeopleInfo : this)
        {
            list.add(objPeopleInfo.Copy());
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
		sbStr.append("<ArrayOfPeopleInfo xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n");
		for (PeopleInfo objPeopleInfo : this)
		{
			sbStr.append("  <PeopleInfo>\n");
            //人员ID
			sbStr.append("    <Databasepeopleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeopleInfo.getDatabasepeopleid()));
			sbStr.append("</Databasepeopleid>\n");
            //人员编号
			sbStr.append("    <Peopleid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeopleInfo.getPeopleid()));
			sbStr.append("</Peopleid>\n");
            //姓名
			sbStr.append("    <Peoplename>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeopleInfo.getPeoplename()));
			sbStr.append("</Peoplename>\n");
            //所属部门
			sbStr.append("    <Databasepeoplesectorid>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeopleInfo.getDatabasepeoplesectorid()));
			sbStr.append("</Databasepeoplesectorid>\n");
            //性别：1-男、2-女
			sbStr.append("    <Sex>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeopleInfo.getSex()));
			sbStr.append("</Sex>\n");
            //办公地址
			sbStr.append("    <Adress>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeopleInfo.getAdress()));
			sbStr.append("</Adress>\n");
            //电话
			sbStr.append("    <Phone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeopleInfo.getPhone()));
			sbStr.append("</Phone>\n");
            //手机
			sbStr.append("    <Cellphone>");
			sbStr.append(com.colorwinglib.StringFormat.HtmlEncode(objPeopleInfo.getCellphone()));
			sbStr.append("</Cellphone>\n");
			sbStr.append("  </PeopleInfo>\n");
		}
		sbStr.append("</ArrayOfPeopleInfo>\n");
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
	// GetPeopleInfoCollectionFormFileName 从文件中反序列化获得实体类

	// [start] GetPeopleInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename文件名
	 */
	public static PeopleInfoCollection GetPeopleInfoCollectionFormFileName(String filename)
	{
		return GetPeopleInfoCollectionFormFileName(filename, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPeopleInfoCollectionFormFileName 从文件中反序列化获得实体类
	/**
	 * 从文件中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeopleInfoCollection GetPeopleInfoCollectionFormFileName(String filename, com.colorwinglib.Encoding encoding)
	{
		String xml = com.colorwinglib.FileFormat.ReadFile(filename, encoding);
		return GetPeopleInfoCollectionFormXml(xml, encoding);
	}

	// [end]

	// GetPeopleInfoCollectionFormXml 从Xml字符串中反序列化获得实体类

	// [start] GetPeopleInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeopleInfoCollection GetPeopleInfoCollectionFormXml(String xml)
	{
		return GetPeopleInfoCollectionFormXml(xml, com.colorwinglib.Encoding.UTF8);
	}

	// [end]

	// [start] GetPeopleInfoCollectionFormXml 从Xml字符串中反序列化获得实体类
	/**
	 * 从Xml字符串中反序列化获得实体类
	 *
	 * @param filename
	 *            文件名
	 */
	public static PeopleInfoCollection GetPeopleInfoCollectionFormXml(String xml, com.colorwinglib.Encoding encoding)
	{
		PeopleInfoCollection objPeopleInfoCollection = new PeopleInfoCollection();
		try
		{
			org.dom4j.Document doc = org.dom4j.DocumentHelper.parseText(xml);

			org.dom4j.Element root = doc.getRootElement();
			org.dom4j.Element foo;
			for (java.util.Iterator i = root.elementIterator("PeopleInfo"); i.hasNext();)
			{
				foo = (org.dom4j.Element) i.next();
				PeopleInfo objPeopleInfo = new PeopleInfo();
				//人员ID
				if (foo.elementText("Databasepeopleid") != null)
					objPeopleInfo.setDatabasepeopleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeopleid")));
				//人员编号
				if (foo.elementText("Peopleid") != null)
					objPeopleInfo.setPeopleid(com.colorwinglib.Converts.StrToInt(foo.elementText("Peopleid")));
				//姓名
				if (foo.elementText("Peoplename") != null)
					objPeopleInfo.setPeoplename(com.colorwinglib.Converts.objToStr(foo.elementText("Peoplename")));
				//所属部门
				if (foo.elementText("Databasepeoplesectorid") != null)
					objPeopleInfo.setDatabasepeoplesectorid(com.colorwinglib.Converts.StrToInt(foo.elementText("Databasepeoplesectorid")));
				//性别：1-男、2-女
				if (foo.elementText("Sex") != null)
					objPeopleInfo.setSex(com.colorwinglib.Converts.StrToInt(foo.elementText("Sex")));
				//办公地址
				if (foo.elementText("Adress") != null)
					objPeopleInfo.setAdress(com.colorwinglib.Converts.objToStr(foo.elementText("Adress")));
				//电话
				if (foo.elementText("Phone") != null)
					objPeopleInfo.setPhone(com.colorwinglib.Converts.objToStr(foo.elementText("Phone")));
				//手机
				if (foo.elementText("Cellphone") != null)
					objPeopleInfo.setCellphone(com.colorwinglib.Converts.objToStr(foo.elementText("Cellphone")));
				objPeopleInfoCollection.add(objPeopleInfo);
			}

		}
		catch (org.dom4j.DocumentException e2)
		{
			
			e2.printStackTrace();
		}

		return objPeopleInfoCollection;
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
		//人员ID
		if ("Databasepeopleid".equals(columnName) && isAsc == true)
		{
          return sort(PeopleColumnNameEnum.Databasepeopleid, isAsc);
		}

		//人员编号
		if ("Peopleid".equals(columnName) && isAsc == true)
		{
          return sort(PeopleColumnNameEnum.Peopleid, isAsc);
		}

		//姓名
		if ("Peoplename".equals(columnName) && isAsc == true)
		{
          return sort(PeopleColumnNameEnum.Peoplename, isAsc);
		}

		//所属部门
		if ("Databasepeoplesectorid".equals(columnName) && isAsc == true)
		{
          return sort(PeopleColumnNameEnum.Databasepeoplesectorid, isAsc);
		}

		//性别：1-男、2-女
		if ("Sex".equals(columnName) && isAsc == true)
		{
          return sort(PeopleColumnNameEnum.Sex, isAsc);
		}

		//办公地址
		if ("Adress".equals(columnName) && isAsc == true)
		{
          return sort(PeopleColumnNameEnum.Adress, isAsc);
		}

		//电话
		if ("Phone".equals(columnName) && isAsc == true)
		{
          return sort(PeopleColumnNameEnum.Phone, isAsc);
		}

		//手机
		if ("Cellphone".equals(columnName) && isAsc == true)
		{
          return sort(PeopleColumnNameEnum.Cellphone, isAsc);
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
	public boolean sort(PeopleColumnNameEnum columnNameEnu, boolean isAsc)
	{

		//人员ID
		if (PeopleColumnNameEnum.Databasepeopleid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeopleDatabasepeopleidComparatorAsc());// 顺序
			return true;
		}
		if (PeopleColumnNameEnum.Databasepeopleid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeopleDatabasepeopleidComparatorDesc());// 倒叙
			return true;
		}

		//人员编号
		if (PeopleColumnNameEnum.Peopleid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplePeopleidComparatorAsc());// 顺序
			return true;
		}
		if (PeopleColumnNameEnum.Peopleid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplePeopleidComparatorDesc());// 倒叙
			return true;
		}

		//姓名
		if (PeopleColumnNameEnum.Peoplename.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplePeoplenameComparatorAsc());// 顺序
			return true;
		}
		if (PeopleColumnNameEnum.Peoplename.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplePeoplenameComparatorDesc());// 倒叙
			return true;
		}

		//所属部门
		if (PeopleColumnNameEnum.Databasepeoplesectorid.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeopleDatabasepeoplesectoridComparatorAsc());// 顺序
			return true;
		}
		if (PeopleColumnNameEnum.Databasepeoplesectorid.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeopleDatabasepeoplesectoridComparatorDesc());// 倒叙
			return true;
		}

		//性别：1-男、2-女
		if (PeopleColumnNameEnum.Sex.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeopleSexComparatorAsc());// 顺序
			return true;
		}
		if (PeopleColumnNameEnum.Sex.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeopleSexComparatorDesc());// 倒叙
			return true;
		}

		//办公地址
		if (PeopleColumnNameEnum.Adress.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeopleAdressComparatorAsc());// 顺序
			return true;
		}
		if (PeopleColumnNameEnum.Adress.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeopleAdressComparatorDesc());// 倒叙
			return true;
		}

		//电话
		if (PeopleColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeoplePhoneComparatorAsc());// 顺序
			return true;
		}
		if (PeopleColumnNameEnum.Phone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeoplePhoneComparatorDesc());// 倒叙
			return true;
		}

		//手机
		if (PeopleColumnNameEnum.Cellphone.equals(columnNameEnu) && isAsc == true)
		{
			java.util.Collections.sort(this, new PeopleCellphoneComparatorAsc());// 顺序
			return true;
		}
		if (PeopleColumnNameEnum.Cellphone.equals(columnNameEnu) && isAsc == false)
		{
			java.util.Collections.sort(this, new PeopleCellphoneComparatorDesc());// 倒叙
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
		for (PeopleInfo objPeopleInfo : this)
		{
			objJSONArray.put(objPeopleInfo.toJson());
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
				PeopleInfo objPeopleInfo = new PeopleInfo();
				objPeopleInfo.FromJson(objJSONArray.getJSONObject(i));
				add(objPeopleInfo);
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
	// [start] 按 Databasepeopleid 人员ID 正序排序
/**
 * 按 Databasepeopleid 人员ID 正序排序
 *
 */
class PeopleDatabasepeopleidComparatorAsc implements Comparator<PeopleInfo>
{
	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		if (arg0.getDatabasepeopleid() > arg1.getDatabasepeopleid())
			return 1;
		else if (arg0.getDatabasepeopleid() < arg1.getDatabasepeopleid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Databasepeopleid 人员ID 倒叙排序
/**
 * 按 Databasepeopleid 人员ID 倒叙排序
 *
 */
class PeopleDatabasepeopleidComparatorDesc implements Comparator<PeopleInfo>
{

	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		if (arg0.getDatabasepeopleid() > arg1.getDatabasepeopleid())
			return -1;
		else if (arg0.getDatabasepeopleid() < arg1.getDatabasepeopleid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Peopleid 人员编号 正序排序
/**
 * 按 Peopleid 人员编号 正序排序
 *
 */
class PeoplePeopleidComparatorAsc implements Comparator<PeopleInfo>
{
	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		if (arg0.getPeopleid() > arg1.getPeopleid())
			return 1;
		else if (arg0.getPeopleid() < arg1.getPeopleid())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Peopleid 人员编号 倒叙排序
/**
 * 按 Peopleid 人员编号 倒叙排序
 *
 */
class PeoplePeopleidComparatorDesc implements Comparator<PeopleInfo>
{

	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		if (arg0.getPeopleid() > arg1.getPeopleid())
			return -1;
		else if (arg0.getPeopleid() < arg1.getPeopleid())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Peoplename 姓名正序排序
/**
 * 按 Peoplename 姓名 正序排序
 *
 */
class PeoplePeoplenameComparatorAsc implements Comparator<PeopleInfo>
{
	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		return arg0.getPeoplename().toLowerCase().compareTo(arg1.getPeoplename().toLowerCase());
	}
}
	// [end]

	// [start] 按 Peoplename 姓名 倒叙排序
/**
 * 按 Peoplename 姓名 倒叙排序
 *
 */
class PeoplePeoplenameComparatorDesc implements Comparator<PeopleInfo>
{

	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		return arg1.getPeoplename().toLowerCase().compareTo(arg0.getPeoplename().toLowerCase());
	}
}
	// [end]


	// [start] 按 Databasepeoplesectorid 所属部门 正序排序
/**
 * 按 Databasepeoplesectorid 所属部门 正序排序
 *
 */
class PeopleDatabasepeoplesectoridComparatorAsc implements Comparator<PeopleInfo>
{
	public int compare(PeopleInfo arg0, PeopleInfo arg1)
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

	// [start] 按 Databasepeoplesectorid 所属部门 倒叙排序
/**
 * 按 Databasepeoplesectorid 所属部门 倒叙排序
 *
 */
class PeopleDatabasepeoplesectoridComparatorDesc implements Comparator<PeopleInfo>
{

	public int compare(PeopleInfo arg0, PeopleInfo arg1)
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


	// [start] 按 Sex 性别：1-男、2-女 正序排序
/**
 * 按 Sex 性别：1-男、2-女 正序排序
 *
 */
class PeopleSexComparatorAsc implements Comparator<PeopleInfo>
{
	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		if (arg0.getSex() > arg1.getSex())
			return 1;
		else if (arg0.getSex() < arg1.getSex())
			return -1;
		else
			return 0;
	}
}
	// [end]

	// [start] 按 Sex 性别：1-男、2-女 倒叙排序
/**
 * 按 Sex 性别：1-男、2-女 倒叙排序
 *
 */
class PeopleSexComparatorDesc implements Comparator<PeopleInfo>
{

	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		if (arg0.getSex() > arg1.getSex())
			return -1;
		else if (arg0.getSex() < arg1.getSex())
			return 1;
		else
			return 0;
	}
}
	// [end]


	// [start] 按 Adress 办公地址正序排序
/**
 * 按 Adress 办公地址 正序排序
 *
 */
class PeopleAdressComparatorAsc implements Comparator<PeopleInfo>
{
	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		return arg0.getAdress().toLowerCase().compareTo(arg1.getAdress().toLowerCase());
	}
}
	// [end]

	// [start] 按 Adress 办公地址 倒叙排序
/**
 * 按 Adress 办公地址 倒叙排序
 *
 */
class PeopleAdressComparatorDesc implements Comparator<PeopleInfo>
{

	public int compare(PeopleInfo arg0, PeopleInfo arg1)
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
class PeoplePhoneComparatorAsc implements Comparator<PeopleInfo>
{
	public int compare(PeopleInfo arg0, PeopleInfo arg1)
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
class PeoplePhoneComparatorDesc implements Comparator<PeopleInfo>
{

	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		return arg1.getPhone().toLowerCase().compareTo(arg0.getPhone().toLowerCase());
	}
}
	// [end]


	// [start] 按 Cellphone 手机正序排序
/**
 * 按 Cellphone 手机 正序排序
 *
 */
class PeopleCellphoneComparatorAsc implements Comparator<PeopleInfo>
{
	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		return arg0.getCellphone().toLowerCase().compareTo(arg1.getCellphone().toLowerCase());
	}
}
	// [end]

	// [start] 按 Cellphone 手机 倒叙排序
/**
 * 按 Cellphone 手机 倒叙排序
 *
 */
class PeopleCellphoneComparatorDesc implements Comparator<PeopleInfo>
{

	public int compare(PeopleInfo arg0, PeopleInfo arg1)
	{
		return arg1.getCellphone().toLowerCase().compareTo(arg0.getCellphone().toLowerCase());
	}
}
	// [end]


	// [end]

