/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import controller.Controller;
import domain.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class KreirajPUForm extends javax.swing.JDialog {

    /**
     * Creates new form KreirajPUForm
     */
    public KreirajPUForm(java.awt.Frame parent, boolean modal, PolicijskaUprava pu) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Promeni Policijsku Upravu");
        prepareForUpdate(pu);
        
        btnPromeni.addActionListener( e -> {
            String username = txtUsername.getText();
            char[] pass_chars = txtPassword.getPassword();
            String password = "";
            for(char c : pass_chars) 
                password += c;
            String grad = (String)comboGrad.getSelectedItem();
            String opstina = (String)comboOpstina.getSelectedItem();
            String adresa = txtAdresa.getText();
            // Ako se nista ne promeni
            if(username.equals(pu.getUsername()) && password.equals(pu.getPassword()) && adresa.equals(pu.getAdresa())) {
                JOptionPane.showMessageDialog(this, "Unesite nove, izmenjene podatke", "Poruka", JOptionPane.INFORMATION_MESSAGE);
                return;
            }  
            // Ako se promeni samo username
            if(!username.equals(pu.getUsername()) && adresa.equals(pu.getAdresa())) {
                if(Controller.getInstance().puusernameok(username)) {
                    if(Controller.getInstance().promeniPolicijskaUprava(new PolicijskaUprava(Long.parseLong(txtID.getText()), username, password, grad, opstina, adresa))) {
                        JOptionPane.showMessageDialog(this, "Policijska uprava promenjena!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                        new PromeniPUForm(null, true).setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(this, "Greska pri promeni policijske uprave!", "Greska", JOptionPane.ERROR_MESSAGE);
                        
                } else
                    JOptionPane.showMessageDialog(this, "Policijska uprava sa datim nazivom vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
            } 
            
            // Ako se promeni samo adresa
            if(username.equals(pu.getUsername()) && !adresa.equals(pu.getAdresa()) ) {
                if(Controller.getInstance().puadresaok(adresa, grad)) {
                    if(Controller.getInstance().promeniPolicijskaUprava(new PolicijskaUprava(Long.parseLong(txtID.getText()), username, password, grad, opstina, adresa))) {
                        JOptionPane.showMessageDialog(this, "Policijska uprava promenjena!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                        new PromeniPUForm(null, true).setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(this, "Greska pri promeni policijske uprave!", "Greska", JOptionPane.ERROR_MESSAGE);
                        
                } else
                    JOptionPane.showMessageDialog(this, "Policijska uprava sa datom adresom vec postoji u istom gradu!", "Greska", JOptionPane.ERROR_MESSAGE);
            } 
            
            //Ako se promeni samo lozinka
            if(username.equals(pu.getUsername()) && adresa.equals(pu.getAdresa()) && !password.equals(pu.getPassword()) ) {
                if(password.length() >= 8) {
                    if(Controller.getInstance().promeniPolicijskaUprava(new PolicijskaUprava(Long.parseLong(txtID.getText()), username, password, grad, opstina, adresa))) {
                        JOptionPane.showMessageDialog(this, "Policijska uprava promenjena!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                        new PromeniPUForm(null, true).setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(this, "Greska pri promeni policijske uprave!", "Greska", JOptionPane.ERROR_MESSAGE);
                        
                } else
                    JOptionPane.showMessageDialog(this, "Lozinka mora biti minimum duzine 8 karaktera!", "Greska", JOptionPane.ERROR_MESSAGE);
            }
            
            // Ako se promene username i adresa, a ne lozinka
            if(!username.equals(pu.getUsername()) && !adresa.equals(pu.getAdresa()) && password.equals(pu.getPassword()) ) {
                if(Controller.getInstance().puusernameok(username) && Controller.getInstance().puadresaok(adresa, grad)) {
                    if(Controller.getInstance().promeniPolicijskaUprava(new PolicijskaUprava(Long.parseLong(txtID.getText()), username, password, grad, opstina, adresa))) {
                        JOptionPane.showMessageDialog(this, "Policijska uprava promenjena!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                        new PromeniPUForm(null, true).setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(this, "Greska pri promeni policijske uprave!", "Greska", JOptionPane.ERROR_MESSAGE);
                        
                } else
                    JOptionPane.showMessageDialog(this, "Policijska uprava sa unetim nazivom ili adresom vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
            }
            
            // Ako se promene username i lozinka, a ne adresa
            if(!username.equals(pu.getUsername()) && adresa.equals(pu.getAdresa()) && !password.equals(pu.getPassword()) ) {
                if(Controller.getInstance().puusernameok(username) && password.length() >= 8) {
                    if(Controller.getInstance().promeniPolicijskaUprava(new PolicijskaUprava(Long.parseLong(txtID.getText()), username, password, grad, opstina, adresa))) {
                        JOptionPane.showMessageDialog(this, "Policijska uprava promenjena!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                        new PromeniPUForm(null, true).setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(this, "Greska pri promeni policijske uprave!", "Greska", JOptionPane.ERROR_MESSAGE);
                        
                } else
                    JOptionPane.showMessageDialog(this, "Policijska uprava sa unetim nazivom vec postoji ili prekratka lozinka!", "Greska", JOptionPane.ERROR_MESSAGE);
            }
            
            
            // Ako se promene password i adresa, a ne username
            if(username.equals(pu.getUsername()) && !adresa.equals(pu.getAdresa()) && !password.equals(pu.getPassword()) ) {
                if(Controller.getInstance().puadresaok(adresa, grad) && password.length() >= 8) {
                    if(Controller.getInstance().promeniPolicijskaUprava(new PolicijskaUprava(Long.parseLong(txtID.getText()), username, password, grad, opstina, adresa))) {
                        JOptionPane.showMessageDialog(this, "Policijska uprava promenjena!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                        new PromeniPUForm(null, true).setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(this, "Greska pri promeni policijske uprave!", "Greska", JOptionPane.ERROR_MESSAGE);
                        
                } else
                    JOptionPane.showMessageDialog(this, "Policijska uprava sa unetom adresom u istom gradu vec postoji ili prekratka lozinka!", "Greska", JOptionPane.ERROR_MESSAGE);
            }
            
            //Ako se promene username, adresa i password
            if(!username.equals(pu.getUsername()) && !adresa.equals(pu.getAdresa()) && !password.equals(pu.getPassword()) ) {
                if(Controller.getInstance().puusernameok(username) && Controller.getInstance().puadresaok(adresa, grad) && password.length() >= 8) {
                    if(Controller.getInstance().promeniPolicijskaUprava(new PolicijskaUprava(Long.parseLong(txtID.getText()), username, password, grad, opstina, adresa))) {
                        JOptionPane.showMessageDialog(this, "Policijska uprava promenjena!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                        this.setVisible(false);
                        new PromeniPUForm(null, true).setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(this, "Greska pri promeni policijske uprave!", "Greska", JOptionPane.ERROR_MESSAGE);
                        
                } else
                    JOptionPane.showMessageDialog(this, "Policijska uprava sa unetim nazivom ili adresom vec postoji ili prekratka lozinka!", "Greska", JOptionPane.ERROR_MESSAGE);
            }
                    
            
            
        });
    }
    
    private void prepareForUpdate(PolicijskaUprava pu) {
        lblID.setVisible(true);
        txtID.setVisible(true);
        txtID.setText(pu.getId() + "");
        txtID.setEnabled(false);
        txtUsername.setText(pu.getUsername());
        txtPassword.setText(pu.getPassword());
        ucitajGradove();
        comboGrad.setSelectedItem(pu.getGrad());
        comboGrad.setEnabled(false);
        ucitajOpstine(pu.getGrad());
        comboOpstina.setSelectedItem(pu.getOpstina());
        comboOpstina.setEnabled(false);
        txtAdresa.setText(pu.getAdresa());
        btnKreiraj.setVisible(false);
    }
    
    public KreirajPUForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kreiraj Policijsku Upravu");
        
        ucitajGradove();
        lblID.setVisible(false);
        txtID.setVisible(false);
        btnPromeni.setVisible(false);
        
        comboGrad.addActionListener( e -> {
            ucitajOpstine((String) comboGrad.getSelectedItem());
        });
        
        btnKreiraj.addActionListener( e-> {
                String username = txtUsername.getText();
                char[] pass_chars = txtPassword.getPassword();
                String password = "";
                
                for(char c : pass_chars)
                    password += c;
                
                String grad = (String) comboGrad.getSelectedItem();
                String opstina = (String) comboOpstina.getSelectedItem();
                String adresa = txtAdresa.getText();
            
                if(checkFields(username, password, grad, opstina, adresa)) {
                    if(JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Potvrda", JOptionPane.YES_NO_OPTION) == 0) {
                        if(!Controller.getInstance().daLiPostojiPU(new PolicijskaUprava(username, password, grad, opstina, adresa))) {
                            if(Controller.getInstance().kreirajPolicijskaUprava(new PolicijskaUprava(username, password, grad, opstina, adresa))) {
                                JOptionPane.showMessageDialog(this, "Policijska uprava sacuvana!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);

                                if(JOptionPane.showConfirmDialog(this, "Novi unos?", "Potvrda", JOptionPane.YES_NO_OPTION) == 0) {
                                    prepareForNewInsert();
                                } else 
                                    this.setVisible(false);
                            } else 
                                JOptionPane.showMessageDialog(this, "Policijska uprava nije sacuvana!", "Greska", JOptionPane.ERROR_MESSAGE);
                        } else 
                            JOptionPane.showMessageDialog(this, "Policijska uprava sa unetim podacima vec postoji", "Greska", JOptionPane.ERROR_MESSAGE);
                    
                    } 
                } else
                    JOptionPane.showMessageDialog(this, "Neispravni podaci!", "Greska", JOptionPane.ERROR_MESSAGE);
            });

        }
    
        private void prepareForNewInsert() {
            txtUsername.setText("");
            txtPassword.setText("");
            comboGrad.setSelectedItem(null);
            comboOpstina.setSelectedItem(null);
            txtAdresa.setText("");
        }

        private boolean checkFields(String username, String password, String grad, String opstina, String adresa) {
            
            if(username.equals("") || password.equals("") || grad == null || opstina == null || adresa.equals(""))
                return false;
            
            if(username.length() < 3 || password.length() < 8 || adresa.length() < 4)
                return false;
            
            char[] username_chars = username.toCharArray();
            for(char c : username_chars) {
                if(Character.isDigit(c))
                    return false;
            }

            return true;
        }
        
        private void ucitajGradove() {
            String[] gradovi = {"Beograd", "Novi Sad", "Nis"};
            for(String s : gradovi)
                comboGrad.addItem(s);
            
            comboGrad.setSelectedItem(null);
        }
        
        private void ucitajOpstine(String grad) {
            
            if(grad == null) return;
            
            comboOpstina.removeAllItems();
            
            String[] beo_opstine = {"Cukarica", "Rakovica", "Surcin", "Palilula" ,"Zvezdara", "Vracar", "Savski Venac", "Novi Beograd", "Stari Grad", "Vozdovac", "Sopot", "Barajevo", "Mladenovac", "Lazarevac", "Grocka"};
            String[] ns_opstine = {"Veternik", "Futog", "Budisava", "Bukovac", "Begec", "Rumenka", "Stepanovicevo"};
            String[] nis_opstine = {"Pantelej", "Palilula", "Niska Banja", "Crveni Krst"};
            
            switch(grad) {
                case "Beograd":
                    for(String s : beo_opstine)
                        comboOpstina.addItem(s);
                break;
                
                case "Novi Sad":
                    for(String s : ns_opstine)
                        comboOpstina.addItem(s);
                break;
                
                case "Nis":
                    for(String s : nis_opstine)
                        comboOpstina.addItem(s);
                break;
                
            }

            comboOpstina.setSelectedItem(null);
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
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnKreiraj = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        comboGrad = new javax.swing.JComboBox<>();
        comboOpstina = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        btnPromeni = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Kreiraj Policijsku Upravu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Korisnicko Ime");

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("Lozinka");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("Grad PU");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("Opstina PU");

        btnKreiraj.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnKreiraj.setText("Kreiraj");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        comboGrad.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        comboOpstina.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("Adresa PU");

        txtAdresa.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        btnPromeni.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        btnPromeni.setText("Promeni");

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblID.setText("ID PU");

        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(140, 140, 140))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnKreiraj)
                .addGap(106, 106, 106)
                .addComponent(btnPromeni)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword)
                    .addComponent(comboGrad, 0, 281, Short.MAX_VALUE)
                    .addComponent(comboOpstina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAdresa)
                    .addComponent(txtID))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboOpstina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPromeni))
                .addGap(14, 14, 14))
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
            java.util.logging.Logger.getLogger(KreirajPUForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreirajPUForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreirajPUForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreirajPUForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KreirajPUForm dialog = new KreirajPUForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboOpstina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtID;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
