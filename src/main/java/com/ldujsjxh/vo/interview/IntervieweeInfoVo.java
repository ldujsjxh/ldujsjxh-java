package com.ldujsjxh.vo.interview;

import lombok.Data;

/**
 * @Author Alaskyed
 * @Date 27/09/2020 - 16:03
 * @Version 1.0
 * @Description 面试时返回该部门面试人员的基本信息
 */

@Data
public class IntervieweeInfoVo {
    //全局唯一id
    private String candidateId;
    //报名者姓名
    private String candidateName;
    //学号
    private String candidateStuId;
    //学院
    private String candidateAcademy;
    //部门
    private String desirableDepartment;
    //面试得分
    private String score;
    //面试状态
    private int state;
    //是否服从调剂
    private int candidateObeyAdjust;

}
