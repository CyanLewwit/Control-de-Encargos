
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
public class Gestionar_Eq extends javax.swing.JFrame {

    String user;
    public static int IDequipo_update;/*Permite enviar datos entre interfaces*/
    DefaultTableModel Model=new DefaultTableModel();
    
    public Gestionar_Eq() {
        initComponents();
        user=Login.user;
        setSize(630, 380);
        setResizable(false);
        setTitle("Equipos Registrados - Sesion de "+user);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();
        
        Conexion cn=new Conexion();
        
        try {
            String sql="select id_equipo, tipo_equipo, marca, estatus from equipos;";
            ResultSet rs=cn.consulta(sql);
            Tabla_eq = new JTable(Model);
            jScrollPane1.setViewportView(Tabla_eq);
            
            Model.addColumn("");
            Model.addColumn("Tipo");
            Model.addColumn("Marca");
            Model.addColumn("Estatus");
            
            while(rs.next()){
                Object[] fila=new Object[4];
                for (int i=0; i<4 ; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                Model.addRow(fila);
            }
            
            cn.desconectarBase();
            
        } catch (Exception e) {
            System.err.println("Error al llenar la Tabla "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la lista. Contacte al Administrador");
        }
        
       obtenerDatos(); 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_eq = new javax.swing.JTable();
        cmb_sta = new javax.swing.JComboBox<>();
        Mostrar = new javax.swing.JButton();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        footer.setForeground(new java.awt.Color(0, 0, 0));
        footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 320, -1, -1));

        Tabla_eq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla_eq);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        cmb_sta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo Ingreso", "No Reparado", "En Revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_sta, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, -1));

        Mostrar.setBackground(new java.awt.Color(153, 153, 255));
        Mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar.setText("Mostrar");
        Mostrar.setBorder(null);
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 210, 35));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed

        String seleccion = cmb_sta.getSelectedItem().toString();
        String sfl;
        Conexion cnn = new Conexion();

      Model.setRowCount(0);
      Model.setColumnCount(0);
      
        try {
            if (seleccion.equalsIgnoreCase("Todos")) {
                sfl="select id_equipo, tipo_equipo, marca, estatus from equipos;";
            } else {
                sfl="select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = \""+seleccion+"\";";
            }
            System.out.println(sfl);
            
            ResultSet rs = cnn.consulta(sfl);

            Tabla_eq = new JTable(Model);
            jScrollPane1.setViewportView(Tabla_eq);

            Model.addColumn("");
            Model.addColumn("Tipo");
            Model.addColumn("Marca");
            Model.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                Model.addRow(fila);
            }
            cnn.desconectarBase();

        } catch (SQLException e) {
            System.err.println("Error al recuperar registro de equipos");
        } catch (Exception ex) {
            Logger.getLogger(Gestionar_Eq.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      obtenerDatos();
    }//GEN-LAST:event_MostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Gestionar_Eq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Eq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Eq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestionar_Eq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestionar_Eq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JButton Mostrar;
    private javax.swing.JTable Tabla_eq;
    private javax.swing.JComboBox<String> cmb_sta;
    private javax.swing.JLabel footer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void obtenerDatos(){
    Tabla_eq.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point=Tabla_eq.rowAtPoint(e.getPoint());
                int colum_point=0;
                
                if (fila_point > -1) {
                    IDequipo_update = (int) Model.getValueAt(fila_point, colum_point);

                    try {
                        Info_equipoT eqt = new Info_equipoT();
                        eqt.setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(Gestionar_Eq.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }
                
            }
        });
    }
}
