package com.park.login.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WX_WebSocketController {

	// 记录当前在线人数
		private static int onlineCount = 0;
		// CopyOnWriteArraySet是安全的set集合，用来存放客户端的每个websocket对象
		private static CopyOnWriteArraySet<WX_WebSocketController> set = new CopyOnWriteArraySet<WX_WebSocketController>();
		// 与客户端的连接会话
		private Session session;
		// 返回的信息
		private String message;
		// 当前用户的线程名字
		private String username;
	 
		/**
		 * 连接建立成功调用的方法
		 * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
		 */
		@OnOpen
		public void onOpen(Session session) throws IOException {
			// 初始化session
			this.session = session;
			// 将当前session添加到set集合中
			set.add(this);				
			// 在线人数加1
			onlineCount++;
			// 修改当前线程的名字
			Thread.currentThread().setName("用户" + onlineCount);
			// 获取当前线程的名字
			username = Thread.currentThread().getName();
			// 编写返回的信息
			message = username + "登录成功，当前在线人数为：" + onlineCount + "人";
			// 群发消息
			for (WX_WebSocketController websocketTomcat : set) {
				websocketTomcat.session.getBasicRemote().sendText(message);
			}
		}
	 
		/**
		 * 连接关闭调用的方法
		 */
		@OnClose
		public void onClose() throws IOException {
			// 将当前session从set集合中移除
			set.remove(this);
			// 在线人数减1
			onlineCount--;
			// 编写返回的信息
			message = username + "下线成功,当前在线人数为：" + onlineCount + "人";
			// 判断set集合中是否还有websocket对象
			if (set.size() > 0) {
				// 群发消息
				for (WX_WebSocketController websocketTomcat : set) {
					websocketTomcat.session.getBasicRemote().sendText(message);
				}
			}
		}
	 
		/**
		 * 连接关闭调用的方法
		 */
		@OnError
		public void onError(Throwable error) {
			error.printStackTrace();
		}
	 
		/**
		 * 收到客户端消息后调用的方法
		 * @param message 客户端发送过来的消息
		 * @param session 可选的参数
		 */
		@OnMessage
		public void onMessage(String message) throws IOException {
			// 群发消息
			for (WX_WebSocketController websocketTomcat : set) {
				websocketTomcat.session.getBasicRemote().sendText(message);
			}
		}

}
