
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


public class Graficar_Estatus extends javax.swing.JFrame {
    
    String user;
    int n_ing,no_rep,rep,entregado,enRev;
    
    String[] vector_estatus_name= new String[5];
    int[] vector_estatus_cantidad= new int[5];
    
    public Graficar_Estatus() throws Exception {
        initComponents();
        
        user=Login.user;
        setSize(550, 450);
        setResizable(false);
        setTitle("Tecnico - Sesion de "+user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();
        
        Conexion cn=new Conexion();
        
        try {
            String sql="select estatus, count(estatus) as Cantidad from equipos group by estatus;";
            ResultSet rs=cn.consulta(sql);
            
            if(rs.next()){
                int pos=0;
                
                do {                    
                    vector_estatus_name[pos]=rs.getString(1);
                    vector_estatus_cantidad[pos]=rs.getInt(2);
                    
                    if (vector_estatus_name[pos].equalsIgnoreCase("En Revision")) {
                        enRev=vector_estatus_cantidad[pos];
                    } else if (vector_estatus_name[pos].equalsIgnoreCase("Entregado")) {
                        entregado=vector_estatus_cantidad[pos];
                    } else if (vector_estatus_name[pos].equalsIgnoreCase("No Reparado")) {
                        no_rep=vector_estatus_cantidad[pos];
                    } else if (vector_estatus_name[pos].equalsIgnoreCase("Nuevo Ingreso")) {
                        n_ing=vector_estatus_cantidad[pos];
                    } else if (vector_estatus_name[pos].equalsIgnoreCase("Reparado")) {
                        rep=vector_estatus_cantidad[pos];
                    } 
                    
                    pos++;
                } while (rs.next());
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la BdD "+e);
            JOptionPane.showMessageDialog(null, "Error. Contacte al Administrador");
        }
        repaint();
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
        footer = new javax.swing.JLabel();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(getIconImages());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de Estatus");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        footer.setForeground(new java.awt.Color(0, 0, 0));
        footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Graficar_Estatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficar_Estatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficar_Estatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficar_Estatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Graficar_Estatus().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Graficar_Estatus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public int estatusMasRep(int nuevoIngreso,int noReparado,int enRev,int Reparado,int Entregado){
        if(nuevoIngreso>noReparado && nuevoIngreso>enRev && nuevoIngreso>Reparado && nuevoIngreso>Entregado){
            return nuevoIngreso;
        } else if(noReparado>enRev && noReparado>Reparado && noReparado>Entregado){
            return noReparado;
        } else if(enRev>Reparado && enRev>Entregado){
            return enRev;
        } else if(Reparado>Entregado){
            return Reparado;
        } else{
            return Entregado;
        }
    }
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int MasRep=estatusMasRep(n_ing, no_rep, enRev, rep, entregado);
        
        int largo_newIngreso=n_ing * 400 /MasRep;
        int largo_noReparado=no_rep * 400 /MasRep;
        int largo_enRevision=enRev * 400 /MasRep;
        int largo_Reparado=rep * 400 /MasRep;
        int largo_ent=entregado * 400 /MasRep;
        
        
        g.setColor(new Color(240,248,0));/*Amarillo*/
        g.fillRect(100, 100, largo_newIngreso, 40);
        g.drawString("Nuevo Ingreso", 10, 118);
        g.drawString("Cantidad:"+n_ing, 10, 133);
        
        g.setColor(new Color(255,0,0));/*Rojo*/
        g.fillRect(100, 150, largo_noReparado, 40);
        g.drawString("No Reparado", 10, 168);
        g.drawString("Cantidad:"+no_rep, 10, 183);
        
        g.setColor(new Color(0,0,0));/*Negro*/
        g.fillRect(100, 200, largo_enRevision, 40);
        g.drawString("En Revision", 10, 218);
        g.drawString("Cantidad:"+enRev, 10, 233);
        
        g.setColor(new Color(255,255,255));/*Blanco*/
        g.fillRect(100, 250, largo_Reparado, 40);
        g.drawString("Reparado", 10, 268);
        g.drawString("Cantidad:"+rep, 10, 283);
        
        g.setColor(new Color(0,85,0));/*Verde*/
        g.fillRect(100, 300, largo_ent, 40);
        g.drawString("Entregado", 10, 318);
        g.drawString("Cantidad:"+entregado, 10, 333);
    }

}
