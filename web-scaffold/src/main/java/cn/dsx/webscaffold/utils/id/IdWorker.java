package cn.dsx.webscaffold.utils.id;

/**
 * 7.5年 每天重启3次 每秒224000个
 * @Classname: IdWorker
 * @Author: Dsx
 */
public class IdWorker {
    /**
     * 起始时间戳，用于用当前时间戳减去这个时间戳，算出偏移量
     **/
    private final long startTime = 1549209600000L;

    /**
     * workerId占用的位数：13
     **/
    private final long workerIdBits = 14L;
    /**
     * 序列号占用的位数：8
     **/
    private final long sequenceBits = 8L;

    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private final long workerIdShift = sequenceBits;
    private final long timestampLeftShift = workerIdBits + sequenceBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);
    private long workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;
    private boolean isClock = false;

    public IdWorker(long workerId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }

        this.workerId = workerId;
    }

    /**
     * 获取ID
     *
     * @return
     */
    public synchronized Long nextId() {
        long timestamp = this.timeGen();

        // 闰秒：如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            long offset = lastTimestamp - timestamp;
            if (offset <= 5) {
                try {
                    this.wait(offset << 1);
                    timestamp = this.timeGen();
                    if (timestamp < lastTimestamp) {
                        throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
            }
        }

        // 解决跨毫秒生成ID序列号始终为偶数的缺陷:如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = this.tilNextMillis(lastTimestamp);
            }
        } else {
            // 时间戳改变，毫秒内序列重置
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - startTime) << timestampLeftShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    /**
     * 保证返回的毫秒数在参数之后(阻塞到下一个毫秒，直到获得新的时间戳)
     *
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }

        return timestamp;
    }

    /**
     * 获得系统当前毫秒数
     *
     * @return timestamp
     */
    private long timeGen() {
        if (isClock) {
            // 解决高并发下获取时间戳的性能问题
            return SystemClock.now();
        } else {
            return System.currentTimeMillis();
        }
    }
}