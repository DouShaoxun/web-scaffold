package cn.dsx.webscaffold.utils.id;

/**
 * @Classname: IDUtils
 * @Author: Dsx
 */
public class IDUtils {
    public static Long workId = 18L;
    private static IdWorker idWorker;

    public static IdWorker getIdWorkerInstance() {
        if (idWorker == null) {
            idWorker = new IdWorker(workId);
        }
        return idWorker;
    }

    public static String nextId() {
        return String.valueOf(IDUtils.getIdWorkerInstance().nextId());
    }
}
