package com.task.api.configuration;

import java.util.Collections;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.mongodb.ConnectionString;


@Configuration
   

public class MongoConfig implements InitializingBean {
	
	
	    @Autowired
	    @Lazy
	    private MappingMongoConverter mappingMongoConverter;

	    @Override
	    public void afterPropertiesSet() throws Exception {
	        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
	    }
	
}
	
	 
 




//@EnableMongoRepositories(basePackages = "com.task.api.repository")
//@Value("${spring.data.mongodb.database}")
//private String database;
//
//
//
//@Autowired
//private MongoDatabaseFactory mongoDbFactory;
//
////@Bean
////public SimpleMongoRepository simpleMongoRepository() throws Exception {
////  return new SimpleMongoRepository(mongoDbFactory, new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), new MongoMappingContext()));
////}
//
//@Bean
//public MongoTemplate mongoTemplate() throws Exception {
//  DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
//
//  // Remove _class
//  MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
//  converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//
//  return new MongoTemplate(mongoDbFactory, converter);
//}


	    






//@Bean
//public ValidatingMongoEventListener validatingMongoEventListener() {
//    return new ValidatingMongoEventListener(validator());
//}
//
//@Bean
//public LocalValidatorFactoryBean validator() {
//    return new LocalValidatorFactoryBean();
//}
//
//@Bean
//public MongoCustomConversions mongoCustomConversions() {
//    return new MongoCustomConversions(Collections.emptyList());
//}
	    
	    
	    
	    
	    
//		private MongoDatabaseFactory mongodbFactory;
	//	
//		  
//		 @Bean
//		    public MongoDatabaseFactory mongoDbFactory() {
//		        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/cs");
//		        return new SimpleMongoClientDatabaseFactory(connectionString);
//		    }
	//
//		    @Bean
//		    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDbFactory, MongoConverter converter) {
//		        return new MongoTemplate(mongoDbFactory, converter);
//		    }
	//
//		    @Bean
//		    public MongoConverter mongoConverter(MongoDatabaseFactory mongoDbFactory, MongoMappingContext context) {
//		        MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory, context);
//		        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//		        return converter;
//		    }
	// 
		
		
	    
	    
	    
	    
	    
	    
	    
