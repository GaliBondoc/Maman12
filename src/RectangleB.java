import java.lang.reflect.AnnotatedElement;

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
        if (w <= 0 || w % 10 > 0 || h <= 0 || h % 10 > 0) {
            _pointSW.setX(1);
            _pointSW.setY(1);
        }
    }

    public RectangleB(Point p, int w, int h){
        if (w <= 0 || w % 10 > 0) {
            w = 1;
        }
        if (h <= 0 || h % 10 > 0) {
            h = 1;
        }
        if (p.getX() <= 0 || p.getX() % 10 > 0 || p.getY() <= 0 || p.getY() % 10 > 0){
            p.setX(1);
            p.setY(1);
        }
    }

    public RectangleB(Point sw, Point ne){
        _pointNE = ne;
        _pointSW = sw;
    }

    public RectangleB(RectangleB r){
        int tempW = getWidth();
        int tempH = getHeight();
        _width = tempW;
        _height = tempH;
        _pointSW = this._pointSW;

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

    public boolean equals(RectangleB other){
        return (this.getPointNE() == other.getPointNE() && this.getPointSW() == other.getPointSW()
                && this.getHeight() == other.getHeight() && this.getWidth() == other.getWidth());
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
        _width = getHeight();
        _height = getWidth();
    }

    public boolean isIn (RectangleB r){
        int tempHeightR = r.getHeight();
        int tempWidthR = r.getWidth();
        int tempSWX = r.getPointSW()._x;
        int tempNEY = r.getPointNE()._y;

        return (tempSWX > getPointSW()._x && tempWidthR < getWidth()
                && tempNEY <= getPointNE()._y && tempHeightR <= getHeight());
    }

    public boolean overlap (RectangleB r){
        return (r.getPointSW() == getPointSW() && r.getPointNE() == getPointNE());
    }
}
