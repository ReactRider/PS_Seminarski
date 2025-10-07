/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;
import domain.*;
import controller.Controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import table_models.EvidencijeTableModel;

/**
 *
 * @author Stefan
 */
public class PretraziEvidencijaForm extends javax.swing.JDialog {

    /**
     * Creates new form PretraziEvidencijaForm
     */
    
    private void prepareGeneral() {
        this.remove(lblOpseg);
        this.remove(comboOpseg);
        this.remove(lblNazivKazne);
        this.remove(comboKazne);
        this.remove(lblPU);
        this.remove(comboPU);
        this.remove(lblRegOznaka);
        this.remove(txtRegOznaka);
        this.remove(btnPretraga);
        this.remove(jScrollPane1);
        this.remove(btnPromeni);
    }
    
    public PretraziEvidencijaForm(java.awt.Frame parent, boolean modal, String kriterijum, String filter) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        switch(kriterijum) {
            case "Evidencija Kazni":
                updateSearchEvidKazni(filter);
            break;
            
            case "Kazna":
                updateSearchKazna(filter);
            break;
            
            case "Policijska Uprava":
                updateSearchPU(filter);
            break;
            
            case "Vozilo":
                updateSearchVozilo(filter);
            break;
        }
    }
    
    private void updateSearchEvidKazni(String filter) {
        prepareGeneral();
        prepareSearchEvidKazni();
        comboOpseg.setSelectedItem(filter);
        int izbor = 0;
        switch(filter) {
            case "do 250.000RSD":
                izbor = 0;
            break;

            case "izmedju 250.000RSD i 500.000RSD":
                izbor = 1;
            break;

            case "preko 500.000RSD":
                izbor = 2;
            break;
        }
        tblEvidencije.setModel(new EvidencijeTableModel(new EvidencijaKazni(izbor)));
    }
    
    private void updateSearchKazna(String filter) {
        prepareGeneral();
        prepareSearchKazna();
        comboKazne.setSelectedItem(filter);
        tblEvidencije.setModel(new EvidencijeTableModel(new Kazna(filter)));
    }
    
    private void updateSearchPU(String filter) {
        prepareGeneral();
        prepareSearchPU();
        comboPU.setSelectedItem(filter);
        tblEvidencije.setModel(new EvidencijeTableModel(new PolicijskaUprava(filter)));
    }
    
    private void updateSearchVozilo(String filter) {
        prepareGeneral();
        prepareSearchVozilo();
        txtRegOznaka.setText(filter);
        this.add(jScrollPane1);
        tblEvidencije.setModel(new EvidencijeTableModel(new Vozilo(filter)));
    }
    
    public PretraziEvidencijaForm(java.awt.Frame parent, boolean modal, String kriterijum) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        prepareGeneral();
        
        switch(kriterijum) {
            case "Evidencija Kazni":
                prepareSearchEvidKazni();
            break;
            
            case "Kazna":
                prepareSearchKazna();
            break;
            
            case "Policijska Uprava":
                prepareSearchPU();
            break;
            
            case "Vozilo":
                prepareSearchVozilo();
            break;
        }
    }
    
    private void prepareSearchEvidKazni() {
        setTitle("Pretraga po kriterijumu evidencije kazni");
        this.add(lblOpseg);
        this.add(comboOpseg);
        ucitajOpsege();
        
        comboOpseg.addActionListener( e -> {
            String izbor_str = (String)comboOpseg.getSelectedItem();
            int izbor = 0;
            switch(izbor_str) {
                case "do 250.000RSD":
                    izbor = 0;
                break;
                
                case "izmedju 250.000RSD i 500.000RSD":
                    izbor = 1;
                break;
                
                case "preko 500.000RSD":
                    izbor = 2;
                break;
            }
            this.add(jScrollPane1);
            tblEvidencije.setModel(new EvidencijeTableModel(new EvidencijaKazni(izbor)));
        });        
        this.add(btnPromeni);
        prepareBtnPromeni();
    }
    
    private void prepareBtnPromeni() {
        btnPromeni.addActionListener( e -> {
            if(!jScrollPane1.isDisplayable()) {
                JOptionPane.showMessageDialog(this, "Izaberite kriterijum pretrage!", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                int selRow = tblEvidencije.getSelectedRow();
                TableModel tm = tblEvidencije.getModel();
                EvidencijeTableModel etm = (EvidencijeTableModel)tm;
                EvidencijaKazni evidencija = etm.get(selRow);
                this.setVisible(false);
                
                String kriterijum = "";
                String filter = "";
                
                if(comboOpseg.isDisplayable()) {
                    kriterijum = "Evidencija Kazni";
                    filter = (String)comboOpseg.getSelectedItem();
                } else if(comboKazne.isDisplayable()) {
                    kriterijum = "Kazna";
                    filter = (String)comboKazne.getSelectedItem();
                } else if(comboPU.isDisplayable()) {
                    kriterijum = "Policijska Uprava";
                    filter = (String)comboPU.getSelectedItem();
                } else if(txtRegOznaka.isDisplayable()) {
                    kriterijum = "Vozilo";
                    filter = txtRegOznaka.getText();
                }
                
                new KreirajEvidencijaForm(null, true, evidencija,kriterijum, filter).setVisible(true);
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Izaberite evidenciju kazne iz tabele!", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
        });
    }
    
    private void prepareSearchKazna() {
        setTitle("Pretraga po kriterijumu kazni");
        this.add(lblNazivKazne);
        this.add(comboKazne);
        ucitajNaziveKazni();
        
        comboKazne.addActionListener( e -> {
            this.add(jScrollPane1);
            tblEvidencije.setModel(new EvidencijeTableModel(new Kazna((String)comboKazne.getSelectedItem())));
        });
        this.add(btnPromeni);
        prepareBtnPromeni();
    }
        
    private void prepareSearchPU() {
        setTitle("Pretraga po kriterijumu policijske uprave");
        this.add(lblPU);
        this.add(comboPU);
        ucitajPU();
        
        comboPU.addActionListener( e -> {
            this.add(jScrollPane1);
            tblEvidencije.setModel(new EvidencijeTableModel(new PolicijskaUprava((String)comboPU.getSelectedItem())));
        });
        this.add(btnPromeni);
        prepareBtnPromeni();
    }
        
    private void prepareSearchVozilo() {
        setTitle("Pretraga po kriterijumu vozilo");
        
        this.add(lblRegOznaka);
        this.add(txtRegOznaka);
        this.add(btnPretraga);
        
        btnPretraga.addActionListener( e -> {
            if(!check_reg()) {
                JOptionPane.showMessageDialog(this, "Neispravan unos!", "Greska", JOptionPane.ERROR_MESSAGE);
                tblEvidencije.setModel(new EvidencijeTableModel());
                return;
            }
            this.add(jScrollPane1);
            tblEvidencije.setModel(new EvidencijeTableModel(new Vozilo(txtRegOznaka.getText())));

            if(tblEvidencije.getRowCount() == 0)
                JOptionPane.showMessageDialog(this, "Nema rezultata pretrage!", "Poruka", JOptionPane.INFORMATION_MESSAGE);
        });        
        this.add(btnPromeni);
        prepareBtnPromeni();
    }
    
    private void ucitajPU() {
        ArrayList<String> uprave = Controller.getInstance().ucitajPU();
        
        for(String uprava : uprave)
            comboPU.addItem(uprava);
        
        comboPU.setSelectedItem(null);
    }
    
    private void ucitajOpsege() {
        String[] elems = {"do 250.000RSD", "izmedju 250.000RSD i 500.000RSD", "preko 500.000RSD"};
        
        for(String elem : elems) 
            comboOpseg.addItem(elem);
        
        comboOpseg.setSelectedItem(null);
    }
    
    private void ucitajNaziveKazni() {
        ArrayList<String> nazivi = Controller.getInstance().ucitajKazne();
        
        for(String naziv : nazivi)
            comboKazne.addItem(naziv);
        
        comboKazne.setSelectedItem(null);
    }
    
    private boolean check_reg() {
        String[] elems = txtRegOznaka.getText().split("-");
        if(elems[0].length() != 2 || elems[2].length() != 2 || elems[1].length() < 3 || elems[1].length() > 5) 
            return false;

        char[] chars_1 = elems[0].toCharArray();
        for(char c : chars_1) {
            if(!Character.isLetter(c)) 
                return false;
        }

        char[] chars_2 = elems[1].toCharArray();
        for(char c : chars_2) {
            if(!Character.isDigit(c)) 
                return false;
        }
        
        char[] chars_3 = elems[2].toCharArray();
        for(char c : chars_3) {
            if(!Character.isLetter(c)) 
                return false;
        }
        
        return true;
    }
    
    public PretraziEvidencijaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pretrazi Evidenciju Kazni");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblOpseg = new javax.swing.JLabel();
        comboOpseg = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvidencije = new javax.swing.JTable();
        lblNazivKazne = new javax.swing.JLabel();
        comboKazne = new javax.swing.JComboBox<>();
        lblPU = new javax.swing.JLabel();
        comboPU = new javax.swing.JComboBox<>();
        lblRegOznaka = new javax.swing.JLabel();
        txtRegOznaka = new javax.swing.JTextField();
        btnPretraga = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblTitle.setText("Pretraga Evidencije Kazni");

        lblOpseg.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblOpseg.setText("Izaberi opseg ukupnog iznosa kazni:");

        comboOpseg.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        tblEvidencije.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tblEvidencije.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEvidencije.setRowHeight(30);
        jScrollPane1.setViewportView(tblEvidencije);

        lblNazivKazne.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblNazivKazne.setText("Izaberite kaznu:");

        comboKazne.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lblPU.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblPU.setText("Izaberite policijsku upravu:");

        comboPU.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        lblRegOznaka.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblRegOznaka.setText("Unesite registracionu oznaku vozila:");

        txtRegOznaka.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        btnPretraga.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnPretraga.setText("Pretraga");

        btnPromeni.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnPromeni.setText("Promeni");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblPU)
                                .addGap(18, 18, 18)
                                .addComponent(comboPU, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblRegOznaka)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRegOznaka, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(btnPretraga))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOpseg)
                                .addGap(41, 41, 41)
                                .addComponent(comboOpseg, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNazivKazne)
                                .addGap(41, 41, 41)
                                .addComponent(comboKazne, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPromeni)
                .addGap(376, 376, 376))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpseg)
                    .addComponent(comboOpseg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNazivKazne)
                    .addComponent(comboKazne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPU)
                    .addComponent(comboPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegOznaka)
                    .addComponent(txtRegOznaka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretraga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnPromeni)
                .addGap(16, 16, 16))
        );

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
            java.util.logging.Logger.getLogger(PretraziEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretraziEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretraziEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretraziEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PretraziEvidencijaForm dialog = new PretraziEvidencijaForm(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPretraga;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<String> comboKazne;
    private javax.swing.JComboBox<String> comboOpseg;
    private javax.swing.JComboBox<String> comboPU;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNazivKazne;
    private javax.swing.JLabel lblOpseg;
    private javax.swing.JLabel lblPU;
    private javax.swing.JLabel lblRegOznaka;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblEvidencije;
    private javax.swing.JTextField txtRegOznaka;
    // End of variables declaration//GEN-END:variables
}
