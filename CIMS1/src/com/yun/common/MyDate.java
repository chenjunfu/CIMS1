package com.yun.common;

import com.colorwinglib.Converts;

public class MyDate extends java.util.Date
{

	public MyDate()
	{
		super();
	}

	public MyDate(long time)
	{
		super(time);
	}

	public MyDate(java.sql.Timestamp time)
	{
		super(time.getTime());
	}

	public MyDate(java.sql.Date time)
	{
		super(time.getTime());
	}

	public MyDate(java.util.Date time)
	{
		super(time.getTime());
	}

	/**
	 * 构造一个MyDate值
	 *
	 * @param time
	 *            时间
	 * @return
	 */
	public static MyDate setDate()
	{
		return new MyDate();
	}

	/**
	 * 构造一个MyDate值
	 *
	 * @param time
	 *            时间
	 * @return
	 */
	public static MyDate setDate(java.sql.Timestamp time)
	{
		if (time != null)
			return new MyDate(time.getTime());
		else
			return new MyDate();
	}

	/**
	 * 构造一个MyDate值
	 *
	 * @param time
	 *            时间
	 * @return
	 */
	public static MyDate setDate(java.sql.Date time)
	{
		if (time != null)
			return new MyDate(time.getTime());
		else
			return new MyDate();
	}

	/**
	 * 构造一个MyDate值
	 *
	 * @param time
	 *            时间
	 * @return
	 */
	public static MyDate setDate(java.util.Date time)
	{
		if (time != null)
			return new MyDate(time.getTime());
		else
			return new MyDate();
	}

	/**
	 * 转化成MyDate类型
	 *
	 * @param s
	 *            需要转化的字符串
	 * @return
	 */
	public static MyDate Parse(String s)
	{
		return new MyDate(Converts.StrToDate(s).getTime());
	}

	/**
	 * 把此 Date 对象转换为以下形式的 String： <br />
	 * dow mon dd hh:mm:ss zzz yyyy<br />
	 * 其中：<br />
	 * dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)。 <br />
	 * mon 是月份 (Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec)。 <br />
	 * dd 是一月中的某一天（01 至 31），显示为两位十进制数。<br />
	 * hh 是一天中的小时（00 至 23），显示为两位十进制数。 <br />
	 * mm 是小时中的分钟（00 至 59），显示为两位十进制数。 <br />
	 * ss 是分钟中的秒数（00 至 61），显示为两位十进制数。 <br />
	 * zzz 是时区（并可以反映夏令时）。标准时区缩写包括方法 parse 识别的时区缩写。如果不提供时区信息，则 zzz 为空，即根本不包括任何字符。 <br />
	 * yyyy 是年份，显示为 4 位十进制数。<br />
	 */
	@Override
	public String toString()
	{
		super.toString();
		return Converts.DateToString(this, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 *
	 * 把此 Date 对象转换为以下形式的 String： <br />
	 * dow mon dd hh:mm:ss zzz yyyy<br />
	 * 其中：<br />
	 * dow 是一周中的某一天 (Sun, Mon, Tue, Wed, Thu, Fri, Sat)。 <br />
	 * mon 是月份 (Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec)。 <br />
	 * dd 是一月中的某一天（01 至 31），显示为两位十进制数。<br />
	 * hh 是一天中的小时（00 至 23），显示为两位十进制数。 <br />
	 * mm 是小时中的分钟（00 至 59），显示为两位十进制数。 <br />
	 * ss 是分钟中的秒数（00 至 61），显示为两位十进制数。 <br />
	 * zzz 是时区（并可以反映夏令时）。标准时区缩写包括方法 parse 识别的时区缩写。如果不提供时区信息，则 zzz 为空，即根本不包括任何字符。 <br />
	 * yyyy 是年份，显示为 4 位十进制数。<br />
	 *
	 * @param fromat
	 *            格式化样式
	 * @return
	 */
	public String toString(String fromat)
	{
		return Converts.DateToString(this, fromat);
	}


	/**
	 * 转化成 yyyy-MM-dd 格式
	 *
	 * @return
	 */
	public String toShortDateString()
	{
		return Converts.DateToString(this, "yyyy-MM-dd");
	}

	/**
	 * 转化成 HH:mm 格式
	 *
	 * @return
	 */
	public String toShortTimeString()
	{
		return Converts.DateToString(this, "HH:mm");
	}

	/**
	 * 转化成 HH:mm:ss 格式
	 *
	 * @return
	 */
	public String toLongTimeString()
	{
		return Converts.DateToString(this, "HH:mm:ss");
	}

	/**
	 * 转化成 yyyy-MM-dd 格式
	 *
	 * @return
	 */
	public String getShortDate()
	{
		return Converts.DateToString(this, "yyyy-MM-dd");
	}

	/**
	 * 转化成 HH:mm 格式
	 *
	 * @return
	 */
	public String getShortTime()
	{
		return Converts.DateToString(this, "HH:mm");
	}

	/**
	 * 转化成 HH:mm:ss 格式
	 *
	 * @return
	 */
	public String getLongTime()
	{
		return Converts.DateToString(this, "HH:mm:ss");
	}

}
