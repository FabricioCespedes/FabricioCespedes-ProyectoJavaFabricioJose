/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.*;
import LogicaNegocios.CronogramaBLO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josea
 */
public class frmBuscarCronogramas extends javax.swing.JDialog {
    DefaultTableModel model;
    EPrograma programa;
    EModuloCronograma cronograma;
    EModulo modulo;
    List<EModuloCronograma> listaMC; 

    public List<EModuloCronograma> getListaMC() {
        return listaMC;
    }
    /**
     * Creates new form frmBuscarCronogramas
     */
    public frmBuscarCronogramas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            limpiarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnBuscarPrograma = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnFiltar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnSel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBuscarPrograma.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnBuscarPrograma.setText("Seleccionar programa");
        btnBuscarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProgramaActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtNombre.setEnabled(false);

        txtCodigo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtCodigo.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnBuscarPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(600, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPrograma)
                    .addComponent(jLabel3))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnFiltar.setText("Filtrar");
        btnFiltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnSel.setText("Selecionar Cronograma");
        btnSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(btnFiltar, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176)
                .addComponent(btnSel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProgramaActionPerformed
        frmBuscarProgramas vistaBuscarProgramas = new frmBuscarProgramas(null, true);
        vistaBuscarProgramas.setLocationRelativeTo(this);

        vistaBuscarProgramas.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent wE) {
                try {
                    programa = vistaBuscarProgramas.getPrograma();
                    if (programa != null) {
                        txtNombre.setText(programa.getNombrePrograma());
                        txtCodigo.setText(programa.getCodigo());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }

        });
        vistaBuscarProgramas.setVisible(true);
    }//GEN-LAST:event_btnBuscarProgramaActionPerformed

    private void btnFiltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltarActionPerformed
        CronogramaBLO crono = new CronogramaBLO();
        if(!txtCodigo.getText().equals("")){
            try{
             llenarTabla("p.codigo ='"+txtCodigo.getText()+"'");   
            }catch (Exception e){
                
            }
        }
    }//GEN-LAST:event_btnFiltarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelActionPerformed
        if (jTable1.getRowCount() !=0) {
           this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccione un programa primero");
        }
    }//GEN-LAST:event_btnSelActionPerformed

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
            java.util.logging.Logger.getLogger(frmBuscarCronogramas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCronogramas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCronogramas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBuscarCronogramas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmBuscarCronogramas dialog = new frmBuscarCronogramas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void llenarTabla(String condition) throws Exception {
               
        CronogramaBLO cronogramaBL = new CronogramaBLO();
        Object[] row = new Object[15];

        limpiarTabla();

        try {
            listaMC = cronogramaBL.listar(condition);
            for (EModuloCronograma mc : listaMC) {
                mc.setProfesor((ArrayList<EProfesor>) cronogramaBL.listar(mc,""));
                row[0] = mc.getFechaInicio();
                row[1] = mc.getFechaFin();
                row[2] = mc.getHorasDia();
                row[3] = mc.getHoraInicio();
                row[4] = mc.getHoraFin();
                row[5] = mc.getEstado();
                row[6] = mc.getModulo().getCodigo();
                row[7] = mc.getModulo().getNombreModulo();
                row[8] = mc.getModulo().getHorasTotales();
                row[9] = mc.getPrograma().getCodigo();
                row[10] = mc.getPrograma().getNombrePrograma();
                row[11] = mc.getPrograma().getHorasDia();
                row[12] = mc.getPrograma().getHorasInicio();
                row[13] = mc.getPrograma().getHorasFin();
                row[14] = mc.getPrograma().getEstado();
                model.addRow(row);
            }
        } catch (Exception e) {
            throw e;
        }
    }
        
     private void limpiarTabla() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Fecha Inicio");
        model.addColumn("Fecha fin");
        model.addColumn("Horas Dia");
        model.addColumn("Hora Inicio");
        model.addColumn("Hora Fin");
        model.addColumn("Estado");
        model.addColumn("Codigo Módulo");
        model.addColumn("Nombre Módulo");
        model.addColumn("HorasTotales Módulo");
        model.addColumn("Codigo Programa");
        model.addColumn("Nombre Programa");
        model.addColumn("Horas Dia Programa");
        model.addColumn("Hora Inicio Programa");
        model.addColumn("Hora Fin");
        model.addColumn("Estado");
        jTable1.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPrograma;
    private javax.swing.JButton btnFiltar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
