package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import services.AppService;


public class MainSwing {
    JFrame jFrame;
    AppService appService=AppService.getInstance();
    private void initializareLocatii(){
        jFrame.setVisible(true);
    }
    private void initializareClienti(){
        jFrame.setVisible(true);

    }
    private void initializareFirmeProductie(){
        jFrame.setVisible(true);

    }
    private void initializareFirmeScanare(){
        jFrame.setVisible(true);

    }
    private void initializareEvenimente(){
        jFrame.setVisible(true);

    }
    private void initializareComenzi(){
        jFrame.setVisible(true);

    }

    private void intializareFereastraInitiala(){
        BorderLayout borderLayout=new BorderLayout(5,5);
        jFrame.setBackground(Color.BLUE);
        jFrame.setLayout(borderLayout);
        jFrame.setVisible(true);

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

        JPanel jPanelCentru = new JPanel();
        GridBagLayout gridBagLayout=new GridBagLayout();
        jPanelCentru.setLayout(gridBagLayout);

        JButton jButtonComenzi=new JButton("Acceseaza comenzile");
        jButtonComenzi.setSize(200,200);
        jButtonComenzi.addActionListener((e)->{
            jFrame.removeAll();
            jFrame.setVisible(false);
            initializareComenzi();
        }  );
        jPanelCentru.add(jButtonComenzi,gbc);

        JButton jButtonEvenimente=new JButton("Acceseaza evenimentele");
        jButtonEvenimente.setSize(200,200);
        jButtonEvenimente.addActionListener((e)->{
            jFrame.removeAll();
            jFrame.setVisible(false);
            initializareEvenimente();
        }  );
        jPanelCentru.add(jButtonEvenimente,gbc);
        pane.add(jPanelCentru,BorderLayout.CENTER);

jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private MainSwing(){
        jFrame=new JFrame();
        jFrame.setSize(1920,980);
        intializareFereastraInitiala();

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(MainSwing::new);
    }

}
