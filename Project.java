import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Project {
    private static ArrayList<Song> songs = new ArrayList<>();
    
    public static void main(String[] args) {

        JFrame frame = new JFrame("PlaylistforU");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

       
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        
      
        JTextField songField = new JTextField();
        JTextField artistField = new JTextField();
        JTextField yearField = new JTextField();
        
        inputPanel.add(new JLabel("Song:"));
        inputPanel.add(songField);
        inputPanel.add(new JLabel("Artist:"));
        inputPanel.add(artistField);
        inputPanel.add(new JLabel("Year:"));
        inputPanel.add(yearField);
        
       
        JButton addButton = new JButton("Add Song");
        inputPanel.add(addButton);
        
        frame.add(inputPanel, BorderLayout.NORTH);
        
       
        String[] columnNames = {"Song", "Artist", "Year"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

       
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String song = songField.getText();
                String artist = artistField.getText();
                String yearStr = yearField.getText();
                
                try {
                    int year = Integer.parseInt(yearStr);
                    Song song1 = new Song(song, artist, year);
                    songs.add(song1);
                    model.addRow(new Object[]{song, artist, year});
                    songField.setText("");
                    artistField.setText("");
                    yearField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid year.");
                }
            }
        });
        

        frame.setVisible(true);
    }
}


class Song {
    private String title;
    private String artist;
    private int year;
    
    public Song(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public int getYear() {
        return year;
    }
}