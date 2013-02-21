
/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 13:24:04
   功能说明: 表t_nation 民族表的实体类NationInfo的数据层基类
   表说明:民族表
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
 * 表 t_nation 民族表 的实体NationInfo的数据操作类
 * @author 贾军磊
 *
 */
public class NationDAL extends NationDALBase
{
    // [start] GetListByNationidReturnSQL
    /**
    * 根据 <br />
* NationID Nationid 民族编号<br />
返回表t_nation 民族表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 11:35:00
    * @param Nationid 民族编号 
    * @return SQL语句 
    */
    public String GetListByNationidReturnSQL(int Nationid, String OrderBy, String[] ColumnNames)
    {
        StringBuilder sbStr = new StringBuilder(1024);
        sbStr.append("SELECT \n");
            if (ColumnNames == null)
                ColumnNames = com.yun.entities.culture.NationInfo.ColumnNames;
            String LastColumnName = ColumnNames[ColumnNames.length - 1];
            for (String s : ColumnNames)
            {
                if (s.equals(LastColumnName))
                    sbStr.append("		[").append(s).append("] \n");
                else
                    sbStr.append("		[").append(s).append("], \n");
            }
        sbStr.append("FROM [t_nation]\n");
        boolean isWhere = true;

        //民族编号
        if (Nationid != 0)
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
        sbStr.append("	 [NationID] = ?\n");//-- 民族编号
        getDP().AddNewParameter("Nationid",Nationid ); // 民族编号
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
        sbStr.append("		[NationdatabaseID] DESC \n");//NationdatabaseID
        }
        return sbStr.toString();
    }
    // [end]
    // [start] GetListByNationid
    /**
    * 根据 <br />
* NationID Nationid 民族编号<br />
返回表t_nation 民族表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 11:35:00
    * @param Nationid 民族编号 
    * @return 数据列表的强类型实体类 
    */
    public NationInfoCollection GetListByNationid(int Nationid, String OrderBy)
    {
        NationInfoCollection list = new NationInfoCollection();
        getDP().ClearParameter();
        String[] columnNames = com.yun.entities.culture.NationInfo.ColumnNames;
        ResultSet rs = getDP().RunSqlResultSet(GetListByNationidReturnSQL(Nationid, OrderBy, columnNames));
        if (rs != null)
        {
		try
		{
        while (rs.next())
        {
            list.add(new NationInfo(rs));
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
    // [start] GetListByNationid
    /**
    * 根据 <br />
* NationID Nationid 民族编号<br />
返回表t_nation 民族表的数据列表<br />
    * 开发者 贾军磊 2013年01月16日 11:35:00
    * @param Nationid 民族编号 
    * @return 数据列表的强类型实体类 
    */
    public NationInfoCollection GetListByNationid(int Nationid)
    {
        return GetListByNationid(Nationid, "");
    }
    // [end]



}