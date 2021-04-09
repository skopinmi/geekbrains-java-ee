package ru.geekbrains.persist;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "deleteCustomerById", query = "delete from Customer c where c.id = :id"),
        @NamedQuery(name = "findAllCustomer", query = "from Customer c"),
        @NamedQuery(name = "countCustomer", query = "select count(c) from Customer c")
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String mail;

    public Customer() {
    }

    public Customer(Long id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
