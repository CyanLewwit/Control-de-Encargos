
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

public class Capturista extends javax.swing.JFrame {
    
    String user, nombre_usuario;
    int Sesion_user;

   
    public Capturista() throws SQLException, Exception {
        initComponents();
        user=Login.user;
        Sesion_user=Administrador.sesion_usuario;
        Conexion cn=new Conexion();

        setSize(550,300);
        setResizable(false);
        setTitle("Capturista - Sesion de "+user);
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
            System.err.println("Errpr al consultar el nombre del capturista "+e);
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
        Boton_registrarcliente = new javax.swing.JButton();
        Boton_gestionarclientes = new javax.swing.JButton();
        Boton_imprimir = new javax.swing.JButton();
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

        Boton_registrarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        Boton_registrarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_registrarclienteActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_registrarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        Boton_gestionarclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        Boton_gestionarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_gestionarclientesActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_gestionarclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        Boton_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        Boton_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gestionar Clientes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Imprimir Clientes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Creado por Cyan Lewwit");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 240, -1, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_registrarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_registrarclienteActionPerformed
        // TODO add your handling code here:
        Registro_clientes c=new Registro_clientes();
        c.setVisible(true);
    }//GEN-LAST:event_Boton_registrarclienteActionPerformed

    private void Boton_gestionarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_gestionarclientesActionPerformed
        // TODO add your handling code here:
        Gestionar_Clientes gc=new Gestionar_Clientes();
        gc.setVisible(true);
    }//GEN-LAST:event_Boton_gestionarclientesActionPerformed

    private void Boton_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_imprimirActionPerformed
        
        Document doc=new Document();
        Conexion cn=new Conexion();
        try {
            String ruta=System.getProperty("user.home");
            PdfWriter.getInstance(doc, new FileOutputStream(ruta+"/Desktop/ListasClientes.pdf"));
            
            com.itextpdf.text.Image header=com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            Paragraph parrafo=new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de Clientes. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18,Font.BOLD,BaseColor.BLACK));
            
            doc.open();
            doc.add(header);
            doc.add(parrafo);
            
            PdfPTable tc=new PdfPTable(5);
            tc.addCell("ID");
            tc.addCell("Nombre");
            tc.addCell("Email");
            tc.addCell("Telefono");
            tc.addCell("Direccion");
            
            try {
                String sql="select* from clientes ;";
                ResultSet rs=cn.consulta(sql);
                if (rs.next()) {
                    do {                        
                        tc.addCell(rs.getString(1));
                        tc.addCell(rs.getString(2));
                        tc.addCell(rs.getString(3));
                        tc.addCell(rs.getString(4));
                        tc.addCell(rs.getString(5));
                    } while (rs.next());
                    doc.add(tc);
                }
                
                
            } catch (SQLException e) {
                System.err.println("Error al generar lista de clientes "+e);
            }
    
            JOptionPane.showMessageDialog(null, "PDF Obtenido");
            
        } catch (Exception e) {
            System.err.println("Error al generar pdf "+e);
            JOptionPane.showMessageDialog(null, "Error al generar pdf. Avise al ADM");
        }
    }//GEN-LAST:event_Boton_imprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Capturista().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Capturista.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Capturista.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_gestionarclientes;
    private javax.swing.JButton Boton_imprimir;
    private javax.swing.JButton Boton_registrarcliente;
    private javax.swing.JLabel Lab_nameuser;
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
