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
import java.awt.event.KeyEvent;

public class Game
{
    private int WIDTH, HEIGHT;

    private List<QMCharacter> characters;
    private QMCharacter temp_character;

    private List<QPlatform> platforms;
    private QPlatform temp_platform;

    private int choice[];
    private static int button_press = 0;

    public Game(int WIDTH, int HEIGHT)
    {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        choice = new int[3];
        choice[0] = 0;
        choice[1] = 0;
        choice[2] = 0;

        platforms = new ArrayList<QPlatform>();

        temp_platform = new QPlatform();
        temp_platform.setX(0);
        temp_platform.setY(430);
        temp_platform.setWidth(640);
        temp_platform.setHeight(50);
        temp_platform.setColor(Color.GREEN);
        platforms.add(temp_platform);

        temp_platform = new QPlatform();
        temp_platform.setX(0);
        temp_platform.setY(0);
        temp_platform.setWidth(10);
        temp_platform.setHeight(430);
        temp_platform.setColor(Color.GREEN);
        platforms.add(temp_platform);

        temp_platform = new QPlatform();
        temp_platform.setX(630);
        temp_platform.setY(0);
        temp_platform.setWidth(10);
        temp_platform.setHeight(430);
        temp_platform.setColor(Color.GREEN);
        platforms.add(temp_platform);

        temp_platform = new QPlatform();
        temp_platform.setX(10);
        temp_platform.setY(0);
        temp_platform.setWidth(620);
        temp_platform.setHeight(30);
        temp_platform.setColor(Color.GREEN);
        platforms.add(temp_platform);

        characters = new ArrayList<QMCharacter>();

        temp_character = new QMCharacter();
        temp_character.setX(150);
        temp_character.setY(150);
        temp_character.setWidth(30);
        temp_character.setHeight(30);
        temp_character.setGravity(1);
        temp_character.setMaxSpeed(5);
        temp_character.setJump(17);
        temp_character.setAcceleration(0.7);
        temp_character.setGroundFriction(3);
        temp_character.setAirFriction(2);
        temp_character.setLeftKey(KeyEvent.VK_LEFT);
        temp_character.setRightKey(KeyEvent.VK_RIGHT);
        temp_character.setJumpKey(KeyEvent.VK_UP);
        characters.add(temp_character);

        temp_character = new QMCharacter();
        temp_character.setX(350);
        temp_character.setY(150);
        temp_character.setWidth(30);
        temp_character.setHeight(30);
        temp_character.setGravity(1);
        temp_character.setMaxSpeed(5);
        temp_character.setJump(17);
        temp_character.setAcceleration(0.7);
        temp_character.setGroundFriction(3);
        temp_character.setAirFriction(2);
        temp_character.setLeftKey(KeyEvent.VK_A);
        temp_character.setRightKey(KeyEvent.VK_D);
        temp_character.setJumpKey(KeyEvent.VK_W);
        temp_character.setColor(Color.GRAY);
        characters.add(temp_character);
    }

