package Lab5_Paint;


public class PaintDarker extends Paint {
    Paint inner;


    public PaintDarker(Paint inner) {
        this.inner = inner;
    }


    @Override
    public Color getColor() {
        return this.inner.getColor().darker();
    }


}
