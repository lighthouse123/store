package config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class DemoConfig implements ServerApplicationConfig{

	/**
	 * ע�ⷽʽ��̡�����
	 */
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scand) {
		System.out.println("config..........."+scand.size());
		return scand;
	}
	
	/**\
	 * �ӿڷ�ʽ��
	 */
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		return null;
	}

}
