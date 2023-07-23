
package vista;

import controlador.DAO.CategoriaDAO;
import controlador.DAO.ExamenDAO;
import controlador.DAO.LaboratorioDAO;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import modelo.Categoria;
import modelo.Examen;
import modelo.tabla.ExamenTabla;
import vista.utilidades.UtilidadesVista;

public class Frm_Examenes extends javax.swing.JFrame {

    ExamenDAO examenDAO = new ExamenDAO();
    CategoriaDAO categoriaDAO = new CategoriaDAO();
    LaboratorioDAO laboratorioDAO = new LaboratorioDAO();

    ExamenTabla me = new ExamenTabla();

    public Frm_Examenes() {
        initComponents();
        setTitle("EXAMENES");
        setLocationRelativeTo(null);
        cargarDatosCategoria();
        cargarTabla();
        bloquear();
        bloquearbotones();
        cargarDatosLaboratorio();
    }

    public void cargarTabla() {
        me.setListaExamenes(examenDAO.TodosExam());
        tbl_exam.setModel(me);
        tbl_exam.updateUI();
    }

    public void cargarDatosCategoria() {
        cbx_cat.removeAllItems();
        UtilidadesVista.cargarCbx(cbx_cat, categoriaDAO.TodasCat());
    }

    public void cargarDatosLaboratorio() {
        cbx_lab.removeAllItems();
        UtilidadesVista.cargarCbx(cbx_lab, (List) laboratorioDAO.laboratoriosPorEstado("ACTIVO"));

    }

    public void limpiar() {
        txt_nombre.setText("");
        txt_unidad_medida.setText("");

    }

    public void bloquearbotones() {
        btn_guardar.setEnabled(false);
        btn_cancelar.setEnabled(false);
    }

