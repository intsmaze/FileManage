package cn.intsmaze.usestate.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.intsmaze.core.service.BaseServiceImpl;
import cn.intsmaze.user.dao.UserDao;
import cn.intsmaze.usestate.dao.UseStateDao;
import cn.intsmaze.usestate.entity.UseState;


@Service(UseStateService.SERVICE_NAME)
public class UseStateServiceImpl extends BaseServiceImpl<UseState>
					implements UseStateService
{
	private UseStateDao useStateDao;
	
	@Resource (name="useStateDaoImpl")
	public void setUseStateDao(UseStateDao useStateDao) {
		super.setBaseDao(useStateDao);
		this.useStateDao = useStateDao;
	}

	@Override
	public List<UseState> getIsDownByUseridAndFileid(String fileid,
			String userid) {
		return useStateDao. getIsDownByUseridAndFileid(fileid,userid);
	}

}
