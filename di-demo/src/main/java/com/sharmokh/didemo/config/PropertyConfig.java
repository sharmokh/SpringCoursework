package com.sharmokh.didemo.config;

import com.sharmokh.didemo.examplebeans.FakeDataSource;
import com.sharmokh.didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Single Property Source
// @PropertySource("classpath:datasource.properties")

// Multiple Property Sources
/*
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
 */
public class PropertyConfig {

    @Value("${com.username}")
    String username;
    @Value("${com.password}")
    String password;
    @Value("${com.dburl}")
    String url;

    @Value("${com.jms.username}")
    String jmsUsername;
    @Value("${com.jms.password}")
    String jmsPassword;
    @Value("${com.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker jmsBroker = new FakeJmsBroker();
        jmsBroker.setUsername(jmsUsername);
        jmsBroker.setPassword(jmsPassword);
        jmsBroker.setUrl(jmsUrl);
        return jmsBroker;
    }


    // Bean for additional Property Sources beyond application.properties
    /*
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
     */

}
