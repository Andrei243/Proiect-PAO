package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.Flow;

import services.AppService;


public class MainSwing {
    JFrame jFrame;
    AppService appService=AppService.getInstance();

    static private Dimension dimension=new Dimension(160,20);
    static private Dimension dimlist=new Dimension(400,600);

    private void initializareLocatii(){
        jFrame.dispose();
        jFrame=new JFrame();

        jFrame.setSize(800,800);
        Container pane=jFrame.getContentPane();
        jFrame.setVisible(true);

        BorderLayout borderLayout=new BorderLayout(10,10);
        jFrame.setLayout(borderLayout);
        ArrayList<String> stringuri=appService.getLocationsStrings();
        DefaultListModel<String> list=new DefaultListModel<>();
        for(String s : stringuri){
            list.addElement(s);
        }

        JList jlist=new JList(list);
        jlist.setBounds(20,20,400,400);
        JScrollPane jScrollPane=new JScrollPane(jlist);
        jScrollPane.setSize(dimlist);
        pane.add(jScrollPane,BorderLayout.LINE_START);

        JPanel jPanelSus=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton jButton=new JButton("Intoarce-te la meniul principal");
        jButton.setSize(300,50);
        jButton.addActionListener((e)->{
            jFrame.setVisible(false);
            jFrame.removeAll();
            intializareFereastraInitiala();

        }  );
        jPanelSus.add(jButton);
        pane.add(jPanelSus,BorderLayout.PAGE_START);


        JPanel jPaneldreapta=new JPanel();
        JButton stergere=new JButton("sterge");
        stergere.setSize(50,50);
        stergere.addActionListener((e)->{
            if(jlist.getSelectedIndex()==-1){
                JOptionPane.showMessageDialog(null,"Trebuie sa selectezi un element");
            }
            else{
                int index=jlist.getSelectedIndex();
                appService.sterge_locatie(index);
                jFrame.setVisible(false);
                jFrame.removeAll();
                initializareLocatii();
            }

        }  );
        jPaneldreapta.add(stergere);
        pane.add(stergere,BorderLayout.LINE_END);

        JPanel jPaneljos=new JPanel();
        jPaneljos.setLayout(new BoxLayout(jPaneljos,BoxLayout.Y_AXIS));

        JPanel jPanelTextFields=new JPanel();

        jPanelTextFields.setLayout(new FlowLayout());

        JPanel jPaneltara=new JPanel();
        jPaneltara.setLayout(new BoxLayout(jPaneltara,BoxLayout.Y_AXIS));
        JLabel jLabeltara=new JLabel("Tara:");
        JTextField jTextFieldTara=new JTextField();
        jTextFieldTara.setPreferredSize(dimension);
        jPaneltara.add(jLabeltara);
        jPaneltara.add(jTextFieldTara);

        JPanel jPaneloras=new JPanel();
        jPaneloras.setLayout(new BoxLayout(jPaneloras,BoxLayout.Y_AXIS));
        JLabel jLabeloras=new JLabel("Oras:");
        JTextField jTextFieldOras=new JTextField();
        jTextFieldOras.setPreferredSize(dimension);
        jPaneloras.add(jLabeloras);
        jPaneloras.add(jTextFieldOras);

        jPanelTextFields.add(jPaneltara);
        jPanelTextFields.add(jPaneloras);


        JPanel jPanelButoane=new JPanel();
        jPanelButoane.setLayout(new FlowLayout());
        JButton jButtonAdaugare=new JButton("Adauga");
        jButtonAdaugare.setSize(30,5);
        jButtonAdaugare.addActionListener((e)->{
            if(jTextFieldOras.getText().equals("")||jTextFieldTara.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Trebuie sa introduci ceva nenul");
            }
            else{
                appService.adauga_locatie(jTextFieldTara.getText(),jTextFieldOras.getText());
                jFrame.removeAll();
                jFrame.setVisible(false);
                initializareLocatii();
            }

        } );
        JButton jButtonEditare=new JButton("Editeaza");
        jButtonEditare.setSize(30,5);
        jButtonEditare.addActionListener((e)->{
            if(jTextFieldOras.getText().equals("")||jTextFieldTara.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Trebuie sa introduci ceva nenul");
            }
            else{
                if(jlist.getSelectedIndex()==-1){
                    JOptionPane.showMessageDialog(null,"Trebuie sa selectezi celula pe care vrei sa o editezi");
                }
                else {
                    appService.schimba_locatie(jlist.getSelectedIndex(),jTextFieldTara.getText(),jTextFieldOras.getText());
                    jTextFieldTara.setText("");
                    jTextFieldOras.setText("");
                    jFrame.removeAll();
                    jFrame.setVisible(false);
                    initializareLocatii();
                }
            }
        }  );

        jPanelButoane.add(jButtonAdaugare);
        jPanelButoane.add(jButtonEditare);

        jPaneljos.add(jPanelTextFields);
        jPaneljos.add(jPanelButoane);
        pane.add(jPaneljos,BorderLayout.PAGE_END);


        System.out.println("Gata");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    private void initializareClienti(){
        jFrame.dispose();
        jFrame=new JFrame();

        jFrame.setSize(800,800);
        Container pane=jFrame.getContentPane();
        jFrame.setVisible(true);

        BorderLayout borderLayout=new BorderLayout(10,10);
        jFrame.setLayout(borderLayout);
        ArrayList<String> stringuri=appService.getClientsStrings();
        DefaultListModel<String> list=new DefaultListModel<>();
        for(String s : stringuri){
            list.addElement(s);
        }

        JList jlist=new JList(list);
        jlist.setBounds(20,20,400,400);
        JScrollPane jScrollPane=new JScrollPane(jlist);
        jScrollPane.setSize(dimlist);
        pane.add(jScrollPane,BorderLayout.LINE_START);


        JPanel jPanelSus=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton jButton=new JButton("Intoarce-te la meniul principal");
        jButton.setSize(300,50);
        jButton.addActionListener((e)->{
            jFrame.setVisible(false);
            jFrame.removeAll();
            intializareFereastraInitiala();

        }  );
        jPanelSus.add(jButton);
        pane.add(jPanelSus,BorderLayout.PAGE_START);



        JPanel jPaneldreapta=new JPanel();
        JButton stergere=new JButton("Sterge");
        stergere.setSize(50,50);
        stergere.addActionListener((e)->{
            if(jlist.getSelectedIndex()==-1){
                JOptionPane.showMessageDialog(null,"Trebuie sa selectezi un element");
            }
            else{
                int index=jlist.getSelectedIndex();
                appService.sterge_client(index);
                jFrame.setVisible(false);
                jFrame.removeAll();
                initializareClienti();
            }

        }  );
        jPaneldreapta.add(stergere);
        pane.add(stergere,BorderLayout.LINE_END);

        JPanel jPaneljos=new JPanel();
        jPaneljos.setLayout(new BoxLayout(jPaneljos,BoxLayout.Y_AXIS));

        JPanel jPanelTextFields=new JPanel();

        jPanelTextFields.setLayout(new FlowLayout());

        JPanel jPanelNume=new JPanel();
        jPanelNume.setLayout(new BoxLayout(jPanelNume,BoxLayout.Y_AXIS));
        JLabel jLabeltara=new JLabel("Nume:");
        JTextField jTextNume=new JTextField();
        jTextNume.setPreferredSize(dimension);
        jPanelNume.add(jLabeltara);
        jPanelNume.add(jTextNume);


        jPanelTextFields.add(jPanelNume);


        JPanel jPanelButoane=new JPanel();
        jPanelButoane.setLayout(new FlowLayout());
        JButton jButtonAdaugare=new JButton("Adauga");
        jButtonAdaugare.setSize(30,5);
        jButtonAdaugare.addActionListener((e)->{
            if(jTextNume.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Trebuie sa introduci ceva nenul");
            }
            else{
                appService.adauga_client(jTextNume.getText());
                jFrame.removeAll();
                jFrame.setVisible(false);
                initializareClienti();
            }

        } );
        JButton jButtonEditare=new JButton("Editeaza");
        jButtonEditare.setSize(30,5);
        jButtonEditare.addActionListener((e)->{
            if(jTextNume.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Trebuie sa introduci ceva nenul");
            }
            else{
                if(jlist.getSelectedIndex()==-1){
                    JOptionPane.showMessageDialog(null,"Trebuie sa selectezi celula pe care vrei sa o editezi");
                }
                else {
                    appService.schimba_client(jlist.getSelectedIndex(),jTextNume.getText());
                    jTextNume.setText("");
                    jFrame.removeAll();
                    jFrame.setVisible(false);
                    initializareClienti();
                }
            }
        }  );

        jPanelButoane.add(jButtonAdaugare);
        jPanelButoane.add(jButtonEditare);

        jPaneljos.add(jPanelTextFields);
        jPaneljos.add(jPanelButoane);
        pane.add(jPaneljos,BorderLayout.PAGE_END);


        System.out.println("Gata");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void initializareFirmeProductie(){
        jFrame.dispose();
        jFrame=new JFrame();

        jFrame.setSize(800,800);
        Container pane=jFrame.getContentPane();
        jFrame.setVisible(true);

        BorderLayout borderLayout=new BorderLayout(10,10);
        jFrame.setLayout(borderLayout);
        ArrayList<String> stringuri=appService.getProductionStrings();
        DefaultListModel<String> list=new DefaultListModel<>();
        for(String s : stringuri){
            list.addElement(s);
        }

        JList jlist=new JList(list);
        jlist.setBounds(20,20,400,400);
        JScrollPane jScrollPane=new JScrollPane(jlist);
        jScrollPane.setSize(dimlist);

        pane.add(jScrollPane,BorderLayout.LINE_START);


        JPanel jPanelSus=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton jButton=new JButton("Intoarce-te la meniul principal");
        jButton.setSize(300,50);
        jButton.addActionListener((e)->{
            jFrame.setVisible(false);
            jFrame.removeAll();
            intializareFereastraInitiala();

        }  );
        jPanelSus.add(jButton);
        pane.add(jPanelSus,BorderLayout.PAGE_START);



        JPanel jPaneldreapta=new JPanel();
        JButton stergere=new JButton("Sterge");
        stergere.setSize(50,50);
        stergere.addActionListener((e)->{
            if(jlist.getSelectedIndex()==-1){
                JOptionPane.showMessageDialog(null,"Trebuie sa selectezi un element");
            }
            else{
                int index=jlist.getSelectedIndex();
                appService.sterge_firma_productie(index);
                jFrame.setVisible(false);
                jFrame.removeAll();
                initializareFirmeProductie();
            }

        }  );
        jPaneldreapta.add(stergere);
        pane.add(stergere,BorderLayout.LINE_END);

        JPanel jPaneljos=new JPanel();
        jPaneljos.setLayout(new BoxLayout(jPaneljos,BoxLayout.Y_AXIS));

        JPanel jPanelTextFields=new JPanel();

        jPanelTextFields.setLayout(new FlowLayout());

        JPanel jPanelNume=new JPanel();
        jPanelNume.setLayout(new BoxLayout(jPanelNume,BoxLayout.Y_AXIS));
        JLabel jLabelNume=new JLabel("Nume:");
        JTextField jTextNume=new JTextField();
        jTextNume.setPreferredSize(dimension);
        jPanelNume.add(jLabelNume);
        jPanelNume.add(jTextNume);


        jPanelTextFields.add(jPanelNume);


        JPanel jPanelButoane=new JPanel();
        jPanelButoane.setLayout(new FlowLayout());
        JButton jButtonAdaugare=new JButton("Adauga");
        jButtonAdaugare.setSize(30,5);
        jButtonAdaugare.addActionListener((e)->{
            if(jTextNume.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Trebuie sa introduci ceva nenul");
            }
            else{
                appService.adauga_firma_productie(jTextNume.getText());
                jFrame.removeAll();
                jFrame.setVisible(false);
                initializareFirmeProductie();
            }

        } );
        JButton jButtonEditare=new JButton("Editeaza");
        jButtonEditare.setSize(30,5);
        jButtonEditare.addActionListener((e)->{
            if(jTextNume.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Trebuie sa introduci ceva nenul");
            }
            else{
                if(jlist.getSelectedIndex()==-1){
                    JOptionPane.showMessageDialog(null,"Trebuie sa selectezi celula pe care vrei sa o editezi");
                }
                else {
                    appService.schimba_firma_productie(jlist.getSelectedIndex(),jTextNume.getText());
                    jTextNume.setText("");
                    jFrame.removeAll();
                    jFrame.setVisible(false);
                    initializareFirmeProductie();
                }
            }
        }  );

        jPanelButoane.add(jButtonAdaugare);
        jPanelButoane.add(jButtonEditare);

        jPaneljos.add(jPanelTextFields);
        jPaneljos.add(jPanelButoane);
        pane.add(jPaneljos,BorderLayout.PAGE_END);


        System.out.println("Gata");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void initializareFirmeScanare(){
        jFrame.dispose();
        jFrame=new JFrame();

        jFrame.setSize(800,800);
        Container pane=jFrame.getContentPane();
        jFrame.setVisible(true);

        BorderLayout borderLayout=new BorderLayout(10,10);
        jFrame.setLayout(borderLayout);
        ArrayList<String> stringuri=appService.getScanStrings();
        DefaultListModel<String> list=new DefaultListModel<>();
        for(String s : stringuri){
            list.addElement(s);
        }

        JList jlist=new JList(list);
        jlist.setBounds(20,20,400,400);
        JScrollPane jScrollPane=new JScrollPane(jlist);
        jScrollPane.setSize(dimlist);

        pane.add(jScrollPane,BorderLayout.LINE_START);

        JPanel jPanelSus=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton jButton=new JButton("Intoarce-te la meniul principal");
        jButton.setSize(300,50);
        jButton.addActionListener((e)->{
            jFrame.setVisible(false);
            jFrame.removeAll();
            intializareFereastraInitiala();

        }  );
        jPanelSus.add(jButton);
        pane.add(jPanelSus,BorderLayout.PAGE_START);


        JPanel jPaneldreapta=new JPanel();
        JButton stergere=new JButton("Sterge");
        stergere.setSize(50,50);
        stergere.addActionListener((e)->{
            if(jlist.getSelectedIndex()==-1){
                JOptionPane.showMessageDialog(null,"Trebuie sa selectezi un element");
            }
            else{
                int index=jlist.getSelectedIndex();
                appService.sterge_firma_scanare(index);
                jFrame.setVisible(false);
                jFrame.removeAll();
                initializareFirmeScanare();
            }

        }  );
        jPaneldreapta.add(stergere);
        pane.add(stergere,BorderLayout.LINE_END);

        JPanel jPaneljos=new JPanel();
        jPaneljos.setLayout(new BoxLayout(jPaneljos,BoxLayout.Y_AXIS));

        JPanel jPanelTextFields=new JPanel();

        jPanelTextFields.setLayout(new FlowLayout());

        JPanel jPanelNume=new JPanel();
        jPanelNume.setLayout(new BoxLayout(jPanelNume,BoxLayout.Y_AXIS));
        JLabel jLabelNume=new JLabel("Nume:");
        JTextField jTextFieldNume=new JTextField();
        jTextFieldNume.setPreferredSize(dimension);
        jPanelNume.add(jLabelNume);
        jPanelNume.add(jTextFieldNume);

        JPanel jPanelNumar=new JPanel();
        jPanelNumar.setLayout(new BoxLayout(jPanelNumar,BoxLayout.Y_AXIS));
        JLabel jLabelNumar=new JLabel("Numar:");
        JTextField jTextFieldNumar=new JTextField();
        jTextFieldNumar.setPreferredSize(dimension);
        jPanelNumar.add(jLabelNumar);
        jPanelNumar.add(jTextFieldNumar);

        jPanelTextFields.add(jPanelNume);
        jPanelTextFields.add(jPanelNumar);


        JPanel jPanelButoane=new JPanel();
        jPanelButoane.setLayout(new FlowLayout());
        JButton jButtonAdaugare=new JButton("Adauga");
        jButtonAdaugare.setSize(30,5);
        jButtonAdaugare.addActionListener((e)->{
            if(jTextFieldNumar.getText().equals("")||jTextFieldNume.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Trebuie sa introduci ceva nenul");
            }
            else{

                try{
                    int nr_scanere=Integer.parseInt(jTextFieldNumar.getText());
                    if(nr_scanere<=0)throw new Exception();
                    appService.adauga_firma_scanare(jTextFieldNume.getText(),nr_scanere);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"Trebuie sa introduci un nuamr valid");
                    jTextFieldNumar.setText("");
                    jTextFieldNume.setText("");

                }
                jFrame.removeAll();
                jFrame.setVisible(false);
                initializareFirmeScanare();
            }

        } );
        JButton jButtonEditare=new JButton("Editeaza");
        jButtonEditare.setSize(30,5);
        jButtonEditare.addActionListener((e)->{
            if(jTextFieldNumar.getText().equals("")||jTextFieldNume.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Trebuie sa introduci ceva nenul");
            }
            else{
                if(jlist.getSelectedIndex()==-1){
                    JOptionPane.showMessageDialog(null,"Trebuie sa selectezi celula pe care vrei sa o editezi");
                }
                else {
                    try {
                        int nr_scanere=Integer.parseInt(jTextFieldNumar.getText());
                        if(nr_scanere<=0)throw new Exception();
                        appService.schimba_firma_scanare(jlist.getSelectedIndex(), jTextFieldNume.getText(), nr_scanere);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null,"Trebuie sa introduci un numar valid");
                    }

                    jTextFieldNume.setText("");
                    jTextFieldNumar.setText("");
                    jFrame.removeAll();
                    jFrame.setVisible(false);
                    initializareFirmeScanare();
                }
            }
        }  );

        jPanelButoane.add(jButtonAdaugare);
        jPanelButoane.add(jButtonEditare);

        jPaneljos.add(jPanelTextFields);
        jPaneljos.add(jPanelButoane);
        pane.add(jPaneljos,BorderLayout.PAGE_END);


        System.out.println("Gata");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    private void intializareFereastraInitiala(){
        jFrame.dispose();

        jFrame=new JFrame();

        jFrame.setSize(600,200);
        BorderLayout borderLayout=new BorderLayout(5,5);
        jFrame.setBackground(Color.BLUE);
        jFrame.setLayout(borderLayout);
        jFrame.setVisible(true);
        jFrame.repaint();
        jFrame.revalidate();

        Container pane=jFrame.getContentPane();

        JPanel jPanelLocatii=new JPanel();
        JButton jButtonLocatii=new JButton("Acceseaza locatiile");
        jButtonLocatii.setSize(200,200);
        jButtonLocatii.addActionListener((e)->{
            jFrame.removeAll();
            jFrame.setVisible(false);
            initializareLocatii();

        }  );
        jPanelLocatii.add(jButtonLocatii);
        pane.add(jPanelLocatii,BorderLayout.PAGE_START);

        JPanel jPanelClienti=new JPanel();
        JButton jButtonClienti = new JButton("Acceseaza clientii");
        jButtonClienti.setSize(200,200);
        jButtonClienti.addActionListener((e)->{
            jFrame.removeAll();
            jFrame.setVisible(false);
            initializareClienti();
        });
        jPanelClienti.add(jButtonClienti);
        pane.add(jPanelClienti,BorderLayout.PAGE_END);

        JPanel jPanelFirmeProductie = new JPanel();
        jPanelFirmeProductie.setLayout(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        JButton jButtonFirmeProductie=new JButton("Acceseaza firmele de productie");
        jButtonFirmeProductie.setSize(200,200);
        jButtonFirmeProductie.addActionListener((e)->{
            jFrame.removeAll();
            jFrame.setVisible(false);
            initializareFirmeProductie();
        }  );
        jPanelFirmeProductie.add(jButtonFirmeProductie,gbc);
        pane.add(jPanelFirmeProductie,BorderLayout.LINE_START);

        JPanel jPanelFirmeScanare=new JPanel();
        jPanelFirmeScanare.setLayout(new GridBagLayout());
        JButton jButtonFirmeScanare=new JButton("Acceseaza firmele de scanare");
        jButtonFirmeScanare.setSize(200,200);
        jButtonFirmeScanare.addActionListener((e)->{
            jFrame.removeAll();
            jFrame.setVisible(false);
            initializareFirmeScanare();
        }  );
        jPanelFirmeScanare.add(jButtonFirmeScanare,gbc);
        pane.add(jPanelFirmeScanare,BorderLayout.LINE_END);


jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private MainSwing(){
        jFrame=new JFrame();
        intializareFereastraInitiala();

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(MainSwing::new);
    }

}
