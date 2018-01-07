package cn.intsmaze.usestate.dao;

import java.util.List;

import cn.intsmaze.core.dao.BaseDao;
import cn.intsmaze.usestate.entity.UseState;


public interface UseStateDao extends BaseDao<UseState>{

	List<UseState> getIsDownByUseridAndFileid(String fileid, String userid);

}
