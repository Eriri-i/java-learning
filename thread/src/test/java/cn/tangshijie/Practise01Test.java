package cn.tangshijie;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : tangshijie
 * @since : 2021-10-31 13:11
 */
public class Practise01Test {

    @Test
    @SuppressWarnings("squid:S2699")
    public void test() {
        while (true) {
            int x = (int) (101 * Math.random());
            System.out.println(x);
            if (x == 0 || x == 100) {
                break;
            }
        }
    }

}
