package demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.intsmaze.core.util.SensitivewordFilter;

public class demo {

	
	public static void main(String[] args) throws IOException {
		
		
		// 创建Spring容器
        ApplicationContext ctx = new
            ClassPathXmlApplicationContext("Sensitiveword-spring.xml");
        
        // 获取id为person的Bean
        SensitivewordFilter p = ctx.getBean("sensitivewordFilter" , SensitivewordFilter.class);
        String string = "操你妈骚穴太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
				+ "然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
				+ "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
        string=p.replaceSensitiveWord(string, 1, "*");
		System.out.println(string);
		
//		File file = new File("D:\\words1.txt");    //读取文件
//		//创建一个字符写入流对象
//        FileWriter fw=new FileWriter("D:\\words2.txt");
//        //为了提高字符写入流效率，加入了缓冲技术。
//        //只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。
//        BufferedWriter bufw=new BufferedWriter(fw);
//        
//      
//        
//		InputStreamReader read = new InputStreamReader(new FileInputStream(file));
//			if(file.isFile() && file.exists()){      //文件流是否存在
//				BufferedReader bufferedReader = new BufferedReader(read);
//				String txt = null;
//				while((txt = bufferedReader.readLine()) != null){    //读取文件，将文件内容放入到set中
//					System.out.println(txt);
//					int n=txt.lastIndexOf("，");
//					txt=txt.substring(0, n);
//					System.out.println(txt);
//					bufw.write(txt);
//				    //换行符因为在不同系统转义方式不一样，所以用bufw的函数可以实现跨平台
//				    bufw.write("\r\n");
////				    bufw.newLine();//只所以可以实现跨平台，主要是调用底层的代码，而底层的代码是根据安装在不同平台下
//				    //的jdk版本来确定的。
//				    //只要用到缓冲区就要记得刷新。
//				        bufw.flush();
//				       
//			    }
//			}
//			 //这里虽然是FileWriter调用的系统资源，但是只需要关闭缓冲区就可以了，它就是在关闭缓冲区中的流对象。
//	        bufw.close();
//			read.close();     //关闭文件流
	}
}
