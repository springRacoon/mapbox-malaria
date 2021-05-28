package com.sanguo.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Ill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "card_id", type = IdType.AUTO)
    private String cardId;

    private String cardNumber;

    private String cardStu;

    private String gender;

    private Date birthday;

    private Integer age;

    private String patientCompany;

    private String patientOf;

    private Integer nowStayId;

    private String nowStayAddress;

    private String occupation;

    private String caseClassification;

    private String caseClassification2;

    private Date onsetTime;

    private Date diagnosisTime;

    private String deadTime;

    private String illName;

    private String beforeIllName;

    private Date fillCardTime;

    private Long reportAreaId;

    private String reportCompany;

    private String companyType;

    private Date cardInputTime;

    private String cardInputPeople;

    private String cardInputPeopleCompany;

    private String countyAuditTime;

    private String cityAuditTime;

    private String provinceAuditTime;

    private String auditStu;

    private String revisedReportingTime;

    private Date revisedDeadTime;

    private String lastDeadTime;

    private String revisedPeople;

    private String revisedPeopleCompany;

    private String deleteTime;

    private String deletePeople;

    private String deletePeopleCompany;

    private String deleteReason;

    private String note;

    @TableField(exist = false)
    private String geo;
}
