
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:20:30
   功能说明: 表t_education 学历表的实体类EducationInfo的数据层基类
   表说明:学历表
======================================================================*/
package com.yun.sqlserverdal.culture;

import java.util.*;
import com.yun.entities.culture.*;
import com.yun.entities.culture.collection.*;
import com.yun.sqlserverdal.*;
import com.yun.sqlserverdal.culture.base.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


/**
 * 表 t_education 学历表 的实体EducationInfo的数据操作类
 * @author 贾军磊
 *
 */
public class EducationDAL extends EducationDALBase
{
  // [start] EducationDAL
	public EducationDAL()
	{
		super();
	}

	public EducationDAL(String connectionString, String DbUserName, String DbPassWord, String connectionStringUpdate, String DbUserNameUpdate, String DbPassWordUpdate)
	{
		super(connectionString, DbUserName, DbPassWord, connectionStringUpdate, DbUserNameUpdate, DbPassWordUpdate);

	}
  // [end]
    // [start] GetListByEducationdatabaseidReturnSQL
    /**
    * 根据 <br />
* EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
返回表t_education 学历表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:44:44
    * @param Educationdatabaseid EducationdatabaseID 
    * @return SQL语句 
    */
    public String GetListByEducationdatabaseidReturnSQL(int Educationdatabaseid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_education]\n");
        boolean isWhere = true;

        //EducationdatabaseID
        if (Educationdatabaseid != 0)
        {
            if (isWhere)
            {
                sbStr.append("		WHERE\n");
                isWhere = false;
            }
            else
            {
                sbStr.append("		 AND ");
            }
        sbStr.append("	 [EducationdatabaseID] = ?\n");//-- EducationdatabaseID
        getDP().AddNewParameter("Educationdatabaseid",Educationdatabaseid ); // EducationdatabaseID
        }
        if (OrderBy.trim().length() > 0)
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append(OrderBy);
        sbStr.append("\n");
        }
        else
        {
        sbStr.append("	ORDER BY\n");
        sbStr.append("		[EducationdatabaseID] DESC \n");//EducationdatabaseID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByEducationdatabaseid
    /**
    * 根据 <br />
* EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
返回表t_education 学历表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:44:44
    * @param Educationdatabaseid EducationdatabaseID 
    * @return 数据列表的强类型实体类 
    */
    public EducationInfoCollection GetListByEducationdatabaseid(int Educationdatabaseid, String OrderBy)
    {
        EducationInfoCollection list = new EducationInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.EducationInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByEducationdatabaseidReturnSQL(Educationdatabaseid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new EducationInfo(rs));
        }
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
        }
        getDP().Dispose();
        return list;
    }
    // [end]
    // [start] GetListByEducationdatabaseid
    /**
    * 根据 <br />
* EducationdatabaseID Educationdatabaseid EducationdatabaseID<br />
返回表t_education 学历表的数据列表<br />
    * 开发者 贾军磊 2012年12月11日 10:44:44
    * @param Educationdatabaseid EducationdatabaseID 
    * @return 数据列表的强类型实体类 
    */
    public EducationInfoCollection GetListByEducationdatabaseid(int Educationdatabaseid)
    {
        return GetListByEducationdatabaseid(Educationdatabaseid, "");
    }
    // [end]


}