package com.yun.bll.itemcollection.culture;

import java.util.*;
import com.yun.bll.itemcollection.*;

/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月04日 09:33:14
   功能说明: 表t_system_admin_log 管理人员日志表的SystemAdminLogItemCollection的类
   表说明:管理人员日志表
======================================================================*/

    /**
    * 表t_system_admin_log的SystemAdminLogItemCollection的类
	 */
public class SystemAdminLogItemCollection
{
	public SystemAdminLogItemCollection()
	{
		//
		// 
		//
	}

	 // [start] Type 日志类型
	 // [start] Type  日志类型
	 private static ItemInfoCollection _TypeCollection = null;
	 /**
	 * Type  日志类型 Collection
	 *
	 * @return Type  日志类型 T_ParentTableCollection
	 */
	 public static ItemInfoCollection TypeCollection()
	 {
	     if (_TypeCollection == null)
	     {
	         ItemInfoCollection list = new ItemInfoCollection();
	         //日志类型：1-操作日志、2-登录日志
	         list.add(new ItemInfo("1", "操作日志"));
	         list.add(new ItemInfo("2", "登录日志"));

	         _TypeCollection = list;
	     }
	     return _TypeCollection;
	 }
	 // [end]

	 // [start] TypeText  日志类型
	 /**
	 * TypeText   日志类型，默认不使用label标签
	 *
	 * @param Type 日志类型
	 * @param isCSS 使用label标签+样式表
	 * @return 日志类型 描述
	 */
	 public static String TypeText(String Type)
	 {
	     return TypeText(Type, false);
	 }
	 // [end]

	 // [start] TypeText  日志类型
	 /**
	 * TypeText   日志类型，默认不使用label标签
	 *
	 * @param Type 日志类型
	 * @param isCSS 使用label标签+样式表
	 * @return 日志类型 描述
	 */
	 public static String TypeText(String Type, boolean isCSS)
	 {

	     ItemInfoCollection list = TypeCollection();

	     ItemInfo itemInfo = list.GetItemInfoByValue(Type);
	     if (itemInfo != null)
	     {
	         if (isCSS)
	         {
				return String.format("<label class=\"Sort%1$s\">%2$s</label>",
						itemInfo.getValue(), itemInfo.getText());
	         }
	         else
	         {
	             return itemInfo.getText();
	         }
	     }
	     return "";
	 }
	 // [end]

	 // [start] TypeOption标签
	 /**
	 * TypeOption标签
	 * @return 日志类型 Option标签
	 */
	 public static String TypeOption()
	 {
		StringBuilder sbStr = new StringBuilder(100);
		for (ItemInfo itemInfo : TypeCollection())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", itemInfo.getValue(), itemInfo.getText()));
		}
		return sbStr.toString();
	 }
	 // [end]
	 // [end]

}
