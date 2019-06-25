package com.pp.websocke;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
/**
 * 当与服务器建立连接时调用
 * @author acer
 *
 */
@ServerEndpoint("/websocket")
public class WebSocketSync {
	
	//session保存用户请求过来的信息
	private Session session;
	
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		System.out.println(session.getId()+"--------------建立连接------------------");
		
	}
	/**
	 * 当连接关闭时调用
	 */
	@OnClose
	public void onClose(Session session) {
		System.out.println(session.getId() + "--------连接关闭---------");
	}
	
	/**
	 * 
	 * 收到来自客户端的消息是调用,session保存发送消息的客户端信息
	 * 
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		String messageUser = null;
		
	}
	
	/**
	 * 发生错误时调用
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
	}
	
	private void sendMessage(String message) throws IOException {
		// TODO Auto-generated method stub
		this.session.getBasicRemote().sendText(message);
	}
	
	public static synchronized Set<String> getUser(){
		return null;
		
	}
	
}





















