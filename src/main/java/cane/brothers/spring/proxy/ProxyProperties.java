package cane.brothers.spring.proxy;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("proxy")
public class ProxyProperties {
	
	private String proxyHost;
	private String proxyPort;
	
	public String getProxyHost() {
		return proxyHost;
	}
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}
	public String getProxyPort() {
		return proxyPort;
	}
	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}
	
	
}
