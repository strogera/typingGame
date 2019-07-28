/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import static javax.management.timer.Timer.ONE_SECOND;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;

/**
 *
 * @author strogera
 */
public class typingGameGui extends javax.swing.JFrame {

    /**
     * Creates new form typingGameGui
     */
    public typingGameGui() {
        initComponents();
        //typing highlighting set up
        indexCorrect = 0;
        indexWrong = 0;
        cyanPainter = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
        redPainter = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.red);

        timeCounter = CountTime();
        //Countdown timer set up
        timer = new Timer((int) ONE_SECOND, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdown--;
                if (countdown == 0) {
                    inputTextField.setText("");
                    inputTextField.setHorizontalAlignment(SwingConstants.LEFT);
                    playAgainButton.setEnabled(true);
                    countdown = 4;
                    ((Timer) e.getSource()).stop();

                    inputTextField.setText("");
                    inputTextField.setEnabled(true);
                    timeCounter.start();

                    inputTextField.requestFocusInWindow();
                } else if (countdown == 3) {
                    inputTextField.setEnabled(false);
                    playAgainButton.setEnabled(false);
                    inputTextField.setHorizontalAlignment(SwingConstants.CENTER);
                    inputTextField.setDisabledTextColor(Color.red);
                    inputTextField.setText(String.valueOf(countdown));

                } else {
                    inputTextField.setText(String.valueOf(countdown));

                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jFileChooser1 = new javax.swing.JFileChooser();
        wps = new javax.swing.JPanel();
        currTimeCount = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textToType = new javax.swing.JTextArea();
        inputTextField = new javax.swing.JTextField();
        playAgainButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        OpenFileOption = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        setPreferredSize(new java.awt.Dimension(640, 640));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        currTimeCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        currTimeCount.setText("Time: - WPM: -");
        currTimeCount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout wpsLayout = new javax.swing.GroupLayout(wps);
        wps.setLayout(wpsLayout);
        wpsLayout.setHorizontalGroup(
            wpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(wpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(wpsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(currTimeCount)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        wpsLayout.setVerticalGroup(
            wpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(wpsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(wpsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(currTimeCount)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(wps);

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWeights = new double[] {0.1};
        jPanel2Layout.rowWeights = new double[] {0.1};
        jPanel2.setLayout(jPanel2Layout);

        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        textToType.setEditable(false);
        textToType.setColumns(20);
        textToType.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        textToType.setLineWrap(true);
        textToType.setRows(5);
        textToType.setText("hello world");
        textToType.setToolTipText("");
        textToType.setWrapStyleWord(true);
        textToType.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(textToType);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        jPanel2.add(jScrollPane1, gridBagConstraints);

        inputTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inputTextField.setEnabled(false);
        inputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputTextFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(inputTextField, gridBagConstraints);

        playAgainButton.setText("Play");
        javax.swing.SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                playAgainButton.requestFocusInWindow();
            }
        });
        playAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAgainButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanel2.add(playAgainButton, gridBagConstraints);

        getContentPane().add(jPanel2);

        jLabel1.setText("Statistics go here");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);

        jMenu1.setText("File");

        OpenFileOption.setText("Open File");
        OpenFileOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenFileOptionActionPerformed(evt);
            }
        });
        jMenu1.add(OpenFileOption);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAgainButtonActionPerformed
        //play button, whenever its pushed the game starts/restarts
        //restart highlight
        indexCorrect = 0;
        indexWrong = 0;
        numberOfWordsTyped = 0;
        textToType.getHighlighter().removeAllHighlights();
        inputTextField.setDisabledTextColor(Color.black);

        //timer takes some time to start
        inputTextField.setText("Loading..");

        currTimeCount.setText("Time: - WPM: -");
        //sec countdown
        countdown = 4;
        timer.start();

        //set button title when you hit play
        if (playAgainButton.getText().equals("Play")) {
            // timeCounter.start();

            playAgainButton.setText("Restart");
        } else {
            timeCounter.stop();
            countSecs = 0;
        }

    }//GEN-LAST:event_playAgainButtonActionPerformed

    private void inputTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextFieldKeyTyped
        char c = evt.getKeyChar();
        char[] text = textToType.getText().toCharArray();
        String tempInputText = inputTextField.getText();
        //build the input String with the typed character added
        StringBuilder sb = new StringBuilder();
        sb.append(tempInputText);
        if (c != '\n') { //enter is allowed to change words
            sb.append(c);
        } else {
            sb.append(' ');
        }
        tempInputText = sb.toString();
        char[] inputText = tempInputText.toCharArray();

