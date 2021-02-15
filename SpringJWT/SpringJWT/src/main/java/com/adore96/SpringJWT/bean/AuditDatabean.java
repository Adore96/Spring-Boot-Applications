package com.adore96.SpringJWT.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author kasun_k ON 1/26/21
 * @project SpringJWT
 */

@Getter
@Setter
public class AuditDatabean {

    private int id;
    private String userrole;
    private String description;
    private String page;
    private String task;
    private String ip;
    private String lastupdateduser;
    private String lastupdatedtime;
    private String oldvalue;
    private String newvalue;

}
