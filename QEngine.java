/**
 * @author      Edgar Quillion <edgarquill@gmail.com>
 * @version     Version 1
 * @since       1.6
 */

public class QEngine
{
    /**
     * Makes the given character jump
     * @param character object that you would like to jump
     */
    public static void jump(QBMControls character)
    {
        if(character.isStanding())
        {
            character.incrementY(-1);
            character.setYVector(-character.getJump());
        }
    }

    /**
     * Makes character move left,
     * Character will never exceed it's max given velocity,
     * and will accelerate by factor of accelerate while on ground and
     * factor of air friction while in air
     * @param character object that you want to move left
     */
    public static void moveLeft(QBMControls character)
    {
        if(character.isStanding())
        {
            if(character.getXVector() < -character.getMaxSpeed())
                character.setXVector(-character.getMaxSpeed());
            else
                character.incrementXVector(-character.getAcceleration());
        }
        else
        {
            if(character.getXVector() < -character.getMaxSpeed())
                character.setXVector(-character.getMaxSpeed());
            else
                character.incrementXVector(-character.getAirFriction());
        }
    }

    /**
     * Makes character move right,
     * Character will never exceed it's max given velocity,
     * and will accelerate by factor of accelerate while on ground and
     * factor of air friction while in air
     * @param character object that you want to move right
     */
    public static void moveRight(QBMControls character)
    {
        if(character.isStanding())
        {
            if(character.getXVector() > character.getMaxSpeed())
                character.setXVector(character.getMaxSpeed());
            else
                character.incrementXVector(character.getAcceleration());
        }
        else
        {
            if(character.getXVector() > character.getMaxSpeed())
                character.setXVector(character.getMaxSpeed());
            else
                character.incrementXVector(character.getAirFriction());
        }
    }

    public static void rest(QBMControls character)
    {
        // if character is standing on a platform
        if(character.isStanding())
        {
            // if character is moving right
            if(character.getXVector() > 0)
            {
                // if character is almost stopped and friction will make him go the other way
                if(character.getXVector() < character.getGroundFriction())
                    character.setXVector(0);
                // if character is still strongly moving right
                else
                    character.incrementXVector(-character.getGroundFriction());
            }
            // if character is moving left
            else if(character.getXVector() < 0)
            {
                // if character is almost stopped and friction will make him go the other way
                if(character.getXVector() > -character.getGroundFriction())
                    character.setXVector(0);
                // if character is still strongly moving left
                else
                    character.incrementXVector(character.getGroundFriction());
            }
        }
        // if character is in the air
        else
        {
            // if character is moving right
            if(character.getXVector() > 0)
            {
                // if character is almost stopped and friction will make him go the other way
                if(character.getXVector() < character.getAirFriction())
                    character.setXVector(0);
                // if character is still strongly moving right
                else
                    character.incrementXVector(-character.getAirFriction());
            }
            // if character is moving left
            else if(character.getXVector() < 0)
            {
                // if character is almost stopped and friction will make him go the other way
                if(character.getXVector() > -character.getAirFriction())
                    character.setXVector(0);
                // if character is still strongly moving left
                else
                    character.incrementXVector(character.getAirFriction());
            }
        }
    }
}
