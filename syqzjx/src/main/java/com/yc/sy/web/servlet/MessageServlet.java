package com.yc.sy.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.logging.log4j.LogManager;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.yc.sy.entity.Message;
import com.yc.sy.service.MessageService;




@WebServlet("/message/*")
public class MessageServlet extends BaseServlet {

	private static final long serialVersionUID = -7819688575849833542L;
	private int NUM=6;
	private MessageService messageService;
	public MessageServlet() {
		messageService=(MessageService) cxt.getBean("messageService");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUriStr = request.getRequestURI();
		LogManager.getLogger().debug("请求FavoriteServlet处理" + reqUriStr + "的请求资源....");
		if (reqUriStr.endsWith("phoneCode")) {//验证码
			doPhoneCode(request,response);
		}else if(reqUriStr.endsWith("inform")) {//短信通知
			doInform(request,response);
		}else if(reqUriStr.endsWith("list")) {//短信模板列表
			doList(request,response);
		}else if(reqUriStr.endsWith("remove")) {//删除
			doRemove(request,response);
		}else if(reqUriStr.endsWith("modify")) {//删除
			doModify(request,response);
		}
	}

	private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Message message=getReqParam2Obj(request, Message.class);
		System.out.println("===>"+message);
		boolean isSucess=messageService.doMoidfy(message);
		respOutStr(response, isSucess+"");
		
	}
	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer mid=Integer.parseInt(request.getParameter("mid").toString());
		boolean isSucess=messageService.RemoveMes(mid);
		respOutStr(response, isSucess+"");
		
	}
	private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Message> messages=messageService.list();
		System.out.println(messages);
		respOutStr(response, toJsonStr(messages));
		
	}
	private void doInform(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Message message=messageService.getMessage(1);
		System.out.println("lyyy++"+message);
		// 官网的URL---必须是这个
		String url = "http://gw.api.taobao.com/router/rest";

		// 成为开发者，创建应用后系统会自动生成--前面图片中有说明
		String appkey = message.getMappkey();

		// 创建应用后系统会自动生成--前面图片中有说明
		String secret = message.getMsecret();
		//需要通知的电话号码
		String utel =message.getMtel();
		 TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			// 公共回传参数，在“消息返回”中会透传回该参数；
			// 举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用

			req.setExtend("");
			// 短信类型，传入值请填写normal
			req.setSmsType("normal");

			// 签名名称
			req.setSmsFreeSignName(message.getMsignname());
				

			
			// 短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。
			// 短信接收号码
			req.setRecNum(utel);

			// 短信模板ID    (验证码)模版
			req.setSmsTemplateCode(message.getMtemplateCode()); 
			AlibabaAliqinFcSmsNumSendResponse rsp = null;
			boolean issuccess=false;
			try {
				rsp = client.execute(req);
				issuccess = true;
			} catch (ApiException e) {
				e.printStackTrace();
			}
			respOutStr(response, issuccess+"");
	}

	private void doPhoneCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Message message=messageService.getMessage(2);
		HttpSession session=request.getSession();
		// 官网的URL---必须是这个
		String url = "http://gw.api.taobao.com/router/rest";

		// 成为开发者，创建应用后系统会自动生成--前面图片中有说明
		String appkey = message.getMappkey();

		// 创建应用后系统会自动生成--前面图片中有说明
		String secret = message.getMsecret();
		
		String utel = request.getParameter("utel");
		String code="";
		 Random r = new Random();
         for(int i=0;i<NUM;i++){
             code = code+r.nextInt(10);
         }
         LogManager.getLogger().debug("手机号为:"+utel+",验证码为:"+code);
         //将验证码加入容器中---用户输入验证码之后验证
         session.setAttribute("code", code);
		
		 LogManager.getLogger().debug("手机号为:" + utel + ",验证码为:" + code);
		 
		 TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			// 公共回传参数，在“消息返回”中会透传回该参数；
			// 举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用

			req.setExtend("");
			// 短信类型，传入值请填写normal
			req.setSmsType("normal");

			// 签名名称
			req.setSmsFreeSignName(message.getMsignname());

			// 短信模板的内容
//			String json = "{\"测试\":\"" + code + "\"}";
			String json="{\"code\":\""+code+"\"}";

			
			// 短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。
			req.setSmsParamString(json);

			// 短信接收号码
			req.setRecNum(utel);

			// 短信模板ID    (验证码)模版
			req.setSmsTemplateCode(message.getMtemplateCode()); 
			AlibabaAliqinFcSmsNumSendResponse rsp = null;
			boolean issuccess=false;
			try {
				rsp = client.execute(req);
				issuccess = true;
			} catch (ApiException e) {
				e.printStackTrace();
			}
			respOutStr(response, issuccess+"");
	}

}
