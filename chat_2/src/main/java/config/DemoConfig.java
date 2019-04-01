package config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class DemoConfig implements ServerApplicationConfig{

	/**
	 * 注解方式编程　启动
	 */
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scand) {
		System.out.println("config..........."+scand.size());
		return scand;
	}
	
	/**\
	 * 接口方式　
	 */
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		return null;
	}

}
