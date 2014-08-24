package Impresiones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Conversores.NumberToLetterConverter;
import Conversores.Numeros;
import interfaces.Adeudable;
import interfaces.Generable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.imageio.ImageIO;
import objetos.Articulos;
import objetos.ClientesTango;
import objetos.Comprobantes;
import objetos.Cuotas;
import objetos.Planes;


/**
 *
 * @author hernan
 */
public class Impresora {

    Font fuente = new Font("Arial", Font.PLAIN, 9);
    Font fuente1=new Font("Arial",Font.BOLD,16);
    Font fuente3 = new Font("Arial", Font.PLAIN, 7);
    Font fuente4 = new Font("Arial", Font.BOLD,7);
    Font fuente5=new Font("Arial",Font.PLAIN,16);
    Font fuente6 = new Font("Arial", Font.BOLD, 9);
	PrintJob pj;	
	Graphics pagina;
	

	/********************************************************************
	*	A continuación el constructor de la clase. Aquí lo único que	*
	*	hago es tomar un objeto de impresion.							*
	********************************************************************/
	public Impresora()
	{
		pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
               
	}
			
	/********************************************************************
	*	A continuación el método "imprimir(String)", el encargado de 	*
	*	colocar en el objeto gráfico la cadena que se le pasa como 		*
	*	parámetro y se imprime.											*
	********************************************************************/
    public void imprimir(ArrayList listado,Integer tipoComprobante) throws SQLException, IOException	{
		//LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
            
		//try
	//	{
			pagina = pj.getGraphics();
                        //pagina=pj.jobAttributes;
			pagina.setFont(fuente);
			pagina.setColor(Color.black);
                        DecimalFormat fr=new DecimalFormat("#####.##");
                        int a=0;
                        int renglon=10;
                        int columna=150;
                        int columna1=20;
                        int renglonImagen=10;
                        //String condicionDeVenta=null;
                        
                        switch (tipoComprobante){
                            case 1:
                                //RECIBOS  
                                //for(int aa=0;aa < 3;aa++){
                                Generable genera=new Cuotas();
                                Cuotas cuota=new Cuotas();
                                Planes plan=new Planes();
                                Generable gen=new Planes();
                                Adeudable adeu=new ClientesTango();
                                ClientesTango cliente=new ClientesTango();
                                //Image imagen1=.getImage("C://Gestion//imagen//encabezado.jpg");
                                BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//encabezado.jpg"));
                                //imagen.getGraphics () ;
                                //Graphics g = pj.getGraphics (); 
                                //g.drawImage (imagen, 0, 0,798, 497, Color.white, null); 
                                //g.dispose (); 
                                Iterator il=listado.listIterator();
                                int b=0;
                                //int ba=0;
                                while(il.hasNext()){
                                    a++;
                                    b++;
                                    
                                    cliente=(ClientesTango)il.next();
                                    
                                    //encabezado
                                    //renglon=20;
                                    //columna=90;
                                    if(b==9){
                                        //b=1;
                                        pagina.dispose();
                                        pagina = pj.getGraphics();
                        //pagina=pj.jobAttributes;
			pagina.setFont(fuente);
			pagina.setColor(Color.black);
                        //DecimalFormat fr=new DecimalFormat("#####.##");
                                        b=1;
                                        renglon=10;
                                        columna=150;
                                        columna1=20;
                                        renglonImagen=10;
                                        
                                    }
                                    if(a==1){
                                        //pagina.drawImage(imagen,columna1,renglonImagen,null);

                                        //Graphics g = pj.getGraphics (); 
                                        //g.drawImage (imagen, 0, 0,798, 497, Color.white, null);
                                        //pagina=g;
                                        pagina.drawImage(imagen,10,renglon,280,195, null);

                                        /*
                                        pagina.drawString("San Martin 2819 P.A. Of. 1",columna,renglon);
                                        renglon=renglon + 10;
                                        pagina.drawString("Tel: 0342-4532651",columna,renglon);
                                        renglon=renglon + 10;
                                        pagina.drawString("E-mail: aseavyt@gigared.com",columna,renglon);
                                        renglon=renglon + 10;
                                        pagina.setFont(fuente3);
                                        pagina.drawString("CUIT.:30-61200162-2",columna,renglon);
                                        pagina.setFont(fuente1);
                                        */
                                        renglon=renglon + 105;
                                        //cuerpo

                                        pagina.drawString(cliente.getRazonSocial(),columna1,renglon);
                                        renglon=renglon + 12;
                                        pagina.drawString(cliente.getDireccion(),columna1,renglon);
                                        renglon=renglon + 12;
                                        pagina.drawString("SANTA FE",columna1,renglon);
                                        // pie
                                        renglon=renglon + 20;
                                        pagina.setFont(fuente);
                                        //pagina.drawString("IMPORTE",columna1,renglon);
                                        //pagina.drawString("SOCIO",columna1 + 80,renglon);
                                        //pagina.drawString("FECHA",columna1 + 140,renglon);
                                        renglon=renglon + 15;
                                        pagina.setFont(fuente4);
                                        cuota=(Cuotas)genera.Cargar(1);
                                        plan=(Planes)gen.Cargar(cliente.getListaDePrecios());
                                        pagina.drawString("$"+plan.getMonto1()+" hasta "+cuota.getVencimiento1(),columna1 -5,renglon);
                                        renglon=renglon + 10;
                                        pagina.drawString("$"+plan.getMonto2()+" hasta "+cuota.getVencimiento2(),columna1 -5,renglon);
                                        pagina.drawString(String.valueOf(cliente.getCodigoId()),columna1 + 95,renglon);
                                        pagina.drawString(cuota.getPeriodo(),columna1 + 150,renglon);
                                        pagina.setFont(fuente);
                                        //pagina.drawImage(imagen,columna1,renglonImagen,null);
                                        System.out.println("renglon tiene que estar en 10 esta en "+renglon);
                                        renglon=renglon - 169;
                                        //renglonImagen=renglon - 10;
                                        System.out.println("puntos "+columna+" "+columna1+" "+renglon+" "+renglonImagen+" "+a);
                                    }else{
                                        columna=columna +290;
                                        columna1=columna1 + 290;
                                        
                                        pagina.drawImage(imagen,300,renglonImagen,280,195, null);
                                        //pagina.drawImage(imagen,columna1,renglon, null);
                                          /*  
                                        pagina.drawString("San Martin 2819 P.A. Of. 1",columna,renglon);
                                        renglon=renglon + 10;
                                        pagina.drawString("Tel: 0342-4532651",columna,renglon);
                                        renglon=renglon + 10;
                                        pagina.drawString("E-mail: aseavyt@gigared.com",columna,renglon);
                                        renglon=renglon + 10;
                                        pagina.setFont(fuente3);
                                        pagina.drawString("CUIT.:30-61200162-2",columna,renglon);
                                        pagina.setFont(fuente1);
                                            */
                                        renglon=renglon + 105;
                                        //cuerpo

                                        pagina.drawString(cliente.getRazonSocial(),columna1,renglon);
                                        renglon=renglon + 12;
                                        pagina.drawString(cliente.getDireccion(),columna1,renglon);
                                        renglon=renglon + 12;
                                        pagina.drawString(cliente.getLocalidad(),columna1,renglon);
                                        // pie
                                        renglon=renglon + 20;
                                        //pagina.setFont(fuente);
                                        //pagina.drawString("IMPORTE",columna1,renglon);
                                        //pagina.drawString("SOCIO",columna1 + 80,renglon);
                                        //pagina.drawString("FECHA",columna1 + 140,renglon);
                                        renglon=renglon + 15;
                                        pagina.setFont(fuente4);
                                        cuota=(Cuotas)genera.Cargar(1);
                                        plan=(Planes)gen.Cargar(cliente.getListaDePrecios());
                                        pagina.drawString("$"+plan.getMonto1()+" hasta "+cuota.getVencimiento1(),columna1 -5,renglon);
                                        renglon=renglon + 10;
                                        pagina.drawString("$"+plan.getMonto2()+" hasta "+cuota.getVencimiento2(),columna1 -5,renglon);
                                        pagina.drawString(String.valueOf(cliente.getCodigoId()),columna1 + 95,renglon);
                                        pagina.drawString(cuota.getPeriodo(),columna1 + 150,renglon);
                                        pagina.setFont(fuente);
                                        System.out.println("renglon tiene que estar en 10 esta en "+renglon);
                                        renglon=renglon + 10;
                                        renglonImagen=renglon;
                                        a=0;
                                        columna=columna -290;
                                        columna1=columna1 - 290;
                                        System.out.println("puntos "+columna+" "+columna1+" "+renglon+" "+renglonImagen+" "+a);
                                    }
                                    //adeu.PagarComprobante(cliente);
                                }
                               //pagina.drawString("Fecha :",470,87);
                               //pagina.drawString("ES UNA PRUEBA ", 45,163);
                               
                               //cuerpo
                               
                               
                               //pie
                               
                               
                               
                               /*
                                pagina.drawString(comp.getFechaComprobante(), 470, 87);
                                pagina.drawString(comp.getCliente().getCodigoCliente()+" "+comp.getCliente().getRazonSocial(), 45, 163);
                                pagina.drawString(comp.getCliente().getDireccion(), 45, 173);
                                pagina.drawString("- 3000", 183, 173);
                                pagina.drawString(comp.getCliente().getLocalidad(),233, 173);
                                pagina.drawString("COND DE VENTA :",370, 173);
                                pagina.drawString("IVA RESPONSABLE INSCRIPTO",45, 183);
                                pagina.drawString(comp.getCliente().getTelefono(),183, 183);
                                pagina.drawString("CUIT: "+comp.getCliente().getNumeroDeCuit(),370, 183);


                                pagina.drawString("Cod. Art", 45, 213);
                                pagina.drawString("Descripcion", 85, 213);
                                pagina.drawString("Und", 273, 213);
                                pagina.drawString("Cant", 293, 213);
                                pagina.drawString("Eq.", 363, 213);
                                pagina.drawString("Prec. Unit", 403,213);
                                pagina.drawString("Importe", 490, 213);
                                    //DETALLE DE ARTICULOS DE LA FACTURA
                                    a=213;
                                    for(int i=0;i< comp.getArticulos().size();i++){
                                        a=a+10;
                                        art=(Articulos)comp.getArticulos().get(i);
                                        pagina.drawString(art.getCodigo(), 45, a);
                                        pagina.drawString(art.getDescripcionArticulo(), 85, a);
                                        pagina.drawString(art.getUnidadDeMedida(), 270, a);
                                        pagina.drawString(fr.format(art.getCantidad()), 290,a);
                                        pagina.drawString(fr.format(art.getPesoUnitario()),360, a);
                                         Double tota=art.getPrecioUnitario() / art.getCantidad();
                                        pagina.drawString(fr.format(tota),400, a);
                                        pagina.drawString(fr.format(art.getPrecioUnitario()),490, a);

                                    }
                                    pagina.drawString("________________________________", 270,563);
                                    pagina.drawString("CONFORMIDAD DEL CLIENTE PARA PROCESAR ",260,577);
                                    //OBSERVACIONES
                                    pagina.drawString("LEYENDA 1",45,563);
                                    pagina.drawString("LEYENDA 2", 45, 573);
                                    pagina.drawString("LEYENDA 3",45,583);


                                    // SON PESOS:
                                    pagina.drawString("SON PESOS :",45,603);
                                    pagina.drawString("VENDEDOR :"+comp.getVendedor(), 45, 613);
                                    pagina.drawString("DTO : 0.00",125, 613);
                                    pagina.drawString("LP :"+comp.getCliente().getCondicionDePago(),195, 613);
                                    //TOTALES BRUTO - IVA - NETO
                                     bruto=comp.getMontoTotal() / 1.21;
                                    iv=comp.getMontoTotal() - bruto;
                                    neto=comp.getMontoTotal();
                                    pagina.drawString("21%",423,765);
                                    pagina.drawString(fr.format(bruto),45,775);
                                    pagina.drawString(fr.format(bruto),125,775);
                                    pagina.drawString(fr.format(bruto),225,775);
                                    pagina.drawString(fr.format(iv),423, 775);
                                    pagina.drawString(fr.format(neto),510,775);
                                   comp.guardarPedido(comp);
                                   */
                                break;
                                
                                
                        }
                        

			pagina.dispose();
			pj.end();
                        
		//}catch(Exception e)
		//{
		//	System.out.println("LA IMPRESION HA SIDO CANCELADA..."+e);
		//}
	}//FIN DEL PROCEDIMIENTO imprimir(String...)
    public void ImprimirFactura(Comprobantes comp){
        Comprobantes comprobante=new Comprobantes();
        comprobante=comp;
        DecimalFormat fd=new DecimalFormat("00");
        Calendar c1=Calendar.getInstance();
	Calendar c2=new GregorianCalendar();
	String dia=Integer.toString(c2.get(Calendar.DAY_OF_MONTH));
	String mes=Integer.toString(c2.get(Calendar.MONTH));
	String ano=Integer.toString(c2.get(Calendar.YEAR));
	String yy=ano.substring(2);
        int mess=Integer.parseInt(mes);
        mess++;
        mes=String.valueOf(mess);
        pagina = pj.getGraphics();
                        //pagina=pj.jobAttributes;
			pagina.setFont(fuente);
			pagina.setColor(Color.black);
                        DecimalFormat fr=new DecimalFormat("#####.##");
                        //fecha
                        pagina.drawString(dia, 327,86);
                        pagina.drawString(mes,363,86);
                        pagina.drawString(yy,387,86);
                        // 1 er renglon
                        pagina.drawString(comprobante.getCliente().getRazonSocial(),140,148);
                        //2 do renglon
                        pagina.drawString(comprobante.getCliente().getDireccion(), 135,163);
                        pagina.drawString("SANTA FE",327,163);
                        // 3 er renglon
                        pagina.drawString("SANTA FE", 100,185);
                        pagina.drawString(comprobante.getCliente().getTelefono(),180,185);
                        pagina.drawString(comprobante.getCliente().getNumeroDeCuit(), 330,185);
                        
                        //situacion iva
                        int condicion=Integer.parseInt(comprobante.getCliente().getCondicionIva());
                        switch (condicion){
                            case 0:
                                pagina.drawString("X",78,206);
                                break;
                            case 1:
                                pagina.drawString("X",163,206);
                                break;
                            case 2:
                                pagina.drawString("X", 250,206);
                                break;
                            case 3:
                                pagina.drawString("X", 337,206);
                                break;
                            case 4:
                                pagina.drawString("X",78,226);
                                break;
                            case 5:
                                pagina.drawString("X",163,226);
                                break;
                            case 6:
                                pagina.drawString("X",250,226);
                                break;
                            case 7:
                                pagina.drawString("X",337,226);
                                break;
                                
                        }
                        //articulos
                        Iterator itA=comprobante.getListadoDeArticulos().listIterator();
                        Articulos articulo=new Articulos();
                        Integer renglonI=416;
                        while(itA.hasNext()){
                            articulo=(Articulos)itA.next();
                            pagina.drawString(articulo.getDescripcionArticulo(),60,renglonI);
                            pagina.drawString(String.valueOf(articulo.getPrecioUnitarioNeto()),380,renglonI);
                            renglonI=renglonI + 15;
                        }
                        pagina.drawString(String.valueOf(comprobante.getMontoTotal()), 383,523);
        pagina.dispose();
        pj.end();
    }
    public void ImprimirRecibos(Comprobantes comp) throws IOException{
        Comprobantes comprobante=new Comprobantes();
        //BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//encabezado.jpg"));
        comprobante=comp;
        int nnum=comprobante.getNumero();
        DecimalFormat fd=new DecimalFormat("00");
        Calendar c1=Calendar.getInstance();
	Calendar c2=new GregorianCalendar();
	String dia=Integer.toString(c2.get(Calendar.DAY_OF_MONTH));
	String mes=Integer.toString(c2.get(Calendar.MONTH));
	String ano=Integer.toString(c2.get(Calendar.YEAR));
	String yy=ano.substring(2);
        int mess=Integer.parseInt(mes);
        mess++;
        switch (mess){
            case 1:
                mes="ENERO";
                break;
            case 2:
                mes="FEBRERO";
                break;
            case 3:
                mes="MARZO";
                break;
            case 4:
                mes="ABRIL";
                break;
            case 5:
                mes="MAYO";
                break;
                case 6:
                mes="JUNIO";
                break;
                case 7:
                    mes="JULIO";
                    break;
                case 8:
                    mes="AGOSTO";
                    break;
                case 9:
                    mes="SETIEMBRE";
                    break;
                case 10:
                    mes="OCTUBRE";
                    break;
                case 11:
                    mes="NOVIEMBRE";
                    break;
                case 12:
                    mes="DICIEMBRE";
                    break;
                    
                
        }
        //mes=String.valueOf(mess);
        String mont=String.valueOf(comprobante.getMontoTotal());
        int posi=mont.indexOf(".");
        String numAConv=mont.substring(0,posi);
        posi++;
        String decimales=mont.substring(posi);
        pagina = pj.getGraphics();
        BufferedImage imagen= ImageIO.read(new File("C://Gestion//imagen//aseavyt-logo.jpg"));
                        //pagina=pj.jobAttributes;
			pagina.setFont(fuente1);
			pagina.setColor(Color.black);
                        DecimalFormat fr=new DecimalFormat("#####.##");
        
                        pagina.drawImage(imagen,15,10,370,50,null);
                        pagina.drawString("RECIBO",410,30);
                        //pagina.setFont(fuente);
                        imagen= ImageIO.read(new File("C://Gestion//imagen//fondoRec.jpg"));
                        pagina.drawImage(imagen,250,120,160,70,null);
                        Double num=Numeros.ConvertirStringADouble(numAConv);
                        pagina.setFont(fuente5);
                        pagina.drawString("N° "+nnum,410,50);
                        pagina.setFont(fuente3);
                        pagina.drawString("PERSONERÍA JURÍDICA 12815",220 ,60);
                        pagina.drawString("San Martin 2819 - Pta Alta - Oficina 1 - Tel/Fax: (0342) 4532651 - (S3000FSI) Santa Fe", 105,70);
                        pagina.drawString("E-mail: secretaria@aseavyt.org.ar - Web:www.aseavyt.org.ar",150,80);
        //Double num=Numeros.ConvertirStringADouble(numAConv);
        pagina.setFont(fuente);
        
        pagina.drawString("Santa Fe :"+dia+" de "+mes+" de "+ano,310,100);
        //pagina.drawLine(70, 110, 200, 110);
        pagina.drawString("Recibí de "+comprobante.getCliente().getRazonSocial(),15,110);
        //pagina.drawLine(140, 130, 400, 130);
        pagina.drawString("La cantidad de Pesos "+NumberToLetterConverter.convertNumberToLetter(num)+" con / "+decimales, 15,130);
        pagina.drawLine(90, 150, 440, 150);
        pagina.drawString("en concepto de ",15,150);
        pagina.drawLine(15, 170, 440, 170);
        pagina.drawLine(15, 180, 100, 180);
        pagina.setFont(fuente6);
        pagina.drawString("Son $ "+mont,15,190);
        pagina.setFont(fuente3);
        pagina.drawLine(15, 200, 100, 200);
        pagina.drawLine(250, 200, 440, 200);
        pagina.drawString("por ASEAVYT", 330, 210);
        pagina.dispose();
        pj.end();
    }
					
}//FIN DE LA CLASE Impresora

 

