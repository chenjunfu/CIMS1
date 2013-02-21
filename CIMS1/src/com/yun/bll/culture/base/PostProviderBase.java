/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:30:56
   功能说明: 表t_post 职称表的业务类PostInfo的业务层基类
   表说明:职称表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Post 职称表 的实体PostInfo的数据操作类
 *
 */
public class PostProviderBase
{
	// [start] 设置和获取静态属性列表 PostStatic, 默认值:null
	// 设置和获取静态属性列表 PostStatic, 默认值:null 开始
	private static PostInfoCollection postStatic = null;
	/**
	* 获取 静态属性列表 PostStatic, 默认值:null
	 *
	 * @return 静态属性列表 PostStatic, 默认值:null
	 */
	public static PostInfoCollection getPostStatic()
	{
		if (postStatic == null)
		  postStatic = new PostDAL().GetListBy();
		return postStatic;
	}
	/**
	 * 设置 静态属性列表 PostStatic, 默认值:null
	 *
	 * @param sPostStatic
	 *            静态属性列表 PostStatic, 默认值:null
	 */
	public static void setPostStatic(PostInfoCollection sPostStatic)
	{
		postStatic = sPostStatic;
		setPostInfoStaticByTitledatabaseid (null);
	}
	// 设置和获取静态属性列表 PostStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.PostInfo objPostInfo : getPostStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objPostInfo.getTitledatabaseid(), objPostInfo.getTitlename()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetPostInfoStaticByTitledatabaseid
	// [start] 设置和获取静态属性列表 PostInfoStaticByTitledatabaseid, 默认值:null
	// 设置和获取静态属性列表 PostInfoStaticByTitledatabaseid, 默认值:null 开始
	private static PostInfoCollection PostInfoStaticByTitledatabaseid = null;
	/**
	* 获取 静态属性列表 PostInfoStaticByTitledatabaseid, 默认值:null
	 *
	 * @return 静态属性列表 PostInfoStaticByTitledatabaseid, 默认值:null
	 */
	public static PostInfoCollection getPostInfoStaticByTitledatabaseid()
	{
		return PostInfoStaticByTitledatabaseid;
	}
	/**
	 * 设置 静态属性列表 PostInfoStaticByTitledatabaseid, 默认值:null
	 *
	 * @param sPostInfoStaticByTitledatabaseid
	 *            静态属性列表 PostInfoStaticByTitledatabaseid, 默认值:null
	 */
	public static void setPostInfoStaticByTitledatabaseid(PostInfoCollection sPostInfoStaticByTitledatabaseid)
	{
		PostInfoStaticByTitledatabaseid = sPostInfoStaticByTitledatabaseid;
	}
	// 设置和获取静态属性列表 PostInfoStaticByTitledatabaseid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 获取表t_post 职称表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titledatabaseid TitledatabaseID
        * @return PostInfo对象实体
        */
        public static PostInfo GetPostInfoStaticByTitledatabaseid(int Titledatabaseid)
        {
            if (PostInfoStaticByTitledatabaseid == null)
                PostInfoStaticByTitledatabaseid = new PostInfoCollection();
            int allcount = PostInfoStaticByTitledatabaseid.size();
            PostInfo objPostInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (PostInfoStaticByTitledatabaseid == null)
                    break;
                    objPostInfo = PostInfoStaticByTitledatabaseid.get(i);
                if (objPostInfo == null)
                    break;
                if (objPostInfo.getTitledatabaseid() == Titledatabaseid)
                {
                    return objPostInfo;
                }
            }
            PostInfo obj= new PostDAL().GetPostInfoByTitledatabaseid(Titledatabaseid);

