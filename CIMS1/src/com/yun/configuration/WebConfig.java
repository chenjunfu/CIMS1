package com.yun.configuration;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * WEBConfig 静态配置类 也就是Web.Config的静态属性
 */
public class WebConfig
{

	/**
	 * 网站的标题
	 */
	public static final String WEB_TITLE = com.colorwinglib.Converts.objToStr(getValueByConnXml("WEB_TITLE"), "文化产业信息管理");

	/**
	 * 缓存数据的页数，默认是7页
	 */
	public static final int PAGE_CACHE_ALL = com.colorwinglib.Converts.StrToInt(getValueByConnXml("PAGE_CACHE_ALL"), 7);

	/**
	 * 页面默认显示的行数，默认是10页
	 */
	public static final int PAGE_SIZE = com.colorwinglib.Converts.StrToInt(getValueByConnXml("PAGE_SIZE"), 10);
	/**
	 * 行样式名1
	 */
	public static final String TRCLASSNAME1 = getValueByConnXml("TRCLASSNAME1");
	/**
	 * 行样式名2
	 */
	public static final String TRCLASSNAME2 = getValueByConnXml("TRCLASSNAME2");



	// [start] 设置和获取 当前操作系统的路径分隔符, 默认值:""
	// 设置和获取 当前操作系统的路径分隔符,类型String 默认值:"" 开始
	private static String fileSeparator = "";

	/**
	 * 获取 当前操作系统的路径分隔符, 类型String 默认值:""
	 *
	 * @return 当前操作系统的路径分隔符, 类型String 默认值:""
	 */
	public static String getFileSeparator()
	{
		if (fileSeparator.equals(""))
		{
			// 通过获得系统属性构造属性类 prop
			java.util.Properties prop = new java.util.Properties(System.getProperties());
			fileSeparator = prop.getProperty("file.separator");
		}

		return fileSeparator;
	}

	/**
	 * 设置 当前操作系统的路径分隔符, 类型String 默认值:""
	 *
	 * @param sfileSeparator
	 *            当前操作系统的路径分隔符, 类型String 默认值:""
	 */
	public static void setFileSeparator(String sfileSeparator)
	{
		fileSeparator = sfileSeparator;
	}

	// 设置和获取 当前操作系统的路径分隔符, 类型String 默认值:"" 结束
	// [end]


