package reviewer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
// @AllArgsConstructor
// @NoArgsConstructor
@Table(name="Tag")
public class Tag {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    private String tag;

    @ManyToOne
    private User user;

    public User getUser() 
    {
        return user;
    }

    public User setUser(User user) 
    {
        return this.user = user;
    }
   

    public String getTag() 
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    @Override
    public String toString() 
    {
        return "Tag [Tag=" + tag + ", users=" + user + "]";
    }

    public Tag(String tag,User user) 
    {
        super();
        this.tag = tag;
        this.user = user;
    }

    public Tag() 
    {
        super();
    }
}
