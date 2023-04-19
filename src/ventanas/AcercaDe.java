
package ventanas;

import clases.Conexion;
import java.sql.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class AcercaDe extends javax.swing.JFrame {
    
    String user, nombre_usuario;
    int Sesion_user;

   
    public AcercaDe() throws SQLException, Exception {
        initComponents();
        user=Login.user;
        Sesion_user=Administrador.sesion_usuario;

        setSize(400,300);
        setResizable(false);
        setTitle("Acerca De - Sesion de "+user);
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

    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logtitle.png"));
        return retValue;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lab1 = new javax.swing.JLabel();
        Lab2 = new javax.swing.JLabel();
        Lab3 = new javax.swing.JLabel();
        Lab4 = new javax.swing.JLabel();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lab1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Lab1.setForeground(new java.awt.Color(255, 255, 255));
        Lab1.setText("Sistema creado como Ejercicio");
        getContentPane().add(Lab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        Lab2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Lab2.setForeground(new java.awt.Color(255, 255, 255));
        Lab2.setText("como practica");
        getContentPane().add(Lab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        Lab3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Lab3.setForeground(new java.awt.Color(255, 255, 255));
        Lab3.setText("La Geekipedia de Ernesto");
        getContentPane().add(Lab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        Lab4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Lab4.setForeground(new java.awt.Color(255, 255, 255));
        Lab4.setText("Facebook/Twitter/Instagram");
        getContentPane().add(Lab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AcercaDe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new AcercaDe().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(AcercaDe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AcercaDe.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lab1;
    private javax.swing.JLabel Lab2;
    private javax.swing.JLabel Lab3;
    private javax.swing.JLabel Lab4;
    private javax.swing.JLabel Lab_wall;
    // End of variables declaration//GEN-END:variables
}
