package VaTou;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

    public static void main( String[] args ) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame();
        frame.setBounds( 100, 100, 450, 300 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout( null );
        JButton btnNewButton = new JButton( "Get File" );
        btnNewButton.addActionListener( new ActionListener() {

            @Override
            public void actionPerformed( ActionEvent arg0 ) {

                // TODO Auto-generated method stub
                MyFileOpener of = new MyFileOpener();
                try {
                    of.pick_me();
                } catch ( Exception e ) {
                    e.printStackTrace();
                }

            }
        } );
        btnNewButton.setBounds( 160, 182, 121, 43 );
        frame.getContentPane().add( btnNewButton );
        frame.setVisible( true );
    }

}
