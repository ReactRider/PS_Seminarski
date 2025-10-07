/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;
import java.util.ArrayList;
import controller.Controller;
import domain.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class KreirajVlasnikForm extends javax.swing.JDialog {

    /**
     * Creates new form KreirajVlasnika
     */
    public KreirajVlasnikForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kreiraj vlasnika");
        prepareForInsert();
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
    
    public KreirajVlasnikForm(java.awt.Frame parent, boolean modal, Vlasnik v) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Promeni vlasnika");
        prepareForUpdate(v);
        
        btnPromeni.addActionListener(e -> {
            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            String grad = (String)comboGrad.getSelectedItem();
            
            if(ime.equals("") || prezime.equals("")) {
                JOptionPane.showMessageDialog(this, "Popunite sva polja", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            
            if(JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Potvrda", JOptionPane.YES_NO_OPTION) == 0) {
                if(Controller.getInstance().promeniVlasnik(new Vlasnik(Long.parseLong(txtID.getText()), ime, prezime, grad))) {
                    JOptionPane.showMessageDialog(null, "Vlasnik promenjen!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    new PromeniVlasnikForm(null, true).setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null, "Greska pri promeni vlasnika!", "Greska", JOptionPane.ERROR_MESSAGE);
            } 
               
        });
    }
    
    private void prepareForUpdate(Vlasnik v) {
        lblTitle.setText("Promeni Vlasnika");
        btnKreiraj.setVisible(false);
        
        lblID.setVisible(true);
        txtID.setVisible(true);
        txtID.setText(v.getId_vlasnik() + "");
        txtID.setEnabled(false);
        
        txtIme.setText(v.getIme());
        txtPrezime.setText(v.getPrezime());
        txtJMBG.setText(v.getJmbg());
        txtJMBG.setEnabled(false);
        
        ucitajGradove();
        comboGrad.setSelectedItem(v.getGrad());
        
    }
    
    private void ucitajGradove() {
            String[] gradovi = {"Beograd", "Novi Sad", "Nis"};
            for(String s : gradovi)
                comboGrad.addItem(s);
            
            comboGrad.setSelectedItem(null);
    }
    
    private void prepareForInsert() {
        btnPromeni.setVisible(false);
        
        lblID.setVisible(false);
        txtID.setVisible(false);
        ucitajGradove();
        
        btnKreiraj.addActionListener(e -> {
            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            String jmbg = txtJMBG.getText();
            String grad = (String)comboGrad.getSelectedItem();
            
            if(ime.equals("") || prezime.equals("") || jmbg.equals("") || grad == null) {
                JOptionPane.showMessageDialog(this, "Popunite sva polja", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(!check_jmbg()) {
                JOptionPane.showMessageDialog(this, "Neispravan JMBG!", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(Controller.getInstance().pretraziVlasnik(new Vlasnik(jmbg)) != null) {
                JOptionPane.showMessageDialog(this, "Vlasnik sa unetim JMBG-om vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Potvrda", JOptionPane.YES_NO_OPTION) != 0)
                return;
           
            if(Controller.getInstance().kreirajVlasnik(new Vlasnik(ime, prezime, jmbg, grad))) 
                JOptionPane.showMessageDialog(this, "Vlasnik kreiran.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Greska.", "Greska", JOptionPane.ERROR_MESSAGE);
            
            if(JOptionPane.showConfirmDialog(this, "Da li zelite uneti novog vlasnika?", "Potvrda", JOptionPane.YES_NO_OPTION) != 0)
                this.setVisible(false);
            else
                prepareForNewInsert();

        });
    }
    
    private void prepareForNewInsert() {
        txtIme.setText("");
        txtPrezime.setText("");
        txtJMBG.setText("");
        comboGrad.setSelectedItem(null);
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
        jLabel2 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtJMBG = new javax.swing.JTextField();
        btnKreiraj = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnPromeni = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblGrad = new javax.swing.JLabel();
        comboGrad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Ime ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Prezime");

        txtIme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPrezime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("JMBG");

        txtJMBG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtJMBG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJMBGFocusLost(evt);
            }
        });

        btnKreiraj.setText("Kreiraj Vlasnika");

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID.setText("ID");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnPromeni.setText("Promeni Vlasnika");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle.setText("Kreiraj Vlasnika");

        lblGrad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGrad.setText("Grad");

        comboGrad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(lblTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(37, 37, 37))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblID)
                                    .addGap(49, 49, 49)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtID)
                                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(30, 30, 30))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblGrad)
                                    .addGap(35, 35, 35)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrezime)
                                .addComponent(txtJMBG)
                                .addComponent(comboGrad, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(btnKreiraj)))
                    .addComponent(btnPromeni))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrad)
                    .addComponent(comboGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPromeni))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJMBGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJMBGFocusLost
   
    }//GEN-LAST:event_txtJMBGFocusLost

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
            java.util.logging.Logger.getLogger(KreirajVlasnikForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreirajVlasnikForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreirajVlasnikForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreirajVlasnikForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KreirajVlasnikForm dialog = new KreirajVlasnikForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<String> comboGrad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblGrad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables
}
