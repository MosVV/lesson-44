package dao;

import java.util.Objects;

public class Phone {
    private int id;
    private String name;
    private String phone;


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone1 = (Phone) o;
        return getId() == phone1.getId() && Objects.equals(getName(), phone1.getName()) && Objects.equals(getPhone(), phone1.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhone());
    }

    @Override
    public String toString() {
        return "dao.Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
