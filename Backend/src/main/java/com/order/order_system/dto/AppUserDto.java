package com.order.order_system.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppUserDto extends BaseDto <Long>  {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;


    private String password;
    
    public String getPassword() {
        return this.password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
