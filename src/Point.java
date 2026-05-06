/**
 * The Point class represents a point in a plane, according to the Cartesian coordinate system.
 *
 *@author Galina Bondoc
 *@version 05.06
 */

public class Point
{
    private int _x;
    private int _y; //attribute
    private final double POWER = 2.0;

    /**
     * Constructs a point on the cartesian system
     * @param x represents the x coordinate
     * @param y represents the y coordinate
     */
    public Point(int x, int y){
        _x = x;
        _y = y;
    } // end builder

    /**
     * Copies the original point
     * @param other
     */
    // copier
    public Point(Point other){
        _x = other._x;
        _y = other._y;
    } // end copier

    /**
     * Fetches the x coordinate
     * @return  returns the x coordinate
     */
    public int getX() {
        return _x;
    } // end getX

    /**
     * Fetches the y coordinate
     * @return  returns the y coordinate
     */
    public int getY() {
        return _y;
    } //end getY


    /**
     * Sets the x coordinate at the specified value
     * @param num new value for the x coordinate
     */
    public void setX(int num){
        _x = num;
    } //end setX

    /**
     * Sets the y coordinate at the specified value
     * @param num new value for the y coordinate
     */
    public void setY (int num){
        _y = num;
    } //end setY

    /**
     *
     * @return
     */
    public String toString(){
        return "(" + _x + "," + _y + ")";
    } // end toString

    public boolean equals(Point other){
        return other != null && _x == other._x && _y == other._y;
    } //end equals

    public boolean isAbove(Point other){
        return this._y > other._y;
    } //end isAbove

    public boolean isUnder(Point other){
        return other.isAbove(this); 
    } //end isUnder

    public boolean isLeft(Point other){
        return this._x < other._x;
    } //end isLeft

    public boolean isRight(Point other){
        return other.isLeft(this);
    } //end isRight

    public void move(int deltaX,int deltaY){ // moves deltaX and deltaY accordingly
        _x += deltaX;
        _y += deltaY;
    } // end move

    public double distance(Point p){
        return Math.sqrt((Math.pow((this._x - p._x), POWER) + Math.pow((this._y - p._y), POWER)));
    } // end distance
}
