/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JButton;

public class TooHappyFrame extends JFrame{
    
    Random rand = new Random();
    
    private JButton leftJButton;
    private JButton centerJButton;
    private JButton rightJButton;
    private FlowLayout layout;
    private Container container;
    
    public TooHappyFrame()
    {
        super( "Are you too Happy?" );
        
        layout = new FlowLayout();
        container = getContentPane();
        setLayout(layout);
        
        leftJButton = new JButton("Left");
        add(leftJButton);
        leftJButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed (ActionEvent event)
                    {
                        layout.setAlignment(FlowLayout.LEFT);
                        layout.layoutContainer(container);
                    }                    
                }     
        ); 
        
        centerJButton = new JButton("Center");
        add( centerJButton);
        centerJButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed (ActionEvent event)
                    {
                        layout.setAlignment(FlowLayout.CENTER);
                        layout.layoutContainer(container);
                    }
                }
        );
        
        rightJButton = new JButton("Right");
        add(rightJButton);
        rightJButton.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent event)
                    {
                        layout.setAlignment(FlowLayout.RIGHT);
                        layout.layoutContainer(container);
                    }
                }
        );
    }
}
