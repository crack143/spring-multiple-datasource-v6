package com.liqui.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role implements Serializable{

	private static final long serialVersionUID = -846768490101837201L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	 	private Long Id;
	 	
	    @Column(name = "NAME")
	    private String name;
	    
	    @ManyToMany(mappedBy="roles")
	    private Set<User> users;
	    


		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public Set<User> getUsers() {
			return users;
		}

		public void setUsers(Set<User> users) {
			this.users = users;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Role other = (Role) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Role [Id=" + Id + ", name=" + name + "]";
		}
	   
}










/*
 
 
 
 
 
 
*/











