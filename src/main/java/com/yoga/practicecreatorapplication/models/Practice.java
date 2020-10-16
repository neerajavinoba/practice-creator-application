package com.yoga.practicecreatorapplication.models;

public class Practice
{
	int duration;
	int meditationDuration;
	int sunSalutationCount;
	String level;
	boolean includeBreathing;
	boolean includeMeditation;
	boolean includeSunSalutes;
	boolean includeYinPostures;

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	public int getMeditationDuration()
	{
		return meditationDuration;
	}

	public void setMeditationDuration(int meditationDuration)
	{
		this.meditationDuration = meditationDuration;
	}

	public int getSunSalutationCount()
	{
		return sunSalutationCount;
	}

	public void setSunSalutationCount(int sunSalutationCount)
	{
		this.sunSalutationCount = sunSalutationCount;
	}

	public String getLevel()
	{
		return level;
	}

	public void setLevel(String level)
	{
		this.level = level;
	}

	public boolean isIncludeBreathing()
	{
		return includeBreathing;
	}

	public void setIncludeBreathing(boolean includeBreathing)
	{
		this.includeBreathing = includeBreathing;
	}

	public boolean isIncludeMeditation()
	{
		return includeMeditation;
	}

	public void setIncludeMeditation(boolean includeMeditation)
	{
		this.includeMeditation = includeMeditation;
	}

	public boolean isIncludeSunSalutes()
	{
		return includeSunSalutes;
	}

	public boolean isIncludeYinPostures()
	{
		return includeYinPostures;
	}

	public void setIncludeYinPostures(boolean includeYinPostures)
	{
		this.includeYinPostures = includeYinPostures;
	}

	public void setIncludeSunSalutes(boolean includeSunSalutes)
	{
		this.includeSunSalutes = includeSunSalutes;
	}
}
