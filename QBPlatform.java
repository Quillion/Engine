/**
 * @author      Edgar Quillion <edgarquill@gmail.com>
 * @version     Version 1
 * @since       1.6
 */

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Platform with bounding box
 */
public class QBPlatform extends QBBox
{
    private BufferedImage image;

    /**
     * Constructor for the platform, originally contains no image
     */
    public QBPlatform()
    {
        super();
        image = null;
    }

    /**
     * Load the image from a given path,
     * @return true if image loaded successfully, false otherwise
     */
    public boolean loadImage(String path)
    {
        URL url = this.getClass().getResource(path);
        this.image = null;

        try
        {
            this.image =  ImageIO.read(url);
        }
        catch (Exception e)
        {
            return false;
        }

        super.setWidth(image.getWidth());
        super.setHeight(image.getHeight());

        return true;
    }

    /**
     * Returns this platform's image
     * @return image of this platform
     */
    public BufferedImage getImage()
    {
        return this.image;
    }

    /**
     * Draws image for the platform to the specified canvas
     */
    public void draw(Graphics2D g)
    {
        g.drawImage(this.image, null, super.getX(), super.getY());
    }
}
