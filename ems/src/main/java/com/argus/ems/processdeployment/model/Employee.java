package com.argus.ems.processdeployment.model;

import com.argus.ems.common.model.SerialIdStateEntity;
import jakarta.persistence.*;
import java.sql.Timestamp;
import com.argus.ems.master.model.TypeEntity;

/**
 *
 * @author nandani
 */

@Entity
@Table(name = "employee")
public class Employee extends SerialIdStateEntity {
    
    @Id
    @Column(name = "ID", length = 250)
    private String id;

    @Column(name = "password", length = 12, nullable = false)
    private String password;

    @Column(name = "first_name", length = 150, nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 150)
    private String middleName;

    @Column(name = "last_name", length = 150, nullable = false)
    private String lastName;

    @Column(name = "email", length = 150, nullable = false, unique = true)
    private String email;

    @Column(name = "designation", length = 50)
    private String designation;

    @Column(name = "birthdate", nullable = false)
    private Timestamp birthdate;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "blood_group", length = 15)
    private String bloodGroup;

    @Column(name = "address", length = 1500)
    private String address;

    @Column(name = "marital_status")
    private Boolean maritalStatus;

    @Column(name = "mobile_no", length = 50, nullable = false, unique = true)
    private String mobileNo;

  
    @Column(name = "state_id")
    private String stateId;

    @Column(name = "type_id")
    private String typeId;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Employee{" 
                + "id=" + this.getId()
                + ", password=" + this.getName()
                + ", firstName=" + this.getFirstName()
                + ", middleName=" + this.getMiddleName()
                + ", lastName=" + this.getLastName()
                + ", email=" + this.getEmail()
                + ", designation=" + this.getDesignation()
                + ", birthdate=" + this.getBirthdate()
                + ", gender=" + this.getGender()
                + ", bloodGroup=" + this.getBloodGroup()
                + ", address=" + this.getAddress()
                + ", maritalStatus=" + this.getMaritalStatus()
                + ", mobileNo=" + this.getMobileNo()
                + ", stateId=" + this.getStateId()
                + ", typeId=" + this.getTypeId()
                + ", createdAt=" + this.getCreatedAt()
                + ", createdBy=" + this.getCreatedBy()
                + ", updatedAt=" + this.getUpdatedAt()
                + ", updatedBy=" + this.getUpdatedBy()+ '}';
    }
    
    
}