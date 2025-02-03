package org.employment;

import javax.swing.*;
import java.util.Objects;

public class PegawaiForm {

    private JTextField txtNama;
    private JTextField txtNikId;
    private JTextField txtTempatLahir;
    private JComboBox cmbJenisKelamin;
    private JTextField txtAlamat;
    private JComboBox cmbStatus;
    private JButton btnSimpan;

    public PegawaiForm() {
        initComponents();
        setupEventHandlers();
    }

    private void setupEventHandlers() {
        btnSimpan.addActionListener(e -> {
            try {
                Pegawai pegawai = new Pegawai(
                        txtNama.getText(),
                        txtNikId.getText(),
                        txtTempatLahir.getText(),
                        Objects.requireNonNull(cmbJenisKelamin.getSelectedItem()).toString(),
                        txtAlamat.getText(),
                        Objects.requireNonNull(cmbStatus.getSelectedItem()).toString()
                );

                DBUtil.insertPegawai(pegawai);
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
                clearForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error: " + ex.getMessage(),
                        "Database Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void clearForm() {
        txtNama.setText("");
        txtNikId.setText("");
        txtTempatLahir.setText("");
        cmbJenisKelamin.setText("");
        txtAlamat.setText("");
        cmbStatus.setText("");
    }
}