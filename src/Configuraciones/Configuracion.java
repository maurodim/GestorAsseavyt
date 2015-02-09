/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuraciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author mauro di
 */
public class Configuracion {
    private Integer estado;

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Configuracion() throws MalformedURLException, IOException, ParserConfigurationException, SAXException {
        String arc="configAseavyt.xml";
        URL url=new URL("http://www.bambusoft.com.ar/xml/configAseavyt.xml");
        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
        String entrada;
        String cadena="";
        ArrayList listadoConecciones=new ArrayList();
        while((entrada=br.readLine())!=null){
            cadena =cadena + entrada;
        }
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        InputSource archivo=new InputSource();
        archivo.setCharacterStream(new StringReader(cadena));
        Document documento=db.parse(archivo);
        documento.getDocumentElement().normalize();
        org.w3c.dom.NodeList nodeLista=documento.getElementsByTagName("coneccion");
        int cantidad=nodeLista.getLength();
        System.out.println("Informacion de conecciones");
        
        for (int s = 0; s < cantidad; s++) {
            
	Node primerNodo = nodeLista.item(s);
	String titulo;
	String autor;
	String hits;
        System.err.println("numero nodo "+s);
        
	if (primerNodo.getNodeType() == Node.ELEMENT_NODE) {

	Element primerElemento = (Element) primerNodo;
        

	        org.w3c.dom.NodeList primerNombreElementoLista =primerElemento.getElementsByTagName("estado");
	Element primerNombreElemento =(Element) primerNombreElementoLista.item(0);
	        org.w3c.dom.NodeList primerNombre = primerNombreElemento.getChildNodes();
            String nombreConeccion = ((Node) primerNombre.item(0)).getNodeValue().toString();
            int est=Integer.parseInt(nombreConeccion);
	System.out.println("NOMBRE : "  + nombreConeccion);
        estado=est;
        
	}
        }
     
    }
    
    
}
