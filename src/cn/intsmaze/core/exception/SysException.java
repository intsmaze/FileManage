package cn.intsmaze.core.exception;

//系统总的异常类
public abstract class SysException extends Exception {
	
	private String errorMsg;

	public SysException() {
		super();
	}

	public SysException(String message, Throwable cause) {
		super(message, cause);
		errorMsg = message;
	}

	public SysException(String message) {
		super(message);
		errorMsg = message;
	}

	public SysException(Throwable cause) {
		super(cause);
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
