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
@Table(name = "subject_form")
public class SubjectFormDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_form_id")
    private Long subjectFormId;

    private String name;
}
