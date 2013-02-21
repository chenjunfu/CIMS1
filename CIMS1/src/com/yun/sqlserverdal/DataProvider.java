package com.yun.sqlserverdal;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

import org.apache.log4j.Level;

import java.util.Date;

//byte	Byte
//short	Short
//int	Int
//long	Long
//float	Float
//double	Double
//Date	Date
//boolean	Boolean
//String	String
//Object	Object
//byte[]	ByteS
/**
 * 这是一个通用的数据访问层接口。类似于SQLHelper
 *
 */
public class DataProvider
{

	// 属性
	/**
	 * 出错信息
	 *
	 */
	private static String errorMsg;
	/**
	 * 是否显示出错的查询语句（包括存储过程名程）
	 */
	private static boolean isShowErrorSQL;
	/**
	 * 获取执行SQL查询语句后影响的行数
	 *
	 */
	private int executeRowCount;
	/**
	 * 建立Connection对象
	 */
	private Connection conn;
	/**
	 * 建立Statement对象
	 */
	private Statement stmt;
	/**
	 * 建立Statement对象
	 */
	private ResultSet rs;
	private PreparedStatement pstmt;
	/**
	 * 用于事务处理
	 *
	 */
	// private SqlTransaction sqlTrans;
	/**
	 * 是否启用了.net 的事务处理
	 */
	private boolean isUseTrans;
	/**
	 * 连接字符串
	 */
	private String connectString;
	/**
	 * 是否已经被销毁
	 */
	private boolean isDisposed;

