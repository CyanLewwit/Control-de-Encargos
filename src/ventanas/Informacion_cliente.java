
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import sun.security.krb5.internal.Krb5;
import static ventanas.Gestionar_Clientes.IDcliente_update;

public class Informacion_cliente extends javax.swing.JFrame {
    String user;
    int IDcliente_update=0;
    public static int ID_eq=0;
    DefaultTableModel Model=new DefaultTableModel();
    
    public Informacion_cliente() {
        initComponents();
        user=Login.user;
        IDcliente_update=Gestionar_Clientes.IDcliente_update;
        setSize(630, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(Lab_wall.getWidth(), Lab_wall.getHeight(), Image.SCALE_DEFAULT));
        Lab_wall.setIcon(icono);
        this.repaint();
        
        Conexion cn=new Conexion();
        try {
            String sql="select * from clientes where id_cliente = \""+IDcliente_update+"\";";
            ResultSet rs = cn.consulta(sql);
            if(rs.next()){
                setTitle("Informacion del cliente "+rs.getString("nombre_cliente")+" - Sesion de "+user);
                LTIT.setText("Informacion del cliente "+rs.getString("nombre_cliente"));
                
                txt_name.setText(rs.getString("nombre_cliente"));
                txt_mail.setText(rs.getString("email_cliente"));
                txt_tt.setText(rs.getString("tel_cliente"));
                txt_dir.setText(rs.getString("dir_cliente"));
                txt_ultimamod.setText(rs.getString("ultima_mod"));
            }
            cn.desconectarBase();
            
            
        } catch (Exception e) {
            System.err.println("Error al obtener la info del cliente "+e);
            JOptionPane.showMessageDialog(null, "Error en obtener la info del cliente. Comuniquese con el Administrador");
        }
        
        try {
            String sql2="select  id_equipo, tipo_equipo,marca,estatus from equipos where id_cliente = \""+IDcliente_update+"\";";
            ResultSet rs=cn.consulta(sql2);
            
            Tabla_equipos=new JTable(Model);
            Scroll.setViewportView(Tabla_equipos);
            
            Model.addColumn("Id equipo");
            Model.addColumn("Tipo de equipo");
            Model.addColumn("Marca");
            Model.addColumn("estatus");
            
            while(rs.next()){
                Object[]fila=new Object[4];
                for(int i=0; i<4;i++){
                    fila[i]=rs.getObject(i+1);
                }
                Model.addRow(fila);
            }
            cn.desconectarBase();
        } catch (Exception e) {
            System.err.println("Error al llenar la tabla equipo "+e);
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla equipo. Comuniquese con el Administrador");
        }
        Tabla_equipos.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point=Tabla_equipos.rowAtPoint(e.getPoint());
                int colum_point=0;
                
                if(fila_point>-1){
                    ID_eq=(int)Model.getValueAt(fila_point, colum_point);
                    Info_equipo infoeq = null;
                    try {
                        infoeq = new Info_equipo();
                    } catch (Exception ex) {
                        Logger.getLogger(Informacion_cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    infoeq.setVisible(true);
                } 
            }
        });
    }

     @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logtitle.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Scroll = new javax.swing.JScrollPane();
        Tabla_equipos = new javax.swing.JTable();
        LTIT = new javax.swing.JLabel();
        footer = new javax.swing.JLabel();
        Lab_name = new javax.swing.JLabel();
        Lab_name1 = new javax.swing.JLabel();
        Lab_name2 = new javax.swing.JLabel();
        Lab_name3 = new javax.swing.JLabel();
        Lab_name4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_tt = new javax.swing.JTextField();
        txt_dir = new javax.swing.JTextField();
        txt_ultimamod = new javax.swing.JTextField();
        But_Registrar = new javax.swing.JButton();
        But_Actualizar = new javax.swing.JButton();
        Boton_imprimirReporte = new javax.swing.JButton();
        Lab_wall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla_equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        Scroll.setViewportView(Tabla_equipos);

        getContentPane().add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        LTIT.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        LTIT.setForeground(new java.awt.Color(255, 255, 255));
        LTIT.setText("Información del Cliente");
        getContentPane().add(LTIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        footer.setForeground(new java.awt.Color(0, 0, 0));
        footer.setText("Creado por Cyan Lewwit");
        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 390, -1, -1));

        Lab_name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name.setText("Nombre:");
        getContentPane().add(Lab_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        Lab_name1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name1.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name1.setText("Em@il:");
        getContentPane().add(Lab_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        Lab_name2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name2.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name2.setText("Telefono:");
        getContentPane().add(Lab_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        Lab_name3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name3.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name3.setText("Direccion:");
        getContentPane().add(Lab_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        Lab_name4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Lab_name4.setForeground(new java.awt.Color(255, 255, 255));
        Lab_name4.setText("Ultima Modificacion por:");
        getContentPane().add(Lab_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txt_name.setBackground(new java.awt.Color(153, 153, 255));
        txt_name.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_tt.setBackground(new java.awt.Color(153, 153, 255));
        txt_tt.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_tt.setForeground(new java.awt.Color(255, 255, 255));
        txt_tt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_tt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_dir.setBackground(new java.awt.Color(153, 153, 255));
        txt_dir.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_dir.setForeground(new java.awt.Color(255, 255, 255));
        txt_dir.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        txt_ultimamod.setBackground(new java.awt.Color(153, 153, 255));
        txt_ultimamod.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultimamod.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimamod.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultimamod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultimamod.setEnabled(false);
        getContentPane().add(txt_ultimamod, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, -1));

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
        getContentPane().add(But_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 210, 35));

        But_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        But_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        But_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        But_Actualizar.setText("Actualizar Cliente");
        But_Actualizar.setBorder(null);
        But_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                But_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(But_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 210, 35));

        Boton_imprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        Boton_imprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_imprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_imprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 120, 100));
        getContentPane().add(Lab_wall, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void But_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_RegistrarActionPerformed
      Registro_eq r=new Registro_eq();
      r.setVisible(true);
    }//GEN-LAST:event_But_RegistrarActionPerformed

    private void But_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_But_ActualizarActionPerformed

        int validacion=0;
        String name,mail,tt,dir,regex;
        Conexion cn=new Conexion();
        
        regex="(\\W|^)[\\w.\\-]{0,25}@(yahoo|hotmail|gmail)\\.com";
        name=txt_name.getText().trim();
        mail=txt_mail.getText().trim();
        tt=txt_tt.getText().trim();
        dir=txt_dir.getText().trim();
        Pattern patt=Pattern.compile(regex);
        Matcher mat=patt. matcher(mail);
        
        if(mail.equals("") || mat.find()==false){
            validacion++;
            txt_mail.setBackground(Color.red);
            JOptionPane.showMessageDialog(null,"Error en el mail"); 
        }
        if(name.equals("")){
            txt_name.setBackground(Color.red);
            validacion++;
        }
        if(dir.equals("")){
            txt_dir.setBackground(Color.red);
            validacion++;
        }
        if(tt.equals("")){
            txt_tt.setBackground(Color.red);
            validacion++;
        }
        
        if (validacion==0) {
            try {
               String sql="update clientes set nombre_cliente = \""+name+"\", email_cliente = \""+
                                mail+"\", tel_cliente = \""+tt+"\", dir_cliente = \""+dir+"\", ultima_mod = \""+
                                user+"\" where id_cliente = \""+IDcliente_update+"\" ;";
               cn.insertarModificarEliminar(sql);
               
                
                
                
                Limpiar();
                
                txt_name.setBackground(Color.GREEN);
                txt_tt.setBackground(Color.GREEN);
                txt_dir.setBackground(Color.GREEN);
                txt_mail.setBackground(Color.GREEN);
                txt_ultimamod.setText(user);
                
                
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa!!!");
                this.dispose();
            } catch (SQLException e) {
                System.err.println("Error al Actualizar cliente.");
                JOptionPane.showMessageDialog(null, "Error al Actualizar cliente.Contacte con el Administrador");
            } catch (Exception ex) {
                Logger.getLogger(Informacion_cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_But_ActualizarActionPerformed

    private void Boton_imprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_imprimirReporteActionPerformed
        // TODO add your handling code here:
        Document docum=new Document();
        Conexion cn=new Conexion();
        try {
            String ruta=System.getProperty("user.home");
            PdfWriter.getInstance(docum,new FileOutputStream(ruta+"/Desktop/"+txt_name.getText().trim()+".pdf"));/*Ruta guardar archico*/
            
            /*Poner un header en el PDF*/
            com.itextpdf.text.Image header=com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            /*Agregar contenido al PDF, en este caso Parrafos*/
            Paragraph parrafo=new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Informacion del Cliente. \n \n");
            parrafo.setFont(FontFactory.getFont("Tahoma",14,Font.BOLD,BaseColor.DARK_GRAY)); /*Propiedades texto*/ 
            
            docum.open();
            docum.add(header);
            docum.add(parrafo);
            
            /*Crear Tabla*/
            PdfPTable tc=new PdfPTable(5);
            tc.addCell("ID");
            tc.addCell("Nombre");
            tc.addCell("Email");
            tc.addCell("Telefono");
            tc.addCell("Direccion");
            
            try {
                String sql="select* from clientes where id_cliente = \""+IDcliente_update+"\";";
                ResultSet rs=cn.consulta(sql);
                
                if (rs.next()) {
                    do {                        
                        tc.addCell(rs.getString(1));
                        tc.addCell(rs.getString(2));
                        tc.addCell(rs.getString(3));
                        tc.addCell(rs.getString(4));
                        tc.addCell(rs.getString(5));
                    } while (rs.next());
                    docum.add(tc);
                }
                
                Paragraph parr2 = new Paragraph();
                parr2.setAlignment(Paragraph.ALIGN_CENTER);
                parr2.add("\n \n Equipos Registrados. \n \n");
                parr2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
                cn.desconectarBase();
                docum.add(parr2);
                
                PdfPTable te = new PdfPTable(4);
                te.addCell("ID");
                te.addCell("Tipo");
                te.addCell("Marca");
                te.addCell("Estatus");
                
                try {
                    String sqlh="select id_equipo,tipo_equipo,marca,estatus from equipos where id_cliente = \""+IDcliente_update+"\";";
                    ResultSet r=cn.consulta(sqlh);
                    if(r.next()){
                        do {                            
                            te.addCell(r.getString(1));
                            te.addCell(r.getString(2));
                            te.addCell(r.getString(3));
                            te.addCell(r.getString(4));
                        } while (r.next());
                        docum.add(te);
                    }
                } catch (Exception e) {
                    System.err.println("Error al Cargar equipos "+e);
                }

            } catch (SQLException e) {
                System.err.println("Error al llenar tabla pdf "+e);
            } catch (Exception ex) {
                Logger.getLogger(Informacion_cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "PDF obtenido");
        } catch (DocumentException |IOException e) {
            System.err.println("Error al Obtener el PDF "+e);
            JOptionPane.showMessageDialog(null, "Error al obtener el PDF.Contacte al Administrador");
        }
        
        
    }//GEN-LAST:event_Boton_imprimirReporteActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_imprimirReporte;
    private javax.swing.JButton But_Actualizar;
    private javax.swing.JButton But_Registrar;
    private javax.swing.JLabel LTIT;
    private javax.swing.JLabel Lab_name;
    private javax.swing.JLabel Lab_name1;
    private javax.swing.JLabel Lab_name2;
    private javax.swing.JLabel Lab_name3;
    private javax.swing.JLabel Lab_name4;
    private javax.swing.JLabel Lab_wall;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JTable Tabla_equipos;
    private javax.swing.JLabel footer;
    private javax.swing.JTextField txt_dir;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_tt;
    private javax.swing.JTextField txt_ultimamod;
    // End of variables declaration//GEN-END:variables

    public void Limpiar(){
    txt_name.setText("");
    txt_dir.setText("");
    txt_tt.setText("");
    txt_mail.setText("");
}


}
