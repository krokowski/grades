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
@Table(name = "worker")
public class WorkerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "user_id")
    private Long userId;
}
