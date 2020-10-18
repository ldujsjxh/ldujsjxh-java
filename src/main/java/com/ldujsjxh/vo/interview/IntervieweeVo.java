package com.ldujsjxh.vo.interview;

import lombok.Data;

/**
 * @Author Alaskyed
 * @Date 27/09/2020 - 11:26
 * @Version 1.0
 * @Description 面试者信息
 */


@Data
public class IntervieweeVo {
    //id
    private String candidateId;
    //姓名
    private String candidateName;
    //学号
    private String candidateStuId;
    //学院
    private String candidateAcademy;
    //意向部门
    private String desirableDepartment;
    //状态
    private int state;
    //面试地点
    private String position;


}
