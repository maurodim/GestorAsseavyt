/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

import Conversores.Numeros;
import interfaces.Generable;
import interfaces.Transaccionable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cuotas implements Generable{
   private Integer id;
   private String vencimiento1;
   private String vencimiento2;
   private String periodo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVencimiento1() {
        return vencimiento1;
    }

    public void setVencimiento1(String vencimiento1) {
        this.vencimiento1 = vencimiento1;
    }

    public String getVencimiento2() {
        return vencimiento2;
    }

    public void setVencimiento2(String vencimiento2) {
        this.vencimiento2 = vencimiento2;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public void Alta(Object objeto) {
        Cuotas cuota=(Cuotas)objeto;
        String sql="insert into cuotas (vencimiento1,vencimiento2,periodo) values ('"+cuota.getVencimiento1()+"','"+cuota.getVencimiento2()+"','"+cuota.getPeriodo()+"')";
        Transaccionable tra=new ConeccionLocal();
        tra.guardarRegistro(sql);
        
    }

    @Override
    public void Baja(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificacion(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList Listar() {
        ArrayList listado=new ArrayList();
        String sql="select * from cuotas";
        Transaccionable tra=new ConeccionLocal();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
       try {
           while(rs.next()){
               Cuotas cuota=new Cuotas();
               cuota.setId(rs.getInt("id"));
               cuota.setPeriodo(rs.getString("periodo"));
               cuota.setVencimiento1(Numeros.ConvertirFecha(rs.getDate("vencimiento1")));
               cuota.setVencimiento2(Numeros.ConvertirFecha(rs.getDate("vencimiento2")));
               listado.add(cuota);
           }
           rs.close();
       } catch (SQLException ex) {
           Logger.getLogger(Cuotas.class.getName()).log(Level.SEVERE, null, ex);
       }
       return listado;
    }

    @Override
    public Object Cargar(Integer id) {
        Cuotas cuota=new Cuotas();
        String sql="select * from cuotas where id="+id;
        Transaccionable tra=new ConeccionLocal();
        ResultSet rs=tra.leerConjuntoDeRegistros(sql);
       try {
           while(rs.next()){
               
               cuota.setId(rs.getInt("id"));
               cuota.setPeriodo(rs.getString("periodo"));
               cuota.setVencimiento1(Numeros.ConvertirFecha(rs.getDate("vencimiento1")));
               cuota.setVencimiento2(Numeros.ConvertirFecha(rs.getDate("vencimiento2")));
               
           }
           rs.close();
       } catch (SQLException ex) {
           Logger.getLogger(Cuotas.class.getName()).log(Level.SEVERE, null, ex);
       }
       return cuota;
    }
   
   
}
