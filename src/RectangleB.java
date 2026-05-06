/**
 * Write a description of class RectangleB here.
 *
 * @author Galina Bondoc
 * @version 05.06
 */
public class RectangleB {

    private Point _pointSW;
    private Point _pointNE;



    public RectangleB(int w, int h){
        int width, height;

        if (w > 0)
            width = w;
        else
            width = 1;

        if (h > 0)
            height = h;
        else
            height = 1;

        _pointSW = new Point (0 , 0);
        _pointNE = new Point (width , height);
    }

    public RectangleB(Point p, int w, int h){
        int width, height;

        if (w > 0)
            width = w;
        else
            width = 1;

        if (h > 0)
            height = h;
        else
            height = 1;

        _pointSW = new Point (p);
        _pointNE = new Point (_pointSW.getX() + width , _pointSW.getY() + height);
    }

    public RectangleB(Point sw, Point ne){
        _pointNE = new Point(ne);
        _pointSW = new Point(sw);

    }

    public RectangleB(RectangleB r){
        _pointSW = new Point(r._pointSW.getX() , r._pointSW.getY());
        _pointNE = new Point(r.getPointNE().getX() , r.getPointNE().getY());
    }

    public int getWidth(){
        return Math.abs(this.getPointSW().getX() - getPointNE().getX());
    }

    public int getHeight(){
        return Math.abs(this.getPointSW().getY() - getPointNE().getY());
    }

    public Point getPointSW() {
        return new Point(_pointSW);
    }

    public void setWidth(int w){
        if (w > 0)
            _pointNE = new Point((_pointSW.getX() + w), (_pointSW.getY() + getHeight()));
    }

    public void setHeight(int h){
         if (h > 0)
        _pointNE = new Point(_pointSW.getX() + getWidth(), (_pointSW.getY() + h));
    }

    public void setPointSW(Point p){
        int oldW = Math.abs(_pointSW.getX() - _pointNE.getX());
        int oldH = Math.abs(_pointSW.getY() - _pointNE.getY());
        _pointSW = new Point (p);
        _pointNE = new Point (_pointSW.getX() + oldW , _pointSW.getY() + oldH);
    }

    public String toString(){
        return "Width=" + getWidth() + " Height=" + getHeight() + " PointSW=" + _pointSW;
    }

    public int getPerimeter(){
        return (getHeight() + getWidth()) * 2;
    }

    public int getArea(){
        return getHeight() * getWidth();
    }

    public void move(int deltaX, int deltaY){
        int oldW = Math.abs(_pointSW.getX() - _pointNE.getX());
        int oldH = Math.abs(_pointSW.getY() - _pointNE.getY());

        _pointSW = new Point(_pointSW.getX() + deltaX, _pointSW.getY() + deltaY);
        _pointNE = new Point (_pointSW.getX() + oldW, _pointSW.getY() + oldH);
    }

    public boolean equals(RectangleB other){
        return (this._pointSW.equals(other._pointSW) && this.getHeight() == other.getHeight()
                && this.getWidth() == other.getWidth());
    }

    public double getDiagonalLength(){
        int tempW = getHeight();
        int tempH = getWidth();
        double d = (Math.pow(tempW, 2) + Math.pow(tempH, 2));
        return Math.sqrt(d);
    }

    public boolean isLarger(RectangleB other){
        return (this.getArea() > other.getArea());
    }

    public Point getPointNE(){
        return new Point(_pointNE);
    }

    public void changeSides(){
        int oldW = Math.abs(_pointSW.getX() - _pointNE.getX());
        int oldH = Math.abs(_pointSW.getY() - _pointNE.getY());

        _pointNE = new Point(_pointSW.getX() + oldH, _pointSW.getY() + oldW);
    }

    public boolean isIn (RectangleB r){return (this._pointSW.getX() >= r._pointSW.getX()
            && this.getPointNE().getX() <= r.getPointNE().getX() && this._pointSW.getY()>= r._pointSW.getY()
            && this.getPointNE().getY() <= r.getPointNE().getY());}

    public boolean overlap (RectangleB r){
        return this.getPointNE().getX() >= r.getPointSW().getX() && this._pointSW.getX() <= r.getPointNE().getX()
                && this.getPointNE().getY() >= r.getPointSW().getY() && this._pointSW.getY() <= r.getPointNE().getY();
    }
}
