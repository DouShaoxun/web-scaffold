package cn.dsx.webscaffold.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "emp_leave")
public class EmpLeave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联用户id
     */
    private Integer hid;

    /**
     * 请假起始时间
     */
    @Column(name = "startTime")
    private Date starttime;

    /**
     * 请假结束时间
     */
    @Column(name = "endTime")
    private Date endtime;

    /**
     * 请假条填写时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 是否审核通过(3:待审核  1：通过  2：拒绝)
     */
    private Long flag;

    /**
     * 审核时间
     */
    @Column(name = "auditTime")
    private Date audittime;

    /**
     * 审核人
     */
    @Column(name = "auditHrId")
    private Integer audithrid;

    /**
     * 请假缘由
     */
    private String reason;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取关联用户id
     *
     * @return hid - 关联用户id
     */
    public Integer getHid() {
        return hid;
    }

    /**
     * 设置关联用户id
     *
     * @param hid 关联用户id
     */
    public void setHid(Integer hid) {
        this.hid = hid;
    }

    /**
     * 获取请假起始时间
     *
     * @return startTime - 请假起始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置请假起始时间
     *
     * @param starttime 请假起始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取请假结束时间
     *
     * @return endTime - 请假结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置请假结束时间
     *
     * @param endtime 请假结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取请假条填写时间
     *
     * @return createTime - 请假条填写时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置请假条填写时间
     *
     * @param createtime 请假条填写时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取是否审核通过(3:待审核  1：通过  2：拒绝)
     *
     * @return flag - 是否审核通过(3:待审核  1：通过  2：拒绝)
     */
    public Long getFlag() {
        return flag;
    }

    /**
     * 设置是否审核通过(3:待审核  1：通过  2：拒绝)
     *
     * @param flag 是否审核通过(3:待审核  1：通过  2：拒绝)
     */
    public void setFlag(Long flag) {
        this.flag = flag;
    }

    /**
     * 获取审核时间
     *
     * @return auditTime - 审核时间
     */
    public Date getAudittime() {
        return audittime;
    }

    /**
     * 设置审核时间
     *
     * @param audittime 审核时间
     */
    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    /**
     * 获取审核人
     *
     * @return auditHrId - 审核人
     */
    public Integer getAudithrid() {
        return audithrid;
    }

    /**
     * 设置审核人
     *
     * @param audithrid 审核人
     */
    public void setAudithrid(Integer audithrid) {
        this.audithrid = audithrid;
    }

    /**
     * 获取请假缘由
     *
     * @return reason - 请假缘由
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置请假缘由
     *
     * @param reason 请假缘由
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
}