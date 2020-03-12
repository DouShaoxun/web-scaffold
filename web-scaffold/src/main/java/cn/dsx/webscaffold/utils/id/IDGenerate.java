package cn.dsx.webscaffold.utils.id;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname: IDGenerate
 * @Author: Dsx
 */
public class IDGenerate {

    private static int sequence = 0;

    private static int length = 18;

    /**
     * 主键生成
     *
     * @return
     */
    public static String nextId() {
        return addLeftZero(IDUtils.nextId(), length);
    }

    /**
     * 左填0
     *
     * @param s
     * @param length
     * @return
     */
    private static String addLeftZero(String s, int length) {
        // StringBuilder sb=new StringBuilder();
        int old = s.length();
        if (length > old) {
            char[] c = new char[length];
            char[] x = s.toCharArray();
            if (x.length > length) {
                throw new IllegalArgumentException(
                        "Numeric value is larger than intended length: " + s
                                + " LEN " + length);
            }
            int lim = c.length - x.length;
            for (int i = 0; i < lim; i++) {
                c[i] = '0';
            }
            System.arraycopy(x, 0, c, lim, x.length);
            return new String(c);
        }
        return s.substring(0, length);
    }

    /**
     * @return 产生租客ID，每秒钟最大10个，如果后期有大于此数量级需求，需该代码
     */
    public static synchronized String nextTenantId() {
        sequence = sequence >= 9 ? 1 : sequence + 1;
        String datetime = new SimpleDateFormat("yyMMddHHmmss")
                .format(new Date());
        return datetime + sequence;
    }
}
