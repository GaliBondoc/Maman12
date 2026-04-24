/**
 * Write a description of class RectangleA here.
 *
 * @author Galina Bondoc
 * @since (04 / 11 / 26, 11 : 50)
 */

public class RectangleA {
    private static int _width;
    private static int _height;
    private static Point _pointSW;
    private static Point _pointNE;

    public RectangleA(int w, int h){
        _width = (w <= 0 ? 1 : w);
        _height = (h <= 0 ? 1 : h);
    }

    public RectangleA(Point p, int w, int h){
        if (p == null) {
            w = 1;
            h = 1;
        }
        _pointSW = p;
    }

    public RectangleA(Point sw, Point ne){
        _pointNE = (ne);
        _pointSW = new Point (sw);
    }

    public RectangleA(RectangleA r){
        int tempW = getWidth();
        int tempH = getHeight();
        _width = tempW;
        _height = tempH;
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
        return "Width=" + _width + " Height=" + _height + " PointSW=(" + getPointSW() + ")";
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
        return (this.getPointNE() == other.getPointNE() && this.getPointSW() == other.getPointSW()
                && this.getHeight() == other.getHeight() && this.getWidth() == other.getWidth());
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
        return _pointNE;
    }

    public void changeSides(){
        _width = getHeight();
        _height = getWidth();
    }

    public boolean isIn (RectangleA r){
        int tempHeightR = r.getHeight();
        int tempWidthR = r.getWidth();
        int tempSWX = r.getPointSW()._x;
        int tempNEY = r.getPointNE()._y;

        return (tempSWX > getPointSW()._x && tempWidthR < getWidth()
                && tempNEY <= getPointNE()._y && tempHeightR <= getHeight());
    }

    public boolean overlap (RectangleA r){
        return (r.getPointSW() == getPointSW() && r.getPointNE() == getPointNE());
    }

}
