package cane.brothers.spring.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cane.brothers.spring.api.ICanProxy;

@Configuration
@ConditionalOnProperty(prefix = "proxy", name = "host")
@EnableConfigurationProperties(ProxyProperties.class)
public class ProxyAutoConfiguration {

	private static final Logger log = LoggerFactory.getLogger(ProxyAutoConfiguration.class);

	@Autowired
	private ProxyProperties properties;
	
	@Bean
	public ICanProxy getSystemProxy() {
		return new ICanProxy() {
			@Override
			public void configure() {
				log.info("configure proxy via system properties");
				System.setProperty("http.proxyHost", properties.getProxyHost());
				System.setProperty("http.proxyPort", properties.getProxyPort());
			}
		};
	}
}
