package ffhs.schwendh.eventmanager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author schwendh
 * 
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable
{
	private static final long serialVersionUID = -5527566248002296042L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MONEY")
	private Double money;

	/**
	 * @return
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public Double getMoney()
	{
		return money;
	}

	/**
	 * @param money
	 */
	public void setMoney(Double money)
	{
		this.money = money;
	}
}
