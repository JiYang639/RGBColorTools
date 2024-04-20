import components.standard.Standard;

/**
 * Interface defining core functionalities for RGB color manipulation. This
 * component ensures each RGB value is managed within the standard 8-bit color
 * range.
 *
 * @mathsubtypes <pre>
 *  RGBColorToolsKernel is modeled by a tuple of integers (r, g, b):
 *  Each element (r, g, b) represents the intensity of the Red, Green, and Blue components, respectively.
 *  Each element is constrained within the range [0, 255].
 * </pre>
 * @mathmodel <pre>
 *  type RGBColorToolsKernel is modeled by integer triples (r, g, b) such that 0 <= r, g, b <= 255.
 * </pre>
 * @initially <pre>
 *    ensures:
 *      this.color[0] represents the red component, and 0 <= this.color[0]] <= 255;
 *      this.color[1] represents the green component, and 0 <= this.color[1] <= 255;
 *      this.color[2] represents the blue component, and 0 <= this.color[2] <= 255.
 * </pre>
 */
public interface RGBColorToolsKernel extends Standard<RGBColorTools> {

    /**
     * Gets the red component of the color.
     *
     * @return the value of the red component
     */
    int getR();

    /**
     * Sets the red component of the color.
     *
     * @param r
     *            the new value for the red component
     * @ensures this.getR() == r
     */
    void setR(int r);

    /**
     * Gets the green component of the color.
     *
     * @return the value of the green component
     */
    int getG();

    /**
     * Sets the green component of the color.
     *
     * @param g
     *            the new value for the green component
     * @ensures this.getG() == g
     */
    void setG(int g);

    /**
     * Gets the blue component of the color.
     *
     * @return the value of the blue component
     */
    int getB();

    /**
     * Sets the blue component of the color.
     *
     * @param b
     *            the new value for the blue component
     * @ensures this.getB() == b
     */
    void setB(int b);

}