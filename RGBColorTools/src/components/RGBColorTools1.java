/**
 * {@code RGBColorTools1} represented as an array of integers for RGB
 * components, extending {@code RGBColorToolsSecondary} with specific behaviors.
 *
 * @convention <pre>
 * The RGB values are stored in an integer array 'color' of length 3,
 * where color[0], color[1], and color[2] are within the range [0, 255].
 * </pre>
 * @correspondence <pre>
 * This.color[0] -> red component,
 * This.color[1] -> green component,
 * This.color[2] -> blue component.
 * </pre>
 * @author Yang Ji
 */

public class RGBColorTools1 extends RGBColorToolsSecondary {

    private int[] color;

    /**
     * Creator of initial representation.
     */
    public void createNewRep() {
        this.color = new int[3];
    }

    public RGBColorTools1() {
        this.createNewRep();
    }

    @Override
    public int compareTo(RGBColorTools o) {
        int one = this.getR() + this.getG() + this.getB();
        int two = o.getR() + o.getG() + o.getB();

        return Integer.compare(one, two);
    }

    @Override
    public int getR() {
        return this.color[0];
    }

    @Override
    public void setR(int r) {
        assert r >= 0 && r <= 255 : "Violation of: red channel is not valid";
        this.color[0] = r;

    }

    @Override
    public int getG() {
        return this.color[1];
    }

    @Override
    public void setG(int g) {
        assert g >= 0 && g <= 255 : "Violation of: green channel is not valid";
        this.color[1] = g;

    }

    @Override
    public int getB() {
        return this.color[2];
    }

    @Override
    public void setB(int b) {
        assert b >= 0 && b <= 255 : "Violation of: blue channel is not valid";
        this.color[2] = b;

    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public RGBColorTools newInstance() {
        RGBColorTools newColorTool = new RGBColorTools1();
        return newColorTool;
    }

    @Override
    public void transferFrom(RGBColorTools arg0) {
        assert arg0 != null : "Violation of: source is not null";
        assert arg0 != this : "Violation of: source is not this";
        assert arg0.getR() >= 0 && arg0
                .getR() <= 255 : "Violation of: red channel of red channel is not valid";
        assert arg0.getG() >= 0 && arg0
                .getG() <= 255 : "Violation of: green channel of red channel is not valid";
        assert arg0.getB() >= 0 && arg0
                .getB() <= 255 : "Violation of: blue channel of red channel is not valid";

        this.setR(arg0.getR());
        this.setG(arg0.getG());
        this.setB(arg0.getB());
        arg0.clear();

    }

}