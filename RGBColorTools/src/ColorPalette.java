import components.sequence.Sequence;
import components.sequence.Sequence1L;

public class ColorPalette {

    private Sequence<RGBColorTools> colorSeq;

    /**
     * Constructs an empty color palette.
     */
    public ColorPalette() {
        this.colorSeq = new Sequence1L<>();
    }

    /**
     * Adds a color to the palette at the specified position.
     *
     * @param color
     *            the RGBColorTools object representing the color
     * @param pos
     *            the position to insert the color
     * @ensures the color is added at the specified position in the palette
     */
    public void addColor(RGBColorTools color, int pos) {
        this.colorSeq.add(pos, color);
    }

    /**
     * Removes the color at the specified position from the palette.
     *
     * @param pos
     *            the position of the color to be removed
     * @ensures the color is removed from the specified position
     */
    public void removeColor(int pos) {
        this.colorSeq.remove(pos);
    }

    /**
     * Blends two colors from the palette and inserts the result at a specified
     * position.
     *
     * @param index1
     *            the index of the first color to blend
     * @param index2
     *            the index of the second color to blend
     * @param pos
     *            the position to insert the blended color
     * @ensures a new color created by blending two existing colors is inserted
     *          at the specified position
     */
    public void blendTwoColors(int index1, int index2, int pos) {
        assert index1 < this.colorSeq.length() && index2 < this.colorSeq
                .length() : "The index is out of scope.";

        RGBColorTools blendedColor = this.colorSeq.entry(index1)
                .overlayColors(this.colorSeq.entry(index2));
        this.colorSeq.add(pos, blendedColor);
    }

    /**
     * Compares the similarity between two colors in the palette.
     *
     * @param index1
     *            the index of the first color
     * @param index2
     *            the index of the second color
     * @return the similarity score between the two colors
     * @ensures returns a value indicating the color similarity
     */
    public double compareTwoColors(int index1, int index2) {
        assert index1 < this.colorSeq.length() && index2 < this.colorSeq
                .length() : "The index is out of scope.";
        assert index1 != index2 : "You compare two same color.";

        double similarity = this.colorSeq.entry(index1)
                .colorSimilarity(this.colorSeq.entry(index2));
        return similarity;
    }

    /**
     * Counts the number of 'warm' colors in the palette.
     *
     * @return the number of warm colors
     * @ensures returns the count of warm colors in the palette
     */
    public int countWarmColor() {
        int number = 0;
        for (int i = 0; i < this.colorSeq.length(); i++) {
            if (this.colorSeq.entry(i).colorIsWarm()) {
                number++;
            }
        }
        return number;
    }

    /**
     * Finds the darkest color in the palette based on grayscale value.
     *
     * @return the darkest RGBColorTools object
     * @ensures returns the color with the lowest grayscale value
     */
    public RGBColorTools darkestColor() {
        RGBColorTools darkest = new RGBColorTools1();
        int grayscale = 0;
        for (int i = 0; i < this.colorSeq.length(); i++) {
            if (this.colorSeq.entry(i).toGrayscale() > grayscale) {
                darkest = this.colorSeq.entry(i);
                grayscale = this.colorSeq.entry(i).toGrayscale();
            }
        }
        return darkest;
    }

    /**
     * Finds the lightest color in the palette based on grayscale value.
     *
     * @return the lightest RGBColorTools object
     * @ensures returns the color with the highest grayscale value
     */
    public RGBColorTools lightestColor() {
        RGBColorTools lightest = new RGBColorTools1();
        int grayscale = 255;
        for (int i = 0; i < this.colorSeq.length(); i++) {
            if (this.colorSeq.entry(i).toGrayscale() < grayscale) {
                lightest = this.colorSeq.entry(i);
                grayscale = this.colorSeq.entry(i).toGrayscale();
            }
        }
        return lightest;
    }

    /**
     * Generates a string representation of all colors in the palette.
     *
     * @return a string containing representations of all colors
     * @ensures returns a concatenated string of all color representations
     */
    public String printPalette() {
        String re = "";
        for (RGBColorTools color : this.colorSeq) {
            re = re + color.toString();
        }
        return re;
    }

    public static void main(String[] args) {
        ColorPalette palette = new ColorPalette();

        RGBColorTools color1 = new RGBColorTools1();
        color1.setR(255);
        color1.setG(10);
        color1.setB(20);

        RGBColorTools color2 = new RGBColorTools1();
        color2.setR(0);
        color2.setG(255);
        color2.setB(0);

        RGBColorTools color3 = new RGBColorTools1();
        color3.setR(2);
        color3.setG(4);
        color3.setB(255);

        palette.addColor(color1, 0);
        palette.addColor(color2, 0);
        palette.addColor(color3, 0);
        palette.blendTwoColors(0, 1, 0);

        RGBColorTools darkestcolor = palette.darkestColor();
        RGBColorTools lightestcolor = palette.lightestColor();

        double similarity = palette.compareTwoColors(0, 1);
        System.out.println(
                "The first and second colors iin palette has similarity "
                        + similarity);

        System.out.println("The palette has colors below:");
        System.out.println(palette.printPalette());
        System.out.println("The palette has " + palette.countWarmColor()
                + " warm colors.");
        System.out.println(
                "The palette has darkest color" + darkestcolor.toString());
        System.out.println(
                "The palette has lightest color" + lightestcolor.toString());

    }
}