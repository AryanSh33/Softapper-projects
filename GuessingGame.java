import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.Random;

public class GuessingGame extends JFrame {
    int toGuess;
    int Count;
    JTextField guessField;
    JLabel messageLabel;
    JLabel guessCountLabel;
    public GuessingGame () {
        // Initialize
        Random r = new Random ();
        toGuess = r.nextInt (100) + 1;
        Count = 0;

        // Set frame
        setTitle ("Guessing Game");
        setSize (600, 200);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLayout (new GridLayout (4, 1));

        // Components
        JLabel instructionLabel =
                new JLabel ("Guess the number between 1 and 100 ");
        guessField = new JTextField ();
        JButton guessButton = new JButton ("Guess");
        messageLabel = new JLabel ("");
        guessCountLabel = new JLabel ("Number of guesses: 0");

        // Add components to frame
        add (instructionLabel);
        add (guessField);
        add (messageLabel);
        add (guessButton);
        add (guessCountLabel);
        // Add action listener to the button
        guessButton.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e){
                makeGuess ();}
        });
        // Center frame
        setLocationRelativeTo (null);
    }
    private void makeGuess () {
        try{
            int guess = Integer.parseInt (guessField.getText ());
            Count++;

            if (guess == toGuess) {
                messageLabel.setText ("You have guessed the correct number: " +
                        toGuess);
                guessCountLabel.setText ("In " + Count + " guesses");
                guessField.setEnabled (false);
            }

            else if (guess < toGuess) {
                messageLabel.setText ("your guess is too low, guess a little higher");

            }
            else if(Count==10){
                messageLabel.setText ("Maximum no. of attempts reached");
                guessField.setEnabled (false);
            }
            else {
                messageLabel.setText ("your guess is too high, guess a little lower");

            }
            guessCountLabel.setText ("Number of guesses: " + Count);

        }


        catch (NumberFormatException e) {
            messageLabel.setText ("Please enter a valid number");
        }
        guessField.setText ("");
    }


    public static void main (String[]args) {
        SwingUtilities.invokeLater (new Runnable () {
            @Override public void run () {
                new GuessingGame ().setVisible (true);}
        });
    }
}
