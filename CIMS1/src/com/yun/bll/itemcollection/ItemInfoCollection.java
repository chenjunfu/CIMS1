package com.yun.bll.itemcollection;

import java.util.ArrayList;

public class ItemInfoCollection extends ArrayList<ItemInfo>
{

	/**
	 *
	 */
	private static final long serialVersionUID = -5020721910239475839L;

	public ItemInfo GetItemInfoByValue(String value)
	{
		for (ItemInfo itemInfo : this)
		{
			if (itemInfo.getValue().equals(value))
			{
				return itemInfo;
			}
		}
		return null;
	}
}

