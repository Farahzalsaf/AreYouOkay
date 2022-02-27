import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class JFrameWindow {
    
    private final int minimmumXButtonPos= 150;
    private final int maxXButtionPos = 200;
    private final int minYButtonPos = 100;
    private final int maxYbuttonPos = 200;

    private int windowWidth;
    private int windowHeight;

    private Font font;

    public JFrame frame;
    public JButton YesButton;
    public JButton NoButton;
    public JTextField mTextField;

    Timer time = new Timer();

    //The constructor will initialize our windows with given in input parameters, our parameters are the width and height 
    
    JFrameWindow(int width, int height) {
        windowWidth = width;
        windowHeight = height;

        frame = new JFrame();
        YesButton = new JButton("Yes");
        NoButton = new JButton("No");
        mTextField = new JTextField("Are u Okay?");
        font = new Font("SansSerif", Font.BOLD, 40);

        setTextField();
        setButtons();
        setFrame();


        //define the actionListeners on the buttons
        YesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
            	mTextField.setBounds(0,100,300,50);	
                mTextField.setText("YAY! :D");
                YesButton.setVisible(false);
                NoButton.setVisible(false);
                startCountDown();
            }
        });

        NoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int randomX = (int) Math.floor(Math.random()*(maxXButtionPos-minimmumXButtonPos+1)+minimmumXButtonPos);
                int randomY = (int) Math.floor(Math.random()*(maxYbuttonPos-minYButtonPos+1)+minYButtonPos);
                NoButton.setLocation(randomX, randomY);
            } 
        
        });
    }


    //Let's define the textField
    public void setTextField() {
        mTextField.setBounds(0,50,300,50);	
        mTextField.setFont(font);
        mTextField.setOpaque(false);
        mTextField.setHorizontalAlignment(JLabel.CENTER);
        mTextField.setBorder(BorderFactory.createEmptyBorder());
        mTextField.setFocusable(false);
    }


    //Let's define the buttons
    public void setButtons() {
        YesButton.setBounds(40,200,70,35);
        NoButton.setBounds(180,200,70,35);

        YesButton.setFocusable(false);
        NoButton.setFocusable(false);
    }


     //Let's define the actual window that will contain textField and buttons
    public void setFrame() {
        frame.getContentPane().add(mTextField);
        frame.add(NoButton);
        frame.add(YesButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    //This is a simple timer that lose the application in 3 seconds after clicking on Yes
    public void startCountDown() {
        time.schedule(new TimerTask() {
        @Override
        public void run() {
            frame.dispose();
            }
        }, 3*1000);
    }
}
