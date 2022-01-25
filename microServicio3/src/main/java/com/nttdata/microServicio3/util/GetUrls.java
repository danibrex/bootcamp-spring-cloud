package com.nttdata.microServicio3.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class GetUrls {
private static List<String> listaUrls = new ArrayList<>();
	
	public GetUrls() {}
	
	public GetUrls(List<String> listaUrls) {
		super();
		this.listaUrls = listaUrls;
	}
	

	public List<String> getListaUrls() {
		return listaUrls;
	}


	public void setListaUrls(List<String> listaUrls) {
		this.listaUrls = listaUrls;
	}

	public static List<String> buscarUrls() throws IOException {
		List<String> listaCadenas = new ArrayList<>();
        String inputLine;
        String cadena= "";
        String subString;
        int indexOf;

        URL actuator;
		try {
			actuator = new URL("http://localhost:8083/actuator/");
			BufferedReader in = new BufferedReader(
			new InputStreamReader(actuator.openStream()));
	        while ((inputLine = in.readLine()) != null) {
	        	cadena = inputLine;
	        }
	        in.close();
			
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		
		indexOf = cadena.indexOf('"');
        subString = cadena.substring(indexOf);
        
        //INICIO DEL BUCLE GUARRO        
        while(subString.length() > 0 && indexOf > 0) {
        	subString = subString.substring(1);
            indexOf = subString.indexOf('"');
            subString = subString.substring(0, subString.length());
            listaCadenas.add(subString.substring(0, indexOf));
            subString = subString.substring(1);
            indexOf = subString.indexOf('"');
            subString = subString.substring(0, subString.length());
            listaCadenas.add(subString.substring(0, indexOf));
            indexOf = subString.indexOf('"');    
            ///tras guardar una palabra la descarto y comienzo desde el inicio + 1
            subString = subString.substring(indexOf + 1, subString.length());
            indexOf = subString.indexOf('"');
            if(indexOf > 0) {
	            subString = subString.substring(indexOf, subString.length());         	
            }       
        }
        
        for (String i : listaCadenas) {
			if(i.contains("http")) {
				listaUrls.add(i);
			}
		}
        return listaUrls;

	}

}

