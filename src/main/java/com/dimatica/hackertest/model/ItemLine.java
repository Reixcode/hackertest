package com.dimatica.hackertest.model;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ItemLine {
	
	private String ip;
	private Long date;
	private String action;
	private String userName;
	
	public ItemLine(String line) {
		String [] splitLine  =line.split(",");
		this.ip= splitLine[0];
		this.date =Long.parseLong(splitLine[1]);
		this.action=splitLine[2];
		this.userName=splitLine[3];	
	}
	
	public ItemLine setItemLine(String line) {
		String [] splitLine  =line.split(",");
		this.ip= splitLine[0];
		this.date =Long.parseLong(splitLine[1]);
		this.action=splitLine[2];
		this.userName=splitLine[3];	
		return this;
	}
	

	@Override
	public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ItemLine otherItem = (ItemLine) o;
        
        return (otherItem.getIp().equals(ip) && otherItem.getAction().equals(action) && otherItem.getUserName().equals(userName) );
	
	}
	
	@Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.ip != null ? this.ip.hashCode() : 0);
        result = 31 * result + (this.date != null ? this.date.hashCode() : 0);
        result = 31 * result + (this.action != null ? this.action.hashCode() : 0);
        result = 31 * result + (this.userName != null ? this.userName.hashCode() : 0);
        return result;
    }

	public boolean isSuspiciusIp( ItemLine otherItem) {

	    Long minutePeriod = Math.abs(Duration.between(Instant.ofEpochSecond(otherItem.getDate()),Instant.ofEpochSecond(date)).toMinutes());
	        return ( "SIGNIN_FAILURE".equals(otherItem.getAction()) && otherItem.equals(this)  && minutePeriod <=5);
		}
}
