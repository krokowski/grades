package com.grades.domain;

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
public class SubjectBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_block_id")
    private Long subjectBlockId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "subject_form_id")
    private Long subjectFormId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "worker_id")
    private Long workerId;
}
