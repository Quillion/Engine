/**
 * @author      Edgar Quillion <edgarquill@gmail.com>
 * @version     Version 1
 * @since       1.6
 */

import java.awt.Graphics2D;
import java.awt.Color;

public class QBox
{
    private double x, y;
    private int width, height;

    /**
     * A constructor for the box
     * QBox does not contain any offsets, it is just a box
     * All the values are set to 0 on creation
     */
    public QBox()
    {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    /**
     * Sets the value of x to whatever you choose to
     * @param x the value to which x will be set to
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * Return x value of the object
     * I return int because it is easier to use for collision detection
     * @return returns the x value of the object
     */
    public int getX()
    {
        return (int)this.x;
    }

    /**
     * Increment the object's x value, very useful for movement
     * @param x the value by which to increment x by
     */
    public void incrementX(double x)
    {
        this.x += x;
    }

    /**
     * Sets the value of y to whatever you choose to
     * @param y the value to which y will be set to
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * Return y value of the object
     * I return int because it is easier to use for collision detection
     * @return returns the y value of the object
     */
    public int getY()
    {
        return (int)this.y;
    }

    /**
     * Increment the object's y value, very useful for movement
     * @param y the value by which to increment y by
     */
    public void incrementY(double y)
    {
        this.y += y;
    }

    /**
     * Sets the width value to whatever you choose to
     * @param width the value to which objetc's width will be set to
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * returns the object's width
     * @return the width of this object
     */
    public int getWidth()
    {
        return this.width;
    }

    /**
     * Sets the height value to whatever you choose to
     * @param height the value to which object's height will be set to
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * returns the objetc's height
     * @return the width of this object
     */
    public int getHeight()
    {
        return this.height;
    }

    /**
     * returns the object's left x coordinate,
     * is used for collision detection checking
     * @return the object's left x coordinate
     */
    public int getLeftX()
    {
        return (int)this.x;
    }

    /**
     * returns the object's right x coordinate,
     * is used for collision detection checking
     * @return the object's right x coordinate(which is x+widht)
     */
    public int getRightX()
    {
        return (int)(this.x+this.width);
    }

    /**
     * returns the object's top y coordinate,
     * is used for collision detection checking
     * @return the object's top y coordinate
     */
    public int getTopY()
    {
        return (int)this.y;
    }

    /**
     * returns the object's bottom y coordinate,
     * is used for collision detection checking
     * @return the object's bottom y coordinate(which is y+height)
     */
    public int getBottomY()
    {
        return (int)(this.y+this.height);
    }

    /**
     * Draws the box into to the graphics passed,
     * box outline will be black color
     * @param g graphics where the box will be drawn into
     */
    public void drawBox(Graphics2D g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(this.getX(), this.getY(), this.width, this.height);
    }

    /**
     * Same as drawBox
     * @param g graphics where the box will be drawn into
     */
    public void draw(Graphics2D g)
    {
        this.drawBox(g);
    }
}
