/**
 * @author      Edgar Quillion <edgarquill@gmail.com>
 * @version     Version 1
 * @since       1.6
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Game
{
    private int WIDTH, HEIGHT;

    private QBMControls box;
    private QPlatform platform;

    public Game(int WIDTH, int HEIGHT)
    {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        box = new QBMControls();
        box.setX(10);
        box.setY(10);
        box.setWidth(100);
        box.setHeight(100);
        box.setHorizontalOffset(5);
        box.setVerticalOffset(5);

        platform = new QPlatform();
        platform.setX(300);
        platform.setY(300);
        platform.setWidth(133);
        platform.setHeight(50);
        platform.setColor(Color.GREEN);
    }

    public void draw(Graphics2D g)
    {
        box.drawBox(g);
        box.draw(g);

        platform.draw(g);
        platform.drawBox(g);
    }

    public void update()
    {
    }

    public void keyPressed(KeyEvent e)
    {
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void mouseEntered(MouseEvent e) 
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public int getWIDTH ()
    {
        return WIDTH;
    }

    public int getHEIGHT ()
    {
        return HEIGHT;
    }
}
