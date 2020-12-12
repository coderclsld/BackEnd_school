package com.lll.chat;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * 这个文件没用用到，可以不看
 */







@ServerEndpoint("/chat/{userid}")
@Component
public class SocketServer {
    //记录当前的在线连接数,AtomicInteger是一个提供原子操作的Integer类，通过线程安全的方式操作加减
    private static AtomicInteger onlineNum = new AtomicInteger();
    private static ConcurrentHashMap<String, Session> sessionsPools = new ConcurrentHashMap<>();

    //成功建立连接时为没有创建Session回话的userid创建回话
    @OnOpen
    public void createSession(@PathParam(value = "userid")String userid){
        if(sessionsPools.get(userid)==null){
            Session se = new webSocketSession();
            sessionsPools.put(userid,se);
        }
    }

    //发送消息给指定session
    public void sendMessage(Session session,String message) throws IOException{
        if(session != null){
            synchronized (session) {
                System.out.println("发送数据"+message);
                session.getBasicRemote().sendText(message);
            }
        }
    }

    //给指定用户发送信息
    public void send(String userid,String message){
        Session session = sessionsPools.get(userid);
        try {
            sendMessage(session,message);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

//    移除指定userid的session
    @OnClose
    public void removeSession(@PathParam(value = "userid") String userid){
        sessionsPools.remove(userid);
        subOnlineCount();
    }
//客户端发送过来的消息
    @OnMessage
    public void onMessage(String message,Session tosession) throws IOException {
        System.out.println(message);
        for (Session se:sessionsPools.values()){
            if (se == tosession){
                se.getBasicRemote().sendText(message);
            }
        }
    }

    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }
}
