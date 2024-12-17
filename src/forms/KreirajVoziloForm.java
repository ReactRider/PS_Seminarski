/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import controller.Controller;
import domain.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class KreirajVoziloForm extends javax.swing.JDialog {

    /**
     * Creates new form KreirajVoziloForm
     */
    public KreirajVoziloForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kreiraj vozilo");
        prepareForInsert();
    }
    
    public KreirajVoziloForm(java.awt.Frame parent, boolean modal, Vozilo v) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Promeni vozilo");
        prepareForUpdate(v);
        
        btnPromeni.addActionListener(e -> {
            if(JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Potvrda", JOptionPane.YES_NO_OPTION) == 0) {
                if(Controller.getInstance().promeniVozilo(new Vozilo(Long.parseLong(txtID.getText()), (Vlasnik)comboVlasnici.getSelectedItem()))) {
                    JOptionPane.showMessageDialog(null, "Vozilo promenjeno!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    new PromeniVoziloForm(null, true).setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null, "Greska pri promeni vozila!", "Greska", JOptionPane.ERROR_MESSAGE);
            } 
               
        });
    }
    
    private void prepareForUpdate(Vozilo v) {
        lblTitle.setText("Promeni Vozilo");
        ucitajVlasnike();
        comboVlasnici.setSelectedItem(v.getVlasnik());
        
        btnKreiraj.setVisible(false);
        
        lblID.setVisible(true);
        txtID.setVisible(true);
        txtID.setText(v.getId_vozilo()+ "");
        txtID.setEnabled(false);
        
        txtMarka.setText(v.getMarka());
        txtMarka.setEnabled(false);
        txtModel.setText(v.getModel());
        txtModel.setEnabled(false);
        txtRegistracija.setText(v.getReg_oznaka());
        txtRegistracija.setEnabled(false);
      
    }
    
    private void ucitajVlasnike() {
       ArrayList<Vlasnik> vlasnici = Controller.getInstance().vratiListuSviVlasnik();
       for(Vlasnik v : vlasnici) 
           comboVlasnici.addItem(v);
       comboVlasnici.setSelectedItem(null);
    }
    
    private void prepareForInsert() {
        lblTitle.setText("Kreiraj Vozilo"); 
        ucitajVlasnike();
        
        btnPromeni.setVisible(false);
        
        lblID.setVisible(false);
        txtID.setVisible(false);
        
        btnKreiraj.addActionListener(e -> {
            if(!check_reg()) {
                JOptionPane.showMessageDialog(this, "Neispravna registraciona oznaka", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Potvrda", JOptionPane.YES_NO_OPTION) != 0)
                return;
            
            String marka = txtMarka.getText();
            String model = txtModel.getText();
            String reg_oznaka = txtRegistracija.getText();
            
            if(marka.equals("") || model.equals("") || reg_oznaka.equals("") || comboVlasnici.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Popunite sva polja", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            
            if(Controller.getInstance().pretraziVozilo(new Vozilo(reg_oznaka)) != null) {
                JOptionPane.showMessageDialog(this, "Vozilo sa unetom registracionom oznakom vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(Controller.getInstance().kreirajVozilo(new Vozilo(reg_oznaka, marka, model, (Vlasnik) comboVlasnici.getSelectedItem()))) 
                JOptionPane.showMessageDialog(this, "Vozilo kreirano.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Greska.", "Greska", JOptionPane.ERROR_MESSAGE);
            
            if(JOptionPane.showConfirmDialog(this, "Da li zelite uneti novo vozilo?", "Potvrda", JOptionPane.YES_NO_OPTION) != 0)
                this.setVisible(false);
            else
                prepareForNewInsert();

        });
    }
    
    private void prepareForNewInsert() {
        txtMarka.setText("");
        txtModel.setText("");
        txtRegistracija.setText("");
        comboVlasnici.setSelectedItem(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMarka = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblRegistracija = new javax.swing.JLabel();
        btnKreiraj = new javax.swing.JButton();
        btnPromeni = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblVlasnik = new javax.swing.JLabel();
        comboVlasnici = new javax.swing.JComboBox<>();
        txtRegistracija = new javax.swing.JTextField();
        txtMarka = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMarka.setText("Marka");

        jLabel1.setText("Model");

        lblRegistracija.setText("Registraciona Oznaka");

        btnKreiraj.setText("Kreiraj vozilo");

        btnPromeni.setText("Promeni vozilo");

        lblID.setText("ID");

        lblVlasnik.setText("Vlasnik");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle.setText("Kreiraj Vozilo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVlasnik)
                        .addGap(27, 27, 27)
                        .addComponent(comboVlasnici, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKreiraj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPromeni))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(lblMarka))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblID)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMarka)
                            .addComponent(txtModel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRegistracija)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRegistracija)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarka)
                    .addComponent(txtMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistracija)
                    .addComponent(txtRegistracija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVlasnik)
                    .addComponent(comboVlasnici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPromeni))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private boolean check_reg() {
        String[] elems = txtRegistracija.getText().split("-");
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
            java.util.logging.Logger.getLogger(KreirajVoziloForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreirajVoziloForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreirajVoziloForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreirajVoziloForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KreirajVoziloForm dialog = new KreirajVoziloForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<Vlasnik> comboVlasnici;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMarka;
    private javax.swing.JLabel lblRegistracija;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVlasnik;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMarka;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtRegistracija;
    // End of variables declaration//GEN-END:variables
}
