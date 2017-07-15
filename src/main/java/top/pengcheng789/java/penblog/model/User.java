package top.pengcheng789.java.penblog.model;

import java.util.Date;

/**
 * Created by pen on 17-7-3.
 */
public class User {
    private String id;
    private String mail;
    private String nickname;
    private String head_image;
    private String sex;
    private String password;
    private Date create_date;
    private short is_admin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public short getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(short is_admin) {
        this.is_admin = is_admin;
    }
}
