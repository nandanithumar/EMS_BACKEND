//package com.argus.ems.processdeployment.dto.info;
//
//
//import com.argus.ems.common.dto.iface.TemporalTypeStatelessEntity;
//import com.argus.ems.common.dto.info.TemporalTypeStatelessEntityInfo;
//import com.argus.ems.processdeployment.dto.infc.Employee;
//import java.io.Serializable;
//import java.sql.Timestamp;
//
///**
// * This info is for state DTO that contains all the state model's data.
// *
// */
//public class EmployeeInfo
//        extends TemporalTypeStatelessEntityInfo
//        implements Employee, Serializable {
//    
//    String id;
//    String password;
//    String firstName;
//    String middleName;
//    String lastName;
//    String email;
//    String designation;
//    Timestamp birthdate;
//    Boolean gender;
//    String bloodGroup;
//    String address;
//    Boolean maritalStatus;
//    String mobileNo;
//    String stateId;
//    String TypeId;
//
//    @Override
//    public String getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @Override
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    @Override
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Override
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String designation) {
//        this.designation = designation;
//    }
//
//    @Override
//    public Timestamp getBirthdate() {
//        return birthdate;
//    }
//
//    public void setBirthdate(Timestamp birthdate) {
//        this.birthdate = birthdate;
//    }
//
//    @Override
//    public Boolean getGender() {
//        return gender;
//    }
//
//    public void setGender(Boolean gender) {
//        this.gender = gender;
//    }
//
//    @Override
//    public String getBloodGroup() {
//        return bloodGroup;
//    }
//
//    public void setBloodGroup(String bloodGroup) {
//        this.bloodGroup = bloodGroup;
//    }
//
//    @Override
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Boolean getMaritalStatus() {
//        return maritalStatus;
//    }
//
//    public void setMaritalStatus(Boolean maritalStatus) {
//        this.maritalStatus = maritalStatus;
//    }
//
//    @Override
//    public String getMobileNo() {
//        return mobileNo;
//    }
//
//    public void setMobileNo(String mobileNo) {
//        this.mobileNo = mobileNo;
//    }
//
//    @Override
//    public String getStateId() {
//        return stateId;
//    }
//
//    public void setStateId(String stateId) {
//        this.stateId = stateId;
//    }
//
//    @Override
//    public String getTypeId() {
//        return TypeId;
//    }
//
//    public void setTypeId(String TypeId) {
//        this.TypeId = TypeId;
//    }
//
//    public EmployeeInfo() {
//    }
//
//    public EmployeeInfo(Employee employee){
//        if (employee != null) {
//
//            this.id = employee.getId();
//            this.password = employee.getPassword();
//            this.firstName = employee.getFirstName();
//            this.middleName = employee.getMiddleName();
//            this.lastName = employee.getLastName();
//            this.email = employee.getEmail();
//            this.designation = employee.getDesignation();
//            this.birthdate = employee.getBirthdate();
//            this.gender = employee.getGender();
//            this.bloodGroup = employee.getAddress();
//            this.address = employee.getAddress();
//            this.maritalStatus = employee.getMaritalStatus();
//            this.mobileNo = employee.getMobileNo();
//            this.stateId = employee.getStateId();
//            this.TypeId = employee.getTypeId();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "EmployeeInfo{"
//                + "id=" + id
//                + ", password=" + password 
//                + ", firstName=" + firstName 
//                + ", middleName=" + middleName 
//                + ", lastName=" + lastName 
//                + ", email=" + email 
//                + ", designation=" + designation 
//                + ", birthdate=" + birthdate 
//                + ", gender=" + gender 
//                + ", bloodGroup=" + bloodGroup 
//                + ", address=" + address 
//                + ", maritalStatus=" + maritalStatus 
//                + ", mobileNo=" + mobileNo 
//                + ", stateId=" + stateId 
//                + ", TypeId=" + TypeId + '}';
//    }
//
//   
//    
//    
//}
//
//
//    
//    
//
//   
//
//
//
