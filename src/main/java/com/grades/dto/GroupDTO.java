package com.grades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Wojciech.Krokowski on 2017-01-08.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "group")
public class GroupDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long groupId;

    private String name;
}
