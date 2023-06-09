/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import clases.Conexion;

public class Login extends javax.swing.JFrame {
    
    public static String user = "";
    String pass = "";
    
    public Login() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setTitle("Acceso al Sistema");
        setLocationRelativeTo(null);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Label_Wallpaper.getWidth(), Label_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        Label_Wallpaper.setIcon(icono);
        this.repaint();
        
        ImageIcon wall_logo = new ImageIcon("src/images/logtitle.png");
        Icon icon_logo = new ImageIcon(wall_logo.getImage().getScaledInstance(Label_Logo.getWidth(), Label_Logo.getHeight(), Image.SCALE_DEFAULT));
        Label_Logo.setIcon(icon_logo);
        this.repaint();
        
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logtitle.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_Logo = new javax.swing.JLabel();
        Textuser = new javax.swing.JTextField();
        passw = new javax.swing.JPasswordField();
        Button_acceso = new javax.swing.JButton();
        Label_footer = new javax.swing.JLabel();
        Label_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Label_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 270, 270));

        Textuser.setBackground(new java.awt.Color(153, 153, 255));
        Textuser.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Textuser.setForeground(new java.awt.Color(255, 255, 255));
        Textuser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Textuser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(Textuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        passw.setBackground(new java.awt.Color(153, 153, 255));
        passw.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        passw.setForeground(new java.awt.Color(255, 255, 255));
        passw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passw.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(passw, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 370, 210, -1));

        Button_acceso.setBackground(new java.awt.Color(153, 153, 255));
        Button_acceso.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        Button_acceso.setForeground(new java.awt.Color(255, 255, 255));
        Button_acceso.setText("Acceder");
        Button_acceso.setBorder(null);
        Button_acceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_accesoActionPerformed(evt);
            }
        });
        getContentPane().add(Button_acceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 420, 210, 35));

        Label_footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(Label_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 500, -1, -1));
        getContentPane().add(Label_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_accesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_accesoActionPerformed
        // TODO add your handling code here:
        
        user = Textuser.getText().trim();
        pass = passw.getText().trim();
        
        if (!user.equals("") || !pass.equals("")) {
            try {
                Conexion cn = new Conexion();
                ResultSet rs = cn.Log(user, pass);
                if (rs.next()) {
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");
                    
                    if (tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Administrador().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Capturista().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Tecnico().setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error en los datos");
                    Textuser.setText("");
                    passw.setText("");
                    
                }                
            } catch (Exception e) {
                System.err.print("Error en boton Acceder." + e);
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion. Comuniquese con el Administrador");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        }
        

    }//GEN-LAST:event_Button_accesoActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_acceso;
    private javax.swing.JLabel Label_Logo;
    private javax.swing.JLabel Label_Wallpaper;
    private javax.swing.JLabel Label_footer;
    private javax.swing.JTextField Textuser;
    private javax.swing.JPasswordField passw;
    // End of variables declaration//GEN-END:variables
}