        if (c == KeyEvent.VK_BACKSPACE) { //backspace
            if (inputText.length == 0) { //if the textfield is empty do nothing
                return;
            }
            //rebuild the input String without the character that is going to be deleted (last character)
            StringBuilder sb2 = new StringBuilder();
            sb2.append(tempInputText);
            sb2.setLength(sb.length() - 1);
            tempInputText = sb2.toString();
            inputText = tempInputText.toCharArray();
        }
        curWordCorrectCount = 0; //count how many characters in the input String is correct
        for (int i = 0; i < inputText.length; i++) {
            if (inputText[i] != text[indexCorrect + i]) {
                try {
                    textToType.getHighlighter().removeAllHighlights();
                    textToType.getHighlighter().addHighlight(0, indexCorrect + curWordCorrectCount, cyanPainter);
                    textToType.getHighlighter().addHighlight(indexCorrect + curWordCorrectCount, indexCorrect + inputText.length, redPainter);
                } catch (BadLocationException ble) {
                }
                return;
            } else {
                curWordCorrectCount++;
            }
        }
        try {
            textToType.getHighlighter().removeAllHighlights();
            textToType.getHighlighter().addHighlight(0, indexCorrect + curWordCorrectCount, cyanPainter);
        } catch (BadLocationException ble) {

        }

        if (((c == ' ' || c == '\n'))) { //go to the next word either by pressing space or enter when you complete a word
            evt.consume(); //don't show the space in the input text field, just change word
            inputTextField.setText("");
            indexCorrect += curWordCorrectCount;
            curWordCorrectCount = 0;
            numberOfWordsTyped++;
        }
        if (text.length == (indexCorrect + curWordCorrectCount)) { //end of game
            timeCounter.stop();
            countSecs = 0;
            numberOfWordsTyped++; //count last word
            inputTextField.setText("");
            inputTextField.setEnabled(false);
            playAgainButton.setText("Play");
        }

    }//GEN-LAST:event_inputTextFieldKeyTyped

    private void OpenFileOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenFileOptionActionPerformed
        // TODO add your handling code here:
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == jFileChooser1.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            try {

                String text = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                textToType.setText(text);
                playAgainButtonActionPerformed(null); ///
            } catch (IOException ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_OpenFileOptionActionPerformed

    private Timer CountTime() {
        Timer countTypingTime = new Timer((int) ONE_SECOND, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                countSecs++;
                StringBuilder sb = new StringBuilder();
                sb.append("Time: ");
                sb.append(String.valueOf(countSecs / 60));
                sb.append(":");
                if (countSecs % 60 >= 10) {
                    sb.append(String.valueOf(countSecs % 60));
                } else {
                    sb.append("0");
                    sb.append(String.valueOf(countSecs % 60));
                }
                sb.append(" WPM: ");
                sb.append(String.valueOf((60 * numberOfWordsTyped) / countSecs));
                //currTimeCount.setText("Time: " + String.valueOf(countSecs / 60) + ":" + String.valueOf(countSecs % 60) + "  WPM: " + String.valueOf((60 * numberOfWordsTyped) / countSecs));
                    currTimeCount.setText(sb.toString());
            }
        });
        return countTypingTime;
    }

    /**/
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
            java.util.logging.Logger.getLogger(typingGameGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(typingGameGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(typingGameGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(typingGameGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new typingGameGui().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem OpenFileOption;
    private javax.swing.JLabel currTimeCount;
    private javax.swing.JTextField inputTextField;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton playAgainButton;
    private javax.swing.JTextArea textToType;
    private javax.swing.JPanel wps;
    // End of variables declaration//GEN-END:variables
    private int indexCorrect, indexWrong, curWordCorrectCount = 0;
    private javax.swing.text.Highlighter.HighlightPainter cyanPainter;
    private javax.swing.text.Highlighter.HighlightPainter redPainter;
    private Timer timer, timeCounter;
    private int countdown = 4;
    private int countSecs = 0;
    private int numberOfWordsTyped = 0, currWordStart = 0;
    boolean emptyFieldFlag = true;
}
