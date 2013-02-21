/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:28:34
   功能说明: 表t_dictionary 的业务类DictionaryInfo的业务层基类
   表说明:
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Dictionary  的实体DictionaryInfo的数据操作类
 *
 */
public class DictionaryProviderBase
{
	// [start] 设置和获取静态属性列表 DictionaryStatic, 默认值:null
	// 设置和获取静态属性列表 DictionaryStatic, 默认值:null 开始
	private static DictionaryInfoCollection dictionaryStatic = null;
	/**
	* 获取 静态属性列表 DictionaryStatic, 默认值:null
	 *
	 * @return 静态属性列表 DictionaryStatic, 默认值:null
	 */
	public static DictionaryInfoCollection getDictionaryStatic()
	{
		if (dictionaryStatic == null)
		  dictionaryStatic = new DictionaryDAL().GetListBy();
		return dictionaryStatic;
	}
	/**
	 * 设置 静态属性列表 DictionaryStatic, 默认值:null
	 *
	 * @param sDictionaryStatic
	 *            静态属性列表 DictionaryStatic, 默认值:null
	 */
	public static void setDictionaryStatic(DictionaryInfoCollection sDictionaryStatic)
	{
		dictionaryStatic = sDictionaryStatic;
		setDictionaryInfoStaticByDictionaryid (null);
	}
	// 设置和获取静态属性列表 DictionaryStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.DictionaryInfo objDictionaryInfo : getDictionaryStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objDictionaryInfo.getDictionaryid(), objDictionaryInfo.getTablename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetDictionaryInfoStaticByDictionaryid
	// [start] 设置和获取静态属性列表 DictionaryInfoStaticByDictionaryid, 默认值:null
	// 设置和获取静态属性列表 DictionaryInfoStaticByDictionaryid, 默认值:null 开始
	private static DictionaryInfoCollection DictionaryInfoStaticByDictionaryid = null;
	/**
	* 获取 静态属性列表 DictionaryInfoStaticByDictionaryid, 默认值:null
	 *
	 * @return 静态属性列表 DictionaryInfoStaticByDictionaryid, 默认值:null
	 */
	public static DictionaryInfoCollection getDictionaryInfoStaticByDictionaryid()
	{
		return DictionaryInfoStaticByDictionaryid;
	}
	/**
	 * 设置 静态属性列表 DictionaryInfoStaticByDictionaryid, 默认值:null
	 *
	 * @param sDictionaryInfoStaticByDictionaryid
	 *            静态属性列表 DictionaryInfoStaticByDictionaryid, 默认值:null
	 */
	public static void setDictionaryInfoStaticByDictionaryid(DictionaryInfoCollection sDictionaryInfoStaticByDictionaryid)
	{
		DictionaryInfoStaticByDictionaryid = sDictionaryInfoStaticByDictionaryid;
	}
	// 设置和获取静态属性列表 DictionaryInfoStaticByDictionaryid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 获取表t_dictionary 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param Dictionaryid DictionaryId
        * @return DictionaryInfo对象实体
        */
        public static DictionaryInfo GetDictionaryInfoStaticByDictionaryid(int Dictionaryid)
        {
            if (DictionaryInfoStaticByDictionaryid == null)
                DictionaryInfoStaticByDictionaryid = new DictionaryInfoCollection();
            int allcount = DictionaryInfoStaticByDictionaryid.size();
            DictionaryInfo objDictionaryInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (DictionaryInfoStaticByDictionaryid == null)
                    break;
                    objDictionaryInfo = DictionaryInfoStaticByDictionaryid.get(i);
                if (objDictionaryInfo == null)
                    break;
                if (objDictionaryInfo.getDictionaryid() == Dictionaryid)
                {
                    return objDictionaryInfo;
                }
            }
            DictionaryInfo obj= new DictionaryDAL().GetDictionaryInfoByDictionaryid(Dictionaryid);

