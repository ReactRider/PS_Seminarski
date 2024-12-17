/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;
import domain.*;
import controller.Controller;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import table_models.*;
/**
 *
 * @author Stefan
 */
public class PretraziVlasnikForm extends javax.swing.JDialog {

    /**
     * Creates new form PretraziVlasnikForm
     */
    
    public PretraziVlasnikForm(java.awt.Frame parent, boolean modal, String grad) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pretraga vlasnika");
        prepareGrad();
    }
    
    private void prepareGrad() {
        this.remove(lblID);
        this.remove(txtID);
        this.remove(lblIme);
        this.remove(txtIme);
        this.remove(lblPrezime);
        this.remove(txtPrezime);
        this.remove(lblGrad);
        this.remove(comboGrad);
        this.remove(btnPretraga);
        this.remove(jScrollPane1);
        this.remove(lblJMBG);
        this.remove(txtJMBG);
        
        ucitajGradove("lokacija");
        comboGrad1.addActionListener( e -> {
            if(comboGrad1.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Izaberite grad", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            this.add(jScrollPane1);
            tblVlasnici.setModel(new VlasnikTableModel(new Vlasnik((String)comboGrad1.getSelectedItem(), 0)));
        });
    }
    
    
    public PretraziVlasnikForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Pretraga vlasnika");
        prepare_search_jmbg();
    }
    
     private void prepare_search_jmbg() {
         txtID.setEnabled(false);
         txtIme.setEnabled(false);
         txtPrezime.setEnabled(false);
         comboGrad.setEnabled(false);
         lblPrebivaliste.setVisible(false);
         comboGrad1.setVisible(false);
         this.remove(jScrollPane1);
         
        btnPretraga.addActionListener(e-> {
            if(check_jmbg()) {
                Vlasnik vl = Controller.getInstance().pretraziVlasnik(new Vlasnik(txtJMBG.getText()));
                ucitajGradove("");
                
                if(vl == null) {
                    txtID.setText("");
                    txtIme.setText("");
                    txtPrezime.setText("");
                    comboGrad.setSelectedItem(null);
                    JOptionPane.showMessageDialog(this, "Ne postoji rezultat pretrage!", "Poruka", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                txtID.setText(vl.getId_vlasnik()+"");
                txtIme.setText(vl.getIme());
                txtPrezime.setText(vl.getPrezime());
                comboGrad.setSelectedItem(vl.getGrad());
            } else
                JOptionPane.showMessageDialog(this, "Neispravan JMBG", "Greska", JOptionPane.ERROR_MESSAGE);
            
        });
        
        
    }

    
     private boolean check_jmbg() {
        char[] chars = txtJMBG.getText().toCharArray();
        for(char c : chars){
            if(!Character.isDigit(c))
                return false;
        }
        
        if(txtJMBG.getText().length() != 13) 
            return false;
        
        return true;
    }
    
    private void ucitajGradove(String s) {
        ArrayList<String> gradovi = Controller.getInstance().ucitajGradove();
       
        if(s.equals("lokacija")) {
            for(String grad : gradovi)
                comboGrad1.addItem(grad);
            comboGrad1.setSelectedItem(null);
        } else {
            for(String grad : gradovi)
                comboGrad.addItem(grad);
            comboGrad.setSelectedItem(null);
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

        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        lblJMBG = new javax.swing.JLabel();
        lblGrad = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtJMBG = new javax.swing.JTextField();
        comboGrad = new javax.swing.JComboBox<>();
        btnPretraga = new javax.swing.JButton();
        lblPrebivaliste = new javax.swing.JLabel();
        comboGrad1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVlasnici = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Pretrazi Vlasnika");

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID.setText("ID");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblIme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIme.setText("Ime");

        lblPrezime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPrezime.setText("Prezime");

        lblJMBG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblJMBG.setText("JMBG");

        lblGrad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGrad.setText("Grad");

        txtIme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPrezime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtJMBG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        comboGrad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnPretraga.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnPretraga.setText("Pretrazi");

        lblPrebivaliste.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblPrebivaliste.setText("Grad / Prebivaliste:");

        comboGrad1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        tblVlasnici.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVlasnici);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(348, 367, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(298, 298, 298))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(btnPretraga))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblJMBG)
                            .addGap(42, 42, 42)
                            .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblID)
                                .addComponent(lblIme))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtID)
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPrezime)
                                .addComponent(lblGrad))
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrezime)
                                .addComponent(comboGrad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboGrad1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPrebivaliste)
                                .addGap(163, 163, 163))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(lblPrebivaliste)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblJMBG)
                            .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIme)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPrezime)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGrad)
                            .addComponent(comboGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPretraga)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboGrad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(84, Short.MAX_VALUE))))
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
            java.util.logging.Logger.getLogger(PretraziVlasnikForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretraziVlasnikForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretraziVlasnikForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretraziVlasnikForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PretraziVlasnikForm dialog = new PretraziVlasnikForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboGrad;
    private javax.swing.JComboBox<String> comboGrad1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGrad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblJMBG;
    private javax.swing.JLabel lblPrebivaliste;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JTable tblVlasnici;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables
}
