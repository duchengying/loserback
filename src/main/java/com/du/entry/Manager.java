package com.du.entry;

public class Manager {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.worker_num
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    private String workerNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.worker_name
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    private String workerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.worker_pwd
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    private String workerPwd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.position
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    private String position;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.power
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    private String power;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager.worker_phone
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    private String workerPhone;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.worker_num
     *
     * @return the value of manager.worker_num
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public String getWorkerNum() {
        return workerNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.worker_num
     *
     * @param workerNum the value for manager.worker_num
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public void setWorkerNum(String workerNum) {
        this.workerNum = workerNum == null ? null : workerNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.worker_name
     *
     * @return the value of manager.worker_name
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public String getWorkerName() {
        return workerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.worker_name
     *
     * @param workerName the value for manager.worker_name
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.worker_pwd
     *
     * @return the value of manager.worker_pwd
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public String getWorkerPwd() {
        return workerPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.worker_pwd
     *
     * @param workerPwd the value for manager.worker_pwd
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public void setWorkerPwd(String workerPwd) {
        this.workerPwd = workerPwd == null ? null : workerPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.position
     *
     * @return the value of manager.position
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.position
     *
     * @param position the value for manager.position
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.power
     *
     * @return the value of manager.power
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public String getPower() {
        return power;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.power
     *
     * @param power the value for manager.power
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager.worker_phone
     *
     * @return the value of manager.worker_phone
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public String getWorkerPhone() {
        return workerPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager.worker_phone
     *
     * @param workerPhone the value for manager.worker_phone
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone == null ? null : workerPhone.trim();
    }
    public String toString(){
        return getWorkerNum()+getWorkerName()+getPower()+getWorkerPwd();
    }
}