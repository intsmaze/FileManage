package cn.intsmaze.core.quartz;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import cn.intsmaze.useremail.service.UserEmailService;

public class QuartzTask {

	@Resource(name=UserEmailService.SERVICE_NAME)
	private UserEmailService userEmailService;
	
	public void deletePastRecord() {
		
		userEmailService.deletePastRecord();
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println("doing simpleTrigger task..." + sdf.format(new Date()));
	}
	
}
