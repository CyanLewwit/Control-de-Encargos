
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Registro_clientes extends javax.swing.JFrame {

    String user;
    public Registro_clientes() {
        initComponents();
        user=Login.user;
        
        setTitle("Registrar nuevo Cliente-Sesion de "+user);
        setSize(530,350);
        setResizable(false);
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

        Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_tt = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        boton_Rclientes = new javax.swing.JButton();
        label_footer = new javax.swing.JLabel();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Registro de Clientes");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registrar Cliente");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

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

        txt_direccion.setBackground(new java.awt.Color(153, 153, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        boton_Rclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        boton_Rclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_RclientesActionPerformed(evt);
            }
        });
        getContentPane().add(boton_Rclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 120, 100));

        label_footer.setForeground(new java.awt.Color(0, 0, 0));
        label_footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(label_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_RclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_RclientesActionPerformed
        // TODO add your handling code here:
        int validacion=0;
        String name, mail,tt, direccion,regex;
        Conexion cn=new Conexion();
        regex="(\\W|^)[\\w.\\-]{0,25}@(yahoo|hotmail|gmail)\\.com";
        
        name=txt_name.getText().trim();
        mail=txt_email.getText().trim();
        tt=txt_tt.getText().trim();
        direccion=txt_direccion.getText().trim();
        
        Pattern patt=Pattern.compile(regex);
        Matcher mat=patt. matcher(mail);
        
        if(mail.equals("") || mat.find()==false){
            validacion++;
            txt_email.setBackground(Color.red);
            JOptionPane.showMessageDialog(null,"Error en el mail/Coloque uno habilitado"); 
        }
        if(name.equals("")){
            txt_name.setBackground(Color.red);
            validacion++;
        }
        if(tt.equals("")){
            txt_tt.setBackground(Color.red);
            validacion++;
        }
        if(direccion.equals("")){
            txt_direccion.setBackground(Color.red);
            validacion++;
        }
        
        if (validacion==0) {
            try {
                String sql = "INSERT INTO clientes(nombre_cliente,email_cliente,tel_cliente,dir_cliente,ultima_mod) " + "VALUES(\"" + name
                        + "\", \"" + mail + "\",\"" + tt + "\",\"" + direccion + "\",\"" + user + "\");";
                System.out.println(sql);
                cn.insertarModificarEliminar(sql);
                
                Limpiar();
                txt_name.setBackground(Color.GREEN);
                txt_direccion.setBackground(Color.GREEN);
                txt_email.setBackground(Color.GREEN);
                txt_tt.setBackground(Color.GREEN);
                

                JOptionPane.showMessageDialog(null, "Registro Exitoso.");
          
                this.dispose();

            } catch (Exception e) {
                System.out.println("Error al registrar cliente "+e);
                JOptionPane.showMessageDialog(null,"Error al registrar cliente Contacte al Administrador");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
        
    }//GEN-LAST:event_boton_RclientesActionPerformed

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
            java.util.logging.Logger.getLogger(Registro_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton boton_Rclientes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel label_footer;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_tt;
    // End of variables declaration//GEN-END:variables

    
    public void Limpiar(){
    txt_name.setText("");
    txt_direccion.setText("");
    txt_tt.setText("");
    txt_email.setText("");
}

}
