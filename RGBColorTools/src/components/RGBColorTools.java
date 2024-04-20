/**
 * {@code RGBColorToolsKernel} enhanced with secondary methods.
 */
public interface RGBColorTools
        extends Comparable<RGBColorTools>, RGBColorToolsKernel {

    /**
     * Determines if a color is 'warm' based on the combined intensity of red
     * and green channels compared to blue.
     *
     * @return true if the sum of the red and green channels exceeds the blue
     *         channel, false otherwise
     * @ensures returns true if (R + G) > B, otherwise false
     */
    boolean colorIsWarm();

    /**
     * Inverts the current color by subtracting each color channel value from
     * 255.
     *
     * @ensures each color channel value is set to 255 minus its original value
     */
    void invertColor();

    /**
     * Converts the current color to its grayscale equivalent using standard
     * luminance calculation.
     *
     * @return the grayscale value
     * @ensures returns an integer representing the grayscale value calculated
     *          using the formula 0.299*R + 0.587*G + 0.114*B
     */
    int toGrayscale();

    /**
     * Extracts the value of a single color channel.
     *
     * @param Whichchannel
     *            the channel index (0 for red, 1 for green, 2 for blue)
     * @return the value of the specified channel
     * @ensures returns the value of the specified channel
     * @throws AssertionError
     *             if the input channel index is out of range (not 0, 1, or 2)
     */
    int extractSingleChannel(int Whichchannel);

    /**
     * Creates a new color by averaging the channels of this color and another
     * specified color.
     *
     * @param color
     *            the RGBColorTools object to overlay with this color
     * @return a new RGBColorTools object representing the overlay color
     * @ensures the RGB values of the returned color are the averages of the
     *          corresponding channels of this color and the specified color
     */
    RGBColorTools overlayColors(RGBColorTools color);

    /**
     * Blends this color with another color using a specified ratio.
     *
     * @param color
     *            the other RGBColorTools object to blend with
     * @param ratio
     *            the blending ratio from 0.0 to 1.0 where 1 is full this color,
     *            0 is full the other color
     * @return a new RGBColorTools object representing the blended color
     * @ensures the RGB values of the returned color are computed as
     *          R1*(1-ratio) + R2*ratio for each channel
     */
    RGBColorTools blendColorsWithRatio(RGBColorTools color, double ratio);

    /**
     * Computes the similarity between this color and another color based on
     * their RGB values.
     *
     * @param color
     *            the other RGBColorTools object to compare with
     * @return the similarity score, a double between 0.0 (completely different)
     *         and 1.0 (identical)
     * @ensures returns a similarity score calculated using the Euclidean
     *          distance of normalized RGB values
     */
    double colorSimilarity(RGBColorTools color);

}