public class ColorPair {

    private RGBColorTools Pickone;
    private RGBColorTools Picktwo;

    /**
     * Constructs a color pair.
     */
    public ColorPair(RGBColorTools Pickone, RGBColorTools Picktwo) {
        this.Pickone = Pickone;
        this.Picktwo = Picktwo;
    }

    public void changeColor(int i, RGBColorTools colornew) {
        assert i == 1
                || i == 2 : "Only two colors. Please enter a valid integer.";

        if (i == 1) {
            assert !this.Pickone.equals(colornew) : "Two colors are same.";
            this.Pickone.setR(colornew.getR());
            this.Pickone.setG(colornew.getG());
            this.Pickone.setB(colornew.getB());
        } else {
            assert !this.Picktwo.equals(colornew) : "Two colors are same.";
            this.Picktwo.setR(colornew.getR());
            this.Picktwo.setG(colornew.getG());
            this.Picktwo.setB(colornew.getB());
        }
    }

    public boolean firstIsDarker() {
        return (this.Pickone.toGrayscale() > this.Picktwo.toGrayscale());
    }

    public RGBColorTools blendTwoColors() {
        RGBColorTools blendedColor = this.Pickone.overlayColors(this.Picktwo);
        return blendedColor;
    }

    /**
     * Counts the number of 'warm' colors in the palette.
     *
     * @return the number of warm colors
     * @ensures returns the count of warm colors in the palette
     */
    public int countWarmColor() {
        int number = 0;
        if (this.Pickone.colorIsWarm()) {
            number++;
        }
        if (this.Picktwo.colorIsWarm()) {
            number++;
        }
        return number;
    }

    /**
     * Generates a string representation of all colors in the palette.
     *
     * @return a string containing representations of all colors
     * @ensures returns a concatenated string of all color representations
     */
    public String printColorPair() {
        return this.Pickone.toString() + this.Picktwo.toString();
    }

    public static void main(String[] args) {
        RGBColorTools color1 = new RGBColorTools1();
        color1.setR(255);
        color1.setG(10);
        color1.setB(20);

        RGBColorTools color2 = new RGBColorTools1();
        color2.setR(0);
        color2.setG(245);
        color2.setB(45);

        RGBColorTools color3 = new RGBColorTools1();
        color3.setR(255);
        color3.setG(20);
        color3.setB(40);

        ColorPair colorPair = new ColorPair(color1, color2);

        colorPair.changeColor(1, color3);
        boolean firstIsDarker = colorPair.firstIsDarker();
        RGBColorTools blendColor = colorPair.blendTwoColors();
        int numberOfWarColor = colorPair.countWarmColor();

        System.out.println("The color pair has two colors:");
        System.out.println(colorPair.printColorPair());
        System.out.println("Is the first color darker? " + firstIsDarker);
        System.out.println(
                "The color pair has " + numberOfWarColor + " warm colors.");
        System.out.println(
                "The color pair has blended color: " + blendColor.toString());

    }
}