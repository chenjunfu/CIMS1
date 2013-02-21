/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:31:19
   功能说明: 表t_projectpic 项目图片表的业务类ProjectpicInfo的业务层基类
   表说明:项目图片表
======================================================================*/
package com.yun.bll.culture.base;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.*;

/**
 * 表Projectpic 项目图片表 的实体ProjectpicInfo的数据操作类
 *
 */
public class ProjectpicProviderBase
{
	// [start] 设置和获取静态属性列表 ProjectpicStatic, 默认值:null
	// 设置和获取静态属性列表 ProjectpicStatic, 默认值:null 开始
	private static ProjectpicInfoCollection projectpicStatic = null;
	/**
	* 获取 静态属性列表 ProjectpicStatic, 默认值:null
	 *
	 * @return 静态属性列表 ProjectpicStatic, 默认值:null
	 */
	public static ProjectpicInfoCollection getProjectpicStatic()
	{
		if (projectpicStatic == null)
		  projectpicStatic = new ProjectpicDAL().GetListBy();
		return projectpicStatic;
	}
	/**
	 * 设置 静态属性列表 ProjectpicStatic, 默认值:null
	 *
	 * @param sProjectpicStatic
	 *            静态属性列表 ProjectpicStatic, 默认值:null
	 */
	public static void setProjectpicStatic(ProjectpicInfoCollection sProjectpicStatic)
	{
		projectpicStatic = sProjectpicStatic;
		setProjectpicInfoStaticByProjectpicid (null);
	}
	// 设置和获取静态属性列表 ProjectpicStatic, 默认值:null 结束
	// [end]

