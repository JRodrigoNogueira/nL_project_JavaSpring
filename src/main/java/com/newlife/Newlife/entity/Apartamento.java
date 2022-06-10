package com.newlife.Newlife.entity;


import com.newlife.Newlife.dto.VeiculoForm;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Apartamento")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

}
