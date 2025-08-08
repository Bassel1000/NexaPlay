import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCard extends JPanel {
    public interface LaunchHandler { void onLaunch(); }
    public interface AddHandler { void onAddToLibrary(JButton playButton); }

    private final JButton playButton;

    public GameCard(String title, String heroImagePath, String playLabel, LaunchHandler onLaunch, AddHandler onAdd) {
        setLayout(new BorderLayout(12, 12));
        setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        Theme.applyElevated(this);

        // Image area
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(280, 160));
    imageLabel.setIcon(new ImageIcon(scaledImage(heroImagePath, 280, 160)));
        add(imageLabel, BorderLayout.NORTH);

        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(Theme.H2);
        titleLabel.setForeground(Theme.TEXT_PRIMARY);
        add(titleLabel, BorderLayout.CENTER);

        // Actions
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        Theme.applyPanel(actions);
        JButton addBtn = new JButton("Add to Library");
        Theme.stylePrimary(addBtn);
        playButton = new JButton(playLabel);
        Theme.stylePrimary(playButton);
        addBtn.addActionListener(e -> onAdd.onAddToLibrary(playButton));
        playButton.addActionListener(e -> onLaunch.onLaunch());
        actions.add(addBtn);
        actions.add(playButton);
        add(actions, BorderLayout.SOUTH);
    }

    private Image scaledImage(String path, int w, int h) {
        try {
            ImageIcon icon = new ImageIcon(path);
            if (icon.getIconWidth() <= 0 || icon.getIconHeight() <= 0) throw new Exception("bad");
            return icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        } catch (Exception ex) {
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = img.createGraphics();
            g.setColor(new Color(255,255,255,20));
            g.fillRect(0,0,w,h);
            g.setColor(Theme.ACCENT);
            g.drawRect(1,1,w-2,h-2);
            g.dispose();
            return img;
        }
    }
}
