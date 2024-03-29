/**
 * @author      Edgar Quillion <edgarquill@gmail.com>
 * @version     Version 1
 * @since       1.6
 */

import java.awt.Graphics2D;
import java.awt.Color;

/**
 * Bounding Box
 */
public class QBBox extends QBox
{
    private int HOffset, VOffset;

    /**
     * A constructor for the bounding box
     * QBBox extends QBox so it has same properties
     * but has offsets which will be used  in collision detection.
     */
    public QBBox()
    {
        super();
        this.HOffset = 0;
        this.VOffset = 0;
    }

    /**
     * Sets the horizontal offset to whatever value is passed
     * @param offset value to which horizontal offset will be set to
     */
    public void setHorizontalOffset(int offset)
    {
        this.HOffset = offset;
    }

    /**
     * Returns the horizontal offset of this object
     * @return horizontal offset of this object
     */
    public int getHorizontalOffset()
    {
        return this.HOffset;
    }

    /**
     * Sets the vertical offset to whatever value is passed
     * @param offset value to which vertical offset will be set to
     */
    public void setVerticalOffset(int offset)
    {
        this.VOffset = offset;
    }

    /**
     * Returns the vertical offset of this object
     * @return vertical offset of this object
     */
    public int getVerticalOffset()
    {
        return this.VOffset;
    }

    /**
     * returns the object's left x coordinate with offset,
     * is used for collision detection checking
     * @return the object's left x coordinate with offset
     */
    public int getLeftX()
    {
        return (super.getLeftX() + this.HOffset);
    }

    /**
     * returns the object's right x coordinate with offset,
     * is used for collision detection checking
     * @return the object's right x coordinate(which is x+widht) with offset
     */
    public int getRightX()
    {
        return (super.getRightX() - this.HOffset);
    }

    /**
     * returns the object's top y coordinate with offset,
     * is used for collision detection checking
     * @return the object's top y coordinate
     */
    public int getTopY()
    {
        return (super.getTopY() + this.VOffset);
    }

    /**
     * returns the object's bottom y coordinate with offset,
     * is used for collision detection checking
     * @return the object's bottom y coordinate(which is y+height) with offset
     */
    public int getBottomY()
    {
        return (super.getBottomY() - this.VOffset);
    }

    /**
     * Draws the box into to the graphics passed, box outline will be black color
     * @param g graphics where the box will be drawn into
     */
    public void draw(Graphics2D g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(this.getLeftX(), this.getTopY(), (this.getRightX() - this.getLeftX()), (this.getBottomY() - this.getTopY()));
    }
}
