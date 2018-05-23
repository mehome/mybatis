package com.tangbaobao.pojo;

import java.util.Date;

/**
 * 经历表
 *
 * @author 唐学俊
 * @create 2018/02/05
 * <p>
 * `exp_id` varchar(50) DEFAULT NULL,
 * `studyRecord` varchar(15) DEFAULT NULL,
 * `school` varchar(15) DEFAULT NULL,
 * `profession` varchar(15) DEFAULT NULL,
 * `startTime` date DEFAULT NULL,
 * `endTime` date DEFAULT NULL,
 * `emp_id` varchar(50) DEFAULT NULL,
 * KEY `empId` (`emp_id`),
 * CONSTRAINT `empId` FOREIGN KEY (`emp_id`) REFERENCES `tb_emp` (`emp_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 **/

public class Exp {
    private String expId;
    private String studyRecord;
    private String school;
    private String profession;
    private Date startTime;
    private Date endTime;

    /**
     * 多对一
     */
    private Emp emp;

    public String getExpId() {
        return expId;
    }

    public void setExpId(String expId) {
        this.expId = expId;
    }

    public String getStudyRecord() {
        return studyRecord;
    }

    public void setStudyRecord(String studyRecord) {
        this.studyRecord = studyRecord;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Exp{" +
                "expId='" + expId + '\'' +
                ", studyRecord='" + studyRecord + '\'' +
                ", school='" + school + '\'' +
                ", profession='" + profession + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", emp=" + emp +
                '}';
    }
}
