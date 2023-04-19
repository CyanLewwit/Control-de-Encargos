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

public class Graficar_Marcas extends javax.swing.JFrame {

    String user;
    int acer, alenware, apple, asus, brother, dell, hp, lenovo;

    String[] vector_marcas_name = new String[8];
    int[] vector_marcas_cantidad = new int[8];

    public Graficar_Marcas() throws Exception {
        initComponents();

        user = Login.user;
        setSize(550, 450);
        setResizable(false);
        setTitle("Tecnico - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();

        Conexion cn = new Conexion();

        try {
            String sql = "select marca, count(marca) as Marcas from equipos group by marca;";
            ResultSet rs = cn.consulta(sql);

            if (rs.next()) {
                int pos = 0;
                do {
                    vector_marcas_name[pos] = rs.getString(1);
                    vector_marcas_cantidad[pos] = rs.getInt(2);

                    if (vector_marcas_name[pos].equalsIgnoreCase("Acer")) {
                        acer = vector_marcas_cantidad[pos];
                    } else if (vector_marcas_name[pos].equalsIgnoreCase("Alenware")) {
                        alenware = vector_marcas_cantidad[pos];
                    } else if (vector_marcas_name[pos].equalsIgnoreCase("Apple")) {
                        apple = vector_marcas_cantidad[pos];
                    } else if (vector_marcas_name[pos].equalsIgnoreCase("Asus")) {
                        asus = vector_marcas_cantidad[pos];
                    } else if (vector_marcas_name[pos].equalsIgnoreCase("Brother")) {
                        brother = vector_marcas_cantidad[pos];
                    } else if (vector_marcas_name[pos].equalsIgnoreCase("Dell")) {
                        dell = vector_marcas_cantidad[pos];
                    } else if (vector_marcas_name[pos].equalsIgnoreCase("Lenovo")) {
                        lenovo = vector_marcas_cantidad[pos];
                    } else if (vector_marcas_name[pos].equalsIgnoreCase("HP")) {
                        hp = vector_marcas_cantidad[pos];
                    }
                    pos++;
                } while (rs.next());
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta " + e);
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
        jLabel1.setText("Grafica de Marcas");
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
            java.util.logging.Logger.getLogger(Graficar_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficar_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficar_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficar_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Graficar_Marcas().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Graficar_Marcas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int total_marcas = acer + hp + lenovo + brother + apple + alenware + asus + dell;

        int grados_acer = acer * 360 / total_marcas;
        int grados_hp = hp * 360 / total_marcas;
        int grados_lenovo = lenovo * 360 / total_marcas;
        int grados_brother = brother * 360 / total_marcas;
        int grados_dell = dell * 360 / total_marcas;
        int grados_apple = apple * 360 / total_marcas;
        int grados_alenware = alenware * 360 / total_marcas;
        int grados_asus = asus * 360 / total_marcas;

        /*Arcos*/
        g.setColor(new Color(175, 122, 197));/*Morado*/
        g.fillArc(25, 100, 270, 270, 0, grados_acer);
        g.fillRect(310, 120, 20, 20);
        g.drawString(acer + " de Acer", 340, 135);

        g.setColor(new Color(0, 255, 0));/*Verde*/
        g.fillArc(25, 100, 270, 270, grados_acer, grados_alenware);
        g.fillRect(310, 150, 20, 20);
        g.drawString(alenware + " de Alenware", 340, 165);

        g.setColor(new Color(0, 255, 255));/*Verde Agua*/
        g.fillArc(25, 100, 270, 270, grados_alenware + grados_acer, grados_apple);
        g.fillRect(310, 180, 20, 20);
        g.drawString(apple + " de Apple", 340, 195);

        g.setColor(new Color(55, 0, 255));/*Azul*/
        g.fillArc(25, 100, 270, 270, grados_alenware + grados_acer + grados_apple, grados_asus);
        g.fillRect(310, 210, 20, 20);
        g.drawString(asus + " de Asus", 340, 225);

        g.setColor(new Color(255, 255, 255));/*Blanco*/
        g.fillArc(25, 100, 270, 270, grados_alenware + grados_acer + grados_apple + grados_asus, grados_brother);
        g.fillRect(310, 240, 20, 20);
        g.drawString(brother + " de Brother", 340, 255);

        g.setColor(new Color(247, 220, 111));/*Amarillo*/
        g.fillArc(25, 100, 270, 270, grados_alenware + grados_acer + grados_apple + grados_asus + grados_brother, grados_dell);
        g.fillRect(310, 270, 20, 20);
        g.drawString(dell + " de Dell", 340, 285);

        g.setColor(new Color(21, 42, 160));/*Azul Marino*/
        g.fillArc(25, 100, 270, 270, grados_alenware + grados_acer + grados_apple + grados_asus + grados_brother + grados_dell, grados_hp);
        g.fillRect(310, 300, 20, 20);
        g.drawString(hp + " de HP", 340, 315);

        g.setColor(new Color(215, 96, 0));/*Naranja*/
        g.fillArc(25, 100, 270, 270, grados_alenware + grados_acer + grados_apple + grados_asus + grados_brother + grados_dell + grados_hp, grados_lenovo);
        g.fillRect(310, 330, 20, 20);
        g.drawString(lenovo + " de Lenovo", 340, 345);
    }

}
