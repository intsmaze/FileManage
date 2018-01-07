package cn.intsmaze.core.dao;

import java.io.Serializable;
import java.util.List;





import cn.intsmaze.core.page.PageResult;
import cn.intsmaze.core.util.QueryHelper;
import cn.intsmaze.useremail.entity.UserEmail;

public interface BaseDao<T> {
	
	//新增
	public void save(T entity);
	
	//更新
	public void update(T entity);
	
	
	//根据id数组或单个id值进行删除，参数可以是数组也可以是单个值
	//形参不要定义为Serializable[] ids，这样只能接受数组了，不能接受单个值，序列化类型可以兼容主键是整形或是字符串类型
	void deleteObjectByIds(Serializable... ids);
	
	//根据集合删除
	void deleteObjectByCollection(List<T> list);
		
	
	//根据id查找对象，这里类型使用序列号类型，而不是string或int类型，这样不管表主键是何类型都可以使用该方法，这两个类型都实现serializable接口。
	public T findObjectById(Serializable id);
	
	//查找列表
	public List<T> findObjects();
		
	//条件查询实体列表
	public List<T> findObjects(String hql, List<Object> parameters);
		
	//条件查询实体列表--查询助手queryHelper
	public List<T> findObjects(QueryHelper queryHelper);
		
	//分页条件查询实体列表--查询助手queryHelper
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);




	

}
