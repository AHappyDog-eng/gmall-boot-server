import com.mogujie.gmallprovider8001.configuration.ConstantProperties;
import com.mogujie.gmallprovider8001.utils.OSSOperatorUtils;

/**
 * @author WN
 * @date 2020/7/10 11:47
 */
public class Test {

    @org.junit.Test
    public void test() {
        ConstantProperties properties = new ConstantProperties();
        String string = properties.toString();
        System.out.println(string);

    }

    @org.junit.Test
    public void test1() {
        OSSOperatorUtils operatorUtils = new OSSOperatorUtils();
        String imgUrl = operatorUtils.getImgUrl("blog/2020-07-30/d1e9cc5168bf405cbccc8071530220d3-IMG_1334.JPG");
        System.out.println(imgUrl);
    }

    @org.junit.Test
    public void test2() {

    }
}
