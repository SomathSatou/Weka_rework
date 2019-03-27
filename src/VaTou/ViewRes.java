package VaTou;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ViewRes {
    ViewRes( /* structure de res */ ) {
        JFrame resFrame = new JFrame();
        resFrame.setBounds( 600, 100, 1250, 750 );
        resFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        resFrame.getContentPane().setLayout( null );

        JTextArea resTab = new JTextArea();
        resTab.setEditable( false );
        resTab.setBounds( 5, 5, 610, 740 );
        resTab.setText( "------------------------------------------------------------------\n" +
                "||                         test                                 ||\n" +
                "------------------------------------------------------------------\n" );

        resFrame.add( resTab );
        resFrame.setVisible( true );
    }
}
