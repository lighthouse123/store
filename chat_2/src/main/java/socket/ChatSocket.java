package socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import vo.ContentVo;
import vo.Message;

@ServerEndpoint("/chatSocket")
public class ChatSocket {
	

	private Gson gson = new Gson();
	
	private String username;
	private List<Session> sessions = new ArrayList<Session>();
	private Map<String,Session> map = new HashMap<String,Session>();
	private static List<String> names = new ArrayList<String>();
	@OnOpen
	public void open(Session session) {
	//	gson.fromjson
		String string = session.getQueryString();
		System.out.println(string);
		
		username = string.split("=")[1];
		System.out.println("000000000000");
		System.out.println(username);
		names.add(username);
		sessions.add(session);
		this.map.put(username, session);
		
		String msg = "欢迎"+this.username+"进入聊天密室!!</br>";
		Message message = new Message();
		
		message.setMessage(msg);
		message.setUsernames(names);
		
		this.broadcast(this.sessions,msg);//message.toJson());
				
		
		
	}
	private void broadcast(List<Session> session, String msg) {
		for(Session ss:session) {
			try {
				ss.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@OnClose
	public void close(Session session) {
		this.sessions.remove(session);
		this.names.remove(this.username);
		
		String msg = this.username+"离开聊天密室!!</br>";
		Message message = new Message();
		message.setMessage(msg);
		message.setUsernames(this.names);
		
		//broadcast(this.sessions,message.toJson());
	}
	
	
	@OnMessage
	public void message(Session session ,String json) {
		ContentVo vo = gson.fromJson(json, ContentVo.class);
		
		if(vo.getType()==1) {//广播
			Message message = new Message();
			//message.setUsernames(this.names);
			message.setContent(this.username,"<font color=red> 私聊："+vo.getMsg()+"</font>");
			//broadcast(sessions,message.toJson());
			
			
		/*	
		}else {//单聊
			//根据username  找到对应　的session对象　
			String to = vo.getTo();
			Session to_session = this.map.get(to);
			
			Message message  = new Message();
			message.setContent(this.username,vo.getMsg());
			
			try {
				to_session.getBasicRemote().sendText(message.toJson());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		*/
		
		
		
		
		}}}
	
	
	
	
	
	













