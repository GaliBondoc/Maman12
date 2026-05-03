/**
 * Write a description of class RectangleA here.
 *
 * @author Galina Bondoc
 * @since (04 / 11 / 26, 11 : 50)
 */

public class RectangleA {
    private int _width;
    private int _height;
    private Point _pointSW;

    public RectangleA(int w, int h){
        if (w <= 0)
            w = 1;
        if (h <= 0)
            h = 1;
        _width = w;
        _height = h;
        _pointSW = new Point (0 , 0);
    }

    public RectangleA(Point p, int w, int h){
        if (w <= 0)
            w = 1;
        if (h <= 0)
            h = 1;

        _height = h;
        _width = w;
        _pointSW = new Point (p);
    }

    public RectangleA(Point sw, Point ne){
        _pointSW = new Point (sw);
        _height = Math.abs(ne.getY() - sw.getY());
        _width = Math.abs(ne.getX() - sw.getX());
    }

    public RectangleA(RectangleA r){
        _width = r.getWidth();
        _height = r.getHeight();
        _pointSW = new Point (r._pointSW.getX(), r._pointSW.getY());
    }

    public int getWidth(){
        return _width;
    }

    public int getHeight(){
        return _height;
    }

    public Point getPointSW(){
        return new Point(_pointSW);
    }

    public void setWidth(int w){
        _width = (w <= 0)? _width:w;
    }

    public void setHeight(int h){
        _height = (h <= 0) ? _height:h;
    }

    public void setPointSW(Point p){
        _pointSW = new Point (p);
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
        _pointSW = new Point(_pointSW.getX() + deltaX, _pointSW.getY() + deltaY);
    }

    public boolean equals(RectangleA other){
        return (this._pointSW.equals(other._pointSW) && this.getHeight() == other.getHeight()
                && this.getWidth() == other.getWidth());
    }

    public double getDiagonalLength(){
        int tempW = getHeight();
        int tempH = getWidth();
        double d = (Math.pow(tempW, 2) + Math.pow(tempH, 2));
        return Math.sqrt(d);
    }

    public boolean isLarger(RectangleA other){
        return (this.getArea() > other.getArea());
    }

    public Point getPointNE(){
        return new Point((_pointSW.getX() + getWidth()), (_pointSW.getY() + getHeight()));
    }

    public void changeSides(){
        int temp = getWidth();
        _width = getHeight();
        _height = temp;
    }

    public boolean isIn (RectangleA r){
        return (this._pointSW.getX() >= r.getPointSW().getX() && this.getPointNE().getX() <= r.getPointNE().getX()
                && this._pointSW.getY()>= r.getPointSW().getY() && this.getPointNE().getY() <= r.getPointNE().getY());}

    public boolean overlap (RectangleA r){
        return this.getPointNE().getX() >= r.getPointSW().getX() && this._pointSW.getX() <= r.getPointNE().getX()
                && this.getPointNE().getY() >= r.getPointSW().getY() && this._pointSW.getY() <= r.getPointNE().getY();
    }


}
