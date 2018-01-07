package cn.intsmaze.core.exception;


//service层异常类
public class ServiceException extends SysException {

	public ServiceException() {
		super("业务操作错误！");
	}

	public ServiceException(String message) {
		super(message);
	}

	
}