	// [start] getValueByConnXml 从conn.xml获得数据库连接数据
	public static String getValueByConnXml(String name)
	{
		String strReturn = "";

		// long lasting = System.currentTimeMillis();
		try
		{
			String configFile = "/conn.xml";
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			java.net.URL url = classLoader.getResource(configFile);
			if (url == null)
			{
				configFile = "conn.xml";
				url = classLoader.getResource(configFile);
			}
			java.io.File f = new java.io.File(url.getPath());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("property");
			for (int i = 0; i < nl.getLength(); i++)
			{
				if (doc.getElementsByTagName("property").item(i).getAttributes().getNamedItem("name").getNodeValue().equals(name))
				{
					strReturn = doc.getElementsByTagName("property").item(i).getFirstChild().getNodeValue();
					break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return strReturn.trim();
	}

	// [end]

	// [start] getValueByHibernateCfg 从hibernate.cfg.xml获得数据
	public static String getValueByHibernateCfg(String name)
	{
		String strReturn = "";

		// long lasting = System.currentTimeMillis();
		try
		{

			String configFile = "/hibernate.cfg.xml";
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			java.net.URL url = classLoader.getResource(configFile);
			if (url == null)
			{
				configFile = "hibernate.cfg.xml";
				url = classLoader.getResource(configFile);
			}
			java.io.File f = new java.io.File(url.getPath());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName("property");
			for (int i = 0; i < nl.getLength(); i++)
			{
				if (doc.getElementsByTagName("property").item(i).getAttributes().getNamedItem("name").getNodeValue().equals(name))
				{
					strReturn = doc.getElementsByTagName("property").item(i).getFirstChild().getNodeValue();
					break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return strReturn.trim();
	}
	// [end]




	// ------------------- cultureBysqlserverdal 开始 -------------------
	// [start] 数据库连接设置
	// [start] 设置和获取 数据库连接, 默认值:""
	// 设置和获取 数据库连接,类型String 默认值:"" 开始
	private static String cultureBysqlserverdal = "";

	/**
	 * 获取 数据库连接, 类型String 默认值:""
	 *
	 * @return 数据库连接, 类型String 默认值:""
	 */
	public static String getCultureBysqlserverdal()
	{
		if (cultureBysqlserverdal.equals(""))
			cultureBysqlserverdal = getValueByConnXml("connection.urlBysqlserverdal");
		return cultureBysqlserverdal;
	}

	/**
	 * 设置 数据库连接, 类型String 默认值:""
	 *
	 * @param scultureBysqlserverdal
	 *            数据库连接, 类型String 默认值:""
	 */
	public static void setCultureBysqlserverdal(String scultureBysqlserverdal)
	{
		cultureBysqlserverdal = scultureBysqlserverdal;
	}

	// 设置和获取 数据库连接, 类型String 默认值:"" 结束
	// [end]
	// [start] 设置和获取 数据库用户名, 默认值:""
	// 设置和获取 数据库用户名,类型String 默认值:"" 开始
	private static String dbUserNameBysqlserverdal = "";

	/**
	 * 获取 数据库用户名, 类型String 默认值:""
	 *
	 * @return 数据库用户名, 类型String 默认值:""
	 */
	public static String getDbUserNameBysqlserverdal()
	{
		if (dbUserNameBysqlserverdal.equals(""))
			dbUserNameBysqlserverdal = getValueByConnXml("connection.usernameBysqlserverdal");
		return dbUserNameBysqlserverdal;
	}

	/**
	 * 设置 数据库用户名, 类型String 默认值:""
	 *
	 * @param sdbUserNameBysqlserverdal
	 *            数据库用户名, 类型String 默认值:""
	 */
	public static void setDbUserNameBysqlserverdal(String sdbUserNameBysqlserverdal)
	{
		dbUserNameBysqlserverdal = sdbUserNameBysqlserverdal;
	}

	// 设置和获取 数据库用户名, 类型String 默认值:"" 结束
	// [end]
	// [start] 设置和获取 数据库密码, 默认值:""
	// 设置和获取 数据库密码,类型String 默认值:"" 开始
	private static String dbPassWordBysqlserverdal = "";

	/**
	 * 获取 数据库密码, 类型String 默认值:""
	 *
	 * @return 数据库密码, 类型String 默认值:""
	 */
	public static String getDbPassWordBysqlserverdal()
	{
		if (dbPassWordBysqlserverdal.equals(""))
			dbPassWordBysqlserverdal = getValueByConnXml("connection.passwordBysqlserverdal");
		return dbPassWordBysqlserverdal;
	}

	/**
	 * 设置 数据库密码, 类型String 默认值:""
	 *
	 * @param sdbPassWordBysqlserverdal
	 *            数据库密码, 类型String 默认值:""
	 */
	public static void setDbPassWordBysqlserverdal(String sdbPassWordBysqlserverdal)
	{
		dbPassWordBysqlserverdal = sdbPassWordBysqlserverdal;
	}

	// 设置和获取 数据库密码, 类型String 默认值:"" 结束
	// [end]


	// [start] 设置和获取 Update数据库连接, 默认值:""
	// 设置和获取 Update数据库连接,类型String 默认值:"" 开始
	private static String cultureUpdateBysqlserverdal = "";

	/**
	 * 获取 Update数据库连接, 类型String 默认值:""
	 *
	 * @return Update数据库连接, 类型String 默认值:""
	 */
	public static String getCultureUpdateBysqlserverdal()
	{
		if (cultureUpdateBysqlserverdal.equals(""))
			cultureUpdateBysqlserverdal = getValueByConnXml("connection.urlUpdateBysqlserverdal");
		return cultureUpdateBysqlserverdal;
	}

	/**
	 * 设置 Update数据库连接, 类型String 默认值:""
	 *
	 * @param scultureUpdateBysqlserverdal
	 *            Update数据库连接, 类型String 默认值:""
	 */
	public static void setCultureUpdateBysqlserverdal(String scultureUpdateBysqlserverdal)
	{
		cultureUpdateBysqlserverdal = scultureUpdateBysqlserverdal;
	}

	// 设置和获取 Update数据库连接, 类型String 默认值:"" 结束
	// [end]
	// [start] 设置和获取 Update数据库用户名, 默认值:""
	// 设置和获取 Update数据库用户名,类型String 默认值:"" 开始
	private static String dbUserNameUpdateBysqlserverdal = "";

	/**
	 * 获取 Update数据库用户名, 类型String 默认值:""
	 *
	 * @return Update数据库用户名, 类型String 默认值:""
	 */
	public static String getDbUserNameUpdateBysqlserverdal()
	{
		if (dbUserNameUpdateBysqlserverdal.equals(""))
			dbUserNameUpdateBysqlserverdal = getValueByConnXml("connection.usernameUpdateBysqlserverdal");
		return dbUserNameUpdateBysqlserverdal;
	}

	/**
	 * 设置 Update数据库用户名, 类型String 默认值:""
	 *
	 * @param sdbUserNameUpdateBysqlserverdal
	 *            Update数据库用户名, 类型String 默认值:""
	 */
	public static void setDbUserNameUpdateBysqlserverdal(String sdbUserNameUpdateBysqlserverdal)
	{
		dbUserNameUpdateBysqlserverdal = sdbUserNameUpdateBysqlserverdal;
	}

	// 设置和获取 Update数据库用户名, 类型String 默认值:"" 结束
	// [end]
	// [start] 设置和获取 Update数据库密码, 默认值:""
	// 设置和获取 Update数据库密码,类型String 默认值:"" 开始
	private static String dbPassWordUpdateBysqlserverdal = "";

	/**
	 * 获取 Update数据库密码, 类型String 默认值:""
	 *
	 * @return Update数据库密码, 类型String 默认值:""
	 */
	public static String getDbPassWordUpdateBysqlserverdal()
	{
		if (dbPassWordUpdateBysqlserverdal.equals(""))
			dbPassWordUpdateBysqlserverdal = getValueByConnXml("connection.passwordUpdateBysqlserverdal");
		return dbPassWordUpdateBysqlserverdal;
	}

	/**
	 * 设置 Update数据库密码, 类型String 默认值:""
	 *
	 * @param sdbPassWordUpdateBysqlserverdal
	 *            Update数据库密码, 类型String 默认值:""
	 */
	public static void setDbPassWordUpdateBysqlserverdal(String sdbPassWordUpdateBysqlserverdal)
	{
		dbPassWordUpdateBysqlserverdal = sdbPassWordUpdateBysqlserverdal;
	}

	// 设置和获取 Update数据库密码, 类型String 默认值:"" 结束
	// [end]

	// [start] 设置和获取 是否使用连接池获得数据库链接, 默认值:false
	private static boolean isConnectionPoolBysqlserverdal = false;
	private static boolean isConnectionPoolNotReadBysqlserverdal = true;

	/**
	 * 获取 是否使用连接池获得数据库链接, 类型boolean 默认值:false
	 *
	 * @return 是否使用连接池获得数据库链接, 类型boolean 默认值:false
	 */
	public static boolean getIsConnectionPoolBysqlserverdal()
	{
		if (isConnectionPoolNotReadBysqlserverdal)
		{
			if (getValueByConnXml("connection.isConnectionPoolBysqlserverdal").length() > 0)
			{
				isConnectionPoolBysqlserverdal = com.colorwinglib.Converts.StrToBoolean(getValueByConnXml("connection.isConnectionPoolBysqlserverdal"));
				isConnectionPoolNotReadBysqlserverdal = false;
			}
		}

		return isConnectionPoolBysqlserverdal;
	}

	/**
	 * 设置 是否使用连接池获得数据库链接, 类型boolean 默认值:false
	 *
	 * @param sisConnectionPoolBysqlserverdal
	 *            是否使用连接池获得数据库链接, 类型boolean 默认值:false
	 */
	public static void setisConnectionPoolBysqlserverdal(boolean sisConnectionPoolBysqlserverdal)
	{
		isConnectionPoolBysqlserverdal = sisConnectionPoolBysqlserverdal;
		isConnectionPoolNotReadBysqlserverdal = false;
	}

	// [end]

	// [start] 设置和获取 数据库连接池名, 默认值:false
	private static String connectionPoolNameBysqlserverdal = "";

	/**
	 * 获取 数据库连接池名, 类型String 默认值:false
	 *
	 * @return 数据库连接池名, 类型String 默认值:false
	 */
	public static String getConnectionPoolNameBysqlserverdal()
	{
		if (connectionPoolNameBysqlserverdal.length()==0)
		{
			connectionPoolNameBysqlserverdal = getValueByConnXml("connection.ConnectionPoolNameBysqlserverdal");
		}
		return connectionPoolNameBysqlserverdal;
	}

	/**
	 * 设置 数据库连接池名, 类型String 默认值:false
	 *
	 * @param sconnectionPoolNameBysqlserverdal
	 *            数据库连接池名, 类型String 默认值:false
	 */
	public static void setconnectionPoolNameBysqlserverdal(String sconnectionPoolNameBysqlserverdal)
	{
		connectionPoolNameBysqlserverdal = sconnectionPoolNameBysqlserverdal;
	}

	// [end]
	// [end]
	// ------------------- cultureBysqlserverdal 结束 -------------------
}

