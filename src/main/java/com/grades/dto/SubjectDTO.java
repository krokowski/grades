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
@Table(name = "subject")
public class SubjectDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private Long subjectId;

    private String name;
}
