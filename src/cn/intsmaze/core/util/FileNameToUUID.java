package cn.intsmaze.core.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.intsmaze.core.constant.Constant;

/**  
* @Description: 把用户上传文件名转换为uuid格式唯一的文件名
* @Author: 刘洋（作者）
* @Create Date: 2015-10-24（创建日期）
*/
public class FileNameToUUID {

	/**  
	* @throws IOException 
	* @Name: getUUID
	* @Description: 转换单个文件名,并转换类型为swf
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-10-24（创建日期）
	* @Parameters: 文件数据，文件名
	*/
	public static String getUUID(File file,String fileName) throws IOException
	{
		
		//处理文件
		if(file != null){
			
			//1、保存文件到upload/user
			//获取保存路径的绝对地址
			String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
			//重命名文件，放置后面上传文件名与前面的文件名相同会覆盖掉
			//uuid名称+文件后缀
			String fileNameNow = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));	
			//复制文件
			FileUtils.copyFile(file, new File(filePath, fileNameNow));
			
			//对文件进行格式转换，前台等待的时间太长，要想办法解决。使用js或后台对这个代码开启一个线程。	
			String demo=filePath+"/"+fileNameNow;
			demo=demo.replace("\\", "/");
			DocConverter d = new DocConverter(demo);
			d.conver();	
			return "user/"+fileNameNow;
		}
		
		return null;
	}
	
	
	/**  
	* @throws IOException 
	* @Name: getUUID
	* @Description: 转换单个文件名,并转换类型为swf
	* @Author: 刘洋（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2015-10-24（创建日期）
	* @Parameters: 文件数据，文件名
	*/
	public static String getImageUUID(File file,String fileName) throws IOException
	{		
		//处理文件
		if(file != null){		
			//1、保存文件到upload/user
			//获取保存路径的绝对地址
			String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
			//重命名文件，放置后面上传文件名与前面的文件名相同会覆盖掉
			//uuid名称+文件后缀
			String fileNameNow = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));	
			//复制文件
			FileUtils.copyFile(file, new File(filePath, fileNameNow));
			return "user/"+fileNameNow;
		}
		
		return null;
	}
}