            if (obj != null)
            {
                if (DictionaryInfoStaticByDictionaryid != null)
                    DictionaryInfoStaticByDictionaryid.add(obj);
                return obj;
            }
            else
            {
                return new DictionaryInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByDictionaryid
        // [start] CountByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param Dictionaryid DictionaryId
        * @return 数据量
        */
        public static int CountByDictionaryid(int Dictionaryid)
        {
            return new DictionaryDAL().CountByDictionaryid(Dictionaryid);
        }
        // [end]
        // [start] CountByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param Dictionaryid DictionaryId
        * @return 数据量
        */
        public static int CountByDictionaryid(DataProvider dp, int Dictionaryid)
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByDictionaryid(Dictionaryid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new DictionaryDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据列表的强类型实体类
        */
        public static DictionaryInfoCollection GetListBy()
        {
            return new DictionaryDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据列表的强类型实体类
        */
        public static DictionaryInfoCollection GetListBy(DataProvider dp )
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据列表的强类型实体类
        */
        public static DictionaryInfoCollection GetListBy(String OrderBy)
        {
            return new DictionaryDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据列表的强类型实体类
        */
        public static DictionaryInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据列表的强类型实体类
        */
        public static DictionaryInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new DictionaryDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new DictionaryDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据列表的强类型实体类
        */
        public static DictionaryInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new DictionaryDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new DictionaryDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据列表的强类型实体类
        */
        public static DictionaryInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_dictionary 的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据列表的强类型实体类
        */
        public static DictionaryInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_dictionary 的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetDictionaryInfoByDictionaryid
        // [start] GetDictionaryInfoByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 获取表t_dictionary 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param Dictionaryid DictionaryId
        * @return DictionaryInfo对象实体
        */
        public static DictionaryInfo GetDictionaryInfoByDictionaryid(int Dictionaryid)
        {
            return new DictionaryDAL().GetDictionaryInfoByDictionaryid(Dictionaryid);
        }
        // [end]
        // [start] GetDictionaryInfoByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 获取表t_dictionary 的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param Dictionaryid DictionaryId
        * @return DictionaryInfo对象实体
        */
        public static DictionaryInfo GetDictionaryInfoByDictionaryid(DataProvider dp, int Dictionaryid)
        {
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetDictionaryInfoByDictionaryid(Dictionaryid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_dictionary 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param objDictionaryInfo DictionaryInfo对象 
        */
  public static boolean Insert(DictionaryInfo objDictionaryInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objDictionaryInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_dictionary 中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param objDictionaryInfo DictionaryInfo对象 
        */
  public static boolean Insert(DataProvider dp, DictionaryInfo objDictionaryInfo)
	{
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objDictionaryInfo);
      setDictionaryStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_dictionary", "添加", objDictionaryInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByDictionaryid
        // [start] UpdateByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 更新表t_dictionary 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param objDictionaryInfo DictionaryInfo对象 
        */
  public static boolean UpdateByDictionaryid(DictionaryInfo objDictionaryInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByDictionaryid(dp, objDictionaryInfo);
	}

	// [end]
        // [start] UpdateByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 更新表t_dictionary 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param objDictionaryInfo DictionaryInfo对象 
        */
  public static boolean UpdateByDictionaryid(DataProvider dp, DictionaryInfo objDictionaryInfo)
	{
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Dictionaryid =  objDictionaryInfo.getDictionaryid();//DictionaryId  数据类型:int
      DictionaryInfo objOld =  dal.GetDictionaryInfoByDictionaryid(Dictionaryid);// 读取实体信息
		dal.UpdateByDictionaryid(objDictionaryInfo);
		setDictionaryStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objDictionaryInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objDictionaryInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_dictionary", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByDictionaryid
        // [start] DeleteByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 删除数据表t_dictionary 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param Dictionaryid DictionaryId
        */
	public static boolean DeleteByDictionaryid(int Dictionaryid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByDictionaryid(dp, Dictionaryid);
	}

	// [end]
        // [start] DeleteByDictionaryid
        /**
        * 根据 <br />
    * DictionaryId Dictionaryid DictionaryId<br />
 删除数据表t_dictionary 中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:28:34
        *
        * @param Dictionaryid DictionaryId
        */
	public static boolean DeleteByDictionaryid(DataProvider dp, int Dictionaryid)
	{
		DictionaryDAL dal = new DictionaryDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      DictionaryInfo objOld =  dal.GetDictionaryInfoByDictionaryid(Dictionaryid);// 读取实体信息
		dal.DeleteByDictionaryid(Dictionaryid);
		setDictionaryStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_dictionary", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}