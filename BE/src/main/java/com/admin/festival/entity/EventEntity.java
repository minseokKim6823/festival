package com.admin.festival.entity;

import com.admin.festival.dto.EventDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "event_table")
public class EventEntity {
    @Id // pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    // 1. 비행기티켓
    @Column
    private int ticket;

    // 2. 보물차기
    @Column
    private int box1;
    @Column
    private int box2;
    @Column
    private int box3;
    @Column
    private int box4;

    // 3. 드레스코드
    @Column
    private int dress1;
    @Column
    private int dress2;

    public int getAttributeValue(String attributeName){
        switch (attributeName) {
            case "box1":
                return this.getBox1();
            case "box2":
                return this.getBox2();
            case "box3":
                return this.getBox3();
            case "box4":
                return this.getBox4();
            case "dress1":
                return this.getDress1();
            case "dress2":
                return this.getDress2();

            default:
                throw new IllegalArgumentException("Invalid attributeName: " + attributeName);
        }
    }

    public void setAttributeValue(String attributeName, int value) {
        switch (attributeName) {
            case "box1":
                this.setBox1(value);
                break;
            case "box2":
                this.setBox2(value);
                break;
            case "box3":
                this.setBox3(value);
                break;
            case "box4":
                this.setBox4(value);
                break;
            case "dress1":
                this.setDress1(value);
                break;
            case "dress2":
                this.setDress2(value);
                break;

            default:
                throw new IllegalArgumentException("Invalid attributeName: " + attributeName);
        }
    }

}
