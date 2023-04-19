
package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.Calendar;
import clases.Conexion;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


public class Registro_eq extends javax.swing.JFrame {

    int ID_cliente_update=0;
    String user,nom_c;
    public Registro_eq() {
        initComponents();
        user=Login.user;
        ID_cliente_update=Gestionar_Clientes.IDcliente_update;
        Conexion cn = new Conexion();
        try {
            String sql="select nombre_cliente from clientes where"
                    + " id_cliente = \""+ID_cliente_update+"\";";
            ResultSet rs=cn.consulta(sql);
            if (rs.next()) {
                nom_c=rs.getString("nombre_cliente");
            }
        } catch (Exception e) {
            System.err.println("Error al consultar el nombre del cliente "+e);
            JOptionPane.showMessageDialog(null, "Error al consultar el nombre del cliente.Comuniquese con el Administrador");
        }
        
        setSize(630, 445);
        setResizable(false);
        setTitle("Registrar nuevo Equipo para "+nom_c);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();
        
        txt_namecliente.setText(nom_c);
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
        Lab_name1 = new javax.swing.JLabel();
        Lab_name2 = new javax.swing.JLabel();
        Lab_name3 = new javax.swing.JLabel();
        Lab_name4 = new javax.swing.JLabel();
        Lab_name5 = new javax.swing.JLabel();
        txt_namecliente = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_serie = new javax.swing.JTextField();
        cmb_tipo = new javax.swing.JComboBox<>();
        cmb_marca = new javax.swing.JComboBox<>();
        ScrollPane = new javax.swing.JScrollPane();
        txtpane_obsv = new javax.swing.JTextPane();
        But_Registrar = new javax.swing.JButton();
        footer = new javax.swing.JLabel();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LTIT.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        LTIT.setForeground(new java.awt.Color(255, 255, 255));
        LTIT.setText("Registro de Equipo");
        getContentPane().add(LTIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        Lab_name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name.setText("Nombre del Cliente:");
        getContentPane().add(Lab_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        Lab_name1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name1.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name1.setText("Tipo de equipo:");
        getContentPane().add(Lab_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        Lab_name2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name2.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name2.setText("Marca:");
        getContentPane().add(Lab_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        Lab_name3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name3.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name3.setText("Modelo:");
        getContentPane().add(Lab_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        Lab_name4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name4.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name4.setText("Numero de Serie:");
        getContentPane().add(Lab_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        Lab_name5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name5.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name5.setText("Daño Reportado/Observaciones");
        getContentPane().add(Lab_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        txt_namecliente.setBackground(new java.awt.Color(153, 153, 255));
        txt_namecliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_namecliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_namecliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_namecliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_namecliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_modelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_serie.setBackground(new java.awt.Color(153, 153, 255));
        txt_serie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_serie.setForeground(new java.awt.Color(255, 255, 255));
        txt_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_serie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        cmb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional" }));
        getContentPane().add(cmb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_marca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alenware", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo" }));
        getContentPane().add(cmb_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        ScrollPane.setViewportView(txtpane_obsv);

        getContentPane().add(ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 330, 230));

        But_Registrar.setBackground(new java.awt.Color(153, 153, 255));
        But_Registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        But_Registrar.setForeground(new java.awt.Color(255, 255, 255));
        But_Registrar.setText("Registrar Equipo");
        But_Registrar.setBorder(null);
        But_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(But_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 210, 35));

        footer.setForeground(new java.awt.Color(0, 0, 0));
        footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 390, -1, -1));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 445));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_RegistrarActionPerformed

        int validacion=0;
        String tipo_equipo,marca,modelo,n_serie,dia_i,mes_i,annio_i,status,obsv;
        Conexion cn=new Conexion();
        
        tipo_equipo=cmb_tipo.getSelectedItem().toString();
        marca=cmb_marca.getSelectedItem().toString();
        modelo=txt_modelo.getText().trim();
        n_serie=txt_serie.getText().trim();
        obsv=txtpane_obsv.getText();
        status="Nuevo Ingreso";
        
        Calendar calendar= Calendar.getInstance();
        dia_i=Integer.toString(calendar.get(Calendar.DATE));
        mes_i=Integer.toString(calendar.get(Calendar.MONTH)+1);
        annio_i=Integer.toString(calendar.get(Calendar.YEAR));
        
        System.out.println(dia_i+","+mes_i+","+annio_i);
        
        if(modelo.equals("")){
            txt_modelo.setBackground(Color.red);
            validacion++;
        }
        if(n_serie.equals("")){
            txt_serie.setBackground(Color.red);
            validacion++;
        }
        if(obsv.equals("")){
            txtpane_obsv.setText("Sin Observaciones.");
        }
        
        if (validacion==0) {
            try {
                String sql="INSERT INTO equipos(id_cliente,tipo_equipo,marca,modelo,num_serie,dia_i,mes_i,annio_i,observaciones,estatus,ultima_mod,comentarios_tecnicos,"
                        + "revision_tec_de) " + "VALUES(\"" + ID_cliente_update
                    + "\", \"" + tipo_equipo + "\",\"" + marca + "\",\"" + modelo + "\",\"" + n_serie + "\""
                        + ",\"" + dia_i + "\",\"" + mes_i + "\",\"" + annio_i + "\",\""+obsv+"\",\""+status+"\""
                        + ",\""+user+"\",\""+""+"\",\""+""+"\");";
                System.out.println(sql);
                
                cn.insertarModificarEliminar(sql);
                
                txt_namecliente.setBackground(Color.GREEN);
                txt_modelo.setBackground(Color.GREEN);
                txt_serie.setBackground(Color.GREEN);
                txtpane_obsv.setBackground(Color.GREEN);
                
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                this.dispose();
                
            } catch (SQLException e) {
                System.err.println("Error en registrar equipo "+e);
                JOptionPane.showMessageDialog(null,"Error en registrar equipo.Contacte al ADMIN.");
            } catch (Exception ex) {
                Logger.getLogger(Registro_eq.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes completar todos los campos.");
        }
                
    }//GEN-LAST:event_But_RegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(Registro_eq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_eq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_eq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_eq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_eq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton But_Registrar;
    private javax.swing.JLabel LTIT;
    private javax.swing.JLabel Lab_name;
    private javax.swing.JLabel Lab_name1;
    private javax.swing.JLabel Lab_name2;
    private javax.swing.JLabel Lab_name3;
    private javax.swing.JLabel Lab_name4;
    private javax.swing.JLabel Lab_name5;
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JComboBox<String> cmb_marca;
    private javax.swing.JComboBox<String> cmb_tipo;
    private javax.swing.JLabel footer;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_namecliente;
    private javax.swing.JTextField txt_serie;
    private javax.swing.JTextPane txtpane_obsv;
    // End of variables declaration//GEN-END:variables
}
