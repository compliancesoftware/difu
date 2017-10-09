package br.com.compliancesoftware.difu.nlp;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import br.com.compliancesoftware.difu.utils.Logger;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

/**
 * tratador de linguagem natural
 * @author douglas.f.filho
 *
 */
public class NLP {
	
	public static ArrayList<String> processa(String texto, Context context) {
		try { 
			ArrayList<String> respostas = new ArrayList<String>();
			
			//Loading sentence detector model 
			InputStream inputStream = NLP.class.getClassLoader().getResourceAsStream("nlp_models/pt-sent.bin"); 
			SentenceModel model = new SentenceModel(inputStream);
			
			//Instantiating the SentenceDetectorME class 
			SentenceDetectorME detector = new SentenceDetectorME(model);
			
			//Detecting the sentence 
			String sentences[] = detector.sentDetect(texto);
			
			for(String sentence : sentences) {
				respostas = buildContext(sentence, context);
			}
			
			return respostas;
		} catch(Exception e) {
			Logger.info(NLP.class.getCanonicalName(), "processa", "Erro ao tentar acessar arquivo.");
			e.printStackTrace();
			return null;
		}
	}
	
	private static String[] buildContext(String sentence, Context context) {
		
	}
	
	public static void main(String[] args) {
		String[] respostas = (String[])processa("Olá! Tudo bem?", new Context()).toArray();
		for(String resposta : respostas) {
			System.out.println(resposta);
		}
	}
	
}