    public void desbloquearbotones() {
        btn_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);
    }

    public void bloquear() {
        txt_nombre.setEnabled(false);
        txt_unidad_medida.setEnabled(false);

        cbx_cat.setEnabled(false);
        cbx_lab.setEnabled(false);

    }

    public void desbloquear() {
        txt_nombre.setEnabled(true);
        txt_unidad_medida.setEnabled(true);

        cbx_cat.setEnabled(true);
        cbx_lab.setEnabled(true);
    }

    public boolean validarNombreCategoria() {
        examenDAO.setExam(null);
        boolean aux = true;
        for (int i = 0; i < examenDAO.contadorExam(); i++) {
            if (txt_nombre.getText().equalsIgnoreCase(String.valueOf(examenDAO.encontrarExam((Examen) examenDAO.TodosExam().get(i)).getNombre()))) {
                aux = false;
                JOptionPane.showMessageDialog(this, "El nombre del examen no se puede repetir", "", ERROR_MESSAGE);
            }
        }
        return aux;
    }

    public boolean validarNombreCategoriaEditar() {
        examenDAO.setExam(null);
        boolean aux = true;
        for (int i = 0; i < examenDAO.contadorExam(); i++) {
            if (i == tbl_exam.getSelectedRow()) {

            } else if (txt_nombre.getText().equalsIgnoreCase(String.valueOf(examenDAO.encontrarExam((Examen) examenDAO.TodosExam().get(i)).getNombre()))) {
                aux = false;
                JOptionPane.showMessageDialog(this, "El nombre del examen no se puede repetir", "", ERROR_MESSAGE);
            }
        }
        return aux;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelExamen = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_unidad_medida = new javax.swing.JTextField();
        cbx_cat = new javax.swing.JComboBox<>();
        cbx_lab = new javax.swing.JComboBox<>();
        btn_cancelar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_exam = new javax.swing.JTable();
        btn_nuevo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelExamen.setBackground(new java.awt.Color(153, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombre:");

        jLabel2.setText("Categoria:");

        jLabel3.setText("Laboratorio:");

        jLabel4.setText("Unidad de Medida:");

        cbx_cat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbx_lab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_guardar.setText("GUARDAR");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(cbx_cat, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(cbx_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(txt_unidad_medida, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(cbx_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cbx_lab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_guardar))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txt_unidad_medida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_exam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Categoria", "Laboratorio", "Unidad de Medida"
            }
        ));
        tbl_exam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_examMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_exam);

        btn_nuevo.setText("NUEVO");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });

        btn_editar.setText("EDITAR");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_nuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_editar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelExamenLayout = new javax.swing.GroupLayout(PanelExamen);
        PanelExamen.setLayout(PanelExamenLayout);
        PanelExamenLayout.setHorizontalGroup(
            PanelExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelExamenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelExamenLayout.setVerticalGroup(
            PanelExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelExamenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(PanelExamen, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        desbloquear();
        desbloquearbotones();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        int fila = tbl_exam.getSelectedRow();
        if (fila != -1) {

            if (!txt_nombre.getText().equals("") && !txt_unidad_medida.getText().equals("")) {
                if (validarNombreCategoriaEditar()) {
                    examenDAO.setExam(null);
                    examenDAO.setExam((Examen) examenDAO.TodosExam().get(fila));
                    examenDAO.setExam(examenDAO.encontrarExam(examenDAO.getExam()));

                    Long id = examenDAO.getExam().getId_examen();

                    examenDAO.getExam().setId_examen(id);
                    examenDAO.getExam().setNombre(txt_nombre.getText());
                    //Se agrega Categoria
                    categoriaDAO.setCat(null);
                    categoriaDAO.setCat((Categoria) categoriaDAO.TodasCat().get(cbx_cat.getSelectedIndex()));
                    examenDAO.getExam().setCategoria(categoriaDAO.getCat());
                    //Se agrega Laboratorio
                    laboratorioDAO.setLaboratorio(null);
                    laboratorioDAO.setLaboratorio(laboratorioDAO.laboratoriosPorEstado("activo").get(cbx_lab.getSelectedIndex()));
                    examenDAO.getExam().setLaboratorio(laboratorioDAO.getLaboratorio());
                    examenDAO.getExam().setUnidad_medida(txt_unidad_medida.getText());
                    examenDAO.setExam(examenDAO.getExam());
                    if (examenDAO.editarExam(examenDAO.getExam())) {
                        cargarTabla();
                        limpiar();
                        bloquear();
                        bloquearbotones();
                        tbl_exam.removeRowSelectionInterval(0, tbl_exam.getRowCount() - 1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error, el examen no se pudo editar", "Editar", ERROR_MESSAGE);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Por Favor, llene todos los campos", "Editar", WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "debe seleccionar una fila de la tabla", "Editar", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        bloquear();
        bloquearbotones();
        limpiar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if (!txt_nombre.getText().equals("") && !txt_unidad_medida.getText().equals("")) {
            if (validarNombreCategoria()) {
                examenDAO.setExam(null);
                examenDAO.getExam().setNombre(txt_nombre.getText());
//Se agrega Categoria
                categoriaDAO.setCat(null);
                categoriaDAO.setCat((Categoria) categoriaDAO.TodasCat().get(cbx_cat.getSelectedIndex()));
                examenDAO.getExam().setCategoria(categoriaDAO.getCat());
//Se agrega Laboratorio
                laboratorioDAO.setLaboratorio(null);
                laboratorioDAO.setLaboratorio(laboratorioDAO.laboratoriosPorEstado("activo").get(cbx_lab.getSelectedIndex()));
                examenDAO.getExam().setLaboratorio(laboratorioDAO.getLaboratorio());

                examenDAO.getExam().setUnidad_medida(txt_unidad_medida.getText());
                examenDAO.setExam(examenDAO.getExam());
                if (examenDAO.agregarExam(examenDAO.getExam())) {
                    JOptionPane.showMessageDialog(null, "Examen guardado con exito!", "Guardar", INFORMATION_MESSAGE);
                    cargarTabla();
                    limpiar();
                    bloquear();
                    bloquearbotones();
                } else {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error, el examen no se pudo ingresar", "Guardar", ERROR_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por Favor, llene todos los campos", "Guardar", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void tbl_examMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_examMouseClicked
        int fila = tbl_exam.getSelectedRow();
        desbloquear();
        String nombre = String.valueOf(tbl_exam.getValueAt(fila, 0));
        String cat = String.valueOf(tbl_exam.getValueAt(fila, 1));
        String lab = String.valueOf(tbl_exam.getValueAt(fila, 2));
        String um = String.valueOf(tbl_exam.getValueAt(fila, 3));
        txt_nombre.setText(nombre);
        txt_unidad_medida.setText(um);

        categoriaDAO.setCat(null);
        laboratorioDAO.setLaboratorio(null);
        for (int i = 0; i < categoriaDAO.contadorCat(); i++) {

            if (cat.equalsIgnoreCase(String.valueOf(categoriaDAO.encontrarCat((Categoria) categoriaDAO.TodasCat().get(i)).getNombre_cat()))) {
                cbx_cat.setSelectedIndex(i);
            }
        }

        for (int i = 0; i < laboratorioDAO.contadorLab(); i++) {
            if (lab.equalsIgnoreCase(String.valueOf(laboratorioDAO.laboratoriosPorEstado("activo").get(i).getNombre_lab()))) {
                cbx_lab.setSelectedIndex(i);
            }
        }
    }//GEN-LAST:event_tbl_examMouseClicked

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
            java.util.logging.Logger.getLogger(Frm_Examenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Examenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Examenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Examenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Examenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel PanelExamen;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JComboBox<String> cbx_cat;
    private javax.swing.JComboBox<String> cbx_lab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_exam;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_unidad_medida;
    // End of variables declaration//GEN-END:variables
}