/* John McDowell
    My roommate told me I'm always too happy...
    I tell my roommate she is always too sad...
 */
package toohappy;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TooHappy extends JFrame 
    {
        Random rand = new Random();
        
        // Objects of different things in the user window
        private JLabel statement;
        private JLabel endLabel;
        private JLabel playAgain;
        
        private JButton buttonYes;
        private JButton buttonNo;
        private JButton hellNo;
        private JButton hellYas;
        
        private int happyLevelNumber = 10;
        private int position;
        private int count= 0;
        
        private String [] happynessLevel = new String[21];
        private int [] happyLevelQuestionsAsked = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        private final String [] happyLevelQuestions = new String[26];
                

        //************************************
        // Constructor -> displays original buttons
        //************************************
        public TooHappy()
        {
            super("Are you too happy?");
            happyLevelQuestions[0] = "Do you want to listen to country music?";
            happyLevelQuestions[1] = "Do you want to hold a puppy?";
            happyLevelQuestions[2] = "Did you talk to someone new today?";
            happyLevelQuestions[3] = "Do you want a hug right now?";
            happyLevelQuestions[4] = "Do you want to go to PSUHack?";
            happyLevelQuestions[5] = "Do you want to take a shower?";
            happyLevelQuestions[6] = "Have you taken a selfie today?";
            happyLevelQuestions[7] = "Have you done  lot of homework today?";
            happyLevelQuestions[8] = "Have you talked to one of your parents today?";
            happyLevelQuestions[9] = "Are you in the mood to eat?";
            happyLevelQuestions[10] = "Do you want to watch a movie?";
            happyLevelQuestions[11] = "Er Mer Gerd, do you need to sleep?";
            happyLevelQuestions[12] = "Are you in the mood for tacos?";
            happyLevelQuestions[13] = "Have you been sitting down for more than an hour today?";
            happyLevelQuestions[14] = "Are you wearing any neon colors?";
            happyLevelQuestions[15] = "Do you want my digits?";
            happyLevelQuestions[16] = "I'm going swimming. Do you want to come?";
            happyLevelQuestions[17] = "If you had a pet fish, would you name it Kevin?";
            happyLevelQuestions[18] = "The creamery is right there. Are you coming with me?";
            happyLevelQuestions[19] = "So should I stop asking you questions?";
            happyLevelQuestions[20] = "I can do a handstand. Let me see your's.";
            happyLevelQuestions[21] = "I'm giving away prizes. Should I give one to you?";
            happyLevelQuestions[22] = "Do you want to hold a bird?";
            happyLevelQuestions[23] = "Is computer Science your BEST FRIEND?";
            happyLevelQuestions[24] = "Do you sing in the shower?";

            
            happynessLevel[0]= "OMG, GO TO BED! No ONE WANTS TO SEE YOU! TAKE A NAP.";
            happynessLevel[1]= "You are not much better than the person that has been away for 48 hours...";
            happynessLevel[2]= "Gurl, you need to get happy... quick!";
            happynessLevel[3]= "Unacceptable... *gives virtual hug*";
            happynessLevel[4]= "Just letting you know I love you.";
            happynessLevel[5]= "It will be okay. This calls for a puppy lick though!";
            happynessLevel[6]= "You may need to take a nap.";
            happynessLevel[7]= "Just 5 more minutes of sleep could have fixed you today.";
            happynessLevel[8]= "The happiness is strong with this one.";
            happynessLevel[9]= "You're lip gloss must be popping";
            happynessLevel[10]= "Why are you here again?";
            happynessLevel[11]= "We wear pink on Wednesdays. You should too.";
            happynessLevel[12]= "The happiness is strong with this one.";
            happynessLevel[13]= "Dang! You good! Keep your smile!";
            happynessLevel[14]= "You are my spirit animal. You are the perfect amount of happy.";
            happynessLevel[15]= "Dang! You good! Keep your smile!";
            happynessLevel[16]= "Start giving some hugs out...spread the love!";
            happynessLevel[17]= "Love you, but I can only take so much happiness";
            happynessLevel[18]= "One more move and you may be in Time Out... you too happy";
            happynessLevel[19]= "For the love of god... stop talking to everyone!";
            happynessLevel[20]= "TONE IT DOWN! GOD KAREN!";
            
            setRandomNum();            
            setLayout( new GridLayout(2,1) );
            
            endLabel = new JLabel("");
            statement = new JLabel(happyLevelQuestions[0]);
            //statement = happyLevelQuestions[position];
            statement.setHorizontalTextPosition(SwingConstants.CENTER);
            add(statement); // Adds label to frame

            buttonYes = new JButton("Yes");
            add(buttonYes); //Adds textField to the frame
            
            buttonNo = new JButton("No");
            add(buttonNo); //Adds textField to the frame
            hellNo = new JButton("Hell No");
            hellYas = new JButton("Yaaas");

            ButtonHandlerYes handlerYes = new ButtonHandlerYes();
            buttonYes.addActionListener(handlerYes);

            ButtonHandlerNo handlerNo = new ButtonHandlerNo();
            buttonNo.addActionListener(handlerNo);       

            add(statement);
        }

        //************************************
        // Event handler when the user enters a number
        //************************************
        private class ButtonHandlerYes implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(position%2 == 0)
                    happyLevelNumber++;
                else
                    happyLevelNumber--;
                
                count++;
                do{
                    setRandomNum();
                }while((happyLevelQuestionsAsked[position] == 1) && (count <= 10));
                 
                happyLevelQuestionsAsked[position] = 1;
                statement.setText(happyLevelQuestions[position]);

                if(count == 10)
                    endOfProgram();
                
            }
        } 

        //*********************************************
        // Yes Button event handler
        //*********************************************
        private class ButtonHandlerNo implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent event)
            { 
                        if(position%2 != 0)
                            happyLevelNumber++;
                        else
                            happyLevelNumber--; 
                        
                        count++;
                        do{ 
                            setRandomNum();
                        }while(happyLevelQuestionsAsked[position] == 1 && count <= 10);
                        
                        happyLevelQuestionsAsked[position] = 1;
                        statement.setText(happyLevelQuestions[position]);
                        
                        if(count == 10)
                            endOfProgram();                        
            }
        } 
        
        public int setRandomNum ()
        {
            return (position= rand.nextInt(24));
        }
        public void reset()
        {
                
                happyLevelNumber = 10;
                count= 0;
                buttonYes.setVisible(true);
                buttonNo.setVisible(true);
                
        }
        public void endOfProgram()
        {
            buttonYes.setVisible(false);
            buttonNo.setVisible(false);
            statement.setText("Your happy level is...");
            endLabel.setText(happynessLevel[happyLevelNumber]);
            add(endLabel);
        }
        
        public static void main(String[] args) 
        {
            TooHappy flowLayoutFrame = new TooHappy();
            flowLayoutFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
            flowLayoutFrame.setSize( 600, 75);
            flowLayoutFrame.setVisible(true);        
        }
 }