package com.juber.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionState implements HttpSessionListener{
	
	public static int onlineCount = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		onlineCount++;
		HttpSessionListener.super.sessionCreated(se);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		onlineCount--;
		HttpSessionListener.super.sessionDestroyed(se);
	}
	
//	@Override
//	public void valueBound(HttpSessionBindingEvent event) {
//		onlineCount++;
//		System.out.println("当前在线人数：" + onlineCount);
//		HttpSessionBindingListener.super.valueBound(event);
//	}
//
//	@Override
//	public void valueUnbound(HttpSessionBindingEvent event) {
//		onlineCount--;
//		System.out.println("当前在线人数：" + onlineCount);
//		HttpSessionBindingListener.super.valueUnbound(event);
//	}
	
}
