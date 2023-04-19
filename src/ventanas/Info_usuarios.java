
package ventanas;

import javax.swing.WindowConstants;
import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.regex.*;

public class Info_usuarios extends javax.swing.JFrame {
    String user,user_update="";
    int ID;

    
    public Info_usuarios() {
        initComponents();
        user=Login.user;
        user_update=Gestionar_Usuarios.user_update;
        
        setSize(630, 450);
        setResizable(false);
        setTitle("Informacion del Usuario "+user_update+" - Sesion de "+user);
        setLocationRelativeTo(null);
        
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();
        
        LTIT.setText("Informacion del Usuario "+user_update);
        
        Conexion cn = new Conexion();
        try {
           String sql="select* from usuarios where username = \""+user_update+"\"";
           ResultSet rs=cn.consulta(sql);
           
           if(rs.next()){
               ID=rs.getInt("id_usuario");
               
               txt_name.setText(rs.getString("nombre_usuario"));
               txt_email.setText(rs.getString("email"));
               txt_tt.setText(rs.getString("telefono"));
               txt_username.setText(rs.getString("username"));
               txt_registradopor.setText(rs.getString("registrado_por"));
               
               cmb_niveles.setSelectedItem(rs.getString("tipo_nivel"));
               cmb_estatus.setSelectedItem(rs.getString("estatus"));
               cn.desconectarBase();
           }
        } catch (Exception e) {
            System.err.println("Error al cargar Usuario "+e);
            JOptionPane.showMessageDialog(null, "Error al cargar. Contacte al Administrador");
        } 
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
        Lab_name = new javax.swing.JLabel();
        Lab_email = new javax.swing.JLabel();
        Lab_tt = new javax.swing.JLabel();
        Lab_perm = new javax.swing.JLabel();
        Lab_username = new javax.swing.JLabel();
        Lab_status = new javax.swing.JLabel();
        Lab_reg = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_tt = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_registradopor = new javax.swing.JTextField();
        cmb_estatus = new javax.swing.JComboBox<>();
        cmb_niveles = new javax.swing.JComboBox<>();
        But_actualizar = new javax.swing.JButton();
        But_restpass = new javax.swing.JButton();
        footer = new javax.swing.JLabel();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LTIT.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        LTIT.setForeground(new java.awt.Color(255, 255, 255));
        LTIT.setText("Información del Usuario");
        getContentPane().add(LTIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        Lab_name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name.setText("Nombre:");
        getContentPane().add(Lab_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        Lab_email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_email.setForeground(new java.awt.Color(255, 255, 255));
        Lab_email.setText("Email:");
        getContentPane().add(Lab_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        Lab_tt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_tt.setForeground(new java.awt.Color(255, 255, 255));
        Lab_tt.setText("Telefono:");
        getContentPane().add(Lab_tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        Lab_perm.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_perm.setForeground(new java.awt.Color(255, 255, 255));
        Lab_perm.setText("Permisos de:");
        getContentPane().add(Lab_perm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        Lab_username.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_username.setForeground(new java.awt.Color(255, 255, 255));
        Lab_username.setText("Username:");
        getContentPane().add(Lab_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        Lab_status.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_status.setForeground(new java.awt.Color(255, 255, 255));
        Lab_status.setText("Estatus:");
        getContentPane().add(Lab_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        Lab_reg.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_reg.setForeground(new java.awt.Color(255, 255, 255));
        Lab_reg.setText("Registrado por:");
        getContentPane().add(Lab_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        txt_name.setBackground(new java.awt.Color(153, 153, 255));
        txt_name.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_email.setBackground(new java.awt.Color(153, 153, 255));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_tt.setBackground(new java.awt.Color(153, 153, 255));
        txt_tt.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_tt.setForeground(new java.awt.Color(255, 255, 255));
        txt_tt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_username.setBackground(new java.awt.Color(153, 153, 255));
        txt_username.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        txt_registradopor.setBackground(new java.awt.Color(153, 153, 255));
        txt_registradopor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_registradopor.setForeground(new java.awt.Color(255, 255, 255));
        txt_registradopor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_registradopor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_registradopor.setEnabled(false);
        getContentPane().add(txt_registradopor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 210, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        But_actualizar.setBackground(new java.awt.Color(153, 153, 255));
        But_actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        But_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        But_actualizar.setText("Actualizar Usuario");
        But_actualizar.setBorder(null);
        But_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(But_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 210, 35));

        But_restpass.setBackground(new java.awt.Color(153, 153, 255));
        But_restpass.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        But_restpass.setForeground(new java.awt.Color(255, 255, 255));
        But_restpass.setText("Restaurar Password");
        But_restpass.setBorder(null);
        But_restpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_restpassActionPerformed(evt);
            }
        });
        getContentPane().add(But_restpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 210, 35));

        footer.setForeground(new java.awt.Color(0, 0, 0));
        footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 390, -1, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_actualizarActionPerformed
        // TODO add your handling code here:
        int permisos_cmb,estatus_cmb,validacion=0;
        String nombre,mail,tel,username,pas,perm_st="",estatus_st="",regex=
                "(\\W|^)[\\w.\\-]{0,25}@(yahoo|hotmail|gmail)\\.com";
        
        mail=txt_email.getText().trim();
        username=txt_username.getText().trim();
        nombre=txt_name.getText().trim();
        tel=txt_tt.getText().trim();
        permisos_cmb=(cmb_niveles.getSelectedIndex())+1;
        estatus_cmb=(cmb_estatus.getSelectedIndex())+1;
        Pattern patt=Pattern.compile(regex);
        Matcher mat=patt. matcher(mail);
        
        if(mail.equals("") || mat.find()==false){
            validacion++;
            txt_email.setBackground(Color.red);
            JOptionPane.showMessageDialog(null,"Error en el mail");
            
        }
        if(username.equals("")){
            txt_username.setBackground(Color.red);
            validacion++;
        }
        
        if(nombre.equals("")){
            txt_name.setBackground(Color.red);
            validacion++;
        }
        if(tel.equals("")){
            txt_tt.setBackground(Color.red);
            validacion++;
        }
        
        if (validacion==0) {
            switch (permisos_cmb) {
            case 1:
                perm_st="Administrador";
                break;
            case 2:
                perm_st="Capturista";
                break;
            case 3:
                perm_st="Tecnico";
                break;
            default:
                perm_st="Tecnico";
                break;
        }
        
        switch (estatus_cmb) {
            case 1:
                estatus_st="Activo";
                break;
            case 2:
                estatus_st="Inactivo";
                break;
            default:
                estatus_st="Activo";
                break;
                
                
                }
        
        Conexion cn = new Conexion();
                try {
                    String sql="select username from usuarios where username = \""+username+"\" and not id_usuario = \""+ID+"\"";/*ultima parte para que no compare la actual*/
                    ResultSet rs=cn.consulta(sql);
                    if (rs.next()) {
                        txt_username.setBackground(Color.red);
                        JOptionPane.showInternalMessageDialog(null, "Nombre de usuario no disponible.");
                        cn.desconectarBase();
                    } else {
                        String sql2="update usuarios set nombre_usuario = \""+nombre+"\", email = \""+
                                mail+"\", telefono = \""+tel+"\", username = \""+username+"\", tipo_nivel = \""+
                                perm_st+"\", estatus = \""+estatus_st+"\" where id_usuario = \""+ID+"\"";
                        cn.insertarModificarEliminar(sql2);
                        
                        JOptionPane.showMessageDialog(null, "Actualizacion exitosa!!!");
                        cn.desconectarBase();
                    }
                    
                } catch (Exception e) {
                    System.err.println("Error al Actualizar "+e);
                    JOptionPane.showMessageDialog(null,"Error al actualizar. Comuniquese con el Administardor");
        }
                
                
        } else {
            JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
        }
        
        
        
        
        
    }//GEN-LAST:event_But_actualizarActionPerformed

    private void But_restpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_restpassActionPerformed
        // TODO add your handling code here:
        Restaurar_password x = new Restaurar_password();
        x.setVisible(true);
    }//GEN-LAST:event_But_restpassActionPerformed

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
            java.util.logging.Logger.getLogger(Info_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Info_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Info_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Info_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Info_usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_actualizar;
    private javax.swing.JButton But_restpass;
    private javax.swing.JLabel LTIT;
    private javax.swing.JLabel Lab_email;
    private javax.swing.JLabel Lab_name;
    private javax.swing.JLabel Lab_perm;
    private javax.swing.JLabel Lab_reg;
    private javax.swing.JLabel Lab_status;
    private javax.swing.JLabel Lab_tt;
    private javax.swing.JLabel Lab_username;
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JLabel footer;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_registradopor;
    private javax.swing.JTextField txt_tt;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
