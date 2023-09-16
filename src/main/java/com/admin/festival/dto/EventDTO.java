package com.admin.festival.dto;

import com.admin.festival.dto.event.*;
import lombok.*;

@Getter // lombok: Getter 자동으로
@Setter // lombok: Setter 자동으로
@NoArgsConstructor // lombok: 기본생성자를 자동으로 만들어준다.
@AllArgsConstructor
@ToString // lombok: ToString 메서드를 자동으로 만들어준다.
public class EventDTO {

    private Long id;
    private TicketDTO ticketDTO;
    private BoxDTO boxDTO;
    private DressDTO dressDTO;

}
