import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class problem4extra extends JPanel
                           implements ActionListener
{
    private static JPasswordField pf;
    private static JCheckBox cb;
    private static JFrame controllingFrame;
    private static JLabel l;

    protected JComponent createButtonPanel() { //Good
        JPanel p = new JPanel(new GridLayout(0,1));
        JButton okButton = new JButton("OK");

        okButton.setActionCommand("OK");
        okButton.addActionListener(this);

        p.add(okButton);

        return p;
    }

    public problem4extra(JFrame f)
    {
        controllingFrame = f;

        //Initialize variables
        pf = new JPasswordField(20);
        pf.setActionCommand("OK");
        pf.addActionListener(this);

        cb = new JCheckBox("Show password");
        
        l = new JLabel("A valid password is one with at least 6 characters and at least one non-alphanumeric character (+, -, *, /, or @).\n Enter a valid password: ");
        l.setLabelFor(pf);

        JComponent buttonPane  = createButtonPanel();

        //Configure show password function
        cb.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            pf.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
        });

        //Lay out everything
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(l);
        textPane.add(pf);

        add(textPane);
        add(buttonPane);
        add(cb);
    }
    

    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        
        if (cmd == "OK")
        {
            char[] input = pf.getPassword();
            if (isPasswordValid(input)) 
            {
                JOptionPane.showMessageDialog(controllingFrame, "Password verified!");
            }
            else 
            {
                JOptionPane.showMessageDialog(controllingFrame, "Please check that your password is at least 6 characters long AND contains at least one non-alphanumeric character (+, -, *, /, or @).");
            }
            pf.selectAll();
            resetFocus();
        }
    }

    private static boolean isPasswordValid(char[] input) //Good
    {
        boolean isCorrect = true;
        String password = "";
        for(char c : input)
        {
            password += c;
        }

        if(password.length() < 5)
        {
            return false;
        }

        boolean noChar = true;
        Set<String> characters = new HashSet<String>();
        characters.add("+");
        characters.add("-");
        characters.add("*");
        characters.add("/");
        characters.add("@");

        outerloop:
        while(noChar)
        {
            for(int i = 0; i < password.length(); i++)
            {
                String s = password.substring(i, i + 1);
                if(characters.contains(s))
                {
                    isCorrect = true;
                    break outerloop; 
                }
            }
            isCorrect = false;
            noChar = false;
        }

        return isCorrect;
    }

    protected void resetFocus() //Good
    {
        pf.requestFocusInWindow();
    }

    private static void createAndShowGUI() //Good
    {
        //Create and set up the window.
        JFrame f = new JFrame("Password");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        final problem4extra newContentPane = new problem4extra(f);
        newContentPane.setOpaque(true); //content panes must be opaque
        f.setContentPane(newContentPane);

        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        f.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });

        //Display the window.
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		createAndShowGUI();
            }
        });
    }
}
