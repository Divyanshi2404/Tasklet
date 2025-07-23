import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {
    public static Font loadCustomFont(float size) {
        try {
            // Use getResourceAsStream() instead of getResource()
            InputStream fontStream = FontLoader.class.getClassLoader().getResourceAsStream("fonts/LEMONMILK-Light.otf");

            if (fontStream == null) {
                throw new IOException("Font file not found in resources/fonts/");
            }

            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            return customFont;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", Font.PLAIN, 14); // Fallback font
        }
    }
}
