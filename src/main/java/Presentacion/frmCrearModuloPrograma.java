/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.EModulo;
import Entidades.EModuloCronograma;
import Entidades.EProfesor;
import LogicaNegocios.CronogramaBLO;
import static Presentacion.frmCrearCronograma.listaModulosParalela;
import static Presentacion.frmCrearCronograma.listaModulosProgramas;
import static Presentacion.frmCrearCronograma.simultaneo;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class frmCrearModuloPrograma extends javax.swing.JDialog {

    EModuloCronograma moduloCronograma = new EModuloCronograma();

    public EModuloCronograma getModuloCronograma() {
        return moduloCronograma;
    }
    EModulo modulo;
    EProfesor profesor;
    boolean actualizar = false;
    boolean borrar = false;
    int index = 0;
    boolean addModSimultaneo = false;

    public boolean isBorrar() {
        return borrar;
    }

    /**
     * Creates new form frmCrearModuloPrograma
     */
    public frmCrearModuloPrograma(Frame parent, boolean modal, EModuloCronograma moduloCronogramaUpdate, int index, boolean addSimultaneo) {
        super(parent, modal);
        initComponents();
        if (moduloCronogramaUpdate != null) {
            actualizar = true;
            moduloCronograma = moduloCronogramaUpdate;
            actualizarCampos();
        }
        this.index = index;
        this.addModSimultaneo = addSimultaneo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnProfesor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdP = new javax.swing.JTextField();
        txtNomP = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnModulo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombreM = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtHoraI1 = new javax.swing.JSpinner();
        txtHoraI2 = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 70), new java.awt.Dimension(0, 70), new java.awt.Dimension(32767, 70));
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtHoraF1 = new javax.swing.JSpinner();
        txtHoraF2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        btnAddMod = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSimultaneo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnProfesor.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnProfesor.setText("Seleccionar profesor");
        btnProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Identificación");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

        txtIdP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtIdP.setEnabled(false);

        txtNomP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtNomP.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtIdP, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNomP, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProfesor)
                    .addComponent(jLabel1)
                    .addComponent(txtIdP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnModulo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnModulo.setText("Seleccionar modulo");
        btnModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModuloActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Codigo");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");

        txtCodigo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtCodigo.setEnabled(false);

        txtNombreM.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtNombreM.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModulo)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("Hora de inicio");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText(":");

        txtHoraI1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtHoraI1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        txtHoraI2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtHoraI2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "30" }));
        txtHoraI2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHoraI1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtHoraI2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtHoraI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraI2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtHoraI1, txtHoraI2});

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Estado");

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setText(":");

        txtHoraF1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtHoraF1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        txtHoraF2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtHoraF2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "30" }));
        txtHoraF2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtHoraF1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoraF2, 0, 60, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoraF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtHoraF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtHoraF1, txtHoraF2});

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel10.setText("Hora de fin");

        txtEstado.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Terminado", " " }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10))
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAddMod.setBackground(new java.awt.Color(255, 255, 204));
        btnAddMod.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAddMod.setText("Añadir modulo");
        btnAddMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddModActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 204));
        btnEliminar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSimultaneo.setBackground(new java.awt.Color(255, 255, 204));
        btnSimultaneo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSimultaneo.setText("Añadir modulo simultaneo");
        btnSimultaneo.setEnabled(false);
        btnSimultaneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimultaneoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(344, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(btnSimultaneo)
                .addGap(66, 66, 66)
                .addComponent(btnAddMod, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(935, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMod, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimultaneo))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddMod, btnEliminar, btnSimultaneo, jButton2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesorActionPerformed
        frmBuscarProfesores vistaBuscarProfesores = new frmBuscarProfesores(null, true);
        vistaBuscarProfesores.setLocationRelativeTo(this);
        vistaBuscarProfesores.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent wE) {
                try {
                    profesor = vistaBuscarProfesores.getProfesor();
                    if (profesor != null) {
                        txtNomP.setText(profesor.getNombre() + " " + profesor.getApellido1() + " " + profesor.getApellido2());
                        txtIdP.setText(String.valueOf(profesor.getIdPersona()));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }

        });
        vistaBuscarProfesores.setVisible(true);
    }//GEN-LAST:event_btnProfesorActionPerformed

    private void btnModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModuloActionPerformed
        frmBuscarModulos vistaBuscarModulos = new frmBuscarModulos(null, true);
        vistaBuscarModulos.setLocationRelativeTo(this);
        vistaBuscarModulos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent wE) {
                try {
                    modulo = vistaBuscarModulos.getModulo();
                    if (modulo != null) {
                        txtNombreM.setText(modulo.getNombreModulo());
                        txtCodigo.setText(String.valueOf(modulo.getCodigo()));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }

        });
        vistaBuscarModulos.setVisible(true);    }//GEN-LAST:event_btnModuloActionPerformed

    private void btnAddModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddModActionPerformed
        try {

            if (addModSimultaneo) {
                CronogramaBLO cronogramaBL = new CronogramaBLO();
                double horasTotales = cronogramaBL.obtenerHorasDia(String.valueOf(txtHoraI1.getValue()) + ":" + String.valueOf(txtHoraI2.getSelectedItem()), String.valueOf(txtHoraF1.getValue()) + ":" + String.valueOf(txtHoraF2.getSelectedItem()));
                horasTotales += cronogramaBL.obtenerHorasDia(listaModulosProgramas.get(index).getHoraInicio(), listaModulosProgramas.get(index).getHoraFin());
                if (horasTotales > 6) {
                    JOptionPane.showMessageDialog(this, "Los modulos que esta queriendo sincronizar dan mas de 6 horas al dia", "Error", HEIGHT);
                } else {
                    String[] hora = listaModulosProgramas.get(index).getHoraFin().split(":");
                    if (Integer.parseInt(hora[0]) <= (int) txtHoraI1.getValue()) {
                        if (modulo != null && profesor != null) {
                            moduloCronograma.setModulo(modulo);
                            profesor.getCentro().setNombre("");
                            profesor.getCentro().setUbicacion("");
                            moduloCronograma.agregarProfesor(profesor);
                            moduloCronograma.setHoraInicio(String.valueOf(txtHoraI1.getValue()) + ":" + String.valueOf(txtHoraI2.getSelectedItem()));
                            moduloCronograma.setHoraFin(String.valueOf(txtHoraF1.getValue()) + ":" + String.valueOf(txtHoraF2.getSelectedItem()));
                            moduloCronograma.setEstado(txtEstado.getSelectedItem().toString());
                            if (listaModulosProgramas.get(index).getModulo().getIdModulo() == moduloCronograma.getModulo().getIdModulo()) {
                                JOptionPane.showMessageDialog(this, "Esta queriendo sincronizar el mismo curso", "Error", HEIGHT);
                            } else {
                                if (listaModulosProgramas.get(index).getModulo().getIdModulo() == moduloCronograma.getModulo().getModuloRequerido().getIdModulo()) {
                                    JOptionPane.showMessageDialog(this, "El curso 1 que quiere sincronizar es requisito del curso 2", "Error", HEIGHT);
                                } else {
                                    if (listaModulosProgramas.get(index).getModulo().getModuloRequerido().getIdModulo() == moduloCronograma.getModulo().getIdModulo()) {
                                        JOptionPane.showMessageDialog(this, "El curso 2 que quiere sincronizar es requisito del curso 1", "Error", HEIGHT);
                                    } else {
                                        listaModulosParalela.set(index, moduloCronograma);
                                        
                                        JOptionPane.showMessageDialog(null, "Ha agregado un modulo simultaneo con exito");
                                        simultaneo = false;
                                        this.dispose();
                                    }
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Las horas de los cursos chocan", "Error", HEIGHT);
                    }

                }
            } else {
                if (modulo != null && profesor != null) {
                    moduloCronograma.setModulo(modulo);
                    profesor.getCentro().setNombre("");
                    profesor.getCentro().setUbicacion("");
                    moduloCronograma.agregarProfesor(profesor);
                    moduloCronograma.setHoraInicio(String.valueOf(txtHoraI1.getValue()) + ":" + String.valueOf(txtHoraI2.getSelectedItem()));
                    moduloCronograma.setHoraFin(String.valueOf(txtHoraF1.getValue()) + ":" + String.valueOf(txtHoraF2.getSelectedItem()));
                    moduloCronograma.setEstado(txtEstado.getSelectedItem().toString());
                    this.dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAddModActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        borrar = true;
        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSimultaneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimultaneoActionPerformed
        try {
            if (listaModulosParalela.get(index).getModulo().getIdModulo() == listaModulosProgramas.get(index).getModulo().getIdModulo()) {
                frmCrearModuloPrograma vistaAddModulo = new frmCrearModuloPrograma(null, true, null, index, true);
                vistaAddModulo.setLocationRelativeTo(this);
                vistaAddModulo.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent wE) {
                        try {
                            btnSimultaneo.setEnabled(false);
                            simultaneo = false;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                        }
                    }
                });
                vistaAddModulo.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Error, ese curso ya tiene un curso simultaneo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnSimultaneoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frmCrearModuloPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCrearModuloPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCrearModuloPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCrearModuloPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCrearModuloPrograma dialog = new frmCrearModuloPrograma(new javax.swing.JFrame(), true, null, 0, true);
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

    private boolean compararHoras(String inicio, String fin) {
        boolean banderaHoras = false;
        String[] hora = inicio.split(":");
        int horaInicio = Integer.parseInt(hora[0]);
        int minutoInicio = Integer.parseInt(hora[1]);
        hora = fin.split(":");
        int horaFin = Integer.parseInt(hora[0]);
        int minutoFin = Integer.parseInt(hora[1]);
        double resultado = 0;

        if (horaInicio < horaFin) {
            banderaHoras = true;
        } else if (horaInicio == horaFin && minutoInicio < minutoFin) {
            banderaHoras = true;
        }

        if (banderaHoras == true) {
            if (horaFin - horaInicio < 6) {
                return true;
            }
        }

        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMod;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModulo;
    private javax.swing.JButton btnProfesor;
    private javax.swing.JButton btnSimultaneo;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JComboBox<String> txtEstado;
    private javax.swing.JSpinner txtHoraF1;
    private javax.swing.JComboBox<String> txtHoraF2;
    private javax.swing.JSpinner txtHoraI1;
    private javax.swing.JComboBox<String> txtHoraI2;
    private javax.swing.JTextField txtIdP;
    private javax.swing.JTextField txtNomP;
    private javax.swing.JTextField txtNombreM;
    // End of variables declaration//GEN-END:variables

    private void actualizarCampos() {
        txtNomP.setText(moduloCronograma.getProfesor().get(0).getNombre() + " " + moduloCronograma.getProfesor().get(0).getApellido1() + " " + moduloCronograma.getProfesor().get(0).getApellido2());
        txtIdP.setText(String.valueOf(moduloCronograma.getProfesor().get(0).getIdPersona()));
        txtNombreM.setText(moduloCronograma.getModulo().getNombreModulo());
        txtCodigo.setText(String.valueOf(moduloCronograma.getModulo().getCodigo()));
        profesor = moduloCronograma.getProfesor().get(0);
        modulo = moduloCronograma.getModulo();
        if ("Activo".equals(moduloCronograma.getEstado())) {
            txtEstado.setSelectedIndex(0);
        } else {
            txtEstado.setSelectedIndex(1);
        }
        String[] hora = moduloCronograma.getHoraInicio().split(":");
        txtHoraI1.setValue(Integer.parseInt(hora[0]));
        if (Integer.parseInt(hora[1]) == 00) {
            txtHoraI2.setSelectedIndex(0);
        } else {
            txtHoraI2.setSelectedIndex(1);
        }

        hora = moduloCronograma.getHoraFin().split(":");
        txtHoraF1.setValue(Integer.parseInt(hora[0]));
        if (Integer.parseInt(hora[1]) == 00) {
            txtHoraF2.setSelectedIndex(0);
        } else {
            txtHoraF2.setSelectedIndex(1);
        }
        btnSimultaneo.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
}
