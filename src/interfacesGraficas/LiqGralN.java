/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesGraficas;

import interfaces.Busquedas;
import interfaces.Generable;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.ClientesTango;
import objetos.Cuotas;



/**
 *
 * @author mauro
 */
public class LiqGralN extends javax.swing.JInternalFrame {
    private String fecha=null;
    private String fecha3=null;
    /**
     * Creates new form LiqGralN
     */
    public LiqGralN() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Aseavyt - Emision de Cuotas");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Emision de Cuotas");

        jLabel3.setText("1 er Vencimiento");

        jLabel4.setText("2 do Vencimiento");

        jButton2.setText("Generar Cuota");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 67, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Calendar fecha1=this.dateChooserCombo1.getSelectedDate();
        Calendar fecha2=this.dateChooserCombo2.getSelectedDate();
        String periodo=null;
        DecimalFormat fr=new DecimalFormat("00");
        //Calendar c1=Calendar.getInstance();
	//Calendar c2=new GregorianCalendar();
	String dia=Integer.toString(fecha1.get(Calendar.DAY_OF_MONTH));
	String mes=Integer.toString(fecha1.get(Calendar.MONTH));
	String ano=Integer.toString(fecha1.get(Calendar.YEAR));
	
        int da=Integer.parseInt(dia);
        int me=Integer.parseInt(mes);
        me++;
        dia=fr.format(da);
        mes=fr.format(me);
        fecha=ano+"-"+mes+"-"+dia;
	periodo=mes+"/"+ano;
        //fecha="23/12/2011";
        String fh=ano+"-"+mes+"-"+dia;
        // a partir de aca lo de fecha2
        
        dia=Integer.toString(fecha2.get(Calendar.DAY_OF_MONTH));
        mes=Integer.toString(fecha2.get(Calendar.MONTH));
        ano=Integer.toString(fecha2.get(Calendar.YEAR));
        da=Integer.parseInt(dia);
        me=Integer.parseInt(mes);
        me++;
        dia=fr.format(da);
        mes=fr.format(me);
        fecha3=ano+"-"+mes+"-"+dia;
        System.err.println(fecha+"  / 2 do:"+fecha3);
        Cuotas cuota=new Cuotas();
        Generable genera=new Cuotas();
        cuota.setPeriodo(periodo);
        cuota.setVencimiento1(fecha);
        cuota.setVencimiento2(fecha3);
        genera.Alta(cuota);
        Integer idCuota=0;
        Iterator ic=genera.Listar().listIterator();
        while(ic.hasNext()){
            cuota=(Cuotas)ic.next();
            idCuota=cuota.getId();
        }
        ArrayList listadoClientes=new ArrayList();
        Busquedas bus=new ClientesTango();
        ClientesTango cliente=new ClientesTango();
        listadoClientes=bus.listar("");
        Iterator il=listadoClientes.listIterator();
        while(il.hasNext()){
            cliente=(ClientesTango)il.next();
            cliente.setIdCuota(idCuota);
        }
        
        cliente.emitirCuotas(listadoClientes);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