    public void draw(Graphics2D g)
    {
        for(int i = 0; i < platforms.size(); i++)
        {
            platforms.get(i).draw(g);
            platforms.get(i).drawBox(g);
        }

        if(platforms.size() > 4)
        {
            g.setColor(Color.WHITE);
            g.fillOval(platforms.get(choice[2]).getX(), platforms.get(choice[2]).getY(), platforms.get(choice[2]).getWidth(), platforms.get(choice[2]).getHeight());

            g.setColor(Color.BLACK);
            g.drawString(String.format("X: %d | Width:  %d", platforms.get(choice[2]).getX(), platforms.get(choice[2]).getWidth()), 490, 445);
            g.drawString(String.format("Y: %d | Height: %d", platforms.get(choice[2]).getY(), platforms.get(choice[2]).getHeight()), 490, 455);
        }

        for(int i = 0; i < characters.size(); i++)
        {
            characters.get(i).draw(g);
            characters.get(i).drawBox(g);

            g.setColor(Color.BLACK);
            g.drawRect(9+(101*choice[i]), 0+(11*i), 103, 11);
            g.drawString(String.format("Gravity: %.1f", characters.get(i).getGravity()), 10, 11+(i*10));
            g.drawString(String.format("Jump: %.1f", characters.get(i).getJump()), 111, 11+(i*10));
            g.drawString(String.format("Air Friction: %.1f", characters.get(i).getAirFriction()), 212, 11+(i*10));
            g.drawString(String.format("Acceleration: %.1f", characters.get(i).getAcceleration()), 313, 11+(i*10));
            g.drawString(String.format("Max Speed: %.1f", characters.get(i).getMaxSpeed()), 414, 11+(i*10));
            g.drawString(String.format("Ground Friction: %.1f", characters.get(i).getGroundFriction()), 515, 11+(i*10));
            g.drawString(String.format("X Speed: %.1f", characters.get(i).getXVector()), 10, 445+(i*10));
            g.drawString(String.format("Y Speed: %.1f", characters.get(i).getYVector()), 90, 445+(i*10));
            g.drawString(String.format("X Pos: %d", characters.get(i).getX()), 170, 445+(i*10));
            g.drawString(String.format("Y Pos: %d", characters.get(i).getY()), 240, 445+(i*10));
        }
        g.drawString("Controls: Arrow keys to move", 310, 445);
        g.drawString("Controls: WASD to move", 310, 455);
        g.drawString("FH/JL Change choice. TG/IK Increment/decrement value.", 10, 475);
    }

    public void update()
    {
        for(int j = 0; j < characters.size(); j++)
        {
            QEngine.preUpdate(characters.get(j));
            // character is always falling until proven otherwise
            characters.get(j).setStanding(false);
            for(int i = 0; i < platforms.size(); i++)
            {
                int vert = QEngine.verticalCollision(characters.get(j), platforms.get(i));
                int hort = QEngine.horizontalCollision(characters.get(j), platforms.get(i));

                if(hort == QConstants.RIGHT)
                {
                    characters.get(j).setRight(false);
                    characters.get(j).setX(platforms.get(i).getLeftX() - characters.get(j).getWidth());
                    characters.get(j).setXVector(0);
                }
                else if(hort == QConstants.LEFT)
                {
                    characters.get(j).setLeft(false);
                    characters.get(j).setX(platforms.get(i).getRightX());
                    characters.get(j).setXVector(0);
                }

                if(vert == QConstants.UP)
                {
                    if(characters.get(j).getGravity() < 0)
                        characters.get(j).setStanding(true);
                    characters.get(j).setY(platforms.get(i).getBottomY());
                    characters.get(j).setYVector(0);
                }
                else if(vert == QConstants.DOWN)
                {
                    if(characters.get(j).getGravity() > 0)
                        characters.get(j).setStanding(true);
                    characters.get(j).setY(platforms.get(i).getTopY()-characters.get(j).getHeight());
                    characters.get(j).setYVector(0);
                }
            }

            for(int i = 0; i < characters.size(); i++)
            {
                if(i != j)
                {
                    int vert = QEngine.verticalCollision(characters.get(j), characters.get(i));
                    int hort = QEngine.horizontalCollision(characters.get(j), characters.get(i));

                    if(hort == QConstants.RIGHT)
                    {
                        characters.get(j).setRight(false);
                        characters.get(j).setX(characters.get(i).getLeftX() - characters.get(j).getWidth());
                        characters.get(j).setXVector(0);
                    }
                    else if(hort == QConstants.LEFT)
                    {
                        characters.get(j).setLeft(false);
                        characters.get(j).setX(characters.get(i).getRightX());
                        characters.get(j).setXVector(0);
                    }

                    if(vert == QConstants.UP)
                    {
                        if(characters.get(j).getGravity() < 0)
                            characters.get(j).setStanding(true);
                        characters.get(j).setY(characters.get(i).getBottomY());
                        characters.get(j).setYVector(0);
                    }
                    else if(vert == QConstants.DOWN)
                    {
                        if(characters.get(j).getGravity() > 0)
                            characters.get(j).setStanding(true);
                        characters.get(j).setY(characters.get(i).getTopY()-characters.get(j).getHeight());
                        characters.get(j).setYVector(0);
                    }
                }
            }
            QEngine.postUpdate(characters.get(j));
        }
    }

