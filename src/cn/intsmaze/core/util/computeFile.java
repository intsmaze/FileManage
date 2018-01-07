package cn.intsmaze.core.util;

/**  
* @Description: 计算上传文件的大小，如果文件小于1M，则文件显示kb,文件大于1M，显示单位是M
* @Author: 刘洋（作者）
* @Create Date: 2015-11-5（创建日期）
*/
public class computeFile {

	/**
	 *  计算上传文件的大小，如果文件小于1M，则文件显示kb,文件大于1M，显示单位是M
	 * */
	public static String getFileSize(long size)
	{
		String demo=null;
		if(size>1048576)
		{
			demo=String.valueOf(size/(float)1048576);
			demo=demo.substring(0, 4);			
		}
		else
		{
			demo=String.valueOf(size/(float)1048576);
			demo=demo.substring(0, 5);
		}
		return demo;
	}
	
}
