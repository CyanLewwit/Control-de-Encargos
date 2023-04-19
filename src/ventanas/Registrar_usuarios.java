
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
import javax.swing.WindowConstants;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class Registrar_usuarios extends javax.swing.JFrame {
    
    String user;


    public Registrar_usuarios() {
        initComponents();
        user=Login.user;
        
        setTitle("Registrar nuevo usuario-Sesion de "+user);
        setSize(630,350);
        setResizable(false);
        setLocationRelativeTo(null);
        
         /*Metodo para que el programa  siga en funcionamiento
        cuando se cierre la ventana
        */
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wallReg.getWidth(), Lab_wallReg.getHeight(), Image.SCALE_DEFAULT));
        Lab_wallReg.setIcon(icono);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        cmb_niveles = new javax.swing.JComboBox<>();
        boton_reg = new javax.swing.JButton();
        label_footer = new javax.swing.JLabel();
        Lab_wallReg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("E-mail:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Permisos de:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        txt_username.setBackground(new java.awt.Color(153, 153, 255));
        txt_username.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        txt_email.setBackground(new java.awt.Color(153, 153, 255));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_tel.setBackground(new java.awt.Color(153, 153, 255));
        txt_tel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_tel.setForeground(new java.awt.Color(255, 255, 255));
        txt_tel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_Password.setBackground(new java.awt.Color(153, 153, 255));
        txt_Password.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Password.setForeground(new java.awt.Color(255, 255, 255));
        txt_Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 210, -1));

        cmb_niveles.setBackground(new java.awt.Color(153, 153, 255));
        cmb_niveles.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        cmb_niveles.setForeground(new java.awt.Color(255, 255, 255));
        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        boton_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        boton_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_regActionPerformed(evt);
            }
        });
        getContentPane().add(boton_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 120, 100));

        label_footer.setForeground(new java.awt.Color(0, 0, 0));
        label_footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(label_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 300, -1, -1));
        getContentPane().add(Lab_wallReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_regActionPerformed
        // TODO add your handling code here:
        int permisos_cmb,validacion = 0;
        String name, ema, usernam,pass,tt, perm_string,regex;
        regex="(\\W|^)[\\w.\\-]{0,25}@(yahoo|hotmail|gmail)\\.com";
        
        ema=txt_email.getText().trim();
        usernam=txt_username.getText().trim();
        pass=txt_Password.getText().trim();
        name=txt_nombre.getText().trim();
        tt=txt_tel.getText().trim();
        permisos_cmb=(cmb_niveles.getSelectedIndex())+1;
        Pattern patt=Pattern.compile(regex);
        Matcher mat=patt. matcher(ema);
        
        if(ema.equals("") || mat.find()==false){
            validacion++;
            txt_email.setBackground(Color.red);
            JOptionPane.showMessageDialog(null,"Error en el mail"); 
        }
        if(usernam.equals("")){
            txt_username.setBackground(Color.red);
            validacion++;
        }
        if(pass.equals("")){
            txt_Password.setBackground(Color.red);
            validacion++;
        }
        if(name.equals("")){
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        if(tt.equals("")){
            txt_tel.setBackground(Color.red);
            validacion++;
        }
        
        
        switch (permisos_cmb) {
            case 1:
                perm_string="Administrador";
                break;
            case 2:
                perm_string="Capturista";
                break;
            case 3:
                perm_string="Tecnico";
                break;
            default:
                perm_string="Tecnico";
                break;
        }
        Conexion cn=new Conexion();
        try{
            String sql="select username from usuarios where username = \""+usernam+"\"";
            
            ResultSet rs=cn.consulta(sql);
            
            if(rs.next()){
                txt_username.setBackground(Color.RED);
                JOptionPane.showInternalMessageDialog(null, "Nombre de usuario no disponible. Ya existe");
            } else {
                cn.desconectarBase();
                if (validacion==0) {
                    try{
                        
                        String sql2 = "INSERT INTO usuarios(nombre_usuario,email,telefono,username,pasword,tipo_nivel,estatus,registrado_por) " + "VALUES(\"" + name
                                + "\", \"" + ema + "\",\"" + tt + "\",\"" + usernam + "\",\"" + pass + "\",\"" + perm_string + "\",\"" + "Activo" + "\",\"" + user + "\");";
                        //Mostramos cadena resultante.
                        System.out.println(sql2);
                        cn.insertarModificarEliminar(sql2);

                        Limpiar();
                        txt_username.setBackground(Color.GREEN);
                        txt_nombre.setBackground(Color.GREEN);
                        txt_email.setBackground(Color.GREEN);
                        txt_tel.setBackground(Color.GREEN);
                        txt_Password.setBackground(Color.GREEN);
                        cn.desconectarBase();
                        
                        JOptionPane.showMessageDialog(null, "Registro Exitoso.");
                        /*Metodo dispose permite que se cierre una vez finalizado el registro
                        */
                        
                        this.dispose();
                    }catch(SQLException e){
                        System.err.println("Error al registrar usuario"+e);
                        cn.desconectarBase();
                        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                    cn.desconectarBase();
                }
            }
        }catch(Exception e){
            System.err.println("Error en Conexion a BdD/Ventana Registro Adm");
            JOptionPane.showMessageDialog(null,"Error. Informe al Administrador");
        } finally {
            try {
                cn.desconectarBase();
            } catch (SQLException ex) {
                Logger.getLogger(Registrar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Registrar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_boton_regActionPerformed

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
            java.util.logging.Logger.getLogger(Registrar_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lab_wallReg;
    private javax.swing.JButton boton_reg;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel label_footer;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

public void Limpiar(){
    txt_nombre.setText("");
    txt_username.setText("");
    txt_tel.setText("");
    txt_email.setText("");
    txt_Password.setText("");
    cmb_niveles.setSelectedIndex(0);
}

}
