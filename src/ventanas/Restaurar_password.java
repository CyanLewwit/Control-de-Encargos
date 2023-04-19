
package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
        
public class Restaurar_password extends javax.swing.JFrame {

    String user,user_update;
    public Restaurar_password() {
        initComponents();
        user=Login.user;
        user_update=Gestionar_Usuarios.user_update;
        
        setSize(360, 260);
        setResizable(false);
        setTitle("Restaurar Password para "+user_update+" - Sesion de "+user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logtitle.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        But_restpass = new javax.swing.JButton();
        txt_pass1 = new javax.swing.JPasswordField();
        txt_passc = new javax.swing.JPasswordField();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambio de Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nuevo Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirmar Password:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

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
        getContentPane().add(But_restpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 35));

        txt_pass1.setBackground(new java.awt.Color(155, 155, 255));
        txt_pass1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_pass1.setForeground(new java.awt.Color(255, 255, 255));
        txt_pass1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_passc.setBackground(new java.awt.Color(155, 155, 255));
        txt_passc.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_passc.setForeground(new java.awt.Color(255, 255, 255));
        txt_passc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_passc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_passc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_restpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_restpassActionPerformed
        // TODO add your handling code here:
        String passw,passwcon;
        
        passw=txt_pass1.getText().trim();
        passwcon=txt_passc.getText().trim();
        Conexion cn=new Conexion();
        if (!passw.equals("") && !passwcon.equals("")) {
            if (passw.equals(passwcon)) {
                
                try {
                    String sql="update usuarios set pasword = \""+passwcon+"\" where username = \""+user_update+"\"";
                    cn.insertarModificarEliminar(sql);
                    txt_pass1.setBackground(Color.green);
                    txt_passc.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Restauracion Completa");
                } catch (Exception e) {
                    System.err.println("Error al Restaurar Password");
                    JOptionPane.showMessageDialog(null, "Error al Restaurar Password. Comuniquese con el Admin");
                    
                }
                
            } else {
                txt_passc.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las Contraseñas no cionciden");
            }
            
        } else {
            txt_pass1.setBackground(Color.red);
            txt_passc.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "No se admiten contraseñas vacias.");
        }
        
        
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
            java.util.logging.Logger.getLogger(Restaurar_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaurar_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaurar_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaurar_password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaurar_password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_restpass;
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txt_pass1;
    private javax.swing.JPasswordField txt_passc;
    // End of variables declaration//GEN-END:variables
}
