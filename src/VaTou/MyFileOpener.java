package VaTou;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

public class MyFileOpener {
    JFileChooser file_chooser = new JFileChooser();

    public String pick_me() throws FileNotFoundException {
        String path = "";
        if ( file_chooser.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION ) {
            // get the file
            File file = file_chooser.getSelectedFile();
            // read the path of file
            // System.out.println("selected file:"+file.getAbsolutePath() );
            path = file.getAbsolutePath();
            System.out.println( path );
            // ajouter la méthode reset

        }
        return path;
    }
}
