package tw.epicer.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//相當於web.xml的mvc設定組態
//需要改成web.xml的時候除了filter以外的方法全部改成return null
public class WebAppinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	//設定相當於beans.config.xml的java程式組態類別
	//詳參beans.config.xml
	@Override 
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
//		return null;
	}

//用來設定相當於mvc-servlet的java程式組態類別
//  <servlet>
//  	<servlet-name>mvc</servlet-name>
//  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//  	<load-on-startup>1</load-on-startup>不用寫，因為一開始就會直接建立
//  </servlet>
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppConfig.class};
//		return null;
	}
	
	//用來設定相當於DispatcherServlet url-pattern
//	  <servlet-mapping>
//	  	<servlet-name>mvc</servlet-name>
//	  	<url-pattern>/</url-pattern>
//	  </servlet-mapping>
	@Override 
	protected String[] getServletMappings() {
		return new String[] {"/"};
//		return null;
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef1 = new CharacterEncodingFilter();
		cef1.setEncoding("UTF-8");
		cef1.setForceEncoding(true);
		
//		CharacterEncodingFilter cef1 = new CharacterEncodingFilter("UTF-8", true);
		
		return new Filter[] {cef1};
	}

}
