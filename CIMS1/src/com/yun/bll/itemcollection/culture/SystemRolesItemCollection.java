package com.yun.bll.itemcollection.culture;

import java.util.*;
import com.yun.bll.itemcollection.*;

/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 12:58:01
   功能说明: 表t_system_roles 角色表的SystemRolesItemCollection的类
   表说明:角色表
======================================================================*/

    /**
    * 表t_system_roles的SystemRolesItemCollection的类
	 */
public class SystemRolesItemCollection
{
	public SystemRolesItemCollection()
	{
		//
		// 
		//
	}

	 // [start] IsUse 启用标志
	 // [start] IsUse  启用标志
	 private static ItemInfoCollection _IsUseCollection = null;
	 /**
	 * IsUse  启用标志 Collection
	 *
	 * @return IsUse  启用标志 T_ParentTableCollection
	 */
	 public static ItemInfoCollection IsUseCollection()
	 {
	     if (_IsUseCollection == null)
	     {
	         ItemInfoCollection list = new ItemInfoCollection();
	         //启用标志：1-启用、2-未启用
	         list.add(new ItemInfo("1", "启用"));
	         list.add(new ItemInfo("2", "未启用"));

	         _IsUseCollection = list;
	     }
	     return _IsUseCollection;
	 }
	 // [end]

	 // [start] IsUseText  启用标志
	 /**
	 * IsUseText   启用标志，默认不使用label标签
	 *
	 * @param IsUse 启用标志
	 * @param isCSS 使用label标签+样式表
	 * @return 启用标志 描述
	 */
	 public static String IsUseText(String IsUse)
	 {
	     return IsUseText(IsUse, false);
	 }
	 // [end]

	 // [start] IsUseText  启用标志
	 /**
	 * IsUseText   启用标志，默认不使用label标签
	 *
	 * @param IsUse 启用标志
	 * @param isCSS 使用label标签+样式表
	 * @return 启用标志 描述
	 */
	 public static String IsUseText(String IsUse, boolean isCSS)
	 {

	     ItemInfoCollection list = IsUseCollection();

	     ItemInfo itemInfo = list.GetItemInfoByValue(IsUse);
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

	 // [start] IsUseOption标签
	 /**
	 * IsUseOption标签
	 * @return 启用标志 Option标签
	 */
	 public static String IsUseOption()
	 {
		StringBuilder sbStr = new StringBuilder(100);
		for (ItemInfo itemInfo : IsUseCollection())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", itemInfo.getValue(), itemInfo.getText()));
		}
		return sbStr.toString();
	 }
	 // [end]
	 // [end]

}
