package tw.epicer.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


//對應mvc-servlet.xml的java程式組態
@Configuration
//<context:annotation-config/>

@EnableWebMvc
//<mvc:annotation-driven/>

@ComponentScan(basePackages = {"tw.epicer"})
//<context:component-scan base-package="tw.leonchen"/>
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
//	<mvc:default-servlet-handler/>
	
	
	
	//module.7
	//透過加入該組態設定虛擬路徑(邏輯名稱)
	//將view元件放在WEB-INF下，使用者就無法直接呼叫
	//internalResourceViewResolver則會設定裡面view的邏輯名稱
	//以後return jsp view就不需要加/和jsp可以直接呼叫檔案名稱
	//加入後就無法直接用.jsp檔run server 必須要開啟server後透過網址列呼叫Servlet 讓它return view給頁面
	//範例裡面把jsp檔丟到WEB-INF/pages裡面設立虛擬路徑
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr1 = new InternalResourceViewResolver();
		//將虛擬路徑設定為:/WEB-INF/pages/後贅詞為.jsp的檔案，不在路徑內的就會找不到
		//所以檔案都要移到pages裡
		irvr1.setPrefix("/WEB-INF/pages/");
		irvr1.setSuffix(".jsp");
		irvr1.setOrder(6);
		return irvr1;
	}
	//搭配loginSystemController.java
	//更改虛擬路徑後，呼叫loginSystem.jsp的方法改為啟動server->網址輸入http://localhost:8080/SpringMvcProject/loginsystemmain.controller呼叫LoginSystemController.java內的對應方法->return loginSystem


	//module.14 使用靜態資源
		//resouceHandler會解析靜態資源位置並給予相對應的虛擬位置
		//addResourceHandler(新的虛擬位置).addresourceLocations(原始資源位置)
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");
			registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
			registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
			
		}


		//viewController會把指定的虛擬路徑再指定新的虛擬位置
		//addRedirectViewController(指定路徑,虛擬位置)->在網址列輸入原本位置會導向到新的虛擬位置
		//addViewController(指定路徑).setViewName(虛擬位置)->在網址列輸入指定路徑會呈現虛擬位置的網頁(view)
//		@Override
//		public void addViewControllers(ViewControllerRegistry registry) {
//			registry.addRedirectViewController("/", "membersmain.controller");
//		}
		@Bean
		public CommonsMultipartResolver multipartResolver() {
			CommonsMultipartResolver cmr = new CommonsMultipartResolver();
			cmr.setDefaultEncoding("UTF-8");
			return cmr;
		}
		
		@Bean
		public MappingJackson2JsonView jsonView() {
			MappingJackson2JsonView myJsonView = new MappingJackson2JsonView();
			myJsonView.setPrettyPrint(true);
			return myJsonView;
		}
		
		@Bean
		public Jaxb2Marshaller marshaller() {
			Jaxb2Marshaller jaxb2 = new Jaxb2Marshaller();
			jaxb2.setPackagesToScan("tw.epicer");
			return jaxb2;
		}
		
		@Bean
		public ContentNegotiatingViewResolver contentViewResolver() {
			ContentNegotiatingViewResolver cnvr1 = new ContentNegotiatingViewResolver();
			ArrayList<View> list = new ArrayList<View>();
			list.add(jsonView());
			cnvr1.setDefaultViews(list);
			return cnvr1;
		}

}
