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
        _pointSW = p;
    }

    public RectangleA(Point sw, Point ne){
        _pointSW = new Point (sw);
        _height = Math.abs(ne.getY() - sw.getY());
        _width = Math.abs(ne.getX() - sw.getX());
    }

    public RectangleA(RectangleA r){
        _width = r._width;
        _height = r._height;
        _pointSW = new Point (r._pointSW.getX(), r._pointSW.getY());
    }

    public int getWidth(){
        return _width;
    }

    public int getHeight(){
        return _height;
    }

    public Point getPointSW(){
        return _pointSW;
    }

    public void setWidth(int w){
        _width = (w <= 0)? _width:w;
    }

    public void setHeight(int h){
        _height = (h <= 0) ? _height:h;
    }

    public void setPointSW(Point p){
        _pointSW._x = p._x;
        _pointSW._y = p._y;
    }

    public String toString(){
        return "Width=" + _width + " Height=" + _height + " PointSW=" + getPointSW();
    }

    public int getPerimeter(){
        return (_height + _width) * 2;
    }

    public int getArea(){
        return _height * _width;
    }

    public void move(int deltaX, int deltaY){
        int tempMoveX = _pointSW.getX() + deltaX;
        int tempMoveY = _pointSW.getY() + deltaY;
        _pointSW._x = tempMoveX;
        _pointSW._y = tempMoveY;
    }

    public boolean equals(RectangleA other){
        return (this.getPointSW().equals(other.getPointSW()) && this.getHeight() == other.getHeight()
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
        return new Point((_pointSW.getX() + _width), (_pointSW.getY() + _height));
    }

    public void changeSides(){
        int temp = _width;
        _width = getHeight();
        _height = temp;
    }

    public boolean isIn (RectangleA r){return (this._pointSW.getX() >= r._pointSW.getX()
            && this.getPointNE().getX() <= r.getPointNE().getX() && this._pointSW.getY()>= r._pointSW.getY()
            && this.getPointNE().getY() <= r.getPointNE().getY());}

    public boolean overlap (RectangleA r){
        return this._pointSW.getX() <= r.getPointNE().getX() && this._pointSW.getY() <= r.getPointNE().getY()
            || this._pointSW.getY() >= r._pointSW.getX() && this._pointSW.getX() <= r.getPointNE().getY()
            || this.getPointNE().getX() >= r._pointSW.getX() && this._pointSW.getX() <= r.getPointNE().getY()
            || this.getPointNE().getX() >= r._pointSW.getX() && this.getPointNE().getY() >= r._pointSW.getY()
            || this.getPointNE().getX() >= r.getPointNE().getX() && this.getPointNE().getY() >= r.getPointNE().getY()
            && this._pointSW.getX() <= r._pointSW.getX() && this._pointSW.getY() <= r._pointSW.getY()
            || this.getPointNE().getX() <= r.getPointNE().getX() && this.getPointNE().getY() <= r.getPointNE().getY()
            && this._pointSW.getX() >= r._pointSW.getX() && this._pointSW.getY() >= r._pointSW.getY();
    }


}
