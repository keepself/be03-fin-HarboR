package com.example.harbor_employee.Employee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
* Entity 구성
* employeeId: 사원번호(PK), 8자리
* teamCode: 소속팀(코드)
* positionCode: 직위(코드)
* statusCode: 업무 상태(코드)
* genderCode: 성별(코드)
* dutyCode: 직무(코드)
* bankCode: 은행(코드)
* profile_image: 사진 url
* email: 이메일
* name: 이름
* phone: 전화번호
* socialSecurityNumber: 주민등록번호
* birthDate: 생년월일
* address: 주소
* year: 년차
* joinDate: 입사날짜
* leavingDate: 퇴사날짜
* updateDate: 수정날짜
* reasonForResignation: 퇴사사유
* account: 계좌번호
* */
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "HR_Employee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(nullable = false, length = 20)
    private String employeeId;
    @Column(length = 20)
    private String teamCode;
    @Column(length = 20)
    private String positionCode;
    @Column(length = 20)
    private String statusCode;
    @Column(length = 20)
    private String genderCode;
    @Column(length = 20)
    private String dutyCode;
    @Column(length = 20)
    private String bankCode;
    @Column(length = 1000)
    private String profileImage;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(length = 20)
    private String phone;
    @Column(length = 20)
    private String socialSecurityNumber;
    @Column(nullable = false, length = 20)
    private String birthDate;
    private String address;
    private String careerYMD;
    private String joinDate;
    private String leavingDate;
    private String updateDate;
    private String reasonForResignation;
    @Column(length = 50)
    private String accountNumber;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_code")
    private Department department;

    @OneToMany(mappedBy = "employee")
    private List<Eworks> eworks = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<PersonnelAppointment> personnelAppointmentList = new ArrayList<>();
}

