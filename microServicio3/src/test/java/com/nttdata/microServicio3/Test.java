package com.nttdata.microServicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Test {
	private List<String> listaUrls = new ArrayList<>();
	
	public Test() {}
	
	public Test(List<String> listaUrls) {
		super();
		this.listaUrls = listaUrls;
	}
	

	public List<String> getListaUrls() {
		return listaUrls;
	}


	public void setListaUrls(List<String> listaUrls) {
		this.listaUrls = listaUrls;
	}

	public void buscarUrls() throws IOException {
		List<String> listaCadenas = new ArrayList<>();
        String inputLine;
        String cadena= "";
        String subString, title, url, aux;
        int indexOf;
        boolean esEncontrado = false;
        boolean esComilla = false;

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
        int indexCount = 1;
        System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
        
        
        subString = cadena.substring(indexOf);
        int subCount = 1;
        System.out.println("subString " + " contador: " + subCount + " valor: " + subString);
        
        //INICIO DEL BUCLE GUARRO
        
        while(subString.length() > 0 && indexOf > 0) {
        	subString = subString.substring(1);
            indexOf = subString.indexOf('"');
            indexCount++;
            System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
            
            subString = subString.substring(0, subString.length());
            subCount++;
            System.out.println("subString " + " contador: " + subCount + " valor: " + subString);
            
            listaCadenas.add(subString.substring(0, indexOf));
            System.out.println("palabra archivada");
            
            subString = subString.substring(1);
            
            indexOf = subString.indexOf('"');
            indexCount++;
            System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
            
            subString = subString.substring(0, subString.length());
            subCount++;
            System.out.println("subString " + " contador: " + subCount + " valor: " + subString);
            
            listaCadenas.add(subString.substring(0, indexOf));
            System.out.println("palabra archivada");
            indexOf = subString.indexOf('"');
            indexCount++;
            System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
            
            ///tras guardar una palabra la descarto y comienzo desde el inicio + 1
            subString = subString.substring(indexOf + 1, subString.length());
            subCount++;
            System.out.println("subString " + " contador: " + subCount + " valor: " + subString);
           
            indexOf = subString.indexOf('"');
            indexCount++;
            System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
            
            if(indexOf > 0) {
	            subString = subString.substring(indexOf, subString.length());
	            subCount++;
	            System.out.println("subString " + " contador: " + subCount + " valor: " + subString);           	
            }       
        }
        for (String i : listaCadenas) {
			if(i.contains("http")) {
				listaUrls.add(i);
			}
		}
        
        System.out.println("Lista de Urls guardadas");
        listaUrls.stream().forEach(t -> System.out.println(t));
		

		
	}
	

	public static void main(String[] args) throws IOException {
		Test test = new Test();
		/*
		List<String> listaCadenas = new ArrayList<>();

        URL actuator = new URL("http://localhost:8083/actuator/");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(actuator.openStream()));

        String inputLine;
        String cadena= "";
        String subString, title, url, aux;
        int indexOf;
        boolean esEncontrado = false;
        boolean esComilla = false;

        while ((inputLine = in.readLine()) != null) {
        	cadena = inputLine;
        }
        in.close();
        
        System.out.println(cadena);

        
        indexOf = cadena.indexOf('"');
        int indexCount = 1;
        System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
        
        
        subString = cadena.substring(indexOf);
        int subCount = 1;
        System.out.println("subString " + " contador: " + subCount + " valor: " + subString);
        
        //INICIO DEL BUCLE GUARRO
        
        while(subString.length() > 0 && indexOf > 0) {
        	subString = subString.substring(1);
            indexOf = subString.indexOf('"');
            indexCount++;
            System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
            
            subString = subString.substring(0, subString.length());
            subCount++;
            System.out.println("subString " + " contador: " + subCount + " valor: " + subString);
            
            listaCadenas.add(subString.substring(0, indexOf));
            System.out.println("palabra archivada");
            
            subString = subString.substring(1);
            
            indexOf = subString.indexOf('"');
            indexCount++;
            System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
            
            subString = subString.substring(0, subString.length());
            subCount++;
            System.out.println("subString " + " contador: " + subCount + " valor: " + subString);
            
            listaCadenas.add(subString.substring(0, indexOf));
            System.out.println("palabra archivada");
            indexOf = subString.indexOf('"');
            indexCount++;
            System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
            
            ///tras guardar una palabra la descarto y comienzo desde el inicio + 1
            subString = subString.substring(indexOf + 1, subString.length());
            subCount++;
            System.out.println("subString " + " contador: " + subCount + " valor: " + subString);
           
            indexOf = subString.indexOf('"');
            indexCount++;
            System.out.println("IndexOf: " + " contador: " + indexCount + " valor: " + indexOf);
            
            if(indexOf > 0) {
	            subString = subString.substring(indexOf, subString.length());
	            subCount++;
	            System.out.println("subString " + " contador: " + subCount + " valor: " + subString);           	
            }         
        }
             
        for (String i : listaCadenas) {
			if(i.contains("http")) {
				listaUrls.add(i);
			}
		}
        
        System.out.println("Lista de Urls guardadas");
        listaUrls.stream().forEach(t -> System.out.println(t));
        */
	}
	
}