    public void keyPressed(KeyEvent e)
    {
        for(int i = 0; i < characters.size(); i++)
        {
            QEngine.keyPressed(e.getKeyCode(), characters.get(i));
        }

        if(e.getKeyCode() == KeyEvent.VK_I)
        {
            if(choice[0] == 0)
                characters.get(0).incrementGravity(0.1);
            else if(choice[0] == 1)
                characters.get(0).incrementJump(0.1);
            else if(choice[0] == 2)
                characters.get(0).incrementAirFriction(0.1);
            else if(choice[0] == 3)
                characters.get(0).incrementAcceleration(0.1);
            else if(choice[0] == 4)
                characters.get(0).incrementMaxSpeed(0.1);
            else if(choice[0] == 5)
                characters.get(0).incrementGroundFriction(0.1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_K)
        {
            if(choice[0] == 0)
                characters.get(0).incrementGravity(-0.1);
            else if(choice[0] == 1)
                characters.get(0).incrementJump(-0.1);
            else if(choice[0] == 2)
                characters.get(0).incrementAirFriction(-0.1);
            else if(choice[0] == 3)
                characters.get(0).incrementAcceleration(-0.1);
            else if(choice[0] == 4)
                characters.get(0).incrementMaxSpeed(-0.1);
            else if(choice[0] == 5)
                characters.get(0).incrementGroundFriction(-0.1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_J)
        {
            choice[0]--;
            if(choice[0] < 0)
                choice[0] = 5;
        }
        else if(e.getKeyCode() == KeyEvent.VK_L)
        {
            choice[0]++;
            if(choice[0] > 5)
                choice[0] = 0;
        }

        if(e.getKeyCode() == KeyEvent.VK_T)
        {
            if(choice[1] == 0)
                characters.get(1).incrementGravity(0.1);
            else if(choice[1] == 1)
                characters.get(1).incrementJump(0.1);
            else if(choice[1] == 2)
                characters.get(1).incrementAirFriction(0.1);
            else if(choice[1] == 3)
                characters.get(1).incrementAcceleration(0.1);
            else if(choice[1] == 4)
                characters.get(1).incrementMaxSpeed(0.1);
            else if(choice[1] == 5)
                characters.get(1).incrementGroundFriction(0.1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_G)
        {
            if(choice[1] == 0)
                characters.get(1).incrementGravity(-0.1);
            else if(choice[1] == 1)
                characters.get(1).incrementJump(-0.1);
            else if(choice[1] == 2)
                characters.get(1).incrementAirFriction(-0.1);
            else if(choice[1] == 3)
                characters.get(1).incrementAcceleration(-0.1);
            else if(choice[1] == 4)
                characters.get(1).incrementMaxSpeed(-0.1);
            else if(choice[1] == 5)
                characters.get(1).incrementGroundFriction(-0.1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_F)
        {
            choice[1]--;
            if(choice[1] < 0)
                choice[1] = 5;
        }
        else if(e.getKeyCode() == KeyEvent.VK_H)
        {
            choice[1]++;
            if(choice[1] > 5)
                choice[1] = 0;
        }

        if(e.getKeyCode() == KeyEvent.VK_B)
        {
            int x = QEngine.random(10, 620);
            int y = QEngine.random(30, 420);
            int width = QEngine.random(10, 630 - x);
            int height = QEngine.random(10, 430 - y);

            temp_platform = new QPlatform();
            temp_platform.setX(x);
            temp_platform.setY(y);
            temp_platform.setWidth(width);
            temp_platform.setHeight(height);
            temp_platform.setColor(new Color(QEngine.random(0, 255), QEngine.random(0,255), QEngine.random(0,255)));
            platforms.add(temp_platform);

            choice[2] = platforms.size()-1;
        }
        else if(e.getKeyCode() == KeyEvent.VK_M)
        {
            if(platforms.size() > 4)
                platforms.remove(choice[2]);
        }
        else if(e.getKeyCode() == KeyEvent.VK_N)
        {
            choice[2]++;
            if(choice[2] == platforms.size())
                choice[2] = 4;
        }

        if(e.getKeyCode() == KeyEvent.VK_Z)
        {
            if(button_press < 10)
            {
                button_press++;
                platforms.get(choice[2]).incrementX(-1);
            }
            else
                platforms.get(choice[2]).incrementX(-10);

            if(platforms.get(choice[2]).getLeftX() < 10)
                platforms.get(choice[2]).setX(10);
        }
        else if(e.getKeyCode() == KeyEvent.VK_X)
        {
            if(button_press < 10)
            {
                button_press++;
                platforms.get(choice[2]).incrementX(1);
            }
            else
                platforms.get(choice[2]).incrementX(10);

            if(platforms.get(choice[2]).getRightX() > 630)
                platforms.get(choice[2]).setX(630 - platforms.get(choice[2]).getWidth());
        }

        if(e.getKeyCode() == KeyEvent.VK_C)
        {
            if(button_press < 10)
            {
                button_press++;
                platforms.get(choice[2]).incrementY(-1);
            }
            else
                platforms.get(choice[2]).incrementY(-10);

            if(platforms.get(choice[2]).getTopY() < 30)
                platforms.get(choice[2]).setY(30);
        }
        else if(e.getKeyCode() == KeyEvent.VK_V)
        {
            if(button_press < 10)
            {
                button_press++;
                platforms.get(choice[2]).incrementY(1);
            }
            else
                platforms.get(choice[2]).incrementY(10);

            if(platforms.get(choice[2]).getBottomY() > 430)
                platforms.get(choice[2]).setY(430 - platforms.get(choice[2]).getHeight());
        }

        if(e.getKeyCode() == KeyEvent.VK_E)
        {
            if(button_press < 10)
            {
                button_press++;
                platforms.get(choice[2]).incrementWidth(-1);
            }
            else
                platforms.get(choice[2]).incrementWidth(-10);

            if(platforms.get(choice[2]).getWidth() < 5)
                platforms.get(choice[2]).setWidth(5);
        }
        else if(e.getKeyCode() == KeyEvent.VK_R)
        {
            if(button_press < 10)
            {
                button_press++;
                platforms.get(choice[2]).incrementWidth(1);
            }
            else
                platforms.get(choice[2]).incrementWidth(10);

            if(platforms.get(choice[2]).getRightX() > 630)
                platforms.get(choice[2]).setWidth(630 - platforms.get(choice[2]).getX());
        }

        if(e.getKeyCode() == KeyEvent.VK_Y)
        {
            if(button_press < 10)
            {
                button_press++;
                platforms.get(choice[2]).incrementHeight(-1);
            }
            else
                platforms.get(choice[2]).incrementHeight(-10);

            if(platforms.get(choice[2]).getHeight() < 5)
                platforms.get(choice[2]).setHeight(5);
        }
        else if(e.getKeyCode() == KeyEvent.VK_U)
        {
            if(button_press < 10)
            {
                button_press++;
                platforms.get(choice[2]).incrementHeight(1);
            }
            else
                platforms.get(choice[2]).incrementHeight(10);

            if(platforms.get(choice[2]).getBottomY() > 430)
                platforms.get(choice[2]).setHeight(430 - platforms.get(choice[2]).getY());
        }
    }

    public void keyReleased(KeyEvent e)
    {
        for(int i = 0; i < characters.size(); i++)
        {
            QEngine.keyReleased(e.getKeyCode(), characters.get(i));
        }
        if(e.getKeyCode() == KeyEvent.VK_Z ||
           e.getKeyCode() == KeyEvent.VK_X ||
           e.getKeyCode() == KeyEvent.VK_C ||
           e.getKeyCode() == KeyEvent.VK_V ||
           e.getKeyCode() == KeyEvent.VK_E ||
           e.getKeyCode() == KeyEvent.VK_R ||
           e.getKeyCode() == KeyEvent.VK_Y ||
           e.getKeyCode() == KeyEvent.VK_U)
            button_press = 0;
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
