package VaTou;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ViewRes {
    ViewRes( Resultat_tableau res, String algo ) {
        JFrame resFrame = new JFrame();
        resFrame.setBounds( 600, 100, 1250, 500 );
        resFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        resFrame.getContentPane().setLayout( null );

        JTextArea resTab = new JTextArea();
        resTab.setEditable( false );
        resTab.setBounds( 5, 5, 500, 490 );
        resTab.setText( "\t-------------------------------------------------------------------------\n" +
                "\t||\ttest\t\t||\n" +
                "\t-------------------------------------------------------------------------\n" );
        DecimalFormat df2 = new DecimalFormat( ".###" );

        // affichage d'un tableau moche pour l'instant
        resTab.setText( resTab.getText() + "\t|nbr min de feuilles \t|% de réussite \t| \n" );
        for ( int i = 0; i < res.getNbr_feuilles().size(); i++ ) {
            resTab.setText( resTab.getText() + "\t|" + res.getNbr_feuilles().get( i ) + "\t\t|"
                    + df2.format( res.getPourcentage_reussite().get( i ) ) + "\t|\n" );
        }
        resTab.setText(
                resTab.getText() + "\t-------------------------------------------------------------------------\n" );

        Courbe tc = new Courbe( res, algo );

        resFrame.add( resTab );
        resFrame.add( tc );

        resFrame.setVisible( true );
    }
}
