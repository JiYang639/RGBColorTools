import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code RGBColorTools}'s constructor and kernel
 * methods.
 *
 * @author Yang Ji
 *
 */
public abstract class RGBColorToolsKernelTest {

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
    public final void testConstructor() {
        RGBColorTools test = this.constructorTest();
        RGBColorTools actual = this.constructorTest();
        assertEquals(test, actual);
    }

    @Test
    public final void testGetR() {
        RGBColorTools color = this.createFromArgsTest(10, 56, 90);
        assertEquals(color.getR(), 10);
    }

    @Test
    public final void testGetG() {
        RGBColorTools color = this.createFromArgsTest(10, 56, 90);
        assertEquals(color.getG(), 56);
    }

    @Test
    public final void testGetB() {
        RGBColorTools color = this.createFromArgsTest(10, 56, 90);
        assertEquals(color.getB(), 90);
    }

    @Test
    public final void testSetR() {
        RGBColorTools colorTest = this.createFromArgsTest(10, 89, 34);
        RGBColorTools colorRef = this.createFromArgsTest(56, 89, 34);
        colorTest.setR(56);
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testSetG() {
        RGBColorTools colorTest = this.createFromArgsTest(10, 89, 34);
        RGBColorTools colorRef = this.createFromArgsTest(10, 204, 34);
        colorTest.setG(204);
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testSetB() {
        RGBColorTools colorTest = this.createFromArgsTest(3, 89, 34);
        RGBColorTools colorRef = this.createFromArgsTest(3, 89, 75);
        colorTest.setB(75);
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testClear() {
        RGBColorTools colorTest = this.createFromArgsTest(3, 89, 34);
        RGBColorTools colorRef = this.constructorTest();
        colorTest.clear();
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testNewInstance() {
        RGBColorTools colorTest = this.createFromArgsTest(3, 89, 34);
        RGBColorTools colorRef = this.constructorTest();
        RGBColorTools newcolor = colorTest.newInstance();
        assertEquals(newcolor, colorRef);
    }

    @Test
    public final void testTransferFrom() {
        RGBColorTools colorTest = this.constructorTest();
        RGBColorTools colorRef = this.createFromArgsTest(100, 67, 89);
        RGBColorTools color = this.createFromArgsTest(100, 67, 89);
        colorTest.transferFrom(color);
        assertEquals(colorTest, colorRef);
    }

    @Test
    public final void testCompareToSame() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 67, 89);
        RGBColorTools colorRef = this.createFromArgsTest(100, 67, 89);
        assertEquals(colorTest.compareTo(colorRef), 0);
    }

    @Test
    public final void testCompareToLarge() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 68, 89);
        RGBColorTools colorRef = this.createFromArgsTest(100, 67, 89);
        assertEquals(colorTest.compareTo(colorRef), 1);
    }

    @Test
    public final void testCompareTo() {
        RGBColorTools colorTest = this.createFromArgsTest(100, 66, 89);
        RGBColorTools colorRef = this.createFromArgsTest(100, 67, 89);
        assertEquals(colorTest.compareTo(colorRef), -1);
    }

}
