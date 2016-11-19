package bjjpit;

import java.util.concurrent.atomic.AtomicLong;
public class people
{
	private long id;
	private String name;
	private int age;
	private String rank;
	private long height;
	private long weight;
	private int wins;
	private int losses;
	private String fav_gi;
	
	public people(String name,int age,String rank,long height,long weight,int wins,int losses,int id,String fav_gi)
	{
		this.name=name;
		this.age=age;
		this.rank=rank;
		this.height=height;
		this.weight=weight;
		this.losses=losses;
		this.wins=wins;
		this.id=id;
		this.fav_gi=fav_gi;
	}
	
	public people(String name,int age,String rank,long height,long weight,int wins,int losses)
	{
		this.name=name;
		this.age=age;
		this.rank=rank;
		this.height=height;
		this.weight=weight;
		this.losses=losses;
		this.wins=wins;
        }
}
