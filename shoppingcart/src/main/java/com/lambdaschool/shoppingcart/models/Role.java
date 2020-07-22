package com.lambdaschool.shoppingcart.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    @NotNull
    @Column(nullable = false,
            unique = true)
    private String name;

    /**
     * Part of the join relationship between user and role
     * connects roles to the user role combination
     */
    @OneToMany(mappedBy = "role",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "role",
            allowSetters = true)
    private Set<UserRole> users = new HashSet<>();

    public Role()
    {
    }

    public Role(String name)
    {
        this.name = name;

    }

    public long getRoleid()
    {
        return roleid;
    }

    public void setRoleid(long roleid)
    {
        this.roleid = roleid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<UserRole> getUsers()
    {
        return users;
    }

    public void setUsers(Set<UserRole> users)
    {
        this.users = users;
    }
}
