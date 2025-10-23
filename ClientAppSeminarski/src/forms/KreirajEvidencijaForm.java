/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;
import controller.Controller;
import domain.*;
import java.util.*;
import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import table_models.StavkeEvidencijeTableModel;


/**
 *
 * @author Stefan
 */
public class KreirajEvidencijaForm extends javax.swing.JDialog {
    private EvidencijaKazni poslataEvidencija = null;
    
    public KreirajEvidencijaForm(java.awt.Frame parent, boolean modal, EvidencijaKazni evidencija, String kriterijum, String filter) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        prepareGeneral();
        prepareForUpdate(evidencija, kriterijum, filter);
        
        poslataEvidencija = evidencija;
        
        List<StavkaEvidencije> noveStavke = new ArrayList<StavkaEvidencije>();

        btnDodajStavku.addActionListener( e -> {
            StavkaEvidencije stavkaEvidencije = new StavkaEvidencije();

            Kazna kazna = (Kazna)comboKazna.getSelectedItem();
            Raskrsnica raskrsnica = (Raskrsnica)comboRaskrsnica.getSelectedItem();
            String unos = txtDatumPrekrsaja.getText().trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime datumPrekrsaja = null;
            
            try {
                datumPrekrsaja = LocalDateTime.parse(unos, formatter);
                LocalDateTime now = LocalDateTime.now();
                if(datumPrekrsaja.isAfter(now)) {
                    JOptionPane.showMessageDialog(this, "Greska. Unet je buduci datum.", "Greska", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Uneti datum prekrsaja nije ispravan.", "Pogresan format datuma", JOptionPane.ERROR_MESSAGE);
            }
            
            stavkaEvidencije.setDatumPrekrsaja(datumPrekrsaja);
            stavkaEvidencije.setEvidencija(evidencija);
            stavkaEvidencije.setKazna(kazna);
            stavkaEvidencije.setKategorija_kazne(kazna.getKategorija());
            stavkaEvidencije.setRaskrsnica(raskrsnica);
            
            noveStavke.add(stavkaEvidencije);
            
            try {
                List<StavkaEvidencije> postojeceStavke = evidencija.getStavke_ev();
                List<StavkaEvidencije> sveStavke = new ArrayList<>(postojeceStavke);
                sveStavke.addAll(noveStavke);
                
                tblStavkeEvidencije.setModel(new StavkeEvidencijeTableModel(sveStavke));
                comboRaskrsnica.setSelectedItem(null);
                comboKazna.setSelectedItem(null);
                txtDatumPrekrsaja.setText("");
            } catch(Exception exc) {
                exc.printStackTrace();
            }
        }); 
        
        btnPromeniEvidenciju.addActionListener( t -> {
            if(noveStavke.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Unesite barem jednu novu stavku u evidenciju", "Informacija", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            if(JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Poruka", JOptionPane.YES_NO_OPTION) != 0)
                return;
            
            try {
                evidencija.setStavke_ev(noveStavke);
                
                if(Controller.getInstance().updateEvidencijaKazni(evidencija)) {
                    JOptionPane.showMessageDialog(this, "Evidencija je azurirana.");
                } else {
                    JOptionPane.showMessageDialog(this, "Evidencija nije azurirana.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            } catch(Exception exc) {
                exc.printStackTrace();
            }
        });
    }
    
    private void prepareForUpdate(EvidencijaKazni e, String krit, String filter) {
        this.add(lblTitle);
        this.add(lblPU);
        this.add(comboUprave);
        this.add(lblVozilo);
        this.add(txtRegOznaka);
        this.add(btnVoziloPretraga);
        this.add(btnNovoVozilo);
        this.add(lblRaskrsnica);
        this.add(comboRaskrsnica);
        this.add(lblKazna);
        this.add(comboKazna);
        this.add(lblDatum);
        this.add(txtDatumPrekrsaja);
        this.add(lblPonder);
        this.add(lblSliderValue);
        this.add(sliderPonder);
        
        btnKreirajEvidenciju.setEnabled(false);
        
        sliderPonder.setValue((int)e.getBazni_ponder());
        lblSliderValue.setText(e.getBazni_ponder()+"");
        sliderPonder.setEnabled(false);
        
        lblTitle.setText("Promena Evidencije Kazni");
        
        btnNovoVozilo.setEnabled(false);
        btnVoziloPretraga.setEnabled(false);
        
        ucitajUprave();
        comboUprave.setSelectedItem(e.getPu());
        comboUprave.setEnabled(false);
        
        txtRegOznaka.setText(e.getVozilo().getReg_oznaka());
        txtRegOznaka.setEditable(false);
        
        ucitajRaskrsniceGrada(e.getPu().getGrad());
        comboRaskrsnica.setSelectedItem(null);
        
        ucitajKazne();
        comboKazna.setSelectedItem(null);
        
        
        lblSliderValue.setText(String.valueOf(e.getBazni_ponder()));
        sliderPonder.setValue((int)e.getBazni_ponder());
        
        this.add(jScrollPane1);
        try {
            List<StavkaEvidencije> stavke = e.getStavke_ev();
            tblStavkeEvidencije.setModel(new StavkeEvidencijeTableModel(e.getStavke_ev()));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private EvidencijaKazni evidencija = new EvidencijaKazni();
    private List<StavkaEvidencije> listaStavki = new ArrayList<StavkaEvidencije>();
    private long brKazniI, brKazniII, brKazniIII = 0l;
    
    public KreirajEvidencijaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kreiraj Evidenciju Kazni");
        prepareGeneral();
        prepareForInsert();
                
        comboUprave.addActionListener( e -> {
           evidencija.setPu((PolicijskaUprava)comboUprave.getSelectedItem());
           String grad = ((PolicijskaUprava)comboUprave.getSelectedItem()).getGrad();
           ucitajRaskrsniceGrada(grad);
        });
        
        btnVoziloPretraga.addActionListener( e -> {
           if(check_vozilo_id()) {
               String reg_ozn = txtRegOznaka.getText().toLowerCase();
               try {
                   Vozilo v = Controller.getInstance().pretraziVozilo(new Vozilo(reg_ozn));
                   
                   if(v != null) {
                       JOptionPane.showMessageDialog(this, "Vozilo pronadjeno: " + v.getMarka() + " " + v.getModel() + ", " + v.getReg_oznaka().toUpperCase());
                       evidencija.setVozilo(v);
                   } else 
                       JOptionPane.showMessageDialog(this, "Vozilo sa unetom registracionom oznakom ne postoji. Mozete uneti vozilo klikom na dugme 'Novo vozilo'!","Poruka",JOptionPane.INFORMATION_MESSAGE);
               } catch(Exception ex) {
                   ex.printStackTrace();
               }
           } else {
               JOptionPane.showMessageDialog(this, "Uneta neispravna registraciona oznaka vozila.", "Greska", JOptionPane.ERROR_MESSAGE);
               return;
           }
        });
        
        btnNovoVozilo.addActionListener( e -> {
            KreirajVoziloForm dlg = new KreirajVoziloForm(this);
            dlg.setVisible(true);
            Vozilo novo_vozilo = dlg.vratiNovoVozilo();
            
            if(novo_vozilo != null) {
                txtRegOznaka.setText(novo_vozilo.getReg_oznaka().toUpperCase());
                evidencija.setVozilo(novo_vozilo);
            }
            
        });
        
        btnDodajStavku.addActionListener( e -> {
            StavkaEvidencije stavkaEvidencije = new StavkaEvidencije();
            boolean flag = false;
            try {
                flag = Controller.getInstance().daLiPostojiEvidencija(evidencija);
                 
            } catch(Exception exc) {
                exc.printStackTrace();
            }
            if(flag) {
               JOptionPane.showMessageDialog(this, "Evidencija za dato vozilo i policijsku upravu vec postoji.", "Greska", JOptionPane.ERROR_MESSAGE);
               return;
            }
                
            Kazna kazna = (Kazna)comboKazna.getSelectedItem();
            Raskrsnica raskrsnica = (Raskrsnica)comboRaskrsnica.getSelectedItem();
            
            String unos = txtDatumPrekrsaja.getText().trim();
            
            if(evidencija.getPu() == null || evidencija.getVozilo() == null || raskrsnica == null || kazna == null){
                JOptionPane.showMessageDialog(this, "Nisu uneti svi podaci.", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime datumPrekrsaja = null;
            try {
                datumPrekrsaja = LocalDateTime.parse(unos, formatter);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti evidenciju kazni.", "Pogresan format datuma", JOptionPane.ERROR_MESSAGE);
            }
            
            LocalDateTime now = LocalDateTime.now();
            if(datumPrekrsaja.isAfter(now)) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti evidenciju kazni.", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            stavkaEvidencije.setDatumPrekrsaja(datumPrekrsaja);
            stavkaEvidencije.setEvidencija(evidencija);
            stavkaEvidencije.setKazna(kazna);
            stavkaEvidencije.setKategorija_kazne(kazna.getKategorija());
            stavkaEvidencije.setRaskrsnica(raskrsnica);
            
            switch(kazna.getKategorija()) {
                case KategorijaKazna.Kategorija_I:
                    brKazniI++;
                    break;
                case KategorijaKazna.Kategorija_II:
                    brKazniII++;
                    break;
                case KategorijaKazna.Kategorija_III:
                    brKazniIII++;
                    break;
            }
            
            listaStavki.add(stavkaEvidencije);
            
            evidencija.setStavke_ev(listaStavki);
            evidencija.setBr_kazni_I(brKazniI);
            evidencija.setBr_kazni_II(brKazniII);
            evidencija.setBr_kazni_III(brKazniIII);
            evidencija.setBazni_ponder(sliderPonder.getValue());
            evidencija.setIznos_total();
            
            comboUprave.setEnabled(false);
            txtRegOznaka.setEditable(false);
            btnVoziloPretraga.setEnabled(false);
            btnNovoVozilo.setEnabled(false);
            comboRaskrsnica.setSelectedItem(null);
            comboKazna.setSelectedItem(null);
            txtDatumPrekrsaja.setText("");
            sliderPonder.setEnabled(false);
            
            this.add(jScrollPane1);
            tblStavkeEvidencije.setModel(new StavkeEvidencijeTableModel(evidencija.getStavke_ev()));
            if(tblStavkeEvidencije.getModel().getRowCount() != 0)
                btnKreirajEvidenciju.setEnabled(true);
        });
        
        btnKreirajEvidenciju.addActionListener(e -> {
            evidencija.setStavke_ev(listaStavki);
            evidencija.setBr_kazni_I(brKazniI);
            evidencija.setBr_kazni_II(brKazniII);
            evidencija.setBr_kazni_III(brKazniIII);
            evidencija.setIznos_total();
            
            int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite kreirati novu evidenciju kazni?", "Potvrda", JOptionPane.YES_NO_OPTION);
            
            long evidencija_id = 0l;
            if(result == JOptionPane.YES_OPTION) {
                try {
                    evidencija_id = Controller.getInstance().kreirajEvidencijaKazni(evidencija);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
                
                if(evidencija_id != 0l) {
                    JOptionPane.showMessageDialog(this, "Sistem je zapamtio evidenciju kazni.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Nastala je greska.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void prepareGeneral() {
        this.remove(lblTitle);
        this.remove(lblPU);
        this.remove(comboUprave);
        this.remove(lblVozilo);
        this.remove(txtRegOznaka);
        this.remove(btnVoziloPretraga);
        this.remove(btnNovoVozilo);
        this.remove(lblRaskrsnica);
        this.remove(comboRaskrsnica);
        this.remove(lblKazna);
        this.remove(comboKazna);
        this.remove(lblDatum);
        this.remove(txtDatumPrekrsaja);
        this.remove(lblPonder);
        this.remove(lblSliderValue);
        this.remove(sliderPonder);
        this.remove(jScrollPane1);
    }
    
    private void prepareForInsert() {
        this.add(lblTitle);
        this.add(lblPU);
        this.add(comboUprave);
        this.add(lblVozilo);
        this.add(txtRegOznaka);
        this.add(btnVoziloPretraga);
        this.add(btnNovoVozilo);
        this.add(lblRaskrsnica);
        this.add(comboRaskrsnica);
        this.add(lblKazna);
        this.add(comboKazna);
        this.add(lblDatum);
        this.add(txtDatumPrekrsaja);
        this.add(lblPonder);
        this.add(lblSliderValue);
        this.add(sliderPonder);
        
        btnKreirajEvidenciju.setEnabled(false);
        btnPromeniEvidenciju.setEnabled(false);
        
        ucitajUprave();
        ucitajKazne();
    }
    
    private void ucitajUprave() {
        ArrayList<PolicijskaUprava> uprave = new ArrayList<PolicijskaUprava>();
        
        try {
            uprave = Controller.getInstance().vratiListuSviPolicijskaUprava();
        } catch(Exception ex) {
            System.out.println("Greska pri ucitavanju policijskih uprava iz baze podataka!");
        }
        
        for(PolicijskaUprava uprava : uprave)
            comboUprave.addItem(uprava);
        
        comboUprave.setSelectedItem(null);
    }
    
    private void ucitajRaskrsniceGrada(String grad) {
        ArrayList<Raskrsnica> raskrsnice = new ArrayList<Raskrsnica>();
        Raskrsnica ras = new Raskrsnica(grad);
        
        try {
            raskrsnice = Controller.getInstance().vratiListuRaskrsnica(ras);
        } catch(Exception ex) {
            System.out.println("Greska pri ucitavanju raskrsnica iz baze podataka!");
        }
        comboRaskrsnica.removeAllItems();
        for(Raskrsnica r : raskrsnice)
            comboRaskrsnica.addItem(r);
        
        comboRaskrsnica.setSelectedItem(null);
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
        lblPU = new javax.swing.JLabel();
        comboUprave = new javax.swing.JComboBox<>();
        lblRaskrsnica = new javax.swing.JLabel();
        btnKreirajEvidenciju = new javax.swing.JButton();
        lblKazna = new javax.swing.JLabel();
        sliderPonder = new javax.swing.JSlider();
        lblPonder = new javax.swing.JLabel();
        lblSliderValue = new javax.swing.JLabel();
        btnPromeniEvidenciju = new javax.swing.JButton();
        comboRaskrsnica = new javax.swing.JComboBox<>();
        txtRegOznaka = new javax.swing.JTextField();
        btnVoziloPretraga = new javax.swing.JButton();
        btnNovoVozilo = new javax.swing.JButton();
        comboKazna = new javax.swing.JComboBox<>();
        lblVozilo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavkeEvidencije = new javax.swing.JTable();
        btnDodajStavku = new javax.swing.JButton();
        lblDatum = new javax.swing.JLabel();
        txtDatumPrekrsaja = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lblTitle.setText("Kreiraj Evidenciju Kazni");

        lblPU.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPU.setText("Policijska Uprava:");

        comboUprave.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        lblRaskrsnica.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblRaskrsnica.setText("Raskrsnica:");

        btnKreirajEvidenciju.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnKreirajEvidenciju.setText("Kreiraj Evidenciju");

        lblKazna.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblKazna.setText("Izaberite Kaznu:");

        sliderPonder.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        sliderPonder.setMaximum(5);
        sliderPonder.setMinimum(1);
        sliderPonder.setValue(1);
        sliderPonder.setPreferredSize(new java.awt.Dimension(500, 40));
        sliderPonder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderPonderStateChanged(evt);
            }
        });

        lblPonder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPonder.setText("Ponder (1-5):");

        lblSliderValue.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSliderValue.setForeground(new java.awt.Color(255, 0, 51));
        lblSliderValue.setText("1");

        btnPromeniEvidenciju.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnPromeniEvidenciju.setText("Promeni Evidenciju");

        comboRaskrsnica.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        comboRaskrsnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRaskrsnicaActionPerformed(evt);
            }
        });

        txtRegOznaka.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        txtRegOznaka.setPreferredSize(new java.awt.Dimension(64, 28));
        txtRegOznaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegOznakaActionPerformed(evt);
            }
        });

        btnVoziloPretraga.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnVoziloPretraga.setText("Pronadji Vozilo");
        btnVoziloPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoziloPretragaActionPerformed(evt);
            }
        });

