package cn.intsmaze.usestate.service;

import java.util.List;

import cn.intsmaze.core.service.BaseService;
import cn.intsmaze.usestate.entity.UseState;


public interface UseStateService extends BaseService<UseState>{
	public final static String SERVICE_NAME=
			"cn.intsmaze.usestate.service.UseStateServiceImpl";

	List<UseState> getIsDownByUseridAndFileid(String fileid, String userid);
}
