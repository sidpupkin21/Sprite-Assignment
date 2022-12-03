/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sid
 */
@Entity
@Table(name = "APPUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appuser.findAll", query = "SELECT c FROM Appuser c"),
    @NamedQuery(name = "Appuser.findById", query = "SELECT c FROM Appuser c WHERE c.id = :id"),
    @NamedQuery(name = "Appuser.findByGroupname", query = "SELECT c FROM Appuser c WHERE c.groupname = :groupname"),
    @NamedQuery(name = "Appuser.findByPassword", query = "SELECT c FROM Appuser c WHERE c.password = :password"),
    @NamedQuery(name = "Appuser.findByUsername", query = "SELECT c FROM Appuser c WHERE c.username = :username")
})
@DatabaseIdentityStoreDefinition(
    dataSourceLookup = "${'java:comp/DefaultDataSource'}",
    callerQuery = "#{'select password from app.Appuser where username = ?'}",
    groupsQuery = "select groupname from app.Appuser where username = ?",
    hashAlgorithm = PasswordHash.class,
    priority = 10
)
public class Appuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
  //  @Basic(optional = false)
 // @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Size(max = 255)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 255)
    @Column(name = "GROUPNAME")
    private String groupname;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    
    public Appuser() {
    }

    public Appuser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getGroupname(){
        return groupname;
    }
    public void setGroupname(String groupname){
        this.groupname = groupname;
    }
    public String getPassword(){
        return null;
        //return password;
    }
    public void setPassword(String password){
        if(password.length() > 0){
            // initialize a PasswordHash object which will generate password hashes
            Instance<? extends PasswordHash> instance = CDI.current().select(Pbkdf2PasswordHash.class);
            PasswordHash passwordHash = instance.get();
            passwordHash.initialize(new HashMap<String,String>()); // todo: are the defaults good enough?
            // now we can generate a password entry for a given password
            String passwordEntry = password; //pretend the user has chosen a password mySecretPassword
            passwordEntry = passwordHash.generate(passwordEntry.toCharArray());
            //at this point, passwordEntry refers to a salted/hashed password entry corresponding to mySecretPassword
            this.password = passwordEntry;//.toString();
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject.Appuser[ id=" + id + " ]";
    }
    
}
