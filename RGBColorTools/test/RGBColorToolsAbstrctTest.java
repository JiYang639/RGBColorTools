import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code RGBColorTools}'s abstract methods.
 *
 * @author Yang Ji
 *
 */
public abstract class RGBColorToolsAbstrctTest {

    protected abstract RGBColorTools constructorTest();

    private RGBColorTools createFromArgsTest(int r, int g, int b) {
        assert r >= 0 && r <= 255 : "The red channel is not valid";
        assert g >= 0 && g <= 255 : "The green channel is not valid";
        assert b >= 0 && b <= 255 : "The blue channel is not valid";
        RGBColorTools color = this.constructorTest();
        color.setR(r);
        color.setG(g);
        color.setB(b);
        return color;
    }

    @Test
    public final void testIsWarmTrue() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 57, 98);
        RGBColorTools colorRef = this.createFromArgsTest(100, 57, 98);
        assertEquals(colorTest.colorIsWarm(), true);
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testIsWarmFalse() {
        RGBColorTools colorTest = this.createFromArgsTest(1, 57, 98);
        RGBColorTools colorRef = this.createFromArgsTest(1, 57, 98);
        assertEquals(colorTest.colorIsWarm(), false);
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testinvertColorWhite() {
        RGBColorTools colorTest = this.createFromArgsTest(0, 0, 0);
        RGBColorTools colorRef = this.createFromArgsTest(255, 255, 255);
        colorTest.invertColor();
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testinvertColorBlack() {
        RGBColorTools colorTest = this.createFromArgsTest(255, 255, 255);
        RGBColorTools colorRef = this.createFromArgsTest(0, 0, 0);
        colorTest.invertColor();
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testinvertColorNormal() {
        RGBColorTools colorTest = this.createFromArgsTest(200, 55, 155);
        RGBColorTools colorRef = this.createFromArgsTest(55, 200, 100);
        colorTest.invertColor();
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testtoGrayscaleOneZero() {
        RGBColorTools colorTest = this.createFromArgsTest(0, 55, 155);
        RGBColorTools colorRef = this.createFromArgsTest(0, 55, 155);
        assertEquals(49, colorTest.toGrayscale());
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testtoGrayscaleTwoZero() {
        RGBColorTools colorTest = this.createFromArgsTest(0, 0, 155);
        RGBColorTools colorRef = this.createFromArgsTest(0, 0, 155);
        assertEquals(17, colorTest.toGrayscale());
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testtoGrayscaleWhite() {
        RGBColorTools colorTest = this.createFromArgsTest(0, 0, 0);
        RGBColorTools colorRef = this.createFromArgsTest(0, 0, 0);
        assertEquals(0, colorTest.toGrayscale());
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testtoGrayscaleBlack() {
        RGBColorTools colorTest = this.createFromArgsTest(255, 255, 255);
        RGBColorTools colorRef = this.createFromArgsTest(255, 255, 255);
        assertEquals(255, colorTest.toGrayscale());
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testextractRedChannel() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 20, 200);
        RGBColorTools colorRef = this.createFromArgsTest(100, 20, 200);
        assertEquals(100, colorTest.extractSingleChannel(0));
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testextractGreenChannel() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 20, 200);
        RGBColorTools colorRef = this.createFromArgsTest(100, 20, 200);
        assertEquals(20, colorTest.extractSingleChannel(1));
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testextractBlurChannel() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 20, 200);
        RGBColorTools colorRef = this.createFromArgsTest(100, 20, 200);
        assertEquals(200, colorTest.extractSingleChannel(2));
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testOverlayColor() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 20, 200);
        RGBColorTools colorRef = this.createFromArgsTest(60, 60, 120);
        RGBColorTools colorAdd = this.createFromArgsTest(20, 100, 40);
        RGBColorTools colornew = colorTest.overlayColors(colorAdd);
        assertEquals(colornew, colorRef);
    }

    @Test
    public final void testOverlayColor2() {
        RGBColorTools colorTest = this.createFromArgsTest(60, 100, 20);
        RGBColorTools colorRef = this.createFromArgsTest(30, 75, 60);
        RGBColorTools colorAdd = this.createFromArgsTest(0, 50, 100);
        RGBColorTools colornew = colorTest.overlayColors(colorAdd);
        assertEquals(colornew, colorRef);
    }

    @Test
    public final void testblendColorsWithRatio0() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 20, 200);
        RGBColorTools colorRef = this.createFromArgsTest(100, 20, 200);
        RGBColorTools colorAdd = this.createFromArgsTest(20, 100, 40);
        RGBColorTools colornew = colorTest.blendColorsWithRatio(colorAdd, 0);
        assertEquals(colornew, colorRef);
    }

    @Test
    public final void testblendColorsWithRatio1() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 20, 200);
        RGBColorTools colorRef = this.createFromArgsTest(20, 100, 40);
        RGBColorTools colorAdd = this.createFromArgsTest(20, 100, 40);
        RGBColorTools colornew = colorTest.blendColorsWithRatio(colorAdd, 1);
        assertEquals(colornew, colorRef);
    }

    @Test
    public final void testblendColorsWithRatiobetween0and1() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 20, 200);
        RGBColorTools colorRef = this.createFromArgsTest(80, 40, 160);
        RGBColorTools colorAdd = this.createFromArgsTest(20, 100, 40);
        RGBColorTools colornew = colorTest.blendColorsWithRatio(colorAdd, 0.25);
        assertEquals(colornew, colorRef);
    }

    @Test
    public final void testColorSimilaritySame() {
        RGBColorTools colorTest = this.createFromArgsTest(80, 40, 160);
        RGBColorTools colorAdd = this.createFromArgsTest(80, 40, 160);
        double similarity = colorTest.colorSimilarity(colorAdd);
        assertEquals(similarity, 1, 0.01);
    }

    @Test
    public final void testColorSimilarityCompletelyDifferent() {
        RGBColorTools colorTest = this.createFromArgsTest(0, 0, 0);
        RGBColorTools colorAdd = this.createFromArgsTest(255, 255, 255);
        double similarity = colorTest.colorSimilarity(colorAdd);
        assertEquals(similarity, 0, 0.01);
    }

    @Test
    public final void testColorSimilarityDifferent() {
        RGBColorTools colorTest = this.createFromArgsTest(123, 89, 65);
        RGBColorTools colorAdd = this.createFromArgsTest(24, 45, 23);
        double similarity = colorTest.colorSimilarity(colorAdd);
        assertEquals(similarity, 0.737, 0.01);
    }

    @Test
    public final void testToString() {
        RGBColorTools colorTest = this.createFromArgsTest(123, 89, 65);
        String re = colorTest.toString();
        assertEquals(re, "[R=123, G=89, B=65]");
    }

    @Test
    public final void testEqualTrue() {
        RGBColorTools colorTest = this.createFromArgsTest(123, 89, 65);
        Object colorRef = this.createFromArgsTest(123, 89, 65);
        assertEquals(colorTest.equals(colorRef), true);
    }

    @Test
    public final void testEqualFalse() {
        RGBColorTools colorTest = this.createFromArgsTest(123, 90, 65);
        Object colorRef = this.createFromArgsTest(123, 89, 65);
        assertEquals(colorTest.equals(colorRef), false);
    }

    @Test
    public final void testHashCode() {
        RGBColorTools colorTest = this.createFromArgsTest(0, 0, 0);
        assertEquals(colorTest.hashCode(), 0);
    }

    @Test
    public final void testHashCode2() {
        RGBColorTools colorTest = this.createFromArgsTest(200, 100, 24);
        assertEquals(colorTest.hashCode(), 324);
    }

}
