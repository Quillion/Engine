/**
 * @author      Edgar Quillion <edgarquill@gmail.com>
 * @version     Version 1
 * @since       1.6
 */

import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Game
{
    private int WIDTH, HEIGHT;

    private QMCharacter box;

    private List<QPlatform> platforms;
    private QPlatform temp_platform;

    public Game(int WIDTH, int HEIGHT)
    {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        platforms = new ArrayList<QPlatform>();

        temp_platform = new QPlatform();
        temp_platform.setX(0);
        temp_platform.setY(400);
        temp_platform.setWidth(630);
        temp_platform.setHeight(50);
        temp_platform.setColor(Color.GREEN);
        platforms.add(temp_platform);

        temp_platform = new QPlatform();
        temp_platform.setX(0);
        temp_platform.setY(0);
        temp_platform.setWidth(10);
        temp_platform.setHeight(390);
        temp_platform.setColor(Color.GREEN);
        platforms.add(temp_platform);

        temp_platform = new QPlatform();
        temp_platform.setX(210);
        temp_platform.setY(350);
        temp_platform.setWidth(50);
        temp_platform.setHeight(10);
        temp_platform.setColor(Color.GREEN);
        platforms.add(temp_platform);

        temp_platform = new QPlatform();
        temp_platform.setX(610);
        temp_platform.setY(10);
        temp_platform.setWidth(20);
        temp_platform.setHeight(380);
        temp_platform.setColor(Color.GREEN);
        platforms.add(temp_platform);

        box = new QMCharacter();
        box.setX(150);
        box.setY(150);
        box.setWidth(30);
        box.setHeight(30);
    }

    public void draw(Graphics2D g)
    {
        for(int i = 0; i < platforms.size(); i++)
        {
            platforms.get(i).draw(g);
            platforms.get(i).drawBox(g);
        }

        box.drawBox(g);
        box.draw(g);
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
