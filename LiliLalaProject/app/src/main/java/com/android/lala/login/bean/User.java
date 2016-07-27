package com.android.lala.login.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author emotiona
 * Email emotiona_xiaoshi@icloud.com
 * Date 2016.07.25
 **/
public class User implements Parcelable {
    private int id;
    private int type;//用户类型：0-管理员；1-普通用户',
    private String username;//'登录用户名',
    private String password;// '登录密码',
    private String name;//'姓名',
    private int age;// '年龄'
    private String roles;//1=个人；2=企业',
    private String channels;//个人频道
    private String photo;//头像'

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.type);
        dest.writeString(this.username);
        dest.writeString(this.password);
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeString(this.roles);
        dest.writeString(this.channels);
        dest.writeString(this.photo);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readInt();
        this.type = in.readInt();
        this.username = in.readString();
        this.password = in.readString();
        this.name = in.readString();
        this.age = in.readInt();
        this.roles = in.readString();
        this.channels = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}