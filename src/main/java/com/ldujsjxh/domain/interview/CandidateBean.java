package com.ldujsjxh.domain.interview;

import lombok.Data;
import lombok.ToString;

@Data
public class CandidateBean {
    //面试人id
    private String candidateId;
    //面试人姓名
    private String candidateName;
    //面试人学号
    private String candidateStuId;
    //性别
    private String candidateGender;
    //学院
    private String candidateAcademy;
    //班级
    private String candidateClass;
    //宿舍
    private String candidateDormitory;
    //微信
    private String candidateWechat;
    //QQ
    private String candidateQq;
    //电话
    private String candidatePhoneNumber;
    //是否服从调剂
    private String candidateObeyAdjust;
    //自我介绍
    private String candidateIntroduction;
    //加入理由
    private String candidateReason;
    //掌握技能
    private String candidateSkills;
    //面试人意向部门
    private String desirableDepartment;




}
