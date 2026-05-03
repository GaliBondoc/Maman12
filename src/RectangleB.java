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
        _height = Math.abs(getPointNE().getY() - _pointSW.getY());
        _width = Math.abs(getPointNE().getX() - _pointSW.getX());
    }

    public RectangleB(RectangleB r){
        _width = Math.abs(r.getPointNE().getX() - r._pointSW.getX());
        _height = Math.abs(r.getPointNE().getY() - r._pointSW.getY());
        _pointSW = new Point(r._pointSW.getX() , r._pointSW.getY());
        _pointNE = new Point(r.getPointNE().getX() , r.getPointNE().getY());
    }

    public int getWidth(){
        return _width;
    }

    public int getHeight(){
        return _height;
    }

    public Point getPointSW() {
        return new Point(_pointSW);
    }

    public void setWidth(int w){
        _width = (w <= 0)? _width:w;
        _pointNE = new Point((_pointSW.getX() + _width), (_pointSW.getY() + getHeight()));
    }

    public void setHeight(int h){
        _height = (h <= 0) ? _height:h;
        _pointNE = new Point(_pointSW.getX() + getWidth(), (_pointSW.getY() + _height));
    }

    public void setPointSW(Point p){
        _pointSW = new Point (p);
        _pointNE = new Point (_pointSW.getX() + getWidth() , _pointSW.getY() + getHeight());
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
        _pointNE = new Point (_pointSW.getX() + getWidth(), _pointSW.getY() + getHeight());
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
        return new Point((_pointSW.getX() + getWidth()), (_pointSW.getY() + getHeight()));
    }

    public void changeSides(){
        int temp = _width;
        _width = getHeight();
        _height = temp;
        _pointNE = new Point(_pointSW.getX() + _width, _pointSW.getY() + _height);
    }

    public boolean isIn (RectangleB r){return (this._pointSW.getX() >= r._pointSW.getX()
            && this.getPointNE().getX() <= r.getPointNE().getX() && this._pointSW.getY()>= r._pointSW.getY()
            && this.getPointNE().getY() <= r.getPointNE().getY());}

    public boolean overlap (RectangleB r){
        return this.getPointNE().getX() >= r.getPointSW().getX() && this._pointSW.getX() <= r.getPointNE().getX()
                && this.getPointNE().getY() >= r.getPointSW().getY() && this._pointSW.getY() <= r.getPointNE().getY();
    }
}
