package com.yun.bll.itemcollection;

public class ItemInfo
{
	/**
	 * Value值，字符型
	 */
	private String value; // Value值，字符型
	/**
	 * Text值的文本描述
	 */
	private String text; // text值的文本描述

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	/**
	 *
	 * @param Value需要显示的值
	 * @param Text值的描述
	 */
	public ItemInfo(String Value, String Text)
	{
		this.value = Value;// Value值，字符型
		this.text = Text;// Value值的文本描述

	}

}

