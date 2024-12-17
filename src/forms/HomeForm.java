/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import domain.*;

/**
 *
 * @author Stefan
 */
public class HomeForm extends javax.swing.JDialog {

    /**
     * Creates new form HomepageForm
     */
    public HomeForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    
     public HomeForm(java.awt.Frame parent, boolean modal, PolicijskaUprava pu) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Glavna Forma");
        
        ////////////////////////////////////////////////////////////////////////
        
        itemKritEvid.addActionListener( e -> {
            new PretraziEvidencijaForm(null, true, "Evidencija Kazni").setVisible(true);
        });
        
        itemKritKazna.addActionListener( e -> {
            new PretraziEvidencijaForm(null, true, "Kazna").setVisible(true);
        });
        
        itemKritPU.addActionListener( e -> {
            new PretraziEvidencijaForm(null, true, "Policijska Uprava").setVisible(true);
        });
        
        itemKritVozilo.addActionListener( e -> {
            new PretraziEvidencijaForm(null, true, "Vozilo").setVisible(true);
        });
        
        itemKreirajEvidencija.addActionListener( e-> {
            new KreirajEvidencijaForm(null, true).setVisible(true);
        });
        
        ////////////////////////////////////////////////////////////////////////
        
        itemUbaciRaskrsnica.addActionListener( e-> {
            new UbaciRaskrsnicaForm(null, true).setVisible(true);
        });
        
        itemPretragaNazivRaskrsnica.addActionListener( e-> {
            new PretraziRaskrsnicaForm(null, true, "Naziv").setVisible(true);
        });
        
        itemPretragaLokacijaRaskrsnica.addActionListener( e-> {
            new PretraziRaskrsnicaForm(null, true, "Lokacija").setVisible(true);
        });
        
        
        itemObrisiRaskrsnica.addActionListener( e-> {
            new ObrisiRaskrsnicaForm(null, true).setVisible(true);
        });
        
        itemPromeniRaskrsnica.addActionListener( e-> {
            new PromeniRaskrsnicaForm(null, true).setVisible(true);
        });
        
        ////////////////////////////////////////////////////////////////////////
        
        itemKreirajPU.addActionListener( e-> {
            new KreirajPUForm(null, true).setVisible(true);
        });
        
        itemPretragaNazivPU.addActionListener( e-> {
            new PretraziPUForm(null, true).setVisible(true);
        });
        
        itemPretragaLokacijaPU.addActionListener( e-> {
            new PretraziPUKritForm(null, true, "Lokacija").setVisible(true);
        });
        
        itemPretragaRaskrsnicaPU.addActionListener( e-> {
            new PretraziPUKritForm(null, true, "Raskrsnica").setVisible(true);
        });
        
        
        
        itemObrisiPU.addActionListener( e-> {
            new ObrisiPUForm(null, true).setVisible(true);
        });
        
        itemPromeniPU.addActionListener( e-> {
            new PromeniPUForm(null, true).setVisible(true);
        }); 
        
        ////////////////////////////////////////////////////////////////////////
        
        itemKreirajKazna.addActionListener(e -> {
            new KreirajKaznaForm(null, true).setVisible(true);
        });
        
        itemPretragaNazivKazna.addActionListener(e -> {
            new PretraziKaznaForm(null, true, "Naziv").setVisible(true);
        });
        
        itemPretragaKategorijaKazna.addActionListener( e -> {
            new PretraziKaznaForm(null, true, "Kategorija").setVisible(true);
        });
        
        itemPromeniKazna.addActionListener(e -> {
            new PromeniKaznaForm(null, true).setVisible(true);
        });
        
        itemObrisiKazna.addActionListener(e -> {
            new ObrisiKaznaForm(null, true).setVisible(true);
        });
        
        
        ////////////////////////////////////////////////////////////////////////
        
        itemKreirajVozilo.addActionListener(e -> {
            new KreirajVoziloForm(null, true).setVisible(true);
        });
        
        itemPretragaRegOznakaVozilo.addActionListener(e -> {
            new PretraziVoziloForm(null, true).setVisible(true);
        });
        
        itemPretragaVlasnikVozilo.addActionListener(e -> {
            new PretraziVoziloKritForm(null, true, "Vlasnik").setVisible(true);
        });
        
        itemPretragaMarkaVozilo.addActionListener(e -> {
            new PretraziVoziloKritForm(null, true, "Marka").setVisible(true);
        });
        
        
        
        itemPromeniVozilo.addActionListener(e -> {
            new PromeniVoziloForm(null, true).setVisible(true);
        });
        
        itemObrisiVozilo.addActionListener(e -> {
            new ObrisiVoziloForm(null, true).setVisible(true);
        });
        
        ////////////////////////////////////////////////////////////////////////
        
