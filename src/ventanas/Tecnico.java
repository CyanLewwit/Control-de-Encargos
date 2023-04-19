
package ventanas;

import clases.Conexion;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class Tecnico extends javax.swing.JFrame {
    
    String user, nombre_usuario;
    int Sesion_user;

   
    public Tecnico() throws SQLException, Exception {
        initComponents();
        user=Login.user;
        Sesion_user=Administrador.sesion_usuario;
        Conexion cn=new Conexion();

        setSize(550,300);
        setResizable(false);
        setTitle("Tecnico - Sesion de "+user);
        setLocationRelativeTo(null);
        
        if (Sesion_user==1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();
        
        try {
            String sql="select nombre_usuario from usuarios where username = \""+user+"\"";
            ResultSet rs=cn.consulta(sql);
            if(rs.next()){
                nombre_usuario=rs.getString("nombre_usuario");
                Lab_nameuser.setText("Bienvenido "+nombre_usuario);
            }
        } catch (Exception e) {
            System.err.println("Errpr al consultar el nombre del Tecnico "+e);
        }
        
        cn.desconectarBase();
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logtitle.png"));
        return retValue;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lab_nameuser = new javax.swing.JLabel();
        But_GE = new javax.swing.JButton();
        But_Gstatus = new javax.swing.JButton();
        But_Gmarcas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lab_nameuser.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        Lab_nameuser.setForeground(new java.awt.Color(255, 255, 255));
        Lab_nameuser.setText("jLabel1");
        getContentPane().add(Lab_nameuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        But_GE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apoyo-tecnico.png"))); // NOI18N
        But_GE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_GEActionPerformed(evt);
            }
        });
        getContentPane().add(But_GE, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        But_Gstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        But_Gstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_GstatusActionPerformed(evt);
            }
        });
        getContentPane().add(But_Gstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        But_Gmarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        But_Gmarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_GmarcasActionPerformed(evt);
            }
        });
        getContentPane().add(But_Gmarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gestion de Equipo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Grafica de Estatus");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Grafica de Marcas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Creado por Cyan Lewwit");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 240, -1, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_GEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_GEActionPerformed
        
        Gestionar_Eq ge=new Gestionar_Eq();
        ge.setVisible(true);
    }//GEN-LAST:event_But_GEActionPerformed

    private void But_GstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_GstatusActionPerformed
        // TODO add your handling code here:
        Graficar_Estatus gr;
        try {
            gr = new Graficar_Estatus();
            gr.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_But_GstatusActionPerformed

    private void But_GmarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_GmarcasActionPerformed
        
        try {
            Graficar_Marcas gm=new Graficar_Marcas();
            gm.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_But_GmarcasActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Tecnico().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Tecnico.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_GE;
    private javax.swing.JButton But_Gmarcas;
    private javax.swing.JButton But_Gstatus;
    private javax.swing.JLabel Lab_nameuser;
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

}
