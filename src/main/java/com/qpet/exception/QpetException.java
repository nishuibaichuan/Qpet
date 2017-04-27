package com.qpet.exception;
/** 
 * @Desc: ()
 * @author: 张瑞
 * @date: 2017年4月1日 下午2:37:25  
 * @email:2411685663@qq.com 
 */
public class QpetException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public QpetException() {
		super();
	}

	public QpetException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public QpetException(String message, Throwable cause) {
		super(message, cause);
	}

	public QpetException(String message) {
		super(message);
	}

	public QpetException(Throwable cause) {
		super(cause);
	}
	
	
}