            if (obj != null)
            {
                if (PostInfoStaticByTitledatabaseid != null)
                    PostInfoStaticByTitledatabaseid.add(obj);
                return obj;
            }
            else
            {
                return new PostInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByTitledatabaseid
        // [start] CountByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titledatabaseid TitledatabaseID
        * @return 数据量
        */
        public static int CountByTitledatabaseid(int Titledatabaseid)
        {
            return new PostDAL().CountByTitledatabaseid(Titledatabaseid);
        }
        // [end]
        // [start] CountByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titledatabaseid TitledatabaseID
        * @return 数据量
        */
        public static int CountByTitledatabaseid(DataProvider dp, int Titledatabaseid)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByTitledatabaseid(Titledatabaseid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new PostDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountBy();
        }
        // [end]
        // [end]
        // [start] CountByTitleid
        // [start] CountByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据量
        */
        public static int CountByTitleid(int Titleid)
        {
            return new PostDAL().CountByTitleid(Titleid);
        }
        // [end]
        // [start] CountByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据量
        */
        public static int CountByTitleid(DataProvider dp, int Titleid)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByTitleid(Titleid);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetList
        // [start] GetListBy
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListBy()
        {
            return new PostDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListBy(DataProvider dp )
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListBy(String OrderBy)
        {
            return new PostDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy(OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListByTitleid
        // [start] GetListByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListByTitleid(int Titleid)
        {
            return new PostDAL().GetListByTitleid(Titleid);
        }
        // [end]
        // [start] GetListByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListByTitleid(DataProvider dp, int Titleid)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByTitleid(Titleid);
        }
        // [end]
        // [start] GetListByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListByTitleid(int Titleid, String OrderBy)
        {
            return new PostDAL().GetListByTitleid(Titleid, OrderBy);
        }
        // [end]
        // [start] GetListByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListByTitleid(DataProvider dp, int Titleid, String OrderBy)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListByTitleid(Titleid, OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetListPager
        // [start] GetListPagerBy
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new PostDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new PostDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new PostDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new PostDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]
        // [start] GetListPagerByTitleid
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListPagerByTitleid(int Titleid, int pageIndex, int pageSize)
        {
            return new PostDAL().GetListPagerByTitleid(Titleid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据总量
        */
        public static int GetListPagerByTitleid(int Titleid)
        {
            return new PostDAL().GetListPagerByTitleid(Titleid);
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListPagerByTitleid(int Titleid,  String OrderBy, int pageIndex, int pageSize)
        {
            return new PostDAL().GetListPagerByTitleid(Titleid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据总量
        */
        public static int GetListPagerByTitleid(int Titleid, String OrderBy)
        {
            return new PostDAL().GetListPagerByTitleid(Titleid,  OrderBy);
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListPagerByTitleid(DataProvider dp,int Titleid, int pageIndex, int pageSize)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByTitleid(Titleid,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据总量
        */
        public static int GetListPagerByTitleid(DataProvider dp, int Titleid)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByTitleid(Titleid);
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 返回表t_post 职称表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据列表的强类型实体类
        */
        public static PostInfoCollection GetListPagerByTitleid(DataProvider dp, int Titleid,  String OrderBy, int pageIndex, int pageSize)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByTitleid(Titleid,  OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerByTitleid
        /**
        * 根据 <br />
    * TitleID Titleid 职称编号<br />
 统计表t_post 职称表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titleid 职称编号
        * @return 数据总量
        */
        public static int GetListPagerByTitleid(DataProvider dp, int Titleid, String OrderBy)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerByTitleid(Titleid,  OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetPostInfoByTitledatabaseid
        // [start] GetPostInfoByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 获取表t_post 职称表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titledatabaseid TitledatabaseID
        * @return PostInfo对象实体
        */
        public static PostInfo GetPostInfoByTitledatabaseid(int Titledatabaseid)
        {
            return new PostDAL().GetPostInfoByTitledatabaseid(Titledatabaseid);
        }
        // [end]
        // [start] GetPostInfoByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 获取表t_post 职称表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titledatabaseid TitledatabaseID
        * @return PostInfo对象实体
        */
        public static PostInfo GetPostInfoByTitledatabaseid(DataProvider dp, int Titledatabaseid)
        {
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetPostInfoByTitledatabaseid(Titledatabaseid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_post 职称表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param objPostInfo PostInfo对象 职称表
        */
  public static boolean Insert(PostInfo objPostInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objPostInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_post 职称表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param objPostInfo PostInfo对象 职称表
        */
  public static boolean Insert(DataProvider dp, PostInfo objPostInfo)
	{
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objPostInfo);
      setPostStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_post", "添加", objPostInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByTitledatabaseid
        // [start] UpdateByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 更新表t_post 职称表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param objPostInfo PostInfo对象 职称表
        */
  public static boolean UpdateByTitledatabaseid(PostInfo objPostInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByTitledatabaseid(dp, objPostInfo);
	}

	// [end]
        // [start] UpdateByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 更新表t_post 职称表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param objPostInfo PostInfo对象 职称表
        */
  public static boolean UpdateByTitledatabaseid(DataProvider dp, PostInfo objPostInfo)
	{
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Titledatabaseid =  objPostInfo.getTitledatabaseid();//TitledatabaseID  数据类型:int
      PostInfo objOld =  dal.GetPostInfoByTitledatabaseid(Titledatabaseid);// 读取实体信息
		dal.UpdateByTitledatabaseid(objPostInfo);
		setPostStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objPostInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objPostInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_post", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByTitledatabaseid
        // [start] DeleteByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 删除数据表t_post 职称表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titledatabaseid TitledatabaseID
        */
	public static boolean DeleteByTitledatabaseid(int Titledatabaseid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByTitledatabaseid(dp, Titledatabaseid);
	}

	// [end]
        // [start] DeleteByTitledatabaseid
        /**
        * 根据 <br />
    * TitledatabaseID Titledatabaseid TitledatabaseID<br />
 删除数据表t_post 职称表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:30:56
        *
        * @param Titledatabaseid TitledatabaseID
        */
	public static boolean DeleteByTitledatabaseid(DataProvider dp, int Titledatabaseid)
	{
		PostDAL dal = new PostDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      PostInfo objOld =  dal.GetPostInfoByTitledatabaseid(Titledatabaseid);// 读取实体信息
		dal.DeleteByTitledatabaseid(Titledatabaseid);
		setPostStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_post", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}