import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Page3Boutton2_Boutton1 {
    private JTextField textSize3;
    private JLabel matrixLabel3,matrixLabel4,resultMatrixLabel;
    private MatrixClass matrix3,matrix4;
    private JMenuBar menuBar = new JMenuBar();
    private JMenuBar menuBar2 = new JMenuBar();
    private String type01,type02;
    private JMenu TypeMenu = new JMenu("Type de la matrice");
    private JMenu TypeMenu2 = new JMenu("Type de la matrice");
    private double[][] matriceInverse ;
     public void intializePage12P3(){
        JLabel labelTitre= new JLabel("                             Page Multiplication matrice matrice:");
        labelTitre.setFont(Application.MAIN_FONT);
        labelTitre.setForeground(Color.WHITE);
        // saisir la taille
         JLabel labelT2= new JLabel("type de matrice 1:");
        labelT2.setFont(Application.MAIN_FONT);
        labelT2.setForeground(Color.WHITE);
         JLabel labelT1= new JLabel("type de matrice 2:");
        labelT1.setFont(Application.MAIN_FONT);
        labelT1.setForeground(Color.WHITE);
        JLabel labelSize2= new JLabel("Size:");
        labelSize2.setFont(Application.MAIN_FONT);
        labelSize2.setForeground(Color.WHITE);
        textSize3=new JTextField();
        textSize3.setFont(Application.MAIN_FONT);
        afficheMenu();
        afficheMenu2();
        JPanel pan=new JPanel();
        pan.setOpaque(false);
        JPanel entrePanel2= new JPanel();
        entrePanel2.setLayout(new GridLayout(4,1,5,5));
        entrePanel2.setOpaque(false);
        entrePanel2.add(labelTitre);
        entrePanel2.add(pan);
        entrePanel2.add(labelT2);
        entrePanel2.add(menuBar);
        entrePanel2.add(labelT1);
        entrePanel2.add(menuBar2);
        entrePanel2.add(labelSize2);
        entrePanel2.add(textSize3);
        
        JPanel entreGlobPanel= new JPanel( new BorderLayout());
        entreGlobPanel.setOpaque(false);
        entreGlobPanel.add(entrePanel2,BorderLayout.CENTER);

        matrixLabel3 = new JLabel();
        matrixLabel3.setFont(Application.MAIN_FONT);
        matrixLabel3.setForeground(Color.WHITE);
        matrixLabel4 = new JLabel();
        matrixLabel4.setFont(Application.MAIN_FONT);
        matrixLabel4.setForeground(Color.WHITE);
        resultMatrixLabel = new JLabel();
        resultMatrixLabel.setFont(Application.MAIN_FONT);
        resultMatrixLabel.setForeground(Color.WHITE);

        JButton buttonMatrix4 = new JButton("créer matrice 1");
        buttonMatrix4.setFont(Application.MAIN_FONT);
        buttonMatrix4.setBackground(new Color(0, 139, 139));
        buttonMatrix4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                int size=Integer.parseInt(textSize3.getText());
                if (type01.equals("bande")||type01.equals("bandeSup") ||type01.equals("bandeInf")) {
                    int maxLarge = (size - 1) / 2;
                    while (true) {
                        String input = JOptionPane.showInputDialog(null, "Entrez la largeur :");
                        try {
                            int number = Integer.parseInt(input);
                            if (number <= maxLarge) {
                                MatrixClass.setBandWith(number);
                                break; // Sort de la boucle while car la saisie est valide
                            } else {
                                Application.playSoundError();
                                JOptionPane.showMessageDialog(null, "La largeur doit être inférieure ou égale à " + maxLarge);
                            }
                        } catch (NumberFormatException ex) {
                            Application.playSoundError();
                            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                Application.playSoundbut();
                matrix4= new MatrixClass(type01, size);
                 String ch = matrix4.afficheMatrix();
                ch = ch.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
                ch = ch.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                ch = ch.replaceAll("</td></tr>", "</td></tr><br>");  // Ajoutez un retour à la ligne après chaque ligne
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");

                matrixLabel4.setText("<html>" + ch + "</html>");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton lireMatrix4 = new JButton("lire matrice1");
        lireMatrix4.setFont(Application.MAIN_FONT);
        lireMatrix4.setBackground(new Color(0, 139, 139));
        lireMatrix4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                int size=Integer.parseInt(textSize3.getText());
                if (type01.equals("bande")||type01.equals("bandeSup") ||type01.equals("bandeInf")) {
                    int maxLarge = (size - 1) / 2;
                    while (true) {
                        String input = JOptionPane.showInputDialog(null, "Entrez la largeur :");
                        try {
                            int number = Integer.parseInt(input);
                            if (number <= maxLarge) {
                                MatrixClass.setBandWith(number);
                                break; // Sort de la boucle while car la saisie est valide
                            } else {
                                Application.playSoundError();
                                JOptionPane.showMessageDialog(null, "La largeur doit être inférieure ou égale à " + maxLarge);
                            }
                        } catch (NumberFormatException ex) {
                            Application.playSoundError();
                            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                LectureMatrix lectMat1=new LectureMatrix(type01, size);
                matrix4= new MatrixClass(type01, size,lectMat1.convertirMatriceEntiers());
                String ch = matrix4.afficheMatrix();
                ch = ch.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
                ch = ch.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                ch = ch.replaceAll("</td></tr>", "</td></tr><br>");  // Ajoutez un retour à la ligne après chaque ligne
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");

                matrixLabel4.setText("<html>" + ch + "</html>");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton buttonmatrix3 = new JButton("créer matrice 2");
        buttonmatrix3.setFont(Application.MAIN_FONT);
        buttonmatrix3.setBackground(new Color(0, 139, 139));
        buttonmatrix3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                int size=Integer.parseInt(textSize3.getText());
                if (type02.equals("bande")||type02.equals("bandeSup") ||type02.equals("bandeInf")) {
                    int maxLarge = (size - 1) / 2;
                    while (true) {
                        String input = JOptionPane.showInputDialog(null, "Entrez la largeur :");
                        try {
                            int number = Integer.parseInt(input);
                            if (number <= maxLarge) {
                                MatrixClass.setBandWith(number);
                                break; // Sort de la boucle while car la saisie est valide
                            } else {
                                Application.playSoundError();
                                JOptionPane.showMessageDialog(null, "La largeur doit être inférieure ou égale à " + maxLarge);
                            }
                        } catch (NumberFormatException ex) {
                            Application.playSoundError();
                            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                Application.playSoundbut();
                matrix3= new MatrixClass(type02, size);
                String ch = matrix3.afficheMatrix();
                ch = ch.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
                ch = ch.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                ch = ch.replaceAll("</td></tr>", "</td></tr><br>");  // Ajoutez un retour à la ligne après chaque ligne
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");

                matrixLabel3.setText("<html>" + ch + "</html>");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton lirematrix3 = new JButton("lire matrice2 ");
        lirematrix3.setFont(Application.MAIN_FONT);
        lirematrix3.setBackground(new Color(0, 139, 139));
        lirematrix3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                int size=Integer.parseInt(textSize3.getText());
                if (type02.equals("bande")||type02.equals("bandeSup") ||type02.equals("bandeInf")) {
                    int maxLarge = (size - 1) / 2;
                    while (true) {
                        String input = JOptionPane.showInputDialog(null, "Entrez la largeur :");
                        try {
                            int number = Integer.parseInt(input);
                            if (number <= maxLarge) {
                                MatrixClass.setBandWith(number);
                                break; // Sort de la boucle while car la saisie est valide
                            } else {
                                Application.playSoundError();
                                JOptionPane.showMessageDialog(null, "La largeur doit être inférieure ou égale à " + maxLarge);
                            }
                        } catch (NumberFormatException ex) {
                            Application.playSoundError();
                            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                LectureMatrix lectmat2=new LectureMatrix(type02, size);
                matrix3= new MatrixClass(type02, size,lectmat2.convertirMatriceEntiers());
                String ch = matrix3.afficheMatrix();
                ch = ch.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                ch = ch.replaceAll("</td></tr>", "</td></tr><br>");  // Ajoutez un retour à la ligne après chaque ligne

                matrixLabel3.setText("<html>" + ch + "</html>");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton inverseButton = new JButton("Calculer l'inverse ");
        inverseButton.setFont(Application.MAIN_FONT);
        inverseButton.setBackground(new Color(0, 139, 139));
        inverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                if (matrix4 != null ) {
                    int n=matrix4.getSize();
                    matriceInverse =new double[n][n];
                    matriceInverse=matrix4.inverse(); // Calculez l'inverse de la matrice
                    String inverseMatrix = matrix4.afficheInverse(); // Obtenez la représentation HTML de la matrice inverse
                    inverseMatrix = inverseMatrix.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                    inverseMatrix = inverseMatrix.replaceAll("</td></tr>", "</td></tr><br>");  // Ajoutez un retour à la ligne après chaque ligne
                    matrixLabel3.setText("<html>" + inverseMatrix + "</html>");
                } else {
                    Application.playSoundError();
                    // Si la matrice n'est pas de type "dense", vous pouvez afficher un message indiquant que l'inversion n'est pas prise en charge pour ce type de matrice.
                    JOptionPane.showMessageDialog(null, "L'inversion n'est pas prise en charge pour ce type de matrice.");
                }
            }
        });
        
        JButton buttonmultp = new JButton("Resultat Multiplication");
        buttonmultp.setFont(Application.MAIN_FONT);
        buttonmultp.setBackground(new Color(0, 139, 139));
        buttonmultp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                if(matriceInverse !=null ){
                MultiplicationMatrixMatrix m=new MultiplicationMatrixMatrix(matrix4, matriceInverse);
                String ch = m.affichemultipInverse();
                ch = ch.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                ch = ch.replaceAll("</td></tr>", "</td></tr><br>");

                resultMatrixLabel.setText("<html>" + ch + "</html>");
                }else{
                MultiplicationMatrixMatrix m= new MultiplicationMatrixMatrix(matrix4,matrix3);
                String ch = m.afficheMatrix();
                ch = ch.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                ch = ch.replaceAll("</td></tr>", "</td></tr><br>");  

                resultMatrixLabel.setText("<html>" + ch + "</html>");
                }
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton pagePreButton = new JButton("<-- Page Principale");
        pagePreButton.setFont(Application.MAIN_FONT);
        pagePreButton.setBackground(new Color(0, 139, 139));

        // Ajoutez un ActionListener au bouton pour revenir à la première "page"
        pagePreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                Application.cardLayout.show( Application.cardPanel,"page1");
            }
        });
        JButton clearButton = new JButton("Effacer Contenu");
        clearButton.setFont(Application.MAIN_FONT);
        clearButton.setBackground(new Color(0, 139, 139));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                // Réinitialiser les composants
                TypeMenu.setText("type de la matrice");
                textSize3.setText("");
                matrixLabel3.setText("");
                matrixLabel4.setText("");
                resultMatrixLabel.setText("");

                // Remettre à zéro les objets vect2 et matrix2 si nécessaire
                matrix4= null;
                matrix3 = null;
            }
        });



        JPanel buttonGlob= new JPanel();
        buttonGlob.setLayout(new GridLayout(2,2,5,5));
        buttonGlob.setOpaque(false);
        buttonGlob.add(clearButton); 
        buttonGlob.add(buttonMatrix4);
        buttonGlob.add(buttonmatrix3);
        buttonGlob.add(inverseButton);
        buttonGlob.add(pagePreButton);
        buttonGlob.add(lireMatrix4);
        buttonGlob.add(lirematrix3);
        buttonGlob.add(buttonmultp);
        

        

        JPanel matPanel= new JPanel();
        matPanel.setOpaque(false);
        matPanel.add(matrixLabel4);

        JPanel matPanel2 = new JPanel();
        matPanel2.setOpaque(false);
        matPanel2.add(matrixLabel3);

        JPanel resultPanel= new JPanel();
        resultPanel.setOpaque(false);
        resultPanel.add(resultMatrixLabel);

        
        JPanel descriPanelMultiplication2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 50));
        descriPanelMultiplication2.setOpaque(false);
        descriPanelMultiplication2.add(matPanel);
        descriPanelMultiplication2.add(matPanel2);
        descriPanelMultiplication2.add(resultPanel);


        JPanel viewportBackgroundPanel = new JPanel();
        viewportBackgroundPanel.setOpaque(false);
        viewportBackgroundPanel.setLayout(new BorderLayout());
        viewportBackgroundPanel.add(descriPanelMultiplication2, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(viewportBackgroundPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        ImageIcon backgroundImage = new ImageIcon("./image2.gif");


        // Création du JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(990, 760));

        // Panneau pour l'image en arrière-plan
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        imagePanel.setBounds(0, 0, 990, 760);

        // Panneau pour les boutons superposés
        JPanel page5 = new JPanel(new BorderLayout());
        page5.setOpaque(false);
        page5.setBounds(0, 0, 1000, 750);
        page5.add(entreGlobPanel, BorderLayout.NORTH);
        page5.add(scrollPane,BorderLayout.CENTER);
        page5.add(buttonGlob,BorderLayout.SOUTH);




        // Ajout des panneaux au JLayeredPane
        layeredPane.add(imagePanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(page5, JLayeredPane.PALETTE_LAYER);

        Application.cardPanel.add(layeredPane, "page5");
    }
    public void afficheMenu(){
        
        TypeMenu.setFont(Application.MAIN_FONT);
        JMenuItem MenuItem1 = new JMenuItem("Triangulaire Superieur");
        MenuItem1.setFont(Application.MAIN_FONT);
        MenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="triangsup";
                TypeMenu.setText(MenuItem1.getText());
            }
        });
        TypeMenu.add(MenuItem1);
        JMenuItem MenuItem2 = new JMenuItem("Triangulaire Inferieur");
        MenuItem2.setFont(Application.MAIN_FONT);
        MenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="trianginf";
                TypeMenu.setText(MenuItem2.getText());
            }
        });
        TypeMenu.add(MenuItem2);
        JMenuItem MenuItem3 = new JMenuItem("Dense");
        MenuItem3.setFont(Application.MAIN_FONT);
        MenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="dense";
                TypeMenu.setText(MenuItem3.getText());
            }
        });
        TypeMenu.add(MenuItem3);
        JMenuItem MenuItem4 = new JMenuItem("Bande");
        MenuItem4.setFont(Application.MAIN_FONT);
        MenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="bande";
                TypeMenu.setText(MenuItem4.getText());
            }
        });
        TypeMenu.add(MenuItem4);
        JMenuItem MenuItem5 = new JMenuItem("Bande Superieur");
        MenuItem5.setFont(Application.MAIN_FONT);
        MenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="bandeSup";
                TypeMenu.setText(MenuItem5.getText());
            }
        });
        TypeMenu.add(MenuItem5);
        JMenuItem MenuItem6 = new JMenuItem("Bande Inferieur");
        MenuItem6.setFont(Application.MAIN_FONT);
        MenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="bandeInf";
                TypeMenu.setText(MenuItem6.getText());
            }
        });
        TypeMenu.add(MenuItem6);
        JMenuItem MenuItem7 = new JMenuItem("Symetrique");
        MenuItem7.setFont(Application.MAIN_FONT);
        MenuItem7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="symetrique";
                TypeMenu.setText(MenuItem7.getText());
            }
        });
        TypeMenu.add(MenuItem7);

        JMenuItem MenuItem8 = new JMenuItem("Creuse ");
        MenuItem8.setFont(Application.MAIN_FONT);
        MenuItem8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="creuse";
                TypeMenu.setText(MenuItem8.getText());
            }
        });
        TypeMenu.add(MenuItem8);

        JMenuItem MenuItem9 = new JMenuItem("Symetrique Definie Positive ");
        MenuItem9.setFont(Application.MAIN_FONT);
        MenuItem9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="symetrique definiePositive";
                TypeMenu.setText(MenuItem9.getText());
            }
        });
        TypeMenu.add(MenuItem9);

        JMenuItem MenuItem10 = new JMenuItem("Definie Positive ");
        MenuItem10.setFont(Application.MAIN_FONT);
        MenuItem10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type01="definiePositive";
                TypeMenu.setText(MenuItem10.getText());
            }
        });
        TypeMenu.add(MenuItem10);
        menuBar.add(TypeMenu);
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.DARK_GRAY);
        menuBar.setPreferredSize(new Dimension(100,50));;

    }
    public void afficheMenu2(){
        
        TypeMenu2.setFont(Application.MAIN_FONT);
        JMenuItem MenuItem1 = new JMenuItem("Triangulaire Superieur");
        MenuItem1.setFont(Application.MAIN_FONT);
        MenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="triangsup";
                TypeMenu2.setText(MenuItem1.getText());
            }
        });
        TypeMenu2.add(MenuItem1);
        JMenuItem MenuItem2 = new JMenuItem("Triangulaire Inferieur");
        MenuItem2.setFont(Application.MAIN_FONT);
        MenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="trianginf";
                TypeMenu2.setText(MenuItem2.getText());
            }
        });
        TypeMenu2.add(MenuItem2);
        JMenuItem MenuItem3 = new JMenuItem("Dense");
        MenuItem3.setFont(Application.MAIN_FONT);
        MenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="dense";
                TypeMenu2.setText(MenuItem3.getText());
            }
        });
        TypeMenu2.add(MenuItem3);
        JMenuItem MenuItem4 = new JMenuItem("Bande");
        MenuItem4.setFont(Application.MAIN_FONT);
        MenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="bande";
                TypeMenu2.setText(MenuItem4.getText());
            }
        });
        TypeMenu2.add(MenuItem4);
        JMenuItem MenuItem5 = new JMenuItem("Bande Superieur");
        MenuItem5.setFont(Application.MAIN_FONT);
        MenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="bandeSup";
                TypeMenu2.setText(MenuItem5.getText());
            }
        });
        TypeMenu2.add(MenuItem5);
        JMenuItem MenuItem6 = new JMenuItem("Bande Inferieur");
        MenuItem6.setFont(Application.MAIN_FONT);
        MenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="bandeInf";
                TypeMenu2.setText(MenuItem6.getText());
            }
        });;
        TypeMenu2.add(MenuItem6);
        JMenuItem MenuItem7 = new JMenuItem("Symetrique");
        MenuItem7.setFont(Application.MAIN_FONT);
        MenuItem7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="symetrique";
                TypeMenu2.setText(MenuItem7.getText());
            }
        });
        TypeMenu2.add(MenuItem7);

        JMenuItem MenuItem8 = new JMenuItem("Creuse ");
        MenuItem8.setFont(Application.MAIN_FONT);
        MenuItem8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="creuse";
                TypeMenu2.setText(MenuItem8.getText());
            }
        });
        TypeMenu2.add(MenuItem8);

        JMenuItem MenuItem9 = new JMenuItem("Symetrique Definie Positive ");
        MenuItem9.setFont(Application.MAIN_FONT);
        MenuItem9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="symetrique definiePositive";
                TypeMenu2.setText(MenuItem9.getText());
            }
        });
        TypeMenu2.add(MenuItem9);

        JMenuItem MenuItem10 = new JMenuItem("Definie Positive ");
        MenuItem10.setFont(Application.MAIN_FONT);
        MenuItem10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type02="definiePositive";
                TypeMenu2.setText(MenuItem10.getText());
            }
        });
        TypeMenu2.add(MenuItem10);
        menuBar2.add(TypeMenu2);
        menuBar2.setOpaque(true);
        menuBar2.setBackground(Color.DARK_GRAY);
        menuBar2.setPreferredSize(new Dimension(100,50));

    }
    
    
}
