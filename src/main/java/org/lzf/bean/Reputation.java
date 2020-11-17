package org.lzf.bean;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 信誉表
 * @author MI
 */
@Service
public class Reputation implements Serializable {
    /**
     * @repId
     * 学生id
     */
    private String repId;
    /**
     * @value
     * 信誉值
     */
    private int value;
    /**
     * @message
     * 减信誉值的原因
     */
    private String message;

    public String getRepId() {
        return repId;
    }

    public void setRepId(String repId) {
        this.repId = repId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
