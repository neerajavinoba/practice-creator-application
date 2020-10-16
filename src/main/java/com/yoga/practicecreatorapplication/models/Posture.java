package com.yoga.practicecreatorapplication.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "postures_master")
public class Posture implements Comparable<Posture>
{
	@Id
	@SequenceGenerator(name="id_seq", sequenceName = "id_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	private Long id;
	private String name;
	private String sanskritName;
	private String level;
	private String type;
	private String benefits;
	private float duration;
	private boolean doubleSided;

	public Posture() {

	}
	public Posture(Long id, String name, String sanskritName, String level, String type, String benefits, float duration, boolean doubleSided)
	{
		this.id = id;
		this.name = name;
		this.sanskritName = sanskritName;
		this.level = level;
		this.type = type;
		this.benefits = benefits;
		this.duration = duration;
		this.doubleSided = doubleSided;
	}

	public Long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSanskritName()
	{
		return sanskritName;
	}

	public void setSanskritName(String sanskritName)
	{
		this.sanskritName = sanskritName;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getBenefits()
	{
		return benefits;
	}

	public void setBenefits(String benefits)
	{
		this.benefits = benefits;
	}

	public float getDuration()
	{
		return duration;
	}

	public void setDuration(float duration)
	{
		this.duration = duration;
	}

	public boolean isDoubleSided()
	{
		return doubleSided;
	}

	public void setDoubleSided(boolean doubleSided)
	{
		this.doubleSided = doubleSided;
	}

	@Override
	public int compareTo(Posture posture)
	{
		return this.getType().compareTo(posture.type);
	}
}