        itemKreirajVlasnik.addActionListener(e -> {
            new KreirajVlasnikForm(null, true).setVisible(true);
        });
        
        itemPretragaJMBGVlasnik.addActionListener(e -> {
            new PretraziVlasnikForm(null, true).setVisible(true);
        });
        
        itemPretragaGradVlasnik.addActionListener( e -> {
            new PretraziVlasnikForm(null, true, "grad").setVisible(true);
        });
        
        itemPromeniVlasnik.addActionListener(e -> {
            new PromeniVlasnikForm(null, true).setVisible(true);
        });
        
        itemObrisiVlasnik.addActionListener(e -> {
            new ObrisiVlasnikForm(null, true).setVisible(true);
        });
        
        ////////////////////////////////////////////////////////////////////////
        
    }

    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuHome = new javax.swing.JMenuBar();
        meniDokumenti = new javax.swing.JMenu();
        itemKreirajEvidencija = new javax.swing.JMenuItem();
        subPretraga = new javax.swing.JMenu();
        itemKritEvid = new javax.swing.JMenuItem();
        itemKritKazna = new javax.swing.JMenuItem();
        itemKritPU = new javax.swing.JMenuItem();
        itemKritVozilo = new javax.swing.JMenuItem();
        meniPruzalacUsluge = new javax.swing.JMenu();
        subPU = new javax.swing.JMenu();
        itemKreirajPU = new javax.swing.JMenuItem();
        itemObrisiPU = new javax.swing.JMenuItem();
        itemPromeniPU = new javax.swing.JMenuItem();
        subPretragaPU = new javax.swing.JMenu();
        itemPretragaNazivPU = new javax.swing.JMenuItem();
        itemPretragaLokacijaPU = new javax.swing.JMenuItem();
        itemPretragaRaskrsnicaPU = new javax.swing.JMenuItem();
        meniPrimalacUsluge = new javax.swing.JMenu();
        subVozilo = new javax.swing.JMenu();
        itemKreirajVozilo = new javax.swing.JMenuItem();
        itemObrisiVozilo = new javax.swing.JMenuItem();
        itemPromeniVozilo = new javax.swing.JMenuItem();
        subPretragaVozilo = new javax.swing.JMenu();
        itemPretragaRegOznakaVozilo = new javax.swing.JMenuItem();
        itemPretragaVlasnikVozilo = new javax.swing.JMenuItem();
        itemPretragaMarkaVozilo = new javax.swing.JMenuItem();
        meniSifarnici = new javax.swing.JMenu();
        subVlasnik = new javax.swing.JMenu();
        itemKreirajVlasnik = new javax.swing.JMenuItem();
        itemObrisiVlasnik = new javax.swing.JMenuItem();
        itemPromeniVlasnik = new javax.swing.JMenuItem();
        subPretragaVlasnik = new javax.swing.JMenu();
        itemPretragaJMBGVlasnik = new javax.swing.JMenuItem();
        itemPretragaGradVlasnik = new javax.swing.JMenuItem();
        subKazna = new javax.swing.JMenu();
        itemKreirajKazna = new javax.swing.JMenuItem();
        itemObrisiKazna = new javax.swing.JMenuItem();
        itemPromeniKazna = new javax.swing.JMenuItem();
        subKaznaPretraga = new javax.swing.JMenu();
        itemPretragaNazivKazna = new javax.swing.JMenuItem();
        itemPretragaKategorijaKazna = new javax.swing.JMenuItem();
        subRaskrsnica = new javax.swing.JMenu();
        itemUbaciRaskrsnica = new javax.swing.JMenuItem();
        itemObrisiRaskrsnica = new javax.swing.JMenuItem();
        itemPromeniRaskrsnica = new javax.swing.JMenuItem();
        subRaskrsnicaPretraga = new javax.swing.JMenu();
        itemPretragaNazivRaskrsnica = new javax.swing.JMenuItem();
        itemPretragaLokacijaRaskrsnica = new javax.swing.JMenuItem();
        meniPodesavanja = new javax.swing.JMenu();
        meniOProgramu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        meniDokumenti.setText("Dokumenti");

        itemKreirajEvidencija.setText("Kreiraj Evidencija Kazni");
        meniDokumenti.add(itemKreirajEvidencija);

        subPretraga.setText("Pretrazi Evidencija Kazni");

        itemKritEvid.setText("Kriterijum Evidencija");
        subPretraga.add(itemKritEvid);

        itemKritKazna.setText("Kriterijum Kazna");
        subPretraga.add(itemKritKazna);

        itemKritPU.setText("Kriterijum Policijska Uprava");
        subPretraga.add(itemKritPU);

        itemKritVozilo.setText("Kriterijum Vozilo");
        subPretraga.add(itemKritVozilo);

        meniDokumenti.add(subPretraga);

        menuHome.add(meniDokumenti);

        meniPruzalacUsluge.setText("Pruzalac Usluge");

        subPU.setText("Policijska Uprava");

        itemKreirajPU.setText("Kreiraj Policijska Uprava");
        itemKreirajPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemKreirajPUActionPerformed(evt);
            }
        });
        subPU.add(itemKreirajPU);

        itemObrisiPU.setText("Obrisi Policijska Uprava");
        subPU.add(itemObrisiPU);

        itemPromeniPU.setText("Promeni Policijska Uprava");
        subPU.add(itemPromeniPU);

        subPretragaPU.setText("Pretrazi Policijska Uprava");

        itemPretragaNazivPU.setText("Kriterijum Naziv");
        subPretragaPU.add(itemPretragaNazivPU);

        itemPretragaLokacijaPU.setText("Kriterijum Lokacija");
        subPretragaPU.add(itemPretragaLokacijaPU);

        itemPretragaRaskrsnicaPU.setText("Kriterijum Raskrsnica");
        subPretragaPU.add(itemPretragaRaskrsnicaPU);

        subPU.add(subPretragaPU);

        meniPruzalacUsluge.add(subPU);

        menuHome.add(meniPruzalacUsluge);

        meniPrimalacUsluge.setText("Primalac Usluge");

        subVozilo.setText("Vozilo");

        itemKreirajVozilo.setText("Kreiraj Vozilo");
        subVozilo.add(itemKreirajVozilo);

        itemObrisiVozilo.setText("Obrisi Vozilo");
        subVozilo.add(itemObrisiVozilo);

        itemPromeniVozilo.setText("Promeni Vozilo");
        subVozilo.add(itemPromeniVozilo);

        subPretragaVozilo.setText("Pretrazi Vozilo");

        itemPretragaRegOznakaVozilo.setText("Kriterijum Registraciona Oznaka");
        subPretragaVozilo.add(itemPretragaRegOznakaVozilo);

        itemPretragaVlasnikVozilo.setText("Kriterijum Prebivaliste Vlasnika");
        subPretragaVozilo.add(itemPretragaVlasnikVozilo);

        itemPretragaMarkaVozilo.setText("Kriterijum Marka Vozila");
        subPretragaVozilo.add(itemPretragaMarkaVozilo);

        subVozilo.add(subPretragaVozilo);

        meniPrimalacUsluge.add(subVozilo);

        menuHome.add(meniPrimalacUsluge);

        meniSifarnici.setText("Sifarnici");

        subVlasnik.setText("Vlasnik");

        itemKreirajVlasnik.setText("Kreiraj Vlasnika");
        subVlasnik.add(itemKreirajVlasnik);

        itemObrisiVlasnik.setText("Obrisi Vlasnika");
        subVlasnik.add(itemObrisiVlasnik);

        itemPromeniVlasnik.setText("Promeni Vlasnika");
        subVlasnik.add(itemPromeniVlasnik);

        subPretragaVlasnik.setText("Pretrazi Vlasnika");

        itemPretragaJMBGVlasnik.setText("Kriterijum JMBG");
        subPretragaVlasnik.add(itemPretragaJMBGVlasnik);

        itemPretragaGradVlasnik.setText("Kriterijum Prebivaliste");
        itemPretragaGradVlasnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPretragaGradVlasnikActionPerformed(evt);
            }
        });
        subPretragaVlasnik.add(itemPretragaGradVlasnik);

        subVlasnik.add(subPretragaVlasnik);

        meniSifarnici.add(subVlasnik);

        subKazna.setText("Kazna");

        itemKreirajKazna.setText("Kreiraj Kazna");
        itemKreirajKazna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemKreirajKaznaActionPerformed(evt);
            }
        });
        subKazna.add(itemKreirajKazna);

        itemObrisiKazna.setText("Obrisi Kazna");
        subKazna.add(itemObrisiKazna);

        itemPromeniKazna.setText("Promeni Kazna");
        subKazna.add(itemPromeniKazna);

        subKaznaPretraga.setText("Pretrazi Kazna");

        itemPretragaNazivKazna.setText("Kriterijum Naziv");
        subKaznaPretraga.add(itemPretragaNazivKazna);

        itemPretragaKategorijaKazna.setText("Kriterijum Kategorija");
        subKaznaPretraga.add(itemPretragaKategorijaKazna);

        subKazna.add(subKaznaPretraga);

        meniSifarnici.add(subKazna);

        subRaskrsnica.setText("Raskrsnica");

        itemUbaciRaskrsnica.setText("Ubaci Raskrsnica");
        itemUbaciRaskrsnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUbaciRaskrsnicaActionPerformed(evt);
            }
        });
        subRaskrsnica.add(itemUbaciRaskrsnica);

        itemObrisiRaskrsnica.setText("Obrisi Raskrsnica");
        subRaskrsnica.add(itemObrisiRaskrsnica);

        itemPromeniRaskrsnica.setText("Promeni Raskrsnica");
        subRaskrsnica.add(itemPromeniRaskrsnica);

        subRaskrsnicaPretraga.setText("Pretrazi Raskrsnica");

        itemPretragaNazivRaskrsnica.setText("Kriterijum Naziv");
        subRaskrsnicaPretraga.add(itemPretragaNazivRaskrsnica);

        itemPretragaLokacijaRaskrsnica.setText("Kriterijum Lokacija");
        subRaskrsnicaPretraga.add(itemPretragaLokacijaRaskrsnica);

        subRaskrsnica.add(subRaskrsnicaPretraga);

        meniSifarnici.add(subRaskrsnica);

        menuHome.add(meniSifarnici);

        meniPodesavanja.setText("Podesavanja softverskog sistema");
        menuHome.add(meniPodesavanja);

        meniOProgramu.setText("O Programu");
        menuHome.add(meniOProgramu);

        setJMenuBar(menuHome);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 722, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemKreirajKaznaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemKreirajKaznaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemKreirajKaznaActionPerformed

    private void itemKreirajPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemKreirajPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemKreirajPUActionPerformed

    private void itemUbaciRaskrsnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUbaciRaskrsnicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemUbaciRaskrsnicaActionPerformed

    private void itemPretragaGradVlasnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPretragaGradVlasnikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPretragaGradVlasnikActionPerformed

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
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeForm dialog = new HomeForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenuItem itemKreirajEvidencija;
    private javax.swing.JMenuItem itemKreirajKazna;
    private javax.swing.JMenuItem itemKreirajPU;
    private javax.swing.JMenuItem itemKreirajVlasnik;
    private javax.swing.JMenuItem itemKreirajVozilo;
    private javax.swing.JMenuItem itemKritEvid;
    private javax.swing.JMenuItem itemKritKazna;
    private javax.swing.JMenuItem itemKritPU;
    private javax.swing.JMenuItem itemKritVozilo;
    private javax.swing.JMenuItem itemObrisiKazna;
    private javax.swing.JMenuItem itemObrisiPU;
    private javax.swing.JMenuItem itemObrisiRaskrsnica;
    private javax.swing.JMenuItem itemObrisiVlasnik;
    private javax.swing.JMenuItem itemObrisiVozilo;
    private javax.swing.JMenuItem itemPretragaGradVlasnik;
    private javax.swing.JMenuItem itemPretragaJMBGVlasnik;
    private javax.swing.JMenuItem itemPretragaKategorijaKazna;
    private javax.swing.JMenuItem itemPretragaLokacijaPU;
    private javax.swing.JMenuItem itemPretragaLokacijaRaskrsnica;
    private javax.swing.JMenuItem itemPretragaMarkaVozilo;
    private javax.swing.JMenuItem itemPretragaNazivKazna;
    private javax.swing.JMenuItem itemPretragaNazivPU;
    private javax.swing.JMenuItem itemPretragaNazivRaskrsnica;
    private javax.swing.JMenuItem itemPretragaRaskrsnicaPU;
    private javax.swing.JMenuItem itemPretragaRegOznakaVozilo;
    private javax.swing.JMenuItem itemPretragaVlasnikVozilo;
    private javax.swing.JMenuItem itemPromeniKazna;
    private javax.swing.JMenuItem itemPromeniPU;
    private javax.swing.JMenuItem itemPromeniRaskrsnica;
    private javax.swing.JMenuItem itemPromeniVlasnik;
    private javax.swing.JMenuItem itemPromeniVozilo;
    private javax.swing.JMenuItem itemUbaciRaskrsnica;
    private javax.swing.JMenu meniDokumenti;
    private javax.swing.JMenu meniOProgramu;
    private javax.swing.JMenu meniPodesavanja;
    private javax.swing.JMenu meniPrimalacUsluge;
    private javax.swing.JMenu meniPruzalacUsluge;
    private javax.swing.JMenu meniSifarnici;
    private javax.swing.JMenuBar menuHome;
    private javax.swing.JMenu subKazna;
    private javax.swing.JMenu subKaznaPretraga;
    private javax.swing.JMenu subPU;
    private javax.swing.JMenu subPretraga;
    private javax.swing.JMenu subPretragaPU;
    private javax.swing.JMenu subPretragaVlasnik;
    private javax.swing.JMenu subPretragaVozilo;
    private javax.swing.JMenu subRaskrsnica;
    private javax.swing.JMenu subRaskrsnicaPretraga;
    private javax.swing.JMenu subVlasnik;
    private javax.swing.JMenu subVozilo;
    // End of variables declaration//GEN-END:variables
}
