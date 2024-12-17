/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;
import controller.Controller;
import domain.*;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import main.KategorijaKazna;


/**
 *
 * @author Stefan
 */
public class KreirajEvidencijaForm extends javax.swing.JDialog {

    /**
     * Creates new form KreirajEvidencijaForm
     */
    
    public KreirajEvidencijaForm(java.awt.Frame parent, boolean modal, EvidencijaKazni evidencija, String kriterijum, String filter) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        prepareForUpdate(evidencija, kriterijum, filter);
    }
    
    private void prepareForUpdate(EvidencijaKazni evid, String kriterijum, String filter) {
        setTitle("Promeni Evidenciju Kazni");
        lblTitle.setText("Promeni Evidenciju Kazni");
        ucitajUprave();
        comboUprave.setSelectedItem(evid.getPu());
        comboUprave.setEnabled(false);
        ucitajVozila();
        comboVozila.setSelectedItem(evid.getVozilo());
        comboVozila.setEnabled(false);
        sliderPonder.setValue((int)evid.getBazni_ponder());
        this.remove(btnKreiraj);
        
        ArrayList<Kazna> kazne = Controller.getInstance().vratiListuSviKazna();
        
        JCheckBox
        cb1 = new JCheckBox(kazne.get(0).getNaziv()+""),
        cb2 = new JCheckBox(kazne.get(1).getNaziv()+""),
        cb3 = new JCheckBox(kazne.get(2).getNaziv()+""),
        cb4 = new JCheckBox(kazne.get(3).getNaziv()+""),
        cb5 = new JCheckBox(kazne.get(4).getNaziv()+""),
        cb6 = new JCheckBox(kazne.get(5).getNaziv()+""),
        cb7 = new JCheckBox(kazne.get(6).getNaziv()+""),
        cb8 = new JCheckBox(kazne.get(7).getNaziv()+""),
        cb9 = new JCheckBox(kazne.get(8).getNaziv()+""),
        cb10 = new JCheckBox(kazne.get(9).getNaziv()+""),
        cb11 = new JCheckBox(kazne.get(10).getNaziv()+""),
        cb12 = new JCheckBox(kazne.get(11).getNaziv()+""),
        cb13 = new JCheckBox(kazne.get(12).getNaziv()+""),
        cb14 = new JCheckBox(kazne.get(13).getNaziv()+""),
        cb15 = new JCheckBox(kazne.get(14).getNaziv()+"");

        cb1.setBounds(50, 330, 250, 80);
        cb2.setBounds(300, 330, 250, 80);
        cb3.setBounds(550, 330, 250, 80);
        cb4.setBounds(800, 330, 250, 80);
        cb5.setBounds(50, 410, 250, 80);
        cb6.setBounds(300, 410, 250, 80);
        cb7.setBounds(550, 410, 250, 80);
        cb8.setBounds(800, 410, 250, 80);
        cb9.setBounds(50, 490, 250, 80);
        cb10.setBounds(300, 490, 250, 80);
        cb11.setBounds(550, 490, 250, 80);
        cb12.setBounds(800, 490, 250, 80);
        cb13.setBounds(50, 570, 250, 80);
        cb14.setBounds(300, 570, 250, 80);
        cb15.setBounds(550, 570, 250, 80);

        cb1.setFont(new Font("Ariel", Font.BOLD, 15));
        cb2.setFont(new Font("Ariel", Font.BOLD, 15));
        cb3.setFont(new Font("Ariel", Font.BOLD, 15));
        cb4.setFont(new Font("Ariel", Font.BOLD, 15));
        cb5.setFont(new Font("Ariel", Font.BOLD, 15));
        cb6.setFont(new Font("Ariel", Font.BOLD, 15));
        cb7.setFont(new Font("Ariel", Font.BOLD, 15));
        cb8.setFont(new Font("Ariel", Font.BOLD, 15));
        cb9.setFont(new Font("Ariel", Font.BOLD, 15));
        cb10.setFont(new Font("Ariel", Font.BOLD, 15));
        cb11.setFont(new Font("Ariel", Font.BOLD, 15));
        cb12.setFont(new Font("Ariel", Font.BOLD, 15));
        cb13.setFont(new Font("Ariel", Font.BOLD, 15));
        cb14.setFont(new Font("Ariel", Font.BOLD, 15));
        cb15.setFont(new Font("Ariel", Font.BOLD, 15));

        this.add(cb1);
        this.add(cb2);
        this.add(cb3);
        this.add(cb4);
        this.add(cb5);
        this.add(cb6);
        this.add(cb7);
        this.add(cb8);
        this.add(cb9);
        this.add(cb10);
        this.add(cb11);
        this.add(cb12);
        this.add(cb13);
        this.add(cb14);
        this.add(cb15);

        ArrayList<StavkaEvidencije> stavke_evidencije = Controller.getInstance().vratiListuSviStavkeEvidencije(evid);
        
        for(StavkaEvidencije stavka : stavke_evidencije) {
            if(stavka.getKazna().getNaziv().equals(cb1.getText())) {
                cb1.setSelected(true);
                cb1.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb2.getText())) {
                cb2.setSelected(true);
                cb2.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb3.getText())) {
                cb3.setSelected(true);
                cb3.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb4.getText())) {
                cb4.setSelected(true);
                cb4.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb5.getText())) {
                cb5.setSelected(true);
                cb5.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb6.getText())) {
                cb6.setSelected(true);
                cb6.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb7.getText())) {
                cb7.setSelected(true);
                cb7.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb8.getText())) {
                cb8.setSelected(true);
                cb8.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb9.getText())) {
                cb9.setSelected(true);
                cb9.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb10.getText())) {
                cb10.setSelected(true);
                cb10.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb11.getText())) {
                cb11.setSelected(true);
                cb11.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb12.getText())) {
                cb12.setSelected(true);
                cb12.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb13.getText())) {
                cb13.setSelected(true);
                cb13.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb14.getText())) {
                cb14.setSelected(true);
                cb14.setEnabled(false);
            }
            
            if(stavka.getKazna().getNaziv().equals(cb15.getText())) {
                cb15.setSelected(true);
                cb15.setEnabled(false);
            }
        }
                
        btnPromeni.addActionListener( e -> {
            if(JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Potvrda", JOptionPane.YES_NO_OPTION) != 0)
                return;
            
            ArrayList<Kazna> izabrane_kazne = new ArrayList<Kazna>();
        
            if(cb1.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb1.getText())));
            if(cb2.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb2.getText())));
            if(cb3.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb3.getText())));
            if(cb4.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb4.getText())));
            if(cb5.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb5.getText())));
            if(cb6.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb6.getText())));
            if(cb7.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb7.getText())));
            if(cb8.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb8.getText())));
            if(cb9.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb9.getText())));
            if(cb10.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb10.getText())));
            if(cb11.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb11.getText())));
            if(cb12.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb12.getText())));
            if(cb13.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb13.getText())));
            if(cb14.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb14.getText())));
            if(cb15.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb15.getText())));
            
            EvidencijaKazni evidencija = new EvidencijaKazni();
            evidencija.setId_evidencija(evid.getId_evidencija());
            evidencija.setPu((PolicijskaUprava)comboUprave.getSelectedItem());
            evidencija.setVozilo((Vozilo)comboVozila.getSelectedItem());
            evidencija.setBazni_ponder((double)sliderPonder.getValue());

            long brKazniI = 0l, brKazniII = 0l, brKazniIII = 0l;
            for(Kazna k : izabrane_kazne) {
                switch(k.getKategorija()) {
                    case KategorijaKazna.Kategorija_I:
                        ++brKazniI;
                    break;
                    
                    case KategorijaKazna.Kategorija_II:
                        ++brKazniII;
                    break;
                    
                    case KategorijaKazna.Kategorija_III:
                        ++brKazniIII;
                    break;
                }
            }  

            evidencija.setBr_kazni_I(brKazniI);
            evidencija.setBr_kazni_II(brKazniII);
            evidencija.setBr_kazni_III(brKazniIII);
            evidencija.setIznos_total();
            
            if(Controller.getInstance().promeniEvidencijaKazni(evidencija)) {
                for(int i = 0; i < izabrane_kazne.size(); i++) {
                    StavkaEvidencije stavka = new StavkaEvidencije();
                    stavka.setEvidencija(evidencija);
                    stavka.setKazna(izabrane_kazne.get(i));
                    stavka.setKategorija_kazne(izabrane_kazne.get(i).getKategorija());
                    Controller.getInstance().kreirajStavkaEvidencije(stavka);
                }
                
                JOptionPane.showMessageDialog(this, "Evidencija i stavke evidencije su promenjene!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                
                this.setVisible(false);
                new PretraziEvidencijaForm(null, true, kriterijum, filter).setVisible(true);
                izabrane_kazne.clear();
            } else
                JOptionPane.showMessageDialog(this, "Greska pri promeni evidencije!", "Greska", JOptionPane.ERROR_MESSAGE);
        });
    }
    
    public KreirajEvidencijaForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kreiraj Evidenciju Kazni");
        prepareGeneral();
        prepareForInsert();
        
        this.add(lblPU);
        this.add(comboUprave);
        this.add(lblVozilo);
        this.add(comboVozila);
        this.add(lblSlider);
        this.add(lblSliderValue);
        this.add(sliderPonder);
        this.add(lblIzaberiKzn);
        
        ArrayList<Kazna> kazne = Controller.getInstance().vratiListuSviKazna();
        JCheckBox
        cb1 = new JCheckBox(kazne.get(0).getNaziv()+""),
        cb2 = new JCheckBox(kazne.get(1).getNaziv()+""),
        cb3 = new JCheckBox(kazne.get(2).getNaziv()+""),
        cb4 = new JCheckBox(kazne.get(3).getNaziv()+""),
        cb5 = new JCheckBox(kazne.get(4).getNaziv()+""),
        cb6 = new JCheckBox(kazne.get(5).getNaziv()+""),
        cb7 = new JCheckBox(kazne.get(6).getNaziv()+""),
        cb8 = new JCheckBox(kazne.get(7).getNaziv()+""),
        cb9 = new JCheckBox(kazne.get(8).getNaziv()+""),
        cb10 = new JCheckBox(kazne.get(9).getNaziv()+""),
        cb11 = new JCheckBox(kazne.get(10).getNaziv()+""),
        cb12 = new JCheckBox(kazne.get(11).getNaziv()+""),
        cb13 = new JCheckBox(kazne.get(12).getNaziv()+""),
        cb14 = new JCheckBox(kazne.get(13).getNaziv()+""),
        cb15 = new JCheckBox(kazne.get(14).getNaziv()+"");

        cb1.setBounds(50, 330, 250, 80);
        cb2.setBounds(300, 330, 250, 80);
        cb3.setBounds(550, 330, 250, 80);
        cb4.setBounds(800, 330, 250, 80);
        cb5.setBounds(50, 410, 250, 80);
        cb6.setBounds(300, 410, 250, 80);
        cb7.setBounds(550, 410, 250, 80);
        cb8.setBounds(800, 410, 250, 80);
        cb9.setBounds(50, 490, 250, 80);
        cb10.setBounds(300, 490, 250, 80);
        cb11.setBounds(550, 490, 250, 80);
        cb12.setBounds(800, 490, 250, 80);
        cb13.setBounds(50, 570, 250, 80);
        cb14.setBounds(300, 570, 250, 80);
        cb15.setBounds(550, 570, 250, 80);

        cb1.setFont(new Font("Ariel", Font.BOLD, 15));
        cb2.setFont(new Font("Ariel", Font.BOLD, 15));
        cb3.setFont(new Font("Ariel", Font.BOLD, 15));
        cb4.setFont(new Font("Ariel", Font.BOLD, 15));
        cb5.setFont(new Font("Ariel", Font.BOLD, 15));
        cb6.setFont(new Font("Ariel", Font.BOLD, 15));
        cb7.setFont(new Font("Ariel", Font.BOLD, 15));
        cb8.setFont(new Font("Ariel", Font.BOLD, 15));
        cb9.setFont(new Font("Ariel", Font.BOLD, 15));
        cb10.setFont(new Font("Ariel", Font.BOLD, 15));
        cb11.setFont(new Font("Ariel", Font.BOLD, 15));
        cb12.setFont(new Font("Ariel", Font.BOLD, 15));
        cb13.setFont(new Font("Ariel", Font.BOLD, 15));
        cb14.setFont(new Font("Ariel", Font.BOLD, 15));
        cb15.setFont(new Font("Ariel", Font.BOLD, 15));

        this.add(cb1);
        this.add(cb2);
        this.add(cb3);
        this.add(cb4);
        this.add(cb5);
        this.add(cb6);
        this.add(cb7);
        this.add(cb8);
        this.add(cb9);
        this.add(cb10);
        this.add(cb11);
        this.add(cb12);
        this.add(cb13);
        this.add(cb14);
        this.add(cb15);

        ArrayList<Kazna> izabrane_kazne = new ArrayList<Kazna>();
        
        btnKreiraj.addActionListener( e -> {
            if((PolicijskaUprava)comboUprave.getSelectedItem() == null || (Vozilo)comboVozila.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Izaberite policijsku upravu i vozilo!", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            
            if(Controller.getInstance().daLiPostojiEvidencija((PolicijskaUprava)comboUprave.getSelectedItem(), (Vozilo)comboVozila.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "Evidencija za izabrano vozilo i izabranu policijsku upravu vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);   
                return;
            }
            
            if(JOptionPane.showConfirmDialog(this, "Da li ste sigurni?", "Potvrda", JOptionPane.YES_NO_OPTION) != 0) 
                return;
           
            if(cb1.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb1.getText())));
            if(cb2.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb2.getText())));
            if(cb3.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb3.getText())));
            if(cb4.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb4.getText())));
            if(cb5.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb5.getText())));
            if(cb6.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb6.getText())));
            if(cb7.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb7.getText())));
            if(cb8.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb8.getText())));
            if(cb9.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb9.getText())));
            if(cb10.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb10.getText())));
            if(cb11.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb11.getText())));
            if(cb12.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb12.getText())));
            if(cb13.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb13.getText())));
            if(cb14.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb14.getText())));
            if(cb15.isSelected())
                izabrane_kazne.add(Controller.getInstance().pretraziKazna(new Kazna(cb15.getText())));
            
            EvidencijaKazni evidencija = new EvidencijaKazni();
            evidencija.setBazni_ponder(sliderPonder.getValue());
            evidencija.setPu((PolicijskaUprava)comboUprave.getSelectedItem());
            evidencija.setVozilo((Vozilo)comboVozila.getSelectedItem());
            
            long brKazniI = 0l, brKazniII = 0l, brKazniIII = 0l;
            for(Kazna k : izabrane_kazne) {
                switch(k.getKategorija()) {
                    case KategorijaKazna.Kategorija_I:
                        ++brKazniI;
                    break;
                    
                    case KategorijaKazna.Kategorija_II:
                        ++brKazniII;
                    break;
                    
                    case KategorijaKazna.Kategorija_III:
                        ++brKazniIII;
                    break;
                }
            }  
            
            evidencija.setBr_kazni_I(brKazniI);
            evidencija.setBr_kazni_II(brKazniII);
            evidencija.setBr_kazni_III(brKazniIII);
            evidencija.setIznos_total();
            
            if(Controller.getInstance().kreirajEvidencijaKazni(evidencija)) {
                for(int i = 0; i < izabrane_kazne.size(); i++) {
                    StavkaEvidencije stavka = new StavkaEvidencije();
                    stavka.setEvidencija(evidencija);
                    stavka.setKazna(izabrane_kazne.get(i));
                    stavka.setKategorija_kazne(izabrane_kazne.get(i).getKategorija());
                    Controller.getInstance().kreirajStavkaEvidencije(stavka);
                }
                
                JOptionPane.showMessageDialog(this, "Evidencija i stavke evidencije su kreirane!", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                
                if(JOptionPane.showConfirmDialog(this, "Novi unos?", "Potvrda", JOptionPane.YES_NO_OPTION) != 0) 
                    this.setVisible(false);
                
                comboUprave.setSelectedItem(null);
                comboVozila.setSelectedItem(null);
                sliderPonder.setValue(1);
                cb1.setSelected(false);
                cb2.setSelected(false);
                cb3.setSelected(false);
                cb4.setSelected(false);
                cb5.setSelected(false);
                cb6.setSelected(false);
                cb7.setSelected(false);
                cb8.setSelected(false);
                cb9.setSelected(false);
                cb10.setSelected(false);
                cb11.setSelected(false);
                cb12.setSelected(false);
                cb13.setSelected(false);
                cb14.setSelected(false);
                cb15.setSelected(false);
                
                izabrane_kazne.clear();
            } else
                JOptionPane.showMessageDialog(this, "Greska pri kreiranju evidencije!", "Greska", JOptionPane.ERROR_MESSAGE);
            
        });
    }
    
    private void prepareGeneral() {
        this.remove(lblPU);
        this.remove(comboUprave);
        this.remove(lblVozilo);
        this.remove(comboVozila);
        this.remove(lblSlider);
        this.remove(lblSliderValue);
        this.remove(sliderPonder);
        this.remove(lblIzaberiKzn);
        this.remove(btnPromeni);
    }
    
    private void prepareForInsert() {
        ucitajUprave();
        ucitajVozila();
    }
    
    
    private void ucitajUprave() {
        ArrayList<PolicijskaUprava> uprave = Controller.getInstance().vratiListuSviPolicijskaUprava();
        
        for(PolicijskaUprava uprava : uprave)
            comboUprave.addItem(uprava);
        
        comboUprave.setSelectedItem(null);
    }
    
    private void ucitajVozila() {
        ArrayList<Vozilo> vozila = Controller.getInstance().vratiListuSviVozilo();
        
        for(Vozilo vozilo : vozila)
            comboVozila.addItem(vozilo);
        
        comboVozila.setSelectedItem(null);
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
        lblVozilo = new javax.swing.JLabel();
        comboVozila = new javax.swing.JComboBox<>();
        btnKreiraj = new javax.swing.JButton();
        lblIzaberiKzn = new javax.swing.JLabel();
        sliderPonder = new javax.swing.JSlider();
        lblSlider = new javax.swing.JLabel();
        lblSliderValue = new javax.swing.JLabel();
        btnPromeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lblTitle.setText("Kreiraj Evidenciju Kazni");

        lblPU.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPU.setText("Policijska Uprava:");

        comboUprave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblVozilo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblVozilo.setText("Vozilo:");

        comboVozila.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnKreiraj.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnKreiraj.setText("Kreiraj Evidenciju");

        lblIzaberiKzn.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblIzaberiKzn.setText("Izaberite Kaznu/e:");

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

        lblSlider.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSlider.setText("Ponder (1-5):");

        lblSliderValue.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSliderValue.setForeground(new java.awt.Color(255, 0, 51));
        lblSliderValue.setText("1");

        btnPromeni.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPromeni.setText("Promeni Evidenciju");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIzaberiKzn)
                        .addGap(474, 474, 474))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(428, 428, 428))))
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPU)
                    .addComponent(lblVozilo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSlider)
                        .addGap(26, 26, 26)
                        .addComponent(lblSliderValue)))
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnKreiraj)
                        .addGap(40, 40, 40)
                        .addComponent(btnPromeni))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboVozila, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboUprave, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sliderPonder, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPU)
                    .addComponent(comboUprave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboVozila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVozilo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSlider)
                            .addComponent(lblSliderValue))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderPonder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(lblIzaberiKzn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKreiraj)
                    .addComponent(btnPromeni))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderPonderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPonderStateChanged
        // TODO add your handling code here:
        lblSliderValue.setText(sliderPonder.getValue() + "");
    }//GEN-LAST:event_sliderPonderStateChanged

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
    private javax.swing.JButton btnKreiraj;
    private javax.swing.JButton btnPromeni;
    private javax.swing.JComboBox<PolicijskaUprava> comboUprave;
    private javax.swing.JComboBox<Vozilo> comboVozila;
    private javax.swing.JLabel lblIzaberiKzn;
    private javax.swing.JLabel lblPU;
    private javax.swing.JLabel lblSlider;
    private javax.swing.JLabel lblSliderValue;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVozilo;
    private javax.swing.JSlider sliderPonder;
    // End of variables declaration//GEN-END:variables
}
