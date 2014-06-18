/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

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
public class Planes implements Generable{
    private Integer id;
    private String descripcion;
    private Double monto1;
    private Double monto2;
    private String fecha1;
    private String fecha2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto1() {
        return monto1;
    }

    public void setMonto1(Double monto1) {
        this.monto1 = monto1;
    }

    public Double getMonto2() {
        return monto2;
    }

    public void setMonto2(Double monto2) {
        this.monto2 = monto2;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    @Override
    public void Alta(Object objeto) {
        Planes plan=(Planes) objeto;
        String sql="insert into coeficienteslistas (descripcion,montocuota,montocuota2,coeficiente) values ('"+plan.getDescripcion()+"',"+plan.getMonto1()+","+plan.getMonto2()+",1.00)";
        Transaccionable tra=new ConeccionLocal();
        tra.guardarRegistro(sql);
    }

    @Override
    public void Baja(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificacion(Object objeto) {
        Planes plan=(Planes) objeto;
        String sql="update coeficienteslistas set descripcion='"+plan.getDescripcion()+"',montocuota="+plan.getMonto1()+",montocuota2="+plan.getMonto2();
        Transaccionable tra=new ConeccionLocal();
        tra.guardarRegistro(sql);
    }

    @Override
    public ArrayList Listar() {
       ArrayList listado=new ArrayList();
       String sql="select * from coeficienteslistas";
       Transaccionable tra=new ConeccionLocal();
       ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                Planes plan=new Planes();
                plan.setDescripcion(rs.getString("descripcion"));
                plan.setId(rs.getInt("id"));
                plan.setMonto1(rs.getDouble("montocuota"));
                plan.setMonto2(rs.getDouble("montocuota2"));
                listado.add(plan);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Planes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    @Override
    public Object Cargar(Integer id) {
        Planes plan=new Planes();
       String sql="select * from coeficienteslistas where id="+id;
       Transaccionable tra=new ConeccionLocal();
       ResultSet rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                
                plan.setDescripcion(rs.getString("descripcion"));
                plan.setId(rs.getInt("id"));
                plan.setMonto1(rs.getDouble("montocuota"));
                plan.setMonto2(rs.getDouble("montocuota2"));
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Planes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plan;
    }
    
}
