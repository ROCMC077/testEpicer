package tw.epicer.config;



import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//相當於beans.config.xml的java程式組態  
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "tw.epicer")
public class RootAppConfig {
//	<bean id="datasource" class="org.springframework.jndi.JndiObjectFactoryBean"> <property name="jndiName" value="java:comp/env/connectSqlServerJdbc/SystemService"/>
	@Bean
	public DataSource dataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		//下面順序不能錯!
		jndiBean.setJndiName("java:comp/env/connectSqlServerJdbc/SystemService");
		jndiBean.afterPropertiesSet();
		//上面順序不能錯!
		DataSource ds = (DataSource) jndiBean.getObject();
		return ds;
	}
	
	
//	<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean"> .........
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("tw.epicer");
		factory.setHibernateProperties(additionalproperties());
		return factory;
	}
	
	private Properties additionalproperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", org.hibernate.dialect.SQLServer2016Dialect.class);
		props.put("hibernate.show_sql",Boolean.TRUE);
		props.put("hibernate.format_sql",Boolean.TRUE);
//		props.put("hibernate.current_session_context_class","thread");
		props.put("hibernate.allow_update_outside_transaction", Boolean.TRUE);
		return props;
	}
//	</bean>

//	module.10 transaction
//	transactionManager會在註解有@Transactional的class內(ex.AccountService.java)
//	提供管理交易的功能，可以在該class內所有方法(或自行設定)負責進行開啟和關閉session，就不用另外撰寫transaction的open和close，應該是一種AOP?
//	有被管理的功能會有橘色的箭頭註解
//	<bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager"> <property name="sessionFactory" ref="sessionFactory"/>
//	記得要加bean 和autowired 不然找不到 跳No qualifying bean of type 'org.springframework.transaction.TransactionManager' available
	@Bean @Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(factory);
		return txMgr;
	}
}
