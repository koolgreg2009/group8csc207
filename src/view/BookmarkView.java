package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BookmarkView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "bookmark";

    final JButton bookmarkButton = new JButton("Save");
    final JButton removeBookmarkButton = new JButton("Unsave");
    static final JButton homeButton = new JButton("Home");
    static final JButton profileButton = new JButton("My Profile");
    static final JButton logoutButton = new JButton("Logout");
    static final JButton preferenceButton = new JButton("My Preferences");
    static final JButton myBookmarksButton = new JButton("My Bookmarks");

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}

