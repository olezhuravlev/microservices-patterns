package com.ftgo.restaurantservice.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ftgo.restaurantservice.api.model.RestaurantMenu;

/**
 * The entity class for restaurants.
 * 
 * @author  Wuyi Chen
 * @date    05/16/2019
 * @version 1.0
 * @since   1.0
 */
@Entity
@Table(name = "restaurants")
@Access(AccessType.FIELD)
public class Restaurant {
	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Embedded
	private RestaurantMenu menu;
	
	public Restaurant(String name, RestaurantMenu menu) {
		this.name = name;
		this.menu = menu;
	}

	public Long   getId()              { return id;        }
	public void   setId(Long id)       { this.id = id;     }
	public String getName()            { return name;      }
	public void   setName(String name) { this.name = name; }
}
