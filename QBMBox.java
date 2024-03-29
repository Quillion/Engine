/**
 * @author      Edgar Quillion <edgarquill@gmail.com>
 * @version     Version 1
 * @since       1.6
 */

/**
 * Bounding box with vector qualities
 */
public class QBMBox extends QBBox
{
    private double xVector, yVector;
    private double gravity, groundFriction, airFriction;
    private double acceleration, maxSpeed, jump;

    /**
     * Constructor, creates box which has vectors,
     * and certain moving qualities,
     * all the vectors and gravity are set to zero
     */
    public QBMBox()
    {
        super();
        this.xVector = 0;
        this.yVector = 0;
        this.gravity = 0;
        this.groundFriction = 0;
        this.airFriction = 0;
        this.acceleration = 0;
        this.maxSpeed = 0;
        this.jump = 0;
    }

    /**
     * Sets the x vector to whatever you want
     * Useful if you want to launch an object at high speed
     * @param vector vector value to which x vector will be set to
     */
    public void setXVector(double vector)
    {
        this.xVector = vector;
    }

    /**
     * Returns a double which represents x vector
     * @return value of x vector
     */
    public double getXVector()
    {
        return this.xVector;
    }

    /**
     * Increments x vector by a value of vector
     * @param vector value by which x vector will be incremented
     */
    public void incrementXVector(double vector)
    {
        this.xVector += vector;
    }

    /**
     * Sets the y vector to whatever you want
     * Useful if you want to launch an object at high speed
     * @param vector vector value to which y vector will be set to
     */
    public void setYVector(double vector)
    {
        this.yVector = vector;
    }

    /**
     * Returns a double which represents y vector
     * @return value of y vector
     */
    public double getYVector()
    {
        return this.yVector;
    }

    /**
     * Increments y vector by a value of vector
     * @param vector value by which y vector will be incremented
     */
    public void incrementYVector(double vector)
    {
        this.yVector += vector;
    }

    /**
     * Sets gravity to whatever floats your boat
     * @param gravity new value to which gravity will be set to
     */
    public void setGravity(double gravity)
    {
        this.gravity = gravity;
    }

    /**
     * Tells you what the current gravity for current character is
     * @return double value which represents gravity
     */
    public double getGravity()
    {
        return this.gravity;
    }

    /**
     * Increments gravity by whatever value you want
     * Useful if your character has a skill to decrease gravity
     * @param value how much to increment gravity by
     */
    public void incrementGravity(double value)
    {
        this.gravity += value;
    }

    /**
     * Sets the friction when character is on the ground
     * If character steps on ice simply change friction
     * @param friction value to which ground friction should be set to
     */
    public void setGroundFriction(double friction)
    {
        this.groundFriction = friction;
    }

    /**
     * Returns value to which ground friction is set to
     * @return value which represents ground friction
     */
    public double getGroundFriction()
    {
        return this.groundFriction;
    }

    /**
     * Increments ground friction by value
     * I don't know what use this can have but I added this in case
     * @param value how much to increment ground friction by
     */
    public void incrementGroundFriction(double value)
    {
        this.groundFriction += value;
    }

    /**
     * Determines how fast user can accelerate and decelerate while in air
     * Try using it and see what it does
     * @param friction value to which air friction will be set to
     */
    public void setAirFriction(double friction)
    {
        this.airFriction = friction;
    }

    /**
     * Returns the value of air friction
     * @return double value which represents air friction
     */
    public double getAirFriction()
    {
        return this.airFriction;
    }

    /**
     * Increments value of air friction by a certain value
     * I have no idea what use this can have
     * @param value how much to increment air friction by
     */
    public void incrementAirFriction(double value)
    {
        this.airFriction += value;
    }

    /**
     * Determines how fast user can accelerate while touching the ground
     * @param acceleration value to which acceleration will be set to
     */
    public void setAcceleration(double acceleration)
    {
        this.acceleration = acceleration;
    }

    /**
     * Returns this object's acceleration
     * @return value which represents this object's acceleration
     */
    public double getAcceleration()
    {
        return this.acceleration;
    }

    /**
     * Increments acceleration by a given value
     * Good for buff or debuff skill use
     * @param value how much to increment acceleration by
     */
    public void incrementAcceleration(double value)
    {
        this.acceleration += value;
    }

    /**
     * Sets maximum speed object may have
     * @param speed the value to which new max speed will be set to
     */
    public void setMaxSpeed(double speed)
    {
        this.maxSpeed = speed;
    }

    /**
     * Returns max speed this object is allowed to have
     * @return value which represents this object's max speed
     */
    public double getMaxSpeed()
    {
        return this.maxSpeed;
    }

    /**
     * Increment max allowed speed of this object by value
     * Good for skills that speed up character
     * @param value how much to increment max speed by
     */
    public void incrementMaxSpeed(double value)
    {
        this.maxSpeed += value;
    }

    /**
     * Sets the jump value for the object
     * The higher the jump the higher the character will jump
     * @param jump value to which jump will be set to
     */
    public void setJump(double jump)
    {
        this.jump = jump;
    }

    /**
     * Returns the jump value for this object
     * @return value to which jump is set to
     */
    public double getJump()
    {
        return this.jump;
    }

    /**
     * Increments jump value by whatever you specify
     * Can be used for skills
     * @param value value by which to increment jump
     */
    public void incrementJump(double value)
    {
        this.jump += value;
    }
}
