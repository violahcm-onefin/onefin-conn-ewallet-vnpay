package com.onefin.ewallet.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.vnpay.vntopup.VnpSrvSoap;

@Configuration
public class VnpayClientConfig {
	
	@Value("${vnpay.airtimeTopup.soapUrl}")
	private String soapUrl;
	
	@Bean(name = "vnpayTopupProxy")
	public VnpSrvSoap vnpayTopupProxy() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(VnpSrvSoap.class);
		jaxWsProxyFactoryBean.setAddress(soapUrl.trim());
		return (VnpSrvSoap) jaxWsProxyFactoryBean.create();
    }
	
	/*
	@Bean(name = "vnpayTopupClientProxy")
	public Client vnpayTopupClientProxy() {
		Client client = ClientProxy.getClient(vnpayTopupProxy());
        return getVnpayTopupClientProxy(client);
	}
	
	protected Client getVnpayTopupClientProxy(Client client) {
        Map<String, Object> outProps = new HashMap<>();
        client.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
		return client;
	}
	*/
}
