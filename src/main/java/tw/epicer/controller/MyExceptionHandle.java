package tw.epicer.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //概括整個專案的controller,發生自定義的例外事件時，會執行自定義的處理方式
public class MyExceptionHandle {
	
		@ExceptionHandler(Exception.class)
		public String exceptionHandle(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
