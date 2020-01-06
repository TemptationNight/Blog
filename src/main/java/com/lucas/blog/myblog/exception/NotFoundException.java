package com.lucas.blog.myblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.exception
 * @ClassName: NotFoundException
 * @Author: Heyuanhui
 * @Description: ${异常类  404}
 * @Date: 2019/9/3 20:48
 * @Version: 1.0
 */


@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends RuntimeException{
	public NotFoundException() {
	}

	public NotFoundException(String message)
	{
		super(message);
	}

	public NotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
}


