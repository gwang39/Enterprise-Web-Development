/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author guany
 */
public class Tour {
    
    private String name = null;
    private String password = null;
    private boolean success = false;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        if (password.equals("foo")) {
           success = true;            
        }
    }
    
    public boolean getSuccess() {
        return success;
    }
}
