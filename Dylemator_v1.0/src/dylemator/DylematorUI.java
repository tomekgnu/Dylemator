/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dylemator;

import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author a144899
 */
public class DylematorUI extends javax.swing.JFrame {
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private UserDialog ud = null;
    private final SelectionDialog sd = new SelectionDialog(this, true);
    private final QuestionDialog qd = new QuestionDialog(this,true);
    private FindDialog fd;
   // private final PreferencesDialog pd = new PreferencesDialog(this, true);
    private QuestionThread questionThread;
    private List<Dilemma> selectedDilemmas;    
    private List<Dilemma> warmupList;
    private final List<String> answers = new ArrayList<String>();
    private final List<Long> seconds = new ArrayList<Long>();
    private DisplayMode dispModeOld;
    private boolean fullscreen;
    private boolean threadRunning;
    private Thread threadObject;
       
    public DylematorUI() {
        super("Dylemator");
        initComponents();
        createUserDialog();
       
        sd.setRandom(false);
        sd.setWordsPerMinute(180);
       // this.textArea.setEditorKit(new MyEditorKit());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        textPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();
        answerPanel = new javax.swing.JPanel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        userMenuItem = new javax.swing.JMenuItem();
        questionsMenuItem = new javax.swing.JMenuItem();
        preferencesMenuItem = new javax.swing.JMenuItem();
        quitMenuItem = new javax.swing.JMenuItem();
        findMenu = new javax.swing.JMenu();
        allUsersMenuItem = new javax.swing.JMenuItem();
        findUserMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(759, 520));
        setName("mainFrame"); // NOI18N
        setResizable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Dylemator"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        textPanel.setFocusable(false);
        textPanel.setName("Tekst dylematu"); // NOI18N

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBar(null);

        textArea.setBackground(new java.awt.Color(238, 238, 238));
        textArea.setBorder(null);
        textArea.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textArea.setAutoscrolls(false);
        textArea.setFocusable(false);
        textArea.setMargin(new java.awt.Insets(0, 0, 0, 0));
        textArea.setPreferredSize(new java.awt.Dimension(0, 0));
        scrollPane.setViewportView(textArea);

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        answerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        answerPanel.setName("odpowiedz"); // NOI18N

        yesButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yesButton.setText("TAK");
        yesButton.setEnabled(false);
        yesButton.setFocusable(false);
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        noButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noButton.setText("NIE");
        noButton.setEnabled(false);
        noButton.setFocusable(false);
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });

        startButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        startButton.setText("START");
        startButton.setFocusable(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nextButton.setText(">>>");
        nextButton.setEnabled(false);
        nextButton.setFocusable(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout answerPanelLayout = new javax.swing.GroupLayout(answerPanel);
        answerPanel.setLayout(answerPanelLayout);
        answerPanelLayout.setHorizontalGroup(
            answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answerPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(noButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        answerPanelLayout.setVerticalGroup(
            answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(answerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainMenuBar.setFocusable(false);
        mainMenuBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mainMenuBar.setPreferredSize(new java.awt.Dimension(70, 30));

        mainMenu.setText("Plik");
        mainMenu.setFocusable(false);
        mainMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mainMenu.setIconTextGap(8);

        userMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        userMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userMenuItem.setText("Użytkownik");
        userMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(userMenuItem);

        questionsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        questionsMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        questionsMenuItem.setText("Wczytaj pytania");
        questionsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionsMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(questionsMenuItem);

        preferencesMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        preferencesMenuItem.setText("Ustawienia");
        preferencesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferencesMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(preferencesMenuItem);

        quitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quitMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        quitMenuItem.setText("Wyjście");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuItemActionPerformed(evt);
            }
        });
        mainMenu.add(quitMenuItem);

        mainMenuBar.add(mainMenu);

        findMenu.setText("Szukaj");

        allUsersMenuItem.setText("Lista badanych");
        allUsersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allUsersMenuItemActionPerformed(evt);
            }
        });
        findMenu.add(allUsersMenuItem);

        findUserMenuItem.setText("Znajdź użytkownika");
        findUserMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findUserMenuItemActionPerformed(evt);
            }
        });
        findMenu.add(findUserMenuItem);

        mainMenuBar.add(findMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(answerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(answerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Dylemator");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void createUserDialog(){
        ud = new UserDialog(this,true);
        int userInputWidth = ud.getWidth();
        int userInputHeight = ud.getHeight();
        int formInputWidth = this.getWidth();
        int formInputHeight = this.getHeight();
        int xposition = (formInputWidth - userInputWidth) / 2;
        int yposition = (formInputHeight - userInputHeight) / 2;
        Point p = new Point(xposition, yposition);
        ud.setLocation(p);
        
    }
    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
          this.questionThread.answer("TAK");

    }//GEN-LAST:event_yesButtonActionPerformed

    private void questionsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionsMenuItemActionPerformed
       JFileChooser f = new JFileChooser(System.getProperty("user.dir"));
       int result = f.showOpenDialog(this);
       if(result == JFileChooser.APPROVE_OPTION)
           this.file = f.getSelectedFile();
       else
           return;
       
        displayCenteredText("");
        
        QuestionParser parser = new QuestionParser(file);
        List<Dilemma> dList = parser.getDilemmaList();
        this.warmupList = parser.getWarmupList();
        qd.setDilemmas(dList);

        if(parser.isXmlFileOk() == true){
            qd.setVisible(true);
            qd.clearAll();
            this.startButton.setEnabled(true);
        }
        else{
            displayCenteredText("Plik jest niepoprawny!");
            return;
        }
         if(ud.getName() == null || ud.getName().isEmpty()){
             displayCenteredText("Wpisz dane użytkownika");
         }
         else{
             this.startButton.setText("START");
        }
            
    }//GEN-LAST:event_questionsMenuItemActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if(selectedDilemmas == null || selectedDilemmas.isEmpty()){
            displayCenteredText("Załaduj plik z pytaniami.");
            return;
        }
        if(ud.getName() == null || ud.getName().isEmpty()){
            ud.setVisible(true);
            return;
        }
        this.questionThread = new QuestionThread(this);
        this.answers.clear();
        this.threadObject = new Thread(this.questionThread);
        this.threadObject.start();  
    }//GEN-LAST:event_startButtonActionPerformed
    
    private void writeUserCode(){
        File userCodes = new File("Kody_osob.txt");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(userCodes,true));
            bufferedWriter.write(this.ud.getCode());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(DylematorUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void writeReport(){
        
        long deonCount = 0;
        long utilCount = 0;
        double deonTime = 0;
        double utilTime = 0;
        double totalTime = 0;
                
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
	String date = sdf.format(new Date()); 
        String[] questionsFile = this.file.getName().split("\\.");
	boolean newDate = false;
        File resultsFile = new File("Odpowiedzi_" + questionsFile[0] + "_" + date + ".csv");
        if(resultsFile.exists() == false){
            newDate = true;
        }        

        
        displayCenteredText("KONIEC BADANIA.\r\nDZIĘKUJEMY ZA UDZIAŁ.");
        
        for(Dilemma selected:selectedDilemmas ){
                System.out.println(selected);
                if("TAK".equals(selected.getAnswer())){
                    utilCount++;
                    utilTime += selected.getSeconds();
                }
                if("NIE".equals(selected.getAnswer())){
                    deonCount++;
                    deonTime += selected.getSeconds();
                }
                Long time = selected.getSeconds();
                totalTime += time;                
                
        }
       
        if(utilCount > 0){
            utilTime = ((double)utilTime / (double)utilCount);
            //utilTimeStr = String.format(new Locale("US"),"%.2f",utilTime);
            //this.textArea.append("\nŚredni czas decyzji utylitarnej (ms): " + utilTimeStr);            
        }
        if(deonCount > 0){
            deonTime = ((double)deonTime / (double)deonCount);
            //deonTimeStr = String.format(new Locale("US"),"%.2f",deonTime);
            //this.textArea.append("\nŚredni czas decyzji deontologicznej (ms): " + deonTimeStr);            
        }
               
        
        try {
            
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultsFile,true)));
            StringBuffer sb = new StringBuffer();
            if(newDate){
                String[] fields = new String[]{"Kod osoby","Data badania","Imię","Nazwisko","Wiek","Płeć","Miejsce zamieszkania",
                                               "Praworęczność","Lata edukacji","Urazy głowy","Leczenie neur.",
                                               "Leczenie psych.","Zażywa leki psych.","Kłopoty z pam.","Uzależnienia",
                                               "Decyzja utylitarna","Decyzja deontologiczna",
                                               "Średni czas decyzji utylitarnej (ms)",
                                               "Średni czas decyzji deontologicznej (ms)"};
               String fieldStr = StringUtils.join(fields,";");
               sb.append(fieldStr).append("\r\n");                
            }
            String[] userData = new String[]{ud.getCode(),date,ud.getName(),ud.getSurname(),
                                new Integer(ud.getAge()).toString(),
                                new Integer(ud.getGender()).toString(),
                                new Integer(ud.getPlace()).toString(),
                                new Integer(ud.getHandedness()).toString(),
                                new Integer(ud.getEducationYears()).toString(),
                                // Interview
                                 new Integer(ud.getHeadInjuries()).toString(),
                                new Integer(ud.getNeurotreatment()).toString(),
                                new Integer(ud.getPsychotreatment()).toString(),
                                new Integer(ud.getOnDrugs()).toString(),
                                new Integer(ud.getMemoryPb()).toString(),
                                new Integer(ud.getAddictions()).toString(),
                                new Long(utilCount).toString(),
                                new Long(deonCount).toString(),
                                new Double(utilTime).toString(),
                                new Double(deonTime).toString()
            
            };
            
            String userDataStr = StringUtils.join(userData,";");
            sb.append(userDataStr);    
            sb.append("\r\n");
            bufferedWriter.append(sb);
            bufferedWriter.flush();
            bufferedWriter.close();
            sb.delete(0, sb.length());
        } catch (IOException ex) {
            Logger.getLogger(DylematorUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String totalTimeStr = String.format(new Locale("US"),"%.2f",totalTime / 1000);
        //this.textArea.append("\nCałkowity czas: " + totalTimeStr + " sek.\n");
    }
    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
          this.questionThread.answer("NIE");

    }//GEN-LAST:event_noButtonActionPerformed

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void userMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMenuItemActionPerformed
        ud.setVisible(true);
        //this.questions.clear();
        this.seconds.clear();
        this.answers.clear();
        //this.texts.clear();
        displayCenteredText("");
        this.startButton.setEnabled(true);
        if(selectedDilemmas != null && selectedDilemmas.size() > 0){
           displayCenteredText("Aby rozpocząć naciśnij przycisk START lub klawisz S");
           this.startButton.setText("START");
        }
        else{
            displayCenteredText("Wczytaj plik z pytaniami.");
        }
        //this.startButton.setText("START");
    }//GEN-LAST:event_userMenuItemActionPerformed

    private void preferencesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferencesMenuItemActionPerformed
       sd.setVisible(true);
    }//GEN-LAST:event_preferencesMenuItemActionPerformed
    
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        char key = evt.getKeyChar();
        int keyCode = evt.getKeyCode();
        if(keyCode == 27){
           this.threadRunning = false;
           setFullscreen(false);
           mainMenuBar.setVisible(true);
           answerPanel.setVisible(true);
            
        }
        switch(key){
            case ' ':   if(this.questionThread != null){
                            synchronized(this.questionThread){
                            if(this.questionThread.readMode == true)
                                this.questionThread.notifyAll();
                            if(this.questionThread.nextTextMode == true)
                                this.questionThread.notifyAll();
                         }
                        }
                      break;
            case 'V':
            case 'v': if(this.questionThread.questionMode == true)
                        this.questionThread.answer("TAK");
                      break;
            case 'N':
            case 'n': if(this.questionThread.questionMode == true)
                        this.questionThread.answer("NIE");
                      break;
            case 'S':
            case 's': startButtonActionPerformed(null);
                      break;
//            case 'F': 
//            case 'f': this.setFullscreen(true);
//                      this.answerPanel.setVisible(false);
//                      firstScreen(0);
        }
    }//GEN-LAST:event_formKeyPressed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if(this.questionThread.nextTextMode == true){
            synchronized(this.questionThread){
                this.questionThread.notifyAll();
            }
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void findUserMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findUserMenuItemActionPerformed
        fd = new FindDialog(this,false);
        fd.setVisible(true);
    }//GEN-LAST:event_findUserMenuItemActionPerformed

    private void allUsersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allUsersMenuItemActionPerformed
       UserList ul = new UserList(this,true);
       ul.setVisible(true);
    }//GEN-LAST:event_allUsersMenuItemActionPerformed
    
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DylematorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DylematorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DylematorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DylematorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DylematorUI().setVisible(true);
                
            }
        });
    }
       
    File file = null;
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem allUsersMenuItem;
    private javax.swing.JPanel answerPanel;
    private javax.swing.JMenu findMenu;
    private javax.swing.JMenuItem findUserMenuItem;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton noButton;
    private javax.swing.JMenuItem preferencesMenuItem;
    private javax.swing.JMenuItem questionsMenuItem;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton startButton;
    private javax.swing.JTextPane textArea;
    private javax.swing.JPanel textPanel;
    private javax.swing.JMenuItem userMenuItem;
    private javax.swing.JButton yesButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    void setFontSize(float size){
        Font font = textArea.getFont().deriveFont(size);
        textArea.setFont(font);
        
    }
    void setSelectedNumbers(List<Dilemma> list){
        this.selectedDilemmas = list;
    }
    private void warmupScreen(){
        displayCenteredText("ZAPOZNAJ SIĘ Z NASTĘPUJĄCYMI SYTUACJAMI I ODPOWIEDZ NA PYTANIA WCISKAJĄC NA KLAWIATURZE PRZYCISK \"TAK\" LUB \"NIE\".\n\n" + 
                    "Aby rozpocząć, naciśnij spację.");
    }
    private void firstScreen(int decision) {
        if(decision == 1){
            displayCenteredText("ZA CHWILĘ ZOBACZYSZ NA EKRANIE OPIS PEWNEJ SYTUACJI. ZARAZ PO JEGO PRZECZYTANIU NACIŚNIJ SPACJĘ. " +
            "PO NACIŚNIĘCIU SPACJI NA EKRANIE POJAWI SIĘ PYTANIE ODNOSZĄCE SIĘ DO SYTUACJI, KTÓRĄ PRZECZYTAŁEŚ. " +
            "SZYBKO ODPOWIEDZ NA PYTANIE WCISKAJĄC OPOWIEDNI PRZYCISK NA KLAWIATURZE.\nAby rozpocząć, naciśnij spację.");
        }
        else{
            displayCenteredText("ZA CHWILĘ ZOBACZYSZ NA EKRANIE OPIS PEWNEJ SYTUACJI. " +
            "PO CHWILI OPIS ZNIKNIE I POJAWI SIĘ PYTANIE ODNOSZĄCE SIĘ DO SYTUACJI, KTÓRĄ PRZECZYTAŁEŚ. " +
            "SZYBKO ODPOWIEDZ NA PYTANIE WCISKAJĄC OPOWIEDNI PRZYCISK NA KLAWIATURZE.\nAby rozpocząć, naciśnij spację.");
        }
    }
    
   private void displayCenteredText(String text){
            textArea.setText("");
            text = "\n\n\n" + text;
            SimpleAttributeSet attribs = new SimpleAttributeSet();
            float fnt = sd.getFontSize();
            StyledDocument doc = (StyledDocument) textArea.getDocument();
            Style style = doc.getStyle(StyleContext.DEFAULT_STYLE);//doc.addStyle("MyStyle",null);
            StyleConstants.setFontSize(style, (int) fnt);
            StyleConstants.setLineSpacing(attribs,0.5f);
            StyleConstants.setFontFamily(style, "Segoe UI");
            StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER);
            textArea.setParagraphAttributes(attribs,true);
            
        try {
              doc.insertString(doc.getLength(), text, style);
              doc.setParagraphAttributes(0, doc.getLength()-1, attribs, false);
        } catch (BadLocationException ex) {
            Logger.getLogger(DylematorUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            
   }
    public void setFullscreen( boolean fullscreen )
    {
        //get a reference to the device.
        GraphicsDevice device  = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        DisplayMode dispMode = device.getDisplayMode();
        //save the old display mode before changing it.
        dispModeOld = device.getDisplayMode();

        if( this.fullscreen != fullscreen )
        { //are we actually changing modes.
            //change modes.
            this.fullscreen = fullscreen;
            // toggle fullscreen mode
            if( !fullscreen )
            {
                //change to windowed mode.
                //set the display mode back to the what it was when
                //the program was launched.
                device.setDisplayMode(dispModeOld);
                //hide the frame so we can change it.
                setVisible(false);
                //remove the frame from being displayable.
                dispose();
                //put the borders back on the frame.
                setUndecorated(false);
                //needed to unset this window as the fullscreen window.
                device.setFullScreenWindow(null);
                //recenter window
                setLocationRelativeTo(null);
                setResizable(true);

                //reset the display mode to what it was before
                //we changed it.
                setVisible(true);

            }
            else
            { //change to fullscreen.
                //hide everything
                setVisible(false);
                //remove the frame from being displayable.
                dispose();
                //remove borders around the frame
                setUndecorated(true);
                //make the window fullscreen.
                device.setFullScreenWindow(this);
                //attempt to change the screen resolution.
                device.setDisplayMode(dispMode);
                setResizable(false);
                setAlwaysOnTop(false);
                //show the frame
                setVisible(true);
            }
            //make sure that the screen is refreshed.
            repaint();
        }
    }

    
           
    class QuestionThread implements Runnable{
        private DylematorUI parent;
        private int currentQuestion = 0;
        private int count = 0;
        private int wordCount = 0;
        private boolean questionMode = false;
        private boolean readMode = false;
        private boolean nextTextMode = false;
        private List<Dilemma> tmpList;
        
        public QuestionThread(DylematorUI p){
            parent = p;
        }
        @Override
        public void run() {
            setFullscreen(true);
            threadRunning = true;
            parent.mainMenuBar.setVisible(false);
            parent.answerPanel.setVisible(false);
            // pytania i dylematy wg rozbiegowki
            if(sd.getWarmups() == true){
                try{
                        synchronized(this){
                            
                            this.nextTextMode = true;
                            warmupScreen();
                            wait();
                            this.nextTextMode = false;
                        }
                    }  
                    catch(InterruptedException ex){
                
                    }
                 currentQuestion = 0;
                 tmpList = warmupList;
                 count = warmupList.size();
                 questionLoop();
            }
                
        if(sd.getRandom() == true){
             long seed = System.nanoTime();
              Collections.shuffle(selectedDilemmas, new Random(seed));
        }
                
        currentQuestion = 0;
        count = selectedDilemmas.size();  
        tmpList = selectedDilemmas;
        
        try{
            synchronized(this)
            {
                this.nextTextMode = true;
                firstScreen(sd.getDecision());
                wait();
                this.nextTextMode = false;
            }
        }  
        catch(InterruptedException ex){
                
        }
        
        questionLoop();
        try{
            if(currentQuestion == count && count != 0){
                writeUserCode();
                writeReport();
         }
        }
         catch(Exception ex){
             System.out.println(ex.toString());
         }
        
        
  }
    
        synchronized void answer(String s){
            tmpList.get(currentQuestion).setAnswer(s);
            notifyAll();
            yesButton.setEnabled(false);
            noButton.setEnabled(false);
            
        }
       
        
        synchronized private void waitForNextText() throws InterruptedException{
            if(threadRunning == false)
                return;
            nextTextMode = true;
            displayCenteredText("Naciśnij spację");
            nextButton.setEnabled(true);
            wait();
            nextButton.setEnabled(false);
            nextTextMode = false;
        }
        
        synchronized private void readQuestion() throws InterruptedException {
            if(threadRunning == false)
                return;
            yesButton.setEnabled(true);
            noButton.setEnabled(true);
            displayCenteredText(tmpList.get(currentQuestion).getQuestion());
            long startTime = new Date().getTime();
            questionMode = true;
            wait();
            questionMode = false;
            long endTime = new Date().getTime();
            tmpList.get(currentQuestion).setSeconds(endTime - startTime);
        }
        
        synchronized private int readDilemma() {
            if(threadRunning == false)
                return 0;
            yesButton.setEnabled(false);
            noButton.setEnabled(false);
            String text = tmpList.get(currentQuestion).getProblem();
            displayCenteredText(text);
            return new StringTokenizer(text).countTokens();     
        }
        synchronized private int readDescription() {
            if(threadRunning == false)
                return 0;
            yesButton.setEnabled(false);
            noButton.setEnabled(false);
            String text = tmpList.get(currentQuestion).getDescription();
            displayCenteredText(text);
            return new StringTokenizer(text).countTokens();
        }
        
        
        private void questionLoop() {
            int waitMilliseconds = 0;
             while(threadRunning == true && currentQuestion < count){
                try {
                    readMode = true;
                    wordCount = readDescription();
                    waitMilliseconds = wordCount *  60000 / sd.getWordsPerMinute();
                    if(sd.getDecision() == 0){
                        
                       Thread.sleep(waitMilliseconds);                       
                    }
                    else{
                            synchronized(this){
                            wait();
                         }
                    }
                    wordCount = readDilemma();
                    waitMilliseconds = wordCount *  60000 / sd.getWordsPerMinute();
                    if(sd.getDecision() == 0){                       
                       Thread.sleep(waitMilliseconds);                       
                    }
                    else{
                            synchronized(this){
                            wait();
                         }
                    }
                    readMode = false;
                    readQuestion();
                    waitForNextText();
                    currentQuestion++;
                    
                    
                 } catch (InterruptedException ex) {
                    Logger.getLogger(DylematorUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
        }

        
     }   
}