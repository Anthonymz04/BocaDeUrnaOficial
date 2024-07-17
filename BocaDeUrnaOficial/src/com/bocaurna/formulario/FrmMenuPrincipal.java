package com.bocaurna.formulario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private FrmCandidatos frmCandidatos;
    private FrmBocaUrna frmBocaUrna;
    private FrmResultadosProvincia frmResultadosProvincia;
    private FrmResultadosCanton frmResultadosCanton;

    public FrmMenuPrincipal() {
        setTitle("Sistema de Boca de Urna");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 562, 433);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnArchivo = new JMenu("Archivo");
        menuBar.add(mnArchivo);

        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnArchivo.add(mntmSalir);

        JMenu mnCandidatos = new JMenu("Candidatos");
        menuBar.add(mnCandidatos);

        JMenuItem mntmPrefectos = new JMenuItem("Prefectos");
        mntmPrefectos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmCandidatos == null || !frmCandidatos.isShowing()) {
                    frmCandidatos = new FrmCandidatos();
                    frmCandidatos.setVisible(true);
                }
            }
        });
        mnCandidatos.add(mntmPrefectos);

        JMenu mnProceso = new JMenu("Proceso");
        menuBar.add(mnProceso);

        JMenuItem mntmBocaUrna = new JMenuItem("Boca de urna");
        mntmBocaUrna.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmBocaUrna == null || !frmBocaUrna.isShowing()) {
                    frmBocaUrna = new FrmBocaUrna();
                    frmBocaUrna.setVisible(true);
                }
            }
        });
        mnProceso.add(mntmBocaUrna);

        JMenu mnReportes = new JMenu("Reportes");
        menuBar.add(mnReportes);

        JMenuItem mntmResultadosProvincia = new JMenuItem("Resultados por provincia");
        mntmResultadosProvincia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmResultadosProvincia == null || !frmResultadosProvincia.isShowing()) {
                    frmResultadosProvincia = new FrmResultadosProvincia();
                    frmResultadosProvincia.setVisible(true);
                }
            }
        });
        mnReportes.add(mntmResultadosProvincia);

        JMenuItem mntmResultadosCanton = new JMenuItem("Resultados por cantón o ciudad");
        mntmResultadosCanton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmResultadosCanton == null || !frmResultadosCanton.isShowing()) {
                    frmResultadosCanton = new FrmResultadosCanton();
                    frmResultadosCanton.setVisible(true);
                }
            }
        });
        mnReportes.add(mntmResultadosCanton);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmMenuPrincipal frame = new FrmMenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
