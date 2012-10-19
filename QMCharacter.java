/**
 * @author      Edgar Quillion <edgarquill@gmail.com>
 * @version     Version 1
 * @since       1.6
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

public class QMCharacter extends QMControls
{
    private BufferedImage image;
    private Color color;

    /**
     * Constructor for the character, originally contains no image,
     * and color is set to black
     */
    public QMCharacter()
    {
        super();
        image = null;
        color = Color.BLACK;
    }

    /**
     * Sets the color of the character to whatever you want
     * @param color what color the new character will be
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * Returns the color to which this character is set to
     * @return color of this character
     */
    public Color getColor()
    {
        return this.color;
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
     * Returns this character's image
     * @return image of this character
     */
    public BufferedImage getImage()
    {
        return this.image;
    }

    /**
     * Draws image for the character to the specified canvas
     */
    public void draw(Graphics2D g)
    {
        if(image == null)
        {
            g.setColor(color);
            g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
        }
        else
            g.drawImage(this.image, null, this.getX(), this.getY());
    }
}
