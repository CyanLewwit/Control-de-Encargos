
package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Info_equipo extends javax.swing.JFrame {

    int IDCliente_update,IDequipo;
    String user,nom_cliente;
    
    public Info_equipo() throws Exception {
        initComponents();
        user=Login.user;
        IDequipo=Informacion_cliente.ID_eq;
        IDCliente_update=Gestionar_Clientes.IDcliente_update;
        Conexion cn=new Conexion();
        try {
            String sl="select nombre_cliente from clientes where id_cliente = \""+IDCliente_update+"\";";
            ResultSet rs=cn.consulta(sl);
            if (rs.next()) {
                nom_cliente=rs.getString("nombre_cliente");
            } 
        } catch (SQLException e) {
            System.err.println("Error al consultar name del cliente "+e);
        }
        
        try {
            String sl2="select * from equipos where id_equipo = \""+IDequipo+"\";";
            ResultSet rs=cn.consulta(sl2);
            if (rs.next()) {
                cmc_tipo.setSelectedItem(rs.getString("tipo_equipo"));
                cmb_marca.setSelectedItem(rs.getString("marca"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));
                txt_serie.setText(rs.getString("num_serie"));
                txt_modelo.setText(rs.getString("modelo"));
                txt_ultimamod.setText(rs.getString("ultima_mod"));
                String dia,mes,annio;
                dia=rs.getString("dia_i");
                mes=rs.getString("mes_i");
                annio=rs.getString("annio_i");
                txt_fecha.setText(dia+"/"+mes+"/"+annio);
                txtpane_observaciones.setText(rs.getString("observaciones"));
                txtpane_comTec.setText(rs.getString("comentarios_tecnicos"));
                ComentarioTecDe.setText("Comentarios y actualizacion del tecnico: "+rs.getString("revision_tec_de"));
            } 
        } catch (SQLException e) {
            System.err.println("Error al consultar la info del Equipo "+e);
        }
        
        setTitle("Equipo del cliente "+nom_cliente);
        
        setSize(670, 530);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();
        
        txt_name.setText(nom_cliente);
        
        
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logtitle.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LTIT = new javax.swing.JLabel();
        Scroll1 = new javax.swing.JScrollPane();
        txtpane_observaciones = new javax.swing.JTextPane();
        Scroll2 = new javax.swing.JScrollPane();
        txtpane_comTec = new javax.swing.JTextPane();
        Lab_name = new javax.swing.JLabel();
        Lab_name1 = new javax.swing.JLabel();
        Lab_name2 = new javax.swing.JLabel();
        Lab_name3 = new javax.swing.JLabel();
        Lab_name4 = new javax.swing.JLabel();
        Lab_name5 = new javax.swing.JLabel();
        Lab_name6 = new javax.swing.JLabel();
        Lab_name7 = new javax.swing.JLabel();
        Lab_name8 = new javax.swing.JLabel();
        ComentarioTecDe = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_serie = new javax.swing.JTextField();
        txt_ultimamod = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        cmc_tipo = new javax.swing.JComboBox<>();
        cmb_marca = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        But_Actualizar = new javax.swing.JButton();
        footer = new javax.swing.JLabel();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LTIT.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        LTIT.setForeground(new java.awt.Color(255, 255, 255));
        LTIT.setText("Información de Equipo");
        getContentPane().add(LTIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        Scroll1.setViewportView(txtpane_observaciones);

        getContentPane().add(Scroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        txtpane_comTec.setEditable(false);
        Scroll2.setViewportView(txtpane_comTec);

        getContentPane().add(Scroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        Lab_name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name.setText("Nombre del Cliente:");
        getContentPane().add(Lab_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        Lab_name1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name1.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name1.setText("Tipo de Equipo:");
        getContentPane().add(Lab_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        Lab_name2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name2.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name2.setText("Marca:");
        getContentPane().add(Lab_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        Lab_name3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name3.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name3.setText("Modelo:");
        getContentPane().add(Lab_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        Lab_name4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name4.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name4.setText("Numero de Serie:");
        getContentPane().add(Lab_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        Lab_name5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name5.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name5.setText("Fecha de Ingreso:");
        getContentPane().add(Lab_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        Lab_name6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name6.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name6.setText("Ultima modificacion por:");
        getContentPane().add(Lab_name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        Lab_name7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name7.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name7.setText("Estatus:");
        getContentPane().add(Lab_name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        Lab_name8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name8.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name8.setText("Daño reportado/Observaciones:");
        getContentPane().add(Lab_name8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        ComentarioTecDe.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        ComentarioTecDe.setForeground(new java.awt.Color(255, 255, 255));
        ComentarioTecDe.setText("Comentarios tecnicos:");
        getContentPane().add(ComentarioTecDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        txt_name.setBackground(new java.awt.Color(153, 153, 255));
        txt_name.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_name.setEnabled(false);
        getContentPane().add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_modelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_serie.setBackground(new java.awt.Color(153, 153, 255));
        txt_serie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_serie.setForeground(new java.awt.Color(255, 255, 255));
        txt_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_serie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        txt_ultimamod.setBackground(new java.awt.Color(153, 153, 255));
        txt_ultimamod.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultimamod.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimamod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultimamod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultimamod.setEnabled(false);
        getContentPane().add(txt_ultimamod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        txt_fecha.setBackground(new java.awt.Color(153, 153, 255));
        txt_fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_fecha.setEnabled(false);
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        cmc_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmc_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alenware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo" }));
        getContentPane().add(cmb_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo Ingreso", "No Reparado", "En Revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        But_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        But_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        But_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        But_Actualizar.setText("Actualizar Equipo");
        But_Actualizar.setBorder(null);
        But_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(But_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 210, 35));

        footer.setForeground(new java.awt.Color(0, 0, 0));
        footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, -1, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_ActualizarActionPerformed

        int validacion=0;
        String tipo_e,marca,modelo,n_s,obs,sta;
        Conexion cn=new Conexion();
        
        tipo_e=cmc_tipo.getSelectedItem().toString();
        marca=cmb_marca.getSelectedItem().toString();
        sta=cmb_estatus.getSelectedItem().toString();
        modelo=txt_modelo.getText().trim();
        n_s=txt_serie.getText().trim();
        obs=txtpane_observaciones.getText();
        
        if(modelo.equals("")){
            txt_modelo.setBackground(Color.red);
            validacion++;
        }
        if(n_s.equals("")){
            txt_serie.setBackground(Color.red);
            validacion++;
        }
        if(obs.equals("")){
            txtpane_observaciones.setText("Sin Comentarios.");
        }
        
        if (validacion==0) {
            try {
                String sql="update equipos set tipo_equipo = \""+tipo_e+"\", marca = \""+
                                marca+"\", modelo = \""+modelo+"\", num_serie = \""+n_s+"\", observaciones = \""+
                                obs+"\", estatus = \""+sta+"\", ultima_mod = \""+user+"\" where id_equipo = \""+IDequipo+"\";";
                
                cn.insertarModificarEliminar(sql);
                Limpiar();
                
                txt_name.setBackground(Color.GREEN);
                txt_fecha.setBackground(Color.GREEN);
                txt_serie.setBackground(Color.GREEN);
                txt_serie.setBackground(Color.GREEN);
                txt_ultimamod.setText(user);
                
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa!!");
                this.dispose();
            } catch (SQLException e) {
                System.err.println("Error al Act eq "+e);
                JOptionPane.showMessageDialog(null,"Error.Contacte al Administrador.");
            } catch (Exception ex) {
                Logger.getLogger(Info_equipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar los campos vacios");
        }
    }//GEN-LAST:event_But_ActualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Info_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Info_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Info_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Info_equipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Info_equipo().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Info_equipo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_Actualizar;
    private javax.swing.JLabel ComentarioTecDe;
    private javax.swing.JLabel LTIT;
    private javax.swing.JLabel Lab_name;
    private javax.swing.JLabel Lab_name1;
    private javax.swing.JLabel Lab_name2;
    private javax.swing.JLabel Lab_name3;
    private javax.swing.JLabel Lab_name4;
    private javax.swing.JLabel Lab_name5;
    private javax.swing.JLabel Lab_name6;
    private javax.swing.JLabel Lab_name7;
    private javax.swing.JLabel Lab_name8;
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JScrollPane Scroll1;
    private javax.swing.JScrollPane Scroll2;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_marca;
    private javax.swing.JComboBox<String> cmc_tipo;
    private javax.swing.JLabel footer;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextField txt_ultimamod;
    private javax.swing.JTextPane txtpane_comTec;
    private javax.swing.JTextPane txtpane_observaciones;
    // End of variables declaration//GEN-END:variables

public void Limpiar(){
    txt_name.setText("");
    txt_fecha.setText("");
    txt_serie.setText("");
    txt_serie.setText("");
    txt_ultimamod.setText("");
}
}