	private ArrayList<Parameters> cmParameters;
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DataProvider.class.getName());
	/**
	 * 是否已经回退
	 */
	public boolean isRollBack = false;
	/**
	 * 是否运行成功
	 */
	public boolean isRun = false;

	/**
	 * 读取出错信息
	 *
	 */
	public String getErrorMsg()
	{
		return errorMsg;
	}

	/**
	 * 修改连接字符串，在同时访问两个或两个以上的数据库的时候使用
	 *
	 */
	public String getCnString()
	{
		return connectString;
	}

	/**
	 * 修改连接字符串，在同时访问两个或两个以上的数据库的时候使用
	 *
	 */
	public void setCnString(String value)
	{
		connectString = value;
	}

	/**
	 * 获取执行SQL查询语句后影响的行数
	 *
	 */
	public int getExecuteRowCount()
	{
		return executeRowCount;
	}

	/**
	 * 对象是否已经被销毁
	 *
	 */
	public boolean getIsDisposed()
	{
		return isDisposed;
	}

	/**
	 * 对象是否已经被销毁
	 *
	 */
	public void setIsDisposed(boolean value)
	{
		isDisposed = value;
	}

	/**
	 * 释放资源
	 *
	 */
	public void Dispose()
	{
		// if (isUseTrans)
		// sqlTrans.Dispose();

		errorMsg = null;
		try
		{		
			if(rs!=null)
			{
				rs.close();
				
			}
			if (stmt != null)
			{
				stmt.close();
				
			}

			if (pstmt != null)
			{
				pstmt.close();
				
			}

			if (isUseTrans == false && conn != null && !conn.isClosed())
			{
				conn.close();		
			}
		}
		catch (Exception e)
		{
			
		}
		if (isUseTrans == false)
			isDisposed = true;
	}

	// 构造函数
	public DataProvider()
	{
		String user = com.yun.configuration.WebConfig.getDbUserNameBysqlserverdal();
		String password = com.yun.configuration.WebConfig.getDbPassWordBysqlserverdal();
		this.connectString = com.yun.configuration.WebConfig.getCultureBysqlserverdal();
		// 默认不使用事务
		isUseTrans = false;
		// 获取连接字符串
		conn = getConn(connectString, user, password);
		// 初始化错误信息
		errorMsg = "0";
		isShowErrorSQL = true; // 本地运行，显示出错的查询语句（包括存储过程名程）
		// isShowErrorSQL = false; //服务器运行，不显示出错的查询语句（包括存储过程名程）
		cmParameters = new ArrayList<Parameters>();
	}

	// 构造函数
	public DataProvider(String _connectString, String user, String password)
	{
		this.connectString = _connectString;
		// 默认不使用事务
		isUseTrans = false;
		// 获取连接字符串
		conn = getConn(_connectString, user, password);
		// 初始化错误信息
		errorMsg = "0";
		isShowErrorSQL = true; // 本地运行，显示出错的查询语句（包括存储过程名程）
		// isShowErrorSQL = false; //服务器运行，不显示出错的查询语句（包括存储过程名程）
		cmParameters = new ArrayList<Parameters>();
	}
	public static boolean isNotConnection = true;

	// public static Connection objConnection = null;

	/**
	 * 返回数据库连接 注意：红色的字体表示他要调用的连接池名，同配置
	 *
	 * @return Connection
	 * @throws SQLException
	 */
	public static synchronized Connection getConn(String _connectString, String user, String password)
	{
		Connection objConnectionReturn = null;
		if (com.yun.configuration.WebConfig.getIsConnectionPoolBysqlserverdal())
		{
			try
			{
					// 连接池获得数据库链接，这里用的是Tomcat6的连接池配置，如果用其他的服务器，请更换其他的配置，主要是更换ctx.lookup()里面的地址
					Context ctx = new InitialContext();// 得到初始化上下文
					DataSource ds = (DataSource) ctx.lookup(com.yun.configuration.WebConfig.getConnectionPoolNameBysqlserverdal());// 查找连接池，这里需要按需要进行修改配置
					objConnectionReturn = ds.getConnection();// 从连接池中得到一个连接
					return objConnectionReturn;
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			catch (NamingException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				// 普通方式获得数据库链接
				if (isNotConnection)
				{
					String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
					Class.forName(driver);
					objConnectionReturn = DriverManager.getConnection(_connectString, user, password);
					isNotConnection = false;
					return objConnectionReturn;
				}
				else
				{
					// if (objConnection.isClosed())
					objConnectionReturn = DriverManager.getConnection(_connectString, user, password);
					return objConnectionReturn;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	// 记录错误日志
	// 如果要使用的话，根据你的需要进行修改。
	public void AddLog(String SPName, String ErrDescribe)
	{
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("\n");
		sbStr.append(SPName);
		sbStr.append("\n");
		for (Parameters ps : cmParameters)
		{
			// 输出参数信息
			sbStr.append(ps.getParameterOutStrint());
			sbStr.append("\n");
		}
		logger.info(sbStr.toString());
		
	}

	// 如果要使用的话，根据你的需要进行修改。
	public void AddLogErr(String SPName, String ErrDescribe)
	{
		// 回滚事务
		TranRollBack();

		logger.error(ErrDescribe);
		StringBuilder sbStr = new StringBuilder(1024);
		sbStr.append("\n");
		sbStr.append(SPName);
		sbStr.append("\n");
		for (Parameters ps : cmParameters)
		{
			// 输出参数信息
			sbStr.append(ps.getParameterOutStrint());
			sbStr.append("\n");
		}
		logger.error(sbStr.toString());
	}

	// 存储过程的参数部分——清除和添加参数

	// 清除参数
	/**
	 * 清除SqlCommand的存储过程的参数。
	 *
	 */
	public void ClearParameter()
	{
		cmParameters.clear();
	}

	// 输入型的参数int 、double、decimal、nvarChar、、、

	// byte
	/**
	 * 添加byte型的参数。
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, byte ParameterValue)
	{
		cmParameters.add(0, new Parameters(ParameterName, ParameterValue));
	}

	// short
	/**
	 * 添加short型的参数。
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, short ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// int
	/**
	 * 添加int型的参数。
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, int ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// BigInt
	public void AddNewParameter(String ParameterName, long ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// double
	/**
	 * 添加小数参数，double
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, double ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// bit
	/**
	 * 添加bit型的参数。方向是输入（input）
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, boolean ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// float
	/**
	 * 添加小数参数，float
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, float ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// Date
	/**
	 * 添加Date型的参数。
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, Date ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}
	public void AddNullParameter(String ParameterName, Object ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// nText
	/**
	 * 添加nText型的参数。方向是输入（input）
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, String ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}
	
	/**
	 * 添加nText型的参数。方向是输入（input）
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 * @param PadRightLen
	 *            字符长度Char类型用，不足则不足长度
	 */
	public void AddNewParameter(String ParameterName, String ParameterValue, String ParameterType, int PadRightLen)
	{
		if (ParameterType.toLowerCase().equals("char"))
			cmParameters.add(new Parameters(ParameterName, com.colorwinglib.StringFormat.PadRight(ParameterValue, PadRightLen, true)));
		else
			cmParameters.add(new Parameters(ParameterName, com.colorwinglib.StringFormat.PadRight(ParameterValue, PadRightLen)));
	}

	// byte[]
	/**
	 * 添加byte[]型的参数。方向是输入（input）
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, byte[] ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// Object
	/**
	 * 添加Object型的参数。方向是输入（input）
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public void AddNewParameter(String ParameterName, Object ParameterValue)
	{
		cmParameters.add(new Parameters(ParameterName, ParameterValue));
	}

	// byte[]
	/**
	 * 添加byte[]型的参数。方向是输入（input）
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 * @param ParameterValue参数值
	 */
	public Object GetParameterValue(Object ParameterValue)
	{
		// return ParameterValue == null ? DBNull.Value : ParameterValue; // 负值
		return ParameterValue; // 负值
	}

	// 存储过程的参数部分——修改参数值

	/**
	 * 按序号修改参数值，一般在一次添加多条记录时用。
	 *
	 * @param ParameterIndex序号
	 */
	public void setParameter(int ParameterIndex, Object ParameterValue)
	{
		int i = 0;
		for (Parameters ps : cmParameters)
		{
			if (i == ParameterIndex)
			{
				ps.setParameterValue(ParameterValue);
				break;
			}
			i++;
		}

	}

	/**
	 * 按名称修改参数值，一般在一次添加多条记录时用
	 *
	 * @param ParameterName参数名称
	 *            。比如@UserName
	 */
	public void setParameter(String ParameterName, Object ParameterValue)
	{
		for (Parameters ps : cmParameters)
		{
			if (ps.getParameterName().equals(ParameterName))
			{
				ps.setParameterValue(ParameterValue);
				break;
			}
		}
	}

	// 事务处理部分。并没有做太多的测试，有不合理的地方请多指教
	/**
	 * 打开连接，并且开始事务。
	 *
	 * @throws SQLException
	 *
	 */
	public void TranBegin()
	{
		try
		{
			conn.setAutoCommit(false);
			isUseTrans = true;
		}
		catch (SQLException e)
		{
			errorMsg = "事务开始时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();
			AddLogErr("TranBegin", errorMsg);
			e.printStackTrace();
		}
	}

	/**
	 * 提交事务，并关闭连接
	 *
	 * @throws SQLException
	 *
	 */
	public boolean TranCommit()
	{
		return TranCommit(false);
	}

	/**
	 * 提交事务，并关闭连接
	 *
	 * @throws SQLException
	 *
	 */
	public boolean TranCommit(Boolean isCloseConnection)
	{
		try
		{
			conn.commit();
			if (isCloseConnection)
				conn.close();
			return true;
		}
		catch (SQLException e)
		{
			errorMsg = "回滚提交时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();
			AddLogErr("TranCommit", errorMsg);
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 回滚事务，并关闭连接。在程序出错的时候，自动调用。
	 *
	 * @throws SQLException
	 *
	 */
	public void TranRollBack()
	{
		TranRollBack(false);
	}

	/**
	 * 回滚事务，并关闭连接。在程序出错的时候，自动调用。
	 *
	 * @throws SQLException
	 *
	 */
	public void TranRollBack(Boolean isCloseConnection)
	{
		isRun = false;
		try
		{
			conn.rollback();
			isRollBack = true;
			if (isCloseConnection)
				conn.close();
		}
		catch (SQLException e)
		{
			errorMsg = "回滚回滚时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();
			AddLogErr("TranRollBack", errorMsg);
			e.printStackTrace();
		}
	}

	// 运行存储过程返回记录（Scalar,ResultSet,DataSet、DataTable）
	// 运行存贮过程返回第一行第一列
	/**
	 * 运行存贮过程返回第一行第一列
	 *
	 * @param StoreProcedureName存贮过程名
	 */
	public Object RunStoreScalar(String StoredProcedureName)
	{
		try
		{
			AddLog(StoredProcedureName, errorMsg);

		
			
			logger.debug(StoredProcedureName);
			errorMsg = "0";
			//ResultSet rs;
			if (cmParameters.size() > 0)
			{
				pstmt = conn.prepareCall(StoredProcedureName, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				int i = 1;
				for (Parameters ps : cmParameters)
				{
					switch (ps.getParameterType())
					{
					case Byte:
						pstmt.setByte(i, ps.getParameterValueByte());
						break;
					case Short:
						pstmt.setShort(i, ps.getParameterValueShort());
						break;
					case Int:
						pstmt.setInt(i, ps.getParameterValueInt());
						break;
					case Long:
						pstmt.setLong(i, ps.getParameterValueLong());
						break;
					case Float:
						pstmt.setFloat(i, ps.getParameterValueFloat());
						break;
					case Double:
						pstmt.setDouble(i, ps.getParameterValueDouble());
						break;
					case Date:
						// pstmt.setDate(i, ps.getParameterValueDate());
						pstmt.setTimestamp(i, ps.getParameterValueDate());
						break;
					case Boolean:
						pstmt.setBoolean(i, ps.getParameterValueBoolean());
						break;
					case String:
						pstmt.setString(i, ps.getParameterValueString());
						break;
					case Object:
						pstmt.setObject(i, ps.getParameterValueObject());
						break;
					case ByteS:
						pstmt.setBytes(i, ps.getParameterValueByteS());
						break;
					}
					i++;
				}
				rs = pstmt.executeQuery();
			}
			else
			{
				pstmt = conn.prepareCall(StoredProcedureName, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				rs = pstmt.executeQuery();
			}

			Object obj = null;
			while (rs.next())
				obj = rs.getObject(0);
			isRun = true;
			return obj;

		}
		catch (SQLException e)
		{
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();

			isRun = false;
			TranRollBack();
			AddLogErr(StoredProcedureName, errorMsg);
			e.printStackTrace();
			return null;

		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }

	}

	// 运行存贮过程返回ResultSet
	/**
	 * 运行存贮过程返回ResultSet
	 *
	 * @param StoredProcedureName
	 */
	public ResultSet RunStoreResultSet(String StoredProcedureName)
	{
		try
		{
			AddLog(StoredProcedureName, errorMsg);

	
			logger.debug("ColorWingCode 代码生成器存储过程:");
			logger.debug(StoredProcedureName);
			errorMsg = "0";
			//ResultSet rs;
			if (cmParameters.size() > 0)
			{
				pstmt = conn.prepareCall(StoredProcedureName, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				int i = 1;
				for (Parameters ps : cmParameters)
				{
					switch (ps.getParameterType())
					{
					case Byte:
						pstmt.setByte(i, ps.getParameterValueByte());
						break;
					case Short:
						pstmt.setShort(i, ps.getParameterValueShort());
						break;
					case Int:
						pstmt.setInt(i, ps.getParameterValueInt());
						break;
					case Long:
						pstmt.setLong(i, ps.getParameterValueLong());
						break;
					case Float:
						pstmt.setFloat(i, ps.getParameterValueFloat());
						break;
					case Double:
						pstmt.setDouble(i, ps.getParameterValueDouble());
						break;
					case Date:
						// pstmt.setDate(i, ps.getParameterValueDate());
						pstmt.setTimestamp(i, ps.getParameterValueDate());
						break;
					case Boolean:
						pstmt.setBoolean(i, ps.getParameterValueBoolean());
						break;
					case String:
						pstmt.setString(i, ps.getParameterValueString());
						break;
					case Object:
						pstmt.setObject(i, ps.getParameterValueObject());
						break;
					case ByteS:
						pstmt.setBytes(i, ps.getParameterValueByteS());
						break;
					}
					i++;
				}
				rs = pstmt.executeQuery();
			}
			else
			{
				pstmt = conn.prepareCall(StoredProcedureName, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				rs = pstmt.executeQuery(StoredProcedureName);
			}

			isRun = true;
			return rs;

		}
		catch (SQLException e)
		{
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();

			isRun = false;
			TranRollBack();
			AddLogErr(StoredProcedureName, errorMsg);
			e.printStackTrace();
			return null;

		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }

	}

	// 运行添加数据的SQL语句返回ID
	/**
	 * 运行添加数据的SQL语句返回ID
	 *
	 * @param SQL
	 *            添加程序的SQL语句
	 */
	public long RunStoreScalarByInsert(String StoredProcedureName)
	{
		try
		{
			AddLog(StoredProcedureName, errorMsg);
			logger.debug("ColorWingCode 代码生成器存储过程:");
			logger.debug(StoredProcedureName);
			errorMsg = "0";
			
			//ResultSet rs;
			if (cmParameters.size() > 0)
			{
				pstmt = conn.prepareCall(StoredProcedureName, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				int i = 1;
				for (Parameters ps : cmParameters)
				{
					switch (ps.getParameterType())
					{
					case Byte:
						pstmt.setByte(i, ps.getParameterValueByte());
						break;
					case Short:
						pstmt.setShort(i, ps.getParameterValueShort());
						break;
					case Int:
						pstmt.setInt(i, ps.getParameterValueInt());
						break;
					case Long:
						pstmt.setLong(i, ps.getParameterValueLong());
						break;
					case Float:
						pstmt.setFloat(i, ps.getParameterValueFloat());
						break;
					case Double:
						pstmt.setDouble(i, ps.getParameterValueDouble());
						break;
					case Date:
						// pstmt.setDate(i, ps.getParameterValueDate());
						pstmt.setTimestamp(i, ps.getParameterValueDate());
						break;
					case Boolean:
						pstmt.setBoolean(i, ps.getParameterValueBoolean());
						break;
					case String:
						pstmt.setString(i, ps.getParameterValueString());
						break;
					case Object:
						pstmt.setObject(i, ps.getParameterValueObject());
						break;
					case ByteS:
						pstmt.setBytes(i, ps.getParameterValueByteS());
						break;
					}
					i++;
				}
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();

			}
			else
			{
				pstmt = conn.prepareCall(StoredProcedureName, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				rs = pstmt.executeQuery();
			}

			long obj = 0;
			while (rs.next())
			{
				obj = rs.getLong(1);
			}
			isRun = true;

			return obj;

		}
		catch (SQLException e)
		{
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();

			isRun = false;
			TranRollBack();
			AddLogErr(StoredProcedureName, errorMsg);
			e.printStackTrace();
			return 0;

		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }

	}

	// 运行存储过程不返回记录集，用于添加、修改、删除等操作
	/**
	 * 运行存储过程不返回记录集，用于添加、修改、删除等操作
	 *
	 * @param ParameterName存储过程名称
	 */
	public boolean RunStore(String StoredProcedureName)
	{
		try
		{
			AddLog(StoredProcedureName, errorMsg);
			logger.debug("ColorWingCode 代码生成器存储过程:");
			logger.debug(StoredProcedureName);
			errorMsg = "0";
			// ResultSet rs;
			if (cmParameters.size() > 0)
			{
				pstmt = conn.prepareStatement(StoredProcedureName, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				int i = 1;
				for (Parameters ps : cmParameters)
				{
					switch (ps.getParameterType())
					{
					case Byte:
						pstmt.setByte(i, ps.getParameterValueByte());
						break;
					case Short:
						pstmt.setShort(i, ps.getParameterValueShort());
						break;
					case Int:
						pstmt.setInt(i, ps.getParameterValueInt());
						break;
					case Long:
						pstmt.setLong(i, ps.getParameterValueLong());
						break;
					case Float:
						pstmt.setFloat(i, ps.getParameterValueFloat());
						break;
					case Double:
						pstmt.setDouble(i, ps.getParameterValueDouble());
						break;
					case Date:
						// pstmt.setDate(i, ps.getParameterValueDate());
						pstmt.setTimestamp(i, ps.getParameterValueDate());
						break;
					case Boolean:
						pstmt.setBoolean(i, ps.getParameterValueBoolean());
						break;
					case String:
						pstmt.setString(i, ps.getParameterValueString());
						break;
					case Object:
						pstmt.setObject(i, ps.getParameterValueObject());
						break;
					case ByteS:
						pstmt.setBytes(i, ps.getParameterValueByteS());
						break;
					}
					i++;
				}
				pstmt.executeUpdate();
			}
			else
			{
				stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				stmt.executeUpdate(StoredProcedureName);
			}
			isRun = true;
			return true;

		}
		catch (SQLException e)
		{
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();

			isRun = false;
			TranRollBack();
			AddLogErr(StoredProcedureName, errorMsg);
			e.printStackTrace();
			return false;
		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }

	}

	// 运行存储过程返回记录（Scalar,ResultSet,DataSet、DataTable）
	// 运行SQL语句返回第一行第一列
	/**
	 * 运行SQL语句返回第一行第一列
	 *
	 * @param StoreProcedureName存贮过程名
	 */
	public Object RunSqlScalar(String SQL)
	{
		try
		{
			AddLog(SQL, errorMsg);
			logger.debug(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			logger.debug(" ColorWingCode 代码生成器SQL语句:");
			logger.debug(SQL);
			errorMsg = "0";
			//ResultSet rs;
			if (cmParameters.size() > 0)
			{
				pstmt = conn.prepareStatement(SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				int i = 1;
				for (Parameters ps : cmParameters)
				{
					switch (ps.getParameterType())
					{
					case Byte:
						pstmt.setByte(i, ps.getParameterValueByte());
						break;
					case Short:
						pstmt.setShort(i, ps.getParameterValueShort());
						break;
					case Int:
						pstmt.setInt(i, ps.getParameterValueInt());
						break;
					case Long:
						pstmt.setLong(i, ps.getParameterValueLong());
						break;
					case Float:
						pstmt.setFloat(i, ps.getParameterValueFloat());
						break;
					case Double:
						pstmt.setDouble(i, ps.getParameterValueDouble());
						break;
					case Date:
						// pstmt.setDate(i, ps.getParameterValueDate());
						pstmt.setTimestamp(i, ps.getParameterValueDate());
						break;
					case Boolean:
						pstmt.setBoolean(i, ps.getParameterValueBoolean());
						break;
					case String:
						pstmt.setString(i, ps.getParameterValueString());
						break;
					case Object:
						pstmt.setObject(i, ps.getParameterValueObject());
						break;
					case ByteS:
						pstmt.setBytes(i, ps.getParameterValueByteS());
						break;
					}
					i++;
				}
				rs = pstmt.executeQuery();

			}
			else
			{
				stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(SQL);
			}

			Object obj = null;
			while (rs.next())
			{
				obj = rs.getObject(1);
			}
			isRun = true;

			return obj;

		}
		catch (SQLException e)
		{
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();

			isRun = false;
			TranRollBack();
			AddLogErr(SQL, errorMsg);
			e.printStackTrace();
			return null;

		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }

	}

	// 运行添加数据的SQL语句返回ID
	/**
	 * 运行添加数据的SQL语句返回ID
	 *
	 * @param SQL
	 *            添加程序的SQL语句
	 */
	public long RunSqlScalarByInsert(String SQL)
	{
		try
		{	
			//SQL=SQL.substring(0,SQL.indexOf(";"));
			AddLog(SQL, errorMsg);
 
			logger.debug(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			logger.debug(" ColorWingCode 代码生成器SQL语句:");
			logger.debug(SQL);
			errorMsg = "0";
			//ResultSet rs;
			pstmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
			int i = 1;
			for (Parameters ps : cmParameters)
			{
				switch (ps.getParameterType())
				{
				case Byte:
					pstmt.setByte(i, ps.getParameterValueByte());
					break;
				case Short:
					pstmt.setShort(i, ps.getParameterValueShort());
					break;
				case Int:
					pstmt.setInt(i, ps.getParameterValueInt());
					break;
				case Long:
					pstmt.setLong(i, ps.getParameterValueLong());
					break;
				case Float:
					pstmt.setFloat(i, ps.getParameterValueFloat());
					break;
				case Double:
					pstmt.setDouble(i, ps.getParameterValueDouble());
					break;
				case Date:
					// pstmt.setDate(i, ps.getParameterValueDate());
					pstmt.setTimestamp(i, ps.getParameterValueDate());
					break;
				case Boolean:
					pstmt.setBoolean(i, ps.getParameterValueBoolean());
					break;
				case String:
					pstmt.setString(i, ps.getParameterValueString());
					break;
				case Object:
					pstmt.setObject(i, ps.getParameterValueObject());
					break;
				case ByteS:
					pstmt.setBytes(i, ps.getParameterValueByteS());
					break;
				}
				i++;
			}
			pstmt.execute();
			rs = pstmt.getGeneratedKeys();
		
			long obj = 0;
			while (rs.next())
			{
				obj = rs.getLong(1);
			}
			isRun = true;
			return obj;

		}
		catch (SQLException e)
		{		
		
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();
			e.printStackTrace();
			isRun = false;
			TranRollBack();
			AddLogErr(SQL, errorMsg);
			e.printStackTrace();
			return 0;

		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }

	}

	// 运行查询语句返回记录（DataSet、DataTable、IDString、）
	// RunSqlResultSet 运行SQL查询语句返回ResultSet。
	/**
	 * 运行SQL查询语句返回ResultSet。
	 *
	 * @param SQL
	 */
	public ResultSet RunSqlResultSet(String SQL)
	{
		try
		{
			AddLog(SQL, errorMsg);
 
			logger.debug(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			logger.debug(" ColorWingCode 代码生成器SQL语句:");
			logger.debug(SQL);
			errorMsg = "0";
			//ResultSet rs;
			if (cmParameters.size() > 0)
			{
				pstmt = conn.prepareStatement(SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				int i = 1;
				for (Parameters ps : cmParameters)
				{
					switch (ps.getParameterType())
					{
					case Byte:
						pstmt.setByte(i, ps.getParameterValueByte());
						break;
					case Short:
						pstmt.setShort(i, ps.getParameterValueShort());
						break;
					case Int:
						pstmt.setInt(i, ps.getParameterValueInt());
						break;
					case Long:
						pstmt.setLong(i, ps.getParameterValueLong());
						break;
					case Float:
						pstmt.setFloat(i, ps.getParameterValueFloat());
						break;
					case Double:
						pstmt.setDouble(i, ps.getParameterValueDouble());
						break;
					case Date:
						// pstmt.setDate(i, ps.getParameterValueDate());
						pstmt.setTimestamp(i, ps.getParameterValueDate());
						break;
					case Boolean:
						pstmt.setBoolean(i, ps.getParameterValueBoolean());
						break;
					case String:
						pstmt.setString(i, ps.getParameterValueString());
						break;
					case Object:
						pstmt.setObject(i, ps.getParameterValueObject());
						break;
					case ByteS:
						pstmt.setBytes(i, ps.getParameterValueByteS());
						break;
					}
					i++;
				}
				rs = pstmt.executeQuery();

			}
			else
			{
				stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(SQL);
			}

			isRun = true;
			return rs;

		}
		catch (SQLException e)
		{
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();

			isRun = false;
			TranRollBack();
			AddLogErr(SQL, errorMsg);
			e.printStackTrace();
			return null;

		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }
	}

	// 运行查询语句返回记录（DataSet、DataTable、IDString、）
	// RunSqlResultSet 运行SQL查询语句返回ResultSet。
	/**
	 * 运行SQL查询语句返回ResultSet。
	 *
	 * @param SQL
	 *            SQL语句
	 * @param isMore
	 *            是否是多条Select语句,如果是,则返回最后的select语句的结果
	 */
	public ResultSet RunSqlResultSet(String SQL, boolean isMore)
	{
		if (isMore == false)
			return RunSqlResultSet(SQL);
		try
		{
			AddLog(SQL, errorMsg);
  
			logger.debug("ColorWingCode 代码生成器SQL语句:");
			logger.debug(SQL);
			errorMsg = "0";
			//ResultSet rs;
			if (cmParameters.size() > 0)
			{
				pstmt = conn.prepareStatement(SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				int i = 1;
				for (Parameters ps : cmParameters)
				{
					switch (ps.getParameterType())
					{
					case Byte:
						pstmt.setByte(i, ps.getParameterValueByte());
						break;
					case Short:
						pstmt.setShort(i, ps.getParameterValueShort());
						break;
					case Int:
						pstmt.setInt(i, ps.getParameterValueInt());
						break;
					case Long:
						pstmt.setLong(i, ps.getParameterValueLong());
						break;
					case Float:
						pstmt.setFloat(i, ps.getParameterValueFloat());
						break;
					case Double:
						pstmt.setDouble(i, ps.getParameterValueDouble());
						break;
					case Date:
						// pstmt.setDate(i, ps.getParameterValueDate());
						pstmt.setTimestamp(i, ps.getParameterValueDate());
						break;
					case Boolean:
						pstmt.setBoolean(i, ps.getParameterValueBoolean());
						break;
					case String:
						pstmt.setString(i, ps.getParameterValueString());
						break;
					case Object:
						pstmt.setObject(i, ps.getParameterValueObject());
						break;
					case ByteS:
						pstmt.setBytes(i, ps.getParameterValueByteS());
						break;
					}
					i++;
				}
				// rs = pstmt.executeQuery();
				pstmt.execute();
				// rs = pstmt.getResultSet();
				rs = null;

				// if ((pstmt.getMoreResults() == false) && (pstmt.getUpdateCount() == -1))
				// rs = pstmt.getResultSet();

				int nextIndex = 0;
				boolean isNext = true;
				while (isNext)
				{
					if (pstmt.getMoreResults())
					{
						rs = pstmt.getResultSet();
						isNext = false;
					}
					// 循环大于100次,认为是没有找到最后的select语句,直接执行当前的select语句
					if (nextIndex > 100)
					{
						rs = pstmt.getResultSet();
						break;
					}
					nextIndex++;

				}
			}
			else
			{
				stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				// rs = stmt.executeQuery(SQL);
				stmt.execute(SQL);
				// rs = stmt.getResultSet();
				rs = null;

				// if ((stmt.getMoreResults() == false) && (stmt.getUpdateCount() == -1))
				// rs = stmt.getResultSet();
				int nextIndex = 0;
				boolean isNext = true;
				while (isNext)
				{
					if (stmt.getMoreResults())
					{
						rs = stmt.getResultSet();
						isNext = false;
					}
					// 循环大于100次,认为是没有找到最后的select语句,直接执行当前的select语句
					if (nextIndex > 100)
					{
						rs = stmt.getResultSet();
						break;
					}
					nextIndex++;

				}
			}

			isRun = true;
			return rs;

		}
		catch (SQLException e)
		{
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();

			isRun = false;
			TranRollBack();
			AddLogErr(SQL, errorMsg);
			e.printStackTrace();
			return null;

		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }
	}

	// 运行查询语句不返回记录集（无返回记录、返回一个字段、返回一条记录）
	// 函数实现——RunSql 运行SQL查询语句，不返回记录集。用于添加、修改、删除等操作
	/**
	 * 运行SQL查询语句，不返回记录集。用于添加、修改、删除等操作
	 *
	 * @param SQL查询语句
	 *            。比如insert into tableName 、update tableName...
	 *
	 */
	public boolean RunSql(String SQL)
	{

		try
		{
			AddLog(SQL, errorMsg);
 
			logger.debug(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			logger.debug(" ColorWingCode 代码生成器SQL语句:");
			logger.debug(SQL);
			errorMsg = "0";
			// ResultSet rs;
			if (cmParameters.size() > 0)
			{
				pstmt = conn.prepareStatement(SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				int i = 1;
				for (Parameters ps : cmParameters)
				{	
					
					switch (ps.getParameterType())
					{
					case Byte:
						pstmt.setByte(i, ps.getParameterValueByte());
						break;
					case Short:
						pstmt.setShort(i, ps.getParameterValueShort());
						break;
					case Int:
						pstmt.setInt(i, ps.getParameterValueInt());
						break;
					case Long:
						pstmt.setLong(i, ps.getParameterValueLong());
						break;
					case Float:
						pstmt.setFloat(i, ps.getParameterValueFloat());
						break;
					case Double:
						pstmt.setDouble(i, ps.getParameterValueDouble());
						break;
					case Date:
						// pstmt.setDate(i, ps.getParameterValueDate());
						pstmt.setTimestamp(i, ps.getParameterValueDate());
						break;
					case Boolean:
						pstmt.setBoolean(i, ps.getParameterValueBoolean());
						break;
					case String:
						pstmt.setString(i, ps.getParameterValueString());
						break;
					case Object:
						pstmt.setObject(i, ps.getParameterValueObject());
						break;
					case ByteS:
						pstmt.setBytes(i, ps.getParameterValueByteS());
						break;
					}
					i++;
				}
				pstmt.executeUpdate();
			}
			else
			{
				stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
				stmt.executeUpdate(SQL);
			}
			isRun = true;
			return true;

		}
		catch (SQLException e)
		{
			errorMsg = "运行函数时出现错误。\n错误信息：" + e.getMessage() + "\n" + e.getStackTrace();

			isRun = false;
			TranRollBack();
			AddLogErr(SQL, errorMsg);
			e.printStackTrace();
			return false;
		}
		// finally
		// {
		// if (!isUseTrans) //不使用事务的时候才能关闭连接
		// cm.Connection.Close();
		// }
	}

}

class Parameters
{ // [start] 实例化 byte
	public Parameters(String ParameterName, byte ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueByte = ParameterValue;
		this.parameterType = ParameterTypes.Byte;
	}

	// [end]
	// [start] 实例化 short
	public Parameters(String ParameterName, short ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueShort = ParameterValue;
		this.parameterType = ParameterTypes.Short;
	}

	// [end]
	// [start] 实例化 int
	public Parameters(String ParameterName, int ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueInt = ParameterValue;
		this.parameterType = ParameterTypes.Int;
	}

	// [end]
	// [start] 实例化 long
	public Parameters(String ParameterName, long ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueLong = ParameterValue;
		this.parameterType = ParameterTypes.Long;
	}

	// [end]
	// [start] 实例化 float
	public Parameters(String ParameterName, float ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueFloat = ParameterValue;
		this.parameterType = ParameterTypes.Float;
	}

	// [end]
	// [start] 实例化 double
	public Parameters(String ParameterName, double ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueDouble = ParameterValue;
		this.parameterType = ParameterTypes.Double;
	}

	// [end]
	// [start] 实例化 Date
	public Parameters(String ParameterName, Date ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueDate = ParameterValue;
		this.parameterType = ParameterTypes.Date;
	}

	// [end]
	// [start] 实例化 boolean
	public Parameters(String ParameterName, boolean ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueBoolean = ParameterValue;
		this.parameterType = ParameterTypes.Boolean;
	}

	// [end]
	// [start] 实例化 String
	public Parameters(String ParameterName, String ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueString = ParameterValue;
		this.parameterType = ParameterTypes.String;
	}

	// [end]
	// [start] 实例化 Object
	public Parameters(String ParameterName, Object ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueObject = ParameterValue;
		this.parameterType = ParameterTypes.Object;
	}

	// [end]
	// [start] 实例化 byte[]
	public Parameters(String ParameterName, byte[] ParameterValue)
	{
		this.parameterName = ParameterName;
		this.parameterOutStrint = ParameterName + ":" + ParameterValue;
		this.parameterValueByteS = ParameterValue;
		this.parameterType = ParameterTypes.ByteS;
	}

	// [end]

	enum ParameterTypes
	{
		Byte, Short, Int, Long, Float, Double, Date, Boolean, String, Object,
		/**
		 * 二进制数组
		 */
		ByteS
	}

	// [start] 设置和获取 参数类型
	// 设置和获取 参数类型
	private ParameterTypes parameterType;

	/**
	 * 获取 参数名称
	 *
	 * @return 参数类型
	 */
	public ParameterTypes getParameterType()
	{
		return this.parameterType;
	}

	/**
	 * 设置 参数名称
	 *
	 * @param sCompetenceId
	 *            参数类型
	 */
	public void setParameterType(ParameterTypes sCompetenceId)
	{
		this.parameterType = sCompetenceId;
	}

	// 设置和获取 参数类型
	// [end]

	// [start] 设置和获取 参数名称
	// 设置和获取 参数名称
	private String parameterName = "";

	/**
	 * 获取 参数名称
	 *
	 * @return 参数名称
	 */
	public String getParameterName()
	{
		return this.parameterName;
	}

	/**
	 * 设置 参数名称
	 *
	 * @param sCompetenceId
	 *            参数名称
	 */
	public void setParameterName(String sCompetenceId)
	{
		this.parameterName = sCompetenceId;
	}

	// 设置和获取 参数值
	// [end]

	// [start] 设置和获取 参数名称
	// 设置和获取 参数名称
	private String parameterOutStrint = "";

	/**
	 * 获取 参数名称
	 *
	 * @return 参数名称
	 */
	public String getParameterOutStrint()
	{
		return this.parameterOutStrint;
	}

	/**
	 * 设置 参数名称
	 *
	 * @param sCompetenceId
	 *            参数名称
	 */
	public void setParameterOutStrint(String sCompetenceId)
	{
		this.parameterOutStrint = sCompetenceId;
	}

	// 设置和获取 参数值
	// [end]

	// [start] 参数值 byte
	private byte parameterValueByte;

	/**
	 * 获取 参数值
	 */
	public byte getParameterValueByte()
	{
		return this.parameterValueByte;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueByte
	 *            参数值
	 */
	public void setParameterValue(byte sparameterValueByte)
	{
		this.parameterValueByte = sparameterValueByte;
	}

	// [end]
	// [start] 参数值 short
	private short parameterValueShort;

	/**
	 * 获取 参数值
	 */
	public short getParameterValueShort()
	{
		return this.parameterValueShort;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueShort
	 *            参数值
	 */
	public void setParameterValue(short sparameterValueShort)
	{
		this.parameterValueShort = sparameterValueShort;
	}

	// [end]
	// [start] 参数值 int
	private int parameterValueInt;

	/**
	 * 获取 参数值
	 */
	public int getParameterValueInt()
	{
		return this.parameterValueInt;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueInt
	 *            参数值
	 */
	public void setParameterValue(int sparameterValueInt)
	{
		this.parameterValueInt = sparameterValueInt;
	}

	// [end]
	// [start] 参数值 long
	private long parameterValueLong;

	/**
	 * 获取 参数值
	 */
	public long getParameterValueLong()
	{
		return this.parameterValueLong;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueLong
	 *            参数值
	 */
	public void setParameterValue(long sparameterValueLong)
	{
		this.parameterValueLong = sparameterValueLong;
	}

	// [end]
	// [start] 参数值 float
	private float parameterValueFloat;

	/**
	 * 获取 参数值
	 */
	public float getParameterValueFloat()
	{
		return this.parameterValueFloat;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueFloat
	 *            参数值
	 */
	public void setParameterValue(float sparameterValueFloat)
	{
		this.parameterValueFloat = sparameterValueFloat;
	}

	// [end]
	// [start] 参数值 double
	private double parameterValueDouble;

	/**
	 * 获取 参数值
	 */
	public double getParameterValueDouble()
	{
		return this.parameterValueDouble;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueDouble
	 *            参数值
	 */
	public void setParameterValue(double sparameterValueDouble)
	{
		this.parameterValueDouble = sparameterValueDouble;
	}

	// [end]
	// [start] 参数值 Date
	private Date parameterValueDate;

	/**
	 * 获取 参数值
	 */
	public java.sql.Timestamp getParameterValueDate()
	{
		// java.sql.Date dt = new java.sql.Date(this.parameterValueDate.getTime());
		java.sql.Timestamp dt = new java.sql.Timestamp(this.parameterValueDate.getTime());
		return dt;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueDate
	 *            参数值
	 */
	public void setParameterValue(Date sparameterValueDate)
	{
		this.parameterValueDate = sparameterValueDate;
	}

	// [end]
	// [start] 参数值 boolean
	private boolean parameterValueBoolean;

	/**
	 * 获取 参数值
	 */
	public boolean getParameterValueBoolean()
	{
		return this.parameterValueBoolean;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueBoolean
	 *            参数值
	 */
	public void setParameterValue(boolean sparameterValueBoolean)
	{
		this.parameterValueBoolean = sparameterValueBoolean;
	}

	// [end]
	// [start] 参数值 String
	private String parameterValueString;

	/**
	 * 获取 参数值
	 */
	public String getParameterValueString()
	{
		return this.parameterValueString;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueString
	 *            参数值
	 */
	public void setParameterValue(String sparameterValueString)
	{
		this.parameterValueString = sparameterValueString;
	}

	// [end]
	// [start] 参数值 Object
	private Object parameterValueObject;

	/**
	 * 获取 参数值
	 */
	public Object getParameterValueObject()
	{
		return this.parameterValueObject;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueObject
	 *            参数值
	 */
	public void setParameterValue(Object sparameterValueObject)
	{
		this.parameterValueObject = sparameterValueObject;
	}

	// [end]
	// [start] 参数值 byte[]
	private byte[] parameterValueByteS;

	/**
	 * 获取 参数值
	 */
	public byte[] getParameterValueByteS()
	{
		return this.parameterValueByteS;
	}

	/**
	 * 设置 参数值
	 *
	 * @param sparameterValueByteS
	 *            参数值
	 */
	public void setParameterValue(byte[] sparameterValueByteS)
	{
		this.parameterValueByteS = sparameterValueByteS;
	}
	// [end]

}
