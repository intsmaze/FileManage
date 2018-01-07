package cn.intsmaze.core.util;

public class RateUtil {

	
	//根据好评和总评数量计算好评率
	public static String getGoodCommentRate(long goodComment,long badComment)
	{
		if((goodComment+badComment)==0)
		{
			return "0";
		}
		else
		{
			if(goodComment==0)
			{
				return "0";
			}
			float rate=goodComment/(float)(goodComment+badComment);
			
			return String.valueOf(rate*100).substring(0, 4);
		}
	
	}
	
	public static void main(String args[]) {
		System.out.println(getGoodCommentRate(0, 0));
	}
}
