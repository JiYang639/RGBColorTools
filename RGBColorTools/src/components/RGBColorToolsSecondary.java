/**
 * Layered implementations of secondary methods for {@code RGBColorToolsKernel}
 */
public abstract class RGBColorToolsSecondary implements RGBColorTools {

    @Override
    public boolean colorIsWarm() {
        boolean answer = false;
        if ((this.getR() + this.getG()) > this.getB()) {
            answer = true;
        }
        return answer;
    }

    @Override
    public void invertColor() {
        this.setR(255 - this.getR());
        this.setG(255 - this.getG());
        this.setB(255 - this.getB());
    }

    @Override
    public int toGrayscale() {
        int gray = (int) (0.299 * this.getR() + 0.587 * this.getG()
                + 0.114 * this.getB());
        return gray;
    }

    @Override
    public int extractSingleChannel(int Whichchannel) {
        assert Whichchannel < 3 && Whichchannel >= 0 : ""
                + "Violation of: channel is out of range";

        int color = -1;
        if (Whichchannel == 0) {
            color = this.getR();
        } else if (Whichchannel == 1) {
            color = this.getG();
        } else {
            color = this.getB();
        }
        return color;
    }

    @Override
    public RGBColorTools overlayColors(RGBColorTools color) {
        RGBColorTools newcolor = new RGBColorTools1();
        newcolor.setR((this.getR() + color.getR()) / 2);
        newcolor.setG((this.getG() + color.getG()) / 2);
        newcolor.setB((this.getB() + color.getB()) / 2);
        return newcolor;
    }

    @Override
    public RGBColorTools blendColorsWithRatio(RGBColorTools color,
            double ratio) {
        RGBColorTools newcolor = new RGBColorTools1();
        newcolor.setR((int) (this.getR() * (1 - ratio) + color.getR() * ratio));
        newcolor.setG((int) (this.getG() * (1 - ratio) + color.getG() * ratio));
        newcolor.setB((int) (this.getB() * (1 - ratio) + color.getB() * ratio));
        return newcolor;
    }

    @Override
    public double colorSimilarity(RGBColorTools color) {
        double distance = Math
                .sqrt((Math.pow((this.getR() - color.getR()) * 1.0 / 255, 2)
                        + Math.pow((this.getG() - color.getG()) * 1.0 / 255, 2)
                        + Math.pow((this.getB() - color.getB()) * 1.0 / 255, 2))
                        * 1.0 / 3);
        double similarity = 1 - distance;
        return similarity;
    }

    // Rewrite common method
    @Override
    public String toString() {
        String re = "[R=" + this.getR() + ", G=" + this.getG() + ", B="
                + this.getB() + "]";
        return re;
    }

    @Override
    public boolean equals(Object obj) {
        assert obj != null : "The object can not be null.";

        boolean answer = false;
        RGBColorTools that = (RGBColorTools) obj;
        answer = this.getR() == that.getR() && this.getG() == that.getG()
                && this.getB() == that.getB();
        return answer;
    }

    @Override
    public int hashCode() {
        return this.getR() + this.getG() + this.getB();
    }

}