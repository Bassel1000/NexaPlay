import javax.swing.*;
import java.awt.*;

public final class Theme {
    private Theme() {}

    // Palette
    public static final Color BG = new Color(0x1a223a);
    public static final Color BG_ELEVATED = new Color(0x212a48);
    public static final Color ACCENT = new Color(0xf5875c);
    public static final Color TEXT_PRIMARY = Color.WHITE;
    public static final Color TEXT_MUTED = new Color(0xC8D0E3);

    // Typography
    public static final Font H1 = new Font("Segoe UI", Font.BOLD, 28);
    public static final Font H2 = new Font("Segoe UI", Font.BOLD, 20);
    public static final Font BODY = new Font("Segoe UI", Font.PLAIN, 16);

    public static void applyRoot(JFrame frame) {
        frame.getContentPane().setBackground(BG);
    }

    public static void applyPanel(JComponent comp) {
        comp.setBackground(BG);
        comp.setForeground(TEXT_PRIMARY);
    }

    public static void applyElevated(JComponent comp) {
        comp.setBackground(BG_ELEVATED);
        comp.setForeground(TEXT_PRIMARY);
    }

    public static void stylePrimary(AbstractButton b) {
        b.setBackground(ACCENT);
        b.setForeground(BG);
        b.setFont(H2);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(10, 16, 10, 16));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static JLabel heading(String text) {
        JLabel l = new JLabel(text);
        l.setFont(H1);
        l.setForeground(ACCENT);
        return l;
    }

    public static JLabel subtitle(String text) {
        JLabel l = new JLabel(text);
        l.setFont(BODY);
        l.setForeground(TEXT_MUTED);
        return l;
    }
}
