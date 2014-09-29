/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import interfaces.Transaccionable;
import interfacesGraficas.Inicio;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.ConeccionLocal;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 *
 * @author mauro di
 */
public class InformesClientes {
   public void InfomeCtaCte(Integer id) throws SQLException {
              HSSFWorkbook libro=new HSSFWorkbook();
        //HSSFSheet hoja=libro.createSheet("Resumen");
        /*
         * GENERAR LAS SIGUIENTES HOJAS
         * 1- DETALLE DE MOVIMIENTOS DE CAJA - LEE EN MOVIMIENTOS CAJA INDENTIFICANDO EL TIPO DE MOVIMIENTO, USUARIOS Y 
         * NUMERO DE CAJA
         * 2- DETALLE DE ARTICULOS VENDIDOS: LISTADO DE MOVIEMIENTOS DE ARTICULOS, CON USUARIOS Y CAJA
         * 3- DETALLE DE GASTOS : MOVIMIENTOS DE CAJA DETALLANDO LOS GASTOS
         * 
         */
        HSSFSheet hoja1=libro.createSheet("Movimientos");
        //HSSFSheet hoja2=libro.createSheet("Articulos");
        HSSFSheet hoja3=libro.createSheet("Hoja 2");
        String ttx="celda numero :";
        HSSFRow fila=null;
        HSSFCell celda;
        HSSFCell celda1;
        HSSFCell celda2;
        HSSFCell celda3;
        HSSFCell celda4;
        HSSFCell celda5;
        HSSFCell celda6;
        HSSFCell celda7;
        HSSFCell celda8;
        HSSFFont fuente=libro.createFont();
        //fuente.setFontHeight((short)21);
        fuente.setFontName(fuente.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        String form=null;
        /*
        String sql="select *,(select movimientoscaja.monto from movimientoscaja where movimientoscaja.tipoMovimiento=10 and movimientoscaja.idCaja=informemensualdecaja.numero and movimientoscaja.monto < 0)as cierre from informemensualdecaja where idcaja="+idCaja;
        System.out.println(sql);
        Transaccionable tra=new ConeccionLocal();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        */
        Transaccionable tra=new ConeccionLocal();
        String sql="";
        ResultSet rs=null;
        HSSFCellStyle titulo=libro.createCellStyle();
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //for(int a=0;a < 100;a++){
        int col=0;
        int a=0;
         
            
            /*
             * HOJA 1
             */
 
        form=null;
        if(id > 0){
        sql="select movimientosclientes.numeroproveedor,movimientosclientes.monto,movimientosclientes.fecha,(select listcli.razon_soci from listcli where listcli.codmmd=movimientosclientes.numeroproveedor)as nombreU,movimientosclientes.numerocomprobante,movimientosclientes.tipocomprobante,movimientosclientes.idcuota,(select tipocomprobantes.descripcion from tipocomprobantes where tipocomprobantes.numero=movimientosclientes.tipocomprobante)as descComp,(select cuotas.periodo from cuotas where cuotas.id=movimientosclientes.idcuota)as periodo from movimientosclientes where numeroProveedor="+id;
        }else{
            sql="select movimientosclientes.numeroproveedor,movimientosclientes.monto,movimientosclientes.fecha,(select listcli.razon_soci from listcli where listcli.codmmd=movimientosclientes.numeroproveedor)as nombreU,movimientosclientes.numerocomprobante,movimientosclientes.tipocomprobante,movimientosclientes.idcuota,(select tipocomprobantes.descripcion from tipocomprobantes where tipocomprobantes.numero=movimientosclientes.tipocomprobante)as descComp,(select cuotas.periodo from cuotas where cuotas.id=movimientosclientes.idcuota)as periodo from movimientosclientes order by numeroProveedor";
        }
        System.out.println(sql);
        //tra=new Conecciones();
        rs=tra.leerConjuntoDeRegistros(sql);
        //HSSFCellStyle titulo=libro.createCellStyle();
        titulo.setFont(fuente);
        //titulo.setFillBackgroundColor((short)22);
        titulo.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        titulo.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        //for(int a=0;a < 100;a++){
        col=0;
        a=0;
            if(a==0){
                fila=hoja1.createRow(a);
            celda=fila.createCell(0);
            celda.setCellStyle(titulo);
            celda.setCellValue("Cliente");
            celda1=fila.createCell(1);
            celda1.setCellStyle(titulo);
            celda1.setCellValue("N Comprobante");
            celda2=fila.createCell(2);
            celda2.setCellStyle(titulo);
            celda2.setCellValue("Monto");
            celda3=fila.createCell(3);
            celda3.setCellStyle(titulo);
            celda3.setCellValue("Movimiento");
            celda4=fila.createCell(4);
            celda4.setCellStyle(titulo);
            celda4.setCellValue("Periodo");
            celda5=fila.createCell(5);
            celda5.setCellStyle(titulo);
            celda5.setCellValue("Fecha");
            //celda8=fila.createCell(8);
            //celda8.setCellStyle(titulo);
            //celda8.setCellValue("Dejo en Caja");
            
            
            }
            while(rs.next()){
            a++;
            //col=rs.getInt("tipoMovimiento");
            switch(col){
                case 1:
                    
                    break;
                default:
                    
                    break;
            }
            fila=hoja1.createRow(a);
            celda=fila.createCell(0);
            ttx=ttx;
            celda.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda.setCellValue(rs.getString("nombreU"));
            celda1=fila.createCell(1);
            ttx=ttx;
            celda1.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda1.setCellValue(rs.getInt("numerocomprobante"));
            celda2=fila.createCell(2);
            celda2.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda2.setCellValue(rs.getDouble("monto"));
            celda3=fila.createCell(3);
            celda3.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda3.setCellValue(rs.getString("descComp"));
            celda4=fila.createCell(4);
            celda4.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda4.setCellValue(rs.getString("periodo"));
            
           
            celda5=fila.createCell(5);
            //celda5.setCellFormula(rs.getString("observaciones"));
            celda5.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda5.setCellValue(" "+rs.getDate("fecha"));
            //celda5.setCellValue(rs.getDate("fecha"));
            celda6=fila.createCell(6);
            celda6.setCellType(HSSFCell.CELL_TYPE_STRING);
            celda6.setCellValue("");
            /*
            celda7=fila.createCell(7);
            celda7.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
            celda7.setCellValue();
            
            
            
            if(a > 1){
            form="B"+a+"+C"+a+"+D"+a+"+E"+a+"+G"+a+"+H"+a;
            celda8=fila.createCell(8);
            celda8.setCellType(HSSFCell.CELL_TYPE_FORMULA);
            celda8.setCellFormula(form);
            }
            */
            
        }
             
            /*
             * HOJA 3
             */
        
            
            
        rs.close();
        //texto+="\r\n";
        String ruta="C://Informes//"+Inicio.fechaDia+" _ "+id+"_informectactes.xls";
        try {
            FileOutputStream elFichero=new FileOutputStream(ruta);
            try {
                libro.write(elFichero);
                elFichero.close();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+ruta);
            } catch (IOException ex) {
                Logger.getLogger(InformeMensual.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformeMensual.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
