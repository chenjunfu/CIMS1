﻿package com.yun.bll.itemcollection.culture;

import java.util.*;
import com.yun.bll.itemcollection.*;

/*======================================================================
   开发者:贾军磊
   创建日期:2012年12月03日 12:58:10
   功能说明: 表t_system_sector 部门表的SystemSectorItemCollection的类
   表说明:部门表
======================================================================*/

    /**
    * 表t_system_sector的SystemSectorItemCollection的类
	 */
public class SystemSectorItemCollection
{
	public SystemSectorItemCollection()
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

	 // [start] IsDel 是否删除
	 // [start] IsDel  是否删除
	 private static ItemInfoCollection _IsDelCollection = null;
	 /**
	 * IsDel  是否删除 Collection
	 *
	 * @return IsDel  是否删除 T_ParentTableCollection
	 */
	 public static ItemInfoCollection IsDelCollection()
	 {
	     if (_IsDelCollection == null)
	     {
	         ItemInfoCollection list = new ItemInfoCollection();
	         //是否删除：1-未删除、2-已删除
	         list.add(new ItemInfo("1", "未删除"));
	         list.add(new ItemInfo("2", "已删除"));

	         _IsDelCollection = list;
	     }
	     return _IsDelCollection;
	 }
	 // [end]

	 // [start] IsDelText  是否删除
	 /**
	 * IsDelText   是否删除，默认不使用label标签
	 *
	 * @param IsDel 是否删除
	 * @param isCSS 使用label标签+样式表
	 * @return 是否删除 描述
	 */
	 public static String IsDelText(String IsDel)
	 {
	     return IsDelText(IsDel, false);
	 }
	 // [end]

	 // [start] IsDelText  是否删除
	 /**
	 * IsDelText   是否删除，默认不使用label标签
	 *
	 * @param IsDel 是否删除
	 * @param isCSS 使用label标签+样式表
	 * @return 是否删除 描述
	 */
	 public static String IsDelText(String IsDel, boolean isCSS)
	 {

	     ItemInfoCollection list = IsDelCollection();

	     ItemInfo itemInfo = list.GetItemInfoByValue(IsDel);
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

	 // [start] IsDelOption标签
	 /**
	 * IsDelOption标签
	 * @return 是否删除 Option标签
	 */
	 public static String IsDelOption()
	 {
		StringBuilder sbStr = new StringBuilder(100);
		for (ItemInfo itemInfo : IsDelCollection())
		{
			sbStr.append(String.format("<option value=\"%1$s\">%2$s</option>\n", itemInfo.getValue(), itemInfo.getText()));
		}
		return sbStr.toString();
	 }
	 // [end]
	 // [end]

}
