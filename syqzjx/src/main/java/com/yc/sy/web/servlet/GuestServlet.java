package com.yc.sy.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.yc.sy.entity.Guest;
import com.yc.sy.entity.Message;
import com.yc.sy.service.GuestService;
import com.yc.sy.service.MessageService;
import com.yc.sy.util.ServiceUtil;

/**
 * Servlet implementation class Message_test
 */
@WebServlet("/guest/*")
public class GuestServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private int NUM=6;
	private Logger logger=LogManager.getLogger(GuestServlet.class);
	private GuestService guestService;
	private MessageService messageService;
	public GuestServlet() {
		guestService=(GuestService) cxt.getBean("guestService");
		messageService=(MessageService) cxt.getBean("messageService");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uriName=ServiceUtil.getPath(request.getRequestURI());
		switch (uriName) {
		case "testCode":	//获取资质证书
			doTestCode(request, response);
			break;
		case "insert":	//提交留言
			doInsert(request, response);
			break;
		case "list":	//留言列表
			doList(request, response);
			break;
		case "delete":	//删除留言
			doDeleteMes(request, response);
			break;
		case "getByid":	//删除留言
			doGetMesById(request, response);
			break;
		case "inform":	//短信通知
			doInform(request, response);
			break;
		default:
			break;
		}
	}
	private void doInform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doSendCode(request,response,1);
		
	}
	private void doGetMesById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer gid=Integer.parseInt(request.getParameter("gid").toString());
		Guest guest=guestService.getMesById(gid);
		respOutStr(response, toJsonStr(guest));
		
	}
	private void doDeleteMes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer gid=Integer.parseInt(request.getParameter("gid").toString());
		boolean isScuess=guestService.deleteMes(gid);
		respOutStr(response, isScuess+"");
		
	}
	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Guest> gs=guestService.listGuest();
		respOutStr(response, toJsonStr(gs));
	}
	private void doInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Guest guest=getReqParam2Obj(request, Guest.class);
		boolean isScuess=guestService.insert(guest);
		respOutStr(response, isScuess+"");
		
	}
	private void doTestCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String Icode=request.getParameter("code");
		
		String code= request.getSession().getAttribute("code").toString();
		if(Icode.intern()==code.intern()){
			respOutStr(response, true+"");
		}
		
		respOutStr(response, false+"");
	}
	protected void doSendCode(HttpServletRequest request, HttpServletResponse response,int type) throws ServletException, IOException {
		Message message=messageService.getMessage(type);
		System.out.println("===>"+type);
		System.out.println(message);
		HttpSession session=request.getSession();
		String mobile=message.getMtel();
		//官网的URL---必须是这个
        String url="http://gw.api.taobao.com/router/rest"; 
        //成为开发者，创建应用后系统会自动生成--前面图片中有说明
        String appkey=message.getMappkey(); 
      //创建应用后系统会自动生成--前面图片中有说明
        String secret=message.getMsecret();
        
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        //公共回传参数，在“消息返回”中会透传回该参数；
        //举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用

        req.setExtend(""); 
        //短信类型，传入值请填写normal
        req.setSmsType("normal");
        //签名名称
        req.setSmsFreeSignName("河北山叶 ");
        //短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。
        if (type==2) {
        	 String code="";
             
             Random r = new Random();
             for(int i=0;i<NUM;i++){
                 code = code+r.nextInt(10);
             }
             logger.info("手机号为:"+mobile+",验证码为:"+code);
             //将验证码加入容器中---用户输入验证码之后验证
             session.setAttribute("code", code);
             
             String json="{\"name\":\""+code+"\"}";
             req.setSmsParamString(json);
		}
       
        //短信接收号码
        req.setRecNum(mobile);
        //短信模板ID
        req.setSmsTemplateCode("SMS_16230528");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        boolean isScuess=false;
        try {
            rsp = client.execute(req);
            isScuess=true;
        } catch (ApiException e) {
            e.printStackTrace();
        }
        logger.debug(rsp.getBody());
        respOutStr(response, isScuess+"");
        
	}

}