	// [start] 获得Html的Option标签
	/**
	 * 获得Html的Option标签
	 */
	public static String getHtmlOption()
	{
		StringBuilder sbStr = new StringBuilder(1024);
		for (com.yun.entities.culture.ProjectpicInfo objProjectpicInfo : getProjectpicStatic())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", objProjectpicInfo.getProjectpicid(), objProjectpicInfo.getProjectpicid()));

		}
		return sbStr.toString();
	}
	// [end]


        // [start] GetObjectStatic
        // [start] GetProjectpicInfoStaticByProjectpicid
	// [start] 设置和获取静态属性列表 ProjectpicInfoStaticByProjectpicid, 默认值:null
	// 设置和获取静态属性列表 ProjectpicInfoStaticByProjectpicid, 默认值:null 开始
	private static ProjectpicInfoCollection ProjectpicInfoStaticByProjectpicid = null;
	/**
	* 获取 静态属性列表 ProjectpicInfoStaticByProjectpicid, 默认值:null
	 *
	 * @return 静态属性列表 ProjectpicInfoStaticByProjectpicid, 默认值:null
	 */
	public static ProjectpicInfoCollection getProjectpicInfoStaticByProjectpicid()
	{
		return ProjectpicInfoStaticByProjectpicid;
	}
	/**
	 * 设置 静态属性列表 ProjectpicInfoStaticByProjectpicid, 默认值:null
	 *
	 * @param sProjectpicInfoStaticByProjectpicid
	 *            静态属性列表 ProjectpicInfoStaticByProjectpicid, 默认值:null
	 */
	public static void setProjectpicInfoStaticByProjectpicid(ProjectpicInfoCollection sProjectpicInfoStaticByProjectpicid)
	{
		ProjectpicInfoStaticByProjectpicid = sProjectpicInfoStaticByProjectpicid;
	}
	// 设置和获取静态属性列表 ProjectpicInfoStaticByProjectpicid, 默认值:null 结束
	// [end]
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 获取表t_projectpic 项目图片表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param Projectpicid 项目图片编号
        * @return ProjectpicInfo对象实体
        */
        public static ProjectpicInfo GetProjectpicInfoStaticByProjectpicid(int Projectpicid)
        {
            if (ProjectpicInfoStaticByProjectpicid == null)
                ProjectpicInfoStaticByProjectpicid = new ProjectpicInfoCollection();
            int allcount = ProjectpicInfoStaticByProjectpicid.size();
            ProjectpicInfo objProjectpicInfo;
            for (int i = 0; i < allcount; i++)
            {
                if (ProjectpicInfoStaticByProjectpicid == null)
                    break;
                    objProjectpicInfo = ProjectpicInfoStaticByProjectpicid.get(i);
                if (objProjectpicInfo == null)
                    break;
                if (objProjectpicInfo.getProjectpicid() == Projectpicid)
                {
                    return objProjectpicInfo;
                }
            }
            ProjectpicInfo obj= new ProjectpicDAL().GetProjectpicInfoByProjectpicid(Projectpicid);

            if (obj != null)
            {
                if (ProjectpicInfoStaticByProjectpicid != null)
                    ProjectpicInfoStaticByProjectpicid.add(obj);
                return obj;
            }
            else
            {
                return new ProjectpicInfo();
            }
        }
        // [end]

        // [end]

        // [start] Count
        // [start] CountByProjectpicid
        // [start] CountByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param Projectpicid 项目图片编号
        * @return 数据量
        */
        public static int CountByProjectpicid(int Projectpicid)
        {
            return new ProjectpicDAL().CountByProjectpicid(Projectpicid);
        }
        // [end]
        // [start] CountByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param Projectpicid 项目图片编号
        * @return 数据量
        */
        public static int CountByProjectpicid(DataProvider dp, int Projectpicid)
        {
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.CountByProjectpicid(Projectpicid);
        }
        // [end]
        // [end]
        // [start] CountBy
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据量
        */
        public static int CountBy()
        {
            return new ProjectpicDAL().CountBy();
        }
        // [end]
        // [start] CountBy
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据量
        */
        public static int CountBy(DataProvider dp )
        {
		ProjectpicDAL dal = new ProjectpicDAL();
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
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectpicInfoCollection GetListBy()
        {
            return new ProjectpicDAL().GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectpicInfoCollection GetListBy(DataProvider dp )
        {
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListBy();
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectpicInfoCollection GetListBy(String OrderBy)
        {
            return new ProjectpicDAL().GetListBy(OrderBy);
        }
        // [end]
        // [start] GetListBy
        /**
        * 根据 <br />
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectpicInfoCollection GetListBy(DataProvider dp, String OrderBy)
        {
		ProjectpicDAL dal = new ProjectpicDAL();
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
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectpicInfoCollection GetListPagerBy(int pageIndex, int pageSize)
        {
            return new ProjectpicDAL().GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据总量
        */
        public static int GetListPagerBy()
        {
            return new ProjectpicDAL().GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectpicInfoCollection GetListPagerBy( String OrderBy, int pageIndex, int pageSize)
        {
            return new ProjectpicDAL().GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(String OrderBy)
        {
            return new ProjectpicDAL().GetListPagerBy( OrderBy);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectpicInfoCollection GetListPagerBy(DataProvider dp,int pageIndex, int pageSize)
        {
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp )
        {
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy();
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 返回表t_projectpic 项目图片表的数据列表<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据列表的强类型实体类
        */
        public static ProjectpicInfoCollection GetListPagerBy(DataProvider dp,  String OrderBy, int pageIndex, int pageSize)
        {
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy,  pageIndex, pageSize);
        }
        // [end]
        // [start] GetListPagerBy
        /**
        * 根据 <br />
 统计表t_projectpic 项目图片表的数据量<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @return 数据总量
        */
        public static int GetListPagerBy(DataProvider dp, String OrderBy)
        {
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetListPagerBy( OrderBy);
        }
        // [end]
        // [end]

        // [end]


        // [start] GetObject
        // [start] GetProjectpicInfoByProjectpicid
        // [start] GetProjectpicInfoByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 获取表t_projectpic 项目图片表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param Projectpicid 项目图片编号
        * @return ProjectpicInfo对象实体
        */
        public static ProjectpicInfo GetProjectpicInfoByProjectpicid(int Projectpicid)
        {
            return new ProjectpicDAL().GetProjectpicInfoByProjectpicid(Projectpicid);
        }
        // [end]
        // [start] GetProjectpicInfoByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 获取表t_projectpic 项目图片表的对象<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param Projectpicid 项目图片编号
        * @return ProjectpicInfo对象实体
        */
        public static ProjectpicInfo GetProjectpicInfoByProjectpicid(DataProvider dp, int Projectpicid)
        {
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
            return dal.GetProjectpicInfoByProjectpicid(Projectpicid);
        }
        // [end]
        // [end]

        // [end]


        // [start] Insert
	// [start] Insert
        /**
        * 向表t_projectpic 项目图片表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param objProjectpicInfo ProjectpicInfo对象 项目图片表
        */
  public static boolean Insert(ProjectpicInfo objProjectpicInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return Insert(dp, objProjectpicInfo);
	}

	// [end]
	// [start] Insert
        /**
        * 向表t_projectpic 项目图片表中插入数据<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param objProjectpicInfo ProjectpicInfo对象 项目图片表
        */
  public static boolean Insert(DataProvider dp, ProjectpicInfo objProjectpicInfo)
	{
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
		dal.Insert(objProjectpicInfo);
      setProjectpicStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_projectpic", "添加", objProjectpicInfo.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]

        // [end]


        // [start] Update
        // [start] UpdateByProjectpicid
        // [start] UpdateByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 更新表t_projectpic 项目图片表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param objProjectpicInfo ProjectpicInfo对象 项目图片表
        */
  public static boolean UpdateByProjectpicid(ProjectpicInfo objProjectpicInfo)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return UpdateByProjectpicid(dp, objProjectpicInfo);
	}

	// [end]
        // [start] UpdateByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 更新表t_projectpic 项目图片表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param objProjectpicInfo ProjectpicInfo对象 项目图片表
        */
  public static boolean UpdateByProjectpicid(DataProvider dp, ProjectpicInfo objProjectpicInfo)
	{
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
    // 表主键字段
		int Projectpicid =  objProjectpicInfo.getProjectpicid();//项目图片编号  数据类型:int
      ProjectpicInfo objOld =  dal.GetProjectpicInfoByProjectpicid(Projectpicid);// 读取实体信息
		dal.UpdateByProjectpicid(objProjectpicInfo);
		setProjectpicStatic(null);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("原信息为: \n");
		sbStr.append(objOld.ToSplitString());
		sbStr.append("\n修改为: \n");
		sbStr.append(objProjectpicInfo.ToSplitString());
		sbStr.append("\n修改的内容是为: \n");
		sbStr.append(objProjectpicInfo.ToModifyString(objOld));
		com.yun.common.TableLog.AddLog(dp, "t_projectpic", "修改", sbStr.toString());
		boolean isRun = dp.isRun;
		return isRun;
	}

	// [end]
	// [end]

        // [end]


        // [start] Delete
        // [start] DeleteByProjectpicid
        // [start] DeleteByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 删除数据表t_projectpic 项目图片表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param Projectpicid 项目图片编号
        */
	public static boolean DeleteByProjectpicid(int Projectpicid)
	{
		String connectionStringUpdate = com.yun.configuration.WebConfig.getCultureUpdateBysqlserverdal();
		String dbUserNameUpdate = com.yun.configuration.WebConfig.getDbUserNameUpdateBysqlserverdal();
		String dbPassWordUpdate = com.yun.configuration.WebConfig.getDbPassWordUpdateBysqlserverdal();

		DataProvider dp = new DataProvider(connectionStringUpdate, dbUserNameUpdate, dbPassWordUpdate);
		return DeleteByProjectpicid(dp, Projectpicid);
	}

	// [end]
        // [start] DeleteByProjectpicid
        /**
        * 根据 <br />
    * ProjectPicID Projectpicid 项目图片编号<br />
 删除数据表t_projectpic 项目图片表中的内容<br />
        * 开发者 贾军磊 2012年12月03日 13:31:19
        *
        * @param Projectpicid 项目图片编号
        */
	public static boolean DeleteByProjectpicid(DataProvider dp, int Projectpicid)
	{
		ProjectpicDAL dal = new ProjectpicDAL();
		dal.setDP(dp);
		dal.setDPUpdate(dp);
      ProjectpicInfo objOld =  dal.GetProjectpicInfoByProjectpicid(Projectpicid);// 读取实体信息
		dal.DeleteByProjectpicid(Projectpicid);
		setProjectpicStatic(null);
		com.yun.common.TableLog.AddLog(dp, "t_projectpic", "删除", objOld.ToSplitString());
		boolean isRun = dp.isRun;
		return isRun;
	}
	// [end]
	// [end]

        // [end]

}