        btnNovoVozilo.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnNovoVozilo.setText("Novo Vozilo");
        btnNovoVozilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoVoziloActionPerformed(evt);
            }
        });

        comboKazna.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N

        lblVozilo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblVozilo.setText("Vozilo (Reg. Oznaka):");

        jScrollPane1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N

        tblStavkeEvidencije.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        tblStavkeEvidencije.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStavkeEvidencije);

        btnDodajStavku.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnDodajStavku.setText("Dodaj Stavku");

        lblDatum.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblDatum.setText("Datum Prekrsaja:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(btnKreirajEvidenciju)
                        .addGap(99, 99, 99)
                        .addComponent(btnPromeniEvidenciju))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVozilo)
                        .addGap(90, 90, 90)
                        .addComponent(txtRegOznaka, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVoziloPretraga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNovoVozilo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRaskrsnica)
                            .addComponent(lblKazna)
                            .addComponent(lblDatum)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPonder)
                                .addGap(50, 50, 50)
                                .addComponent(lblSliderValue, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboKazna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDatumPrekrsaja)
                                    .addComponent(sliderPonder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(comboRaskrsnica, 0, 801, Short.MAX_VALUE)))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPU)
                        .addGap(127, 127, 127)
                        .addComponent(comboUprave, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58))
                    .addComponent(jScrollPane1)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(318, 318, 318))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPU)
                            .addComponent(comboUprave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVozilo)
                            .addComponent(txtRegOznaka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVoziloPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovoVozilo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboRaskrsnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRaskrsnica))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKazna)
                            .addComponent(comboKazna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDatumPrekrsaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDatum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 65, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPonder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSliderValue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sliderPonder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodajStavku, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKreirajEvidenciju)
                            .addComponent(btnPromeniEvidenciju))
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderPonderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPonderStateChanged
        // TODO add your handling code here:
        lblSliderValue.setText(sliderPonder.getValue() + "");
        evidencija.setBazni_ponder(sliderPonder.getValue());
    }//GEN-LAST:event_sliderPonderStateChanged

    private void comboRaskrsnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRaskrsnicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRaskrsnicaActionPerformed

    private void btnVoziloPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoziloPretragaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoziloPretragaActionPerformed

    private void txtRegOznakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegOznakaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegOznakaActionPerformed

    private void btnNovoVoziloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoVoziloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNovoVoziloActionPerformed

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
            java.util.logging.Logger.getLogger(KreirajEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KreirajEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KreirajEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KreirajEvidencijaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KreirajEvidencijaForm dialog = new KreirajEvidencijaForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnDodajStavku;
    private javax.swing.JButton btnKreirajEvidenciju;
    private javax.swing.JButton btnNovoVozilo;
    private javax.swing.JButton btnPromeniEvidenciju;
    private javax.swing.JButton btnVoziloPretraga;
    private javax.swing.JComboBox<Kazna> comboKazna;
    private javax.swing.JComboBox<Raskrsnica> comboRaskrsnica;
    private javax.swing.JComboBox<PolicijskaUprava> comboUprave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblKazna;
    private javax.swing.JLabel lblPU;
    private javax.swing.JLabel lblPonder;
    private javax.swing.JLabel lblRaskrsnica;
    private javax.swing.JLabel lblSliderValue;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVozilo;
    private javax.swing.JSlider sliderPonder;
    private javax.swing.JTable tblStavkeEvidencije;
    private javax.swing.JTextField txtDatumPrekrsaja;
    private javax.swing.JTextField txtRegOznaka;
    // End of variables declaration//GEN-END:variables

    private boolean check_vozilo_id() {
        String reg_oznaka = txtRegOznaka.getText().trim();

        if(reg_oznaka.equals(""))
            return false;
        
        String[] elems = reg_oznaka.split("-");
        
        if(elems[0].length() != 2)
            return false;
        
        if(elems[2].length() != 2)
            return false;
        
        if(elems[1].length() < 2 || elems[1].length() > 5) 
            return false;
        
        /////////////////////////////////////////////////
        boolean lettersOnly = true;
        for( char c : elems[0].toCharArray()) {
            if(!Character.isLetter(c)) {
                lettersOnly = false;
                break;
            }
        }
        
        boolean lettersOnly2 = true;
        for( char c : elems[2].toCharArray()) {
            if(!Character.isLetter(c)) {
                lettersOnly2 = false;
                break;
            }
        }
        
        boolean digitsOnly = true;
        for( char c : elems[1].toCharArray()) {
            if(!Character.isDigit(c)) {
                digitsOnly = false;
                break;
            }
        }
        
        if(!lettersOnly || !lettersOnly2 || !digitsOnly)
           return false;
        /////////////////////////////////////////////////
        
        return true;
    }

    private void ucitajKazne() {
        ArrayList<Kazna> kazne = new ArrayList<Kazna>();
        
        try {
            kazne = Controller.getInstance().vratiListuSviKazna();
            
            for(Kazna k : kazne) {
                comboKazna.addItem(k);
            }
            
            comboKazna.setSelectedItem(null);
        } catch(Exception ex) {
            System.out.println("Greska prilikom ucitavanja kazni!");
            ex.printStackTrace();
        }
        
    }
}
