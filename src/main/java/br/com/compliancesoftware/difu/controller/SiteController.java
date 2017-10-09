package br.com.compliancesoftware.difu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.compliancesoftware.difu.nlp.NLP;

@Controller
public class SiteController {
	
	@RequestMapping(value = {"/","home"})
	public String home(HttpSession session){
		String[] mensagens = new String[]{"Olá!","Em que posso te ajudar?"};
		session.setAttribute("mensagens", mensagens);
		
		return "index";
	}
	
	@RequestMapping("getmessage")
	public void getMessage(HttpSession session, HttpServletResponse response) {
		String result = "{\"status\":\"{status}\",\"messages\":[messages]}";
		
		String[] mensagens = (String[])session.getAttribute("mensagens");
		
		if(mensagens != null && mensagens.length > 0) {
			String modelMessages = "";
			
			for(String mensagem : mensagens) {
				modelMessages += "\"" + mensagem + "\",";
			}
			
			modelMessages = modelMessages.substring(0, modelMessages.length() - 1);
			modelMessages = "[" + modelMessages + "]";
			
			result = result.replace("[messages]", modelMessages);
			result = result.replace("{status}", "true");
		}
		else{
			result = result.replace("[messages]", "[]");
			result = result.replace("{status}", "false");
		}
		
		session.removeAttribute("mensagens");
		
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(result);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("sendmessage")
	public void sendMessage(String message, HttpSession session, HttpServletResponse response) {
		String result = "{\"status\":\"true\",\"messages\":[\"Mensagem recebida\"]}";
		
		trataMensagem(message, session);
		
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append(result);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void trataMensagem(String mensagem, HttpSession session) {
		String[] respostas = NLP.processa(mensagem);
		session.setAttribute("mensagens", respostas);
	}
	
}
