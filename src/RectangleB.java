/**
 * Write a description of class RectangleB here.
 *
 * @author Galina Bondoc
 * @since ()04/10/26, 13:22)
 */
public class RectangleB {

    private Point _pointSW;
    private Point _pointNE;
    private int _width;
    private int _height;


    public RectangleB(int w, int h){
        if (w <= 0)
            w = 1;
        if (h <= 0)
            h = 1;
        _height = h;
        _width = w;
        _pointSW = new Point (0 , 0);
        _pointNE = new Point (w , h);
    }

    public RectangleB(Point p, int w, int h){
        if (w <= 0)
            w = 1;
        if (h <= 0)
            h = 1;
        _height = h;
        _width = w;
        _pointSW = new Point (p);
        _pointNE = new Point (_pointSW.getX() + w , _pointSW.getY() + h);
    }

    public RectangleB(Point sw, Point ne){
        _pointNE = new Point(ne);
        _pointSW = new Point(sw);
        _height = Math.abs(_pointNE.getY() - _pointSW.getY());
        _width = Math.abs(_pointNE.getX() - _pointSW.getX());
    }

    public RectangleB(RectangleB r){
        _width = Math.abs(r.getPointNE().getX() - r.getPointSW().getX());
        _height = Math.abs(r.getPointNE().getY() - r.getPointSW().getY());
        _pointSW = new Point(r.getPointSW().getX() , r.getPointSW().getY());
        _pointNE = new Point(r.getPointNE().getX() , r.getPointNE().getY());
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

    public boolean equals(RectangleB other){
        return (this.getPointSW().equals(other.getPointSW()) && this.getHeight() == other.getHeight()
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
        return _pointNE;
    }

    public void changeSides(){
        int temp = _width;
        _width = getHeight();
        _height = temp;
    }

    public boolean isIn (RectangleB r){return (this._pointSW.getX() >= r._pointSW.getX()
            && this._pointNE.getX() <= r._pointNE.getX() && this._pointSW.getY()>= r._pointSW.getY()
            && this._pointNE.getY() <= r._pointNE.getY());}

    public boolean overlap (RectangleB r){
        return this._pointSW.getX() <= r._pointNE.getX() && this._pointSW.getY() <= r._pointNE.getY()
                || this._pointSW.getY() >= r._pointSW.getX() && this._pointSW.getX() <= r._pointNE.getY()
                || this._pointNE.getX() >= r._pointSW.getX() && this._pointSW.getX() <= r._pointNE.getY()
                || this._pointNE.getX() >= r._pointSW.getX() && this._pointNE.getY() >= r._pointSW.getY()
                || this._pointNE.getX() >= r._pointNE.getX() && this._pointNE.getY() >= r._pointNE.getY()
                && this._pointSW.getX() <= r._pointSW.getX() && this._pointSW.getY() <= r._pointSW.getY()
                || this._pointNE.getX() <= r._pointNE.getX() && this._pointNE.getY() <= r._pointNE.getY()
                && this._pointSW.getX() >= r._pointSW.getX() && this._pointSW.getY() >= r._pointSW.getY();
    }
}
