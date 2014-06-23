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
public class Rubros implements Generable{
    private Integer id;
    private String descripcion;

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

    @Override
    public void Alta(Object objeto) {
        Rubros rubro=new Rubros();
        rubro=(Rubros)objeto;
        String sql="insert into rubros (descripcion) values ('"+rubro.getDescripcion()+"')";
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
        String sql="select * from rubros";
        ResultSet rs=null;
        Transaccionable tra=new ConeccionLocal();
        rs=tra.leerConjuntoDeRegistros(sql);
        try {
            while(rs.next()){
                Rubros rubro=new Rubros();
                rubro.setDescripcion(rs.getString("descripcion"));
                rubro.setId(rs.getInt("id"));
                listado.add(rubro);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Rubros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }

    @Override
    public Object Cargar(Integer id) {
        
        String sql="select * from rubros where id="+id;
        ResultSet rs=null;
        Transaccionable tra=new ConeccionLocal();
        rs=tra.leerConjuntoDeRegistros(sql);
        Rubros rubro=new Rubros();
        try {
            while(rs.next()){
                
                rubro.setDescripcion(rs.getString("descripcion"));
                rubro.setId(rs.getInt("id"));
                
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Rubros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rubro;
    }
    
    
}
