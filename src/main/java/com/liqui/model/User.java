package com.liqui.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = 3126912031410584792L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	private Long Id;
	 	
	    @Column(name = "FIRST_NAME")
	    private String firstName;
	    
	    @Column(name = "LAST_NAME")
	    private String lastName ;
	    
	    @Column(name = "EMAIL")
		private String email;
	    
	    @Column(name = "PASSWORD")
		private String password ;

	    @ManyToMany
	    @JoinTable(name="user_role",
	    	joinColumns=@JoinColumn(name="user_id"),
	    	inverseJoinColumns=@JoinColumn(name="role_id"))
	    private Set<Role> roles;

	    
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name="user_role", joinColumns = {@JoinColumn(name = "user_id",
	 * referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name =
	 * "role_id", referencedColumnName = "id")})
	 */
	    
	    
		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((email == null) ? 0 : email.hashCode());
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
			User other = (User) obj;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", password=" + password + ", roles=" + roles + "]";
		}
	    
	
	   
}










/*
 
 
 
 
 
 
*/











