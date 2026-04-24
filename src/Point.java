/**
 * The Point class represents a point in a plane, according to the Cartesian coordinate system.
 *
 *@author Galina Bondoc
 *@version
 */

public class Point
{
    public int _x;
    public int _y; //attribute
    private final double POWER = 2.0;

    //builder 1
    public Point(int x, int y){
        int _x = x;
        int _y = y;
    } // end builder

    // copier
    public Point(Point other){
        _x = other._x;
        _y = other._y;
    } // end copier

    //getter
    public int getX() {
        return _x;
    } // end getX

    public int getY() {
        return _y;
    } //end getY

    //setter
    public void setX(int num){
        _x = num;
    } //end setX

    public void setY (int num){
        _y = num;
    } //end setY

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
